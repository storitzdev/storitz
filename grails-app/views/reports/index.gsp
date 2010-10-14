<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN"
    "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" >
  <head>

    <g:render template="/header_admin" />

    <p:dependantJavascript>
      <p:javascript src="jquery.string.1.0"/>
      <p:javascript src="date"/>
      <script type="text/javascript">
//<![CDATA[

      $(document).ready(function() {
        var dateFormat = '%m/%d/%Y';


        // do stuff when DOM is ready
        $('#startDate').datepicker();
        $('#endDate').datepicker();
        $('input#sitename').autocomplete({source:"${createLink(controller:'storageSite', action:'autocompleteSite')}"});


        $('#today').click(function(event) {
          event.preventDefault();
          var now = new Date();
          var dateStr = now.print(dateFormat);
          $('#startDate').val(dateStr);
          $('#endDate').val(dateStr);
        });

         $('#thisWeek').click(function(event) {
           event.preventDefault();
           var now = new Date();
           var dateStr = now.print(dateFormat);
           $('#endDate').val(dateStr);
           // find the sunday of this week
           now.setDate(now.getDate()-now.getDay());
           $('#startDate').val(now.print(dateFormat));
         });

        $('#thisMonth').click(function(event) {
          event.preventDefault();
          var now = new Date();
          var dateStr = now.print(dateFormat);
          $('#endDate').val(dateStr);
          // find the sunday of this week
          now.setDate(1);
          $('#startDate').val(now.print(dateFormat));
        });

        $('#thisYear').click(function(event) {
          event.preventDefault();
          var now = new Date();
          var dateStr = now.print(dateFormat);
          $('#endDate').val(dateStr);
          // find the sunday of this week
          now.setDate(1);
          now.setMonth(0);
          $('#startDate').val(now.print(dateFormat));
        });

      });
//]]>
    </script>
  </p:dependantJavascript>
  </head>
  <body>
    <div id="body">
    <g:render template="/topnav" />
    <div id="stcontent">
      <g:render template="/logo_bar" />

      <div class="price_options checkout_header white">
        Reports
      </div>

      <div class="formInstructions">
        Choose the date range and the output format of your report - PDF and Excel reports will download automatically. If you want a custom date range, click on the start and end date fields to enter your dates.
      </div>

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
        <div class="checkout_fields">
          <div style="width:200px;" class="checkout_value ${hasErrors(bean: reportPeriod, field: 'startDate', 'errors')}">
            <input type="text" style="width:180px;" id="startDate" name="startDate" value="${reportPeriod?.startDate}" />
          </div>
          <div style="width:200px;" class="checkout_value ${hasErrors(bean: reportPeriod, field: 'endDate', 'errors')}">
            <input type="text" style="width:180px;" id="endDate" name="endDate" value="${reportPeriod?.endDate}" />
          </div>
          <div class="buttons">
            <span class="button"><a href="" id="today">Today</a></span>
            <span class="button"><a href="" id="thisWeek">This Week</a></span>
            <span class="button"><a href="" id="thisMonth">This Month</a></span>
            <span class="button"><a href="" id="thisYear">This Year</a></span>
          </div>
          <div style="clear:both;"></div>
        </div>

        <div class="checkout_labels">
          <div class="checkout_name" style="width:200px;">
            <label for="startDate">Start Date</label>
          </div>
          <div class="checkout_name" style="width:200px;">
            <label for="endDate">End Date</label>
          </div>
          <div style="clear:both;"></div>
        </div>

        <div class="checkout_fields">
          <div style="width:250px;" class="checkout_value ${hasErrors(bean: reportPeriod, field: 'outputType', 'errors')}">
            <g:select id="outputType" style="width:230px;" name="outputType" from="${storitz.constants.ReportOutputType?.list()}" value="${reportPeriod?.outputType}" optionValue="display" />
          </div>
          <div style="width:250px;" class="checkout_value ${hasErrors(bean: reportPeriod, field: 'site', 'errors')}">
            <input name="sitename" id="sitename" value="${reportPeriod?.site?.title}" style="width:230px;" />
          </div>
          <div style="clear:both;"></div>
        </div>

        <div class="checkout_labels">
          <div class="checkout_name" style="width:250px;">
            <label for="outputType">Output Type</label>
          </div>
          <div class="checkout_name" style="width:250px;">
            <label for="sitename">Site</label>
          </div>
          <div style="clear:both;"></div>
        </div>

        <div class="buttons">
          <sec:ifAnyGranted roles="ROLE_ADMIN">
            <span class="button"><g:actionSubmit action="balk" value="${message(code: 'default.button.balk.label', default: 'Balk Report')}"/></span>
          </sec:ifAnyGranted>
          <span class="button"><g:actionSubmit action="site" value="${message(code: 'default.button.site.label', default: 'Site Transactions')}"/></span>
        </div>
      </g:form>
    </div>
    <div style="height:30px;"></div>
    <g:render template="/footer_admin" />
    </div>
  </body>
  <p:renderDependantJavascript/>
</html>