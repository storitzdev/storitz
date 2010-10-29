<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN"
    "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" >
  <head>
    <script src="http://www.google.com/jsapi" type="text/javascript"></script>
    <g:set var="title" value="Edit Metro Entry" scope="request"/>
    <g:render template="/header_admin" />

    <p:dependantJavascript>
      <script type="text/javascript">
//<![CDATA[

      $(document).ready(function() {
        jQuery.noConflict();

        setupUserSelector();
      });

      function setupUserSelector() {
        jQuery("input#metro").autocomplete(
          {
            source:"${createLink(controller:'metroEntry', action:'autocompleteMetro')}",
            select:function(event, ui) {
              jQuery("input#metro_id").val(ui.item.id);
            }
          });
      }

//]]>
    </script>
  </p:dependantJavascript>

  </head>
  <body>
    <div id="body">
    <g:render template="/topnav" />
    <div id="stcontent">
      <g:render template="/logo_bar" />

        <div class="buttons">
            <span class="button"><a href="${createLink(controller:'admin', action:'index')}">Menu</a></span>
            <span class="button"><g:link action="list">Metro Entry List</g:link></span>
        </div>

        <div class="body">

          <div class="price_options checkout_header white">
            Edit Neighborhood
          </div>

            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${metroEntryInstance}">
            <div class="errors">
                <g:renderErrors bean="${metroEntryInstance}" as="list" />
            </div>
            </g:hasErrors>

            <g:form action="save" method="post" >

              <div class="formInstructions">
                Create the neighborhood name and choose the state. Choose the metro name from the dynamic autocomplete box.
              </div>

              <div class="checkout_section_header">
                Neighborhood name and state
              </div>

              <div class="checkout_fields">
                <div style="width:120px;" class="checkout_value ${hasErrors(bean: metroEntryInstance, field: 'zipcode', 'errors')}">
                  <g:textField id="zipcode" name="zipcode" style="width: 100px;" value="${fieldValue(bean:metroEntryInstance,field:'zipcode')}" />
                </div>
                <div style="width:250px;" class="checkout_value ${hasErrors(bean: metroEntryInstance, field: 'city', 'errors')}">
                  <g:textField id="city" name="city" style="width: 230px;" value="${fieldValue(bean:metroEntryInstance,field:'city')}" />
                </div>
                <div style="width:250px;" class="checkout_value ${hasErrors(bean: metroEntryInstance, field: 'state', 'errors')}">
                  <g:select name="state" id="state" class="validate-selection" style="width:230px;" from="${storitz.constants.State.list()}" value="${metroEntryInstance?.state}" optionValue="value"/>
                </div>
                <div style="clear:both;"></div>
              </div>

              <div class="checkout_labels">
                <div class="checkout_name" style="width:120px;">
                  <label for="city">Zip Code</label>
                </div>
                <div class="checkout_name" style="width:250px;">
                  <label for="city">Neighborhood</label>
                </div>
                <div class="checkout_name" style="width:250px;">
                  <label for="state">State</label>
                </div>
                <div style="clear:both;"></div>
              </div>

              <div class="checkout_section_header">
                Metro Area
              </div>
              <div class="checkout_fields">
                <div style="width:250px;" class="checkout_value ${hasErrors(bean: metroEntryInstance, field: 'metro', 'errors')}">
                  <input type="text" name="metro" id="metro" />
                  <input type="hidden" name="metro_id" id="metro_id" value="${metroEntryInstance?.metro?.id}" />
                </div>
                <div style="clear:both;"></div>
              </div>

              <div class="checkout_labels">
                <div class="checkout_name" style="width:250px;">
                  <label for="city">Metro Name</label>
                </div>
                <div style="clear:both;"></div>
              </div>

              <input type="hidden" name="id" value="${metroInstance?.id}" />
              <div class="buttons">
                  <span class="button"><g:actionSubmit class="save" value="Update" /></span>
                  <span class="button"><g:actionSubmit class="delete" onclick="return confirm('Are you sure?');" value="Delete" /></span>
                  <span class="button"><g:link class="edit" action="show" id="${metroInstance?.id}">Cancel</g:link></span>
              </div>
            </g:form>
        </div>
      </div>
    </div>
  </body>
  <p:renderDependantJavascript />
</html>
