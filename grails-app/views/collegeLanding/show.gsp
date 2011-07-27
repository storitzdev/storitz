<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="org.codehaus.groovy.grails.commons.ConfigurationHolder; com.storitz.CollegeLanding" %>
<html>
    <head>
        <g:set var="entityName" value="${message(code: 'collegeLanding.label', default: 'CollegeLanding')}" />
        <title><g:message code="default.show.label" args="[entityName]" /></title>
    </head>
    <body id="body">
    <div class="buttons">
        <span class="button"><a href="${createLink(controller: 'admin', action: 'index')}">Menu</a></span>
        <span class="button"><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></span>
        <span class="button"><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></span>
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
                            <td valign="top" class="name"><g:message code="collegeLanding.id.label" default="Id" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: collegeLandingInstance, field: "id")}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="collegeLanding.name.label" default="Name" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: collegeLandingInstance, field: "name")}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="collegeLanding.address.label" default="Address" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: collegeLandingInstance, field: "address")}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="collegeLanding.displayName.label" default="Display Name" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: collegeLandingInstance, field: "displayName")}</td>
                            
                        </tr>

                        <tr class="prop">
                            <td valign="top" class="name">Logo</td>
                            <td valign="top" class="value"><img src="${resource(file: collegeLandingInstance.logoSrc())}" alt="logo"/></td>
                        </tr>

                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="collegeLanding.logoBaseName.label" default="Logo Base Name" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: collegeLandingInstance, field: "logoBaseName")}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="collegeLanding.logoFileLoc.label" default="Logo File Loc" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: collegeLandingInstance, field: "logoFileLoc")}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="collegeLanding.primaryBGColor.label" default="Primary BGColor" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: collegeLandingInstance, field: "primaryBGColor")}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="collegeLanding.primaryFGColor.label" default="Primary FGColor" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: collegeLandingInstance, field: "primaryFGColor")}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="collegeLanding.secondaryBGColor.label" default="Secondary BGColor" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: collegeLandingInstance, field: "secondaryBGColor")}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="collegeLanding.secondaryFGColor.label" default="Secondary FGColor" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: collegeLandingInstance, field: "secondaryFGColor")}</td>
                            
                        </tr>

                    <tr class="prop">
                        <td valign="top" class="name"><g:message code="collegeLanding.url.label" default="URL" /></td>

                        <td valign="top" class="value">${ConfigurationHolder.config.grails.serverURL}/college/${fieldValue(bean: collegeLandingInstance, field: "name").toString().toLowerCase()}</td>

                    </tr>

                    
                    </tbody>
                </table>
            </div>
            <div class="buttons">
                <g:form>
                    <g:hiddenField name="id" value="${collegeLandingInstance?.id}" />
                    <span class="button"><g:actionSubmit class="edit" action="edit" value="${message(code: 'default.button.edit.label', default: 'Edit')}" /></span>
                    <span class="button"><g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" /></span>
                </g:form>
            </div>
        </div>
    </body>
</html>
