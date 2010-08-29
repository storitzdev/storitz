<div class="transBox">
  <div style="margin: 5px 15px 20px 15px;">
    <div class="left">
      <div class="transHeader">Unit Type</div>
      <div>
        <select id="unitType" name="unitType" class="transDropdown">
          
        </select>
      </div>
    </div>
    <div class="left" style="margin-left:15px">
      <div class="transHeader">Unit Size</div>
      <div>
        <div class="left">
          <g:select id="unitsize" class="transDropdown" name="unitsize" from="${sizeList}" optionValue="description" value="${params.searchSize}" optionKey="id" />
        </div>
        <div class="left" style="margin: 5px 0 0 5px;">
          <img id="sizeInfo" style="vertical-align: middle;" src="${createLinkTo(dir:'images', file:'icn_info_circle.png')}" alt="info"/>
        </div>
      </div>
    </div>
    <div class="left" style="vertical-align: bottom; margin: 8px 0 0 15px;">
      <div id="regPrice" class="transStrikethru"></div>
      <div>
        <div id="pushPrice" class="transPrice left"></div>
        <div class="transPerMonth left"> /Per Month</div>
      </div>
    </div>
    <div class="right" style="margin-top:5px;">
      <g:if test="${params.action != 'payment'}"> 
        <input type="image" id="rentme" style="border:none;cursor:pointer;" src="${createLinkTo(dir:'images', file:'btn-rent-me.png')}" alt="Rent Me"/>
      </g:if>
      <g:else>
        <div id="rentme" style="display:none"></div>
      </g:else>
    </div>
    <div style="height: 10px;clear:both;"></div>
    <div class="left specialOfferText">
      Selected Offer: <span id="selectedOffer" class="selectedOffer"></span>
    </div>
    <div style="height: 10px;clear:both;"></div>
    <div class="left">
      <div class="specialOfferText">
        Featured Offers
      </div>
      <div id="moreOffers" class="offerLink right">
        <a href="#" onclick="Effect.toggle('moreOffers', 'appear', {queue: 'end', duration: 0.1});Effect.BlindDown('nonFeaturedOffers'); Effect.toggle('fewerOffers', 'appear', {queue:'end', duration: 0.1});return false;">More Offers</a>
      </div>
      <div id="fewerOffers" class="offerLink right" style="display:none;">
        <a href="#" onclick="Effect.toggle('fewerOffers', 'appear', {queue: 'end', duration: 0.1});Effect.BlindUp('nonFeaturedOffers'); Effect.toggle('moreOffers', 'appear', {queue:'end', duration: 0.1});return false;">Fewer Offers</a>
      </div>
    </div>
    <div id="specialOffers" class="left offerList" style="margin-left: 10px;">
      <div>
        <g:each in="${site.featuredOffers()}" var="offer">
          <p><input type="radio" name="specialOffer" value="${offer.id}" ${(promoId as Integer) == offer.id ? 'checked="checked"' : ''}/> ${offer.promoName} </p>
        </g:each>
      </div>
      <div id="nonFeaturedOffers" style="display:none">
        <g:each in="${site.nonFeaturedOffers()}" var="offer">
          <p><input type="radio" name="specialOffer" value="${offer.id}" ${(promoId as Integer)== offer.id ? 'checked="checked"' : ''}/> ${offer.promoName} </p>
        </g:each>
      </div>
    </div>
    <div class="right">
      <div id="costDetails" class="right">
        <table id="costTotals">
          <tr>
            <td>Monthly rent</td>
            <td class="costDuration" id="monthlyDuration"></td>
            <td class="costMoneyPerMonth" id="monthlyPerMonth"></td>
            <td class="costMoney" id="monthlyTotal"></td>
          </tr>
          <tr id="specialOfferBlock">
            <td>Selected Offer</td>
            <td></td>
            <td></td>
            <td class="costMoney" id="discountTotal"></td>
          </tr>
          <tr id="insuranceBlock">
            <td>Insurance</td>
            <td class="costDuration" id="insuranceDuration"></td>
            <td class="costMoneyPerMonth" id="insurancePerMonth"></td>
            <td class="costMoney" id="insuranceTotal"></td>
          </tr>
          <tr>
            <td>Admin Fees</td>
            <td></td>
            <td></td>
            <td class="costMoney" id="adminTotal"></td>
          </tr>
          <tr id="taxBlock">
            <td>Tax</td>
            <td></td>
            <td></td>
            <td class="costMoney" id="taxTotal"></td>
          </tr>
        </table>
      </div>
      <div style="clear:both;"></div>
      <div class="right transTotalMoveIn">
        <div class="left" style="margin-right: 30px;">
          Total Move-In Cost:
        </div>
        <div class="left">
          <a href="#" id="totalMoveInCost" onclick="Effect.toggle('costDetails', 'appear', { duration: 0.25 }); return false;"></a>
        </div>
      </div>
      <div style="clear:both;"></div>
    </div>
    <div style="height: 10px;clear:both;width: 626px; border-bottom:1px solid #dfdfdf;margin: 0 0 10px -3px;"></div>
    <div class="left">
      <div class="specialOfferText" style="width:400px;">
        Insurance: <span id="selectedInsurance" class="selectedOffer"></span>
      </div>
      <div>
        <div id="moreInsurance" class="offerLink left" style="margin-left:5px;">
          <a href="#" onclick="Effect.toggle('moreInsurance', 'appear', {queue: 'end', duration: 0.1}); Effect.toggle('fewerInsurance', 'appear', {queue:'end', duration: 0.1}); Effect.BlindDown('insurances'); return false;">Show Insurance</a>
        </div>
        <div id="fewerInsurance" class="offerLink left" style="margin-left:25px;display:none;width:40px;">
          <a href="#" onclick="Effect.BlindUp('insurances'); Effect.toggle('fewerInsurance', 'appear', {queue: 'end', duration: 0.1}); Effect.toggle('moreInsurance', 'appear', {queue:'end', duration: 0.1});return false;">Hide</a>
        </div>
      </div>
      <div id="insurances" class="left offerList" style="display:none;margin-left: 10px;width: 310px;">
        <p><input type="radio" name="insuranceId" value="-999" ${ (insuranceId as Integer) < 0 ? 'checked="checked"' : '' } /> Waive insurance - use my renters/home policy coverage</p>
        <g:each in="${site.insurances.sort{it.premium}}" var="ins">
          <p><input type="radio" name="insuranceId" value="${ins.id}" ${ins.id == (insuranceId as Integer) ? 'checked="checked"' : '' } /> <g:formatNumber number="${ins.premium}" type="currency" currencyCode="USD" />/mo. Coverage: <g:formatNumber number="${ins.totalCoverage}" type="currency" currencyCode="USD" /> Theft: <g:formatNumber number="${ins.percentTheft}" type="percent" /></p>
        </g:each>
      </div>
    </div>
    <div class="right">
      <input type="hidden" id="date" name="date" />
      <div class="left">
        <img id="calendarPic" style="cursor: pointer;" src="${resource(dir:'images', file:'icn-calendar.png')}" alt="calendar">
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