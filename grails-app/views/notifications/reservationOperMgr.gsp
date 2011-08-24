<%@ page import="java.text.DateFormat" contentType="text/html" %>
<html>
<head>
  <title>Storitz Reservation Notification</title>
</head>
<body>
<div>
  <div style="z-index: 100; float: left; margin-top: 22px;">
    <g:link controller="home" action="index">
      <storitz:image src="${resource(dir:'images', file:'logo_storitz.gif', absolute: true)}" absolute="true" style="border-style: none;" width="950" height="61" alt="Storitz Logo"/>
    </g:link>
  </div>
  <div style="clear: both;"></div>
</div>
<div style="margin-left: 50px;">
  <storitz:image src="${resource(dir:'images', file:'tagline_clickstoredone.gif', absolute: true)}" absolute="true" style="border-style: none;" width="170" height="21" alt="Click. Store. Done."/>
</div>
<div style="height: 3em;"></div>

<p>
  ${DateFormat.getDateInstance(DateFormat.FULL, Locale.US).format(new Date())}
</p>
<p>
  Dear Storitz Partner,
</p>
<p>
  Congratulations! We are pleased to inform you that another new tenant has reserved a unit at ${siteName}. Your property management software should already show this reservation. To move-in the customer, simply select the reservation and take payment.
</p>
<p style="font-weight:bold;">
  Rental Summary:
</p>
<ul>
  <li>Transaction #: ${idNumber}</li>
  <li>Property Name: ${siteName}</li>
  <li>Unit #: ${unitNumber}</li>
  <li>Unit Size: ${displaySize}</li>
  <li>Move-In Date: ${moveInDate}</li>
  <li>Rental Rate: ${rentalRate}</li>
  <li>Rent is Paid Through: ${paidThruDate}</li>
  <li>Promotion(s): ${promoName}</li>
  <li>Property Protection: ${insuranceName}</li>
  <li>Reservation Fee Collected: ${rentalFee}</li>
  <li>Total to be paid at Move-In: ${remainderDueAtMoveIn}</li>
  <li>Total Move-In Cost: ${moveInCost}</li>
</ul>
<p style="font-weight:bold;">
  Tenant Information:
</p>
<ul>
  <li>Storitz ID#: ${storitzId}</li>
  <li>Tenant Name: ${tenantName}</li>
  <li>Phone: ${phone}</li>
  <li>Email: ${email}</li>
</ul>
<p>
  We thank you for your continued business with Storitz. For information or concerns:
</p>
<p>
<div><a href="https://www.storitz.com/admin">Storitz Admin</a></div>
<div>Phone: (877) 456-2929</div>
<div>Email: info@storitz.com</div>
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