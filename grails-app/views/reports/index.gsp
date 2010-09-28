<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN"
    "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" >
  <head>
    <g:render template="/header_admin" />
    <link href="${createLinkTo(dir:'css', file:'jquery-ui-1.8.4.custom.css')}" media="screen" rel="stylesheet" type="text/css" />
    <script src="https://www.google.com/jsapi" type="text/javascript"></script>

    <script type="text/javascript">
//<![CDATA[
    google.load("jquery", "1.4.2");
    google.load("jqueryui", "1.8.5");

    google.setOnLoadCallback(function() {
      // do stuff when DOM is ready
         $('#startDate').datepicker();
         $('#endDate').datepicker();
    });
//]]>
  </script>

  </head>
  <body>
    <div id="body">
    <g:render template="/topnav" />
    <div id="stcontent">
      <g:render template="/logo_bar" />
      <H1>Storitz Reports</H1>

      <div class="buttons">
        <span class="button"><a href="${createLink(controller: 'admin', action: 'index')}">Admin Menu</a></span>
      </div>

      <g:if test="${flash.message}">
        <div class="message">${flash.message}</div>
      </g:if>
      <g:hasErrors bean="${reportPeriod}">
        <div class="errors">
          <g:renderErrors bean="${reportPeriod}" as="list"/>
        </div>
      </g:hasErrors>


      <g:form>
        <div>
          Start Date: <input type="text" id="startDate" name="startDate" value="${reportPeriod?.startDate}" />
          End Date: <input type="text" id="endDate" name="endDate" value="${reportPeriod?.endDate}" />
        </div>
        <div>
          Pick your output type:
          <g:select id="outputType" style="width:250px;" name="outputType" from="${storitz.constants.ReportOutputType?.list()}" value="${reportPeriod?.outputType}" optionValue="display" optionKey="value" />
        </div>

        <div class="buttons">
          <sec:ifAnyGranted roles="ROLE_ADMIN">
            <span class="button"><g:actionSubmit action="balk" value="${message(code: 'default.button.balk.label', default: 'Balk Report')}"/></span>
          </sec:ifAnyGranted>
        </div>
      </g:form>
    </div>
    <div style="height:30px;"></div>
    <g:render template="/footer" />
    </div>
  </body>
</html>