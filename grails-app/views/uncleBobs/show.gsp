<%@ page import="com.storitz.UncleBobs" %>
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN"
    "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head>
  <g:set var="title" value="Show Uncle Bob's Feed" scope="request"/>
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
      <span class="button"><a href="${createLink(controller: 'admin', action: 'index')}">Menu</a></span>
      <span class="button"><g:link action="list">List Uncle Bob's Feeds</g:link></span>
      <span class="button"><g:link action="create">Create New Uncle Bob's Feed</g:link></span>
    </div>
    <div class="body">
      <h1>Show Uncle Bob's Feed</h1>
      <g:if test="${flash.message}">
        <div class="message">${flash.message}</div>
      </g:if>
      <div class="dialog">
        <table>
          <tbody>

          <tr class="prop">
            <td valign="top" class="name"><g:message code="uncleBobs.id.label" default="Id"/></td>

            <td valign="top" class="value">${fieldValue(bean: uncleBobsInstance, field: "id")}</td>

          </tr>

          <tr class="prop">
            <td valign="top" class="name"><g:message code="uncleBobs.operatorName.label" default="Operator Name"/></td>

            <td valign="top" class="value">${fieldValue(bean: uncleBobsInstance, field: "operatorName")}</td>

          </tr>

          <tr class="prop">
            <td valign="top" class="name"><g:message code="uncleBobs.UBCompanyName.label" default="Uncle Bob's Company Name"/></td>

            <td valign="top" class="value">${fieldValue(bean: uncleBobsInstance, field: "UBCompanyName")}</td>

          </tr>

          <tr class="prop">
            <td valign="top" class="name"><g:message code="storageSite.address.label" default="Address1"/></td>

            <td valign="top" class="value">${fieldValue(bean: uncleBobsInstance, field: "address1")}</td>

          </tr>

          <tr class="prop">
            <td valign="top" class="name"><g:message code="storageSite.address2.label" default="Address2"/></td>

            <td valign="top" class="value">${fieldValue(bean: uncleBobsInstance, field: "address2")}</td>

          </tr>

          <tr class="prop">
            <td valign="top" class="name"><g:message code="storageSite.city.label" default="City"/></td>

            <td valign="top" class="value">${fieldValue(bean: uncleBobsInstance, field: "city")}</td>

          </tr>

          <tr class="prop">
            <td valign="top" class="name"><g:message code="storageSite.state.label" default="State"/></td>

            <td valign="top" class="value">${uncleBobsInstance.state?.display}</td>

          </tr>

          <tr class="prop">
            <td valign="top" class="name"><g:message code="storageSite.zipcode.label" default="Zipcode"/></td>

            <td valign="top" class="value">${fieldValue(bean: uncleBobsInstance, field: "zipcode")}</td>

          </tr>

          <tr class="prop">
            <td valign="top" class="name"><g:message code="uncleBobs.manager.label" default="Manager"/></td>

            <td valign="top" class="value"><g:link controller="user" action="show" id="${uncleBobsInstance?.manager?.id}">${uncleBobsInstance?.manager?.username?.encodeAsHTML()}</g:link></td>

          </tr>

          <tr class="prop">
            <td valign="top" class="name"><g:message code="uncleBobs.reservationMoveInDescription" default="Reservation Move-In Description"/></td>

            <td valign="top" class="value">${fieldValue(bean: uncleBobsInstance, field: "reservationMoveInDescription")}</td>

          </tr>


          <tr class="prop">
            <td valign="top" class="name"><g:message code="uncleBobs.transactionBoxLink" default="Transaction Box Link"/></td>

            <td valign="top" class="value">${fieldValue(bean: uncleBobsInstance, field: "transactionBoxLink")}</td>

          </tr>

          <tr class="prop">
            <td valign="top" class="name"><g:message code="uncleBobs.transactionBoxBody" default="Transaction Box Body"/></td>

            <td valign="top" class="value">${fieldValue(bean: uncleBobsInstance, field: "transactionBoxBody")}</td>

          </tr>

          <tr class="prop">
            <td valign="top" class="name"><g:message code="uncleBobs.commissionSchedule.label" default="Commission Schedule"/></td>

            <td valign="top" class="value">${uncleBobsInstance.commissionSchedule?.scheduleName}</td>

          </tr>

          <tr class="prop">
            <td valign="top" class="name"><g:message code="uncleBobs.sites.label" default="Sites"/></td>

            <td valign="top" style="text-align: left;" class="value">
              <ul>
                <g:each in="${uncleBobsInstance.sites.sort{ it.title }}" var="s">
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
          <g:hiddenField name="id" value="${uncleBobsInstance?.id}"/>
          <span class="button"><g:actionSubmit action="edit" value="${message(code: 'default.button.edit.label', default: 'Edit')}"/></span>
          <span class="button"><g:actionSubmit action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');"/></span>
          <span class="button"><g:actionSubmit action="refresh" value="${message(code: 'default.button.refresh.label', default: 'Refresh Sites, Units, and Promotions')}"/></span>
          <!--
          <span class="button"><g:actionSubmit action="updateInventory" value="${message(code: 'default.button.refresh.promos.label', default: 'Update Inventory')}"/></span>
          <span class="button"><g:actionSubmit action="createContacts" value="${message(code: 'default.button.create.contacts.label', default: 'Create contacts')}"/></span>
          <span class="button"><g:actionSubmit action="updateTax" value="${message(code: 'default.button.create.contacts.label', default: 'Refresh tax')}"/></span>
          <span class="button"><g:actionSubmit action="updateProration" value="${message(code: 'default.button.create.contacts.label', default: 'Refresh proration')}"/></span>
          <span class="button"><g:actionSubmit action="refreshInsurance" value="${message(code: 'default.button.refresh.insurance.label', default: 'Refresh Insurance')}"/></span>
          <span class="button"><g:actionSubmit action="refreshPromos" value="${message(code: 'default.button.refresh.promos.label', default: 'Refresh Promos')}"/></span>
          -->
        </g:form>
        <sec:ifAnyGranted roles="ROLE_ADMIN">
          <span class="button"><g:link controller="feed" action="seoLinks" id="${uncleBobsInstance?.id}">SEO Links</g:link></span>
        </sec:ifAnyGranted>

      </div>
    </div>
  </div>
</div>
</body>
<p:renderDependantJavascript/>
</html>
