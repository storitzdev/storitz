<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="com.storitz.StorageMart" %>
<html>
<head>
  <g:set var="title" value="Show Storage Mart Feed" scope="request"/>
</head>
<body>
<div id="body">
  <div class="stcontent">
    <div class="buttons">
      <span class="button"><a href="${createLink(controller: 'admin', action: 'index')}">Menu</a></span>
      <span class="button"><g:link action="list">List Storage Mart Feeds</g:link></span>
      <span class="button"><g:link action="create">Create New Storage Mart Feed</g:link></span>
    </div>
    <div class="body">
      <h1>Show Storage Mart Feed</h1>
      <g:if test="${flash.message}">
        <div class="message">${flash.message}</div>
      </g:if>
      <div class="dialog">
        <table>
          <tbody>

          <tr class="prop">
            <td valign="top" class="name"><g:message code="storageMart.id.label" default="Id"/></td>

            <td valign="top" class="value">${fieldValue(bean: storageMartInstance, field: "id")}</td>

          </tr>

          <tr class="prop">
            <td valign="top" class="name"><g:message code="storageMart.operatorName.label" default="Operator Name"/></td>

            <td valign="top" class="value">${fieldValue(bean: storageMartInstance, field: "operatorName")}</td>

          </tr>

          <tr class="prop">
            <td valign="top" class="name"><g:message code="storageMart.stmUser.label" default="Storage Mart User Name"/></td>

            <td valign="top" class="value">${fieldValue(bean: storageMartInstance, field: "stmUser")}</td>

          </tr>

          <tr class="prop">
            <td valign="top" class="name"><g:message code="storageMart.stmPass.label" default="Storage Mart Pass Word"/></td>

            <td valign="top" class="value">${fieldValue(bean: storageMartInstance, field: "stmPass")}</td>

          </tr>

          <tr class="prop">
            <td valign="top" class="name"><g:message code="storageMart.url.label" default="Storage Mart URL"/></td>

            <td valign="top" class="value">${fieldValue(bean: storageMartInstance, field: "url")}</td>

          </tr>

          <tr class="prop">
            <td valign="top" class="name"><g:message code="storageSite.address.label" default="Address1"/></td>

            <td valign="top" class="value">${fieldValue(bean: storageMartInstance, field: "address1")}</td>

          </tr>

          <tr class="prop">
            <td valign="top" class="name"><g:message code="storageSite.address2.label" default="Address2"/></td>

            <td valign="top" class="value">${fieldValue(bean: storageMartInstance, field: "address2")}</td>

          </tr>

          <tr class="prop">
            <td valign="top" class="name"><g:message code="storageSite.city.label" default="City"/></td>

            <td valign="top" class="value">${fieldValue(bean: storageMartInstance, field: "city")}</td>

          </tr>

          <tr class="prop">
            <td valign="top" class="name"><g:message code="storageSite.state.label" default="State"/></td>

            <td valign="top" class="value">${storageMartInstance.state?.display}</td>

          </tr>

          <tr class="prop">
            <td valign="top" class="name"><g:message code="storageSite.zipcode.label" default="Zipcode"/></td>

            <td valign="top" class="value">${fieldValue(bean: storageMartInstance, field: "zipcode")}</td>

          </tr>

          <tr class="prop">
            <td valign="top" class="name"><g:message code="storageMart.manager.label" default="Manager"/></td>

            <td valign="top" class="value"><g:link controller="user" action="show" id="${storageMartInstance?.manager?.id}">${storageMartInstance?.manager?.username?.encodeAsHTML()}</g:link></td>

          </tr>

          <tr class="prop">
            <td valign="top" class="name"><g:message code="storageMart.reservationMoveInDescription" default="Reservation Move-In Description"/></td>

            <td valign="top" class="value">${fieldValue(bean: storageMartInstance, field: "reservationMoveInDescription")}</td>

          </tr>


          <tr class="prop">
            <td valign="top" class="name"><g:message code="storageMart.transactionBoxLink" default="Transaction Box Link"/></td>

            <td valign="top" class="value">${fieldValue(bean: storageMartInstance, field: "transactionBoxLink")}</td>

          </tr>

          <tr class="prop">
            <td valign="top" class="name"><g:message code="storageMart.transactionBoxBody" default="Transaction Box Body"/></td>

            <td valign="top" class="value">${fieldValue(bean: storageMartInstance, field: "transactionBoxBody")}</td>

          </tr>

          <tr class="prop">
            <td valign="top" class="name"><g:message code="storageMart.commissionSchedule.label" default="Commission Schedule"/></td>

            <td valign="top" class="value">${storageMartInstance.commissionSchedule?.scheduleName}</td>

          </tr>

          <tr class="prop">
            <td valign="top" class="name"><g:message code="storageMart.sites.label" default="Sites"/></td>

            <td valign="top" style="text-align: left;" class="value">
              <ul>
                <g:each in="${storageMartInstance.sites.sort{ it.title }}" var="s">
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
          <g:hiddenField name="id" value="${storageMartInstance?.id}"/>
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
          <span class="button"><g:link controller="feed" action="seoLinks" id="${storageMartInstance?.id}">SEO Links</g:link></span>
        </sec:ifAnyGranted>

      </div>
    </div>
  </div>
</div>
</body>
</html>
