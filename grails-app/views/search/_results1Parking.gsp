<div class="panel" id="pickers">
    <div>
        <h2>
            Map
            <a href="_results.gsp#map-view" class="toggle_map_view" id="map_toggle_link">Show big map!</a>
        </h2>
        <div id="mini_map_canvas"></div>
    </div>
    <div>
        <h2>Parking size</h2>
        <ul>
            <li><input class="formpicker" type="radio" name="unit_size" value="10x10" id="size_10x10" <g:if test="${unitSize == '10x10'}">checked="checked"</g:if> /><label for="size_10x10">10 x 10</label></li>
            <li><input class="formpicker" type="radio" name="unit_size" value="10x15" id="size_10x15" <g:if test="${unitSize == '10x15'}">checked="checked"</g:if> /><label for="size_10x15">10 x 15</label></li>
            <li><input class="formpicker" type="radio" name="unit_size" value="10x20" id="size_10x20" <g:if test="${unitSize == '10x20'}">checked="checked"</g:if> /><label for="size_10x20">10 x 20</label></li>
            <li><input class="formpicker" type="radio" name="unit_size" value="10x25" id="size_10x25" <g:if test="${unitSize == '10x25'}">checked="checked"</g:if> /><label for="size_10x25">10 x 25</label></li>
            <li><input class="formpicker" type="radio" name="unit_size" value="10x30" id="size_10x30" <g:if test="${unitSize == '10x30'}">checked="checked"</g:if> /><label for="size_10x30">10 x 30</label></li>
            <li><input class="formpicker" type="radio" name="unit_size" value="10x35" id="size_10x35" <g:if test="${unitSize == '10x35'}">checked="checked"</g:if> /><label for="size_10x35">10 x 35</label></li>
            <li><input class="formpicker" type="radio" name="unit_size" value="10x40" id="size_10x40" <g:if test="${unitSize == '10x40'}">checked="checked"</g:if> /><label for="size_10x40">10 x 40</label></li>
            <li><input class="formpicker" type="radio" name="unit_size" value="10x45" id="size_10x45" <g:if test="${unitSize == '10x45'}">checked="checked"</g:if> /><label for="size_10x45">10 x 45</label></li>
            <li><input class="formpicker" type="radio" name="unit_size" value="10x50" id="size_10x50" <g:if test="${unitSize == '10x50'}">checked="checked"</g:if> /><label for="size_10x50">10 x 50</label></li>
            <li><input class="formpicker" type="radio" name="unit_size" value="" id="size_all" <g:if test="${!unitSize}">checked="checked"</g:if> /><label for="size_all">Any</label></li>
        </ul>
    </div>
    <div>
        <h2>Parking type</h2>
        <ul>
            <li><input class="formpicker" type="radio" name="unit_type" value="covered" id="type_covered" <g:if test="${unitType == 'covered'}">checked="checked"</g:if> /><label for="type_covered">Covered</label></li>
            <li><input class="formpicker" type="radio" name="unit_type" value="uncovered" id="type_uncovered" <g:if test="${unitType == 'uncovered'}">checked="checked"</g:if> /><label for="type_uncovered">Uncovered</label></li>
            <li><input class="formpicker" type="radio" name="unit_type" value="" id="type_all" <g:if test="${!unitType}">checked="checked"</g:if> /><label for="type_all">Any</label></li>
        </ul>
    </div>
</div>
