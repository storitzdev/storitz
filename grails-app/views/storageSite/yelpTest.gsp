<%@ page import="storitz.constants.UnitType; com.storitz.StoritzUtil; storitz.constants.TransactionType" %>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head></head>
<body class="yelp_test">
<h1>hello world!</h1>
<table>
  <tbody>
  <tr>
    <th>Storage Sites</th>
    <th>Yelp ratings</th>
  </tr>
  <g:if test="${siteList.size()}">
    <g:each in="${siteList}" var="entry">
      <tr>
       <td class="${entry.id}">${entry.id}, ${entry.title}, ${entry.address}, ${entry.city}</td>
       <td class="yelp${entry.id}"></td>
      </tr>
    </g:each>
  </g:if>
  </tbody>
</table>
</body>
</html>