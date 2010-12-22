<div class="left" style="margin-bottom: 10px;">
  <div id="site_logo">
    <g:if test="${site?.logo}">
      <img src="${resource(file:site.logo.src())}" width="250" height="100" alt="${site.title} Logo"/>
    </g:if>
  </div>
  <div id="site_address">
    <div class="title">
      ${site.title}
    </div>
    <div>
      ${site.address}
    </div>
    <div>
      ${site.address2}
    </div>
    <div>
      ${site.city}, ${site.state.display} ${site.zipcode}
    </div>
    <sec:ifAnyGranted roles="ROLE_CALLCENTER, ROLE_CALLCENTER_ADMIN">
      <div>
        Phone: ${site.phone}
      </div>
    </sec:ifAnyGranted>
  </div>
</div>
<div style="clear:both;"></div>
<div class="siteInfoText">
  <div id="operatingHours">
    <ul>
      <li><a href="#officeHours">Office</a></li>
      <li><a href="#gateHours">Gate</a></li>
    </ul>
    <div id="officeHours">
      <table class="operatingHours">
        <tr>
          <td class="tright" style="width:120px;">
            Mon:
          </td>
          <g:if test="${site.openMonday}">
            <td class="tright">
              <g:formatDate format="h:mma" date="${site.startMonday}"/>
            </td>
            <td>-</td>
            <td class="tright">
              <g:formatDate format="h:mma" date="${site.endMonday}"/>
            </td>
          </g:if>
          <g:else>
            <td colspan="3" style="text-align: center;">Closed</td>
          </g:else>
        </tr>
        <tr>
          <td class="tright" style="width:120px;">
            Tue:
          </td>
          <g:if test="${site.openTuesday}">
            <td class="tright">
              <g:formatDate format="h:mma" date="${site.startTuesday}"/>
            </td>
            <td>-</td>
            <td class="tright">
              <g:formatDate format="h:mma" date="${site.endTuesday}"/>
            </td>
          </g:if>
          <g:else>
            <td colspan="3" style="text-align: center;">Closed</td>
          </g:else>
        </tr>
        <tr>
          <td class="tright" style="width:120px;">
            Wed:
          </td>
          <g:if test="${site.openWednesday}">
            <td class="tright">
              <g:formatDate format="h:mma" date="${site.startWednesday}"/>
            </td>
            <td>-</td>
            <td class="tright">
              <g:formatDate format="h:mma" date="${site.endWednesday}"/>
            </td>
          </g:if>
          <g:else>
            <td colspan="3" style="text-align: center;">Closed</td>
          </g:else>
        </tr>
        <tr>
          <td class="tright" style="width:120px;">
            Thu:
          </td>
          <g:if test="${site.openThursday}">
            <td class="tright">
              <g:formatDate format="h:mma" date="${site.startThursday}"/>
            </td>
            <td>-</td>
            <td class="tright">
              <g:formatDate format="h:mma" date="${site.endThursday}"/>
            </td>
          </g:if>
          <g:else>
            <td colspan="3" style="text-align: center;">Closed</td>
          </g:else>
        </tr>
        <tr>
          <td class="tright" style="width:120px;">
            Fri:
          </td>
          <g:if test="${site.openFriday}">
            <td class="tright">
              <g:formatDate format="h:mma" date="${site.startFriday}"/>
            </td>
            <td>-</td>
            <td class="tright">
              <g:formatDate format="h:mma" date="${site.endFriday}"/>
            </td>
          </g:if>
          <g:else>
            <td colspan="3" style="text-align: center;">Closed</td>
          </g:else>
        </tr>
        <tr>
          <td class="tright" style="width:120px;">
            Sat:
          </td>
          <g:if test="${site.openSaturday}">
            <td class="tright">
              <g:formatDate format="h:mma" date="${site.startSaturday}"/>
            </td>
            <td>-</td>
            <td class="tright">
              <g:formatDate format="h:mma" date="${site.endSaturday}"/>
            </td>
          </g:if>
          <g:else>
            <td colspan="3" style="text-align: center;">Closed</td>
          </g:else>
        </tr>
        <tr>
          <td class="tright" style="width:120px;">
            Sun:
          </td>
          <g:if test="${site.openSunday}">
            <td class="tright">
              <g:formatDate format="h:mma" date="${site.startSunday}"/>
            </td>
            <td>-</td>
            <td class="tright">
              <g:formatDate format="h:mma" date="${site.endSunday}"/>
            </td>
          </g:if>
          <g:else>
            <td colspan="3" style="text-align: center;">Closed</td>
          </g:else>
        </tr>
      </table>
    </div>
    <div id="gateHours">
      <table class="operatingHours">
        <tr>
          <td class="tright" style="width:120px;">
            Mon:
          </td>
          <td>
            <g:formatDate format="h:mma" date="${site.startMondayGate}"/>
          </td>
          <td>-</td>
          <td class="tright">
            <g:formatDate format="h:mma" date="${site.endMondayGate}"/>
          </td>
        </tr>
        <tr>
          <td class="tright" style="width:120px;">
            Tue:
          </td>
          <td>
            <g:formatDate format="h:mma" date="${site.startTuesdayGate}"/>
          </td>
          <td>-</td>
          <td class="tright">
            <g:formatDate format="h:mma" date="${site.endTuesdayGate}"/>
          </td>
        </tr>
        <tr>
          <td class="tright" style="width:120px;">
            Wed:
          </td>
          <td>
            <g:formatDate format="h:mma" date="${site.startWednesdayGate}"/>
          </td>
          <td>-</td>
          <td class="tright">
            <g:formatDate format="h:mma" date="${site.endWednesdayGate}"/>
          </td>
        </tr>
        <tr>
          <td class="tright" style="width:120px;">
            Thu:
          </td>
          <td>
            <g:formatDate format="h:mma" date="${site.startThursdayGate}"/>
          </td>
          <td>-</td>
          <td class="tright">
            <g:formatDate format="h:mma" date="${site.endThursdayGate}"/>
          </td>
        </tr>
        <tr>
          <td class="tright" style="width:120px;">
            Fri:
          </td>
          <td>
            <g:formatDate format="h:mma" date="${site.startFridayGate}"/>
          </td>
          <td>-</td>
          <td class="tright">
            <g:formatDate format="h:mma" date="${site.endFridayGate}"/>
          </td>
        </tr>
        <tr>
          <td class="tright" style="width:120px;">
            Sat:
          </td>
          <td>
            <g:formatDate format="h:mma" date="${site.startSaturdayGate}"/>
          </td>
          <td>-</td>
          <td class="tright">
            <g:formatDate format="h:mma" date="${site.endSaturdayGate}"/>
          </td>
        </tr>
        <tr>
          <td class="tright" style="width:120px;">
            Sun:
          </td>
          <td>
            <g:formatDate format="h:mma" date="${site.startSundayGate}"/>
          </td>
          <td>-</td>
          <td class="tright">
            <g:formatDate format="h:mma" date="${site.endSundayGate}"/>
          </td>
        </tr>
      </table>
    </div>
  </div>
  <g:if test="${site.extendedHours}">
    <div class="siteInfoText" style="margin-top:6px;">
      Extended Hours Available
    </div>
  </g:if>
</div>
<div style="padding: 18px 0 10px;" class="section_header">
  Site Features:
</div>

<g:if test="${site.freeTruck  == storitz.constants.TruckType.FREE}">
  <div class="left">
    <storitz:image src="icon3d-rentaltruck32f.gif" width="32" height="32" alt="Free Truck"/>
  </div>
  <div class="left icon_text">Free Truck</div>
  <div style="clear: both;"></div>
</g:if>
<g:if test="${site.freeTruck  == storitz.constants.TruckType.RENTAL}">
  <div class="left">
    <storitz:image src="icon3d-rentaltruck32r.gif" width="32" height="32" alt="Rental Truck"/>
  </div>
  <div class="left icon_text">Rental Truck</div>
  <div style="clear: both;"></div>
</g:if>
<g:if test="${site.isGate}">
  <div class="left">
    <storitz:image src="icon3d-gate32.jpg" width="32" height="32" alt="Gated"/>
  </div>
  <div class="left icon_text">Gated</div>
  <div style="clear: both;"></div>
</g:if>
<g:if test="${site.isKeypad}">
  <div class="left">
    <storitz:image src="icon3d-keypad32.jpg" width="32" height="32" alt="Keypad"/>
  </div>
  <div class="left icon_text">Keypad Entry</div>
  <div style="clear: both;"></div>
</g:if>
<g:if test="${site.isCamera}">
  <div class="left">
    <storitz:image src="icon3d-camera32.jpg" width="32" height="32" alt="Camera"/>
  </div>
  <div class="left icon_text">Camera</div>
  <div style="clear: both;"></div>
</g:if>
<g:if test="${site.isUnitAlarmed}">
  <div class="left">
    <storitz:image src="icon3d-alarm32.jpg" width="32" height="32" alt="Alarmed"/>
  </div>
  <div class="left icon_text">Unit Alarmed</div>
  <div style="clear: both;"></div>
</g:if>
<g:if test="${site.isManagerOnsite}">
  <div class="left">
    <storitz:image src="icon3d-mgr32b.jpg" width="32" height="32" alt="Manager Onsite"/>
  </div>
  <div class="left icon_text">Manager Onsite</div>
  <div style="clear: both;"></div>
</g:if>
<g:if test="${site.hasElevator}">
  <div class="left">
    <storitz:image src="icon3d-elevator32.jpg" width="32" height="32" alt="Elevator Available"/>
  </div>
  <div class="left icon_text">Elevator Available</div>
  <div style="clear: both;"></div>
</g:if>
<g:if test="${video}">
  <div class="leftSection">
    <div class="leftSectionHeader">
      Video
    </div>
    <div class="videoContainer">
      <div id="videoContainer"></div>
    </div>
    <p:dependantJavascript>
    <script type="text/javascript">
        jwplayer("videoContainer").setup({
            flashplayer: "${resource(file:'/jwplayer/player.swf')}",
            file: "${resource(file:video.fileLocation)}",
            image: "${resource(file:video.stillImage)}",
            height: 160,
            width: 282
        });
    </script>
    </p:dependantJavascript>
  </div>
</g:if>
