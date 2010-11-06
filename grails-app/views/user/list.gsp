<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN"
    "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" >
  <head>
    <g:set var="title" value="User List" scope="request"/>
    <g:render template="/header_admin"/>

    <p:dependantJavascript>
      <script type="text/javascript">
//<![CDATA[

      $(document).ready(function() {
        jQuery.noConflict();

        setupUserSelector();
      });

      function setupUserSelector() {
        jQuery("input#username").autocomplete({source:"${createLink(controller:'user', action:'autocompleteUser')}"});
      }

//]]>
    </script>
  </p:dependantJavascript>
  </head>
  <body>
    <div id="body">
    <g:render template="/topnav" />
    <div class="stcontent">
      <g:render template="/logo_bar" />
        <div class="buttons">
            <span class="button"><a href="${createLink(controller:'admin', action:'index')}">Menu</a></span>
            <span class="button"><g:link action="create">New User</g:link></span>
        </div>
        <div class="body">

          <div class="price_options checkout_header white">
            List Users
          </div>

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
                                  <span class="button"><input class="save" type="submit" value="Search" /></span>
                                </td>
                            </tr>
                        </tbody>
                      </table>
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
              <g:paginate total="${personListCount}" params="${flash}"/>
            </div>
        </div>
      </div>
    </div>
  </body>
  <p:renderDependantJavascript/>
</html>
