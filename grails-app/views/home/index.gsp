<%@ page import="org.codehaus.groovy.grails.commons.ConfigurationHolder; com.storitz.StoritzUtil; java.math.RoundingMode" %>
<html>
<head>
    <title>Self Storage Units - Best Price Guaranteed - Storitz.com</title>
    <meta name="keywords" content="self storage, mini storage, storage units, self storage units, mini storage units, storage lockers, rv storage, boat storage, military storage, student storage, storage, storitz" />
    <meta name="description" content="Find, compare and rent self storage units and mini storage near you. Storitz guarantees that you will get the best deal.  It's the smartest way to shop for self storage anywhere in the U.S." />
    <meta name="layout" content="splash"/>
    <!--[if IE]> <link href="${resource(dir:'css', file:'application_ie.css')}" rel="stylesheet" type="text/css"> <![endif]-->
</head>
<body>
<div id="bigbox">
    <span id="storitz-logo"${(ConfigurationHolder.config?.storitz?.beta) ? ' class="beta"' : ''}">
        Storitz.com. Click. Store. Done.
        <g:link controller="home" action="index"></g:link>
    </span>
    <h1>
        <span class="first-child">Simplify your search for self storage.</span>
    </h1>
    <div class="socialButtons">
        ${"<g:plusone size='medium'></g:plusone>"}
        <iframe id="splash_fb" src="http://www.facebook.com/plugins/like.php?app_id=204418169614657&amp;href=http%3A%2F%2Fwww.storitz.com&amp;send=false&amp;layout=button_count&amp;width=90&amp;show_faces=true&amp;action=like&amp;colorscheme=light&amp;font&amp;height=21" scrolling="no" frameborder="0" style="border:none; overflow:hidden; width:90px; height:21px;" allowTransparency="true"></iframe>
    </div>
    <div id="coverphoto">
        <g:form controller="search" action="index" name="search" id="search" method="get">
            <fieldset class="basic">
                <legend>Enter the city, zip code, or address where you need storage:</legend>
                <div class="controls">
                    <input class="text" type="text" name="where" placeholder="e.g. Los Angeles, CA or 90026" /><input type="submit" class="submit" value="Find Storage!" />
                </div>
            </fieldset>
            <fieldset class="advanced">
                <legend><span>&#x25b6;</span> More Search Options</legend>
                <div id="advanced_search_controls">
                    <div class="amenities">
                        <input id="amenity_cc" type="checkbox" value="cc" name="amenity" />
                        <label for="amenity_cc">Climate Control/AC</label>
                        <br />
                        <input id="amenity_alarm" type="checkbox" value="alarm" name="amenity" />
                        <label for="amenity_alarm">In-Unit Alarm</label>
                     </div>
                    <div class="unit_size">
                        <label for="unit_size">Unit size:</label>
                        <select id="unit_size" name="unit_size">
                            <option value="">Any</option>
                            <option value="5x5">5 x 5</option>
                            <option value="5x10">5 x 10</option>
                            <option value="10x10">10 x 10</option>
                            <option value="10x15">10 x 15</option>
                            <option value="10x20">10 x 20</option>
                            <option value="10x30">10 x 30</option>
                        </select>
                        <a href="#" title="Help me choose a size!">Help me choose</a>
                    </div>
                    <div class="unit_type">
                        <label for="unit_type">Unit type:</label>
                        <select id="unit_type" name="unit_type">
                            <option value="">Any</option>
                            <option value="interior">Interior unit</option>
                            <option value="upper">Upper unit</option>
                            <option value="drive-up">Drive-up unit</option>
                        </select>
                        <a href="#" title="What does this mean?">What does this mean?</a>
                    </div>
                 </div>
            </fieldset>
        </g:form>
    </div>

</div>
<div id="logos">
    <span>Now<br />Renting...</span>
    <ul>
        <li class="ustoreit">U-Store-It</li>
        <li class="storquest">StorQuest</li>
        <li class="extraspace">ExtraSpace Storage</li>
        <li class="pricess">Price Self Storage</li>
        <li class="safkeep">Saf Keep Storage</li>
        <li class="usstoragecenters">U.S. Storage Centers</li>
        <li class="devon">Devon Self Storage</li>
        <li class="goldenstate">Golden State Self Storage</li>
    </ul>
</div>
<div id="info">
    <div id="howto">
        <h2>Rent your unit online.</h2>
        <p>Why hassle with phone calls and email when you can rent storage right
        now? Only Storitz lets you search, select, pay, and then print your
        receipt, contract, and gate code.</p>
    </div>
    <div id="guarantee">
        <h2>Get the absolute best price on storage. Guaranteed.</h2>
        <p>Storitz is the only place online where you can find, compare and rent
        a self storage unit anywhere in the country &mdash; all from one site. We
        list thousands of storage units, and let you sort by distance, price and
        unit size.</p>
    </div>
</div>
<div id="browse">
    <ul class="tabs">
        <li class="tab" id="states"><a href="#storage-by-state">Storage by State</a></li>
        <li class="tab" id="cities"><a href="#storage-by-city">Storage by City</a></li>
        <li class="tab" id="military"><a href="#military-storage">Military Storage</a></li>
        <li class="tab" id="college"><a href="#college-storage">College Storage</a></li>
        <li class="tab" id="business"><a href="#business-storage">Business Storage</a></li>
    </ul>

    <div class="panes">
        <div>
          <h3 class="tab_pane_title">Storage by State<a name="storage-by-state">&nbsp;</a></h3>
            <table>
                <tr>
                  <td>
                  <g:set var="i" value="${0}" />
                  <g:each in="${states}" var="state">
                    <g:link controller="seo" action="state" params="[state:state.path]">${state.label}</g:link>
                    <g:set var="i" value="${i + 1}" />
                    <g:if test="${i > 0 && i % statesPerColumn == 0 && i < states.size()}">
                  </td><td>
                    </g:if>
                  </g:each>
                  </td>
                </tr>
            </table>
        </div>

        <div>
            <h3 class="tab_pane_title">Storage by City<a name="storage-by-city">&nbsp;</a></h3>
            <table>
                <tr>
                  <td>
                  <g:set var="i" value="${0}" />
                  <g:each in="${metros}" var="metro">
                    <g:link mapping="metro2" controller="search" action="metro" params="[city:StoritzUtil.seoEncode(metro.city), state:metro.stateCode]">${metro.city}, ${metro.stateCode}</g:link>
                    <g:set var="i" value="${i + 1}" />
                    <g:if test="${i > 0 && i % metrosPerColumn == 0 && i < metros.size()}">
                  </td><td>
                    </g:if>
                  </g:each>
                  </td>
                </tr>
            </table>
        </div>

        <div>
            <h3>Military Storage<a name="military-storage">&nbsp;</a></h3>
            <p>Frequent relocation is a challenge for any family, but can be especially stressful for military
            service members and their families. Finding an affordable storage unit near a military base can be
            a challenge. Storitz lists hundreds of self storage facilities
            </p>
            <p class="right">
            near military bases, including Henderson Hall storage, Fort Myer storage,
            Fort McNair storage units and storage near Fort Hamilton. To compare self storage
            military deals, enter your zip code to search near you.</p>
        </div>
        <div>
            <h3>College Storage<a name="college-storage">&nbsp;</a></h3>
            <p>For many new college students, going to college means living with much less storage space than they are
            used to at home. Storitz makes it easy to find college student self storage across the country. Whether it
            is you or your son or daughter who is seeking summer storage, college storage, dorm storage or simply an affordable</p>
            <p class="right">
            self storage unit near USC, Storitz has you covered. You can even compare self storage
            near the University of Arizona and rent college storage units at any time of the day, online. Just type in
            your campus address or zip code to start your search.
            </p>
        </div>
        <div>
            <h3>Business Storage<a name="business-storage">&nbsp;</a></h3>
            <p>Business owners may need to rent self storage for many reasons.  A business storage unit can be an affordable
            solution to store inventory overstock. Small business storage makes operating a business possible where there
            is not much space in your storefront or home. Self storage for business can also be an affordable place to </p>
            <p class="right">store business tools or to store business vehicles, by utilizing a facility’s trailer storage or boat storage. Enter your zip code to search
            and compare business self storage locations near you.</p>
        </div>
    </div>
</div>
<p:dependantJavascript>
<script type="text/javascript">
  //<![CDATA[
  $(document).ready(function() {
    initialize_splash();
  });
  (function() {
    var po = document.createElement('script'); po.type = 'text/javascript'; po.async = true;
    po.src = 'https://apis.google.com/js/plusone.js';
    var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(po, s);
  })();
  //]]>
</script>
</p:dependantJavascript>
<script type="text/javascript">
  %{-- TODO: necessary? --}%
    //<![CDATA[
    var _gaq = _gaq || [];
    //]]>
</script>
<content tag='gwo'>
    <g:if test="${false && session.style != 'monthly'}"><!-- && false to disable GWO experiments until we're launched -->
        <g:if env="production">
            <!-- Google Website Optimizer Control Script -->
            <script type="text/javascript">
                _gaq.push(['gwo._setAccount', 'UA-16012579-4']);
                _gaq.push(['gwo._trackPageview', '/0667671337/test']);
                function utmx_section() {
                }
                function utmx() {
                }
                (function() {
                    var k = '0667671337',d = document,l = d.location,c = d.cookie;

                    function f(n) {
                        if (c) {
                            var i = c.indexOf(n + '=');
                            if (i > -1) {
                                var j = c.indexOf(';', i);
                                return escape(c.substring(i + n.length + 1, j < 0 ? c.length : j))
                            }
                        }
                    }

                    var x = f('__utmx'),xx = f('__utmxx'),h = l.hash;
                    d.write('<sc' + 'ript src="' + 'http' + (l.protocol == 'https:' ? 's://ssl' : '://www') + '.google-analytics.com' + '/siteopt.js?v=1&utmxkey=' + k + '&utmx=' + (x ? x : '') + '&utmxx=' + (xx ? xx : '') + '&utmxtime=' + new Date().valueOf() + (h ? '&utmxhash=' + escape(h.substr(1)) : '') + '" type="text/javascript" charset="utf-8"></sc' + 'ript>')
                })();
            </script>
            <script type="text/javascript">utmx("url", 'A/B');</script>
            <!-- End of Google Website Optimizer Control Script -->
        </g:if>
    </g:if>
</content>
</body>
</html>
