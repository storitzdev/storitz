<%@ page import="com.storitz.StoritzUtil" %>
<html>
<head>
  <title>Self Storage in ${state.fullName}</title>
  <meta name="keywords" content="${state.fullName} self storage, ${state.display} self storage, self storage, mini storage, storage units, self storage units, mini storage units, storage lockers, rv storage, boat storage, military storage, student storage, storage, storitz" />
  <meta name="description" content="Self storage in ${state.fullName}, listed city by city" />
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
