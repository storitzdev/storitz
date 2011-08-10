<%@ page contentType="text/html;charset=UTF-8" %>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head>
  <title>Storitz 404 Error</title>
  <meta name="layout" content="application" />
</head>
<body>

      <h1 style="padding: 10px;">Not Found</h1>

      <p style="padding: 10px 0 20px 10px;">
        We're not sure what you were looking for, but how about finding some storage?
        <g:link controller="home" action="index">Storitz</g:link>
      </p>
<p:dependantJavascript>
<script type="text/javascript">
var gaJsHost = (("https:" == document.location.protocol) ? " https://ssl." : "http://www.");
document.write(unescape("%3Cscript src='" + gaJsHost + " google-analytics.com/ga.js' type='text/javascript'%3E%3C/script%3E"));
</script>
<script type="text/javascript">
try{
var pageTracker = _gat._getTracker("UA-16012579-1");
pageTracker._trackPageview("/404.html?page=" + document.location.pathname + document.location.search + "&from=" + document.referrer);
} catch(err) {}
</script>
</p:dependantJavascript>
</body>
</html>