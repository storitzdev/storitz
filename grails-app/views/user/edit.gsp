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
    <div id="body">
    <g:render template="/topnav" />
    <div id="stcontent">
      <g:render template="/logo_bar" />
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLink(controller:'admin', action:'index')}">Admin</a></span>
            <span class="menuButton"><g:link class="list" action="list">User List</g:link></span>
            <span class="menuButton"><g:link class="create" action="create">New User</g:link></span>
        </div>
        <div class="body">
            <h1>Edit User</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${userInstance}">
            <div class="errors">
                <g:renderErrors bean="${userInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form method="post" >
                <input type="hidden" name="id" value="${userInstance?.id}" />
                <input type="hidden" name="version" value="${userInstance?.version}" />
                <div class="dialog">
                    <table>
                        <tbody>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="username">Username:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:person,field:'username','errors')}">
                                    <input type="text" id="username" name="username" value="${fieldValue(bean:person,field:'username')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="userRealName">User Real Name:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:person,field:'userRealName','errors')}">
                                    <input type="text" id="userRealName" name="userRealName" value="${fieldValue(bean:person,field:'userRealName')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="passwd">Password:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:person,field:'password','errors')}">
                                    <input type="password" id="passwd" name="passwd" value="${person?.password?.encodeAsHTML()}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="repasswd">Reenter Password:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:person,field:'password','errors')}">
                                    <input type="password" id="repasswd" name="repasswd" value="${person?.password?.encodeAsHTML()}"/>
                                </td>
                            </tr>

                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label>Manager:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:person,field:'manager','errors')}">
                                    <g:select from="${User.list()}" value="${person?.manager?.id}"
                                              optionKey="id" optionValue="userRealName" name="manager.id"
                                              noSelection="['null':'No manager selected']"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="enabled">Enabled:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:person,field:'enabled','errors')}">
                                    <g:checkBox name="enabled" value="${person?.enabled}" />
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label>Assign Roles:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:person,field:'authorities','errors')}">
                                    <table><g:each var="role" in="${roleMap.keySet()}">
                                      <tr>
                                        <td valign="top" class="name" align="left">${role.authority.encodeAsHTML()}</td>
                                        <td align="left"><g:checkBox name="${role.authority}" value="${roleMap[role]}"/></td>
                                      </tr>
                                    </g:each></table>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="description">Description:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:person,field:'description','errors')}">
                                    <input type="text" id="description" name="description" value="${fieldValue(bean:person,field:'description')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="email">Email:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:person,field:'email','errors')}">
                                    <input type="text" id="email" name="email" value="${fieldValue(bean:person,field:'email')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="emailShow">Email Show:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:person,field:'emailShow','errors')}">
                                    <g:checkBox name="emailShow" value="${person?.emailShow}" />
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label>Sites:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:person,field:'sites','errors')}">
                                    
                                  <ul>
                                    <g:each var="s" in="${person?.sites}">
                                        <li><g:link controller="siteUser" action="show" id="${s.id}">${s?.encodeAsHTML()}</g:link></li>
                                    </g:each>
                                  </ul>
                                  <g:link controller="siteUser" params="['user.id':person?.id]" action="create">Add SiteUser</g:link>

                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="pass">Pass:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:person,field:'pass','errors')}">
                                    <input type="text" name="pass" id="pass" value="${fieldValue(bean:person,field:'pass')}" />
                                </td>
                            </tr> 
                        
                        </tbody>
                    </table>
                </div>
                <div class="buttons">
                    <span class="button"><g:actionSubmit class="save" value="Update" /></span>
                    <span class="button"><g:actionSubmit class="delete" onclick="return confirm('Are you sure?');" value="Delete" /></span>
                    <span class="button"><g:link class="edit" action="show" id="${person?.id}">Cancel</g:link></span>
                </div>
            </g:form>
        </div>
      </div>
    </div>
    </body>
</html>
