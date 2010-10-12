<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN"
    "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head>
  <g:set var="title" value="Storitz Site Map" scope="request"/>
  <g:render template="/header"/>

</head>
<body>
<div id="body">
  <g:render template="/topnav"/>
  <div id="stcontent">
    <g:render template="/logo_bar"/>
    <div style="height: 25px;"></div>
    <div class="body">
      <h1>Storage Site List</h1>
      %{--When we have enough states, put in a tabular index up top here.--}%
      <div class="list">
        <g:each in="${storageSiteStateMap}" status="s" var="sitesEntryForState">
          <h2>${sitesEntryForState.key}</h2>
          <div class="list">
            <g:each in="${sitesEntryForState.value}" status="t" var="storageSiteInstance">
              <div class="site">
                %{--If we were to use "absolute:true" here then session url rewriting is disabled. --}%
                <g:link controller="storageSite" action="detail" id="${storageSiteInstance.id}"
                        params="${[city:storageSiteInstance.city, site_title:storageSiteInstance.siteTitle]}">${fieldValue(bean: storageSiteInstance, field: "title")}</g:link>
                <span>${fieldValue(bean: storageSiteInstance, field: "city")}</span>
              </div>
            </g:each>
          </div>
        </g:each>
      </div>
    </div>
    <div style="height: 25px;"></div>
  </div>
  <g:render template="/footer"/>
</div>
</body>
</html>
