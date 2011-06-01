<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head><title>Self Storage Prices &amp; Special Offers Near ${aMetro.city}, ${aMetro.stateCode}</title></head>

<body class="serp">
<h1>Self Storage Prices &amp; Special Offers Near ${aMetro.city}, ${aMetro.stateCode}</h1>
<g:form>
    <div id="topbox">
        <div id="maplet"></div>

        <div id="size_picker"></div>

        <div id="amenities"></div>
    </div>
</g:form>
<p class="summary">
    We Found Prices &amp; Availability for ${clientSites.size()} Facilities
    <a class="button small black" href="#map-view" id="toggle_map_view">Map View</a>
</p>
<g:if test="${clientSites.size() > 0}">
    <div id="big_map_canvas"></div>
    <ul id="search_result_labels">
        <li class="photo">&nbsp;</li>
        <li class="facility">Facility</li>
        <li class="unit_info">Unit Type</li>
        <li class="special">Special</li>
        <li class="price">Price</li>
        <li class="rent_button"></li>
    </ul>
    <ul id="search_results">
        <g:each var="site" in="${clientSites}" status="c">
            <li class="line" id="site_${site.id}">
                <g:render template="/clientSite" model="['site':site, 'unitInfo':siteMoveInPrice[site.id]]"/>
            </li>
        </g:each>
    </ul>

    <div id="map_popup" class="tooltip">
        <a class="close button small black">close</a>

        <p><!-- 1234 Main St. --></p>

        <div id="maplet_canvas" style="width:320px; height:320px"></div>
    </div>
</g:if>
</body>
</html>