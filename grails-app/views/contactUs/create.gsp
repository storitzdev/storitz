<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN"
    "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" >
  <head>
    <g:render template="/header" />

    <script type="text/javascript">
//<![CDATA[

//]]>
  </script>

  </head>
  <body>
    <div id="body">
    <g:render template="/topnav" />
    <div id="stcontent">
      <g:render template="/logo_bar" />
      <div id="staticMenu" class="left" style="margin-top: 26px;">
        <!-- menu section -->
      </div>
      <div style="width: 650px;margin-right: 35px;" class="right">

        <div class="price_options checkout_header white">
          Contact Us
        </div>

        <div class="formInstructions">
          Please contact us by choosing a subject and entering a valid email.  We will get back to you as soon as possible.
        </div>

        <g:if test="${flash.message}">
        <div class="message">${flash.message}</div>
        </g:if>
        <g:hasErrors bean="${contactUsInstance}">
        <div class="errors">
            <g:renderErrors bean="${contactUsInstance}" as="list" />
        </div>
        </g:hasErrors>

        <g:form action="save" method="post" >
          <div class="checkout_fields">
            <div style="width:400px;" class="checkout_value ${hasErrors(bean: contactUsInstance, field: 'contactType', 'errors')}">
                <g:select name="contactType" id="contactType" style="width:400px;" from="${storitz.constants.ContactType.list()}" optionValue="display" value="${contactUsInstance?.contactType}"  />
            </div>
            <div style="clear:both;"></div>
          </div>
          <div class="checkout_labels">
            <div class="checkout_name" style="width:400px;">
              <label for="contactType">Subject</label>
            </div>
            <div style="clear:both;"></div>
          </div>

          <div class="checkout_fields">
            <div style="width:410px;" class="checkout_value ${hasErrors(bean: contactUsInstance, field: 'userEmail', 'errors')}">
              <g:textField name="userEmail" id="userEmail" style="width:400px;" value="${contactUsInstance?.userEmail}" />
            </div>
            <div style="clear:both;"></div>
          </div>
          <div class="checkout_labels">
            <div class="checkout_name" style="width:400px;">
              <label for="userEmail">Your email</label>
            </div>
            <div style="clear:both;"></div>
          </div>

          <div class="checkout_fields">
            <div style="width:610px;" class="checkout_value ${hasErrors(bean: contactUsInstance, field: 'message', 'errors')}">
              <g:textArea name="message" id="message" style="width:600px; height:300px;" value="${contactUsInstance?.message}" />
            </div>
            <div style="clear:both;"></div>
          </div>
          <div class="checkout_labels">
            <div class="checkout_name" style="width:400px;">
              <label for="message">Message</label>
            </div>
            <div style="clear:both;"></div>
          </div>

          <div class="right buttons">
              <span class="button"><g:submitButton name="create" class="save" value="${message(code: 'default.button.send.label', default: 'Send')}" /></span>
          </div>
        </g:form>
      </div>
    </div>

    <div style="clear:both; height:30px;"></div>
      <g:render template="/footer" />
      <g:render template="/size_popup" />
    </div>
  </body>
</html>