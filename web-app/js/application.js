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

//detail page map
var _direction = function() {
    var map;
    var directionsDisplay;
    var markerGreen;
    var markerBlue;
    var directionsService;
    var site_title;
    var site_latlng;
    var marker;

    return {
        init: function() { //optional args: title, lat, lng
            markerGreen = new google.maps.MarkerImage("http://gmaps-samples.googlecode.com/svn/trunk/markers/green/blank.png");
            markerGreen = new google.maps.MarkerImage("http://gmaps-samples.googlecode.com/svn/trunk/markers/blue/blank.png");
            directionsService = new google.maps.DirectionsService();
            var  site = $(".site_info .tabs #display_map");
            site_title = (arguments[0]) ? arguments[0] : site.attr('title');
            var site_lat = (arguments[1]) ? arguments[1] : site.attr('lat');
            var site_lng = (arguments[2]) ? arguments[2] : site.attr('lng');
            site_latlng = new google.maps.LatLng(site_lat, site_lng);
            var myOptions = {
              zoom: 15,
              center: site_latlng,
              mapTypeId: google.maps.MapTypeId.ROADMAP
            };
            marker = new google.maps.Marker({
              position: site_latlng,
              title: site_title,
              icon: markerGreen
            });
            map = new google.maps.Map(document.getElementById("directionMapCanvas"),
                    myOptions);
            marker.setMap(map);
        },
        calculate: function() { //optional args: start,lat,lng
            directionsDisplay = new google.maps.DirectionsRenderer();
            var request;
            var start;
            if (arguments[0] && arguments[1] && arguments[2]) {
                directionsService = new google.maps.DirectionsService();
                var destLatLng = new google.maps.LatLng(arguments[1], arguments[2]);
                start = arguments[0];
                request = {
                    origin: start,
                    destination: destLatLng,
                    unitSystem: google.maps.DirectionsUnitSystem.IMPERIAL,
                    travelMode: google.maps.TravelMode.DRIVING
                };
            }
            else {
                start = $("#srcAddr").val();
                request = {
                    origin: start,
                    destination: site_latlng,
                    unitSystem: google.maps.DirectionsUnitSystem.IMPERIAL,
                    travelMode: google.maps.TravelMode.DRIVING
                };
            }
            directionsService.route(request, _direction.drawDirections);
        },
        drawDirections: function(response, status) {
            if (status == google.maps.DirectionsStatus.OK) {
                directionsDisplay.setDirections(response);
                var polyline = new google.maps.Polyline({
                            path: [],
                            strokeColor: '#3bad00',
                            strokeWeight: 3
                });
                var bounds = new google.maps.LatLngBounds();
                var route = response.routes[0];
                var legs = route.legs;
                var startLocation = new Object();
                var endLocation = new Object();

                $('#directionsSteps').children().each(function(index) { $(this).remove() });
                marker.setMap(null);

                for (i=0; i < legs.length; i++) {
                    if (i == 0) {
                        startLocation.latlng = legs[i].start_location;
                        startLocation.address = legs[i].start_address;
                        new google.maps.Marker({
                            map: map,
                            title: "Start",
                            position: startLocation.latlng,
                            icon: markerBlue
                        });
                        if (legs[i].distance && legs[i].duration) {
                            $('#directionsDistance').html('Total distance: ' + legs[i].distance.text + ' in approximately ' + legs[i].duration.text);
                        }
                    }
                    endLocation.latlng = legs[i].end_location;
                    endLocation.address = legs[i].end_address;
                    var steps = legs[i].steps;
                    var elem;
                    for (j=0; j < steps.length; j++) {
                        var nextSegment = steps[j].path;
                        var durationText = steps[j].duration.text ? steps[j].duration.text : "&nbsp;";
                        var distanceText = steps[j].distance.text ? steps[j].distance.text : "&nbsp;";
                        if (j != steps.length - 1) {
                            elem = $('<tr>', { "class": "directionStep" })
                                    .append($('<td>', { style:"width:95px;text-align:right;"}).html((j + 1) + '.'))
                                    .append($('<td>', { style:"width:380px; padding-left:10px;" }).html(steps[j].instructions))
                                    .append($('<td>', { style:"width: 75px; padding-right: 10px;text-align:right;"}).html(distanceText))
                                    .append($('<td>', { style:"width: 115px; padding-right: 15px;text-align:right;"}).html(durationText));
                        }
                        else {
                            elem = $('<tr>', { "class": "directionStepLast" })
                                    .append($('<td>', { style:"width:95px;text-align:right;"}).html((j + 1) + '.'))
                                    .append($('<td>', { style:"width:380px; padding-left:10px; line-height:140%;" }).html(steps[j].instructions))
                                    .append($('<td>', { style:"width: 75px; padding-right: 10px;text-align:right;"}).html(distanceText))
                                    .append($('<td>', { style:"width: 115px; padding-right: 15px;text-align:right;"}).html(durationText));
                        }

                        $('#directionsSteps').append(elem);
                        for (k=0; k < nextSegment.length; k++) {
                            polyline.getPath().push(nextSegment[k]);
                            bounds.extend(nextSegment[k]);
                        }
                    }
                }
                if (route.copyrights) {
                    $('#directionsCopyrights').html(route.copyrights);
                }
                if (route.warnings && route.warnings.length > 0) {
                    var warnings = $('<ul>');
                    $.each(route.warnings, function(index, warn) {
                        warnings.append($('<li>').text(warn))
                    });
                    $('#directionsWarnings').html(warnings);
                }
                polyline.setMap(map);
                map.fitBounds(bounds);
                new google.maps.Marker({
                    map: map,
                    title: site_title,
                    position: endLocation.latlng,
                    icon: markerGreen
                });
                $('#directionsStartAddr').html(startLocation.address);
                $('#directionsEndAddr').html(endLocation.address);
            }
        }
    }
}();

var _map = function() {
    // private variables
    var active_icon;
    var inactive_icon;
    var current_maplet_marker = null;
    var current_info_window = null;
    var big_map;
    var popup_map;
    var mini_map;
    var markers = {}; // maps site IDs to [google.maps.Marker, google.maps.InfoWindow] pairs
    var popup_map_options;
    var big_map_options;
    var toggle_info_window = function(info_window, map, marker) {
        if (current_info_window) {
            current_info_window.close();
        }
        current_info_window = info_window;
        info_window.open(map, marker);
    };

    // TODO: This is very fragile; it will break if the DOM structure isn't exactly right.
    // When calling init(), the caller should provide the selectors to which the various
    // click/hover events should be bound

    // public interface
    return {
        mapify: function() {
            var link = $("#map_toggle_link");
            link.text("List View");
            link.attr("href", "#list-view");
            window.location.hash = "#map-view";
            $("#search_results").addClass("map");
            $("#search_result_labels").addClass("map");
            $("#big_map_canvas").addClass("visible");
            $("#search_results > li").click(function() {
                var site_id = $(this).attr("id").substr(5);
                var entry = markers[site_id];
                toggle_info_window(entry[1], big_map, entry[0]);
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
            var link = $("#map_toggle_link");
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
            active_icon = new google.maps.MarkerImage("http://gmaps-samples.googlecode.com/svn/trunk/markers/green/blank.png");
            inactive_icon = new google.maps.MarkerImage("http://gmaps-samples.googlecode.com/svn/trunk/markers/blue/blank.png");
            popup_map_options = {
              zoom: 14,
              mapTypeId: google.maps.MapTypeId.ROADMAP
            };
            big_map_options = {
                zoom: 15,
                mapTypeId: google.maps.MapTypeId.ROADMAP
            };
            var big_map_canvas = document.getElementById("big_map_canvas");
            var popup_map_canvas = document.getElementById("popup_map_canvas");
            var mini_map_url = "";
            if (popup_map_canvas) {
              popup_map = new google.maps.Map(popup_map_canvas, popup_map_options);
            }
            if (big_map_canvas) {
                big_map = new google.maps.Map(big_map_canvas, big_map_options);
                var big_map_bounds = new google.maps.LatLngBounds();
                var mini_map_canvas = $("#mini_map_canvas");
                var mini_map_width = mini_map_canvas.width();
                var mini_map_height = mini_map_canvas.height();
                var mini_map_url = "http://maps.google.com/maps/api/staticmap?maptype=roadmap&sensor=false&size=" // http://maps.google.com/maps/api/staticmap?size=175x108&maptype=roadmap&sensor=false&markers=size:tiny|color:blue|37.598602295,-122.366798401|37.610084534,-122.401283264|...&markers=size:tiny|color:red|37.61666667,-122.3833333
                mini_map_url += mini_map_width + "x" + mini_map_height;
                mini_map_url += "&markers=size:tiny|color:blue|"
                var row;
                var name;
                var site_id;
                var lat;
                var lng;
                var facilities = $("#search_results .facility");
                var i = 0;
                var n = facilities.length;
                facilities.each(function() {
                    row = $(this);
                    name = row.children("a").first().text();
                    site_id = row.attr("site_id");
                    lat = row.attr("lat");
                    lng = row.attr("lng");
                    var point = new google.maps.LatLng(lat, lng);
                    var marker = new google.maps.Marker({ map: big_map, position: point, icon: inactive_icon, title: name });
                    var info_window = new google.maps.InfoWindow( { content: name, maxWidth: 200 });
                    google.maps.event.addListener(marker, "click", function() {
                        toggle_info_window(info_window, big_map, marker);
                    });
                    markers[site_id] = [marker, info_window];
                    big_map_bounds.extend(point);
                    mini_map_url += lat + "," + lng;
                    if (i < n  - 1) {
                      mini_map_url += "|";
                    }
                    i++;
                });
                mini_map_canvas.html('<a href="#map-view" class="toggle_map_view"><img width="' + mini_map_width + '" height="' + mini_map_height + '" src="' + mini_map_url + '" /></a>');
                big_map.setCenter(big_map_bounds.getCenter());
                big_map.fitBounds(big_map_bounds);
            }
        },
        show_popup: function(element) {
            var link = $(element);
            var site_id = link.parents(".facility").first().attr("site_id");
            var address = link.parent().prev().text();
            $("p", "#popup_map").first().text(address);
            if (current_maplet_marker) {
                current_maplet_marker.setMap(null);
            }
            var point = markers[site_id][0].getPosition();
            current_maplet_marker = new google.maps.Marker({ map: popup_map, position: point, title: name, icon: inactive_icon });  // todo: cache & re-use
            popup_map.setCenter(point);
            _gaq.push(['_trackEvent', 'detail', 'college-rebate-show-map']);
            _util.display_tooltip("#popup_map", link);
        }
    }
}();

$(document).ready(function() { // common event bindings
    // bind tooltip events
    $(".tooltip a.close").click(function() {
        $(this).parents(".tooltip").first().css("left", -2000);
        return false;
    });
    //hover functionality in logos for IE
    if ($.browser.msie) {
        $("#logos li").hover(
             function() {
                  $(this).addClass('hover');
             },
             function() {
                 $(this).removeClass('hover');
             }
        );
    }
});

function initialize_checkout_page() {
  initialize_transaction_box(update_billing_summary_panel);
}

function initialize_site_detail_page() {
    if(typeof stLight != "undefined") {
      stLight.options({publisher:'fcffc560-5a11-434a-b976-a60a57d870ed'});
    }

    //image gallery in detail page.
    $(".photos ul.image_list li img").click(
            function() {
                var new_img = $(this).attr('src');
                $(".main_pic").attr('src', new_img);
            }
    );
    // initialize tabs
    $("ul.tabs").tabs("div.panes > div");

    // fix height so footer isn't hidden behind body content
    var left = $("#left_panel").height();
    var right = $("#right_panel").height();
    var max_height = Math.max(left, right);
    $(".container").height(max_height);

    initialize_transaction_box(update_rent_me_panel);

    //browser specifics for IE
    if ($.browser.msie) {
      $("#featuresList ul").css("float", "left");
      $("#rentme").css("margin-left", "10px");
    }
    //map tab
    $("#display_map").click(function() {
        _direction.init();
    });
    $("#getDirections").click(function () {
        _direction.calculate();
        $("#dirPanel").css("display", "block");
    });
}

function initialize_transaction_box(callback) {
  $("#datepicker").datepicker(
          { dateFormat: 'yy-mm-dd',
            minDate: 0,
            onSelect: function(date) {
              $('#moveInDate').val(date);
              _gaq.push(['_trackEvent', 'detail', 'transaction box', 'date change']);
              $("#datepicker").hide();
              callback();
            }
          }).datepicker("hide");

  $(".move_in_quote a.edit_date").live("click", function(evt) {
    var element = $("#datepicker");
    element.datepicker("option", "maxDate", $(this).attr("max-days"));
    element.css("top", (evt.pageY - element.innerHeight() + 30) + "px");
    element.css("left", (evt.pageX - element.innerWidth()) + "px");
    element.show();
    return false;
  });

  $(".move_in_quote .promos a").live("click", function() {
    $("#promoId").val($(this).attr("promo_id"));
    callback();
    return false;
  });
  $(".move_in_quote .offer_links a.remove").live("click", function() {
    $("#promoId").val("-1");
    callback();
    return false;
  });
  $(".move_in_quote .offer_links a.more").live("click", function() {
    $(this).parent(".offer_links").next("ul").slideToggle();
    return false;
  });
  $(".move_in_quote a.breakdown").live("click", function() {
    $(this).parent().next(".cost_breakdown").slideToggle();
    return false;
  });
}
function initialize_college_landing_page() {
    initialize_serp();
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
}

function initialize_splash() {
    // bind home page events
    $("#coverphoto fieldset.advanced legend").click(function() {
        $("#advanced_search_controls").slideToggle();
    });
    $("input[placeholder]").placeholder();
    $("#browse .tabs").tabs("#browse .panes > div", {
                //history: true,
                initialIndex: null,
                onClick: function() {
                    //alert("what?");
                }
            });
}

function initialize_serp() {
  _map.init();
  // show map?
  if (window.location.hash == "#map-view") {
      _map.mapify();
  }
  // bind map events
  $(".toggle_map_view").click(function() {
      $("#search_results").hasClass("map") ? _map.listify() : _map.mapify();
      return false;
  });
  $(".show_map_popup a").click(function() {
      _map.show_popup(this);
      return false;
  });
}
function update_rent_me_panel() {
  var f = $("#rent_me_form");
  f.css("opacity", "0.5")
  f.load(f.attr("src"), f.serialize(), function() {
    f.css("opacity", "1");
  });
}
function update_billing_summary_panel() {
  var panel = $("#booking_summary");
  var inputs = $("input[type=hidden]", panel);
  panel.css("opacity", "0.5")
  panel.load(panel.attr("src"), inputs.serialize(), function() {
    panel.css("opacity", "1");
    $("#rental_transaction_form h1.pay .moveInCostTotal").html($(".cost_breakdown tr.total td.last").html());
  });
}