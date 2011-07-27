<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="com.storitz.OrganizerContest" %>
<html>
    <head>
        <g:set var="entityName" value="${message(code: 'organizerContest.label', default: 'OrganizerContest')}" />
        <title><g:message code="default.show.label" args="[entityName]" /></title>
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
            <h1><g:message code="default.show.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="dialog">
                <table>
                    <tbody>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="organizerContest.id.label" default="Id" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: organizerContestInstance, field: "id")}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="organizerContest.firstName.label" default="First Name" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: organizerContestInstance, field: "firstName")}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="organizerContest.lastName.label" default="Last Name" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: organizerContestInstance, field: "lastName")}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="organizerContest.phone.label" default="Phone" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: organizerContestInstance, field: "phone")}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="organizerContest.email.label" default="Email" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: organizerContestInstance, field: "email")}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="organizerContest.twitterName.label" default="Twitter Name" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: organizerContestInstance, field: "twitterName")}</td>
                            
                        </tr>

                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="organizerContest.zipcode.label" default="Zipcode" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: organizerContestInstance, field: "zipcode")}</td>
                            
                        </tr>
                    
                    <tr class="prop">
                        <td valign="top" class="name"><g:message code="organizerContest.zipcode2.label" default="Zipcode2" /></td>

                        <td valign="top" class="value">${fieldValue(bean: organizerContestInstance, field: "zipcode2")}</td>

                    </tr>

                         <tr class="prop">
                            <td valign="top" class="name"><g:message code="organizerContest.referralSource.label" default="Referral Source" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: organizerContestInstance, field: "referralSource")}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="organizerContest.essayWhyStorage.label" default="Essay Why Storage" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: organizerContestInstance, field: "essayWhyStorage")}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="organizerContest.readTermsAndConditions.label" default="Read Terms And Conditions" /></td>
                            
                            <td valign="top" class="value"><g:formatBoolean boolean="${organizerContestInstance?.readTermsAndConditions}" /></td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="organizerContest.sendMeUpdates.label" default="Send Me Updates" /></td>
                            
                            <td valign="top" class="value"><g:formatBoolean boolean="${organizerContestInstance?.sendMeUpdates}" /></td>
                            
                        </tr>
                    
                    </tbody>
                </table>
            </div>
            <div class="buttons">
                <g:form>
                    <g:hiddenField name="id" value="${organizerContestInstance?.id}" />
                    <span class="button"><g:actionSubmit class="edit" action="edit" value="${message(code: 'default.button.edit.label', default: 'Edit')}" /></span>
                    <span class="button"><g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" /></span>
                </g:form>
            </div>
        </div>
    </body>
</html>
