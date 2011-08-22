

<%@ page import="com.storitz.StorageMartSpecialOfferLookup" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta name="layout" content="main" />
    <g:set var="entityName" value="${message(code: 'storageMartSpecialOfferLookup.label', default: 'StorageMartSpecialOfferLookup')}" />
    <title><g:message code="default.create.label" args="[entityName]" /></title>
</head>
<body>
<div class="nav">
    <span class="menuButton"><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></span>
    <span class="menuButton"><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></span>
</div>
<div class="body">
    <h1><g:message code="default.create.label" args="[entityName]" /></h1>
    <g:if test="${flash.message}">
        <div class="message">${flash.message}</div>
    </g:if>
    <g:hasErrors bean="${storageMartSpecialOfferLookupInstance}">
        <div class="errors">
            <g:renderErrors bean="${storageMartSpecialOfferLookupInstance}" as="list" />
        </div>
    </g:hasErrors>
    <g:form action="save" >
        <div class="dialog">
            <table>
                <tbody>

                <tr class="prop">
                    <td valign="top" class="name">
                        <label for="name"><g:message code="storageMartSpecialOfferLookup.name.label" default="Name" /></label>
                    </td>
                    <td valign="top" class="value ${hasErrors(bean: storageMartSpecialOfferLookupInstance, field: 'name', 'errors')}">
                        <g:textField name="name" value="${storageMartSpecialOfferLookupInstance?.name}" />
                    </td>
                </tr>

                <tr class="prop">
                    <td valign="top" class="name">
                        <label for="type"><g:message code="storageMartSpecialOfferLookup.type.label" default="Type" /></label>
                    </td>
                    <td valign="top" class="value ${hasErrors(bean: storageMartSpecialOfferLookupInstance, field: 'type', 'errors')}">
                        <g:select name="type" from="${storitz.constants.PromoType?.values()}" keys="${storitz.constants.PromoType?.values()*.name()}" value="${storageMartSpecialOfferLookupInstance?.type?.name()}" noSelection="['': '']" />
                    </td>
                </tr>

                <tr class="prop">
                    <td valign="top" class="name">
                        <label for="amount"><g:message code="storageMartSpecialOfferLookup.amount.label" default="Amount" /></label>
                    </td>
                    <td valign="top" class="value ${hasErrors(bean: storageMartSpecialOfferLookupInstance, field: 'amount', 'errors')}">
                        <g:textField name="amount" value="${fieldValue(bean: storageMartSpecialOfferLookupInstance, field: 'amount')}" />
                    </td>
                </tr>

                <tr class="prop">
                    <td valign="top" class="name">
                        <label for="startMonth"><g:message code="storageMartSpecialOfferLookup.startMonth.label" default="Start Month" /></label>
                    </td>
                    <td valign="top" class="value ${hasErrors(bean: storageMartSpecialOfferLookupInstance, field: 'startMonth', 'errors')}">
                        <g:textField name="startMonth" value="${fieldValue(bean: storageMartSpecialOfferLookupInstance, field: 'startMonth')}" />
                    </td>
                </tr>

                <tr class="prop">
                    <td valign="top" class="name">
                        <label for="expireMonth"><g:message code="storageMartSpecialOfferLookup.expireMonth.label" default="Expire Month" /></label>
                    </td>
                    <td valign="top" class="value ${hasErrors(bean: storageMartSpecialOfferLookupInstance, field: 'expireMonth', 'errors')}">
                        <g:textField name="expireMonth" value="${fieldValue(bean: storageMartSpecialOfferLookupInstance, field: 'expireMonth')}" />
                    </td>
                </tr>

                <tr class="prop">
                    <td valign="top" class="name">
                        <label for="prepayMonths"><g:message code="storageMartSpecialOfferLookup.prepayMonths.label" default="Prepay Months" /></label>
                    </td>
                    <td valign="top" class="value ${hasErrors(bean: storageMartSpecialOfferLookupInstance, field: 'prepayMonths', 'errors')}">
                        <g:textField name="prepayMonths" value="${fieldValue(bean: storageMartSpecialOfferLookupInstance, field: 'prepayMonths')}" />
                    </td>
                </tr>

                </tbody>
            </table>
        </div>
        <div class="buttons">
            <span class="button"><g:submitButton name="create" class="save" value="${message(code: 'default.button.create.label', default: 'Create')}" /></span>
        </div>
    </g:form>
</div>
</body>
</html>
