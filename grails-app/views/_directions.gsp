  <div class="right" style="display:none;margin: -30px 10px 0 0;" id="printThisTop">
    <a href="#" onclick="window.print(); return false;">print</a>
  </div>
  <div style="height: 10px;"></div>
  <div id="directionMap">
    <div id="directionMapCanvas"></div>
  </div>
  <div class="price_options checkout_header white">
    Driving Directions
  </div>
  <div class="formInstructions">
    Enter your starting address to get driving directions to this facility.
  </div>
  <div class="left checkout_fields">
    <div style="width:350px;" class="checkout_value">
      <g:textField id="srcAddr" name="srcAddr" style="width: 330px;" />
    </div>
    <div style="clear:both;"></div>
  </div>
  <div style="margin-top:0;" class="left">
    <p:inputImage src="btn-find-it.png" style="width:108px;border:none;" name="getDirections" value="Get Directions"/>
  </div>
  <div class="checkout_labels">
    <div class="checkout_name" style="width:400px; margin-top: -10px;">
      <label for="srcAddr">Enter start address</label>
    </div>
    <div style="clear:both;"></div>
  </div>
  <div style="clear:both;"></div>
  <div id="dirPanel" style="display:none;">
    <div class="specialOfferText" id="directionsDistance" style="margin: 6px 0;"></div>
    <div id="directionsWarnings" class="directionsWarnings"></div>
    <div class="transBox">
      <div class="left" style="margin:5px 15px;">
        <p:image src="icn_map_blue.png" alt="Start" />
      </div>
      <div id="directionsStartAddr" class="left directionsAddress" style="margin: 14px 0;"></div>
      <div style="clear:both;"></div>
    </div>
    <table id="directionsSteps" style="width:650px; margin: 15px 10px 15px 0;">
    </table>
    <div class="transBox">
      <div class="left" style="margin:5px 15px;">
        <p:image src="icn_map_grn.png" alt="End" />
      </div>
      <div id="directionsEndAddr" class="left directionsAddress" style="margin: 14px 0;"></div>
      <div style="clear:both;"></div>
    </div>
    <div id="directionsCopyrights" class="directionsCopyrights"></div>
  </div>
  <div id="directionMapDestination" style="display:none;">
    <div id="directionMapDestinationCanvas"></div>
  </div>
  <div id="printThis" class="right" style="display:none; margin: 10px;">
    <a href="#" onclick="window.print(); return false;">print</a>
  </div>