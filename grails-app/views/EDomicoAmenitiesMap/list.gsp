<%@ page import="com.storitz.EDomicoAmenitiesMap" %>
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN"
    "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta name="layout" content="main" />
    <g:set var="entityName" value="${message(code: 'EDomicoAmenitiesMap.label', default: 'EDomicoAmenitiesMap')}" />
    <g:set var="title" value="List EDomico Amenities Mappings" scope="request"/>
    <g:render template="/header"/>
</head>
<body>
<div id="body">
    <g:render template="/topnav" />
    <div class="stcontent">
        <g:render template="/logo_bar" />
        <div class="buttons">
            <span class="button"><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></span>
            <!--span class="button"><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></span-->
            <span class="button"><g:link controller="EDomico" action="list">List EDomico Feeds</g:link></span>
        </div>

        <div class="body">

            <div class="price_options checkout_header white">
              List EDomico Amenities Mappings
            </div>

            <g:if test="${flash.message}">
                <div class="message">${flash.message}</div>
            </g:if>
            <div class="list">
                <table>
                    <thead>
                    <tr>

                        <g:sortableColumn property="id" title="${message(code: 'EDomicoAmenitiesMap.id.label', default: 'Id')}" />

                        <g:sortableColumn property="description" title="${message(code: 'EDomicoAmenitiesMap.type.label', default: 'Description')}" />

                        <g:sortableColumn property="unitType" title="${message(code: 'EDomicoAmenitiesMap.unitType.label', default: 'Unit Type')}" />

                        <g:sortableColumn property="secure" title="${message(code: 'EDomicoAmenitiesMap.secure.label', default: 'Secure')}" />

                        <g:sortableColumn property="tempControlled" title="${message(code: 'EDomicoAmenitiesMap.tempControlled.label', default: 'temperature Controlled')}" />

                        <g:sortableColumn property="powered" title="${message(code: 'EDomicoAmenitiesMap.powered.label', default: 'Powered')}" />

                    </tr>
                    </thead>
                    <tbody>
                    <g:each in="${EDomicoAmenitiesMapInstanceList}" status="i" var="EDomicoAmenitiesMapInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">

                            <td><g:link action="show" id="${EDomicoAmenitiesMapInstance.id}">${fieldValue(bean: EDomicoAmenitiesMapInstance, field: "id")}</g:link></td>

                            <td>${fieldValue(bean: EDomicoAmenitiesMapInstance, field: "description")}</td>

                            <td>${fieldValue(bean: EDomicoAmenitiesMapInstance, field: "unitType")}</td>

                            <td><g:formatBoolean boolean="${EDomicoAmenitiesMapInstance.secure}" /></td>

                            <td><g:formatBoolean boolean="${EDomicoAmenitiesMapInstance.tempControlled}" /></td>

                            <td><g:formatBoolean boolean="${EDomicoAmenitiesMapInstance.powered}" /></td>

                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${EDomicoAmenitiesMapInstanceTotal}" />
            </div>
        </div>
    </div>
</div>
</body>
</html>
