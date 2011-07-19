<%@ page import="storitz.constants.TransactionType" %>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head>
  <title>Thanks for renting Self Storage with Storitz!</title>
</head>
<body class="thankyou">
<div class="conf_box">
    <h1>Order Confirmation</h1>
    <h2>Thank you for your order! Your order number is:</h2><span>${rentalTransactionInstance.bookingDate.format('yyyyMMdd')}${sprintf('%08d', rentalTransactionInstance.id)}</span>
    <div class="formInstructions">
        Congratulations, you have successfully <g:formatBoolean boolean="${rentalTransactionInstance.site.transactionType == TransactionType.RESERVATION}" true="reserved" false="rented" /> a self-storage unit. We thank you for choosing Storitz and making your experience as easy as Click. Store. Done.
        Below is a summary of your transaction. For assistance with your order, please call <b>(877) 456-2929</b>.
    </div>
    <div class="userInfo">
        <div id="billInfo" class="column">
            <h3>Billing Information:</h3>
            <p>Name:</p>
            <span>${rentalTransactionInstance.billingAddress.fullName()}</span>
            <p>Address:</p>
            <span>${rentalTransactionInstance.billingAddress.fullAddress()}</span>
            <p>Phone:</p>
            <span>(310) 308-3495</span> <!-- placeholder -->
        </div>
        <div id="paymentInfo" class="column">
            <h3>Payment Information:</h3>
            <p>Type:</p>
            <span>American Express</span> <!-- placeholder -->
            <p>Card No.:</p>
            <span>${rentalTransactionInstance.cleanCCNum}</span>
            <p>Amount:</p>
            <span><g:formatNumber number="${rentalTransactionInstance.cost}" type="currency" currencyCode="USD"/></span>
            <p>Name on Card:</p>
            <span>${rentalTransactionInstance.billingAddress.fullName()}</span>  <!-- placeholder -->
        </div>
        <div id="orderInfo" class="column">
            <h3>Order Information:</h3>
            <p>Date Purchased:</p>
            <span>${rentalTransactionInstance.bookingDate.format('MM/dd/yy')}</span>
            <p>Order Confirmation:</p>
            <span>${rentalTransactionInstance.bookingDate.format('yyyyMMdd')}${sprintf('%08d', rentalTransactionInstance.id)}</span>
        </div>
    </div>
    <div style="width:693px;border-bottom: 1px solid #ccc; margin: 20px 0 20px -18px;position:relative;"></div>
    <h2>Checking into your unit is as easy 1-2-3...</h2>
    <div class="icons">
        <div id="map_icon" class="column">
            <g:link class="map" absolute="true" mapping="siteLink2" controller="storageSite" action="detail" id="${rentalTransactionInstance.site.id}" params="[site_title:rentalTransactionInstance.site.title.replaceAll(' - ','-').replaceAll(' ', '-'), bestUnit:rentalTransactionInstance.unitId, promoId:rentalTransactionInstance.promoId]"/>
            <span class="icn_label">Get driving <br />directions</span>
        </div>
        <div id="print_icon" class="column">
            <a class="print" href="#" onclick="window.print(); return false;"></a>
            <span class="icn_label">Print order confirmation and bring to storage facility</span>
        </div>
        <div id="check_icon" class="column">
            <a class="check" href="#"></a>
            <span class="icn_label">Review mini checklist for useful moving and packing tips</span>
        </div>
    </div>
    <div class="storageInfo">
        <div id="storFacility" class="column">
            <h3>Storage Facility</h3>
            <span>${rentalTransactionInstance.site.title}</span>
            <p style="margin:0;">${rentalTransactionInstance.site.getFullAddress()}</p>
            <g:link class="map" absolute="true" mapping="siteLink2" controller="storageSite" action="detail" id="${rentalTransactionInstance.site.id}" params="[site_title:rentalTransactionInstance.site.title.replaceAll(' - ','-').replaceAll(' ', '-'), bestUnit:rentalTransactionInstance.unitId, promoId:rentalTransactionInstance.promoId]">Get Directions</g:link>
        </div>
        <div id="storHours" class="extColumn">
            <h3>Office Hours</h3>
            <div class="days">
                <p>Monday</p>
                <p>Tuesday</p>
                <p>Wednesday</p>
                <p>Thursday</p>
                <p>Friday</p>
                <p>Saturday</p>
                <p>Sunday</p>
            </div>
            <div class="hours"> <!-- check if site is open on a day -->
                <p><g:formatDate format="h:mma" date="${rentalTransactionInstance.site.startMonday}"/> - <g:formatDate format="h:mma" date="${rentalTransactionInstance.site.endMonday}"/></p>
                <p><g:formatDate format="h:mma" date="${rentalTransactionInstance.site.startTuesday}"/> - <g:formatDate format="h:mma" date="${rentalTransactionInstance.site.endTuesday}"/></p>
                <p><g:formatDate format="h:mma" date="${rentalTransactionInstance.site.startWednesday}"/> - <g:formatDate format="h:mma" date="${rentalTransactionInstance.site.endWednesday}"/></p>
                <p><g:formatDate format="h:mma" date="${rentalTransactionInstance.site.startThursday}"/> - <g:formatDate format="h:mma" date="${rentalTransactionInstance.site.endThursday}"/></p>
                <p><g:formatDate format="h:mma" date="${rentalTransactionInstance.site.startFriday}"/> - <g:formatDate format="h:mma" date="${rentalTransactionInstance.site.endFriday}"/></p>
                <p><g:formatDate format="h:mma" date="${rentalTransactionInstance.site.startSaturday}"/> - <g:formatDate format="h:mma" date="${rentalTransactionInstance.site.endSaturday}"/></p>
                <p><g:formatDate format="h:mma" date="${rentalTransactionInstance.site.startSunday}"/> - <g:formatDate format="h:mma" date="${rentalTransactionInstance.site.endSunday}"/></p>
            </div>
            <div class="important">
                <p>IMPORTANT! When checking in to your unit for the first time, please arrive two hours <em>before</em> facility office closes.</p>
            </div>
        </div>
    </div>
    <div style="width:693px;border-bottom: 1px solid #ccc; margin: 20px 0 20px -18px;position:relative;"></div>
    <h2>What's next?</h2>
    <div class="promos">
        <div class="column" style="background-color:gray;border-radius:10px;height:110px;">Deals</div>
        <div class="column" style="background-color:gray;border-radius:10px;height:110px;">Coupon</div>
        <div class="column" style="background-color:gray;border-radius:10px;height:110px;">Blah</div>
    </div>
</div>
<div id="purchaseSummary" src="${createLink(mapping:'purchaseSummaryPanel')}">
  <g:render template="purchaseSummaryPanel" model="[unit:unit, site:site, insurance:insurance, promo:promo, promos:promos, totals:totals, moveInDate:moveInDate]" />
</div>
</body>
</html>