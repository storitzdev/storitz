<%@ page import="storitz.constants.ReportName" %>
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN"
    "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head>

  <g:set var="title" value="Stortiz Reporting Menu" scope="request"/>

  <g:render template="/header_admin"/>

  <p:dependantJavascript>
    <p:javascript src="jquery.string.1.0"/>
    <p:javascript src="date"/>
    <script type="text/javascript">
      //<![CDATA[

      $(document).ready(function() {
        var dateFormat = '%m/%d/%Y';

        // do stuff when DOM is ready
        $('#startDate').datepicker({
          showOn: "button",
          buttonImage: ${storitz.imageLink(src:"calendar.png")},
          onSelect: function(dateText, inst) {
            $('#startDateDisplay').html(dateText);
          },
          buttonImageOnly: true
        });
        $('#endDate').datepicker({
          showOn: "button",
          buttonImage: ${storitz.imageLink(src:"calendar.png")},
          onSelect: function(dateText, inst) {
            $('#endDateDisplay').html(dateText);
          },
          buttonImageOnly: true
        });
        $('input#sitename').autocomplete({source:"${createLink(controller:'storageSite', action:'autocompleteSite')}"});


        $('#today').click(function(event) {
          event.preventDefault();
          var now = new Date();
          var dateStr = now.print(dateFormat);
          $('#startDate').val(dateStr);
          $('#startDateDisplay').html(dateStr);
          $('#endDate').val(dateStr);
          $('#endDateDisplay').html(dateStr);
        });

        $('#thisWeek').click(function(event) {
          event.preventDefault();
          var now = new Date();
          var dateStr = now.print(dateFormat);
          $('#endDate').val(dateStr);
          $('#endDateDisplay').html(dateStr);
          // find the sunday of this week
          now.setDate(now.getDate() - now.getDay());
          $('#startDate').val(now.print(dateFormat));
          $('#startDateDisplay').html(now.print(dateFormat));
        });

        $('#thisMonth').click(function(event) {
          event.preventDefault();
          var now = new Date();
          var dateStr = now.print(dateFormat);
          $('#endDate').val(dateStr);
          $('#endDateDisplay').html(dateStr);
          // find the sunday of this week
          now.setDate(1);
          $('#startDate').val(now.print(dateFormat));
          $('#startDateDisplay').html(now.print(dateFormat));
        });

        $('#thisYear').click(function(event) {
          event.preventDefault();
          var now = new Date();
          var dateStr = now.print(dateFormat);
          $('#endDate').val(dateStr);
          $('#endDateDisplay').html(dateStr);
          // find the sunday of this week
          now.setDate(1);
          now.setMonth(0);
          $('#startDate').val(now.print(dateFormat));
          $('#startDateDisplay').html(now.print(dateFormat));
        });

        $('#reportName').change(function(event) {
          if ($(this).val() == '${ReportName.MOVEIN}' ||
                  $(this).val() == '${ReportName.PENDING}' ||
                  $(this).val() == '${ReportName.ACTIVITY}') {
            $('#optionalParams').show();
            $('#feedParams').hide();
          } else if ($(this).val() == '${ReportName.TRANSACTION_HISTORY}' || $(this).val() == '${ReportName.ACH_TRANSFERS}' || $(this).val() == '${ReportName.INVOICE}') {
            $('#optionalParams').hide();
            $('#feedParams').show();
          }
        });

      });
      //]]>

    </script>
  </p:dependantJavascript>
</head>
<body>
<div id="body">
  <g:render template="/topnav"/>
  <div class="stcontent">
    <g:render template="/logo_bar"/>

    <div class="buttons">
      <span class="button"><a href="${createLink(controller: 'admin', action: 'index')}">Admin Menu</a></span>
    </div>
    <div style="height:10px;clear:both;"></div>

    <div class="price_options checkout_header white">
      Reports Menu
    </div>

    <div class="formInstructions">
      Follow the steps to create your report.  Pick a date range, then an output format and lastly the report type.  Some reports may have more parameters to pick.
    </div>

    <g:if test="${flash.message}">
      <div class="message">${flash.message}</div>
    </g:if>
    <g:hasErrors bean="${reportPeriod}">
      <div class="errors">
        <g:renderErrors bean="${reportPeriod}" as="list"/>
      </div>
    </g:hasErrors>

    <g:form name="reportForm" target="_blank">
      <div style="height:20px;clear:both;"></div>
      <div class="price_options checkout_header white">
        Pick a date range
      </div>

      <div class="checkout_fields">
        <div class="checkout_value ${hasErrors(bean: reportPeriod, field: 'startDate', 'errors')}">
          <span id="startDateDisplay" style="font-size:16px;">${(reportPeriod?.startDate ? reportPeriod?.startDate : new Date()).format('MM/dd/yyyy')}</span><input type="hidden" id="startDate" name="startDate" value="${(reportPeriod?.startDate ? reportPeriod?.startDate : new Date()).format('MM/dd/yyyy')}"/>&nbsp;-&nbsp;
        </div>
        <div class="checkout_value ${hasErrors(bean: reportPeriod, field: 'endDate', 'errors')}">
          <span id="endDateDisplay" style="font-size:16px;">${(reportPeriod?.endDate ? reportPeriod?.endDate : new Date()).format('MM/dd/yyyy')}</span><input type="hidden" id="endDate" name="endDate" value="${(reportPeriod?.endDate ? reportPeriod?.endDate : new Date()).format('MM/dd/yyyy')}"/>
        </div>
        <div style="height:10px;clear:both;"></div>
        <div class="buttons">
          <span class="buttonSmall"><a href="" id="today">Today</a></span>
          <span class="buttonSmall"><a href="" id="thisWeek">This Week</a></span>
          <span class="buttonSmall"><a href="" id="thisMonth">This Month</a></span>
          <span class="buttonSmall"><a href="" id="thisYear">This Year</a></span>
        </div>
        <div style="height:20px;clear:both;"></div>
      </div>

      <div class="price_options checkout_header white">
        Pick a your output format
      </div>


      <div class="checkout_fields">
        <div style="width:250px;" class="checkout_value ${hasErrors(bean: reportPeriod, field: 'outputType', 'errors')}">
          <g:select id="outputType" style="width:230px;" name="outputType" from="${storitz.constants.ReportOutputType?.list()}" value="${reportPeriod?.outputType}" optionValue="display"/>
        </div>
        <div style="clear:both;"></div>
      </div>

      <div class="checkout_labels">
        <div class="checkout_name" style="width:250px;">
          <label for="outputType">Output Type</label>
        </div>
        <div style="height:20px;clear:both;"></div>
      </div>

      <div class="price_options checkout_header white">
        Pick your report
      </div>

      <div class="checkout_fields">
        <div style="width:250px;" class="checkout_value ${hasErrors(bean: reportPeriod, field: 'outputType', 'errors')}">
          <select id="reportName" style="width:230px;" name="reportName">
            <option ${!reportPeriod ? 'selected="selected"' : ''} value="">Choose a report</option>
            <sec:ifAnyGranted roles="ROLE_ADMIN">
              <option ${reportPeriod?.reportName == ReportName.BALK ? 'selected="selected"' : ''} value="${ReportName.BALK}">${ReportName.BALK.display}</option>
            </sec:ifAnyGranted>
            <option ${reportPeriod?.reportName == ReportName.MOVEIN ? 'selected="selected"' : ''} value="${ReportName.MOVEIN}">${ReportName.MOVEIN.display}</option>
            <option ${reportPeriod?.reportName == ReportName.PENDING ? 'selected="selected"' : ''} value="${ReportName.PENDING}">${ReportName.PENDING.display}</option>
            <option ${reportPeriod?.reportName == ReportName.ACTIVITY ? 'selected="selected"' : ''} value="${ReportName.ACTIVITY}">${ReportName.ACTIVITY.display}</option>
            <sec:ifAnyGranted roles="ROLE_ADMIN,ROLE_MANAGER">
              <option ${reportPeriod?.reportName == ReportName.TRANSACTION_HISTORY ? 'selected="selected"' : ''} value="${ReportName.TRANSACTION_HISTORY}">${ReportName.TRANSACTION_HISTORY.display}</option>
              <option ${reportPeriod?.reportName == ReportName.ACH_TRANSFERS ? 'selected="selected"' : ''} value="${ReportName.ACH_TRANSFERS}">${ReportName.ACH_TRANSFERS.display}</option>
            </sec:ifAnyGranted>
            <sec:ifAnyGranted roles="ROLE_ADMIN">
              <option ${reportPeriod?.reportName == ReportName.INVOICE ? 'selected="selected"' : ''} value="${ReportName.INVOICE}">${ReportName.INVOICE.display}</option>
            </sec:ifAnyGranted>
          </select>
        </div>
        <div style="height:20px;clear:both;"></div>
      </div>

      <div id="optionalParams" style="display:none;">
        <div class="price_options checkout_header white">
          Choose report parameters
        </div>

        <div class="formInstructions">
          You have picked a report that requires your to select a specifice storage location.  Start by typing the name - the list of matching sites will appear below.  Choose the one upon which you wish to report.
        </div>

        <div class="checkout_fields">
          <div style="width:250px;" class="checkout_value ${hasErrors(bean: reportPeriod, field: 'site', 'errors')}">
            <input name="sitename" id="sitename" value="${reportPeriod?.site?.title}" style="width:230px;"/>
          </div>
          <div style="clear:both;"></div>
        </div>

        <div class="checkout_labels">
          <div class="checkout_name" style="width:250px;">
            <label for="sitename">Site</label>
          </div>
          <div style="height:20px;clear:both;"></div>
        </div>

      </div>

      <g:if test="${feedList?.size() > 1}">
        <div id="feedParams" style="display:none;">
          <div class="price_options checkout_header white">
            Choose Corporation
          </div>

          <div class="formInstructions">
            Pick the correct corporation for the report
          </div>

          <div class="checkout_fields">
            <div style="width:400px;" class="checkout_value ${hasErrors(bean: reportPeriod, field: 'feed', 'errors')}">
              <g:select style="width:400px;" from="${feedList}" value="${reportPeriod?.feed?.id}"
                      optionKey="id" optionValue="operatorName" name="feed.id"
                      noSelection="['null':'No feed selected']"/>
            </div>
            <div style="clear:both;"></div>
          </div>

          <div class="checkout_labels">
            <div class="checkout_name" style="width:400px;">
              <label for="feed.id">Site</label>
            </div>
            <div style="height:20px;clear:both;"></div>
          </div>

        </div>
      </g:if>
      <g:else>
        <input type="hidden" name="feed.id" value='${feedList ? feedList.asList()[0].id : ""}'/>
      </g:else>

      <div class="buttons">
        <span class="button"><g:actionSubmit action="site" value="Generate Report"/></span>
      </div>
    </g:form>
  </div>
  <div style="height:30px;"></div>
  <g:render template="/footer_admin"/>
</div>
</body>
<p:renderDependantJavascript/>
</html>