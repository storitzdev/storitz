
var markerImageGreen;
var markerImageBlue;

var directionMap;

function createDirectionMap() {

  $('#directionMapDestination').hide();
  $('#printThis').hide();
  $('#printThisTop').hide();
  $('#dirPanel').hide();

  destLatLng = new google.maps.LatLng(siteLat, siteLng);

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
    title: siteTitle,
    position: destLatLng,
    icon: markerImageGreen
  });

  directionsService = new google.maps.DirectionsService();
}

function refreshMap() {
   google.maps.event.trigger(directionMap, 'resize');
   createDirectionMap();
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

    $('#directionsSteps').children().each(function(index) { $(this).remove() });

    for (i=0; i < legs.length; i++) {
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
          $('#directionsDistance').html('Total distance: ' + legs[i].distance.text + ' in approximately ' + legs[i].duration.text);
        }
      }
      endLocation.latlng = legs[i].end_location;
      endLocation.address = legs[i].end_address;
      var steps = legs[i].steps;
      var elem;
      for (j=0; j < steps.length; j++) {
        var nextSegment = steps[j].path;
        var durationText = steps[j].duration.text ? steps[j].duration.text : "&nbsp;";
        var distanceText = steps[j].distance.text ? steps[j].distance.text : "&nbsp;";
        elem = $('<tr>', { "class": "directionStep" })
                .append($('<td>', { style:"width:50px;text-align:right;"}).html((j + 1) + '.'))
                .append($('<td>', { style:"width:425px;" }).html(steps[j].instructions))
                .append($('<td>', { style:"width: 75px; padding-right: 10px;text-align:right;"}).html(distanceText))
                .append($('<td>', { style:"width: 75px; padding-right: 15px;text-align:right;"}).html(durationText));

        $('#directionsSteps').append(elem);
        for (k=0; k < nextSegment.length; k++) {
          polyline.getPath().push(nextSegment[k]);
          bounds.extend(nextSegment[k]);
        }
      }
    }
    if (route.copyrights) {
      $('#directionsCopyrights').html(route.copyrights);
    }
    if (route.warnings && route.warnings.length > 0) {
      var warnings = $('<ul>');
      $.each(route.warnings, function(index, warn) {
        warnings.append($('<li>').text(warn))
      });
      $('#directionsWarnings').html(warnings);
    }
    polyline.setMap(directionMap);
    directionMap.fitBounds(bounds);

    new google.maps.Marker({
      map: directionMap,
      clickable:false,
      title: siteTitle,
      position: endLocation.latlng,
      icon: markerImageGreen
    });
    $('#directionsStartAddr').html(startLocation.address);
    $('#directionsEndAddr').html(endLocation.address);
    $('#dirPanel').show();

    $('#directionMapDestination').show();
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
      title: siteTitle,
      position: destLatLng,
      icon: markerImageGreen
    });
    $('#printThis').show();
    $('#printThisTop').show();
  }
}

function getDirections() {
  markerImageGreen = new google.maps.MarkerImage(srcIconMapGreen, null, null, new google.maps.Point(1, 32));
  markerImageBlue = new google.maps.MarkerImage(srcIconMapBlue, null, null, new google.maps.Point(1, 32));

  $('#srcAddr').keypress(function(event) {
    if (event.keyCode == 13) {
      event.preventDefault();
      var request = {
              origin:$('#srcAddr').val(),
              destination:destLatLng,
              unitSystem: google.maps.DirectionsUnitSystem.IMPERIAL,
              travelMode: google.maps.DirectionsTravelMode.DRIVING
          };
          directionsService.route(request,  drawDirections);
    }
  });

  $('#getDirections').click(function(event) {
    var request = {
            origin:$('#srcAddr').val(),
            destination:destLatLng,
            unitSystem: google.maps.DirectionsUnitSystem.IMPERIAL,
            travelMode: google.maps.DirectionsTravelMode.DRIVING
        };
        directionsService.route(request,  drawDirections);
  });
}
