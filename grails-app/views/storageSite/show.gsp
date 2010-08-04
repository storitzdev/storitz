<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN"
    "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head>
  <g:set var="title" value="Create Storage Site"/>
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
  <g:render template="/logo_bar" />

  <div style="clear: both;height: 10px"></div>
  <div class="buttons">
    <span class="button"><a href="${createLink(controller:'admin', action:'index')}">Menu</a></span>
    <span class="button"><g:link action="list">List Storage Sites</g:link></span>
    %{--<span class="menuButton"><g:link class="report" action="report" id="${storageSiteInstance.id}">Storage Site Report</g:link></span>--}%
    <sec:ifAnyGranted roles="ROLE_ADMIN">
      <span class="button"><g:link action="create">Create New Storage Site</g:link></span>
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

          <td valign="top" class="value">${fieldValue(bean: storageSiteInstance, field: "state")}</td>

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
            <ul>
              <g:each in="${storageSiteInstance.contacts}" var="c">
                <li>${c.name} - ${c.email}</li>
              </g:each>
            </ul>
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
          <td colspan="2" valign="top"><h3>Hours of Operation</h3></td>

        </tr>

        <tr class="prop">
          <td valign="top" class="name"><g:message code="storageSiteInstance.openWeekday.label" default="Weekdays"/></td>

          <td valign="top" class="value">${storageSiteInstance.openWeekday ? "Open" : "Closed"}
            <g:if test="${storageSiteInstance.openWeekday}">
              Start: <g:formatDate date="${storageSiteInstance.startWeekday}" format="h:mma" /> End: <g:formatDate date="${storageSiteInstance.endWeekday}" format="h:mma" />
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
          <td valign="top" class="name"><g:message code="storageSiteInstance.gateHours.label" default="Gate Hours"/></td>

          <td valign="top" class="value">
              Start: <g:formatDate date="${storageSiteInstance.startGate}" format="h:mma" /> End: <g:formatDate date="${storageSiteInstance.endGate}" format="h:mma" />
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

          <td valign="top" class="value">${storageSiteInstance?.freeTruck}</td>

        </tr>

        <tr class="prop">
          <td valign="top" class="name"><g:message code="storageSite.requiresInsurance.label" default="Requires Insurance"/></td>

          <td valign="top" class="value"><g:formatBoolean boolean="${storageSiteInstance?.requiresInsurance}"/></td>

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
              <a href="${resource(file:storageSiteInstance?.rentalAgreement.src())}" target="_blank"><img src="${resource(dir:'images', file:'icn_pdf.jpg')}" alt="PDF"></a>
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
                    <li><img src="${resource(file:i.thumbnail())}" alt="image ${i}"/></li>
                  </g:if>
              </g:each>
            </ul>
          </td>

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
        <span class="button"><a href="${createLink(action:"detail", params:[id:storageSiteInstance?.id])}" target="_blank">User View</a></span>
      </g:form>
    </div>
  </div>
</div>
</div>
</body>
</html>
