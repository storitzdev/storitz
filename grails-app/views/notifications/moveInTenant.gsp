<%@ page import="java.text.DateFormat" contentType="text/html" %>
<html>
  <head>
    <title>Storitz Move-In Notification</title>
  </head>
  <body>
  <div>
    <div style="z-index: 100; float: left; margin-top: 22px;">
      <g:link controller="home" action="index">
        <img src="${createLinkTo(dir:'images', file:'logo_storitz.gif', absolute: true)}" style="border-style: none;" alt="Storitz Logo"/>
      </g:link>
    </div>
    <div style="clear: both;"></div>
  </div>
  <div style="margin-left: 50px;">
    <img src="${createLinkTo(dir:'images', file:'tagline_clickstoredone.gif', absolute:true)}" style="border-style: none;" alt="Click. Store. Done."/>
  </div>
  <div style="height: 3em;"></div>

  <p>
    ${DateFormat.getDateInstance(DateFormat.FULL, Locale.US).format(new Date())}
  </p>
  <p>
    Dear ${tenantName},
  </p>
  <p>
    Thank you for choosing Storitz! We hope your experience was as easy as Click. Store. Done.
  </p>
  <p style="font-weight:bold;">
    Rental Summary:
  </p>
  <ul>
    <li>Tenant name: ${tenantName}</li>
    <li>Confirmation #: ${storitzId}</li>
    <li>Order Date: ${bookingDate}</li>
    <li>Move-in Date: ${moveInDate}</li>
    <li>Property Name: ${siteName}</li>
    <li>Property Address: ${siteAddress}</li>
    <li>Directions: <a href="${directionsLink}">click here</a></li>
    <li>Phone: ${phone}</li>
    <li>Manager: ${manager}</li>
    <g:if test="${gateAccessCode}">
      <li>Gate Access Code: ${gateAccessCode}</li>
    </g:if>
  </ul>
  <p style="font-weight:bold;">
    Billing Summary:
  </p>
  <ul>
    <li>Storitz ID#: ${storitzId}</li>
    <li>Name: ${billingName}</li>
    <li>Address: ${billingAddress}</li>
    <li>Payment type: Credit Card</li>
    <li>Credit Card number: ${ccNum}</li>
    <li>Rental Rate: ${rentalRate}</li>
    <li>Rent is Paid Through: ${paidThruDate}</li>
    <li>Promotion(s): ${promoName}</li>
    <li>Payment Received: ${paymentTotal}</li>
  </ul>
  <div style="height: 30px;"></div>
  <g:if test="${rentalAgreementLink}">
    <p>
      Before move-in, please review and print out a copy of your <a href="${rentalAgreementLink}">lease agreement</a>.
    </p>
  </g:if>
  <p>
    For easy directions to your storage facility from your billing address, please click <g:link controller="storageSite" action="directions" id="${siteId}">here</g:link>.
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
  </body>
</html>