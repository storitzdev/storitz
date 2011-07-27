<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
  <g:set var="title" value="Commission List" scope="request"/>
</head>
<body>
<div id="body">

  <div class="stcontent">
    <div class="buttons">
      <span class="button"><a href="${createLink(controller: 'admin', action: 'index')}">Menu</a></span>
    </div>
    <div class="body">

      <div class="price_options checkout_header white">
        List Commission Schedules
      </div>

      <g:if test="${flash.message}">
        <div class="message">${flash.message}</div>
      </g:if>

      <g:form action="createSchedule" method="post">
        <div class="dialog">
          <table>
            <tbody>
            <tr class='prop'>
              <td valign='top' class='name'>
                <label for='scheduleName'>New Schedule Name:</label>
              </td>
              <td valign='top' class='value'>
                <input type="text" id="scheduleName" name="scheduleName" style="width:300px;" value="${flash.scheduleName}"/>
                <span class="button"><input class="save" type="submit" value="Create"/></span>
              </td>
            </tr>
            </tbody>
          </table>
        </div>
      </g:form>

      <div class="list">
        <table>
          <thead>
          <tr>

            <g:sortableColumn property="id" title="${message(code: 'commissionSchedule.id.label', default: 'Id')}"/>

            <g:sortableColumn property="scheduleName" title="${message(code: 'commissionSchedule.scheduleName.label', default: 'Schedule Name')}"/>

            <th>Edit</th>
          </tr>
          </thead>
          <tbody>
          <g:each in="${commissionScheduleInstanceList}" status="i" var="commissionSchedule">
            <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">

              <td><g:link action="show" id="${commissionSchedule.id}">${fieldValue(bean: commissionSchedule, field: "id")}</g:link></td>

              <td>${fieldValue(bean: commissionSchedule, field: "scheduleName")}</td>

              <td><g:link action="edit" id="${commissionSchedule.id}">edit</g:link></td>

            </tr>
          </g:each>
          </tbody>
        </table>
      </div>
      <div class="paginateButtons">
        <g:paginate total="${commissionScheduleInstanceTotal}"/>
      </div>
    </div>
  </div>
</div>
</body>
</html>
