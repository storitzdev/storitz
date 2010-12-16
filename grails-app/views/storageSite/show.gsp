<%@ page import="com.storitz.UserNotificationType" %>



<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head>
  <g:set var="title" value="Show Storage Site" scope="request"/>
  <g:render template="/header_admin"/>

</head>
<body>
<div id="body">
<g:render template="/topnav"/>
<div class="stcontent">
  <g:render template="/logo_bar" />

  <div style="clear: both;height: 10px"></div>
  <div class="buttons">
    <span class="button"><a href="${createLink(controller:'admin', action:'index')}">Menu</a></span>
    <span class="button"><g:link action="list">List Storage Sites</g:link></span>
    <sec:ifAnyGranted roles="ROLE_ADMIN">
      <span class="button"><g:link action="create">Create New Storage Site</g:link></span>
    </sec:ifAnyGranted>
  </div>
  <div class="body">

    <div class="price_options checkout_header white">
      Storage Site Details
    </div>
    
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
          <td valign="top" class="name"><g:message code="storageSite.security.label" default="Security Items"/></td>

          <td valign="top" style="text-align: left;" class="value">
            <ul>
              <g:each in="${storageSiteInstance.securityItems.sort{ it.id }}" var="c">
                <li>${c.bullet}</li>
              </g:each>
            </ul>
          </td>

        </tr>

        <tr class="prop">
          <td valign="top" class="name"><g:message code="storageSite.convenience.label" default="Convenience Items"/></td>

          <td valign="top" style="text-align: left;" class="value">
            <ul>
              <g:each in="${storageSiteInstance.convenienceItems.sort{ it.id }}" var="c">
                <li>${c.bullet}</li>
              </g:each>
            </ul>
          </td>

        </tr>

        <tr class="prop">
          <td valign="top" class="name"><g:message code="storageSite.amenity.label" default="Amenity Items"/></td>

          <td valign="top" style="text-align: left;" class="value">
            <ul>
              <g:each in="${storageSiteInstance.amenityItems.sort{ it.id }}" var="c">
                <li>${c.bullet}</li>
              </g:each>
            </ul>
          </td>

        </tr>

        <tr class="prop">
          <td valign="top" class="name"><g:message code="storageSite.description.label" default="Description"/></td>

          <td valign="top" class="value">${fieldValue(bean: storageSiteInstance, field: "description").decodeHTML()}</td>

        </tr>

        <tr class="prop">
          <td valign="top" class="name"><g:message code="storageSite.address.label" default="Address"/></td>

          <td valign="top" class="value">${fieldValue(bean: storageSiteInstance, field: "address")}</td>

        </tr>

        <tr class="prop">
          <td valign="top" class="name"><g:message code="storageSite.address2.label" default="Address2"/></td>

          <td valign="top" class="value">${fieldValue(bean: storageSiteInstance, field: "address2")}</td>

        </tr>

        <tr class="prop">
          <td valign="top" class="name"><g:message code="storageSite.city.label" default="City"/></td>

          <td valign="top" class="value">${fieldValue(bean: storageSiteInstance, field: "city")}</td>

        </tr>

        <tr class="prop">
          <td valign="top" class="name"><g:message code="storageSite.state.label" default="State"/></td>

          <td valign="top" class="value">${storageSiteInstance.state.display}</td>

        </tr>

        <tr class="prop">
          <td valign="top" class="name"><g:message code="storageSite.zipcode.label" default="Zipcode"/></td>

          <td valign="top" class="value">${fieldValue(bean: storageSiteInstance, field: "zipcode")}</td>

        </tr>

        <tr class="prop">
          <td valign="top" class="name"><g:message code="storageSite.phone.label" default="Phone"/></td>

          <td valign="top" class="value">${fieldValue(bean: storageSiteInstance, field: "phone")}</td>

        </tr>

        <tr class="prop">
          <td valign="top" class="name"><g:message code="storageSite.url.label" default="Url"/></td>

          <td valign="top" class="value">${fieldValue(bean: storageSiteInstance, field: "url")}</td>

        </tr>

        <tr class="prop">
          <td valign="top" class="name"><g:message code="storageSite.contacts.label" default="Contacts"/></td>

          <td valign="top" style="text-align: left;" class="value">
            <table>
              <tr>
                <th>Login</th>
                <th>Name</th>
                <th>Email</th>
                <th>Operational Manager</th>
                <th>District Manager</th>
                <th>Site Manager</th>
                <th>Accounting</th>
              </tr>
              <g:each var="contact" in="${contacts}">
                <tr>
                  <sec:ifAnyGranted roles="ROLE_ADMIN,ROLE_MANAGER">
                    <td>
                      <g:link controller="user" action="edit" id="${contact.id}">${contact.username}</g:link>
                    </td>
                  </sec:ifAnyGranted>
                  <sec:ifNotGranted roles="ROLE_ADMIN,ROLE_MANAGER">
                    <td>${contact.username}</td>
                  </sec:ifNotGranted>
                  <td>${contact.userRealName}</td>
                  <td>${contact.email}</td>
                  <td>${UserNotificationType.userHasNotificationType(contact, 'NOTIFICATION_OPERATIONS_MANAGER')? 'X' : '&nbsp;'}</td>
                  <td>${UserNotificationType.userHasNotificationType(contact, 'NOTIFICATION_DISTRICT_MANAGER')? 'X' : '&nbsp;'}</td>
                  <td>${UserNotificationType.userHasNotificationType(contact, 'NOTIFICATION_SITE_MANAGER')? 'X' : '&nbsp;'}</td>
                  <td>${UserNotificationType.userHasNotificationType(contact, 'NOTIFICATION_ACCOUNTING')? 'X' : '&nbsp;'}</td>
                </tr>
              </g:each>
            </table>
          </td>

        </tr>

        <tr class="prop">
          <td valign="top" class="name"><g:message code="storageSite.specialOffers.label" default="Special Offers"/></td>

          <td valign="top" style="text-align: left;" class="value">
            <table>
              <tr>
                <th>Active</th>
                <th>Featured</th>
                <th>Waive Admin</th>
                <th>Promo Name</th>
                <th>Description</th>
              </tr>
              <g:each in="${storageSiteInstance.specialOffers}" var="s">
                <tr>
                  <td>${s.active ? 'X' : '&nbsp;'}</td>
                  <td>${s.featured ? 'X' : '&nbsp;'}</td>
                  <td>${s.waiveAdmin ? 'X' : '&nbsp;'}</td>
                  <td>${s?.promoName}</td>
                  <td>${s?.description}</td>
                </tr>
              </g:each>
            </table>
          </td>

        </tr>

        <tr class="prop">
          <td valign="top" class="name"><g:message code="storageSite.insurances.label" default="Property Protection"/></td>

          <td valign="top" style="text-align: left;" class="value">
            <table>
              <tr>
                <th>Active</th>
                <th>Description</th>
              </tr>
              <g:each in="${storageSiteInstance.insurances.sort{it.id}}" var="ins">
                <tr>
                  <td>${ins.active ? 'X' : '&nbsp;'}</td>
                  <td><g:formatNumber number="${ins.premium}" type="currency" currencyCode="USD" />/mo. Coverage: <g:formatNumber number="${ins.totalCoverage}" type="currency" currencyCode="USD" /> Theft: <g:formatNumber number="${ins.percentTheft}" type="percent" /></td>
                </tr>
              </g:each>
            </table>
          </td>

        </tr>

        <tr class="prop">
          <td colspan="2" valign="top"><h3>Hours of Operation</h3></td>

        </tr>

        <tr class="prop">
          <td valign="top" class="name"><g:message code="storageSiteInstance.openMonday.label" default="Mondays"/></td>

          <td valign="top" class="value">${storageSiteInstance.openMonday ? "Open" : "Closed"}
            <g:if test="${storageSiteInstance.openMonday}">
              Start: <g:formatDate date="${storageSiteInstance.startMonday}" format="h:mma" /> End: <g:formatDate date="${storageSiteInstance.endMonday}" format="h:mma" />
            </g:if>
          </td>

        </tr>

        <tr class="prop">
          <td valign="top" class="name"><g:message code="storageSiteInstance.openTuesday.label" default="Tuesdays"/></td>

          <td valign="top" class="value">${storageSiteInstance.openTuesday ? "Open" : "Closed"}
            <g:if test="${storageSiteInstance.openTuesday}">
              Start: <g:formatDate date="${storageSiteInstance.startTuesday}" format="h:mma" /> End: <g:formatDate date="${storageSiteInstance.endTuesday}" format="h:mma" />
            </g:if>
          </td>

        </tr>
        <tr class="prop">
          <td valign="top" class="name"><g:message code="storageSiteInstance.openWednesday.label" default="Wednesdays"/></td>

          <td valign="top" class="value">${storageSiteInstance.openWednesday ? "Open" : "Closed"}
            <g:if test="${storageSiteInstance.openWednesday}">
              Start: <g:formatDate date="${storageSiteInstance.startWednesday}" format="h:mma" /> End: <g:formatDate date="${storageSiteInstance.endWednesday}" format="h:mma" />
            </g:if>
          </td>

        </tr>
        <tr class="prop">
          <td valign="top" class="name"><g:message code="storageSiteInstance.openThursday.label" default="Thursdays"/></td>

          <td valign="top" class="value">${storageSiteInstance.openThursday ? "Open" : "Closed"}
            <g:if test="${storageSiteInstance.openThursday}">
              Start: <g:formatDate date="${storageSiteInstance.startThursday}" format="h:mma" /> End: <g:formatDate date="${storageSiteInstance.endThursday}" format="h:mma" />
            </g:if>
          </td>

        </tr>
        <tr class="prop">
          <td valign="top" class="name"><g:message code="storageSiteInstance.openFriday.label" default="Fridays"/></td>

          <td valign="top" class="value">${storageSiteInstance.openFriday ? "Open" : "Closed"}
            <g:if test="${storageSiteInstance.openFriday}">
              Start: <g:formatDate date="${storageSiteInstance.startFriday}" format="h:mma" /> End: <g:formatDate date="${storageSiteInstance.endFriday}" format="h:mma" />
            </g:if>
          </td>

        </tr>
        <tr class="prop">
          <td valign="top" class="name"><g:message code="storageSiteInstance.openSaturday.label" default="Saturday"/></td>

          <td valign="top" class="value">${storageSiteInstance.openSaturday ? "Open" : "Closed"}
            <g:if test="${storageSiteInstance.openSaturday}">
              Start: <g:formatDate date="${storageSiteInstance.startSaturday}" format="h:mma" /> End: <g:formatDate date="${storageSiteInstance.endSaturday}" format="h:mma" />
            </g:if>
          </td>

        </tr>

        <tr class="prop">
          <td valign="top" class="name"><g:message code="storageSiteInstance.openSunday.label" default="Sunday"/></td>

          <td valign="top" class="value">${storageSiteInstance.openSunday ? "Open" : "Closed"}
            <g:if test="${storageSiteInstance.openSunday}">
              Start: <g:formatDate date="${storageSiteInstance.startSunday}" format="h:mma" /> End: <g:formatDate date="${storageSiteInstance.endSunday}" format="h:mma" />
            </g:if>
          </td>

        </tr>

        <tr class="prop">
          <td valign="top" class="name"><g:message code="storageSiteInstance.gateHours.label" default="Monday Gate Hours"/></td>

          <td valign="top" class="value">
              Start: <g:formatDate date="${storageSiteInstance.startMondayGate}" format="h:mma" /> End: <g:formatDate date="${storageSiteInstance.endMondayGate}" format="h:mma" />
          </td>

        </tr>

        <tr class="prop">
          <td valign="top" class="name"><g:message code="storageSiteInstance.gateHours.label" default="Tuesday Gate Hours"/></td>

          <td valign="top" class="value">
              Start: <g:formatDate date="${storageSiteInstance.startTuesdayGate}" format="h:mma" /> End: <g:formatDate date="${storageSiteInstance.endTuesdayGate}" format="h:mma" />
          </td>

        </tr>

        <tr class="prop">
          <td valign="top" class="name"><g:message code="storageSiteInstance.gateHours.label" default="Wednesday Gate Hours"/></td>

          <td valign="top" class="value">
              Start: <g:formatDate date="${storageSiteInstance.startWednesdayGate}" format="h:mma" /> End: <g:formatDate date="${storageSiteInstance.endWednesdayGate}" format="h:mma" />
          </td>

        </tr>

        <tr class="prop">
          <td valign="top" class="name"><g:message code="storageSiteInstance.gateHours.label" default="Thursday Gate Hours"/></td>

          <td valign="top" class="value">
              Start: <g:formatDate date="${storageSiteInstance.startThursdayGate}" format="h:mma" /> End: <g:formatDate date="${storageSiteInstance.endThursdayGate}" format="h:mma" />
          </td>

        </tr>

        <tr class="prop">
          <td valign="top" class="name"><g:message code="storageSiteInstance.gateHours.label" default="Friday Gate Hours"/></td>

          <td valign="top" class="value">
              Start: <g:formatDate date="${storageSiteInstance.startFridayGate}" format="h:mma" /> End: <g:formatDate date="${storageSiteInstance.endFridayGate}" format="h:mma" />
          </td>

        </tr>

        <tr class="prop">
          <td valign="top" class="name"><g:message code="storageSiteInstance.gateHours.label" default="Saturday Gate Hours"/></td>

          <td valign="top" class="value">
              Start: <g:formatDate date="${storageSiteInstance.startSaturdayGate}" format="h:mma" /> End: <g:formatDate date="${storageSiteInstance.endSaturdayGate}" format="h:mma" />
          </td>

        </tr>

        <tr class="prop">
          <td valign="top" class="name"><g:message code="storageSiteInstance.sundayGateHours.label" default="Sunday Gate Hours"/></td>

          <td valign="top" class="value">
              Start: <g:formatDate date="${storageSiteInstance.startSundayGate}" format="h:mma" /> End: <g:formatDate date="${storageSiteInstance.endSundayGate}" format="h:mma" />
          </td>

        </tr>

        <tr class="prop">
          <td valign="top" class="name"><g:message code="storageSiteInstance.extendedHours.label" default="Extended Hours"/></td>

          <td valign="top" class="value">
            ${storageSiteInstance.extendedHours ? "Available" : "Unavailable"}
          </td>

        </tr>

        <tr class="prop">
          <td colspan="2" valign="top"><h3>Fees</h3></td>

        </tr>

        <tr class="prop">
          <td valign="top" class="name"><g:message code="storageSite.lockFee.label" default="Lock Fee"/></td>

          <td valign="top" class="value"><g:formatNumber number="${storageSiteInstance.lockFee}" type="currency" currencyCode="USD" /></td>

        </tr>

        <tr class="prop">
          <td valign="top" class="name"><g:message code="storageSite.adminFee.label" default="Admin Fee"/></td>

          <td valign="top" class="value"><g:formatNumber number="${storageSiteInstance.adminFee}" type="currency" currencyCode="USD" /></td>

        </tr>

        <tr class="prop">
          <td colspan="2" valign="top"><h3>Attributes</h3></td>

        </tr>

        <tr class="prop">
          <td valign="top" class="name"><g:message code="storageSite.boxesAvailable.label" default="Boxes Available"/></td>

          <td valign="top" class="value"><g:formatBoolean boolean="${storageSiteInstance?.boxesAvailable}"/></td>

        </tr>

        <tr class="prop">
          <td valign="top" class="name"><g:message code="storageSite.freeTruck.label" default="Free Truck"/></td>

          <td valign="top" class="value">${storageSiteInstance?.freeTruck?.display}</td>

        </tr>

        <tr class="prop">
          <td valign="top" class="name"><g:message code="storageSite.requiresInsurance.label" default="Requires Insurance"/></td>

          <td valign="top" class="value"><g:formatBoolean boolean="${storageSiteInstance?.requiresInsurance}"/></td>

        </tr>

        <tr class="prop">
          <td valign="top" class="name"><g:message code="storageSite.noInsuranceWaiver.label" default="Must buy insurance with rental"/></td>

          <td valign="top" class="value"><g:formatBoolean boolean="${storageSiteInstance?.noInsuranceWaiver}"/></td>

        </tr>

        <tr class="prop">
          <td valign="top" class="name"><g:message code="storageSite.isGate.label" default="Is Gate"/></td>

          <td valign="top" class="value"><g:formatBoolean boolean="${storageSiteInstance?.isGate}"/></td>

        </tr>

        <tr class="prop">
          <td valign="top" class="name"><g:message code="storageSite.isKeypad.label" default="Is Keypad"/></td>

          <td valign="top" class="value"><g:formatBoolean boolean="${storageSiteInstance?.isKeypad}"/></td>

        </tr>

        <tr class="prop">
          <td valign="top" class="name"><g:message code="storageSite.isUnitAlarmed.label" default="Is Unit Alarmed"/></td>

          <td valign="top" class="value"><g:formatBoolean boolean="${storageSiteInstance?.isUnitAlarmed}"/></td>

        </tr>

        <tr class="prop">
          <td valign="top" class="name"><g:message code="storageSite.isManagerOnsite.label" default="Is Manager Onsite"/></td>

          <td valign="top" class="value"><g:formatBoolean boolean="${storageSiteInstance?.isManagerOnsite}"/></td>

        </tr>

        <tr class="prop">
          <td valign="top" class="name"><g:message code="storageSite.hasElevator.label" default="Elevator Available"/></td>

          <td valign="top" class="value"><g:formatBoolean boolean="${storageSiteInstance?.hasElevator}"/></td>

        </tr>

        <tr class="prop">
          <td valign="top" class="name"><g:message code="storageSite.isCamera.label" default="Is Camera"/></td>

          <td valign="top" class="value"><g:formatBoolean boolean="${storageSiteInstance?.isCamera}"/></td>

        </tr>

        <g:if test="${storageSiteInstance?.rentalAgreement}">
          <tr class="prop">
            <td colspan="2" valign="top"><h3>Rental/Lease Agreement</h3></td>

          </tr>

          <tr class="prop">
            <td valign="top" class="name">${storageSiteInstance?.rentalAgreement?.title}</td>

            <td valign="top" style="text-align: left;" class="value">
              <a href="${resource(file:storageSiteInstance?.rentalAgreement.src())}" onclick="window.open(this.href,'_blank');return false;"><storitz:image src="icn_pdf.jpg" width="36" height="36" alt="PDF"/></a>
            </td>

          </tr>
        </g:if>

        <tr class="prop">
          <td colspan="2" valign="top"><h3>Images</h3></td>

        </tr>

        <tr class="prop">
          <td valign="top" class="name">Images</td>

          <td valign="top" style="text-align: left;" class="value">
            <ul>
              <g:each in="${storageSiteInstance?.images}" var="i">
                  <g:if test="${!i.isLogo}">
                    <sec:ifAnyGranted roles="ROLE_ADMIN">
                      <li><img src="${resource(file:i.thumbnail())}" alt="image ${i}"/> Caption: ${i.caption}, Tags: ${i.tags}</li>
                    </sec:ifAnyGranted>
                    <sec:ifNotGranted roles="ROLE_ADMIN">
                      <li><img src="${resource(file:i.thumbnail())}" alt="image ${i}"/></li>
                    </sec:ifNotGranted>
                  </g:if>
              </g:each>
            </ul>
          </td>

        </tr>

        <tr class="prop">
          <td colspan="2" valign="top"><h3>Rentable Units</h3></td>

        </tr>

        <tr class="prop">
          <td valign="top" class="name"><g:message code="storageSite.rentable.units.label" default="Rentable Units"/></td>

          <td valign="top" style="text-align: left;" class="value">
            <span>${storageSiteInstance.rentableUnits()}</span>
          </td>
        </tr>

        <tr class="prop">
          <td colspan="2" valign="top"><h3>Visit Information</h3></td>

        </tr>

        <tr class="prop">
          <td valign="top" class="name"><g:message code="storageSite.visits.label" default="Visit Count"/></td>

          <td valign="top" style="text-align: left;" class="value">
            <span>${visitCount}</span>
          </td>
        </tr>

        </tbody>
      </table>
    </div>
    <div class="buttons">
      <g:form>
        <g:hiddenField name="id" value="${storageSiteInstance?.id}"/>
        <span class="button"><g:actionSubmit action="edit" value="${message(code: 'default.button.edit.label', default: 'Edit')}"/></span>
        <span class="button"><g:actionSubmit action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');"/></span>
        <span class="button"><g:actionSubmit action="refresh" value="${message(code: 'default.button.refresh.label', default: 'Refresh Storage Site from Feed')}" /></span>
        <span class="button"><g:actionSubmit action="units" value="${message(code: 'default.button.refresh.label', default: 'Reload Available Units')}" /></span>
        <span class="button"><g:actionSubmit action="report" value="${message(code: 'default.button.report.label', default: 'Activity Report')}" /></span>
        <span class="button"><a href="${createLink(action:"detail", params:[id:storageSiteInstance?.id, adminView:true])}" onclick="window.open(this.href,'_blank');return false;">User View</a></span>
      </g:form>
    </div>
  </div>
</div>
</div>
</body>
<p:renderDependantJavascript />
</html>
