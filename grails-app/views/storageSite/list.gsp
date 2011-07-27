<%@ page contentType="text/html;charset=UTF-8" %>c
<html>
<head>
  <g:set var="title" value="List Storage Sites" scope="request"/>

  <p:dependantJavascript>
    <script type="text/javascript">
      //<![CDATA[
      $(document).ready(function() {
        setupUserSelector();
      });

      function setupUserSelector() {
        $("input#sitename").autocomplete({source:"${createLink(controller:'storageSite', action:'autocompleteSite')}"});
      }

      //]]>
    </script>
  </p:dependantJavascript>

</head>
<body>
<div id="body">

  <div class="stcontent">

    <div style="clear: both;height: 10px"></div>
    <div class="buttons">
      <span class="button"><a href="${createLink(controller: 'admin', action: 'index')}">Menu</a></span>
      <!--  JM: Manual site creation disabled. Use automated feed.
      <sec:ifAnyGranted roles="ROLE_ADMIN">
        <span class="button"><g:link action="create">Create New Site</g:link></span>
      </sec:ifAnyGranted>
      -->
    </div>
    <div class="body">

      <div class="price_options checkout_header white">
        List Storage Sites
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
                <label for='sitename'>Site name:</label>
              </td>
              <td valign='top' class='value'>
                <input type="text" id="sitename" name="sitename" style="width:300px;" value="${flash.sitename}"/>
                <span class="button"><input class="save" type="submit" value="Search"/></span>
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

            <g:sortableColumn property="id" title="${message(code: 'storageSite.id.label', default: 'Id')}"/>

            <g:sortableColumn property="title" title="${message(code: 'storageSite.title.label', default: 'Site Name')}"/>

            <g:sortableColumn property="city" title="${message(code: 'storageSite.city.label', default: 'City')}"/>

            <g:sortableColumn property="zipcode" title="${message(code: 'storageSite.zipcode.label', default: 'Zipcode')}"/>

            <g:sortableColumn property="manager" title="${message(code: 'storageSite.manager.label', default: 'Manager')}"/>

            <th>Edit</th>

          </tr>
          </thead>
          <tbody>
          <g:each in="${storageSiteInstanceList}" status="i" var="storageSiteInstance">
            <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">

              <td><g:link action="show" id="${storageSiteInstance.id}">${fieldValue(bean: storageSiteInstance, field: "id")}</g:link></td>

              <td>${fieldValue(bean: storageSiteInstance, field: "title")}</td>

              <td>${fieldValue(bean: storageSiteInstance, field: "city")}</td>

              <td>${fieldValue(bean: storageSiteInstance, field: "zipcode")}</td>

              <td>${storageSiteInstance.getManager()?.username}</td>

              <td><g:link action="edit" id="${storageSiteInstance.id}">edit</g:link></td>

            </tr>
          </g:each>
          </tbody>
        </table>
      </div>
      <div class="paginateButtons">
        <g:paginate total="${storageSiteInstanceTotal}" params="[sitename:params?.sitename]"/>
      </div>
    </div>
  </div>
</div>
</body>
</html>
