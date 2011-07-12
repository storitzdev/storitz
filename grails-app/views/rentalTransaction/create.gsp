<%@ page import="storitz.constants.TransactionType" %>
<html>
<head>
  <title>Unit Rental - ${transaction.site.title}</title>
</head>
<body class="checkout">
<g:form action="save" controller="rentalTransaction" method="post" useToken="true" name="rentalTransaction"
        id="${transaction?.id}" class="checkout">
<input type="hidden" name="unitId" id="unitId" value="${transaction.unitId}"/>
<input type="hidden" name="promoId" id="promoId" value="${transaction.promoId}"/>
<input type="hidden" name="insuranceId" id="insuranceId" value="${transaction.insuranceId}"/>
<input type="hidden" name="siteId" value="${transaction.site.id}"/>
<input type="hidden" name="moveInDate" id="moveInDate" value="${transaction?.moveInDate}"/>
<div class="customer_info">
  <g:if test="${!(transaction.site.transactionType == TransactionType.RESERVATION && transaction.site.rentalFee == 0)}">
  <div class="first">
    <h1>Payment Details</h1>
    <div class="col2 ccimages"><storitz:image src="credit-cards.gif" width="302" height="38" alt="Credit Cards"/></div>
    <div class="row">
      <div class="col1">
        <label for="contactPrimary.firstName">First Name</label>
        <g:textField id="contactPrimary.firstName" name="contactPrimary.firstName" class="required"
                     value="${transaction?.contactPrimary?.firstName}"/>
      </div>
      <div class="col2">
        <label for="contactPrimary.lastName">Last Name</label>
        <g:textField id="contactPrimary.lastName" name="contactPrimary.lastName" class="required"
                     value="${transaction?.contactPrimary?.lastName}"/>
      </div>
    </div>
    <div class="row">
      <div class="col1">
        <label for="cc_number">Credit Card Number</label>
        <g:textField name="cc_number" id="cc_number" class="required ccnumber" value="${cc_number}"/>
      </div>
      <div class="col2">
        <label for="cc_issuer">Card Type</label>
        <g:select name="cc_issuer" from="['Visa', 'Mastercard', 'American Express', 'Discover', 'Diners Club', 'JCB']" value="${cc_issuer}"/>
      </div>
    </div>
    <div class="row">
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
    <g:else>
    <h1>Tenant Info</h1>
    <div>
      <div class="col1">
        <label for="contactPrimary.firstName">First Name</label>
        <g:textField id="contactPrimary.firstName" name="contactPrimary.firstName" class="required"
                     value="${transaction?.contactPrimary?.firstName}"/>
      </div>
      <div class="col2">
        <label for="contactPrimary.lastName">First Name</label>
        <g:textField id="contactPrimary.lastName" name="contactPrimary.lastName" class="required"
                     value="${transaction?.contactPrimary?.lastName}"/>
      </div>
    </div>
    </g:else>
    <div class="col1">
      <label for="address1">Address Line 1</label>
      <g:textField name="address1" id="address1" class="contactRequired" value="${transaction?.billingAddress?.address1}"/>
    </div>
    <div class="row col1">
      <label for="address2">Address Line 2</label>
      <g:textField name="address2" id="address2" value="${transaction?.billingAddress?.address2}"/>
    </div>
    <div class="row">
      <div class="col1">
        <label for="city">City</label>
        <g:textField name="city" id="city" class="contactRequired" value="${transaction?.billingAddress?.city}"/>
      </div>
      <div class="col2">
        <label for="state">State</label>
        <g:select name="state" id="state" class="state" from="${storitz.constants.State.list()}" value="${transaction?.billingAddress?.state}" optionValue="value"/>
      </div>
      <div class="col3">
        <label for="zipcode">ZIP code</label>
        <g:textField name="zipcode" id="zipcode" class="contactRequired zipcode" value="${transaction?.billingAddress?.zipcode}"/>
      </div>
    </div>
  </div>
  <div>
    <h1>Contact Info</h1>
    <div class="row">
      <div class="col1">
        <label for="contactPrimary.email">Email</label>
        <g:textField name="contactPrimary.email" id="contactPrimary-email" class="required email"
                     value="${transaction?.contactPrimary?.email}"/>
      </div>
      <div class="col2">
        <label for="contactPrimary.emailRepeat">Confirm email</label>
        <g:textField name="contactPrimary.emailRepeat" id="contactPrimary.emailRepeat"
                     value="${transaction?.contactPrimary?.email}"/>
      </div>
    </div>
    <div class="row col1">
      <label for="contactPrimary.phone">Phone Number (xxx-xxx-xxxx)</label>
      <g:textField name="contactPrimary.phone" id="contactPrimary.phone" class="required phone"
                   value="${transaction?.contactPrimary?.phone}"/>
    </div>
  </div>
  <div class="terms">
    <h1>Terms and Conditions</h1>
    <div class="col2">
    <g:checkBox name="terms" id="terms" class="required" value="${transaction?.terms}"/>
    I agree to the <a href="${createLink(controller: 'static', action: 'terms')}"
                    onclick="window.open(this.href, '_blank');
                    return false;">Storitz Inc. Terms of Use</a>
    <g:if test="${transaction.site.rentalAgreement}">
    and the <a href="${resource(file: transaction.site.rentalAgreement.src())}" onclick="window.open(this.href, '_blank'); return false;">${transaction.site.feed.operatorName} Terms and Conditions</a>
    </g:if>
    </div>
  </div>

  <g:if test="${!(transaction.site.transactionType == TransactionType.RESERVATION && transaction.site.rentalFee == 0)}">
  <div class="pay_button">
    <h1>Submit Booking</h1>
    <div class="col2">
      <p><strong>You will be charged a total of $xxx.xx</strong> (including all discounts and facility fees)</p>
      <g:submitButton name="action"
                      value="${(transaction.site.transactionType == TransactionType.RESERVATION) ? 'reserve' : 'rent'}"
                      class="rent_me_button" />
      <p class="guaranteed_secure">Your transaction is guaranteed secure.</p>
      </div>
  </div>
  </g:if>
  <g:else>
  <div class="reserve_button">
    <h1>Reserve Unit</h1>
    <div class="col2" class="pay_button">
        <g:submitButton name="action"
                        value="${(transaction.site.transactionType == TransactionType.RESERVATION) ? 'reserve' : 'rent'}"
                        class="rent_me_button" />
    </div>
  </div>
  </g:else>
</div>
<div class="booking_summary">
  <g:render template="booking_summary" model="[unit:unit, transaction:transaction, promos:promos, totals:totals]" />
</div>
<p:dependantJavascript>
  <script type="text/javascript">
    $("body.checkout .move_in_quote a.edit_date").click(function() { return false; });
  </script>
</p:dependantJavascript>
</g:form>
</body>
</html>