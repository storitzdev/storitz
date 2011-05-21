// setup for google analytics
var _gaq = _gaq || [];
_gaq.push(  ['_setAccount', 'UA-16012579-1'],
            ['_setDomain', '.storitz.com'],
            ['_setAllowHash',false],
            ['_setAllowLinker', true],
            ['_trackPageview'],
            ['_trackPageview', '/goal/college_landing']);

<!-- Google Website Optimizer Tracking Script -->
 _gaq.push(['gwo._setAccount', 'UA-16012579-4']);
 _gaq.push(['gwo._trackPageview', '/0667671337/test']);

var ga = document.createElement('script');
ga.type = 'text/javascript';
ga.async = true;
ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
var s = document.getElementsByTagName('script')[0];
s.parentNode.insertBefore(ga, s);

$(document).ready(function() {
    $(".tooltip a.close").click(function() {
        $(this).parents(".tooltip").first().css("left", -2000);
        return false;
    });
    if (window.location.hash == "#map-view") {
        mapify();
    }
    $("#toggle_map_view").click(function() {
        $("#search_results").hasClass("map") ? listify() : mapify();
        return false;
    });
    var rebate_clicked = false;
    $("#rebate_tile").click(function() {
        if (!rebate_clicked) {
            _gaq.push(['_trackEvent', 'detail', 'college-rebate-click']);
            rebate_clicked = true;
        }
        $("#rebate_panel").slideToggle();
        return false;
    });
    $("#rebate_panel a.close").click(function() {
        $("#rebate_panel").slideUp();
        return false;
    });
    var tips_clicked = false;
    $("#college_tips_button").click(function() {
        if (!rebate_clicked) {
            _gaq.push(['_trackEvent', 'detail', 'college-tips-click']);
            tips_clicked = true;
        }
        $("#college_tips_panel").slideToggle();
        return false;
    });
    $("#college_tips_panel a.close").click(function() {
        $("#college_tips_panel").slideUp();
        return false;
    });
    $(".show_map_popup a").click(function() {
        var link = $(this);
        var site_id = link.parents(".facility").first().attr("site_id");
        if (current_maplet_marker) {
            current_maplet_marker.setMap(null);
        }
        var point = markers[site_id].getPosition();
        current_maplet_marker = new google.maps.Marker({ map: google_maplet, position: point });  // todo: cache & re-use
        google_maplet.setCenter(point);
        _gaq.push(['_trackEvent', 'detail', 'college-rebate-show-map']);
        display_tooltip("#map_popup", link);
        return false;
    });
    var markers = {};
    var current_maplet_marker = null;
    var google_big_map;
    var google_maplet;
    var bounds = new google.maps.LatLngBounds();
    var maplet_canvas = document.getElementById("maplet_canvas");
    if (maplet_canvas) {
        google_maplet = new google.maps.Map(maplet_canvas, maplet_options);
    }
    var big_map_canvas = document.getElementById("big_map_canvas");
    if (big_map_canvas) {
        google_big_map = new google.maps.Map(big_map_canvas, big_map_options);
        google_big_map.setCenter(bounds.getCenter());
        google_big_map.fitBounds(bounds);
    }
    $("#search_results .facility").each(function() {
        var row = $(this);
        var site_id = row.attr("site_id");
        var point = new google.maps.LatLng(row.attr("lat"), row.attr("lng"));
        var marker = new google.maps.Marker({ map: google_big_map, position: point });
        markers[site_id] = marker;
        bounds.extend(point);
    });
    var maplet_options = {
      zoom: 14,
      mapTypeId: google.maps.MapTypeId.ROADMAP
    }
    var big_map_options = {
      zoom: 15,
      mapTypeId: google.maps.MapTypeId.ROADMAP
    }
});


function display_tooltip(selector, src, options) {
    var left = null;
    var top = null;
    if (options) {
        if (options.left) {
            left = options.left;
        }
        if (options.top) {
            top = options.top;
        }
    }
    var node = $(selector);
    var offset = src.offset();
    if (!left) {
        left = offset.left + src.outerWidth() + 7;
    }
    if (!top) {
        top = offset.top - (0.5 * node.outerHeight());
    }
    node.css({
        left: left,
        top: top
    });
}

function mapify() {
    var link = $("#toggle_map_view");
    link.text("List View");
    link.attr("href", "#list-view");
    window.location.hash = "#map-view";
    $("#search_results").addClass("map");
    $("#search_result_labels").addClass("map");
    $("#big_map_canvas").addClass("visible");
}
function listify() {
    var link = $("#toggle_map_view");
    link.text("Map View");
    link.attr("href", "#map-view");
    window.location.hash = "#list-view";
    $("#search_results").removeClass("map");
    $("#search_result_labels").removeClass("map");
    $("#big_map_canvas").removeClass("visible");
}