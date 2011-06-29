<%@ page import="com.storitz.OrganizerContest" %>
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN"
    "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'organizerContest.label', default: 'OrganizerContest')}" />
        <title><g:message code="default.list.label" args="[entityName]" /></title>
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

        <g:if test="${enabled}">
            <span class="button"><a href="${createLink(controller: 'organizerContest', action: 'disable')}">Disable</a></span>
        </g:if>
        <g:else>
            <span class="button"><a href="${createLink(controller: 'organizerContest', action: 'enable')}">Enable</a></span>
        </g:else>

        <g:if test="${active}">
            <span class="button"><a href="${createLink(controller: 'organizerContest', action: 'deactivate')}">Deactivate</a></span>
        </g:if>
        <g:else>
            <span class="button"><a href="${createLink(controller: 'organizerContest', action: 'activate')}">Activate</a></span>
        </g:else>

       <!--
        <span class="button"><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></span>
        -->
    </div>

    <div>
        <p> New Contest Entries will be sent to the following email address:</p>

        <g:form controller="organizerContest" action="saveToEmailAddress" method="post">
            <g:textField name="toEmailAddress" id="toEmailAddress" value="${toEmailAddress}"></g:textField>
            <span class="button"><g:actionSubmit class="save" action="saveToEmailAddress" value="Update" /></span>
        </g:form>

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
                        
                            <g:sortableColumn property="id" title="${message(code: 'organizerContest.id.label', default: 'Id')}" />
                        
                            <g:sortableColumn property="firstName" title="${message(code: 'organizerContest.firstName.label', default: 'First Name')}" />
                        
                            <g:sortableColumn property="lastName" title="${message(code: 'organizerContest.lastName.label', default: 'Last Name')}" />
                        
                            <g:sortableColumn property="phone" title="${message(code: 'organizerContest.phone.label', default: 'Phone')}" />
                        
                            <g:sortableColumn property="email" title="${message(code: 'organizerContest.email.label', default: 'Email')}" />
                        
                            <g:sortableColumn property="twitterName" title="${message(code: 'organizerContest.twitterName.label', default: 'Twitter Name')}" />
                        
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${organizerContestInstanceList}" status="i" var="organizerContestInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td><g:link action="show" id="${organizerContestInstance.id}">${fieldValue(bean: organizerContestInstance, field: "id")}</g:link></td>
                        
                            <td>${fieldValue(bean: organizerContestInstance, field: "firstName")}</td>
                        
                            <td>${fieldValue(bean: organizerContestInstance, field: "lastName")}</td>
                        
                            <td>${fieldValue(bean: organizerContestInstance, field: "phone")}</td>
                        
                            <td>${fieldValue(bean: organizerContestInstance, field: "email")}</td>
                        
                            <td>${fieldValue(bean: organizerContestInstance, field: "twitterName")}</td>
                        
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${organizerContestInstanceTotal}" />
            </div>
        </div>
    </body>
</html>
