<html>
<head>
  <title>Internal Server Error</title>
  <meta name="layout" content="application" />
</head>
<body>
<g:if test="${exception}">
  <h2>Stack Trace</h2>
  <pre>
    <g:each in="${exception.stackTraceLines}">${it.encodeAsHTML()}</g:each>
  </pre>
</g:if>
<p:dependantJavascript>
<script type="text/javascript">
var gaJsHost = (("https:" == document.location.protocol) ? " https://ssl." : "http://www.");
document.write(unescape("%3Cscript src='" + gaJsHost + " google-analytics.com/ga.js' type='text/javascript'%3E%3C/script%3E"));
</script>
<script type="text/javascript">
try{
var pageTracker = _gat._getTracker("UA-16012579-1");
pageTracker._trackPageview("/500.html?page=" + document.location.pathname + document.location.search + "&from=" + document.referrer);
} catch(err) {}
</script>
</p:dependantJavascript>
</body>
</html>