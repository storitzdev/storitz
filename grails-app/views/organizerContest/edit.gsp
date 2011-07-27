<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="com.storitz.OrganizerContest" %>
<html>
    <head>
        <g:set var="entityName" value="${message(code: 'organizerContest.label', default: 'OrganizerContest')}" />
        <title><g:message code="default.edit.label" args="[entityName]" /></title>
   </head>
    <body id="body">
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
                                  <label for="zipcode"><g:message code="organizerContest.zipcode.label" default="Zipcode" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: organizerContestInstance, field: 'zipcode', 'errors')}">
                                    <g:textField name="zipcode" value="${organizerContestInstance?.zipcode}" />
                                </td>
                            </tr>
                        
                        <tr class="prop">
                            <td valign="top" class="name">
                              <label for="zipcode2"><g:message code="organizerContest.zipcode2.label" default="Zipcode2" /></label>
                            </td>
                            <td valign="top" class="value ${hasErrors(bean: organizerContestInstance, field: 'zipcode2', 'errors')}">
                                <g:textField name="zipcode2" value="${organizerContestInstance?.zipcode2}" />
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
                                  <label for="sendMeUpdates"><g:message code="organizerContest.sendMeUpdates.label" default="Send Me Updates" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: organizerContestInstance, field: 'sendMeUpdates', 'errors')}">
                                    <g:checkBox name="sendMeUpdates" value="${organizerContestInstance?.sendMeUpdates}" />
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
