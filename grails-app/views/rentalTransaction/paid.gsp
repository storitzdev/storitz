<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN"
    "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" >
  <head>
    <g:render template="/header" />

    <script type="text/javascript">
//<![CDATA[

  var defaultOffer = { active: true, promoName: "Default", promoType: "AMOUNT_OFF", promoQty: 0, prepay: false, prepayMonths: 1, inMonth: 1, expireMonth: 1, waiveAdmin: false };
  var offerChosen = defaultOffer;
  <g:if test="${promo != null}">
    offerChosen = { active: ${promo.active}, promoName: "${promo.promoName}", promoType: "${promo.promoType}", promoQty: ${promo.promoQty}, prepay: ${promo.prepay},  prepayMonths: ${promo.prepayMonths}, inMonth: ${promo.inMonth}, expireMonth: ${promo.expireMonth}, waiveAdmin: ${promo.waiveAdmin}};
  </g:if> 

  var unit = { type: "${unit.unitType}", price: ${unit.price} };
  var premium = ${ins ? ins.premium : 0};
  var additionalFees = ${site.adminFee ? site.adminFee : 0} + ${site.lockFee ? site.lockFee : 0};
  var adminFee = ${site.adminFee ? site.adminFee : 0};

  function drawCheckoutTable() {
    var durationMonths = (offerChosen.prepay ? offerChosen.prepayMonths + offerChosen.expireMonth : (offerChosen.inMonth -1) + offerChosen.expireMonth);

    var checkoutTableBody = "<tr>";
    checkoutTableBody += "<td style=\"padding-bottom:10px;\">" + unit.type + "</td>";
    checkoutTableBody += "<td class=\"textCenter\">" + durationMonths + "</td><td class=\"price_text\">$" + unit.price.toFixed(2) + "</td>";
    checkoutTableBody += "<td class=\"price_text\">$" + (unit.price*durationMonths).toFixed(2) + "</td>";
    checkoutTableBody += "</tr>";

    var startDate = "${rentalTransactionInstance?.moveInDate?.format("MM/dd/yyyy")}";
    var paidThru = Date.parseDate(startDate, "%m/%d/%Y");
    paidThru.setMonth( paidThru.getMonth() + durationMonths);
    $('checkout_paid_through_date').update(paidThru.print("%o/%d/%y"));

    $('checkout_price_body').update(checkoutTableBody);
    $('checkout_unit_size').update('${unit?.unitsize?.description}');
    $('checkout_movein_date').update(startDate);
    showTotals();
  }

  function showTotals() {
    // TODO -  push all calculations into Ajax/Service call

    var tableBody = "";

    var durationMonths = (offerChosen.prepay ? offerChosen.prepayMonths + offerChosen.expireMonth : (offerChosen.inMonth -1) + offerChosen.expireMonth);
    if (premium > 0) {
      tableBody += "<tr class=\"tableLine\"><td colspan=\"\">Insurance:</td><td class=\"textCenter\">" + durationMonths +"</td><td class=\"price_text\">$" + premium.toFixed(2) + "</td><td class=\"price_text borderRight\">$" + (durationMonths*premium).toFixed(2) + "</td></tr>";
    }

    var offerDiscount = 0;
    if (offerChosen != defaultOffer) {

      switch(offerChosen.promoType) {
        case "AMOUNT_OFF":
          offerDiscount = offerChosen.promoQty * offerChosen.expireMonth;
          break;

        case "PERCENT_OFF":
          offerDiscount = (offerChosen.promoQty/100.0) * offerChosen.expireMonth * unit.price;
          break;

        case "FIXED_RATE":
          offerDiscount = (unit.price - offerChosen.promoQty) * offerChosen.expireMonth;
          break;
      }
      tableBody += "<tr class=\"specialOfferText tableLine\"><td  colspan=\"3\">Special Offer " + offerChosen.promoName + "<td class=\"price_text borderRight\">-$" + offerDiscount.toFixed(2) + "</td></tr>";
    }

    if (!offerChosen.waiveAdmin) {
      tableBody += "<tr class=\"tableLine\"><td colspan=\"3\">Admin Fee (one time charge)</td><td class=\"borderRight price_text\">$" + additionalFees.toFixed(2) + "</td></tr>";
    }

    var total_movein = (offerChosen.waiveAdmin ? additionalFees - adminFee : additionalFees) + (unit.price + premium)*durationMonths - offerDiscount;

    $('checkout_price_totals_body').update(tableBody);
    $('checkout_price_total').update("$" + total_movein.toFixed(2));
  }

  function contactChange() {
    $('billingAddress').observe('click', function() {
      var contactType =  $('billingAddress').select('input:checked[type=radio]').pluck('value');
      if (contactType == 'new') {
        $('newContact').show();
      } else {
        $('newContact').hide();
      }
    });
  }

  function validateForm() {
    var valid = true;
    valid &= Validation.validate('cc_number');
    valid &= Validation.validate('cc_cvv2');
    var contactType =  $('billingAddress').select('input:checked[type=radio]').pluck('value');
    if (contactType == 'new') {
      valid &= Validation.validate('firstName');
      valid &= Validation.validate('lastName');
      valid &= Validation.validate('streetNumber');
      valid &= Validation.validate('street');
      valid &= Validation.validate('city');
      valid &= Validation.validate('state');
      valid &= Validation.validate('zipcode');
    }
    return valid;
  }

  function nextStep() {
    if (validateForm()) {
      $('rentalTransaction').submit();
    }
  }

  function createMap() {}

  Event.observe(window, 'load', function() {
    $('left_checkout_info').show();
    $('returnLinks').hide();
    drawCheckoutTable();
    contactChange();
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
        <g:render template="/orderSummary"/>
      </div>
      <div style="width: 685px;" class="right">
        <div id="detailInfo">
            <div id="rentalForm">
              <g:form action="pay" controller="rentalTransaction" name="rentalTransaction" method="post" id="${params.id}">

                <div class="vert_text">
                  <span id="step1_bullet" class="bullet" style="display: none;">&#8226</span><span id="step1" class="step_header">Primary Contact</span>
                  <span id="step2_bullet" class="bullet" style="display: none;">&#8226</span><span id="step2" class="step_header">Secondary Contact</span>
                  <span id="step3_bullet" class="bullet" style="display: none;">&#8226</span><span id="step3" class="step_header">Rental Options</span>
                  <span id="step4_bullet" class="bullet">&#8226</span><span id="step4" class="step_header_hi">Payment</span>
                  <span id="step5_bullet" class="bullet" style="display: none;">&#8226</span><span id="step5" class="step_header">Order Complete</span>
                </div>
                <g:if test="${flash.message}">
                  <div class="message">${flash.message}</div>
                </g:if>
                <div class="price_options checkout_header white">
                  Paid
                </div>
                <div class="formInstructions">
                  Your payment for this unit has already been processed.  If you believe you have reached this page by
                  mistake, please <g:link controller="static" action="contactus">Contact Us</g:link>.
                </div>

              </g:form>
            </div>
        </div>
      </div>
    </div>

    <div style="clear:both; height:30px;"></div>
    <g:render template="/footer" />
    <g:render template="/size_popup" />
    <script type="text/javascript" src="http://www.google.com/jsapi?autoload=%7B%22modules%22%3A%5B%7B%22name%22%3A%22maps%22%2C%22version%22%3A%223.x%22%2Cother_params%3A%22sensor%3Dfalse%22%2C%22callback%22%3A%22createMap%22%7D%2C%7B%22name%22%3A%22gdata%22%2C%22version%22%3A%222.x%22%2C%22packages%22%3A%5B%22maps%22%5D%7D%5D%7D&amp;key=ABQIAAAAEDNru_s_vCsZdWplqCj4hxSjGMYCLTKEQ0TzQvUUxxIh1qVrLhTUMUuVByc3xGunRlZ-4Jv6pHfFHA"></script>
    </div>
  </body>
</html>