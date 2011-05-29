<%@ page import="java.math.RoundingMode" %>
<html>
<head>
    <title>The Fastest, Easiest Way to Find &amp; Rent Self-Storage - Storitz</title>
    <meta name="layout" content="splash"/>
</head>
<body>
<div id="bigbox">
    <h1 class="storitz-logo">Storitz.com - Click. Store. Done.</h1>
    <p>
        <span>Simplify your search for self storage.</span>
        <span>Get prices, availability &amp deals with 1 click...</span>
    </p>
    <div id="coverphoto">
        <h2>Then Rent <em>or</em> Reserve Your Unit!</h2>
        <form action="#" id="search">
            <fieldset>
                <legend>Enter the location where you need to find storage:</legend>
                <input type="text" name="where" placeholder="e.g. Los Angeles, CA or 90026" />
                <input type="submit" value="Find Storage!" />
            </fieldset>
            <fieldset id="advanced_search">
                <legend><span>&#x25b6;</span> More Search Options</legend>
                <div id="advanced_search_controls">
                    <div class="storage_type">
                        <input id="type_storage" type="radio" name="type" value="storage" checked="checked" />
                        <label for="type_storage">Self Storage</label>
                        <input id="type_parking" type="radio" name="type" value="parking" disabled="disabled" />
                        <label for="type_parking">Car, RV &amp; boat storage</label>
                    </div>
                    <div class="unit_size">
                        <label for="unit_size">Unit size:</label>
                        <select id="unit_size">
                            <option value="">Any</option>
                            <option value="5x5">5 x 5</option>
                            <option value="5x10">5 x 10</option>
                            <option value="10x10">10 x 10</option>
                            <option value="10x20">10 x 20</option>
                            <option value="10x30">10 x 30</option>
                        </select>
                        <a href="#" title="Help me choose a size!">Help me choose</a>
                    </div>
                    <div class="unit_type">
                        <label for="unit_type">Unit type:</label>
                        <select id="unit_type">
                            <option value="">Any</option>
                            <option value="interior">Interior unit</option>
                            <option value="drive-up">Drive-up unit</option>
                        </select>
                        <a href="#" title="What does this mean?">What does this mean?</a>
                    </div>
                    <div class="amenities">
                        <input id="cc_y" type="checkbox" value="y" name="cc" />
                        <label for="cc_y">Climate Control/AC</label>
                        <br />
                        <input id="24h_y" type="checkbox" value="y" name="24h" />
                        <label for="24h_y">24-hour access</label>
                        <br />
                        <input id="truck_y" type="checkbox" value="y" name="truck" />
                        <label for="truck_y">Free move-in truck</label>
                    </div>
                 </div>
            </fieldset>
        </form>
    </div>

</div>
<div id="logos">
    <span>Featured Facilities</span>
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
        <h2>How to find and choose a storage unit</h2>
        <p>Why hassle with phone calls and email when you can rent storage right
        now? Only Storitz lets you search, select, pay, and then print your
        receipt, contract, and gate code.  Or to put it another way: Why hassle with phone calls and email when you can rent storage right
        now? Only Storitz lets you search, select, pay, and then print your
        receipt, contract, and gate code.</p>
    </div>
    <div id="guarantee">
        <h2>Get the absolute best price on storage. Guaranteed.</h2>
        <p>Storitz is the only place online where you can find, compare and rent
        a self storage unit anywhere in the country &mdash; all from one site. We
        list thousands of storage units, and let you sort by distance, price and
        unit size so you can find the best storage unit near you without
        the hassle of calling or driving to multiple locations. We show you
        facility photos and videos before you rent, so you know
        exactly what you’re getting. Our facilities offer the best storage deals
        on the internet, including free move-in trucks, $1 move-in specials,
        online-only coupons, and more.</p>
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
        <div><a name="storage-by-state">
            <table>
                <tr>
                    <td>
                        <g:each var="state" in="${states[0..6]}">
                            <g:link controller="seo" action="state" params="[state:state.path]">${state.label}</g:link>
                        </g:each>
                    </td>
                    <td>
                        <g:each var="state" in="${states[7..13]}">
                            <g:link controller="seo" action="state" params="[state:state.path]">${state.label}</g:link>
                        </g:each>
                    </td>
                    <td>
                        <g:each var="state" in="${states[14..20]}">
                            <g:link controller="seo" action="state" params="[state:state.path]">${state.label}</g:link>
                        </g:each>
                    </td>
                    <td>
                        <g:each var="state" in="${states[21..27]}">
                            <g:link controller="seo" action="state" params="[state:state.path]">${state.label}</g:link>
                        </g:each>
                    </td>
                    <td>
                        <g:each var="state" in="${states[28..34]}">
                            <g:link controller="seo" action="state" params="[state:state.path]">${state.label}</g:link>
                        </g:each>
                    </td>
                    <td>
                        <g:each var="state" in="${states[35..41]}">
                            <g:link controller="seo" action="state" params="[state:state.path]">${state.label}</g:link>
                        </g:each>
                    </td>
                </tr>
            </table></a>
        </div>

        <div id="storge-by-city">
            <table>
                <tr>
                    <td>
                        <g:each var="metro" in="${metros[0..8]}">
                            <g:link mapping="metro2" controller="search" action="metro" params="[metro:metro.getPathParam()]">${metro.city}, ${metro.stateCode}</g:link>
                        </g:each>
                    </td>
                    <td>
                        <g:each var="metro" in="${metros[9..17]}">
                            <g:link mapping="metro2" controller="search" action="metro" params="[metro:metro.getPathParam()]">${metro.city}, ${metro.stateCode}</g:link>
                        </g:each>
                    </td>
                    <td>
                        <g:each var="metro" in="${metros[18..26]}">
                            <g:link mapping="metro2" controller="search" action="metro" params="[metro:metro.getPathParam()]">${metro.city}, ${metro.stateCode}</g:link>
                        </g:each>
                    </td>
                    <td>
                        <g:each var="metro" in="${metros[27..35]}">
                            <g:link mapping="metro2" controller="search" action="metro" params="[metro:metro.getPathParam()]">${metro.city}, ${metro.stateCode}</g:link>
                        </g:each>
                    </td>
                    <td>
                        <g:each var="metro" in="${metros[36..44]}">
                            <g:link mapping="metro2" controller="search" action="metro" params="[metro:metro.getPathParam()]">${metro.city}, ${metro.stateCode}</g:link>
                        </g:each>
                    </td>
                    <td>
                        <g:each var="metro" in="${metros[45..50]}">
                            <g:link mapping="metro2" controller="search" action="metro" params="[metro:metro.getPathParam()]">${metro.city}, ${metro.stateCode}</g:link>
                        </g:each>
                    </td>
                </tr>
            </table>
        </div>

        <div id="military-storage">
            <h3>Military Storage</h3>
            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
            <p class="right">Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
        </div>
        <div id="college-storage">
            <h3>College Storage</h3>
            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
            <p class="right">Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
        </div>
        <div id="business-storage">
            <h3>Business Storage</h3>
            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
            <p class="right">Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
        </div>
    </div>
</div>
<script type="text/javascript">
    //<![CDATA[
    var _gaq = _gaq || [];
    //]]>
</script>
<content tag='gwo'>
    <g:if test="${session.style != 'monthly'}">
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
