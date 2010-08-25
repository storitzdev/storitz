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
              Congratulations, you have successfully rented a self-storage unit. We thank you for choosing Storitz and making your experience as easy as Click. Store. Done.
              Below is a summary of your transaction.
            </div>

            <div class="checkout_section_header">
              Rental Summary
            </div>
            <div style="height: 10px;"></div>
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
                  <td>${siteManager?.userRealName}</td>
                </tr>
              </table>
            </div>
            <div style="height: 20px;"></div>

            <div class="checkout_section_header">
              Billing Summary
            </div>
            <div style="height: 10px;"></div>
            <div>
              <table class="checkoutComplete">
                <g:if test="${rentalTransactionInstance.idNumber}"> 
                  <tr>
                    <td class="tright">Transaction #:</td>
                    <td>${rentalTransactionInstance.idNumber}</td>
                  </tr>
                </g:if>
                <tr>
                  <td class="tright">Name:</td>
                  <td>${rentalTransactionInstance.billingAddress.firstName} ${rentalTransactionInstance.billingAddress.lastName}</td>
                </tr>
                <tr>
                  <td class="tright">Address:</td>
                  <td>${rentalTransactionInstance.billingAddress.address1} ${rentalTransactionInstance.billingAddress.address2}, ${rentalTransactionInstance.billingAddress.city}, ${rentalTransactionInstance.billingAddress.state.display} ${rentalTransactionInstance.billingAddress.zipcode}</td>
                </tr>
                <tr>
                  <td class="tright">Payment Method:</td>
                  <td>Credit Card</td>
                </tr>
                <tr>
                  <td class="tright">Credit Card #:</td>
                  <td>${ccNum}</td>
                </tr>
                <tr>
                  <td class="tright">Rental Rate:</td>
                  <td><g:formatNumber number="${unit?.pushRate}" type="currency" currencyCode="USD"/></td>
                </tr>
                <tr>
                  <td class="tright">Rent is Paid Through:</td>
                  <td>${rentalTransactionInstance.paidThruDate.format('MM/dd/yy')}</td>
                </tr>
                <g:if test="${promo}">
                  <tr>
                    <td class="tright">Promotion Discount(s):</td>
                    <td>${promo.promoName}</td>
                  </tr>
                </g:if>
                <tr>
                  <td class="tright">Move-In Cost:</td>
                  <td><g:formatNumber number="${rentalTransactionInstance.cost}" type="currency" currencyCode="USD"/></td>
                </tr>
              </table>
            </div>

            <div style="height: 30px;"></div>
            <g:if test="${site.rentalAgreement}">
              <p>
                Before move-in, please review and print out a copy of your <a href="${resource(file:site.rentalAgreement.src())}" target="_blank">lease agreement</a>.
              </p>
            </g:if>
            <p>
              For easy directions to your storage facility from your billing address, please click <g:link controller="storageSite" action="directions" id="${rentalTransactionInstance.site.id}">here</g:link>.
            </p>
            <p>
              If you have any questions or concerns regarding your experience with Storitz, please contact us.
            </p>
            <p>
              <div>Phone: (877) 456-2929</div>
              <div>Email: <a href="mailto:info@storitz.com">info@storitz.com</a></div>
            </p>
            <p>
              Sincerely,
              Storitz, Inc.
            </p>

          </div>
        </div>

        <div style="clear:both; height:30px;"></div>
        <g:render template="/footer" />
        <g:render template="/size_popup" />
      </div>
    </div>
  </body>
</html>