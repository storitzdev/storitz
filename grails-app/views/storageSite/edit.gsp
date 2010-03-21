

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'storageSite.label', default: 'StorageSite')}" />
        <title><g:message code="default.edit.label" args="[entityName]" /></title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLink(uri: '/')}">Home</a></span>
            <span class="menuButton"><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></span>
            <span class="menuButton"><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></span>
        </div>
        <div class="body">
            <h1><g:message code="default.edit.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${storageSiteInstance}">
            <div class="errors">
                <g:renderErrors bean="${storageSiteInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form method="post" >
                <g:hiddenField name="id" value="${storageSiteInstance?.id}" />
                <g:hiddenField name="version" value="${storageSiteInstance?.version}" />
                <div class="dialog">
                    <table>
                        <tbody>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="description"><g:message code="storageSite.description.label" default="Description" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: storageSiteInstance, field: 'description', 'errors')}">
                                    <g:textArea name="description" cols="40" rows="5" value="${storageSiteInstance?.description}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="logoUrl"><g:message code="storageSite.logoUrl.label" default="Logo Url" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: storageSiteInstance, field: 'logoUrl', 'errors')}">
                                    <g:textField name="logoUrl" value="${storageSiteInstance?.logoUrl}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="zipcode"><g:message code="storageSite.zipcode.label" default="Zipcode" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: storageSiteInstance, field: 'zipcode', 'errors')}">
                                    <g:textField name="zipcode" value="${storageSiteInstance?.zipcode}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="phone"><g:message code="storageSite.phone.label" default="Phone" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: storageSiteInstance, field: 'phone', 'errors')}">
                                    <g:textField name="phone" value="${storageSiteInstance?.phone}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="url"><g:message code="storageSite.url.label" default="Url" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: storageSiteInstance, field: 'url', 'errors')}">
                                    <g:textField name="url" value="${storageSiteInstance?.url}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="source"><g:message code="storageSite.source.label" default="Source" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: storageSiteInstance, field: 'source', 'errors')}">
                                    <g:textField name="source" value="${storageSiteInstance?.source}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="sourceId"><g:message code="storageSite.sourceId.label" default="Source Id" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: storageSiteInstance, field: 'sourceId', 'errors')}">
                                    <g:textField name="sourceId" value="${storageSiteInstance?.sourceId}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="sourceLoc"><g:message code="storageSite.sourceLoc.label" default="Source Loc" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: storageSiteInstance, field: 'sourceLoc', 'errors')}">
                                    <g:textField name="sourceLoc" value="${storageSiteInstance?.sourceLoc}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="address2"><g:message code="storageSite.address2.label" default="Address2" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: storageSiteInstance, field: 'address2', 'errors')}">
                                    <g:textField name="address2" value="${storageSiteInstance?.address2}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="users"><g:message code="storageSite.users.label" default="Users" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: storageSiteInstance, field: 'users', 'errors')}">
                                    
<ul>
<g:each in="${storageSiteInstance?.users?}" var="u">
    <li><g:link controller="siteUser" action="show" id="${u.id}">${u?.encodeAsHTML()}</g:link></li>
</g:each>
</ul>
<g:link controller="siteUser" action="create" params="['storageSite.id': storageSiteInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'siteUser.label', default: 'SiteUser')])}</g:link>

                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="isGate"><g:message code="storageSite.isGate.label" default="Is Gate" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: storageSiteInstance, field: 'isGate', 'errors')}">
                                    <g:checkBox name="isGate" value="${storageSiteInstance?.isGate}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="boxesAvailable"><g:message code="storageSite.boxesAvailable.label" default="Boxes Available" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: storageSiteInstance, field: 'boxesAvailable', 'errors')}">
                                    <g:checkBox name="boxesAvailable" value="${storageSiteInstance?.boxesAvailable}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="state"><g:message code="storageSite.state.label" default="State" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: storageSiteInstance, field: 'state', 'errors')}">
                                    <g:textField name="state" value="${storageSiteInstance?.state}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="lng"><g:message code="storageSite.lng.label" default="Lng" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: storageSiteInstance, field: 'lng', 'errors')}">
                                    <g:textField name="lng" value="${fieldValue(bean: storageSiteInstance, field: 'lng')}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="freeTruck"><g:message code="storageSite.freeTruck.label" default="Free Truck" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: storageSiteInstance, field: 'freeTruck', 'errors')}">
                                    <g:checkBox name="freeTruck" value="${storageSiteInstance?.freeTruck}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="contacts"><g:message code="storageSite.contacts.label" default="Contacts" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: storageSiteInstance, field: 'contacts', 'errors')}">
                                    
<ul>
<g:each in="${storageSiteInstance?.contacts?}" var="c">
    <li><g:link controller="siteContact" action="show" id="${c.id}">${c?.encodeAsHTML()}</g:link></li>
</g:each>
</ul>
<g:link controller="siteContact" action="create" params="['storageSite.id': storageSiteInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'siteContact.label', default: 'SiteContact')])}</g:link>

                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="city"><g:message code="storageSite.city.label" default="City" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: storageSiteInstance, field: 'city', 'errors')}">
                                    <g:textField name="city" value="${storageSiteInstance?.city}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="title"><g:message code="storageSite.title.label" default="Title" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: storageSiteInstance, field: 'title', 'errors')}">
                                    <g:textField name="title" value="${storageSiteInstance?.title}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="requiresInsurance"><g:message code="storageSite.requiresInsurance.label" default="Requires Insurance" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: storageSiteInstance, field: 'requiresInsurance', 'errors')}">
                                    <g:checkBox name="requiresInsurance" value="${storageSiteInstance?.requiresInsurance}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="isKeypad"><g:message code="storageSite.isKeypad.label" default="Is Keypad" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: storageSiteInstance, field: 'isKeypad', 'errors')}">
                                    <g:checkBox name="isKeypad" value="${storageSiteInstance?.isKeypad}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="lat"><g:message code="storageSite.lat.label" default="Lat" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: storageSiteInstance, field: 'lat', 'errors')}">
                                    <g:textField name="lat" value="${fieldValue(bean: storageSiteInstance, field: 'lat')}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="specialOffers"><g:message code="storageSite.specialOffers.label" default="Special Offers" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: storageSiteInstance, field: 'specialOffers', 'errors')}">
                                    <g:select name="specialOffers" from="${SpecialOffer.list()}" multiple="yes" optionKey="id" size="5" value="${storageSiteInstance?.specialOffers}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="isUnitAlarmed"><g:message code="storageSite.isUnitAlarmed.label" default="Is Unit Alarmed" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: storageSiteInstance, field: 'isUnitAlarmed', 'errors')}">
                                    <g:checkBox name="isUnitAlarmed" value="${storageSiteInstance?.isUnitAlarmed}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="units"><g:message code="storageSite.units.label" default="Units" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: storageSiteInstance, field: 'units', 'errors')}">
                                    <g:select name="units" from="${StorageUnit.list()}" multiple="yes" optionKey="id" size="5" value="${storageSiteInstance?.units}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="address"><g:message code="storageSite.address.label" default="Address" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: storageSiteInstance, field: 'address', 'errors')}">
                                    <g:textField name="address" value="${storageSiteInstance?.address}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="isCamera"><g:message code="storageSite.isCamera.label" default="Is Camera" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: storageSiteInstance, field: 'isCamera', 'errors')}">
                                    <g:checkBox name="isCamera" value="${storageSiteInstance?.isCamera}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="images"><g:message code="storageSite.images.label" default="Images" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: storageSiteInstance, field: 'images', 'errors')}">
                                    
<ul>
<g:each in="${storageSiteInstance?.images?}" var="i">
    <li><g:link controller="siteImage" action="show" id="${i.id}">${i?.encodeAsHTML()}</g:link></li>
</g:each>
</ul>
<g:link controller="siteImage" action="create" params="['storageSite.id': storageSiteInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'siteImage.label', default: 'SiteImage')])}</g:link>

                                </td>
                            </tr>
                        
                        </tbody>
                    </table>
                </div>
                <div class="buttons">
                    <span class="button"><g:actionSubmit class="save" action="update" value="${message(code: 'default.button.update.label', default: 'Update')}" /></span>
                    <span class="button"><g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" /></span>
                </div>
            </g:form>
        </div>
    </body>
</html>
