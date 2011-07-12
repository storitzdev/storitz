<%@ page import="storitz.constants.TransactionType" %>
<html>
<head>
  <title>Unit Rental - ${site.title}</title>
</head>
<body class="checkout">
<g:form action="create" controller="rentalTransaction" method="post" useToken="true" name="rental_transaction_form"
        class="checkout">
<div class="customer_info">
  <g:if test="${!(site.transactionType == TransactionType.RESERVATION && site.rentalFee == 0)}">
  <h1 class="pay first">
    Payment Details
    <div class="col2 ccimages"><storitz:image src="credit-cards.gif" width="302" height="38" alt="Credit Cards"/></div>
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
      <label for="cc_issuer">Card Type</label>
      <g:select name="cc_issuer" from="['Visa', 'Mastercard', 'American Express', 'Discover', 'Diners Club', 'JCB']" value="${cc_issuer}"/>
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
        <label for="cc_cvv2">Security Code</label>
        <g:textField id="cc_cvv2" name="cc_cvv2" class="required digits cvv2"
                     value="${cc_cvv2}"/>
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
    <g:checkBox name="terms" id="terms" class="required" value="${params.terms}"/>
    I agree to the <a href="${createLink(controller: 'static', action: 'terms')}"
                    onclick="window.open(this.href, '_blank');
                    return false;">Storitz Inc. Terms of Use</a>
    <g:if test="${site.rentalAgreement}">
    and the <a href="${resource(file: site.rentalAgreement.src())}" onclick="window.open(this.href, '_blank'); return false;">${site.feed.operatorName} Terms and Conditions</a>
    </g:if>
    </div>
    </h1>


  <g:if test="${!(site.transactionType == TransactionType.RESERVATION && site.rentalFee == 0)}">
  <h1 class="pay">Submit Booking
    <div class="col2">
      <p><strong>You will be charged a total of <span class="moveInCostTotal"><g:formatNumber type="currency" currencyCode="USD" number="${totals.moveInTotal}" /></span></strong> (including all discounts and facility fees)</p>
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
<div id="datepicker"></div>
<p:dependantJavascript>
  <script type="text/javascript">
    $(document).ready(function() {
      initialize_checkout_page();
    });
  </script>
</p:dependantJavascript>
</body>
</html>