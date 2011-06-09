<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN"
    "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head>
  <g:set var="title" value="List Videos" scope="request"/>
  <g:render template="/header"/>

  <script type="text/javascript">
    //<![CDATA[
    //]]>
  </script>

</head>
<body>
<div id="body">
  <g:render template="/topnav"/>
  <div class="stcontent">
    <g:render template="/logo_bar"/>
    <div class="buttons">
      <span class="button"><a href="${createLink(controller: 'admin', action: 'index')}">Menu</a></span>
      <span class="button"><g:link action="create">Create New Video</g:link></span>
    </div>
    <div class="body">

      <div class="price_options checkout_header white">
        List Videos
      </div>

      <g:if test="${flash.message}">
        <div class="message">${flash.message}</div>
      </g:if>
      <div class="list">
        <table>
          <thead>
          <tr>

            <g:sortableColumn property="id" title="${message(code: 'video.id.label', default: 'Id')}"/>

            <g:sortableColumn property="title" title="${message(code: 'video.title.label', default: 'Title')}"/>

            <g:sortableColumn property="release" title="${message(code: 'video.releaseDate.label', default: 'Release Date')}"/>

            <g:sortableColumn property="useYouTube" title="${message(code: 'video.useYouTube.label', default: 'Uses Youtube Player')}" />

            <g:sortableColumn property="release" title="${message(code: 'video.releaseDate.label', default: 'External Link')}"/>
          </tr>
          </thead>
          <tbody>
          <g:each in="${videoInstanceList}" status="i" var="videoInstance">
            <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">

              <td><g:link action="show" id="${videoInstance.id}">${fieldValue(bean: videoInstance, field: "id")}</g:link></td>

              <td>${fieldValue(bean: videoInstance, field: "title")}</td>

              <td>${videoInstance?.releaseDate?.format('MM-dd-yyyy')}</td>

              <td>${videoInstance?.useYouTube ? "Yes" : "No" }</td>

              <td>
                <g:createLink mapping="video" absolute="true" params="[id:videoInstance.id, date:videoInstance.releaseDate.format('MM-dd-yyyy'), title:videoInstance.urlTitle ? videoInstance.urlTitle : videoInstance.title]"/>
              </td>
            </tr>
          </g:each>
          </tbody>
        </table>
      </div>
      <div class="paginateButtons">
        <g:paginate total="${videoInstanceTotal}"/>
      </div>
    </div>
  </div>
</div>
</body>
<p:renderDependantJavascript/>
</html>
