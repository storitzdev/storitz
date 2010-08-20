<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN"
    "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" >
  <head>
    <g:set var="title" value="User List"/>
    <g:render template="/header" />

    <script type="text/javascript">
//<![CDATA[
//]]>
  </script>

  </head>
  <body>
    <div id="body">
      <g:render template="/topnav" />
      <div id="stcontent">
        <g:render template="/logo_bar" />

        <div class="buttons">
            <span class="button"><a href="${createLink(controller:'admin', action:'index')}">Menu</a></span>
            <span class="button"><g:link action="create">New Commission Range</g:link></span>
        </div>
        <div class="body">

            <div class="price_options checkout_header white">
              List Commission Entries
            </div>

            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="list">
                <table>
                    <thead>
                        <tr>
                        
                            <g:sortableColumn property="id" title="${message(code: 'commission.id.label', default: 'Id')}" />

                            <g:sortableColumn property="lowerBound" title="${message(code: 'commission.lowerBound.label', default: 'Lower Bound')}" />

                            <g:sortableColumn property="upperBound" title="${message(code: 'commission.upperBound.label', default: 'Upper Bound')}" />

                            <g:sortableColumn property="amount" title="${message(code: 'commission.amount.label', default: 'Amount')}" />
                        
                            <g:sortableColumn property="commissionType" title="${message(code: 'commission.commissionType.label', default: 'Commission Type')}" />

                            <g:sortableColumn property="commissionSource" title="${message(code: 'commission.commissionSource.label', default: 'Commission Source')}" />

                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${commissionInstanceList}" status="i" var="commissionInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td><g:link action="show" id="${commissionInstance.id}">${fieldValue(bean: commissionInstance, field: "id")}</g:link></td>
                        
                            <td>${fieldValue(bean: commissionInstance, field: "lowerBound")}</td>

                            <td>${fieldValue(bean: commissionInstance, field: "upperBound")}</td>

                            <td>${fieldValue(bean: commissionInstance, field: "amount")}</td>
                        
                            <td>${fieldValue(bean: commissionInstance, field: "commissionType")}</td>

                            <td>${commissionInstance.commissionSource.display}</td>

                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${commissionInstanceTotal}" />
            </div>
        </div>
      </div>
    </div>
  </body>
</html>
