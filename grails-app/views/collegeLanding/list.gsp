<%@ page import="com.storitz.CollegeLanding" %>
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN"
    "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'collegeLanding.label', default: 'CollegeLanding')}" />
        <title><g:message code="default.list.label" args="[entityName]" /></title>
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
                      </tr>
                    </thead>
                    <tbody>
                    <g:each in="${collegeLandingInstanceList}" status="i" var="collegeLandingInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td><g:link action="show" id="${collegeLandingInstance.id}">${fieldValue(bean: collegeLandingInstance, field: "id")}</g:link></td>
                        
                            <td>${fieldValue(bean: collegeLandingInstance, field: "name")}</td>
                        
                            <td>${fieldValue(bean: collegeLandingInstance, field: "address")}</td>
                        
                            <td>${fieldValue(bean: collegeLandingInstance, field: "displayName")}</td>
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
