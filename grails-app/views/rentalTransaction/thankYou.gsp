<%@ page import="storitz.constants.TransactionType" %>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head>
  <title>Thanks for renting Self Storage with Storitz!</title>
</head>
<body class="thankyou">
<div class="print"><a href="#" onclick="window.print(); return false;">Print page</a></div>
<h1><g:formatBoolean boolean="${rentalTransactionInstance.site.transactionType == TransactionType.RESERVATION}" true="Reservation" false="Rental" /> Confirmation</h1>
<div class="formInstructions">
  Congratulations, you have successfully <g:formatBoolean boolean="${rentalTransactionInstance.site.transactionType == TransactionType.RESERVATION}" true="reserved" false="rented" /> a self-storage unit. We thank you for choosing Storitz and making your experience as easy as Click. Store. Done.
  Below is a summary of your transaction.
</div>
<g:if test="${!(rentalTransactionInstance.site.transactionType == TransactionType.RESERVATION && rentalTransactionInstance.site.rentalFee == 0)}">
<table>
  <tr><td>Tenant Name:</td> <td>${rentalTransactionInstance.contactPrimary.fullName()}</td></tr>
  <tr><td>Confirmation #:</td> <td>${rentalTransactionInstance.bookingDate.format('yyyyMMdd')}${sprintf('%08d', rentalTransactionInstance.id)}</td></tr>
  <tr><td>Order Date:</td> <td>${rentalTransactionInstance.bookingDate.format('MM/dd/yy')}</td></tr>
  <tr><td>Move-in Date:</td> <td>${rentalTransactionInstance.moveInDate.format('MM/dd/yy')}</td></tr>
  <tr><td>Property Name:</td> <td>${rentalTransactionInstance.site.title}</td></tr>
  <tr><td>Address:</td> <td>${rentalTransactionInstance.site.getFullAddress()}</td></tr>
  <g:if test="${rentalTransactionInstance.accessCode}">
  <tr><td>Gate Access Code:</td><td>${rentalTransactionInstance.accessCode}</td></tr>
  </g:if>
  <g:if test="${rentalTransactionInstance.site.phone}">
  <tr><td>Phone:</td> <td>${rentalTransactionInstance.site.phone}</td></tr>
  </g:if>
</table>
<h2>Billing Summary</h2>
<table>
  <g:if test="${rentalTransactionInstance.idNumber}">
  <tr><td>Transaction #:</td> <td>${rentalTransactionInstance.idNumber}</td></tr>
  </g:if>
  <g:elseif test="${rentalTransactionInstance.reserved}">
  <tr><td>Transaction #:</td> <td>R${rentalTransactionInstance.reservationId}</td></tr>
  </g:elseif>
  <tr><td>Name:</td> <td>${rentalTransactionInstance.billingAddress.fullName()}</td></tr>
  <tr><td>Address:</td> <td>${rentalTransactionInstance.billingAddress.fullAddress()}</td></tr>
  <tr><td>Payment Method:</td> <td>Credit Card</td></tr>
  <tr><td>Credit Card #:</td> <td>${rentalTransactionInstance.cleanCCNum}</td></tr>
  <tr><td>Rental Rate:</td> <td><g:formatNumber number="${rentalTransactionInstance.monthlyRate}" type="currency" currencyCode="USD"/></td> </tr>
  <tr><td>Rent is Paid Through:</td> <td>${rentalTransactionInstance.paidThruDate.format('MM/dd/yy')}</td> </tr>
  <tr><td>Unit Size:</td> <td>${rentalTransactionInstance.displaySize}</td></tr>
  <g:if test="${promo}">
  <tr><td>Promotion Discount(s):</td> <td>${promo.promoName}</td></tr>
  </g:if>
  <g:if test="${rentalTransactionInstance.site.transactionType == TransactionType.RESERVATION}">
  <tr><td>Reservation Fee:</td> <td><g:formatNumber number="${rentalTransactionInstance.cost}" type="currency" currencyCode="USD"/></td></tr>
  <tr><td>Total Due at Move In:</td> <td><g:formatNumber number="${rentalTransactionInstance.moveInCost}" type="currency" currencyCode="USD"/></td> </tr>
  </g:if>
  <g:else>
  <tr><td>Move-In Cost:</td> <td><g:formatNumber number="${rentalTransactionInstance.cost}" type="currency" currencyCode="USD"/></td></tr>
  </g:else>
</table>
</g:if>

<g:else>
<table>
  <tr><td>Tenant Name:</td> <td>${rentalTransactionInstance.contactPrimary.fullName()}</td></tr>
  <tr><td>Confirmation #:</td> <td>${rentalTransactionInstance.bookingDate.format('yyyyMMdd')}${sprintf('%08d', rentalTransactionInstance.id)}</td></tr>
  <tr><td>Order Date:</td> <td>${rentalTransactionInstance.bookingDate.format('MM/dd/yy')}</td></tr>
  <tr><td>Move-in Date:</td> <td>${rentalTransactionInstance.moveInDate.format('MM/dd/yy')}</td></tr>
  <tr><td>Property Name:</td> <td>${rentalTransactionInstance.site.title}</td></tr>
  <tr><td>Address:</td> <td>${rentalTransactionInstance.site.getFullAddress()}</td></tr>
  <g:if test="${rentalTransactionInstance.accessCode}">
  <tr><td>Gate Access Code:</td><td>${rentalTransactionInstance.accessCode}</td></tr>
  </g:if>
  <g:if test="${rentalTransactionInstance.site.phone}">
  <tr><td>Phone:</td> <td>${rentalTransactionInstance.site.phone}</td></tr>
  </g:if>
  <g:if test="${rentalTransactionInstance.idNumber}">
  <tr><td>Transaction #:</td> <td>${rentalTransactionInstance.idNumber}</td></tr>
  </g:if>
  <g:elseif test="${rentalTransactionInstance.reserved}">
  <tr><td>Transaction #:</td> <td>R${rentalTransactionInstance.reservationId}</td></tr>
  </g:elseif>
  <tr><td>Address:</td> <td>${rentalTransactionInstance.billingAddress.fullAddress()}</td></tr>
  <tr><td>Rental Rate:</td> <td><g:formatNumber number="${rentalTransactionInstance.monthlyRate}" type="currency" currencyCode="USD"/></td></tr>
  <tr><td>Rent Period Through:</td> <td>${rentalTransactionInstance.paidThruDate.format('MM/dd/yy')}</td> </tr>
  <tr><td>Unit Size:</td> <td>${rentalTransactionInstance.displaySize}</td></tr>
  <g:if test="${promo}">
  <tr><td>Promotion Discount(s):</td> <td>${promo.promoName}</td></tr>
  </g:if>
  <tr><td>Amount Due at Move In:</td> <td><g:formatNumber number="${rentalTransactionInstance.moveInCost}" type="currency" currencyCode="USD"/></td></tr>
</g:else>

<p>Please be aware of this facility's office and access hours, and arrive for your move-in during office hours.</p>

<g:if test="${rentalTransactionInstance.site.transactionType == TransactionType.RESERVATION && rentalTransactionInstance.site.rentalFee > 0}">
<p>
  Your reservation fee will be credited to your move-in cost on the day of your move-in.  Some facilities may require that you purchase insurance on the day of your move-in at an additional charge.  If you have
  renter's insurance, bring proof to the facility on your move-in date.
</p>
</g:if>

<g:if test="${rentalTransactionInstance.site.rentalAgreement}">
<p>
  Before move-in, please review and print out a copy of your <a href="${resource(file: rentalTransactionInstance.site.rentalAgreement.src())}" onclick="window.open(this.href, '_blank');
  return false;">terms and conditions</a>.
</p>
</g:if>
<p>
  For easy directions to your storage facility, please click
  <g:link controller="storageSite" action="directions" id="${rentalTransactionInstance.site.id}">here</g:link>.
</p>
<p>If you have any questions or concerns regarding your experience with Storitz, please contact us.</p>
<div>Phone: (877) 456-2929</div>
<div>Email: <a href="mailto:info@storitz.com">info@storitz.com</a></div>
<p>
  Sincerely,
  Storitz, Inc.
</p>
</body>
</html>