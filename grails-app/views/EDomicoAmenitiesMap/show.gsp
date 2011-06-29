<%@ page import="com.storitz.EDomicoAmenitiesMap" %>
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN"
    "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta name="layout" content="main" />
    <g:set var="entityName" value="${message(code: 'EDomicoAmenitiesMap.label', default: 'EDomicoAmenitiesMap')}" />
    <g:set var="title" value="Show EDomico Amenities Mappings" scope="request"/>
    <g:render template="/header"/>
</head>
<body>
<div id="body">

    <div class="stcontent">
        <g:render template="/logo_bar"/>
        <div class="buttons">
            <span class="button"><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></span>
            <span class="button"><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></span>
            <!--span class="button"><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></span-->
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
                        <td valign="top" class="name"><g:message code="EDomicoAmenitiesMap.id.label" default="Id" /></td>

                        <td valign="top" class="value">${fieldValue(bean: EDomicoAmenitiesMapInstance, field: "id")}</td>

                    </tr>

                    <tr class="prop">
                        <td valign="top" class="name"><g:message code="EDomicoAmenitiesMap.type.label" default="Description" /></td>

                        <td valign="top" class="value">${fieldValue(bean: EDomicoAmenitiesMapInstance, field: "description")}</td>

                    </tr>

                    <tr class="prop">
                        <td valign="top" class="name"><g:message code="EDomicoAmenitiesMap.unitType.label" default="Unit Type" /></td>

                        <td valign="top" class="value">${EDomicoAmenitiesMapInstance?.unitType?.encodeAsHTML()}</td>

                    </tr>

                    <tr class="prop">
                        <td valign="top" class="name"><g:message code="EDomicoAmenitiesMap.searchType.label" default="Search Type" /></td>

                        <td valign="top" class="value">${EDomicoAmenitiesMapInstance?.searchType?.encodeAsHTML()}</td>

                    </tr>

                    <tr class="prop">
                        <td valign="top" class="name"><g:message code="EDomicoAmenitiesMap.secure.label" default="Secure" /></td>

                        <td valign="top" class="value"><g:formatBoolean boolean="${EDomicoAmenitiesMapInstance?.secure}" /></td>

                    </tr>

                    <tr class="prop">
                        <td valign="top" class="name"><g:message code="EDomicoAmenitiesMap.climateControlled.label" default="Temperature Controlled" /></td>

                        <td valign="top" class="value"><g:formatBoolean boolean="${EDomicoAmenitiesMapInstance?.tempControlled}" /></td>

                    </tr>

                    <tr class="prop">
                        <td valign="top" class="name"><g:message code="EDomicoAmenitiesMap.powered.label" default="Powered" /></td>

                        <td valign="top" class="value"><g:formatBoolean boolean="${EDomicoAmenitiesMapInstance?.powered}" /></td>

                    </tr>

                    <tr class="prop">
                        <td valign="top" class="name"><g:message code="EDomicoAmenitiesMap.alarmed.label" default="Alarmed" /></td>

                        <td valign="top" class="value"><g:formatBoolean boolean="${EDomicoAmenitiesMapInstance?.alarmed}" /></td>

                    </tr>

                    <tr class="prop">
                        <td valign="top" class="name"><g:message code="EDomicoAmenitiesMap.irregular.label" default="Irregular" /></td>

                        <td valign="top" class="value"><g:formatBoolean boolean="${EDomicoAmenitiesMapInstance?.irregular}" /></td>

                    </tr>

                    </tbody>
                </table>
            </div>
            <div class="buttons">
                <g:form>
                    <g:hiddenField name="id" value="${EDomicoAmenitiesMapInstance?.id}" />
                    <span class="button"><g:actionSubmit class="edit" action="edit" value="${message(code: 'default.button.edit.label', default: 'Edit')}" /></span>
                    <!--span class="button"><g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" /></span-->
                </g:form>
            </div>
        </div>
    </div>
</div>
</body>
</html>
