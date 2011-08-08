<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="com.storitz.OrganizerContest" %>
<html>
    <head>
         <g:set var="entityName" value="${message(code: 'organizerContest.label', default: 'OrganizerContest')}" />
        <title><g:message code="default.list.label" args="[entityName]" /></title>
    </head>
    <body>
    <div id="body">
        <div class="stcontent">
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

        <p> Enter the video ID of the youtube video you wish to show:</p>

        <g:form controller="organizerContest" action="saveVideoId" method="post">
            <g:textField name="videoId" id="videoId" value="${videoId}"/>
            <span class="button"><g:actionSubmit class="save" action="saveVideoId" value="Update"/></span>
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
       </div>
    </div>
    </body>
</html>
