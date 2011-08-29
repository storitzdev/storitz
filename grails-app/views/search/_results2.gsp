<div id="results_container" class="panel results_container">
    <h2>
        ${clientSites.size()} Locations Found
    </h2>
    <g:if test="${clientSites.size() > 0}">
        <ul id="search_results">
            <g:each var="site" in="${clientSites}" status="c">
                <g:if test="${yelpReviews[c]}">
                    <li id="site_${site.id}" revCount="${yelpReviews[c].reviewCount}" revStar="${yelpReviews[c].starUrl}">
                </g:if>
                <g:else>
                    <li id="site_${site.id}">
                </g:else>
                    <g:render template="/clientSite" model="['site':site, 'unitInfo':siteMoveInPrice[site.id]]"/>
                </li>
            </g:each>
            <li id="site_1732" class="sponsored">
                <g:render template="sponsoredSite" model="['site':sponsored_site]" />
            </li>
        </ul>
        <div class="map_container"><div id="big_map_canvas"></div></div>

    </g:if>
</div>
<div id="popup_map" class="tooltip">
    <a class="close button small black">close</a>
    <p><!-- 1234 Main St. --></p>
    <div id="popup_map_canvas" style="width:320px; height:320px"></div>
</div>
<div id="spinner" class="spinner">
    <div class="message">
        <p>Searching...</p>
    </div>
</div>
<!--[if IE]>
<div id="ieSerpFix"></div>
<![endif]-->