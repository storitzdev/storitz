<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN"
    "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" >
  <head>
    <g:render template="/header" />

    <script type="text/javascript">
//<![CDATA[

    var directionsService;
    var directionsDisplay;
    var storageSize = [];
    var premiums = [];
    var prices = [];
    var unitTypes = [];
    var specialOffers = [];
    var searchSize;
    var unitId;
    var siteId = ${params.id};
    var rentalFormReady = false;
    var additionalFees = ${site.adminFee ? site.adminFee : 0} + ${site.lockFee ? site.lockFee : 0};
    var destLatLng;
    var startDate = "${params.date}";
    var specialOfferId;
    var monthlyRent = 0;
    var galleryImageNum = 0;

    var priceDriveup = ${params.priceDriveup ? "true" : "false"};
    var priceInterior = ${params.priceInterior ? "true" : "false"};
    var priceUpper = ${params.priceUpper ? "true" : "false"};

    <g:each var="size" in="${sizeList}">storageSize[${size.id}] = "${size.description}";</g:each>
    <g:if test="${params.searchSize}">
      searchSize = ${params.searchSize};
      var sizeDescription = storageSize[ ${params.searchSize} ];
    </g:if>
    <g:each var="ins" in="${site.insurances}">premiums[${ins.insuranceId}] = ${ins.premium};</g:each>
    premiums[-999] = 0;
    var defaultOffer = specialOffers[-1] = { active: true, promoName: "Default", promoType: "AMOUNT_OFF", promoQty: 0, prepay: false, prepayMonths: 1, inMonth: 1, expireMonth: 1 };
    <g:each var="offer" in="${site.specialOffers}">
      specialOffers[${offer.id}] = { active: ${offer.active}, promoName: "${offer.promoName}", promoType: "${offer.promoType}", promoQty: ${offer.promoQty}, prepay: ${offer.prepay},  prepayMonths: ${offer.prepayMonths}, inMonth: ${offer.inMonth}, expireMonth: ${offer.expireMonth}};
    </g:each>
    var premium = 0;
    var offerChosen = specialOffers[-1];

    function setupSize() {
      if(typeof(sizeDescription) !== 'undefined')  {
        if (searchSize > 1) {
          $('sizeDescription').update(storageSize[searchSize]);
        } else {
          $('sizeDescription').update(' not chosen');
        }
      }
    }

    function buildTable() {
      new Ajax.Request("${createLink(controller:'storageSite', action:'detailUnits')}",
      {
        method:'get',
        parameters: {searchSize: searchSize, id: siteId },
        onSuccess:function(transport) {
          var tableBody = "<tr><td colspan=\"4\" style=\"padding-left:20px;\">Select from the following storage options:</td></tr>";
          var checkoutTableBody = "";
          var units = transport.responseJSON.units;
          var unitCount = (typeof(units.driveUp) !== 'undefined' ? 1 : 0) + (typeof(units.interior) !== 'undefined' ? 1 : 0) + (typeof(units.upper) !== 'undefined' ? 1 : 0);
          var rowCount = 0;
          var durationMonths = (offerChosen.prepay ? offerChosen.prepayMonths + offerChosen.expireMonth : (offerChosen.inMonth -1) + offerChosen.expireMonth);
          $('priceDriveup').value = false;
          $('priceUpper').value = false;
          $('priceInterior').value = false;
          if (units) {
            if (units.driveup) {
              tableBody += "<tr class=" + (rowCount++ % 2 == 0 ? "roweven" : "rowodd") + ">";
              tableBody += "<td style=\"padding-left:20px;\"><input type=\"radio\" name=\"unit_choice\" value=\"" + units.driveup.id + "\"" + (priceDriveup || unitCount == 1 ? " checked=\"true\"" : "") + "/> Drive up</td>";
              tableBody += "<td class=\"textCenter\">" + durationMonths + "</td><td class=\"price_text\">$" + units.driveup.price.toFixed(2) + "</td>";
              tableBody += "<td class=\"price_text\" style=\"padding-right:20px;\">$" + (units.driveup.price*durationMonths).toFixed(2) + "</td>";
              tableBody += "</tr>";
              prices[units.driveup.id] = units.driveup.price;
              unitTypes[units.driveup.id] = 'priceDriveup';
              if (priceDriveup || unitCount == 1) {
                unitId = units.driveup.id;
                monthlyRent = prices[unitId];
                $('priceDriveup').value = true;
                $('unitId').value = unitId;
                rentalFormReady = true;
                $('rentmeBtn').show();
                checkoutTableBody += "<tr>";
                checkoutTableBody += "<td style=\"padding-bottom:10px;\">Drive up</td>";
                checkoutTableBody += "<td class=\"textCenter\">" + durationMonths + "</td><td class=\"price_text\">$" + units.driveup.price.toFixed(2) + "</td>";
                checkoutTableBody += "<td class=\"price_text\">$" + (units.driveup.price*durationMonths).toFixed(2) + "</td>";
                checkoutTableBody += "</tr>";
              }
            }
            if (units.interior) {
              tableBody += "<tr class=" + (rowCount++ % 2 == 0 ? "roweven" : "rowodd") + ">";
              tableBody += "<td style=\"padding-left:20px;\"><input type=\"radio\" name=\"unit_choice\" value=\"" + units.interior.id + "\"" + (priceInterior || unitCount == 1 ? " checked=\"true\"" : "") + "/> Interior</td>";
              tableBody += "<td class=\"textCenter\">" + durationMonths + "</td><td class=\"price_text\">$" + units.interior.price.toFixed(2) + "</td>";
              tableBody += "<td class=\"price_text\" style=\"padding-right:20px;\">$" + (units.interior.price*durationMonths).toFixed(2) + "</td>";
              tableBody += "</tr>";
              prices[units.interior.id] = units.interior.price;
              unitTypes[units.interior.id] = 'priceInterior';
              if (priceInterior || unitCount == 1) {
                unitId = units.interior.id;
                monthlyRent = prices[unitId];
                $('priceInterior').value = true;
                $('unitId').value = unitId;
                rentalFormReady = true;
                $('rentmeBtn').show();
                checkoutTableBody += "<tr>";
                checkoutTableBody += "<td style=\"padding-bottom:10px;\">Interior</td>";
                checkoutTableBody += "<td class=\"textCenter\">" + durationMonths + "</td><td class=\"price_text\">$" + units.interior.price.toFixed(2) + "</td>";
                checkoutTableBody += "<td class=\"price_text\">$" + (units.interior.price*durationMonths).toFixed(2) + "</td>";
                checkoutTableBody += "</tr>";
              }
            }
            if (units.upper) {
              tableBody += "<tr class=" + (rowCount++ % 2 == 0 ? "roweven" : "rowodd") + ">";
              tableBody += "<td style=\"padding-left:20px;\"><input type=\"radio\" name=\"unit_choice\" value=\"" + units.upper.id + "\"" + (priceUpper || unitCount == 1 ? " checked=\"true\"" : "") + "/> Upper</td>";
              tableBody += "<td class=\"textCenter\">" + durationMonths + "</td><td class=\"price_text\">$" + units.upper.price.toFixed(2) + "</td>";
              tableBody += "<td class=\"price_text\" style=\"padding-right:20px;\">$" + (units.upper.price*durationMonths).toFixed(2) + "</td>";
              tableBody += "</tr>";
              prices[units.upper.id] = units.upper.price;
              unitTypes[units.upper.id] = 'priceUpper';
              if (priceUpper || unitCount == 1) {
                unitId = units.upper.id;
                monthlyRent = prices[unitId];
                $('priceUpper').value = true;
                $('unitId').value = unitId;
                rentalFormReady = true;
                $('rentmeBtn').show();
                checkoutTableBody += "<tr>";
                checkoutTableBody += "<td style=\"padding-bottom:10px;\">Upper</td>";
                checkoutTableBody += "<td class=\"textCenter\">" + durationMonths + "</td><td class=\"price_text\">$" + units.upper.price.toFixed(2) + "</td>";
                checkoutTableBody += "<td class=\"price_text\">$" + (units.upper.price*durationMonths).toFixed(2) + "</td>";
                checkoutTableBody += "</tr>";
              }
            }
          }
          $('price_body').update(tableBody);
          $('checkout_price_body').update(checkoutTableBody);
          showTotals();
        }
      });
    }
    function createMap() {
      destLatLng = new google.maps.LatLng(${site.lat}, ${site.lng});
      directionsService = new google.maps.DirectionsService();
      directionsDisplay = new google.maps.DirectionsRenderer();
      directionsDisplay.setPanel($('dirPanel'));
    }

    function setupHelp() {
      $('sizeInfo').observe('click', function(event) {
        $('sizeHelp').setStyle({ top: Event.pointerY(event) - 10 + "px", left: Event.pointerX(event) + 10 + "px" });
        Effect.toggle('sizeHelp', 'appear', {duration: 0.8});
      });
      $('helpClose').observe('click', function() {
        Effect.toggle('sizeHelp', 'appear', {duration: 0.8});
      });
    }

    function getDirections() {
      $('get_directions').observe('click', function() {
        var request = {
                origin:$F('srcAddr'),
                destination:destLatLng,
                travelMode: google.maps.DirectionsTravelMode.DRIVING
            };
            directionsService.route(request, function(response, status) {
              if (status == google.maps.DirectionsStatus.OK) {
                directionsDisplay.setDirections(response);
              }
            });

      });
    }

    function sizeChange() {
      $('unitsize').observe('change', function() {
        searchSize = $F('unitsize');
        if (searchSize > 1) {
          $('sizeDescription').update(storageSize[searchSize]);
        } else {
          $('sizeDescription').update(' not chosen');
        }
        buildTable();
      })
    }

    function dateChange() {
      startDate = $F('date');
      showTotals();
      Validation.validate('date');
    }

    function directionTab() {
      $('direction_button').observe('click', function() {
        $('photo_button').removeClassName('tab_button_on');
        $('photo_button').removeClassName('button_text_hi');
        $('photo_button').addClassName('tab_button_off');
        $('photo_button').addClassName('button_text');
        $('direction_button').removeClassName('tab_button_off');
        $('direction_button').removeClassName('button_text');
        $('direction_button').addClassName('tab_button_on');
        $('direction_button').addClassName('button_text_hi');
        $('photos').hide();
        $('directions').show();
      })
    }

    function photoTab() {
      $('photo_button').observe('click', function() {
        $('direction_button').removeClassName('tab_button_on');
        $('direction_button').removeClassName('button_text_hi');
        $('direction_button').addClassName('tab_button_off');
        $('direction_button').addClassName('button_text');
        $('photo_button').removeClassName('tab_button_off');
        $('photo_button').removeClassName('button_text');
        $('photo_button').addClassName('tab_button_on');
        $('photo_button').addClassName('button_text_hi');
        $('directions').hide();
        $('photos').show();
      })
    }

    function unitTypeClick() {
      $('price_table').observe('click', function() {
        var unitId =  $('price_table').select('input:checked[type=radio]').pluck('value');
        monthlyRent = prices[unitId];
        $('unitId').value = unitId;
        priceUpper = false;
        priceInterior = false;
        priceDriveup = false;
        eval(unitTypes[unitId] + "= true;");
        $('priceDriveup').value = priceDriveup;
        $('priceUpper').value = priceUpper;
        $('priceInterior').value = priceInterior;
        showTotals();
        rentalFormReady = true;
        $('rentmeBtn').show();
      });
    }

    function insuranceClick() {
      $('insuranceChoices').observe('click', function() {
        var insId =  $('insuranceChoices').select('input:checked[type=radio]').pluck('value');
        premium = premiums[insId];
        showTotals();
      });
    }

    function specialOfferSelect() {
      $('specialOffers').observe('click', function() {
        var offerId =  $('specialOffers').select('input:checked[type=radio]').pluck('value');
        $('promoId').value = offerId;
        var oldOfferMonths = offerChosen.prepay ? offerChosen.prepayMonths + offerChosen.expireMonth : (offerChosen.inMonth - 1) + offerChosen.expireMonth;
        offerChosen = specialOffers[offerId];
        if (oldOfferMonths != offerChosen.prepay ? offerChosen.prepayMonths + offerChosen.expireMonth : (offerChosen.inMonth - 1) + offerChosen.expireMonth)  {
          buildTable();
        } else {
          showTotals();
        }
      });
    }

    function showTotals() {
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
            offerDiscount = (offerChosen.promoQty/100.0) * offerChosen.expireMonth * monthlyRent;
            break;

          case "FIXED_RATE":
            offerDiscount = (monthlyRent - offerChosen.promoQty) * offerChosen.expireMonth;
            break;
        }
        tableBody += "<tr class=\"specialOfferText tableLine\"><td  colspan=\"3\">Special Offer " + offerChosen.promoName + "<td class=\"price_text borderRight\">-$" + offerDiscount.toFixed(2) + "</td></tr>";
      }

      tableBody += "<tr class=\"tableLine\"><td colspan=\"3\">Admin Fee (one time charge)</td><td class=\"borderRight price_text\">$" + additionalFees.toFixed(2) + "</td></tr>";

      var paidThruRow = "";
      if (typeof(startDate) !== 'undefined') {
        var paidThru = Date.parseDate(startDate, "%m-%d-%Y");
        paidThru.setMonth( paidThru.getMonth() + durationMonths);
        // can't use colspan=4 or it renders border wrong in Chrome/Safari
        paidThruRow = "<tr class=\"tableLine\"><td colspan=\"2\">Paid Through Date: <span class=\"specialOfferText\">" + paidThru.print("%o/%d/%y") + "</span></td><td></td><td></td></tr>";
      }
      var total_movein = additionalFees + (monthlyRent + premium)*durationMonths - offerDiscount;

      $('price_totals_body').update(tableBody + paidThruRow);
      $('checkout_price_totals_body').update(tableBody);
      if (typeof(paidThru) !== 'undefined') {
        $('checkout_paid_through_date').update(paidThru.print("%o/%d/%y"));
      }
      $('price_total').update("$" + total_movein.toFixed(2));
      $('checkout_price_total').update("$" + total_movein.toFixed(2));
    }

    function rentmeClick() {
      $('rentme').observe('click', function() {
        if (rentalFormReady && validateRentme()) {
          $('sizeHelp').hide();
          var sdate = Date.parseDate($F('date'), "%m-%d-%Y");
          $('checkout_movein_date').update(sdate.print("%o/%d/%y"));
          $('moveInDate').value = $F('date');
          $('checkout_unit_size').update(storageSize[searchSize]);
          $('left_info').hide();
          $('left_checkout_info').show();
          $('rentalForm').show();
          $('detailInfo').hide();
        }
      });
    }

    function details_return() {
      $('left_info').show();
      $('left_checkout_info').hide();
      $('rentalForm').hide();
      $('detailInfo').show();
    }

    function idTypeClick() {
      $('idType').observe('change', function() {
         var idType = $F('idType');
         switch($F('idType')) {
            case "PASSPORT":
              $('idStateLabel').hide();
              $('idStateField').hide();
              $('idCountryLabel').show();
              $('idCountryField').show();
              break;
            case "DRIVERSLICENSE":
              $('idCountryLabel').hide();
              $('idCountryField').hide();
              $('idStateLabel').show();
              $('idStateField').show();
              break;
         }
      });
    }

    function primaryCountryClick() {
      $('contactPrimary.country').observe('change', function() {
        var country = $F('contactPrimary.country');
        if (country == "US") {
          $('primaryProvinceField').hide();
          $('primaryStateField').show();
          $('primaryProvinceLabel').hide();
          $('primaryStateLabel').show();
        } else {
          $('primaryProvinceField').show();
          $('primaryStateField').hide();
          $('primaryProvinceLabel').show();
          $('primaryStateLabel').hide();
        }
      });
    }

    function secondaryCountryClick() {
      $('contactSecondary.country').observe('change', function() {
        var country = $F('contactSecondary.country');
        if (country == "US") {
          $('secondaryProvinceField').hide();
          $('secondaryStateField').show();
          $('secondaryProvinceLabel').hide();
          $('secondaryStateLabel').show();
        } else {
          $('secondaryProvinceField').show();
          $('secondaryStateField').hide();
          $('secondaryProvinceLabel').show();
          $('secondaryStateLabel').hide();
        }
      });
    }

    function validateStep1() {
      var valid = true;
      valid &= Validation.validate('contactPrimary.firstName');
      valid &= Validation.validate('contactPrimary.lastName');
      valid &= Validation.validate('contactPrimary.streetNumber');
      valid &= Validation.validate('contactPrimary.street');
      valid &= Validation.validate('contactPrimary.city');
      valid &= Validation.validate('contactPrimary.state');
      valid &= Validation.validate('contactPrimary.zipcode');
      valid &= Validation.validate('contactPrimary.phone');
      valid &= Validation.validate('contactPrimary.email');
      valid &= Validation.validate('idState');
      valid &= Validation.validate('idNumber');
      return valid;
    }

    function validateStep2() {
      // TODO validate dupe information
      var valid = true;
      valid &= Validation.validate('contactSecondary.firstName');
      valid &= Validation.validate('contactSecondary.lastName');
      valid &= Validation.validate('contactSecondary.streetNumber');
      valid &= Validation.validate('contactSecondary.street');
      valid &= Validation.validate('contactSecondary.city');
      valid &= Validation.validate('contactSecondary.state');
      valid &= Validation.validate('contactSecondary.zipcode');
      valid &= Validation.validate('contactSecondary.phone');
      valid &= Validation.validate('contactSecondary.email');
      return valid;
    }

    function validateStep3() {
      var valid = true;
      valid &= Validation.validate('rentalUse');
      valid &= Validation.validate('insuranceChoices');
      valid &= Validation.validate('insuranceTermsHolder');
      valid &= Validation.validate('hazardousMaterialsHolder');
      valid &= Validation.validate('termsHolder');
      return valid;
    }

    function validateRentme() {
      var valid = true;
      valid &= Validation.validate('unitsize');
      valid &= Validation.validate('date');
      return valid;
    }

    function nextStep1() {
      if (validateStep1()) {
        $('step1_bullet').hide();
        $('step2_bullet').show();
        $('step1').removeClassName('step_header_hi');
        $('step1').addClassName('step_header');
        $('step2').removeClassName('step_header');
        $('step2').addClassName('step_header_hi');
        $('primary_contact').hide();
        $('secondary_contact').show();
      }
    }

    function prevStep2() {
      $('step2_bullet').hide();
      $('step1_bullet').show();
      $('step1').addClassName('step_header_hi');
      $('step1').removeClassName('step_header');
      $('step2').addClassName('step_header');
      $('step2').removeClassName('step_header_hi');
      $('secondary_contact').hide();
      $('primary_contact').show();
    }

    function nextStep2() {
      if (validateStep2()) {
        $('step2_bullet').hide();
        $('step3_bullet').show();
        $('step2').removeClassName('step_header_hi');
        $('step2').addClassName('step_header');
        $('step3').removeClassName('step_header');
        $('step3').addClassName('step_header_hi');
        $('secondary_contact').hide();
        $('rental_info').show();
      }
    }

    function prevStep3() {
      $('step3_bullet').hide();
      $('step2_bullet').show();
      $('step3').removeClassName('step_header_hi');
      $('step3').addClassName('step_header');
      $('step2').removeClassName('step_header');
      $('step2').addClassName('step_header_hi');
      $('rental_info').hide();
      $('secondary_contact').show();
    }

    function nextStep3() {
      if (validateStep3()) {
        $('step3_bullet').hide();
        $('step4_bullet').show();
        $('step3').removeClassName('step_header_hi');
        $('step3').addClassName('step_header');
        $('step4').removeClassName('step_header');
        $('step4').addClassName('step_header_hi');
        $('rental_info').hide();
        $('rentalTransaction').submit();
      }
    }

    function setupCalendar() {
      Calendar.setup({
          dateField     : 'date',
          triggerElement: 'date',
          dateFormat    : '%m-%d-%Y'
      });
    }


  function showImage(img, newElem) {
    $$('img.gallerySelected').each(function(elem) {
      elem.removeClassName('gallerySelected');
      elem.addClassName('galleryNormal');
    });
    $(newElem).removeClassName('galleryNormal');
    $(newElem).addClassName('gallerySelected');
    var imgElem = new Element("img", {src:img, alt:"", visibility:"hidden", style:"display:block;margin:auto;"});
    $('imgFrame').update(imgElem);
    new Effect.Opacity(
     'imgFrame', {
        from: 0.0,
        to: 1.0,
        duration: 0.5,
        queue: 'end'
     }
    );
  }

  function rightArrowClick() {
    $('rightArrow').observe('click', function() {
      if (galleryImageNum < (${site.siteImages().size()} - 4)) {
        galleryImageNum++;
        new Effect.Move('items', { x: -62, y:0, mode:'relative'});
        if (galleryImageNum >= (${site.siteImages().size()} - 4)) {
          if($('rightArrow').hasClassName('rightArrowActive')) {
            $('rightArrow').removeClassName('rightArrowActive');
            $('rightArrow').addClassName('rightArrowNull');
          }
        }
        if ($('leftArrow').hasClassName('leftArrowNull')) {
          $('leftArrow').addClassName('leftArrowActive');
          $('leftArrow').removeClassName('leftArrowNull');
        }
      } else {
        if($('rightArrow').hasClassName('rightArrowActive')) {
          $('rightArrow').removeClassName('rightArrowActive');
          $('rightArrow').addClassName('rightArrowNull');
        }
      }
    });
  }

  function leftArrowClick() {
    $('leftArrow').observe('click', function() {
      if ((${site.siteImages().size()}) > 4 && galleryImageNum > 0) {
        galleryImageNum--;
        new Effect.Move('items', { x: 62, y:0, mode:'relative'});
        if (galleryImageNum < (${site.siteImages().size()} - 4)) {
          if($('rightArrow').hasClassName('rightArrowNull')) {
            $('rightArrow').removeClassName('rightArrowNull');
            $('rightArrow').addClassName('rightArrowActive');
          }
        }
        if (galleryImageNum == 0) {
          if($('leftArrow').hasClassName('leftArrowActive')) {
            $('leftArrow').removeClassName('leftArrowActive');
            $('leftArrow').addClassName('leftArrowNull');
          }
        }
      } else {
        if($('leftArrow').hasClassName('leftArrowActive')) {
          $('leftArrow').removeClassName('leftArrowActive');
          $('leftArrow').addClassName('leftArrowNull');
        }
      }
    });
  }

  function setupValidation() {
  }

  Event.observe(window, 'load', function() {
    createMap();
    setupSize();
    buildTable();
    setupHelp();
    sizeChange();
    directionTab();
    photoTab();
    getDirections();
    unitTypeClick();
    idTypeClick();
    rentmeClick();
    setupCalendar();
    specialOfferSelect();
    setupValidation();
    primaryCountryClick();
    secondaryCountryClick();
    <g:if test="${site.requiresInsurance}">
    insuranceClick();
    </g:if>
    rightArrowClick();
    leftArrowClick();
    validateRentme();
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

          <div id="left_info">
            <div>
              <div class="section_header">Available sizes:  (currently <span id="sizeDescription">undefined</span>)</div>
              <g:if test="${params.searchSize}">
                <g:select id="unitsize" class="validate-selection" style="width:150px;" name="unitsize" from="${sizeList}" optionValue="description" value="${params.searchSize}" optionKey="id" />
              </g:if>
              <g:else>
                <g:select id="unitsize" class="validate-selection" style="width:150px;" name="unitsize" from="${sizeList}" optionValue="description" value="1" optionKey="id" />
              </g:else>
              <img id="sizeInfo" style="vertical-align: middle;" src="${createLinkTo(dir:'images', file:'icn_info_circle.png')}" alt="info"/>
            </div>
            <div style="height: 18px;"></div>
            <div>
              <div class="section_header">Start Date:</div>
              <label for="date"></label><input type="text" class="required validate-date-us dateInput" id="date" style="width: 150px;" value="${params.date}" onchange="dateChange()"/>
            </div>
            <div style="padding: 18px 0 10px;" class="section_header">
              Site Features:
            </div>

            <g:if test="${site.freeTruck  == storitz.constants.TruckType.FREE}">
              <div class="left">
                <img src="${createLinkTo(dir:'images', file:'icon3d-rentaltruck32f.gif')}" alt="Free Truck"/>
              </div>
              <div class="left icon_text">Free Truck</div>
              <div style="clear: both;"></div>
            </g:if>
            <g:if test="${site.freeTruck  == storitz.constants.TruckType.RENTAL}">
              <div class="left">
                <img src="${createLinkTo(dir:'images', file:'icon3d-rentaltruck32r.gif')}" alt="Rental Truck"/>
              </div>
              <div class="left icon_text">Rental Truck</div>
              <div style="clear: both;"></div>
            </g:if>
            <g:if test="${site.isGate}">
              <div class="left">
                <img src="${createLinkTo(dir:'images', file:'icon3d-gate32.jpg')}" alt="Gated"/>
              </div>
              <div class="left icon_text">Gated</div>
              <div style="clear: both;"></div>
            </g:if>
            <g:if test="${site.isKeypad}">
              <div class="left">
                <img src="${createLinkTo(dir:'images', file:'icon3d-keypad32.jpg')}" alt="Keypad"/>
              </div>
              <div class="left icon_text">Keypad Entry</div>
              <div style="clear: both;"></div>
            </g:if>
            <g:if test="${site.isCamera}">
              <div class="left">
                <img src="${createLinkTo(dir:'images', file:'icon3d-camera32.jpg')}" alt="Camera"/>
              </div>
              <div class="left icon_text">Camera</div>
              <div style="clear: both;"></div>
            </g:if>
            <g:if test="${site.isUnitAlarmed}">
              <div class="left">
                <img src="${createLinkTo(dir:'images', file:'icon3d-alarm32.jpg')}" alt="Alarmed"/>
              </div>
              <div class="left icon_text">Unit Alarmed</div>
              <div style="clear: both;"></div>
            </g:if>
            <div style="height:21px;"></div>
            <div class="other_details header_text_hi">
              Featured Offers:
            </div>
            <div class="featuredOfferText">
              <div id="specialOffers">
              <p class="featuredOfferHeader">Select from the list below to take advantage of these Special Offers!</p>
              <p><input type="radio" name="specialOffer" value="-1" checked="checked" /> None</p>
                <g:each in="${site.featuredOffers()}" var="offer">
                  <p><input type="radio" name="specialOffer" value="${offer.id}"/> ${offer.promoName} </p>
                </g:each>
                <g:if test="${site.nonFeaturedOffers().size() > 0}">
                  <div id="moreSpecialOffers" class="expanding">
                    <div class="right" onclick="Effect.toggle('moreSpecialOffers', 'appear', {queue: 'end', duration: 0.1});Effect.BlindDown('nonFeaturedOffers'); Effect.toggle('lessSpecialOffers', 'appear', {queue:'end', duration: 0.1});return false;">
                      <a href="#" style="text-decoration: none;"><img src="${resource(dir:'images', file:'icon-plus.png')}" style="border: none;" alt="plus icon"/> See All Special Offers</a>
                    </div>
                  </div>
                </g:if>
                <div id="nonFeaturedOffers" style="display:none">
                  <g:each in="${site.nonFeaturedOffers()}" var="offer">
                    <p><input type="radio" name="specialOffer" value="${offer.id}"/> ${offer.promoName} </p>
                  </g:each>
                </div>
                <div id="lessSpecialOffers" style="display: none;" class="expanding">
                  <div class="right">
                    <a href="#" style="text-decoration: none;" onclick="Effect.toggle('lessSpecialOffers', 'appear', {queue: 'end', duration: 0.1}); Effect.BlindUp('nonFeaturedOffers'); Effect.toggle('moreSpecialOffers', 'appear', {queue: 'end', duration: 0.1});return false;"><img src="${resource(dir:'images', file:'icon-minus.png')}" style="border: none;" alt="minus icon"/> See Only Featured Offers</a>
                  </div>
                </div>

              </div>
            </div>
          </div>
          <g:render template="/orderSummary"/>
        </div>

        <div style="width: 685px;" class="right">
          <div id="detailInfo">
            <div style="margin-top: -20px;">
              <div class="returnLink right" style="padding: 0 0.5em; margin-right: 20px;">
                <g:link controller="home" action="index">
                  New Search
                </g:link>
              </div>
              <div class="returnLink right">|</div>
              <div class="returnLink right" style="padding: 0 0.5em;">
                <g:link controller="home" action="index" params="[size: params.searchSize, date: params.date, address: params.address]">
                 Back to Seach Results
                </g:link>
              </div>
            </div>
            <div style="height: 25px; clear: both;"></div>
            <div id="map">
              <img src="http://maps.google.com/maps/api/staticmap?center=${site.lat},${site.lng}&zoom=15&size=314x265&maptype=roadmap&markers=icon:${resource(absolute: true, dir:'images', file:'icn_map_grn.png')}|${site.lat},${site.lng}&sensor=false&key=ABQIAAAAEDNru_s_vCsZdWplqCj4hxSjGMYCLTKEQ0TzQvUUxxIh1qVrLhTUMUuVByc3xGunRlZ-4Jv6pHfFHA" alt="Map of ${site.title}"/>
            </div>
            <div id="detail_tabs">
              <div id="photo_button" class="left tab_button_on button_text_hi">Photos</div><div id="direction_button" class="right tab_button_off button_text">Directions</div>
              <div style="clear: both;"></div>
              <div id="photos">
                <div id="imgFrame">
                  <g:if test="${site.siteImages().size() > 0}">
                      <img src="${resource(file:site.coverImage().mid())}" style="display:block;margin:auto;" alt=""/>
                  </g:if>
                  <g:else>
                    <img src="${resource(dir: 'images', file:'placeholder.jpg')}" alt="place holder"/>
                  </g:else>
                </div>
                <div id="leftArrow" class="left ${site.siteImages().size() > 4 ? 'leftArrowNull' : 'arrowEmpty'}" style="margin-top: 8px;">
                </div>
                <div class="left" id="thumbWrapper">
                  <ul id="items">
                     <g:each var="siteImg" in="${site.siteImages()}" status="i">
                         <li class="thumb">
                           <img id="img${siteImg.imgOrder}" class="${i == 0 ? 'gallerySelected' : 'galleryNormal'}" src="${resource(file:siteImg.thumbnail())}" alt="" onclick="showImage('${resource(file:siteImg.mid())}', 'img${siteImg.imgOrder}')"/>
                         </li>
                     </g:each>
                  </ul>
                </div>
                <div id="rightArrow" class="left ${site.siteImages().size() > 4 ? 'rightArrowActive' : 'arrowEmpty'}" style="margin-top: 8px;">
                </div>
                <div style="clear: both;height: 5px;"></div>
              </div>
              <div id="directions" style="display:none;">
                <div>
                  <label for="srcAddr">Start Address:</label> <input type="text" name="srcAddr" id="srcAddr"/>
                </div>
                <div>
                  <label for="get_directions"></label><input id="get_directions" type="button" name="getDirections" value="Get Directions"/>
                </div>
                <div id="dirPanel"></div>
              </div>
            </div>
            <div style="clear:both;"></div>
            <table id="price_table">
              <thead>
                <tr class="price_options">
                  <th style="width:200px; text-align: left; padding-left:20px;">Options</th>
                  <th style="width:100px;">Months</th>
                  <th style="width:200px; text-align: right;">Monthly Rent</th>
                  <th style="width:166px; text-align: right;">Total Rent</th>
                </tr>
              </thead>
              <tbody id="price_body">
              </tbody>
            </table>
            <div style="height: 10px;"></div>
            <table id="price_totals">
              <tbody id="price_totals_body">
              </tbody>
              <tr class="price_options">
                <th style="width: 500px; text-align: left; padding-left:20px;">Total Move-In Cost:</th>
                <th id="price_total" class="price_text" style="width:166px; padding-right: 20px;"></th>
              </tr>
            </table>
            <div style="height:15px;"></div>
            <div class="left">
              <g:link controller="home" action="index" params="[size: params.searchSize, date: params.date, address: params.address]">
                <img src="${resource(dir:'images', file:'btn-previous2.png')}" style="border: 0; cursor: pointer;" alt="back home"/>
              </g:link>
            </div>
            <div id="rentmeBtn" style="float: right; margin-right: 20px; display: none;">
              <img id="rentme" src="${createLinkTo(dir:'images', file:'btn-rent-me.png')}" alt="Rent Me"/>
            </div>
          </div>

          <div id="rentalForm" style="display: none;">
            <g:form action="save" controller="rentalTransaction" name="rentalTransaction" method="post" useToken="true">
              <input type="hidden" name="priceDriveup" id="priceDriveup" value="" />
              <input type="hidden" name="priceInterior" id="priceInterior" value="" />
              <input type="hidden" name="priceUpper" id="priceUpper" value="" />
              <input type="hidden" name="unitId" id="unitId" value="" />
              <input type="hidden" name="promoId" id="promoId" value="" />
              <input type="hidden" name="site" value="${params.id}" />
              <input type="hidden" name="moveInDate" id="moveInDate" value="" />

              <div class="vert_text">
                <span id="step1_bullet" class="bullet">&#8226</span><span id="step1" class="step_header_hi">Primary Contact</span>
                <span id="step2_bullet" class="bullet" style="display: none;">&#8226</span><span id="step2" class="step_header">Secondary Contact</span>
                <span id="step3_bullet" class="bullet" style="display: none;">&#8226</span><span id="step3" class="step_header">Rental Options</span>
                <span id="step4_bullet" class="bullet" style="display: none;">&#8226</span><span id="step4" class="step_header">Billing Info</span>
                <span id="step5_bullet" class="bullet" style="display: none;">&#8226</span><span id="step5" class="step_header">Confirm Order</span>
              </div>

              <!-- Primary Contact -->
              <div id="primary_contact">
                <div class="price_options checkout_header white">
                  Primary Contact Information
                </div>
                <div class="formInstructions">
                  Information collected is for purposes of completing the Storage Rental Agreement, and will not be used for any other purpose except as described in our Privacy Policy
                </div>
                <div class="checkout_section_header">
                  Name
                </div>
                <div class="checkout_fields">
                  <div style="width:200px;" class="checkout_value ${hasErrors(bean: rentalTransaction, field: 'contactPrimary.firstName', 'errors')}">
                      <g:textField id="contactPrimary.firstName" name="contactPrimary.firstName" style="width: 180px;" class="required" value="${rentalTransaction?.contactPrimary?.firstName}" />
                  </div>
                  <div style="width:200px;" class="checkout_value ${hasErrors(bean: rentalTransaction, field: 'contactPrimary.lastName', 'errors')}">
                    <g:textField id="contactPrimary.lastName" name="contactPrimary.lastName" style="width: 180px;" class="required" value="${rentalTransaction?.contactPrimary?.lastName}" />
                  </div>
                  <div style="width:100px;" class="checkout_value ${hasErrors(bean: rentalTransaction, field: 'contactPrimary.suffixName', 'errors')}">
                    <g:textField id="contactPrimary.suffixName" name="contactPrimary.suffixName" style="width: 80px;" value="${rentalTransaction?.contactPrimary?.suffixName}" />
                  </div>
                  <div style="clear:both;"></div>
                </div>
                <div class="checkout_labels">
                  <div class="checkout_name" style="width:200px;">
                    <label for="contactPrimary.firstName">First Name</label>
                  </div>
                  <div class="checkout_name" style="width:200px;">
                    <label for="contactPrimary.lastName">Last Name</label>
                  </div>
                  <div class="checkout_name" style="width:100px;">
                    <label for="contactPrimary.suffixName">Suffix</label>
                  </div>
                  <div style="clear:both;"></div>
                </div>
                <div class="checkout_section_header">
                  Address
                </div>
                <div class="checkout_fields">
                  <div style="width:100px;" class="checkout_value ${hasErrors(bean: rentalTransaction, field: 'contactPrimary.streetNumber', 'errors')}">
                      <g:textField name="contactPrimary.streetNumber" id="contactPrimary.streetNumber" class="required" style="width:80px;" value="${rentalTransaction?.contactPrimary?.streetNumber}" />
                  </div>
                  <div style="width:200px;" class="checkout_value ${hasErrors(bean: rentalTransaction, field: 'contactPrimary.street', 'errors')}">
                      <g:textField name="contactPrimary.street" id="contactPrimary.street" class="required" style="width:180px;" value="${rentalTransaction?.contactPrimary?.street}" />
                  </div>
                  <div style="width:100px;" class="checkout_value ${hasErrors(bean: rentalTransaction, field: 'contactPrimary.streetType', 'errors')}">
                      <g:select name="contactPrimary.streetType" id="contactPrimary.streetType" style="width:80px;" from="${storitz.constants.StreetType.list()}" value="${rentalTransaction?.contactPrimary?.streetType}" optionValue="value"/>
                  </div>
                  <div style="width:100px;" class="checkout_value ${hasErrors(bean: rentalTransaction, field: 'contactPrimary.unit', 'errors')}">
                      <g:textField name="contactPrimary.unit" id="contactPrimary.unit" style="width:80px;" value="${rentalTransaction?.contactPrimary?.unit}" />
                  </div>
                  <div style="clear:both;"></div>
                </div>
                <div class="checkout_labels">
                  <div style="width:100px;" class="checkout_name">
                    <label for="contactPrimary.streetNumber">Street Number</label>
                  </div>
                  <div style="width:200px;" class="checkout_name">
                    <label for="contactPrimary.street">Street Name</label>
                  </div>
                  <div style="width:100px;" class="checkout_name">
                    <label for="contactPrimary.streetType">Street Suffix</label>
                  </div>
                  <div style="width:100px;" class="checkout_name">
                    <label for="contactPrimary.unit">Unit/Apt.</label>
                  </div>
                  <div style="clear:both;"></div>
                </div>
                <div class="checkout_fields">
                  <div style="width:200px;" class="checkout_value ${hasErrors(bean: rentalTransaction, field: 'contactPrimary.city', 'errors')}">
                      <g:textField name="contactPrimary.city" id="contactPrimary.city" class="required" style="width:180px;" value="${rentalTransaction?.contactPrimary?.city}" />
                  </div>
                  <div id="primaryStateField" style="width:100px;" class="checkout_value ${hasErrors(bean: rentalTransaction, field: 'contactPrimary.state', 'errors')}">
                    <g:select name="contactPrimary.state" id="contactPrimary.state" class="validate-selection" style="width:80px;" from="${storitz.constants.State.list()}" value="${rentalTransaction?.contactPrimary?.state}" optionValue="value"/>
                  </div>
                  <div id="primaryProvinceField" class="checkout_value ${hasErrors(bean: rentalTransaction, field: 'contactPrimary.province', 'errors')}" style="width: 150px;display: none;">
                    <g:textField name="contactPrimary.province" id="contactPrimary.province" class="required" style="width:130px;" value="${rentalTransaction?.contactPrimary?.province}" />
                  </div>
                  <div style="width:100px;" class="checkout_value ${hasErrors(bean: rentalTransaction, field: 'contactPrimary.zipcode', 'errors')}">
                      <g:textField name="contactPrimary.zipcode" id="contactPrimary.zipcode" class="required" style="width:80px;" value="${rentalTransaction?.contactPrimary?.zipcode}" />
                  </div>
                  <div style="width:200px;" class="checkout_value ${hasErrors(bean: rentalTransaction, field: 'contactPrimary.country', 'errors')}">
                    <g:select name="contactPrimary.country" id="contactPrimary.country" style="width:180px;" from="${storitz.constants.Country.list()}" value="${rentalTransaction?.contactPrimary?.country?.key}" optionKey="key" optionValue="display"/>
                  </div>
                  <div style="clear:both;"></div>
                </div>
                <div class="checkout_labels">
                  <div style="width:200px;" class="checkout_name">
                    <label for="contactPrimary.city">City</label>
                  </div>
                  <div style="width:100px;" id="primaryStateLabel" class="checkout_name">
                    <label for="contactPrimary.state">State</label>
                  </div>
                  <div style="width: 150px;display: none;" id="primaryProvinceLabel" class="checkout_name">
                    <label for="contactPrimary.province">Province</label>
                  </div>
                  <div style="width:100px;" class="checkout_name">
                    <label for="contactPrimary.zipcode">Postal Code</label>
                  </div>
                  <div style="width:200px;" class="checkout_name">
                    <label for="contactPrimary.country">Country</label>
                  </div>
                  <div style="clear:both;"></div>
                </div>
                <div class="checkout_section_header">
                  Phone / Email
                </div>
                <div class="checkout_fields">
                  <div style="width:100px;" class="checkout_value ${hasErrors(bean: rentalTransaction, field: 'contactPrimary.phoneType', 'errors')}">
                      <g:select name="contactPrimary.phoneType" id="contactPrimary.phoneType" style="width:80px;" from="${storitz.constants.PhoneType.list()}" value="${rentalTransaction?.contactPrimary?.phoneType}" optionValue="value"/>
                  </div>
                  <div style="width:200px;" class="checkout_value ${hasErrors(bean: rentalTransaction, field: 'contactPrimary.phone', 'errors')}">
                      <g:textField name="contactPrimary.phone" id="contactPrimary.phone" class="required" style="width:180px;" value="${rentalTransaction?.contactPrimary?.phone}" />
                  </div>
                  <div style="width:300px;" class="checkout_value ${hasErrors(bean: rentalTransaction, field: 'contactPrimary.email', 'errors')}">
                      <g:textField name="contactPrimary.email" id="contactPrimary.email" class="required validate-email" style="width:280px;" value="${rentalTransaction?.contactPrimary?.email}" />
                  </div>
                  <div style="clear:both;"></div>
                </div>
                <div class="checkout_labels">
                  <div style="width:100px;" class="checkout_name">
                    <label for="contactPrimary.phoneType">Phone Type</label>
                  </div>
                  <div style="width:200px;" class="checkout_name">
                    <label for="contactPrimary.phone">Phone Number</label>
                  </div>
                  <div style="width:300px;" class="checkout_name">
                    <label for="contactPrimary.email">Email</label>
                  </div>
                  <div style="clear:both;"></div>
                </div>
                <div class="checkout_section_header">
                  ID Information
                </div>
                <div class="checkout_fields">
                  <div style="width:200px;" class="checkout_value ${hasErrors(bean: rentalTransaction, field: 'idType', 'errors')}">
                      <g:select id="idType" name="idType" style="width:180px;" from="${storitz.constants.IdType.list()}" value="${rentalTransaction?.idType}" optionValue="value"/>
                  </div>
                  <div id="idStateField" style="width:100px;" class="checkout_value ${hasErrors(bean: rentalTransaction, field: 'idState', 'errors')}">
                      <g:select name="idState" id="idState" class="validate-selection" style="width:80px;" from="${storitz.constants.State.list()}" value="${rentalTransaction?.idState}" optionValue="value"/>
                  </div>
                  <div id="idCountryField" class="checkout_value ${hasErrors(bean: rentalTransaction, field: 'idCountry', 'errors')}" style="width:200px;display: none;">
                      <g:select name="idCountry" id="idCountry" style="width:180px;" from="${storitz.constants.Country.list()}" value="${rentalTransaction?.idCountry?.key}" optionKey="key" optionValue="display"/>
                  </div>
                  <div style="width:200px;" class="checkout_value ${hasErrors(bean: rentalTransaction, field: 'idNumber', 'errors')}">
                      <g:textField name="idNumber" id="idNumber" class="required" style="width:180px;" value="${rentalTransaction?.idNumber}" />
                  </div>
                  <div style="clear:both;"></div>
                </div>
                <div class="checkout_labels">
                  <div style="width:200px;" class="checkout_name">
                    <label for="idType">ID Type</label>
                  </div>
                  <div id="idStateLabel" style="width:100px;" class="checkout_name">
                    <label for="idState">ID State</label>
                  </div>
                  <div id="idCountryLabel" class="checkout_name" style="width:200px;display: none;">
                    <label for="idCountry">ID Country</label>
                  </div>
                  <div style="width:200px;" class="checkout_name">
                    <label for="idNumber">ID Number</label>
                  </div>
                  <div style="clear:both;"></div>
                </div>
                <div style="margin-top: 20px;">
                  <div class="left"><img src="${resource(dir:'images', file:'btn-previous2.png')}" onclick="details_return(); return false" alt="Back"></div>
                  <div class="right"><img src="${resource(dir:'images', file:'btn-nextstep2.png')}" onclick="nextStep1(); return false" alt="Next"></div>
                  <div style="clear:both;"></div>
                </div>
              </div>

              <!-- Secondary Contact -->
              <div id="secondary_contact" style="display:none;">
                <div class="price_options checkout_header white">
                  Secondary Contact Information
                </div>
                <div class="formInstructions">
                  Storage Property Owners (and most States) require a second contact with distinct address and phone number in the event your property is at risk and you are incapacitated or unreachable. A good second contact is a parent or friend.
                </div>
                <div class="checkout_section_header">
                  Name
                </div>
                <div class="checkout_fields">
                  <div style="width:200px;" class="checkout_value ${hasErrors(bean: rentalTransaction, field: 'contactSecondary.firstName', 'errors')}">
                      <g:textField name="contactSecondary.firstName" id="contactSecondary.firstName" class="required" style="width: 180px;" value="${rentalTransaction?.contactSecondary?.firstName}" />
                  </div>
                  <div style="width:200px;" class="checkout_value ${hasErrors(bean: rentalTransaction, field: 'contactSecondary.lastName', 'errors')}">
                    <g:textField name="contactSecondary.lastName" id="contactSecondary.lastName" class="required" style="width: 180px;" value="${rentalTransaction?.contactSecondary?.lastName}" />
                  </div>
                  <div style="width:100px;" class="checkout_value ${hasErrors(bean: rentalTransaction, field: 'contactSecondary.suffixName', 'errors')}">
                    <g:textField name="contactSecondary.suffixName" id="contactSecondary.suffixName" style="width: 80px;" value="${rentalTransaction?.contactSecondary?.suffixName}" />
                  </div>
                  <div style="clear:both;"></div>
                </div>
                <div class="checkout_labels">
                  <div class="checkout_name" style="width:200px;">
                    <label for="contactSecondary.firstName">First Name</label>
                  </div>
                  <div class="checkout_name" style="width:200px;">
                    <label for="contactSecondary.lastName">Last Name</label>
                  </div>
                  <div class="checkout_name" style="width:100px;">
                    <label for="contactSecondary.suffixName">Suffix</label>
                  </div>
                  <div style="clear:both;"></div>
                </div>
                <div class="checkout_section_header">
                  Address
                </div>
                <div class="checkout_fields">
                  <div style="width:100px;" class="checkout_value ${hasErrors(bean: rentalTransaction, field: 'contactSecondary.streetNumber', 'errors')}">
                      <g:textField name="contactSecondary.streetNumber" id="contactSecondary.streetNumber" class="required" style="width:80px;" value="${rentalTransaction?.contactSecondary?.streetNumber}" />
                  </div>
                  <div style="width:200px;" class="checkout_value ${hasErrors(bean: rentalTransaction, field: 'contactSecondary.street', 'errors')}">
                      <g:textField name="contactSecondary.street" id="contactSecondary.street" class="required" style="width:180px;" value="${rentalTransaction?.contactSecondary?.street}" />
                  </div>
                  <div style="width:100px;" class="checkout_value ${hasErrors(bean: rentalTransaction, field: 'contactSecondary.streetType', 'errors')}">
                      <g:select name="contactSecondary.streetType" id="contactSecondary.streetType" style="width:80px;" from="${storitz.constants.StreetType.list()}" value="${rentalTransaction?.contactSecondary?.streetType}" optionValue="value"/>
                  </div>
                  <div style="width:100px;" class="checkout_value ${hasErrors(bean: rentalTransaction, field: 'contactSecondary.unit', 'errors')}">
                      <g:textField name="contactSecondary.unit" id="contactSecondary.unit" style="width:80px;" value="${rentalTransaction?.contactSecondary?.unit}" />
                  </div>
                  <div style="clear:both;"></div>
                </div>
                <div class="checkout_labels">
                  <div style="width:100px;" class="checkout_name">
                    <label for="contactSecondary.streetNumber">Street Number</label>
                  </div>
                  <div style="width:200px;" class="checkout_name">
                    <label for="contactSecondary.street">Street Name</label>
                  </div>
                  <div style="width:100px;" class="checkout_name">
                    <label for="contactSecondary.streetType">Street Suffix</label>
                  </div>
                  <div style="width:100px;" class="checkout_name">
                    <label for="contactSecondary.unit">Unit/Apt.</label>
                  </div>
                  <div style="clear:both;"></div>
                </div>
                <div class="checkout_fields">
                  <div style="width:200px;" class="checkout_value ${hasErrors(bean: rentalTransaction, field: 'contactSecondary.city', 'errors')}">
                      <g:textField name="contactSecondary.city" id="contactSecondary.city" class="required" style="width:180px;" value="${rentalTransaction?.contactSecondary?.city}" />
                  </div>
                  <div id="secondaryStateField" style="width:100px;" class="checkout_value ${hasErrors(bean: rentalTransaction, field: 'contactSecondary.state', 'errors')}">
                    <g:select name="contactSecondary.state" id="contactSecondary.state" class="validate-selection" style="width:80px;" from="${storitz.constants.State.list()}" value="${rentalTransaction?.contactSecondary?.state}" optionValue="value"/>
                  </div>
                  <div id="secondaryProvinceField" class="checkout_value ${hasErrors(bean: rentalTransaction, field: 'contactSecondary.province', 'errors')}" style="width: 200px;display: none;">
                    <g:textField name="contactSecondary.province" id="contactSecondary.province" class="required" style="width:180px;" value="${rentalTransaction?.contactSecondary?.province}" />
                  </div>
                  <div style="width:100px;" class="checkout_value ${hasErrors(bean: rentalTransaction, field: 'contactSecondary.zipcode', 'errors')}">
                      <g:textField name="contactSecondary.zipcode" id="contactSecondary.zipcode" class="required" style="width:80px;" value="${rentalTransaction?.contactSecondary?.zipcode}" />
                  </div>
                  <div style="width:200px;" class="checkout_value ${hasErrors(bean: rentalTransaction, field: 'contactSecondary.country', 'errors')}">
                    <g:select name="contactSecondary.country" id="contactSecondary.country" style="width:180px;" from="${storitz.constants.Country.list()}" value="${rentalTransaction?.contactSecondary?.country?.key}" optionKey="key" optionValue="display"/>
                  </div>
                  <div style="clear:both;"></div>
                </div>
                <div class="checkout_labels">
                  <div style="width:200px;" class="checkout_name">
                    <label for="contactSecondary.city">City</label>
                  </div>
                  <div style="width:100px;" id="secondaryStateLabel" class="checkout_name">
                    <label for="contactSecondary.state">State</label>
                  </div>
                  <div style="width: 200px;display: none;" id="secondaryProvinceLabel" class="checkout_name">
                    <label for="contactSecondary.province">Province</label>
                  </div>
                  <div style="width:100px;" class="checkout_name">
                    <label for="contactSecondary.zipcode">Postal Code</label>
                  </div>
                  <div style="width:200px;" class="checkout_name">
                    <label for="contactSecondary.country">Country</label>
                  </div>
                  <div style="clear:both;"></div>
                </div>
                <div class="checkout_section_header">
                  Phone / Email
                </div>
                <div class="checkout_fields">
                  <div style="width:100px;" class="checkout_value ${hasErrors(bean: rentalTransaction, field: 'contactSecondary.phoneType', 'errors')}">
                      <g:select name="contactSecondary.phoneType" id="contactSecondary.phoneType" style="width:80px;" from="${storitz.constants.PhoneType.list()}" value="${rentalTransaction?.contactSecondary?.phoneType}" optionValue="value"/>
                  </div>
                  <div style="width:200px;" class="checkout_value ${hasErrors(bean: rentalTransaction, field: 'contactSecondary.phone', 'errors')}">
                      <g:textField name="contactSecondary.phone" id="contactSecondary.phone" class="required" style="width:180px;" value="${rentalTransaction?.contactSecondary?.phone}" />
                  </div>
                  <div style="width:300px;" class="checkout_value ${hasErrors(bean: rentalTransaction, field: 'contactSecondary.email', 'errors')}">
                      <g:textField name="contactSecondary.email" id="contactSecondary.email" class="required validate-email" style="width:280px;" value="${rentalTransaction?.contactSecondary?.email}" />
                  </div>
                  <div style="clear:both;"></div>
                </div>
                <div class="checkout_labels">
                  <div style="width:100px;" class="checkout_name">
                    <label for="contactSecondary.phoneType">Phone Type</label>
                  </div>
                  <div style="width:200px;" class="checkout_name">
                    <label for="contactSecondary.phone">Phone Number</label>
                  </div>
                  <div style="width:300px;" class="checkout_name">
                    <label for="contactSecondary.email">Email</label>
                  </div>
                  <div style="clear:both;"></div>
                </div>
                <div style="margin-top: 20px;">
                  <div class="right" style="margin-left:20px;"><img src="${resource(dir:'images', file:'btn-nextstep2.png')}" onclick="nextStep2(); return false" alt="Next"></div>
                  <div class="left"><img src="${resource(dir:'images', file:'btn-previous2.png')}" onclick="prevStep2(); return false" alt="Prev"></div>
                  <div style="clear:both;"></div>
                </div>
              </div>

              <!-- Rental Info -->
              <div id="rental_info" style="display:none;">
                <div class="price_options checkout_header white">
                  Rental Options
                </div>
                <div class="checkout_section_header">
                  Rental Use
                </div>
                <div class="checkout_fields">
                  <div id="rentalUse" class="validate-one-radio value ${hasErrors(bean: rentalTransaction, field: 'rentalUse', 'errors')}">
                      <g:radioGroup name="rentalUse" labels="${storitz.constants.RentalUse.labels()}" values="${storitz.constants.RentalUse.list()}" value="${rentalTransaction?.rentalUse}">
                        <div class="left" style="width:200px;">${it.radio} ${it.label}</div>
                      </g:radioGroup>
                      <div style="clear:both;"></div>
                  </div>
                </div>
                <g:if test="${site.freeTruck == storitz.constants.TruckType.FREE}">
                  <div class="checkout_section_header">
                    Free Truck
                  </div>
                  <div class="checkout_fields">
                    <div class="value ${hasErrors(bean: rentalTransaction, field: 'reserveTruck', 'errors')}">
                        <g:checkBox name="reserveTruck" id="reserveTruck" value="${rentalTransaction?.reserveTruck}" /> Reserve Free Truck for this move in
                    </div>
                    <div style="clear:both;"></div>
                  </div>
                </g:if>
                <g:elseif test="${site.freeTruck == storitz.constants.TruckType.RENTAL}">
                  <div class="checkout_section_header">
                    Rental Truck
                  </div>
                  <div class="checkout_fields">
                    <div class="value ${hasErrors(bean: rentalTransaction, field: 'reserveTruck', 'errors')}">
                        <g:checkBox name="reserveTruck" id="reserveTruck" value="${rentalTransaction?.reserveTruck}" /> Reserve Rental Truck for this move in
                    </div>
                    <div style="clear:both;"></div>
                  </div>
                </g:elseif>
                <div class="checkout_section_header">
                  Insurance
                </div>
                <div class="formInstructions">
                  Storage property owner does not carry insurance to cover the loss or damage of your items. Your existing Homeowner’s Insurance or Renter’s Insurance may cover items you keep in storage. Alternatively, you may select (are required to select) the level of monthly insurance coverage that you may pay for as part of your monthly rent.
                </div>
                <div class="checkout_fields" style="width:646px;">
                  <div id="insuranceChoices" class="validate-one-radio" >
                    <div class="left" style="width: 320px;"><input type="radio" name="insuranceId" value="-999" checked="checked" /> Waive insurance - use my renters/home policy coverage</div>
                    <g:each in="${site.insurances.sort{it.premium}}" var="ins">
                      <div class="left" style="width: 320px;"><input type="radio" name="insuranceId" value="${ins.insuranceId}"/> <g:formatNumber number="${ins.premium}" type="currency" currencyCode="USD" />/mo. Coverage: <g:formatNumber number="${ins.totalCoverage}" type="currency" currencyCode="USD" /> Theft: <g:formatNumber number="${ins.percentTheft}" type="percent" /></div>
                    </g:each>
                    <div style="clear:both;"></div>
                  </div>
                </div>
                <div class="checkout_fields">
                  <div id="insuranceTermsHolder" class="validate-one-checkbox value ${hasErrors(bean: rentalTransaction, field: 'insuranceTerms', 'errors')}">
                      <g:checkBox name="insuranceTerms" id="insuranceTerms" class="required" value="${rentalTransaction?.insuranceTerms}" /> By Checking Here, I acknowledge that I am responsible for damage or loss to my goods while stored at Storage Property
                  </div>
                  <div style="clear:both;"></div>
                </div>
                <div class="checkout_section_header">
                  Active Military
                </div>
                <div class="formInstructions">
                  Active US Military renters are not eligible for lien auctions. This protects your items while you are on duty.
                </div>
                <div class="checkout_fields">
                  <div class="value ${hasErrors(bean: rentalTransaction, field: 'activeMilitary', 'errors')}">
                      <g:checkBox name="activeMilitary" value="${rentalTransaction?.activeMilitary}" /> Are you a member of the US Armed Forces and on active duty?
                  </div>
                  <div style="clear:both;"></div>
                </div>
                <div class="checkout_section_header">
                  Hazardous Materials
                </div>
                <div class="checkout_fields">
                  <div id="hazardousMaterialsHolder" class="validate-one-checkbox value ${hasErrors(bean: rentalTransaction, field: 'hazardousMaterials', 'errors')}">
                      <g:checkBox name="hazardousMaterials" id="hazardousMaterials" class="required" value="${rentalTransaction?.hazardousMaterials}" /> By checking here, I agree to not store hazardous items according to Federal Code, which includes but is not limited to Tires, Oil, Gasoline or Flammables, Paints, Environmental or Toxic Waste and Perishable Food.
                  </div>
                  <div style="clear:both;"></div>
                </div>
                <div class="checkout_section_header">
                  Terms
                </div>
                <div class="checkout_fields">
                  <div id="termsHolder" class="validate-one-checkbox value ${hasErrors(bean: rentalTransaction, field: 'terms', 'errors')}">
                      <g:checkBox name="terms" id="terms" class="required" value="${rentalTransaction?.terms}" /> I agree to the terms and conditions of the Storage Rental Agreement
                  </div>
                  <div style="clear:both;"></div>
                </div>
                <div style="margin-top: 20px;">
                  <div class="right" style="margin-left:20px;"><img src="${resource(dir:'images', file:'btn-nextstep2.png')}" onclick="nextStep3(); return false" alt="Next"></div>
                  <div class="left"><img src="${resource(dir:'images', file:'btn-previous2.png')}" onclick="prevStep3(); return false" alt="Prev"></div>
                  <div style="clear:both;"></div>
                </div>
              </div>
            </g:form>
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