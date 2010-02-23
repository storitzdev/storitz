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
    function setupAutocomplete() {
      new Ajax.Autocompleter("manager",
                             "manager_choices",
                             "${createLink(controller:'user', action:'managers')}",
                             {}
                            );
    }

    FastInit.addOnLoad(setupAutocomplete);
  </script>

  </head>
  <body>
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
                                    <label for="manager">Manager:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:person,field:'manager','errors')}">
                                  <input type="text" id="manager" name="manager_autocomplete"/>
                                  <div id="manager_choices" class="autocomplete" ></div>
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
                                    <label for="emailShow">Email Show:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:person,field:'emailShow','errors')}">
                                    <g:checkBox name="emailShow" value="${person?.emailShow}" ></g:checkBox>
                                </td>
                            </tr> 
                        
                            <tr class='prop'>
                                <td valign='top' class='name'><label for='passwd'>Password:</label></td>
                                <td valign='top' class='value ${hasErrors(bean:person,field:'passwd','errors')}'>
                                    <input type="password" name='passwd' value="${person?.passwd?.encodeAsHTML()}"/>
                                </td>
                            </tr>

                            <tr class='prop'>
                                <td valign='top' class='name'><label for='enabled'>Confirm Password:</label></td>
                                <td valign='top' class='value ${hasErrors(bean:person,field:'passwd','errors')}'>
                                    <input type="password" name='repasswd' value="${person?.passwd?.encodeAsHTML()}"/>
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
    </body>
</html>
