<%@ page import="storitz.constants.UnitType; storitz.constants.TruckType" %>
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN"
    "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" >
    <head>
      <meta name="Description" content="Storitz Self-Storage search results in ${city}, ${state} ${zip ? 'postal code:' + zip : zip}. Storitz is the smart and easy way to find and rent self-storage, mini-storage, RV storage, wine storage.  Compare and save on your storage rentals." />
      <META name="y_key" content="b6e5ae8512caefa9" />
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
        var srcMarkersGreen = [];
        var srcMarkersBlue = [];
        var mapMarker = null;
        var firstDraw = false;
        var resultTable;
        var savedTableId;

        <g:each var="size" in="${sizeList}">storageSize[${size.id}] = "${size.description}";</g:each>
        <g:each in="${0..25}" var="i">
          srcMarkersGreen[${i}] = ${p.imageLink(src:'map_icons/green-loc' + i + '.png')};
          srcMarkersBlue[${i}] = ${p.imageLink(src:'map_icons/blue-loc' + i + '.png')};
        </g:each>

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
          return baseURL + encodeURIComponent(s.city) + '/' + encodeURIComponent(s.state) + '/' + encodeURIComponent(s.title.replace(city_pat, '')) + '/' + s.id + '?size=' + (searchSize > 1 ? searchSize : '') + '&date=' + getDate() + '&address=' + encodeURIComponent(getAddress());
        }

        function getDate() {
          if ($('#date').val() && !/^Select/.test($('#date').val())) {
            return $('#date').val();
          }
          return '';
        }

        function getAddress() {
          if ($('#address').val() && !/^Enter /.test($('#address').val())) {
            return $('#address').val();
          }
          return '';
        }

        function markerClick(feature) {
          c = $('<div>', { style: 'width:200px;' }).append(
                  $('<div>', { 'class': 'infoWindowTitle' } ).text(feature.title));
            if (feature.coverImg.length > 0) {
              c.append($('<img>', { src:"${resource(dir:'/') != '/' ? resource(dir:'/') : ''}" + feature.coverImg,  alt:feature.title, 'class': 'left'}).css('margin-right', '5px'));
            }
            c.append($('<div>', { 'class':'infoWindowText' })
                    .append($('<div>').text(feature.address))
                    .append($('<div>').text(feature.city + ', ' + feature.state + ' ' + feature.zipcode))
                    .append($('<div>', {'class':'left'}).css('margin-top','5px').append($('<a>', { href: siteLink(feature) })
                    .append($('<img>', { src: ${p.imageLink(src:'details-button.gif')}, width:'55', height:'20', border:'0'  })))));

          feature.marker.setIcon(markersBlue[feature.index]);
          $('#map_icon'+feature.id).html($('<img>', { src:srcMarkersBlue[feature.index], width: 28, height: 35}));
          savedTableId = feature.id;
          if (infoWindow) {
            infoWindow.close();
          }
          if (savedFeature) {
            features[savedFeature].marker.setIcon(markersGreen[features[savedFeature].index]);
          }
          savedFeature = feature.id;
          infoWindow = new google.maps.InfoWindow({content: c.html(), maxWidth: 200});
          google.maps.event.addListener(infoWindow, 'closeclick', function() {
            features[savedFeature].marker.setIcon(markersGreen[features[savedFeature].index]);
            if (savedTableId) {
              $('#map_icon'+savedTableId).html($('<img>', { src:srcMarkersGreen[features[savedTableId].index], width: 28, height: 35}));
            }
          });
          infoWindow.open(map, feature.marker);
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
          $('#mapSpinner').fadeIn();

          $.ajax({
            url: "${createLink(controller:'STMap', action:'mapresults')}",
            method:'get',
            dataType:'json',
            data: {
              searchSize: searchSize,
              date: getDate(),
              lat: searchLat,
              lng: searchLng,        
              swLat: bounds.getSouthWest().lat(),
              swLng: bounds.getSouthWest().lng(),
              neLat: bounds.getNorthEast().lat(),
              neLng: bounds.getNorthEast().lng()
            },
            success:function(ret) {

              var rows = 0;
              var statusText
              if (ret.siteCount >= 20) {
                statusText = 'Your search found more than 20 results.  Here are the top 20';
              } else if (ret.siteCount > 1) {
                statusText = 'Your search found ' + ret.siteCount + ' results';
              } else if (ret.siteCount == 1) {
                statusText = 'Your search found ' + ret.siteCount + ' result';
              } else {
                statusText = 'Your search found no results';
              }
              $('#mapStatus').html(statusText).effect("highlight", {}, 1000);

              resultTable.fnClearTable();

              $.each(features, function(i, f) {
                if (f && f.marker) {
                  f.marker.setMap(null);
                }
              });

              $.each(ret.features, function(i, s) {
                  createMarker(s);
                  createTableRow(s);
              });
              $('table#stresults thead').children().remove();

              setupMap();
            },
            error:function(ret) {
              alert("Something went wrong " + ret);
            }
          });
          $('#mapSpinner').idle(500).fadeOut('slow')
        }

        function createMarker(s) {
          var location = new google.maps.LatLng(s.lat, s.lng);

          features[s.id] = s;
          s.marker = new google.maps.Marker({
            map: map,
            title: s.title,
            position: location,
            icon: savedFeature && savedFeature == s.id ? markersBlue[s.index] : markersGreen[s.index]
          });
          google.maps.event.addListener(s.marker, 'click', function() {
            markerClick(s);
          });
          google.maps.event.addListener(s.marker, 'mouseover', function() {
            var foundRow = $(resultTable.fnGetNodes(s.index - 1));
            if (foundRow) {
              foundRow.addClass('highlightRow');
            }
          });
          google.maps.event.addListener(s.marker, 'mouseout', function() {
            var foundRow = $(resultTable.fnGetNodes(s.index - 1));
            if (foundRow) {
              foundRow.removeClass('highlightRow');
            }
          });
        }

        function createTableRow(s) {

          var logoCol
          if (s.logo.toString().length > 0) {
            logoCol = $('<div>', { 'class': 'left' } ).append($('<img>', { src: s.logo, width:100, height:40, border:0, alt: s.title + ' Logo'}));
          } else {
            logoCol = $('<div>', { 'class': 'left' } )
          }

          var features = $('<div>');
          if (s.isKeypad) {
            features.append($('<img>', { 'class': 'stFeatureIcon tooltip_keypad', src:${p.imageLink(src:'icon-keypad-green-20x20.gif')}, alt:"Keypad", width:20, height:20 }));
          }
          if (s.isCamera) {
            features.append($('<img>', { 'class': 'stFeatureIcon tooltip_camera', src:${p.imageLink(src:'icon-camera-green-20x20.gif')}, alt:"Video Camera", width:20, height:20 }));
          }
          if (s.isGate) {
            features.append($('<img>', { 'class': 'stFeatureIcon tooltip_gate', src:${p.imageLink(src:'icon-gate-green-20x20.gif')}, alt:"Gate", width:20, height:20 }));
          }
          if (s.isUnitAlarmed) {
            features.append($('<img>', { 'class': 'stFeatureIcon tooltip_alarm', src:${p.imageLink(src:'icon-alarm-green-20x20.gif')}, alt:"Unit Alarms", width:20, height:20 }));
          }
          if (s.isManagerOnsite) {
            features.append($('<img>', { 'class': 'stFeatureIcon tooltip_manager', src:${p.imageLink(src:'icon-green-mgr20b.gif')}, alt:"Manager Onsite", width:20, height:20 }));
          }
          if (s.isGate) {
            features.append($('<img>', { 'class': 'stFeatureIcon tooltip_elevator', src:${p.imageLink(src:'icon-green-elevator20.gif')}, alt:"Elevator", width:20, height:20 }));
          }

          switch(s.freeTruck) {
            case "FREE":
              features.append($('<img>', { 'class': 'stFeatureIcon tooltip_truck', src:${p.imageLink(src:'icon-rentaltruck-green-20x20.gif')}, alt:"Free Truck", width:20, height:20 }));
              break;
            case "RENTAL":
              features.append($('<img>', { 'class': 'stFeatureIcon tooltip_truck', src:${p.imageLink(src:'icon-rentaltruck-green-20x20.gif')}, alt:"Rental Truck", width:20, height:20 }));
              break;
          }

          var offersCol = $('<div>');

          if (s.promoId) {
            offersCol
              .append($('<div>', {'class':'left'}).css('width','22px')
                .append($('<img>', { src: ${p.imageLink(src:'special-offer-16px.png')}, alt:'Special Offer checkmark', width:16, height:16})))
              .append($('<div>', {'class':'left'}).css('width','120px')
                .append($('<div>', { 'class': 'stSpecialOffers'}).text(s.promoName ? s.promoName : ''))
                .append($('<div>', { 'class': 'stSpecialOffersSeeMore'}).text('See more offers'))
                .append($('<div>').text((s.sizeDescription ? s.sizeDescription: '') + (s.unitType ? ' ' + s.unitType : '') + ' unit')));
          } else {
            offersCol
              .append($('<div>', {'class':'left'}).css('width','22px').html('&nbsp;'))
              .append($('<div>', {'class':'left'}).css('width','120px')
                .append($('<div>', { 'class': 'stSpecialOffersSeeMore'}).text('See more offers'))
                .append($('<div>').text((s.sizeDescription ? s.sizeDescription: '') + (s.unitType ? ' ' + s.unitType : '') + ' unit')));
          }

          var distanceCol = $('<div>').append($('<div>', { 'class': 'left' }).css('margin-left', '10px')
                      .append($('<div>', { id: 'map_icon'+s.id, 'class':'map_icon'})
                        .append($('<img>', { src: savedTableId && savedTableId == s.id ? srcMarkersBlue[s.index] : srcMarkersGreen[s.index], width: 28, height: 35 })))
                      .append($('<div>', { 'class':'stDistance' }).text(calcDistance(searchLat, s.lat, searchLng, s.lng)))
                      .append($('<div>', { 'class':'stMiles' }).text('miles')));

          var facilityCol = $('<div>').append($('<div>', { 'class':'stTitle' }).text(s.title))
                      .append($('<div>', { 'class': 'left' }).css('margin-left', '5px')
                        .append($('<div>', { 'class':'stAddress' }).text(s.address)))
                    .append($('<div>').css('clear','both'))
                    .append(features);

          var priceCol = $('<div>')
                    .append($('<div>', { 'class':'stPrice textCenter' }).text('$' + (s.moveInCost ? s.moveInCost.toFixed(2) : '')))
                    .append($('<div>', { 'class':'stPriceSub textCenter'}).text('Paid thru ' + (s.paidThruDate ? s.paidThruDate : '')))
                    .append($('<div>', { 'class':'stPriceSub textCenter'}).html('Taxes &amp; fees included'))
                    .append($('<div>', { 'class':'stRentMe' })
                      .append($('<a>', { href: siteLink(s)  + (s.promoId ? '&promoId=' + s.promoId : '') })
                        .append($('<img>', { src: ${p.imageLink(src:'rent-me-button.png')}, width:87, height: 31, border: 0 } ))))
                    .append($('<div>', { 'class':'stPriceSub textCenter'}).text('$' + (s.monthly ? s.monthly.toFixed(2) : '') + ' / MO'));

          resultTable.fnAddData([
            priceCol.html(),
            distanceCol.html(),
            logoCol.html(),
            facilityCol.html(),
            offersCol.html(),
          ]);
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
            site.index = ${c + 1};
            site.unitCount = ${site.units.size()};
            site.coverImg = '${site.coverImage() ? site.coverImage().thumbnail() : ""}';
            site.address = '${site.address}';
            site.zipcode = '${site.zipcode}';
            site.state = '${site.state.display}';
            site.city = '${site.city}';
            createMarker(site);
          </g:each>
          
          <g:if test="${sites.size() > 1}">
            var statusText = 'Your search found ${sites.size()} results';
          </g:if>
          <g:elseif test="${sites.size() == 1}">
            var statusText = 'Your search found 1 result';
          </g:elseif>
          <g:else>
            var statusText = 'Your search found no results';
          </g:else>
          setupIdle();
          $('#mapStatus').html(statusText).fadeIn();

          resultTable = $('#stresults').dataTable({
            "aoColumns": [
			  { "sSortDataType": "moveincost", "sType": "numeric", "sWidth":"120px", "sClass":"curvedLeft" },
              { "sSortDataType": "distance", "sType": "numeric", "sWidth":"55px", "sClass":"curvedCenter" },
              { "bSortable":false, "sWidth":"120px", "sType":"html", "sClass":"curvedCenter stVert" },
			  { "sSortDataType": "facility", "sType": "string", "sWidth":"190px", "sClass":"curvedCenter stVert" },
              { "bSortable":false, "sWidth":"150px", "sType":"html", "sClass":"curvedRight stVert" },
		    ],
            "bAutoWidth":false,
            "bFilter":false,
            "bInfo":false,
            "bJQueryUI":false,
            "bPaginate":false,
            "bSort":false
          });
          $('table#stresults thead').children().remove();
          
        }

        function showAddress(address, size, date) {

          var validAddr = address.length > 4 && !/^Enter /.test(address);

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
                // TODO - update map div with message
                
              }
            });
          }
          getMarkers();
        }

        function setupCalendar() {
          $('#date').datepicker(
                    { dateFormat: 'mm/dd/y',
                      minDate: 0,
                      maxDate: "+2M"
                    }).addTouch();
        }

        function setupHelp() {
          $('#sizeHelp').dialog({
            autoOpen: false,
            resizable: false,
            width: 440
          }).addTouch();
          $('.sizeGuide').click(function(event) {
            $('#sizeHelp').dialog('open');
          });
        }

        function setupForm() {
          $('#address').focus();
          $('#address').keypress(function(event) {
            if (event.keyCode == 13) {
              showAddress(getAddress(), $('#size').val(), getDate());
            }
          });
          $('#address').click(function(event) {
            if (/^Enter /.test($('#address').val())) {
              $('#address').val('');
            }
          });
          $('#size').change(function(event) {
            showAddress(getAddress(), $('#size').val(), getDate());
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

      function setupQtipThemeroller() {
        $.fn.qtip.styles.themeroller = {
          background: null,
          color: null,
          tip: {
            corner: true,
            background: null
          },
          border: {
            width: 5,
            radius: 3
          },
          title: {
            'background': null,
            'fontWeight': null
          },
          classes: {
            tooltip: 'ui-widget',
            tip: 'ui-widget',
            title: 'ui-widget-header',
            content: 'ui-widget-content'
          }
        };

        $('a[title]').qtip({
          position: {
            corner: {
              target: 'rightTop',
              tooltip: 'leftBottom'
            }
          },
          style: {
            name: 'themeroller',
            tip: true
          }
        });
      }

      function setupTooltips() {
        $(".tooltip_keypad").qtip({ content: "Keypad Entry",  position: { corner: { target: 'bottomMiddle', tooltip: 'topMiddle' } },   show: 'mouseover', hide: 'mouseout', style: { name: 'themeroller', tip: true } });
        $(".tooltip_camera").qtip({ content: "Video Camera Security", position: { corner: { target: 'bottomMiddle', tooltip: 'topMiddle' } }, show: 'mouseover', hide: 'mouseout', style: { name: 'themeroller', tip: true } });
        $(".tooltip_gate").qtip({ content: "Security Gate", position: { corner: { target: 'bottomMiddle', tooltip: 'topMiddle' } }, show: 'mouseover', hide: 'mouseout', style: { name: 'themeroller', tip: true } });
        $(".tooltip_alarm").qtip({ content: "Unit level alarms", position: { corner: { target: 'bottomMiddle', tooltip: 'topMiddle' } }, show: 'mouseover', hide: 'mouseout', style: { name: 'themeroller', tip: true } });
        $(".tooltip_truck").qtip({ content: "Move-In Truck Available", position: { corner: { target: 'bottomMiddle', tooltip: 'topMiddle' } }, show: 'mouseover', hide: 'mouseout', style: { name: 'themeroller', tip: true } });
        $(".tooltip_manager").qtip({ content: "Manager Onsite", position: { corner: { target: 'bottomMiddle', tooltip: 'topMiddle' } }, show: 'mouseover', hide: 'mouseout', style: { name: 'themeroller', tip: true } });
        $(".tooltip_elevator").qtip({ content: "Elevator to upper floors", position: { corner: { target: 'bottomMiddle', tooltip: 'topMiddle' } }, show: 'mouseover', hide: 'mouseout', style: { name: 'themeroller', tip: true } });
      }

      function setupIdle() {
        $.fn.idle = function(time){
      	  return this.each(function(){
            var i = $(this);
            i.queue(function(){
              setTimeout(function(){
                i.dequeue();
              }, time);
            });
          });
        };
      }

      function setupTable() {
        /* Create an array with the values of all the input boxes in a column */
        $.fn.dataTableExt.afnSortData['distance'] = function  ( oSettings, iColumn ) {
	      var aData = [];
	      $( 'td:eq('+iColumn+') div.stDistance', oSettings.oApi._fnGetTrNodes(oSettings) ).each( function () {
		    aData.push( $(this).text() );
	      } );
	      return aData;
        }
        $.fn.dataTableExt.afnSortData['facility'] = function  ( oSettings, iColumn ) {
          var aData = [];
          $( 'td:eq('+iColumn+') div.stTitle', oSettings.oApi._fnGetTrNodes(oSettings) ).each( function () {
            aData.push( $(this).text() );
          } );
          return aData;
        }
        $.fn.dataTableExt.afnSortData['moveincost'] = function  ( oSettings, iColumn ) {
          var aData = [];
          $( 'td:eq('+iColumn+') div.stPrice', oSettings.oApi._fnGetTrNodes(oSettings) ).each( function () {
            aData.push( $(this).text().substring(1) );
          } );
          return aData;
        }
      }

      function setupMap() {
        $('.map_icon').click(function(event) {
          var mapId = $(this).attr('id').substring(8);
          $('#map_icon'+mapId).html($('<img>', { src:srcMarkersBlue[features[mapId].index], width: 28, height: 35}));
          if (savedTableId) {
            $('#map_icon'+savedTableId).html($('<img>', { src:srcMarkersGreen[features[savedTableId].index], width: 28, height: 35}));
          }
          markerClick(features[mapId]);
          savedTableId = mapId;
        });
        $('#stresults > tbody > tr').mouseenter(function(event) {
          var mapDiv = $(this).find('.map_icon');
          var mapId = mapDiv.attr('id').substring(8);
          features[mapId].marker.setIcon(markersBlue[features[mapId].index]);
        });
        $('#stresults > tbody > tr').mouseleave(function(event) {
          var mapDiv = $(this).find('.map_icon');
          var mapId = mapDiv.attr('id').substring(8);
          if (!savedTableId || savedTableId != mapId) {
            features[mapId].marker.setIcon(markersGreen[features[mapId].index]);
          }
        });
      }

      var _gaq = _gaq || [];
      _gaq.push(['_setAccount', 'UA-16012579-1']);
      _gaq.push(['_trackPageview']);

      $(document).ready(function() {

        setupCalendar();
        setupHelp();
        setupForm();
        setupQtipThemeroller();
        setupIdle();
        setupTooltips();
        setupTable();
        setupMap();
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
              Find the best prices and locations for self storage right here.
            </div>
            <div style="height: 5px;"></div>
            <div>
              <form id="gsearch" action="" method="post">
                <div class="left" style="margin: 2px 9px 0 0;">
                  <storitz:image src="btn-circle-1.png" width="26" height="26" alt="1"/>
                </div>
                <div class="left">
                  <input type="text" name="address" id="address" class="inputBox" value="${params.address ? params.address : 'Enter address or zip code'}"/>
                </div>
                <div style="clear:both;height: 10px;"></div>
                <div>
                  <div class="left" style="margin: 2px 9px 0 0;">
                    <storitz:image src="btn-circle-2.png" width="26" height="26" alt="2"/>
                  </div>
                  <div class="left">
                    <g:select name="size" id="size" from="${sizeList}" class="inputSelect" value="${params.size}" optionKey="id" optionValue="description"/>
                  </div>
                  <div class="left sizeGuide">
                    size guide
                  </div>
                  <div style="clear: both;"></div>
                </div>
                <div style="height: 10px;"></div>
                <div class="left" style="margin: 2px 9px 0 0;">
                  <storitz:image src="btn-circle-3.png" width="26" height="26" alt="3"/>
                </div>
                <div class="left">
                  <input type="text" id="date" class="inputBox dateInput" value="${params.date ? params.date : 'Select move-in date'}"/>
                </div>
                <div style="clear: both;height: 15px;"></div>
                <div style="margin-left:35px;">
                  <storitz:image src="best-price-guarantee.png" width="230" height="70" alt="Best Price and AnyTime refund guaranteed"/>
                </div>
                <div style="clear: both;"></div>
              </form>
            </div>
          </div>
          <div class="leftSection">
            <div class="leftSectionHeader">
              Video
            </div>
            <div id="videoContainer"></div>
            <script type="text/javascript">
                jwplayer("videoContainer").setup({
                    flashplayer: "${resource(file:'/jwplayer/player.swf')}",
                    file: "http://www.youtube.com/watch?v=w815nn8ypt0",
                    height: 166,
                    width: 300
                });
            </script>
          </div>
          <div>
            <div class="leftSectionHeader">
              Storitz Supports
            </div>
            <a href="http://www.pancreatic.org/" target="_blank">
              <storitz:image src='hirshberg-banner.gif' width="148" height="57" border="0"/>
            </a>
            <a href="http://www.kureit.org/" target="_blank">
              <storitz:image src='kure-it-banner.gif' width="148" height="57" border="0"/>
            </a>
          </div>
        </div>
        <div class="rightColumn">
          <div id="gmap">
            <div id="mapSpinner" class="mapSpinner" style="display:none;"><storitz:image src="ajax-loader.gif" width="32" height="32" border="0"/></div>
            <div id="mapStatus" class="mapStatus" style="display:none"></div>
            <div id="map_canvas">
            </div>
          </div>

          <div class="resultsBar"></div>
          <div id="stresults_div">
            <g:if test="${sites.size() > 0}">
              <table id="stresults">
                <thead>
                </thead>
                <tbody>
                <g:each var="site" in="${sites}" status="c">
                  <tr>
                    <td class="curvedLeft">
                      <div class="stPrice textCenter"><g:formatNumber number="${siteMoveInPrice[site.id]?.cost}" type="currency" currencyCode="USD"/></div>
                      <div class="stPriceSub textCenter">Paid thru ${siteMoveInPrice[site.id]?.paidThruDate}</div>
                      <div class="stPriceSub textCenter">Taxes &amp; fees included</div>
                      <div class="stRentMe">
                        <g:link mapping="siteLink" params="[city:site.city, state:site.state.display, site_title:site.title, id:site.id, size:params.size, date:params.date, promoId:siteMoveInPrice[site.id]?.promo]">
                          <storitz:image src='rent-me-button.png' width='87' height='31' border='0'/>
                        </g:link>
                      </div>
                      <div class="stPriceSub textCenter"><g:formatNumber number="${siteMoveInPrice[site.id]?.monthly}" type="currency" currencyCode="USD"/> / MO </div>
                    </td>
                    <td class="curvedCenter textCenter">
                      <div class="left" style="margin-left:10px;">
                        <div id="map_icon${site.id}" class="map_icon">
                          <storitz:image src="${'map_icons/green-loc' + (c  + 1) + '.png'}" width="28" height="35"/>
                        </div>
                        <div class="stDistance"><storitz:calcDistance lat1="${lat}" lat2="${site.lat}" lng1="${lng}" lng2="${site.lng}"/></div>
                        <div class="stMiles">miles</div>
                      </div>
                    </td>
                    <td class="curvedCenter stVert">
                      <g:if test="${site?.logo}">
                        <img src="${resource(file:site.logo.src())}" width="100" height="40" border="0" alt="${site.title} Logo"/>
                      </g:if>
                    </td>
                    <td class="curvedCenter stVert">
                      <div class="stTitle">${site.title}</div>
                      <div class="left" style="margin-left: 5px;">
                        <div class="stAddress">${site.address}</div>
                      </div>
                      <div style="clear:both;"></div>
                      <div>
                        <g:if test="${site.isKeypad}">
                          <storitz:image class="pointer tooltip_keypad" src="icon-keypad-green-20x20.gif" style="vertical-align: middle; margin: 1px; width:20px; height:20px;" alt="Keypad"/>
                        </g:if>
                        <g:if test="${site.isCamera}">
                          <storitz:image class="pointer tooltip_camera" src="icon-camera-green-20x20.gif" style="vertical-align: middle; margin: 1px; width:20px; height:20px;" alt="Camera"/>
                        </g:if>
                        <g:if test="${site.isGate}">
                          <storitz:image class="pointer tooltip_gate" src="icon-gate-green-20x20.gif" style="vertical-align: middle; margin: 1px; width:20px; height:20px;" alt="Gate"/>
                        </g:if>
                        <g:if test="${site.isUnitAlarmed}">
                          <storitz:image class="pointer tooltip_alarm" src="icon-alarm-green-20x20.gif" style="vertical-align: middle; margin: 1px; width:20px; height:20px;" alt="Alarm"/>
                        </g:if>
                        <g:if test="${site.isManagerOnsite}">
                          <storitz:image class="pointer tooltip_manager" src="icon-green-mgr20b.gif" style="vertical-align: middle; margin: 1px; width:20px; height:20px;" alt="Manager Onsite"/>
                        </g:if>
                        <g:if test="${site.hasElevator}">
                          <storitz:image class="pointer tooltip_elevator" src="icon-green-elevator20.gif" style="vertical-align: middle; margin: 1px; width:20px; height:20px;" alt="Elevator"/>
                        </g:if>
                        <g:if test="${site.freeTruck == TruckType.FREE || site.freeTruck == TruckType.RENTAL}">
                          <storitz:image class="pointer tooltip_truck" src="icon-rentaltruck-green-20x20.gif" style="vertical-align: middle; margin: 1px; width:20px; height:20px;" alt="Elevator"/>
                        </g:if>
                      </div>
                    </td>
                    <td class="curvedRight stVert">
                      <g:if test="${siteMoveInPrice[site.id]?.promo}">
                        <div class="left" style="width:22px;">
                          <storitz:image src="special-offer-16px.png" width="16" height="16px" border="0"/>
                        </div>
                        <div class="left" style="width:120px;">
                          <div class="stSpecialOffers">
                            ${siteMoveInPrice[site.id]?.promoName}
                          </div>
                          <div class="stSpecialOffersSeeMore">See more offers</div>
                          <div>${siteMoveInPrice[site.id]?.sizeDescription} ${siteMoveInPrice[site.id]?.unitType} unit</div>
                        </div>
                      </g:if>
                      <g:else>
                        <div class="left" style="width:22px;"></div>
                        <div class="left" style="width:120px;">
                          <div>${siteMoveInPrice[site.id]?.sizeDescription} ${siteMoveInPrice[site.id]?.unitType} unit</div>
                        </div>
                      </g:else> 
                    </td>
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
      <g:render template="/size_popup_jquery" />

    </div>
    </body>
    <p:dependantJavascript>
      <script type="text/javascript" src="http://www.google.com/jsapi?autoload=%7B%22modules%22%3A%5B%7B%22name%22%3A%22maps%22%2C%22version%22%3A%223.x%22%2Cother_params%3A%22sensor%3Dfalse%22%2C%22callback%22%3A%22createMap%22%7D%2C%7B%22name%22%3A%22gdata%22%2C%22version%22%3A%222.x%22%2C%22packages%22%3A%5B%22maps%22%5D%7D%5D%7D&amp;key=ABQIAAAAEDNru_s_vCsZdWplqCj4hxSjGMYCLTKEQ0TzQvUUxxIh1qVrLhTUMUuVByc3xGunRlZ-4Jv6pHfFHA"></script>
    </p:dependantJavascript>
    <p:renderDependantJavascript />
</html>
