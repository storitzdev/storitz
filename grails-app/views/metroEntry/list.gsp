<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN"
    "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" >
  <head>
    <g:set var="title" value="Metro Entry List" scope="request"/>
    <g:render template="/header_admin"/>

    <p:dependantJavascript>
      <script type="text/javascript">
//<![CDATA[

      $(document).ready(function() {

        setupUserSelector();
      });

      function setupUserSelector() {
        $("input#city").autocomplete({source:"${createLink(controller:'metroEntry', action:'autocompleteMetroEntry')}"});
      }

//]]>
    </script>
  </p:dependantJavascript>
  </head>
  <body>
    <div id="body">
    <g:render template="/topnav" />
    <div class="stcontent">
      <g:render template="/logo_bar" />
        <div class="buttons">
            <span class="button"><a href="${createLink(controller:'admin', action:'index')}">Menu</a></span>
            <span class="button"><g:link action="create">New Metro Entry</g:link></span>
        </div>
        <div class="body">

          <div class="price_options checkout_header white">
            List Metro Areas
          </div>

            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:form action="list" method="post" >
                <div class="dialog">
                    <table>
                        <tbody>
                          <tr class='prop'>
                                <td valign='top' class='name'>
                                    <label for='city'>Metro Entry:</label>
                                </td>
                                <td valign='top' class='value'>
                                  <input type="text" id="city" name="city" value="${flash.city}"/>
                                  <span class="button"><input class="save" type="submit" value="Search" /></span>
                                </td>
                            </tr>
                        </tbody>
                      </table>
                  </div>
            </g:form>
            <div style="height:20px;"></div>
            <div class="list">
                <table>
                    <thead>
                        <tr>
                        
                   	        <g:sortableColumn property="id" title="Id" params="${flash}" />
                        
                            <g:sortableColumn property="zipcode" title="Zip Code" params="${flash}" />
                        
                   	        <g:sortableColumn property="city" title="Neighborhood" params="${flash}" />
                        
                   	        <g:sortableColumn property="state" title="State" params="${flash}"/>
                        
                            <g:sortableColumn property="metro.city" title="Metro" params="${flash}"/>
                          
                            <th>Edit</th>

                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${metroEntryList}" status="i" var="metroEntryInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td><g:link action="show" id="${metroEntryInstance.id}">${fieldValue(bean:metroEntryInstance, field:'id')}</g:link></td>
                        
                            <td>${fieldValue(bean:metroEntryInstance, field:'zipcode')}</td>

                            <td>${fieldValue(bean:metroEntryInstance, field:'city')}</td>
                        
                            <td>${metroEntryInstance?.state?.display}</td>
                        
                            <td>${metroEntryInstance?.metro?.city}, ${metroEntryInstance?.metro?.state?.display}</td>

                            <td><g:link action="edit" id="${metroEntryInstance.id}">edit</g:link></td>

                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
              <g:paginate total="${metroEntryListCount ? metroEntryListCount : 0}" params="[city:params?.city]"/>
            </div>
            <g:uploadForm action="upload" method="post" >
                <div class="dialog">
                    <table>
                        <tbody>
                          <tr class='prop'>
                                <td valign='top' class='name'>
                                    <label for='city'>File with entries:</label>
                                </td>
                                <td valign='top' class='value'>
                                  <input type="file" name="uploadFile" />
                                  <span class="button"><input class="save" type="submit" value="Upload" /></span>
                                </td>
                            </tr>
                        </tbody>
                      </table>
                  </div>
            </g:uploadForm>

        </div>
      </div>
    </div>
  </body>
  <p:renderDependantJavascript/>
</html>
