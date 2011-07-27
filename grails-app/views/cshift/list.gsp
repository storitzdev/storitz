<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
  <g:set var="title" value="List CenterShift Feeds" scope="request"/>
</head>
<body>
<div id="body">

  <div class="stcontent">
    <div class="buttons">
      <span class="button"><a href="${createLink(controller: 'admin', action: 'index')}">Menu</a></span>
      <span class="button"><g:link action="create">Create New CenterShift Feed</g:link></span>
    </div>
    <div class="body">

      <div class="price_options checkout_header white">
        List CenterShift Feeds
      </div>

      <g:if test="${flash.message}">
        <div class="message">${flash.message}</div>
      </g:if>
      <div class="list">
        <table>
          <thead>
          <tr>

            <g:sortableColumn property="id" title="${message(code: 'cshift.id.label', default: 'Id')}"/>

            <g:sortableColumn property="operatorName" title="${message(code: 'cshift.operatorName.label', default: 'Operator Name')}"/>

            <th><g:message code="cshift.manager.label" default="Manager"/></th>

            <g:sortableColumn property="userName" title="${message(code: 'cshift.userName.label', default: 'User Name')}"/>

            <g:sortableColumn property="pin" title="${message(code: 'cshift.pin.label', default: 'PIN')}"/>

            <g:sortableColumn property="location" title="${message(code: 'cshift.location.label', default: 'Location')}"/>

            <g:sortableColumn property="cshiftVersion" title="${message(code: 'cshift.cshiftVersion.label', default: 'Version')}"/>
          </tr>
          </thead>
          <tbody>
          <g:each in="${cshiftInstanceList}" status="i" var="cshiftInstance">
            <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">

              <td><g:link action="show" id="${cshiftInstance.id}">${fieldValue(bean: cshiftInstance, field: "id")}</g:link></td>

              <td>${fieldValue(bean: cshiftInstance, field: "operatorName")}</td>

              <td>${cshiftInstance?.manager?.username}</td>

              <td>${fieldValue(bean: cshiftInstance, field: "userName")}</td>

              <td>${fieldValue(bean: cshiftInstance, field: "pin")}</td>

              <td>${cshiftInstance.location?.display}</td>

              <td>${cshiftInstance.cshiftVersion?.display}</td>

            </tr>
          </g:each>
          </tbody>
        </table>
      </div>
      <div class="paginateButtons">
        <g:paginate total="${cshiftInstanceTotal}"/>
      </div>
    </div>
  </div>
</div>
</body>
</html>
