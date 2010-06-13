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
<g:render template="/topnav"/>
<div id="stcontent">
        <div class="nav">
          <span class="menuButton"><a class="home" href="${createLink(controller:'admin', action:'index')}">Admin</a></span>
          <g:ifAnyGranted role="ROLE_ADMIN">
            <span class="menuButton"><g:link class="create" action="create">Create New Site</g:link></span>
          </g:ifAnyGranted>
        </div>
        <div class="body">
            <h1>Storage Site List</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="list">
                <table>
                    <thead>
                        <tr>
                        
                            <g:sortableColumn property="id" title="${message(code: 'storageSite.id.label', default: 'Id')}" />
                        
                            <g:sortableColumn property="title" title="${message(code: 'storageSite.title.label', default: 'Site Name')}" />
                        
                            <g:sortableColumn property="city" title="${message(code: 'storageSite.city.label', default: 'City')}" />
                        
                            <g:sortableColumn property="zipcode" title="${message(code: 'storageSite.zipcode.label', default: 'Zipcode')}" />

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
                <g:paginate total="${storageSiteInstanceTotal}" />
            </div>
        </div>
      </div>
    </body>
</html>
