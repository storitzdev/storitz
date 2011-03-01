<%@ page import="storitz.constants.TransactionType" %>
<div class="transBox">
  <div style="width:620px;margin: 5px 15px 20px 15px;">
    <div class="left">
      <div class="transHeader">Unit Type</div>
      <div>
        <select id="unitType" name="unitType" class="transDropdown">
          <option value=""></option>
        </select>
      </div>
    </div>
    <div class="left" style="margin-left:15px">
      <div class="transHeader">Unit Size</div>
      <div>
        <div class="left">
          <g:select id="unitsize" class="transDropdown" name="unitsize" from="${sizeList}" optionValue="description" value="${params.size}" optionKey="id" />
        </div>
        <div class="left sizeGuide">
          size guide
        </div>
      </div>
    </div>
    <div class="left" style="vertical-align: bottom; margin: 8px 0 0 15px;">
      <div id="regPrice" class="transStrikethru"></div>
      <div>
        <div id="pushPrice" class="transPrice left"></div>
        <div class="transPerMonth left"> /Per Month</div>
      </div>
      <div class="transPerMonth">
        <div class="left">Actual Size:</div>
        <div class="left" id="actualSize"></div>
      </div>
    </div>
    <div class="right" style="margin-top:5px;">
      <g:if test="${params.action != 'payment'}">
        <g:if test="${site.transactionType == TransactionType.RESERVATION}">
          <p:inputImage id="rentme" style="width:108px;height:36px;border:none;cursor:pointer;" src="btn-reserve-108x36.png" alt="Reserve"/>
          <div></div>
          <p:inputImage id="rentmeDisabled" style="width:108px;height:36px;border:none;cursor:pointer;" src="btn-rent-me-grey-108x36.png" alt="Rent Me"/>
          <div id="rentVsReserve" class="rentVsReserve textCenter">Rent vs. Reserve</div>
        </g:if>
        <g:else>
          <p:inputImage id="rentme" style="width:108px;height:36px;border:none;cursor:pointer;" src="btn-rent-me.png" alt="Rent Me"/>
        </g:else>
      </g:if>
      <g:else>
        <div id="rentme" style="display:none"></div>
      </g:else>
    </div>
    <div style="height: 10px;clear:both;"></div>
    <div class="left specialOfferText">
      Selected Offer: <span id="selectedOffer" class="selectedOffer"></span>&nbsp;<span id="clearOffer" class="clearOffer"></span>
    </div>
    <div style="height: 10px;clear:both;"></div>
    <div class="left" style="width:105px;">
      <div class="specialOfferText">
        Featured Offers
      </div>
      <div id="moreOffers" class="offerLink right">
        <span>More Offers</span>
      </div>
      <div id="fewerOffers" class="offerLink right" style="display:none;">
        <span>Fewer Offers</span>
      </div>
    </div>
    <div id="specialOffers" class="left offerList" style="margin-left: 10px;">
      <div id="featuredOffers">
      </div>
      <div id="nonFeaturedOffers" style="display:none">
      </div>
    </div>
    <div class="right">
      <g:if test="${site.transactionType == TransactionType.RESERVATION}">
        <div class="left" style="margin-right:25px;">
          <p>Reservation Details</p>
          <ul>
            <li>Hold your unit until Move-In date</li>
            <li>Take Advantage of Special Offer</li>
            <li>Get this Rent rate when you Move-In</li>
            <g:if test="${site.rentalFee}">
              <li>Refundable until Move-In date</li>
            </g:if>
          </ul>
        </div>
      </g:if>
      <div id="costDetails" class="right">
        <table class="costTotals" cellspacing="0">
          <thead>
            <tr>
              <th>Item</th>
              <th>Initial Period</th>
              <th>Monthly Rate</th>
              <th>Total</th>
            </tr>
          </thead>
          <tbody>
            <tr>
              <td class="transLineDesc">Rent</td>
              <td class="costDuration" id="monthlyDuration"></td>
              <td class="costMoneyPerMonth" id="monthlyPerMonth"></td>
              <td class="costMoney" id="monthlyTotal"></td>
            </tr>
            <tr id="specialOfferBlock">
              <td class="transLineDesc">Selected Offer</td>
              <td class="costDuration"></td>
              <td class="costMoneyPerMonth"></td>
              <td class="costMoney" id="discountTotal"></td>
            </tr>
            <tr id="insuranceBlock">
              <td class="transLineDesc">Property Protection</td>
              <td class="costDuration" id="insuranceDuration"></td>
              <td class="costMoneyPerMonth" id="insurancePerMonth"></td>
              <td class="costMoney" id="insuranceTotal"></td>
            </tr>
            <tr>
              <td class="transLineDesc">Property Fees</td>
              <td class="costDuration"></td>
              <td class="costMoneyPerMonth"></td>
              <td class="costMoney" id="adminTotal"></td>
            </tr>
            <tr id="depositBlock">
              <td class="transLineDesc">Refundable Deposit</td>
              <td class="costDuration"></td>
              <td class="costMoneyPerMonth"></td>
              <td class="costMoney" id="deposit"></td>
            </tr>
            <tr id="taxBlock">
              <td class="transLineDesc">Tax</td>
              <td class="costDuration"></td>
              <td class="costMoneyPerMonth"></td>
              <td class="costMoney" id="taxTotal"></td>
            </tr>
          </tbody>
        </table>
      </div>
      <div style="clear:both;"></div>
      <div class="right transTotalMoveIn">
        <div class="left" style="margin-right: 30px;">
          Total Move-In Cost:
        </div>
        <div class="right">
          <span id="totalMoveInCost"></span>
        </div>
        <g:if test="${site.transactionType == TransactionType.RESERVATION}">
          <div style="clear:both;"></div>
          <div class="left" style="margin-right: 30px;">
            Reserve Today:
          </div>
          <div class="right">
            <span><g:formatNumber number="${site.rentalFee}" currencyCode="USD" type="currency"/></span>
          </div>
        </g:if>
      </div>
      <div style="clear:both;"></div>
    </div>
    <div style="height: 10px;clear:both;width: 626px; border-bottom:1px solid #dfdfdf;margin: 0 0 10px -3px;"></div>
    <div class="left">
      <div class="specialOfferText" style="width:400px;">
        <div>Property</div> Protection: <span id="selectedInsurance" class="selectedOffer"></span>
      </div>
      <div>
        <div id="moreInsurance" class="offerLink left">
          <span>Show Property Protection</span>
        </div>
        <div id="fewerInsurance" class="offerLink left" style="margin-left:25px;display:none;width:40px;">
          <span>Hide</span>
        </div>
      </div>
      <div id="insurances" class="left offerList" style="display:none;margin-left: 10px;width: 325px;">
        <g:if test="${!site.noInsuranceWaiver}">
          <p><input type="radio" name="insuranceId" value="-999" ${ (insuranceId as Integer) < 0 ? 'checked="checked"' : '' } /> Waive insurance - use my renters/home policy coverage</p>
        </g:if>
        <g:each in="${site.insurances.sort{it.premium}}" var="ins" status="i">
          <g:if test="${ins.active}">
            <p><input type="radio" name="insuranceId" value="${ins.id}" ${(site.noInsuranceWaiver && i == 0) || (ins.id == (insuranceId as Integer)) ? 'checked="checked"' : '' } /> <g:formatNumber number="${ins.premium}" type="currency" currencyCode="USD" />/mo. Coverage: <g:formatNumber number="${ins.totalCoverage}" type="currency" currencyCode="USD" /> Theft: <g:formatNumber number="${ins.percentTheft}" type="percent" /></p>
          </g:if>
        </g:each>
      </div>
    </div>
    <div class="right">
      <input type="hidden" id="date" name="date" />
      <div class="left">
        <storitz:image id="calendarPic" style="cursor: pointer;" src="icn-calendar.png" width="23" height="19" alt="calendar" />
      </div>
      <div class="left">
        <div class="transDateHeader left">
          Move-In Date:
        </div>
        <div style="clear:both;"></div>
        <div class="transDate" id="transMoveInDate">
        </div>
      </div>
      <div class="left" style="margin-left: 25px;">
        <div class="transDateHeader">
          Paid Through:
        </div>
        <div class="transDate" id="paidThruDate">
        </div>
      </div>
    </div>
    <div style="height: 10px;clear:both;"></div>
  </div>
</div>
<div id="rentVsReserveText" style="display:none">
  Reserve a unit now to hold a specific space and its price up until your move-in date.  You'll need to finalize paperwork, payment and other details when you arrive at the property.
</div>