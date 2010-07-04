<%@ page import="com.storitz.StorageSite" %>



<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head>
  <g:set var="title" value="Edit SiteLink Feed"/>
  <g:render template="/header"/>

  <script type="text/javascript">
    //<![CDATA[
    //]]>
  </script>

</head>
<body>
<div id="body">
<g:render template="/topnav"/>
<div id="stcontent">
  <g:render template="/logo_bar"/>
  <div class="nav">
    <span class="menuButton"><a class="home" href="${createLink(controller:'admin', action:'index')}">Admin</a></span>
    <span class="menuButton"><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]"/></g:link></span>
    <span class="menuButton"><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]"/></g:link></span>
  </div>
  <div class="body">
    <h1><g:message code="default.edit.label" args="[entityName]"/></h1>
    <g:if test="${flash.message}">
      <div class="message">${flash.message}</div>
    </g:if>
    <g:hasErrors bean="${siteLinkInstance}">
      <div class="errors">
        <g:renderErrors bean="${siteLinkInstance}" as="list"/>
      </div>
    </g:hasErrors>
    <g:form method="post">
      <g:hiddenField name="id" value="${siteLinkInstance?.id}"/>
      <g:hiddenField name="version" value="${siteLinkInstance?.version}"/>
      <div class="dialog">
        <table>
          <tbody>

          <tr class="prop">
            <td valign="top" class="name">
              <label for="manager.id"><g:message code="siteLink.manager.label" default="Manager"/></label>
            </td>
            <td valign="top" class="value ${hasErrors(bean: siteLinkInstance, field: 'manager', 'errors')}">
              <g:select name="manager.id" from="${User.list()}" optionKey="id" value="${siteLinkInstance?.manager?.id}" noSelection="['null': '']"/>
            </td>
          </tr>

          <tr class="prop">
            <td valign="top" class="name">
              <label for="corpCode"><g:message code="siteLink.corpCode.label" default="Corp Code"/></label>
            </td>
            <td valign="top" class="value ${hasErrors(bean: siteLinkInstance, field: 'corpCode', 'errors')}">
              <g:textField name="corpCode" value="${siteLinkInstance?.corpCode}"/>
            </td>
          </tr>

          <tr class="prop">
            <td valign="top" class="name">
              <label for="userName"><g:message code="siteLink.userName.label" default="User Name"/></label>
            </td>
            <td valign="top" class="value ${hasErrors(bean: siteLinkInstance, field: 'userName', 'errors')}">
              <g:textField name="userName" value="${siteLinkInstance?.userName}"/>
            </td>
          </tr>

          <tr class="prop">
            <td valign="top" class="name">
              <label for="password"><g:message code="siteLink.password.label" default="Password"/></label>
            </td>
            <td valign="top" class="value ${hasErrors(bean: siteLinkInstance, field: 'password', 'errors')}">
              <g:textField name="password" value="${siteLinkInstance?.password}"/>
            </td>
          </tr>

          <tr class="prop">
            <td valign="top" class="name">
              <label for="sites"><g:message code="siteLink.sites.label" default="Sites"/></label>
            </td>
            <td valign="top" class="value ${hasErrors(bean: siteLinkInstance, field: 'sites', 'errors')}">
              <g:select name="sites" from="${StorageSite.list()}" multiple="yes" optionKey="id" size="5" value="${siteLinkInstance?.sites}"/>
            </td>
          </tr>

          </tbody>
        </table>
      </div>
      <div class="buttons">
        <span class="button"><g:actionSubmit class="save" action="update" value="${message(code: 'default.button.update.label', default: 'Update')}"/></span>
        <span class="button"><g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');"/></span>
      </div>
    </g:form>
  </div>
</div>
</div>
</body>
</html>
