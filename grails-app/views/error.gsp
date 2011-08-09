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
</body>
</html>