<%@ page import="com.storitz.EDomicoAmenitiesMap" %>
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN"
    "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'EDomicoAmenitiesMap.label', default: 'EDomicoAmenitiesMap')}" />
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
            <g:hasErrors bean="${EDomicoAmenitiesMapInstance}">
            <div class="errors">
                <g:renderErrors bean="${EDomicoAmenitiesMapInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form action="save" >
                <div class="dialog">
                    <table>
                        <tbody>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="type"><g:message code="EDomicoAmenitiesMap.type.label" default="Description" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: EDomicoAmenitiesMapInstance, field: 'description', 'errors')}">
                                    <g:textField name="type" value="${EDomicoAmenitiesMapInstance?.description}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="unitType"><g:message code="EDomicoAmenitiesMap.unitType.label" default="Unit Type" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: EDomicoAmenitiesMapInstance, field: 'unitType', 'errors')}">
                                    <g:select name="unitType" from="${storitz.constants.UnitType?.values()}" keys="${storitz.constants.UnitType?.values()*.name()}" value="${EDomicoAmenitiesMapInstance?.unitType?.name()}"  />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="secure"><g:message code="EDomicoAmenitiesMap.secure.label" default="Secure" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: EDomicoAmenitiesMapInstance, field: 'secure', 'errors')}">
                                    <g:checkBox name="secure" value="${EDomicoAmenitiesMapInstance?.secure}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="climateControlled"><g:message code="EDomicoAmenitiesMap.climateControlled.label" default="Temperature Controlled" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: EDomicoAmenitiesMapInstance, field: 'tempControlled', 'errors')}">
                                    <g:checkBox name="climateControlled" value="${EDomicoAmenitiesMapInstance?.tempControlled}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="powered"><g:message code="EDomicoAmenitiesMap.powered.label" default="Powered" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: EDomicoAmenitiesMapInstance, field: 'powered', 'errors')}">
                                    <g:checkBox name="powered" value="${EDomicoAmenitiesMapInstance?.powered}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="alarmed"><g:message code="EDomicoAmenitiesMap.alarmed.label" default="Alarmed" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: EDomicoAmenitiesMapInstance, field: 'alarmed', 'errors')}">
                                    <g:checkBox name="alarmed" value="${EDomicoAmenitiesMapInstance?.alarmed}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="irregular"><g:message code="EDomicoAmenitiesMap.irregular.label" default="Irregular" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: EDomicoAmenitiesMapInstance, field: 'irregular', 'errors')}">
                                    <g:checkBox name="irregular" value="${EDomicoAmenitiesMapInstance?.irregular}" />
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
