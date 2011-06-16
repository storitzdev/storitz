<%@ page import="java.math.RoundingMode" %>
<html>
<head>
    <title>The Fastest, Easiest Way to Find &amp; Rent Self-Storage - Storitz</title>
    <meta name="layout" content="splash"/>
</head>
<body>
<div id="bigbox">
    <h1 class="storitz-logo">
        <g:link controller="home" action="index">
            Storitz.com - Click. Store. Done.
        </g:link>
    </h1>
    <h2>
        <span>Simplify your search for self storage.</span>
        <span>Get prices, availability &amp; deals with 1 click!</span>
    </h2>
    <div id="coverphoto">
        <form action="#" id="search">
            <fieldset class="basic">
                <legend>Enter the city, zip code or address where you need storage:</legend>
                <div class="controls">
                    <input type="text" name="where" placeholder="e.g. Los Angeles, CA or 90026" /><input type="submit" value="Find Storage!" />
                </div>
            </fieldset>
            <fieldset class="advanced">
                <legend><span>&#x25b6;</span> More Search Options</legend>
                <div id="advanced_search_controls">
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
                 </div>
            </fieldset>
        </form>
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
        <h2>Self Storage How To</h2>
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

            <table>
                <tr>
                  <td>
                  <g:set var="i" value="${0}" />
                  <g:each in="${metros}" var="metro">
                    <g:link mapping="metro2" controller="search" action="metro" params="[city:metro.city, state:metro.stateCode]">${metro.city}, ${metro.stateCode}</g:link>
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
            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit,    sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
            <p class="right">Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
        </div>
        <div>
            <h3>College Storage<a name="college-storage">&nbsp;</a></h3>
            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
            <p class="right">Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
        </div>
        <div>
            <h3>Business Storage<a name="business-storage">&nbsp;</a></h3>
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
    <g:if test="${session.style != 'monthly'} && false"><!-- && false to disable GWO experiments until we're launched -->
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
