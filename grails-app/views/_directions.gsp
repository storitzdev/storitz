<div class="right" style="display:none;margin: -30px 10px 0 0;" id="printThisTop">
  <a href="#" onclick="window.print();
  return false;">print</a>
</div>
<div id="directionMap">
  <div id="directionMapCanvas"></div>
  <div id="facilityHours" class="right">
      <h2>${site.title}</h2>
      <div>${site.address}<br />${site.city} ${site.state.display}<br />${site.zipcode}</div>
      <h2>Hours of Operation</h2>
      <g:render template="/siteHours" />
  </div>
</div>
<div class="dirInstructions">
  <h2>Driving Directions</h2> Enter your start address below
</div>
<div class="ieDivContainer">
    <div class="left ieLeft">
        <div style="width:294px; margin-bottom: 10px" class="checkout_value">
            <g:textField id="srcAddr" name="srcAddr" placeholder="Enter city, address, or zip"/>
        </div>
        %{--<div style="clear:both;"></div>--}%
    </div>
    <div style="margin-top:-2px;" class="left ieLeft">
        <p:inputImage src="get-directions-form-button.png" style="width:132px;height:32px;border:none;padding:2px 0 0 4px;" name="getDirections" value="Get Directions"/>
    </div>
</div>
<div style="clear:both;"></div>
<div id="dirPanel" style="display:none;">
  <div class="specialOfferText" id="directionsDistance" style="margin: 15px 0;"></div>
  <div id="directionsWarnings" class="directionsWarnings"></div>
  <div class="transBox">
    <div class="left" style="margin:5px 15px;">
      <storitz:image src="icn_map_blue.png" width="27" height="35" alt="Start"/>
    </div>
    <div id="directionsStartAddr" class="left directionsAddress" style="margin: 14px 0;"></div>
    <div style="clear:both;"></div>
  </div>
  <table id="directionsSteps" style="width:648px; margin: 15px 10px 15px 0;">
  </table>
  <div class="transBox">
    <div class="left" style="margin:5px 15px;">
      <storitz:image src="icn_map_grn.png" width="27" height="35" alt="End"/>
    </div>
    <div id="directionsEndAddr" class="left directionsAddress" style="margin: 14px 0;"></div>
    <div style="clear:both;"></div>
  </div>
    <div id="directionsCopyrights" class="directionsCopyrights"></div>
  <div class="ieDivContainer">
    <div id="printThis">
        <a href="#" onclick="window.print();
        return false;">print</a>
    </div>
    <div id="shareThis">
        <g:link controller="storageSite" action="directions" id="${params.id}" params="[origin:'los angeles, ca']">Share</g:link>
    </div>
  </div>
</div>
<p:dependantJavascript>
    <script>
    $("#getDirections").click(function () {
        _direction.calculate();
        $("#dirPanel").css("display", "block");
    });
    $("#shareThis").hide();
    </script>
</p:dependantJavascript>