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
      <H1>Admin Links</H1>
      <g:if test="${flash.message}">
        <div class="message">${flash.message}</div>
      </g:if>
      <ul>
        <li><g:link controller="storageSite" action="list">Manage Sites</g:link> </li>
        <li><g:link controller="user" action="password">Change Password</g:link> </li>
        <sec:ifAnyGranted roles="ROLE_ADMIN">
        <li><g:link controller="storageSize" action="list">Storage Unit Size list</g:link> </li>
        <li><g:link controller="specialOffer" action="list">Manage Special Offers</g:link> </li>
        <li><g:link controller="user" action="list">Show Users</g:link> </li>
        <li><g:link controller="siteLink" action="list">Manage SiteLink</g:link> </li>
        </sec:ifAnyGranted>
        <li><g:link controller="logout">Log out</g:link></li>
      </ul>
    </div>
    <div style="height:30px;"></div>
    <g:render template="/footer" />
    </div>
  </body>
</html>