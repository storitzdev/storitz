<g:form controller="${controller}" action="${action}" name="${name}" method="get">
    <input type="hidden" name="where" id="where" value="${where}" />
    <input type="hidden" name="view-mode" id="view-mode" value="" />
    <g:render template="/search/results1" />
</g:form>
<g:render template="/search/results2" />


