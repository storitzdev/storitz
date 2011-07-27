<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="com.storitz.EDomicoAmenitiesMap" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta name="layout" content="main" />
    <g:set var="entityName" value="${message(code: 'EDomicoAmenitiesMap.label', default: 'EDomicoAmenitiesMap')}" />
    <g:set var="title" value="Edit EDomico Amenities Mappings" scope="request"/>
</head>
<body>
<div id="body">

    <div class="stcontent">
        <div class="buttons">
            <span class="button"><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></span>
            <span class="button"><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></span>
            <!--span class="button"><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></span-->
        </div>
        <div class="body">
            <h1><g:message code="default.edit.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
                <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${EDomicoAmenitiesMapInstance}">
                <div class="errors">
                    <g:renderErrors bean="${EDomicoAmenitiesMapInstance}" as="list" />
                </div>
            </g:hasErrors>
            <g:form method="post" >
                <g:hiddenField name="id" value="${EDomicoAmenitiesMapInstance?.id}" />
                <g:hiddenField name="version" value="${EDomicoAmenitiesMapInstance?.version}" />
                <div class="dialog">
                    <table>
                        <tbody>

                        <tr class="prop">
                            <td valign="top" class="name">
                                <label for="type"><g:message code="EDomicoAmenitiesMap.type.label" default="Description" /></label>
                            </td>
                            <td valign="top" class="value ${hasErrors(bean: EDomicoAmenitiesMapInstance, field: 'description', 'errors')}">
                                <g:hiddenField name="type" value="${EDomicoAmenitiesMapInstance?.description}" />
                                ${EDomicoAmenitiesMapInstance?.description}
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
                                <label for="unitType"><g:message code="EDomicoAmenitiesMap.searchType.label" default="Search Type" /></label>
                            </td>
                            <td valign="top" class="value ${hasErrors(bean: EDomicoAmenitiesMapInstance, field: 'searchType', 'errors')}">
                                <g:select name="searchType" from="${storitz.constants.SearchType?.values()}" keys="${storitz.constants.SearchType?.values()*.name()}" value="${EDomicoAmenitiesMapInstance?.searchType?.name()}"  />
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
                    <span class="button"><g:actionSubmit class="save" action="update" value="${message(code: 'default.button.update.label', default: 'Update')}" /></span>
                    <!--span class="button"><g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" /></span-->
                </div>
            </g:form>
        </div>
    </div>
</div>
</body>
</html>
