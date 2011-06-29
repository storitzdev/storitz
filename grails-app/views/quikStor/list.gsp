<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN"
    "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head>
  <g:set var="title" value="List QuikStor Feeds" scope="request"/>
  <g:render template="/header"/>

  <script type="text/javascript">
    //<![CDATA[
    //]]>
  </script>

</head>
<body>
<div id="body">

  <div class="stcontent">
    <g:render template="/logo_bar"/>
    <div class="buttons">
      <span class="button"><a href="${createLink(controller: 'admin', action: 'index')}">Menu</a></span>
      <span class="button"><g:link action="create">Create New QuikStor Feed</g:link></span>
    </div>
    <div class="body">

      <div class="price_options checkout_header white">
        List QuikStor Feeds
      </div>

      <g:if test="${flash.message}">
        <div class="message">${flash.message}</div>
      </g:if>
      <div class="list">
        <table>
          <thead>
          <tr>

            <g:sortableColumn property="id" title="${message(code: 'quikStor.id.label', default: 'Id')}"/>

            <g:sortableColumn property="operatorName" title="${message(code: 'quikStor.operatorName.label', default: 'Operator Name')}"/>

            <th><g:message code="quikStor.manager.label" default="Manager"/></th>

          </tr>
          </thead>
          <tbody>
          <g:each in="${quikStorInstanceList}" status="i" var="quikStorInstance">
            <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">

              <td><g:link action="show" id="${quikStorInstance.id}">${fieldValue(bean: quikStorInstance, field: "id")}</g:link></td>

              <td>${fieldValue(bean: quikStorInstance, field: "operatorName")}</td>

              <td>${quikStorInstance?.manager?.username}</td>

            </tr>
          </g:each>
          </tbody>
        </table>
      </div>
      <div class="paginateButtons">
        <g:paginate total="${quikStorInstanceTotal}"/>
      </div>
    </div>
  </div>
</div>
</body>
<p:renderDependantJavascript/>
</html>
