<%@ page import="storitz.constants.TransactionType" %>
<div class="move_in_quote">
  <table class="summary first">
    <tr><th>Move-In Date</th>
    <td>
      <a class="edit_date" title="Click to Change" href="#" max-days="${(unit.maxReserveDays != null) ? unit.maxReserveDays : site.maxReserveDays}"><g:formatDate type="date" style="MEDIUM" date="${moveInDate}" /></a>
    </td>
    </tr>
    <tr><th>Paid Until</th>
    <td><g:formatDate type="date" style="MEDIUM" date="${totals.paidThruDate}" /></td></tr>
    <tr>
        <th>Special Offer
            <g:if test="${(promo == null && promos?.size() > 0) || promos.size() > 1}">
                (<a class="more_offers" href="#">view all</a>)
            </g:if>
        </th>
    <td>
      <g:if test="${promos.size() == 0}"><span class="none">No specials available</span></g:if>
      <g:elseif test="${promo == null}"><span class="none">No special selected</span></g:elseif>
      <g:else>${promo.promoName}<br/><a class="remove_offer" href="#">remove</a>%{--<a class="offer_details" href="#">details |&nbsp;</a>--}%</g:else>
      </td>
    </tr>

    <g:if test="${site.transactionType == TransactionType.RESERVATION}">
        <tr class="total"><td colspan="2"><span class="label">Total Due Today</span><g:formatNumber number="${site.rentalFee}" type="currency" currencyCode="USD" /></td></tr>
        <tr>
            <th><span class="label">Total Move-In Cost</span></th>
            <th><span class="right"><g:formatNumber number="${totals.getMoveInTotal()}" type="currency" currencyCode="USD" /><span class="move_in_cost_asterisk">*</span></span></th>
        </tr>
    </g:if>
    <g:else>
        <tr class="total"><td colspan="2"><span class="label">Total Move-In Cost</span><g:formatNumber number="${totals.getMoveInTotal()}" type="currency" currencyCode="USD" /><span class="move_in_cost_asterisk">*</span></td></tr>
    </g:else>
  </table>

   <g:if test="${site.transactionType == TransactionType.RESERVATION && site.feed.reservationMoveInDescription}">
      <div id="reservation_move_in_description" class="reservation_move_in_description">${site.feed.reservationMoveInDescription}</div>
   </g:if>
  <g:if test="${(promo == null && promos?.size() > 0) || promos?.size() > 1}">
  <ul id="promo_list" class="tooltip">
      <h2>Select an Offer</h2>
  <g:each in="${promos}" var="p">
    <li><a href="#" class="promo" promo_id="${p.id}">${p.promoName}</a></li>
  </g:each>
    <li class="close"><a href="#" class="close">Close X</a></li>
  </ul>
  </g:if>
  <p>* Includes <a class="breakdown" href="#">initial rent, discounts and facility fees</a></p>
  <div class="cost_breakdown">
    <table>
      <caption>Move-In Cost Breakdown</caption>
      <tbody>
      <tr>
        <th class="item">Item</th>
        <th>Initial Period</th>
        <th class="numeric">Monthly Rate</th>
        <th class="numeric last">Amount</th>
      </tr>
      <tr>
        <td class="item">Rent</td>
        <td><g:if test="${totals.getDurationMonths() > 0}">${totals.getDurationMonths()}mo </g:if><g:if test="${totals.getDurationDays() > 0}">${totals.getDurationDays()}d</g:if></td>
        <td class="numeric"><g:formatNumber number="${unit.bestUnitPrice}" type="currency" currencyCode="USD" /></td>
        <td class="numeric last"><g:formatNumber number="${totals.getRentTotal()}" type="currency" currencyCode="USD" /></td>
      </tr>
      <g:if test="${promo != null && totals.getDiscountTotal() != 0}">
        <tr>
          <td class="item">${promo.promoName}</td>
          <td>${promo.expireMonth}mo</td>
          <td class="numeric"></td>
          <td class="numeric last negative">-<g:formatNumber type="currency" currencyCode="USD"  number="${totals.getDiscountTotal()}" /></td>
        </tr>
      </g:if>
      <g:if test="${insurance != null}">
        <tr>
          <td class="item">Property protection (required)</td>
          <td><g:if test="${totals.getDurationMonths() > 0}">${totals.getDurationMonths()}mo </g:if><g:if test="${totals.getDurationDays() > 0}">${totals.getDurationDays()}d</g:if></td>
          <td class="numeric"><g:formatNumber type="currency" currencyCode="USD"  number="${insurance.premium}" /></td>
          <td class="numeric last"><g:formatNumber type="currency" currencyCode="USD"  number="${totals.getInsuranceCost()}" /></td>
        </tr>
      </g:if>
      <g:if test="${totals.getFeesTotal() > 0}">
	<tr>
          <td class="item">Facility fee</td>
          <td></td>
          <td class="numeric"></td>
          <td class="numeric last"><g:formatNumber type="currency" currencyCode="USD"  number="${totals.getFeesTotal()}" /></td>
	</tr>
      </g:if>
      <g:if test="${totals.getDeposit() > 0}">
	<tr>
          <td class="item">Refundable deposit</td>
          <td></td>
          <td class="numeric"></td>
          <td class="numeric last"><g:formatNumber type="currency" currencyCode="USD"  number="${totals.getDeposit()}" /></td>
	</tr>
      </g:if>
      <g:if test="${totals.getTax() > 0}">
	<tr>
          <td class="item">Sales tax</td>
          <td></td>
          <td class="numeric"></td>
          <td class="numeric last"><g:formatNumber type="currency" currencyCode="USD"  number="${totals.getTax()}" /></td>
	</tr>
      </g:if>
     <g:if test="${site.transactionType == TransactionType.RESERVATION && site.rentalFee}">
          <td class="item">Reservation Deposit</td>
          <td class="numeric"></td>
          <td class="numeric"></td>
          <td class="numeric last negative">-<g:formatNumber type="currency" currencyCode="USD"  number="${site.rentalFee}" /></td>
      </g:if>
      <tr class="total">
          <g:if test="${site.transactionType == TransactionType.RESERVATION && site.rentalFee}">
              <td class="item" colspan="3">Total Due at Move-In</td><td class="last" colspan="1"><g:formatNumber type="currency" currencyCode="USD"  number="${totals.getMoveInTotal() - site.rentalFee}" /></td>
          </g:if>
          <g:else>
              <td class="item">Total</td><td class="last" colspan="3"><g:formatNumber type="currency" currencyCode="USD"  number="${totals.getMoveInTotal()}" /></td>
          </g:else>
      </tr>
      </tbody>
    </table>
  </div>
</div>
