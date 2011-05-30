<%@ page import="storitz.constants.TransactionType; storitz.constants.SearchType; storitz.constants.UnitType; storitz.constants.TruckType" %>
<html>
<head>
    <g:render template="/header_college"/>
    <script type="text/javascript">
      var _gaq = _gaq || [];
        _gaq.push(["_setCustomVar", 1, "nresults", "${sites.size}"]);
        // TODO: track additional properties of result set: closest result, avg distance, # results w/in 2/5/10 mi, etc.
    </script>
    <style type="text/css">
        h1 {
            color:${college.primaryFGColor ?: 'blue'};
            background:${college.primaryBGColor ?: 'wheat'} url(../images/bg-text-line.png) repeat-x;
        }
        #secondary-color {
            display: block;
            background:${college.secondaryBGColor ?: 'blue'} url(../images/bg-text-line-2.png) repeat-x;
        }
        #footer {
            background:${college.primaryBGColor ?: 'wheat'};
        }
        #college_logo {
            background: url(${resource(file: college.logoBaseName + college.logoFileLoc)}) no-repeat;
        }
    </style>
</head>
<body class="college">
<div id="promo">
    <storitz:image src="img-15.jpg" alt="image description" width="949" height="268" />
    <p class="tagline">Got a few things you don’t want to keep at Mom &amp; Dad’s?</p>
    <p><a href="http://www.storitz.com">Storitz.com</a> lets you compare 1000s of
    summer storage units and rent all online with our
    <g:link controller="static" action="guarantee"><em>Best Price
    Guarantee</em></g:link>.</p>
    <p><a href="#" id="rebate_tile">Rent your storage unit online today from
    storitz.com and get $20 cash back! Click for details</a></p>
    <div class="photo_credit">Photo by <a href="http://www.collegehumor.com" target="_blank">collegehumor.com</a></div>
</div>
<div id="main_container">
    <div id="college_logo">&nbsp;</div>
    <h1>Self Storage Units Near <span class="college_name">${college.displayName}</span></h1>
    <div id="secondary-color">
        <a class="button small black" href="#map-view" id="toggle_map_view">Map View</a>
    </div>
    <div id="rebate_panel">
        <storitz:image src="rebate20-header-large.png" width="749" height="63" />
        <dl>
            <dt>How to Claim Your Rebate</dt>
            <dd>Once you rent or reserve a storage unit, you'll receive an email from us with a link
            to your rebate form &amp; instructions for sending it to us! Simple!</dd>
        </dl>
        <a class="close button">Close</a>
    </div>
    <g:link action="storageTips" elementId="college_tips_button">Storage 101: College Summer Storage Tips for Students</g:link>
    <div id="college_tips_panel">
      <a class="close" href="#">Close</a>
      <iframe src="<g:createLink action="storageTips" params="[layout:'min']" />"></iframe>
    </div>
    <g:if test="${sites.size() > 0}">
        <div id="big_map_canvas"></div>
        <ul id="search_result_labels">
            <li class="photo">&nbsp;</li>
            <li class="facility">Facility</li>
            <li class="unit_info">Unit Type <a href="#">filter</a></li>
            <li class="special">Student Special</li>
            <li class="price">Price</li>
            <li class="rent_button"></li>
        </ul>
        <ul id="search_results">
            <g:each var="site" in="${sites}" status="c">
                <li class="line" id="site_${site.id}">
                    <g:render template="/clientSite" model="['site':site, 'unitInfo':siteMoveInPrice[site.id]]" />
                    <g:if test="${isAdmin}">
                        <div class="admin_strip">
                            <span class="operator_name">Operator: ${site.feed.operatorName}</span>
                            <g:link controller="storageSite" action="edit" id="${site.id}" class="button white small"
                                    fragment="special_offers" target="_blank">specials</g:link>
                        </div>
                    </g:if>
                </li>
            </g:each>
        </ul>
    </g:if>
</div>
<div id="map_popup" class="tooltip">
    <a class="close button small black">close</a>
    <p><!-- 1234 Main St. --></p>
    <div id="maplet_canvas" style="width:320px; height:320px"></div>
</div>
</body>
</html>
