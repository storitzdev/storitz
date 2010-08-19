

<%@ page import="com.storitz.Commission" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'commission.label', default: 'Commission')}" />
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
            <g:hasErrors bean="${commissionInstance}">
            <div class="errors">
                <g:renderErrors bean="${commissionInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form method="post" >
                <g:hiddenField name="id" value="${commissionInstance?.id}" />
                <g:hiddenField name="version" value="${commissionInstance?.version}" />
                <div class="dialog">
                    <table>
                        <tbody>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="amount"><g:message code="commission.amount.label" default="Amount" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: commissionInstance, field: 'amount', 'errors')}">
                                    <g:textField name="amount" value="${fieldValue(bean: commissionInstance, field: 'amount')}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="commissionType"><g:message code="commission.commissionType.label" default="Commission Type" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: commissionInstance, field: 'commissionType', 'errors')}">
                                    <g:select name="commissionType" from="${storitz.constants.CommissionType?.values()}" value="${commissionInstance?.commissionType}"  />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="lowerBound"><g:message code="commission.lowerBound.label" default="Lower Bound" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: commissionInstance, field: 'lowerBound', 'errors')}">
                                    <g:textField name="lowerBound" value="${fieldValue(bean: commissionInstance, field: 'lowerBound')}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="upperBound"><g:message code="commission.upperBound.label" default="Upper Bound" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: commissionInstance, field: 'upperBound', 'errors')}">
                                    <g:textField name="upperBound" value="${fieldValue(bean: commissionInstance, field: 'upperBound')}" />
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
