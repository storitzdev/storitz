<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN"
    "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head>
  <g:set var="title" value="List SiteLink Feeds"/>
  <g:render template="/header"/>

  <script type="text/javascript">
    //<![CDATA[
    //]]>
  </script>

</head>
<body>
<g:render template="/topnav"/>
<div id="stcontent">
  <g:render template="/logo_bar"/>
  <div class="nav">
    <span class="menuButton"><a class="home" href="${createLink(controller:'admin', action:'index')}">Admin</a></span>
    <span class="menuButton"><g:link class="create" action="create">Create New SiteLink Feed</g:link></span>
  </div>
  <div class="body">
    <h1>List SiteLink Feeds</h1>
    <g:if test="${flash.message}">
      <div class="message">${flash.message}</div>
    </g:if>
    <div class="list">
      <table>
        <thead>
        <tr>

          <g:sortableColumn property="id" title="${message(code: 'siteLink.id.label', default: 'Id')}"/>

          <th><g:message code="siteLink.manager.label" default="Manager"/></th>

          <g:sortableColumn property="corpCode" title="${message(code: 'siteLink.corpCode.label', default: 'Corp Code')}"/>

          <g:sortableColumn property="userName" title="${message(code: 'siteLink.userName.label', default: 'User Name')}"/>

          <g:sortableColumn property="password" title="${message(code: 'siteLink.password.label', default: 'Password')}"/>

        </tr>
        </thead>
        <tbody>
        <g:each in="${siteLinkInstanceList}" status="i" var="siteLinkInstance">
          <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">

            <td><g:link action="show" id="${siteLinkInstance.id}">${fieldValue(bean: siteLinkInstance, field: "id")}</g:link></td>

            <td>${siteLinkInstance?.manager?.username}</td>

            <td>${fieldValue(bean: siteLinkInstance, field: "corpCode")}</td>

            <td>${fieldValue(bean: siteLinkInstance, field: "userName")}</td>

            <td>${fieldValue(bean: siteLinkInstance, field: "password")}</td>

          </tr>
        </g:each>
        </tbody>
      </table>
    </div>
    <div class="paginateButtons">
      <g:paginate total="${siteLinkInstanceTotal}"/>
    </div>
  </div>
</div>
</body>
</html>
