<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN"
    "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" >
  <head>
    <g:set var="title" value="Show User" scope="request"/>
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
        <div class="buttons">
            <span class="button"><a class="home" href="${createLink(controller:'admin', action:'index')}">Menu</a></span>
            <span class="button"><g:link action="list">User List</g:link></span>
            <span class="button"><g:link action="create">New User</g:link></span>
        </div>
        <div class="body">

          <div class="price_options checkout_header white">
            Show User
          </div>

            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="dialog">
                <table>
                    <tbody>

                    
                        <tr class="prop">
                            <td valign="top" class="name">Id:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:person, field:'id')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Username:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:person, field:'username')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">User Real Name:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:person, field:'userRealName')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Manager:</td>
                            
                            <td valign="top" class="value">${person?.manager?.username}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Enabled:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:person, field:'enabled')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Authorities:</td>
                            
                            <td  valign="top" style="text-align:left;" class="value">
                                <ul>
                                <g:each var="role" in="${roleNames}">
                                    <li>${role}</li>
                                </g:each>
                                </ul>
                            </td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Notification Types:</td>

                            <td  valign="top" style="text-align:left;" class="value">
                                <ul>
                                <g:each var="type" in="${notificationTypes}">
                                    <li>${type.description}</li>
                                </g:each>
                                </ul>
                            </td>

                        </tr>

                        <tr class="prop">
                            <td valign="top" class="name">Site Privileges:</td>

                            <td  valign="top" style="text-align:left;" class="value">
                                <ul>
                                <g:each var="site" in="${siteNames}">
                                    <li>${site}</li>
                                </g:each>
                                </ul>
                            </td>

                        </tr>

                        <tr class="prop">
                            <td valign="top" class="name">Description:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:person, field:'description')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Email:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:person, field:'email')}</td>
                            
                        </tr>
                    
                    </tbody>
                </table>
            </div>
            <div class="buttons">
                <g:form>
                  <span class="button"><g:link action="edit" id="${person?.id}">Edit</g:link></span>
                  <span class="button"><g:actionSubmit action="delete" onclick="return confirm('Are you sure?');" value="Delete" /></span>
                </g:form>
            </div>
        </div>
      </div>
    </div>
  </body>
</html>
