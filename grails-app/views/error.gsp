<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN"
    "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head>
  <g:set var="title" value="Storitz 500 Error" scope="request"/>
  <g:render template="/header"/>

  <style type="text/css">
  .message {
    border: 1px solid black;
    padding: 5px;
    background-color: #E9E9E9;
  }

  .stack {
    border: 1px solid black;
    padding: 5px;
    overflow: auto;
    height: 300px;
  }

  .snippet {
    padding: 5px;
    background-color: white;
    border: 1px solid black;
    margin: 3px;
    font-family: courier;
  }
  </style>
  <script type="text/javascript">
    //<![CDATA[

    //]]>
  </script>

</head>
<body>
<div id="body">
  <g:render template="/topnav"/>
  <div class="stcontent">
    <g:render template="/logo_bar"/>
    <div id="staticMenu" class="left" style="margin-top: 26px;">
      <!-- menu section -->
    </div>
    <div style="width: 650px;margin-right: 35px;" class="right">

      <h1>Storitz Error</h1>

      <div id="errContent" style="display:none;">
        <div class="message">
          <strong>Error ${request.'javax.servlet.error.status_code'}:</strong> ${request.'javax.servlet.error.message'.encodeAsHTML()}<br/>
          <strong>Servlet:</strong> ${request.'javax.servlet.error.servlet_name'}<br/>
          <strong>URI:</strong> ${request.'javax.servlet.error.request_uri'}<br/>
          <g:if test="${exception}">
            <strong>Exception Message:</strong> ${exception.message?.encodeAsHTML()} <br/>
            <strong>Caused by:</strong> ${exception.cause?.message?.encodeAsHTML()} <br/>
            <strong>Class:</strong> ${exception.className} <br/>
            <strong>At Line:</strong> [${exception.lineNumber}] <br/>
            <strong>Code Snippet:</strong><br/>
            <div class="snippet">
              <g:each var="cs" in="${exception.codeSnippet}">
                ${cs?.encodeAsHTML()}<br/>
              </g:each>
            </div>
          </g:if>
        </div>

        <g:if test="${exception}">
          <h2>Stack Trace</h2>
          <div class="stack">
            <pre><g:each in="${exception.stackTraceLines}">${it.encodeAsHTML()}<br/></g:each></pre>
          </div>
        </g:if>
        <div id="lessDescription" class="expanding">
          <a href="#" style="text-decoration: none;" onclick="$('#errContent').hide('blind');
          $('#moreDescription').toggle('fade');
          return false;"><storitz:image src="icon-minus.png" style="border: none;" width="15" height="13" alt="minus icon"/> Less</a>
        </div>
      </div>
      <div id="moreDescription" class="expanding">
        <a href="#" style="text-decoration: none;" onclick="$('#errContent').show('blind');
        $('#moreDescription').toggle('fade');
        return false;"><storitz:image src="icon-plus.png" style="border: none;" width="15" height="13" alt="plus icon"/> More</a>
      </div>
    </div>
  </div>

  <div style="clear:both; height:30px;"></div>
  <g:render template="/footer"/>
</div>
</body>
<p:renderDependantJavascript/>
</html>