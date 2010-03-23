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
    var prices = [];
    var searchSize;
    var unitId = ${params.id};
    var additionalFees = ${site.adminFee ? site.adminFee : 0} + ${site.lockFee ? site.lockFee : 0};
    var destLatLng;

    var priceDriveup = ${params.priceDriveup ? "true" : "false"};
    var priceInterior = ${params.priceInterior ? "true" : "false"};
    var priceUpper = ${params.priceUpper ? "true" : "false"};
    var priceTempControlled = ${params.priceTempControlled ? "true" : "false"};

    <g:each var="size" in="${sizeList}">storageSize[${size.id}] = "${size.description}";</g:each>
    <g:if test="${params.searchSize}">
      searchSize = ${params.searchSize};
      var sizeDescription = storageSize[ ${params.searchSize} ];
    </g:if>

    function setupSize() {
      if(typeof(sizeDescription) !== 'undefined')  {
        $('sizeDescription').replace(sizeDescription);
      }
    }

    <g:if test="${site.isKeypad}">
      var keypadImg = '<img src="${createLinkTo(dir:'images', file:'icon-keypad-green-20x20.gif')}" style="vertical-align: middle; margin: 1px;" alt="Keypad"/>';
    </g:if>
    <g:else >
      var keypadImg = '<span style="width:20px; margin:1px;"></span>';
    </g:else>
    <g:if test="${site.isCamera}">
      var cameraImg = '<img src="${createLinkTo(dir:'images', file:'icon-camera-green-20x20.gif')}" style="vertical-align: middle; margin: 1px;" alt="Camera"/>';
    </g:if>
    <g:else>
      var cameraImg = '<span style="width:20px; margin: 1px;"></span>';
    </g:else>
    <g:if test="${site.isGate}">
      var gateImg   = '<img src="${createLinkTo(dir:'images', file:'icon-gate-green-20x20.gif')}" style="vertical-align: middle; margin: 1px;" alt="Gate"/>';
    </g:if>
    <g:else>
      var gateImg   =  '<span style="width:20px; margin: 1px;"></span>';
    </g:else>
    <g:if test="${site.isUnitAlarmed}">
      var alarmImg  = '<img src="${createLinkTo(dir:'images', file:'icon-alarm-green-20x20.gif')}" style="vertical-align: middle; margin: 1px;" alt="Alarm"/>';
    </g:if>
    <g:else>
      var alarmImg  = '<span style="width:20px; margin: 1px;"></span>';
    </g:else>
    <g:if test="${site.freeTruck}">
      var truckImg  = '<img src="${createLinkTo(dir:'images', file:'icon-rentaltruck-green-20x20.gif')}" style="vertical-align: middle; margin: 1px;" alt="Rental Truck"/>';
    </g:if>
    <g:else>
      var truckImg  = '<span style="width:20px; margin: 1px;"></span>';
    </g:else>

    function buildTable() {
      new Ajax.Request("${createLink(controller:'storageSite', action:'detailUnits')}",
      {
        method:'get',
        parameters: {searchSize: searchSize, id: unitId},
        onSuccess:function(transport) {
          var tableBody = "<table>"
          var units = transport.responseJSON.units;
          var rowCount = 0;
          if (units) {
            if (units.driveup) {
              tableBody += "<tr class=" + (rowCount++ % 2 == 0 ? "roweven" : "rowodd") + ">";
              tableBody += "<td style=\"padding-left:20px;\"><input type=\"radio\" name=\"unit_choice\" value=\"" + units.driveup.id + "\"" + (priceDriveup ? " checked=\"true\"" : "") + "/> Drive up</td><td class=\"price_text\"><span class=\"price_text\">$" + units.driveup.price + "</span></td>";
              tableBody += "</tr>";
              prices[units.driveup.id] = units.driveup.price;
              if (priceDriveup) {
                $('price_total').update("Price: $" + (additionalFees + units.driveup.price));
              }
            }
            if (units.interior) {
              tableBody += "<tr class=" + (rowCount++ % 2 == 0 ? "roweven" : "rowodd") + ">";
              tableBody += "<td style=\"padding-left:20px;\"><input type=\"radio\" name=\"unit_choice\" value=\"" + units.interior.id + "\"" + (priceInterior ? " checked=\"true\"" : "") + "/> Interior</td><td class=\"price_text\"><span class=\"price_text\">$" + units.interior.price + "</span></td>";
              tableBody += "</tr>";
              prices[units.interior.id] = units.interior.price;
              if (priceInterior) {
                $('price_total').update("Price: $" + (additionalFees + units.interior.price));
              }
            }
            if (units.upper) {
              tableBody += "<tr class=" + (rowCount++ % 2 == 0 ? "roweven" : "rowodd") + ">";
              tableBody += "<td style=\"padding-left:20px;\"><input type=\"radio\" name=\"unit_choice\" value=\"" + units.upper.id + "\"" + (priceUpper ? " checked=\"true\"" : "") + "/> Upper</td><td class=\"price_text\"><span class=\"price_text\">$" + units.upper.price + "</span></td>";
              tableBody += "</tr>";
              prices[units.upper.id] = units.upper.price;
              if (priceUpper) {
                $('price_total').update("Price: $" + (additionalFees + units.upper.price));
              }
            }
            if (units.tempcontrolled) {
              tableBody += "<tr class=" + (rowCount++ % 2 == 0 ? "roweven" : "rowodd") + ">";
              tableBody += "<td style=\"padding-left:20px;\"><input type=\"radio\" name=\"unit_choice\" value=\"" + units.tempcontrolled.id + "\"" + (priceTempControlled ? " checked=\"true\"" : "") + "/> A/C</td><td class=\"price_text\"><span class=\"price_text\">$" + units.tempcontrolled.price + "</span></td>";
              tableBody += "</tr>";
              prices[units.tempcontrolled.id] = units.tempcontrolled.price;
              if (priceTempControlled) {
                $('price_total').update("Price: $" + (additionalFees + units.tempcontrolled.price));
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
        $('price_total').update("Price: $" + (prices[unitId] + additionalFees));
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
          <g:if test="${site.freeTruck}">
            <div class="icon_text">
              <img src="${createLinkTo(dir:'images', file:'icon-rentaltruck32.gif')}" alt="Rental Truck"/> Rental Truck
            </div>
          </g:if>
          <g:if test="${site.isGate}">
            <div class="icon_text">
              <img src="${createLinkTo(dir:'images', file:'icon-gate32.gif')}" alt="Gated"/> Gated
            </div>
          </g:if>
          <g:if test="${site.isKeypad}">
            <div class="icon_text">
              <img src="${createLinkTo(dir:'images', file:'icon-keypad32.gif')}" alt="Keypad"/> Keypad Entry
            </div>
          </g:if>
          <g:if test="${site.isCamera}">
            <div class="icon_text">
              <img src="${createLinkTo(dir:'images', file:'icon-camera32.gif')}" alt="Camera"/> Camera
            </div>
          </g:if>
          <g:if test="${site.isUnitAlarmed}">
            <div class="icon_text">
              <img src="${createLinkTo(dir:'images', file:'icon-alarm32.gif')}" alt="Alarmed"/> Unit Alarmed
            </div>
          </g:if>
          <div style="height:10px;"></div>
          <div class="other_details header_text_hi">
            Special Offers:
          </div>
          <div class="icon_text">
            <ul>
              <g:each var="offer" in="${site.specialOffers}">
                <li>${offer.description}</li>
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
          <div style="float: right;">
            <span id="price_total"></span><img src="${createLinkTo(dir:'images', file:'btn-rentme-106x34.gif')}" alt="Rent Me"/>
          </div>
        </div>
        <div style="clear: both;"/>
      </div>
    </div>
    <div style="height:30px;"></div>
    <g:render template="/footer" />
    <g:render template="/size_popup" />
    <script type="text/javascript" src="http://www.google.com/jsapi?autoload=%7B%22modules%22%3A%5B%7B%22name%22%3A%22maps%22%2C%22version%22%3A%223.x%22%2Cother_params%3A%22sensor%3Dfalse%22%2C%22callback%22%3A%22createMap%22%7D%2C%7B%22name%22%3A%22gdata%22%2C%22version%22%3A%222.x%22%2C%22packages%22%3A%5B%22maps%22%5D%7D%5D%7D&amp;key=ABQIAAAAEDNru_s_vCsZdWplqCj4hxSjGMYCLTKEQ0TzQvUUxxIh1qVrLhTUMUuVByc3xGunRlZ-4Jv6pHfFHA"></script>
  </body>
</html>