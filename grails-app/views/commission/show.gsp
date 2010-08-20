<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN"
    "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" >
  <head>
    <g:set var="title" value="Show Commission Entry"/>
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
            <span class="button"><a class="home" href="${createLink(controller:'admin', action:'index')}">Menu</a></span>
            <span class="button"><g:link action="list">Commission List</g:link></span>
            <span class="button"><g:link action="create">New Commission Entry</g:link></span>
        </div>
        <div class="body">

            <div class="price_options checkout_header white">
              Show Commission Entry
            </div>

            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="dialog">
                <table>
                    <tbody>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="commission.id.label" default="Id" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: commissionInstance, field: "id")}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="commission.commissionType.label" default="Commission Source" /></td>

                            <td valign="top" class="value">${commissionInstance?.commissionSource?.display}</td>

                        </tr>

                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="commission.amount.label" default="Amount" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: commissionInstance, field: "amount")}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="commission.commissionType.label" default="Commission Type" /></td>
                            
                            <td valign="top" class="value">${commissionInstance?.commissionType?.display}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="commission.lowerBound.label" default="Lower Bound" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: commissionInstance, field: "lowerBound")}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="commission.upperBound.label" default="Upper Bound" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: commissionInstance, field: "upperBound")}</td>
                            
                        </tr>
                    
                    </tbody>
                </table>
            </div>
            <div class="buttons">
                <g:form>
                    <g:hiddenField name="id" value="${commissionInstance?.id}" />
                    <span class="button"><g:actionSubmit class="edit" action="edit" value="${message(code: 'default.button.edit.label', default: 'Edit')}" /></span>
                    <span class="button"><g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" /></span>
                </g:form>
            </div>
        </div>
      </div>
    </div>
  </body>
</html>
