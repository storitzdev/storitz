<%@ page import="com.storitz.CollegeLanding" %>
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN"
    "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'collegeLanding.label', default: 'CollegeLanding')}" />
        <title><g:message code="default.edit.label" args="[entityName]" /></title>
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
        <span class="button"><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></span>
        <span class="button"><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></span>
    </div>
        <div class="body">
            <h1><g:message code="default.edit.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${collegeLandingInstance}">
            <div class="errors">
                <g:renderErrors bean="${collegeLandingInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form method="post" enctype="multipart/form-data">
                <g:hiddenField name="id" value="${collegeLandingInstance?.id}" />
                <g:hiddenField name="version" value="${collegeLandingInstance?.version}" />
                <g:hiddenField name="logoBaseName" value="${collegeLandingInstance?.logoBaseName}" />
                <g:hiddenField name="logoFileLoc" value="${collegeLandingInstance?.logoFileLoc}" />
                <div class="dialog">
                    <table>
                        <tbody>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="name"><g:message code="collegeLanding.name.label" default="Name" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: collegeLandingInstance, field: 'name', 'errors')}">
                                    <g:textField size="50" name="name" value="${collegeLandingInstance?.name}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="address"><g:message code="collegeLanding.address.label" default="Address" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: collegeLandingInstance, field: 'address', 'errors')}">
                                    <g:textField size="50"  name="address" value="${collegeLandingInstance?.address}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="displayName"><g:message code="collegeLanding.displayName.label" default="Display Name" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: collegeLandingInstance, field: 'displayName', 'errors')}">
                                    <g:textField size="50"  name="displayName" value="${collegeLandingInstance?.displayName}" />
                                </td>
                            </tr>
                          <tr class="prop">
                                <td valign="top" class="name">
                                    <img src="${resource(file: collegeLandingInstance.logoSrc())}" alt="logo"/><br>
                                    <label for="logoFile">College Logo</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: collegeLandingInstance, field: 'logoBaseName', 'errors')}">
                                    <input id="logoFile" type="file" style="width:250px;" name="logoFile"/>
                                </td>
                            </tr>

                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="primaryBGColor"><g:message code="collegeLanding.primaryBGColor.label" default="Primary BGC olor" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: collegeLandingInstance, field: 'primaryBGColor', 'errors')}">
                                    <g:textField size="50"  name="primaryBGColor" value="${collegeLandingInstance?.primaryBGColor}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="primaryFGColor"><g:message code="collegeLanding.primaryFGColor.label" default="Primary FGC olor" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: collegeLandingInstance, field: 'primaryFGColor', 'errors')}">
                                    <g:textField  size="50" name="primaryFGColor" value="${collegeLandingInstance?.primaryFGColor}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="secondaryBGColor"><g:message code="collegeLanding.secondaryBGColor.label" default="Secondary BGC olor" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: collegeLandingInstance, field: 'secondaryBGColor', 'errors')}">
                                    <g:textField size="50"  name="secondaryBGColor" value="${collegeLandingInstance?.secondaryBGColor}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="secondaryFGColor"><g:message code="collegeLanding.secondaryFGColor.label" default="Secondary FGC olor" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: collegeLandingInstance, field: 'secondaryFGColor', 'errors')}">
                                    <g:textField size="50"  name="secondaryFGColor" value="${collegeLandingInstance?.secondaryFGColor}" />
                                </td>
                            </tr>
                        
                        </tbody>
                    </table>
                </div>
                <div class="buttons">
                    <span class="button"><g:actionSubmit class="save" action="update" value="${message(code: 'default.button.update.label', default: 'Update')}" /></span>
                    <span class="button"><g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" /></span>
                </div>
            </g:form>
        </div>
    </body>
</html>
