<%@ page import="storitz.constants.UnitType; com.storitz.StoritzUtil; storitz.constants.TransactionType" %>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head><title>yelp test</title>
<link rel="canonical" href="${StoritzUtil.storageSiteCanonicalLink(createLink(mapping: 'detail', absolute: true, params: params) as String)}" /></head>
<body class="yelp_test">
<h1>hello world!</h1>
<table id="sites">
  <tbody>
  <tr>
    <th>Storage Sites</th>
    <th>Yelp ratings</th>
  </tr>
  <g:if test="${siteList.size()}">
    <g:each in="${siteList}" var="entry">
      <tr class="site-test">
       <td class="${entry.id}" id="${entry.id}" lat="${entry.lat}" lng="${entry.lng}">${entry.id}, ${entry.title}, ${entry.address}, ${entry.city}, ${entry.state}</td>
       <td class="yelp${entry.id}"></td>
      </tr>
    </g:each>
  </g:if>
  </tbody>
</table>
<p:dependantJavascript>
    <script>
        $(document).ready(function() {
          yelpTest();
        });
    </script>
</p:dependantJavascript>
</body>
</html>