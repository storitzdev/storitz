<h1>Your Booking Summary</h1>
<div class="site_info">
  <div class="image_container">
  <g:if test="${site.coverImage()}">
    <img src="${resource(file: site.coverImage().mid())}" alt="Image of ${site.title} located in ${site.city}, ${site.state.fullName}">
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
<div class="unit_info">
  <h4><g:render template="/storageSite/unitSizeLabel" model="[unit:unit]" /></h4>
  <div>
    <ul class="amenities">
      <li>Climate Control: <g:formatBoolean boolean="${unit.isTempControlled}" true="Yes" false="No" /></li>
      <li>Resident Manager: <g:formatBoolean boolean="${site.isManagerOnsite}" true="Yes" false="No" /></li>
      <li>Elevator: <g:formatBoolean boolean="${site.hasElevator}" true="Yes" false="No" /></li>
      <li><g:if test="${site.freeTruck == 'FREE'}">Free Move-In Truck: Yes </g:if><g:elseif test="${site.freeTruck == 'RENTAL'}">Move-In Truck: Yes</g:elseif><g:else>Move-In Truck: No</g:else></li>
    </ul>
    <ul class="amenities">
      <li>Unit Alarmed: <g:formatBoolean boolean="${unit.isAlarm || site.isUnitAlarmed}" true="Yes" false="No" /></li>
      <li>Gated Entry: <g:formatBoolean boolean="${site.isGate}" true="Yes" false="No" /></li>
      <li>Keypad Entry: <g:formatBoolean boolean="${site.isKeypad}" true="Yes" false="No" /></li>
      <li>Security Cameras: <g:formatBoolean boolean="${site.isCamera}" true="Yes" false="No" /></li>
    </ul>
  </div>
</div>
<g:render template="/storageSite/moveInQuote" model="[site:site, unit:unit, promo:promo, promos:promos, moveInDate:moveInDate, insurance:insurance, totals:totals]" />
<g:hiddenField name="siteId" value="${site.id}" />
<g:hiddenField name="unitId" value="${unit.id}" />
<g:hiddenField name="moveInDate" value="${formatDate(format:'yyyy-MM-dd', date:moveInDate)}" />
<g:if test="${promo != null}"><g:hiddenField name="promoId" value="${promo.id}" /></g:if>
<g:else><g:hiddenField name="promoId" value="-1" /></g:else>
<g:if test="${insurance != null}"><g:hiddenField name="insuranceId" value="${insurance.id}" /></g:if>
<g:else><g:hiddenField name="insuranceId" value="-1" /></g:else>