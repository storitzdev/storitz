<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN"
    "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head>
  <g:set var="title" value="Storitz College Site Map" scope="request"/>
  <g:render template="/header"/>

</head>
<body>
<div id="body">
  <g:render template="/topnav"/>
  <div class="stcontent">
    <g:render template="/logo_bar"/>
    <div style="height: 25px;"></div>
    <div class="body">
      <h1>College List</h1>
      %{--When we have enough states, put in a tabular index up top here.--}%
      <div class="list">
        <p>
        <g:each in="${collegeList}" var="college">
          <g:link url="college/${college.name}">${college.displayName}</g:link>
          <span>${college.address}</span><br>
        </g:each>
        </p>
      </div>
    </div>
    <div style="height: 25px;"></div>
  </div>
  <g:render template="/footer"/>
</div>
</body>
<p:renderDependantJavascript/>
</html>
