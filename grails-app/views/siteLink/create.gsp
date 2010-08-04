<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN"
    "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head>
  <g:set var="title" value="Create SiteLink Feed"/>
  <g:render template="/header"/>

  <script type="text/javascript">
    //<![CDATA[
    //]]>
  </script>

</head>
<body>
<div id="body">
<g:render template="/topnav"/>
<div id="stcontent">
  <g:render template="/logo_bar"/>
  <div class="buttons">
    <span class="button"><a href="${createLink(controller:'admin', action:'index')}">Menu</a></span>
    <span class="button"><g:link action="list">List SiteLink Feeds</g:link></span>
  </div>
  <div class="body">

    <div class="price_options checkout_header white">
      Create SiteLink Feed
    </div>

    <g:if test="${flash.message}">
      <div class="message">${flash.message}</div>
    </g:if>
    <g:hasErrors bean="${siteLinkInstance}">
      <div class="errors">
        <g:renderErrors bean="${siteLinkInstance}" as="list"/>
      </div>
    </g:hasErrors>
    <g:form action="save" method="post">

      <div class="formInstructions">
        Create a SiteLink Feed - this will create the feed and do the initial load.  Be patient, it can take 10 minutes
        to load the data in for the first time.
      </div>

      <div class="checkout_section_header">
        Manager
      </div>

      <div class="formInstructions">
        This should be a user created with ROLE_MANAGER privileges.  This user will have the rights to assign other
        users on this feed.
      </div>

      <div class="checkout_fields">
        <div style="width:300px;" class="checkout_value ${hasErrors(bean: siteLinkInstance, field: 'manager', 'errors')}">
          <g:select name="manager.id" style="width:280px;" from="${com.storitz.UserRole.getUsersByRoleName('ROLE_MANAGER')}" optionKey="id" optionValue="username" value="${siteLinkInstance?.manager?.username}" noSelection="['null': '']"/>
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

      <div class="buttons">
        <span class="button"><g:submitButton name="create" class="save" value="${message(code: 'default.button.create.label', default: 'Create')}"/></span>
      </div>
    </g:form>
  </div>
</div>
</div>
</body>
</html>
