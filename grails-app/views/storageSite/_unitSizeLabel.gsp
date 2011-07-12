<%@ page import="storitz.constants.UnitType" %>
${unit.displaySize ? unit.displaySize.replaceAll(/(\d+) X (\d+)/, "\$1' x \$2'") : "??"}
<g:if test="${unit.unitType == UnitType.INTERIOR}">
  Interior Unit (Ground Floor)
</g:if>
<g:elseif test="${unit.unitType == UnitType.DRIVEUP}">
  Drive-Up Unit
</g:elseif>
<g:elseif test="${unit.unitType == UnitType.UPPER}">
  Upper Floor Unit
</g:elseif>
<g:elseif test="${unit.unitType == UnitType.COVERED}">
  Covered Parking Space
</g:elseif>
<g:elseif test="${unit.unitType == UnitType.COVERED}">
  Covered Parking Space
</g:elseif>
<g:elseif test="${unit.unitType == UnitType.COVERED}">
  Uncovered Parking Space
</g:elseif>
<g:else>
  Unit
</g:else>