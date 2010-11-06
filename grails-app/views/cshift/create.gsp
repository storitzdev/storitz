<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN"
    "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head>
  <g:set var="title" value="Create CenterShift Feed" scope="request"/>
  <g:render template="/header_admin"/>
  <script type="text/javascript">
    //<![CDATA[
    $(document).ready(function() {
      jQuery.noConflict();

      setupForm();
    });

    function setupForm() {
      jQuery('#cshiftVersion').change(function(event) {
        jQuery('#orgId_label').toggle('blind', {}, 500);
        jQuery('#orgId').toggle('blind', {}, 500);
      });
    }
    //]]>
  </script>

</head>
<body>
<div id="body">
<g:render template="/topnav"/>
<div class="stcontent">
  <g:render template="/logo_bar"/>
  <div class="buttons">
    <span class="button"><a href="${createLink(controller:'admin', action:'index')}">Menu</a></span>
    <span class="button"><g:link action="list">List CenterShift Feeds</g:link></span>
  </div>
  <div class="body">

    <div class="price_options checkout_header white">
      Create CenterShift Feed
    </div>

    <g:if test="${flash.message}">
      <div class="message">${flash.message}</div>
    </g:if>
    <g:hasErrors bean="${cshiftInstance}">
      <div class="errors">
        <g:renderErrors bean="${cshiftInstance}" as="list"/>
      </div>
    </g:hasErrors>
    <g:form action="save" method="post">

      <div class="formInstructions">
        Create a CenterShift Feed - this will create the feed and do the initial load.  Be patient, it can take 10 minutes
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
        <div style="width:300px;" class="checkout_value ${hasErrors(bean: cshiftInstance, field: 'manager', 'errors')}">
          <g:select name="manager.id" style="width:280px;" from="${com.storitz.UserRole.getUsersByRoleName('ROLE_MANAGER')}" optionKey="id" optionValue="username" value="${cshiftInstance?.manager?.username}" noSelection="['null': '']"/>
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
        CenterShift Account Information
      </div>

      <div class="formInstructions">
        This information should come from CenterShift and the operator
      </div>

      <div class="checkout_fields">
        <div style="width:200px;" class="checkout_value ${hasErrors(bean: cshiftInstance, field: 'cshiftVersion', 'errors')}">
          <g:select id="cshiftVersion" style="width:150px;" name="cshiftVersion" from="${storitz.constants.CenterShiftVersion?.list()}" value="${cshiftInstance?.cshiftVersion}" optionValue="display"  />
        </div>
        <div id="orgId" style="width:200px;display:none;" class="checkout_value ${hasErrors(bean: cshiftInstance, field: 'orgId', 'errors')}">
          <g:textField name="orgId" style="width:180px;" value="${cshiftInstance?.orgId}"/>
        </div>
        <div style="clear:both;"></div>
      </div>

      <div class="checkout_labels">
        <div class="checkout_name" style="width:200px;">
          <label for="cshiftVersion">CenterShift Version</label>
        </div>
        <div id="orgId_label" class="checkout_name" style="width:200px;display:none;">
          <label for="orgId">Organization ID</label>
        </div>
        <div style="clear:both;"></div>
      </div>

      <div class="checkout_fields">
        <div style="width:200px;" class="checkout_value ${hasErrors(bean: cshiftInstance, field: 'userName', 'errors')}">
          <g:textField name="userName" style="width:180px;" value="${cshiftInstance?.userName}"/>
        </div>
        <div style="width:200px;" class="checkout_value ${hasErrors(bean: cshiftInstance, field: 'pin', 'errors')}">
          <g:textField name="pin" style="width:180px;" value="${cshiftInstance?.pin}"/>
        </div>
        <div style="width:200px;" class="checkout_value ${hasErrors(bean: cshiftInstance, field: 'location', 'errors')}">
          <g:select id="location" style="width:200px;" name="location" from="${storitz.constants.CenterShiftLocations?.list()}" value="${cshiftInstance?.location}" optionValue="display"  />
        </div>
        <div style="clear:both;"></div>
      </div>

      <div class="checkout_labels">
        <div class="checkout_name" style="width:200px;">
          <label for="userName">User Name</label>
        </div>
        <div class="checkout_name" style="width:200px;">
          <label for="pin">Password/PIN</label>
        </div>
        <div class="checkout_name" style="width:200px;">
          <label for="location">Location</label>
        </div>
        <div style="clear:both;"></div>
      </div>

      <div class="checkout_section_header">
        Operator Information
      </div>

      <div class="checkout_fields">
        <div style="width:400px;" class="checkout_value ${hasErrors(bean: cshiftInstance, field: 'operatorName', 'errors')}">
          <g:textField name="operatorName" id="operatorName" style="width:380px;" value="${cshiftInstance?.operatorName}"/>
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
        <span class="button"><g:submitButton name="create" class="save" value="${message(code: 'default.button.create.label', default: 'Create')}"/></span>
      </div>
    </g:form>
  </div>
</div>
</div>
</body>
</html>
