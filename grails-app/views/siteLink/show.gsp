<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN"
    "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head>
  <g:set var="title" value="Show SiteLink Feed"/>
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
    <span class="menuButton"><g:link class="create" action="create">Create New SiteLink Feed</g:link></span>
  </div>
  <div class="body">
    <h1>Show SiteLink Feed</h1>
    <g:if test="${flash.message}">
      <div class="message">${flash.message}</div>
    </g:if>
    <div class="dialog">
      <table>
        <tbody>

        <tr class="prop">
          <td valign="top" class="name"><g:message code="siteLink.id.label" default="Id"/></td>

          <td valign="top" class="value">${fieldValue(bean: siteLinkInstance, field: "id")}</td>

        </tr>

        <tr class="prop">
          <td valign="top" class="name"><g:message code="siteLink.manager.label" default="Manager"/></td>

          <td valign="top" class="value"><g:link controller="user" action="show" id="${siteLinkInstance?.manager?.id}">${siteLinkInstance?.manager?.username?.encodeAsHTML()}</g:link></td>

        </tr>

        <tr class="prop">
          <td valign="top" class="name"><g:message code="siteLink.corpCode.label" default="Corp Code"/></td>

          <td valign="top" class="value">${fieldValue(bean: siteLinkInstance, field: "corpCode")}</td>

        </tr>

        <tr class="prop">
          <td valign="top" class="name"><g:message code="siteLink.userName.label" default="User Name"/></td>

          <td valign="top" class="value">${fieldValue(bean: siteLinkInstance, field: "userName")}</td>

        </tr>

        <tr class="prop">
          <td valign="top" class="name"><g:message code="siteLink.password.label" default="Password"/></td>

          <td valign="top" class="value">${fieldValue(bean: siteLinkInstance, field: "password")}</td>

        </tr>

        <tr class="prop">
          <td valign="top" class="name"><g:message code="siteLink.sites.label" default="Sites"/></td>

          <td valign="top" style="text-align: left;" class="value">
            <ul>
              <g:each in="${siteLinkInstance.sites}" var="s">
                <li><g:link controller="storageSite" action="show" id="${s.id}">${s?.encodeAsHTML()}</g:link></li>
              </g:each>
            </ul>
          </td>

        </tr>

        </tbody>
      </table>
    </div>
    <div class="buttons">
      <g:form>
        <g:hiddenField name="id" value="${siteLinkInstance?.id}"/>
        <span class="button"><g:actionSubmit class="edit" action="edit" value="${message(code: 'default.button.edit.label', default: 'Edit')}"/></span>
        <span class="button"><g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');"/></span>
      </g:form>
    </div>
  </div>
</div>
</body>
</html>
