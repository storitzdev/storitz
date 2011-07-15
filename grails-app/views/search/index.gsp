<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head><title>Self Storage Prices &amp; Special Offers Near ${queryTerm}</title></head>
<body class="serp metro">
<h1>Self Storage Prices &amp; Special Offers Near <strong>${queryTerm}</strong></h1>
<g:render template="/search/results" model="${resultsModel}"/>
<p:dependantJavascript>
<script type="text/javascript">
  var d=document,l=d.location;
  d.write('<sc'+'ript src="'+'http'+(l.protocol=='https:'?'s://maps-api-ssl':'://maps')+'.google.com'+'/maps/api/js?v=3&client=gme-storitz&sensor=false" type="text/javascript"></sc'+'ript>');
  $(d).ready(function() {
    initialize_serp();
  });

  bindPickerFormHandler('.formpicker','picker','.results_container','.spinner');
</script>
</p:dependantJavascript>
</body>
</html>