<%@ page import="storitz.constants.TransactionType" %>
<div class="rent_me">
  <g:render template="unitPrice" model="[unit:unit]" />
  <div class="rent_reserve">
    <g:submitButton name="action"
                    value="${(site.transactionType == TransactionType.RESERVATION) ? 'reserve' : 'rent'}"
                    class="rent_me_button" />
    <div class="guarantee">Storitz Price Guarantee</div>
  </div>
  <div class="unit_info">
    <a class="more_sizes" href="#all_units">See all sizes</a>
    <h4><g:render template="unitSizeLabel" model="[unit:unit]" /></h4>
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
  <g:render template="moveInQuote" model="[site:site, unit:unit, promo:promo, promos:promos, moveInDate:moveInDate, insurance:insurance, totals:totals]" />
</div>
<g:hiddenField name="siteId" value="${site?.id}" />
<g:hiddenField name="unitId" value="${unit?.id}" />
<g:hiddenField name="moveInDate" value="${formatDate(format:'yyyy-MM-dd', date:moveInDate)}" />
<g:hiddenField name="promoId" value="${promo?.id}" />
<g:hiddenField name="insuranceId" value="${insurance?.id}" />