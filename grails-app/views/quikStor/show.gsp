<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN"
    "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head>
  <g:set var="title" value="Show QuikStor Feed" scope="request"/>
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
  <div class="buttons">
    <span class="button"><a href="${createLink(controller:'admin', action:'index')}">Menu</a></span>
    <span class="button"><g:link action="list">List QuikStor Feeds</g:link></span>
    <span class="button"><g:link action="create">Create New QuikStor Feed</g:link></span>
  </div>
  <div class="body">
    <h1>Show QuikStor Feed</h1>
    <g:if test="${flash.message}">
      <div class="message">${flash.message}</div>
    </g:if>
    <div class="dialog">
      <table>
        <tbody>

        <tr class="prop">
          <td valign="top" class="name"><g:message code="quikStor.id.label" default="Id"/></td>

          <td valign="top" class="value">${fieldValue(bean: quikStorInstance, field: "id")}</td>

        </tr>

        <tr class="prop">
          <td valign="top" class="name"><g:message code="quikStor.url.label" default="WSDL Url"/></td>

          <td valign="top" class="value">${fieldValue(bean: quikStorInstance, field: "url")}</td>

        </tr>

        <tr class="prop">
          <td valign="top" class="name"><g:message code="quikStor.operatorName.label" default="Operator Name"/></td>

          <td valign="top" class="value">${fieldValue(bean: quikStorInstance, field: "operatorName")}</td>

        </tr>

        <tr class="prop">
          <td valign="top" class="name"><g:message code="quikStor.manager.label" default="Manager"/></td>

          <td valign="top" class="value"><g:link controller="user" action="show" id="${quikStorInstance?.manager?.id}">${quikStorInstance?.manager?.username?.encodeAsHTML()}</g:link></td>

        </tr>

        <tr class="prop">
          <td valign="top" class="name"><g:message code="quikStor.sites.label" default="Sites"/></td>

          <td valign="top" style="text-align: left;" class="value">
            <table>
              <thead>
                <tr>
                  <th>Site Name</th>
                  <th>User</th>
                  <th>Password</th>
                </tr>
              </thead>
              <tbody>
              <g:each in="${quikStorInstance.locations.sort{ it.sitename }}" var="s">
                <tr>
                  <td>${s.sitename}</td>
                  <td>${s.username}</td>
                  <td>${s.password}</td>
                </tr>
              </g:each>
              </tbody>
            </table>
          </td>
        </tr>

        <tr class="prop">
          <td valign="top" class="name"><g:message code="quikStor.sites.label" default="Sites"/></td>

          <td valign="top" style="text-align: left;" class="value">
            <ul>
              <g:each in="${quikStorInstance.sites.sort{ it.title }}" var="s">
                <li><g:link controller="storageSite" action="show" id="${s.id}">${s?.title}</g:link></li>
              </g:each>
            </ul>
          </td>
        </tr>
        </tbody>
      </table>
    </div>
    <div class="buttons">
      <g:form>
        <g:hiddenField name="id" value="${quikStorInstance?.id}"/>
        <span class="button"><g:actionSubmit action="edit" value="${message(code: 'default.button.edit.label', default: 'Edit')}"/></span>
        <span class="button"><g:actionSubmit action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');"/></span>
        <span class="button"><g:actionSubmit action="refresh" value="${message(code: 'default.button.refresh.label', default: 'Refresh Sites')}"/></span>
        <span class="button"><g:actionSubmit action="processLocations" value="${message(code: 'default.button.processLocations.label', default: 'Process Locations')}"/></span>
        <span class="button"><g:actionSubmit action="updateInventory" value="${message(code: 'default.button.refresh.promos.label', default: 'Update Inventory')}"/></span>
        <span class="button"><g:actionSubmit action="createContacts" value="${message(code: 'default.button.create.contacts.label', default: 'Create Contacts')}"/></span>
        <span class="button"><g:actionSubmit action="updateTax" value="${message(code: 'default.button.create.contacts.label', default: 'Refresh tax')}"/></span>
        <span class="button"><g:actionSubmit action="refreshInsurance" value="${message(code: 'default.button.refresh.insurance.label', default: 'Refresh Insurance')}"/></span>
        <span class="button"><g:actionSubmit action="refreshPromos" value="${message(code: 'default.button.refresh.promos.label', default: 'Refresh Promos')}"/></span>
      </g:form>
      <sec:ifAnyGranted roles="ROLE_ADMIN">
        <span class="button"><g:link controller="feed" action="seoLinks" id="${quikStorInstance?.id}">SEO Links</g:link> </span>
      </sec:ifAnyGranted>
      
    </div>
  </div>
</div>
</div>
</body>
<p:renderDependantJavascript />
</html>
