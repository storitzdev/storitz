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
    var searchSize;
    var unitId = ${params.id};
    var rentalFormReady = false;
    var additionalFees = ${site.adminFee ? site.adminFee : 0} + ${site.lockFee ? site.lockFee : 0};
    var destLatLng;

    var priceDriveup = ${params.priceDriveup ? "true" : "false"};
    var priceInterior = ${params.priceInterior ? "true" : "false"};
    var priceUpper = ${params.priceUpper ? "true" : "false"};

    <g:each var="size" in="${sizeList}">storageSize[${size.id}] = "${size.description}";</g:each>
    <g:if test="${params.searchSize}">
      searchSize = ${params.searchSize};
      var sizeDescription = storageSize[ ${params.searchSize} ];
    </g:if>
    <g:each var="ins" in="${site.insurances}">premiums[${ins.insuranceId}] = ${ins.premium};</g:each>
    var premium = 0;

    function setupSize() {
      if(typeof(sizeDescription) !== 'undefined')  {
        $('sizeDescription').update(sizeDescription);
      }
    }

    function buildTable() {
      new Ajax.Request("${createLink(controller:'storageSite', action:'detailUnits')}",
      {
        method:'get',
        parameters: {searchSize: searchSize, id: unitId},
        onSuccess:function(transport) {
          var tableBody = "<table>"
          var units = transport.responseJSON.units;
          var rowCount = 0;
          $('priceDriveup').value = false;
          $('priceUpper').value = false;
          $('priceInterior').value = false;
          if (units) {
            if (units.driveup) {
              tableBody += "<tr class=" + (rowCount++ % 2 == 0 ? "roweven" : "rowodd") + ">";
              tableBody += "<td style=\"padding-left:20px;\"><input type=\"radio\" name=\"unit_choice\" value=\"" + units.driveup.id + "\"" + (priceDriveup ? " checked=\"true\"" : "") + "/> Drive up</td><td class=\"price_text\"><span class=\"price_text\">$" + units.driveup.price + "</span></td>";
              tableBody += "</tr>";
              prices[units.driveup.id] = units.driveup.price;
              unitTypes[units.driveup.id] = 'priceDriveup';
              if (priceDriveup) {
                $('price_total').update("Price: $" + (additionalFees + units.driveup.price));
                $('priceDriveup').value = true;
              }
            }
            if (units.interior) {
              tableBody += "<tr class=" + (rowCount++ % 2 == 0 ? "roweven" : "rowodd") + ">";
              tableBody += "<td style=\"padding-left:20px;\"><input type=\"radio\" name=\"unit_choice\" value=\"" + units.interior.id + "\"" + (priceInterior ? " checked=\"true\"" : "") + "/> Interior</td><td class=\"price_text\"><span class=\"price_text\">$" + units.interior.price + "</span></td>";
              tableBody += "</tr>";
              prices[units.interior.id] = units.interior.price;
              unitTypes[units.interior.id] = 'priceInterior';
              if (priceInterior) {
                $('price_total').update("Price: $" + (additionalFees + units.interior.price));
                $('priceInterior').value = true;
              }
            }
            if (units.upper) {
              tableBody += "<tr class=" + (rowCount++ % 2 == 0 ? "roweven" : "rowodd") + ">";
              tableBody += "<td style=\"padding-left:20px;\"><input type=\"radio\" name=\"unit_choice\" value=\"" + units.upper.id + "\"" + (priceUpper ? " checked=\"true\"" : "") + "/> Upper</td><td class=\"price_text\"><span class=\"price_text\">$" + units.upper.price + "</span></td>";
              tableBody += "</tr>";
              prices[units.upper.id] = units.upper.price;
              unitTypes[units.upper.id] = 'priceUpper';
              if (priceUpper) {
                $('price_total').update("Price: $" + (additionalFees + units.upper.price));
                $('priceUpper').value = true;
              }
            }
          }
          tableBody += "</table>"
          $('price_table').update(tableBody);
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
        $('price_total').update("Price: $" + (prices[unitId] + additionalFees + premium));
        $('unitId').value = unitId;
        priceUpper = false;
        priceInterior = false;
        priceDriveup = false;
        eval(unitTypes[unitId] + "= true;");
        $('priceDriveup').value = priceDriveup;
        $('priceUpper').value = priceUpper;
        $('priceInterior').value = priceInterior;
        rentalFormReady = true;
        $('rentmeBtn').show();
      });
    }

    function insuranceClick() {
      $('insuranceChoices').observe('click', function(event) {
        var insId =  $('insuranceChoices').select('input:checked[type=radio]').pluck('value');
        var unitId = $F('unitId');
        premium = premiums[insId];
        $('price_total').update("Price: $" + (prices[unitId] + additionalFees + premium));
      });
    }

    function rentmeClick() {
      $('rentme').observe('click', function(event) {
        if (rentalFormReady) {
          $('step2').removeClassName('step_header_hi');
          $('step2').addClassName('step_header');
          $('step3').removeClassName('step_header');
          $('step3').addClassName('step_header_hi');
          $('rentalForm').show();
        }
      });
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
          </div>
          <div style="clear: both; height: 15px;"></div>
          <div>
            ${site.description}
          </div>
          <!--
            get the default image for the site here
          -->
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
              <g:each var="offer" in="${site.specialOffers}">
                <li>${offer.promoName}</li> 
              </g:each>
            </ul>
          </div>
        </div>
        <div class="right">
          <div class="right vert_text">
            <span id="step1" class="step_header">Search Storage</span>
            <span id="step2" class="step_header_hi">Review Options</span>
            <span id="step3" class="step_header">Billing Information</span>
            <span id="step4" class="step_header">Confirm Order</span>
          </div>
          <div style="clear:both;"></div>
          <div id="map">
            <img src="http://maps.google.com/maps/api/staticmap?center=${site.lat},${site.lng}&zoom=15&size=360x300&maptype=roadmap&markers=color:blue|${site.lat},${site.lng}&sensor=false&key=ABQIAAAAEDNru_s_vCsZdWplqCj4hxSjGMYCLTKEQ0TzQvUUxxIh1qVrLhTUMUuVByc3xGunRlZ-4Jv6pHfFHA" alt="Map of ${site.title}"/>
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
          <div class="price_options">
            <span class="header_text_hi">Options</span>
            <span class="header_text_hi right">Price</span>
          </div>
          <div id="price_table">
          </div>
          <div style="height:10px;"></div>
          <div id="rentmeBtn" style="float: right; display: none;">
            <span id="price_total"></span><img id="rentme" src="${createLinkTo(dir:'images', file:'btn-rentme-106x34.gif')}" alt="Rent Me"/>
          </div>
        </div>
        <div style="clear: both;"/>
        <div id="rentalForm" style="display: none;">
          <input type="hidden" id="priceDriveup" value="" />
          <input type="hidden" id="priceInterior" value="" />
          <input type="hidden" id="priceUpper" value="" />
          <input type="hidden" id="unitId" value="" />
          <table style="width:100%;">
            <tbody>
              <tr>
                <th colspan="2">Primary Contact:</th>
                <th colspan="2">Secondary Contact:</th>
              </tr>
              <tr>
                <td valign="top" class="name">
                  <label for="contactPrimary.firstName">First Name:</label>
                </td>
                <td valign="top" class="value ${hasErrors(bean: rentalTransaction, field: 'contactPrimary.firstName', 'errors')}">
                    <g:textField name="contactPrimary.firstName" value="${rentalTransaction?.contactPrimary?.firstName}" />
                </td>
                <td valign="top" class="name">
                  <label for="contactSecondary.firstName">First Name:</label>
                </td>
                <td valign="top" class="value ${hasErrors(bean: rentalTransaction, field: 'contactSecondary.firstName', 'errors')}">
                    <g:textField name="contactSecondary.firstName" value="${rentalTransaction?.contactSecondary?.firstName}" />
                </td>
              </tr>
            <tr>
              <td valign="top" class="name">
                <label for="contactPrimary.lastName">Last Name:</label>
              </td>
              <td valign="top" class="value ${hasErrors(bean: rentalTransaction, field: 'contactPrimary.lastName', 'errors')}">
                  <g:textField name="contactPrimary.lastName" value="${rentalTransaction?.contactPrimary?.lastName}" />
              </td>
              <td valign="top" class="name">
                <label for="contactSecondary.lastName">Last Name:</label>
              </td>
              <td valign="top" class="value ${hasErrors(bean: rentalTransaction, field: 'contactSecondary.lastName', 'errors')}">
                  <g:textField name="contactSecondary.lastName" value="${rentalTransaction?.contactSecondary?.lastName}" />
              </td>
            </tr>
            <tr>
              <th colspan="4">&nbsp;</th>
            </tr>
            <tr>
              <td valign="top" class="name">
                <label for="contactPrimary.streetNumber">Street Number:</label>
              </td>
              <td valign="top" class="value ${hasErrors(bean: rentalTransaction, field: 'contactPrimary.streetNumber', 'errors')}">
                  <g:textField name="contactPrimary.streetNumber" value="${rentalTransaction?.contactPrimary?.streetNumber}" />
              </td>
              <td valign="top" class="name">
                <label for="contactSecondary.streetNumber">Street Number:</label>
              </td>
              <td valign="top" class="value ${hasErrors(bean: rentalTransaction, field: 'contactSecondary.streetNumber', 'errors')}">
                  <g:textField name="contactSecondary.streetNumber" value="${rentalTransaction?.contactSecondary?.streetNumber}" />
              </td>
            </tr>
            <tr>
              <td valign="top" class="name">
                <label for="contactPrimary.streetNumber">Street Name:</label>
              </td>
              <td valign="top" class="value ${hasErrors(bean: rentalTransaction, field: 'contactPrimary.street', 'errors')}">
                  <g:textField name="contactPrimary.street" value="${rentalTransaction?.contactPrimary?.street}" />
              </td>
              <td valign="top" class="name">
                <label for="contactSecondary.streetNumber">Street Name:</label>
              </td>
              <td valign="top" class="value ${hasErrors(bean: rentalTransaction, field: 'contactSecondary.street', 'errors')}">
                  <g:textField name="contactSecondary.street" value="${rentalTransaction?.contactSecondary?.street}" />
              </td>
            </tr>
            <tr>
              <td valign="top" class="name">
                <label for="contactPrimary.streetType">Street Suffix:</label>
              </td>
              <td valign="top" class="value ${hasErrors(bean: rentalTransaction, field: 'contactPrimary.streetType', 'errors')}">
                  <g:select name="contactPrimary.streetType" from="${storagetech.constants.StreetType.list()}" value="${rentalTransaction?.contactPrimary?.streetType}" optionValue="value"/>
              </td>
              <td valign="top" class="name">
                <label for="contactSecondary.streetType">Street Suffix:</label>
              </td>
              <td valign="top" class="value ${hasErrors(bean: rentalTransaction, field: 'contactSecondary.streetType', 'errors')}">
                  <g:select name="contactSecondary.streetType" from="${storagetech.constants.StreetType.list()}" value="${rentalTransaction?.contactSecondary?.streetType}" optionValue="value"/>
              </td>
            </tr>
            <tr>
              <td valign="top" class="name">
                <label for="contactPrimary.unit">Unit/Apt.:</label>
              </td>
              <td valign="top" class="value ${hasErrors(bean: rentalTransaction, field: 'contactPrimary.unit', 'errors')}">
                  <g:textField name="contactPrimary.unit" value="${rentalTransaction?.contactPrimary?.unit}" />
              </td>
              <td valign="top" class="name">
                <label for="contactSecondary.unit">Unit/Apt.:</label>
              </td>
              <td valign="top" class="value ${hasErrors(bean: rentalTransaction, field: 'contactSecondary.unit', 'errors')}">
                  <g:textField name="contactSecondary.unit" value="${rentalTransaction?.contactSecondary?.unit}" />
              </td>
            </tr>
            <tr>
              <th colspan="4">&nbsp;</th>
            </tr>
            <tr>
              <td valign="top" class="name">
                <label for="contactPrimary.city">City:</label>
              </td>
              <td valign="top" class="value ${hasErrors(bean: rentalTransaction, field: 'contactPrimary.city', 'errors')}">
                  <g:textField name="contactPrimary.city" value="${rentalTransaction?.contactPrimary?.city}" />
              </td>
              <td valign="top" class="name">
                <label for="contactSecondary.city">City:</label>
              </td>
              <td valign="top" class="value ${hasErrors(bean: rentalTransaction, field: 'contactSecondary.city', 'errors')}">
                  <g:textField name="contactSecondary.city" value="${rentalTransaction?.contactSecondary?.city}" />
              </td>
            </tr>
            <tr>
              <td valign="top" class="name">
                <label for="contactPrimary.state">State:</label>
              </td>
              <td valign="top" class="value ${hasErrors(bean: rentalTransaction, field: 'contactPrimary.state', 'errors')}">
                <g:select name="contactPrimary.state" from="${storagetech.constants.State.list()}" value="${rentalTransaction?.contactPrimary?.state}" optionValue="value"/>
              </td>
              <td valign="top" class="name">
                <label for="contactSecondary.state">State:</label>
              </td>
              <td valign="top" class="value ${hasErrors(bean: rentalTransaction, field: 'contactSecondary.state', 'errors')}">
                <g:select name="contactSecondary.state" from="${storagetech.constants.State.list()}" value="${rentalTransaction?.contactSecondary?.state}" optionValue="value"/>
              </td>
            </tr>
            <tr>
              <td valign="top" id="primaryProvinceLabel" class="name" style="display: none;">
                <label for="contactPrimary.province">Province:</label>
              </td>
              <td valign="top" id="primaryProvinceField" class="value ${hasErrors(bean: rentalTransaction, field: 'contactPrimary.province', 'errors')}" style="display: none;">
                <g:textField name="contactPrimary.province" value="${rentalTransaction?.contactPrimary?.province}" />
              </td>
              <td valign="top" id="secondaryProvinceLabel" class="name" style="display: none;">
                <label for="contactSecondary.province">Province:</label>
              </td>
              <td valign="top" id="secondaryProvinceField" class="value ${hasErrors(bean: rentalTransaction, field: 'contactSecondary.province', 'errors')}" style="display: none;">
                <g:textField name="contactSecondary.province" value="${rentalTransaction?.contactSecondary?.province}" />
              </td>
            </tr>
            <tr>
              <td valign="top" class="name">
                <label for="contactPrimary.zipcode">Postal Code:</label>
              </td>
              <td valign="top" class="value ${hasErrors(bean: rentalTransaction, field: 'contactPrimary.zipcode', 'errors')}">
                  <g:textField name="contactPrimary.zipcode" value="${rentalTransaction?.contactPrimary?.zipcode}" />
              </td>
              <td valign="top" class="name">
                <label for="contactSecondary.city">Postal Code:</label>
              </td>
              <td valign="top" class="value ${hasErrors(bean: rentalTransaction, field: 'contactSecondary.zipcode', 'errors')}">
                  <g:textField name="contactSecondary.zipcode" value="${rentalTransaction?.contactSecondary?.zipcode}" />
              </td>
            </tr>
            <tr>
              <td valign="top" class="name">
                <label for="contactPrimary.country">Country:</label>
              </td>
              <td valign="top" class="value ${hasErrors(bean: rentalTransaction, field: 'contactPrimary.country', 'errors')}">
                <g:select name="contactPrimary.country" from="${storagetech.constants.Country.list()}" value="${rentalTransaction?.contactPrimary?.country}" optionKey="key" optionValue="display"/>
              </td>
              <td valign="top" class="name">
                <label for="contactSecondary.country">Country:</label>
              </td>
              <td valign="top" class="value ${hasErrors(bean: rentalTransaction, field: 'contactSecondary.country', 'errors')}">
                <g:select name="contactSecondary.state" from="${storagetech.constants.Country.list()}" value="${rentalTransaction?.contactSecondary?.country}" optionKey="key" optionValue="display"/>
              </td>
            </tr>
            <tr>
              <th colspan="4">&nbsp;</th>
            </tr>
            <tr>
              <td valign="top" class="name">
                <label for="contactPrimary.phoneType">Phone Type:</label>
              </td>
              <td valign="top" class="value ${hasErrors(bean: rentalTransaction, field: 'contactPrimary.phoneType', 'errors')}">
                  <g:select name="contactPrimary.phoneType" from="${storagetech.constants.PhoneType.list()}" value="${rentalTransaction?.contactPrimary?.phoneType}" optionValue="value"/>
              </td>
              <td valign="top" class="name">
                <label for="contactSecondary.phoneType">Phone Type:</label>
              </td>
              <td valign="top" class="value ${hasErrors(bean: rentalTransaction, field: 'contactSecondary.phoneType', 'errors')}">
                  <g:select name="contactSecondary.phoneType" from="${storagetech.constants.PhoneType.list()}" value="${rentalTransaction?.contactSecondary?.phoneType}" optionValue="value"/>
              </td>
            </tr>
            <tr>
              <td valign="top" class="name">
                <label for="contactPrimary.phone">Phone Number:</label>
              </td>
              <td valign="top" class="value ${hasErrors(bean: rentalTransaction, field: 'contactPrimary.phone', 'errors')}">
                  <g:textField name="contactPrimary.phone" value="${rentalTransaction?.contactPrimary?.phone}" />
              </td>
              <td valign="top" class="name">
                <label for="contactSecondary.phone">Phone Number:</label>
              </td>
              <td valign="top" class="value ${hasErrors(bean: rentalTransaction, field: 'contactSecondary.phone', 'errors')}">
                  <g:textField name="contactSecondary.phone" value="${rentalTransaction?.contactSecondary?.phone}" />
              </td>
            </tr>
            <tr>
              <td valign="top" class="name">
                <label for="contactPrimary.email">Email:</label>
              </td>
              <td valign="top" class="value ${hasErrors(bean: rentalTransaction, field: 'contactPrimary.email', 'errors')}">
                  <g:textField name="contactPrimary.email" value="${rentalTransaction?.contactPrimary?.email}" />
              </td>
              <td valign="top" class="name">
                <label for="contactSecondary.email">Email:</label>
              </td>
              <td valign="top" class="value ${hasErrors(bean: rentalTransaction, field: 'contactSecondary.email', 'errors')}">
                  <g:textField name="contactSecondary.email" value="${rentalTransaction?.contactSecondary?.email}" />
              </td>
            </tr>
            <tr>
              <th colspan="4">ID Information:</th>
            </tr>
            <tr>
              <td valign="top" class="name">
                <label for="idType">ID Type:</label>
              </td>
              <td valign="top" colspan="3" class="value ${hasErrors(bean: rentalTransaction, field: 'idType', 'errors')}">
                  <g:select id="idType" name="idType" from="${storagetech.constants.IdType.list()}" value="${rentalTransaction?.idType}" optionValue="value"/>
              </td>
            </tr>
            <tr>
              <td id="idStateLabel" valign="top" class="name">
                <label for="idState">ID State:</label>
              </td>
              <td id="idStateField" valign="top" colspan="3" class="value ${hasErrors(bean: rentalTransaction, field: 'idState', 'errors')}">
                  <g:select name="idState" from="${storagetech.constants.State.list()}" value="${rentalTransaction?.idState}" optionValue="value"/>
              </td>
            </tr>
            <tr>
              <td id="idCountryLabel" valign="top" class="name" style="display: none;">
                <label for="idCountry">ID Country:</label>
              </td>
              <td id="idCountryField" valign="top" colspan="3" class="value ${hasErrors(bean: rentalTransaction, field: 'idCountry', 'errors')}" style="display: none;">
                  <g:select name="idCountry" from="${storagetech.constants.Country.list()}" value="${rentalTransaction?.idCountry}" optionKey="key" optionValue="display"/>
              </td>
            </tr>
            <tr>
              <td valign="top" class="name">
                <label for="idNumber">ID Number:</label>
              </td>
              <td valign="top" colspan="3" class="value ${hasErrors(bean: rentalTransaction, field: 'idNumber', 'errors')}">
                  <g:textField name="idNumber" value="${rentalTransaction?.idNumber}" />
              </td>
            </tr>
            <tr>
              <th colspan="4">Rental Information:</th>
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
    <div style="height:30px;"></div>
    <g:render template="/footer" />
    <g:render template="/size_popup" />
    <script type="text/javascript" src="http://www.google.com/jsapi?autoload=%7B%22modules%22%3A%5B%7B%22name%22%3A%22maps%22%2C%22version%22%3A%223.x%22%2Cother_params%3A%22sensor%3Dfalse%22%2C%22callback%22%3A%22createMap%22%7D%2C%7B%22name%22%3A%22gdata%22%2C%22version%22%3A%222.x%22%2C%22packages%22%3A%5B%22maps%22%5D%7D%5D%7D&amp;key=ABQIAAAAEDNru_s_vCsZdWplqCj4hxSjGMYCLTKEQ0TzQvUUxxIh1qVrLhTUMUuVByc3xGunRlZ-4Jv6pHfFHA"></script>
  </body>
</html>