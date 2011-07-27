<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
  <g:set var="title" value="List EDomico Feeds" scope="request"/>
</head>
<body>
<div id="body">

  <div class="stcontent">
    <div class="buttons">
      <span class="button"><a href="${createLink(controller: 'admin', action: 'index')}">Menu</a></span>
      <span class="button"><g:link action="create">Create New EDomico Feed</g:link></span>
      <span class="button"><g:link controller="EDomicoAmenitiesMap" class="list" action="list">Manage Amenities Mapping</g:link></span>

    </div>
    <div class="body">

      <div class="price_options checkout_header white">
        List EDomico Feeds
      </div>

      <g:if test="${flash.message}">
        <div class="message">${flash.message}</div>
      </g:if>
      <div class="list">
        <table>
          <thead>
          <tr>

            <g:sortableColumn property="id" title="${message(code: 'edomico.id.label', default: 'Id')}"/>

            <g:sortableColumn property="operatorName" title="${message(code: 'edomico.operatorName.label', default: 'Operator Name')}"/>

            <th><g:message code="edomico.manager.label" default="Manager"/></th>

            <g:sortableColumn property="edomicoClientID" title="${message(code: 'edomico.edomicoClientID.label', default: 'Client ID')}"/>

            <g:sortableColumn property="edomicoWebServicesKey" title="${message(code: 'edomico.edomicoWebServicesKey.label', default: 'Web Services Key')}"/>

          </tr>
          </thead>
          <tbody>
          <g:each in="${edomicoInstanceList}" status="i" var="edomicoInstance">
            <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">

              <td><g:link action="show" id="${edomicoInstance.id}">${fieldValue(bean: edomicoInstance, field: "id")}</g:link></td>

              <td>${fieldValue(bean: edomicoInstance, field: "operatorName")}</td>

              <td>${edomicoInstance?.manager?.username}</td>

              <td>${edomicoInstance?.edomicoClientID}</td>

              <td>${edomicoInstance?.edomicoWebServicesKey}</td>

            </tr>
          </g:each>
          </tbody>
        </table>
      </div>
      <div class="paginateButtons">
        <g:paginate total="${edomicoInstanceTotal}"/>
      </div>
    </div>
  </div>
</div>
</body>
</html>
