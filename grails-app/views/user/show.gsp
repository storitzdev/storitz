<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
  <g:set var="title" value="Show User" scope="request"/>
</head>
<body>
<div id="body">

  <div class="stcontent">
    <div class="buttons">
      <span class="button"><a class="home" href="${createLink(controller: 'admin', action: 'index')}">Menu</a></span>
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

            <td valign="top" class="value">${fieldValue(bean: person, field: 'id')}</td>

          </tr>

          <tr class="prop">
            <td valign="top" class="name">Username:</td>

            <td valign="top" class="value">${fieldValue(bean: person, field: 'username')}</td>

          </tr>

          <tr class="prop">
            <td valign="top" class="name">User Real Name:</td>

            <td valign="top" class="value">${fieldValue(bean: person, field: 'userRealName')}</td>

          </tr>

          <tr class="prop">
            <td valign="top" class="name">Manager:</td>

            <td valign="top" class="value">${person?.manager?.username}</td>

          </tr>

          <tr class="prop">
            <td valign="top" class="name">Enabled:</td>

            <td valign="top" class="value">${fieldValue(bean: person, field: 'enabled')}</td>

          </tr>

          <tr class="prop">
            <td valign="top" class="name">Authorities:</td>

            <td valign="top" style="text-align:left;" class="value">
              <ul>
                <g:each var="role" in="${roleNames}">
                  <li>${role}</li>
                </g:each>
              </ul>
            </td>

          </tr>

          <tr class="prop">
            <td valign="top" class="name">Notification Types:</td>

            <td valign="top" style="text-align:left;" class="value">
              <ul>
                <g:each var="type" in="${notificationTypes}">
                  <li>${type.description}</li>
                </g:each>
              </ul>
            </td>

          </tr>

          <tr class="prop">
            <td valign="top" class="name">Site Privileges:</td>

            <td valign="top" style="text-align:left;" class="value">
              <ul>
                <g:each var="site" in="${siteNames}">
                  <li>${site}</li>
                </g:each>
              </ul>
            </td>

          </tr>

          <tr class="prop">
            <td valign="top" class="name">Description:</td>

            <td valign="top" class="value">${fieldValue(bean: person, field: 'description')}</td>

          </tr>

          <tr class="prop">
            <td valign="top" class="name">Email:</td>

            <td valign="top" class="value">${fieldValue(bean: person, field: 'email')}</td>

          </tr>

          </tbody>
        </table>
      </div>
      <div class="buttons">
        <g:form id="${person?.id}">
          <span class="button"><g:link action="edit" id="${person?.id}">Edit</g:link></span>
          <span class="button"><g:actionSubmit action="delete" id="${person?.id}" onclick="return confirm('Are you sure?');" value="Delete"/></span>
        </g:form>
      </div>
    </div>
  </div>
</div>
</body>
</html>
