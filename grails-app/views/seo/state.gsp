<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN"
    "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head>
  <g:set var="title" value="Self Storage in ${state.display}" scope="request"/>
  <g:render template="/header"/>

</head>
<body>
<div id="body">
  <g:render template="/topnav"/>
  <div class="stcontent">
    <g:render template="/logo_bar"/>
    <div style="height: 25px;"></div>
    <div class="body">
      <h1>Self Storage results for ${state.fullName}</h1>
      <h2>Metro Areas</h2>
      <div style="width:650px;">
        <g:each in="${metroList}" var="metro">
          <div class="site">
            <g:link mapping="metro2" params="${[city:metro.city, state:metro.state.display]}">${metro.city}, ${metro.state.display}</g:link>
          </div>
        </g:each>
      </div>
      <h2>Cities and Neighborhoods</h2>
      <div class="left" style="width:300px;">
        <g:each in="${metroEntryList}" var="metroEntry">
          <div class="site">
            <g:link mapping="geo2" params="${[city:metroEntry.city, state:metroEntry.state.display, zip:metroEntry.zipcode]}">${metroEntry.city} self storage</g:link>
          </div>
        </g:each>
      </div>
    </div>
    <div style="height: 25px;"></div>
  </div>
  <g:render template="/footer"/>
</div>
</body>
<p:renderDependantJavascript/>
</html>
