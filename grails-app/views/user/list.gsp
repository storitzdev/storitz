<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN"
    "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" >
  <head>
    <g:set var="title" value="User List"/>
    <g:render template="/header" />

    <script type="text/javascript">
//<![CDATA[
//]]>
  </script>

  </head>
  <body>
    <g:render template="/topnav" />
    <div id="stcontent">
      <g:render template="/logo_bar" />
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLink(controller:'admin', action:'index')}">Admin</a></span>
            <span class="menuButton"><g:link class="create" action="create">New User</g:link></span>
        </div>
        <div class="body">
            <h1>User List</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:form action="list" method="post" >
                <div class="dialog">
                    <table>
                        <tbody>
                          <tr class='prop'>
                                <td valign='top' class='name'>
                                    <label for='username'>User name:</label>
                                </td>
                                <td valign='top' class='value'>
                                    <input type="text" id="username" name="username" value="${flash.username}"/>
                                </td>
                            </tr>
                        </tbody>
                      </table>
                  </div>
                  <div class="buttons">
                      <span class="button"><input class="save" type="submit" value="Search" /></span>
                  </div>
            </g:form>
            <div style="height:20px;"></div>
            <div class="list">
                <table>
                    <thead>
                        <tr>
                        
                   	        <g:sortableColumn property="id" title="Id" params="${flash}" />
                        
                   	        <g:sortableColumn property="username" title="Username" params="${flash}" />
                        
                   	        <g:sortableColumn property="userRealName" title="User Real Name" params="${flash}"/>
                        
                   	        <g:sortableColumn property="manager" title="Manager" params="${flash}"/>
                        
                            <g:sortableColumn property="description" title="Description" params="${flash}"/>

                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${personList}" status="i" var="userInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td><g:link action="show" id="${userInstance.id}">${fieldValue(bean:userInstance, field:'id')}</g:link></td>
                        
                            <td>${fieldValue(bean:userInstance, field:'username')}</td>
                        
                            <td>${fieldValue(bean:userInstance, field:'userRealName')}</td>
                        
                            <td>${userInstance.manager?.username}</td>
                        
                            <td>${fieldValue(bean:userInstance, field:'description')}</td>

                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
              <g:paginate total="${personList.count()}" params="${flash}"/>
            </div>
        </div>
      </div>
    </body>
</html>
