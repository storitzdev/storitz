<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN"
    "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head>
  <g:set var="title" value="Create Storage Site"/>
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
    <div class="nav">
      <span class="menuButton"><a class="home" href="${createLink(controller: 'admin', action: 'index')}">Admin</a></span>
      <sec:ifAnyGranted roles="ROLE_ADMIN">
        <span class="menuButton"><g:link class="create" action="create">Create New Site</g:link></span>
      </sec:ifAnyGranted>
    </div>
    <div class="body">
      <h1>Storage Site List</h1>
      <g:if test="${flash.message}">
        <div class="message">${flash.message}</div>
      </g:if>
      <g:form action="list" method="post" >
          <div class="dialog">
              <table>
                  <tbody>
                    <tr class='prop'>
                          <td valign='top' class='name'>
                              <label for='sitename'>Site name:</label>
                          </td>
                          <td valign='top' class='value'>
                              <input type="text" id="sitename" name="sitename" value="${flash.sitename}"/>
                          </td>
                      </tr>
                  </tbody>
                </table>
            </div>
            <div class="buttons">
                <span class="button"><input class="save" type="submit" value="Search" /></span>
            </div>
      </g:form>

      <div class="list">
        <table>
          <thead>
          <tr>

            <g:sortableColumn property="id" title="${message(code: 'storageSite.id.label', default: 'Id')}"/>

            <g:sortableColumn property="title" title="${message(code: 'storageSite.title.label', default: 'Site Name')}"/>

            <g:sortableColumn property="city" title="${message(code: 'storageSite.city.label', default: 'City')}"/>

            <g:sortableColumn property="zipcode" title="${message(code: 'storageSite.zipcode.label', default: 'Zipcode')}"/>

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
