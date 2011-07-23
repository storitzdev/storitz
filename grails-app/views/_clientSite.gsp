<%@ page import="storitz.constants.TransactionType; com.storitz.StoritzUtil; storitz.constants.TruckType" %>
<%
    // TODO: More inline copy/paste urlencoding... move to DB :(
    String site_title = StoritzUtil.seoEncode(site.title);
    def site_url_params = [site_title:site_title, id:site.id];
      if (unitInfo?.promo) {
        site_url_params['promoId']=unitInfo.promo;
      }
      if (unitInfo?.bestUnit) {
        site_url_params['bestUnit']=unitInfo.bestUnit.id;
      }

%>
<div class="photo">
    <g:if test="${site.coverImage()}">
      <div class="thumb_frame">
        <g:link mapping='siteLink2' class="name" params="${site_url_params}"><img class="thumb" src="${resource(file: site.coverImage()?.mid())}"
             alt="Image of ${site.title} located in ${site.city}, ${site.state.fullName}"></g:link>
      </div>
    </g:if>
    <g:elseif test="${site?.logo && site.logo != null}">
        <g:link mapping='siteLink2' class="name" params="${site_url_params}"><img class="logo" src="${resource(file: site.logo.src())}" border="0" alt="${site_title} Logo"/></g:link>
    </g:elseif>
    <g:else>
        &nbsp;
    </g:else>
</div>
<div class="facility" site_id="${site.id}" lat="${site.lat}" lng="${site.lng}" addr="${site.address}" city="${site.city}" state="${site.state.display}" zip="${site.zipcode}" price="${unitInfo?.yourPrice}" pic="${resource(file: site.coverImage()?.mid())}">
    <g:link mapping='siteLink2' class="name" params="${site_url_params}">${site.title}</g:link>
    <div class="street address">
        <span>${site.address}</span>
        <span class="show_map_popup">(<a href="#">show map</a>)</span>
    </div>
    <div class="distance">
        <storitz:calcDistance lat1="${lat}" lat2="${site.lat}" lng1="${lng}" lng2="${site.lng}"/> miles
    </div>
</div>
<g:if test="${unitInfo != null}">
<div class="unit_info">
    <div class="dimensions">${unitInfo?.sizeDescription?.replaceAll(/(\d+) X (\d+)/, "\$1' x \$2' Unit")}</div>
    <div class="location">${unitInfo?.unitType}</div>
    <ul class="site_features">
        <g:if test="${unitInfo?.isTempControlled}"><li>Climate control</li></g:if>
        <g:if test="${site.isKeypad}"><li>Keypad access</li></g:if>
        <g:if test="${site.isCamera}"><li>Security cameras</li></g:if>
        <g:if test="${site.isGate}"><li>Gated property</li></g:if>
        <g:if test="${site.isUnitAlarmed}"><li>Alarm in unit</li></g:if>
        <g:if test="${site.isManagerOnsite}"><li>On-Site manager</li></g:if>
        <g:if test="${site.hasElevator}"><li>Elevator access</li></g:if>
        <g:if test="${site.freeTruck == TruckType.FREE || site.freeTruck == TruckType.RENTAL}"><li>Free truck!</li></g:if>
    </ul>
</div>
<div class="special">
    <g:if test="${unitInfo?.promo}">
        ${unitInfo?.promoName}
    </g:if>
    <g:else>
        &nbsp;
    </g:else>
</div>
<div class="rent_me">
    <div class="your_price">
        <g:formatNumber number="${unitInfo?.yourPrice}" type="currency" currencyCode="USD"/>
    </div>
    <g:if test="$unitInfo?.listPrice">
        <div class="list_price">
            <g:formatNumber number="${unitInfo?.listPrice }" type="currency" currencyCode="USD"/>
        </div>
    </g:if>
    <div class="permonth">per month</div>
    <g:link mapping='siteLink2' class="name" params="${site_url_params}">Rent Me!</g:link>
</div>
</g:if>
<g:else>
<div class="unit_info">
    <div class="unavailable">No Units Available</div>
    <ul class="site_features">
        <g:if test="${site.isKeypad}"><li>Keypad access</li></g:if>
        <g:if test="${site.isCamera}"><li>Security cameras</li></g:if>
        <g:if test="${site.isGate}"><li>Gated property</li></g:if>
        <g:if test="${site.isUnitAlarmed}"><li>Alarm in unit</li></g:if>
        <g:if test="${site.isManagerOnsite}"><li>On-Site manager</li></g:if>
        <g:if test="${site.hasElevator}"><li>Elevator access</li></g:if>
        <g:if test="${site.freeTruck == TruckType.FREE || site.freeTruck == TruckType.RENTAL}"><li>Free truck!</li></g:if>
    </ul>
</div>
<div class="special">&nbsp;</div>
<div class="rent_me">&nbsp;</div>
</g:else>