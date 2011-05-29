<%@ page import="java.math.RoundingMode" %>
<html>
<head>
  <title>Self Storage in ${state.fullName}</title>
</head>
<body class="state_directory">
<h1>Self Storage Facilities in ${state.fullName}</h1>
<table>
    <tr>
        <g:each in="${cityLists}" var="cityList">
            <td>
                <g:each in="${cityList}" var="city">
                    <div>
                          <g:link controller="search" action="metro" params="[metro:city.asQueryParam]">${city.name}</g:link> (${city.numSites})
                    </div>
                </g:each>
            </td>
        </g:each>
    </tr>
</table>
</body>
</html>
