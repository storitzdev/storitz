<%@ page import="com.storitz.StorageSite" contentType="text/html;charset=UTF-8" %>
<html>
  <head><title>Smart Call Center Assistance</title></head>
  <body>
  <g:form action="smartCall" method="GET">
    <span>Caller's Session ID</span><g:textField name="id" value=""/>
    <input type="submit" name="Go" value="Go"/>
    <hr/>
    <table cellpadding="3px" border="1">
      <tr><th>Call</th><th>Name</th><th>Site Title</th><th>City</th><th>ST</th><th>Search address</th></tr>
      <g:each in="${calls}" var="e">
        <g:set var="site" value="${StorageSite.get(e.value.site)}"/>
        <g:set var="rt" value="${e.value.rentalTransaction}"/>
        <tr>
          <td><g:link action="smartCall" id="${e.key}">${e.key}</g:link></td>
          <td>${rt.contactPrimary.firstName} ${rt.contactPrimary.lastName} ${rt.contactPrimary.suffixName}</td>
          <td>${site.title}</td><td>${site.city}</td><td>${site.state.display}</td>
          <td>${e.value.address}</td>
        </tr>
      </g:each>
    </table>
  </g:form>
  </body>
</html>
