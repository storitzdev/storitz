<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head>
  <g:set var="title" value="Show EDomico Feed" scope="request"/>
  <g:render template="/header"/>

  <script type="text/javascript">
    //<![CDATA[
    //]]>
  </script>

</head>
<body>
<div id="body">

  <div class="stcontent">
    <g:render template="/logo_bar"/>
    <div class="buttons">
      <span class="button"><a href="${createLink(controller: 'admin', action: 'index')}">Menu</a></span>
      <span class="button"><g:link action="list">List EDomico Feeds</g:link></span>
      <span class="button"><g:link action="create">Create New EDomico Feed</g:link></span>
    </div>
    <div class="body">
      <h1>Show EDomico Feed</h1>
      <g:if test="${flash.message}">
        <div class="message">${flash.message}</div>
      </g:if>
      <div class="dialog">
        <table>
          <tbody>

          <tr class="prop">
            <td valign="top" class="name"><g:message code="edomico.id.label" default="Id"/></td>

            <td valign="top" class="value">${fieldValue(bean: edomicoInstance, field: "id")}</td>

          </tr>


          <tr class="prop">
            <td valign="top" class="name"><g:message code="edomico.edomicoClientID.label" default="Client ID"/></td>

            <td valign="top" class="value">${fieldValue(bean: edomicoInstance, field: "edomicoClientID")}</td>

          </tr>

          <tr class="prop">
            <td valign="top" class="name"><g:message code="edomico.edomicoWebServicesKey.label" default="Web Services Key"/></td>

            <td valign="top" class="value">${fieldValue(bean: edomicoInstance, field: "edomicoWebServicesKey")}</td>

          </tr>

          <tr class="prop">
            <td valign="top" class="name"><g:message code="edomico.operatorName.label" default="Operator Name"/></td>

            <td valign="top" class="value">${fieldValue(bean: edomicoInstance, field: "operatorName")}</td>

          </tr>

          <tr class="prop">
            <td valign="top" class="name"><g:message code="storageSite.address.label" default="Address1"/></td>

            <td valign="top" class="value">${fieldValue(bean: edomicoInstance, field: "address1")}</td>

          </tr>

          <tr class="prop">
            <td valign="top" class="name"><g:message code="storageSite.address2.label" default="Address2"/></td>

            <td valign="top" class="value">${fieldValue(bean: edomicoInstance, field: "address2")}</td>

          </tr>

          <tr class="prop">
            <td valign="top" class="name"><g:message code="storageSite.city.label" default="City"/></td>

            <td valign="top" class="value">${fieldValue(bean: edomicoInstance, field: "city")}</td>

          </tr>

          <tr class="prop">
            <td valign="top" class="name"><g:message code="storageSite.state.label" default="State"/></td>

            <td valign="top" class="value">${fieldValue(bean: edomicoInstance, field: "state")}</td>

          </tr>


         <tr class="prop">
            <td valign="top" class="name"><g:message code="storageSite.zipcode.label" default="Zipcode"/></td>

            <td valign="top" class="value">${fieldValue(bean: edomicoInstance, field: "zipcode")}</td>

          </tr>

          <tr class="prop">
            <td valign="top" class="name"><g:message code="edomico.manager.label" default="Manager"/></td>

            <td valign="top" class="value"><g:link controller="user" action="show" id="${edomicoInstance.manager?.id}">${edomicoInstance.manager?.username?.encodeAsHTML()}</g:link></td>

          </tr>

           <tr class="prop">
             <td valign="top" class="name"><g:message code="edomico.reservationMoveInDescription" default="Reservation Move-In Description"/></td>

             <td valign="top" class="value">${fieldValue(bean: edomicoInstance, field: "reservationMoveInDescription")}&nbsp;</td>

           </tr>


         <tr class="prop">
            <td valign="top" class="name"><g:message code="edomico.transactionBoxLink" default="Transaction Box Link"/></td>

            <td valign="top" class="value">${fieldValue(bean: edomicoInstance, field: "transactionBoxLink")}&nbsp;</td>

          </tr>

          <tr class="prop">
            <td valign="top" class="name"><g:message code="edomico.transactionBoxBody" default="Transaction Box Body"/></td>

            <td valign="top" class="value">${fieldValue(bean: edomicoInstance, field: "transactionBoxBody")}&nbsp;</td>

          </tr>


          <tr class="prop">
            <td valign="top" class="name"><g:message code="edomico.commissionSchedule.label" default="Commission Schedule"/></td>

            <td valign="top" class="value">${edomicoInstance.commissionSchedule?.scheduleName}</td>

          </tr>



          <tr class="prop">
            <td valign="top" class="name"><g:message code="quikStor.sites.label" default="Sites"/></td>

            <td valign="top" style="text-align: left;" class="value">
              <table>
                <thead>
                <tr>
                  <th>Site ID</th>
                  <th>Site Name</th>
                  <th>Address1</th>
                  <th>City</th>
                  <th>State</th>
                  <th>Zip</th>
               </tr>
                </thead>
                <tbody>
                <g:each in="${edomicoInstance.locations.sort{ it.siteID }}" var="s">
                  <tr>
                    <td>${s.siteID}</td>
                    <td>${s.siteName}</td>
                    <td>${s.address1}</td>
                    <td>${s.city}</td>
                    <td>${s.state}</td>
                    <td>${s.zipcode}</td>
                  </tr>
                </g:each>
                </tbody>
              </table>
            </td>
          </tr>





          <tr class="prop">
            <td valign="top" class="name"><g:message code="edomico.sites.label" default="Sites"/></td>

            <td valign="top" style="text-align: left;" class="value">
              <ul>
                <g:each in="${edomicoInstance.sites.sort{ it.title }}" var="s">
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
          <g:hiddenField name="id" value="${edomicoInstance.id}"/>
          <span class="button"><g:actionSubmit action="edit" value="${message(code: 'default.button.edit.label', default: 'Edit')}"/></span>
          <span class="button"><g:actionSubmit action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');"/></span>
          <span class="button"><g:actionSubmit action="refresh" value="${message(code: 'default.button.refresh.label', default: 'Refresh Sites, Units, and Promotions')}"/></span>
          <!--
          <span class="button"><g:actionSubmit action="updateInventory" value="${message(code: 'default.button.refresh.promos.label', default: 'Update Inventory')}"/></span>
          <span class="button"><g:actionSubmit action="refreshPromos" value="${message(code: 'default.button.refresh.promos.label', default: 'Refresh Promos')}"/></span>
          <span class="button"><g:actionSubmit action="refreshInsurance" value="${message(code: 'default.button.refresh.insurance.label', default: 'Refresh Insurance')}"/></span>
          <span class="button"><g:actionSubmit action="createContacts" value="${message(code: 'default.button.create.contacts.label', default: 'Create Contacts')}"/></span>
          <span class="button"><g:actionSubmit action="refreshPhones" value="${message(code: 'default.button.refresh.phones.label', default: 'Refresh Phones')}"/></span>
          -->
        </g:form>
        <sec:ifAnyGranted roles="ROLE_ADMIN">
          <span class="button"><g:link controller="feed" action="seoLinks" id="${edomicoInstance.id}">SEO Links</g:link></span>
        </sec:ifAnyGranted>
      </div>
    </div>
  </div>
</div>
</body>
<p:renderDependantJavascript/>
</html>
