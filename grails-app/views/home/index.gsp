<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN"
    "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" >
    <head>
      <g:render template="/header" />
      <script type="text/javascript">
      
//<![CDATA[
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
        var oldBounds;
        var baseURL = '${request.contextPath}/storageSite/detail/';
        var mapSmoother = false;

        TableKit.Sortable.addSortType(
            new TableKit.Sortable.Type('stprice', {
                pattern : /^�|<[aA].+\$(\d+)<\/[aA]>/,
                normal : function(v) {
                    // This will grab the first thing that looks like a number from a string, so you can use it to order a column of various srings containing numbers.
                    if (v == '�') return -1;
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

          if (!mapSmoother) {
            mapSmoother = true;
            var timeoutFunc =  function() {
              var newBounds = map.getBounds();
              if (oldBounds && newBounds.equals(oldBounds)) {
                 getMarkers(false);
              } else {
                oldBounds = newBounds;
                window.setTimeout(timeoutFunc, 250);
              }
              mapSmoother = false;
            };
            window.setTimeout( timeoutFunc, 250);
           }
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
                var tableContents = '<div class="srText">Search Results for size ' + searchSizeDesc + ' near ' + searchAddr + ' starting on ' + searchDate + '</td></tr></div><table class="sortable" id="stresults' + randId + '"><thead><tr><th class="addrwidth" id="title">Title</th><th class="sortfirstasc distwidth white" id="distance">Distance</th><th class="stprice pricewidth white">Drive Up</th><th class="stprice pricewidth white">Interior</th><th class="stprice pricewidth white">Upper</th><th class="stprice pricewidth white">A/C</th><th class="white">Special Offers</th></tr></thead><tbody>';
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
                      '<a href="' + baseURL + s.id + '?searchSize=' + searchSize + '">' + s.address +'</a></td><td class="textCenter">' + calcDistance(searchLat, s.lat, searchLng, s.lng) + 'mi </td><td class="textCenter">' +
                      (priceDriveup && priceDriveup < 999999 ? '<a href="' + baseURL + s.id + '?priceDriveup=true&searchSize=' + searchSize + '">$' + priceDriveup + '</a>' : "&#8212;")  + '</td><td class="textCenter">' +
                      (priceInterior && priceInterior < 999999 ? '<a href="' + baseURL + s.id + '?priceInterior=true&searchSize=' + searchSize + '">$' + priceInterior + '</a>' : "&#8212;") + '</td><td class="textCenter">' +
                      (priceUpper && priceUpper < 999999 ? '<a href="' + baseURL + s.id + '?priceUpper=true&searchSize=' + searchSize + '">$' + priceUpper + '</a>' : "&#8212;") + '</td><td class="textCenter">' +
                      (priceTempControlled && priceTempControlled < 999999 ? '<a href="' + baseURL + s.id + '?priceTempControlled=true&searchSize=' + searchSize + '">$' + priceTempControlled + '</a>' : "&#8212;") +'</td><td class="textCenter">' +
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
              oldBounds = map.getBounds();
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

        FastInit.addOnLoad(setupCalendar, setupHelp, setupForm);
//]]>
      </script>
    </head>
    <body>
      <g:render template="/topnav" />
      <div id="stcontent">
        <g:render template="/logo_bar" />
        <div id="search">
          <div id="instructions">
            Search for Storage
          </div>
          <div style="height: 20px;"></div>
          <div style="margin-left: 15px;">
            <form id="gsearch" action="" method="post">
              <div>Enter an address, city, state or zip code:</div>
              <div>
                <input type="text" name="address" id="address"/>
              </div>
              <div style="float: left;">
                <div>
                  <div>Unit Size:</div>
                  <div style="height: 30px;">
                    <g:select name="size" id="size" from="${sizeList}" optionKey="id" optionValue="description"/>
                    <img id="sizeInfo" style="vertical-align: middle;" src="${createLinkTo(dir:'images', file:'icn_info_circle.png')}" alt="info"/>
                  </div>
                </div>
              </div>
              <div style="float: left; margin-left: 20px;">
                <div>Start Date:</div>
                <input type="text" id="date" style="width: 105px;" />
              </div>
              <div style="clear: both; height: 10px;"></div>
              <div>
                <input type="image" src="${createLinkTo(dir:'images', file:'btn_findstoragenow.gif')}" class="noborder" alt="Search Storage"/>
              </div>
              <div style="clear: both; height: 10px;"></div>
            </form>
          </div>
          <div style="height: 20px;"></div>
          <div class="large" style="padding-left: 1em; padding-bottom: 0.5em; font-weight: bold;">Legend:</div>
          <div style="clear: both; padding-left: 1.5em;">
            <div style="float: left; padding-right: 1em;"><img src="${createLinkTo(dir:'images', file:'icn_map_blue.png')}" style="vertical-align: top;" alt="blue map icon"/></div> <div style="margin-left: 2em;">Storage site that meets your search criteria</div>
          </div>
          <div style="clear: both; padding-left: 1.5em;">
            <div style="float: left; padding-right: 1em;"><img src="${createLinkTo(dir:'images', file:'icn_map_grn.png')}" style="vertical-align: top;" alt="green map icon"/></div> <div style="margin-left: 2em;">Storage site without your size or availability date</div>
          </div>
        </div>
        <div id="gmap">
          <div id="map_canvas"></div>
        </div>

        <div style="clear: both;"></div>

        <div id="stresults_div">
        </div>
      </div>
      <div style="height:30px;"></div>
      <g:render template="/footer" />
      <div id="sizeHelp" style="display: none;">
        <table id="sizeHelpContents">
          <thead>
          <tr>
            <th colspan="2">Storage Sizes</th>
          </tr>
          </thead>
          <tbody>
            <tr>
              <td>5x5</td><td>Small - Ideal for dorm rooms, decorations, paintings, small items</td>
            </tr>
            <tr>
              <td>5x10</td><td>Small-Medium - Size of a walk-in closet, ideal for narrow items &amp; documents boxes</td>
            </tr>
            <tr>
              <td>7x10</td><td>Medium - For a small bedroom &amp; livingroom, tools &amp; equipment</td>
            </tr>
            <tr>
              <td>10x10</td><td>Medium size - For a 1 br apartment</td>
            </tr>
            <tr>
              <td>10x15</td><td>Med-Large size - For small house, boat or trailer</td>
            </tr>
            <tr>
              <td>10x20</td><td>Large size - For 3+ bedroom house, business equipment or car/SUV</td>
            </tr>
            <tr>
              <td>10x25</td><td>Large size - For 4 bedroom house or mini-warehouse</td>
            </tr>
            <tr>
              <td>10x30</td><td>Extra Large size - Mini-warehouse</td>
            </tr>
          </tbody>
        </table>
      </div>
    <script type="text/javascript" src="http://www.google.com/jsapi?autoload=%7B%22modules%22%3A%5B%7B%22name%22%3A%22maps%22%2C%22version%22%3A%223.x%22%2Cother_params%3A%22sensor%3Dfalse%22%2C%22callback%22%3A%22createMap%22%7D%2C%7B%22name%22%3A%22gdata%22%2C%22version%22%3A%222.x%22%2C%22packages%22%3A%5B%22maps%22%5D%7D%5D%7D&amp;key=ABQIAAAAEDNru_s_vCsZdWplqCj4hxSjGMYCLTKEQ0TzQvUUxxIh1qVrLhTUMUuVByc3xGunRlZ-4Jv6pHfFHA"></script>
    </body>
</html>