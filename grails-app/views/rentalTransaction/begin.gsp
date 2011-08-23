<%@ page import="storitz.constants.TransactionType" %>
<html>
<head>
  <title>Unit Rental - ${site.title}</title>
</head>
<body class="checkout">
<g:form action="create" controller="rentalTransaction" method="post" useToken="true" name="rental_transaction_form"
        class="checkout">
    <input type="hidden" id="xid" name="xid" value="${xid}" />
<div class="customer_info">
  <g:if test="${rentalTransactionInstance?.hasErrors() || contact?.hasErrors()}">
  <div class="errors">
    <h2>Oh noes!</h2>

    <div class="messages">
      Some of the information we need to complete your order was missing or incomplete:
      <ul>
        <g:eachError model="[contact:contact]" field="firstName"><li><span class="field">First name</span>Please enter your first name as it appears on your card</li></g:eachError>
        <g:eachError model="[contact:contact]" field="lastName"><li><span class="field">Last name</span>Please enter your last name as it appears on your card</li></g:eachError>
        <g:eachError model="[contact:contact]" field="address1"><li><span class="field">Address Line 1</span>Please enter the street address of the billing address for your card.</li></g:eachError>
        <g:eachError model="[contact:contact]" field="city"><li><span class="field">City</span>Please enter the city of the billing address for your card.</li></g:eachError>
        <g:eachError model="[contact:contact]" field="state"><li><span class="field">State</span>Please enter the state of the billing address for your card.</li></g:eachError>
        <g:eachError model="[contact:contact]" field="zipcode"><li><span class="field">ZIP Code</span>Please enter the ZIP code of the billing address for your card.</li></g:eachError>
        <g:eachError model="[contact:contact]" field="email"><li><span class="field">Email</span>Please enter a valid email address where we can send a confirmation notice.</li></g:eachError>
        <g:eachError model="[contact:contact]" field="phone"><li><span class="field">Phone Number</span>Please enter your phone number.</li></g:eachError>
        <g:eachError model="[rentalTransactionInstance:rentalTransactionInstance]" field="ccNum"><li><span class="field">Credit Card Number</span>Please enter your credit card number.</li></g:eachError>
        <g:eachError model="[rentalTransactionInstance:rentalTransactionInstance]" field="cvv2"><li><span class="field">Credit Card Security Code</span>Please enter the security code from your credit card.</li></g:eachError>
        <g:eachError model="[rentalTransactionInstance:rentalTransactionInstance]" field="ccExpDate"><li><span class="field">Card Expiration Date</span>Please specify the month and year of the expiration date for your card.</li></g:eachError>
        <g:eachError model="[rentalTransactionInstance:rentalTransactionInstance]" field="terms"><li><span class="field">Terms and Conditions</span>You must accept the Terms of Use before you can book a unit.</li></g:eachError>
      </ul>
    </div>
    <p>Please review the information shown below and submit your order again. If you'd rather complete your order by phone, please just give us a call at <b>(877) 456-2929</b>!</p>
  </div>
  </g:if>
  <g:elseif test="${flash.message}">
    <div class="errors">
      <h2>Bad news...</h2>
      <p class="messages"><g:message code="${flash.message}" /></p>
      <p>Or if you'd rather complete your order by phone, please just give us a call at <b>(877) 456-2929</b>!</p>
    </div>
  </g:elseif>
  <g:if test="${!(site.transactionType == TransactionType.RESERVATION && site.rentalFee == 0)}">
  <h1 class="pay first">
    Billing Information
    <div class="col2 ccimages"><storitz:image src="credit-cards.gif" width="302" height="38" alt="Credit Cards" /></div>
  </h1>
  </g:if>
  <g:else>
  <h1 class="first">Tenant Info</h1>
  </g:else>
  <div>
    <div class="col1">
      <label for="firstName">First Name</label>
      <g:textField name="firstName" class="required" value="${params.firstName}"/>
    </div>
    <div class="col2">
      <label for="lastName">Last Name</label>
      <g:textField name="lastName" class="required" value="${params.lastName}"/>
    </div>
  </div>
  <div>
    <div class="col1">
      <label for="address1">Address Line 1</label>
      <g:textField name="address1" id="address1" class="contactRequired" value="${params.address1}"/>
    </div>
  </div>
  <div>
    <div class="col1">
     <label for="address2">Address Line 2</label>
      <g:textField name="address2" id="address2" value="${params.address2}"/>
    </div>
  </div>
  <div>
    <div class="col1">
      <label for="city">City</label>
      <g:textField name="city" id="city" class="contactRequired" value="${params.city}"/>
    </div>
    <div class="col2">
      <label for="state">State</label>
      <g:select name="state" id="state" class="state" from="${storitz.constants.State.list()}" value="${params.state}" optionValue="value"/>
    </div>
    <div class="col3">
      <label for="zipcode">ZIP code</label>
      <g:textField name="zipcode" id="zipcode" class="contactRequired zipcode" value="${params.zipcode}"/>
    </div>
  </div>
  <g:if test="${!(site.transactionType == TransactionType.RESERVATION && site.rentalFee == 0)}">
  <div>
    <div class="col1">
      <label for="cc_number">Credit Card Number</label>
      <g:textField name="cc_number" id="cc_number" class="required ccnumber" value="${params.cc_number}"/>
    </div>
    <div class="col2">
      <label for="cardType">Card Type</label>
      <g:select name="cardType" from="${storitz.constants.CreditCardType.list()}" value="${cardType}"/>
    </div>
  </div>
  <div>
    <div class="col1">
      <label for="cc_month">Expiration Date (Month/Year)</label>
      <g:select name="cc_month" from="${1..12}" value="${cc_month}"/>
      <g:select name="cc_year" from="${2011..2020}" value="${cc_year}"/>
    </div>
    <sec:ifNotGranted roles="ROLE_CALLCENTER, ROLE_CALLCENTER_ADMIN">
      <div class="col2">
        <label for="cvv2">Security Code</label>
        <g:textField id="cvv2" name="cvv2" class="required digits cvv2"
                     value="${cvv2}"/>
      </div>
    </sec:ifNotGranted>
  </div>
  <div class="assurances">
    <p>We will never sell your personal information and we use secure transmission
    and storage to protect your personal information. Read our
    <g:link controller="static" action="privacy">Privacy Policy</g:link> for more
    information.</p>
    <p>Your credit card will be charged for the full payment upon submitting your
    booking request. See <g:link controller="static" action="terms">Terms and
    Conditions</g:link>.</p>
  </div>
  </g:if>

  <h1>Contact Info</h1>
  <div class="row">
    <div class="col1">
      <label for="email">Email</label>
      <g:textField name="email" class="required email"
                   value="${params.email}"/>
    </div>
    <div class="col2">
      <label for="emailRepeat">Confirm email</label>
      <g:textField name="emailRepeat"
                   value="${params.emailRepeat}"/>
    </div>
  </div>
  <div class="row col1">
    <label for="phone">Phone Number (xxx-xxx-xxxx)</label>
    <g:textField name="phone" class="required phone"
                 value="${params.phone}"/>
  </div>


    <h1>Terms and Conditions
        <div class="col2">
            <input type="checkBox" name="_terms" class="required" value="y" ${(params._terms == 'y' ? 'checked="checked" ' : '')} />
            I agree to the <a href="${createLink(controller: 'static', action: 'terms')}"
                              onclick="window.open(this.href, '_blank');
                              return false;">Storitz Inc. Terms of Use</a>
            <g:if test="${site.rentalAgreement}">
                and the <a href="${resource(file: site.rentalAgreement.src())}" onclick="window.open(this.href, '_blank'); return false;">${site.feed.operatorName} Terms and Conditions</a>
            </g:if>
        </div>
    </h1>

    %{--<h1>--}%
        %{--Enter a Coupon Code<span class="coupon_optional"> (Optional)</span>--}%
        %{--<input type="text" name="coupon_code" id="coupon_code">--}%
    %{--</h1>--}%

  <g:if test="${!(site.transactionType == TransactionType.RESERVATION && site.rentalFee == 0)}">
  <h1 class="pay">Submit Booking
    <div class="col2">
      <p><strong>You will be charged a total of <span class="moveInCostTotal"><g:formatNumber type="currency" currencyCode="USD" number="${site.transactionType == TransactionType.RENTAL ? totals.moveInTotal : site.rentalFee}" /></span></strong> (including all discounts and facility fees)</p>
      <g:submitButton name="action"
                      value="${(site.transactionType == TransactionType.RESERVATION) ? 'reserve' : 'rent'}"
                      class="rent_me_button" />
      <p class="guaranteed_secure">Your transaction is guaranteed secure.</p>
    </div>
  </h1>
  </g:if>
  <g:else>
  <h1 class="free">Reserve Unit
    <div class="col2" class="pay_button">
        <g:submitButton name="action"
                        value="${(site.transactionType == TransactionType.RESERVATION) ? 'reserve' : 'rent'}"
                        class="rent_me_button" />
    </div>
  </h1>
  </g:else>
</div>
<div id="booking_summary" src="${createLink(mapping:'bookingSummaryPanel')}">
  <g:render template="bookingSummaryPanel" model="[unit:unit, site:site, insurance:insurance, promo:promo, promos:promos, totals:totals, moveInDate:moveInDate]" />
</div>
</g:form>
<div id="datepicker" class="tooltip" style="background-color: white;">
    <div class="close_button">
    <a class="close" href="#">Close X</a>
    </div>
</div>
<p:dependantJavascript>
  <script type="text/javascript">
    $(document).ready(function() {
      initialize_checkout_page();
    });
  </script>
</p:dependantJavascript>
</body>
</html>