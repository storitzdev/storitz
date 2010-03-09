<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN"
    "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" >
  <head>
    <script src="http://www.google.com/jsapi" type="text/javascript"></script>
    <g:render template="/header" />

    <script type="text/javascript">
//<![CDATA[
    google.load("prototype", "1.6.1.0");
    google.load("scriptaculous", "1.8.3");

    var directionsService;
    var storageSize = [];

    <g:each var="size" in="${sizeList}">storageSize[${size.id}] = "${size.description}";</g:each>
    // searchSize = ${params.searchSize}
    <g:if test="${params.searchSize}">
      var sizeDescription = storageSize[ ${params.searchSize} ];
    </g:if>

    function setupSize() {
      if(typeof(sizeDescription) !== 'undefined')  {
        $('sizeDescription').replace(sizeDescription);
      }
    }

    var keypadImg = ${site.isKeypad} ? '<img src="${createLinkTo(dir:'images', file:'icon-keypad-green-20x20.gif')}" style="vertical-align: middle; margin: 1px;" alt="Keypad"/>' : '<span style="width:20px; margin:1px;"></span>';
    var cameraImg = ${site.isCamera} ? '<img src="${createLinkTo(dir:'images', file:'icon-camera-green-20x20.gif')}" style="vertical-align: middle; margin: 1px;" alt="Camera"/>' : '<span style="width:20px; margin: 1px;"></span>';
    var gateImg   = ${site.isGate} ? '<img src="${createLinkTo(dir:'images', file:'icon-gate-green-20x20.gif')}" style="vertical-align: middle; margin: 1px;" alt="Gate"/>' : '<span style="width:20px; margin: 1px;"></span>';
    var alarmImg  = ${site.isUnitAlarmed} ? '<img src="${createLinkTo(dir:'images', file:'icon-alarm-green-20x20.gif')}" style="vertical-align: middle; margin: 1px;" alt="Alarm"/>' : '<span style="width:20px; margin: 1px;"></span>';
    var truckImg  = ${site.isUnitAlarmed} ? '<img src="${createLinkTo(dir:'images', file:'icon-rentaltruck-green-20x20.gif')}" style="vertical-align: middle; margin: 1px;" alt="Rental Truck"/>' : '<span style="width:20px; margin: 1px;"></span>';

    function createMap() {
      directionsService = new google.maps.DirectionsService();
    }

    function setupHelp() {
      $('sizeInfo').observe('click', function(event) {
        $('sizeHelp').setStyle({ top: this.offsetTop - 10 + "px", left: this.offsetLeft + this.width + 10 + "px" });
        Effect.toggle('sizeHelp', 'appear', {duration: 0.8});
      });

    }

    FastInit.addOnLoad(setupSize, setupHelp);
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
          <g:if test="${params.searchSize}">
            <div>
              <div class="section_header">Available sizes:  (currently <span id="sizeDescription"></span>)</div>
              <g:select name="unitsize" from="${sizeList}" optionValue="description" value="${params.searchSize}" optionKey="id" />
              <img id="sizeInfo" style="vertical-align: middle;" src="${createLinkTo(dir:'images', file:'icn_info_circle.png')}" alt="info"/>
            </div>
          </g:if>
          <div style="padding-top: 10px;" class="section_header">
            Site Features:
          </div>
          <div class="other_details button_text_hi">
            Special Offers:
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
            <img src="http://maps.google.com/maps/api/staticmap?center=${site.lat},${site.lng}&zoom=15&size=400x320&maptype=roadmap&markers=color:blue|${site.lat},${site.lng}&sensor=false&key=ABQIAAAAEDNru_s_vCsZdWplqCj4hxSjGMYCLTKEQ0TzQvUUxxIh1qVrLhTUMUuVByc3xGunRlZ-4Jv6pHfFHA" alt="Map of ${site.title}"/>
          </div>
          <div id="detail_tabs">
            <div class="left tab_button button_text_hi">Photos</div><div class="right tab_spacer button_text">Get Directions</div>
            <div style="clear: both;"></div>
            <div id="photos">
            </div>
            <div id="directions" style="visibility:hidden">
              <input type="text" name="srcAddr" id="srcAddr"/><input type="button" name="getDirections" value="Get Directions"/>
              <div id="dirPanel"></div>
            </div>
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