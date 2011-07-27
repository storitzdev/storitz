<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
  <g:set var="title" value="SEO links for Feed" scope="request"/>
</head>
<body>
<div id="body">

  <div class="stcontent">
    <div class="buttons">
      <span class="button"><a href="${createLink(controller: 'admin', action: 'index')}">Menu</a></span>
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

              <td><g:link controller="storageSite" action="detail" id="${site.id}">${fieldValue(bean: site, field: "id")}</g:link></td>

              <td>${fieldValue(bean: site, field: "title")}</td>

              <td>
                <g:link mapping="metro2" absolut="true" params="[city:site.city, state:site.state.display]">${createLink(mapping: 'metro2', absolute: true, params: [city: site.city, state: site.state.display])}</g:link>
              </td>

              <td>
                <g:link mapping="siteLink" absolute="true" params="[city:site.city, state:site.state.display, site_title:site.title, id:site.id]">
                  ${createLink(mapping: 'siteLink2', absolute: true, params: [site_title: site.title, id: site.id])}
                </g:link>
              </td>

            </tr>
          </g:each>
          </tbody>
        </table>
      </div>
      <div class="paginateButtons">
        <g:paginate total="${feed.sites.size()}" id="${feed.id}"/>
      </div>
    </div>
  </div>
</div>
</body>
</html>
