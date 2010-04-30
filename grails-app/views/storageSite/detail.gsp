<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN"
    "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" >
  <head>
    <g:render template="/header" />

    <script type="text/javascript">
//<![CDATA[
    google.load("prototype", "1.6.1.0");
    google.load("scriptaculous", "1.8.3");

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

    var priceDriveup = ${params.priceDriveup ? "true" : "false"};
    var priceInterior = ${params.priceInterior ? "true" : "false"};
    var priceUpper = ${params.priceUpper ? "true" : "false"};

    <g:each var="size" in="${sizeList}">storageSize[${size.id}] = "${size.description}";</g:each>
    <g:if test="${params.searchSize}">
      searchSize = ${params.searchSize};
      var sizeDescription = storageSize[ ${params.searchSize} ];
    </g:if>
    <g:each var="ins" in="${site.insurances}">premiums[${ins.insuranceId}] = ${ins.premium};</g:each>
    var defaultOffer = specialOffers[-1] = { active: true, promoName: "Default", promoType: "AMOUNT_OFF", promoQty: 0, prepay: false, prepayMonths: 1, inMonth: 1, expireMonth: 1 };
    <g:each var="offer" in="${site.specialOffers}">
      specialOffers[${offer.id}] = { active: ${offer.active}, promoName: "${offer.promoName}", promoType: "${offer.promoType}", promoQty: ${offer.promoQty}, prepay: ${offer.prepay},  prepayMonths: ${offer.prepayMonths}, inMonth: ${offer.inMonth}, expireMonth: ${offer.expireMonth}};
    </g:each>
    var premium = 0;
    var offerChosen = specialOffers[-1];

    function setupSize() {
      if(typeof(sizeDescription) !== 'undefined')  {
        $('sizeDescription').update(sizeDescription);
      }
    }

    function buildTable() {
      new Ajax.Request("${createLink(controller:'storageSite', action:'detailUnits')}",
      {
        method:'get',
        parameters: {searchSize: searchSize, id: siteId },
        onSuccess:function(transport) {
          var tableBody = "";
          var checkoutTableBody = "";
          var units = transport.responseJSON.units;
          var unitCount = (units.driveUp ? 1 : 0) + (units.interior ? 1 : 0) + (units.upper ? 1 : 0);
          var rowCount = 0;
          var durationMonths = (offerChosen.prepay ? offerChosen.prepayMonths + offerChosen.expireMonth : (offerChosen.inMonth -1) + offerChosen.expireMonth);
          $('priceDriveup').value = false;
          $('priceUpper').value = false;
          $('priceInterior').value = false;
          if (units) {
            if (units.driveup) {
              tableBody += "<tr class=" + (rowCount++ % 2 == 0 ? "roweven" : "rowodd") + ">";
              tableBody += "<td style=\"padding-left:20px;\"><input type=\"radio\" name=\"unit_choice\" value=\"" + units.driveup.id + "\"" + (priceDriveup || unitCount == 1 ? " checked=\"true\"" : "") + "/> Drive up</td>";
              tableBody += "<td class=\"price_text\">" + durationMonths + "</td><td class=\"price_text\">$" + units.driveup.price.toFixed(2) + "</td>";
              tableBody += "<td class=\"price_text\">$" + (units.driveup.price*durationMonths).toFixed(2) + "</td>";
              tableBody += "</tr>";
              prices[units.driveup.id] = units.driveup.price;
              unitTypes[units.driveup.id] = 'priceDriveup';
              if (priceDriveup || unitCount == 1) {
                unitId = units.driveup.id;
                monthlyRent = prices[unitId];
                $('priceDriveup').value = true;
                rentalFormReady = true;
                $('rentmeBtn').show();
                checkoutTableBody += "<tr>";
                checkoutTableBody += "<td>Drive up</td>";
                checkoutTableBody += "<td class=\"price_text\">" + durationMonths + "</td><td class=\"price_text\">$" + units.driveup.price.toFixed(2) + "</td>";
                checkoutTableBody += "<td class=\"price_text\">$" + (units.driveup.price*durationMonths).toFixed(2) + "</td>";
                checkoutTableBody += "</tr>";
              }
            }
            if (units.interior) {
              tableBody += "<tr class=" + (rowCount++ % 2 == 0 ? "roweven" : "rowodd") + ">";
              tableBody += "<td style=\"padding-left:20px;\"><input type=\"radio\" name=\"unit_choice\" value=\"" + units.interior.id + "\"" + (priceInterior || unitCount == 1 ? " checked=\"true\"" : "") + "/> Interior</td>";
              tableBody += "<td class=\"price_text\">" + durationMonths + "</td><td class=\"price_text\">$" + units.interior.price.toFixed(2) + "</td>";
              tableBody += "<td class=\"price_text\">$" + (units.interior.price*durationMonths).toFixed(2) + "</td>";
              tableBody += "</tr>";
              prices[units.interior.id] = units.interior.price;
              unitTypes[units.interior.id] = 'priceInterior';
              if (priceInterior || unitCount == 1) {
                unitId = units.interior.id;
                monthlyRent = prices[unitId];
                $('priceInterior').value = true;
                rentalFormReady = true;
                $('rentmeBtn').show();
                checkoutTableBody += "<tr>";
                checkoutTableBody += "<td>Interior</td>";
                checkoutTableBody += "<td class=\"price_text\">" + durationMonths + "</td><td class=\"price_text\">$" + units.interior.price.toFixed(2) + "</td>";
                checkoutTableBody += "<td class=\"price_text\">$" + (units.interior.price*durationMonths).toFixed(2) + "</td>";
                checkoutTableBody += "</tr>";
              }
            }
            if (units.upper) {
              tableBody += "<tr class=" + (rowCount++ % 2 == 0 ? "roweven" : "rowodd") + ">";
              tableBody += "<td style=\"padding-left:20px;\"><input type=\"radio\" name=\"unit_choice\" value=\"" + units.upper.id + "\"" + (priceUpper || unitCount == 1 ? " checked=\"true\"" : "") + "/> Upper</td>";
              tableBody += "<td class=\"price_text\">" + durationMonths + "</td><td class=\"price_text\">$" + units.upper.price.toFixed(2) + "</td>";
              tableBody += "<td class=\"price_text\">$" + (units.upper.price*durationMonths).toFixed(2) + "</td>";
              tableBody += "</tr>";
              prices[units.upper.id] = units.upper.price;
              unitTypes[units.upper.id] = 'priceUpper';
              if (priceUpper || unitCount == 1) {
                unitId = units.upper.id;
                monthlyRent = prices[unitId];
                $('priceUpper').value = true;
                rentalFormReady = true;
                $('rentmeBtn').show();
                checkoutTableBody += "<tr>";
                checkoutTableBody += "<td>Upper</td>";
                checkoutTableBody += "<td class=\"price_text\">" + durationMonths + "</td><td class=\"price_text\">$" + units.upper.price.toFixed(2) + "</td>";
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
        $('sizeHelp').setStyle({ top: this.offsetTop - 10 + "px", left: this.offsetLeft + this.width + 10 + "px" });
        Effect.toggle('sizeHelp', 'appear', {duration: 0.8});
      });
    }

    function getDirections() {
      $('get_directions').observe('click', function(event) {
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
      $('unitsize').observe('change', function(event) {
        searchSize = $F('unitsize');
        $('sizeDescription').update(storageSize[searchSize]);
        buildTable();
      })
    }

    function directionTab() {
      $('direction_button').observe('click', function(event) {
        $('photo_button').removeClassName('tab_button');
        $('photo_button').removeClassName('button_text_hi');
        $('photo_button').addClassName('tab_spacer');
        $('photo_button').addClassName('button_text');
        $('direction_button').removeClassName('tab_spacer');
        $('direction_button').removeClassName('button_text');
        $('direction_button').addClassName('tab_button');
        $('direction_button').addClassName('button_text_hi');
        $('photos').hide();
        $('directions').show();
      })
    }

    function photoTab() {
      $('photo_button').observe('click', function(event) {
        $('direction_button').removeClassName('tab_button');
        $('direction_button').removeClassName('button_text_hi');
        $('direction_button').addClassName('tab_spacer');
        $('direction_button').addClassName('button_text');
        $('photo_button').removeClassName('tab_spacer');
        $('photo_button').removeClassName('button_text');
        $('photo_button').addClassName('tab_button');
        $('photo_button').addClassName('button_text_hi');
        $('directions').hide();
        $('photos').show();
      })
    }

    function unitTypeClick() {
      $('price_table').observe('click', function(event) {
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
      $('insuranceChoices').observe('click', function(event) {
        var insId =  $('insuranceChoices').select('input:checked[type=radio]').pluck('value');
        var unitId = $F('unitId');
        premium = premiums[insId];
        showTotals();
      });
    }

    function specialOfferSelect() {
      $('specialOffers').observe('click', function(event) {
        var offerId =  $('specialOffers').select('input:checked[type=radio]').pluck('value');
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
        tableBody += "<tr><td>Insurance:</td><td class=\"price_text\">" + durationMonths +"</td><td class=\"price_text\">$" + premium + "</td><td class=\"price_text\">$" + (durationMonths*premium).toFixed(2) + "</td></tr>";
      }
      tableBody += "<tr><td>Admin Fees:</td><td colspan=\"2\"></td><td class=\"price_text\">$" + additionalFees.toFixed(2) + "</td></tr>";

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
        tableBody += "<tr><td>Special Offer<BR/><span class=\"specialOfferText\">" + offerChosen.promoName + "</span><td colspan=\"2\"></td><td class=\"price_text specialOfferText\">-$" + offerDiscount.toFixed(2) + "</td></tr>";
      }
      if (typeof(startDate) !== 'undefined') {
        var paidThru = Date.parseDate(startDate, "%m-%d-%Y");
        paidThru.setMonth( paidThru.getMonth() + durationMonths);
        tableBody += "<tr><td>Paid Through Date:</td><td colspan=\"2\"></td><td class=\"price_text\">" + paidThru.print("%m-%d-%Y") + "</td></tr>";
      }
      var total_movein = additionalFees + (monthlyRent + premium)*durationMonths - offerDiscount;

      // TODO - calculate paid through date
      $('price_totals_body').update(tableBody);
      $('checkout_price_totals_body').update(tableBody);
      $('price_total').update("$" + total_movein.toFixed(2));
      $('checkout_price_total').update("$" + total_movein.toFixed(2));
    }

    function rentmeClick() {
      $('rentme').observe('click', function(event) {
        if (rentalFormReady) {
          $('checkout_movein_date').update($F('date'));
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
      $('idType').observe('change', function(event) {
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
      $('contactPrimary.country').observe('change', function(event) {
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
      valid &= Validation.validate('idNumber');
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
        // TODO validate fields
      $('step2_bullet').hide();
      $('step3_bullet').show();
      $('step2').removeClassName('step_header_hi');
      $('step2').addClassName('step_header');
      $('step3').removeClassName('step_header');
      $('step3').addClassName('step_header_hi');
      $('secondary_contact').hide();
      $('rental_info').show();
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

    function setupCalendar() {
      Calendar.setup({
          dateField     : 'date',
          triggerElement: 'date',
          dateFormat    : '%m-%d-%Y'
      });
    }

  function onDateChange() {
    startDate = $F('date');
    showTotals();
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
    <g:if test="${site.requiresInsurance}">
    insuranceClick();
    </g:if>
  });

//]]>
  </script>

  </head>
  <body>
    <g:render template="/topnav" />
    <div id="stcontent">
      <g:render template="/logo_bar" />
      <div>
        <div id="site_info">
          <div id="site_logo">
          </div>
          <div id="site_address">
            <div class="title">
            ${site.title}
            </div>
            <g:if test="${site.logoUrl}">
              <div>
                <img src="${site.logoUrl}" alt="logo"/>
              </div>
            </g:if>
            <div>
              ${site.address}
            </div>
            <div>
              ${site.address2}
            </div>
            <div>
              ${site.city}, ${site.state} ${site.zipcode}
            </div>
            <div style="height: 10px;"></div>
            <div>
              Weekdays:
              <g:if test="${site.openWeekday}">
                <g:formatDate format="h:mma" date="${site.startWeekday}"/> - <g:formatDate format="h:mma" date="${site.endWeekday}"/>
              </g:if>
              <g:else>Closed</g:else>
            </div>
            <div>
              Saturday:
              <g:if test="${site.openSaturday}">
                <g:formatDate format="h:mma" date="${site.startSaturday}"/> - <g:formatDate format="h:mma" date="${site.endSaturday}"/>
              </g:if>
              <g:else>Closed</g:else>
            </div>
            <div>
              Sunday:
              <g:if test="${site.openSunday}">
                <g:formatDate format="h:mma" date="${site.startSunday}"/> - <g:formatDate format="h:mma" date="${site.endSunday}"/>
              </g:if>
              <g:else>Closed</g:else>
            </div>
          </div>
          <div style="clear: both; height: 15px;"></div>
          <div>
            ${site.description}
          </div>

          <!--
            get the default image for the site here
          -->
          <div id="left_info">
            <div>
              <div class="section_header">Available sizes:  (currently <span id="sizeDescription">undefined</span>)</div>
              <g:if test="${params.searchSize}">
                <g:select id="unitsize" name="unitsize" from="${sizeList}" optionValue="description" value="${params.searchSize}" optionKey="id" />
              </g:if>
              <g:else>
                <g:select id="unitsize" name="unitsize" from="${sizeList}" optionValue="description" value="1" optionKey="id" />
              </g:else>
              <img id="sizeInfo" style="vertical-align: middle;" src="${createLinkTo(dir:'images', file:'icn_info_circle.png')}" alt="info"/>
            </div>
            <div>
              <div class="section_header">Start Date:</div>
              <input type="text" id="date" style="width: 105px;" value="${params.date}" onchange="onDateChange()"/>
            </div>
            <div style="padding: 10px 0px;" class="section_header">
              Site Features:
            </div>

            <g:if test="${site.freeTruck  == storagetech.constants.TruckType.FREE}">
              <div class="icon_text">
                <img src="${createLinkTo(dir:'images', file:'icon3d-rentaltruck32f.gif')}" alt="Free Truck"/> Free Truck
              </div>
            </g:if>
            <g:if test="${site.freeTruck  == storagetech.constants.TruckType.RENTAL}">
              <div class="icon_text">
                <img src="${createLinkTo(dir:'images', file:'icon3d-rentaltruck32r.gif')}" alt="Rental Truck"/> Rental Truck
              </div>
            </g:if>
            <g:if test="${site.isGate}">
              <div class="icon_text">
                <img src="${createLinkTo(dir:'images', file:'icon3d-gate32.jpg')}" alt="Gated"/> Gated
              </div>
            </g:if>
            <g:if test="${site.isKeypad}">
              <div class="icon_text">
                <img src="${createLinkTo(dir:'images', file:'icon3d-keypad32.jpg')}" alt="Keypad"/> Keypad Entry
              </div>
            </g:if>
            <g:if test="${site.isCamera}">
              <div class="icon_text">
                <img src="${createLinkTo(dir:'images', file:'icon3d-camera32.jpg')}" alt="Camera"/> Camera
              </div>
            </g:if>
            <g:if test="${site.isUnitAlarmed}">
              <div class="icon_text">
                <img src="${createLinkTo(dir:'images', file:'icon3d-alarm32.jpg')}" alt="Alarmed"/> Unit Alarmed
              </div>
            </g:if>
            <div style="height:10px;"></div>
            <div class="other_details header_text_hi">
              Special Offers:
            </div>

            <div class="icon_text">
              <ul>
                <div id="specialOffers">
                <p><input type="radio" name="specialOffer" value="-1" checked="checked" /> None</p>
                  <g:each in="${site.specialOffers}" var="offer">
                    <g:if test="${offer.active}">
                      <p><input type="radio" name="specialOffer" value="${offer.id}"/> ${offer.promoName} </p>
                    </g:if>
                  </g:each>
                </div>
              </ul>
            </div>
          </div>
          <div id="left_checkout_info" style="display: none;">
            <div>
              Unit size: <span id="checkout_unit_size"></span>
            </div>
            <div>
              Move in date: <span id="checkout_movein_date"></span>
            </div>
            <table id="checkout_price_table" style="width: 300px;">
              <thead>
                <tr>
                  <th>Options</th>
                  <th>Months</th>
                  <th>Monthly Rent</th>
                  <th>Total Rent</th>
                </tr>
              </thead>
              <tbody id="checkout_price_body">
              </tbody>
            </table>
            <table id="checkout_price_totals" style="width: 300px;">
              <tbody id="checkout_price_totals_body">
              </tbody>
              <tfoot>
                <tr>
                  <th>Total Move-In Cost:</th>
                  <th></th>
                  <th></th>
                  <th id="checkout_price_total"></th>
                </tr>
              </tfoot>
            </table>
            <div style="height: 10px;"></div>
            <div class="returnLink">
              <g:link controller="home" action="index" params="[size: params.searchSize, date: params.date, address: params.address]">
                &laquo; Back to Seach Results
              </g:link>
            </div>
            <div class="returnLink">
              <g:link controller="home" action="index">
                Results Start New Search &raquo;
              </g:link>
            </div>
          </div>
        </div>

        <div class="right">
          <div id="detailInfo">
            <div>
              <div class="returnLink" style="margin-left: 100px; float: left;">
                <g:link controller="home" action="index" params="[size: params.searchSize, date: params.date, address: params.address]">
                  &laquo; Back to Seach Results
                </g:link>
              </div>
              <div class="returnLink" style="margin-right: 100px; float: right;">
                <g:link controller="home" action="index">
                  Results Start New Search &raquo;
                </g:link>
              </div>
            </div>
            <div style="height: 10px; clear: both;"></div>
            <div id="map">
              <img src="http://maps.google.com/maps/api/staticmap?center=${site.lat},${site.lng}&zoom=15&size=360x300&maptype=roadmap&markers=icon:${resource(absolute: true, dir:'images', file:'icn_map_grn.png')}|${site.lat},${site.lng}&sensor=false&key=ABQIAAAAEDNru_s_vCsZdWplqCj4hxSjGMYCLTKEQ0TzQvUUxxIh1qVrLhTUMUuVByc3xGunRlZ-4Jv6pHfFHA" alt="Map of ${site.title}"/>
            </div>
            <div id="detail_tabs">
              <div id="photo_button" class="left tab_button button_text_hi">Photos</div><div id="direction_button" class="right tab_spacer button_text">Get Directions</div>
              <div style="clear: both;"></div>
              <div id="photos">
                Photos
              </div>
              <div id="directions" style="display:none;">
                <div>
                  Start Address: <input type="text" name="srcAddr" id="srcAddr"/>
                </div>
                <div>
                  <input id="get_directions" type="button" name="getDirections" value="Get Directions"/>
                </div>
                <div id="dirPanel"></div>
              </div>
            </div>
            <div style="clear:both;"></div>
            <table id="price_table">
              <thead class="price_options">
                <tr>
                  <th>Options</th>
                  <th>Months</th>
                  <th>Monthly Rent</th>
                  <th>Total Rent</th>
                </tr>
              </thead>
              <tbody id="price_body">
              </tbody>
            </table>
            <table id="price_totals">
              <tbody id="price_totals_body">
              </tbody>
              <tfoot class="price_options">
                <tr>
                  <th>Total Move-In Cost:</th>
                  <th></th>
                  <th></th>
                  <th id="price_total" class="price_text"></th>
                </tr>
              </tfoot>
            </table>
            <div style="height:10px;"></div>
            <div id="rentmeBtn" style="float: right; display: none;">
              <img id="rentme" src="${createLinkTo(dir:'images', file:'btn-rentme-106x34.gif')}" alt="Rent Me"/>
            </div>
          </div>

          <div id="rentalForm" style="display: none;">
            <input type="hidden" id="priceDriveup" value="" />
            <input type="hidden" id="priceInterior" value="" />
            <input type="hidden" id="priceUpper" value="" />
            <input type="hidden" id="unitId" value="" />

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
                <div style="clear:both;"></div>
              </div>
              <div class="checkout_labels">
                <div class="checkout_name" style="width:200px;">
                  <label for="contactPrimary.firstName">First Name</label>
                </div>
                <div class="checkout_name" style="width:200px;">
                  <label for="contactPrimary.lastName">Last Name</label>
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
                    <g:select name="contactPrimary.streetType" id="contactPrimary.streetType" style="width:80px;" from="${storagetech.constants.StreetType.list()}" value="${rentalTransaction?.contactPrimary?.streetType}" optionValue="value"/>
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
                  <label for="contactPrimary.streetName">Street Name</label>
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
                    <g:textField name="contactPrimary.city" name="contactPrimary.city" class="required" style="width:180px;" value="${rentalTransaction?.contactPrimary?.city}" />
                </div>
                <div id="primaryStateField" style="width:100px;" class="checkout_value ${hasErrors(bean: rentalTransaction, field: 'contactPrimary.state', 'errors')}">
                  <g:select name="contactPrimary.state" id="contactPrimary.state" class="validate-selection" style="width:80px;" from="${storagetech.constants.State.list()}" value="${rentalTransaction?.contactPrimary?.state}" optionValue="value"/>
                </div>
                <div id="primaryProvinceField" class="checkout_value ${hasErrors(bean: rentalTransaction, field: 'contactPrimary.province', 'errors')}" style="width: 150px;display: none;">
                  <g:textField name="contactPrimary.province" name="contactPrimary.province" class="required" style="width:130px;" value="${rentalTransaction?.contactPrimary?.province}" />
                </div>
                <div style="width:100px;" class="checkout_value ${hasErrors(bean: rentalTransaction, field: 'contactPrimary.zipcode', 'errors')}">
                    <g:textField name="contactPrimary.zipcode" id="contactPrimary.zipcode" class="required" style="width:80px;" value="${rentalTransaction?.contactPrimary?.zipcode}" />
                </div>
                <div style="width:200px;" class="checkout_value ${hasErrors(bean: rentalTransaction, field: 'contactPrimary.country', 'errors')}">
                  <g:select name="contactPrimary.country" id="contactPrimary.country" style="width:180px;" from="${storagetech.constants.Country.list()}" value="${rentalTransaction?.contactPrimary?.country}" optionKey="key" optionValue="display"/>
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
                    <g:select name="contactPrimary.phoneType" id="contactPrimary.phoneType" style="width:80px;" from="${storagetech.constants.PhoneType.list()}" value="${rentalTransaction?.contactPrimary?.phoneType}" optionValue="value"/>
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
                    <g:select id="idType" name="idType" style="width:180px;" from="${storagetech.constants.IdType.list()}" value="${rentalTransaction?.idType}" optionValue="value"/>
                </div>
                <div id="idStateField" style="width:100px;" class="checkout_value ${hasErrors(bean: rentalTransaction, field: 'idState', 'errors')}">
                    <g:select name="idState" id="idState" class="validate-selection" style="width:80px;" from="${storagetech.constants.State.list()}" value="${rentalTransaction?.idState}" optionValue="value"/>
                </div>
                <div id="idCountryField" class="checkout_value ${hasErrors(bean: rentalTransaction, field: 'idCountry', 'errors')}" style="width:200px;display: none;">
                    <g:select name="idCountry" id="idCountry" style="width:180px;" from="${storagetech.constants.Country.list()}" value="${rentalTransaction?.idCountry}" optionKey="key" optionValue="display"/>
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
              <div style="height:30px;line-height:30px;">
                <a href="#" onclick="details_return(); return false">Back to details</a>&nbsp;
                <a href="#" onclick="nextStep1(); return false">Next</a>
              </div>
            </div>

            <!-- Secondary Contact -->
            <div id="secondary_contact" style="display:none;">
              <div class="price_options checkout_header white">
                Secondary Contact Information
              </div>
              <div class="checkout_section_header">
                Name
              </div>
              <div class="checkout_fields">
                <div style="width:200px;" class="checkout_value ${hasErrors(bean: rentalTransaction, field: 'contactSecondary.firstName', 'errors')}">
                    <g:textField name="contactSecondary.firstName" style="width: 180px;" value="${rentalTransaction?.contactSecondary?.firstName}" />
                </div>
                <div style="width:200px;" class="checkout_value ${hasErrors(bean: rentalTransaction, field: 'contactSecondary.lastName', 'errors')}">
                  <g:textField name="contactSecondary.lastName" style="width: 180px;" value="${rentalTransaction?.contactSecondary?.lastName}" />
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
                <div style="clear:both;"></div>
              </div>
              <div class="checkout_section_header">
                Address
              </div>
              <div class="checkout_fields">
                <div style="width:100px;" class="checkout_value ${hasErrors(bean: rentalTransaction, field: 'contactSecondary.streetNumber', 'errors')}">
                    <g:textField name="contactSecondary.streetNumber" style="width:80px;" value="${rentalTransaction?.contactSecondary?.streetNumber}" />
                </div>
                <div style="width:200px;" class="checkout_value ${hasErrors(bean: rentalTransaction, field: 'contactSecondary.street', 'errors')}">
                    <g:textField name="contactSecondary.street" style="width:180px;" value="${rentalTransaction?.contactSecondary?.street}" />
                </div>
                <div style="width:100px;" class="checkout_value ${hasErrors(bean: rentalTransaction, field: 'contactSecondary.streetType', 'errors')}">
                    <g:select name="contactSecondary.streetType" style="width:80px;" from="${storagetech.constants.StreetType.list()}" value="${rentalTransaction?.contactSecondary?.streetType}" optionValue="value"/>
                </div>
                <div style="width:100px;" class="checkout_value ${hasErrors(bean: rentalTransaction, field: 'contactSecondary.unit', 'errors')}">
                    <g:textField name="contactSecondary.unit" style="width:80px;" value="${rentalTransaction?.contactSecondary?.unit}" />
                </div>
                <div style="clear:both;"></div>
              </div>
              <div class="checkout_labels">
                <div style="width:100px;" class="checkout_name">
                  <label for="contactSecondary.streetNumber">Street Number</label>
                </div>
                <div style="width:200px;" class="checkout_name">
                  <label for="contactSecondary.streetName">Street Name</label>
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
                    <g:textField name="contactSecondary.city" style="width:180px;" value="${rentalTransaction?.contactSecondary?.city}" />
                </div>
                <div style="width:100px;" class="checkout_value ${hasErrors(bean: rentalTransaction, field: 'contactSecondary.state', 'errors')}">
                  <g:select name="contactSecondary.state" style="width:80px;" from="${storagetech.constants.State.list()}" value="${rentalTransaction?.contactSecondary?.state}" optionValue="value"/>
                </div>
                <div id="secondaryProvinceField" class="checkout_value ${hasErrors(bean: rentalTransaction, field: 'contactSecondary.province', 'errors')}" style="width: 200px;display: none;">
                  <g:textField name="contactSecondary.province" style="width:180px;" value="${rentalTransaction?.contactSecondary?.province}" />
                </div>
                <div style="width:100px;" class="checkout_value ${hasErrors(bean: rentalTransaction, field: 'contactSecondary.zipcode', 'errors')}">
                    <g:textField name="contactSecondary.zipcode" style="width:80px;" value="${rentalTransaction?.contactSecondary?.zipcode}" />
                </div>
                <div style="width:200px;" class="checkout_value ${hasErrors(bean: rentalTransaction, field: 'contactSecondary.country', 'errors')}">
                  <g:select name="contactSecondary.country" style="width:180px;" from="${storagetech.constants.Country.list()}" value="${rentalTransaction?.contactSecondary?.country}" optionKey="key" optionValue="display"/>
                </div>
                <div style="clear:both;"></div>
              </div>
              <div class="checkout_labels">
                <div style="width:200px;" class="checkout_name">
                  <label for="contactSecondary.city">City</label>
                </div>
                <div style="width:100px;" class="checkout_name">
                  <label for="contactSecondary.state">State</label>
                </div>
                <div style="width: 200px;display: none;"id="primaryProvinceLabel" class="checkout_name">
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
                    <g:select name="contactSecondary.phoneType" style="width:80px;" from="${storagetech.constants.PhoneType.list()}" value="${rentalTransaction?.contactSecondary?.phoneType}" optionValue="value"/>
                </div>
                <div style="width:200px;" class="checkout_value ${hasErrors(bean: rentalTransaction, field: 'contactSecondary.phone', 'errors')}">
                    <g:textField name="contactSecondary.phone" style="width:180px;" value="${rentalTransaction?.contactSecondary?.phone}" />
                </div>
                <div style="width:300px;" class="checkout_value ${hasErrors(bean: rentalTransaction, field: 'contactSecondary.email', 'errors')}">
                    <g:textField name="contactSecondary.email" style="width:280px;" value="${rentalTransaction?.contactSecondary?.email}" />
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
            <div style="height:30px;line-height:30px;">
              <a href="#" onclick="details_return(); return false">Back to details</a>&nbsp;
              <a href="#" onclick="prevStep2(); return false">Prev</a>
              <a href="#" onclick="nextStep2(); return false">Next</a>
            </div>
            </div>

          <!-- Rental Info -->
          <div id="rental_info" style="display:none;">
            <table>
              <tbody>
                <tr>
                  <th colspan="3">Rental Information:</th>
                </tr>
                <tr>
                  <td valign="top" class="name">
                    <label for="rentalUse">Rental Use:</label>
                  </td>
                  <td valign="top" colspan="3" class="value ${hasErrors(bean: rentalTransaction, field: 'rentalUse', 'errors')}">
                      <g:radioGroup name="rentalUse" labels="${storagetech.constants.RentalUse.labels()}" values="${storagetech.constants.RentalUse.list()}" value="${rentalTransaction?.rentalUse}">
                        <p>${it.radio} ${it.label}</p>
                      </g:radioGroup>
                  </td>
                </tr>
                <g:if test="${site.freeTruck == storagetech.constants.TruckType.FREE}">
                  <tr>
                    <td valign="top" class="name">
                      <label for="reserveTruck">Reserve Free Truck:</label>
                    </td>
                    <td valign="top" colspan="3" class="value ${hasErrors(bean: rentalTransaction, field: 'reserveTruck', 'errors')}">
                        <g:checkBox name="reserveTruck" value="${rentalTransaction?.reserveTruck}" /> Reserve Free Truck for this move in
                    </td>
                  </tr>
                </g:if>
                <g:elseif test="${site.freeTruck == storagetech.constants.TruckType.RENTAL}">
                  <tr>
                    <td valign="top" class="name">
                      <label for="reserveTruck">Reserve Rental Truck:</label>
                    </td>
                    <td valign="top" colspan="3" class="value ${hasErrors(bean: rentalTransaction, field: 'reserveTruck', 'errors')}">
                        <g:checkBox name="reserveTruck" value="${rentalTransaction?.reserveTruck}" /> Reserve Rental Truck for this move in
                    </td>
                  </tr>
                </g:elseif>
                <g:if test="${site.requiresInsurance}">
                  <tr>
                    <td valign="top" class="name">
                      <label for="reserveTruck">Insurance:</label>
                    </td>
                    <td valign="top" colspan="3" class="value">
                        <div id="insuranceChoices">
                        <p><input type="radio" name="insuranceId" value="-999" checked="checked" /> Waive insurance - use my renters/home policy coverage</p>
                          <g:each in="${site.insurances.sort{it.premium}}" var="ins">
                            <p><input type="radio" name="insuranceId" value="${ins.insuranceId}"/> <g:formatNumber number="${ins.premium}" type="currency" currencyCode="USD" />/mo. Coverage: <g:formatNumber number="${ins.totalCoverage}" type="currency" currencyCode="USD" /> Theft: <g:formatNumber number="${ins.percentTheft}" type="percent" /></p>
                          </g:each>
                        </div>
                    </td>
                  </tr>
                </g:if>
                <tr>
                  <td valign="top" class="name">
                    <label for="activeMilitary">Active Military:</label>
                  </td>
                  <td valign="top" colspan="3" class="value ${hasErrors(bean: rentalTransaction, field: 'activeMilitary', 'errors')}">
                      <g:checkBox name="activeMilitary" value="${rentalTransaction?.activeMilitary}" /> Are you an active military member?
                  </td>
                </tr>
                <tr>
                  <td valign="top" class="name">
                    <label for="terms">Terms:</label>
                  </td>
                  <td valign="top" colspan="3" class="value ${hasErrors(bean: rentalTransaction, field: 'terms', 'errors')}">
                      <g:checkBox name="terms" value="${rentalTransaction?.terms}" /> I agree to the terms and conditions to rent this property
                  </td>
                </tr>
                </tbody>
              </table>
            </div>
          </div>
        </div>
      </div>
    </div>
    <div style="clear:both; height:30px;"></div>
    <g:render template="/footer" />
    <g:render template="/size_popup" />
    <script type="text/javascript" src="http://www.google.com/jsapi?autoload=%7B%22modules%22%3A%5B%7B%22name%22%3A%22maps%22%2C%22version%22%3A%223.x%22%2Cother_params%3A%22sensor%3Dfalse%22%2C%22callback%22%3A%22createMap%22%7D%2C%7B%22name%22%3A%22gdata%22%2C%22version%22%3A%222.x%22%2C%22packages%22%3A%5B%22maps%22%5D%7D%5D%7D&amp;key=ABQIAAAAEDNru_s_vCsZdWplqCj4hxSjGMYCLTKEQ0TzQvUUxxIh1qVrLhTUMUuVByc3xGunRlZ-4Jv6pHfFHA"></script>
  </body>
</html>