<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN"
    "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head>
  <g:set var="title" value="List SiteLink Feeds" scope="request"/>
  <g:render template="/header"/>

  <script type="text/javascript">
    //<![CDATA[
    //]]>
  </script>

</head>
<body>
<div id="body">
<g:render template="/topnav"/>
<div id="stcontent">
  <g:render template="/logo_bar"/>
  <div class="buttons">
    <span class="button"><a href="${createLink(controller:'admin', action:'index')}">Menu</a></span>
    <span class="button"><g:link action="create">Create New SiteLink Feed</g:link></span>
  </div>
  <div class="body">

    <div class="price_options checkout_header white">
      List SiteLink Feeds
    </div>

    <g:if test="${flash.message}">
      <div class="message">${flash.message}</div>
    </g:if>
    <div class="list">
      <table>
        <thead>
        <tr>

          <g:sortableColumn property="id" title="${message(code: 'siteLink.id.label', default: 'Id')}"/>

          <g:sortableColumn property="operatorName" title="${message(code: 'siteLink.operatorName.label', default: 'Operator Name')}"/>

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

            <td>${fieldValue(bean: siteLinkInstance, field: "operatorName")}</td>

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
</div>
</body>
</html>
