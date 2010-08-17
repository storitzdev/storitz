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
        var tooltips = new Hash();
        var searchAddr;
        var searchSize;
        var searchSizeDesc;
        var searchDate;
        var helpFadeout = null;
        var baseURL = '${request.contextPath}/self-storage/';
        var inDrag = false;
        var mapLoaded = false;
        var pendingResize = false;
        var savedFeature;
        var siteCount = 0;
        var bounds = null;
        var markerImageGreen = null;
        var markerImageGray = null;

        TableKit.Sortable.addSortType(
            new TableKit.Sortable.Type('stprice', {
                pattern : /^\uFFFD|<[aA].+\$(\d+)<\/[aA]>/,
                normal : function(v) {
                    // This will grab the first thing that looks like a number from a string, so you can use it to order a column of various strings containing numbers.
                    if (v == '\uFFFD') return -1;
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

          bounds = map.getBounds();
          if (pendingResize) {
            getMarkers(true);
            return;
          }

          if (!inDrag) {
             getMarkers(false);
          }

        }

        function dragStart() {
          inDrag = true;
        }

        function dragEnd() {
          inDrag = false;
          getMarkers(false);
        }

        function siteLink(s)
        {
          var city_pat = RegExp(' ?[-/]? ?' + s.city + ' ?[-/]? ?', 'i');

          return baseURL + encodeURIComponent(s.city) + '/' + encodeURIComponent(s.title.replace(city_pat, '')) + '/' + s.id;
        }

        function getDate() {
          if ($F('date') && !$F('date').startsWith('Select')) {
            return $F('date');
          }
          return '';
        }

        function markerClick(feature) {
            var url = siteLink(feature) + '?s=m';
            if (searchSize && searchSize > 1) {
              url += '&searchSize=' + searchSize;
            }
            url += '&date=' + getDate();
            if ($F('address') && !$F('address').startsWith('Enter ')) {
              url += '&address=' + encodeURIComponent($F('address'));
            }
            window.location = url;
        }

        function markerOver(feature) {
          var c = '<div style="width: 300px;"><h3>' + feature.title + '</h3>';
            if (feature.coverImg.length > 0) {
              c += '<div style="float: left;"><img src="${resource(dir:'/')}' + feature.coverImg + '" alt="' + feature.title + '"/></div>';
            }
            c += '<div style="float: left;padding: .5em">' + feature.address + '<br/>' +
              feature.city + ', ' + feature.state + ' ' + feature.zipcode + '</div><div style="clear: both;"></div>';
            if (feature.description) {
              c += feature.description;
            }
            c += '<div style="text-align: center;"><a href="' + siteLink(feature) + '?searchSize=' + searchSize + '&date=' + getDate() + '&address=' + encodeURIComponent($F('address')) + '">details</a></div></div>';
          if (infoWindow) {
            infoWindow.close();
          }
          if (savedFeature && $('row'+savedFeature.id)) {
            $('row'+savedFeature.id).removeClassName('rowhighlight');
          }
          infoWindow = new google.maps.InfoWindow({content: c, maxWidth: 300, disableAutoPan: true});
          google.maps.event.addListener(infoWindow, 'mouseout', function() {
            delete infoWindow;
          });
          infoWindow.open(map, feature.marker);
          $('row'+feature.id).addClassName('rowhighlight');
          savedFeature = feature;
        }

        function markerOut(feature) {
          $('row'+feature.id).removeClassName('rowhighlight');
          savedFeature = null;
          if (infoWindow) {
            infoWindow.close();
          }
        }

        function panTo(markerId) {
          window.setTimeout(function() {
            map.panTo(features[markerId].marker.getPosition());
          }, 250);
          markerOver(features[markerId]);
        }

        function getMarkers(resizeable) {

          tooltips.each(function(t) {
            if (typeof t.value.destroy == 'function') {
              t.value.destroy();
            }
            tooltips.unset(t.name);
          });

          if (!bounds || typeof(bounds) == 'undefined') {
            return;
          }

          if (resizeable) {

            new Ajax.Request("${createLink(controller:'STMap', action:'countSites')}",
            {
              method:'get',
              parameters: {searchSize: searchSize, swLat: bounds.getSouthWest().lat(), swLng: bounds.getSouthWest().lng(), neLat: bounds.getNorthEast().lat(), neLng: bounds.getNorthEast().lng() },
              onSuccess:function(transport) {
                siteCount = transport.responseJSON.siteCount;
                if (siteCount < 2) {
                  if (map.getZoom() > 1) {
                    pendingResize = true;
                    map.setZoom(map.getZoom() - 1);
                  }
                } else if (siteCount > 20) {
                  pendingResize = true;
                  map.setZoom(map.getZoom() + 1);
                } else {
                  pendingResize = false;
                  drawMarkers();
                }
              },
              onFailure:function(transport) {
                alert("Something went wrong " + transport.responseText);
              }
            });
            if (map.getZoom() <= 1 || map.getZoom() >= 16) {
              pendingResize = false;
            }
            if (siteCount == 0) {
              return;
            } else if (siteCount > 20) {
              $('stresults_div').update("<div class=\"siteOverage\">Your search returned too many sites. Zoom in on the map to see detailed results.</div>");
            }
          }  else {

            pendingResize = false;
            if (siteCount > 0) {
              drawMarkers();
            }
          }
        }

        function drawMarkers() {
          new Ajax.Request("${createLink(controller:'STMap', action:'jsonp')}",
          {
              method:'get',
              parameters: {searchSize: searchSize, swLat: bounds.getSouthWest().lat(), swLng: bounds.getSouthWest().lng(), neLat: bounds.getNorthEast().lat(), neLng: bounds.getNorthEast().lng() },
              onSuccess:function(transport) {

                if (transport.responseJSON.siteCount >= 20) {
                  $('stresults_div').update("<div class=\"siteOverage\">Too many results returned.  Zoom in to see results.</div>");
                  return;                    
                }
                var randId = Math.floor(Math.random() * 100001);
                var tableContents = '<table class="sortable" id="stresults' + randId + '"><thead><tr><th class="sortfirstasc distwidth" id="distance">Distance</th><th class="addrwidth" id="title">Location</th><th class="stprice pricewidth">Drive Up</th><th class="stprice pricewidth">Interior</th><th class="stprice pricewidth">Upper</th><th>Features</th><th>Special Offers</th></tr></thead><tbody>';
                var rows = 0;
                var offers;

                transport.responseJSON.features.each(function(s) {

                    var location = new google.maps.LatLng(s.lat, s.lng);
                    features[s.id] = s;
                    var offersTip = s.specialOffers.pluck('promoName').join('<BR/>');
                    var featuredArr = $A(s.featuredOffers.pluck('promoName'));
                    if (featuredArr.size() > 1 ) {
                      offers = '<div id="offers' + s.id + '" class=\"pointer\">' + s.featuredOffers.pluck('promoName').join('<BR/>') + '</div><div id="tooltip_offers' + s.id + '" style="display:none;" class="tooltip">' + offersTip + '</div>';
                      tooltips.set(("offers" + s.id), ("tooltip_offers" + s.id));
                    } else {
                      var offersArr = $A(s.specialOffers.pluck('promoName'));
                      if (offersArr.size() > 1 ) {
                        offers = '<div id="offers' + s.id + '" class=\"pointer\">' + offersArr[0] + '<BR/>' + offersArr[1] + '</div><div id="tooltip_offers' + s.id + '" style="display:none;" class="tooltip">' + offersTip + '</div>';
                        tooltips.set(("offers" + s.id), ("tooltip_offers" + s.id));
                      } else {
                        offers = offersArr[0];
                      }
                    }
                    rows++;
                    var pUp = s.units.find(function(n) { return n.type == 'upper' });
                    var pDup = s.units.find(function(n) { return n.type == 'driveup' });
                    var pInt = s.units.find(function(n) { return n.type == 'interior' });
                    var iconMarker = s.units.size() == 0 ? markerImageGray : markerImageGreen;
                    var priceDriveup = pDup ? pDup.price : 999999;
                    var priceInterior = pInt? pInt.price : 999999;
                    var priceUpper = pUp ? pUp.price : 999999;

                    var keypadImg = s.isKeypad ? '<img id="keypad' + s.id +'" class=\"pointer\" src="${resource(dir:'images', file:'icon-keypad-green-20x20.gif')}" style="vertical-align: middle; margin: 1px;" alt="Keypad"/>' : '<span style="width:20px; margin:1px;"></span>';
                    var cameraImg = s.isCamera ? '<img id="camera' + s.id +'" class=\"pointer\" src="${resource(dir:'images', file:'icon-camera-green-20x20.gif')}" style="vertical-align: middle; margin: 1px;" alt="Camera"/>' : '<span style="width:20px; margin: 1px;"></span>';
                    var gateImg   = s.isGate ? '<img id="gate' + s.id +'" class=\"pointer\" src="${resource(dir:'images', file:'icon-gate-green-20x20.gif')}" style="vertical-align: middle; margin: 1px;" alt="Gate"/>' : '<span style="width:20px; margin: 1px;"></span>';
                    var alarmImg  = s.isUnitAlarmed ? '<img id="alarm' + s.id +'" class=\"pointer\" src="${resource(dir:'images', file:'icon-alarm-green-20x20.gif')}" style="vertical-align: middle; margin: 1px;" alt="Alarm"/>' : '<span style="width:20px; margin: 1px;"></span>';
                    var managerImg  = s.isManagerOnsite ? '<img id="manager' + s.id +'" class=\"pointer\" src="${resource(dir:'images', file:'icon-green-mgr20b.gif')}" style="vertical-align: middle; margin: 1px;" alt="Manager Onsite"/>' : '<span style="width:20px; margin: 1px;"></span>';
                    var elevatorImg  = s.hasElevator ? '<img id="elevator' + s.id +'" class=\"pointer\" src="${resource(dir:'images', file:'icon-green-elevator20.gif')}" style="vertical-align: middle; margin: 1px;" alt="Elevator"/>' : '<span style="width:20px; margin: 1px;"></span>';

                    var truckImg = '<span style="width:20px; margin: 1px;"></span>';
                    switch(s.freeTruck) {
                      case "FREE":
                        truckImg =  '<img id="truck' + s.id +'" class=\"pointer\" src="${resource(dir:'images', file:'icon-rentaltruck-green-20x20.gif')}" style="vertical-align: middle; margin: 1px;" alt="Rental Truck"/>';
                        break;
                      case "RENTAL":
                        truckImg =  '<img id="truck' + s.id +'" class=\"pointer\" src="${resource(dir:'images', file:'icon-rentaltruck-green-20x20.gif')}" style="vertical-align: middle; margin: 1px;" alt="Rental Truck"/>';
                        break;
                    }

                    if (s.isKeypad) {
                      tooltips.set("keypad" + s.id, "tooltip_keypad");
                    }
                    if (s.isCamera) {
                      tooltips.set("camera" + s.id, "tooltip_camera");
                    }
                    if (s.isGate) {
                      tooltips.set("gate" + s.id, "tooltip_gate");
                    }
                    if (s.isUnitAlarmed) {
                      tooltips.set("alarm" + s.id, "tooltip_alarm");
                    }
                    if (s.isManagerOnsite) {
                      tooltips.set("manager" + s.id, "tooltip_manager");
                    }
                    if (s.hasElevator) {
                      tooltips.set("elevator" + s.id, "tooltip_elevator");
                    }
                    if (s.freeTruck == "RENTAL" || s.freeTruck == "FREE") {
                      tooltips.set("truck" + s.id, "tooltip_truck");
                    }

                    s.marker = new google.maps.Marker({
                      map: map,
                      title: s.title,
                      position: location,
                      icon: iconMarker
                    });
                    google.maps.event.addListener(s.marker, 'mouseover', function() {
                      markerOver(s);
                    });
                    google.maps.event.addListener(s.marker, 'click', function() {
                      markerClick(s);
                    });
                    tableContents += '<tr id="row' + s.id + '" class="strow"><td class="textCenter distance">' + calcDistance(searchLat, s.lat, searchLng, s.lng) + 'mi </td><td class="stVert"><div style="float:left;"><a href="#" class="no_underline siteTitle" onclick="panTo(' + s.id + ');return false">' + s.title + '</a><br> ' +
                      '<a href="' + siteLink(s) + '?searchSize=' + searchSize + '&date=' + getDate() + '&address=' + encodeURIComponent($F('address')) + '">' + s.address +'</a></div></td><td class="textCenter">' +
                      (priceDriveup && priceDriveup < 999999 ? '<a href="' + siteLink(s) + '?unitType=driveup' + (pDup ? '&searchSize=' + pDup.unitsize.id : '') + '&date=' + getDate() + '&address=' + encodeURIComponent($F('address')) + '" class="unitPrice">$' + priceDriveup.toFixed(2) + '</a>' : "&#8212;")  + '</td><td class="textCenter">' +
                      (priceInterior && priceInterior < 999999 ? '<a href="' + siteLink(s) + '?unitType=interior' + (pInt ? '&searchSize=' + pInt.unitsize.id : '') + '&date=' + getDate() + '&address=' + encodeURIComponent($F('address')) + '" class="unitPrice">$' + priceInterior.toFixed(2) + '</a>' : "&#8212;") + '</td><td class="textCenter">' +
                      (priceUpper && priceUpper < 999999 ? '<a href="' + siteLink(s) + '?unitType=upper' + (pUp ? '&searchSize=' + pUp.unitsize.id : '') + '&date=' + getDate() + '&address=' + encodeURIComponent($F('address')) + '" class="unitPrice">$' + priceUpper.toFixed(2) + '</a>' : "&#8212;") + '</td><td><div style="float:right;">' + keypadImg + cameraImg + alarmImg + managerImg + gateImg + elevatorImg + truckImg +
                      '</div></td><td class="specialOfferText">' + (offers ? offers : "&#8212;") + '</td></tr>';
                });
                tableContents += '</tbody></table>';
                $('stresults_div').update(tableContents);
                if (rows > 0) {
                  new TableKit('stresults' + randId, { editable:false, stripe:true });
                  tooltips.each(function(pair) {
                     tooltips.set(pair.key, new Tooltip(pair.key, pair.value));
                  });
                }
              },
              onFailure:function(transport) {
                alert("Something went wrong " + transport.responseText);
              }
          });
        }

        function createMap() {
          var iploc;
          var req = new Ajax.Request("${createLink(controller:'STMap', action:'iplocate')}",
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
                  zoom: 12,
                  center: iploc,
                  mapTypeId: google.maps.MapTypeId.ROADMAP,
                  navigationControlOptions: {style: google.maps.NavigationControlStyle.ZOOM_PAN}
                };
              } else {
                myOptions = {
                  zoom: 12,
                  mapTypeId: google.maps.MapTypeId.ROADMAP,
                  navigationControlOptions: {style: google.maps.NavigationControlStyle.ZOOM_PAN}
                };
              }
              markerImageGreen = new google.maps.MarkerImage('${resource(dir:'images', file:'icn_map_grn.png')}', null, null, new google.maps.Point(1, 32));
              markerImageGray = new google.maps.MarkerImage('${resource(dir:'images', file:'gray-icon.png')}', null, null, new google.maps.Point(1, 32));

              map = new google.maps.Map(document.getElementById("map_canvas"), myOptions );

              searchLat = iploc.lat();
              searchLng = iploc.lng();
              TableKit.Sortable.init($('stresults'), {editable:false, stripe:true});
              google.maps.event.addListener(map, 'bounds_changed', redrawMap);
              google.maps.event.addListener(map, 'tilesloaded', checkMapSubmit);
              google.maps.event.addListener(map, 'dragstart', dragStart);
              google.maps.event.addListener(map, 'dragend', dragEnd);
              geocoder = new google.maps.Geocoder();
            }
          });
        }

        function showAddress(address, size, date) {

          updateSearchMsg();
          
          var validAddr = address.length > 4 && !address.startsWith('Enter ');

          if (address) {
            searchAddr = address;
          }
          searchSize = size;
          searchDate = date;
          searchSizeDesc = storageSize[size];

          if (geocoder && validAddr) {
            geocoder.geocode( { 'address': address}, function(results, status) {
              if (status == google.maps.GeocoderStatus.OK) {
                map.setCenter(results[0].geometry.location);
                new google.maps.Marker({
                    map: map,
                    position: results[0].geometry.location
                });
                searchLat = results[0].geometry.location.lat();
                searchLng = results[0].geometry.location.lng();
              } else {
                $('stresults_div').update("<div class=\"siteOverage\">Your search was too vague - you may need to add a zip code or state to:" + $F('address') + "</div>");
              }
            });
          }
          getMarkers(true);
        }

        function setupCalendar() {
          Calendar.setup({
              dateField     : 'date',
              triggerElement: 'date',
              dateFormat    : '%m/%d/%y',
              selectHandler : function(cal, dateString) {
                $('date').value = dateString;
                this.hide();
                showAddress($F('address'), $F('size'), dateString);
              }
          });
        }

        function setupHelp() {
          $('sizeInfo').observe('click', function(event) {
            $('sizeHelp').setStyle({ top: Event.pointerY(event) - 10 + "px", left: Event.pointerX(event) + 10 + "px" });
            Effect.toggle('sizeHelp', 'appear', {duration: 0.8});
          });
          $('helpClose').observe('click', function() {
            Effect.toggle('sizeHelp', 'appear', {duration: 0.8});
          });
        }

        function setupForm() {
          $('address').focus();
          $('gsearchBtn').observe('click', function() {
            showAddress($F('address'), $F('size'), getDate());
          });
          $('address').observe('keypress', function(event) {
            if (event.keyCode == 13) {
              showAddress($F('address'), $F('size'), getDate());
            }
          });
          $('address').observe('click', function(event) {
            if ($F('address').startsWith('Enter ')) {
              $('address').value = '';
            }
          });
          $('size').observe('change', function() {
            showAddress($F('address'), $F('size'), getDate());
          });          
        }

        function checkMapSubmit() {
          if (!mapLoaded && $F('address') != '') {
            showAddress($F('address'), $F('size'), getDate());
            mapLoaded = true;
          }
        }

        function updateSearchMsg() {
          var msg;
          var addrValid = !$F('address').startsWith('Enter ');
          var sizeValid = $F('size') != 1;
          var dateValid = getDate() && getDate().length > 0;

          if (addrValid && sizeValid && dateValid) {
            msg = '<span class="blue">Searching for a </span><span class="green">' + storageSize[$F('size')] +
                    '</span><span class="blue"> unit near </span><span class="green"> ' + $F('address') +
                    '</span><span class="blue"> starting on </span><span class="green">' + getDate() +
                    '</span>';
          } else if (sizeValid) {
            msg = '<span class="blue">Searching for a </span><span class="green">' + storageSize[$F('size')] +
                    '</span>';
            if (addrValid) {
              msg += '<span class="blue"> unit near </span><span class="green"> ' + $F('address') +
                    '</span><span class="blue">. Please select starting date.</span>';
            } else if (dateValid) {
              msg += '<span class="blue"> starting on </span><span class="green">' + getDate() +
                    '</span><span class="blue">. Please select address or zip.</span>';
            } else {
              msg += '<span class="blue">Please select address or zip and move-in date.</span>';
            }
          } else if (addrValid) {
            msg = '<span class="blue">Searching near </span><span class="green">' + $F('address') +
                  '</span>';
            if (dateValid) {
              msg += '<span class="blue"> starting on </span><span class="green">' + getDate() +
                    '</span><span class="blue">. Please select unit size.</span>';
            } else {
              msg += '<span class="blue">. Please select unit size and starting date.</span>';
            }
          } else {
            msg = '';
          }
          $('searchMsg').update(msg);
        }

        FastInit.addOnLoad(setupCalendar, setupHelp, setupForm);
//]]>
      </script>
    </head>
    <body>
    <div id="body">
      <g:render template="/topnav" />
      <div id="stcontent">
        <g:render template="/logo_bar" />
        <div style="height: 25px;"></div>
        <div id="search">
          <div id="instructions">
            Search for Storage
          </div>
          <div style="height: 5px;"></div>
          <div>
            <form id="gsearch" action="" method="post">
              <div class="left" style="margin: 2px 5px 0 0;">
                <img src="${resource(dir:'images', file:'btn-circle-1.png')}" alt="1"/>
              </div>
              <div class="left">
                <input type="text" name="address" id="address" class="inputBox" value="${params.address ? params.address : 'Enter address or zip code.'}"/>
              </div>
              <div style="clear:both;height: 10px;"></div>
              <div>
                <div class="left" style="margin: 2px 5px 0 0;">
                  <img src="${resource(dir:'images', file:'btn-circle-2.png')}" alt="2"/>
                </div>
                <div class="left">
                  <g:select name="size" id="size" from="${sizeList}" class="inputSelect" value="${params.size}" optionKey="id" optionValue="description"/>
                </div>
                <div class="left" style="padding: 4px 7px;">
                  <img id="sizeInfo" src="${resource(dir:'images', file:'icn_info_circle.png')}" alt="info"/>
                </div>
                <div style="clear: both;"></div>
              </div>
              <div style="height: 10px;"></div>
              <div class="left" style="margin: 2px 5px 0 0;">
                <img src="${resource(dir:'images', file:'btn-circle-3.png')}" alt="3"/>
              </div>
              <div class="left">
                <input type="text" id="date" class="inputBox dateInput" value="${params.date ? params.date : 'Select move in date.'}"/>
              </div>
              <div style="clear: both;height: 10px;"></div>
              <div style="margin-left: 30px;">
                <img id="gsearchBtn" src="${resource(dir:'images', file:'btn-find-it.png')}" class="noborder" alt="Search Storage"/>
              </div>
              <div style="clear: both; height: 10px;"></div>
            </form>
          </div>
        </div>
        <!-- highlight offers here -->
        <div id="gmap">
          <div id="map_canvas"></div>
        </div>

        <div style="height: 20px;clear: both;"></div>
        <div id="searchMsg" class="section_header"></div>
        <div style="height: 20px;clear: both;"></div>
        <div class="resultsBar">
          Search Results
        </div>
        <div style="height: 20px;"></div>

        <div id="stresults_div">
        </div>
      </div>
      <div style="height:100px;"></div>
      <g:render template="/footer" />
      <g:render template="/size_popup" />
      <div id="tooltip_keypad" style="display:none" class="tooltip">
      Keypad Entry
      </div>
      <div id="tooltip_camera" style="display:none" class="tooltip">
      Video Camera Security
      </div>
      <div id="tooltip_gate" style="display:none" class="tooltip">
      Security Gate
      </div>
      <div id="tooltip_alarm" style="display:none" class="tooltip">
      Unit level alarms
      </div>
      <div id="tooltip_truck" style="display:none" class="tooltip">
      Free Move-In Truck Available
      </div>
      <div id="tooltip_manager" style="display:none" class="tooltip">
      Manager lives onsite
      </div>
      <div id="tooltip_elevator" style="display:none" class="tooltip">
      Elevator to Upper Floors
      </div>
      <script type="text/javascript" src="http://www.google.com/jsapi?autoload=%7B%22modules%22%3A%5B%7B%22name%22%3A%22maps%22%2C%22version%22%3A%223.x%22%2Cother_params%3A%22sensor%3Dfalse%22%2C%22callback%22%3A%22createMap%22%7D%2C%7B%22name%22%3A%22gdata%22%2C%22version%22%3A%222.x%22%2C%22packages%22%3A%5B%22maps%22%5D%7D%5D%7D&amp;key=ABQIAAAAEDNru_s_vCsZdWplqCj4hxSjGMYCLTKEQ0TzQvUUxxIh1qVrLhTUMUuVByc3xGunRlZ-4Jv6pHfFHA"></script>
    </div>
    </body>
</html>