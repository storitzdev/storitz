<%@ page import="storitz.constants.TransactionType; storitz.constants.SearchType; storitz.constants.UnitType; storitz.constants.TruckType" %>
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN"
    "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head>
<g:if test="${session.style == 'monthly'}">
  <!-- Google Website Optimizer Control Script -->
  <script>
    function utmx_section(){}
    function utmx(){}
    (function(){
      var k='2394730963',d=document,l=d.location,c=d.cookie;
      function f(n){
        if(c){
          var i=c.indexOf(n+'=');
          if(i>-1){
            var j=c.indexOf(';',i);
            return escape(c.substring(i+n.length+1,j<0?c.length:j))
          }
        }
      }
      var x=f('__utmx'),xx=f('__utmxx'),h=l.hash;
      d.write('<sc'+'ript src="'+'http'+(l.protocol=='https:'?'s://ssl':'://www')+'.google-analytics.com'+'/siteopt.js?v=1&utmxkey='+k+'&utmx='+(x?x:'')+'&utmxx='+(xx?xx:'')+'&utmxtime='+new Date().valueOf()+(h?'&utmxhash='+escape(h.substr(1)):'')+'" type="text/javascript" charset="utf-8"></sc'+'ript>')
    })();
  </script>
  <script>utmx("url",'A/B');</script>
  <!-- End of Google Website Optimizer Control Script -->
</g:if>

  <g:if test="${zipSearch}">
    <meta name="description" content="Search, compare and rent self storage units in zip code $zip. Move-in today with the best prices and no Storitz fees. Thousands of units to choose from"/>
  </g:if>
  <g:else>
    <g:if test="${searchCity && searchCity != city}">
      <meta name="description" content="Search, compare and rent self storage units in ${searchCity} near ${city}, ${state}. Move-in today with the best prices and no Storitz fees. Thousands of units to choose"/>
    </g:if>
    <g:else>
      <meta name="description" content="Search, compare and rent self storage units in ${city}, ${state}. Move-in today with the best prices and no Storitz fees. Thousands of units to choose"/>
    </g:else>
  </g:else>
  <g:if test="${metro && !neighborhood}">
    <link rel="canonical" href="${createLink(mapping: 'metro2', absolute:true, params: [state: state, city: metro.city.replaceAll(' ', '-')]) as String}"/>
  </g:if>
  <META name="y_key" content="9a7a338eec8978fd"/>
  <g:render template="/header_home"/>
  <p:dependantJavascript>
    <script type="text/javascript">
      //<![CDATA[
      var urlMapResults = "${createLink(controller:'STMap', action:'mapresults')}";
      var urlUpdateMetro = "${createLink(controller:'home', action:'updateMetro')}";
      var urlGeocode = "${createLink(controller:'home', action:'geoCode')}";
      var urlChangeSearchType = "${createLink(controller:'home', action:'changeSearchType')}";
      var srcDetailButton = ${p.imageLink(src:'details-button.gif')};
      var srcSpecialOffer = ${p.imageLink(src:'special-offer-16px.png')};
      var srcRentMeButton = ${p.imageLink(src:'rent-me-button.png')};
      var srcReserveButton = ${p.imageLink(src:'reserve-button-87x31.png')};
      var srcIconKeypad = ${p.imageLink(src:'icon-keypad-green-20x20.gif')};
      var srcIconCamera = ${p.imageLink(src:'icon-camera-green-20x20.gif')};
      var srcIconGate = ${p.imageLink(src:'icon-gate-green-20x20.gif')};
      var srcIconAlarm = ${p.imageLink(src:'icon-alarm-green-20x20.gif')};
      var srcIconManager = ${p.imageLink(src:'icon-green-mgr20b.gif')};
      var srcIconElevator = ${p.imageLink(src:'icon-green-elevator20.gif')};
      var srcIconTruck = ${p.imageLink(src:'icon-rentaltruck-green-20x20.gif')};
      var srcHome = "${resource(dir:'/') != '/' ? resource(dir:'/') : ''}";
      var displayStyle = "${session.style}";
      //]]>
    </script>
    <p:javascript src="home"/>
    <script type="text/javascript">
      //<![CDATA[
      /*
       Javascript functions for Google Maps, forms and table handling
       */

      var map;
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
      var searchType = '${SearchType.STORAGE}';
      var searchDate;
      var helpFadeout = null;
      var baseURL = '${request.contextPath}';
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
      var zoom = ${zoom};
      var redraw = false;

      <g:each var="size" in="${sizeList}">storageSize[${size.id}] = "${size.description}";
      </g:each>
      <g:each in="${0..25}" var="i">
      srcMarkersGreen[${i}] = ${p.imageLink(src:'map_icons/green-loc' + i + '.png')};
      srcMarkersBlue[${i}] = ${p.imageLink(src:'map_icons/blue-loc' + i + '.png')};
      </g:each>

      function createMap() {
        var iploc = new google.maps.LatLng(searchLat, searchLng);
        var myOptions = {
          zoom: zoom,
          center: iploc,
          scrollwheel: false,
          mapTypeId: google.maps.MapTypeId.ROADMAP,
          navigationControlOptions: {style: google.maps.NavigationControlStyle.DEFAULT}
        };
      <g:each var="i" in="${ (0..25) }">
        markersGreen[${i}] = new google.maps.MarkerImage(${p.imageLink(src:'map_icons/green-loc' + i + '.png')}, null, null, new google.maps.Point(1, 35));
        markersBlue[${i}] = new google.maps.MarkerImage(${p.imageLink(src:'map_icons/blue-loc' + i + '.png')}, null, null, new google.maps.Point(1, 35));
      </g:each>

        map = new google.maps.Map(document.getElementById("map_canvas"), myOptions);

        google.maps.event.addListener(map, 'bounds_changed', redrawMap);
        google.maps.event.addListener(map, 'dragstart', dragStart);
        google.maps.event.addListener(map, 'dragend', dragEnd);

        resultTable = $('#stresults').dataTable({
          "aoColumns": [
            { "bSortable": false, "sWidth":"120px", "sClass":"curvedLeft stClickable" },
            { "sType": "numeric", "bVisible":false },
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
      <g:if test="${c < 20}">
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
        site.transactionType = '${site.transactionType}'
        createMarker(site);
      </g:if>
      </g:each>

      <g:if test="${sites.size() > 20}">
        var statusText = 'Your search found more than 20 results.  Here are the top 20';
      </g:if>
      <g:elseif test="${sites.size() > 1}">
        var statusText = 'Your search found ${sites.size()} results';
      </g:elseif>
      <g:elseif test="${sites.size() == 1}">
        var statusText = 'Your search found 1 result';
      </g:elseif>
      <g:else>
        var statusText = 'Your search found no results';
      </g:else>
        setupIdle();
        $('#mapStatus').html(statusText).fadeIn();
        setupMap();

        if (redraw) {
          redrawMap();
          redraw = false;
        }

      }


      $(window).trigger('hashchange');

      //]]>
    </script>
    <script src="http://maps.google.com/maps/api/js?v=3&client=gme-storitz&sensor=false" type="text/javascript"></script>
    <script type="text/javascript">
      document.write(unescape("%3Cscript src='" + document.location.protocol + "//zopim.com/?OnxU61sHAyKJAixaCrj9vqqwCQ1JzaPN' charset='utf-8' type='text/javascript'%3E%3C/script%3E"));
    </script>
  </p:dependantJavascript>
</head>
<body>
<div id="body">
  <g:render template="/topnav"/>
  <g:render template="/logo_bar"/>
  <div class="stcontent">
    <div style="height: 10px;"></div>
    <div class="leftColumn">
      <div class="leftSection">
        <div>
          <h2 class="inputSectionHeader">Compare storage units. Get the best price. Rent yours today:</h2>
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
            <div class="left" style="margin: 2px 9px 0 0;">
              <storitz:image src="btn-circle-2.png" width="26" height="26" alt="1"/>
            </div>
            <div class="left">
              <input type="radio" name="searchType" checked="checked" value="${SearchType.STORAGE}"/> Self Storage
            &nbsp;
              <input type="radio" name="searchType" value="${SearchType.PARKING}"/> Parking/RV
            </div>
            <div style="clear:both;height: 10px;"></div>
            <div>
              <div class="left" style="margin: 2px 9px 0 0;">
                <storitz:image src="btn-circle-3.png" width="26" height="26" alt="2"/>
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
              <storitz:image src="btn-circle-4.png" width="26" height="26" alt="3"/>
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
            <div class="inputSectionText">
              Why hassle with phone calls and email when you can rent storage right now? Only Storitz lets you search, select, pay, and then print your receipt, contract, and gate code.
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
        <div>
          <h2 class="leftSectionHeader">Video</h2>
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
        <g:link controller="static" action="supports">
          <storitz:image src='hirshberg-banner.gif' width="148" height="57" border="0"/>
        </g:link>
        <g:link controller="static" action="supports">
          <storitz:image src='kure-it-banner.gif' width="148" height="57" border="0"/>
        </g:link>
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
        <div class="sbResults"><h2 class="sbResults">Search Results</h2></div>
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
                <g:if test="${session.style == 'monthly'}">
                  <td class="curvedLeft stClickable">
                    <div style="width: 120px;">
                      <div class="stPrice textCenter">
                        <g:if test="${siteMoveInPrice[site.id]?.monthly > siteMoveInPrice[site.id]?.pushRate}">
                          <div style="text-decoration:line-through;"><g:formatNumber number="${siteMoveInPrice[site.id]?.monthly}" type="currency" currencyCode="USD"/></div>
                          <div class="red"><g:formatNumber number="${siteMoveInPrice[site.id]?.pushRate}" class="red" type="currency" currencyCode="USD"/><span class="stPricePerMonth"> / MO</span></div>
                        </g:if>
                        <g:else>
                          <g:formatNumber number="${siteMoveInPrice[site.id]?.monthly}" type="currency" currencyCode="USD"/><span class="stPricePerMonth"> / MO</span>
                        </g:else>
                      </div>
                      <div class="stRentMe">
                        <g:if test="${params.size || params.date}">
                          <g:if test="${siteMoveInPrice[site.id]?.promo}">
                            <g:link mapping="siteLink2" params="[site_title:site.title.replaceAll(' - ','-').replaceAll(' ','-'), id:site.id, size:params.size, date:params.date, promoId:siteMoveInPrice[site.id]?.promo]">
                              <g:if test="${site.transactionType == TransactionType.RESERVATION}">
                                <storitz:image src='reserve-button-87x31.png' width='87' height='31' border='0'/>
                              </g:if>
                              <g:else>
                                <storitz:image src='rent-me-button.png' width='87' height='31' border='0'/>
                              </g:else>
                            </g:link>
                          </g:if>
                          <g:else>
                            <g:link mapping="siteLink2" params="[site_title:site.title.replaceAll(' - ','-').replaceAll(' ','-'), id:site.id, size:params.size, date:params.date]">
                              <g:if test="${site.transactionType == TransactionType.RESERVATION}">
                                <storitz:image src='reserve-button-87x31.png' width='87' height='31' border='0'/>
                              </g:if>
                              <g:else>
                                <storitz:image src='rent-me-button.png' width='87' height='31' border='0'/>
                              </g:else>
                            </g:link>
                          </g:else>
                        </g:if>
                        <g:else>
                          <g:if test="${siteMoveInPrice[site.id]?.promo}">
                            <g:link mapping="siteLink2" params="[site_title:site.title.replaceAll(' - ','-').replaceAll(' ','-'), id:site.id, promoId:siteMoveInPrice[site.id]?.promo]">
                              <g:if test="${site.transactionType == TransactionType.RESERVATION}">
                                <storitz:image src='reserve-button-87x31.png' width='87' height='31' border='0'/>
                              </g:if>
                              <g:else>
                                <storitz:image src='rent-me-button.png' width='87' height='31' border='0'/>
                              </g:else>
                            </g:link>
                          </g:if>
                          <g:else>
                            <g:link mapping="siteLink2" params="[site_title:site.title.replaceAll(' - ','-').replaceAll(' ','-'), id:site.id]">
                              <g:if test="${site.transactionType == TransactionType.RESERVATION}">
                                <storitz:image src='reserve-button-87x31.png' width='87' height='31' border='0'/>
                              </g:if>
                              <g:else>
                                <storitz:image src='rent-me-button.png' width='87' height='31' border='0'/>
                              </g:else>
                            </g:link>
                          </g:else>
                        </g:else>
                      </div>
                    </div>
                  </td>
                </g:if>
                <g:else>
                  <td class="curvedLeft stClickable">
                    <div style="width: 120px;">
                      <div class="stPrice textCenter"><g:formatNumber number="${siteMoveInPrice[site.id]?.cost}" type="currency" currencyCode="USD"/></div>
                      <div class="stPriceSub textCenter">Paid thru ${siteMoveInPrice[site.id]?.paidThruDate}</div>
                      <div class="stPriceSub textCenter">Taxes &amp; fees included</div>
                      <div class="stRentMe">
                        <g:if test="${params.size || params.date}">
                          <g:if test="${siteMoveInPrice[site.id]?.promo}">
                            <g:link mapping="siteLink2" params="[site_title:site.title.replaceAll(' - ','-').replaceAll(' ','-'), id:site.id, size:params.size, date:params.date, promoId:siteMoveInPrice[site.id]?.promo]">
                              <g:if test="${site.transactionType == TransactionType.RESERVATION}">
                                <storitz:image src='reserve-button-87x31.png' width='87' height='31' border='0'/>
                              </g:if>
                              <g:else>
                                <storitz:image src='rent-me-button.png' width='87' height='31' border='0'/>
                              </g:else>
                            </g:link>
                          </g:if>
                          <g:else>
                            <g:link mapping="siteLink2" params="[site_title:site.title.replaceAll(' - ','-').replaceAll(' ','-'), id:site.id, size:params.size, date:params.date]">
                              <g:if test="${site.transactionType == TransactionType.RESERVATION}">
                                <storitz:image src='reserve-button-87x31.png' width='87' height='31' border='0'/>
                              </g:if>
                              <g:else>
                                <storitz:image src='rent-me-button.png' width='87' height='31' border='0'/>
                              </g:else>
                            </g:link>
                          </g:else>
                        </g:if>
                        <g:else>
                          <g:if test="${siteMoveInPrice[site.id]?.promo}">
                            <g:link mapping="siteLink2" params="[site_title:site.title.replaceAll(' - ','-').replaceAll(' ','-'), id:site.id, promoId:siteMoveInPrice[site.id]?.promo]">
                              <g:if test="${site.transactionType == TransactionType.RESERVATION}">
                                <storitz:image src='reserve-button-87x31.png' width='87' height='31' border='0'/>
                              </g:if>
                              <g:else>
                                <storitz:image src='rent-me-button.png' width='87' height='31' border='0'/>
                              </g:else>
                            </g:link>
                          </g:if>
                          <g:else>
                            <g:link mapping="siteLink2" params="[site_title:site.title.replaceAll(' - ','-').replaceAll(' ','-'), id:site.id]">
                              <g:if test="${site.transactionType == TransactionType.RESERVATION}">
                                <storitz:image src='reserve-button-87x31.png' width='87' height='31' border='0'/>
                              </g:if>
                              <g:else>
                                <storitz:image src='rent-me-button.png' width='87' height='31' border='0'/>
                              </g:else>
                            </g:link>
                          </g:else>
                        </g:else>
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
                </g:else>
                <td>
                  <g:formatNumber number="${siteMoveInPrice[site.id]?.cost}" format="0.00"/>
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
                      <img src="${resource(file: site.logo.src())}" class="stLogo" width="100" height="40" border="0" alt="${site.title} Logo"/>
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
                        <div>${siteMoveInPrice[site.id]?.sizeDescription} ${siteMoveInPrice[site.id]?.unitType} ${searchType == SearchType.PARKING ? 'space' : 'unit'}</div>
                      </div>
                    </g:if>
                    <g:else>
                      <div class="left" style="width:22px;">&nbsp;</div>
                      <div class="left" style="width:125px;">
                        <div>${siteMoveInPrice[site.id]?.sizeDescription} ${siteMoveInPrice[site.id]?.unitType} ${searchType == SearchType.PARKING ? 'space' : 'unit'}</div>
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
            <span style="font-weight:bold;"><h3 class="metro">${metro.city}, ${metro.state.display}:</h3></span> ${metro.note}
            <g:if test="${neighborhood}">
              <div style="height:10px;"></div>
              <span style="font-weight:bold;"><h3 class="metro">${neighborhood.city}, ${neighborhood.state.display}:</h3></span> ${neighborhood.note}
            </g:if>
            <div style="font-weight:bold;margin:10px 0;"><h3 class="metro">Neighborhoods and Towns:</h3></div>
            <g:each in="${neighborhoodList}" var="n">
              <div class="left" style="width:200px;margin-right:8px;">
                <g:link mapping="geo2" params="[city:n.city.replace(' ','-'), state:n.state.display, zip:n.zipcode]">${n.city} self storage</g:link>
              </div>
            </g:each>
            <div style="clear:both;"></div>
          </div>
        </g:if>
      </div>
      <g:render template="/popularSearches"/>
    </div>
    <div style="clear:both;"></div>
  </div>
  <div style="height:100px;"></div>
  <g:render template="/footer_no_analytics"/>
  <g:render template="/size_popup_jquery"/>

</div>
</body>
<p:renderDependantJavascript/>
</html>
