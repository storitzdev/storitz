<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="com.storitz.StorageMart" %>
<html>
<head>
  <g:set var="title" value="Create Storage Mart Feed" scope="request"/>
</head>
<body>
<div id="body">
  <div class="stcontent">
    <div class="buttons">
      <span class="button"><a href="${createLink(controller: 'admin', action: 'index')}">Menu</a></span>
      <span class="button"><g:link action="list">List Storage Mart Feeds</g:link></span>
    </div>
    <div class="body">

      <div class="price_options checkout_header white">
        Create Storage Mart Feed
      </div>

      <g:if test="${flash.message}">
        <div class="message">${flash.message}</div>
      </g:if>
      <g:hasErrors bean="${storageMartInstance}">
        <div class="errors">
          <g:renderErrors bean="${storageMartInstance}" as="list"/>
        </div>
      </g:hasErrors>
      <g:form action="save" method="post">

        <div class="formInstructions">
          Create a Storage Mart Feed - this will create the feed and do the initial load.  Be patient, it can take 10 minutes
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
          <div style="width:300px;" class="checkout_value ${hasErrors(bean: storageMartInstance, field: 'manager', 'errors')}">
            <g:select name="manager.id" style="width:280px;" from="${com.storitz.UserRole.getUsersByRoleName('ROLE_MANAGER')}" optionKey="id" optionValue="username" value="${storageMartInstance?.manager?.username}" noSelection="['null': '']"/>
          </div>
          <div style="clear:both;"></div>
        </div>

        <div class="checkout_labels">
          <div class="checkout_name" style="width:300px;">
            <label for="manager.id">Manager</label>
          </div>
          <div style="clear:both;height: 10px;"></div>
        </div>

        <div class="checkout_section_header">
          Storage Mart Account Information
        </div>

        <div class="formInstructions">
          This information should come from Storage Mart and the operator
        </div>

          <div class="checkout_fields">
              <div style="width:300px;" class="checkout_value ${hasErrors(bean: storageMartInstance, field: 'stmUser', 'errors')}">
                  <g:textField id="stmUser" name="stmUser" style="width: 280px;" value="${storageMartInstance?.stmUser}"/>
              </div>
              <div style="clear:both;"></div>
          </div>

          <div class="checkout_labels">
              <div class="checkout_name" style="width:300px;">
                  <label for="stmUser">Storage Mart User Name</label>
              </div>
              <div style="clear:both;"></div>
          </div>

          <div class="checkout_fields">
              <div style="width:300px;" class="checkout_value ${hasErrors(bean: storageMartInstance, field: 'stmPass', 'errors')}">
                  <g:textField id="stmPass" name="stmPass" style="width: 280px;" value="${storageMartInstance?.stmPass}"/>
              </div>
              <div style="clear:both;"></div>
          </div>

          <div class="checkout_labels">
              <div class="checkout_name" style="width:300px;">
                  <label for="stmPass">Storage Mart Pass Word</label>
              </div>
              <div style="clear:both;"></div>
          </div>

          <div class="checkout_fields">
              <div style="width:300px;" class="checkout_value ${hasErrors(bean: storageMartInstance, field: 'url', 'errors')}">
                  <g:textField id="url" name="url" style="width: 700px;" value="${storageMartInstance?.url}"/>
              </div>
              <div style="clear:both;"></div>
          </div>

          <div class="checkout_labels">
              <div class="checkout_name" style="width:300px;">
                  <label for="url">Storage Mart URL</label>
              </div>
              <div style="clear:both;"></div>
          </div>


        <div class="checkout_section_header">
          Operator Information
        </div>

        <div class="checkout_fields">
          <div style="width:400px;" class="checkout_value ${hasErrors(bean: storageMartInstance, field: 'operatorName', 'errors')}">
            <g:textField name="operatorName" id="operatorName" style="width:380px;" value="${storageMartInstance?.operatorName}"/>
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
          <div style="width:300px;" class="checkout_value ${hasErrors(bean: storageMartInstance, field: 'address1', 'errors')}">
            <g:textField id="address1" name="address1" style="width: 280px;" value="${storageMartInstance?.address1}"/>
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
          <div style="width:300px;" class="checkout_value ${hasErrors(bean: storageMartInstance, field: 'address2', 'errors')}">
            <g:textField id="address2" name="address2" style="width: 280px;" value="${storageMartInstance?.address2}"/>
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
          <div style="width:300px;" class="checkout_value ${hasErrors(bean: storageMartInstance, field: 'city', 'errors')}">
            <g:textField id="city" name="city" style="width: 280px;" value="${storageMartInstance?.city}"/>
          </div>
          <div style="width:100px;" class="checkout_value ${hasErrors(bean: storageMartInstance, field: 'state', 'errors')}">
            <g:select name="state" id="state" class="validate-selection" style="width:80px;" from="${storitz.constants.State.list()}" value="${storageMartInstance?.state}" optionValue="value"/>
          </div>
          <div style="width:120px;" class="checkout_value ${hasErrors(bean: storageMartInstance, field: 'zipcode', 'errors')}">
            <g:textField id="zipcode" name="zipcode" style="width: 100px;" value="${storageMartInstance?.zipcode}"/>
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
          <div style="clear:both;"></div>
        </div>


          <div class="checkout_fields">
            <div style="width:300px;" class="checkout_value ${hasErrors(bean: storageMartInstance, field: 'reservationMoveInDescription', 'errors')}">
              <fckeditor:config CustomConfigurationsPath="${storitz.javascriptLink(src:'fckstoritz')}"/>
              <fckeditor:editor
                      name="reservationMoveInDescription"
                      width="650"
                      height="300"
                      toolbar="Storitz">
                ${storageMartInstance?.reservationMoveInDescription}
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
          <div style="width:300px;" class="checkout_value ${hasErrors(bean: storageMartInstance, field: 'transactionBoxLink', 'errors')}">
            <g:textField id="transactionBoxLink" name="transactionBoxLink" style="width: 280px;" value="${storageMartInstance?.transactionBoxLink}"/>
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
          <div style="width:300px;" class="checkout_value ${hasErrors(bean: storageMartInstance, field: 'transactionBoxBody', 'errors')}">
            <fckeditor:config CustomConfigurationsPath="${storitz.javascriptLink(src:'fckstoritz')}"/>
            <fckeditor:editor
                    name="transactionBoxBody"
                    width="650"
                    height="300"
                    toolbar="Storitz">
              ${storageMartInstance?.transactionBoxBody}
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


        <div class="checkout_fields">
          <div style="width:400px;" class="checkout_value ${hasErrors(bean: storageMartInstance, field: 'commissionSchedule', 'errors')}">
            <g:select name="commissionSchedule.id" id="commissionSchedule" class="validate-selection" style="width:200px;" from="${commissionScheduleList}" value="${storageMartInstance?.commissionSchedule}" optionKey="id" optionValue="scheduleName"/>
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
