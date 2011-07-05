<%@ page import="storitz.constants.TransactionType" %>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head>
<title>${title}</title>
<meta name="DESCRIPTION"
      content="Storitz guarantees you the best deal on storage at ${site.title} in ${site.city}, ${site.state.display}.  Get photos, descriptions, driving directions and move-in today. "/>
<g:meta name="keywords"
        content="Storage unit, self storage units, storage units, moving, storage units for rent, cheap storage units, storage unit rental, self storage, self storage facility, self storage facilities, air conditioned storage units, self storage rental, public self storage, security self storage, find self storage, self storage companies, Mini storage, mini self storage"/>
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
      <h1>Similar Units Nearby</h1>

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