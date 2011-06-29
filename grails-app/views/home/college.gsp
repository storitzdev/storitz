<%@ page import="storitz.constants.TransactionType; storitz.constants.SearchType; storitz.constants.UnitType; storitz.constants.TruckType" %>
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN"
    "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:fb="http://www.facebook.com/2008/fbml" xml:lang="en">
<head>
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
        <link rel="canonical" href="${createLink(mapping: 'metro2', absolute: true, params: [state: state, city: metro.city.replaceAll(' ', '-')]) as String}"/>
    </g:if>
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
                        { "sSortDataType": "distance", "sType": "numeric", "sWidth":"55px",   "sClass":"curvedCenter textCenter" },
                        { "sSortDataType": "company",  "sType": "html",    "sWidth":"120px",  "sClass":"curvedCenter stVert stClickable" },
                        { "sSortDataType": "facility", "sType": "string",  "sWidth":"190px",  "sClass":"curvedCenter stVert stClickable" },
                        { "sSortDataType": "specials", "sType": "html",    "sWidth":"150px",  "sClass":"curvedRight stVert stClickable" }
                    ],
                    "bAutoWidth":false,
                    "bFilter":false,
                    "bInfo":false,
                    "bJQueryUI":false,
                    "bPaginate":false,
                    "bSort":false,
                    "oLanguage": {
                        "sZeroRecords": "Your search did not find any results."
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
                site.transactionType = '${site.transactionType}';
                site.operatorName = '${site.feed.operatorName}';
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
    </p:dependantJavascript>
    <p:javascript src="college" />
    <script src="http://maps.google.com/maps/api/js?v=3&client=gme-storitz&sensor=false" type="text/javascript"></script>
    <p:css name="college" />
    <style type="text/css">
        #main .text-line{
            background:${cPrBGColor ?: 'wheat'} url(../images/bg-text-line.png) repeat-x;
            height:1%;
            overflow:hidden;
            padding:14px 50px 10px;
            text-align:center;
            color:${cPrFGColor ?: 'blue'};
            letter-spacing:4px;
            text-transform:uppercase;
            font-size:1.3em;
            line-height:1.5em;
            text-shadow:-1px -1px 1px #000;
            margin:0 0 3px;
        }
        #main .text-line span{
            color:#fff;
        }
        #main .text-line-2C{
            height:25px;
            overflow:hidden;
            padding:5px 220px 0px 205px;
            background:${cScBGColor ?: 'blue'} url(../images/bg-text-line-2.png) repeat-x;
            text-shadow:1px 1px 1px #a1803c;
        }
        #main .main-content .clogo{
            position:absolute;
            top:-67px;
            left:17px;
            width:130px;
            height:131px;
            text-indent:-9999px;
            overflow:hidden;
            background:url(${resource(file: clogo)}) no-repeat;
        }
        #main .main-content .clogo a{
	        display:block;
	        height:100%;
        }
        #main .footer-content .footer-holder{
            background:${cPrBGColor ?: 'wheat'};
            height:1%;
            overflow:hidden;
            padding:18px 24px 22px;
            color:#fff;
            font-size:1.1em;
            line-height:1.4em;
        }
        p.rebate {
            font-size: larger;
        }
        p.rebate a {
            color: #3fac00;
        }
        p.rebate a:hover {
            text-decoration: underline;
        }

    </style>
</head>
<body class="college">

<!-- *********************** -->
<!-- COLLEGE CONTENT [START] -->
<!-- *********************** -->
<div id="wrapper">
    <div id="main">
        <!-- service-border -->
        <div class="service-border">
            <!-- facebook API -->
            <div id="fb-root"></div>
            <script>
                window.fbAsyncInit = function() {
                    FB.init({appId: 'storitz', status: true, cookie: true, xfbml: true});
                };
                (function() {
                    var e = document.createElement('script'); e.async = true;
                    e.src = document.location.protocol + '//connect.facebook.net/en_US/all.js';
                    document.getElementById('fb-root').appendChild(e);
                }());
            </script>
            <!-- AddThis Button BEGIN -->
            <div class="addthis_toolbox addthis_default_style" style="float:right; padding:0; margin:0">
                <a class="addthis_button_facebook_like" fb:like:layout="button_count" style="padding:0; margin:0"></a>
                <a class="addthis_button_tweet" style="padding:0; margin:0"></a>
                <a class="addthis_counter addthis_pill_style" style="padding:0; margin:0"></a>
            </div>
            <script type="text/javascript">var addthis_config = {"data_track_clickback":true};</script>
            <script type="text/javascript" src="http://s7.addthis.com/js/250/addthis_widget.js#pubid=ra-4db86126250eded7"></script>
            <!-- AddThis Button END -->
        </div>
        <!-- main-container -->
        <div class="main-container">
            <!-- visual -->
            <div class="visual">
                <img src="../images/img-15.jpg" alt="image description" width="949" height="268" />
                <!-- text-holder -->
                <div class="text-holder">
                    <h1 class="text-got-a-few-things">Got a few things you don’t want to keep at Mom &amp; Dad’s?</h1>
                    <div class="holder">
                        <!-- alignleft -->
                        <div class="alignleft">
                            <p><a href="http://www.storitz.com">Storitz.com</a> lets you compare 1000s of summer storage units and rent all online with our <g:link controller="static" action="guarantee"><em>Best Price Guarantee</em></g:link>.</p>
                        </div>
                    </div>
                </div>
                <p id="btn-rent" class="btn-rent">Rent online today and get $20! click for details</p>
                <strong class="text-01">Photo by <a href="http://www.collegehumor.com" target="_blank">collegehumor.com</a></strong>
            </div>
            <!-- text-line -->
            <div class="text-line">
                <strong>SELF STORAGE UNITS NEAR <span>${cname ?: 'YOU'}</span></strong>
            </div>
            <!-- text-line-2C -->
            <div class="text-line-2C">
                <ul class="navC">
                    <li id="sbSortByPrice"><a href="javascript:resultTable.fnSort([[1, 'asc']])"><span  style="color:${cScFGColor ?: 'white'};">Price</span></a></li>
                    <li id="sbSortByDistance"><a href="javascript:resultTable.fnSort([[3, 'asc']])"><span  style="color:${cScFGColor ?: 'white'};">Distance</span></a></li>
                    <li id="sbSortByCompany"><a href="javascript:resultTable.fnSort([[4, 'asc']])"><span  style="color:${cScFGColor ?: 'white'};">Company</span></a></li>
                    <li id="sbSortByFacility"><a href="javascript:resultTable.fnSort([[5, 'asc']])"><span  style="color:${cScFGColor ?: 'white'};">Facility</span></a></li>
                </ul>
                <ul class="btn-right">
                    <li id="sbSortBySpecials"><a href="javascript:resultTable.fnSort([[6, 'asc']])"><span  style="color:${cScFGColor ?: 'white'};">Specials</span></a></li>
                </ul>
            </div>
            <!-- main-content -->
            <div class="main-content">
                <strong class="clogo"><a href="#">college logo</a></strong>
                <!-- ******************************* -->
                <!-- RESULTS DISPLAY CONTENT [START] -->
                <!-- ******************************* -->
                <div class="stcontent">
                    <div id="stresults_div">
                        <g:if test="${sites.size() > 0}">
                            <table id="stresults">
                                <tbody>
                                <g:each var="site" in="${sites}" status="c">
                                    <tr>
                                        <g:if test="${session.style == 'monthly'}">
                                            <td class="curvedLeft stClickable">
                                                <div style="width: 120px;">
                                                    <div class="stPrice textCenter">
                                                        <g:if test="${siteMoveInPrice[site.id]?.monthly > siteMoveInPrice[site.id]?.pushRate}">
                                                            <div style="text-decoration:line-through;"><g:formatNumber number="${siteMoveInPrice[site.id]?.monthly}" type="currency" currencyCode="USD"/></div>
                                                            <div class="red"><g:formatNumber number="${siteMoveInPrice[site.id]?.pushRate}" class="red" type="currency" currencyCode="USD"/><span class="stPricePerMonth">/ MO</span></div>
                                                        </g:if>
                                                        <g:else>
                                                            <g:formatNumber number="${siteMoveInPrice[site.id]?.monthly}" type="currency" currencyCode="USD"/><span class="stPricePerMonth">/ MO</span>
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
                                            <div class="stCompany" style="visibility:hidden">${site.feed.operatorName}</div>
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
                                                    <div class="left" style="width:22px;">
                                                        <div class="stSpecialOffers" style="visibility:hidden">ZZZ</div>
                                                    </div>
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
                       <!-- Hiding the map breaks code. Simply push the map off the visible page instead... -->
                        <div id="gmap" style="position:absolute; top:-9999px; left:-9999px; overflow:hidden;">
                            <div id="mapSpinner" class="mapSpinner" style="display:none;"><storitz:image src="ajax-loader.gif" width="32" height="32" border="0"/></div>
                            <div id="mapStatus" class="mapStatus" style="display:none"></div>
                            <div id="map_canvas"></div>
                        </div>
                    </div>
                    <div style="clear:both;"></div>
                </div>
                <!-- ***************************** -->
                <!-- RESULTS DISPLAY CONTENT [END] -->
                <!-- ***************************** -->
            </div>
            <!-- footer-content -->
            <div class="footer-content">
                <div class="footer-holder">
                    <p style="float:right"><g:link class="footer-holder" controller="static" action="terms">Terms of Use</g:link></p>
                </div>
            </div>
        </div>
        <p class="copyright">&copy; 2010-2011 Storitz Inc. All rights reserved. Use of this website signifies your agreement to the Terms of Use and Online Privacy Policy.</p>
    </div>
    <!-- header -->
    <div id="header">
        <div class="nav-holder2"></div>
        <div class="holder">
            <!-- logo -->
            <strong class="logo"><a href="#">Storitz</a></strong>
            <!-- text-holder -->
            <div class="text-holder">
                <strong class="subheading">The Storitz Advantage</strong>
                <strong class="heading">Find and Rent Self Storage right here, right now.</strong>
            </div>
            <a href="#" class="btn-need-assistance">Need Assisstance? (877) 465-29-29</a>
            <form action="#" class="search-form" id="gsearch" method="post">
                <fieldset>
                    <legend class="hidden">search</legend>
                    <input tabindex="10" class="text" type="text" id="address" value="Enter Address or Zip" title="Enter Address or Zip"/>
                    <input tabindex="11" type="submit" class="submit" id="btn-search" value="" title="search submit"/>
                </fieldset>
            </form>
        </div>
    </div>
    <!-- rebate info -->
    <div id="rebate" style="display:none">
        <div>
            <p class="rebate"><strong>How to claim your rebate</strong></p>
            <br/>
            <p class="rebate">In order to receive your $20 rebate, first rent or reserve a storage unit through Storitz.com. After you
            check out, print the <g:link controller="static" class="rebate" action="collegerebate" target="_blank">Storitz College
        Rebate Form.</g:link> Fill it out and mail it, along with a copy of your lease agreement or move-in receipt,
            to the address provided on the Rebate Form.</p>
            <br/>
            <p class="rebate">Then you'll get a check for $20 sent right to you! <strong>Simple!</strong></p>
        </div>
    </div>
</div>
<!-- ********************* -->
<!-- COLLEGE CONTENT [END] -->
<!-- ********************* -->
</body>
<p:renderDependantJavascript/>
</html>
