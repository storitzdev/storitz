<div class="right" style="display:none;margin: -30px 10px 0 0;" id="printThisTop">
  <a href="#" onclick="window.print();
  return false;">print</a>
</div>
<div id="directionMap">
  <div id="directionMapCanvas"></div>
</div>
<div class="dirInstructions">
  <h2>Driving Directions</h2> Enter your start address below
</div>
<div class="left">
  <div style="width:330px;" class="checkout_value">
    <g:textField id="srcAddr" name="srcAddr" placeholder="Enter city, address, or zip"/>
  </div>
  <div style="clear:both;"></div>
</div>
<div style="margin-top:-2px;" class="left">
  <p:inputImage src="btn-find-it.png" style="width:108px;height:34px;border:none;" name="getDirections" value="Get Directions"/>
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
</div>
%{--<div id="directionMapDestination" style="display:none;">--}%
  %{--<div id="directionMapDestinationCanvas"></div>--}%
%{--</div>--}%
<div id="printThis" class="right" style="display:none; margin: 10px;">
  <a href="#" onclick="window.print();
  return false;">print</a>
</div>