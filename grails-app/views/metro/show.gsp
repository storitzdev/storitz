<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
  <g:set var="title" value="Show Metro" scope="request"/>
</head>
<body>
<div id="body">

  <div class="stcontent">
    <div class="buttons">
      <span class="button"><a class="home" href="${createLink(controller: 'admin', action: 'index')}">Menu</a></span>
      <span class="button"><g:link action="list">Metro List</g:link></span>
      <span class="button"><g:link action="create">New Metro</g:link></span>
    </div>
    <div class="body">

      <div class="price_options checkout_header white">
        Show Metro
      </div>

      <g:if test="${flash.message}">
        <div class="message">${flash.message}</div>
      </g:if>
      <div class="dialog">
        <table>
          <tbody>

          <tr class="prop">
            <td valign="top" class="name">Id:</td>

            <td valign="top" class="value">${fieldValue(bean: metroInstance, field: 'id')}</td>

          </tr>

          <tr class="prop">
            <td valign="top" class="name">Metro:</td>

            <td valign="top" class="value">${fieldValue(bean: metroInstance, field: 'city')}</td>

          </tr>

          <tr class="prop">
            <td valign="top" class="name">State:</td>

            <td valign="top" class="value">${metroInstance?.state?.display}</td>

          </tr>

          <tr class="prop">
            <td valign="top" class="name">Neighborhood:</td>

            <td valign="top" class="value">${fieldValue(bean: metroInstance, field: 'isNeighborhood')}</td>

          </tr>


          <tr class="prop">
            <td valign="top" class="name">Description:</td>

            <td valign="top" class="value">${fieldValue(bean: metroInstance, field: 'note')}</td>

          </tr>

          </tbody>
        </table>
      </div>
      <div class="buttons">
        <g:form>
          <input type="hidden" name="id" value="${metroInstance?.id}"/>
          <span class="button"><g:link action="edit" id="${metroInstance?.id}">Edit</g:link></span>
          <span class="button"><g:actionSubmit action="delete" onclick="return confirm('Are you sure?');" value="Delete"/></span>
        </g:form>
      </div>
    </div>
  </div>
</div>
</body>
</html>
