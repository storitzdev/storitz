<div class="panel" id="pickers">
    <div>
        <h2>
            Map
            <a href="_results.gsp#map-view" class="toggle_map_view" id="map_toggle_link">Show big map!</a>
        </h2>
        <div id="mini_map_canvas"></div>
    </div>
    <div>
        <g:if test="${params.searchType == 'PARKING'}"> <h2>Parking size</h2> </g:if>
        <g:else> <h2>Unit Size</h2> </g:else>
        <ul>
            <g:if test="${params.searchType == 'PARKING'}">
            <li><input class="formpicker" type="radio" name="parking_size" value="10x10" id="psize_10x10" <g:if test="${unitSize == '5x5'}">checked="checked"</g:if> /><label for="size_5x5">10 x 10</label></li>
            <li><input class="formpicker" type="radio" name="parking_size" value="10x15" id="psize_10x15" <g:if test="${unitSize == '5x10'}">checked="checked"</g:if> /><label for="size_5x10">10 x 15</label></li>
            <li><input class="formpicker" type="radio" name="parking_size" value="" id="parking_size_all" <g:if test="${!unitSize}">checked="checked"</g:if> /><label for="size_all">Any</label></li>
            </g:if>
            <g:else>
            <li><input class="formpicker" type="radio" name="unit_size" value="5x5" id="size_5x5" <g:if test="${unitSize == '5x5'}">checked="checked"</g:if> /><label for="size_5x5">5 x 5</label></li>
            <li><input class="formpicker" type="radio" name="unit_size" value="5x10" id="size_5x10" <g:if test="${unitSize == '5x10'}">checked="checked"</g:if> /><label for="size_5x10">5 x 10</label></li>
            <li><input class="formpicker" type="radio" name="unit_size" value="10x10" id="size_10x10" <g:if test="${unitSize == '10x10'}">checked="checked"</g:if> /><label for="size_10x10">10 x 10</label></li>
            <li><input class="formpicker" type="radio" name="unit_size" value="10x15" id="size_10x15" <g:if test="${unitSize == '10x15'}">checked="checked"</g:if> /><label for="size_10x15">10 x 15</label></li>
            <li><input class="formpicker" type="radio" name="unit_size" value="10x20" id="size_10x20" <g:if test="${unitSize == '10x20'}">checked="checked"</g:if> /><label for="size_10x20">10 x 20</label></li>
            <li><input class="formpicker" type="radio" name="unit_size" value="10x30" id="size_10x30" <g:if test="${unitSize == '10x30'}">checked="checked"</g:if> /><label for="size_10x30">10 x 30</label></li>
            <li><input class="formpicker" type="radio" name="unit_size" value="" id="size_all" <g:if test="${!unitSize}">checked="checked"</g:if> /><label for="size_all">Any</label></li>
            </g:else>
        </ul>
    </div>
    <div>
        <g:if test="${params.searchType == 'PARKING'}"> <h2>Parking type</h2> </g:if>
        <g:else> <h2>Unit type</h2> </g:else>
        <ul>
            <g:if test="${params.searchType == 'PARKING'}">
            <li><input class="formpicker" type="radio" name="parking_type" value="covered" id="type_covered" <g:if test="${unitType == 'covered'}">checked="checked"</g:if> /><label for="type_covered">Covered</label></li>
            <li><input class="formpicker" type="radio" name="parking_type" value="uncovered" id="type_uncovered" <g:if test="${unitType == 'uncovered'}">checked="checked"</g:if> /><label for="type_uncovered">Uncovered</label></li>
            <li><input class="formpicker" type="radio" name="parking_type" value="" id="parking_type_all" <g:if test="${!unitType}">checked="checked"</g:if> /><label for="type_all">Any</label></li>
            </g:if>
            <g:else>
            <li><input class="formpicker" type="radio" name="unit_type" value="interior" id="type_interior" <g:if test="${unitType == 'interior'}">checked="checked"</g:if> /><label for="type_interior">Interior</label></li>
            <li><input class="formpicker" type="radio" name="unit_type" value="upper" id="type_upper" <g:if test="${unitType == 'upper'}">checked="checked"</g:if> /><label for="type_upper">Upper</label></li>
            <li><input class="formpicker" type="radio" name="unit_type" value="drive-up" id="type_driveup" <g:if test="${unitType == 'drive-up'}">checked="checked"</g:if> /><label for="type_driveup">Drive-Up</label></li>
            <li><input class="formpicker" type="radio" name="unit_type" value="" id="type_all" <g:if test="${!unitType}">checked="checked"</g:if> /><label for="type_all">Any</label></li>
            </g:else>
        </ul>
    </div>
    <g:if test="${params.searchType != 'PARKING'}">
    <div>
        <h2>Amenities</h2>
        <ul>
            <li><input class="formpicker" type="checkbox" name="amenity" value="cc" id="amenity_cc" <g:if test="${amenities && amenities['cc']}">checked="checked"</g:if> /><label for="amenity_cc">Climate Control</label></li>
            <li><input class="formpicker" type="checkbox" name="amenity" value="alarm" id="amenity_alarm" <g:if test="${amenities && amenities['alarm']}">checked="checked"</g:if> /><label for="amenity_alarm">In-Unit Alarm</label></li>
            <li><input class="formpicker" type="checkbox" name="amenity" value="truck" id="amenity_truck" <g:if test="${amenities && amenities['truck']}">checked="checked"</g:if> /><label for="amenity_truck">Free Move-In Truck</label></li>
        </ul>
    </div>
    </g:if>
</div>
