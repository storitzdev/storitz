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
<g:render template="/topnav"/>
<div id="stcontent">
  <div class="nav">
    <span class="menuButton"><a class="home" href="${createLink(controller:'admin', action:'index')}">Admin</a></span>
    <span class="menuButton"><g:link class="list" action="list">List Storage Sites</g:link></span>
    <span class="menuButton"><g:link class="create" action="create">Create New Storage Site</g:link></span>
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
          <td valign="top" class="name"><g:message code="storageSite.title.label" default="Title"/></td>

          <td valign="top" class="value">${fieldValue(bean: storageSiteInstance, field: "title")}</td>

        </tr>

        <tr class="prop">
          <td valign="top" class="name"><g:message code="storageSite.description.label" default="Description"/></td>

          <td valign="top" class="value">${fieldValue(bean: storageSiteInstance, field: "description")}</td>

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
          <td valign="top" class="name"><g:message code="storageSite.users.label" default="Users"/></td>

          <td valign="top" style="text-align: left;" class="value">
            <ul>
              <g:each in="${storageSiteInstance.users}" var="u">
                <li><g:link controller="siteUser" action="show" id="${u.id}">${u?.encodeAsHTML()}</g:link></li>
              </g:each>
            </ul>
          </td>

        </tr>

        <tr class="prop">
          <td valign="top" class="name"><g:message code="storageSite.contacts.label" default="Contacts"/></td>

          <td valign="top" style="text-align: left;" class="value">
            <ul>
              <g:each in="${storageSiteInstance.contacts}" var="c">
                <li><g:link controller="siteContact" action="show" id="${c.id}">${c.name} - ${c.email}</g:link></li>
              </g:each>
            </ul>
          </td>

        </tr>

        <tr class="prop">
          <td valign="top" class="name"><g:message code="storageSite.specialOffers.label" default="Special Offers"/></td>

          <td valign="top" style="text-align: left;" class="value">
            <ul>
              <g:each in="${storageSiteInstance.specialOffers}" var="s">
                <li><g:link controller="specialOffer" action="show" id="${s.id}">${s?.description}</g:link></li>
              </g:each>
            </ul>
          </td>

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

          <td valign="top" class="value"><g:formatBoolean boolean="${storageSiteInstance?.freeTruck}"/></td>

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
          <td valign="top" class="name"><g:message code="storageSite.isCamera.label" default="Is Camera"/></td>

          <td valign="top" class="value"><g:formatBoolean boolean="${storageSiteInstance?.isCamera}"/></td>

        </tr>

        <tr class="prop">
          <td colspan="2" valign="top"><h3>Images</h3></td>

        </tr>

        <tr class="prop">
          <td valign="top" class="name">Images</td>

          <td valign="top" style="text-align: left;" class="value">
            <ul>
              <g:each in="${storageSiteInstance.images}" var="i">
                <li><img src="${resource(dir:'images', file: i.thumbnail)}" alt="image${i.id}"/></li>
              </g:each>
            </ul>
          </td>

        </tr>
        </tbody>
      </table>
    </div>
    <div class="buttons">
      <g:form>
        <g:hiddenField name="id" value="${storageSiteInstance?.id}"/>
        <span class="button"><g:actionSubmit class="edit" action="edit" value="${message(code: 'default.button.edit.label', default: 'Edit')}"/></span>
        <span class="button"><g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');"/></span>
      </g:form>
    </div>
  </div>
</div>
</body>
</html>
