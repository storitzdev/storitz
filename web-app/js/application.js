// setup for google analytics
var _gaq = _gaq || [];
_gaq.push(  ['_setAccount', 'UA-16012579-1'],
            ['_setDomain', '.storitz.com'],
            ['_setAllowHash',false],
            ['_setAllowLinker', true],
            ['_trackPageview']);

var ga = document.createElement('script');
ga.type = 'text/javascript';
ga.async = true;
ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
var s = document.getElementsByTagName('script')[0];
s.parentNode.insertBefore(ga, s);

var _util = {
    display_tooltip: function(selector, src, options) {
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
};

var _map = function() {
    // private variables
    var active_icon = new google.maps.MarkerImage("http://gmaps-samples.googlecode.com/svn/trunk/markers/green/blank.png");
    var inactive_icon = new google.maps.MarkerImage("http://gmaps-samples.googlecode.com/svn/trunk/markers/blue/blank.png");
    var current_maplet_marker = null;
    var current_info_window = null;
    var google_big_map;
    var google_maplet;
    var markers = {}; // maps site IDs to [google.maps.Marker, google.maps.InfoWindow] pairs
    var maplet_options = {
      zoom: 14,
      mapTypeId: google.maps.MapTypeId.ROADMAP
    };
    var big_map_options = {
        zoom: 15,
        mapTypeId: google.maps.MapTypeId.ROADMAP
    };
    var toggle_info_window = function(info_window, map, marker) {
        if (current_info_window) {
            current_info_window.close();
        }
        current_info_window = info_window;
        info_window.open(map, marker);
    };

    // TODO: This is very fragile; t will break if the DOM structure isn't exactly right.
    // When calling init(), the caller should provide the selectors to which the various
    // click/hover events should be bound

    // public interface
    return {
        mapify: function() {
            var link = $("#toggle_map_view");
            link.text("List View");
            link.attr("href", "#list-view");
            window.location.hash = "#map-view";
            $("#search_results").addClass("map");
            $("#search_result_labels").addClass("map");
            $("#big_map_canvas").addClass("visible");
            $("#search_results > li").click(function() {
                var site_id = $(this).attr("id").substr(5);
                var entry = markers[site_id];
                toggle_info_window(entry[1], google_big_map, entry[0]);
            });
            $("#search_results > li").hover(function() {
                var li = $(this);
                var site_id = li.attr("id").substr(5);
                li.css("background-color", "lightcyan");
                li.css("cursor", "pointer");
                var marker = markers[site_id][0];
                marker.setIcon(active_icon);
            }, function() {
                var li = $(this);
                var site_id = li.attr("id").substr(5);
                li.css("background", "none");
                li.css("cursor", "default");
                var marker = markers[site_id][0];
                marker.setIcon(inactive_icon);
            });
        },
        listify: function() {
            var link = $("#toggle_map_view");
            link.text("Map View");
            link.attr("href", "#map-view");
            window.location.hash = "#list-view";
            $("#search_results").removeClass("map");
            $("#search_result_labels").removeClass("map");
            $("#big_map_canvas").removeClass("visible");
            $("#search_results > li").unbind("click");
            $("#search_results > li").unbind("mouseenter");
            $("#search_results > li").unbind("mouseleave");
        },
        init: function() {
            var maplet_canvas = document.getElementById("maplet_canvas");
            if (maplet_canvas) {
                google_maplet = new google.maps.Map(maplet_canvas, maplet_options);
            }
            var big_map_canvas = document.getElementById("big_map_canvas");
            var bounds = new google.maps.LatLngBounds();
            if (big_map_canvas) {
                google_big_map = new google.maps.Map(big_map_canvas, big_map_options);
                $("#search_results .facility").each(function() {
                    var row = $(this);
                    var name = row.children("a").first().text();
                    var site_id = row.attr("site_id");
                    var point = new google.maps.LatLng(row.attr("lat"), row.attr("lng"));
                    var marker = new google.maps.Marker({ map: google_big_map, position: point, icon: inactive_icon, title: name });
                    var info_window = new google.maps.InfoWindow( { content: name, maxWidth: 200 });
                    google.maps.event.addListener(marker, "click", function() {
                        toggle_info_window(info_window, google_big_map, marker);
                    });
                    markers[site_id] = [marker, info_window];
                    bounds.extend(point);
                });
                google_big_map.setCenter(bounds.getCenter());
                google_big_map.fitBounds(bounds);
            }
        },
        show_popup: function(element) {
            var link = $(element);
            var site_id = link.parents(".facility").first().attr("site_id");
            var address = link.parent().prev().text();
            $("p", "#map_popup").first().text(address);
            if (current_maplet_marker) {
                current_maplet_marker.setMap(null);
            }
            var point = markers[site_id][0].getPosition();
            current_maplet_marker = new google.maps.Marker({ map: google_maplet, position: point, title: name, icon: inactive_icon });  // todo: cache & re-use
            google_maplet.setCenter(point);
            _gaq.push(['_trackEvent', 'detail', 'college-rebate-show-map']);
            _util.display_tooltip("#map_popup", link);
        }
    }
}();

$(document).ready(function() {

    // bind tooltip events
    $(".tooltip a.close").click(function() {
        $(this).parents(".tooltip").first().css("left", -2000);
        return false;
    });

    _map.init();

    // show map?
    if (window.location.hash == "#map-view") {
        _map.mapify();
    }

    // bind map events
    $("#toggle_map_view").click(function() {
        $("#search_results").hasClass("map") ? _map.listify() : _map.mapify();
        return false;
    });
    $(".show_map_popup a").click(function() {
        map.show_popup(this);
        return false;
    });

    // bind college landing page events
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

    // bind home page events
    $("#advanced_search legend").click(function() {
        $("#advanced_search_controls").slideToggle();
    });
    $("#search input[placeholder]").placeholder();
    $("#browse .tabs").tabs("#browse .panes > div", {
                initialIndex: null,
                history: true
            });
});