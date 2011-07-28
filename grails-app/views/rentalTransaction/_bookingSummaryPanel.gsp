<%@ page import="storitz.constants.UnitType" %>
<h1>Your Booking Summary</h1>
<div class="site_info">
  <div class="image_container">
  <g:if test="${site.coverImage()}">
    <img src="${resource(file: site.coverImage()?.mid())}" alt="Image of ${site.title} located in ${site.city}, ${site.state.fullName}"/>
  </g:if>
  <g:elseif test="${site?.logo && site.logo != null}">
    <img src="${resource(file: site.logo.src())}" alt="${site_title} Logo"/>
  </g:elseif>
  </div>
  <h2>${site.title}</h2>
  <p>${site.address}</p>
  <p>${site.city}, ${site.state.display} ${site.zipcode}</p>
  <p class="tel">(877) 456-2929</p>
</div>
%{-- It's possible for unit to be null if we discovered that the unit was unavailable, and then failed to find another unit --}%
<g:if test="${unit != null}">
<div class="unit_info">
  <h4><g:render template="/storageSite/unitSizeLabel" model="[unit:unit]" /></h4>
  <div>
    <ul class="amenities">
      <g:if test="${unit.isTempControlled}"><li>Climate Control</li></g:if>
      <g:if test="${unit.unitType == UnitType.UPPER && site.hasElevator}">Elevator Access</li></g:if>
      <g:if test="${site.freeTruck == 'FREE'}"><li><i>Free Move-In Truck!</i><br />Call to check availability</li></g:if>
      <g:elseif test="${site.freeTruck == 'RENTAL'}"><li>Move-In Truck at Facility</li></g:elseif>
      <g:if test="${unit.isAlarm || site.isUnitAlarmed}"><li>Alarm In Unit </li></g:if>
      <g:if test="${unit.isPowered}"><li>Electrical Outlet</li></g:if>
    </ul>
  </div>
</div>
<g:render template="/storageSite/moveInQuote" model="[site:site, unit:unit, promo:promo, promos:promos, moveInDate:moveInDate, insurance:insurance, totals:totals]" />
<g:hiddenField name="siteId" value="${site.id}" />
<g:hiddenField name="unitId" value="${unit?.id}" />
<g:hiddenField name="moveInDate" value="${formatDate(format:'yyyy-MM-dd', date:moveInDate)}" />
<g:if test="${promo != null}"><g:hiddenField name="promoId" value="${promo.id}" /></g:if>
<g:else><g:hiddenField name="promoId" value="-1" /></g:else>
<g:if test="${insurance != null}"><g:hiddenField name="insuranceId" value="${insurance.id}" /></g:if>
<g:else><g:hiddenField name="insuranceId" value="-1" /></g:else>
</g:if>
