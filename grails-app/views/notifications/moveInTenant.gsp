<%@ page import="java.text.DateFormat" contentType="text/html" %>
<html>
<head>
  <title>Storitz Move-In Notification</title>
</head>
<body>
<div>
  <div style="z-index: 100; float: left; margin-top: 22px;">
    <g:link controller="home" action="index">
      <storitz:image src="${resource(dir:'images/email', file:'logo_storitz.gif', absolute: true)}" absolute="true" style="border-style: none;" width="950" height="61" alt="Storitz Logo"/>
    </g:link>
  </div>
  <div style="clear: both;"></div>
</div>
<div style="margin-left: 50px;">
  <storitz:image src="${resource(dir:'images/email', file:'tagline_clickstoredone.gif', absolute: true)}" absolute="true" style="border-style: none;" width="170" height="21" alt="Click. Store. Done."/>
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
  <li>Unit Size: ${displaySize}</li>
  <li>Promotion(s): ${promoName}</li>
  <li>Property Protection: ${insuranceName}</li>
  <li>Payment Received: ${moveInCost}</li>
</ul>
<div style="height: 30px;"></div>
<g:if test="${rentalAgreementLink}">
  <p>
    Before move-in, please review and print out a copy of your <a href="${rentalAgreementLink}">terms and conditions</a>.
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
<div style="height: 30px;"></div>
<div>
  <a href="http://twitter.com/Storitzdotcom" target="_blank"><storitz:image style="border: none;" absolute="true" src="${resource(dir:'images/email', file:'twitter-icon-page.gif', absolute: true)}" width="20" height="20" alt="Storitz on Twitter"/></a>
  <a href="http://www.facebook.com/storitz" target="_blank"><storitz:image style="border: none;" absolute="true" src="${resource(dir:'images/email', file:'facebook-icon-page.gif', absolute: true)}" width="20" height="20" alt="Storitz on FaceBook"/></a>
  <a href="http://www.stumbleupon.com/submit?url=http://www.storitz.com/" target="_blank"><storitz:image style="border: none;" absolute="true" src="${resource(dir:'images/email', file:'stumbleupon-icon-page.gif', absolute: true)}" width="20" height="20" alt="Storitz on StumbleUpon"/></a>
  <a href="http://www.linkedin.com/companies/storitz-inc?trk=fc_badge" target="_blank"><storitz:image style="border: none;" absolute="true" src="${resource(dir:'images/email', file:'linkedin-icon-page.gif', absolute: true)}" width="20" height="20" alt="Storitz on LinkedIn"/></a>
  <a href="http://www.youtube.com/user/Storitzdotcom" target="_blank"><storitz:image style="border: none;" absolute="true" src="${resource(dir:'images/email', file:'youtube-icon-page.gif', absolute: true)}" width="20" height="20" alt="Storitz Youtube Channel"/></a>
</div>

</body>
</html>