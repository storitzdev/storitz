<div id="site_logopic">
    <g:if test="${site?.logo}">
        <img src="${resource(file: site.logo.src())}" width="250" height="100" alt="${site.title} Logo"/>
    </g:if>
</div>
<div id="site_address">
    <h1 class="title">${site.title}</h1>
    ${site.address}
    ${site.address2}
    ${site.city}, ${site.state.display} ${site.zipcode}
    (877) 456-2929
    <sec:ifAnyGranted roles="ROLE_CALLCENTER, ROLE_CALLCENTER_ADMIN">
        Direct Phone: ${site.phone}
    </sec:ifAnyGranted>
</div>

<div class="site_features">
    <g:if test="${site.freeTruck  == storitz.constants.TruckType.FREE}">
        <storitz:image src="icon3d-rentaltruck32f.gif" alt="Free Truck"/>
    </g:if>
    <g:if test="${site.freeTruck  == storitz.constants.TruckType.RENTAL}">
        <storitz:image src="icon3d-rentaltruck32r.gif" alt="Rental Truck"/>
    </g:if>
    <g:if test="${site.isGate}">
        <storitz:image src="icon3d-gate32.jpg" alt="Gated"/>
    </g:if>
    <g:if test="${site.isKeypad}">
        <storitz:image src="icon3d-keypad32.jpg" alt="Keypad"/>
    </g:if>
    <g:if test="${site.isCamera}">
        <storitz:image src="icon3d-camera32.jpg" alt="Camera"/>
    </g:if>
    <g:if test="${site.isUnitAlarmed}">
        <storitz:image src="icon3d-alarm32.jpg" alt="Alarmed"/>
    </g:if>
    <g:if test="${site.isManagerOnsite}">
        <storitz:image src="icon3d-mgr32b.jpg" alt="Manager Onsite"/>
    </g:if>
    <g:if test="${site.hasElevator}">
        <storitz:image src="icon3d-elevator32.jpg" alt="Elevator Available"/>
    </g:if>
</div>
