<%@ page import="storitz.constants.UnitType; storitz.constants.TruckType" %>
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN"
    "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" >
    <head>
      <meta name="description" content="Storitz has self storage units, mini storage in ${city}, ${state} ${zip ? 'zip code:' + zip : '' }. Storitz is the smart and easy way to find and rent self-storage, mini-storage, RV storage, wine storage.  Compare and save on your storage rentals." />
      <META name="y_key" content="9a7a338eec8978fd" />
      <g:render template="/header_home" />
      <p:dependantJavascript >
      <script type="text/javascript">
//<![CDATA[
        var urlMapResults = "${createLink(controller:'STMap', action:'mapresults')}";
        var urlUpdateMetro = "${createLink(controller:'home', action:'updateMetro')}";
        var srcDetailButton = ${p.imageLink(src:'details-button.gif')};
        var srcSpecialOffer = ${p.imageLink(src:'special-offer-16px.png')};
        var srcRentMeButton = ${p.imageLink(src:'rent-me-button.png')};
        var srcIconKeypad = ${p.imageLink(src:'icon-keypad-green-20x20.gif')};
        var srcIconCamera = ${p.imageLink(src:'icon-camera-green-20x20.gif')};
        var srcIconGate = ${p.imageLink(src:'icon-gate-green-20x20.gif')};
        var srcIconAlarm = ${p.imageLink(src:'icon-alarm-green-20x20.gif')};
        var srcIconManager = ${p.imageLink(src:'icon-green-mgr20b.gif')};
        var srcIconElevator = ${p.imageLink(src:'icon-green-elevator20.gif')};
        var srcIconTruck = ${p.imageLink(src:'icon-rentaltruck-green-20x20.gif')};
        var srcHome = "${resource(dir:'/') != '/' ? resource(dir:'/') : ''}";
//]]>
      </script>
      <p:javascript src="home"/>
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
        var oldSearchAddr;
        var addressChange = false;
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

          resultTable = $('#stresults').dataTable({
            "aoColumns": [
			  { "sSortDataType": "moveincost", "sType": "numeric", "sWidth":"120px", "sClass":"curvedLeft stClickable" },
              { "sType": "numeric", "bVisible":false },
              { "sSortDataType": "distance", "sType": "numeric", "sWidth":"55px", "sClass":"curvedCenter textCenter" },
              { "bSortable":false, "sWidth":"120px", "sType":"html", "sClass":"curvedCenter stVert stClickable" },
			  { "sSortDataType": "facility", "sType": "string", "sWidth":"190px", "sClass":"curvedCenter stVert stClickable" },
              { "bSortable":false, "sWidth":"150px", "sType":"html", "sClass":"curvedRight stVert stClickable" }
		    ],
            "bAutoWidth":false,
            "bFilter":false,
            "bInfo":false,
            "bJQueryUI":false,
            "bPaginate":false,
            "bSort":false,
            "oLanguage": {
              "sZeroRecords": "Your search did not find any results.  Please change your unit size or resize the map to find new results."
            },
            "oClasses": {
              "sRowEmpty": "stNoResults"
            }
          });
          $('table#stresults thead').children().remove();

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
            site.promoId = ${siteMoveInPrice[site.id]?.promo ? siteMoveInPrice[site.id].promo : 'null' };
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

        }

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
              Find the best prices and locations for self storage, right here.
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
                <div style="margin-left: 35px;">
                  <a href="#results">
                    <storitz:image src="btn-find-it.png" width="108" height="36" border="0" alt="Find Results"/>
                  </a>
                </div>
                <div style="clear: both;height: 15px;"></div>
                <div style="margin-left:35px;">
                  <g:link controller="static" action="guarantee" target="_blank">
                    <storitz:image src="best-price-guarantee.png" width="230" height="70" border="0" alt="Best Price and AnyTime refund guaranteed"/>
                  </g:link>
                </div>
                <div style="clear: both;"></div>
              </form>
            </div>
          </div>
          <div class="leftSection">
            <div class="leftSectionHeader">
              Video
            </div>
            <div class="videoContainer">
              <div id="videoContainer"></div>
            </div>
            <p:dependantJavascript>
            <script type="text/javascript">
                jwplayer("videoContainer").setup({
                    flashplayer: "${resource(file:'/jwplayer/player.swf')}",
                    file: "http://www.youtube.com/watch?v=gtlgDTNRL50",
                    height: 160,
                    width: 282
                });
            </script>
            </p:dependantJavascript>
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

          <div class="resultsBar">
            <div class="sbResults">Search Results</div>
            <div class="sbText">Sort By:</div>
            <div class="sbSortSelect">
              <select id="sbSortSelect" name="sbSortSelect">
                <option value="0" selected="true">Distance (nearest)</option>
                <option value="1">Distance (farthest)</option>
                <option value="2">Move In Cost (lowest)</option>
                <option value="3">Move In Cost (highest)</option>
                <option value="4">Monthly Rate(lowest)</option>
                <option value="5">Monthly Rate (highest)</option>
                <option value="6">Facility Name (A to Z)</option>
                <option value="7">Facility Name (Z to A)</option>
              </select>
            </div>
            <div class="sbSpacer">&nbsp;</div>
            <div class="sbText">Unit Size:</div>
            <a name="results"></a>
            <div class="sbUnitSelect">
              <g:select name="sbUnitsize" id="sbUnitsize" from="${sizeList}" class="inputSelect" value="${params.size}" optionKey="id" optionValue="description"/>
            </div>
          </div>
          <div id="stresults_div">
            <g:if test="${sites.size() > 0}">
              <table id="stresults">
                <thead>
                  <tr>
                  </tr>
                </thead>
                <tbody>
                <g:each var="site" in="${sites}" status="c">
                  <tr>
                    <td class="curvedLeft stClickable">
                      <div style="width: 120px;">
                        <div class="stPrice textCenter"><g:formatNumber number="${siteMoveInPrice[site.id]?.cost}" type="currency" currencyCode="USD"/></div>
                        <div class="stPriceSub textCenter">Paid thru ${siteMoveInPrice[site.id]?.paidThruDate}</div>
                        <div class="stPriceSub textCenter">Taxes &amp; fees included</div>
                        <div class="stRentMe">
                          <g:link mapping="siteLink" params="[city:site.city, state:site.state.display, site_title:site.title, id:site.id, size:params.size, date:params.date, promoId:siteMoveInPrice[site.id]?.promo]">
                            <storitz:image src='rent-me-button.png' width='87' height='31' border='0'/>
                          </g:link>
                        </div>
                        <div class="stPriceSub textCenter monthly">
                          <g:if test="${siteMoveInPrice[site.id]?.monthly > siteMoveInPrice[site.id]?.pushRate}">
                            <span style="text-decoration:line-through;"><g:formatNumber number="${siteMoveInPrice[site.id]?.monthly}" type="currency" currencyCode="USD"/></span>&nbsp;<span class="red"><g:formatNumber number="${siteMoveInPrice[site.id]?.pushRate}" class="red" type="currency" currencyCode="USD"/></span> / MO
                          </g:if>
                          <g:else>
                            <g:formatNumber number="${siteMoveInPrice[site.id]?.monthly}" type="currency" currencyCode="USD"/> / MO
                          </g:else>
                        </div>
                      </div>
                    </td>
                    <td>
                      <g:formatNumber number="${siteMoveInPrice[site.id]?.pushRate}" format="0.00"/>
                    </td>
                    <td>
                      <div style="width:55px;">
                        <div class="left" style="margin-left:10px;">
                          <div id="map_icon${site.id}" class="map_icon">
                            <storitz:image src="${'map_icons/green-loc' + (c  + 1) + '.png'}" width="28" height="35"/>
                          </div>
                          <div class="stDistance"><storitz:calcDistance lat1="${lat}" lat2="${site.lat}" lng1="${lng}" lng2="${site.lng}"/></div>
                          <div class="stMiles">miles</div>
                        </div>
                      </div>
                    </td>
                    <td>
                      <div style="width:120px;">
                        <g:if test="${site?.logo}">
                          <img src="${resource(file:site.logo.src())}" class="stLogo" width="100" height="40" border="0" alt="${site.title} Logo"/>
                        </g:if>
                      </div>
                    </td>
                    <td>
                      <div style="width:190px;">
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
                      </div>
                    </td>
                    <td>
                      <div style="width:150px;">
                        <g:if test="${siteMoveInPrice[site.id]?.promo}">
                          <div class="left" style="width:22px;height:100%;">
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
                          <div class="left" style="width:22px;">&nbsp;</div>
                          <div class="left" style="width:125px;">
                            <div>${siteMoveInPrice[site.id]?.sizeDescription} ${siteMoveInPrice[site.id]?.unitType} unit</div>
                          </div>
                        </g:else>
                      </div>
                    </td>
                  </tr>
                </g:each>

                </tbody>
              </table>
            </g:if>
          </div>
          <div id="metroBox">
            <g:if test="${metro}">
              <div class="wideTextbox">
                <span style="font-weight:bold;">${metro.city}, ${metro.state.display}:</span> ${metro.note}
                <g:if test="${neighborhood}">
                  <div style="height:10px;"></div>
                  <span style="font-weight:bold;">${neighborhood.city}, ${neighborhood.state.display}:</span> ${neighborhood.note}
                </g:if>
                <div style="font-weight:bold;margin:10px 0;">Neighborhoods and Towns:</div>
                <g:each in="${neighborhoodList}" var="n">
                  <div class="left" style="width:150px;">
                    <g:link mapping="geo" params="[city:n.city, state:n.state.display, zip:n.zipcode]">${n.city}</g:link>
                  </div>
                </g:each>
                <div style="clear:both;"></div>
              </div>
            </g:if>
          </div>
          <div class="wideTextbox">
            <div style="font-weight:bold;margin-bottom:10px;">Popular searches:</div>
            <div class="left" style="width:310px;">
              <g:link mapping="metro" params="[city:'Santa Monica', state:'CA']">Santa Monica, CA Storage Units</g:link>
            </div>
            <div class="left" style="width:310px;">
              <g:link mapping="metro" params="[city:'Los Angeles', state:'CA']">Los Angeles, CA Storage Units</g:link>
            </div>
            <div class="left" style="width:310px;">
              <g:link mapping="metro" params="[city:'Irvine', state:'CA']">Irvine, CA Storage Units</g:link>
            </div>
            <div class="left" style="width:310px;">
              <g:link mapping="metro" params="[city:'Long Beach', state:'CA']">Long Beach, CA Storage Units</g:link>
            </div>
            <div class="left" style="width:310px;">
              <g:link mapping="metro" params="[city:'West Hollywood', state:'CA']">West Hollywood, CA Storage Units</g:link>
            </div>
            <div class="left" style="width:310px;">
              <g:link mapping="metro" params="[city:'Van Nuys', state:'CA']">Van Nuys, CA Storage Units</g:link>
            </div>
            <div class="left" style="width:310px;">
              <g:link mapping="metro" params="[city:'Torrance', state:'CA']">Torrance, CA Storage Units</g:link>
            </div>
            <div class="left" style="width:310px;">
              <g:link mapping="metro" params="[city:'Carson', state:'CA']">Carson, CA Storage Units</g:link>
            </div>
            <div class="left" style="width:310px;">
              <g:link mapping="metro" params="[city:'Newport Beach', state:'CA']">Newport Beach, CA Storage Units</g:link>
            </div>
            <div class="left" style="width:310px;">
              <g:link mapping="metro" params="[city:'Oxnard', state:'CA']">Oxnard, CA Storage Units</g:link>
            </div>
            <div class="left" style="width:310px;">
              <g:link mapping="metro" params="[city:'El Segundo', state:'CA']">El Segundo, CA Storage Units</g:link>
            </div>
            <div class="left" style="width:310px;">
              <g:link mapping="metro" params="[city:'Burbank', state:'CA']">Burbank, CA Storage Units</g:link>
            </div>
            <div class="left" style="width:310px;">
              <g:link mapping="metro" params="[city:'San Francisco', state:'CA']">San Francisco, CA Storage Units</g:link>
            </div>
            <div class="left" style="width:310px;">
              <g:link mapping="metro" params="[city:'Palm Desert', state:'CA']">Palm Desert, CA Storage Units</g:link>
            </div>
            <div class="left" style="width:310px;">
              <g:link mapping="metro" params="[city:'Anaheim', state:'CA']">Anaheim, CA Storage Units</g:link>
            </div>
            <div class="left" style="width:310px;">
              <g:link mapping="metro" params="[city:'Lancaster', state:'CA']">Lancaster, CA Storage Units</g:link>
            </div>
            <div class="left" style="width:310px;">
              <g:link mapping="metro" params="[city:'Austin', state:'TX']">Austin, TX Storage Units</g:link>
            </div>
            <div class="left" style="width:310px;">
              <g:link mapping="metro" params="[city:'San Diego', state:'CA']">San Diego Storage Units</g:link>
            </div>
            <div class="left" style="width:310px;">
              <g:link mapping="metro" params="[city:'Dallas', state:'TX']">Dallas, TX Storage Units</g:link>
            </div>
            <div class="left" style="width:310px;">
              <g:link mapping="metro" params="[city:'Houston', state:'TX']">Houston, TX Storage Units</g:link>
            </div>
            <div class="left" style="width:310px;">
              <g:link mapping="metro" params="[city:'Jacksonville', state:'FL']">Jacksonville, FL Storage Units</g:link>
            </div>
            <div class="left" style="width:310px;">
              <g:link mapping="metro" params="[city:'Miami', state:'FL']">Miami, FL Storage Units</g:link>
            </div>
            <div class="left" style="width:310px;">
              <g:link mapping="metro" params="[city:'Clearwater', state:'FL']">Clearwater, FL Storage Units</g:link>
            </div>
            <div class="left" style="width:310px;">
              <g:link mapping="metro" params="[city:'New York', state:'NY']">New York, NY Storage Units</g:link>
            </div>
            <div class="left" style="width:310px;">
              <g:link mapping="metro" params="[city:'Phoenix', state:'AZ']">Phoenix, AZ Storage Units</g:link>
            </div>
            <div class="left" style="width:310px;">
              <g:link mapping="metro" params="[city:'Denver', state:'CO']">Denver, CO Storage Units</g:link>
            </div>
            <div class="left" style="width:310px;">
              <g:link mapping="metro" params="[city:'Seattle', state:'WA']">Seattle, WA Storage Units</g:link>
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
