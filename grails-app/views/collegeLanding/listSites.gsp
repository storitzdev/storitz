<%@ page import="storitz.constants.TransactionType; storitz.constants.SearchType; storitz.constants.UnitType; storitz.constants.TruckType" %>
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN"
    "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:fb="http://www.facebook.com/2008/fbml" xml:lang="en">
<head>
    <g:render template="/header_college"/>
    <script type="text/javascript">
      var _gaq = _gaq || [];
        _gaq.push(["_setCustomVar", 1, "nresults", "${sites.size}"]);
        // TODO: track additional properties of result set: closest result, avg distance, # results w/in 2/5/10 mi, etc.
    </script>
    <style type="text/css">
        h1 {
            color:${college.primaryFGColor ?: 'blue'};
            background:${college.primaryBGColor ?: 'wheat'} url(../images/bg-text-line.png) repeat-x;
        }
        #secondary-color {
            display: block;
            background:${college.secondaryBGColor ?: 'blue'} url(../images/bg-text-line-2.png) repeat-x;
        }
        #footer {
            background:${college.primaryBGColor ?: 'wheat'};
        }
        #college_logo {
            background: url(${resource(file: college.logoBaseName + college.logoFileLoc)}) no-repeat;
        }
    </style>
</head>
<body class="college">
<div id="promo">
    <storitz:image src="img-15.jpg" alt="image description" width="949" height="268" />
    <p class="tagline">Got a few things you don’t want to keep at Mom &amp; Dad’s?</p>
    <p><a href="http://www.storitz.com">Storitz.com</a> lets you compare 1000s of
    summer storage units and rent all online with our
    <g:link controller="static" action="guarantee"><em>Best Price
    Guarantee</em></g:link>.</p>
    <p><a href="#" id="rebate_tile">Rent your storage unit online today from
    storitz.com and get $20 cash back! Click for details</a></p>
    <div class="photo_credit">Photo by <a href="http://www.collegehumor.com" target="_blank">collegehumor.com</a></div>
</div>
<div id="main_container">
    <div id="college_logo">&nbsp;</div>
    <h1>Self Storage Units Near <span class="college_name">${college.displayName}</span></h1>
    <div id="secondary-color">
        <a class="button small black" href="#map-view" id="toggle_map_view">Map View</a>
    </div>
    <div id="rebate_panel">
        <storitz:image src="rebate20-header-large.png" width="749" height="63" />
        <dl>
            <dt>How to Claim Your Rebate</dt>
            <dd>Once you rent or reserve a storage unit, you'll receive an email from us with a link
            to your rebate form &amp; instructions for sending it to us! Simple!</dd>
        </dl>
        <a class="close button">Close</a>
    </div>
    <g:link action="storageTips" elementId="college_tips_button">Storage 101: College Summer Storage Tips for Students</g:link>
    <div id="college_tips_panel">
      <a class="close" href="#">Close</a>
      <iframe src="<g:createLink action="storageTips" params="[layout:'min']" />"></iframe>
    </div>
    <g:if test="${sites.size() > 0}">
        <div id="big_map_canvas"></div>
        <ul id="search_result_labels">
            <li class="photo">&nbsp;</li>
            <li class="facility">Facility</li>
            <li class="unit_info">Unit Type <a href="#">filter</a></li>
            <li class="special">Student Special</li>
            <li class="price">Price</li>
            <li class="rent_button"></li>
        </ul>
        <ul id="search_results">
            <g:each var="site" in="${sites}" status="c">
                <li class="line" id="site_${site.id}">
                    <div class="photo cell">
                        <g:if test="${site.coverImage()}">
                          <div class="thumb_frame">
                            <img class="thumb" src="${resource(file: site.coverImage().mid())}" alt="Image of ${site.title} located in ${site.city}, ${site.state.fullName}">
                          </div>
                        </g:if>
                        <g:elseif test="${site?.logo && site.logo != null}">
                            <img class="logo" src="${resource(file: site.logo.src())}" border="0" alt="${site.title} Logo"/>
                        </g:elseif>
                        <g:else>
                            &nbsp;
                        </g:else>
                    </div>
                    <div class="facility cell" site_id="${site.id}" lat="${site.lat}" lng="${site.lng}">
                        <g:link mapping="siteLink2" class="name" params="[site_title:site.title.replaceAll(' - ','-').replaceAll(' ','-'), id:site.id, promoId:siteMoveInPrice[site.id]?.promo]">
                            ${site.title}
                        </g:link>
                        <div class="street address"><span>${site.address}</span><span class="show_map_popup"> (<a href="#">show map</a>)</span></div>
                        <div class="distance"><storitz:calcDistance lat1="${lat}" lat2="${site.lat}" lng1="${lng}" lng2="${site.lng}"/> miles</div>
                    </div>
                    <div class="unit_info cell">
                        <div class="dimensions">${siteMoveInPrice[site.id]?.sizeDescription.replaceAll(/(\d+) X (\d+)/, "\$1' x \$2' Unit")}</div>
                        <div class="location">${siteMoveInPrice[site.id]?.unitType}</div>
                        <ul>
                            <g:if test="${siteMoveInPrice[site.id]?.isTempControlled}"><li>Climate control</li></g:if>
                            <g:if test="${site.isKeypad}"><li>Keypad access</li></g:if>
                            <g:if test="${site.isCamera}"><li>Security cameras</li></g:if>
                            <g:if test="${site.isGate}"><li>Gated property</li></g:if>
                            <g:if test="${site.isUnitAlarmed}"><li>Alarm in unit</li></g:if>
                            <g:if test="${site.isManagerOnsite}"><li>On-Site manager</li></g:if>
                            <g:if test="${site.hasElevator}"><li>Elevator access</li></g:if>
                            <g:if test="${site.freeTruck == TruckType.FREE || site.freeTruck == TruckType.RENTAL}"><li>Free truck!</li></g:if>
                        </ul>
                    </div>
                    <div class="special cell">
                        <g:if test="${siteMoveInPrice[site.id]?.promo}">
                            ${siteMoveInPrice[site.id]?.promoName}
                        </g:if>
                        <g:else>
                            &nbsp;
                        </g:else>
                    </div>
                    <div class="price cell">
                        <div class="your_price"><g:formatNumber number="${siteMoveInPrice[site.id]?.yourPrice}" type="currency" currencyCode="USD"/></div>
                        <g:if test="$siteMoveInPrice[site.id].listPrice">
                            <div class="list_price"><g:formatNumber number="${siteMoveInPrice[site.id]?.listPrice }" type="currency" currencyCode="USD"/></div>
                        </g:if>
                        <div>per month</div>
                    </div>
                    <div class="rent_button cell">
                        <g:if test="${siteMoveInPrice[site.id]?.promo}">
                            <g:link mapping="siteLink2" params="[site_title:site.title.replaceAll(' - ','-').replaceAll(' ','-'), id:site.id, promoId:siteMoveInPrice[site.id]?.promo]">
                                <storitz:image src='btn-rent-me-120x44.png' width='120' height='44' border='0'/>
                            </g:link>
                        </g:if>
                        <g:else>
                            <g:link mapping="siteLink2" params="[site_title:site.title.replaceAll(' - ','-').replaceAll(' ','-'), id:site.id]">
                                <storitz:image src='btn-rent-me-120x44.png' width='120' height='44' border='0'/>
                            </g:link>
                        </g:else>
                    </div>
                    <g:if test="${isAdmin}">
                        <div class="admin_strip">
                            <span class="operator_name">Operator: ${site.feed.operatorName}</span>
                            <g:link controller="storageSite" action="edit" id="${site.id}" class="button white small" fragment="special_offers" target="_blank">specials</g:link>
                        </div>
                    </g:if>
                </li>
            </g:each>
        </ul>
    </g:if>
</div>
<div id="header">
    <strong class="logo"><a href="listSites.gsp#">Storitz</a></strong>
    <div class="text-holder">
        <strong class="subheading">The Storitz Advantage</strong>
        <strong class="heading">Find and Rent Self Storage right here, right now.</strong>
    </div>
    <a href="listSites.gsp#" class="btn-need-assistance">Need Assistance? (877) 465-29-29</a>
    <form action="listSites.gsp#" class="search-form" id="gsearch" method="post">
        <fieldset>
            <legend>search</legend>
            <input tabindex="10" class="text" type="text" id="address" value="Enter Address or Zip" title="Enter Address or Zip"/>
            <input tabindex="11" type="submit" class="submit" id="btn-search" value="" title="search submit"/>
        </fieldset>
    </form>
</div>
<div id="map_popup" class="tooltip">
    <a class="close button small black">close</a>
    <p>1234 Main St.</p>
    <div id="maplet_canvas" style="width:320px; height:320px"></div>
</div>
<div id="footer">
    <p class="copyright">
    &copy; 2010-2011 Storitz Inc. All rights reserved.
    Use of this website signifies your agreement to the <g:link controller="static" action="terms">Terms of Use</g:link> and
    Online Privacy Policy.</p>
</div>
</body>
</html>
