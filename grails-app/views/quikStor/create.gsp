<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN"
    "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head>
  <g:set var="title" value="Create QuikStor Feed" scope="request"/>
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
    <span class="button"><a href="${createLink(controller:'admin', action:'index')}">Menu</a></span>
    <span class="button"><g:link action="list">List QuikStor Feeds</g:link></span>
  </div>
  <div class="body">

    <div class="price_options checkout_header white">
      Create QuikStor Feed
    </div>

    <g:if test="${flash.message}">
      <div class="message">${flash.message}</div>
    </g:if>
    <g:hasErrors bean="${quikStorInstance}">
      <div class="errors">
        <g:renderErrors bean="${quikStorInstance}" as="list"/>
      </div>
    </g:hasErrors>
    <g:form action="save" method="post">

      <div class="formInstructions">
        Create a QuikStor Feed - this will create the feed.  QuikStor then requires adding each location to the feed manually.
        Once this is done, the feed will have all the sites that correspond to that operator.
      </div>

      <div class="checkout_section_header">
        URL
      </div>

      <div class="formInstructions">
        This should be the URL for the WSDL service from QuikStor. Most sites use the default
      </div>

      <div class="checkout_fields">
        <div style="width:400px;" class="checkout_value ${hasErrors(bean: quikStorInstance, field: 'manager', 'errors')}">
          <g:textField name="url" id="url" style="width:380px;" value="${quikStorInstance?.url ? quikStorInstance.url : 'https://ecom.quikstor.com:443/eCom3ServiceSS/QuikStorWebServiceSS.asmx?WSDL' }"/>
        </div>
        <div style="clear:both;"></div>
      </div>

      <div class="checkout_labels">
        <div class="checkout_name" style="width:300px;">
          <label for="url">WSDL Url</label>
        </div>
        <div style="clear:both;"></div>
      </div>

      <div class="checkout_section_header">
        Manager
      </div>

      <div class="formInstructions">
        This should be a user created with ROLE_MANAGER privileges.  This user will have the rights to assign other
        users on this feed.
      </div>

      <div class="checkout_fields">
        <div style="width:300px;" class="checkout_value ${hasErrors(bean: quikStorInstance, field: 'manager', 'errors')}">
          <g:select name="manager.id" style="width:280px;" from="${com.storitz.UserRole.getUsersByRoleName('ROLE_MANAGER')}" optionKey="id" optionValue="username" value="${quikStorInstance?.manager?.username}" noSelection="['null': '']"/>
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
        Operator Information
      </div>

      <div class="checkout_fields">
        <div style="width:400px;" class="checkout_value ${hasErrors(bean: quikStorInstance, field: 'operatorName', 'errors')}">
          <g:textField name="operatorName" id="operatorName" style="width:380px;" value="${quikStorInstance?.operatorName}"/>
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
<p:renderDependantJavascript />
</html>