<%@ page contentType="text/html;charset=UTF-8" %>
<html>
  <head><title>Self Storage Prices &amp; Special Offers Near ${aMetro.city}, ${aMetro.stateCode}</title></head>
  <body class="serp">
    <h1>Self Storage Prices &amp; Special Offers Near ${aMetro.city}, ${aMetro.stateCode}</h1>
    <g:form>
        <div id="topbox">
            <div id="maplet"></div>
            <div id="size_picker"></div>
            <div id="amenities"></div>
        </div>
    </g:form>
    <p class="summary">We Found Prices &amp; Availability for ${clientSites.size()} Facilities</p>
    <g:each in="${clientSites}" var="site">

    </g:each>
  </body>
</html>