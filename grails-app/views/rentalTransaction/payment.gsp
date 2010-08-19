<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN"
    "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" >
  <head>
    <g:render template="/header" />

    <script type="text/javascript">
//<![CDATA[
  var startDate = "${rentalTransactionInstance.moveInDate.format('MM/dd/yy')}";
  var siteId = ${rentalTransactionInstance.site.id};

  <g:render template="/transaction_js"/>

  function contactChange() {
    $('billingAddress').observe('click', function() {
      var contactType =  $('billingAddress').select('input:checked[type=radio]').pluck('value');
      if (contactType == 'new') {
        $('newContact').show();
      } else {
        $('newContact').hide();
      }
    });
  }

  function validateForm() {
    var valid = true;
    valid &= Validation.validate('cc_number');
    valid &= Validation.validate('cc_cvv2');
    var contactType =  $('billingAddress').select('input:checked[type=radio]').pluck('value');
    if (contactType == 'new') {
      valid &= Validation.validate('firstName');
      valid &= Validation.validate('lastName');
      valid &= Validation.validate('streetNumber');
      valid &= Validation.validate('street');
      valid &= Validation.validate('city');
      valid &= Validation.validate('state');
      valid &= Validation.validate('zipcode');
    }
    return valid;
  }

  function nextStep() {
    if (validateForm()) {
      $('rentalTransaction').submit();
    }
  }

  function createMap() {}

  Event.observe(window, 'load', function() {
    contactChange();
    setupCalendar();
    transactionFormSetup();
    updateTransaction();
  });
//]]>
  </script>

  </head>
  <body>
    <div id="body">
    <g:render template="/topnav" />
    <div id="stcontent">
      <g:render template="/logo_bar" />
      <div id="site_info" class="left" style="margin-top: 26px;">
        <g:render template="/siteInfo" />
      </div>

      <div style="width: 650px;" class="right">
        <div id="detailInfo">
            <div id="rentalForm">
              <g:form action="pay" controller="rentalTransaction" name="rentalTransaction" method="post" id="${params.id}">

                <input type="hidden" name="unitId" id="unitId" value="${rentalTransactionInstance?.unitId}" />
                <input type="hidden" name="promoId" id="promoId" value="${rentalTransactionInstance?.promoId}" />
                <input type="hidden" name="moveInDate" id="moveInDate" value="${rentalTransactionInstance?.moveInDate}" />
                <input style="display:none" type="text" name="SC_date" id="SC_date" value="${params.date}"/>
    
                <div class="vert_text">
                  <span id="step1_bullet" class="bullet" style="display: none;">&#8226;</span><span id="step1" class="step_header">Primary Contact</span>
                  <span id="step3_bullet" class="bullet" style="display: none;">&#8226;</span><span id="step3" class="step_header">Rental Options</span>
                  <span id="step4_bullet" class="bullet">&#8226;</span><span id="step4" class="step_header_hi">Payment</span>
                  <span id="step5_bullet" class="bullet" style="display: none;">&#8226;</span><span id="step5" class="step_header">Order Complete</span>
                </div>

                <div id="transaction">
                  <g:render template="/transaction" />
                </div>

                <div style="height:25px;"></div>

                <g:if test="${flash.message}">
                  <div class="message">${flash.message}</div>
                </g:if>

                <div class="price_options checkout_header white">
                  Payment Info
                </div>
                <div class="formInstructions">
                  The billing address will be used to verify your credit card payment - card holder name and address should match the billing
                  address.  If it matches the primary contact you already entered, choose accordingly.  If not, enter a new contact.
                </div>

                <div class="checkout_section_header">
                  Billing Address
                </div>
                <div class="checkout_fields">
                  <div id="billingAddress" class="validate-one-radio value">
                      <div class="left" style="width:200px;">
                        <g:radio name="billingAddress" value="primary" checked="checked"/> Primary Contact Address
                      </div>
                      <div class="left" style="width:200px;">
                        <g:radio name="billingAddress" value="new"/> Enter new address
                      </div>
                      <div style="height: 10px;clear: both;"></div>

                      <div id="newContact" style="display:none;">
                        <div class="checkout_section_header">
                          Name
                        </div>
                        <div class="checkout_fields">
                          <div style="width:200px;" class="checkout_value ${hasErrors(bean: rentalTransaction, field: 'contactSecondary.firstName', 'errors')}">
                              <g:textField name="firstName" id="firstName" class="required" style="width: 180px;" value="${rentalTransaction?.billingAddress?.firstName}" />
                          </div>
                          <div style="width:200px;" class="checkout_value ${hasErrors(bean: rentalTransaction, field: 'lastName', 'errors')}">
                            <g:textField name="lastName" id="lastName" class="required" style="width: 180px;" value="${rentalTransaction?.billingAddress?.lastName}" />
                          </div>
                          <div style="width:100px;" class="checkout_value ${hasErrors(bean: rentalTransaction, field: 'suffixName', 'errors')}">
                            <g:textField name="suffixName" id="suffixName" style="width: 80px;" value="${rentalTransaction?.billingAddress?.suffixName}" />
                          </div>
                          <div style="clear:both;"></div>
                        </div>
                        <div class="checkout_labels">
                          <div class="checkout_name" style="width:200px;">
                            <label for="firstName">First Name</label>
                          </div>
                          <div class="checkout_name" style="width:200px;">
                            <label for="lastName">Last Name</label>
                          </div>
                          <div class="checkout_name" style="width:100px;">
                            <label for="suffixName">Suffix</label>
                          </div>
                          <div style="clear:both;"></div>
                        </div>
                        <div class="checkout_section_header">
                          Address
                        </div>
                        <div class="checkout_fields">
                          <div style="width:400px;" class="checkout_value ${hasErrors(bean: rentalTransaction, field: 'address1', 'errors')}">
                              <g:textField name="address1" id="address1" class="required" style="width:380px;" value="${rentalTransaction?.billingAddress?.address1}" />
                          </div>
                          <div style="clear:both;"></div>
                        </div>
                        <div class="checkout_labels">
                          <div style="width:400px;" class="checkout_name">
                            <label for="address1">Address line 1</label>
                          </div>
                          <div style="clear:both;"></div>
                        </div>
                        <div class="checkout_fields">
                          <div style="width:400px;" class="checkout_value ${hasErrors(bean: rentalTransaction, field: 'address2', 'errors')}">
                              <g:textField name="address2" id="address2" style="width:380px;" value="${rentalTransaction?.billingAddress?.address2}" />
                          </div>
                          <div style="clear:both;"></div>
                        </div>
                        <div class="checkout_labels">
                          <div style="width:400px;" class="checkout_name">
                            <label for="address2">Address line 2</label>
                          </div>
                          <div style="clear:both;"></div>
                        </div>
                        <div class="checkout_fields">
                          <div style="width:200px;" class="checkout_value ${hasErrors(bean: rentalTransaction, field: 'city', 'errors')}">
                              <g:textField name="city" id="city" class="required" style="width:180px;" value="${rentalTransaction?.contactSecondary?.city}" />
                          </div>
                          <div id="secondaryStateField" style="width:100px;" class="checkout_value ${hasErrors(bean: rentalTransaction, field: 'state', 'errors')}">
                            <g:select name="state" id="state" class="validate-selection" style="width:80px;" from="${storitz.constants.State.list()}" value="${rentalTransaction?.contactSecondary?.state}" optionValue="value"/>
                          </div>
                          <div id="secondaryProvinceField" class="checkout_value ${hasErrors(bean: rentalTransaction, field: 'province', 'errors')}" style="width: 200px;display: none;">
                            <g:textField name="province" id="province" class="required" style="width:180px;" value="${rentalTransaction?.contactSecondary?.province}" />
                          </div>
                          <div style="width:100px;" class="checkout_value ${hasErrors(bean: rentalTransaction, field: 'zipcode', 'errors')}">
                              <g:textField name="zipcode" id="zipcode" class="required" style="width:80px;" value="${rentalTransaction?.contactSecondary?.zipcode}" />
                          </div>
                          <div style="width:200px;" class="checkout_value ${hasErrors(bean: rentalTransaction, field: 'country', 'errors')}">
                            <g:select name="country" id="country" style="width:180px;" from="${storitz.constants.Country.list()}" value="${rentalTransaction?.contactSecondary?.country?.key}" optionKey="key" optionValue="display"/>
                          </div>
                          <div style="clear:both;"></div>
                        </div>
                        <div class="checkout_labels">
                          <div style="width:200px;" class="checkout_name">
                            <label for="city">City</label>
                          </div>
                          <div style="width:100px;" id="secondaryStateLabel" class="checkout_name">
                            <label for="state">State</label>
                          </div>
                          <div style="width: 200px;display: none;" id="secondaryProvinceLabel" class="checkout_name">
                            <label for="province">Province</label>
                          </div>
                          <div style="width:100px;" class="checkout_name">
                            <label for="zipcode">Postal Code</label>
                          </div>
                          <div style="width:200px;" class="checkout_name">
                            <label for="country">Country</label>
                          </div>
                          <div style="clear:both;"></div>
                        </div>
                        
                      </div>
                      <div style="clear:both;"></div>
                  </div>
                </div>
                <div style="height: 20px;"></div>

                <div class="checkout_section_header">
                  Credit Card Info
                </div>
                <div style="height: 10px;"></div>
                <div>
                  <div class="left">
                    <img src="${resource(dir:'images', file:'credit-cards.gif')}" alt="Credit Cards" />
                  </div>
                  <div class="left">
                    <div class="checkout_labels">
                      <div style="width:200px;" class="checkout_name">
                        <label for="cc_number">Card Number</label>
                      </div>
                      <div style="width:50px;" class="checkout_name">
                        <label for="cc_month">Month</label>
                      </div>
                      <div style="width:80px;" class="checkout_name">
                        <label for="cc_year">Year</label>
                      </div>
                      <div style="width:80px;" class="checkout_name">
                        <label for="cc_cvv2">CVV2</label>
                      </div>
                    </div>
                    <div class="checkout_fields">
                      <div style="width:200px;" class="checkout_value">
                          <g:textField name="cc_number" id="cc_number" class="required validate-credit-card" style="width:180px;" value="${cc_number}" />
                      </div>
                      <div style="width:50px;" class="checkout_value">
                        <g:select name="cc_month" from="${1..12}" value="${cc_month}"/>
                      </div>
                      <div style="width:80px;" class="checkout_value">
                        <g:select name="cc_year" from="${2010..2020}" value="${cc_year}"/>
                      </div>
                      <div style="width:80px;" class="checkout_value">
                        <g:textField name="cc_cvv2" id="cc_cvv2" class="required validate-digits" style="width:80px;" value="${cc_cvv2}" />
                      </div>
                    </div>
                    <div style="clear:both;"></div>
                  </div>
                </div>
                <div style="clear:both; margin-top: 20px;">
                  <div class="right"><input type="image" style="border:none;" src="${resource(dir:'images', file:'btn-pay-now.png')}" onclick="nextStep()" alt="Pay Now"/></div>
                  <!--
                  //TODO - make working back link
                  <g:link controller="home" action="index" params="[size: params.searchSize, date: params.date, address: params.address]">
                    <img src="${resource(dir:'images', file:'btn-previous2.png')}" style="border: 0; cursor: pointer;" alt="back home"/>
                  </g:link>
                  -->
                  <div class="left"><input type="image" style="border:none;" src="${resource(dir:'images', file:'btn-previous2.png')}" onclick="prevStep3(); return false" alt="Prev"/></div>
                  <div style="clear:both;"></div>
                </div>
              </g:form>
            </div>
        </div>
      </div>
    </div>

    <div style="clear:both; height:30px;"></div>
    <g:render template="/footer" />
    <g:render template="/size_popup" />
    <script type="text/javascript" src="http://www.google.com/jsapi?autoload=%7B%22modules%22%3A%5B%7B%22name%22%3A%22maps%22%2C%22version%22%3A%223.x%22%2Cother_params%3A%22sensor%3Dfalse%22%2C%22callback%22%3A%22createMap%22%7D%2C%7B%22name%22%3A%22gdata%22%2C%22version%22%3A%222.x%22%2C%22packages%22%3A%5B%22maps%22%5D%7D%5D%7D&amp;key=ABQIAAAAEDNru_s_vCsZdWplqCj4hxSjGMYCLTKEQ0TzQvUUxxIh1qVrLhTUMUuVByc3xGunRlZ-4Jv6pHfFHA"></script>
    </div>
  </body>
</html>