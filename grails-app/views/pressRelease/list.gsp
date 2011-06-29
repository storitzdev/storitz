<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN"
    "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head>
  <g:set var="title" value="List Press Releases" scope="request"/>
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
      <span class="button"><g:link action="create">Create New Press Release</g:link></span>
    </div>
    <div class="body">

      <div class="price_options checkout_header white">
        List Press Releases
      </div>

      <g:if test="${flash.message}">
        <div class="message">${flash.message}</div>
      </g:if>
      <div class="list">
        <table>
          <thead>
          <tr>

            <g:sortableColumn property="id" title="${message(code: 'pressRelease.id.label', default: 'Id')}"/>

            <g:sortableColumn property="title" title="${message(code: 'pressRelease.title.label', default: 'Title')}"/>

            <g:sortableColumn property="release" title="${message(code: 'cshift.releaseDate.label', default: 'Release Date')}"/>
          </tr>
          </thead>
          <tbody>
          <g:each in="${pressReleaseInstanceList}" status="i" var="pressReleaseInstance">
            <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">

              <td><g:link action="show" id="${pressReleaseInstance.id}">${fieldValue(bean: pressReleaseInstance, field: "id")}</g:link></td>

              <td>${fieldValue(bean: pressReleaseInstance, field: "title")}</td>

              <td>${pressReleaseInstance?.releaseDate?.format('MM-dd-yyyy')}</td>

            </tr>
          </g:each>
          </tbody>
        </table>
      </div>
      <div class="paginateButtons">
        <g:paginate total="${pressReleaseInstanceTotal}"/>
      </div>
    </div>
  </div>
</div>
</body>
<p:renderDependantJavascript/>
</html>
