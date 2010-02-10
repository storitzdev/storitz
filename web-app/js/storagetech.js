/*
    Javascript functions for Google Maps, forms and table handling
*/

var map;
var geocoder;
var R = 3958.761; // mi
var searchLat;
var searchLng;
var infoWindow;
var features = [];
var storageSize = [];
var searchAddr;
var searchSize;
var searchSizeDesc;
var searchDate;
var helpFadeout = null;
var baseURL = '${request.contextPath}/storageSite/detail/';

TableKit.Sortable.addSortType(
    new TableKit.Sortable.Type('stprice', {
        pattern : /^—|<[aA].+\$(\d+)<\/[aA]>/,
        normal : function(v) {
            // This will grab the first thing that looks like a number from a string, so you can use it to order a column of various srings containing numbers.
            if (v == '—') return -1;
            v = parseFloat(v.replace(/^\$(\d+)/,"$1"));
            return isNaN(v) ? 0 : v;
        }
    })
);

<g:each var="size" in="${sizeList}">storageSize[${size.id}] = "${size.description}";</g:each>

function calcDistance(lat1, lat2, lng1, lng2) {
  var d = Math.acos(Math.sin(lat1/57.2958)*Math.sin(lat2/57.2958) +
              Math.cos(lat1/57.2958)*Math.cos(lat2/57.2958) *
              Math.cos(lng2/57.2958-lng1/57.2958)) * R;
  return Math.round(100 * d) / 100;
}

function redrawMap() {
  getMarkers(false);
}

function markerClick(feature) {
  var c = '<div style="width: 300px;"><h3>' + feature.title + '</h3>';
    if (feature.logoUrl) {
      c += '<div style="float: left;"><img src="' + feature.logoUrl + '" alt="' + feature.title + '"/></div>';
    }
    c += '<div style="float: left;padding: .5em">' + feature.address + '<br/>' +
      feature.city + ', ' + feature.state + ' ' + feature.zipcode + '</div><div style="clear: both;"></div>';
    if (feature.description) {
      c += feature.description;
    }
    c += '<div style="text-align: center;"><a href="' + baseURL + feature.id + '">details</a></div></div>';
  if (infoWindow) {
    infoWindow.close();
  }
  infoWindow = new google.maps.InfoWindow({content: c, maxWidth: 300});
  google.maps.event.addListener(infoWindow, 'closeclick', function() { delete infoWindow });
  infoWindow.open(map, feature.marker);
}

function panTo(markerId) {
  window.setTimeout(function() {
    map.panTo(features[markerId].marker.getPosition());
  }, 250);
  markerClick(features[markerId]);
}

function getMarkers(resizeable) {

  var bounds = map.getBounds();
  if (!bounds) return;
  new Ajax.Request("${createLink(controller:'sTMap', action:'jsonp')}",
  {
      method:'get',
      parameters: {sizeId: searchSize, swLat: bounds.getSouthWest().lat(), swLng: bounds.getSouthWest().lng(), neLat: bounds.getNorthEast().lat(), neLng: bounds.getNorthEast().lng() },
      onSuccess:function(transport) {
        if (resizeable) {
          if (transport.responseJSON.features.length < 2) {
            map.setZoom(map.getZoom() - 1);
            getMarkers(resizeable);
          } else if (transport.responseJSON.features.length > 50) {
            map.setZoom(map.getZoom + 1);
            getMarkers(resizeable);
          }
        }
        var randId = Math.floor(Math.random() * 100001);
        var tableContents = '<div class="srText">Search Results for size ' + searchSizeDesc + ' near ' + searchAddr + ' starting on ' + searchDate + '</td></tr></div><table class="sortable" id="stresults' + randId + '"><thead><tr><th class="addrwidth" id="title">Title</th><th class="sortfirstasc distwidth" id="distance">Distance</th><th class="stprice pricewidth">Drive Up</th><th class="stprice pricewidth">Interior</th><th class="stprice pricewidth">Upper</th><th class="stprice pricewidth">A/C</th><th>Special Offers</th></tr></thead><tbody>';
        var rows = 0;

        transport.responseJSON.features.each(function(s) {
            var location = new google.maps.LatLng(s.lat, s.lng);
            features[s.id] = s;
            rows++;

            var iconLink = s.units.any(function(n) { return n.unitsize.id == searchSize }) ? '${createLinkTo(dir:'images', file:'icn_map_blue.png')}' : '${createLinkTo(dir:'images', file:'icn_map_grn.png')}';
            var priceDriveup = s.units.min(function(n) { return (n.unitsize.id == searchSize && n.isDriveup) ? n.price : 999999; });
            var priceInterior = s.units.min(function(n) { return (n.unitsize.id == searchSize && n.isInterior) ? n.price : 999999; });
            var priceUpper = s.units.min(function(n) { return (n.unitsize.id == searchSize && n.isUpper) ? n.price : 999999; });
            var priceTempControlled = s.units.min(function(n) { return (n.unitsize.id == searchSize && n.isTempControlled) ? n.price : 999999; });

            s.marker = new google.maps.Marker({
              map: map,
              title: s.title,
              position: location,
              icon: iconLink
            });
            google.maps.event.addListener(s.marker, 'click', function() {
              markerClick(s);
            });
            tableContents += '<tr><td><a href="#" class="no_underline" onclick="javascript:panTo(' + s.id + ');return false">' + s.title + '</a><br> ' +
              '<a href="' + baseURL + s.id + '">' + s.address +'</a></td><td class="textCenter">' + calcDistance(searchLat, s.lat, searchLng, s.lng) + 'mi </td><td class="textCenter">' +
              (priceDriveup && priceDriveup < 999999 ? '<a href="' + baseURL + s.id + '?priceDriveup=true">$' + priceDriveup + '</a>' : "&#8212;")  + '</td><td class="textCenter">' +
              (priceInterior && priceInterior < 999999 ? '<a href="' + baseURL + s.id + '?priceInterior=true">$' + priceInterior + '</a>' : "&#8212;") + '</td><td class="textCenter">' +
              (priceUpper && priceUpper < 999999 ? '<a href="' + baseURL + s.id + '?priceUpper=true">$' + priceUpper + '</a>' : "&#8212;") + '</td><td class="textCenter">' +
              (priceTempControlled && priceTempControlled < 999999 ? '<a href="' + baseURL + s.id + '?priceTempControlled=true">$' + priceTempControlled + '</a>' : "&#8212;") +'</td><td class="textCenter">' +
              (s.specialOffer ? s.specialOffer : "&#8212;") + '</td></tr>';
        });
        tableContents += '</tbody></table>';
        $('stresults_div').update(tableContents);
        if (rows > 0) {
          new TableKit('stresults' + randId, { editable:false, stripe:true });
        }
      },
      onFailure:function(transport) {
        alert("Something went wrong " + transport.responseText);
      }
  });
}

function createMap() {
  var iploc;
  var req = new Ajax.Request("${createLink(controller:'sTMap', action:'iplocate')}",
  {
    method:'get',
    onSuccess:function(transport) {
      var res = transport.responseJSON;
      iploc = new google.maps.LatLng(res.latitude, res.longitude);
      searchAddr = res.postalCode;
    },
    onFailure:function(transport) {
      alert("Something went wrong " + transport.responseText);
    },
    onException:function(req, err) {
      alert("Exception: " + err);
    },
    onComplete:function() {
      var myOptions;
      if (iploc) {
        myOptions = {
          zoom: 14,
          center: iploc,
          mapTypeId: google.maps.MapTypeId.ROADMAP
        };
      } else {
        myOptions = {
          zoom: 14,
          mapTypeId: google.maps.MapTypeId.ROADMAP
        };
      }
      map = new google.maps.Map(document.getElementById("map_canvas"), myOptions );
      searchLat = iploc.lat();
      searchLng = iploc.lng();
      TableKit.Sortable.init($('stresults'), {editable:false, stripe:true});
      getMarkers(true);
      google.maps.event.addListener(map, 'bounds_changed', redrawMap);
      geocoder = new google.maps.Geocoder();
    }
  });
}

function showAddress(address, size, date) {
  if (address) {
    searchAddr = address;
  }
  searchSize = size;
  searchDate = date;
  searchSizeDesc = storageSize[size];

  if (geocoder && address) {
    geocoder.geocode( { 'address': address}, function(results, status) {
      if (status == google.maps.GeocoderStatus.OK) {
        map.setCenter(results[0].geometry.location);
        var marker = new google.maps.Marker({
            map: map,
            position: results[0].geometry.location
        });
        searchLat = results[0].geometry.location.lat();
        searchLng = results[0].geometry.location.lng();
      } else {
        alert("Geocode was not successful for the following reason: " + status);
      }
    });
  }
  getMarkers(true);
}

function setupCalendar() {
  Calendar.setup({
      dateField     : 'date',
      triggerElement: 'date',
      dateFormat    : '%m-%d-%Y'
  });
}

function setupHelp() {
  $('sizeInfo').observe('click', function(event) {
    $('sizeHelp').setStyle({ top: this.offsetTop - 10 + "px", left: this.offsetLeft + this.width + 10 + "px" });
    Effect.toggle('sizeHelp', 'appear', {duration: 0.8});
  });

}

function setupForm() {
  $('gsearch').observe('submit', function(event) {
    showAddress($F('address'), $F('size'), $F('date'));
    Event.stop(event);
  });
}

