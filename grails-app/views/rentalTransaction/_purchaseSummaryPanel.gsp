<%@ page import="storitz.constants.UnitType" %>
<h1>Purchase Summary</h1>
<div class="site_info">
  <div class="image_container">
  <g:if test="${rentalTransactionInstance.site.coverImage()}">
    <img src="${resource(file: rentalTransactionInstance.site.coverImage()?.mid())}" alt="Image of ${rentalTransactionInstance.site.title} located in ${rentalTransactionInstance.site.city}, ${rentalTransactionInstance.site.state.fullName}" />
  </g:if>
  <g:elseif test="${rentalTransactionInstance.site?.logo && rentalTransactionInstance.site.logo != null}">
    <img src="${resource(file: rentalTransactionInstance.site.logo.src())}" alt="${rentalTransactionInstance.site_title} Logo"/>
  </g:elseif>
  </div>
  <h2>${rentalTransactionInstance.site.title}</h2>
  <p>${rentalTransactionInstance.site.address}</p>
  <p>${rentalTransactionInstance.site.city}, ${rentalTransactionInstance.site.state.display} ${rentalTransactionInstance.site.zipcode}</p>
  <p class="tel">(877) 456-2929</p>
</div>
<div class="unit_info">
    <g:if test="${unit != null}">
        <h1><g:render template="/storageSite/unitSizeLabel" model="[unit:unit]" /><br />Unit Id: ${rentalTransactionInstance.idNumber}</h1>
    </g:if>
    <g:else>
        <h1>${rentalTransactionInstance.displaySize.replaceAll(/(\d+) X (\d+)/, "\$1' x \$2'")} ${rentalTransactionInstance.unitType} Unit <br /> Unit Id: ${rentalTransactionInstance.idNumber}</h1>
    </g:else>
  <p>
    <g:if test="${unit != null && unit.isTempControlled}">Climate control,</g:if>
    <g:if test="${site.isKeypad}">Keypad access,</g:if>
    <g:if test="${site.isCamera}">Security cameras,</g:if>
    <g:if test="${site.isGate}">Gated property,</g:if>
    <g:if test="${site.isUnitAlarmed}">Alarm in unit,</g:if>
    <g:if test="${site.isManagerOnsite}">On-Site manager,</g:if>
    <g:if test="${site.hasElevator}">Elevator access,</g:if>
    <g:if test="${site.freeTruck == 'FREE' || site.freeTruck == 'RENTAL'}">Free truck!</g:if>
  </p>
</div>
<div class="move_in_info">
    <table class="summary">
        <tbody>
        <tr>
            <th>Move-In Date</th>
            <td><g:formatDate type="date" style="MEDIUM" date="${rentalTransactionInstance.moveInDate}" /></td>
        </tr>
        <tr>
            <th>Paid Through</th>
            <td><g:formatDate type="date" style="MEDIUM" date="${rentalTransactionInstance.paidThruDate}" /></td>
        </tr>
        <tr>
            <th>Special Offer</th>
            <td>${rentalTransactionInstance.promoName}</td>
        </tr>
        </tbody>
    </table>
    <a href="#" onclick="return false;">View Details</a>
</div>
<div class="cost_details">
    <table>
        <tbody>
        <tr>
            <th class="item">Item</th>
            <th>Initial Period</th>
            <th class="numeric">Monthly Rate</th>
            <th class="numeric">Amount</th>
        </tr>
        <tr>
            <td class="item">Unit Rental</td>
            <td><g:if test="${rentalTransactionInstance.durationMonths > 0}">${rentalTransactionInstance.durationMonths} mos </g:if><g:if test="${rentalTransactionInstance.durationDays > 0}">${rentalTransactionInstance.durationDays} days</g:if></td>
            <td class="numeric"><g:formatNumber number="${rentalTransactionInstance.monthlyRate}" type="currency" currencyCode="USD" /></td>
            <td class="numeric"><g:formatNumber number="${totals.getRentTotal()}" type="currency" currencyCode="USD" /></td>
        </tr>
        <g:if test="${promo != null}">
        <tr>
            <td class="item">${promo.promoName}</td>
            <td>${promo.expireMonth} mos</td>
            <td class="numeric"></td>
            <td class="numeric negative">-<g:formatNumber type="currency" currencyCode="USD"  number="${totals.getDiscountTotal()}" /></td>
        </tr>
        </g:if>
        <g:if test="${insurance != null}">
        <tr>
          <td class="item">Property protection (required)</td>
          <td><g:if test="${totals.getDurationMonths() > 0}">${totals.getDurationMonths()}mo </g:if><g:if test="${totals.getDurationDays() > 0}">${totals.getDurationDays()}d</g:if></td>
          <td class="numeric"><g:formatNumber type="currency" currencyCode="USD"  number="${insurance.premium}" /></td>
          <td class="numeric"><g:formatNumber type="currency" currencyCode="USD"  number="${totals.getInsuranceCost()}" /></td>
        </tr>
        </g:if>
        <g:if test="${totals.getFeesTotal() > 0}">
            <tr>
                <td class="item">Facility fee</td>
                <td></td>
                <td class="numeric"></td>
                <td class="numeric"><g:formatNumber type="currency" currencyCode="USD"  number="${totals.getFeesTotal()}" /></td>
            </tr>
        </g:if>
        <g:if test="${totals.getDeposit() > 0}">
            <tr>
                <td class="item">Refundable deposit</td>
                <td></td>
                <td class="numeric"></td>
                <td class="numeric"><g:formatNumber type="currency" currencyCode="USD"  number="${totals.getDeposit()}" /></td>
            </tr>
        </g:if>
        <g:if test="${totals.getTax() > 0}">
            <tr>
                <td class="item">Sales tax</td>
                <td></td>
                <td class="numeric"></td>
                <td class="numeric"><g:formatNumber type="currency" currencyCode="USD"  number="${totals.getTax()}" /></td>
            </tr>
        </g:if>
        </tbody>
    </table>
</div>
<div class="total_cost">
    <h2>Total Move-In Cost</h2>
    <span><g:formatNumber type="currency" currencyCode="USD"  number="${totals.getMoveInTotal()}" />*</span>
    <p>*Includes initial rent, all discounts and facility fees.</p>
</div>