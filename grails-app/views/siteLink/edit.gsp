<%@ page import="com.storitz.UserRole; com.storitz.StorageSite" %>



<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head>
  <g:set var="title" value="Edit SiteLink Feed" scope="request"/>
  <g:render template="/header"/>

  <script type="text/javascript">
    //<![CDATA[
    //]]>
  </script>

</head>
<body>
<div id="body">
<g:render template="/topnav"/>
<div class="stcontent">
  <g:render template="/logo_bar"/>
  <div class="buttons">
    <span class="button"><a href="${createLink(controller:'admin', action:'index')}">Admin</a></span>
    <span class="button"><g:link action="list">List SiteLink Feeds</g:link></span>
    <span class="button"><g:link action="create">Create SiteLink Feed</g:link></span>
  </div>
  <div class="body">

    <div class="price_options checkout_header white">
      Edit SiteLink Feed
    </div>

    <g:if test="${flash.message}">
      <div class="message">${flash.message}</div>
    </g:if>
    <g:hasErrors bean="${siteLinkInstance}">
      <div class="errors">
        <g:renderErrors bean="${siteLinkInstance}" as="list"/>
      </div>
    </g:hasErrors>
    <g:form method="post">
      <g:hiddenField name="id" value="${siteLinkInstance?.id}"/>
      <g:hiddenField name="version" value="${siteLinkInstance?.version}"/>

      <div class="checkout_section_header">
        Manager
      </div>

      <div class="formInstructions">
        This should be a user created with ROLE_MANAGER privileges.  This user will have the rights to assign other
        users on this feed.
      </div>

      <div class="checkout_fields">
        <div style="width:300px;" class="checkout_value ${hasErrors(bean: siteLinkInstance, field: 'manager', 'errors')}">
          <g:select name="manager.id" style="width:280px;" from="${com.storitz.UserRole.getUsersByRoleName('ROLE_MANAGER')}" optionKey="id" optionValue="username" value="${siteLinkInstance?.manager?.id}" noSelection="['null': '']"/>
        </div>
        <div style="clear:both;"></div>
      </div>

      <div class="checkout_labels">
        <div class="checkout_name" style="width:300px;">
          <label for="manager.id">Manager</label>
        </div>
        <div style="clear:both;"></div>
      </div>

      <div class="checkout_section_header">
        SiteLink Account Information
      </div>

      <div class="formInstructions">
        This information should come from SiteLink and the operator
      </div>

      <div class="checkout_fields">
        <div style="width:200px;" class="checkout_value ${hasErrors(bean: siteLinkInstance, field: 'corpCode', 'errors')}">
          <g:textField name="corpCode" style="width:180px;" value="${siteLinkInstance?.corpCode}"/>
        </div>
        <div style="width:200px;" class="checkout_value ${hasErrors(bean: siteLinkInstance, field: 'userName', 'errors')}">
          <g:textField name="userName" style="width:180px;" value="${siteLinkInstance?.userName}"/>
        </div>
        <div style="width:200px;" class="checkout_value ${hasErrors(bean: siteLinkInstance, field: 'password', 'errors')}">
          <g:textField name="password" style="width:180px;" value="${siteLinkInstance?.password}"/>
        </div>
        <div style="clear:both;"></div>
      </div>

      <div class="checkout_labels">
        <div class="checkout_name" style="width:200px;">
          <label for="corpCode">Corp Code</label>
        </div>
        <div class="checkout_name" style="width:200px;">
          <label for="corpCode">User Name</label>
        </div>
        <div class="checkout_name" style="width:200px;">
          <label for="corpCode">Password</label>
        </div>
        <div style="clear:both;"></div>
      </div>

      <div class="checkout_section_header">
        Operator Information
      </div>

      <div class="checkout_fields">
        <div style="width:400px;" class="checkout_value ${hasErrors(bean: siteLinkInstance, field: 'operatorName', 'errors')}">
          <g:textField name="operatorName" id="operatorName" style="width:380px;" value="${siteLinkInstance?.operatorName}"/>
        </div>
        <div style="clear:both;"></div>
      </div>

      <div class="checkout_labels">
        <div class="checkout_name" style="width:400px;">
          <label for="operatorName">Operator Name</label>
        </div>
        <div style="clear:both;"></div>
      </div>

      <div class="buttons">
        <span class="button"><g:actionSubmit class="save" action="update" value="${message(code: 'default.button.update.label', default: 'Update')}"/></span>
        <span class="button"><g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');"/></span>
      </div>
    </g:form>
  </div>
</div>
</div>
</body>
<p:renderDependantJavascript />
</html>
