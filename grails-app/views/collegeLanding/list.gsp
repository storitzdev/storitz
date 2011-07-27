<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="org.codehaus.groovy.grails.commons.ConfigurationHolder; com.storitz.CollegeLanding" %>
<html>
    <head>
        <g:set var="entityName" value="${message(code: 'collegeLanding.label', default: 'CollegeLanding')}" />
        <title><g:message code="default.list.label" args="[entityName]" /></title>
    </head>
    <body id="body">
   <div class="buttons">
        <span class="button"><a href="${createLink(controller: 'admin', action: 'index')}">Menu</a></span>
        <span class="button"><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></span>
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
                        
                            <g:sortableColumn property="id" title="${message(code: 'collegeLanding.id.label', default: 'Id')}" />
                        
                            <g:sortableColumn property="name" title="${message(code: 'collegeLanding.name.label', default: 'Name')}" />
                        
                            <g:sortableColumn property="address" title="${message(code: 'collegeLanding.address.label', default: 'Address')}" />
                        
                            <g:sortableColumn property="displayName" title="${message(code: 'collegeLanding.displayName.label', default: 'Display Name')}" />

                            <g:sortableColumn property="url" title="${message(code: 'collegeLanding.url.label', default: 'URL')}" />
                      </tr>
                    </thead>
                    <tbody>
                    <g:each in="${collegeLandingInstanceList}" status="i" var="collegeLandingInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td><g:link action="show" id="${collegeLandingInstance.id}">${fieldValue(bean: collegeLandingInstance, field: "id")}</g:link></td>
                        
                            <td>${fieldValue(bean: collegeLandingInstance, field: "name")}</td>
                        
                            <td>${fieldValue(bean: collegeLandingInstance, field: "address")}</td>
                        
                            <td>${fieldValue(bean: collegeLandingInstance, field: "displayName")}</td>

                            <td>${ConfigurationHolder.config.grails.serverURL}/college/${fieldValue(bean: collegeLandingInstance, field: "name").toString().toLowerCase()}</td>
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${collegeLandingInstanceTotal}" />
            </div>
        </div>
    </body>
</html>
