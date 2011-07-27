<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="com.storitz.UncleBobs" %>
<html>
<head>
  <g:set var="title" value="List Uncle Bob's Feeds" scope="request"/>
</head>
<body>
<div id="body">
  <div class="stcontent">
    <div class="buttons">
      <span class="button"><a href="${createLink(controller: 'admin', action: 'index')}">Menu</a></span>
      <span class="button"><g:link action="create">Create New Uncle Bob's Feed</g:link></span>
    </div>
    <div class="body">

      <div class="price_options checkout_header white">
        List Uncle Bob's Feeds
      </div>

      <g:if test="${flash.message}">
        <div class="message">${flash.message}</div>
      </g:if>
      <div class="list">
        <table>
          <thead>
          <tr>

            <g:sortableColumn property="id" title="${message(code: 'uncleBobs.id.label', default: 'Id')}"/>

            <g:sortableColumn property="operatorName" title="${message(code: 'uncleBobs.operatorName.label', default: 'Operator Name')}"/>

            <th><g:message code="uncleBobs.manager.label" default="Manager"/></th>

            <g:sortableColumn property="companyName" title="${message(code: 'uncleBobs.UBCompanyName.label', default: 'Company Name')}"/>

          </tr>
          </thead>
          <tbody>
          <g:each in="${uncleBobsInstanceList}" status="i" var="uncleBobsInstance">
            <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">

              <td><g:link action="show" id="${uncleBobsInstance.id}">${fieldValue(bean: uncleBobsInstance, field: "id")}</g:link></td>

              <td>${fieldValue(bean: uncleBobsInstance, field: "operatorName")}</td>

              <td>${uncleBobsInstance?.manager?.username}</td>

              <td>${fieldValue(bean: uncleBobsInstance, field: "UBCompanyName")}</td>

            </tr>
          </g:each>
          </tbody>
        </table>
      </div>
      <div class="paginateButtons">
        <g:paginate total="${uncleBobsInstanceTotal}"/>
      </div>
    </div>
  </div>
</div>
</body>
</html>
