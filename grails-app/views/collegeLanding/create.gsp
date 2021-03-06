<%@ page import="com.storitz.CollegeLanding" %>
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN"
    "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'collegeLanding.label', default: 'CollegeLanding')}" />
        <g:set var="title" value="Create College Landing Page" scope="request"/>
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
            <span class="button"><g:link action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></span>
        </div>
        <div class="body">
            <div class="price_options checkout_header white">
                <g:message code="default.create.label" args="[entityName]" />
            </div>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${collegeLandingInstance}">
            <div class="errors">
                <g:renderErrors bean="${collegeLandingInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form action="save"  enctype="multipart/form-data">
                <g:hiddenField name="logoBaseName" value="tmp" />
                <g:hiddenField name="logoFileLoc" value="tmp" />
                <div class="dialog">
                    <table>
                        <tbody>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="name"><g:message code="collegeLanding.name.label" default="Name" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: collegeLandingInstance, field: 'name', 'errors')}">
                                    <g:textField name="name" value="${collegeLandingInstance?.name}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="address"><g:message code="collegeLanding.address.label" default="Address" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: collegeLandingInstance, field: 'address', 'errors')}">
                                    <g:textField name="address" value="${collegeLandingInstance?.address}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="displayName"><g:message code="collegeLanding.displayName.label" default="Display Name" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: collegeLandingInstance, field: 'displayName', 'errors')}">
                                    <g:textField name="displayName" value="${collegeLandingInstance?.displayName}" />
                                </td>
                            </tr>


                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="logoFile">College Logo</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: collegeLandingInstance, field: 'logoBaseName', 'errors')}">
                                    <input id="logoFile" type="file" style="width:250px;" name="logoFile"/>
                                </td>
                            </tr>

                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="primaryBGColor"><g:message code="collegeLanding.primaryBGColor.label" default="Primary BGColor" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: collegeLandingInstance, field: 'primaryBGColor', 'errors')}">
                                    <g:textField name="primaryBGColor" value="${collegeLandingInstance?.primaryBGColor}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="primaryFGColor"><g:message code="collegeLanding.primaryFGColor.label" default="Primary FGColor" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: collegeLandingInstance, field: 'primaryFGColor', 'errors')}">
                                    <g:textField name="primaryFGColor" value="${collegeLandingInstance?.primaryFGColor}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="secondaryBGColor"><g:message code="collegeLanding.secondaryBGColor.label" default="Secondary BGColor" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: collegeLandingInstance, field: 'secondaryBGColor', 'errors')}">
                                    <g:textField name="secondaryBGColor" value="${collegeLandingInstance?.secondaryBGColor}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="secondaryFGColor"><g:message code="collegeLanding.secondaryFGColor.label" default="Secondary FGColor" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: collegeLandingInstance, field: 'secondaryFGColor', 'errors')}">
                                    <g:textField name="secondaryFGColor" value="${collegeLandingInstance?.secondaryFGColor}" />
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
<p:renderDependantJavascript/>
</html>
