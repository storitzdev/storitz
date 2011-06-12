<g:form>
    <div class="panel" id="pickers">
        <div>
            <h2>
              Map
              <a href="_results.gsp#map-view" class="toggle_map_view" id="map_toggle_link">Show big map!</a>
            </h2>
            <div id="mini_map_canvas"></div>
        </div>
        <div>
            <h2>Unit size</h2>
            <ul>
                <li><input type="radio" name="size" value="5x5" id="size_5x5"/><label for="size_5x5">5 x 5</label></li>
                <li><input type="radio" name="size" value="5x5" id="size_5x10"/><label for="size_5x10">5 x 10</label></li>
                <li><input type="radio" name="size" value="5x5" id="size_10x10"/><label for="size_10x10">10 x 10</label></li>
                <li><input type="radio" name="size" value="5x5" id="size_10x15" /><label for="size_10x15">10 x 15</label></li>
                <li><input type="radio" name="size" value="5x5" id="size_10x20"/><label for="size_10x20">10 x 20</label></li>
                <li><input type="radio" name="size" value="5x5" id="size_10x30"/><label for="size_10x30">10 x 30</label></li>
                <li><input type="radio" name="size" value="all" id="size_all"/><label for="size_all">See All</label></li>
            </ul>
        </div>
        <div>
            <h2>Unit type</h2>
            <ul>
                <li><input type="radio" name="type" value="interior" id="type_interior"/><label for="type_interior">Interior</label></li>
                <li><input type="radio" name="type" value="upper" id="type_upper"/><label for="type_upper">Upper</label></li>
                <li><input type="radio" name="type" value="driveup" id="type_driveup"/><label for="type_driveup">Drive-Up</label></li>
                <li><input type="radio" name="type" value="all" id="type_all"/><label for="type_all">See All</label></li>
            </ul>
        </div>
        <div>
            <h2>Amenities</h2>
            <ul>
                <li><input type="checkbox" name="amenity" value="cc" id="amenity_cc"/><label for="amenity_cc">Climate Control</label></li>
                <li><input type="checkbox" name="amenity" value="24hr" id="amenity_24hr"/><label for="amenity_24hr">24-hour Access</label></li>
                <li><input type="checkbox" name="amenity" value="alarm" id="amenity_alarm"/><label for="amenity_alarm">In-Unit Alarm</label></li>
            </ul>
        </div>
    </div>
</g:form>
<div class="panel results_container">
    <h2>
        ${clientSites.size()} Locations Found
    </h2>
    <g:if test="${clientSites.size() > 0}">
        <div id="big_map_canvas"></div>
        <ul id="search_results">
            <g:each var="site" in="${clientSites}" status="c">
                <li id="site_${site.id}">
                    <g:render template="/clientSite" model="['site':site, 'unitInfo':siteMoveInPrice[site.id]]"/>
                </li>
            </g:each>
        </ul>

    </g:if>
</div>
<div id="popup_map" class="tooltip">
    <a class="close button small black">close</a>
    <p><!-- 1234 Main St. --></p>
    <div id="popup_map_canvas" style="width:320px; height:320px"></div>
</div>