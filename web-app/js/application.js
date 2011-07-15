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
            $("input:hidden[name=view-mode]").val("map-view");
            $("#search_results").addClass("map");
            $("#search_result_labels").addClass("map");
            $("#big_map_canvas").addClass("visible");
            $("body.serp").css('width', '80%'); //2
            $("body.serp .results_container").addClass('map_view'); //1
            $("#big_map_canvas").css('width', '100%'); //3
            $(".map_container").show(); //4
            google.maps.event.trigger(big_map, 'resize');
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
            $("input:hidden[name=view-mode]").val("list-view");
            $("#search_results").removeClass("map");
            $("#search_result_labels").removeClass("map");
            $("#big_map_canvas").removeClass("visible");
            $("body.serp").css('width', '960px');   //2
            $("#big_map_canvas").css('width', '546px'); //3
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
                var site_id;
                var lat;
                var lng;
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
                    name = "<h3 class='info'>"+row.children("a").first().text()+"</h2>";
                    addr1 = "<p>"+row.attr("addr")+"</p>";
                    addr2 = "<p>"+row.attr("city")+", "+row.attr("state")+" "+row.attr("zip")+"</p>";
                    site_id = row.attr("site_id");
                    lat = row.attr("lat");
                    lng = row.attr("lng");
                    yelp = "<div class='yelp_rating_map'>" +
                            "<img src='#'/><p> reviews</p>" +
                            "<a class='yelp_logo' href='http://www.yelp.com'>Reviews from yelp</a></div>";
                    phone = "<p>(877) 456-2929</p>";
                    image = "<img src="+row.attr('pic')+" />";
                    link = "<a href='#'>Rent</a>"
                    infoContainer="<div class='info_window'>" +
                            "<div class='info_left'>"+name+addr1+addr2+phone+yelp+"</div>" +
                            "<div class='info_right'>"+image+link+"</div></div>";
                    var point = new google.maps.LatLng(lat, lng);
                    var marker = new google.maps.Marker({ map: big_map, position: point, icon: inactive_icon, title: hoverName });
                    var info_window = new google.maps.InfoWindow( { content: infoContainer, maxWidth: 300});
                    google.maps.event.addListener(marker, "click", function() {
                        toggle_info_window(info_window, big_map, marker);
                        console.log("lat:" + lat + "lng:"+ lng);
                        genReviews(lat, lng);
                    });
                    markers[site_id] = [marker, info_window];
                    big_map_bounds.extend(point);
                    mini_map_url += lat + "," + lng;
                    if (i < n  - 1) {
                      mini_map_url += "|";
                    }
                    i++;
                });
                console.log(markers);
               for (var mark in markers) {
                    console.log("value of info window"+mark[0].position);
                    var lat = mark[0].position;
                }
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
    var site_review = $(".site_info .tabs #display_review");
    var lat = site_review.attr('lat');
    var lng = site_review.attr('lng');
    genReviews(lat,lng);
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

  $(".move_in_quote #promo_list a").live("click", function() {
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
      left: -60,
      top: 50
    });
//    $("#promo_list").slideToggle();
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
  if (window.location.hash == "#map-view" || QueryString["view-mode"]=="map-view") {
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
//yelp reviews
function genReviews(lat, lng, id) {  //provide the lat, and lng of the site. and optional id.
    var auth = {
        consumerKey: "XGY74hMiq2Vqe_2rXTGkXg",
        consumerSecret: "BjvEVIe7XDavXGyOlnVxz8Qo_Qk",
        accessToken: "1F3P66uwRv-t9NwIXzhz371tkTbO8rgz",
        accessTokenSecret: "03LJdE-bst4sX-SNQvnvKqtsRNE",
        serviceProvider: {
            signatureMethod: "HMAC-SHA1"
        }
    };
    var isBusiness = (id) ? true : false;  //is this a yelp search or yelp business?
    var terms = 'self+storage';
    var ll = lat.toString() + ',' + lng.toString();
    var category_filter = 'selfstorage';
    var limit = '1';
    var sort = '1';
    var radius_filter = '1000';
    console.log("i got here 1"); //debug
    var accessor = {
        consumerSecret: auth.consumerSecret,
        tokenSecret: auth.accessTokenSecret
    };

    parameters = [];
    if (!isBusiness) {
        parameters.push(['term', terms]);
        parameters.push(['ll', ll]);
        parameters.push(['limit', limit]);
        parameters.push(['sort', sort]);
        parameters.push(['category_filter', category_filter]);
        parameters.push(['radius_filter', radius_filter]);
        parameters.push(['callback', 'cb']);
    }
    if (isBusiness) {
        parameters.push(['callback', 'ncb']);
    }
    parameters.push(['oauth_consumer_key', auth.consumerKey]);
    parameters.push(['oauth_consumer_secret', auth.consumerSecret]);
    parameters.push(['oauth_token', auth.accessToken]);
    parameters.push(['oauth_signature_method', 'HMAC-SHA1']);
    var message;
    if (isBusiness) {
        message = {
            'action': 'http://api.yelp.com/v2/business/' + id,
            'method': 'GET',
            'parameters': parameters
        };
    }
    else {
        message = {
            'action': 'http://api.yelp.com/v2/search',
            'method': 'GET',
            'parameters': parameters
        };
    }

    OAuth.setTimestampAndNonce(message);
    OAuth.SignatureMethod.sign(message, accessor);

    var parameterMap = OAuth.getParameterMap(message.parameters);
    parameterMap.oauth_signature = parameterMap.oauth_signature.replace(/\+/g, '%2B');
    console.log(parameterMap);

    if (!isBusiness) {
        $.ajax({
                    'url': message.action,
                    'data': parameterMap,
                    'dataType': 'jsonp',
                    'jsonpCallback': 'cb',
                    'success': function(data, textStats, XMLHttpRequest) {
                        console.log(data);
                        console.log("i got here 2"); //debug
                        procReview(data, isBusiness);
                    }
                });
    }
    else {
        $.ajax({
                    'url': message.action,
                    'data': parameterMap,
                    'dataType': 'jsonp',
                    'jsonpCallback': 'ncb',
                    'success': function(data, textStats, XMLHttpRequest) {
                        console.log(data);
                        procReview(data, isBusiness);
                    }
                });
    }
}
function procReview(data, isBusiness) {
    if (!isBusiness && data.businesses.length == 0) {
        console.log("i got here 3"); //debug
        $(".yelp_rating img, .yelp_rating_map img").attr('src', 'http://media2.px.yelpcdn.com/static/201012164084228337/i/ico/stars/stars_0.png');
        $(".yelp_rating p, .yelp_rating_map p").prepend("0");
        $("#yelp_reviews").prepend("<h2 class='none'>This site has no reviews yet.</h2>");
        return;
    }
    else if (!isBusiness) {
        var site = data.businesses[0];
        genReviews(data.region.center.latitude, data.region.center.longitude, site.id);
    }
    else {
        console.log("i got here 4"); //debug
        var site = data;
        $(".yelp_rating img, .yelp_rating_map img").attr('src', site.rating_img_url);
        $(".yelp_rating p, .yelp_rating_map p").prepend(site.review_count);
        $("#yelp_reviews").prepend("<h2 class='review_title'>Showing "+site.reviews.length+" of "+site.review_count+" Yelp reviews</h2>");
        if (site.review_count > site.reviews.length) {
            $("#yelp_reviews a.read_more").css("display", "block");
            $("#yelp_reviews a.read_more").attr('href', site.url);
        }
        var i = 0;
        for(i = 0; i < site.reviews.length; i++) {
            var review = site.reviews[i];
            var d = new Date(review.time_created*1000);
            var revTime = (d.getUTCMonth()+1).toString() + "/" + d.getUTCDate().toString() + "/" + d.getUTCFullYear().toString();
            var userName = "<h2 class='reviewer'>" + review.user.name + "</h2>";
            var userImage = "<img class='revImage' src="+ review.user.image_url + " alt='user image' />";
            var excerpt = "<p class='revExcerpt'>" + review.excerpt + "<a href="+data.url+">read more</a></p>";
            var rating = "<img class='revRating' src="+ review.rating_image_url + " alt=" + review.rating + "stars" + "/>" + revTime;

            $(".user_reviews").append("<li class='review'>"+userImage+userName+rating+excerpt+"</li>");
        }
    }
}

var jwplayer=function(a){return jwplayer.constructor(a)};jwplayer.constructor=function(a){};var $jw=jwplayer;jwplayer.version="5.4.1530 (Licensed version)";(function(b){b.utils=function(){};b.utils.typeOf=function(d){var c=typeof d;if(c==="object"){if(d){if(d instanceof Array){c="array"}}else{c="null"}}return c};b.utils.extend=function(){var c=b.utils.extend["arguments"];if(c.length>1){for(var e=1;e<c.length;e++){for(var d in c[e]){c[0][d]=c[e][d]}}return c[0]}return null};b.utils.clone=function(f){var c;var d=b.utils.clone["arguments"];if(d.length==1){switch(b.utils.typeOf(d[0])){case"object":c={};for(var e in d[0]){c[e]=b.utils.clone(d[0][e])}break;case"array":c=[];for(var e in d[0]){c[e]=b.utils.clone(d[0][e])}break;default:return d[0];break}}return c};b.utils.extension=function(c){c=c.substring(c.lastIndexOf("/")+1,c.length);c=c.split("?")[0];if(c.lastIndexOf(".")>-1){return c.substr(c.lastIndexOf(".")+1,c.length).toLowerCase()}return""};b.utils.html=function(c,d){c.innerHTML=d};b.utils.append=function(c,d){c.appendChild(d)};b.utils.wrap=function(c,d){c.parentNode.replaceChild(d,c);d.appendChild(c)};b.utils.ajax=function(f,e,c){var d;if(window.XMLHttpRequest){d=new XMLHttpRequest()}else{d=new ActiveXObject("Microsoft.XMLHTTP")}d.onreadystatechange=function(){if(d.readyState===4){if(d.status===200){if(e){e(d)}}else{if(c){c(f)}}}};d.open("GET",f,true);d.send(null);return d};b.utils.load=function(d,e,c){d.onreadystatechange=function(){if(d.readyState===4){if(d.status===200){if(e){e()}}else{if(c){c()}}}}};b.utils.find=function(d,c){return d.getElementsByTagName(c)};b.utils.append=function(c,d){c.appendChild(d)};b.utils.isIE=function(){return(!+"\v1")};b.utils.isLegacyAndroid=function(){var c=navigator.userAgent.toLowerCase();return(c.match(/android 2.[012]/i)!==null)};b.utils.isIOS=function(){var c=navigator.userAgent.toLowerCase();return(c.match(/iP(hone|ad)/i)!==null)};b.utils.getFirstPlaylistItemFromConfig=function(c){var d={};var e;if(c.playlist&&c.playlist.length){e=c.playlist[0]}else{e=c}d.file=e.file;d.levels=e.levels;d.streamer=e.streamer;d.playlistfile=e.playlistfile;if(d.file&&d.file.toLowerCase().indexOf("youtube.com")>-1){d.provider="youtube"}if(d.streamer&&d.streamer.toLowerCase().indexOf("rtmp://")==0){d.provider="rtmp"}if(e.type){d.provider=e.type.toLowerCase()}else{if(e.provider){d.provider=e.provider.toLowerCase()}}return d};b.utils.flashSupportsConfig=function(c){if(b.utils.hasFlash()){if(c){var e=b.utils.getFirstPlaylistItemFromConfig(c);if(typeof e.file=="undefined"&&typeof e.levels=="undefined"){return true}else{if(e.file){return b.utils.flashCanPlay(e.file,e.provider)}else{if(e.levels&&e.levels.length){for(var d=0;d<e.levels.length;d++){if(e.levels[d].file&&b.utils.flashCanPlay(e.levels[d].file,e.provider)){return true}}}}}}else{return true}}return false};b.utils.flashCanPlay=function(c,e){var d=["video","http","sound","image"];if(e&&(d.toString().indexOf(e<0))){return true}var f=b.utils.extension(c);if(!f){return true}if(b.utils.extensionmap[f]!==undefined&&b.utils.extensionmap[f].flash===undefined){return false}return true};b.utils.html5SupportsConfig=function(d){var c=document.createElement("video");if(!!c.canPlayType){if(d){var f=b.utils.getFirstPlaylistItemFromConfig(d);if(typeof f.file=="undefined"&&typeof f.levels=="undefined"){return true}else{if(f.file){return b.utils.html5CanPlay(c,f.file,f.provider,f.playlistfile)}else{if(f.levels&&f.levels.length){for(var e=0;e<f.levels.length;e++){if(f.levels[e].file&&b.utils.html5CanPlay(c,f.levels[e].file,f.provider,f.playlistfile)){return true}}}}}}else{return true}}return false};b.utils.html5CanPlay=function(e,d,f,c){if(c){return false}if(f&&f=="youtube"){return true}if(f&&f!="video"&&f!="http"){return false}var g=b.utils.extension(d);if(b.utils.isLegacyAndroid()&&g.match(/m4v|mp4/)){return true}return b.utils.browserCanPlay(e,g)};b.utils.browserCanPlay=function(d,e){var c;if(!e){return true}else{if(b.utils.extensionmap[e]!==undefined&&b.utils.extensionmap[e].html5===undefined){return false}else{if(b.utils.extensionmap[e]!==undefined&&b.utils.extensionmap[e].html5!==undefined){c=b.utils.extensionmap[e].html5}else{c="video/"+e+";"}}}return d.canPlayType(c)};b.utils.downloadSupportsConfig=function(c){if(c){var e=b.utils.getFirstPlaylistItemFromConfig(c);if(typeof e.file=="undefined"&&typeof e.levels=="undefined"){return true}else{if(e.file){return b.utils.canDownload(e.file,e.provider,e.playlistfile)}else{if(e.levels&&e.levels.length){for(var d=0;d<e.levels.length;d++){if(e.levels[d].file&&b.utils.canDownload(e.levels[d].file,e.provider,e.playlistfile)){return true}}}}}}else{return true}};b.utils.canDownload=function(d,f,c){if(c){return false}var e=["image","sound","youtube","http"];if(f&&(e.toString().indexOf(f)>-1)){return true}if(!f||(f&&f=="video")){var g=b.utils.extension(d);if(g&&b.utils.extensionmap[g]){return true}}return false};b.utils.getOuterHTML=function(d){if(d.outerHTML){return d.outerHTML}else{var e=d.parentNode;var c=document.createElement(e.tagName);c.appendChild(d);var f=c.innerHTML;e.appendChild(d);return f}};b.utils.setOuterHTML=function(f,e){if(f.outerHTML){f.outerHTML=e}else{var g=document.createElement("div");g.innerHTML=e;var c=document.createRange();c.selectNodeContents(g);var d=c.extractContents();f.parentNode.insertBefore(d,f);f.parentNode.removeChild(f)}};b.utils.hasFlash=function(){return(typeof navigator.plugins!="undefined"&&typeof navigator.plugins["Shockwave Flash"]!="undefined")||(typeof window.ActiveXObject!="undefined")};b.utils.getPluginName=function(c){if(c.lastIndexOf("/")>=0){c=c.substring(c.lastIndexOf("/")+1,c.length)}if(c.lastIndexOf("-")>=0){c=c.substring(0,c.lastIndexOf("-"))}if(c.lastIndexOf(".swf")>=0){c=c.substring(0,c.lastIndexOf(".swf"))}return c};b.utils.getAbsolutePath=function(j,h){if(h===undefined){h=document.location.href}if(j===undefined){return undefined}if(a(j)){return j}var k=h.substring(0,h.indexOf("://")+3);var g=h.substring(k.length,h.indexOf("/",k.length+1));var d;if(j.indexOf("/")===0){d=j.split("/")}else{var e=h.split("?")[0];e=e.substring(k.length+g.length+1,e.lastIndexOf("/"));d=e.split("/").concat(j.split("/"))}var c=[];for(var f=0;f<d.length;f++){if(!d[f]||d[f]===undefined||d[f]=="."){continue}else{if(d[f]==".."){c.pop()}else{c.push(d[f])}}}return k+g+"/"+c.join("/")};function a(d){if(d===null){return}var e=d.indexOf("://");var c=d.indexOf("?");return(e>0&&(c<0||(c>e)))}b.utils.mapEmpty=function(c){for(var d in c){return false}return true};b.utils.mapLength=function(d){var c=0;for(var e in d){c++}return c};b.utils.log=function(d,c){if(typeof console!="undefined"&&typeof console.log!="undefined"){if(c){console.log(d,c)}else{console.log(d)}}};b.utils.css=function(d,g,c){if(d!==undefined){for(var e in g){try{if(typeof g[e]==="undefined"){continue}else{if(typeof g[e]=="number"&&!(e=="zIndex"||e=="opacity")){if(isNaN(g[e])){continue}if(e.match(/color/i)){g[e]="#"+b.utils.strings.pad(g[e].toString(16),6)}else{g[e]=Math.ceil(g[e])+"px"}}}d.style[e]=g[e]}catch(f){}}}};b.utils.isYouTube=function(c){return c.indexOf("youtube.com")>-1};b.utils.getYouTubeId=function(c){c.indexOf("youtube.com">0)};b.utils.transform=function(c,d){c.style.webkitTransform=d;c.style.MozTransform=d;c.style.OTransform=d};b.utils.stretch=function(h,m,l,f,k,g){if(typeof l=="undefined"||typeof f=="undefined"||typeof k=="undefined"||typeof g=="undefined"){return}var d=l/k;var e=f/g;var j=0;var i=0;m.style.overflow="hidden";b.utils.transform(m,"");var c={};switch(h.toLowerCase()){case b.utils.stretching.NONE:c.width=k;c.height=g;break;case b.utils.stretching.UNIFORM:if(d>e){c.width=k*e;c.height=g*e}else{c.width=k*d;c.height=g*d}break;case b.utils.stretching.FILL:if(d>e){c.width=k*d;c.height=g*d}else{c.width=k*e;c.height=g*e}break;case b.utils.stretching.EXACTFIT:b.utils.transform(m,["scale(",d,",",e,")"," translate(0px,0px)"].join(""));c.width=k;c.height=g;break;default:break}c.top=(f-c.height)/2;c.left=(l-c.width)/2;b.utils.css(m,c)};b.utils.stretching={NONE:"none",FILL:"fill",UNIFORM:"uniform",EXACTFIT:"exactfit"}})(jwplayer);(function(e){e.utils.mediaparser=function(){};var g={element:{width:"width",height:"height",id:"id","class":"className",name:"name"},media:{src:"file",preload:"preload",autoplay:"autostart",loop:"repeat",controls:"controls"},source:{src:"file",type:"type",media:"media","data-jw-width":"width","data-jw-bitrate":"bitrate"},video:{poster:"image"}};var f={};e.utils.mediaparser.parseMedia=function(i){return d(i)};function c(j,i){if(i===undefined){i=g[j]}else{e.utils.extend(i,g[j])}return i}function d(m,i){if(f[m.tagName.toLowerCase()]&&(i===undefined)){return f[m.tagName.toLowerCase()](m)}else{i=c("element",i);var n={};for(var j in i){if(j!="length"){var l=m.getAttribute(j);if(!(l===""||l===undefined||l===null)){n[i[j]]=m.getAttribute(j)}}}var k=m.style["#background-color"];if(k&&!(k=="transparent"||k=="rgba(0, 0, 0, 0)")){n.screencolor=k}return n}}function h(o,k){k=c("media",k);var m=[];if(e.utils.isIE()){var l=o.nextSibling;if(l!==undefined){while(l.tagName.toLowerCase()=="source"){m.push(a(l));l=l.nextSibling}}}else{var j=e.utils.selectors("source",o);for(var n in j){if(!isNaN(n)){m.push(a(j[n]))}}}var p=d(o,k);if(p.file!==undefined){m[0]={file:p.file}}p.levels=m;return p}function a(k,j){j=c("source",j);var i=d(k,j);i.width=i.width?i.width:0;i.bitrate=i.bitrate?i.bitrate:0;return i}function b(k,j){j=c("video",j);var i=h(k,j);return i}e.utils.mediaparser.replaceMediaElement=function(i,k){if(e.utils.isIE()){var l=false;var n=[];var m=i.nextSibling;while(m&&!l){n.push(m);if(m.nodeType==1&&m.tagName.toLowerCase()==("/")+i.tagName.toLowerCase()){l=true}m=m.nextSibling}if(l){while(n.length>0){var j=n.pop();j.parentNode.removeChild(j)}}i.outerHTML=k}};f.media=h;f.audio=h;f.source=a;f.video=b})(jwplayer);(function(a){a.utils.selectors=function(b,d){if(d===undefined){d=document}b=a.utils.strings.trim(b);var c=b.charAt(0);if(c=="#"){return d.getElementById(b.substr(1))}else{if(c=="."){if(d.getElementsByClassName){return d.getElementsByClassName(b.substr(1))}else{return a.utils.selectors.getElementsByTagAndClass("*",b.substr(1))}}else{if(b.indexOf(".")>0){selectors=b.split(".");return a.utils.selectors.getElementsByTagAndClass(selectors[0],selectors[1])}else{return d.getElementsByTagName(b)}}}return null};a.utils.selectors.getElementsByTagAndClass=function(e,h,g){elements=[];if(g===undefined){g=document}var f=g.getElementsByTagName(e);for(var d=0;d<f.length;d++){if(f[d].className!==undefined){var c=f[d].className.split(" ");for(var b=0;b<c.length;b++){if(c[b]==h){elements.push(f[d])}}}}return elements}})(jwplayer);(function(a){a.utils.strings=function(){};a.utils.strings.trim=function(b){return b.replace(/^\s*/,"").replace(/\s*$/,"")};a.utils.strings.pad=function(c,d,b){if(!b){b="0"}while(c.length<d){c=b+c}return c}})(jwplayer);(function(c){var d=new RegExp(/^(#|0x)[0-9a-fA-F]{3,6}/);c.utils.typechecker=function(g,f){f=f===null?b(g):f;return e(g,f)};function b(f){var g=["true","false","t","f"];if(g.toString().indexOf(f.toLowerCase().replace(" ",""))>=0){return"boolean"}else{if(d.test(f)){return"color"}else{if(!isNaN(parseInt(f,10))&&parseInt(f,10).toString().length==f.length){return"integer"}else{if(!isNaN(parseFloat(f))&&parseFloat(f).toString().length==f.length){return"float"}}}}return"string"}function e(g,f){if(f===null){return g}switch(f){case"color":if(g.length>0){return a(g)}return null;case"integer":return parseInt(g,10);case"float":return parseFloat(g);case"boolean":if(g.toLowerCase()=="true"){return true}else{if(g=="1"){return true}}return false}return g}function a(f){switch(f.toLowerCase()){case"blue":return parseInt("0000FF",16);case"green":return parseInt("00FF00",16);case"red":return parseInt("FF0000",16);case"cyan":return parseInt("00FFFF",16);case"magenta":return parseInt("FF00FF",16);case"yellow":return parseInt("FFFF00",16);case"black":return parseInt("000000",16);case"white":return parseInt("FFFFFF",16);default:f=f.replace(/(#|0x)?([0-9A-F]{3,6})$/gi,"$2");if(f.length==3){f=f.charAt(0)+f.charAt(0)+f.charAt(1)+f.charAt(1)+f.charAt(2)+f.charAt(2)}return parseInt(f,16)}return parseInt("000000",16)}})(jwplayer);(function(a){var b={};a.utils.animations=function(){};a.utils.animations.transform=function(c,d){c.style.webkitTransform=d;c.style.MozTransform=d;c.style.OTransform=d};a.utils.animations.transformOrigin=function(c,d){c.style.webkitTransformOrigin=d;c.style.MozTransformOrigin=d;c.style.OTransformOrigin=d};a.utils.animations.rotate=function(c,d){a.utils.animations.transform(c,["rotate(",d,"deg)"].join(""))};a.utils.cancelAnimation=function(c){delete b[c.id]};a.utils.fadeTo=function(l,f,e,i,h,d){if(b[l.id]!=d&&d!==undefined){return}var c=new Date().getTime();if(d>c){setTimeout(function(){a.utils.fadeTo(l,f,e,i,0,d)},d-c)}l.style.display="block";if(i===undefined){i=l.style.opacity===""?1:l.style.opacity}if(l.style.opacity==f&&l.style.opacity!==""&&d!==undefined){if(f===0){l.style.display="none"}return}if(d===undefined){d=c;b[l.id]=d}if(h===undefined){h=0}var j=(c-d)/(e*1000);j=j>1?1:j;var k=f-i;var g=i+(j*k);if(g>1){g=1}else{if(g<0){g=0}}l.style.opacity=g;if(h>0){b[l.id]=d+h*1000;a.utils.fadeTo(l,f,e,i,0,b[l.id]);return}setTimeout(function(){a.utils.fadeTo(l,f,e,i,0,d)},10)}})(jwplayer);(function(a){a.utils.extensionmap={"3gp":{html5:"video/3gpp",flash:"video"},"3gpp":{html5:"video/3gpp"},"3g2":{html5:"video/3gpp2",flash:"video"},"3gpp2":{html5:"video/3gpp2"},flv:{flash:"video"},f4a:{html5:"audio/mp4"},f4b:{html5:"audio/mp4",flash:"video"},f4p:{html5:"video/mp4",flash:"video"},f4v:{html5:"video/mp4",flash:"video"},mov:{html5:"video/quicktime",flash:"video"},m4a:{html5:"audio/mp4",flash:"video"},m4b:{html5:"audio/mp4"},m4p:{html5:"audio/mp4"},m4v:{html5:"video/mp4",flash:"video"},mkv:{html5:"video/x-matroska"},mp4:{html5:"video/mp4",flash:"video"},rbs:{flash:"sound"},sdp:{html5:"application/sdp",flash:"video"},vp6:{html5:"video/x-vp6"},aac:{html5:"audio/aac",flash:"video"},mp3:{flash:"sound"},ogg:{html5:"audio/ogg"},ogv:{html5:"video/ogg"},webm:{html5:"video/webm"},m3u8:{html5:"audio/x-mpegurl"},gif:{flash:"image"},jpeg:{flash:"image"},jpg:{flash:"image"},swf:{flash:"image"},png:{flash:"image"}}})(jwplayer);(function(b){var a=[];b.constructor=function(c){return b.api.selectPlayer(c)};b.api=function(){};b.api.events={API_READY:"jwplayerAPIReady",JWPLAYER_READY:"jwplayerReady",JWPLAYER_FULLSCREEN:"jwplayerFullscreen",JWPLAYER_RESIZE:"jwplayerResize",JWPLAYER_ERROR:"jwplayerError",JWPLAYER_MEDIA_BUFFER:"jwplayerMediaBuffer",JWPLAYER_MEDIA_BUFFER_FULL:"jwplayerMediaBufferFull",JWPLAYER_MEDIA_ERROR:"jwplayerMediaError",JWPLAYER_MEDIA_LOADED:"jwplayerMediaLoaded",JWPLAYER_MEDIA_COMPLETE:"jwplayerMediaComplete",JWPLAYER_MEDIA_TIME:"jwplayerMediaTime",JWPLAYER_MEDIA_VOLUME:"jwplayerMediaVolume",JWPLAYER_MEDIA_META:"jwplayerMediaMeta",JWPLAYER_MEDIA_MUTE:"jwplayerMediaMute",JWPLAYER_PLAYER_STATE:"jwplayerPlayerState",JWPLAYER_PLAYLIST_LOADED:"jwplayerPlaylistLoaded",JWPLAYER_PLAYLIST_ITEM:"jwplayerPlaylistItem"};b.api.events.state={BUFFERING:"BUFFERING",IDLE:"IDLE",PAUSED:"PAUSED",PLAYING:"PLAYING"};b.api.PlayerAPI=function(d){this.container=d;this.id=d.id;var j={};var o={};var c=[];var g=undefined;var i=false;var h=[];var m=b.utils.getOuterHTML(d);var n={};var k=0;this.setPlayer=function(p){g=p};this.stateListener=function(p,q){if(!o[p]){o[p]=[];this.eventListener(b.api.events.JWPLAYER_PLAYER_STATE,f(p))}o[p].push(q);return this};function f(p){return function(r){var q=r.newstate,t=r.oldstate;if(q==p){var s=o[q];if(s){for(var u=0;u<s.length;u++){if(typeof s[u]=="function"){s[u].call(this,{oldstate:t,newstate:q})}}}}}}this.addInternalListener=function(p,q){p.jwAddEventListener(q,'function(dat) { jwplayer("'+this.id+'").dispatchEvent("'+q+'", dat); }')};this.eventListener=function(p,q){if(!j[p]){j[p]=[];if(g&&i){this.addInternalListener(g,p)}}j[p].push(q);return this};this.dispatchEvent=function(r){if(j[r]){var q=e(r,arguments[1]);for(var p=0;p<j[r].length;p++){if(typeof j[r][p]=="function"){j[r][p].call(this,q)}}}};function e(r,p){var t=b.utils.extend({},p);if(r==b.api.events.JWPLAYER_FULLSCREEN&&!t.fullscreen){t.fullscreen=t.message=="true"?true:false;delete t.message}else{if(typeof t.data=="object"){t=b.utils.extend(t,t.data);delete t.data}}var q=["position","duration","offset"];for(var s in q){if(t[q[s]]){t[q[s]]=Math.round(t[q[s]]*1000)/1000}}return t}this.callInternal=function(q,p){if(i){if(typeof g!="undefined"&&typeof g[q]=="function"){if(p!==undefined){return(g[q])(p)}else{return(g[q])()}}return null}else{h.push({method:q,parameters:p})}};this.playerReady=function(r){i=true;if(!g){this.setPlayer(document.getElementById(r.id))}this.container=document.getElementById(this.id);for(var p in j){this.addInternalListener(g,p)}this.eventListener(b.api.events.JWPLAYER_PLAYLIST_ITEM,function(s){if(s.index!==undefined){k=s.index}n={}});this.eventListener(b.api.events.JWPLAYER_MEDIA_META,function(s){b.utils.extend(n,s.metadata)});this.dispatchEvent(b.api.events.API_READY);while(h.length>0){var q=h.shift();this.callInternal(q.method,q.parameters)}};this.getItemMeta=function(){return n};this.getCurrentItem=function(){return k};this.destroy=function(){j={};h=[];if(b.utils.getOuterHTML(this.container)!=m){b.api.destroyPlayer(this.id,m)}};function l(r,t,s){var p=[];if(!t){t=0}if(!s){s=r.length-1}for(var q=t;q<=s;q++){p.push(r[q])}return p}};b.api.PlayerAPI.prototype={container:undefined,options:undefined,id:undefined,getBuffer:function(){return this.callInternal("jwGetBuffer")},getDuration:function(){return this.callInternal("jwGetDuration")},getFullscreen:function(){return this.callInternal("jwGetFullscreen")},getHeight:function(){return this.callInternal("jwGetHeight")},getLockState:function(){return this.callInternal("jwGetLockState")},getMeta:function(){return this.getItemMeta()},getMute:function(){return this.callInternal("jwGetMute")},getPlaylist:function(){var d=this.callInternal("jwGetPlaylist");for(var c=0;c<d.length;c++){if(d[c].index===undefined){d[c].index=c}}return d},getPlaylistItem:function(c){if(c===undefined){c=this.getCurrentItem()}return this.getPlaylist()[c]},getPosition:function(){return this.callInternal("jwGetPosition")},getState:function(){return this.callInternal("jwGetState")},getVolume:function(){return this.callInternal("jwGetVolume")},getWidth:function(){return this.callInternal("jwGetWidth")},setFullscreen:function(c){if(c===undefined){this.callInternal("jwSetFullscreen",!this.callInternal("jwGetFullscreen"))}else{this.callInternal("jwSetFullscreen",c)}return this},setMute:function(c){if(c===undefined){this.callInternal("jwSetMute",!this.callInternal("jwGetMute"))}else{this.callInternal("jwSetMute",c)}return this},lock:function(){return this},unlock:function(){return this},load:function(c){this.callInternal("jwLoad",c);return this},playlistItem:function(c){this.callInternal("jwPlaylistItem",c);return this},playlistPrev:function(){this.callInternal("jwPlaylistPrev");return this},playlistNext:function(){this.callInternal("jwPlaylistNext");return this},resize:function(d,c){this.container.width=d;this.container.height=c;return this},play:function(c){if(typeof c=="undefined"){c=this.getState();if(c==b.api.events.state.PLAYING||c==b.api.events.state.BUFFERING){this.callInternal("jwPause")}else{this.callInternal("jwPlay")}}else{this.callInternal("jwPlay",c)}return this},pause:function(c){if(typeof c=="undefined"){c=this.getState();if(c==b.api.events.state.PLAYING||c==b.api.events.state.BUFFERING){this.callInternal("jwPause")}else{this.callInternal("jwPlay")}}else{this.callInternal("jwPause",c)}return this},stop:function(){this.callInternal("jwStop");return this},seek:function(c){this.callInternal("jwSeek",c);return this},setVolume:function(c){this.callInternal("jwSetVolume",c);return this},onBufferChange:function(c){return this.eventListener(b.api.events.JWPLAYER_MEDIA_BUFFER,c)},onBufferFull:function(c){return this.eventListener(b.api.events.JWPLAYER_MEDIA_BUFFER_FULL,c)},onError:function(c){return this.eventListener(b.api.events.JWPLAYER_ERROR,c)},onFullscreen:function(c){return this.eventListener(b.api.events.JWPLAYER_FULLSCREEN,c)},onMeta:function(c){return this.eventListener(b.api.events.JWPLAYER_MEDIA_META,c)},onMute:function(c){return this.eventListener(b.api.events.JWPLAYER_MEDIA_MUTE,c)},onPlaylist:function(c){return this.eventListener(b.api.events.JWPLAYER_PLAYLIST_LOADED,c)},onPlaylistItem:function(c){return this.eventListener(b.api.events.JWPLAYER_PLAYLIST_ITEM,c)},onReady:function(c){return this.eventListener(b.api.events.API_READY,c)},onResize:function(c){return this.eventListener(b.api.events.JWPLAYER_RESIZE,c)},onComplete:function(c){return this.eventListener(b.api.events.JWPLAYER_MEDIA_COMPLETE,c)},onTime:function(c){return this.eventListener(b.api.events.JWPLAYER_MEDIA_TIME,c)},onVolume:function(c){return this.eventListener(b.api.events.JWPLAYER_MEDIA_VOLUME,c)},onBuffer:function(c){return this.stateListener(b.api.events.state.BUFFERING,c)},onPause:function(c){return this.stateListener(b.api.events.state.PAUSED,c)},onPlay:function(c){return this.stateListener(b.api.events.state.PLAYING,c)},onIdle:function(c){return this.stateListener(b.api.events.state.IDLE,c)},setup:function(c){return this},remove:function(){this.destroy()},initializePlugin:function(c,d){return this}};b.api.selectPlayer=function(d){var c;if(d===undefined){d=0}if(d.nodeType){c=d}else{if(typeof d=="string"){c=document.getElementById(d)}}if(c){var e=b.api.playerById(c.id);if(e){return e}else{return b.api.addPlayer(new b.api.PlayerAPI(c))}}else{if(typeof d=="number"){return b.getPlayers()[d]}}return null};b.api.playerById=function(d){for(var c=0;c<a.length;c++){if(a[c].id==d){return a[c]}}return null};b.api.addPlayer=function(c){for(var d=0;d<a.length;d++){if(a[d]==c){return c}}a.push(c);return c};b.api.destroyPlayer=function(f,d){var e=-1;for(var h=0;h<a.length;h++){if(a[h].id==f){e=h;continue}}if(e>=0){var c=document.getElementById(a[e].id);if(c){if(d){b.utils.setOuterHTML(c,d)}else{var g=document.createElement("div");g.setAttribute("id",c.id);c.parentNode.replaceChild(g,c)}}a.splice(e,1)}return null};b.getPlayers=function(){return a.slice(0)}})(jwplayer);var _userPlayerReady=(typeof playerReady=="function")?playerReady:undefined;playerReady=function(b){var a=jwplayer.api.playerById(b.id);if(a){a.playerReady(b)}if(_userPlayerReady){_userPlayerReady.call(this,b)}};(function(a){a.embed=function(){};a.embed.Embedder=function(d){this.constructor(d)};function c(){return[{type:"flash",src:"player.swf"},{type:"html5"},{type:"download"}]}a.embed.defaults={width:400,height:300,players:c(),components:{controlbar:{position:"over"}}};a.embed.Embedder.prototype={config:undefined,api:undefined,events:{},players:undefined,constructor:function(e){this.api=e;var d=a.utils.mediaparser.parseMedia(this.api.container);this.config=this.parseConfig(a.utils.extend({},a.embed.defaults,d,this.api.config))},embedPlayer:function(){var e=this.players[0];if(e&&e.type){switch(e.type){case"flash":if(a.utils.flashSupportsConfig(this.config)){if(this.config.file&&!this.config.provider){switch(a.utils.extension(this.config.file).toLowerCase()){case"webm":case"ogv":case"ogg":this.config.provider="video";break}}if(this.config.levels||this.config.playlist){this.api.onReady(this.loadAfterReady(this.config))}this.config.id=this.api.id;var j=a.embed.embedFlash(document.getElementById(this.api.id),e,this.config);this.api.container=j;this.api.setPlayer(j)}else{this.players.splice(0,1);return this.embedPlayer()}break;case"html5":if(a.utils.html5SupportsConfig(this.config)){var g=a.embed.embedHTML5(document.getElementById(this.api.id),e,this.config);this.api.container=document.getElementById(this.api.id);this.api.setPlayer(g)}else{this.players.splice(0,1);return this.embedPlayer()}break;case"download":if(a.utils.downloadSupportsConfig(this.config)){var f=a.utils.getFirstPlaylistItemFromConfig(this.config);var d=a.embed.embedDownloadLink(document.getElementById(this.api.id),e,this.config);this.api.container=document.getElementById(this.api.id);this.api.setPlayer(d)}else{this.players.splice(0,1);return this.embedPlayer()}break}}else{var i=document.createElement("div");this.api.container.appendChild(i);i.style.position="relative";var h=document.createElement("p");i.appendChild(h);h.innerHTML="No suitable players found";a.embed.embedLogo(a.utils.extend({position:"bottom-right",margin:0},this.config.components.logo),"none",i,this.api.id)}this.setupEvents();return this.api},setupEvents:function(){for(var d in this.events){if(typeof this.api[d]=="function"){(this.api[d]).call(this.api,this.events[d])}}},loadAfterReady:function(d){return function(f){if(d.playlist){this.load(d.playlist)}else{if(d.levels){var e=this.getPlaylistItem(0);if(!e){e=d}if(!e.image){e.image=d.image}if(!e.levels){e.levels=d.levels}this.load(e)}}}},parseConfig:function(d){var h=a.utils.extend({},d);for(var e in h){if(e.indexOf(".")>-1){var g=e.split(".");for(var f in g){if(f==g.length-1){d[g[f]]=h[e]}else{if(d[g[f]]===undefined){d[g[f]]={}}d=d[g[f]]}}}}if(typeof h.playlist=="string"){if(!h.components.playlist){h.components.playlist={}}h.components.playlist.position=h.playlist;delete h.playlist}if(typeof h.controlbar=="string"){if(!h.components.controlbar){h.components.controlbar={}}h.components.controlbar.position=h.controlbar;delete h.controlbar}if(h.events){this.events=h.events;delete h.events}if(h.players){this.players=h.players;delete h.players}if(h.plugins){if(typeof h.plugins=="object"){h=a.utils.extend(h,a.embed.parsePlugins(h.plugins))}}if(h.components){if(typeof h.plugins=="object"){h=a.utils.extend(h,a.embed.parseComponents(h.components))}}return h}};a.embed.embedFlash=function(f,h,k){var g=a.utils.extend({},k);var d=g.width;delete g.width;var l=g.height;delete g.height;delete g.levels;delete g.playlist;var e="opaque";if(g.wmode){e=g.wmode}a.embed.parseConfigBlock(g,"components");a.embed.parseConfigBlock(g,"providers");if(a.utils.isIE()){var j='<object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" width="'+d+'" height="'+l+'" id="'+f.id+'" name="'+f.id+'">';j+='<param name="movie" value="'+h.src+'">';j+='<param name="allowfullscreen" value="true">';j+='<param name="allowscriptaccess" value="always">';j+='<param name="wmode" value="'+e+'">';j+='<param name="flashvars" value="'+a.embed.jsonToFlashvars(g)+'">';j+="</object>";if(f.tagName.toLowerCase()=="video"){a.utils.mediaparser.replaceMediaElement(f,j)}else{f.outerHTML=j}return document.getElementById(f.id)}else{var i=document.createElement("object");i.setAttribute("type","application/x-shockwave-flash");i.setAttribute("data",h.src);i.setAttribute("width",d);i.setAttribute("height",l);i.setAttribute("id",f.id);i.setAttribute("name",f.id);a.embed.appendAttribute(i,"allowfullscreen","true");a.embed.appendAttribute(i,"allowscriptaccess","always");a.embed.appendAttribute(i,"wmode",e);a.embed.appendAttribute(i,"flashvars",a.embed.jsonToFlashvars(g));f.parentNode.replaceChild(i,f);return i}};a.embed.embedHTML5=function(e,g,f){if(a.html5){e.innerHTML="";var d=a.utils.extend({screencolor:"0x000000"},f);a.embed.parseConfigBlock(d,"components");if(d.levels&&!d.sources){d.sources=f.levels}if(d.skin&&d.skin.toLowerCase().indexOf(".zip")>0){d.skin=d.skin.replace(/\.zip/i,".xml")}return new (a.html5(e)).setup(d)}else{return null}};a.embed.embedLogo=function(o,n,e,g){var l={prefix:"",file:"",link:"",margin:8,out:0.5,over:1,timeout:3,hide:false,position:"bottom-left"};_css=a.utils.css;var d;var k;m();function m(){q();f();i()}function q(){if(l.prefix){var s=a.version.split(/\W/).splice(0,2).join("/");if(l.prefix.indexOf(s)<0){l.prefix+=s+"/"}}k=a.utils.extend({},l,o)}function r(){var u={border:"none",textDecoration:"none",position:"absolute",cursor:"pointer",zIndex:10};u.display=k.hide?"none":"block";var t=k.position.toLowerCase().split("-");for(var s in t){u[t[s]]=k.margin}return u}function f(){d=document.createElement("img");d.id=g+"_jwplayer_logo";d.style.display="none";d.onload=function(s){_css(d,r());h()};if(!k.file){return}if(k.file.indexOf("http://")===0){d.src=k.file}else{d.src=k.prefix+k.file}}if(!k.file){return}function i(){if(k.link){d.onmouseover=j;d.onmouseout=h;d.onclick=p}else{this.mouseEnabled=false}}function p(s){if(typeof s!="undefined"){s.preventDefault();s.stopPropagation()}if(k.link){window.open(k.link,"_blank")}return}function h(s){if(k.link){d.style.opacity=k.out}return}function j(s){if(k.hide){d.style.opacity=k.over}return}e.appendChild(d)};a.embed.embedDownloadLink=function(e,h,o){var g=a.utils.extend({},o);var n={};var f=o.width?o.width:480;if(typeof f!="number"){f=parseInt(f,10)}var k=o.height?o.height:320;if(typeof k!="number"){k=parseInt(k,10)}var q,l,j;var p={};if(o.playlist&&o.playlist.length){p.file=o.playlist[0].file;l=o.playlist[0].image;p.levels=o.playlist[0].levels}else{p.file=o.file;l=o.image;p.levels=o.levels}if(p.file){q=p.file}else{if(p.levels&&p.levels.length){q=p.levels[0].file}}j=q?"pointer":"auto";var i={display:{style:{cursor:j,width:f,height:k,backgroundColor:"#000",position:"relative",textDecoration:"none",border:"none",display:"block"}},display_icon:{style:{cursor:j,position:"absolute",display:q?"block":"none",top:0,left:0,border:0,margin:0,padding:0,zIndex:3,width:50,height:50,backgroundImage:"url(data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAADIAAAAyCAYAAAAeP4ixAAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJbWFnZVJlYWR5ccllPAAAALdJREFUeNrs18ENgjAYhmFouDOCcQJGcARHgE10BDcgTOIosAGwQOuPwaQeuFRi2p/3Sb6EC5L3QCxZBgAAAOCorLW1zMn65TrlkH4NcV7QNcUQt7Gn7KIhxA+qNIR81spOGkL8oFJDyLJRdosqKDDkK+iX5+d7huzwM40xptMQMkjIOeRGo+VkEVvIPfTGIpKASfYIfT9iCHkHrBEzf4gcUQ56aEzuGK/mw0rHpy4AAACAf3kJMACBxjAQNRckhwAAAABJRU5ErkJggg==)"}},display_iconBackground:{style:{cursor:j,position:"absolute",display:q?"block":"none",top:((k-50)/2),left:((f-50)/2),border:0,width:50,height:50,margin:0,padding:0,zIndex:2,backgroundImage:"url(data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAADIAAAAyCAYAAAAeP4ixAAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJbWFnZVJlYWR5ccllPAAAAEpJREFUeNrszwENADAIA7DhX8ENoBMZ5KR10EryckCJiIiIiIiIiIiIiIiIiIiIiIh8GmkRERERERERERERERERERERERGRHSPAAPlXH1phYpYaAAAAAElFTkSuQmCC)"}},display_image:{style:{width:f,height:k,display:l?"block":"none",position:"absolute",cursor:j,left:0,top:0,margin:0,padding:0,textDecoration:"none",zIndex:1,border:"none"}}};var d=function(r,t,u){var s=document.createElement(r);if(u){s.id=u}else{s.id=e.id+"_jwplayer_"+t}a.utils.css(s,i[t].style);return s};n.display=d("a","display",e.id);if(q){n.display.setAttribute("href",a.utils.getAbsolutePath(q))}n.display_image=d("img","display_image");n.display_image.setAttribute("alt","Click to download...");if(l){n.display_image.setAttribute("src",a.utils.getAbsolutePath(l))}if(true){n.display_icon=d("div","display_icon");n.display_iconBackground=d("div","display_iconBackground");n.display.appendChild(n.display_image);n.display_iconBackground.appendChild(n.display_icon);n.display.appendChild(n.display_iconBackground)}e.parentNode.replaceChild(n.display,e);var m=(o.plugins&&o.plugins.logo)?o.plugins.logo:{};a.embed.embedLogo(o.components.logo,"download",n.display,e.id);return n.display};a.embed.appendAttribute=function(e,d,f){var g=document.createElement("param");g.setAttribute("name",d);g.setAttribute("value",f);e.appendChild(g)};a.embed.jsonToFlashvars=function(f){var d=f.netstreambasepath?"":"netstreambasepath="+escape(window.location.href)+"&";for(var e in f){d+=e+"="+escape(f[e])+"&"}return d.substring(0,d.length-1)};a.embed.parsePlugins=function(g){if(!g){return{}}var j={},i=[];for(var d in g){var f=a.utils.getPluginName(d);var e=g[d];i.push(d);for(var h in e){j[f+"."+h]=e[h]}}j.plugins=i.join(",");return j};a.embed.parseComponents=function(f){if(!f){return{}}var h={};for(var e in f){var d=f[e];for(var g in d){h[e+"."+g]=d[g]}}return h};a.embed.parseConfigBlock=function(g,f){if(g[f]){var i=g[f];for(var e in i){var d=i[e];if(typeof d=="string"){if(!g[e]){g[e]=d}}else{for(var h in d){if(!g[e+"."+h]){g[e+"."+h]=d[h]}}}}delete g[f]}};a.api.PlayerAPI.prototype.setup=function(e,f){if(e&&e.flashplayer&&!e.players){e.players=c();e.players[0].src=e.flashplayer;delete e.flashplayer}if(f&&!e.players){if(typeof f=="string"){e.players=c();e.players[0].src=f}else{if(f instanceof Array){e.players=f}else{if(typeof f=="object"&&f.type){e.players=[f]}}}}var d=this.id;this.remove();var g=a(d);g.config=e;return(new a.embed.Embedder(g)).embedPlayer()};function b(){if(!document.body){return setTimeout(b,15)}var d=a.utils.selectors.getElementsByTagAndClass("video","jwplayer");for(var e=0;e<d.length;e++){var f=d[e];a(f.id).setup({players:[{type:"flash",src:"/jwplayer/player.swf"},{type:"html5"}]})}}b()})(jwplayer);(function(a){a.html5=function(b){var c=b;this.setup=function(d){a.utils.extend(this,new a.html5.api(c,d));return this};return this}})(jwplayer);(function(b){var c=b.utils.css;b.html5.view=function(q,o,e){var t=q;var l=o;var w=e;var v;var f;var A;var r;var B;var n;function y(){v=document.createElement("div");v.id=l.id;v.className=l.className;l.id=v.id+"_video";c(v,{position:"relative",height:w.height,width:w.width,padding:0,backgroundColor:C(),zIndex:0});function C(){if(t.skin.getComponentSettings("display")&&t.skin.getComponentSettings("display").backgroundcolor){return t.skin.getComponentSettings("display").backgroundcolor}return parseInt("000000",16)}c(l,{position:"absolute",width:w.width,height:w.height,top:0,left:0,zIndex:1,margin:"auto",display:"block"});b.utils.wrap(l,v);r=document.createElement("div");r.id=v.id+"_displayarea";v.appendChild(r)}function j(){for(var C=0;C<w.plugins.order.length;C++){var D=w.plugins.order[C];if(w.plugins.object[D].getDisplayElement!==undefined){w.plugins.object[D].height=h(w.plugins.object[D].getDisplayElement().style.height);w.plugins.object[D].width=h(w.plugins.object[D].getDisplayElement().style.width);w.plugins.config[D].currentPosition=w.plugins.config[D].position}}u()}function u(D){if(w.getMedia()!==undefined){for(var C=0;C<w.plugins.order.length;C++){var E=w.plugins.order[C];if(w.plugins.object[E].getDisplayElement!==undefined){if(w.getMedia().hasChrome()){w.plugins.config[E].currentPosition=b.html5.view.positions.NONE}else{w.plugins.config[E].currentPosition=w.plugins.config[E].position}}}}i(w.width,w.height)}function h(C){if(typeof C=="string"){if(C===""){return 0}else{if(C.lastIndexOf("%")>-1){return C}else{return parseInt(C.replace("px",""),10)}}}return C}function p(){n=setInterval(function(){if((typeof w.width=="string"&&w.width.lastIndexOf("%")>-1)||(typeof w.height=="string"&&w.height.lastIndexOf("%")>-1)){return}if(v.width&&v.height&&(w.width!==h(v.width)||w.height!==h(v.height))){i(h(v.width),h(v.height))}else{var C=v.getBoundingClientRect();if(w.width!==C.width||w.height!==C.height){i(C.width,C.height)}delete C}},100)}this.setup=function(C){l=C;y();j();t.jwAddEventListener(b.api.events.JWPLAYER_MEDIA_LOADED,u);t.jwAddEventListener(b.api.events.JWPLAYER_MEDIA_META,function(){x()});p();var D;if(window.onresize!==null){D=window.onresize}window.onresize=function(E){if(D!==undefined){try{D(E)}catch(G){}}if(t.jwGetFullscreen()){var F=document.body.getBoundingClientRect();w.width=Math.abs(F.left)+Math.abs(F.right);w.height=window.innerHeight}i(w.width,w.height)}};function g(C){switch(C.keyCode){case 27:if(t.jwGetFullscreen()){t.jwSetFullscreen(false)}break;case 32:if(t.jwGetState()!=b.api.events.state.IDLE&&t.jwGetState()!=b.api.events.state.PAUSED){t.jwPause()}else{t.jwPlay()}break}}function i(F,C){if(v.style.display=="none"){return}var E=[].concat(w.plugins.order);E.reverse();B=E.length+2;if(!w.fullscreen){w.width=F;w.height=C;f=F;A=C;c(r,{top:0,bottom:0,left:0,right:0,width:F,height:C});c(v,{height:A,width:f});var D=m(s,E);if(D.length>0){B+=D.length;m(k,D,true)}}else{m(z,E,true)}x()}function m(H,E,F){var D=[];for(var C=0;C<E.length;C++){var I=E[C];if(w.plugins.object[I].getDisplayElement!==undefined){if(w.plugins.config[I].currentPosition.toUpperCase()!==b.html5.view.positions.NONE){var G=H(I,B--);if(!G){D.push(I)}else{w.plugins.object[I].resize(G.width,G.height);if(F){delete G.width;delete G.height}c(w.plugins.object[I].getDisplayElement(),G)}}else{c(w.plugins.object[I].getDisplayElement(),{display:"none"})}}}return D}function s(D,E){if(w.plugins.object[D].getDisplayElement!==undefined){if(a(w.plugins.config[D].position)){if(w.plugins.object[D].getDisplayElement().parentNode===null){v.appendChild(w.plugins.object[D].getDisplayElement())}var C=d(D);C.zIndex=E;return C}}return false}function k(E,F){if(w.plugins.object[E].getDisplayElement().parentNode===null){r.appendChild(w.plugins.object[E].getDisplayElement())}var C=w.width,D=w.height;if(typeof w.width=="string"&&w.width.lastIndexOf("%")>-1){percentage=parseFloat(w.width.substring(0,w.width.lastIndexOf("%")))/100;C=Math.round(window.innerWidth*percentage)}if(typeof w.height=="string"&&w.height.lastIndexOf("%")>-1){percentage=parseFloat(w.height.substring(0,w.height.lastIndexOf("%")))/100;D=Math.round(window.innerHeight*percentage)}return{position:"absolute",width:(C-h(r.style.left)-h(r.style.right)),height:(D-h(r.style.top)-h(r.style.bottom)),zIndex:F}}function z(C,D){return{position:"fixed",width:w.width,height:w.height,zIndex:D}}function x(){r.style.position="absolute";w.getMedia().getDisplayElement().style.position="absolute";if(w.getMedia().getDisplayElement().videoWidth==0||w.getMedia().getDisplayElement().videoHeight==0){return}var C,E;if(r.style.width.toString().lastIndexOf("%")>-1||r.style.width.toString().lastIndexOf("%")>-1){var D=r.getBoundingClientRect();C=Math.abs(D.left)+Math.abs(D.right);E=Math.abs(D.top)+Math.abs(D.bottom)}else{C=h(r.style.width);E=h(r.style.height)}b.utils.stretch(t.jwGetStretching(),w.getMedia().getDisplayElement(),C,E,w.getMedia().getDisplayElement().videoWidth,w.getMedia().getDisplayElement().videoHeight)}function d(D){var E={position:"absolute",margin:0,padding:0,top:null};var C=w.plugins.config[D].currentPosition.toLowerCase();switch(C.toUpperCase()){case b.html5.view.positions.TOP:E.top=h(r.style.top);E.left=h(r.style.left);E.width=f-h(r.style.left)-h(r.style.right);E.height=w.plugins.object[D].height;r.style[C]=h(r.style[C])+w.plugins.object[D].height+"px";r.style.height=h(r.style.height)-E.height+"px";break;case b.html5.view.positions.RIGHT:E.top=h(r.style.top);E.right=h(r.style.right);E.width=E.width=w.plugins.object[D].width;E.height=A-h(r.style.top)-h(r.style.bottom);r.style[C]=h(r.style[C])+w.plugins.object[D].width+"px";r.style.width=h(r.style.width)-E.width+"px";break;case b.html5.view.positions.BOTTOM:E.bottom=h(r.style.bottom);E.left=h(r.style.left);E.width=f-h(r.style.left)-h(r.style.right);E.height=w.plugins.object[D].height;r.style[C]=h(r.style[C])+w.plugins.object[D].height+"px";r.style.height=h(r.style.height)-E.height+"px";break;case b.html5.view.positions.LEFT:E.top=h(r.style.top);E.left=h(r.style.left);E.width=w.plugins.object[D].width;E.height=A-h(r.style.top)-h(r.style.bottom);r.style[C]=h(r.style[C])+w.plugins.object[D].width+"px";r.style.width=h(r.style.width)-E.width+"px";break;default:break}return E}this.resize=i;this.fullscreen=function(E){if(navigator.vendor.indexOf("Apple")===0){if(w.getMedia().getDisplayElement().webkitSupportsFullscreen){if(E){w.fullscreen=false;w.getMedia().getDisplayElement().webkitEnterFullscreen()}else{w.getMedia().getDisplayElement().webkitExitFullscreen()}}else{w.fullscreen=false}}else{if(E){document.onkeydown=g;clearInterval(n);var D=document.body.getBoundingClientRect();w.width=Math.abs(D.left)+Math.abs(D.right);w.height=window.innerHeight;var C={position:"fixed",width:"100%",height:"100%",top:0,left:0,zIndex:2147483000};c(v,C);C.zIndex=1;c(w.getMedia().getDisplayElement(),C);C.zIndex=2;c(r,C)}else{document.onkeydown="";p();w.width=f;w.height=A;c(v,{position:"relative",height:w.height,width:w.width,zIndex:0})}i(w.width,w.height)}}};function a(d){return([b.html5.view.positions.TOP,b.html5.view.positions.RIGHT,b.html5.view.positions.BOTTOM,b.html5.view.positions.LEFT].toString().indexOf(d.toUpperCase())>-1)}b.html5.view.positions={TOP:"TOP",RIGHT:"RIGHT",BOTTOM:"BOTTOM",LEFT:"LEFT",OVER:"OVER",NONE:"NONE"}})(jwplayer);(function(a){var b={backgroundcolor:"",margin:10,font:"Arial,sans-serif",fontsize:10,fontcolor:parseInt("000000",16),fontstyle:"normal",fontweight:"bold",buttoncolor:parseInt("ffffff",16),position:a.html5.view.positions.BOTTOM,idlehide:false,layout:{left:{position:"left",elements:[{name:"play",type:"button"},{name:"divider",type:"divider"},{name:"prev",type:"button"},{name:"divider",type:"divider"},{name:"next",type:"button"},{name:"divider",type:"divider"},{name:"elapsed",type:"text"}]},center:{position:"center",elements:[{name:"time",type:"slider"}]},right:{position:"right",elements:[{name:"duration",type:"text"},{name:"blank",type:"button"},{name:"divider",type:"divider"},{name:"mute",type:"button"},{name:"volume",type:"slider"},{name:"divider",type:"divider"},{name:"fullscreen",type:"button"}]}}};_css=a.utils.css;_hide=function(c){_css(c,{display:"none"})};_show=function(c){_css(c,{display:"block"})};a.html5.controlbar=function(j,L){var i=j;var A=a.utils.extend({},b,i.skin.getComponentSettings("controlbar"),L);if(a.utils.mapLength(i.skin.getComponentLayout("controlbar"))>0){A.layout=i.skin.getComponentLayout("controlbar")}var P;var I;var O;var B;var t="none";var f;var h;var Q;var e;var d;var w;var s;var J={};var n=false;var c={};function H(){O=0;B=0;I=0;if(!n){var V={height:i.skin.getSkinElement("controlbar","background").height,backgroundColor:A.backgroundcolor};P=document.createElement("div");P.id=i.id+"_jwplayer_controlbar";_css(P,V)}v("capLeft","left",false,P);var W={position:"absolute",height:i.skin.getSkinElement("controlbar","background").height,background:" url("+i.skin.getSkinElement("controlbar","background").src+") repeat-x center left",left:i.skin.getSkinElement("controlbar","capLeft").width};N("elements",P,W);v("capRight","right",false,P)}this.getDisplayElement=function(){return P};this.resize=function(X,V){a.utils.cancelAnimation(P);document.getElementById(i.id).onmousemove=x;d=X;w=V;x();var W=u();D({id:i.id,duration:Q,position:h});r({id:i.id,bufferPercent:e});return W};function o(){var W=["timeSlider","volumeSlider","timeSliderRail","volumeSliderRail"];for(var X in W){var V=W[X];if(typeof J[V]!="undefined"){c[V]=J[V].getBoundingClientRect()}}}function x(){a.utils.cancelAnimation(P);if(g()){a.utils.fadeTo(P,1,0,1,0)}else{a.utils.fadeTo(P,0,0.1,1,2)}}function g(){if(i.jwGetState()==a.api.events.state.IDLE||i.jwGetState()==a.api.events.state.PAUSED){if(A.idlehide){return false}return true}if(i.jwGetFullscreen()){return false}if(A.position.toUpperCase()==a.html5.view.positions.OVER){return false}return true}function N(Y,X,W){var V;if(!n){V=document.createElement("div");J[Y]=V;V.id=P.id+"_"+Y;X.appendChild(V)}else{V=document.getElementById(P.id+"_"+Y)}if(W!==undefined){_css(V,W)}return V}function G(){U(A.layout.left);U(A.layout.right,-1);U(A.layout.center)}function U(Y,V){var Z=Y.position=="right"?"right":"left";var X=a.utils.extend([],Y.elements);if(V!==undefined){X.reverse()}for(var W=0;W<X.length;W++){z(X[W],Z)}}function E(){return I++}function z(Z,ab){var Y,W,X,V,ad;switch(Z.name){case"play":v("playButton",ab,false);v("pauseButton",ab,true);K("playButton","jwPlay");K("pauseButton","jwPause");break;case"divider":v("divider"+E(),ab,true);break;case"prev":v("prevButton",ab,true);K("prevButton","jwPlaylistPrev");break;case"next":v("nextButton",ab,true);K("nextButton","jwPlaylistNext");break;case"elapsed":v("elapsedText",ab,true);break;case"time":W=i.skin.getSkinElement("controlbar","timeSliderCapLeft")===undefined?0:i.skin.getSkinElement("controlbar","timeSliderCapLeft").width;X=i.skin.getSkinElement("controlbar","timeSliderCapRight")===undefined?0:i.skin.getSkinElement("controlbar","timeSliderCapRight").width;Y=ab=="left"?W:X;V=i.skin.getSkinElement("controlbar","timeSliderRail").width+W+X;ad={height:i.skin.getSkinElement("controlbar","background").height,position:"absolute",top:0,width:V};ad[ab]=ab=="left"?O:B;var aa=N("timeSlider",J.elements,ad);v("timeSliderCapLeft",ab,true,aa,ab=="left"?0:Y);v("timeSliderRail",ab,false,aa,Y);v("timeSliderBuffer",ab,false,aa,Y);v("timeSliderProgress",ab,false,aa,Y);v("timeSliderThumb",ab,false,aa,Y);v("timeSliderCapRight",ab,true,aa,ab=="right"?0:Y);M("time");break;case"fullscreen":v("fullscreenButton",ab,false);v("normalscreenButton",ab,true);K("fullscreenButton","jwSetFullscreen",true);K("normalscreenButton","jwSetFullscreen",false);break;case"volume":W=i.skin.getSkinElement("controlbar","volumeSliderCapLeft")===undefined?0:i.skin.getSkinElement("controlbar","volumeSliderCapLeft").width;X=i.skin.getSkinElement("controlbar","volumeSliderCapRight")===undefined?0:i.skin.getSkinElement("controlbar","volumeSliderCapRight").width;Y=ab=="left"?W:X;V=i.skin.getSkinElement("controlbar","volumeSliderRail").width+W+X;ad={height:i.skin.getSkinElement("controlbar","background").height,position:"absolute",top:0,width:V};ad[ab]=ab=="left"?O:B;var ac=N("volumeSlider",J.elements,ad);v("volumeSliderCapLeft",ab,true,ac,ab=="left"?0:Y);v("volumeSliderRail",ab,true,ac,Y);v("volumeSliderProgress",ab,false,ac,Y);v("volumeSliderCapRight",ab,true,ac,ab=="right"?0:Y);M("volume");break;case"mute":v("muteButton",ab,false);v("unmuteButton",ab,true);K("muteButton","jwSetMute",true);K("unmuteButton","jwSetMute",false);break;case"duration":v("durationText",ab,true);break}}function v(Y,ac,ab,Z,V){if((i.skin.getSkinElement("controlbar",Y)!==undefined||Y.indexOf("Text")>0||Y.indexOf("divider")===0)&&!(Y.indexOf("divider")===0&&s.indexOf("divider")===0)){s=Y;var X={height:i.skin.getSkinElement("controlbar","background").height,position:"absolute",display:"block",top:0};if((Y.indexOf("next")===0||Y.indexOf("prev")===0)&&i.jwGetPlaylist().length<2){ab=false;X.display="none"}var aa;if(Y.indexOf("Text")>0){Y.innerhtml="00:00";X.font=A.fontsize+"px/"+(i.skin.getSkinElement("controlbar","background").height+1)+"px "+A.font;X.color=A.fontcolor;X.textAlign="center";X.fontWeight=A.fontweight;X.fontStyle=A.fontstyle;X.cursor="default";aa=14+3*A.fontsize}else{if(Y.indexOf("divider")===0){X.background="url("+i.skin.getSkinElement("controlbar","divider").src+") repeat-x center left";aa=i.skin.getSkinElement("controlbar","divider").width}else{X.background="url("+i.skin.getSkinElement("controlbar",Y).src+") repeat-x center left";aa=i.skin.getSkinElement("controlbar",Y).width}}if(ac=="left"){X.left=V===undefined?O:V;if(ab){O+=aa}}else{if(ac=="right"){X.right=V===undefined?B:V;if(ab){B+=aa}}}if(Z===undefined){Z=J.elements}X.width=aa;if(n){_css(J[Y],X)}else{var W=N(Y,Z,X);if(i.skin.getSkinElement("controlbar",Y+"Over")!==undefined){W.onmouseover=function(ad){W.style.backgroundImage=["url(",i.skin.getSkinElement("controlbar",Y+"Over").src,")"].join("")};W.onmouseout=function(ad){W.style.backgroundImage=["url(",i.skin.getSkinElement("controlbar",Y).src,")"].join("")}}}}}function C(){i.jwAddEventListener(a.api.events.JWPLAYER_PLAYLIST_LOADED,y);i.jwAddEventListener(a.api.events.JWPLAYER_MEDIA_BUFFER,r);i.jwAddEventListener(a.api.events.JWPLAYER_PLAYER_STATE,p);i.jwAddEventListener(a.api.events.JWPLAYER_MEDIA_TIME,D);i.jwAddEventListener(a.api.events.JWPLAYER_MEDIA_MUTE,T);i.jwAddEventListener(a.api.events.JWPLAYER_MEDIA_VOLUME,k);i.jwAddEventListener(a.api.events.JWPLAYER_MEDIA_COMPLETE,F)}function y(){H();G();u();R()}function R(){D({id:i.id,duration:i.jwGetDuration(),position:0});r({id:i.id,bufferProgress:0});T({id:i.id,mute:i.jwGetMute()});p({id:i.id,newstate:a.api.events.state.IDLE});k({id:i.id,volume:i.jwGetVolume()})}function K(X,Y,W){if(n){return}if(i.skin.getSkinElement("controlbar",X)!==undefined){var V=J[X];if(V!==null){_css(V,{cursor:"pointer"});if(Y=="fullscreen"){V.onmouseup=function(Z){Z.stopPropagation();i.jwSetFullscreen(!i.jwGetFullscreen())}}else{V.onmouseup=function(Z){Z.stopPropagation();if(W!==null){i[Y](W)}else{i[Y]()}}}}}}function M(V){if(n){return}var W=J[V+"Slider"];_css(J.elements,{cursor:"pointer"});_css(W,{cursor:"pointer"});W.onmousedown=function(X){t=V};W.onmouseup=function(X){X.stopPropagation();S(X.pageX)};W.onmousemove=function(X){if(t=="time"){f=true;var Y=X.pageX-c[V+"Slider"].left-window.pageXOffset;_css(J.timeSliderThumb,{left:Y})}}}function S(W){f=false;var V;if(t=="time"){V=W-c.timeSliderRail.left+window.pageXOffset;var Y=V/c.timeSliderRail.width*Q;if(Y<0){Y=0}else{if(Y>Q){Y=Q-3}}i.jwSeek(Y);if(i.jwGetState()!=a.api.events.state.PLAYING){i.jwPlay()}}else{if(t=="volume"){V=W-c.volumeSliderRail.left-window.pageXOffset;var X=Math.round(V/c.volumeSliderRail.width*100);if(X<0){X=0}else{if(X>100){X=100}}if(i.jwGetMute()){i.jwSetMute(false)}i.jwSetVolume(X)}}t="none"}function r(W){if(W.bufferPercent!==null){e=W.bufferPercent}var X=c.timeSliderRail.width;var V=isNaN(Math.round(X*e/100))?0:Math.round(X*e/100);_css(J.timeSliderBuffer,{width:V})}function T(V){if(V.mute){_hide(J.muteButton);_show(J.unmuteButton);_hide(J.volumeSliderProgress)}else{_show(J.muteButton);_hide(J.unmuteButton);_show(J.volumeSliderProgress)}}function p(V){if(V.newstate==a.api.events.state.BUFFERING||V.newstate==a.api.events.state.PLAYING){_show(J.pauseButton);_hide(J.playButton)}else{_hide(J.pauseButton);_show(J.playButton)}x();if(V.newstate==a.api.events.state.IDLE){_hide(J.timeSliderBuffer);_hide(J.timeSliderProgress);_hide(J.timeSliderThumb);D({id:i.id,duration:i.jwGetDuration(),position:0})}else{_show(J.timeSliderBuffer);if(V.newstate!=a.api.events.state.BUFFERING){_show(J.timeSliderProgress);_show(J.timeSliderThumb)}}}function F(V){r({bufferPercent:0});D(a.utils.extend(V,{position:0,duration:Q}))}function D(Y){if(Y.position!==null){h=Y.position}if(Y.duration!==null){Q=Y.duration}var W=(h===Q===0)?0:h/Q;var V=isNaN(Math.round(c.timeSliderRail.width*W))?0:Math.round(c.timeSliderRail.width*W);var X=V;J.timeSliderProgress.style.width=V+"px";if(!f){if(J.timeSliderThumb){J.timeSliderThumb.style.left=X+"px"}}if(J.durationText){J.durationText.innerHTML=m(Q)}if(J.elapsedText){J.elapsedText.innerHTML=m(h)}}function m(V){str="00:00";if(V>0){str=Math.floor(V/60)<10?"0"+Math.floor(V/60)+":":Math.floor(V/60)+":";str+=Math.floor(V%60)<10?"0"+Math.floor(V%60):Math.floor(V%60)}return str}function l(){var Y,W;var X=document.getElementById(P.id+"_elements").childNodes;for(var V in document.getElementById(P.id+"_elements").childNodes){if(isNaN(parseInt(V,10))){continue}if(X[V].id.indexOf(P.id+"_divider")===0&&W.id.indexOf(P.id+"_divider")===0){X[V].style.display="none"}else{if(X[V].id.indexOf(P.id+"_divider")===0&&Y.style.display!="none"){X[V].style.display="block"}}if(X[V].style.display!="none"){W=X[V]}Y=X[V]}}function u(){l();if(i.jwGetFullscreen()){_show(J.normalscreenButton);_hide(J.fullscreenButton)}else{_hide(J.normalscreenButton);_show(J.fullscreenButton)}var W={width:d};var V={};if(A.position.toUpperCase()==a.html5.view.positions.OVER||i.jwGetFullscreen()){W.left=A.margin;W.width-=2*A.margin;W.top=w-i.skin.getSkinElement("controlbar","background").height-A.margin;W.height=i.skin.getSkinElement("controlbar","background").height}else{W.left=0}V.left=i.skin.getSkinElement("controlbar","capLeft").width;V.width=W.width-i.skin.getSkinElement("controlbar","capLeft").width-i.skin.getSkinElement("controlbar","capRight").width;var X=i.skin.getSkinElement("controlbar","timeSliderCapLeft")===undefined?0:i.skin.getSkinElement("controlbar","timeSliderCapLeft").width;_css(J.timeSliderRail,{width:(V.width-O-B),left:X});if(J.timeSliderCapRight!==undefined){_css(J.timeSliderCapRight,{left:X+(V.width-O-B)})}_css(P,W);_css(J.elements,V);o();return W}function k(Z){if(J.volumeSliderRail!==undefined){var X=isNaN(Z.volume/100)?1:Z.volume/100;var Y=parseInt(J.volumeSliderRail.style.width.replace("px",""),10);var V=isNaN(Math.round(Y*X))?0:Math.round(Y*X);var aa=parseInt(J.volumeSliderRail.style.right.replace("px",""),10);var W=i.skin.getSkinElement("controlbar","volumeSliderCapLeft")===undefined?0:i.skin.getSkinElement("controlbar","volumeSliderCapLeft").width;_css(J.volumeSliderProgress,{width:V,left:W});if(J.volumeSliderCapLeft!==undefined){_css(J.volumeSliderCapLeft,{left:0})}}}function q(){H();G();o();n=true;C();R();P.style.opacity=A.idlehide?0:1}q();return this}})(jwplayer);(function(b){var a=["width","height","state","playlist","item","position","buffer","duration","volume","mute","fullscreen"];b.html5.controller=function(t,r,e,q){var w=t;var y=e;var d=q;var k=r;var A=true;var c=-1;var u=(y.config.debug!==undefined)&&(y.config.debug.toString().toLowerCase()=="console");var i=new b.html5.eventdispatcher(k.id,u);b.utils.extend(this,i);function m(D){i.sendEvent(D.type,D)}y.addGlobalListener(m);function p(){try{if(y.playlist[y.item].levels[0].file.length>0){if(A||y.state==b.api.events.state.IDLE){y.addEventListener(b.api.events.JWPLAYER_MEDIA_BUFFER_FULL,function(){y.getMedia().play()});y.addEventListener(b.api.events.JWPLAYER_MEDIA_TIME,function(E){if(E.position>=y.playlist[y.item].start&&c>=0){y.playlist[y.item].start=c;c=-1}});if(y.config.repeat){y.addEventListener(b.api.events.JWPLAYER_MEDIA_COMPLETE,function(E){setTimeout(n,25)})}y.getMedia().load(y.playlist[y.item]);A=false}else{if(y.state==b.api.events.state.PAUSED){y.getMedia().play()}}}return true}catch(D){i.sendEvent(b.api.events.JWPLAYER_ERROR,D)}return false}function B(){try{if(y.playlist[y.item].levels[0].file.length>0){switch(y.state){case b.api.events.state.PLAYING:case b.api.events.state.BUFFERING:y.getMedia().pause();break}}return true}catch(D){i.sendEvent(b.api.events.JWPLAYER_ERROR,D)}return false}function x(D){try{if(y.playlist[y.item].levels[0].file.length>0){if(typeof D!="number"){D=parseFloat(D)}switch(y.state){case b.api.events.state.IDLE:if(c<0){c=y.playlist[y.item].start;y.playlist[y.item].start=D}p();break;case b.api.events.state.PLAYING:case b.api.events.state.PAUSED:case b.api.events.state.BUFFERING:y.getMedia().seek(D);break}}return true}catch(E){i.sendEvent(b.api.events.JWPLAYER_ERROR,E)}return false}function j(){try{if(y.playlist[y.item].levels[0].file.length>0&&y.state!=b.api.events.state.IDLE){y.getMedia().stop()}return true}catch(D){i.sendEvent(b.api.events.JWPLAYER_ERROR,D)}return false}function g(){try{if(y.playlist[y.item].levels[0].file.length>0){if(y.config.shuffle){o(s())}else{if(y.item+1==y.playlist.length){o(0)}else{o(y.item+1)}}}if(y.state!=b.api.events.state.PLAYING&&y.state!=b.api.events.state.BUFFERING){p()}return true}catch(D){i.sendEvent(b.api.events.JWPLAYER_ERROR,D)}return false}function f(){try{if(y.playlist[y.item].levels[0].file.length>0){if(y.config.shuffle){o(s())}else{if(y.item===0){o(y.playlist.length-1)}else{o(y.item-1)}}}if(y.state!=b.api.events.state.PLAYING&&y.state!=b.api.events.state.BUFFERING){p()}return true}catch(D){i.sendEvent(b.api.events.JWPLAYER_ERROR,D)}return false}function s(){var D=null;if(y.playlist.length>1){while(D===null){D=Math.floor(Math.random()*y.playlist.length);if(D==y.item){D=null}}}else{D=0}return D}function o(E){y.resetEventListeners();y.addGlobalListener(m);try{if(y.playlist[E].levels[0].file.length>0){var F=y.state;if(F!==b.api.events.state.IDLE){j()}y.item=E;A=true;y.setActiveMediaProvider(y.playlist[y.item]);i.sendEvent(b.api.events.JWPLAYER_PLAYLIST_ITEM,{index:E});if(F==b.api.events.state.PLAYING||F==b.api.events.state.BUFFERING||y.config.chromeless){p()}}return true}catch(D){i.sendEvent(b.api.events.JWPLAYER_ERROR,D)}return false}function z(E){try{switch(typeof(E)){case"number":y.getMedia().volume(E);break;case"string":y.getMedia().volume(parseInt(E,10));break}return true}catch(D){i.sendEvent(b.api.events.JWPLAYER_ERROR,D)}return false}function l(E){try{if(typeof E=="undefined"){y.getMedia().mute(!y.mute)}else{if(E.toString().toLowerCase()=="true"){y.getMedia().mute(true)}else{y.getMedia().mute(false)}}return true}catch(D){i.sendEvent(b.api.events.JWPLAYER_ERROR,D)}return false}function h(E,D){try{y.width=E;y.height=D;d.resize(E,D);i.sendEvent(b.api.events.JWPLAYER_RESIZE,{width:y.width,height:y.height});return true}catch(F){i.sendEvent(b.api.events.JWPLAYER_ERROR,F)}return false}function v(E){try{if(typeof E=="undefined"){y.fullscreen=!y.fullscreen;d.fullscreen(!y.fullscreen)}else{if(E.toString().toLowerCase()=="true"){y.fullscreen=true;d.fullscreen(true)}else{y.fullscreen=false;d.fullscreen(false)}}i.sendEvent(b.api.events.JWPLAYER_RESIZE,{width:y.width,height:y.height});i.sendEvent(b.api.events.JWPLAYER_FULLSCREEN,{fullscreen:E});return true}catch(D){i.sendEvent(b.api.events.JWPLAYER_ERROR,D)}return false}function C(D){try{j();y.loadPlaylist(D);o(y.item);return true}catch(E){i.sendEvent(b.api.events.JWPLAYER_ERROR,E)}return false}b.html5.controller.repeatoptions={LIST:"LIST",ALWAYS:"ALWAYS",SINGLE:"SINGLE",NONE:"NONE"};function n(){y.resetEventListeners();y.addGlobalListener(m);switch(y.config.repeat.toUpperCase()){case b.html5.controller.repeatoptions.SINGLE:p();break;case b.html5.controller.repeatoptions.ALWAYS:if(y.item==y.playlist.length-1&&!y.config.shuffle){o(0);p()}else{g()}break;case b.html5.controller.repeatoptions.LIST:if(y.item==y.playlist.length-1&&!y.config.shuffle){o(0)}else{g()}break}}this.play=p;this.pause=B;this.seek=x;this.stop=j;this.next=g;this.prev=f;this.item=o;this.setVolume=z;this.setMute=l;this.resize=h;this.setFullscreen=v;this.load=C}})(jwplayer);(function(a){a.html5.defaultSkin=function(){this.text='<?xml version="1.0" ?><skin author="LongTail Video" name="Five" version="1.0"><settings><setting name="backcolor" value="0xFFFFFF"/><setting name="frontcolor" value="0x000000"/><setting name="lightcolor" value="0x000000"/><setting name="screencolor" value="0x000000"/></settings><components><component name="controlbar"><settings><setting name="margin" value="20"/><setting name="fontsize" value="11"/></settings><elements><element name="background" src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABgAAAAYCAIAAABvFaqvAAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJbWFnZVJlYWR5ccllPAAAAFJJREFUeNrslLENwAAIwxLU/09j5AiOgD5hVQzNAVY8JK4qEfHMIKBnd2+BQlBINaiRtL/aV2rdzYBsM6CIONbI1NZENTr3RwdB2PlnJgJ6BRgA4hwu5Qg5iswAAAAASUVORK5CYII="/><element name="capLeft" src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAAEAAAAYCAIAAAC0rgCNAAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJbWFnZVJlYWR5ccllPAAAAD5JREFUeNosi8ENACAMAgnuv14H0Z8asI19XEjhOiKCMmibVgJTUt7V6fe9KXOtSQCfctJHu2q3/ot79hNgANc2OTz9uTCCAAAAAElFTkSuQmCC"/><element name="capRight" src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAAEAAAAYCAIAAAC0rgCNAAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJbWFnZVJlYWR5ccllPAAAAD5JREFUeNosi8ENACAMAgnuv14H0Z8asI19XEjhOiKCMmibVgJTUt7V6fe9KXOtSQCfctJHu2q3/ot79hNgANc2OTz9uTCCAAAAAElFTkSuQmCC"/><element name="divider" src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAAEAAAAYCAIAAAC0rgCNAAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJbWFnZVJlYWR5ccllPAAAAD5JREFUeNosi8ENACAMAgnuv14H0Z8asI19XEjhOiKCMmibVgJTUt7V6fe9KXOtSQCfctJHu2q3/ot79hNgANc2OTz9uTCCAAAAAElFTkSuQmCC"/><element name="playButton" src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABUAAAAYCAYAAAAVibZIAAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJbWFnZVJlYWR5ccllPAAAAEhJREFUeNpiYqABYBo1dNRQ+hr6H4jvA3E8NS39j4SpZvh/LJig4YxEGEqy3kET+w+AOGFQRhTJhrEQkGcczfujhg4CQwECDADpTRWU/B3wHQAAAABJRU5ErkJggg=="/><element name="pauseButton" src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABUAAAAYCAYAAAAVibZIAAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJbWFnZVJlYWR5ccllPAAAAChJREFUeNpiYBgFo2DwA0YC8v/R1P4nRu+ooaOGUtnQUTAKhgIACDAAFCwQCfAJ4gwAAAAASUVORK5CYII="/><element name="prevButton" src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABUAAAAYCAYAAAAVibZIAAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJbWFnZVJlYWR5ccllPAAAAEtJREFUeNpiYBgFo2Dog/9QDAPyQHweTYwiQ/2B+D0Wi8g2tB+JTdBQRiIMJVkvEy0iglhDF9Aq9uOpHVEwoE+NJDUKRsFgAAABBgDe2hqZcNNL0AAAAABJRU5ErkJggg=="/><element name="nextButton" src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABUAAAAYCAYAAAAVibZIAAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJbWFnZVJlYWR5ccllPAAAAElJREFUeNpiYBgFo2Dog/9AfB6I5dHE/lNqKAi/B2J/ahsKw/3EGMpIhKEk66WJoaR6fz61IyqemhEFSlL61ExSo2AUDAYAEGAAiG4hj+5t7M8AAAAASUVORK5CYII="/><element name="timeSliderRail" src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABgAAAAYCAYAAADgdz34AAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJbWFnZVJlYWR5ccllPAAAADxJREFUeNpiYBgFo2AU0Bwwzluw+D8tLWARFhKiqQ9YuLg4aWsBGxs7bS1gZ6e5BWyjSX0UjIKhDgACDABlYQOGh5pYywAAAABJRU5ErkJggg=="/><element name="timeSliderBuffer" src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABgAAAAYCAYAAADgdz34AAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJbWFnZVJlYWR5ccllPAAAAD1JREFUeNpiYBgFo2AU0Bww1jc0/aelBSz8/Pw09QELOzs7bS1gY2OjrQWsrKy09gHraFIfBaNgqAOAAAMAvy0DChXHsZMAAAAASUVORK5CYII="/><element name="timeSliderProgress" src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABgAAAAYCAYAAADgdz34AAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJbWFnZVJlYWR5ccllPAAAAClJREFUeNpiYBgFo2AU0BwwAvF/WlrARGsfjFow8BaMglEwCugAAAIMAOHfAQunR+XzAAAAAElFTkSuQmCC"/><element name="timeSliderThumb" src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAAMAAAAICAYAAAA870V8AAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJbWFnZVJlYWR5ccllPAAAABZJREFUeNpiZICA/yCCiQEJUJcDEGAAY0gBD1/m7Q0AAAAASUVORK5CYII="/><element name="muteButton" src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAA4AAAAYCAYAAADKx8xXAAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJbWFnZVJlYWR5ccllPAAAADFJREFUeNpiYBgFIw3MB+L/5Gj8j6yRiRTFyICJXHfTXyMLAXlGati4YDRFDj8AEGAABk8GSqqS4CoAAAAASUVORK5CYII="/><element name="unmuteButton" src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAA4AAAAYCAYAAADKx8xXAAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJbWFnZVJlYWR5ccllPAAAAD1JREFUeNpiYBgFgxz8p7bm+cQa+h8LHy7GhEcjIz4bmAjYykiun/8j0fakGPIfTfPgiSr6aB4FVAcAAQYAWdwR1G1Wd2gAAAAASUVORK5CYII="/><element name="volumeSliderRail" src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABoAAAAYCAYAAADkgu3FAAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJbWFnZVJlYWR5ccllPAAAAGpJREFUeNpi/P//PwM9ABMDncCoRYPfIqqDZcuW1UPp/6AUDcNM1DQYKtRAlaAj1mCSLSLXYIIWUctgDItoZfDA5aOoqKhGEANIM9LVR7SymGDQUctikuOIXkFNdhHEOFrDjlpEd4sAAgwAriRMub95fu8AAAAASUVORK5CYII="/><element name="volumeSliderProgress" src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABoAAAAYCAYAAADkgu3FAAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJbWFnZVJlYWR5ccllPAAAAFtJREFUeNpi/P//PwM9ABMDncCoRYPfIlqAeij9H5SiYZiqBqPTlFqE02BKLSLaYFItIttgQhZRzWB8FjENiuRJ7aAbsMQwYMl7wDIsWUUQ42gNO2oR3S0CCDAAKhKq6MLLn8oAAAAASUVORK5CYII="/><element name="fullscreenButton" src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABgAAAAYCAYAAADgdz34AAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJbWFnZVJlYWR5ccllPAAAAE5JREFUeNpiYBgFo2DQA0YC8v/xqP1PjDlMRDrEgUgxkgHIlfZoriVGjmzLsLFHAW2D6D8eA/9Tw7L/BAwgJE90PvhPpNgoGAVDEQAEGAAMdhTyXcPKcAAAAABJRU5ErkJggg=="/><element name="normalscreenButton" src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABgAAAAYCAYAAADgdz34AAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJbWFnZVJlYWR5ccllPAAAAEZJREFUeNpiYBgFo2DIg/9UUkOUAf8JiFFsyX88fJyAkcQgYMQjNkzBoAgiezyRbE+tFGSPxQJ7auYBmma0UTAKBhgABBgAJAEY6zON61sAAAAASUVORK5CYII="/></elements></component><component name="display"><elements><element name="background" src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAADIAAAAyCAYAAAAeP4ixAAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJbWFnZVJlYWR5ccllPAAAAEpJREFUeNrszwENADAIA7DhX8ENoBMZ5KR10EryckCJiIiIiIiIiIiIiIiIiIiIiIh8GmkRERERERERERERERERERERERGRHSPAAPlXH1phYpYaAAAAAElFTkSuQmCC"/><element name="playIcon" src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAADIAAAAyCAYAAAAeP4ixAAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJbWFnZVJlYWR5ccllPAAAALdJREFUeNrs18ENgjAYhmFouDOCcQJGcARHgE10BDcgTOIosAGwQOuPwaQeuFRi2p/3Sb6EC5L3QCxZBgAAAOCorLW1zMn65TrlkH4NcV7QNcUQt7Gn7KIhxA+qNIR81spOGkL8oFJDyLJRdosqKDDkK+iX5+d7huzwM40xptMQMkjIOeRGo+VkEVvIPfTGIpKASfYIfT9iCHkHrBEzf4gcUQ56aEzuGK/mw0rHpy4AAACAf3kJMACBxjAQNRckhwAAAABJRU5ErkJggg=="/><element name="muteIcon" src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAADIAAAAyCAYAAAAeP4ixAAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJbWFnZVJlYWR5ccllPAAAAHJJREFUeNrs1jEOgCAMBVAg7t5/8qaoIy4uoobyXsLCxA+0NCUAAADGUWvdQoQ41x4ixNBB2hBvBskdD3w5ZCkl3+33VqI0kjBBlh9rp+uTcyOP33TnolfsU85XX3yIRpQph8ZQY3wTZtU5AACASA4BBgDHoVuY1/fvOQAAAABJRU5ErkJggg=="/><element name="errorIcon" src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAADIAAAAyCAYAAAAeP4ixAAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJbWFnZVJlYWR5ccllPAAAAWlJREFUeNrsl+1twjAQhsHq/7BBYQLYIBmBDcoGMAIjtBPQTcII2SDtBDBBwrU6pGsUO7YbO470PtKJkz9iH++d4ywWAAAAAABgljRNsyWr2bZzDuJG1rLdZhcMbTjrBCGDyUKsqQLFciJb9bSvuG/WagRVRUVUI6gqy5HVeKWfSgRyJruKIU//TrZTSn2nmlaXThrloi/v9F2STC1W4+Aw5cBzkquRc09bofFNc6YLxEON0VUZS5FPTftO49vMjRsIF3RhOGr7/D/pJw+FKU+q0vDyq8W42jCunDqI3LC5XxNj2wHLU1XjaRnb0Lhykhqhhd8MtSF5J9tbjCv4mXGvKJz/65FF/qJryyaaIvzP2QRxZTX2nTuXjvV/VPFSwyLnW7mpH99yTh1FEVro6JBSd40/pMrRdV8vPtcKl28T2pT8TnFZ4yNosct3Q0io6JfBiz1FlGdqVQH3VHnepAEAAAAAADDzEGAAcTwB10jWgxcAAAAASUVORK5CYII="/><element name="bufferIcon" src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAADIAAAAyCAYAAAAeP4ixAAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJbWFnZVJlYWR5ccllPAAAAuhJREFUeNrsWr9rU1EUznuNGqvFQh1ULOhiBx0KDtIuioO4pJuik3FxFfUPaAV1FTdx0Q5d2g4FFxehTnEpZHFoBy20tCIWtGq0TZP4HfkeHB5N8m6Sl/sa74XDybvv3vvOd8/Pe4lXrVZT3dD8VJc0B8QBcUAcEAfESktHGeR5XtMfqFQq/f92zPe/NbtGlKTdCY30kuxrpMGO94BlQCXs+rbh3ONgA6BlzP1p20d80gEI5hmA2A92Qua1Q2PtAFISM+bvjMG8U+Q7oA3rQGASwrYCU6WpNdLGYbA+Pq5jjXIiwi8EEa2UDbQSaKOIuV+SlkcCrfjY8XTI9EpKGwP0C2kru2hLtHqa4zoXtZRWyvi4CLwv9Opr6Hkn6A9HKgEANsQ1iqC3Ub/vRUk2JgmRkatK36kVrnt0qObunwUdUUMXMWYpakJsO5Am8tAw2GBIgwWA+G2S2dMpiw0gDioQRQJoKhRb1QiDwlHZUABYbaXWsm5ae6loTE4ZDxN4CZar8foVzOJ2iyZ2kWF3t7YIevffaMT5yJ70kQb2fQ1sE5SHr2wazs2wgMxgbsEKEAgxAvZUJbQLBGTSBMgNrncJbA6AljtS/eKDJ0Ez+DmrQEzXS2h1Ck25kAg0IZcUOaydCy4sYnN2fOA+2AP16gNoHALlQ+fwH7XO4CxLenUpgj4xr6ugY2roPMbMx+Xs18m/E8CVEIhxsNeg83XWOAN6grG3lGbk8uE5fr4B/WH3cJw+co/l9nTYsSGYCJ/lY5/qv0thn6nrIWmjeJcPSnWOeY++AkF8tpJHIMAUs/MaBBpj3znZfQo5psY+ZrG4gv5HickjEOymKjEeRpgyST6IuZcTcWbnjcgdPi5ghxciRKsl1lDSsgwA1i8fssonJgzmTSqfGUkCENndNdAL7PS6QQ7ZYISTo+1qq0LEWjTWcvY4isa4z+yfQB+7ooyHVg5RI7/i1Ijn/vnggDggDogD4oC00P4KMACd/juEHOrS4AAAAABJRU5ErkJggg=="/></elements></component><component name="dock"><elements><element name="button" src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAADIAAAAyCAYAAAAeP4ixAAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJbWFnZVJlYWR5ccllPAAAAFBJREFUeNrs0cEJACAQA8Eofu0fu/W6EM5ZSAFDRpKTBs00CQQEBAQEBAQEBAQEBAQEBATkK8iqbY+AgICAgICAgICAgICAgICAgIC86QowAG5PAQzEJ0lKAAAAAElFTkSuQmCC"/></elements></component><component name="playlist"><elements><element name="item" src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAADwAAAA8CAIAAAC1nk4lAAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJbWFnZVJlYWR5ccllPAAAAHhJREFUeNrs2NEJwCAMBcBYuv/CFuIE9VN47WWCR7iocXR3pdWdGPqqwIoMjYfQeAiNh9B4JHc6MHQVHnjggQceeOCBBx77TifyeOY0iHi8DqIdEY8dD5cL094eePzINB5CO/LwcOTptNB4CP25L4TIbZzpU7UEGAA5wz1uF5rF9AAAAABJRU5ErkJggg=="/><element name="sliderRail" src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABQAAAA8CAIAAADpFA0BAAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJbWFnZVJlYWR5ccllPAAAADhJREFUeNrsy6ENACAMAMHClp2wYxZLAg5Fcu9e3OjuOKqqfTMzbs14CIZhGIZhGIZhGP4VLwEGAK/BBnVFpB0oAAAAAElFTkSuQmCC"/><element name="sliderThumb" src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABQAAAA8CAIAAADpFA0BAAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJbWFnZVJlYWR5ccllPAAAADRJREFUeNrsy7ENACAMBLE8++8caFFKKiRffU53112SGs3ttOohGIZhGIZhGIZh+Fe8BRgAiaUGde6NOSEAAAAASUVORK5CYII="/></elements></component></components></skin>';this.xml=null;if(window.DOMParser){parser=new DOMParser();this.xml=parser.parseFromString(this.text,"text/xml")}else{this.xml=new ActiveXObject("Microsoft.XMLDOM");this.xml.async="false";this.xml.loadXML(this.text)}return this}})(jwplayer);(function(a){_css=a.utils.css;_hide=function(b){_css(b,{display:"none"})};_show=function(b){_css(b,{display:"block"})};a.html5.display=function(o,y){var v=o;var e={};var g;var z;var k;var w;var x;var p;var j;var n=v.skin.getComponentSettings("display").bufferrotation===undefined?15:parseInt(v.skin.getComponentSettings("display").bufferrotation,10);var f=v.skin.getComponentSettings("display").bufferinterval===undefined?100:parseInt(v.skin.getComponentSettings("display").bufferinterval,10);var d={display:{style:{cursor:"pointer",top:0,left:0,overflow:"hidden"},click:t},display_icon:{style:{cursor:"pointer",position:"absolute",top:((v.skin.getSkinElement("display","background").height-v.skin.getSkinElement("display","playIcon").height)/2),left:((v.skin.getSkinElement("display","background").width-v.skin.getSkinElement("display","playIcon").width)/2),border:0,margin:0,padding:0,zIndex:3}},display_iconBackground:{style:{cursor:"pointer",position:"absolute",top:((z-v.skin.getSkinElement("display","background").height)/2),left:((g-v.skin.getSkinElement("display","background").width)/2),border:0,backgroundImage:(["url(",v.skin.getSkinElement("display","background").src,")"]).join(""),width:v.skin.getSkinElement("display","background").width,height:v.skin.getSkinElement("display","background").height,margin:0,padding:0,zIndex:2}},display_image:{style:{display:"none",width:g,height:z,position:"absolute",cursor:"pointer",left:0,top:0,margin:0,padding:0,textDecoration:"none",zIndex:1}},display_text:{style:{zIndex:4,position:"relative",opacity:0.8,backgroundColor:parseInt("000000",16),color:parseInt("ffffff",16),textAlign:"center",fontFamily:"Arial,sans-serif",padding:"0 5px",fontSize:14}}};v.jwAddEventListener(a.api.events.JWPLAYER_PLAYER_STATE,l);v.jwAddEventListener(a.api.events.JWPLAYER_MEDIA_MUTE,l);v.jwAddEventListener(a.api.events.JWPLAYER_PLAYLIST_ITEM,l);v.jwAddEventListener(a.api.events.JWPLAYER_ERROR,s);A();function A(){e.display=r("div","display");e.display_text=r("div","display_text");e.display.appendChild(e.display_text);e.display_image=r("img","display_image");e.display_image.onerror=function(B){_hide(e.display_image)};e.display_image.onload=m;e.display_icon=r("div","display_icon");e.display_iconBackground=r("div","display_iconBackground");e.display.appendChild(e.display_image);e.display_iconBackground.appendChild(e.display_icon);e.display.appendChild(e.display_iconBackground);b()}this.getDisplayElement=function(){return e.display};this.resize=function(C,B){g=C;z=B;_css(e.display,{width:C,height:B});_css(e.display_text,{width:(C-10),top:((z-e.display_text.getBoundingClientRect().height)/2)});_css(e.display_iconBackground,{top:((z-v.skin.getSkinElement("display","background").height)/2),left:((g-v.skin.getSkinElement("display","background").width)/2)});i();l({})};function m(B){k=e.display_image.naturalWidth;w=e.display_image.naturalHeight;i()}function i(){a.utils.stretch(v.jwGetStretching(),e.display_image,g,z,k,w)}function r(B,D){var C=document.createElement(B);C.id=v.id+"_jwplayer_"+D;_css(C,d[D].style);return C}function b(){for(var B in e){if(d[B].click!==undefined){e[B].onclick=d[B].click}}}function t(B){if(typeof B.preventDefault!="undefined"){B.preventDefault()}else{B.returnValue=false}if(v.jwGetState()!=a.api.events.state.PLAYING){v.jwPlay()}else{v.jwPause()}}function h(B){if(j){return}_show(e.display_iconBackground);e.display_icon.style.backgroundImage=(["url(",v.skin.getSkinElement("display",B).src,")"]).join("");_css(e.display_icon,{display:"block",width:v.skin.getSkinElement("display",B).width,height:v.skin.getSkinElement("display",B).height,top:(v.skin.getSkinElement("display","background").height-v.skin.getSkinElement("display",B).height)/2,left:(v.skin.getSkinElement("display","background").width-v.skin.getSkinElement("display",B).width)/2});if(v.skin.getSkinElement("display",B+"Over")!==undefined){e.display_icon.onmouseover=function(C){e.display_icon.style.backgroundImage=["url(",v.skin.getSkinElement("display",B+"Over").src,")"].join("")};e.display_icon.onmouseout=function(C){e.display_icon.style.backgroundImage=["url(",v.skin.getSkinElement("display",B).src,")"].join("")}}else{e.display_icon.onmouseover=null;e.display_icon.onmouseout=null}}function q(){_hide(e.display_icon);_hide(e.display_iconBackground)}function s(B){j=true;q();e.display_text.innerHTML=B.error;_show(e.display_text);e.display_text.style.top=((z-e.display_text.getBoundingClientRect().height)/2)+"px"}function c(){_css(e.display_image,{display:"none"});delete e.display_image.src}function u(){var B=e.display_image;e.display_image=r("img","display_image");e.display_image.onerror=function(C){_hide(e.display_image)};e.display_image.onload=m;e.display.replaceChild(e.display_image,B)}function l(B){if((B.type==a.api.events.JWPLAYER_PLAYER_STATE||B.type==a.api.events.JWPLAYER_PLAYLIST_ITEM)&&j){j=false;_hide(e.display_text)}if(p!==undefined){clearInterval(p);p=null;a.utils.animations.rotate(e.display_icon,0)}switch(v.jwGetState()){case a.api.events.state.BUFFERING:h("bufferIcon");x=0;p=setInterval(function(){x+=n;a.utils.animations.rotate(e.display_icon,x%360)},f);h("bufferIcon");break;case a.api.events.state.PAUSED:_css(e.display_image,{background:"transparent no-repeat center center"});h("playIcon");break;case a.api.events.state.IDLE:if(v.jwGetPlaylist()[v.jwGetItem()].image){_css(e.display_image,{display:"block"});e.display_image.src=a.utils.getAbsolutePath(v.jwGetPlaylist()[v.jwGetItem()].image)}else{u()}h("playIcon");break;default:if(v.jwGetMute()){u();h("muteIcon")}else{u();_hide(e.display_iconBackground);_hide(e.display_icon)}break}}return this}})(jwplayer);(function(jwplayer){jwplayer.html5.eventdispatcher=function(id,debug){var _id=id;var _debug=debug;var _listeners;var _globallisteners;this.resetEventListeners=function(){_listeners={};_globallisteners=[]};this.resetEventListeners();this.addEventListener=function(type,listener,count){try{if(_listeners[type]===undefined){_listeners[type]=[]}if(typeof(listener)=="string"){eval("listener = "+listener)}_listeners[type].push({listener:listener,count:count})}catch(err){jwplayer.utils.log("error",err)}return false};this.removeEventListener=function(type,listener){try{for(var listenerIndex=0;listenerIndex<_listeners[type].length;listenerIndex++){if(_listeners[type][lisenterIndex].toString()==listener.toString()){_listeners[type].slice(lisenterIndex,lisenterIndex+1);break}}}catch(err){jwplayer.utils.log("error",err)}return false};this.addGlobalListener=function(listener,count){try{if(typeof(listener)=="string"){eval("listener = "+listener)}_globallisteners.push({listener:listener,count:count})}catch(err){jwplayer.utils.log("error",err)}return false};this.removeGlobalListener=function(listener){try{for(var globalListenerIndex=0;globalListenerIndex<_globallisteners.length;globalListenerIndex++){if(_globallisteners[globalListenerIndex].toString()==listener.toString()){_globallisteners.slice(globalListenerIndex,globalListenerIndex+1);break}}}catch(err){jwplayer.utils.log("error",err)}return false};this.sendEvent=function(type,data){if(data===undefined){data={}}jwplayer.utils.extend(data,{id:_id,version:jwplayer.version,type:type});if(_debug){jwplayer.utils.log(type,data)}if(typeof _listeners[type]!="undefined"){for(var listenerIndex=0;listenerIndex<_listeners[type].length;listenerIndex++){try{_listeners[type][listenerIndex].listener(data)}catch(err){jwplayer.utils.log("There was an error while handling a listener",_listeners[type][listenerIndex].listener,err)}if(_listeners[type][listenerIndex].count===1){delete _listeners[type][listenerIndex]}else{if(_listeners[type][listenerIndex].count>0){_listeners[type][listenerIndex].count=_listeners[type][listenerIndex].count-1}}}}for(var globalListenerIndex=0;globalListenerIndex<_globallisteners.length;globalListenerIndex++){try{_globallisteners[globalListenerIndex].listener(data)}catch(err){jwplayer.utils.log("There was an error while handling a listener",_globallisteners[globalListenerIndex].listener,err)}if(_globallisteners[globalListenerIndex].count===1){delete _globallisteners[globalListenerIndex]}else{if(_globallisteners[globalListenerIndex].count>0){_globallisteners[globalListenerIndex].count=_globallisteners[globalListenerIndex].count-1}}}}}})(jwplayer);(function(a){var b={prefix:"",file:"",link:"",margin:8,out:0.5,over:1,timeout:3,hide:true,position:"bottom-left"};_css=a.utils.css;a.html5.logo=function(l,m){var r=l;var n;var i;var c;j();function j(){p();d();f()}function p(){if(b.prefix){var t=l.version.split(/\W/).splice(0,2).join("/");if(b.prefix.indexOf(t)<0){b.prefix+=t+"/"}}if(m.position==a.html5.view.positions.OVER){m.position=b.position}i=a.utils.extend({},b,m)}function d(){c=document.createElement("img");c.id=r.id+"_jwplayer_logo";c.style.display="none";c.onload=function(t){_css(c,q());r.jwAddEventListener(a.api.events.JWPLAYER_PLAYER_STATE,s);e()};if(!i.file){return}if(i.file.indexOf("http://")===0){c.src=i.file}else{c.src=i.prefix+i.file}}if(!i.file){return}this.resize=function(u,t){};this.getDisplayElement=function(){return c};function f(){if(i.link){c.onmouseover=h;c.onmouseout=e;c.onclick=o}else{this.mouseEnabled=false}}function o(t){if(typeof t!="undefined"){t.stopPropagation()}r.jwPause();r.jwSetFullscreen(false);if(i.link){window.open(i.link,"_blank")}return}function e(t){if(i.link){c.style.opacity=i.out}return}function h(t){if(i.hide){c.style.opacity=i.over}return}function q(){var v={textDecoration:"none",position:"absolute",cursor:"pointer"};v.display=i.hide?"none":"block";var u=i.position.toLowerCase().split("-");for(var t in u){v[u[t]]=i.margin}return v}function k(){if(i.hide){c.style.display="block";c.style.opacity=0;a.utils.fadeTo(c,i.out,0.1,parseFloat(c.style.opacity));n=setTimeout(function(){g()},i.timeout*1000)}}function g(){if(i.hide){a.utils.fadeTo(c,0,0.1,parseFloat(c.style.opacity))}}function s(t){if(t.newstate==a.api.events.state.BUFFERING){clearTimeout(n);k()}}return this}})(jwplayer);(function(a){var c={ended:a.api.events.state.IDLE,playing:a.api.events.state.PLAYING,pause:a.api.events.state.PAUSED,buffering:a.api.events.state.BUFFERING};var b=a.utils.css;a.html5.mediavideo=function(f,D){var H={abort:t,canplay:m,canplaythrough:m,durationchange:q,emptied:t,ended:m,error:l,loadeddata:q,loadedmetadata:q,loadstart:m,pause:m,play:K,playing:m,progress:A,ratechange:t,seeked:m,seeking:m,stalled:m,suspend:m,timeupdate:K,volumechange:t,waiting:m,canshowcurrentframe:t,dataunavailable:t,empty:t,load:e,loadedfirstframe:t};var I=new a.html5.eventdispatcher();a.utils.extend(this,I);var h=f;var x=D;var E;var G;var d=a.api.events.state.IDLE;var B=null;var n;var g=0;var z=false;var r=false;var M;var L;var i=[];var N;var C=false;function v(){return d}function e(O){}function t(O){}function m(O){if(c[O.type]){s(c[O.type])}}function s(O){if(C){return}if(n){O=a.api.events.state.IDLE}if(O==a.api.events.state.PAUSED&&d==a.api.events.state.IDLE){return}if(O==a.api.events.state.PLAYING&&d==a.api.events.state.IDLE){s(a.api.events.state.BUFFERING);I.sendEvent(a.api.events.JWPLAYER_MEDIA_BUFFER,{bufferPercent:h.buffer});y();return}if(d!=O){var P=d;h.state=O;d=O;var Q=false;if(O==a.api.events.state.IDLE){p();if(h.position>=h.duration&&(h.position||h.duration)){Q=true}if(x.style.display!="none"&&!h.config.chromeless){x.style.display="none"}}I.sendEvent(a.api.events.JWPLAYER_PLAYER_STATE,{oldstate:P,newstate:O});if(Q){I.sendEvent(a.api.events.JWPLAYER_MEDIA_COMPLETE)}}n=false}function q(O){var P={height:O.target.videoHeight,width:O.target.videoWidth,duration:Math.round(O.target.duration*10)/10};if(h.duration===0||isNaN(h.duration)){h.duration=Math.round(O.target.duration*10)/10}h.playlist[h.item]=a.utils.extend(h.playlist[h.item],P);I.sendEvent(a.api.events.JWPLAYER_MEDIA_META,{metadata:P})}function K(P){if(n){return}if(P!==undefined&&P.target!==undefined){if(h.duration===0||isNaN(h.duration)){h.duration=Math.round(P.target.duration*10)/10}if(!z&&x.readyState>0){s(a.api.events.state.PLAYING)}if(d==a.api.events.state.PLAYING){if(!z&&x.readyState>0){z=true;try{x.currentTime=h.playlist[h.item].start}catch(O){}x.volume=h.volume/100;x.muted=h.mute}h.position=Math.round(P.target.currentTime*10)/10;I.sendEvent(a.api.events.JWPLAYER_MEDIA_TIME,{position:P.target.currentTime,duration:P.target.duration})}}A(P)}function y(){if(E===false&&d==a.api.events.state.BUFFERING){I.sendEvent(a.api.events.JWPLAYER_MEDIA_BUFFER_FULL);E=true}}function F(){var O=(i[i.length-1]-i[0])/i.length;N=setTimeout(function(){if(!G){A({lengthComputable:true,loaded:1,total:1})}},O*10)}function A(Q){var P,O;if(Q!==undefined&&Q.lengthComputable&&Q.total){o();P=Q.loaded/Q.total*100;O=P/100*(h.duration-x.currentTime);if(50<P&&!G){clearTimeout(N);F()}}else{if((x.buffered!==undefined)&&(x.buffered.length>0)){maxBufferIndex=0;if(maxBufferIndex>=0){P=x.buffered.end(maxBufferIndex)/x.duration*100;O=x.buffered.end(maxBufferIndex)-x.currentTime}}}y();if(!G){if(P==100&&G===false){G=true}if(P!==null&&(P>h.buffer)){h.buffer=Math.round(P);I.sendEvent(a.api.events.JWPLAYER_MEDIA_BUFFER,{bufferPercent:Math.round(P)})}}}function w(){if(B===null){B=setInterval(function(){K()},100)}}function p(){clearInterval(B);B=null}function l(Q){var P="There was an error: ";if((Q.target.error&&Q.target.tagName.toLowerCase()=="video")||Q.target.parentNode.error&&Q.target.parentNode.tagName.toLowerCase()=="video"){var O=Q.target.error===undefined?Q.target.parentNode.error:Q.target.error;switch(O.code){case O.MEDIA_ERR_ABORTED:P="You aborted the video playback: ";break;case O.MEDIA_ERR_NETWORK:P="A network error caused the video download to fail part-way: ";break;case O.MEDIA_ERR_DECODE:P="The video playback was aborted due to a corruption problem or because the video used features your browser did not support: ";break;case O.MEDIA_ERR_SRC_NOT_SUPPORTED:P="The video could not be loaded, either because the server or network failed or because the format is not supported: ";break;default:P="An unknown error occurred: ";break}}else{if(Q.target.tagName.toLowerCase()=="source"){L--;if(L>0){return}P="The video could not be loaded, either because the server or network failed or because the format is not supported: "}else{a.utils.log("Erroneous error received. Continuing...");return}}u();P+=j();C=true;I.sendEvent(a.api.events.JWPLAYER_ERROR,{error:P});return}function j(){var Q="";for(var P in M.levels){var O=M.levels[P];var R=x.ownerDocument.createElement("source");Q+=a.utils.getAbsolutePath(O.file);if(P<(M.levels.length-1)){Q+=", "}}return Q}this.getDisplayElement=function(){return x};this.play=function(){if(d!=a.api.events.state.PLAYING){if(x.style.display!="block"){x.style.display="block"}x.play();w();if(E){s(a.api.events.state.PLAYING)}}};this.pause=function(){x.pause();s(a.api.events.state.PAUSED)};this.seek=function(O){if(!(h.duration===0||isNaN(h.duration))&&!(h.position===0||isNaN(h.position))){x.currentTime=O;x.play()}};function u(){x.pause();p();h.position=0;n=true;s(a.api.events.state.IDLE)}this.stop=u;this.volume=function(O){x.volume=O/100;h.volume=O;I.sendEvent(a.api.events.JWPLAYER_MEDIA_VOLUME,{volume:Math.round(O)})};this.mute=function(O){x.muted=O;h.mute=O;I.sendEvent(a.api.events.JWPLAYER_MEDIA_MUTE,{mute:O})};this.resize=function(P,O){if(false){b(x,{width:P,height:O})}I.sendEvent(a.api.events.JWPLAYER_MEDIA_RESIZE,{fullscreen:h.fullscreen,width:P,hieght:O})};this.fullscreen=function(O){if(O===true){this.resize("100%","100%")}else{this.resize(h.config.width,h.config.height)}};this.load=function(O){J(O);I.sendEvent(a.api.events.JWPLAYER_MEDIA_LOADED);E=false;G=false;z=false;if(!h.config.chromeless){i=[];o();s(a.api.events.state.BUFFERING);setTimeout(function(){K()},25)}};function o(){var O=new Date().getTime();i.push(O)}this.hasChrome=function(){return r};function J(V){h.duration=V.duration;r=false;M=V;var Q=document.createElement("video");Q.preload="none";C=false;L=0;for(var P=0;P<V.levels.length;P++){var O=V.levels[P];if(a.utils.isYouTube(O.file)){delete Q;k(O.file);return}var R;if(O.type===undefined){var U=a.utils.extension(O.file);if(a.utils.extensionmap[U]!==undefined&&a.utils.extensionmap[U].html5!==undefined){R=a.utils.extensionmap[U].html5}else{R="video/"+U+";"}}else{R=O.type}if(a.utils.html5CanPlay(Q,O.file)){var T=x.ownerDocument.createElement("source");T.src=a.utils.getAbsolutePath(O.file);if(!a.utils.isLegacyAndroid()){T.type=R}L++;Q.appendChild(T)}}if(L===0){C=true;I.sendEvent(a.api.events.JWPLAYER_ERROR,{error:"The video could not be loaded because the format is not supported by your browser: "+j()})}if(h.config.chromeless){Q.poster=a.utils.getAbsolutePath(V.image);Q.controls="controls"}Q.style.position=x.style.position;Q.style.top=x.style.top;Q.style.left=x.style.left;Q.style.width=x.style.width;Q.style.height=x.style.height;Q.style.zIndex=x.style.zIndex;Q.onload=e;Q.volume=0;x.parentNode.replaceChild(Q,x);Q.id=x.id;x=Q;for(var S in H){x.addEventListener(S,function(W){if(W.target.parentNode!==null){H[W.type](W)}},true)}}function k(S){var P=document.createElement("object");S=["http://www.youtube.com/v/",S.replace(/^[^v]+v.(.{11}).*/,"$1"),"&amp;hl=en_US&amp;fs=1&autoplay=1"].join("");var V={movie:S,allowFullScreen:"true",allowscriptaccess:"always"};for(var O in V){var T=document.createElement("param");T.name=O;T.value=V[O];P.appendChild(T)}var U=document.createElement("embed");var Q={src:S,type:"application/x-shockwave-flash",allowscriptaccess:"always",allowfullscreen:"true",width:document.getElementById(f.id).style.width,height:document.getElementById(f.id).style.height};for(var R in Q){U[R]=Q[R]}P.appendChild(U);P.style.position=x.style.position;P.style.top=x.style.top;P.style.left=x.style.left;P.style.width=document.getElementById(f.id).style.width;P.style.height=document.getElementById(f.id).style.height;P.style.zIndex=2147483000;x.parentNode.replaceChild(P,x);P.id=x.id;x=P;r=true}this.embed=J;return this}})(jwplayer);(function(jwplayer){var _configurableStateVariables=["width","height","start","duration","volume","mute","fullscreen","item","plugins","stretching"];jwplayer.html5.model=function(api,container,options){var _api=api;var _container=container;var _model={id:_container.id,playlist:[],state:jwplayer.api.events.state.IDLE,position:0,buffer:0,config:{width:480,height:320,item:-1,skin:undefined,file:undefined,image:undefined,start:0,duration:0,bufferlength:5,volume:90,mute:false,fullscreen:false,repeat:"none",stretching:jwplayer.utils.stretching.UNIFORM,autostart:false,debug:undefined,screencolor:undefined}};var _media;var _eventDispatcher=new jwplayer.html5.eventdispatcher();var _components=["display","logo","controlbar"];jwplayer.utils.extend(_model,_eventDispatcher);for(var option in options){if(typeof options[option]=="string"){var type=/color$/.test(option)?"color":null;options[option]=jwplayer.utils.typechecker(options[option],type)}var config=_model.config;var path=option.split(".");for(var edge in path){if(edge==path.length-1){config[path[edge]]=options[option]}else{if(config[path[edge]]===undefined){config[path[edge]]={}}config=config[path[edge]]}}}for(var index in _configurableStateVariables){var configurableStateVariable=_configurableStateVariables[index];_model[configurableStateVariable]=_model.config[configurableStateVariable]}var pluginorder=_components.concat([]);if(_model.plugins!==undefined){if(typeof _model.plugins=="string"){var userplugins=_model.plugins.split(",");for(var userplugin in userplugins){if(typeof userplugins[userplugin]=="string"){pluginorder.push(userplugins[userplugin].replace(/^\s+|\s+$/g,""))}}}}if(jwplayer.utils.isIOS()){_model.config.chromeless=true}if(_model.config.chromeless){pluginorder=["logo"]}_model.plugins={order:pluginorder,config:{controlbar:{position:jwplayer.html5.view.positions.BOTTOM}},object:{}};if(typeof _model.config.components!="undefined"){for(var component in _model.config.components){_model.plugins.config[component]=_model.config.components[component]}}for(var pluginIndex in _model.plugins.order){var pluginName=_model.plugins.order[pluginIndex];var pluginConfig=_model.config[pluginName]===undefined?{}:_model.config[pluginName];_model.plugins.config[pluginName]=_model.plugins.config[pluginName]===undefined?pluginConfig:jwplayer.utils.extend(_model.plugins.config[pluginName],pluginConfig);if(_model.plugins.config[pluginName].position===undefined){_model.plugins.config[pluginName].position=jwplayer.html5.view.positions.OVER}}_model.loadPlaylist=function(arg,ready){var input;if(typeof arg=="string"){try{input=eval(arg)}catch(err){input=arg}}else{input=arg}var config;switch(jwplayer.utils.typeOf(input)){case"object":config=input;break;case"array":config={playlist:input};break;default:config={file:input};break}_model.playlist=new jwplayer.html5.playlist(config);if(_model.config.shuffle){_model.item=_getShuffleItem()}else{if(_model.config.item>=_model.playlist.length){_model.config.item=_model.playlist.length-1}else{if(_model.config.item<0){_model.config.item=0}}_model.item=_model.config.item}if(!ready){_eventDispatcher.sendEvent(jwplayer.api.events.JWPLAYER_PLAYLIST_LOADED,{playlist:_model.playlist})}_model.setActiveMediaProvider(_model.playlist[_model.item])};function _getShuffleItem(){var result=null;if(_model.playlist.length>1){while(result===null){result=Math.floor(Math.random()*_model.playlist.length);if(result==_model.item){result=null}}}else{result=0}return result}function forward(evt){if(evt.type==jwplayer.api.events.JWPLAYER_MEDIA_LOADED){_container=_media.getDisplayElement()}_eventDispatcher.sendEvent(evt.type,evt)}_model.setActiveMediaProvider=function(playlistItem){if(_media!==undefined){_media.resetEventListeners()}_media=new jwplayer.html5.mediavideo(_model,_container);_media.addGlobalListener(forward);if(_model.config.chromeless){_media.load(playlistItem)}return true};_model.getMedia=function(){return _media};_model.setupPlugins=function(){for(var plugin in _model.plugins.order){try{if(jwplayer.html5[_model.plugins.order[plugin]]!==undefined){_model.plugins.object[_model.plugins.order[plugin]]=new jwplayer.html5[_model.plugins.order[plugin]](_api,_model.plugins.config[_model.plugins.order[plugin]])}else{if(window[_model.plugins.order[plugin]]!==undefined){_model.plugins.object[_model.plugins.order[plugin]]=new window[_model.plugins.order[plugin]](_api,_model.plugins.config[_model.plugins.order[plugin]])}else{_model.plugins.order.splice(plugin,plugin+1)}}}catch(err){jwplayer.utils.log("Could not setup "+_model.plugins.order[plugin])}}};return _model}})(jwplayer);(function(a){a.html5.playlist=function(b){var d=[];if(b.playlist&&b.playlist instanceof Array&&b.playlist.length>0){for(var c in b.playlist){if(!isNaN(parseInt(c))){d.push(new a.html5.playlistitem(b.playlist[c]))}}}else{d.push(new a.html5.playlistitem(b))}return d}})(jwplayer);(function(a){a.html5.playlistitem=function(c){var b={author:"",date:"",description:"",image:"",link:"",mediaid:"",tags:"",title:"",provider:"",file:"",streamer:"",duration:-1,start:0,currentLevel:-1,levels:[]};for(var d in b){if(c[d]!==undefined){b[d]=c[d]}}if(b.levels.length===0){b.levels[0]=new a.html5.playlistitemlevel(b)}return b}})(jwplayer);(function(a){a.html5.playlistitemlevel=function(b){var d={file:"",streamer:"",bitrate:0,width:0};for(var c in d){if(b[c]!==undefined){d[c]=b[c]}}return d}})(jwplayer);(function(a){a.html5.skin=function(){var b={};var c=false;this.load=function(d,e){new a.html5.skinloader(d,function(f){c=true;b=f;e()},function(){new a.html5.skinloader("",function(f){c=true;b=f;e()})})};this.getSkinElement=function(d,e){if(c){try{return b[d].elements[e]}catch(f){a.utils.log("No such skin component / element: ",[d,e])}}return null};this.getComponentSettings=function(d){if(c){return b[d].settings}return null};this.getComponentLayout=function(d){if(c){return b[d].layout}return null}}})(jwplayer);(function(a){a.html5.skinloader=function(f,n,i){var m={};var c=n;var j=i;var e=true;var h;var l=f;var q=false;function k(){if(l===undefined||l===""){d(a.html5.defaultSkin().xml)}else{a.utils.ajax(a.utils.getAbsolutePath(l),function(r){try{if(r.responseXML!==null){d(r.responseXML);return}}catch(s){}d(a.html5.defaultSkin().xml)},function(r){d(a.html5.defaultSkin().xml)})}}function d(w){var C=w.getElementsByTagName("component");if(C.length===0){return}for(var F=0;F<C.length;F++){var A=C[F].getAttribute("name");var z={settings:{},elements:{},layout:{}};m[A]=z;var E=C[F].getElementsByTagName("elements")[0].getElementsByTagName("element");for(var D=0;D<E.length;D++){b(E[D],A)}var x=C[F].getElementsByTagName("settings")[0];if(x!==undefined&&x.childNodes.length>0){var I=x.getElementsByTagName("setting");for(var N=0;N<I.length;N++){var O=I[N].getAttribute("name");var G=I[N].getAttribute("value");var v=/color$/.test(O)?"color":null;m[A].settings[O]=a.utils.typechecker(G,v)}}var J=C[F].getElementsByTagName("layout")[0];if(J!==undefined&&J.childNodes.length>0){var K=J.getElementsByTagName("group");for(var u=0;u<K.length;u++){var y=K[u];m[A].layout[y.getAttribute("position")]={elements:[]};for(var M=0;M<y.attributes.length;M++){var B=y.attributes[M];m[A].layout[y.getAttribute("position")][B.name]=B.value}var L=y.getElementsByTagName("*");for(var t=0;t<L.length;t++){var r=L[t];m[A].layout[y.getAttribute("position")].elements.push({type:r.tagName});for(var s=0;s<r.attributes.length;s++){var H=r.attributes[s];m[A].layout[y.getAttribute("position")].elements[t][H.name]=H.value}if(m[A].layout[y.getAttribute("position")].elements[t].name===undefined){m[A].layout[y.getAttribute("position")].elements[t].name=r.tagName}}}}e=false;p()}}function p(){clearInterval(h);if(!q){h=setInterval(function(){o()},100)}}function b(w,v){var u=new Image();var r=w.getAttribute("name");var t=w.getAttribute("src");var y;if(t.indexOf("data:image/png;base64,")===0){y=t}else{var s=a.utils.getAbsolutePath(l);var x=s.substr(0,s.lastIndexOf("/"));y=[x,v,t].join("/")}m[v].elements[r]={height:0,width:0,src:"",ready:false};u.onload=function(z){g(u,r,v)};u.onerror=function(z){q=true;p();j()};u.src=y}function o(){for(var r in m){if(r!="properties"){for(var s in m[r].elements){if(!m[r].elements[s].ready){return}}}}if(e===false){clearInterval(h);c(m)}}function g(r,t,s){m[s].elements[t].height=r.height;m[s].elements[t].width=r.width;m[s].elements[t].src=r.src;m[s].elements[t].ready=true;p()}k()}})(jwplayer);(function(a){a.html5.api=function(b,k){var j={};if(!a.utils.html5SupportsConfig()){return j}var e=document.createElement("div");b.parentNode.replaceChild(e,b);e.id=b.id;j.version=a.version;j.id=e.id;var i=new a.html5.model(j,e,k);var g=new a.html5.view(j,e,i);var h=new a.html5.controller(j,e,i,g);j.skin=new a.html5.skin();j.jwPlay=function(l){if(typeof l=="undefined"){d()}else{if(l.toString().toLowerCase()=="true"){h.play()}else{h.pause()}}};j.jwPause=function(l){if(typeof l=="undefined"){d()}else{if(l.toString().toLowerCase()=="true"){h.pause()}else{h.play()}}};function d(){if(i.state==a.api.events.state.PLAYING||i.state==a.api.events.state.BUFFERING){h.pause()}else{h.play()}}j.jwStop=h.stop;j.jwSeek=h.seek;j.jwPlaylistItem=h.item;j.jwPlaylistNext=h.next;j.jwPlaylistPrev=h.prev;j.jwResize=h.resize;j.jwLoad=h.load;function f(l){return function(){return i[l]}}j.jwGetItem=f("item");j.jwGetPosition=f("position");j.jwGetDuration=f("duration");j.jwGetBuffer=f("buffer");j.jwGetWidth=f("width");j.jwGetHeight=f("height");j.jwGetFullscreen=f("fullscreen");j.jwSetFullscreen=h.setFullscreen;j.jwGetVolume=f("volume");j.jwSetVolume=h.setVolume;j.jwGetMute=f("mute");j.jwSetMute=h.setMute;j.jwGetStretching=f("stretching");j.jwGetState=f("state");j.jwGetVersion=function(){return j.version};j.jwGetPlaylist=function(){return i.playlist};j.jwAddEventListener=h.addEventListener;j.jwRemoveEventListener=h.removeEventListener;j.jwSendEvent=h.sendEvent;j.jwGetLevel=function(){};j.jwGetBandwidth=function(){};j.jwGetLockState=function(){};j.jwLock=function(){};j.jwUnlock=function(){};function c(n,m,l){return function(){n.loadPlaylist(n.config,true);n.setupPlugins();m.setup(n.getMedia().getDisplayElement());var o={id:j.id,version:j.version};l.sendEvent(a.api.events.JWPLAYER_READY,o);if(playerReady!==undefined){playerReady(o)}if(window[n.config.playerReady]!==undefined){window[n.config.playerReady](o)}n.sendEvent(a.api.events.JWPLAYER_PLAYLIST_LOADED,{playlist:n.playlist});l.item(n.item);if(n.config.autostart===true&&!n.config.chromeless){l.play()}}}if(i.config.chromeless){setTimeout(c(i,g,h),25)}else{j.skin.load(i.config.skin,c(i,g,h))}return j}})(jwplayer);

function bindPickerFormHandler (target,picker,container,spinner) {
    var handler = function() {
        var form = document.getElementById(picker);
        if (form) {
            var scrollTop = $(window).scrollTop();
            var viewportHeight = $(window).height();
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

