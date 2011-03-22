<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN"
    "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head>
  <g:set var="title" value="Metro List" scope="request"/>
  <g:render template="/header_admin"/>

  <p:dependantJavascript>
    <script type="text/javascript">
      //<![CDATA[

      $(document).ready(function() {
        setupUserSelector();
      });

      function setupUserSelector() {
        $("input#city").autocomplete({source:"${createLink(controller:'metro', action:'autocompleteMetro')}"});
      }

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
      <span class="button"><a href="${createLink(controller: 'admin', action: 'index')}">Menu</a></span>
      <span class="button"><g:link action="create">New Metro</g:link></span>
    </div>
    <div class="body">

      <div class="price_options checkout_header white">
        List Metro Areas
      </div>

      <g:if test="${flash.message}">
        <div class="message">${flash.message}</div>
      </g:if>
      <g:form action="list" method="post">
        <div class="dialog">
          <table>
            <tbody>
            <tr class='prop'>
              <td valign='top' class='name'>
                <label for='city'>Metro:</label>
              </td>
              <td valign='top' class='value'>
                <input type="text" id="city" name="city" value="${flash.city}"/>
                <span class="button"><input class="save" type="submit" value="Search"/></span>
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

            <g:sortableColumn property="id" title="Id" params="${flash}"/>

            <g:sortableColumn property="city" title="Metro" params="${flash}"/>

            <g:sortableColumn property="state" title="State" params="${flash}"/>

            <th>Edit</th>

          </tr>
          </thead>
          <tbody>
          <g:each in="${metroList}" status="i" var="metroInstance">
            <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">

              <td><g:link action="show" id="${metroInstance.id}">${fieldValue(bean: metroInstance, field: 'id')}</g:link></td>

              <td>${fieldValue(bean: metroInstance, field: 'city')}</td>

              <td>${metroInstance?.state?.display}</td>

              <td><g:link action="edit" id="${metroInstance.id}">edit</g:link></td>

            </tr>
          </g:each>
          </tbody>
        </table>
      </div>
      <div class="paginateButtons">
        <g:paginate total="${metroListCount ? metroListCount : 0}" params="[city:params?.city]"/>
      </div>
    </div>
  </div>
</div>
</body>
<p:renderDependantJavascript/>
</html>
