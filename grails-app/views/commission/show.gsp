<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="storitz.constants.CommissionType" %>
<html>
<head>
  <g:set var="title" value="Show Commission Entry" scope="request"/>
</head>
<body>
<div id="body">

  <div class="stcontent">
    <div class="buttons">
      <span class="button"><a class="home" href="${createLink(controller: 'admin', action: 'index')}">Menu</a></span>
      <span class="button"><g:link action="list">Commission Schedule List</g:link></span>
    </div>
    <div class="body">

      <div class="price_options checkout_header white">
        Show Commission Schedule for ${commissionScheduleInstance.scheduleName}
      </div>

      <g:if test="${flash.message}">
        <div class="message">${flash.message}</div>
      </g:if>
      <div class="dialog">
        <table id="commissionEntries">
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
          </tr>
          <g:each var="entry" in="${entries}" status="c">
            <tr id="row_${entry.id}">
              <td>
                <g:formatNumber number="${entry.lowerBound}" type="currency" currencyCode="USD"/>
              </td>
              <td>
                <g:formatNumber number="${entry.upperBound}" type="currency" currencyCode="USD"/>
              </td>
              <td>
                <g:if test="${entry.commissionType == CommissionType.FIXED}">
                  <g:formatNumber number="${entry.amount}" type="currency" currencyCode="USD"/>
                </g:if>
                <g:else>
                  <g:formatNumber number="${entry.amount / 100G}" type="percent"/>
                </g:else>
              </td>
              <td>
                ${entry.commissionType.display}
              </td>
            </tr>
          </g:each>
        </table>

      </div>
      <div class="buttons">
        <g:form>
          <g:hiddenField name="id" value="${commissionScheduleInstance?.id}"/>
          <span class="button"><g:actionSubmit class="edit" action="edit" value="${message(code: 'default.button.edit.label', default: 'Edit')}"/></span>
        </g:form>
      </div>
    </div>
  </div>
</div>
</body>
</html>
