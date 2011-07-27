<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
  <g:set var="title" value="Storage Unit Sizes" scope="request"/>
</head>
<body>
<div id="body">

  <div class="stcontent">
    <div class="nav">
      <span class="menuButton"><a class="home" href="${createLink(controller: 'admin', action: 'index')}">Admin</a></span>
      <span class="menuButton"><g:link class="create" action="create">New StorageSize</g:link></span>
    </div>
    <div class="body">
      <h1>StorageSize List</h1>
      <g:if test="${flash.message}">
        <div class="message">${flash.message}</div>
      </g:if>
      <div class="list">
        <table>
          <thead>
          <tr>

            <g:sortableColumn property="id" title="Id"/>

            <g:sortableColumn property="height" title="Height"/>

            <g:sortableColumn property="description" title="Description"/>

            <g:sortableColumn property="length" title="Length"/>

            <g:sortableColumn property="width" title="Width"/>

          </tr>
          </thead>
          <tbody>
          <g:each in="${storageSizeInstanceList}" status="i" var="storageSizeInstance">
            <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">

              <td><g:link action="show" id="${storageSizeInstance.id}">${fieldValue(bean: storageSizeInstance, field: 'id')}</g:link></td>

              <td>${fieldValue(bean: storageSizeInstance, field: 'height')}</td>

              <td>${fieldValue(bean: storageSizeInstance, field: 'description')}</td>

              <td>${fieldValue(bean: storageSizeInstance, field: 'length')}</td>

              <td>${fieldValue(bean: storageSizeInstance, field: 'width')}</td>

            </tr>
          </g:each>
          </tbody>
        </table>
      </div>
      <div class="paginateButtons">
        <g:paginate total="${storageSizeInstanceTotal}"/>
      </div>
    </div>
  </div>
</div>
</body>
</html>
