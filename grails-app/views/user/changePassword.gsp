<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN"
    "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" >
  <head>
    <p:css name="login.css" />
    <g:set var="title" value="Change Password" scope="request"/>
    <g:render template="/header_admin"/>

    <script type="text/javascript">
      //<![CDATA[

      $(document).ready(function() {
        jQuery.noConflict();

        jQuery('#oldPasswd').focus();
      });

      //]]>
    </script>

  </head>
  <body>

    <div id="body">

    <g:render template="/topnav" />
    <div class="stcontent">
      <g:render template="/logo_bar" />

      <div style="clear: both;height: 10px"></div>
      <div class="buttons">
        <span class="button"><a href="${createLink(controller: 'admin', action: 'index')}">Menu</a></span>
      </div>

      <div style="clear: both;height: 10px"></div>

      <div class="body">

        <div class="price_options checkout_header white">
          Change Password
        </div>

        <g:if test="${flash.message}">
          <div class="message">${flash.message}</div>
        </g:if>
        <g:hasErrors bean="${storageSiteInstance}">
          <div class="errors">
            <g:renderErrors bean="${storageSiteInstance}" as="list"/>
          </div>
        </g:hasErrors>

        <g:form controller="user" action="changePassword" method="POST" id="passwordForm" class='cssform'>

          <div class="checkout_section_header">
            Change Password
          </div>

          <div class="formInstructions">
            Enter your current password in the old password field and then the new password in the new password and repeat password fields.
          </div>

          <div class="checkout_fields">
            <div style="width:250px;" class="checkout_value">
              <input type='password' class='inputBox' name='oldPasswd' id='oldPasswd' />
            </div>
            <div style="clear:both;"></div>
          </div>

          <div class="checkout_labels">
            <div class="checkout_name" style="width:250px;">
              <label for="oldPasswd">Old Password</label>
            </div>
            <div style="clear:both;"></div>
          </div>

          <div class="checkout_fields">
            <div style="width:250px;" class="checkout_value">
              <input type='password' class='inputBox' name='passwd' id='passwd' />
            </div>
            <div style="width:250px;" class="checkout_value">
              <input type='password' class='inputBox' name='repasswd' id='repasswd' />
            </div>
            <div style="clear:both;"></div>
          </div>

          <div class="checkout_labels">
            <div class="checkout_name" style="width:250px;">
              <label for="passwd">New Password</label>
            </div>
            <div class="checkout_name" style="width:250px;">
              <label for="repasswd">Repeat New Password</label>
            </div>
            <div style="clear:both;"></div>
          </div>

          <div class="buttons">
            <span class="button"><g:actionSubmit value="${message(code: 'default.button.changepassword.label', default: 'Change Password')}"/></span>
          </div>
        </g:form>
	</div>
  </div>
</div>
</body>
</html>