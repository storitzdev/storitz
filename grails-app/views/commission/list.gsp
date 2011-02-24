<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN"
    "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" >
  <head>
    <g:set var="title" value="Commission List" scope="request"/>
    <g:render template="/header" />

    <script type="text/javascript">
//<![CDATA[
//]]>
  </script>

  </head>
  <body>
    <div id="body">
      <g:render template="/topnav" />
      <div class="stcontent">
        <g:render template="/logo_bar" />

        <div class="buttons">
            <span class="button"><a href="${createLink(controller:'admin', action:'index')}">Menu</a></span>
        </div>
        <div class="body">

            <div class="price_options checkout_header white">
              List Commission Schedules
            </div>

            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>

          <g:form action="createSchedule" method="post" >
              <div class="dialog">
                  <table>
                      <tbody>
                        <tr class='prop'>
                              <td valign='top' class='name'>
                                  <label for='scheduleName'>New Schedule Name:</label>
                              </td>
                              <td valign='top' class='value'>
                                  <input type="text" id="scheduleName" name="scheduleName" style="width:300px;" value="${flash.scheduleName}"/>
                                  <span class="button"><input class="save" type="submit" value="Create" /></span>
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
                        
                            <g:sortableColumn property="id" title="${message(code: 'commissionSchedule.id.label', default: 'Id')}" />

                            <g:sortableColumn property="scheduleName" title="${message(code: 'commissionSchedule.scheduleName.label', default: 'Schedule Name')}" />

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
                <g:paginate total="${commissionScheduleInstanceTotal}" />
            </div>
        </div>
      </div>
    </div>
  </body>
</html>
