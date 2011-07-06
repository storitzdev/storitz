<%@ page import="storitz.constants.TransactionType" %>
<div class="rent_me">
  <div class="price">
    $72.00 <span class="original_price">$80</span>
    <div class="per_month">per month</div>
  </div>
  <div class="rent_reserve">
    <g:submitButton name="submit"
                    value="${(site.transactionType == TransactionType.RESERVATION) ? "Reserve Now!" : "Rent Me!"}"
                    class="rent_me_button" mapping="checkout" />
    <div class="guarantee">Storitz Price Guarantee</div>
  </div>
  <div class="unit_info">
    <a class="more_sizes" href="#">All sizes</a>
    <h4>${unit.displaySize ? unit.displaySize.replaceAll(/(\d+) X (\d+)/, "\$1' x \$2'") : "??"} Unit</h4>
    <ul>
      <li>${unit.unitType.display} unit</li>
      <li>Climate Control: <g:if test="${unit.isTempControlled}">yes</g:if><g:else>no</g:else>
      <li>Alarm: <g:if test="${unit.isAlarm}">Alarm</g:if><g:else>no</g:else></li>
      <li>Electricity in unit: <g:if test="${unit.isPowered}">yes</g:if><g:else>no</g:else></li>
      <g:if test="${unit.isIrregular}"><li>Note: Irregularly sized unit</li></g:if>
    </ul>
    <div class="promos">
      <g:if test="${promo == null}">
      <g:if test="${promos?.size() > 0}">
      ${promos.size()} special offer(s) available
      <span class="offer_links">(<a class="more" href="#">See offers</a>)</span>
      </g:if>
      </g:if>
      <g:else>
        ${promo.promoName}
        <span class="offer_links">(<a class="remove" href="#">Remove</a><g:if test="${promos?.size() > 1}"> | <a class="more" href="#">See more offers</a></g:if>)</span>
      </g:else>
      <g:if test="${(promo == null && promos?.size() > 0) || promos?.size() > 1}">
      <ul>
      <g:each in="${promos}" var="p">
        <li><a href="#" promo_id="${p.id}">Select Offer</a> ${p.promoName}</li>
      </g:each>
      </ul>
      </g:if>
    </div>
  </div>
  <div class="move_in_date">
    Move-in Date
    <a class="edit_date" title="click to change date" href="#">
      <div class="date_label"><g:formatDate type="date" style="MEDIUM" date="${moveInDate}" /></div>
      <div class="link">Change</div>
    </a>
  </div>
  <div class="move_in_quote">
    <h4>
      Total Move-In Cost <a class="help_button" href="/help#move_in_cost">huh?</a>
      <span class="move_in_cost">$38.00</span>
    </h4>
    <p>* Includes discounts and facility fees</p>
    <p>* Paid through July 20, 2011</p>
  </div>
</div>
<g:hiddenField name="siteId" value="${site?.id}" />
<g:hiddenField name="unitId" value="${unit?.id}" />
<g:hiddenField name="moveInDate" value="${formatDate(format:'yyyy-MM-dd', date:moveInDate)}" />
<g:hiddenField name="promoId" value="${promo?.id}" />
