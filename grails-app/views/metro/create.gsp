<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN"
    "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" >
  <head>
    <script src="http://www.google.com/jsapi" type="text/javascript"></script>
    <g:set var="title" value="Create Metro Area" scope="request"/>
    <g:render template="/header" />

  </head>
  <body>
    <div id="body">
    <g:render template="/topnav" />
    <div class="stcontent">
      <g:render template="/logo_bar" />

        <div class="buttons">
            <span class="button"><a href="${createLink(controller:'admin', action:'index')}">Menu</a></span>
            <span class="button"><g:link action="list">Metro List</g:link></span>
        </div>

        <div class="body">

          <div class="price_options checkout_header white">
            Create Metro
          </div>

            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${metroInstance}">
            <div class="errors">
                <g:renderErrors bean="${metroInstance}" as="list" />
            </div>
            </g:hasErrors>
          
            <g:form action="save" method="post" >

              <div class="formInstructions">
                Create the metro name and choose the state.  Mark whether this is a metro landing page or a neighborhood landing page with the checkmark.
              </div>

              <div class="checkout_section_header">
                Metro name and state
              </div>

              <div class="checkout_fields">
                <div style="width:250px;" class="checkout_value ${hasErrors(bean: metroInstance, field: 'city', 'errors')}">
                  <g:textField id="city" name="city" style="width: 230px;" value="${fieldValue(bean:metroInstance,field:'city')}" />
                </div>
                <div style="width:250px;" class="checkout_value ${hasErrors(bean: metroInstance, field: 'state', 'errors')}">
                  <g:select name="state" id="state" class="validate-selection" style="width:230px;" from="${storitz.constants.State.list()}" value="${metroInstance?.state}" optionValue="value"/>
                </div>
                <div style="clear:both;"></div>
              </div>

              <div class="checkout_labels">
                <div class="checkout_name" style="width:250px;">
                  <label for="city">Metro Name</label>
                </div>
                <div class="checkout_name" style="width:250px;">
                  <label for="state">State</label>
                </div>
                <div style="clear:both;"></div>
              </div>

              <div class="checkout_section_header">
                Description
              </div>

              <div class="checkout_fields">
                <div style="width:660px;" class="checkout_value ${hasErrors(bean: storageSiteInstance, field: 'note', 'errors')}">
                  <fckeditor:config CustomConfigurationsPath="${storitz.javascriptLink(src:'fckstoritz')}" />
                  <fckeditor:editor
                    name="note"
                    width="650"
                    height="300"
                    toolbar="Storitz">
                    ${metroInstance?.note}
                  </fckeditor:editor>
                </div>
                <div style="height:10px;clear:both;"></div>
              </div>

              <div class="checkout_section_header">
                Neighborhood
              </div>

              <div class="checkout_fields">
                <div style="width:300px;" class="checkout_value ${hasErrors(bean: metroInstance, field: 'isNeighborhood', 'errors')}">
                  <g:checkBox name="isNeighborhood" value="${metroInstance?.isNeighborhood}" /> &nbsp; Neighborhood
                </div>
                <div style="clear:both; height:10px;"></div>
              </div>

              <div class="buttons">
                  <span class="button"><input class="save" type="submit" value="Create" /></span>
              </div>
            </g:form>
        </div>
      </div>
    </div>
  </body>
  <p:renderDependantJavascript />
</html>
