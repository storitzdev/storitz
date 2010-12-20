<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN"
    "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head>
  <g:set var="title" value="Show Press Release" scope="request"/>
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
  <g:render template="/logo_bar" />

  <div style="clear: both;height: 10px"></div>
  <div class="buttons">
    <span class="button"><a href="${createLink(controller:'admin', action:'index')}">Menu</a></span>
    <span class="button"><g:link action="list">List Press Releases</g:link></span>
    <sec:ifAnyGranted roles="ROLE_MANAGER">
      <span class="button"><g:link action="create">Create New Press Release</g:link></span>
    </sec:ifAnyGranted>

  </div>
  <div class="body">

    <div class="price_options checkout_header white">
      Press Release Details
    </div>

    <g:if test="${flash.message}">
      <div class="message">${flash.message}</div>
    </g:if>
    <div class="dialog">
      <table>
        <tbody>

        <tr class="prop">
          <td valign="top" class="name"><g:message code="pressRelease.id.label" default="Id"/></td>

          <td valign="top" class="value">${fieldValue(bean: pressReleaseInstance, field: "id")}</td>

        </tr>

        <tr class="prop">
          <td valign="top" class="name"><g:message code="pressRelease.title.label" default="Title"/></td>

          <td valign="top" class="value">${fieldValue(bean: pressReleaseInstance, field: "title")}</td>

        </tr>

        <tr class="prop">
          <td valign="top" class="name"><g:message code="pressRelease.blurb.label" default="Blurb"/></td>

          <td valign="top" class="value">${pressReleaseInstance.blurb}</td>

        </tr>

        <tr class="prop">
          <td valign="top" class="name"><g:message code="pressRelease.body.label" default="body"/></td>

          <td valign="top" class="value">${pressReleaseInstance.body}</td>

        </tr>


        <tr class="prop">
          <td valign="top" class="name"><g:message code="rentalAgreement.file.label" default="Agreement PDF"/></td>

          <td valign="top" class="value"><a href="${resource(file:pressReleaseInstance.pdfLocation)}" onclick="window.open(this.href,'_blank');return false;"><storitz:image src="icn_pdf.jpg" width="36" height="36" alt="PDF"/></a></td>

        </tr>
      </table>
    </div>
    <div class="buttons">
      <g:form>
        <g:hiddenField name="id" value="${pressReleaseInstance?.id}"/>
        <span class="button"><g:actionSubmit action="edit" value="${message(code: 'default.button.edit.label', default: 'Edit')}"/></span>
        <span class="button"><g:actionSubmit action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');"/></span>
      </g:form>
    </div>
  </div>
</div>
</div>
</body>
<p:renderDependantJavascript />
</html>
