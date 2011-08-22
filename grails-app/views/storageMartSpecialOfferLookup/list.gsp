<%@ page import="com.storitz.StorageMartSpecialOfferLookup" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <g:set var="entityName" value="${message(code: 'storageMartSpecialOfferLookup.label', default: 'StorageMartSpecialOfferLookup')}" />
    <title><g:message code="default.list.label" args="[entityName]" /></title>
</head>
<body>
<div id="body">
    <div class="stcontent">
        <div class="buttons">
            <span class="button"><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></span>
            <!--span class="menuButton"><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></span-->
            <span class="button"><g:link controller="storageMart" action="list">List Storage mart Feeds</g:link></span>
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

                        <g:sortableColumn property="id" title="${message(code: 'storageMartSpecialOfferLookup.id.label', default: 'Id')}" />

                        <g:sortableColumn property="name" title="${message(code: 'storageMartSpecialOfferLookup.name.label', default: 'Name')}" />

                        <g:sortableColumn property="type" title="${message(code: 'storageMartSpecialOfferLookup.type.label', default: 'Type')}" />

                        <g:sortableColumn property="amount" title="${message(code: 'storageMartSpecialOfferLookup.amount.label', default: 'Amount')}" />

                        <g:sortableColumn property="startMonth" title="${message(code: 'storageMartSpecialOfferLookup.startMonth.label', default: 'Start Month')}" />

                        <g:sortableColumn property="expireMonth" title="${message(code: 'storageMartSpecialOfferLookup.expireMonth.label', default: 'Expire Month')}" />

                    </tr>
                    </thead>
                    <tbody>
                    <g:each in="${storageMartSpecialOfferLookupInstanceList}" status="i" var="storageMartSpecialOfferLookupInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">

                            <td><g:link action="edit" id="${storageMartSpecialOfferLookupInstance.id}">${fieldValue(bean: storageMartSpecialOfferLookupInstance, field: "id")}</g:link></td>

                            <td>${fieldValue(bean: storageMartSpecialOfferLookupInstance, field: "name")}</td>

                            <td>${fieldValue(bean: storageMartSpecialOfferLookupInstance, field: "type")}</td>

                            <td>${fieldValue(bean: storageMartSpecialOfferLookupInstance, field: "amount")}</td>

                            <td>${fieldValue(bean: storageMartSpecialOfferLookupInstance, field: "startMonth")}</td>

                            <td>${fieldValue(bean: storageMartSpecialOfferLookupInstance, field: "expireMonth")}</td>

                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${storageMartSpecialOfferLookupInstanceTotal}" />
            </div>
        </div>
    </div>
</div>
</body>
</html>
