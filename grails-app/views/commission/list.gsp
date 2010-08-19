
<%@ page import="com.storitz.Commission" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'commission.label', default: 'Commission')}" />
        <title><g:message code="default.list.label" args="[entityName]" /></title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLink(uri: '/')}">Home</a></span>
            <span class="menuButton"><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></span>
        </div>
        <div class="body">
            <h1><g:message code="default.list.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="list">
                <table>
                    <thead>
                        <tr>
                        
                            <g:sortableColumn property="id" title="${message(code: 'commission.id.label', default: 'Id')}" />
                        
                            <g:sortableColumn property="amount" title="${message(code: 'commission.amount.label', default: 'Amount')}" />
                        
                            <g:sortableColumn property="commissionType" title="${message(code: 'commission.commissionType.label', default: 'Commission Type')}" />
                        
                            <g:sortableColumn property="lowerBound" title="${message(code: 'commission.lowerBound.label', default: 'Lower Bound')}" />
                        
                            <g:sortableColumn property="upperBound" title="${message(code: 'commission.upperBound.label', default: 'Upper Bound')}" />
                        
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${commissionInstanceList}" status="i" var="commissionInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td><g:link action="show" id="${commissionInstance.id}">${fieldValue(bean: commissionInstance, field: "id")}</g:link></td>
                        
                            <td>${fieldValue(bean: commissionInstance, field: "amount")}</td>
                        
                            <td>${fieldValue(bean: commissionInstance, field: "commissionType")}</td>
                        
                            <td>${fieldValue(bean: commissionInstance, field: "lowerBound")}</td>
                        
                            <td>${fieldValue(bean: commissionInstance, field: "upperBound")}</td>
                        
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${commissionInstanceTotal}" />
            </div>
        </div>
    </body>
</html>
