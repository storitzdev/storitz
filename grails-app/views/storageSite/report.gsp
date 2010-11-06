<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN"
    "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head>
  <g:set var="title" value="Storage Site Report" scope="request"/>
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
  <div class="nav">
    <span class="menuButton"><a class="home" href="${createLink(controller:'admin', action:'index')}">Admin</a></span>
    <span class="menuButton"><g:link class="list" action="list">List Storage Sites</g:link></span>
    %{--<span class="menuButton"><g:link class="show" action="show" id="${storageSiteInstance.id}">Storage Site Report</g:link></span>--}%
    <sec:ifAnyGranted roles="ROLE_ADMIN">
      <span class="menuButton"><g:link class="create" action="create">Create New Storage Site</g:link></span>
    </sec:ifAnyGranted>
  </div>
  <div class="body">
    <h1>Storage Site Details</h1>
    <g:if test="${flash.message}">
      <div class="message">${flash.message}</div>
    </g:if>
    <div class="dialog">
      <table>
        <tbody>

        <tr class="prop">
          <td valign="top" class="name"><g:message code="storageSite.id.label" default="Id"/></td>

          <td valign="top" class="value">${fieldValue(bean: storageSiteInstance, field: "id")}</td>

        </tr>

        <tr class="prop">
          <td valign="top" class="name"><g:message code="storageSite.logo.label" default="Logo"/></td>

          <td valign="top" class="value">
            <g:if test="${storageSiteInstance?.logo}">
              <img src="${resource(file:storageSiteInstance.logo.src())}" alt="logo"/>
            </g:if>
          </td>

        </tr>

        <tr class="prop">
          <td valign="top" class="name"><g:message code="storageSite.title.label" default="Title"/></td>

          <td valign="top" class="value">${fieldValue(bean: storageSiteInstance, field: "title")}</td>

        </tr>

        <tr class="prop">
          <td valign="top" class="name"><g:message code="storageSite.description.label" default="Description"/></td>

          <td valign="top" class="value">${fieldValue(bean: storageSiteInstance, field: "description").decodeHTML()}</td>

        </tr>

        <tr class="prop">
          <td valign="top" class="name"><g:message code="storageSite.visits.label" default="Visit Count"/></td>

          <td valign="top" style="text-align: left;" class="value">
            <span>${visits.size()}</span>
          </td>
        </tr>

        <tr class="prop">
          <td valign="top" class="name"><g:message code="storageSite.visits.label" default="Visits"/></td>

          <td valign="top" style="text-align: left;" class="value">
              <g:each in="${visits}" var="v">
                <span>${v.dateCreated}, </span>
              </g:each>
          </td>
        </tr>

        </tbody>
      </table>
    </div>
    <div class="buttons">
      <g:form>
        <g:hiddenField name="id" value="${storageSiteInstance?.id}"/>
        <span class="button"><g:actionSubmit class="table" action="show" value="${message(code: 'default.button.show.label', default: 'Show')}"/></span>
      </g:form>
    </div>
  </div>
</div>
</div>
</body>
</html>
