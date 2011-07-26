<p:dependantJavascript>
    <script>
    var pinurl0=<storitz:imageLink src="map-pins-0thru9-36x50.png" />;
    var pinurl1=<storitz:imageLink src="map-pins-10thru99-44x50.png" />;
    var pinurl2=<storitz:imageLink src="map-pins-100thru199-52x50.png" />;
    var pinurl3=<storitz:imageLink src="map-pins-200thru300-52x50.png" />;
    </script>
</p:dependantJavascript>

<g:form controller="${controller}" action="${action}" name="${name}" method="get">
    <input type="hidden" name="where" id="where" value="${where}" />
    <input type="hidden" name="view-mode" id="view-mode" value="" />
    <g:render template="/search/results1" />
</g:form>
<g:render template="/search/results2" />


