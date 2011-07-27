<%@ page import="storitz.constants.UnitType; storitz.constants.TransactionType" %>
<div class="rent_me">
  <g:render template="unitPrice" model="[unit:unit]" />
  <div class="rent_reserve">
    <g:submitButton name="action"
                    value="${(site.transactionType == TransactionType.RESERVATION) ? 'reserve' : 'rent'}"
                    class="${(site.transactionType == TransactionType.RESERVATION) ? 'reserve_me_button' : 'rent_me_button'}" />
    <div class="guarantee">Storitz Price Guarantee</div>
  </div>
  <div class="unit_info">
    <a class="more_sizes" href="#all_units">See all sizes</a>
    <h4><g:render template="unitSizeLabel" model="[unit:unit]" /></h4>
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
  <g:render template="moveInQuote" model="[site:site, unit:unit, promo:promo, promos:promos, moveInDate:moveInDate, insurance:insurance, totals:totals]" />
</div>
<g:hiddenField name="xid" value="${xid}" />
<g:hiddenField name="siteId" value="${site?.id}" />
<g:hiddenField name="unitId" value="${unit?.id}" />
<g:hiddenField name="moveInDate" value="${formatDate(format:'yyyy-MM-dd', date:moveInDate)}" />
<g:hiddenField name="promoId" value="${promo?.id}" />
<g:hiddenField name="insuranceId" value="${insurance?.id}" />