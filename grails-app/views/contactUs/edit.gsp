

<%@ page import="com.storitz.ContactUs" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'contactUs.label', default: 'ContactUs')}" scope="request" />
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
            <g:hasErrors bean="${contactUsInstance}">
            <div class="errors">
                <g:renderErrors bean="${contactUsInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form method="post" >
                <g:hiddenField name="id" value="${contactUsInstance?.id}" />
                <g:hiddenField name="version" value="${contactUsInstance?.version}" />
                <div class="dialog">
                    <table>
                        <tbody>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="message"><g:message code="contactUs.message.label" default="Message" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: contactUsInstance, field: 'message', 'errors')}">
                                    <g:textArea name="message" cols="40" rows="5" value="${contactUsInstance?.message}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="userEmail"><g:message code="contactUs.userEmail.label" default="User Email" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: contactUsInstance, field: 'userEmail', 'errors')}">
                                    <g:textField name="userEmail" value="${contactUsInstance?.userEmail}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="contactType"><g:message code="contactUs.contactType.label" default="Contact Type" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: contactUsInstance, field: 'contactType', 'errors')}">
                                    <g:select name="contactType" from="${storitz.constants.ContactType?.values()}" value="${contactUsInstance?.contactType}"  />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="entered"><g:message code="contactUs.entered.label" default="Entered" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: contactUsInstance, field: 'entered', 'errors')}">
                                    <g:datePicker name="entered" precision="day" value="${contactUsInstance?.entered}"  />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="notes"><g:message code="contactUs.notes.label" default="Notes" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: contactUsInstance, field: 'notes', 'errors')}">
                                    <g:select name="notes" from="${com.storitz.ContactUsNote.list()}" multiple="yes" optionKey="id" size="5" value="${contactUsInstance?.notes}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="serviced"><g:message code="contactUs.serviced.label" default="Serviced" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: contactUsInstance, field: 'serviced', 'errors')}">
                                    <g:checkBox name="serviced" value="${contactUsInstance?.serviced}" />
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
