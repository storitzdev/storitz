<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="com.storitz.StorageMart" %>
<html>
<head>
  <g:set var="title" value="List Storage Mart Feeds" scope="request"/>
</head>
<body>
<div id="body">
  <div class="stcontent">
      <div class="buttons">
      <span class="button"><a href="${createLink(controller: 'admin', action: 'index')}">Menu</a></span>
      <span class="button"><g:link action="create">Create New Storage Mart Feed</g:link></span>
      <span class="button"><g:link controller="storageMartSpecialOfferLookup" class="list" action="list">Manage Special Offer Lookup</g:link></span>
    </div>
    <div class="body">

      <div class="price_options checkout_header white">
        List Storage Mart Feeds
      </div>

      <g:if test="${flash.message}">
        <div class="message">${flash.message}</div>
      </g:if>
      <div class="list">
        <table>
          <thead>
          <tr>

            <g:sortableColumn property="id" title="${message(code: 'storageMart.id.label', default: 'Id')}"/>

            <g:sortableColumn property="operatorName" title="${message(code: 'storageMart.operatorName.label', default: 'Operator Name')}"/>

            <th><g:message code="storageMart.manager.label" default="Manager"/></th>

            <g:sortableColumn property="userName" title="${message(code: 'storageMart.stmUser.label', default: 'User Name')}"/>

          </tr>
          </thead>
          <tbody>
          <g:each in="${storageMartInstanceList}" status="i" var="storageMartInstance">
            <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">

              <td><g:link action="show" id="${storageMartInstance.id}">${fieldValue(bean: storageMartInstance, field: "id")}</g:link></td>

              <td>${fieldValue(bean: storageMartInstance, field: "operatorName")}</td>

              <td>${storageMartInstance?.manager?.username}</td>

              <td>${fieldValue(bean: storageMartInstance, field: "stmUser")}</td>

            </tr>
          </g:each>
          </tbody>
        </table>
      </div>
      <div class="paginateButtons">
        <g:paginate total="${storageMartInstanceTotal}"/>
      </div>
    </div>
  </div>
</div>
</div>
</body>
</html>
