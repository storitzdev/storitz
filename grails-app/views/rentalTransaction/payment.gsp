<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN"
    "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" >
  <head>
    <meta name="DESCRIPTION" content="Storitz self storage partner - ${site.title} located in ${site.city}, ${site.state.fullName} : ${site.description ? site.getTextDescription() : '' }"/>
    <g:render template="/header_ssl" />

<p:dependantJavascript>
    <script type="text/javascript">
//<![CDATA[
  var ajaxFormDirty = true;
  var ajaxServerPollTimer;
  var ajaxFormUpdateTimer;
  var ajaxFormNewValues;
  var ajaxFormOldValues;
  var urlAjaxUpdate = "${createLink(controller:'rentalTransaction', action: 'ajaxUpdate', id:shortSessionId)}";
  var urlAjaxPoll = "${createLink(controller:'rentalTransaction', action: 'ajaxPoll', id:shortSessionId)}";
  var srcSpinner = ${p.imageLink(src:'ajax-loader.gif')};


//]]>
  </script>
  <p:javascript src="callCenterPolling"/>
  <p:javascript src="payment"/>
</p:dependantJavascript>

  <script type="text/javascript">
  //<![CDATA[
    var _gaq = _gaq || [];
    _gaq.push(  ['pageTracker._setAccount', 'UA-16012579-1'],
                ['pageTracker._trackPageview'],
                ['funnelTracker._setAccount', 'UA-16012579-1'],
                ['funnelTracker._trackPageview', '/payment']);
    // Called a few ms after the page has loaded.
    (function() {
        var ga = document.createElement('script');
        ga.type = 'text/javascript';
        ga.async = true;
        ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
        var s = document.getElementsByTagName('script')[0];
        s.parentNode.insertBefore(ga, s); })();
  //]]>
  </script>

  </head>
  <body>
    <div id="body">
    <g:render template="/topnav" />
    <div class="stcontent">
      <g:render template="/logo_bar" />
      <div id="site_info" class="left" style="margin-top: 26px;">
        <g:render template="/siteInfo" />
      </div>

      <div style="width: 650px;" class="right">
        <div id="detailInfo">
            <div id="rentalForm">
              <g:form action="pay" controller="rentalTransaction" name="paymentTransaction" method="post" id="${params.id}">

                <input style="display:none" type="text" name="SC_page" id="SC_page" value="payment"/>

                <div class="vert_text" style="margin-top:10px;">
                  <span id="step1_bullet" class="bullet" style="display: none;">&#8226;</span><span id="step1" class="step_header">Renter Information</span>
                  <span id="step2_bullet" class="bullet">&#8226;</span><span id="step2" class="step_header_hi">Payment</span>
                  <span id="step3_bullet" class="bullet" style="display: none;">&#8226;</span><span id="step3" class="step_header">Order Complete</span>
                </div>

                <div class="paymentTotal" style="display:none;">
                  <ul>
                  <g:each var="item" in="${moveInDetails?.items}">
                    <li>${item.description} - tax=${item.tax} amount=${item.amount}</li>
                  </g:each>
                  </ul>
                  Total = ${moveInDetails?.total()}
                </div>

                <div class="transBox">
                  <div style="margin: 5px 15px 20px 15px;">
                    <div class="left">
                      <div class="transHeader">Unit Type</div>
                      <div class="specialOfferText selectedOffer">
                        ${unit.unitType.display}
                      </div>
                    </div>
                    <div class="left" style="margin-left:15px">
                      <div class="transHeader">Unit Size</div>
                      <div>
                        <div class="left specialOfferText selectedOffer">
                          ${unit.unitsize.description}
                        </div>
                      </div>
                    </div>
                    <div class="left" style="vertical-align: bottom; margin: 8px 0 0 15px;">
                      <g:if test="${unit.price > unit.pushRate}">
                        <div id="regPrice" class="transStrikethru"><g:formatNumber number="${unit.price}" currencyCode="USD" type="currency" /></div>
                        <div>
                          <div id="pushPrice" class="transPrice left red"><g:formatNumber number="${unit.pushRate}" currencyCode="USD" type="currency" /> </div>
                          <div class="transPerMonth left"> /Per Month</div>
                        </div>
                      </g:if>
                      <g:else>
                        <div>
                          <div id="pushPrice" class="transPrice left"><g:formatNumber number="${unit.pushRate}" currencyCode="USD" type="currency" /> </div>
                          <div class="transPerMonth left"> /Per Month</div>
                        </div>
                      </g:else>
                    </div>
                    <div class="right" style="margin-top:5px;">
                    </div>
                    <div style="height: 10px;clear:both;"></div>
                    <div class="left specialOfferText">
                      Selected Offer: <span id="selectedOffer" class="selectedOffer">${promo?.promoName}</span>
                    </div>
                    <div style="height: 10px;clear:both;"></div>
                    <div class="right">
                      <div id="costDetails" class="right">
                        <table id="costTotals">
                          <g:each var="item" in="${moveInDetails?.items}">
                            <tr>
                              <td>${item.description}</td>
                              <td class="costMoney"><g:formatNumber number="${item.amount}" type="currency" currencyCode="USD" /></td>
                            </tr>
                          </g:each>
                          <g:if test="${moveInDetails?.taxTotal() > 0}">
                          <tr id="taxBlock">
                            <td>Tax</td>
                            <td></td>
                            <td></td>
                            <td class="costMoney" id="taxTotal"><g:formatNumber number="${moveInDetails.taxTotal()}" type="currency" currencyCode="USD" /></td>
                          </tr>
                          </g:if>
                        </table>
                      </div>
                      <div style="clear:both;"></div>
                      <div class="right transTotalMoveIn">
                        <div class="left" style="margin-right: 120px;">
                          Total Move-In Cost:
                        </div>
                        <div class="left">
                          <a href="#" id="totalMoveInCost" onclick="Effect.toggle('costDetails', 'appear', { duration: 0.25 }); return false;"><g:formatNumber number="${moveInDetails.total()}" type="currency" currencyCode="USD" /></a>
                        </div>
                      </div>
                      <div style="clear:both;"></div>
                    </div>
                    <div style="height: 10px;clear:both;width: 626px; border-bottom:1px solid #dfdfdf;margin: 0 0 10px -3px;"></div>
                    <div class="left">
                      <div class="specialOfferText" style="width:400px;">
                        <div>Property</div> Protection: <span id="selectedInsurance" class="selectedOffer">
                          <g:if test="${ins}"> 
                            <g:formatNumber number="${ins.premium}" type="currency" currencyCode="USD" />/mo. Coverage: <g:formatNumber number="${ins.totalCoverage}" type="currency" currencyCode="USD" /> Theft: <g:formatNumber number="${ins.percentTheft}" type="percent" />
                          </g:if>
                        </span>
                      </div>
                    </div>
                    <div class="right">
                      <input type="hidden" id="date" name="date" />
                      <div class="left">
                        <div class="transDateHeader left">
                          Move-In Date:
                        </div>
                        <div style="clear:both;"></div>
                        <div class="transDate" id="transMoveInDate">
                          ${rentalTransactionInstance.moveInDate.format('MM/dd/yy')}
                        </div>
                      </div>
                      <div class="left" style="margin-left: 25px;">
                        <div class="transDateHeader">
                          Paid Through:
                        </div>
                        <div class="transDate" id="paidThruDate">
                          ${paidThruDate.format('MM/dd/yy')}
                        </div>
                      </div>
                    </div>
                    <div style="height: 10px;clear:both;"></div>
                  </div>
                </div>

                <div style="height:25px;"></div>

                <g:if test="${flash.message}">
                  <div class="message">${flash.message}</div>
                </g:if>

                <div class="price_options checkout_header white">
                  Payment Info
                </div>

                <div id="errorMessage" class="formErrors">
                  <div id="errorInfo" class="errorInfo"></div>
                  <div id="errorList" class="errorList"></div>
                </div>

                <div class="formInstructions">
                  All transactions are subject to credit card approval and billing address verification
                </div>

                <div class="checkout_section_header">
                  Billing Address
                </div>
                <div class="checkout_fields">
                  <div id="billingAddress" class="validate-one-radio value">
                      <div class="left" style="width:200px;">
                        <g:radio name="billingAddress" value="primary" checked="checked"/> Use Renter Information
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
                          <div style="width:200px;" class="checkout_value ${hasErrors(bean: rentalTransactionInstance, field: 'contactSecondary.firstName', 'errors')}">
                              <g:textField name="firstName" id="firstName" class="contactRequired" style="width: 180px;" value="${rentalTransactionInstance?.billingAddress?.firstName}" />
                          </div>
                          <div style="width:200px;" class="checkout_value ${hasErrors(bean: rentalTransactionInstance, field: 'lastName', 'errors')}">
                            <g:textField name="lastName" id="lastName" class="contactRequired" style="width: 180px;" value="${rentalTransactionInstance?.billingAddress?.lastName}" />
                          </div>
                          <div style="width:100px;" class="checkout_value ${hasErrors(bean: rentalTransactionInstance, field: 'suffixName', 'errors')}">
                            <g:textField name="suffixName" id="suffixName" style="width: 80px;" value="${rentalTransactionInstance?.billingAddress?.suffixName}" />
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
                          <div style="width:400px;" class="checkout_value ${hasErrors(bean: rentalTransactionInstance, field: 'address1', 'errors')}">
                              <g:textField name="address1" id="address1" class="contactRequired" style="width:380px;" value="${rentalTransactionInstance?.billingAddress?.address1}" />
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
                          <div style="width:400px;" class="checkout_value ${hasErrors(bean: rentalTransactionInstance, field: 'address2', 'errors')}">
                              <g:textField name="address2" id="address2" style="width:380px;" value="${rentalTransactionInstance?.billingAddress?.address2}" />
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
                          <div style="width:200px;" class="checkout_value ${hasErrors(bean: rentalTransactionInstance, field: 'city', 'errors')}">
                              <g:textField name="city" id="city" class="contactRequired" style="width:180px;" value="${rentalTransactionInstance?.billingAddress?.city}" />
                          </div>
                          <div id="secondaryStateField" style="width:100px;" class="checkout_value ${hasErrors(bean: rentalTransactionInstance, field: 'state', 'errors')}">
                            <g:select name="state" id="state" class="state" style="width:80px;" from="${storitz.constants.State.list()}" value="${rentalTransactionInstance?.billingAddress?.state}" optionValue="value"/>
                          </div>
                          <div id="secondaryProvinceField" class="checkout_value ${hasErrors(bean: rentalTransactionInstance, field: 'province', 'errors')}" style="width: 120px;display: none;">
                            <g:textField name="province" id="province" class="province" style="width:100px;" value="${rentalTransactionInstance?.billingAddress?.province}" />
                          </div>
                          <div style="width:100px;" class="checkout_value ${hasErrors(bean: rentalTransactionInstance, field: 'zipcode', 'errors')}">
                              <g:textField name="zipcode" id="zipcode" class="contactRequired zipcode" style="width:80px;" value="${rentalTransactionInstance?.billingAddress?.zipcode}" />
                          </div>
                          <div style="width:200px;" class="checkout_value ${hasErrors(bean: rentalTransactionInstance, field: 'country', 'errors')}">
                            <g:select name="country" id="country" style="width:180px;" class="country" from="${storitz.constants.Country.list()}" value="${rentalTransactionInstance?.billingAddress?.country?.key}" optionKey="key" optionValue="display"/>
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
                          <div style="width: 120px;display: none;" id="secondaryProvinceLabel" class="checkout_name">
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
                    <storitz:image src="credit-cards.gif" width="96" height="97" alt="Credit Cards" />
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
                      <sec:ifNotGranted roles="ROLE_CALLCENTER, ROLE_CALLCENTER_ADMIN">
                        <div style="width:80px;" class="checkout_name">
                          <label for="cc_cvv2">CVV2</label>
                        </div>
                      </sec:ifNotGranted>
                      <div style="clear:both;"></div>
                    </div>
                    <div class="checkout_fields">
                      <div style="width:200px;" class="checkout_value">
                          <g:textField name="cc_number" id="cc_number" class="required ccnumber" style="width:180px;" value="${cc_number}" />
                      </div>
                      <div style="width:50px;" class="checkout_value">
                        <g:select name="cc_month" from="${1..12}" value="${cc_month}"/>
                      </div>
                      <div style="width:80px;" class="checkout_value">
                        <g:select name="cc_year" from="${2010..2020}" value="${cc_year}"/>
                      </div>
                      <sec:ifNotGranted roles="ROLE_CALLCENTER, ROLE_CALLCENTER_ADMIN">
                        <div style="width:80px;" class="checkout_value">
                          <g:textField name="cc_cvv2" id="cc_cvv2" class="required digits" style="width:80px;" value="${cc_cvv2}" />
                        </div>
                      </sec:ifNotGranted>
                    </div>
                    <div style="clear:both;"></div>
                  </div>
                </div>
                <div style="clear:both; margin-top: 20px;">
                  <div class="right"><p:inputImage style="width:108px;height:36px;border:none;" src="btn-pay-now.png" alt="Pay Now"/></div>
                  <div class="left"><p:inputImage style="width:108px;height:36px;border:none;" src="btn-previous2.png" onClick="window.history.back();" alt="Prev"/></div>
                  <div style="clear:both;"></div>
                </div>
              </g:form>
            </div>
        </div>
      </div>
    </div>

    <div style="clear:both; height:30px;"></div>
    <div id="helpDeskStatus">STATUS</div>
    <g:render template="/footer_no_analytics" />
    </div>
  </body>
  <p:renderDependantJavascript />
</html>