<%@ page import="storitz.constants.UnitType; com.storitz.StoritzUtil; storitz.constants.TransactionType" %>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head>
<title>${title}</title>
<meta name="description" content="Get reviews, photos, videos, maps, hours, directions, current prices &amp; special offers for self storage units at ${site.title}, located at ${StoritzUtil.titleize(site.address)} in ${StoritzUtil.titleize(site.city)}, ${site.state.display}." />
<meta name="keywords" content="${site.title}, ${StoritzUtil.titleize(site.city)}, self storage, mini storage, storage units, self storage units, mini storage units, storage lockers, rv storage, boat storage, military storage, student storage, storage, storitz" />
<link rel="canonical" href="${StoritzUtil.storageSiteCanonicalLink(createLink(mapping: 'detail', absolute: true, params: params) as String)}" />
</head>
<body class="site_detail">
<div class="breadcrumbs">
  <g:link controller="home" action="index">Home</g:link> &gt;
  <g:link controller="seo" action="state" params="[state:StoritzUtil.seoEncode(site.state.fullName)]">${site.state.fullName}</g:link> &gt;
  <g:link mapping="metro2" params="[city:StoritzUtil.seoEncode(site.city), state:site.state.display]">${StoritzUtil.titleize(site.city)}</g:link> &gt;
  <span class="current">${site.title}</span>
</div>
<div class="container_detail">
  <div id="left_panel">
    <div class="vcard">%{-- TODO: vcardify --}%
      <g:if test="${site?.logo}">
        <div class="site_logo"><img src="${resource(file: site.logo.src())}" width="250" height="100" alt="${site.title} Logo"/></div>
      </g:if>
      <div id="site_address">
        <h1 class="title">${site.title}</h1>
        ${StoritzUtil.titleize(site.address)},
        <g:if test="${site.address2}">
          ${StoritzUtil.titleize(site.address2)},
        </g:if>
        ${StoritzUtil.titleize(site.city)}, ${site.state.display} ${site.zipcode}
        <br /><span class="tel">(877)&nbsp;456-2929</span>
        <sec:ifAnyGranted roles="ROLE_CALLCENTER, ROLE_CALLCENTER_ADMIN">
            Direct Phone: ${site.phone}
        </sec:ifAnyGranted>
        <div class="site_features">
            <g:if test="${site.freeTruck  == storitz.constants.TruckType.FREE}">
                <storitz:image src="icon3d-rentaltruck32f.gif" title="Free Move-In Truck Available" />
            </g:if>
            <g:if test="${site.freeTruck  == storitz.constants.TruckType.RENTAL}">
                <storitz:image src="icon3d-rentaltruck32r.gif" title="Move-In Truck Available to Rent" />
            </g:if>
            <g:if test="${site.isGate}">
                <storitz:image src="icon3d-gate32.jpg" title="Gated Entry"/>
            </g:if>
            <g:if test="${site.isKeypad}">
                <storitz:image src="icon3d-keypad32.jpg" title="Keypad Access"/>
            </g:if>
            <g:if test="${site.isCamera}">
                <storitz:image src="icon3d-camera32.jpg" title="Video Security Cameras" />
            </g:if>
            <g:if test="${site.isUnitAlarmed}">
                <storitz:image src="icon3d-alarm32.jpg" title="Units Alarmed"/>
            </g:if>
            <g:if test="${site.isManagerOnsite}">
                <storitz:image src="icon3d-mgr32b.jpg" title="Resident Manager On-site"/>
            </g:if>
            <g:if test="${site.hasElevator}">
                <storitz:image src="icon3d-elevator32.jpg" title="Elevator to Upper Floors"/>
            </g:if>
        </div>
      </div>
    </div>
    <div class="site_info">
      <!-- the tabs -->
      <ul class="tabs">
        <li><a class="current" href="#tab_overview">Overview</a></li>
        <li><a class="current" href="#tab_video">Video</a></li>
        <li><a class="current" href="#tab_maphours" id="display_map" title="${site.title}" lat="${site.lat}" lng="${site.lng}">Map &amp; Hours</a></li>
        <li><a class="current" href="#tab_reviews" id="display_review" lat="${site.lat}" lng="${site.lng}">Reviews</a></li>
        %{--<li><a class="current" href="#tab_auctions">Auctions</a></li>--}%
      </ul>
      <!-- the panes -->
      <div class="panes">
        <div class="overview"><!-- first tab -->
          <h2 class="tab_pane_title">Photos</h2>
          <div class="photos"><!-- more elems inside this div -->
            <g:if test="${site.coverImage()}">
              <img class="main_pic" src="${resource(file: site.coverImage()?.mid())}"
                   alt="Image of ${site.title} located in ${site.city}, ${site.state.fullName}">
            </g:if>
            <g:if test="${site.siteImages().size() > 1}">
                <ul class="image_list">
                    <g:each var="siteImg" in="${site.siteImages()}" status="i">
                        <li>
                            <a href="#" onClick="return false;"><img src="${resource(file: siteImg.src())}" alt="Image of ${site.title} located in ${site.city}, ${site.state.display}" /></a>
                        </li>
                    </g:each>
                </ul>
            </g:if>
          </div>
          <h2 class="tab_pane_title">Description</h2>
          <div class="description">
            <ul class="action_links">
              <li><a class="print" href="#" onclick="window.print();">Print</a></li>
              <li><span class="st_email" displayText="Share"></span></li>
            </ul>
            <div class="yelp_rating">
                <g:if test="${bizTotal > 0}">
                <a href="#tab_reviews"><img src="${review.starUrl}" /></a><span>${review.reviewCount} reviews</span>
                <a class="yelp_logo" href="http://www.yelp.com" target="_blank">Reviews from yelp</a>
                </g:if>
                <g:else><strong>No Reviews</strong></g:else>
            </div>
            <p>
              ${site.description}
            </p>
          </div>
          <div class="site_features">
            <h2>Facility Features &amp; Amenities</h2>
            <table>
              <tr>
                <td>
                  <h3>Safety/Security</h3>
                  <ul>
                    <g:if test="${site.isGate}"><li>Gated Entry</li></g:if>
                    <g:if test="${site.isKeypad}"><li>Keypad Access</li></g:if>
                    <g:if test="${site.isCamera}"><li>Video Security</li></g:if>
                    <g:if test="${site.isUnitAlarmed}"><li>Alarms in Units</li></g:if>
                  </ul>
                </td>
                <g:if test="${site.hasElevator || site.isTwentyFourHour}">
                <td>
                  <h3>Convenience/Access</h3>
                  <ul>
                    <g:if test="${site.hasElevator}"><li>Elevator</li></g:if>
                    <g:if test="${site.isTwentyFourHour}"><li>24-Hour Access</li></g:if>
                  </ul>
                </td>
                </g:if>
                <td>
                  <h3>Amenities</h3>
                  <ul>
                    <g:if test="${site.isManagerOnsite}"><li>Resident Manager On-site</li></g:if>
                    <g:if test="${site.boxesAvailable}"><li>Boxes &amp; Moving Supplies For Sale</li></g:if>
                    <g:if test="${site.freeTruck == storitz.constants.TruckType.FREE}"><li>Free Move-In Truck</li></g:if>
                    <g:elseif test="${site.freeTruck == storitz.constants.TruckType.RENTAL}"><li>Move-In Truck Available to Rent</li></g:elseif>
                  </ul>

                </td>
              </tr>
            </table>
          </div>
          <div class="all_units">
            <g:if test="${availableUnits?.size()}">
            <h2><a name="all_units">Available Units at ${site.title}</a></h2>
            <ul>
              <g:each in="${availableUnits}" var="entry">
              <li class="unit${entry['unit'].unitsize.description.replaceAll(' ', '')}">
                <div class="unit_info">
                  <h3><g:render template="unitSizeLabel" model="[unit:entry['unit'], omitType:true]" /></h3>
                  <ul class="amenities">
                    <g:if test="${entry['unit'].isTempControlled}"><li>Climate Control</li></g:if>
                    <g:if test="${(entry['unit'].unitType == UnitType.UPPER) && site.hasElevator}"><li>Elevator</li></g:if>
                    <g:if test="${entry['unit'].isAlarm || site.isUnitAlarmed}"><li>Alarm in Unit</li></g:if>
                    <g:if test="${entry['unit'].isPowered}"><li>Electrical Outlet</li></g:if>
                  </ul>
                </div>
                <div class="special">${entry['promo']?.promoName}</div>
                <div class="rent_me">
                  <g:form mapping="checkout" method="GET">
                    <g:render template="unitPrice" model="[unit:entry['unit']]" />
                    <g:submitButton name="action"
                                    value="${(site.transactionType == TransactionType.RESERVATION) ? 'reserve' : 'rent'}"
                                    class="${(site.transactionType == TransactionType.RESERVATION) ? 'reserve_me_button' : 'rent_me_button'}" />
                    <g:hiddenField id="xid_${entry['unit'].id}" name="xid" value="${xid}" />
                    <g:hiddenField id="siteId_${entry['unit'].id}" name="siteId" value="${site?.id}" />
                    <g:hiddenField id="unitId_${entry['unit'].id}" name="unitId" value="${entry['unit'].id}" />
                    <g:hiddenField id="moveInDate_${entry['unit'].id}" name="moveInDate" value="${formatDate(format:'yyyy-MM-dd', date:moveInDate)}" />
                    <g:if test="${entry['promo']}">
                      <g:hiddenField id="promoId_${entry['unit'].id}" name="promoId" value="${entry['promo']?.id}" />
                    </g:if>
                    <g:hiddenField id="insuranceId_${entry['unit'].id}" name="insuranceId" value="${insurance?.id}" />
                  </g:form>
                </div>
              </li>
            </g:each>
            </ul>
            </g:if>
          </div>
          <a name="tab_overview">&nbsp;</a>
        </div>

        <div><!-- second tab-->
          <h2 class="tab_pane_title">Video</h2>
            <g:if test="${video}">
                <div id="videoContainer"></div>
                <h3>${video.title}</h3>
                <p:dependantJavascript>
                    <script type="text/javascript">
                        jwplayer("videoContainer").setup({
                                    flashplayer: "${resource(file:'/jwplayer/player.swf')}",
                                    skin: "${resource(file:'/jwplayer/stijl.zip')}",
                                    <g:if test="${video.useYouTube}">
                                    file: "http://www.youtube.com/watch?v=${video.youTubeId}",
                                    </g:if>
                                    <g:else>
                                    file: "${resource(file:video.fileLocation)}",
                                    image: "${resource(file:video.stillImage)}",
                                    </g:else>
                                    height: 300,
                                    width: 580
                                });
                    </script>
                </p:dependantJavascript>
            </g:if>
            <g:else>
                <p class="none">This site has no videos.</p>
            </g:else>
          <a name="tab_video">&nbsp;</a>
        </div>

        <div>
          <h2 class="tab_pane_title">Map, Hours &amp; Directions</h2>
          <g:render template="/directions"/>
          <a name="tab_maphours">&nbsp;</a>
        </div>

        <div>
          <h2 class="tab_pane_title">User Reviews</h2>
          <div id="yelp_reviews">
              <g:if test="${bizTotal > 0}">
                  <h3 class="review_title">Showing ${review.reviews.size()} of ${review.reviewCount} Yelp reviews</h3>
              </g:if>
              <g:else>
                <p class="none">This site has no reviews yet.</p>
              </g:else>
              <ul class="user_reviews">
                  <g:if test="${bizTotal > 0}">
                    <g:each in="${review.reviews}" var="entry" status="i">
                        <li class="review">
                            <img class="revImage" src="${entry.user.image_url}" alt="Reviewer Image" />
                            <h4 class="reviewer">${entry.user.name}</h4>
                            <img class="revRating" src="${entry.rating_image_url}" alt="${entry.rating} stars" />${reviewDates[i]}
                            <p class="revExcerpt">${entry.excerpt}
                            ...<a target="_blank" href="${review.bizUrl}">read more</a>
                            </p>
                        </li>
                    </g:each>
                  </g:if>
              </ul>
              <a class="yelp_logo" href="http://www.yelp.com" target="_blank">Powered by Yelp</a>
              <g:if test="${bizTotal > 0 && review.reviewCount > review.reviews.size()}">
                <a href="#" class="read_more">Read More Reviews From Yelp</a>
              </g:if>
          </div>
          <a name="tab_reviews">&nbsp;</a>
        </div>

        %{--<div>--}%
          %{--<!-- sixth tab-->--}%
          %{--blah blah blah blah blah--}%
          %{--<a name="tab_auctions">&nbsp;</a>--}%
        %{--</div>--}%
      </div>
    </div>
  </div>
  <div id="right_panel">
    <g:form mapping="checkout" method="GET" name="rent_me_form" src="${createLink(mapping:'rentMePanel')}">
      <g:if test="${unit != null}">
      <g:render template="rentMePanel" model="[site:site, unit:unit, promo:promo, promos:promos, moveInDate:moveInDate, totals:totals, xid:xid]"/>
      </g:if>
      <g:else>
      <div class="rent_me" style="padding:30px; background: none">
        <h2 style="font-size: 14pt; font-family: Arial, Helvetica, sans-serif; font-weight: normal; font-style: italic; color: #999;">No units currently available at this facility.</h2>
      </div>
      </g:else>
    </g:form>
    <g:if test="${nearbyUnits?.size() > 0}">
    <div class="sim_units">
      <h1>Similar Units Nearby</h1>
      <ul>
        <li>
          <img src="#" />
          <h2>Pacoima - Glen Oaks Blvd</h2>
          <div class="price">
            $79.00<span>/mo.</span>
          </div>
          <p>5.8 miles from this facility</p>
        </li>
      </ul>
      <div class="units_bottom">
        <a href="#">View More...</a>
      </div>
    </div>
    </g:if>
  </div>
</div>
<div id="datepicker" class="tooltip" style="background-color: white;">
    <div class="close_button">
    <a class="close" href="#">Close X</a>
    </div>
</div>
<p:dependantJavascript>
  <script type="text/javascript">
    var switchTo5x = true; // sharethis hack
    var d=document,l=d.location;
    d.write('<sc'+'ript src="'+'http'+(l.protocol=='https:'?'s://maps-api-ssl':'://maps')+'.google.com'+'/maps/api/js?v=3&client=gme-storitz&sensor=false" type="text/javascript"></sc'+'ript>');
    d.write('<sc'+'ript src="'+'http'+(l.protocol=='https:'?'s://ws':'://w')+'.sharethis.com'+'/button/buttons.js" type="text/javascript"></sc'+'ript>');
    $(document).ready(function() {
      initialize_site_detail_page();
    });
  </script>
</p:dependantJavascript>
</body>
</html>