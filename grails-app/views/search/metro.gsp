<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
  <title>${queryTerm} Self Storage</title>
  <meta name="keywords" content="${queryTerm} self storage, self storage, mini storage, storage units, self storage units, mini storage units, storage lockers, rv storage, boat storage, military storage, student storage, storage, storitz" />
  <meta name="description" content="Find and rent self storage in ${queryTerm} with Storitz.com" />
</head>
<body class="serp metro">
<g:if test="${params.searchType == 'PARKING'}">
    <h1>RV Parking Prices &amp; Special Offers Near <strong>${queryTerm ? queryTerm : "You!"}</strong></h1>
</g:if>
<g:else>
    <h1>Self Storage Prices &amp; Special Offers Near <strong>${queryTerm ? queryTerm : "You!"}</strong></h1>
</g:else>
<div id="tweet_serp">
    <a href="http://twitter.com/share" class="twitter-share-button" data-count="horizontal" data-via="storitzdotcom">Tweet</a>
</div>
<g:render template="/search/results" model="${resultsModel}"/>
<p:dependantJavascript>
<script type="text/javascript">
  var d=document,l=d.location;
  d.write('<sc'+'ript src="'+'http'+(l.protocol=='https:'?'s':'')+'://maps.googleapis.com/maps/api/js?key=AIzaSyBFwOS98y0mDcMVTvOO7jG7SVyBPMOrFUc&sensor=false" type="text/javascript"></sc'+'ript>');
  $(d).ready(function() {
    initialize_serp();
  });

  bindPickerFormHandler('.formpicker','picker','.results_container','.spinner');
</script>
</p:dependantJavascript>
</body>
</html>