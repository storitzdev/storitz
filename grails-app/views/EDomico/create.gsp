<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN"
    "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head>
  <g:set var="title" value="Create EDomico Feed" scope="request"/>
  <g:render template="/header_admin"/>
  <script type="text/javascript">
    //<![CDATA[
    //]]>
  </script>

</head>
<body>
<div id="body">

  <div class="stcontent">
    <g:render template="/logo_bar"/>
    <div class="buttons">
      <span class="button"><a href="${createLink(controller: 'admin', action: 'index')}">Menu</a></span>
      <span class="button"><g:link action="list">List EDomico Feeds</g:link></span>
    </div>
    <div class="body">

      <div class="price_options checkout_header white">
        Create EDomico Feed
      </div>

      <g:if test="${flash.message}">
        <div class="message">${flash.message}</div>
      </g:if>
      <g:hasErrors bean="${edomicoInstance}">
        <div class="errors">
          <g:renderErrors bean="${edomicoInstance}" as="list"/>
        </div>
      </g:hasErrors>
      <g:form action="save" method="post">

        <div class="formInstructions">
          Create a EDomico Feed - this will create the feed and do the initial load.  Be patient, it can take 10 minutes
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
          <div style="width:300px;" class="checkout_value ${hasErrors(bean: edomicoInstance, field: 'manager', 'errors')}">
            <g:select name="manager.id" style="width:280px;" from="${com.storitz.UserRole.getUsersByRoleName('ROLE_MANAGER')}" optionKey="id" optionValue="username" value="${edomicoInstance?.manager?.username}" noSelection="['null': '']"/>
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
          EDomico Account Information
        </div>

        <div class="formInstructions">
          This information should come from EDomico and the operator
        </div>

          <div class="checkout_fields">
              <div style="width:300px;" class="checkout_value ${hasErrors(bean: edomicoInstance, field: 'edomicoClientID', 'errors')}">
                  <g:textField id="edomicoClientID" name="edomicoClientID" style="width: 280px;" value="${edomicoInstance?.edomicoClientID}"/>
              </div>
              <div style="clear:both;"></div>
          </div>

          <div class="checkout_labels">
              <div class="checkout_name" style="width:300px;">
                  <label for="edomicoClientID">Client ID</label>
              </div>
              <div style="clear:both;"></div>
          </div>

          <div class="checkout_fields">
              <div style="width:300px;" class="checkout_value ${hasErrors(bean: edomicoInstance, field: 'edomicoWebServicesKey', 'errors')}">
                  <g:textField id="edomicoWebServicesKey" name="edomicoWebServicesKey" style="width: 280px;" value="${edomicoInstance?.edomicoWebServicesKey}"/>
              </div>
              <div style="clear:both;"></div>
          </div>

          <div class="checkout_labels">
              <div class="checkout_name" style="width:300px;">
                  <label for="edomicoWebServicesKey">Web Services Key</label>
              </div>
              <div style="clear:both;"></div>
          </div>

        <div class="checkout_section_header">
          Operator Information
        </div>

        <div class="checkout_fields">
          <div style="width:400px;" class="checkout_value ${hasErrors(bean: edomicoInstance, field: 'operatorName', 'errors')}">
            <g:textField name="operatorName" id="operatorName" style="width:380px;" value="${edomicoInstance?.operatorName}"/>
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
          <div style="width:300px;" class="checkout_value ${hasErrors(bean: edomicoInstance, field: 'address1', 'errors')}">
            <g:textField id="address1" name="address1" style="width: 280px;" value="${edomicoInstance?.address1}"/>
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
          <div style="width:300px;" class="checkout_value ${hasErrors(bean: edomicoInstance, field: 'address2', 'errors')}">
            <g:textField id="address2" name="address2" style="width: 280px;" value="${edomicoInstance?.address2}"/>
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
          <div style="width:300px;" class="checkout_value ${hasErrors(bean: edomicoInstance, field: 'city', 'errors')}">
            <g:textField id="city" name="city" style="width: 280px;" value="${edomicoInstance?.city}"/>
          </div>
          <div style="width:100px;" class="checkout_value ${hasErrors(bean: edomicoInstance, field: 'state', 'errors')}">
            <g:select name="state" id="state" class="validate-selection" style="width:80px;" from="${storitz.constants.State.list()}" value="${edomicoInstance?.state}" optionValue="value"/>
          </div>
          <div style="width:120px;" class="checkout_value ${hasErrors(bean: edomicoInstance, field: 'zipcode', 'errors')}">
            <g:textField id="zipcode" name="zipcode" style="width: 100px;" value="${edomicoInstance?.zipcode}"/>
          </div>

          <div style="clear:both;"></div>
        </div>

        <div class="checkout_labels">
          <div class="checkout_name" style="width:300px;">
            <label for="city">City</label>
          </div>
          <div class="checkout_name" style="width:300px;">
            <label for="state">State</label>
          </div>
          <div class="checkout_name" style="width:120px;">
            <label for="zipcode">Zip Code</label>
          </div>
          <div style="clear:both;"></div>
        </div>

         <div class="checkout_fields">
            <div style="width:300px;" class="checkout_value ${hasErrors(bean: edomicoInstance, field: 'reservationMoveInDescription', 'errors')}">
              <fckeditor:config CustomConfigurationsPath="${storitz.javascriptLink(src:'fckstoritz')}"/>
              <fckeditor:editor
                      name="reservationMoveInDescription"
                      width="650"
                      height="300"
                      toolbar="Storitz">
                ${edomicoInstance?.reservationMoveInDescription}
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
          <div style="width:300px;" class="checkout_value ${hasErrors(bean: edomicoInstance, field: 'transactionBoxLink', 'errors')}">
            <g:textField id="transactionBoxLink" name="transactionBoxLink" style="width: 280px;" value="${edomicoInstance?.transactionBoxLink}"/>
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
          <div style="width:300px;" class="checkout_value ${hasErrors(bean: edomicoInstance, field: 'transactionBoxBody', 'errors')}">
            <fckeditor:config CustomConfigurationsPath="${storitz.javascriptLink(src:'fckstoritz')}"/>
            <fckeditor:editor
                    name="transactionBoxBody"
                    width="650"
                    height="300"
                    toolbar="Storitz">
              ${edomicoInstance?.transactionBoxBody}
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
          <div style="width:400px;" class="checkout_value ${hasErrors(bean: edomicoInstance, field: 'commissionSchedule', 'errors')}">
            <g:select name="commissionSchedule.id" id="commissionSchedule" class="validate-selection" style="width:200px;" from="${commissionScheduleList}" value="${edomicoInstance?.commissionSchedule}" optionKey="id" optionValue="scheduleName"/>
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
          <span class="button"><g:submitButton name="create" class="save" value="${message(code: 'default.button.create.label', default: 'Create')}"/></span>
        </div>
      </g:form>
    </div>
  </div>
</div>
</body>
<p:renderDependantJavascript/>
</html>
