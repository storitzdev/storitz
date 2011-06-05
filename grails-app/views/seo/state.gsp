<%@ page import="com.storitz.StoritzUtil" %>
<html>
<head>
  <title>Self Storage in ${state.fullName}</title>
</head>
<body class="state_directory">
<h1>Self Storage Facilities in ${state.fullName}</h1>
<table>
    <tr>
        <td>
        <g:set var="i" value="${0}" />
        <g:each in="${cities}" var="city">
            <div>
                <g:link mapping="metro2" params="[city:StoritzUtil.seoEncode(city.name), state:state.display.toLowerCase()]">${city.name}</g:link> (${city.numSites})
            </div>
            <g:set var="i" value="${i + 1}" />
            <g:if test="${i > 0 && i % citiesPerColumn == 0 && i < cities.size()}">
        </td><td>
            </g:if>
        </g:each>
        </td>
    </tr>
</table>
</body>
</html>
