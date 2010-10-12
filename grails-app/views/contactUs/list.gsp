
<%@ page import="com.storitz.ContactUs" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'contactUs.label', default: 'ContactUs')}" scope="request" />
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
                        
                            <g:sortableColumn property="id" title="${message(code: 'contactUs.id.label', default: 'Id')}" />
                        
                            <g:sortableColumn property="message" title="${message(code: 'contactUs.message.label', default: 'Message')}" />
                        
                            <g:sortableColumn property="userEmail" title="${message(code: 'contactUs.userEmail.label', default: 'User Email')}" />
                        
                            <g:sortableColumn property="contactType" title="${message(code: 'contactUs.contactType.label', default: 'Contact Type')}" />
                        
                            <g:sortableColumn property="entered" title="${message(code: 'contactUs.entered.label', default: 'Entered')}" />
                        
                            <g:sortableColumn property="serviced" title="${message(code: 'contactUs.serviced.label', default: 'Serviced')}" />
                        
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${contactUsInstanceList}" status="i" var="contactUsInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td><g:link action="show" id="${contactUsInstance.id}">${fieldValue(bean: contactUsInstance, field: "id")}</g:link></td>
                        
                            <td>${fieldValue(bean: contactUsInstance, field: "message")}</td>
                        
                            <td>${fieldValue(bean: contactUsInstance, field: "userEmail")}</td>
                        
                            <td>${fieldValue(bean: contactUsInstance, field: "contactType")}</td>
                        
                            <td><g:formatDate date="${contactUsInstance.entered}" /></td>
                        
                            <td><g:formatBoolean boolean="${contactUsInstance.serviced}" /></td>
                        
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${contactUsInstanceTotal}" />
            </div>
        </div>
    </body>
</html>
