<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN"
    "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" >
  <head>
    <script src="http://www.google.com/jsapi" type="text/javascript"></script>
    <g:set var="title" value="Edit Commission Entry"/>
    <g:render template="/header" />

    <script type="text/javascript">
//<![CDATA[
    google.load("prototype", "1.6.1.0");
    google.load("scriptaculous", "1.8.3");
//]]>

    FastInit.addOnLoad(setupAutocomplete);
  </script>

  </head>
  <body>
    <div id="body">
    <g:render template="/topnav" />
    <div id="stcontent">
      <g:render template="/logo_bar" />

      <div class="buttons">
          <span class="button"><a href="${createLink(controller:'admin', action:'index')}">Menu</a></span>
          <span class="button"><g:link action="list">Commission List</g:link></span>
          <span class="button"><g:link action="create">New Commission Entry</g:link></span>
      </div>

        <div class="body">

          <div class="price_options checkout_header white">
            Edit Commission Entry
          </div>

          <g:if test="${flash.message}">
          <div class="message">${flash.message}</div>
          </g:if>
          <g:hasErrors bean="${commissionInstance}">
          <div class="errors">
              <g:renderErrors bean="${commissionInstance}" as="list" />
          </div>
          </g:hasErrors>

          <g:form method="post" >
              <g:hiddenField name="id" value="${commissionInstance?.id}" />
              <g:hiddenField name="version" value="${commissionInstance?.version}" />

            <div class="checkout_section_header">
              Commission Source
            </div>

            <div class="checkout_fields">
              <div style="width:200px;" class="checkout_value ${hasErrors(bean: commissionInstance, field: 'commissionSource', 'errors')}">
                  <g:select id="commissionSource" style="width:200px;" name="commissionSource" from="${storitz.constants.CommissionSourceType?.list()}" value="${commissionInstance?.commissionSource}"  optionValue="value"/>
              </div>
              <div style="clear:both;"></div>
            </div>

            <div class="checkout_labels">
              <div class="checkout_name" style="width:200px;">
                <label for="commissionType">Commission Source</label>
              </div>
              <div style="clear:both;"></div>
            </div>

            <div class="formInstructions">
              Lower and upper bounds should not overlap with other entries.  Enter percentages as whole numbers (i.e) 25 not .25.
            </div>

            <div class="checkout_section_header">
              Bounds
            </div>

            <div class="checkout_fields">
              <div style="width:200px;" class="checkout_value ${hasErrors(bean: commissionInstance, field: 'lowerBound', 'errors')}">
                  <g:textField style="width:180px;" id="lowerBound" name="lowerBound" value="${fieldValue(bean: commissionInstance, field: 'lowerBound')}" />
              </div>
              <div style="width:200px;" class="checkout_value ${hasErrors(bean: commissionInstance, field: 'upperBound', 'errors')}">
                  <g:textField style="width:180px;" id="upperBound" name="upperBound" value="${fieldValue(bean: commissionInstance, field: 'lowerBound')}" />
              </div>
              <div style="clear:both;"></div>
            </div>

            <div class="checkout_labels">
              <div class="checkout_name" style="width:200px;">
                <label for="lowerBound">Lower Bound</label>
              </div>
              <div class="checkout_name" style="width:200px;">
                <label for="upperBound">Upper Bound</label>
              </div>
              <div style="clear:both;"></div>
            </div>

            <div class="checkout_section_header">
              Commission
            </div>

            <div class="checkout_fields">
              <div style="width:200px;" class="checkout_value ${hasErrors(bean: commissionInstance, field: 'amount', 'errors')}">
                  <g:textField id="amount" name="amount" style="width:180px;" value="${fieldValue(bean: commissionInstance, field: 'amount')}" />
              </div>
              <div style="width:200px;" class="checkout_value ${hasErrors(bean: commissionInstance, field: 'commissionType', 'errors')}">
                  <g:select id="commissionType" style="width:100px;" name="commissionType" from="${storitz.constants.CommissionType?.list()}" value="${commissionInstance?.commissionType}" optionValue="value" />
              </div>
              <div style="clear:both;"></div>
            </div>

            <div class="checkout_labels">
              <div class="checkout_name" style="width:200px;">
                <label for="amount">Commission</label>
              </div>
              <div class="checkout_name" style="width:100px;">
                <label for="commissionType">Type</label>
              </div>
              <div style="clear:both;"></div>
            </div>

            <div class="buttons">
                <span class="button"><g:actionSubmit class="save" action="update" value="${message(code: 'default.button.update.label', default: 'Update')}" /></span>
                <span class="button"><g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" /></span>
            </div>
          </g:form>
        </div>
      </div>
    </div>
  </body>
</html>