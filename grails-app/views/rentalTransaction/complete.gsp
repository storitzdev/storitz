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
            <div class="right" style="margin: 0 10px 20px 0;">
              <a href="#" onclick="window.print(); return false;">print</a>
            </div>

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
                  <td style="width:200px;">Tenant Name:</td>
                  <td>${rentalTransactionInstance.contactPrimary.firstName} ${rentalTransactionInstance.contactPrimary.lastName}</td>
                </tr>
                <tr>
                  <td style="width:200px;">Confirmation #:</td>
                  <td>${rentalTransactionInstance.bookingDate.format('yyyyMMdd')}${sprintf('%08d', rentalTransactionInstance.id)}</td>
                <tr>
                  <td style="width:200px;">Order Date:</td>
                  <td>${rentalTransactionInstance.bookingDate.format('MM/dd/yy')}</td>
                </tr>
                <tr>
                  <td style="width:200px;">Move-in Date:</td>
                  <td>${rentalTransactionInstance.moveInDate.format('MM/dd/yy')}</td>
                </tr>
                <tr>
                  <td style="width:200px;">Property Name:</td>
                  <td>${rentalTransactionInstance.site.title}</td>
                </tr>
                <tr>
                  <td style="width:200px;">Address:</td>
                  <td>
                    ${rentalTransactionInstance.site.getFullAddress()}
                  </td>
                </tr>
                <g:if test="${rentalTransactionInstance.accessCode}">
                  <tr>
                    <td style="width:200px;">Gate Access Code:</td>
                    <td>${rentalTransactionInstance.accessCode}</td>
                  </tr>
                </g:if>
                <tr>
                  <td style="width:200px;">Phone:</td>
                  <td>${rentalTransactionInstance.site.phone}</td>
                </tr>
                <g:if test="${siteManager?.userRealName}">
                  <tr>
                    <td style="width:200px;">Manager:</td>
                    <td>${siteManager.userRealName}</td>
                  </tr>
                </g:if>
                <g:if test="${rentalTransactionInstance.site.phone}">
                  <tr>
                    <td style="width:200px;">Phone:</td>
                    <td>${rentalTransactionInstance.site.phone}</td>
                  </tr>
                </g:if>
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
                    <td style="width:200px;">Transaction #:</td>
                    <td>${rentalTransactionInstance.idNumber}</td>
                  </tr>
                </g:if>
                <g:elseif test="${rentalTransactionInstance.reserved}">
                  <tr>
                    <td style="width:200px;">Transaction #:</td>
                    <td>R${rentalTransactionInstance.reservationId}</td>
                  </tr>
                </g:elseif>
                <tr>
                  <td style="width:200px;">Name:</td>
                  <td>${rentalTransactionInstance.billingAddress.fullName()}</td>
                </tr>
                <tr>
                  <td style="width:200px;">Address:</td>
                  <td>${rentalTransactionInstance.billingAddress.fullAddress()}</td>
                </tr>
                <tr>
                  <td style="width:200px;">Payment Method:</td>
                  <td>Credit Card</td>
                </tr>
                <tr>
                  <td style="width:200px;">Credit Card #:</td>
                  <td>${rentalTransactionInstance.cleanCCNum}</td>
                </tr>
                <tr>
                  <td style="width:200px;">Rental Rate:</td>
                  <td><g:formatNumber number="${unit?.pushRate}" type="currency" currencyCode="USD"/></td>
                </tr>
                <tr>
                  <td style="width:200px;">Rent is Paid Through:</td>
                  <td>${rentalTransactionInstance.paidThruDate.format('MM/dd/yy')}</td>
                </tr>
                <g:if test="${promo}">
                  <tr>
                    <td class="tright" style="width:200px;">Promotion Discount(s):</td>
                    <td>${promo.promoName}</td>
                  </tr>
                </g:if>
                <tr>
                  <td style="width:200px;">Move-In Cost:</td>
                  <td><g:formatNumber number="${rentalTransactionInstance.cost}" type="currency" currencyCode="USD"/></td>
                </tr>
              </table>
            </div>

            <div style="height: 30px;"></div>
            <g:if test="${site.rentalAgreement}">
              <p>
                Before move-in, please review and print out a copy of your <a href="${resource(file:site.rentalAgreement.src())}" onclick="window.open(this.href,'_blank');return false;">lease agreement</a>.
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

            <div class="right" style="margin: 20px 10px 0 0;">
              <a href="#" onclick="window.print(); return false;">print</a>
            </div>

          </div>
        </div>

        <div style="clear:both; height:30px;"></div>
        <g:render template="/footer" />
        <g:render template="/size_popup" />
      </div>
    </div>
  </body>
</html>