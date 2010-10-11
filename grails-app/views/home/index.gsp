<%@ page import="storitz.constants.UnitType; storitz.constants.TruckType" %>
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN"
    "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" >
    <head>
      <meta name="Description" content="Storitz is the smart and easy way to find and rent self-storage, mini-storage, RV storage, wine storage.  Compare and save on your storage rentals." />
      <g:render template="/header" />
      <p:dependantJavascript >
      <script type="text/javascript">
//<![CDATA[
      /*
          Javascript functions for Google Maps, forms and table handling
      */

        var map;
        var geocoder;
        var R = 3958.761; // mi
        var searchLat = ${lat};
        var searchLng = ${lng};
        var infoWindow;
        var features = [];
        var storageSize = [];
        var tooltips = [];
        var tipBuilder = [];
        var searchAddr;
        var searchSize = ${searchSize};
        var searchSizeDesc;
        var searchDate;
        var helpFadeout = null;
        var baseURL = '${request.contextPath}/self-storage/';
        var inDrag = false;
        var savedFeature;
        var bounds = null;
        var markerImageGreen = null;
        var markerImageGray = null;
        var mapMarker = null;
        var firstDraw = false;

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

          if (!firstDraw) {
            firstDraw = true;
            return;
          }

          if (!inDrag) {
             getMarkers();
          }
        }

        function dragStart() {
          inDrag = true;
        }

        function dragEnd() {
          inDrag = false;
          getMarkers();
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

        function getAddress() {
          if ($F('address') && !$F('address').startsWith('Enter ')) {
            return $F('address');
          }
          return '';
        }

        function markerClick(feature) {
            var url = siteLink(feature) + '?s=m';
            if (searchSize && searchSize > 1) {
              url += '&searchSize=' + searchSize;
            }
            url += '&date=' + getDate();
            url += '&address=' + encodeURIComponent(getAddress());
            window.location = url;
        }

        function markerOver(feature) {
          var c = '<div style="width: 200px;"><h3>' + feature.title + '</h3>';
            if (feature.coverImg.length > 0) {
              c += '<div style="float: left;"><img src="${resource(dir:'/') != '/' ? resource(dir:'/') : ''}' + feature.coverImg + '" alt="' + feature.title + '"/></div>';
            }
            c += '<div style="float: left;padding: .5em">' + feature.address + '<br/>' +
              feature.city + ', ' + feature.state + ' ' + feature.zipcode + '</div><div style="clear: both;"></div>';
            if (feature.description) {
              c += feature.description;
            }
            c += '<div style="text-align: center;"><a href="' + siteLink(feature) + '?searchSize=' + (searchSize > 1 ? searchSize : '') + '&date=' + getDate() + '&address=' + encodeURIComponent($F('address')) + '">details</a></div></div>';
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
          if ($('row'+feature.id)) {
            $('row'+feature.id).addClassName('rowhighlight');
          }
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

        function getMarkers() {

          if (!bounds || typeof(bounds) == 'undefined') {
            return;
          }

          drawMarkers();
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
                var tableContents = '<table class="sortable" id="stresults' + randId + '"><thead><tr><th class="sortfirstasc distwidth" id="distance">Distance</th><th class="addrwidth" id="title">Location</th><th class="stprice pricewidth">Upper</th><th class="stprice pricewidth">Interior</th><th class="stprice pricewidth">Drive Up</th><th>Features</th><th>Special Offers</th></tr></thead><tbody>';
                var rows = 0;
                var offers;

                tooltips.each(function(t) {
                  if (typeof t.destroy == 'function') {
                    t.destroy();
                  }
                });
                tipBuilder.clear();

                transport.responseJSON.features.each(function(s) {

                    createMarker(s);
                    rows++;
                    tableContents += createTableRow(s);

                });
                tableContents += '</tbody></table>';
                $('stresults_div').update(tableContents);
                if (rows > 0) {
                  new TableKit('stresults' + randId, { editable:false, stripe:true });
                  tipBuilder.each(function(t) {
                     tooltips.push(new Tooltip(t.elementId, t.content));
                  });
                }
              },
              onFailure:function(transport) {
                alert("Something went wrong " + transport.responseText);
              }
          });
        }

        function createMarker(s) {
          var location = new google.maps.LatLng(s.lat, s.lng);
          var iconMarker;

          if (s.unitCount) {
            iconMarker = s.unitCount == 0 ? markerImageGray : markerImageGreen;
          } else {
            if (s.units) {
              iconMarker = s.units.size() == 0 ? markerImageGray : markerImageGreen;
            } else {
              iconMarker = markerImageGray;
            }
          }
          
          features[s.id] = s;
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
        }

        function createTableRow(s) {
          var offersTip = s.specialOffers.pluck('promoName').join('<BR/>');
          var featuredArr = $A(s.featuredOffers.pluck('promoName'));
          if (featuredArr.size() > 1 ) {
            offers = '<div id="offers' + s.id + '" class=\"pointer\">' + s.featuredOffers.pluck('promoName').join('<BR/>') + '</div><div id="tooltip_offers' + s.id + '" style="display:none;" class="tooltip">' + offersTip + '</div>';
            tipBuilder.push({elementId:"offers" + s.id, content:"tooltip_offers" + s.id});
          } else {
            var offersArr = $A(s.specialOffers.pluck('promoName'));
            if (offersArr.size() > 1 ) {
              offers = '<div id="offers' + s.id + '" class=\"pointer\">' + offersArr[0] + '<BR/>' + offersArr[1] + '</div><div id="tooltip_offers' + s.id + '" style="display:none;" class="tooltip">' + offersTip + '</div>';
              tipBuilder.push({elementId:"offers" + s.id, content:"tooltip_offers" + s.id});
            } else {
              offers = offersArr[0];
            }
          }
          var pUp = s.units.find(function(n) { return n.unitType == '${UnitType.UPPER}' });
          var pDup = s.units.find(function(n) { return n.unitType == '${UnitType.DRIVEUP}' });
          var pInt = s.units.find(function(n) { return n.unitType == '${UnitType.INTERIOR}' });
          var priceDriveup = pDup ? pDup.price  : 999999;
          var priceInterior = pInt ? pInt.price : 999999;
          var priceUpper = pUp ? pUp.price : 999999;

          var keypadImg = s.isKeypad ? "<img id=\"keypad" + s.id +"\" class=\"pointer\" src=${p.imageLink(src:'icon-keypad-green-20x20.gif')} style=\"vertical-align: middle; margin: 1px; width:20px; height:20px;\" alt=\"Keypad\"/>" : '<span style="width:20px; margin:1px;"></span>';
          var cameraImg = s.isCamera ? "<img id=\"camera" + s.id +"\" class=\"pointer\" src=${p.imageLink(src:'icon-camera-green-20x20.gif')} style=\"vertical-align: middle; margin: 1px; width:20px; height:20px;\" alt=\"Camera\"/>" : '<span style="width:20px; margin: 1px;"></span>';
          var gateImg   = s.isGate ? "<img id=\"gate" + s.id +"\" class=\"pointer\" src=${p.imageLink(src:'icon-gate-green-20x20.gif')} style=\"vertical-align: middle; margin: 1px; width:20px; height:20px;\" alt=\"Gate\"/>" : '<span style="width:20px; margin: 1px;"></span>';
          var alarmImg  = s.isUnitAlarmed ? "<img id=\"alarm" + s.id +"\" class=\"pointer\" src=${p.imageLink(src:'icon-alarm-green-20x20.gif')} style=\"vertical-align: middle; margin: 1px; width:20px; height:20px;\" alt=\"Alarm\"/>" : '<span style="width:20px; margin: 1px;"></span>';
          var managerImg  = s.isManagerOnsite ? "<img id=\"manager" + s.id +"\" class=\"pointer\" src=${p.imageLink(src:'icon-green-mgr20b.gif')} style=\"vertical-align: middle; margin: 1px; width:20px; height:20px;\" alt=\"Manager Onsite\"/>" : '<span style="width:20px; margin: 1px;"></span>';
          var elevatorImg  = s.hasElevator ? "<img id=\"elevator" + s.id +"\" class=\"pointer\" src=${p.imageLink(src:'icon-green-elevator20.gif')} style=\"vertical-align: middle; margin: 1px; width:20px; height:20px;\" alt=\"Elevator\"/>" : '<span style="width:20px; margin: 1px;"></span>';

          var truckImg = '<span style="width:20px; margin: 1px;"></span>';
          switch(s.freeTruck) {
            case "FREE":
              truckImg =  "<img id=\"truck" + s.id +"\" class=\"pointer\" src=${p.imageLink(src:'icon-rentaltruck-green-20x20.gif')} style=\"vertical-align: middle; margin: 1px; width:20px; height:20px;\" alt=\"Rental Truck\"/>";
              break;
            case "RENTAL":
              truckImg =  "<img id=\"truck" + s.id +"\" class=\"pointer\" src=${p.imageLink(src:'icon-rentaltruck-green-20x20.gif')} style=\"vertical-align: middle; margin: 1px; width:20px; height:20px;\" alt=\"Rental Truck\"/>";
              break;
          }

          if (s.isKeypad) {
            tipBuilder.push({elementId:"keypad" + s.id, content:"tooltip_keypad"});
          }
          if (s.isCamera) {
            tipBuilder.push({elementId:"camera" + s.id, content:"tooltip_camera"});
          }
          if (s.isGate) {
            tipBuilder.push({elementId:"gate" + s.id, content:"tooltip_gate"});
          }
          if (s.isUnitAlarmed) {
            tipBuilder.push({elementId:"alarm" + s.id, content:"tooltip_alarm"});
          }
          if (s.isManagerOnsite) {
            tipBuilder.push({elementId:"manager" + s.id, content:"tooltip_manager"});
          }
          if (s.hasElevator) {
            tipBuilder.push({elementId:"elevator" + s.id, content:"tooltip_elevator"});
          }
          if (s.freeTruck == "RENTAL" || s.freeTruck == "FREE") {
            tipBuilder.push({elementId:"truck" + s.id, content:"tooltip_truck"});
          }

          return '<tr id="row' + s.id + '" class="strow"><td class="textCenter distance">' + calcDistance(searchLat, s.lat, searchLng, s.lng) + 'mi </td><td class="stVert"><div style="float:left;"><a href="#" class="no_underline siteTitle" onclick="panTo(' + s.id + ');return false">' + s.title + '</a><br> ' +
            '<a href="' + siteLink(s) + '?searchSize=' + (searchSize > 1 ? searchSize : '') + '&date=' + getDate() + '&address=' + encodeURIComponent(getAddress()) + '">' + s.address +'</a></div></td><td class="textCenter">' +
            (priceUpper && priceUpper < 999999 ? '<a href="' + siteLink(s) + '?unitType=UPPER' + (pUp ? '&searchSize=' + pUp.unitsize.id : '') + '&date=' + getDate() + '&address=' + encodeURIComponent(getAddress()) + '" class="unitPrice">$' + priceUpper.toFixed(2) + '</a>' : "&#8212;") + '</td><td class="textCenter">' +
            (priceInterior && priceInterior < 999999 ? '<a href="' + siteLink(s) + '?unitType=INTERIOR' + (pInt ? '&searchSize=' + pInt.unitsize.id : '') + '&date=' + getDate() + '&address=' + encodeURIComponent(getAddress()) + '" class="unitPrice">$' + priceInterior.toFixed(2) + '</a>' : "&#8212;") + '</td><td class="textCenter">' +
            (priceDriveup && priceDriveup < 999999 ? '<a href="' + siteLink(s) + '?unitType=DRIVEUP' + (pDup ? '&searchSize=' + pDup.unitsize.id : '') + '&date=' + getDate() + '&address=' + encodeURIComponent(getAddress()) + '" class="unitPrice">$' + priceDriveup.toFixed(2) + '</a>' : "&#8212;")  + '</td>' +
            '<td><div style="float:right;">' + keypadImg + cameraImg + alarmImg + managerImg + gateImg + elevatorImg + truckImg +'</div></td><td class="specialOfferText">' + (offers ? offers : "&#8212;") + '</td></tr>';

        }

        function createMap() {
          var iploc  = new google.maps.LatLng(${lat}, ${lng});
          var myOptions = {
            zoom: ${zoom},
            center: iploc,
            scrollwheel: false,
            mapTypeId: google.maps.MapTypeId.ROADMAP,
            navigationControlOptions: {style: google.maps.NavigationControlStyle.ZOOM_PAN}
          };
          markerImageGreen = new google.maps.MarkerImage(${p.imageLink(src:'icn_map_grn.png')}, null, null, new google.maps.Point(1, 32));
          markerImageGray = new google.maps.MarkerImage(${p.imageLink(src:'gray-icon.png')}, null, null, new google.maps.Point(1, 32));

          map = new google.maps.Map(document.getElementById("map_canvas"), myOptions );

          google.maps.event.addListener(map, 'bounds_changed', redrawMap);
          google.maps.event.addListener(map, 'dragstart', dragStart);
          google.maps.event.addListener(map, 'dragend', dragEnd);
          geocoder = new google.maps.Geocoder();

          var site;
          <g:each var="site" in="${sites}">
            site = new Object();          
            site.lat = ${site.lat};
            site.lng = ${site.lng};
            site.title = '${site.title}';
            site.id = ${site.id};
            site.unitCount = ${site.units.size()};
            site.coverImg = '${site.coverImage() ? site.coverImage().thumbnail() : ""}';
            createMarker(site);
            <g:if test="${site.isKeypad}">
              tooltips.push(new Tooltip("keypad${site.id}", "tooltip_keypad"));
            </g:if>
            <g:if test="${site.isCamera}">
              tooltips.push(new Tooltip("camera${site.id}", "tooltip_camera"));
            </g:if>
            <g:if test="${site.isGate}">
              tooltips.push(new Tooltip("gate${site.id}", "tooltip_gate"));
            </g:if>
            <g:if test="${site.isUnitAlarmed}">
              tooltips.push(new Tooltip("alarm${site.id}", "tooltip_alarm"));
            </g:if>
            <g:if test="${site.isManagerOnsite}">
              tooltips.push(new Tooltip("manager${site.id}", "tooltip_manager"));
            </g:if>
            <g:if test="${site.hasElevator}">
              tooltips.push(new Tooltip("elevator${site.id}", "tooltip_elevator"));
            </g:if>
            <g:if test="${site.freeTruck == TruckType.FREE || site.freeTruck == TruckType.RENTAL}">
              tooltips.push(new Tooltip("truck${site.id}", "tooltip_truck"));
            </g:if>
            tooltips.push(new Tooltip("offers${site.id}", "tooltip_offers${site.id}"));
          </g:each>
          
        }

        function showAddress(address, size, date) {

          updateSearchMsg();
          
          var validAddr = address.length > 4 && !address.startsWith('Enter ');

          if (validAddr) {
            searchAddr = address;
          }
          searchSize = size;
          searchDate = date;
          searchSizeDesc = storageSize[size];

          if (geocoder && validAddr) {
            geocoder.geocode( { 'address': address}, function(results, status) {
              if (status == google.maps.GeocoderStatus.OK) {
                map.setCenter(results[0].geometry.location);
                if (mapMarker) {
                  mapMarker.setMap(null);
                }
                mapMarker = new google.maps.Marker({
                    map: map,
                    position: results[0].geometry.location
                });
                searchLat = results[0].geometry.location.lat();
                searchLng = results[0].geometry.location.lng();
              } else {
                $('stresults_div').update("<div class=\"siteOverage\">Your search was too vague - you may need to add a zip code or state to:" + getAddress() + "</div>");
              }
            });
          }
          getMarkers();
        }

        function setupCalendar() {
          Calendar.setup({
              dateField     : 'date',
              triggerElement: 'date',
              dateFormat    : '%m/%d/%y',
              selectHandler : function(cal, dateString) {
                $('date').value = dateString;
                showAddress(getAddress(), $F('size'), dateString);
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
            showAddress(getAddress(), $F('size'), getDate());
          });
          $('address').observe('keypress', function(event) {
            if (event.keyCode == 13) {
              showAddress(getAddress(), $F('size'), getDate());
            }
          });
          $('address').observe('click', function(event) {
            if ($F('address').startsWith('Enter ')) {
              $('address').value = '';
            }
          });
          $('size').observe('change', function() {
            showAddress(getAddress(), $F('size'), getDate());
          });          
        }


        function updateSearchMsg() {
          var msg;
          var addrValid = getAddress() && getAddress().length > 0;
          var sizeValid = $F('size') != 1;
          var dateValid = getDate() && getDate().length > 0;

          if (addrValid && sizeValid && dateValid) {
            msg = '<span class="blue">Searching for a </span><span class="green">' + storageSize[$F('size')] +
                    '</span><span class="blue"> unit near </span><span class="green"> ' + getAddress() +
                    '</span><span class="blue"> starting on </span><span class="green">' + getDate() +
                    '</span>';
          } else if (sizeValid) {
            msg = '<span class="blue">Searching for a </span><span class="green">' + storageSize[$F('size')] +
                    '</span>';
            if (addrValid) {
              msg += '<span class="blue"> unit near </span><span class="green"> ' + getAddress() +
                    '</span><span class="blue">. Please select starting date.</span>';
            } else if (dateValid) {
              msg += '<span class="blue"> starting on </span><span class="green">' + getDate() +
                    '</span><span class="blue">. Please select address or zip.</span>';
            } else {
              msg += '<span class="blue">Please select address or zip and move-in date.</span>';
            }
          } else if (addrValid) {
            msg = '<span class="blue">Searching near </span><span class="green">' + getAddress() +
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

        function setupAnalytics() {
          window.setTimeout(doAnalytics, 1);
        }

        function doAnalytics() {
          // Called a few ms after the page has loaded.
          var ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;
          ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
          var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ga, s);
        }

        var _gaq = _gaq || [];
        _gaq.push(['_setAccount', 'UA-16012579-1']);
        _gaq.push(['_trackPageview']);

        FastInit.addOnLoad(setupCalendar, setupHelp, setupForm, setupAnalytics);
//]]>
      </script>
      </p:dependantJavascript>
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
                <storitz:image src="btn-circle-1.png" width="26" height="26" alt="1"/>
              </div>
              <div class="left">
                <input type="text" name="address" id="address" class="inputBox" value="${params.address ? params.address : 'Enter address or zip code'}"/>
              </div>
              <div style="clear:both;height: 10px;"></div>
              <div>
                <div class="left" style="margin: 2px 5px 0 0;">
                  <storitz:image src="btn-circle-2.png" width="26" height="26" alt="2"/>
                </div>
                <div class="left">
                  <g:select name="size" id="size" from="${sizeList}" class="inputSelect" value="${params.size}" optionKey="id" optionValue="description"/>
                </div>
                <div class="left" style="padding: 4px 7px;">
                  <storitz:image id="sizeInfo" src="icn_info_circle.png" width="19" height="18" alt="info"/>
                </div>
                <div style="clear: both;"></div>
              </div>
              <div style="height: 10px;"></div>
              <div class="left" style="margin: 2px 5px 0 0;">
                <storitz:image src="btn-circle-3.png" width="26" height="26" alt="3"/>
              </div>
              <div class="left">
                <input type="text" id="date" class="inputBox dateInput" value="${params.date ? params.date : 'Select move-in date'}"/>
              </div>
              <div style="clear: both;height: 10px;"></div>
              <div style="margin-left: 30px;">
                <storitz:image id="gsearchBtn" src="btn-find-it.png" class="noborder" width="108" height="36" alt="Search Storage"/>
              </div>
              <div style="clear: both;"></div>
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
          <g:if test="${sites.size() > 0}">
            <table class="sortable" id="stresults">
              <thead>
                <tr>
                  <th class="sortfirstasc distwidth" id="distance">Distance</th>
                  <th class="addrwidth" id="title">Location</th>
                  <th class="stprice pricewidth">Upper</th>
                  <th class="stprice pricewidth">Interior</th>
                  <th class="stprice pricewidth">Drive Up</th>
                  <th>Features</th>
                  <th>Special Offers</th>
                </tr>
              </thead>
              <tbody>
              <g:each var="site" in="${sites}">
                <tr id="row${site.id}" class="strow">
                  <td class="textCenter distance"><storitz:calcDistance lat1="${lat}" lat2="${site.lat}" lng1="${lng}" lng2="${site.lng}"/> mi</td>
                  <td class="stVert">
                    <div style="float:left;">
                      <a href="#" class="no_underline siteTitle" onclick="panTo(${site.id});return false">${site.title}</a><br>
                      <g:link action="storageSite" controller="detail" mapping="siteLink" id="${site.id}" params="[date:params.date, searchSize:params.searchSize, address:params.address, city:site.city, site_title:site.title, id:site.id]">${site.address}</g:link>
                    </div>
                  </td>
                  <td class="textCenter">
                    <g:if test="${site.units.findAll{ it.unitType == UnitType.UPPER}.size() > 0}">
                      <g:link action="detail" controller="storageSite" mapping="siteLink" id="${site.id}" params="[date:params.date, searchSize:params.searchSize, address:params.address, city:site.city, site_title:site.title, id:site.id, unitType:UnitType.UPPER]" class="unitPrice">$<storitz:printMin set="${site.units.findAll{it.unitType == UnitType.UPPER} }" member="price" format="0.00"/></g:link>
                    </g:if>
                    <g:else>
                      &#8212;
                    </g:else>
                   </td>
                  <td class="textCenter">
                    <g:if test="${site.units.findAll{ it.unitType == UnitType.INTERIOR}.size() > 0}">
                      <g:link action="detail" controller="storageSite" mapping="siteLink" id="${site.id}" params="[date:params.date, searchSize:params.searchSize, address:params.address, city:site.city, site_title:site.title, id:site.id, unitType:UnitType.INTERIOR]" class="unitPrice">$<storitz:printMin set="${site.units.findAll{it.unitType == UnitType.INTERIOR} }" member="price" format="0.00"/></g:link>
                    </g:if>
                    <g:else>
                      &#8212;
                    </g:else>
                  </td>
                  <td class="textCenter">
                    <g:if test="${site.units.findAll{ it.unitType == UnitType.DRIVEUP}.size() > 0}">
                      <g:link action="detail" controller="storageSite" mapping="siteLink" id="${site.id}" params="[date:params.date, searchSize:params.searchSize, address:params.address, city:site.city, site_title:site.title, id:site.id, unitType:UnitType.DRIVEUP]" class="unitPrice">$<storitz:printMin set="${site.units.findAll{it.unitType == UnitType.DRIVEUP} }" member="price" format="0.00"/></g:link>
                    </g:if>
                    <g:else>
                      &#8212;
                    </g:else>
                  </td>
                  <td>
                    <div style="float:right;">
                      <g:if test="${site.isKeypad}">
                        <storitz:image id="keypad${site.id}" class="pointer" src="icon-keypad-green-20x20.gif" style="vertical-align: middle; margin: 1px; width:20px; height:20px;" alt="Keypad"/>
                      </g:if>
                      <g:else>
                        <span style="width:20px; margin:1px;"></span>
                      </g:else>
                      <g:if test="${site.isCamera}">
                        <storitz:image id="camera${site.id}" class="pointer" src="icon-camera-green-20x20.gif" style="vertical-align: middle; margin: 1px; width:20px; height:20px;" alt="Camera"/>
                      </g:if>
                      <g:else>
                        <span style="width:20px; margin: 1px;"></span>
                      </g:else>
                      <g:if test="${site.isGate}">
                        <storitz:image id="gate${site.id}" class="pointer" src="icon-gate-green-20x20.gif" style="vertical-align: middle; margin: 1px; width:20px; height:20px;" alt="Gate"/>
                      </g:if>
                      <g:else>
                        <span style="width:20px; margin: 1px;"></span>
                      </g:else>
                      <g:if test="${site.isUnitAlarmed}">
                        <storitz:image id="alarm${site.id}" class="pointer" src="icon-alarm-green-20x20.gif" style="vertical-align: middle; margin: 1px; width:20px; height:20px;" alt="Alarm"/>
                      </g:if>
                      <g:else>
                        <span style="width:20px; margin: 1px;"></span>
                      </g:else>
                      <g:if test="${site.isManagerOnsite}">
                        <storitz:image id="manager${site.id}" class="pointer" src="icon-green-mgr20b.gif" style="vertical-align: middle; margin: 1px; width:20px; height:20px;" alt="Manager Onsite"/>
                      </g:if>
                      <g:else>
                        <span style="width:20px; margin: 1px;"></span>
                      </g:else>
                      <g:if test="${site.hasElevator}">
                        <storitz:image id="elevator${site.id}" class="pointer" src="icon-green-elevator20.gif" style="vertical-align: middle; margin: 1px; width:20px; height:20px;" alt="Elevator"/>
                      </g:if>
                      <g:else>
                        <span style="width:20px; margin: 1px;"></span>
                      </g:else>
                    </div>
                  </td>
                  <td class="specialOfferText">
                    <g:if test="${site.featuredOffers().size() > 0}">
                      <div id="offers${site.id}" class="pointer"><storitz:joinMember set="${site.featuredOffers()}" member="promoName"/></div>
                      <div id="tooltip_offers${site.id}" style="display:none;" class="tooltip"><storitz:joinMember set="${site.specialOffers()}" member="promoName"/></div>
                    </g:if>
                    <g:elseif test="${site.specialOffers().size() >1}">
                      <div id="offers${site.id}" class="pointer">${site.specialOffers()[0].promoName}<BR/>${site.specialOffers()[1].promoName}</div>
                      <div id="tooltip_offers${site.id}" style="display:none;" class="tooltip"><storitz:joinMember set="${site.specialOffers()}" member="promoName"/></div>
                    </g:elseif>
                    <g:elseif test="${site.specialOffers().size() == 1}">
                      <div id="offers${site.id}" class="pointer">${site.specialOffers()[0].promoName}</div>
                      <div id="tooltip_offers${site.id}" style="display:none;" class="tooltip">${site.specialOffers()[0].promoName}</div>
                    </g:elseif>
                    <g:else>
                      &#8212;
                    </g:else>
                  </td>
                </tr>
              </g:each>

              </tbody>
            </table>
          </g:if>
        </div>
        <div style="margin:1em 0;">
          <p>
            You need someplace to store your stuff. And
            you’re pretty sure the perfect space is out there.
            Somewhere. So how do you find that 10 by 10
            that’s two miles away and currently offering the
            first month free? Storitz. We help you search
            thousands of self-storage units from hundreds of
            partners all from one website. Shop anytime,
            24/7—on your terms. Compare prices, size, amenities, locations.
            Check out deals. Then rent your unit and complete the transaction
            right on the spot. Storitz takes the hassle and headache out of
            finding storage, saving you tons of time and money in the process.
            Storitz. Click. Store. Done.
          </p>
          <p>
            Find, compare and book storage for: climate controlled and air-conditioned storage,
            wine storage, mini storage, self storage, RV parking, boat storage and more.
          </p>
        </div>
      </div>
      <div style="height:100px;"></div>
      <g:render template="/footer_no_analytics" />
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
      <p:dependantJavascript>
        <script type="text/javascript" src="http://www.google.com/jsapi?autoload=%7B%22modules%22%3A%5B%7B%22name%22%3A%22maps%22%2C%22version%22%3A%223.x%22%2Cother_params%3A%22sensor%3Dfalse%22%2C%22callback%22%3A%22createMap%22%7D%2C%7B%22name%22%3A%22gdata%22%2C%22version%22%3A%222.x%22%2C%22packages%22%3A%5B%22maps%22%5D%7D%5D%7D&amp;key=ABQIAAAAEDNru_s_vCsZdWplqCj4hxSjGMYCLTKEQ0TzQvUUxxIh1qVrLhTUMUuVByc3xGunRlZ-4Jv6pHfFHA"></script>
      </p:dependantJavascript>
    </div>
    </body>
    <p:renderDependantJavascript />
</html>