<%@ page import="storitz.constants.PromoType; storitz.constants.UnitType; storitz.constants.TransactionType" %>
<div class="rent_me">
  <div class="price">
    <g:formatNumber number="${unit.bestUnitPrice}" type="currency" currencyCode="USD" />
    <g:if test="${unit.price && unit.price > unit.bestUnitPrice}"><span class="original_price"><g:formatNumber number="${unit.price}" type="currency" currencyCode="USD" /></span></g:if>
    <div class="per_month">per month</div>
  </div>
  <div class="rent_reserve">
    <g:submitButton name="action"
                    value="${(site.transactionType == TransactionType.RESERVATION) ? 'reserve' : 'rent'}"
                    class="rent_me_button" />
    <div class="guarantee">Storitz Price Guarantee</div>
  </div>
  <div class="unit_info">
    <a class="more_sizes" href="#">All sizes</a>
    <h4>
      ${unit.displaySize ? unit.displaySize.replaceAll(/(\d+) X (\d+)/, "\$1' x \$2'") : "??"}
      <g:if test="${unit.unitType == UnitType.INTERIOR}">
        Interior Unit (Ground Floor)
      </g:if>
      <g:elseif test="${unit.unitType == UnitType.DRIVEUP}">
        Drive-Up Unit
      </g:elseif>
      <g:elseif test="${unit.unitType == UnitType.UPPER}">
        Upper Floor Unit
      </g:elseif>
      <g:elseif test="${unit.unitType == UnitType.COVERED}">
        Covered Parking Space
      </g:elseif>
      <g:elseif test="${unit.unitType == UnitType.COVERED}">
        Covered Parking Space
      </g:elseif>
      <g:elseif test="${unit.unitType == UnitType.COVERED}">
        Uncovered Parking Space
      </g:elseif>
      <g:else>
        Unit
      </g:else>
    </h4>
    <div>
      <ul class="amenities">
        <li>Climate Control: <g:formatBoolean boolean="${unit.isTempControlled}" true="Yes" false="No" /></li>
        <li>Resident Manager: <g:formatBoolean boolean="${site.isManagerOnsite}" true="Yes" false="No" /></li>
        <li>Elevator: <g:formatBoolean boolean="${site.hasElevator}" true="Yes" false="No" /></li>
        <li><g:if test="${site.freeTruck == 'FREE'}">Free </g:if><g:elseif test="${site.freeTruck == 'RENTAL'}">Rental </g:elseif>Truck:
        <g:formatBoolean boolean="${site.freeTruck == 'NONE'}" true="No" false="Yes" /></li>
      </ul>
      <ul class="amenities">
        <li>Unit Alarmed: <g:formatBoolean boolean="${unit.isAlarm || site.isUnitAlarmed}" true="Yes" false="No" /></li>
        <li>Gated Entry: <g:formatBoolean boolean="${site.isGate}" true="Yes" false="No" /></li>
        <li>Keypad Entry: <g:formatBoolean boolean="${site.isKeypad}" true="Yes" false="No" /></li>
        <li>Security Cameras: <g:formatBoolean boolean="${site.isCamera}" true="Yes" false="No" /></li>
      </ul>
    </div>
  </div>
  <g:render template="moveInQuote" model="[editable:true, site:site, unit:unit, promo:promo, promos:promos, totals:totals, moveInDate:moveInDate, insurance:insurance]" />
</div>
<g:hiddenField name="siteId" value="${site?.id}" />
<g:hiddenField name="unitId" value="${unit?.id}" />
<g:hiddenField name="moveInDate" value="${formatDate(format:'yyyy-MM-dd', date:moveInDate)}" />
<g:hiddenField name="promoId" value="${promo?.id}" />
<g:hiddenField name="insuranceId" value="${insurance?.id}" />