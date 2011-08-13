<%@ page import="storitz.constants.UnitType" %>
${unit.displaySize ? unit.displaySize.replaceAll(/(\d+(\.\d+)?) X (\d+(\.\d+)?)/, "\$1' x \$3'") : "??"}
<g:if test="${omitType}">
  Unit
</g:if>
<g:else>
  ${unit.displayType()}
</g:else>