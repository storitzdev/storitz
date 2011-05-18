<%@ page import="com.storitz.OrganizerContest" %>
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN"
    "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'organizerContest.label', default: 'OrganizerContest')}" />
        <title><g:message code="default.edit.label" args="[entityName]" /></title>
        <meta name="keywords" content="self-storage, household storage, self storage, storage unit, self storage unit, moving and  relocation storage, storage pods, container storage, compare self storage, storage comparison, lowest storage rent, best storage prices, storage units for rent,  storage unit rental, self storage, self-storage search engine, self-storage directory, self storage facility,  find self storage, mini storage, Military storage, College student storage, University storage, Senior citizen storage"/>
        <p:favicon src="images/favicon"/>
        <p:css name='header_bundled'/>
        <script src="http://www.google.com/jsapi" type="text/javascript"></script>
        <p:javascript src='header_all'/>
    </head>
    <body id="body">
    <g:render template="/topnav"/>
    <g:render template="/logo_bar"/>
    <div class="buttons">
        <span class="button"><a href="${createLink(controller: 'admin', action: 'index')}">Menu</a></span>
        <span class="button"><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></span>
        <!--
        <span class="button"><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></span>
        -->
    </div>
       <div class="body">
            <h1><g:message code="default.edit.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${organizerContestInstance}">
            <div class="errors">
                <g:renderErrors bean="${organizerContestInstance}" as="list" />
            </div>
            </g:hasErrors>
           <p style="color:red;">Please Note: This content is generated via public form submission. Please do not edit without good reason.</p>
            <g:form method="post" >
                <g:hiddenField name="id" value="${organizerContestInstance?.id}" />
                <g:hiddenField name="version" value="${organizerContestInstance?.version}" />
                <div class="dialog">
                    <table>
                        <tbody>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="firstName"><g:message code="organizerContest.firstName.label" default="First Name" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: organizerContestInstance, field: 'firstName', 'errors')}">
                                    <g:textField name="firstName" value="${organizerContestInstance?.firstName}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="lastName"><g:message code="organizerContest.lastName.label" default="Last Name" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: organizerContestInstance, field: 'lastName', 'errors')}">
                                    <g:textField name="lastName" value="${organizerContestInstance?.lastName}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="phone"><g:message code="organizerContest.phone.label" default="Phone" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: organizerContestInstance, field: 'phone', 'errors')}">
                                    <g:textField name="phone" value="${organizerContestInstance?.phone}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="email"><g:message code="organizerContest.email.label" default="Email" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: organizerContestInstance, field: 'email', 'errors')}">
                                    <g:textField name="email" value="${organizerContestInstance?.email}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="twitterName"><g:message code="organizerContest.twitterName.label" default="Twitter Name" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: organizerContestInstance, field: 'twitterName', 'errors')}">
                                    <g:textField name="twitterName" value="${organizerContestInstance?.twitterName}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="address1"><g:message code="organizerContest.address1.label" default="Address1" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: organizerContestInstance, field: 'address1', 'errors')}">
                                    <g:textField name="address1" value="${organizerContestInstance?.address1}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="address2"><g:message code="organizerContest.address2.label" default="Address2" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: organizerContestInstance, field: 'address2', 'errors')}">
                                    <g:textField name="address2" value="${organizerContestInstance?.address2}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="city"><g:message code="organizerContest.city.label" default="City" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: organizerContestInstance, field: 'city', 'errors')}">
                                    <g:textField name="city" value="${organizerContestInstance?.city}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="state"><g:message code="organizerContest.state.label" default="State" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: organizerContestInstance, field: 'state', 'errors')}">
                                    <g:select name="state" from="${storitz.constants.State?.values()}" keys="${storitz.constants.State?.values()*.name()}" value="${organizerContestInstance?.state?.name()}"  />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="zipcode"><g:message code="organizerContest.zipcode.label" default="Zipcode" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: organizerContestInstance, field: 'zipcode', 'errors')}">
                                    <g:textField name="zipcode" value="${organizerContestInstance?.zipcode}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="referralSource"><g:message code="organizerContest.referralSource.label" default="Referral Source" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: organizerContestInstance, field: 'referralSource', 'errors')}">
                                    <g:textField name="referralSource" value="${organizerContestInstance?.referralSource}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="essayWhyStorage"><g:message code="organizerContest.essayWhyStorage.label" default="Essay Why Storage" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: organizerContestInstance, field: 'essayWhyStorage', 'errors')}">
                                    <g:textArea cols="50" rows="5" name="essayWhyStorage" value="${organizerContestInstance?.essayWhyStorage}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="readTermsAndConditions"><g:message code="organizerContest.readTermsAndConditions.label" default="Read Terms And Conditions" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: organizerContestInstance, field: 'readTermsAndConditions', 'errors')}">
                                    <g:checkBox name="readTermsAndConditions" value="${organizerContestInstance?.readTermsAndConditions}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="dontSendMeUpdates"><g:message code="organizerContest.dontSendMeUpdates.label" default="Don't Send Me Updates" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: organizerContestInstance, field: 'dontSendMeUpdates', 'errors')}">
                                    <g:checkBox name="dontSendMeUpdates" value="${organizerContestInstance?.dontSendMeUpdates}" />
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
