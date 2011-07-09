<%@ page import="storitz.constants.TransactionType" %>
<html>
<head>
  <title>Unit Rental - ${rentalTransactionInstance.site.title}</title>
</head>
<body class="checkout">
<g:form action="save" controller="rentalTransaction" method="post" useToken="true" name="rentalTransaction"
        id="${rentalTransactionInstance?.id}" class="checkout">
<input type="hidden" name="unitId" id="unitId" value="${rentalTransactionInstance.unitId}"/>
<input type="hidden" name="promoId" id="promoId" value="${rentalTransactionInstance.promoId}"/>
<input type="hidden" name="insuranceId" id="insuranceId" value="${rentalTransactionInstance.insuranceId}"/>
<input type="hidden" name="siteId" value="${rentalTransactionInstance.site.id}"/>
<input type="hidden" name="moveInDate" id="moveInDate" value="${rentalTransactionInstance?.moveInDate}"/>
<div class="customer_info">
  <g:if test="${!(rentalTransactionInstance.site.transactionType == TransactionType.RESERVATION && rentalTransactionInstance.site.rentalFee == 0)}">
  <div class="first">
    <h1>Payment Details</h1>
    <div class="col2 ccimages"><storitz:image src="credit-cards.gif" width="302" height="38" alt="Credit Cards"/></div>
    <div class="row">
      <div class="col1">
        <label for="contactPrimary.firstName">First Name</label>
        <g:textField id="contactPrimary.firstName" name="contactPrimary.firstName" class="required"
                     value="${rentalTransactionInstance?.contactPrimary?.firstName}"/>
      </div>
      <div class="col2">
        <label for="contactPrimary.lastName">Last Name</label>
        <g:textField id="contactPrimary.lastName" name="contactPrimary.lastName" class="required"
                     value="${rentalTransactionInstance?.contactPrimary?.lastName}"/>
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
                     value="${rentalTransactionInstance?.contactPrimary?.firstName}"/>
      </div>
      <div class="col2">
        <label for="contactPrimary.lastName">First Name</label>
        <g:textField id="contactPrimary.lastName" name="contactPrimary.lastName" class="required"
                     value="${rentalTransactionInstance?.contactPrimary?.lastName}"/>
      </div>
    </div>
    </g:else>
    <div class="col1">
      <label for="address1">Address Line 1</label>
      <g:textField name="address1" id="address1" class="contactRequired" value="${rentalTransactionInstance?.billingAddress?.address1}"/>
    </div>
    <div class="row col1">
      <label for="address2">Address Line 2</label>
      <g:textField name="address2" id="address2" value="${rentalTransactionInstance?.billingAddress?.address2}"/>
    </div>
    <div class="row">
      <div class="col1">
        <label for="city">City</label>
        <g:textField name="city" id="city" class="contactRequired" value="${rentalTransactionInstance?.billingAddress?.city}"/>
      </div>
      <div class="col2">
        <label for="state">State</label>
        <g:select name="state" id="state" class="state" from="${storitz.constants.State.list()}" value="${rentalTransactionInstance?.billingAddress?.state}" optionValue="value"/>
      </div>
      <div class="col3">
        <label for="zipcode">ZIP code</label>
        <g:textField name="zipcode" id="zipcode" class="contactRequired zipcode" value="${rentalTransactionInstance?.billingAddress?.zipcode}"/>
      </div>
    </div>
  </div>
  <div>
    <h1>Contact Info</h1>
    <div class="row">
      <div class="col1">
        <label for="contactPrimary.email">Email</label>
        <g:textField name="contactPrimary.email" id="contactPrimary-email" class="required email"
                     value="${rentalTransactionInstance?.contactPrimary?.email}"/>
      </div>
      <div class="col2">
        <label for="contactPrimary.emailRepeat">Confirm email</label>
        <g:textField name="contactPrimary.emailRepeat" id="contactPrimary.emailRepeat"
                     value="${rentalTransactionInstance?.contactPrimary?.email}"/>
      </div>
    </div>
    <div class="row col1">
      <label for="contactPrimary.phone">Phone Number (xxx-xxx-xxxx)</label>
      <g:textField name="contactPrimary.phone" id="contactPrimary.phone" class="required phone"
                   value="${rentalTransactionInstance?.contactPrimary?.phone}"/>
    </div>
  </div>
  <div class="terms">
    <h1>Terms and Conditions</h1>
    <div class="col2">
    <g:checkBox name="terms" id="terms" class="required" value="${rentalTransactionInstance?.terms}"/>
    I agree to the <a href="${createLink(controller: 'static', action: 'terms')}"
                    onclick="window.open(this.href, '_blank');
                    return false;">Storitz Inc. Terms of Use</a>
    <g:if test="${rentalTransactionInstance.site.rentalAgreement}">
    and the <a href="${resource(file: rentalAgreement.site.rentalAgreement.src())}" onclick="window.open(this.href, '_blank'); return false;">${rentalTransactionInstance.site.feed.operatorName} Terms and Conditions</a>
    </g:if>
    </div>
  </div>

  <g:if test="${!(rentalTransactionInstance.site.transactionType == TransactionType.RESERVATION && rentalTransactionInstance.site.rentalFee == 0)}">
  <div class="pay_button">
    <h1>Submit Booking</h1>
    <div class="col2">
      <p><strong>You will be charged a total of $xxx.xx</strong> (including all discounts and facility fees)</p>
      <g:submitButton name="action"
                      value="${(rentalTransactionInstance.site.transactionType == TransactionType.RESERVATION) ? 'reserve' : 'rent'}"
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
                        value="${(rentalTransactionInstance.site.transactionType == TransactionType.RESERVATION) ? 'reserve' : 'rent'}"
                        class="rent_me_button" />
    </div>
  </div>
  </g:else>
</div>
<div class="booking_summary">
  <g:render template="booking_summary" model="[unit:unit, transaction:rentalTransactionInstance]" />
</div>

%{--<!-- Renter Information -->--}%
%{--<div id="primary_contact">--}%
%{--<div class="price_options checkout_header white">--}%
%{--Renter Information--}%
%{--</div>--}%

%{--<div id="errorMessage" class="formErrors">--}%
%{--<div id="errorInfo" class="errorInfo"></div>--}%

%{--<div id="errorList" class="errorList"></div>--}%
%{--</div>--}%

%{--<div class="formInstructions">--}%
%{--Information collected is for purposes of completing the Storage Rental Agreement, and will not be used for any other purpose except as described in our <a--}%
%{--href="${createLink(controller: 'static', action: 'privacy')}" onclick="window.open(this.href, '_blank');--}%
        %{--return false;">Privacy Policy</a>--}%
%{--</div>--}%

%{--<div class="checkout_section_header">--}%
  %{--Name--}%
%{--</div>--}%

%{--<div class="checkout_fields">--}%
  %{--<input type="hidden" name="contactPrimary.id" value="${rentalTransactionInstance?.contactPrimary?.id}"/>--}%

  %{--<div style="width:200px;"--}%
       %{--class="checkout_value ${hasErrors(bean: rentalTransactionInstance, field: 'contactPrimary.firstName', 'errors')}">--}%
    %{--<g:textField id="contactPrimary.firstName" name="contactPrimary.firstName" style="width: 180px;" class="required"--}%
                 %{--value="${rentalTransactionInstance?.contactPrimary?.firstName}"/>--}%
  %{--</div>--}%

  %{--<div style="width:200px;"--}%
       %{--class="checkout_value ${hasErrors(bean: rentalTransactionInstance, field: 'contactPrimary.lastName', 'errors')}">--}%
    %{--<g:textField id="contactPrimary.lastName" name="contactPrimary.lastName" style="width: 180px;" class="required"--}%
                 %{--value="${rentalTransactionInstance?.contactPrimary?.lastName}"/>--}%
  %{--</div>--}%

  %{--<div style="width:100px;"--}%
       %{--class="checkout_value ${hasErrors(bean: rentalTransactionInstance, field: 'contactPrimary.suffixName', 'errors')}">--}%
    %{--<g:textField id="contactPrimary.suffixName" name="contactPrimary.suffixName" style="width: 80px;" class="ignore"--}%
                 %{--value="${rentalTransactionInstance?.contactPrimary?.suffixName}"/>--}%
  %{--</div>--}%

  %{--<div style="clear:both;"></div>--}%
%{--</div>--}%

%{--<div class="checkout_labels">--}%
  %{--<div class="checkout_name" style="width:200px;">--}%
    %{--<label for="contactPrimary.firstName">First Name</label>--}%
  %{--</div>--}%

  %{--<div class="checkout_name" style="width:200px;">--}%
    %{--<label for="contactPrimary.lastName">Last Name</label>--}%
  %{--</div>--}%

  %{--<div class="checkout_name" style="width:100px;">--}%
    %{--<label for="contactPrimary.suffixName">Suffix</label>--}%
  %{--</div>--}%

  %{--<div style="clear:both;"></div>--}%
%{--</div>--}%

  %{--<div style="width:315px;"--}%
       %{--class="checkout_value ${hasErrors(bean: rentalTransactionInstance, field: 'contactPrimary.address1', 'errors')}">--}%
    %{--<g:textField name="contactPrimary.address1" id="contactPrimary.address1" class="required" style="width:295px;"--}%
                 %{--value="${rentalTransactionInstance?.contactPrimary?.address1}"/>--}%
  %{--</div>--}%

  %{--<div style="width:315px;"--}%
       %{--class="checkout_value ${hasErrors(bean: rentalTransactionInstance, field: 'contactPrimary.address2', 'errors')}">--}%
    %{--<g:textField name="contactPrimary.address2" id="contactPrimary.address2" style="width:295px;" class="ignore"--}%
                 %{--value="${rentalTransactionInstance?.contactPrimary?.address2}"/>--}%
  %{--</div>--}%

  %{--<div style="width:315px;" class="checkout_name">--}%
    %{--<label for="contactPrimary.address1">Address line 1</label>--}%
  %{--</div>--}%

  %{--<div style="width:315px;" class="checkout_name">--}%
    %{--<label for="contactPrimary.address2">Address line 2</label>--}%
  %{--</div>--}%

%{--<div class="checkout_fields">--}%
  %{--<div style="width:200px;"--}%
       %{--class="checkout_value ${hasErrors(bean: rentalTransactionInstance, field: 'contactPrimary.city', 'errors')}">--}%
    %{--<g:textField name="contactPrimary.city" id="contactPrimary.city" class="required" style="width:180px;"--}%
                 %{--value="${rentalTransactionInstance?.contactPrimary?.city}"/>--}%
  %{--</div>--}%

  %{--<div id="primaryStateField" style="width:100px;"--}%
       %{--class="checkout_value ${hasErrors(bean: rentalTransactionInstance, field: 'contactPrimary.state', 'errors')}">--}%
    %{--<g:select name="contactPrimary.state" id="contactPrimary.state" class="state" style="width:80px;"--}%
              %{--from="${storitz.constants.State.list()}" value="${rentalTransactionInstance?.contactPrimary?.state}"--}%
              %{--optionValue="value"/>--}%
  %{--</div>--}%

  %{--<div style="width: 120px;display: none;" id="primaryProvinceField"--}%
       %{--class="checkout_value ${hasErrors(bean: rentalTransactionInstance, field: 'contactPrimary.province', 'errors')}">--}%
    %{--<g:textField name="contactPrimary.province" id="contactPrimary.province" class="province" style="width:100px;"--}%
                 %{--value="${rentalTransactionInstance?.contactPrimary?.province}"/>--}%
  %{--</div>--}%

  %{--<div style="width:100px;"--}%
       %{--class="checkout_value ${hasErrors(bean: rentalTransactionInstance, field: 'contactPrimary.zipcode', 'errors')}">--}%
    %{--<g:textField name="contactPrimary.zipcode" id="contactPrimary.zipcode" class="required zipcode" style="width:80px;"--}%
                 %{--value="${rentalTransactionInstance?.contactPrimary?.zipcode}"/>--}%
  %{--</div>--}%

  %{--<div style="width:200px;"--}%
       %{--class="checkout_value ${hasErrors(bean: rentalTransactionInstance, field: 'contactPrimary.country', 'errors')}">--}%
    %{--<g:select name="contactPrimary.country" id="contactPrimary-country" style="width:180px;" class="country"--}%
              %{--from="${storitz.constants.Country.list()}"--}%
              %{--value="${rentalTransactionInstance?.contactPrimary?.country?.key}" optionKey="key" optionValue="display"/>--}%
  %{--</div>--}%
%{--</div>--}%

%{--<div class="checkout_labels">--}%
  %{--<div style="width:200px;" class="checkout_name">--}%
    %{--<label for="contactPrimary.city">City</label>--}%
  %{--</div>--}%

  %{--<div style="width:100px;" id="primaryStateLabel" class="checkout_name">--}%
    %{--<label for="contactPrimary.state">State</label>--}%
  %{--</div>--}%

  %{--<div style="width: 120px;display: none;" id="primaryProvinceLabel" class="checkout_name">--}%
    %{--<label for="contactPrimary.province">Province</label>--}%
  %{--</div>--}%

  %{--<div style="width:100px;" class="checkout_name">--}%
    %{--<label for="contactPrimary.zipcode">Postal Code</label>--}%
  %{--</div>--}%

  %{--<div style="width:200px;" class="checkout_name">--}%
    %{--<label for="contactPrimary.country">Country</label>--}%
  %{--</div>--}%
%{--</div>--}%

%{--<div class="checkout_section_header">--}%
  %{--Phone / Email--}%
%{--</div>--}%

%{--<div class="checkout_fields">--}%
  %{--<div style="width:100px;"--}%
       %{--class="checkout_value ${hasErrors(bean: rentalTransactionInstance, field: 'contactPrimary.phoneType', 'errors')}">--}%
    %{--<g:select name="contactPrimary.phoneType" id="contactPrimary.phoneType" style="width:80px;"--}%
              %{--from="${storitz.constants.PhoneType.list()}"--}%
              %{--value="${rentalTransactionInstance?.contactPrimary?.phoneType}" optionValue="value"/>--}%
  %{--</div>--}%

  %{--<div style="width:200px;"--}%
       %{--class="checkout_value ${hasErrors(bean: rentalTransactionInstance, field: 'contactPrimary.phone', 'errors')}">--}%
    %{--<g:textField name="contactPrimary.phone" id="contactPrimary.phone" class="required phone" style="width:180px;"--}%
                 %{--value="${rentalTransactionInstance?.contactPrimary?.phone}"/>--}%
  %{--</div>--}%
%{--</div>--}%

%{--<div class="checkout_labels">--}%
  %{--<div style="width:100px;" class="checkout_name">--}%
    %{--<label for="contactPrimary.phoneType">Phone Type</label>--}%
  %{--</div>--}%

  %{--<div style="width:200px;" class="checkout_name">--}%
    %{--<label for="contactPrimary.phone">Phone Number (XXX-XXX-XXXX)</label>--}%
  %{--</div>--}%
%{--</div>--}%

%{--<div class="checkout_fields">--}%
  %{--<div style="width:300px;"--}%
       %{--class="checkout_value ${hasErrors(bean: rentalTransactionInstance, field: 'contactPrimary.email', 'errors')}">--}%
    %{--<g:textField name="contactPrimary.email" id="contactPrimary-email" class="required email" style="width:280px;"--}%
                 %{--value="${rentalTransactionInstance?.contactPrimary?.email}"/>--}%
  %{--</div>--}%

  %{--<div style="width:300px;"--}%
       %{--class="checkout_value ${hasErrors(bean: rentalTransactionInstance, field: 'contactPrimary.email', 'errors')}">--}%
    %{--<g:textField name="contactPrimary.emailRepeat" id="contactPrimary.emailRepeat" style="width:280px;"--}%
                 %{--value="${rentalTransactionInstance?.contactPrimary?.email}"/>--}%
  %{--</div>--}%
%{--</div>--}%

%{--<div class="checkout_labels">--}%
  %{--<div style="width:300px;" class="checkout_name">--}%
    %{--<label for="contactPrimary-email">Email</label>--}%
  %{--</div>--}%

  %{--<div style="width:300px;" class="checkout_name">--}%
    %{--<label for="contactPrimary.emailRepeat">Confirm Email</label>--}%
  %{--</div>--}%
%{--</div>--}%

%{--<div class="checkout_section_header">--}%
  %{--Rental Use--}%
%{--</div>--}%

%{--<div class="checkout_fields">--}%
  %{--<div id="rentalUse"--}%
       %{--class="validate-one-radio value ${hasErrors(bean: rentalTransactionInstance, field: 'rentalUse', 'errors')}">--}%
    %{--<g:radioGroup name="rentalUse" labels="${storitz.constants.RentalUse.labels()}"--}%
                  %{--values="${storitz.constants.RentalUse.list()}" value="${rentalTransactionInstance?.rentalUse}">--}%
      %{--<div class="left" style="width:200px;">${it.radio} ${it.label}</div>--}%
    %{--</g:radioGroup>--}%
  %{--</div>--}%
%{--</div>--}%

%{--<div style="height: 10px;"></div>--}%

%{--<div class="checkout_section_header">--}%
  %{--Active Military--}%
%{--</div>--}%

%{--<div class="formInstructions">--}%
  %{--Section 307 of the <a href="${resource(file: '/SCRA Section 307.pdf')}" onclick="window.open(this.href, '_blank');--}%
%{--return false;">Servicemembers Civil Relief Act</a> protects servicemembers currently serving or 90 days removed from a period of active duty against lien auctions on their property. Checking this box will protect your rights as a servicemember.--}%
%{--</div>--}%

%{--<div class="checkout_fields">--}%
  %{--<div class="value ${hasErrors(bean: rentalTransactionInstance, field: 'activeMilitary', 'errors')}">--}%
    %{--<div class="left"><g:checkBox name="activeMilitary" value="${rentalTransactionInstance?.activeMilitary}"/></div>--}%

    %{--<div class="checkBoxText">I am servicemember in the US Armed Forces and on a period of active duty</div>--}%

    %{--<div style="clear:both;"></div>--}%
  %{--</div>--}%

  %{--<div style="clear:both;"></div>--}%
%{--</div>--}%

%{--<div style="height: 10px;"></div>--}%
%{--<g:if test="${rentalTransactionInstance.site.freeTruck == storitz.constants.TruckType.FREE}">--}%
  %{--<div class="checkout_section_header">--}%
    %{--Free Truck--}%
  %{--</div>--}%

  %{--<div class="checkout_fields">--}%
    %{--<div class="value ${hasErrors(bean: rentalTransactionInstance, field: 'reserveTruck', 'errors')}">--}%
      %{--<div class="left"><g:checkBox name="reserveTruck" id="reserveTruck"--}%
                                    %{--value="${rentalTransactionInstance?.reserveTruck}"/></div>--}%

      %{--<div class="checkBoxText">Reserve Free Truck for this move in</div>--}%
    %{--</div>--}%
  %{--</div>--}%

  %{--<div style="height: 10px;"></div>--}%
%{--</g:if>--}%
%{--<g:elseif test="${rentalTransactionInstance.site.freeTruck == storitz.constants.TruckType.RENTAL}">--}%
  %{--<div class="checkout_section_header">--}%
    %{--Rental Truck--}%
  %{--</div>--}%

    %{--<div class="value ${hasErrors(bean: rentalTransactionInstance, field: 'reserveTruck', 'errors')}">--}%
      %{--<div class="left"><g:checkBox name="reserveTruck" id="reserveTruck"--}%
                                    %{--value="${rentalTransactionInstance?.reserveTruck}"/></div>--}%

      %{--<div class="checkBoxText">Reserve Rental Truck for this move in</div>--}%
    %{--</div>--}%
%{--</g:elseif>--}%
%{--<div class="checkout_section_header">--}%
  %{--Terms--}%
%{--</div>--}%

%{--<div class="checkout_fields">--}%
  %{--<textarea style="width:610px; height: 50px;" name="termText">--}%
    %{--Storage property owner does not carry insurance to cover the loss or damage of your items. Your existing Homeowner’s Insurance or Renter’s Insurance may cover items you keep in storage. Alternatively, you may select (are required to select) the level of monthly insurance coverage that you may pay for as part of your monthly rent.--}%
    %{--By Checking Here, I acknowledge that I am responsible for damage or loss to my goods while stored at Storage Property--}%
    %{--By checking here, I agree to not store hazardous items according to Federal Code, which includes but is not limited to Tires, Oil, Gasoline or Flammables, Paints, Environmental or Toxic Waste and Perishable Food.--}%
  %{--</textarea>--}%

  %{--<div id="termsHolder" style="margin-top:7px;"--}%
       %{--class="${hasErrors(bean: rentalTransactionInstance, field: 'terms', 'errors')}">--}%
    %{--<div class="left">--}%
      %{--<g:checkBox name="terms" id="terms" class="required" value="${rentalTransactionInstance?.terms}"/></div>--}%

    %{--<div class="checkBoxText">I agree to the <a href="${createLink(controller: 'static', action: 'terms')}"--}%
                                                %{--onclick="window.open(this.href, '_blank');--}%
                                                %{--return false;">Storitz Inc. Terms of Use</a>--}%
      %{--<g:if test="${rentalTransactionInstance.site.rentalAgreement}">--}%
        %{--and the <a href="${resource(file: rentalAgreement.stie.rentalAgreement.src())}" onclick="window.open(this.href, '_blank');--}%
      %{--return false;">${rentalTransactionInstance.site.feed.operatorName} Terms and Conditions</a>--}%
      %{--</g:if>--}%
    %{--</div>--}%
  %{--</div>--}%
%{--</div>--}%
%{--<sec:ifAnyGranted roles="ROLE_CALLCENTER">--}%
  %{--<div class="checkout_section_header">--}%
    %{--Call Center Notes--}%
  %{--</div>--}%

  %{--<div class="checkout_fields">--}%
    %{--<div style="width:100px;" class="checkout_value">--}%
      %{--<g:textField name="operatorInitials" id="operatorInitials" style="width:80px;" value="${operatorInitials}"/>--}%
    %{--</div>--}%
  %{--</div>--}%

  %{--<div class="checkout_labels">--}%
    %{--<div style="width:100px;" class="checkout_name">--}%
      %{--<label for="operatorInitials">Operator Initials</label>--}%
    %{--</div>--}%
  %{--</div>--}%

  %{--<div class="checkout_fields">--}%
    %{--<div style="width:500px;" class="checkout_value">--}%
      %{--<g:textArea name="operatorNote" id="operatorNote" style="width:480px;">${operatorNote}</g:textArea>--}%
    %{--</div>--}%
  %{--</div>--}%

  %{--<div class="checkout_labels">--}%
    %{--<div style="width:500px;" class="checkout_name">--}%
      %{--<label for="operatorNote">Operator Note</label>--}%
    %{--</div>--}%
  %{--</div>--}%
%{--</sec:ifAnyGranted>--}%
%{--<div style="margin-top: 20px;">--}%
  %{--<div class="left"><p:inputImage style="width:108px;height:36px;border:none;" src="btn-previous2.png"--}%
                                  %{--onclick="leave_form(); return false" alt="Back"/></div>--}%

  %{--<div class="right">--}%
    %{--<g:if test="${rentalTransactionInstance.site.transactionType == TransactionType.RESERVATION && rentalTransactionInstance.site.rentalFee == 0}">--}%
      %{--<p:inputImage style="width:108px;height:36px;border:none;" src="btn-reserve-108x36.png" alt="Reserve"/>--}%
    %{--</g:if>--}%
    %{--<g:else>--}%
      %{--<p:inputImage style="width:108px;height:36px;border:none;" src="btn-next2.png" alt="Next"/>--}%
    %{--</g:else>--}%
  %{--</div>--}%

%{--</div>--}%
%{--</g:form>--}%
%{--</div>--}%
</g:form>
</body>
</html>