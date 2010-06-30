<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN"
    "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head>
  <g:set var="title" value="Create SiteLink Feed"/>
  <g:render template="/header"/>

  <script type="text/javascript">
    //<![CDATA[
    //]]>
  </script>

</head>
<body>
<g:render template="/topnav"/>
<div id="stcontent">
  <g:render template="/logo_bar"/>
  <div class="nav">
    <span class="menuButton"><a class="home" href="${createLink(controller:'admin', action:'index')}">Admin</a></span>
    <span class="menuButton"><g:link class="list" action="list">List SiteLink Feeds</g:link></span>
  </div>
  <div class="body">
    <h1>Create SiteLink Feed</h1>
    <g:if test="${flash.message}">
      <div class="message">${flash.message}</div>
    </g:if>
    <g:hasErrors bean="${siteLinkInstance}">
      <div class="errors">
        <g:renderErrors bean="${siteLinkInstance}" as="list"/>
      </div>
    </g:hasErrors>
    <g:form action="save" method="post">
      <div class="dialog">
        <table>
          <tbody>

          <tr class="prop">
            <td valign="top" class="name">
              <label for="manager.id"><g:message code="siteLink.manager.label" default="Manager"/></label>
            </td>
            <td valign="top" class="value ${hasErrors(bean: siteLinkInstance, field: 'manager', 'errors')}">
              <g:select name="manager.id" from="${com.storitz.User.list()}" optionKey="id" optionValue="username" value="${siteLinkInstance?.manager?.username}" noSelection="['null': '']"/>
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

          </tbody>
        </table>
      </div>
      <div class="buttons">
        <span class="button"><g:submitButton name="create" class="save" value="${message(code: 'default.button.create.label', default: 'Create')}"/></span>
      </div>
    </g:form>
  </div>
</div>
</body>
</html>
