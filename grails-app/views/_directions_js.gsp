var directionsService;
var directionsDisplay;
var premiums = [];
var destLatLng;

var markerImageGreen;
var markerImageGray;

var directionMap;

function createDirectionMap() {

  $('directionMapDestination').hide();
  $('dirPanel').hide();

  destLatLng = new google.maps.LatLng(${site.lat}, ${site.lng});

  directionMap = new google.maps.Map(document.getElementById("directionMapCanvas"),
    {
      zoom: 12,
      center: destLatLng,
      draggable: false,
      mapTypeControl: false,
      navigationControl: false,
      scrollwheel: false,
      mapTypeId: google.maps.MapTypeId.ROADMAP
    }
  );
  new google.maps.Marker({
    map: directionMap,
    clickable:false,
    title: "${site.title}",
    position: destLatLng,
    icon: markerImageGreen
  });

  directionsService = new google.maps.DirectionsService();
}

function drawDirections(response, status) {
  if (status == google.maps.DirectionsStatus.OK) {
    var polyline = new google.maps.Polyline({
                path: [],
                strokeColor: '#3bad00',
                strokeWeight: 3
    });
    var bounds = new google.maps.LatLngBounds();
    var route = response.routes[0];
    var legs = route.legs;
    var startLocation = new Object();
    var endLocation = new Object();

    $('directionsSteps').childElements().each(function(elem) { elem.remove() });

    for (i=0;i<legs.length;i++) {
      if (i == 0) {
        startLocation.latlng = legs[i].start_location;
        startLocation.address = legs[i].start_address;
        new google.maps.Marker({
          map: directionMap,
          clickable:false,
          title: "Start",
          position: startLocation.latlng,
          icon: markerImageBlue
        });
        if (legs[i].distance && legs[i].duration) {
          $('directionsDistance').update('Total distance: ' + legs[i].distance.text + ' in approximately ' + legs[i].duration.text);
        }
      }
      endLocation.latlng = legs[i].end_location;
      endLocation.address = legs[i].end_address;
      var steps = legs[i].steps;
      var elem;
      for (j=0;j<steps.length;j++) {
        var nextSegment = steps[j].path;
        var durationText = steps[j].duration.text ? steps[j].duration.text : "&nbsp;";
        var distanceText = steps[j].distance.text ? steps[j].distance.text : "&nbsp;";
        elem = new Element('tr', { class: "directionStep" })
                .insert(new Element('td', { style:"width:50px;text-align:right;"}).update((j + 1) + '.'))
                .insert(new Element('td', { style:"width:425px;" }).update(steps[j].instructions))
                .insert(new Element('td', { style:"width: 75px; padding-right: 10px;text-align:right;"}).update(distanceText))
                .insert(new Element('td', { style:"width: 75px; padding-right: 15px;text-align:right;"}).update(durationText));

        $('directionsSteps').insert(elem);
        for (k=0;k<nextSegment.length;k++) {
          polyline.getPath().push(nextSegment[k]);
          bounds.extend(nextSegment[k]);
        }
      }
    }
    if (route.copyrights) {
      $('directionsCopyrights').update(route.copyrights);
    }
    if (route.warnings && route.warnings.length > 0) {
      var warnings = new Element('ul');
      route.warnings.each(function(warn) {
        warnings.insernt(new Element('li').update(warn))
      });
      $('directionsWarnings').update(warnings);
    }
    polyline.setMap(directionMap);
    directionMap.fitBounds(bounds);

    new google.maps.Marker({
      map: directionMap,
      clickable:false,
      title: "${site.title}",
      position: endLocation.latlng,
      icon: markerImageGreen
    });
    $('directionsStartAddr').update(startLocation.address);
    $('directionsEndAddr').update(endLocation.address);
    $('dirPanel').show();

    $('directionMapDestination').show();
    var directionMapDestination = new google.maps.Map(document.getElementById("directionMapDestinationCanvas"),
      {
        zoom: 15,
        center: destLatLng,
        draggable: false,
        mapTypeControl: false,
        navigationControl: false,
        scrollwheel: false,
        mapTypeId: google.maps.MapTypeId.ROADMAP
      }
    );
    var destMarker = new google.maps.Marker({
      map: directionMapDestination,
      title: "${site.title}",
      position: destLatLng,
      icon: markerImageGreen
    });

  }
}

function getDirections() {
  markerImageGreen = new google.maps.MarkerImage('${resource(dir:'images', file:'icn_map_grn.png')}', null, null, new google.maps.Point(1, 32));
  markerImageBlue = new google.maps.MarkerImage('${resource(dir:'images', file:'icn_map_blue.png')}', null, null, new google.maps.Point(1, 32));

  $('srcAddr').observe('keypress', function(event) {
    if (event.keyCode == 13) {
      var request = {
              origin:$F('srcAddr'),
              destination:destLatLng,
              unitSystem: google.maps.DirectionsUnitSystem.IMPERIAL,
              travelMode: google.maps.DirectionsTravelMode.DRIVING
          };
          directionsService.route(request,  drawDirections);
    }
  });
  $('get_directions').observe('click', function() {
    var request = {
            origin:$F('srcAddr'),
            destination:destLatLng,
            unitSystem: google.maps.DirectionsUnitSystem.IMPERIAL,
            travelMode: google.maps.DirectionsTravelMode.DRIVING
        };
        directionsService.route(request,  drawDirections);
  });
}

