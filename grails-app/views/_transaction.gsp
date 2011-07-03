<%@ page import="storitz.constants.TransactionType" %>
<div class="rent_me">
  <div class="price">
    $72.00 <span class="original_price">$80</span>
    <div class="per_month">per month</div>
  </div>
  <div class="rent_reserve">
    <g:if test="${params.action != 'payment'}">
      <g:if test="${site.transactionType == TransactionType.RESERVATION}">
        <p:inputImage class="rent_me_button" src="../images/v2/site_detail/rent-me-275x56.png" alt="Reserve"/>
      </g:if>
      <g:else>
        <p:inputImage id="rent_me_button" src="../images/v2/site_detail/rent-me-275x56.png" alt="Rent Me"/>
      </g:else>
    </g:if>
    <div class="guarantee">Storitz Price Guarantee</div>
  </div>
  <div class="move_in_date">
    Move-in Date <a class="help_button" href="/help#move_in_date">huh?</a>
    <a class="edit_date" title="click to change date" href="#">
      <div class="date_label">June 20, 2011</div>
      <div class="link">Change</div>
    </a>
    <input type="hidden" id="date" name="date"/>
  </div>
  <div class="unit_info">
    <a class="view_more" href="#">See more sizes</a>
    <h4>10' x 10' Unit</h4>
    <ul>
      <li>Drive-up</li>
      <li>Roll-up Door</li>
      <li>Climate Control</li>
    </ul>
    <div class="promos">
      <a class="view_more" href="#">See more offers</a>
      <span class="label">Special offer</span> First month free for witches and labrador retrievers
    </div>
  </div>
  <div class="move_in_quote">
    <h4>
      Total Move-In Cost <a class="help_button" href="/help#move_in_cost">huh?</a>
      <span id="move_in_cost">$38.00</span>
    </h4>
    <p>* Includes discounts and facility fees</p>
    <p>* Paid through July 20, 2011</p>
  </div>
</div>

