<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN"
    "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" >
  <head>
    <g:set var="title" value="Show Metro" scope="request"/>
    <g:render template="/header_admin" />

  </head>
  <body>
    <div id="body">
    <g:render template="/topnav" />
    <div class="stcontent">
      <g:render template="/logo_bar" />
        <div class="buttons">
            <span class="button"><a class="home" href="${createLink(controller:'admin', action:'index')}">Menu</a></span>
            <span class="button"><g:link action="list">Metro List</g:link></span>
            <span class="button"><g:link action="create">New Metro</g:link></span>
        </div>
        <div class="body">

          <div class="price_options checkout_header white">
            Show Metro
          </div>

            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="dialog">
                <table>
                    <tbody>

                    
                        <tr class="prop">
                            <td valign="top" class="name">Id:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:metroInstance, field:'id')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Metro:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:metroInstance, field:'city')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">State:</td>
                            
                            <td valign="top" class="value">${metroInstance?.state?.display}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Neighborhood:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:metroInstance, field:'isNeighborhood')}</td>
                            
                        </tr>
                    

                        <tr class="prop">
                            <td valign="top" class="name">Description:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:metroInstance, field:'note')}</td>
                            
                        </tr>
                    
                    </tbody>
                </table>
            </div>
            <div class="buttons">
                <g:form>
                  <input type="hidden" name="id" value="${metroInstance?.id}" />
                  <span class="button"><g:link action="edit" id="${metroInstance?.id}">Edit</g:link></span>
                  <span class="button"><g:actionSubmit action="delete" onclick="return confirm('Are you sure?');" value="Delete" /></span>
                </g:form>
            </div>
        </div>
      </div>
    </div>
  </body>
  <p:renderDependantJavascript />
</html>
