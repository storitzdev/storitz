<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN"
    "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head>
  <g:set var="title" value="SEO links for Feed" scope="request"/>
  <g:render template="/header"/>

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
  <div class="buttons">
    <span class="button"><a href="${createLink(controller:'admin', action:'index')}">Menu</a></span>
  </div>
  <div class="body">

    <div class="price_options checkout_header white">
      SEO Links
    </div>

    <g:if test="${flash.message}">
      <div class="message">${flash.message}</div>
    </g:if>
    <div class="list">
      <table>
        <thead>
        <tr>

          <g:sortableColumn property="id" title="${message(code: 'site.id.label', default: 'Id')}"/>

          <g:sortableColumn property="title" title="${message(code: 'site.title', default: 'Title')}"/>

          <th><g:message code="site.metroLink" default="Metro Area"/></th>

          <th><g:message code="site.link" default="Direct Link to Property"/></th>

        </tr>
        </thead>
        <tbody>
        <g:each in="${feed.sites}" status="i" var="site">
          <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">

            <td><g:link action="show" id="${site.id}">${fieldValue(bean: site, field: "id")}</g:link></td>

            <td>${fieldValue(bean: site, field: "title")}</td>

            <td>
              <g:link mapping="metro" absolut="true" params="[city:site.city, state:site.state.display]">${createLink(mapping:'metro', absolute:true, params:[city:site.city, state:site.state.display])}</g:link>
            </td>

            <td>
              <g:link mapping="siteLink" absolute="true" params="[city:site.city, state:site.state.display, site_title:site.title, id:site.id]">
                ${createLink(mapping:'siteLink', absolute:true, params:[city:site.city, state:site.state.display, site_title:site.title, id:site.id])}
              </g:link>
            </td>

          </tr>
        </g:each>
        </tbody>
      </table>
    </div>
    <div class="paginateButtons">
      <g:paginate total="${feed.sites.size()}"/>
    </div>
  </div>
</div>
</div>
</body>
<p:renderDependantJavascript />
</html>
