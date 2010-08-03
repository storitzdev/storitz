<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN"
    "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head>
  <g:set var="title" value="List Rental Agreements"/>
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
    <g:render template="/logo_bar" />

    <div style="clear: both;height: 10px"></div>
    <div class="buttons">
      <span class="button"><a href="${createLink(controller: 'admin', action: 'index')}">Menu</a></span>
      <sec:ifAnyGranted roles="ROLE_MANAGER">
        <span class="button"><g:link action="create">Add Agreement</g:link></span>
      </sec:ifAnyGranted>
    </div>

    <div class="body">

      <div class="price_options checkout_header white">
        List Rental/Lease Agreements
      </div>

      <g:if test="${flash.message}">
        <div class="message">${flash.message}</div>
      </g:if>

      <div class="list">
        <table>
          <thead>
          <tr>

            <g:sortableColumn property="id" title="${message(code: 'storageSite.id.label', default: 'Id')}"/>

            <g:sortableColumn property="title" title="${message(code: 'storageSite.title.label', default: 'Site Name')}"/>

            <g:sortableColumn property="city" title="${message(code: 'storageSite.city.label', default: 'City')}"/>

            <g:sortableColumn property="zipcode" title="${message(code: 'storageSite.zipcode.label', default: 'Zipcode')}"/>

            <g:sortableColumn property="manager" title="${message(code: 'storageSite.manager.label', default: 'Manager')}"/>

            <th>Edit</th>

          </tr>
          </thead>
          <tbody>
          <g:each in="${storageSiteInstanceList}" status="i" var="storageSiteInstance">
            <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">

              <td><g:link action="show" id="${storageSiteInstance.id}">${fieldValue(bean: storageSiteInstance, field: "id")}</g:link></td>

              <td>${fieldValue(bean: storageSiteInstance, field: "title")}</td>

              <td>${fieldValue(bean: storageSiteInstance, field: "city")}</td>

              <td>${fieldValue(bean: storageSiteInstance, field: "zipcode")}</td>

              <td>${storageSiteInstance.getManager()?.username}</td>

              <td><g:link action="edit" id="${storageSiteInstance.id}">edit</g:link></td>

            </tr>
          </g:each>
          </tbody>
        </table>
      </div>
      <div class="paginateButtons">
        <g:paginate total="${storageSiteInstanceTotal}" params="[sitename:params?.sitename]"/>
      </div>
    </div>
  </div>
</div>
</body>
</html>
