<%@ page import="java.text.DateFormat" contentType="text/html" %>
<html>
  <head>
    <title>Storitz Move-In Notification</title>
  </head>
  <body>
  <div>
    <div style="z-index: 100; float: left; margin-top: 22px;">
      <g:link controller="home" action="index">
        <storitz:image src="${createLinkTo(dir:'images', file:'tagline_clickstoredone.gif', absolute: true)}" absolute="true" style="border-style: none;" width="170" height="21" alt="Click. Store. Done."/>
      </g:link>
    </div>
    <div style="clear: both;"></div>
  </div>
  <div style="margin-left: 50px;">
    <storitz:image src="${createLinkTo(dir:'images', file:'tagline_clickstoredone.gif', absolute: true)}" absolute="true" style="border-style: none;" width="170" height="21" alt="Click. Store. Done."/>
  </div>
  <div style="height: 3em;"></div>

  <p>
    ${DateFormat.getDateInstance(DateFormat.FULL, Locale.US).format(new Date())}
  </p>
  <p>
    Dear Storitz Partner,
  </p>
  <p>
    Congratulations! We are pleased to inform you that another new tenant has rented a unit at ${siteName}. Your property management software should already reflect the changes detailed below.
  </p>
  <p style="font-weight:bold;">
    Rental Summary:
  </p>
  <ul>
    <li>Storitz ID#: ${storitzId}</li>
    <li>Transaction #: ${idNumber}</li>
    <li>Property Name: ${siteName}</li>
    <li>Unit #: ${unitNumber}</li>
    <li>Move-in Date: ${moveInDate}</li>
    <li>Rental Rate: ${rentalRate}</li>
    <li>Rent is Paid Through: ${paidThruDate}</li>
    <li>Promotion(s): ${promoName}</li>
    <li>Payment Received: ${moveInCost}</li>
  </ul>
  <p style="font-weight:bold;">
    Tenant Information:
  </p>
  <ul>
    <li>Tenant Name: ${tenantName}</li>
    <li>Phone: ${phone}</li>
    <li>Email: ${email}</li>
  </ul>
  <p>
    We thank you for your continued partnership with Storitz. Please contact us if you have any questions or concerns.
  </p>
  <p>
    <div>Phone: (877) 456-2929</div>
    <div>Email: info@storitz.com</div>
  </p>
  </body>
</html>