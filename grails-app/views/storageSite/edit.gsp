<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN"
    "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head>
  <g:set var="title" value="Create Storage Site"/>
  <g:render template="/header"/>

  <script type="text/javascript">
    //<![CDATA[
      google.load("jquery", "1.4.2");

      jQuery.noConflict();

    //]]>
  </script>
  <script src="http://www.fyneworks.com/jquery/multiple-file-upload/jquery.blockUI.js" type="text/javascript"></script>
  <script src="http://jquery-multifile-plugin.googlecode.com/svn/trunk/jquery.MultiFile.js" type="text/javascript"></script>
  <script src="http://www.fyneworks.com/jquery/multiple-file-upload/jquery.MetaData.js" type="text/javascript"></script>

</head>
<body>
<g:render template="/topnav"/>
<div id="stcontent">
        <div class="nav">
          <span class="menuButton"><a class="home" href="${createLink(controller:'admin', action:'index')}">Admin</a></span>
          <span class="menuButton"><g:link class="list" action="list">List Sites</g:link></span>
          <span class="menuButton"><g:link class="create" action="create">Create new Site</g:link></span>
        </div>
        <div class="body">
            <h1>Edit Site</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${storageSiteInstance}">
            <div class="errors">
                <g:renderErrors bean="${storageSiteInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:uploadForm method="post" >
                <g:hiddenField name="id" value="${storageSiteInstance?.id}" />
                <g:hiddenField name="version" value="${storageSiteInstance?.version}" />
                <div class="dialog">
                    <table>
                        <tbody>
                        
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
                                  <label for="description"><g:message code="storageSite.description.label" default="Description" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: storageSiteInstance, field: 'description', 'errors')}">
                                    <g:textArea name="description" cols="40" rows="5" value="${storageSiteInstance?.description}" />
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
                                  <label for="address2"><g:message code="storageSite.address2.label" default="Address2" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: storageSiteInstance, field: 'address2', 'errors')}">
                                    <g:textField name="address2" value="${storageSiteInstance?.address2}" />
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
                                  <label for="state"><g:message code="storageSite.state.label" default="State" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: storageSiteInstance, field: 'state', 'errors')}">
                                    <g:textField name="state" value="${storageSiteInstance?.state}" />
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
                                  <label for="logoFile"><g:message code="storageSite.logo.label" default="Logo" /></label>
                                </td>
                                <td valign="top" class="value">
                                    <g:if test="${storageSiteInstance?.logo}">
                                      <img src="${resource(dir:'image', file:storageSiteInstance.logo.src())}" alt="logo"/>
                                    </g:if>
                                    <input type="file" name="logoFile" />
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
                            <td colspan="2" valign="top"><h3>Fees</h3></td>

                          </tr>

                          <tr class="prop">
                              <td valign="top" class="name">
                                <label for="adminFee"><g:message code="storageSite.adminFee.label" default="Admin Fee" /></label>
                              </td>
                              <td valign="top" class="value ${hasErrors(bean: storageSiteInstance, field: 'adminFee', 'errors')}">
                                  <g:textField name="adminFee" value="${storageSiteInstance?.adminFee}" />
                              </td>
                          </tr>

                          <tr class="prop">
                              <td valign="top" class="name">
                                <label for="lockFee"><g:message code="storageSite.lockFee.label" default="Lock Fee" /></label>
                              </td>
                              <td valign="top" class="value ${hasErrors(bean: storageSiteInstance, field: 'lockFee', 'errors')}">
                                  <g:textField name="lockFee" value="${storageSiteInstance?.lockFee}" />
                              </td>
                          </tr>

                          <tr class="prop">
                              <td colspan="2" valign="top"><h3>Attributes</h3></td>

                          </tr>

                          <tr class="prop">
                              <td valign="top" class="name">
                                <label for="isGate"><g:message code="storageSite.isGate.label" default="Gated Site Entry" /></label>
                              </td>
                              <td valign="top" class="value ${hasErrors(bean: storageSiteInstance, field: 'isGate', 'errors')}">
                                  <g:checkBox name="isGate" value="${storageSiteInstance?.isGate}" />
                              </td>
                          </tr>

                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="freeTruck"><g:message code="storageSite.freeTruck.label" default="Free Moving Truck" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: storageSiteInstance, field: 'freeTruck', 'errors')}">
                                    <g:select name="freeTruck" from="${storagetech.constants.TruckType.list()}" value="${storageSiteInstance?.freeTruck}" optionValue="display" />
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
                                  <label for="requiresInsurance"><g:message code="storageSite.requiresInsurance.label" default="Requires Insurance" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: storageSiteInstance, field: 'requiresInsurance', 'errors')}">
                                    <g:checkBox name="requiresInsurance" value="${storageSiteInstance?.requiresInsurance}" />
                                </td>
                            </tr>

                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="isKeypad"><g:message code="storageSite.isKeypad.label" default="Keypad Entry" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: storageSiteInstance, field: 'isKeypad', 'errors')}">
                                    <g:checkBox name="isKeypad" value="${storageSiteInstance?.isKeypad}" />
                                </td>
                            </tr>

                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="isUnitAlarmed"><g:message code="storageSite.isUnitAlarmed.label" default="Unit Alarmed" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: storageSiteInstance, field: 'isUnitAlarmed', 'errors')}">
                                    <g:checkBox name="isUnitAlarmed" value="${storageSiteInstance?.isUnitAlarmed}" />
                                </td>
                            </tr>

                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="isCamera"><g:message code="storageSite.isCamera.label" default="Video Security" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: storageSiteInstance, field: 'isCamera', 'errors')}">
                                    <g:checkBox name="isCamera" value="${storageSiteInstance?.isCamera}" />
                                </td>
                            </tr>

                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="contacts"><g:message code="storageSite.contacts.label" default="Contacts" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: storageSiteInstance, field: 'contacts', 'errors')}">
                                    
                                  <ul>
                                  <g:each in="${storageSiteInstance?.contacts?}" var="c">
                                      <li><g:link controller="siteContact" action="show" id="${c.id}">${c.name} - ${c.email}</g:link></li>
                                  </g:each>
                                  </ul>
                                  <g:link controller="siteContact" action="create" params="['storageSite.id': storageSiteInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'siteContact.label', default: 'SiteContact')])}</g:link>

                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="specialOffers"><g:message code="storageSite.specialOffers.label" default="Special Offers" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: storageSiteInstance, field: 'specialOffers', 'errors')}">
                                  <ul>
                                    <g:each in="${storageSiteInstance?.specialOffers?}" var="o">
                                      <li><g:checkBox name="specialOffer_${o.id}" value="${o.active}"/> ${o.promoName}</li>
                                    </g:each>
                                  </ul>
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
            </g:uploadForm>
        </div>
      </div>
    </body>
</html>
