<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN"
    "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" >
  <head>
    <g:render template="/header" />

    <script type="text/javascript">
//<![CDATA[
//]]>
  </script>

  </head>
  <body>
    <div id="body">
    <g:render template="/topnav" />
    <div id="stcontent">
      <g:render template="/logo_bar" />
      <H1>Storitz Reports</H1>

      <div class="buttons">
        <span class="button"><a href="${createLink(controller: 'admin', action: 'index')}">Admin Menu</a></span>
      </div>

      <g:if test="${flash.message}">
        <div class="message">${flash.message}</div>
      </g:if>
      <ul>
        <sec:ifAnyGranted roles="ROLE_ADMIN">
          <li><g:link action="occupancy">Occupancy report</g:link></li>
        </sec:ifAnyGranted>
      </ul>
    </div>
    <div style="height:30px;"></div>
    <g:render template="/footer" />
    </div>
  </body>
</html>