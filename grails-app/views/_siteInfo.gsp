<div class="left" style="margin-bottom: 10px;">
  <div id="site_logo">
    <g:if test="${site?.logo}">
      <img src="${resource(file:site.logo.src())}" alt="${site.title} Logo"/>
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
      ${site.city}, ${site.state} ${site.zipcode}
    </div>
  </div>
</div>
<div style="clear:both;"></div>
<div class="siteInfoText">
  Weekdays:
  <g:if test="${site.openWeekday}">
    <g:formatDate format="h:mma" date="${site.startWeekday}"/> - <g:formatDate format="h:mma" date="${site.endWeekday}"/>
  </g:if>
  <g:else>Closed</g:else>
</div>
<div class="siteInfoText">
  Saturday:
  <g:if test="${site.openSaturday}">
    <g:formatDate format="h:mma" date="${site.startSaturday}"/> - <g:formatDate format="h:mma" date="${site.endSaturday}"/>
  </g:if>
  <g:else>Closed</g:else>
</div>
<div class="siteInfoText">
  Sunday:
  <g:if test="${site.openSunday}">
    <g:formatDate format="h:mma" date="${site.startSunday}"/> - <g:formatDate format="h:mma" date="${site.endSunday}"/>
  </g:if>
  <g:else>Closed</g:else>
</div>
<div class="siteInfoText">
  Gate Weekdays:
  <g:formatDate format="h:mma" date="${site.startGate}"/> - <g:formatDate format="h:mma" date="${site.endGate}"/>
</div>
<div class="siteInfoText">
  Gate Sunday:
  <g:formatDate format="h:mma" date="${site.startSundayGate}"/> - <g:formatDate format="h:mma" date="${site.endSundayGate}"/>
</div>
<div class="siteInfoText">
  <g:if test="${site.extendedHours}">
    Extended Hours Available
  </g:if>
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
<g:if test="${site.isManagerOnsite}">
  <div class="left">
    <img src="${createLinkTo(dir:'images', file:'icon3d-mgr32b.jpg')}" alt="Manager Onsite"/>
  </div>
  <div class="left icon_text">Manager Onsite</div>
  <div style="clear: both;"></div>
</g:if>
<g:if test="${site.hasElevator}">
  <div class="left">
    <img src="${createLinkTo(dir:'images', file:'icon3d-elevator32.jpg')}" alt="Elevator Available"/>
  </div>
  <div class="left icon_text">Elevator Available</div>
  <div style="clear: both;"></div>
</g:if>
