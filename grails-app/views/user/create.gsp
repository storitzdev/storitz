<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN"
    "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" >
  <head>
    <script src="http://www.google.com/jsapi" type="text/javascript"></script>
    <g:set var="title" value="User List"/>
    <g:render template="/header" />

    <script type="text/javascript">
//<![CDATA[
    google.load("prototype", "1.6.1.0");
    google.load("scriptaculous", "1.8.3");
//]]>

    FastInit.addOnLoad(setupAutocomplete);
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
        </div>
        <div class="body">
            <h1>Create User</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${person}">
            <div class="errors">
                <g:renderErrors bean="${person}" as="list" />
            </div>
            </g:hasErrors>
            <g:form action="save" method="post" >
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
                                    <label for="manager.id">Manager:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:person,field:'manager','errors')}">
                                  <g:select name="manager.id" from="${com.storitz.UserRole.getUsersByRoleName('ROLE_MANAGER')}" optionKey="id" optionValue="username" value="${siteLinkInstance?.manager?.username}" noSelection="['null': '']"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="enabled">Enabled:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:person,field:'enabled','errors')}">
                                    <g:checkBox name="enabled" value="${person?.enabled}" ></g:checkBox>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="description">Description:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:person,field:'description','errors')}">
                                    <g:textArea name="description" value="${fieldValue(bean:person,field:'description')}" rows="5" cols="40" />
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
                                    <label for="accountExpired">Account Expired:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:person,field:'accountExpired','errors')}">
                                    <g:checkBox name="accountExpired" value="${person?.accountExpired}" ></g:checkBox>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="accountLocked">Account Locked:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:person,field:'accountLocked','errors')}">
                                    <g:checkBox name="accountLocked" value="${person?.accountLocked}" ></g:checkBox>
                                </td>
                            </tr>

                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="passwordExpired">Password Expired:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:person,field:'passwordExpired','errors')}">
                                    <g:checkBox name="passwordExpired" value="${person?.passwordExpired}" ></g:checkBox>
                                </td>
                            </tr>

                            <tr class='prop'>
                                <td valign='top' class='name'><label for='passwd'>Password:</label></td>
                                <td valign='top' class='value ${hasErrors(bean:person,field:'password','errors')}'>
                                    <input type="password" id="passwd" name='passwd' value="${person?.password?.encodeAsHTML()}"/>
                                </td>
                            </tr>

                            <tr class='prop'>
                                <td valign='top' class='name'><label for='enabled'>Confirm Password:</label></td>
                                <td valign='top' class='value ${hasErrors(bean:person,field:'password','errors')}'>
                                    <input type="password" name='repasswd' value="${person?.password?.encodeAsHTML()}"/>
                                </td>
                            </tr>

                            <tr class="prop">
                                <td valign="top" class="name" align="left">Assign Roles:</td>
                            </tr>

                            <g:each in="${authorityList}">
                            <tr>
                                <td valign="top" class="name" align="left">${it.authority.encodeAsHTML()}</td>
                                <td align="left"><g:checkBox name="${it.authority}"/></td>
                            </tr>
                            </g:each>
                        
                        </tbody>
                    </table>
                </div>
                <div class="buttons">
                    <span class="button"><input class="save" type="submit" value="Create" /></span>
                </div>
            </g:form>
        </div>
      </div>
    </div>
  </body>
</html>
