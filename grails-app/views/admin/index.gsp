<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN"
    "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head>
  <g:render template="/header_admin"/>

</head>
<body>
<div id="body">
  <g:render template="/topnav"/>
  <div class="stcontent">
    <g:render template="/logo_bar"/>
    <H1>Admin Links</H1>
    <g:if test="${flash.message}">
      <div class="message">${flash.message}</div>
    </g:if>
    <ul>
      <sec:ifNotGranted roles="ROLE_CALLCENTER">
        <li><g:link controller="storageSite" action="list">Manage Sites</g:link></li>
      </sec:ifNotGranted>
      <li><g:link controller="user" action="password">Change Password</g:link></li>
      <sec:ifAnyGranted roles="ROLE_ADMIN, ROLE_MANAGER">
        <li><g:link controller="user" action="list">Show Users</g:link></li>
        <li><g:link controller="rentalAgreement" action="list">Upload rental agreement</g:link></li>
      </sec:ifAnyGranted>
      <sec:ifAnyGranted roles="ROLE_ADMIN">
        <li>Feed Functions</li>
        <ul>
          <li><g:link controller="siteLink" action="list">Manage SiteLink</g:link></li>
          <li><g:link controller="cshift" action="list">Manage CenterShift</g:link></li>
          <li><g:link controller="quikStor" action="list">Manage QuikStor</g:link></li>
          <li><g:link controller="exrs" action="list">Manage Extraspace</g:link></li>
          <li><g:link controller="usi" action="list">Manage U-Store-It</g:link></li>
          <li><g:link controller="EDomico" action="list">Manage EDomico</g:link></li>
        </ul>
        <li>Reference Data</li>
        <ul>
          <li><g:link controller="storageSize" action="list">Storage Unit Size list</g:link></li>
          <li><g:link controller="commission" action="list">Manage Commission Table</g:link></li>
          <li><g:link controller="metro" action="list">Manage Metro Descriptions</g:link></li>
          <li><g:link controller="metroEntry" action="list">Manage Metro Neighborhoods/Zips</g:link></li>
          <li><g:link controller="collegeLanding" action="list">Manage College Landing Pages</g:link></li>
        </ul>
        <li>Contests</li>
        <ul>
          <li><g:link controller="organizerContest" action="list">Manage Organizer Contest</g:link></li>
        </ul>
        <li>Refresh Items</li>
        <ul>
          <li><g:link controller="storageSite" action="refreshInventory">Refresh Inventory</g:link></li>
          <li><g:link controller="storageSite" action="refreshPromos">Refresh Promos</g:link></li>
        </ul>
        <li>Content Management</li>
        <ul>
          <li><g:link controller="pressRelease" action="list">Manage Press Releases</g:link></li>
          <li><g:link controller="video" action="list">Manage Videos</g:link></li>
          <li><g:link controller="image" action="export">Manage Images</g:link></li>
        </ul>
      </sec:ifAnyGranted>
      <sec:ifAnyGranted roles="ROLE_CALLCENTER">
        <li><g:link controller="storageSite" action="findCall">Assist Caller</g:link></li>
      </sec:ifAnyGranted>
      <li><g:link controller="reports">Reporting menu</g:link></li>
      <li><g:link controller="logout">Log out</g:link></li>
    </ul>
  </div>
  <div style="height:30px;"></div>
  <g:render template="/footer_no_analytics"/>
</div>
</body>
<p:renderDependantJavascript/>
</html>