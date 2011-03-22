<%@ page import="storitz.constants.TransactionType" %>
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN"
    "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head>
  <g:render template="/header_ssl"/>

  <script type="text/javascript">
    //<![CDATA[

    function setupJQueryTabs() {
      $("#operatingHours").tabs();
    }

    $(document).ready(function() {
      setupJQueryTabs();
    });

    var _gaq = _gaq || [];
    _gaq.push(['pageTracker._setAccount', 'UA-16012579-1'],
            ['pageTracker._setDomain', '.storitz.com'],
            ['pageTracker._trackPageview'],
            ['funnelTracker._setAccount', 'UA-16012579-1'],
            ['funnelTracker._setDomain', '.storitz.com'],
            ['funnelTracker._trackPageview', '/complete']);

    (function() {
      var ga = document.createElement('script');
      ga.type = 'text/javascript';
      ga.async = true;
      ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
      var s = document.getElementsByTagName('script')[0];
      s.parentNode.insertBefore(ga, s);
    })();
    //]]>
  </script>

</head>
<body>
<div id="body">
  <g:render template="/topnav"/>
  <div class="stcontent">
    <g:render template="/logo_bar"/>
    <div id="site_info" class="left" style="margin-top: 26px;">
      <g:render template="/siteInfo"/>
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
          <a href="#" onclick="window.print();
          return false;">print</a>
        </div>

        <div class="price_options checkout_header white">
          Checkout Confirmation
        </div>
        <g:if test="${rentalTransactionInstance.site.transactionType == TransactionType.RESERVATION}">
          <div class="formInstructions">
            Congratulations, you have successfully reserved a self-storage unit. We thank you for choosing Storitz and making your experience as easy as Click. Store. Done.
            Below is a summary of your transaction.
          </div>
        </g:if>
        <g:else>
          <div class="formInstructions">
            Congratulations, you have successfully rented a self-storage unit. We thank you for choosing Storitz and making your experience as easy as Click. Store. Done.
            Below is a summary of your transaction.
          </div>
        </g:else>
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
              <td><g:formatNumber number="${rentalTransactionInstance.monthlyRate}" type="currency" currencyCode="USD"/></td>
            </tr>
            <tr>
              <td style="width:200px;">Rent is Paid Through:</td>
              <td>${rentalTransactionInstance.paidThruDate.format('MM/dd/yy')}</td>
            </tr>
            <tr>
              <td style="width:200px;">Unit Size:</td>
              <td>${rentalTransactionInstance.displaySize}</td>
            </tr>
            <g:if test="${promo}">
              <tr>
                <td style="width:200px;">Promotion Discount(s):</td>
                <td>${promo.promoName}</td>
              </tr>
            </g:if>
            <g:if test="${rentalTransactionInstance.site.transactionType == TransactionType.RESERVATION}">
              <tr>
                <td style="width:200px;">Reservation Fee:</td>
                <td><g:formatNumber number="${rentalTransactionInstance.cost}" type="currency" currencyCode="USD"/></td>
              </tr>
              <tr>
                <td style="width:200px;">Total Due at Move In:</td>
                <td><g:formatNumber number="${rentalTransactionInstance.moveInCost}" type="currency" currencyCode="USD"/></td>
              </tr>
            </g:if>
            <g:else>
              <tr>
                <td style="width:200px;">Move-In Cost:</td>
                <td><g:formatNumber number="${rentalTransactionInstance.cost}" type="currency" currencyCode="USD"/></td>
              </tr>
            </g:else>
          </table>
        </div>

        <g:if test="${rentalTransactionInstance.site.transactionType == TransactionType.RESERVATION}">
          <div style="height: 30px;"></div>
          <p>
            Your reservation fee will be credited to your move-in cost on the day of your move-in.  Some facilities may require that you purchase insurance on the day of your move-in at an additional charge.  If you have
            renter's insurance, bring proof to the facility on your move-in date.
          </p>
        </g:if>

        <div style="height: 30px;"></div>
        <g:if test="${site.rentalAgreement}">
          <p>
            Before move-in, please review and print out a copy of your <a href="${resource(file: site.rentalAgreement.src())}" onclick="window.open(this.href, '_blank');
          return false;">lease agreement</a>.
          </p>
        </g:if>
        <p>
          For easy directions to your storage facility from your billing address, please click <g:link controller="storageSite" action="directions" id="${rentalTransactionInstance.site.id}">here</g:link>.
        </p>
        <p>
          If you have any questions or concerns regarding your experience with Storitz, please contact us.
        </p>
        <div>Phone: (877) 456-2929</div>
        <div>Email: <a href="mailto:info@storitz.com">info@storitz.com</a></div>
        <p>
          Sincerely,
          Storitz, Inc.
        </p>

        <div class="right" style="margin: 20px 10px 0 0;">
          <a href="#" onclick="window.print();
          return false;">print</a>
        </div>

      </div>
    </div>
  </div>
  <div style="clear:both; height:30px;"></div>
  <g:render template="/footer_no_analytics"/>
  <!-- Google Code for Bookings Conversion Page -->
  <script type="text/javascript">
    /* <![CDATA[ */
    var google_conversion_id = 1017239961;
    var google_conversion_language = "en";
    var google_conversion_format = "2";
    var google_conversion_color = "ffffff";
    var google_conversion_label = "bz-3CLei_QEQmbOH5QM";
    var google_conversion_value = 0;
    /* ]]> */
  </script>
  <script type="text/javascript" src="https://www.googleadservices.com/pagead/conversion.js">
  </script>
  <noscript>
    <div style="display:inline;">
      <img height="1" width="1" style="border-style:none;" alt="" src="http://www.googleadservices.com/pagead/conversion/1017239961/?label=bz-3CLei_QEQmbOH5QM&amp;guid=ON&amp;script=0"/>
    </div>
  </noscript>
</div>
</body>
<p:renderDependantJavascript/>
</html>