<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN"
    "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head>
  <script src="http://www.google.com/jsapi" type="text/javascript"></script>
  <g:set var="title" value="Edit Commission Entry" scope="request"/>
  <g:render template="/header_admin"/>

  <script type="text/javascript">
    //<![CDATA[
    $(document).ready(function() {
    });

    function deleteEntry(entryId) {
      $.ajax(
      {
        url:"${createLink(controller:'commission', action:'removeEntry')}",
        method:'get',
        dataType: 'json',
        data: {
          id: ${commissionScheduleInstance.id},
          entryId:entryId
        },
        success: function(ret) {
          $("#row_" + entryId).remove();
        }
      });

    }

    function addEntry() {
      var lastRow = $('#commissionEntries > tbody > tr.newEntry:last');
      var lastRowId = lastRow.attr('id');
      var newItem = 1
      if (lastRowId) {
        if (lastRowId.length == 0) {
          return
        }
        newItem = parseInt(lastRowId.substr(lastRowId.indexOf('_') + 1)) + 1;
      }
      var selectCol = $('<select>', {'name':'new_commissionType_' + newItem}).css({width:100});
    <g:each var="type" in="${storitz.constants.CommissionType?.list()}">
      selectCol.append($('<option>', {'value':'${type}'}).append('${type.value}'));
    </g:each>
      var newRow = $('<tr>', {'class':'newEntry', 'id':'newRow_' + newItem})
              .append($('<td>').append($('<input>', {'type':'text', 'name':'new_lowerBound_' + newItem}).css({width:180})))
              .append($('<td>').append($('<input>', {'type':'text', 'name':'new_upperBound_' + newItem}).css({width:180})))
              .append($('<td>').append($('<input>', {'type':'text', 'name':'new_amount_' + newItem}).css({width:180})))
              .append($('<td>').append(selectCol))
              .append($('<td>').append($('<a>',
      {
        href: '#',
        text: 'delete',
        click: function() {
          $(this).parents('tr.newEntry').remove();
          return false;
        }
      })));
      $('#commissionEntries').append(newRow);
      $('input[name="new_lowerBound_' + newItem + '"]').focus();

    }


    //]]>
  </script>

</head>
<body>
<div id="body">

  <div class="stcontent">
    <g:render template="/logo_bar"/>

    <div class="buttons">
      <span class="button"><a href="${createLink(controller: 'admin', action: 'index')}">Menu</a></span>
      <span class="button"><g:link action="list">Commission Schedule List</g:link></span>
    </div>

    <div class="body">

      <div class="price_options checkout_header white">
        Edit Commission Schedule ${commissionScheduleInstance.scheduleName}
      </div>

      <g:if test="${flash.message}">
        <div class="message">${flash.message}</div>
      </g:if>

      <div class="formInstructions">
        Lower and upper bounds should not overlap with other entries.  Enter percentages as whole numbers (i.e) 25 not .25.
      </div>

      <g:form method="post" id="${commissionScheduleInstance?.id}">

        <table id="commissionEntries">
          <thead>
          <tr>
            <th style="width:180px;">
              Lower Bound
            </th>
            <th style="width:180px;">
              Upper Bound
            </th>
            <th style="width:180px;">
              Amount
            </th>
            <th style="width:100px;">
              Commission Type
            </th>
            <th>
              Delete
            </th>
          </tr>
          </thead>
          <tbody>
          <g:each var="entry" in="${entries}" status="c">
            <tr id="row_${entry.id}">
              <td>
                <g:textField style="width:180px;" id="lowerBound_${entry.id}" name="lowerBound_${entry.id}" value="${entry.lowerBound}"/>
              </td>
              <td>
                <g:textField style="width:180px;" id="upperBound_${entry.id}" name="upperBound_${entry.id}" value="${entry.upperBound}"/>
              </td>
              <td>
                <g:textField id="amount_${entry.id}" name="amount_${entry.id}" style="width:180px;" value="${entry.amount}"/>
              </td>
              <td>
                <g:select id="commissionType_${entry.id}" style="width:100px;" name="commissionType_${entry.id}" from="${storitz.constants.CommissionType?.list()}" value="${entry.commissionType}" optionValue="value"/>
              </td>
              <td>
                <a href="#" onclick="deleteEntry(${entry.id});
                return false;">delete</a>
              </td>
            </tr>
          </g:each>
          </tbody>
        </table>

        <div class="checkout_value">
          <span class="buttonSmall"><a href="#" onclick="addEntry();
          return false;">Add Entry</a></span>
        </div>
        <div style="clear:both;height:30px;"></div>
        <div class="buttons">
          <span class="button"><g:actionSubmit action="update" value="${message(code: 'default.button.update.label', default: 'Update')}"/></span>
          <span class="button"><g:actionSubmit action="show" value="${message(code: 'default.button.show.label', default: 'Show')}"/></span>
        </div>
      </g:form>
    </div>
  </div>
</div>
</body>
</html>