<%@ page import="com.storitz.UserRole; com.storitz.StorageSite" %>



<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head>
  <g:set var="title" value="Edit CenterShift Feed" scope="request"/>
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
      <span class="button"><a href="${createLink(controller: 'admin', action: 'index')}">Admin</a></span>
      <span class="button"><g:link action="list">List CenterShift Feeds</g:link></span>
      <span class="button"><g:link action="create">Create CenterShift Feed</g:link></span>
    </div>
    <div class="body">

      <div class="price_options checkout_header white">
        Edit CenterShift Feed
      </div>

      <g:if test="${flash.message}">
        <div class="message">${flash.message}</div>
      </g:if>
      <g:hasErrors bean="${cshiftInstance}">
        <div class="errors">
          <g:renderErrors bean="${cshiftInstance}" as="list"/>
        </div>
      </g:hasErrors>
      <g:form method="post">
        <g:hiddenField name="id" value="${cshiftInstance?.id}"/>
        <g:hiddenField name="version" value="${cshiftInstance?.version}"/>

        <div class="checkout_section_header">
          Manager
        </div>

        <div class="formInstructions">
          This should be a user created with ROLE_MANAGER privileges.  This user will have the rights to assign other
          users on this feed.
        </div>

        <div class="checkout_fields">
          <div style="width:300px;" class="checkout_value ${hasErrors(bean: cshiftInstance, field: 'manager', 'errors')}">
            <g:select name="manager.id" style="width:280px;" from="${com.storitz.UserRole.getUsersByRoleName('ROLE_MANAGER')}" optionKey="id" optionValue="username" value="${cshiftInstance?.manager?.id}" noSelection="['null': '']"/>
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
            <g:select id="cshiftVersion" style="width:150px;" name="cshiftVersion" from="${storitz.constants.CenterShiftVersion?.list()}" value="${cshiftInstance?.cshiftVersion}" optionValue="display"/>
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
            <g:select id="location" style="width:200px;" name="location" from="${storitz.constants.CenterShiftLocations?.list()}" value="${cshiftInstance?.location}" optionValue="display"/>
          </div>
          <div style="clear:both;"></div>
        </div>

        <div class="checkout_labels">
          <div class="checkout_name" style="width:200px;">
            <label for="userName">User Name</label>
          </div>
          <div class="checkout_name" style="width:200px;">
            <label for="pin">PIN</label>
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

        <div class="checkout_fields">
          <div style="width:300px;" class="checkout_value ${hasErrors(bean: cshiftInstance, field: 'address1', 'errors')}">
            <g:textField id="address1" name="address1" style="width: 280px;" value="${cshiftInstance?.address1}"/>
          </div>
          <div style="clear:both;"></div>
        </div>

        <div class="checkout_labels">
          <div class="checkout_name" style="width:300px;">
            <label for="address1">Address Line 1</label>
          </div>
          <div style="clear:both;"></div>
        </div>

        <div class="checkout_fields">
          <div style="width:300px;" class="checkout_value ${hasErrors(bean: cshiftInstance, field: 'address2', 'errors')}">
            <g:textField id="address2" name="address2" style="width: 280px;" value="${cshiftInstance?.address2}"/>
          </div>
          <div style="clear:both;"></div>
        </div>

        <div class="checkout_labels">
          <div class="checkout_name" style="width:300px;">
            <label for="address2">Address Line 2</label>
          </div>
          <div style="clear:both;"></div>
        </div>

        <div class="checkout_fields">
          <div style="width:300px;" class="checkout_value ${hasErrors(bean: cshiftInstance, field: 'city', 'errors')}">
            <g:textField id="city" name="city" style="width: 280px;" value="${cshiftInstance?.city}"/>
          </div>
          <div style="width:100px;" class="checkout_value ${hasErrors(bean: cshiftInstance, field: 'state', 'errors')}">
            <g:select name="state" id="state" class="validate-selection" style="width:80px;" from="${storitz.constants.State.list()}" value="${cshiftInstance?.state}" optionValue="value"/>
          </div>
          <div style="width:120px;" class="checkout_value ${hasErrors(bean: cshiftInstance, field: 'zipcode', 'errors')}">
            <g:textField id="zipcode" name="zipcode" style="width: 100px;" value="${cshiftInstance?.zipcode}"/>
          </div>

          <div style="clear:both;"></div>
        </div>

        <div class="checkout_labels">
          <div class="checkout_name" style="width:300px;">
            <label for="city">City</label>
          </div>
          <div class="checkout_name" style="width:100px;">
            <label for="state">State</label>
          </div>
          <div class="checkout_name" style="width:120px;">
            <label for="zipcode">Zip Code</label>
          </div>
          <div style="clear:both;height:10px;"></div>
        </div>

          <div class="checkout_fields">
            <div style="width:300px;" class="checkout_value ${hasErrors(bean: cshiftInstance, field: 'reservationMoveInDescription', 'errors')}">
              <fckeditor:config CustomConfigurationsPath="${storitz.javascriptLink(src:'fckstoritz')}"/>
              <fckeditor:editor
                      name="reservationMoveInDescription"
                      width="650"
                      height="300"
                      toolbar="Storitz">
                ${cshiftInstance?.reservationMoveInDescription}
              </fckeditor:editor>
            </div>
            <div style="clear:both;"></div>
          </div>

          <div class="checkout_labels">
            <div class="checkout_name" stype="width:300px">
              <label for="reservationMoveInDescription">Reservation Move-In Description</label>
            </div>
            <div style="clear:both;"></div>
          </div>

        <div class="checkout_fields">
          <div style="width:300px;" class="checkout_value ${hasErrors(bean: cshiftInstance, field: 'transactionBoxLink', 'errors')}">
            <g:textField id="transactionBoxLink" name="transactionBoxLink" style="width: 280px;" value="${cshiftInstance?.transactionBoxLink}"/>
          </div>
          <div style="clear:both;"></div>
        </div>

        <div class="checkout_labels">
          <div class="checkout_name" stype="width:300px">
            <label for="transactionBoxLink">Transaction Box Link</label>
          </div>
          <div style="clear:both;"></div>
        </div>

        <div class="checkout_fields">
          <div style="width:300px;" class="checkout_value ${hasErrors(bean: cshiftInstance, field: 'transactionBoxBody', 'errors')}">
            <fckeditor:config CustomConfigurationsPath="${storitz.javascriptLink(src:'fckstoritz')}"/>
            <fckeditor:editor
                    name="transactionBoxBody"
                    width="650"
                    height="300"
                    toolbar="Storitz">
              ${cshiftInstance?.transactionBoxBody}
            </fckeditor:editor>
          </div>
          <div style="clear:both;"></div>
        </div>

        <div class="checkout_labels">
          <div class="checkout_name" stype="width:300px">
            <label for="transactionBoxBody">Transaction Box Body</label>
          </div>
          <div style="clear:both;"></div>
        </div>

        <div class="checkout_section_header">
          Commission Schedule
        </div>

        <div class="checkout_fields">
          <div style="width:400px;" class="checkout_value ${hasErrors(bean: cshiftInstance, field: 'commissionSchedule', 'errors')}">
            <g:select name="commissionSchedule.id" id="commissionSchedule" class="validate-selection" style="width:200px;" from="${commissionScheduleList}" value="${cshiftInstance?.commissionSchedule}" optionKey="id" optionValue="scheduleName"/>
          </div>
          <div style="clear:both;"></div>
        </div>

        <div class="checkout_labels">
          <div class="checkout_name" style="width:400px;">
            <label for="commissionSchedule">Commission Schedule</label>
          </div>
          <div style="clear:both;"></div>
        </div>

        <div class="buttons">
          <span class="button"><g:actionSubmit class="save" action="update" value="${message(code: 'default.button.update.label', default: 'Update')}"/></span>
          <span class="button"><g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');"/></span>
        </div>
      </g:form>
      <g:uploadForm action="uploadLogo" method="post" id="${cshiftInstance?.id}">
        <div class="checkout_section_header">
          Upload Logo
        </div>
        <div class="formInstructions">
          Uploading a logo here will apply it to all the sites that belong to this feed.  Be careful with feeds that may have more than one brand.
        </div>

        <div class="checkout_fields">
          <div style="width:400px;" class="checkout_value">
            <input type="file" name="logoFile" id="logo"/>
          </div>
          <div style="clear:both;"></div>
        </div>
        <div class="checkout_labels">
          <div class="checkout_name" style="width:400px;">
            <label for="logo">Logo</label>
          </div>
          <div style="clear:both;"></div>
        </div>
        <div class="buttons">
          <span class="button"><input class="save" type="submit" value="Upload"/></span>
        </div>
      </g:uploadForm>

    </div>
  </div>
</div>
</body>
<p:renderDependantJavascript/>
</html>
