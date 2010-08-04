<%@ page import="com.storitz.UserRole" %>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head>
  <g:set var="title" value="Create Storage Site"/>
  <g:render template="/header"/>

  <script type="text/javascript">
    //<![CDATA[

    google.load("jquery", "1.4.2");

    google.setOnLoadCallback(function() {
      jQuery.noConflict();

      setupTimePickers();
    });

    //]]>
  </script>
  <g:javascript src="jquery.MetaDeta.js"/>
  <g:javascript src="jquery.MultiFile.js"/>

</head>
<body>
<div id="body">
  <g:render template="/topnav"/>
  <div id="stcontent">
    <g:render template="/logo_bar" />

    <div style="clear: both;height: 10px"></div>
    <div class="buttons">
      <span class="button"><a href="${createLink(controller: 'admin', action: 'index')}">Menu</a></span>
      <span class="button"><g:link action="list">List Agreements</g:link></span>
      <sec:ifAnyGranted roles="ROLE_ADMIN">
        <span class="button"><g:link action="create">Create Rental/Lease Agreement</g:link></span>
      </sec:ifAnyGranted>

    </div>
    <div style="clear: both;height: 10px"></div>

    <div class="body">

      <div class="price_options checkout_header white">
        Edit Rental Agreement
      </div>

      <div class="formInstructions">
        If you wish to change the PDF form, delete this agreement and create a new one.
      </div>

      <g:if test="${flash.message}">
        <div class="message">${flash.message}</div>
      </g:if>
      <g:hasErrors bean="${storageSiteInstance}">
        <div class="errors">
          <g:renderErrors bean="${rentalAgreementInstance}" as="list"/>
        </div>
      </g:hasErrors>

      <g:uploadForm method="post" id="${rentalAgreementInstance?.id}">

        <div class="checkout_section_header">
          Agreement Name
        </div>

        <div class="formInstructions">
          Give this agreement a name so we can distinguish between them - for example CA Lease Agreement
        </div>

        <div class="checkout_fields">
          <div style="width:300px;" class="checkout_value ${hasErrors(bean: rentalAgreementInstance, field: 'title', 'errors')}">
            <g:textField id="title" name="title" style="width: 280px;" value="${rentalAgreementInstance?.title}" />
          </div>
          <div style="clear:both;"></div>
        </div>

        <div class="checkout_labels">
          <div class="checkout_name" style="width:300px;">
            <label for="title">Title</label>
          </div>
          <div style="clear:both;"></div>
        </div>

        <sec:ifAnyGranted roles="ROLE_ADMIN">
        <div class="checkout_section_header">
          Agreement Owner/Manager
        </div>
        <div class="formInstructions">
          This ADMIN only feature allows Storitz to reassign the managerial owner of an agreement.  This can be used if a site is purchase
          and is now managed by a different operator.
        </div>

        <div class="checkout_fields">
          <div style="width:250px;" class="checkout_value ${hasErrors(bean: rentalAgreementInstance, field: 'manager', 'errors')}">
            <g:select id="manager" name="manager.id" style="width:250px;" from="${UserRole.getUsersByRoleName('ROLE_MANAGER')}" optionValue="username" optionKey="id" value="${rentalAgreementInstance.owner?.id}" noSelection="['null': '']"/>
          </div>
          <div style="clear:both;"></div>
        </div>

        <div class="checkout_labels">
          <div class="checkout_name" style="width:250px;">
            <label for="manager">Manager/Owner of Agreement</label>
          </div>
          <div style="clear:both;"></div>
        </div>
        </sec:ifAnyGranted>
        
        <div class="buttons">
          <span class="button"><g:actionSubmit action="update" value="${message(code: 'default.button.update.label', default: 'Update')}"/></span>
        </div>
      </g:uploadForm>
