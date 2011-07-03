<%@ page import="storitz.constants.TransactionType" %>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head>
<title>${title}</title>
<meta name="DESCRIPTION"
      content="Storitz guarantees you the best deal on storage at ${site.title} in ${site.city}, ${site.state.display}.  Get photos, descriptions, driving directions and move-in today. "/>
<g:meta name="keywords"
        content="Storage unit, self storage units, storage units, moving, storage units for rent, cheap storage units, storage unit rental, self storage, self storage facility, self storage facilities, air conditioned storage units, self storage rental, public self storage, security self storage, find self storage, self storage companies, Mini storage, mini self storage"/>
<!-- change the height attribute when done. -->
<style>

.container {
  position: relative;
}
body.site_detail .container {
  margin-top: 10px;
}

body.site_detail {
  font-family: Arial;
}
body.site_detail #header form {
  display: none;
}
body.site_detail #left_panel {
  display: inline-block;
  width: 657px;
  margin-right: 3px;
  background-color: white;
  position: relative;
}

body.site_detail .vcard {
  height: 140px;
  background: url("../images/v2/site_detail/bg-fade-facility-tabs.jpg") repeat-x;
  background-position: left bottom;
  clear: both;
}
body.site_detail .vcard > div {
  float: left;
  display:inline-block;
}
body.site_detail .vcard .site_logo {
  margin-right: 20px;
}
body.site_detail #site_address .tel {
  font-weight: bold;
}
body.site_detail #site_address {
  width: 387px;
  font-size: 11px;
}
body.site_detail .site_info {
  margin-top: -30px;
}
.breadcrumbs {
  color: #025895;
  margin-bottom: 5px;
  margin-left: 5px;
  font-size: 11px;
  font-family: Arial;
}
.breadcrumbs a {
  color: #3EA307;
  text-decoration: none;
}

body.site_detail .tabs li a,
body.site_detail h1,
body.site_detail a.action_links,
body.site_detail h2,
body.site_detail h3,
.breadcrumbs a.current {
  color: #025895;
}
body.site_detail .vcard h1 {
  font-family: Arial;
  font-size: 24px;
  font-weight: normal;
  margin: 10px 0 5px 0;
}

body.site_detail .site_features h2 {
  /*margin: 5px 0 0 0;*/
  color: white;
  background: url("../images/v2/site_detail/facility-subheader-bg-tile.png") repeat-x;
  height: 24px;
  padding-top: 9px;
  padding-left: 9px;
  color: white;
  font-family: Verdana;
  font-weight:normal;
  border-radius: 4px 4px 4px 4px;
  margin-right: 9px;
}

.site_features {
  padding-top: 10px;
}

.site_features img {
  width: 20px;
  height: 20px;
  float: left;
  padding-right: 5px;
}

.site_features div {
  -moz-border-radius: 8px 8px 8px 8px;
  border: 1px solid #dfdfdf;
  background-color: #fcfcfc;
  background-image: url(../images/bkg-features-list.jpg);
  background-position: center bottom;
  border-radius: 8px 8px 8px 8px;
  background-repeat: repeat-x;
  margin: 0 12px 0 0;
  overflow: hidden;
  padding: 0;
  vertical-align: top;
  width: 204px;
  display: inline-block;
}
.site_features div.last {
  margin-right: 0;
}
.site_features li,
.site_features h3 {
  border-bottom: 1px solid #dfdfdf;
  font-family: Verdana, Geneva, sans-serif;
  font-size: 11px;
  padding: 10px 0 10px 45px;
  margin: 0;
  vertical-align: middle;
  font-weight: bold;
}
.site_features li {
  color: #333;
  list-style: none;
  border-top: 1px solid #fff;
  background: url(../images/check-mark.png) no-repeat left center;
}
.site_features li.last {
  border-bottom: none;
}
.site_features h3 {
  color: #134b98;
  font-size: 12px;
  font-weight: bold;
  margin: 0;
}
.site_features h3.safety {
  background: url(../images/icon-safety-security.png) no-repeat left center;
}
.site_features h3.convenience {
  background: url(../images/icon-convenience.png) no-repeat left center;
}
.site_features h3.amenities {
  background: url(../images/icon-checkmark.png) no-repeat left center;
}

.tabs {
  padding: 0 0 0 12px;
  list-style-type: none;
  text-align: center;
  height: 28px;
}

.tabs li {
  display: inline;
  padding: 0;
  margin: 0;
}

.tabs li a {
  float: left;
  font-size: 13px;
  display: inline-block;
  padding: 7px 20px 7px 20px;
  border-color: #d3d3d3;
  border-style: solid;
  border-width: 1px 1px 0 1px;
  height: 13px;
  text-decoration: none;
  font-weight: bold;
  margin-right: 2px;
  position: relative;
  top: 1px;
  outline: 0;
  -moz-border-radius-topright: 5px;
  -webkit-border-top-right-radius: 5px;
  -khtml-border-radius-top-right: 5px;
  border-top-right-radius: 5px;
  -moz-border-radius-topleft: 5px;
  -webkit-border-top-left-radius: 5px;
  -khtml-border-radius-top-left: 5px;
  border-top-left-radius: 5px;
}

.tabs li a:hover {
  background-color: #90c0f0;
}

.tabs li a.current {
  background-color: #fff;
  border-bottom-width: 0px;
  cursor: default;
  -moz-box-shadow: 0px 0px 4px #025895;
  -webkit-box-shadow: 0px 0px 4px #025895;
  box-shadow: 0px 0px 4px #025895;
}

.panes {
  display: block;
  overflow: hidden;
  border-top: 1px solid #aaa;
  background-color: white;
  position: relative;
}

.panes>div {
  display: block;
  border: 1px solid #666;
  border-width: 0 0 0 0;
  padding: 10px 12px 0 0;
  background-color: #fff;
}

.panes .main_pic {
  display: block;
  width: 240px;
  height: 160px;
  margin: 10px 0 10px 0;
}

.panes .overview .photos {
  display: inline-block;
  float: left;
  width: 265px;
}

.panes .overview .description {
  display: inline-block;
  width: 350px;
  padding-top: 10px;
}

.panes .overview ul.action_links {
  display: inline-block;
  float: right;
  margin: 0 0 10px 10px;
  padding-left: 10px;
  border-left: 1px dotted #ccc;
}
.panes .overview ul.action_links li {
  display: block;
  margin-bottom: 4px;
}

.panes .overview ul.action_links li a.print {
  display: inline-block;
  padding-top: 4px;
  background: url("../images/v2/buttons/printer_icon_small.gif") no-repeat;
  background-position: 4px center;
  padding-left: 24px;
  height: 16px;
  font-family: Verdana, Helvetica, sans-serif;
}

a.print:hover {
  opacity: 0.6;
}

  /*everything that is on the right of the page */

.move_in_quote { position: relative; }
a.help_button {
  display: inline-block;
  background: url("../images/v2/buttons/help-12x12.png") no-repeat;
  width: 12px;
  height: 12px;
  text-indent: -9999px;
  position: absolute;
  margin-left: 3px;
}
#right_panel {
  display: block;
  width: 300px;
  background-color: white;
  position: absolute;
  top: 0px;
  right: 0px;
}

.rent_me {
  padding: 0;
  -moz-border-radius: 8px;
  -webkit-border-radius: 8px;
  border: 1px solid #aaaaaa;
  background-image: url("../images/v2/site_detail/bg-transaction-box-align-bottom.jpg");
  background-position: center bottom;
  border-radius: 8px;
  background-repeat: repeat-x;
  vertical-align: top;
  box-shadow: 0 0 8px #cccccc;
}
.rent_me > div {
  padding: 12px 12px;
  border-color: #aaa;
  border-width: 1px 0 0 0;
  border-style: solid;
}

.rent_me > div.price .original_price {
  font-size: 16px;
  font-weight: normal;
  color: red;
  text-decoration: line-through;
}

.rent_me > div.price {
  font: 22px arial, verdana, helvetica, sans-serif;
  font-weight: bold;
  padding-bottom: 0;
  vertical-align: bottom;
  text-align: center;
}

.rent_me > div.rent_reserve {
  padding-bottom: 4px;
}

.rent_me > div.price,
.rent_me > div.rent_reserve {
  border-width: 0;
}

.rent_me > div.price .per_month {
  font-size: 12px;
  font-weight: normal;
}

.rent_me > div.rent_reserve .guarantee {
  background: url("../images/v2/site_detail/checkmark-20x19.png") no-repeat;
  background-position: 50px center;
  padding: 13px 0 10px 75px;
  font-weight: bold;
  color: #3EA307;
}

.rent_me > div.move_in_date {
  padding-top: 15px;
  padding-bottom: 30px;
  font-weight: bold;
}

.rent_me > div.move_in_date a.edit_date {
  padding-left: 28px;
  background: url("../images/icn-calendar.png") no-repeat;
  background-position: left top;
  float: right;
  display: inline-block;
  text-decoration: none;
  line-height: 150%;
  margin-top: -5px;
}
.rent_me > div.move_in_date a.edit_date .date_label {
  font-weight:bold;
  color: black;
}
.rent_me > div.move_in_date a.edit_date .link {
  text-decoration: underline;
  text-align: right;
  font-size: 11px;
  font-weight: normal;
}

.rent_me > div.unit_info a.view_more {
  float: right;
  font-size: 11px;
  margin-top: 1px;
}
.rent_me > div.unit_info .promos a.view_more {
  margin-top: 0px;
}
.rent_me div.unit_info h4 {
  font-size: 14px;
  color: black;
  margin-bottom: 7px;
  color: #025895;
}
.rent_me > div.unit_info .promos .label { display : none; }
.rent_me > div.unit_info .promos .label,
.rent_me > div.unit_info .promos a.view_more {
  font-weight: normal;
}
.rent_me > div.unit_info .promos {
  margin-top: 5px;
  font-weight: bold;
}
#move_in_cost {
  float: right;
}
.rent_me > div.move_in_quote h4 {
  margin-bottom: 4px;
}
.rent_me > div.move_in_quote p {
  font: 10px arial, verdana, helvetica, sans-serif;
  margin-top: 2px;
}

.sim_units {
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
}

.sim_units h1 {
  font: 16px arial, verdana, helvetica, sans-serif;
  font-weight: bold;
  color: #00529B;
}

</style>
</head>

<body class="site_detail">
<div class="breadcrumbs">
  <a href="#">Home</a> &gt;
  <a href="#">California</a> &gt;
  <a href="#">Los Angeles</a> &gt;
  <a href="#" class="current">${site.title}</a>
</div>
<div class="container">
  <div id="left_panel">
    <div class="vcard">%{-- TODO: vcardify --}%
      <g:if test="${site?.logo}">
        <div class="site_logo"><img src="${resource(file: site.logo.src())}" width="250" height="100" alt="${site.title} Logo"/></div>
      </g:if>
      <div id="site_address">
        <h1 class="title">${site.title}</h1>
        ${site.address}
        ${site.address2}
        ${site.city}, ${site.state.display} ${site.zipcode}
        <span class="tel">(877) 456-2929</span>
        <sec:ifAnyGranted roles="ROLE_CALLCENTER, ROLE_CALLCENTER_ADMIN">
            Direct Phone: ${site.phone}
        </sec:ifAnyGranted>
        <div class="site_features">
            <g:if test="${site.freeTruck  == storitz.constants.TruckType.FREE}">
                <storitz:image src="icon3d-rentaltruck32f.gif" alt="Free Truck"/>
            </g:if>
            <g:if test="${site.freeTruck  == storitz.constants.TruckType.RENTAL}">
                <storitz:image src="icon3d-rentaltruck32r.gif" alt="Rental Truck"/>
            </g:if>
            <g:if test="${site.isGate}">
                <storitz:image src="icon3d-gate32.jpg" alt="Gated"/>
            </g:if>
            <g:if test="${site.isKeypad}">
                <storitz:image src="icon3d-keypad32.jpg" alt="Keypad"/>
            </g:if>
            <g:if test="${site.isCamera}">
                <storitz:image src="icon3d-camera32.jpg" alt="Camera"/>
            </g:if>
            <g:if test="${site.isUnitAlarmed}">
                <storitz:image src="icon3d-alarm32.jpg" alt="Alarmed"/>
            </g:if>
            <g:if test="${site.isManagerOnsite}">
                <storitz:image src="icon3d-mgr32b.jpg" alt="Manager Onsite"/>
            </g:if>
            <g:if test="${site.hasElevator}">
                <storitz:image src="icon3d-elevator32.jpg" alt="Elevator Available"/>
            </g:if>
        </div>
      </div>
    </div>
    <div class="site_info">
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
        <div class="overview"><!-- first tab -->
          <div class="photos"><!-- more elems inside this div -->
            <g:if test="${site.coverImage()}">
              <img class="main_pic" src="${resource(file: site.coverImage().mid())}"
                   alt="Image of ${site.title} located in ${site.city}, ${site.state.fullName}">
            </g:if>
          </div>
          <p class="description">
            <ul class="action_links">
              <li><span class="st_email" displayText="Share"></span></li>
              <li><a class="print" href="#" onclick="window.print();">Print</a></li>
            </ul>
            ${site.description}
         </p>
          <a name="tab_overview">&nbsp;</a>
        </div>

        <div><!-- second tab-->
          blah blah blah blah blah
          <a name="tab_allunits">&nbsp;</a>
        </div>

        <div><!-- third tab-->
          blah blah blah blah blah
          <a name="tab_video">&nbsp;</a>
        </div>

        <div>
          <!-- fourth tab-->
          blah blah blah blah blah
          <a name="tab_maphours">&nbsp;</a>
        </div>

        <div>
          <!-- fifth tab-->
          blah blah blah blah blah
          <a name="tab_reviews">&nbsp;</a>
        </div>

        <div>
          <!-- sixth tab-->
          blah blah blah blah blah
          <a name="tab_auctions">&nbsp;</a>
        </div>
      </div>
    </div>

    <div class="site_features">
      <h2>Site Features</h2>
      <div>
        <h3 class="safety">Safety/Security</h3>
        <ul>
          <g:each in="${site.securityItems}" status="i" var="item">
            <li ${i == site.securityItems.size() - 1 ? 'class="last"' : ''}>${item.bullet}</li>
          </g:each>
        </ul>
      </div>
      <div>
        <h3 class="convenience">Convenience</h3></li>
        <ul>
        <g:each in="${site.convenienceItems}" status="i" var="item">
          <li ${i == site.convenienceItems.size() - 1 ? 'class="last"' : ''}>${item.bullet}</li>
        </g:each>
        </ul>
      </div>
      <div class="last">
        <h3 class="amenities">Amenities</h3></li>
        <g:each in="${site.amenityItems}" status="i" var="item">
          <li ${i == site.amenityItems.size() - 1 ? 'class="last"' : ''}>${item.bullet}</li>
        </g:each>
        </ul>
      </div>
    </div>
  </div>

  <div id="right_panel">
    <g:render template="/transaction"/>

    <div class="sim_units">
      <h1>Similar units nearby</h1>

      <div id="units">
        <div class="separator"></div>

        <div class="unit">
          <img src="#"/>

          <div class="unit_text">
            <h2>Pacoima - Glen Oaks Blvd</h2>

            <h2>$79.00/mo.</h2>

            <p>5.8 miles from this facility</p>
          </div>
        </div>

        <div class="separator"></div>

        <div class="unit">
          <img src="#"/>

          <div class="unit_text">
            <h2>Pacoima - Glen Oaks Blvd</h2>

            <h2>$79.00/mo.</h2>

            <p>5.8 miles from this facility</p>
          </div>
        </div>

        <div class="separator"></div>

        <div class="unit">
          <img src="#"/>

          <div class="unit_text">
            <h2>Pacoima - Glen Oaks Blvd</h2>

            <h2>$79.00/mo.</h2>

            <p>5.8 miles from this facility</p>
          </div>
        </div>

        <div class="separator"></div>

        <div class="unit">
          <img src="#"/>

          <div class="unit_text">
            <h2>Pacoima - Glen Oaks Blvd</h2>

            <h2>$79.00/mo.</h2>

            <p>5.8 miles from this facility</p>
          </div>
        </div>

        <div class="separator"></div>
      </div>

      <div class="units_bottom">
        <a href="#">View More...</a>
        <input type="button" value="Compare"/>
      </div>
    </div>
  </div>
</div>


<p:dependantJavascript>
  <script type="text/javascript">var switchTo5x = true;</script>
  <script type="text/javascript" src="http://w.sharethis.com/button/buttons.js"></script>
  <script type="text/javascript">stLight.options({publisher:'fcffc560-5a11-434a-b976-a60a57d870ed'});</script>
  <script type="text/javascript">
    $(document).ready(function() {
      $("ul.tabs").tabs("div.panes > div");

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