<%@ page import="storitz.constants.UnitType; storitz.constants.TruckType" %>
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN"
    "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" >
    <head>
      <meta name="Description" content="Storitz Self-Storage search results in ${city}, ${state} ${zip ? 'postal code:' + zip : zip}. Storitz is the smart and easy way to find and rent self-storage, mini-storage, RV storage, wine storage.  Compare and save on your storage rentals." />
      <g:render template="/header_home" />
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
        var markersGreen = [];
        var markersBlue = [];
        var mapMarker = null;
        var firstDraw = false;

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

          return baseURL + encodeURIComponent(s.city) + '/' + encodeURIComponent(s.state) + '/' + encodeURIComponent(s.title.replace(city_pat, '')) + '/' + s.id;
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
                var tableContents = '<table class="sortable" id="stresults' + randId + "\"><thead><tr><th class=\"sortfirstasc distwidth\" id=\"distance\">Distance</th><th class=\"addrwidth\" id=\"title\">Location</th><th class=\"pricewidthplus\"><div class=\"left\" style=\"padding: 0 5px;cursor:pointer;\"><img id='resultInfo' src=${p.imageLink(src:'icn_info_circle.png')} width='19' height='18' alt='results info'/></div><div class=\"left\" style=\"margin-top:2px;\">Upper</div></th><th class=\"pricewidth\">Interior</th><th class=\"pricewidth\">Drive Up</th><th>Features</th><th>Special Offers</th></tr></thead><tbody>";
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

          iconMarker = markersGreen[s.id];
          
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
            } else if (offersArr.size() > 0) {
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
            navigationControlOptions: {style: google.maps.NavigationControlStyle.DEFAULT}
          };
          <g:each var="i" in="${ (0..25) }">
            markersGreen[${i}] = new google.maps.MarkerImage(${p.imageLink(src:'map_icons/green-loc' + i + '.png')}, null, null, new google.maps.Point(1, 35));
            markersBlue[${i}] = new google.maps.MarkerImage(${p.imageLink(src:'map_icons/blue-loc' + i + '.png')}, null, null, new google.maps.Point(1, 35));
          </g:each>
          
          map = new google.maps.Map(document.getElementById("map_canvas"), myOptions );

          google.maps.event.addListener(map, 'bounds_changed', redrawMap);
          google.maps.event.addListener(map, 'dragstart', dragStart);
          google.maps.event.addListener(map, 'dragend', dragEnd);
          geocoder = new google.maps.Geocoder();

          var site;
          <g:each var="site" in="${sites}" status="c">
            site = new Object();          
            site.lat = ${site.lat};
            site.lng = ${site.lng};
            site.title = '${site.title}';
            site.id = ${site.id};
            site.unitCount = ${site.units.size()};
            site.coverImg = '${site.coverImage() ? site.coverImage().thumbnail() : ""}';
            site.address = '${site.address}';
            site.zipcode = '${site.zipcode}';
            site.state = '${site.state.display}';
            site.city = '${site.city}';
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
            <g:if test="${site.specialOffers().size() > 0}">
              tooltips.push(new Tooltip("offers${site.id}", "tooltip_offers${site.id}"));
            </g:if>
          </g:each>
          
        }

        function showAddress(address, size, date) {

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
            Effect.toggle('sizeHelp', 'appear', {duration: 0.5});
          });
          $('sizeHelpClose').observe('click', function() {
            Effect.toggle('sizeHelp', 'appear', {duration: 0.5});
          });
          $('resultInfo').observe('click', function(event) {
            $('resultHelp').setStyle({ top: Event.pointerY(event) - 10 + "px", left: Event.pointerX(event) + 10 + "px" });
            Effect.toggle('resultHelp', 'appear', {duration: 0.5});
          });
          $('resultHelpClose').observe('click', function() {
            Effect.toggle('resultHelp', 'appear', {duration: 0.5});
          });
        }

        function setupForm() {
          $('address').focus();
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

        $(document).ready(function() {

          setupCalendar();
          setupHelp();
          setupForm();
          setupAnalytics();
        });

//]]>
      </script>
      </p:dependantJavascript>
    </head>
    <body>
    <div id="body">
      <g:render template="/topnav" />
      <g:render template="/logo_bar" />
      <div class="stcontent">
        <div style="height: 10px;"></div>
        <div class="leftColumn">
          <div class="leftSection">
            <div class="leftSectionHeader">
              Search for Self-Storage
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
                  <div class="left" style="padding: 4px 7px;cursor:pointer;">
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
                <div style="clear: both;"></div>
              </form>
            </div>
          </div>
          <div class="leftSection">
            <div class="leftSectionHeader">
              Video
            </div>
            <object width="300" height="193"><param name="movie" value="http://www.youtube.com/v/w815nn8ypt0?fs=1&amp;hl=en_US&amp;rel=0&amp;color1=0x006699&amp;color2=0x54abd6"/><param name="allowFullScreen" value="true"/><param name="allowscriptaccess" value="always"/><embed src="http://www.youtube.com/v/w815nn8ypt0?fs=1&amp;hl=en_US&amp;rel=0&amp;color1=0x006699&amp;color2=0x54abd6" type="application/x-shockwave-flash" allowscriptaccess="always" allowfullscreen="true" width="300" height="193"></embed></object>
          </div>
          <div>
            <div class="leftSectionHeader">
              Storitz Supports
            </div>
            <a href="http://www.pancreatic.org/" target="_blank">
              <storitz:image src='hirshberg-banner.gif' width="148" height="57" border="0"/>
            </a>
            <a href="http://www.kureit.org/" target="_blank">
              <storitz:image src='kure-it-banner.gif' width="148" height="57"/>
            </a>
          </div>
        </div>
        <div class="rightColumn">
          <div id="gmap">
            <div id="map_canvas"></div>
          </div>

          <div id="stresults_div">
            <g:if test="${sites.size() > 0}">
              <table id="stresults">
                <thead>
                  <tr class="stresultsHeader">
                    <th style="width:80px;">Distance</th>
                    <th style="width:250px;">Facility</th>
                    <th style="width:200px;">Special Offers</th>
                    <th style="width:105px;">Move-In Cost From</th>
                  </tr>
                  <tr>
                    <td colspan="4" style="border-bottom:1px black solid;"></td>
                  </tr>
                </thead>
                <tbody>
                <g:each var="site" in="${sites}" status="c">
                  <tr id="row${site.id}">
                    <td class="textCenter">
                      <div class="stDistanceLine"></div>
                      <div class="left" style="margin-left:10px;">
                        <div id="map_icon${site.id}">
                          <storitz:image src="${'map_icons/green-loc' + (c  + 1) + '.png'}" width="28" height="35"/>
                        </div>
                        <div class="stDistance"><storitz:calcDistance lat1="${lat}" lat2="${site.lat}" lng1="${lng}" lng2="${site.lng}"/></div>
                        <div class="stMiles">miles</div>
                      </div>
                    </td>
                    <td class="stVert">
                      <div class="left">
                        <g:if test="${site?.logo}">
                          <img src="${resource(file:site.logo.src())}" width="100" height="40" alt="${site.title} Logo"/>
                        </g:if>
                      </div>
                      <div class="left" style="margin-left: 5px;">
                        <div class="stTitle">${site.title}</div>
                        <div class="stAddress">${site.address}</div>
                      </div>
                      <div style="clear:both;"></div>
                      <div>
                        <g:if test="${site.isKeypad}">
                          <storitz:image id="keypad${site.id}" class="pointer" src="icon-keypad-green-20x20.gif" style="vertical-align: middle; margin: 1px; width:20px; height:20px;" alt="Keypad"/>
                        </g:if>
                        <g:if test="${site.isCamera}">
                          <storitz:image id="camera${site.id}" class="pointer" src="icon-camera-green-20x20.gif" style="vertical-align: middle; margin: 1px; width:20px; height:20px;" alt="Camera"/>
                        </g:if>
                        <g:if test="${site.isGate}">
                          <storitz:image id="gate${site.id}" class="pointer" src="icon-gate-green-20x20.gif" style="vertical-align: middle; margin: 1px; width:20px; height:20px;" alt="Gate"/>
                        </g:if>
                        <g:if test="${site.isUnitAlarmed}">
                          <storitz:image id="alarm${site.id}" class="pointer" src="icon-alarm-green-20x20.gif" style="vertical-align: middle; margin: 1px; width:20px; height:20px;" alt="Alarm"/>
                        </g:if>
                        <g:if test="${site.isManagerOnsite}">
                          <storitz:image id="manager${site.id}" class="pointer" src="icon-green-mgr20b.gif" style="vertical-align: middle; margin: 1px; width:20px; height:20px;" alt="Manager Onsite"/>
                        </g:if>
                        <g:if test="${site.hasElevator}">
                          <storitz:image id="elevator${site.id}" class="pointer" src="icon-green-elevator20.gif" style="vertical-align: middle; margin: 1px; width:20px; height:20px;" alt="Elevator"/>
                        </g:if>
                      </div>
                    </td>
                    <td class="stSpecialOffers">
                      <g:if test="${site.featuredOffers().size() > 0}">
                        <g:each var="promo" in="${site.featuredOffers()}">
                          <div class="left">
                            <storitz:image src="special-offer-icon.gif" width="20" height="20"/>
                          </div>
                          <div class="left" style="margin: 2px 0 0 10px;">
                            ${promo.promoName}
                          </div>
                          <div style="clear:both;"></div>
                        </g:each>
                      </g:if>
                      <g:elseif test="${site.specialOffers().size() > 0}">
                        <g:each var="promo" in="${site.specialOffers()}">
                          <div>
                            <storitz:image src="special-offer-icon.gif" width="20" height="20"/>
                          </div>
                        </g:each>
                        <div class="left" style="margin: 2px 0 0 10px;">
                          ${promo.promoName}
                        </div>
                      </g:elseif>
                      <g:else>
                        &#8212;
                      </g:else>
                    </td>
                    <td>
                      <div class="stPrice textCenter"><g:formatNumber number="${siteMoveInPrice[site.id]?.cost}" type="currency" currencyCode="USD"/></div>
                      <div class="stPriceSub textCenter">MOVES YOU IN</div>
                      <div style="width:87px;margin-left: auto; margin-right: auto;">
                        <g:link mapping="siteLink" params="[city:site.city, state:site.state.display, site_title:site.title, id:site.id, size:params.size, date:params.date, promoId:siteMoveInPrice[site.id]?.promo]">
                          <storitz:image src='rent-me-button.png' width='87' height='31' border='0'/>
                        </g:link>
                      </div>
                    </td>
                  </tr>
                  <tr>
                    <td colspan="4" style="border-bottom:1px #ccc dotted;"></td>
                  </tr>
                </g:each>

                </tbody>
              </table>
            </g:if>
          </div>
          <g:if test="${metro}">
            <div class="wideTextbox">
              <span style="font-weight:bold;">${metro.city}, ${metro.state.display}:</span> ${metro.note}
              <div style="font-weight:bold;margin:10px 0;">Neighborhoods and Towns:</div>
              <g:each in="${neighborhoodList}" var="n">
                <div class="left" style="width:150px;">
                  <g:link mapping="geo" params="[city:n.city, state:n.state.display, zip:n.zipcode]">${n.city}</g:link>
                </div>
              </g:each>
              <div style="clear:both;"></div>
            </div>
          </g:if>
          <div class="wideTextbox">
            <div style="font-weight:bold;margin-bottom:10px;">Popular searches:</div>
            <div class="left" style="width:175px;">
              <g:link mapping="geo" params="[city:'Santa Monica', state:'CA', zip:'90404']">Santa Monica, CA</g:link>
            </div>
            <div class="left" style="width:175px;">
              <g:link mapping="geo" params="[city:'Los Angeles', state:'CA', zip:'90001']">Los Angeles, CA</g:link>
            </div>
            <div class="left" style="width:175px;">
              <g:link mapping="geo" params="[city:'Irvine', state:'CA', zip:'92612']">Irvine, CA</g:link>
            </div>
            <div class="left" style="width:175px;">
              <g:link mapping="geo" params="[city:'Long Beach', state:'CA', zip:'90806']">Long Beach, CA</g:link>
            </div>
            <div class="left" style="width:175px;">
              <g:link mapping="geo" params="[city:'West Hollywood', state:'CA', zip:'90069']">West Hollywood, CA</g:link>
            </div>
            <div class="left" style="width:175px;">
              <g:link mapping="geo" params="[city:'Van Nuys', state:'CA', zip:'91406']">Van Nuys, CA</g:link>
            </div>
            <div class="left" style="width:175px;">
              <g:link mapping="geo" params="[city:'Torrance', state:'CA', zip:'90505']">Torrance, CA</g:link>
            </div>
            <div class="left" style="width:175px;">
              <g:link mapping="geo" params="[city:'Newport Beach', state:'CA', zip:'92660']">Newport Beach, CA</g:link>
            </div>
            <div class="left" style="width:175px;">
              <g:link mapping="geo" params="[city:'El Segundo', state:'CA', zip:'90245']">El Segundo, CA</g:link>
            </div>
            <div class="left" style="width:175px;">
              <g:link mapping="geo" params="[city:'Burbank', state:'CA', zip:'91505']">Burbank, CA</g:link>
            </div>
            <div class="left" style="width:175px;">
              <g:link mapping="geo" params="[city:'Palm Desert', state:'CA', zip:'92260']">Palm Desert, CA</g:link>
            </div>
            <div class="left" style="width:175px;">
              <g:link mapping="geo" params="[city:'Anaheim', state:'CA', zip:'92805']">Anaheim, CA</g:link>
            </div>
            <div class="left" style="width:175px;">
              <g:link mapping="geo" params="[city:'Lancaster', state:'CA', zip:'93535']">Lancaster, CA</g:link>
            </div>
            <div class="left" style="width:175px;">
              <g:link mapping="geo" params="[city:'Austin', state:'TX', zip:'73301']">Austin, TX</g:link>
            </div>
            <div class="left" style="width:175px;">
              <g:link mapping="geo" params="[city:'Dallas', state:'TX', zip:'75201']">Dallas, TX</g:link>
            </div>
            <div class="left" style="width:175px;">
              <g:link mapping="geo" params="[city:'Houston', state:'TX', zip:'77001']">Houston, TX</g:link>
            </div>
            <div class="left" style="width:175px;">
              <g:link mapping="geo" params="[city:'Jacksonville', state:'FL', zip:'32099']">Jacksonville, FL</g:link>
            </div>
            <div class="left" style="width:175px;">
              <g:link mapping="geo" params="[city:'Miami', state:'FL', zip:'33010']">Miami, FL</g:link>
            </div>
            <div class="left" style="width:175px;">
              <g:link mapping="geo" params="[city:'Clearwater', state:'FL', zip:'33755']">Clearwater, FL</g:link>
            </div>
            <div class="left" style="width:175px;">
              <g:link mapping="geo" params="[city:'New York', state:'NY', zip:'10001']">New York, NY</g:link>
            </div>
            <div class="left" style="width:175px;">
              <g:link mapping="geo" params="[city:'Phoenix', state:'AZ', zip:'85001']">Phoenix, AZ</g:link>
            </div>
            <div class="left" style="width:175px;">
              <g:link mapping="geo" params="[city:'Denver', state:'CO', zip:'80201']">Denver, CO</g:link>
            </div>
            <div class="left" style="width:175px;">
              <g:link mapping="geo" params="[city:'Seattle', state:'WA', zip:'98101']">Seattle, WA</g:link>
            </div>
            <div style="clear:both;"></div>
          </div>
        </div>
        <div style="clear:both;"></div>
      </div>
      <div style="height:100px;"></div>
      <g:render template="/footer_no_analytics" />
      <g:render template="/size_popup" />

      <div id="resultHelp" style="display:none;">
        <div class="resultHelpHeader">
          <div class="helpClose" id="resultHelpClose">
            <div class="left" style="margin-right: 5px; margin-top: 2px;">CLOSE </div>
            <div class="left"><storitz:image style="width:17px;height:16px;vertical-align: middle;" src="popup-checkbox.png" alt="close box"/></div>
          </div>
        </div>
        <div>
          <div class="resultHelpBoxText">
            <div class="helpBoxTextHolder">
              <div class="helpBoxTextTitle">
                Drive-Up
              </div>
              <div class="helpBoxTextBody">
                Means the storage unit door is accessed from a drive aisle.  You park your vehicle in front of the unit and load your stuff. Some large warehouse facilities have indoor drive aisles, so a Drive-Up can be outdoors or indoors.
              </div>
            </div>
          </div>
          <div class="resultHelpBoxSeparator"></div>
          <div class="resultHelpBoxText">
            <div class="helpBoxTextHolder">
              <div class="helpBoxTextTitle">
                Upper
              </div>
              <div class="helpBoxTextBody">
                Many storage facilities have multiple floors. An “Upper” type of unit is on any floor other than the ground floor, which typically means it is on an upper floor and is accessed by a cargo lift or elevator. In some cases, this type of unit may be in a basement.
              </div>
            </div>
          </div>
          <div class="resultHelpBoxSeparator"></div>
          <div class="resultHelpBoxText">
            <div class="helpBoxTextHolder">
              <div class="helpBoxTextTitle">
                Interior
              </div>
              <div class="helpBoxTextBody">
                Larger and urban storage facilities are typically housed in a large warehouse building. An Interior storage unit is on the Ground floor and accessed from inside a building.  Often times, there is a central loading area from the street and into building doors, and then your Interior unit is a short walk from those building doors.
              </div>
            </div>
          </div>
          <div class="resultHelpBoxSeparator"></div>
          <div class="resultHelpBoxText">
            <div class="helpBoxTextHolder">
              <div class="helpBoxTextTitle">
                Climate Control
              </div>
              <div class="helpBoxTextBody">
                Some storage properties offer climate controlled storage unit areas.  The climate controls vary from simple ventilation, to evaporative cooling, all the way to full air conditioning and heating. For inclement locales, Climate Control is useful.
              </div>
            </div>
          </div>
        </div>
        <div style="clear:both;height:5px;"></div>
      </div>

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
