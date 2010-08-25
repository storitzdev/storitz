<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN"
    "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" >
  <head>
    <g:render template="/header" />

    <script type="text/javascript">
//<![CDATA[
  Event.observe(window, 'load', function() {
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
                  <span id="step4_bullet" class="bullet" style="display: none;">&#8226;</span><span id="step4" class="step_header">Payment</span>
                  <span id="step5_bullet" class="bullet">&#8226;</span><span id="step5" class="step_header_hi">Order Complete</span>
                </div>

                <div style="height:25px;"></div>

                <div class="price_options checkout_header white">
                  Checkout Confirmation
                </div>
                <div class="formInstructions">
                  Congratulations, you are now the lucky renter of a self-storage unit. We thank you for choosing Storitz and making your experience as easy as Click. Store. Done.
                  Below is a summary of your transaction.
                </div>

                <div class="checkout_section_header">
                  Rental Summary
                </div>
                <div>
                  <table class="checkoutComplete">
                    <tr>
                      <td class="tright">Tenant Name:</td>
                      <td>${rentalTransactionInstance.contactPrimary.firstName} ${rentalTransactionInstance.contactPrimary.lastName}</td>
                    </tr>
                    <tr>
                      <td class="tright">Confirmation #:</td>
                      <td></td>
                    <tr>
                      <td class="tright">Order Date:</td>
                      <td>${rentalTransactionInstance.bookingDate.format('MM/dd/yy')}</td>
                    </tr>
                    <tr>
                      <td class="tright">Move-in Date:</td>
                      <td>${rentalTransactionInstance.moveInDate.format('MM/dd/yy')}</td>
                    </tr>
                    <tr>
                      <td class="tright">Property Name:</td>
                      <td>${rentalTransactionInstance.site.title}</td>
                    </tr>
                    <tr>
                      <td class="tright">Address:</td>
                      <td>
                        ${rentalTransactionInstance.site.address1} ${rentalTransactionInstance.site.address2},
                        ${rentalTransactionInstance.site.city},
                        ${rentalTransactionInstance.site.state.display} ${rentalTransactionInstance.site.zipcode}
                      </td>
                    </tr>
                    <g:if test="${rentalTransactionInstance.accessCode}"> 
                      <tr>
                        <td class="tright">Gate Access Code:</td>
                        <td>${rentalTransactionInstance.accessCode}</td>
                      </tr>
                    </g:if>
                    <tr>
                      <td class="tright">Phone:</td>
                      <td>${rentalTransactionInstance.site.phone}</td>
                    </tr>
                    <tr>
                      <td class="tright">Manager:</td>
                      <td>${siteManager.userRealName}</td>
                    </tr>

                  </table>
                </div>
                <div style="height: 20px;"></div>

                <div class="checkout_section_header">
                  Billing Summary
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
                  <div class="left"><input type="image" style="border:none;" src="${resource(dir:'images', file:'btn-previous2.png')}" onclick="prevStep(); return false" alt="Prev"/></div>
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
    </div>
  </body>
</html>