<p:dependantJavascript>
    <script>
    var pinurl0=<storitz:imageLink src="map-0-9.png" />;
    var pinurl1=<storitz:imageLink src="map-10-99.png" />;
    var pinurl2=<storitz:imageLink src="map-100-199.png" />;
    var pinurl3=<storitz:imageLink src="map-200-299.png" />;
    var pinurl4=<storitz:imageLink src="map-300-399.png" />;
    var pinurl5=<storitz:imageLink src="map-400-499.png" />;
    var pinurl6=<storitz:imageLink src="map-500-599.png" />;
    var pinurl7=<storitz:imageLink src="map-600-699.png" />;
    </script>
</p:dependantJavascript>

<g:form controller="${controller}" action="${action}" name="${name}" method="get">
    <input type="hidden" name="where" id="where" value="${where}" />
    <input type="hidden" name="view-mode" id="view-mode" value="" />
    <input class="text" type="hidden" name="collegeName" value="${college?.name}" />
    <g:render template="/search/results1" />
</g:form>
<g:render template="/search/results2" />


