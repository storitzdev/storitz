<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head>
  <script type="text/javascript">
    //<![CDATA[
    <g:render template="/directions_js" />
    var d=document,l=d.location;
    d.write('<sc'+'ript src="'+'http'+(l.protocol=='https:'?'s://maps-api-ssl':'://maps')+'.google.com'+'/maps/api/js?v=3&client=gme-storitz&sensor=false" type="text/javascript"></sc'+'ript>');

    //]]>
  </script>

</head>
<body>
<g:render template="/directions"/>
<p:dependantJavascript>
    <script>
        _direction.init(siteTitle, siteLat, siteLng);
    </script>
    <g:if test="${params.origin}">
    <script>
        _direction.calculate("${params.origin}", siteLat, siteLng);
       $("#dirPanel").css("display", "block");
       $("#srcAddr").val("${params.origin}");
       $("#shareThis").hide();
    </script>
    </g:if>
</p:dependantJavascript>
</body>
<p:renderDependantJavascript/>
</html>