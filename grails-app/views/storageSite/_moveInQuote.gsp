<div class="move_in_quote">
  <dl class="summary">
    <dt>Total Move-In Cost
      <g:if test="${site.useProrating}"><a class="help_button move_in_cost_calendar" href="/help#move_in_cost__with_calendar_billing">huh?</a></g:if>
      <g:else><a class="help_button move_in_cost_anniversary" href="/help#move_in_cost_with_anniverary_billing">huh?</a></g:else>
    </dt>
    <dd><g:formatNumber number="${totals.getMoveInTotal()}" type="currency" currencyCode="USD" /><span class="move_in_cost_asterisk">*</span></dd>
    <dt>Move-In Date</dt>
    <dd>
      <g:if test="${editable}">
        <a class="edit_date" title="Click to Change" href="#" max-days="${site.maxReserveDays}"><g:formatDate type="date" style="MEDIUM" date="${moveInDate}" /></a>
      </g:if>
      <g:else>
        <g:formatDate type="date" style="MEDIUM" date="${moveInDate}" />
      </g:else>
    </dd>
    <dt>Paid Thru</dt>
    <dd><g:formatDate type="date" style="MEDIUM" date="${totals.paidThruDate}" /></dd>
    <dt>Special Offer</dt>
    <dd>
      <g:if test="${promos.size() == 0}"><span class="none">No specials available</span></g:if>
      <g:elseif test="${promo == null}"><span class="none">No special selected</span></g:elseif>
      <g:else>${promo.promoName}</g:else>
    </dd>
  </dl>
  <g:if test="${editable}">
  <div class="offer_links">
    <g:if test="${promo != null}"><a class="remove" href="#">Remove</a></g:if>
    <g:if test="${(promo == null && promos?.size() > 0) || promos.size() > 1}">
      <g:if test="${promo != null}">|</g:if> <a class="more" href="#">View offers</a>
    </g:if>
  </div>
  <g:if test="${(promo == null && promos?.size() > 0) || promos?.size() > 1}">
  <ul class="promos">
  <g:each in="${promos}" var="p">
    <li><a href="#" promo_id="${p.id}">Select Offer</a> ${p.promoName}</li>
  </g:each>
  </ul>
  </g:if>
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
      <g:if test="${promo != null}">
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
      <tr>
        <td class="item">Facility fee</td>
        <td></td>
        <td class="numeric"></td>
        <td class="numeric last"><g:formatNumber type="currency" currencyCode="USD"  number="${totals.getFeesTotal()}" /></td>
      </tr>
      <tr>
        <td class="item">Sales tax</td>
        <td></td>
        <td class="numeric"></td>
        <td class="numeric last"><g:formatNumber type="currency" currencyCode="USD"  number="${totals.getTax()}" /></td>
      </tr>
      <tr>
        <td class="summary last" colspan="4"><g:formatNumber type="currency" currencyCode="USD"  number="${totals.getMoveInTotal()}" /></td>
      </tr>
      </tbody>
    </table>
  </div>
</div>