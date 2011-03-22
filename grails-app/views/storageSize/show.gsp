<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN"
    "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head>
  <g:set var="title" value="Show Storage Unit Sizes" scope="request"/>
  <g:render template="/header"/>

  <script type="text/javascript">
    //<![CDATA[
    //]]>
  </script>

</head>
<body>
<div id="body">
  <g:render template="/topnav"/>
  <div class="stcontent">
    <g:render template="/logo_bar"/>
    <div class="nav">
      <span class="menuButton"><a class="home" href="${createLink(controller: 'admin', action: 'index')}">Admin</a></span>
      <span class="menuButton"><g:link class="list" action="list">StorageSize List</g:link></span>
      <span class="menuButton"><g:link class="create" action="create">New StorageSize</g:link></span>
    </div>
    <div class="body">
      <h1>Show StorageSize</h1>
      <g:if test="${flash.message}">
        <div class="message">${flash.message}</div>
      </g:if>
      <div class="dialog">
        <table>
          <tbody>

          <tr class="prop">
            <td valign="top" class="name">Id:</td>

            <td valign="top" class="value">${fieldValue(bean: storageSizeInstance, field: 'id')}</td>

          </tr>

          <tr class="prop">
            <td valign="top" class="name">Height:</td>

            <td valign="top" class="value">${fieldValue(bean: storageSizeInstance, field: 'height')}</td>

          </tr>

          <tr class="prop">
            <td valign="top" class="name">Description:</td>

            <td valign="top" class="value">${fieldValue(bean: storageSizeInstance, field: 'description')}</td>

          </tr>

          <tr class="prop">
            <td valign="top" class="name">Length:</td>

            <td valign="top" class="value">${fieldValue(bean: storageSizeInstance, field: 'length')}</td>

          </tr>

          <tr class="prop">
            <td valign="top" class="name">Width:</td>

            <td valign="top" class="value">${fieldValue(bean: storageSizeInstance, field: 'width')}</td>

          </tr>

          </tbody>
        </table>
      </div>
      <div class="buttons">
        <g:form>
          <input type="hidden" name="id" value="${storageSizeInstance?.id}"/>
          <span class="button"><g:actionSubmit class="edit" value="Edit"/></span>
          <span class="button"><g:actionSubmit class="delete" onclick="return confirm('Are you sure?');" value="Delete"/></span>
        </g:form>
      </div>
    </div>
  </div>
</div>
</body>
<p:renderDependantJavascript/>
</html>
