// slurp the query-string into a variable QueryString
// Thanks to http://stackoverflow.com/questions/901115/get-query-string-values-in-javascript
var QueryString = (function(a) {
    if (a == "") return {};
    var b = {};
    for (var i = 0; i < a.length; ++i)
    {
        var p=a[i].split('=');
        if (p.length != 2) continue;
        b[p[0]] = decodeURIComponent(p[1].replace(/\+/g, " "));
    }
    return b;
})(window.location.search.substr(1).split('&'));

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
                $(".container_detail").height($("#left_panel").height()); //hack for correct footer placement
                updateShareLink();
            }
        }
    }
}();

function updateShareLink() {
  var origin = $("#srcAddr").val();
  var currentHref = shareLink;
  var newHref;
  var siteTitle = $("#facilityHours h2:first-child").text();
  if (currentHref.search(/\?origin=.*/) > 0) {
    newHref = currentHref.replace(/\?origin=.*/, "?origin="+origin);
  }
  else {
    newHref = currentHref + "?origin="+origin;
  }
  if (typeof stLight != "undefined") {
    stWidget.addEntry({
              "service":"sharethis",
              "element":document.getElementById('shareThis'),
              "url":newHref,
              "title":"Directions to "+siteTitle,
              "text":"Share"
            });
  }
  return false;
}

function changeMapMarker(marker) {
    var markerUrl = marker.getIcon().url;
    var markerSize = marker.getIcon().size;
    var markerOrigin = marker.getIcon().origin;
    var xCoord = markerOrigin.x;
    var yCoord = markerOrigin.y;
    var newMarkerOffset;
    if (xCoord % ((markerSize.width)*2) == 0) {   //do we have a blue marker or green?
        newMarkerOffset = new google.maps.Point(xCoord + (markerSize.width), yCoord); // we have blue
    }
    else {
        newMarkerOffset = new google.maps.Point(xCoord - (markerSize.width), yCoord); //we have green
    }
    var newMarker = new google.maps.MarkerImage(markerUrl, markerSize, newMarkerOffset);
    marker.setIcon(newMarker);
}
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
    var toggle_info_window = function(info_window, map, marker, site_id) {
        if (current_info_window) {
            current_info_window.close();
        }
        current_info_window = info_window;
        info_window.open(map, marker);
        var link = $("div.facility[site_id~="+site_id+"] a.name").attr("href");
        $("div.info_window .info_right a").attr("href", link.toString());
        $("div.info_window h3.info a").attr("href", link.toString());
        var lat = marker.getPosition().lat();
        var lng = marker.getPosition().lng();
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
            $("input:hidden[name=view-mode]").val("map-view");
            $("#search_results").addClass("map");
            $("#search_result_labels").addClass("map");
            $("#big_map_canvas").addClass("visible");
            $("body.serp").css('width', '80%'); //2
            $("body.serp .results_container").addClass('map_view'); //1
            $("body.serp.college .results_container").css('width', 'auto') //addition for college page.
            $("#big_map_canvas").css('width', '100%'); //3
            $(".map_container").show(); //4
            google.maps.event.trigger(big_map, 'resize');
            $("#search_results > li").click(function() {
                var site_id = $(this).attr("id").substr(5);
                var entry = markers[site_id];
                toggle_info_window(entry[1], big_map, entry[0], site_id);
            });
            $("#search_results > li").hover(function() { //we need to create a new markerImage for hoverIn and hoverOut
                var li = $(this);
                var site_id = li.attr("id").substr(5);
                li.css("background-color", "lightcyan");
                li.css("cursor", "pointer");
                var marker = markers[site_id][0];
                changeMapMarker(marker);
            }, function() {
                var li = $(this);
                var site_id = li.attr("id").substr(5);
                li.css("background", "none");
                li.css("cursor", "default");
                var marker = markers[site_id][0];
                changeMapMarker(marker);
            });
        },
        listify: function() {
            var link = $("#map_toggle_link");
            link.text("Map View");
            link.attr("href", "#map-view");
            window.location.hash = "#list-view";
            $("input:hidden[name=view-mode]").val("list-view");
            $("#search_results").removeClass("map");
            $("#search_result_labels").removeClass("map");
            $("#big_map_canvas").removeClass("visible");
            $("body.serp").css('width', '960px');   //2
            $("body.college").css('width', '947px');
            $("#big_map_canvas").css('width', '546px'); //3
            $("body.serp.college .results_container").css('width', 'none') //map college landing page
            $("body.serp .results_container").removeClass('map_view'); //1
            $(".map_container").hide() //4
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
                var hoverName;
                var addr1;
                var addr2;
                var phone;
                var infoContainer;
                var image;
                var yelp;
                var link;
                var facilities = $("#search_results .facility");
                var i = 0;
                var n = facilities.length;
                facilities.each(function() {
                    row = $(this);
                    hoverName = row.children("a").first().text();
                    name = "<h3 class='info'><a href='#'>"+row.children("a").first().text()+"</a></h3>";
                    addr1 = "<p>"+row.attr("addr")+"</p>";
                    addr2 = "<p>"+row.attr("city")+", "+row.attr("state")+" "+row.attr("zip")+"</p>";
                    var price = Math.floor(row.attr("price"));
                    var site_id = row.attr("site_id");
                    var lat = row.attr("lat");
                    var lng = row.attr("lng");
                    var revCount = $("#search_results li#site_"+site_id).attr('revCount');
                    var revStar = $("#search_results li#site_"+site_id).attr('revStar');
                    if (revCount && revStar) {
                      yelp = "<div class='yelp_rating_map'>" +
                            "<img src="+revStar+"></img>" +
                            "<span>"+revCount+" reviews</span>" +
                            "<a class='yelp_logo' href='http://www.yelp.com'>Reviews from yelp</a></div>";
                    }
                    else {
                      yelp ="<div class='yelp_rating_map'>" +
                            "<img src='http://media2.px.yelpcdn.com/static/201012164084228337/i/ico/stars/stars_0.png'/>" +
                            "<span>0 reviews</span>" +
                            "<a class='yelp_logo' href='http://www.yelp.com'>Reviews from yelp</a></div>";
                    }
                    phone = "<p>(877) 456-2929</p>";
                    image = "<a href='#'><img src="+row.attr('pic')+" /></a>";
                    link = "<a class='site_link' href='#'>Details</a>"
                    infoContainer="<div class='info_window'>" +
                            "<div class='info_left'>"+name+addr1+addr2+phone+yelp+"</div>" +
                            "<div class='info_right'>"+image+link+"</div></div>";
                    var point = new google.maps.LatLng(lat, lng);
                    var markerUrl;  //the pin sprite to use.
                    var markerSize;  //size of a pin
                    var offset;    //position of the pin in sprite
                    var pinWidth = (price < 100) ? 44 : 52;
                    var pinHeight = 50;
                    if (price < 10) { markerUrl = pinurl0; }
                    else if (price < 100) { markerUrl = pinurl1; }
                    else if (price < 200) { markerUrl = pinurl2; }
                    else if (price < 300) { markerUrl = pinurl3; }
                    else if (price < 400) { markerUrl = pinurl4; }
                    else if (price < 500) { markerUrl = pinurl5; }
                    else if (price < 600) { markerUrl = pinurl6; }
                    else { markerUrl = pinurl7; }
                    if (price < 10) {
                        markerSize = new google.maps.Size(36, pinHeight);
                        offset = new google.maps.Point(36, price*pinHeight); //custom offset due to a two column sprite.
                    }
                    else if (price < 100) {
                        markerSize = new google.maps.Size(pinWidth, pinHeight); //size of the image to display in x, y pixels
                        offset = new google.maps.Point(pinWidth*((2*Math.floor(price/10))-1),pinHeight*(price%10));
                    }
                    else {
                        markerSize = new google.maps.Size(pinWidth, pinHeight); //size of the image to display in x, y pixels
                        offset = new google.maps.Point(pinWidth*((2*Math.floor(price/10%10))+1),pinHeight*(price%10));
                    }
                    var priceMarker = new google.maps.MarkerImage(markerUrl, markerSize, offset);
                    var marker = new google.maps.Marker({ map: big_map, position: point, icon: priceMarker, title: hoverName });
                    var info_window = new google.maps.InfoWindow( { content: infoContainer, maxWidth: 300});
                    google.maps.event.addListener(marker, "mouseover", function() {
                        changeMapMarker(marker);
                        $("ul#search_results li#site_"+site_id).css('background-color', 'lightcyan');
                    });
                    google.maps.event.addListener(marker, "mouseout", function() {
                        changeMapMarker(marker);
                        $("ul#search_results li#site_"+site_id).css('background-color', 'white');
                    });
                    google.maps.event.addListener(marker, "click", function() {
                        toggle_info_window(info_window, big_map, marker, site_id);
                        var list = $("#search_results");
                        var target = $("li#site_" + site_id);
                        if (target.length > 0) {
                          var target_top = target.offset().top;
                          var list_top = list.offset().top;
                          // we need to scroll if either of the following are true:
                          //   target_top < list_top (top edge is scrolled up out of view)
                          //   target_top + target.height() > list_top + list.height()) (bottom edge is scrolled out of view)
                          var do_scroll = ((target_top < list_top) || (target_top + target.height() > list_top + list.height()));
                          if (do_scroll) {
                            var found = false;
                            var scroll_y = 0;
                            var siblings = list.children();
                            for (var i = 0; i < siblings.length; i++) {
                              if (siblings[i] == target[0]) {
                                found = true;
                                break;
                              }
                              else {
                                scroll_y += $(siblings[i]).height();
                              }
                            }
                            if (found) {
                              list.scrollTop(scroll_y);
                            }
                          }
                        }
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
    $(".tooltip a.close").live("click", function() {
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
    $("#purchaseSummary .move_in_info a").click(function() { //temporary binding for thankyoupage summary
        $("#purchaseSummary div.cost_details").toggle();
    });

});

function initialize_checkout_page() {
  initialize_transaction_box(update_billing_summary_panel);
  ie_reapply_styles();
}

function initialize_site_detail_page() {
    if(typeof stLight != "undefined") {
      stLight.options({
                publisher:'fcffc560-5a11-434a-b976-a60a57d870ed',
                onHover: false
              });
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
    $("ul.tabs li, div.yelp_rating a").click(function () {
        var left = $("#left_panel").height();
        var right = $("#right_panel").height();
        var max_height = Math.max(left, right);
        $(".container_detail").height(max_height);
    });

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
    var site_review = $(".site_info .tabs #display_review");
    var lat = site_review.attr('lat');
    var lng = site_review.attr('lng');
}

function initialize_transaction_box(callback) {
  $("#datepicker").datepicker(
          { dateFormat: 'yy-mm-dd',
            dayNamesMin: $.datepicker._defaults.dayNamesShort,
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

  $(".move_in_quote #promo_list a.promo").live("click", function() {
    $("#promoId").val($(this).attr("promo_id"));
    $("#promo_list").css("left", -2000)
    callback();
    return false;
  });
  $(".move_in_quote a.remove_offer").live("click", function() {
    $("#promoId").val("-1");
    callback();
    return false;
  });
  $(".move_in_quote a.more_offers").live("click", function() {
    _util.display_tooltip("#promo_list", $(this), {
      left: -40,
      top: 70
    });
//    $("#promo_list").slideToggle();
    return false;
  });
  $(".move_in_quote a.offer_details").live("click", function() {
     _util.display_tooltip("#promo_details", $(this), {
      left: -40,
      top: 70
    });
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
  $("input[placeholder]").placeholder();
  var resHeight = $("#results_container").height();
  var pickHeight = $("div#pickers").height();
  if (resHeight < pickHeight  ) {
     $("div#footer").css('margin-top', pickHeight - resHeight + 10);
  }
  // show map?
  if (window.location.hash == "#map-view" || QueryString["view-mode"]=="map-view") {
      _map.mapify();
  }
  // bind map events
  $(".toggle_map_view").click(function() {
      if ($("#search_results").hasClass("map")) {
          _map.listify();
          if ($.browser.msie && (resHeight < pickHeight)) {
            $("div#footer").css("margin-top", pickHeight - resHeight + 10);
          }
      }
      else {
          _map.mapify();
          if ($.browser.msie) {
            $("div#footer").css("margin-top", 0);
          }
      }
      return false;
  });
  $(".show_map_popup a").click(function() {
      _map.show_popup(this);
      return false;
  });
}
function update_rent_me_panel() {
  var f = $("#rent_me_form");
  if (!$.browser.msie) {f.css("opacity", "0.5");}
  f.load(f.attr("src"), f.serialize(), function() {
    if (!$.browser.msie) { f.css("opacity", "1"); }
    ie_reapply_styles();
  });
}
function update_billing_summary_panel() {
  var panel = $("#booking_summary");
  var inputs = $("input[type=hidden]", panel);
  if (!$.browser.msie) {panel.css("opacity", "0.5");}
  panel.load(panel.attr("src"), inputs.serialize(), function() {
    if (!$.browser.msie) {panel.css("opacity", "1");}
    $("#rental_transaction_form h1.pay .moveInCostTotal").html($(".cost_breakdown tr.total td.last").html());
    ie_reapply_styles();
  });
}
function ie_reapply_styles() { //reapply styles to transaction panel.
  if ($.browser.msie) {
      $("body.checkout .customer_info > div, body.checkout .customer_info > h1").css({'position':'relative', 'padding':'10px 0 0 20px;'});
      $("body.checkout #booking_summary > div").css('padding', '12px');
      $("body.checkout #booking_summary .site_info").css({'padding-top':'0', 'margin-top':'12px'});
      $("body.checkout input[type=text]").addClass('typeText');
      $("body.site_detail #right_panel .move_in_quote a.edit_date").css({'position':'absolute','top':'13px','right':'13px'});
  }
}

function bindPickerFormHandler (target,picker,container,spinner) {
    var handler = function() {
        var form = document.getElementById(picker);
        if (form) {
            var scrollTop = $(window).scrollTop();
            var viewportHeight = $(window).height();
            var parent = $(spinner).parent().get(0).tagName;
            if (parent != "BODY") {
              var spin = $(spinner).detach();
              spin.appendTo('.college');
            }
            $(container).fadeTo(0,.5);
            $(spinner).css('top',scrollTop+(viewportHeight/2)-10);
            $(spinner).show()
            form.submit();
        }
    };

    $(target).change(function() {
        handler()
    });
}

