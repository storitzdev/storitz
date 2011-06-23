<%@ page import="storitz.constants.TransactionType" %>
<div class="transBox">
    <div class="price">
      <div id="regPrice" class="transStrikethru"></div>
      <div>
        <div id="pushPrice" class="transPrice">$72.00</div>
        <div class="transPerMonth">per month</div>
      </div>
    </div>
    <div class="rent_reserve">
      <g:if test="${params.action != 'payment'}">
        <g:if test="${site.transactionType == TransactionType.RESERVATION}">
          <p:inputImage id="rentme" src="btn-reserve-108x36.png" alt="Reserve"/>
        </g:if>
        <g:else>
          <p:inputImage id="rentme" src="btn-rent-me.png" alt="Rent Me"/>
        </g:else>
      </g:if>
      <g:else>
        <div id="rentme" style="display:none"></div>
      </g:else>
      <h3>Storitz Price Guarantee</h3>
    </div>
    <div class="move_in">
        <div>
            <div class="transDateHeader">
              Move-In Date:
            </div>
            <input type="hidden" id="date" name="date"/>
            <div class="transDate" id="transMoveInDate">
                June 20, 2011
            </div>
            <div class="calendar">
                <storitz:image id="calendarPic" src="icn-calendar.png" alt="calendar"/>
            </div>
        </div>
        <div>
            <div class="changeDate">
                <a href="#">Edit date</a>
            </div>
        </div>
    </div>
    <div class="unit_size">
        <h4>10' x 10' Unit</h4>
        <a href="#">See more sizes</a>
    </div>
    <div class="amenities">
        <ul>
            <li>Drive-up</li>
            <li>Roll-up Door</li>
            <li>Climate Control</li>
        </ul>
    </div>
    <div class="promos">
        Military Discount - Save 50% off first two months
    </div>
    <div style="height: 10px;clear:both;width: 270px; border-bottom:1px solid #dfdfdf;margin: 0 5px 10px 5px;"></div>
    <div class="transTotalMoveIn">
        Total Move-In Cost:
        <span id="totalMoveInCost">$38.00</span>
        <div class="paidThrough">
              Paid thru July 20, 2011
        </div>
        <p>*Includes discounts and facility fees</p>
    </div>
</div>

