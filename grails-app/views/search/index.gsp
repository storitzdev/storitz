<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
  <title>${queryTerm} Self Storage</title>
  <meta name="keywords" content="${queryTerm} self storage, self storage, mini storage, storage units, self storage units, mini storage units, storage lockers, rv storage, boat storage, military storage, student storage, storage, storitz" />
  <meta name="description" content="Find and rent self storage in ${queryTerm} with Storitz.com" />
</head>
<body class="serp metro">
<h1>Self Storage Prices &amp; Special Offers Near <strong>${queryTerm ? queryTerm : "You!"}</strong></h1>
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