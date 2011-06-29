<%@ page import="com.storitz.OrganizerContest" %>
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN"
    "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'organizerContest.label', default: 'OrganizerContest')}" />
        <title><g:message code="default.show.label" args="[entityName]" /></title>
        <meta name="keywords" content="self-storage, household storage, self storage, storage unit, self storage unit, moving and  relocation storage, storage pods, container storage, compare self storage, storage comparison, lowest storage rent, best storage prices, storage units for rent,  storage unit rental, self storage, self-storage search engine, self-storage directory, self storage facility,  find self storage, mini storage, Military storage, College student storage, University storage, Senior citizen storage"/>
        <p:favicon src="images/favicon"/>
        <p:css name='header_bundled'/>
        <script src="http://www.google.com/jsapi" type="text/javascript"></script>
        <p:javascript src='header_all'/>
    </head>
    <body id="body">

    <g:render template="/logo_bar"/>
    <div class="buttons">
        <span class="button"><a href="${createLink(controller: 'admin', action: 'index')}">Menu</a></span>
        <span class="button"><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></span>
        <!--
        <span class="button"><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></span>
        -->
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
                            <td valign="top" class="name"><g:message code="organizerContest.id.label" default="Id" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: organizerContestInstance, field: "id")}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="organizerContest.firstName.label" default="First Name" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: organizerContestInstance, field: "firstName")}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="organizerContest.lastName.label" default="Last Name" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: organizerContestInstance, field: "lastName")}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="organizerContest.phone.label" default="Phone" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: organizerContestInstance, field: "phone")}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="organizerContest.email.label" default="Email" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: organizerContestInstance, field: "email")}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="organizerContest.twitterName.label" default="Twitter Name" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: organizerContestInstance, field: "twitterName")}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="organizerContest.address1.label" default="Address1" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: organizerContestInstance, field: "address1")}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="organizerContest.address2.label" default="Address2" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: organizerContestInstance, field: "address2")}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="organizerContest.city.label" default="City" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: organizerContestInstance, field: "city")}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="organizerContest.state.label" default="State" /></td>
                            
                            <td valign="top" class="value">${organizerContestInstance?.state?.encodeAsHTML()}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="organizerContest.zipcode.label" default="Zipcode" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: organizerContestInstance, field: "zipcode")}</td>
                            
                        </tr>
                    
                    <tr class="prop">
                        <td valign="top" class="name"><g:message code="organizerContest.zipcode2.label" default="Zipcode2" /></td>

                        <td valign="top" class="value">${fieldValue(bean: organizerContestInstance, field: "zipcode2")}</td>

                    </tr>

                         <tr class="prop">
                            <td valign="top" class="name"><g:message code="organizerContest.referralSource.label" default="Referral Source" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: organizerContestInstance, field: "referralSource")}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="organizerContest.essayWhyStorage.label" default="Essay Why Storage" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: organizerContestInstance, field: "essayWhyStorage")}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="organizerContest.readTermsAndConditions.label" default="Read Terms And Conditions" /></td>
                            
                            <td valign="top" class="value"><g:formatBoolean boolean="${organizerContestInstance?.readTermsAndConditions}" /></td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="organizerContest.sendMeUpdates.label" default="Send Me Updates" /></td>
                            
                            <td valign="top" class="value"><g:formatBoolean boolean="${organizerContestInstance?.sendMeUpdates}" /></td>
                            
                        </tr>
                    
                    </tbody>
                </table>
            </div>
            <div class="buttons">
                <g:form>
                    <g:hiddenField name="id" value="${organizerContestInstance?.id}" />
                    <span class="button"><g:actionSubmit class="edit" action="edit" value="${message(code: 'default.button.edit.label', default: 'Edit')}" /></span>
                    <span class="button"><g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" /></span>
                </g:form>
            </div>
        </div>
    </body>
</html>
