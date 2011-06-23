<%@ page import="storitz.constants.TransactionType" %>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head>
  <title>${title}</title>
  <meta name="DESCRIPTION" content="Storitz guarantees you the best deal on storage at ${site.title} in ${site.city}, ${site.state.display}.  Get photos, descriptions, driving directions and move-in today. "/>
  <g:meta name="keywords" content="Storage unit, self storage units, storage units, moving, storage units for rent, cheap storage units, storage unit rental, self storage, self storage facility, self storage facilities, air conditioned storage units, self storage rental, public self storage, security self storage, find self storage, self storage companies, Mini storage, mini self storage"/>
  <!-- change the height attribute when done. -->
    <style>

    body {
        width: 1000px;
    }

    .the_page {
        width: 990px;
        display: block;
        position: relative;
    }

    /* everything that is on the left of the page */
    #left_panel {
        display: inline-block;
        width: 690px;
        background-color: white;
        position: relative;
    }

    .site_logo {
        display: block;
        width: 680px;
        height: 130px;
        margin: 10px 0 10px 10px;
        background-color: white;
    }

    #site_logopic {
        display: block;
        float: left;
        width: 250px;
        height: 100px;
        padding-top: 16px;
    }

    #site_address {
        float: left;
        display: block;
        width: 420px;
        padding: 20px 0 0 10px;
        font: 11px arial, verdana, helvetica, sans-serif;
        font-weight: bold;
    }

    .site_logo h1.title {
        display: block;
        font-size: 18px;
        margin-bottom: 5px;
        color: #00529B;
        font-family: arial, verdana, helvetica, sans-serif;
    }

    .site_desc {
        display: block;
        width: 680px;
        margin: 10px 0 10px 10px;
        background-color: white;
    }

    .site_desc p {
        font-family: arial, verdana, helvetica, sans-serif;
        font-size: 13px;
    }

    .site_all_features {
        display: block;
        width: 680px;
        background-color: white;
        margin: 10px 0 10px 10px;
    }

    .site_all_features h2 {
        margin: 5px 0 0 0;
        color: white;
        background: url(../images/bkg-tablehead-666x30.gif) no-repeat;
        height: 30px;
        padding: 7px 0 10px 10px;
        width: 660px;
        font-family: verdana, arial, helvetica, sans-serif;
    }

    .site_features {
        display: block;
        float: left;
        width: 340px;
        height: 40px;
        padding: 10px 0 0 10px;
    }

    .site_features img {
        width: 20px;
        height: 20px;
        float: left;
        padding-right:5px;
    }

    #featuresList ul {
        -moz-border-radius:8px 8px 8px 8px;
        border:1px solid #dfdfdf;
        background-color:#fcfcfc;
        background-image:url(../images/bkg-features-list.jpg);
        background-position:center bottom;
        border-radius:8px 8px 8px 8px;
        background-repeat:repeat-x;
        margin:0 17px 0 0;
        overflow:hidden;
        padding:0;
        vertical-align:top;
        width:204px;
        display: inline-block;
    }

    #featuresList li {
        background:url(../images/check-mark.png) no-repeat left center;
        border-bottom: 1px solid #dfdfdf;
        border-top: 1px solid #fff;
        color:#333;
        font-family:Verdana, Geneva, sans-serif;
        font-size:11px;
        padding:10px 0 10px 45px;
        list-style:none;
        margin:0;
    }

    #featuresList li.safety {
        background:url(../images/icon-safety-security.png) no-repeat left center;
        border-bottom: 1px solid #dfdfdf;
        border-top:none;
        margin:0;
        padding:10px 0 10px 45px;
        vertical-align:middle;
    }

    .listHeader {
        color:#00529B;
        font-family: verdana, arial, helvetica, sans-serif;
        font-size:12px;
        font-weight:bold;
        margin: 0;
    }

    #featuresList li.convenience {
        background:url(../images/icon-convenience.png) no-repeat left center;
        border-bottom: 1px solid #dfdfdf;
        border-top:none;
        color:#134b98;
        font-size:12px;
        font-weight:bold;
        margin:0;
        padding:10px 0 10px 45px;
        vertical-align:middle;
    }

    #featuresList li.amenities {
        background:url(../images/icon-checkmark.png) no-repeat left center;
        border-bottom: 1px solid #dfdfdf;
        border-top:none;
        color:#134b98;
        font-size:12px;
        font-weight:bold;
        margin:0;
        padding:10px 0 10px 45px;
        vertical-align:middle;

    }

    #featuresList li.last {
        border-bottom:none;
        margin-bottom:10px;
    }

    #featuresList a {
        color:#333;
        text-decoration:none;
        font-family: Arial, verdana, helvetica, sans-serif;
        font-weight: bold;
    }

    #featuresList a:hover {
        color:#4595df;
        text-decoration:underline;
    }

    .tabs {
        padding: 0 0 0 12px;
        list-style-type: none;
        text-align: center;
        height:30px;
        border-bottom:1px solid #d3d3d3;
    }

    .tabs li {
        display: inline;
        padding: 0;
        margin: 0;
    }

    .tabs li a {
        float:left;
        font-size:13px;
        font-family: verdana, arial, helvetica, sans-serif;
        display:block;
        padding:5px 20px;
        border:1px solid #d3d3d3;
        border-bottom:0px;
        height:18px;
        background-color:#efffff;
        text-decoration:none;
        font-weight: bold;
        color:#00529B;
        margin-right:2px;
        position:relative;
        top:1px;
        outline:0;
        -moz-border-radius-topright: 5px;
        -webkit-border-top-right-radius: 5px;
        -khtml-border-radius-top-right: 5px;
        border-top-right-radius: 5px;
        -moz-border-radius-topleft: 5px;
        -webkit-border-top-left-radius: 5px;
        -khtml-border-radius-top-left: 5px;
        border-top-left-radius: 5px;
        -moz-box-shadow: 0px 0px 15px skyblue;
        -webkit-box-shadow: 0px 0px 15px skyblue;
        box-shadow: 0px 0px 15px skyblue;
    }

    .tabs li a:hover {
        background-color:#90c0f0;
    }

    .tabs li a.current {
        background-color:#fff;
        border-bottom:1px solid #fff;
        cursor:default;
        -moz-box-shadow: 0px -5px 10px skyblue;
        -webkit-box-shadow: 0px -5px 10px skyblue;
        box-shadow: 0px -5px 10px skyblue;
    }

    .panes {
        display: block;
        width: 680px;
        overflow: hidden;
    }

    .panes>div {
        display:block;
        border:1px solid #666;
        border-width:0 0 0 0;
        padding:10px 12px 0 0;
        background-color:#fff;
    }

    .panes .main_pic {
        display: block;
        width: 240px;
        height: 160px;
        margin: 10px 0 10px 10px;
    }

    .panes .left_panes {
        display: inline-block;
        float: left;
        width: 265px;
    }

    .panes .right_panes {
        display: inline-block;
        width: 350px;
        padding-top: 10px;
    }

    .right_panes .yelp_icons {
        width: inherit;
        height: 30px;
        display: inline-block;
        margin: 0 0 20px 0;
        background-color: white;
    }

    .yelp_icons input, .yelp_icons a {
        float: right;
        display: inline-block;
    }

    .yelp_icons .icons {
        display: inline-block;
        width: 140px;
        height: 20px;
        float: right;
    }

    .icons #print_button {
        background: url("../images/print-icon-15x13.png") no-repeat;
        width: 33px;
        height: 20px;
        padding: 0 8px 0 22px;
        font: 12px Arial, Verdana, Helvetica, sans-serif;
        font-weight: bold;
        text-decoration: none;
        color: #00529B;
    }

    #print_button:hover {
        opacity: 0.7;
        filter: alpha(opacity=70);
    }

    .right_panes .overview_desc {
        width: inherit;
        display: block;
    }

    .stbutton {
        float: right;
        font-weight: bold;
        padding-top: 2px;
    }

    .icons .stbutton .email {
        background-position: 0 20px;
        background: url("../images/email-icon-13x10.png") no-repeat;
    }

    .icons .stbutton .chicklets {
        color: #00529B;
        padding-left: 20px;
        line-height: 10px;
        font-family: arial, verdana, helvetica, sans-serif;
        font-size: 12px;
    }

    /*everything that is on the right of the page */
    #right_panel {
        display: block;
        width: 300px;
        background-color: white;
        position: absolute;
        top: 0px;
        right: 0px;
    }

    .transaction {
        display: block;
        width: 280px;
        margin: 10px 10px 0 0;
    }

    .sim_units {
        display: block;
        width: 300px;
        background-color: white;
        margin: 30px 0 0 0;
    }

    .sim_units #units {
        display: block;
        width: inherit;
        padding: 10px 0 10px 0;
    }

    .sim_units .units_bottom {
        display: block;
        width: inherit;
        height: 40px;
    }

    .separator {
        height: 0;
        clear: both;
        width: 280px;
        border-bottom: 1px solid #dfdfdf;
        margin: 0 0 10px 0;
    }

    #units .unit {
        display: block;
        width: inherit;
        height: 100px;
    }

    .unit img {
        width: 80px;
        height: 80px;
        display: block;
        float: left;
        padding: 10px 10px 10px 0;
    }

    .unit .unit_text {
        display: block;
        float: left;
        width: 210px;
        height: 100px;
        padding: 10px 0 0 0;
        font-family: arial;
        font-weight: bold;
    }

    .unit_text h2 {
        font-family: arial;
        font-weight: bold;
        color: #00529B;
        margin-bottom:5px;
        font-size: 14px;
    }

    .unit_text h3 {
        font-family: arial;
        font-weight: bold;
        display: inline;
        font-size: 14px;
    }

    .transBox {
        padding: 0;
        -moz-border-radius: 8px;
        -webkit-border-radius: 5px;
        border:1px solid #dfdfdf;
        background-color:#fcfcfc;
        background-image:url("../images/bkg-features-list.jpg");
        background-position: center bottom;
        border-radius:8px;
        background-repeat:repeat-x;
        vertical-align:top;
        box-shadow: 0 0 6px #888;
    }

    .transBox .price {
        vertical-align: bottom;
        text-align: center;
        padding-top: 10px;
    }

    .transBox .rent_reserve {
        margin-top: 5px;
    }

    .transBox .rent_reserve h3 {
        text-align: center;
        padding-bottom: 10px;
        color: green;
        font-weight: bold;
        font-family: arial;
        font-size: 11px;
    }

    #rentme {
        width: 260px;
        height: 36px;
        border: none;
        cursor: pointer;
        padding: 5px 10px 5px 10px;
    }

    .transBox .move_in {
        width: 263px;
        height: 40px;
        padding: 22px 15px 10px 0;
        background-color: #87F1F8;
    }

    .transDateHeader {
        width: 80px;
        display: inline-block;
        font: 12px arial, verdana, helvetica, sans-serif;
        font-weight: bold;
        text-align: left;
        padding: 0 0 5px 10px;
    }

    .paidThrough {
        font: 12px arial, verdana, helvetica, sans-serif;
        text-align: left;
        padding: 8px 0 5px 0;
        font-weight: bold;
        color: #888888;
        display: inline-block;
    }

    .move_in .calendar {
        width: 25px;
        float: right;
        display: inline-block;
        margin-top: -2px;
    }

    #calendarPic {
        cursor: pointer;
        width: 23px;
        height: 19px;
    }

    .transDate {
        display: inline-block;
        float: right;
        font: 12px  arial, verdana, helvetica, sans-serif;
        font-weight: bold;
        text-align: right;
    }

    .changeDate {
        display: inline-block;
        float: right;
    }

    .changeDate a {
        font-family: helvetica;
        color: #00529B;
    }

    .unit_size, .amenities, .compare_unit {
        padding-top: 12px;
        margin-left: 10px;
        margin-right: 10px;
    }

    .unit_size h4 {
        display: inline;
        font-family: verdana;
        color: #00008b;
    }

    .unit_size a {
        color: green;
        font-family: arial;
        font-weight: bold;
    }

    .amenities ul {
        line-height: 15px;
    }

    .amenities li {
        font-family: helvetica;
        font-weight: bold;
    }

    .transBox a {
        float: right;
        font-size: 10px;
    }

    .transPrice {
        font: 18px arial, verdana, helvetica, sans-serif;
        font-weight: bold;
    }

    .transPerMonth {
        font-family: helvetica, arial, verdana, sans-serif;
        font-weight: bold;
    }

    .promos {
        font-size: 14px;
        color: #00529B;
        margin: 0 10px 0 10px;
        padding: 15px 0 10px 0;
        font-family: helvetica;
        font-weight: bold;
    }

    .compare_unit {
        font: 12px arial, verdana, helvetica, sans-serif;
        font-weight: bold;
        color: #00529B;
        text-align: right;
    }

    .transTotalMoveIn {
        margin-left: 10px;
        font: 13px verdana, helvetica, sans-serif;
        font-weight: bold;
        color: #00008b;
    }

    #totalMoveInCost {
        float: right;
        margin-right: 20px;
    }

    .transTotalMoveIn p {
        font: 11px helvetica, sans-serif;
        margin-top: 2px;
        padding-bottom: 15px;
        font-weight: bold;
    }

    .sim_units h1 {
        font: 15px verdana, helvetica, sans-serif;
        font-weight: bold;
        color: #00529B;
    }

    </style>
</head>
<body>
    <div class="the_page">
    <div id="left_panel">
        <div class="site_logo">
            <g:render template="/siteInfo"/>
        </div>
        <div class="site_desc">
            <!-- the tabs -->
            <ul class="tabs">
                <li><a class="current" href="#tab_overview">Overview</a></li>
                <li><a class="current" href="#tab_allunits">All Units</a></li>
                <li><a class="current" href="#tab_video">Video</a></li>
                <li><a class="current" href="#tab_maphours">Map &amp; Hours</a></li>
                <li><a class="current" href="#tab_reviews">Reviews</a></li>
                <li><a class="current" href="#tab_auctions">Auctions</a></li>
            </ul>
            <!-- the panes -->
            <div class="panes">
                <div>  <!-- first tab -->

                    <div class="left_panes"> <!-- more elems inside this div -->
                    <g:if test="${site.coverImage()}">
                      <img class="main_pic" src="${resource(file: site.coverImage().mid())}" alt="Image of ${site.title} located in ${site.city}, ${site.state.fullName}">
                    </g:if>
                    </div>
                    <div class="right_panes"> <!-- icons and description here -->
                        <div class="yelp_icons">
                            <div class="icons">
                                <span  class='st_email' displayText='Share'></span>
                                <a id="print_button" href="#"> Print
                                    %{--<img src="../images/print-icon-15x13.png" />Print--}%
                                </a>
                            </div>
                        </div>
                        <div class="overview_desc">
                            <p>${site.description}</p>
                        </div>
                    </div>
                    <a name="tab_overview">&nbsp;</a>
                </div>
                <div><a name="tab_allunits">&nbsp;</a><!-- second tab-->blah blah blah blah blah</div>
                <div><a name="tab_video">&nbsp;</a><!-- third tab-->blah blah blah blah blah</div>
                <div><a name="tab_maphours">&nbsp;</a><!-- fourth tab-->blah blah blah blah blah</div>
                <div><a name="tab_reviews">&nbsp;</a><!-- fifth tab-->blah blah blah blah blah</div>
                <div><a name="tab_auctions">&nbsp;</a><!-- sixth tab-->blah blah blah blah blah</div>
            </div>
        </div>
        <div class="site_all_features">
            <h2>Site Features</h2>
            <div id="featuresList">
                <ul>
                  <li class="safety"><h3 class="listHeader">Safety/Security</h3></li>
                  <g:each in="${site.securityItems}" status="i" var="item">
                    <li ${i == site.securityItems.size() - 1 ? 'class="last"' : ''}><a href="#">${item.bullet}</a></li>
                  </g:each>
                </ul>
                <ul>
                  <li class="convenience"><h3 class="listHeader">Convenience</h3></li>
                  <g:each in="${site.convenienceItems}" status="i" var="item">
                    <li ${i == site.convenienceItems.size() - 1 ? 'class="last"' : ''}><a href="#">${item.bullet}</a></li>
                  </g:each>
                </ul>
                <ul>
                  <li class="amenities"><h3 class="listHeader">Amenities</h3></li>
                  <g:each in="${site.amenityItems}" status="i" var="item">
                    <li ${i == site.amenityItems.size() - 1 ? 'class="last"' : ''}><a href="#">${item.bullet}</a></li>
                  </g:each>
                </ul>
            </div>
        </div>
    </div>
    <div id="right_panel">
        <div class="transaction">
            <g:render template="/transaction"/>
        </div>
        <div class="sim_units">
            <h1>Similar Units in your Area</h1>
            <div id="units">
                <div class="separator"></div>
                <div class="unit">
                    <img src="#" />
                    <div class="unit_text">
                        <h2>Pacoima - Glen Oaks Blvd</h2>
                        <h3>$79.00</h3>/mo.
                        <p>5.8 miles from this facility</p>
                    </div>
                </div>
                <div class="separator"></div>
                <div class="unit">
                    <img src="#" />
                    <div class="unit_text">
                        <h2>Pacoima - Glen Oaks Blvd</h2>
                        <h3>$79.00</h3>/mo.
                        <p>5.8 miles from this facility</p>
                    </div>
                </div>
                <div class="separator"></div>
                <div class="unit">
                    <img src="#" />
                    <div class="unit_text">
                        <h2>Pacoima - Glen Oaks Blvd</h2>
                        <h3>$79.00</h3>/mo.
                        <p>5.8 miles from this facility</p>
                    </div>
                </div>
                <div class="separator"></div>
                <div class="unit">
                    <img src="#" />
                    <div class="unit_text">
                        <h2>Pacoima - Glen Oaks Blvd</h2>
                        <h3>$79.00</h3>/mo.
                        <p>5.8 miles from this facility</p>
                    </div>
                </div>
                <div class="separator"></div>
            </div>
            <div class="units_bottom">
                <a href="#">View More...</a>
                <input type="button" value="Compare" />
            </div>
        </div>
    </div>
    </div>
        <p:dependantJavascript>
            <script type="text/javascript">var switchTo5x=true;</script>
            <script type="text/javascript" src="http://w.sharethis.com/button/buttons.js"></script>
            <script type="text/javascript">stLight.options({publisher:'fcffc560-5a11-434a-b976-a60a57d870ed'});</script>
            <script type="text/javascript">
            $(document).ready(function() {
                $("ul.tabs").tabs("div.panes > div");
                $("#print_button").click(function() {
                    window.print();
                    return false;
                });

                var left = $("#left_panel").height();
                var right = $("#right_panel").height();
                var max_height = Math.max(left, right);

                $(".the_page").height(max_height);

                //browser specifics for IE
                if ($.browser.msie) {
                    $("#featuresList ul").css("float", "left");

                    $("#rentme").css("margin-left", "10px");
                }
            });
            </script>
        </p:dependantJavascript>

</body>
</html>