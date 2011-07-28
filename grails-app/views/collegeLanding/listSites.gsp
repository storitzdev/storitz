<%@ page import="storitz.constants.TransactionType; storitz.constants.SearchType; storitz.constants.UnitType; storitz.constants.TruckType" %>
<html>
<head>
    <title>${title}</title>
    <meta name="keywords" content="${college.displayName}, self storage, mini storage, storage units, self storage units, mini storage units, storage lockers, rv storage, boat storage, military storage, student storage, storage, storitz" />
    <p:css name="college" />
    <script type="text/javascript">
      var _gaq = _gaq || [];
        _gaq.push(["_setCustomVar", 1, "nresults", "${clientSites.size}"]);
        // TODO: track additional properties of result set: closest result, avg distance, # results w/in 2/5/10 mi, etc.
    </script>
    <style type="text/css">
        h2.collegiate {
            color:${college.primaryFGColor ?: 'blue'};
            background:${college.primaryBGColor ?: 'wheat'} url(../images/bg-text-line.png) repeat-x;
        }
        #footer {
            background:${college.primaryBGColor ?: 'wheat'};
        }
        #college_logo {
            background: url(${resource(file: college.logoBaseName + college.logoFileLoc)}) no-repeat;
        }
    </style>
</head>
<body class="college serp">
<div id="promo">
    <storitz:image src="img-15.jpg" alt="image description" width="949" height="268" />
    <p class="tagline">Got a few things you don’t want to keep at Mom &amp; Dad’s?</p>
    <p><a href="http://www.storitz.com">Storitz.com</a> lets you compare 1000s of
    summer storage units and rent all online with our
    <g:link controller="static" action="guarantee"><em>Best Price
    Guarantee</em></g:link>.</p>
    <p><a href="#" id="rebate_tile">Rent your storage unit online today from
    storitz.com and get $20 cash back! Click for details</a></p>
    <div class="photo_credit">Photo by <a href="http://www.collegehumor.com" target="_blank">collegehumor.com</a></div>
</div>
<div id="main_container">
    <div id="college_logo">&nbsp;</div>
    <h2 class="collegiate">Self Storage Units Near <span class="college_name">${college.displayName}</span></h2>
    <div id="rebate_panel">
        <storitz:image src="rebate20-header-large.png" width="749" height="63" />
        <dl>
            <dt>How to Claim Your Rebate</dt>
            <dd>Once you rent or reserve a storage unit, you'll receive an email from us with a link
            to your rebate form &amp; instructions for sending it to us! Simple!</dd>
        </dl>
        <a class="close button">Close</a>
    </div>
    <g:link action="storageTips" elementId="college_tips_button">Storage 101: College Summer Storage Tips for Students</g:link>
    <div id="college_tips_panel">
      <a class="close" href="#">Close</a>
      <iframe src="<g:createLink action="storageTips" params="[layout:'min']" />"></iframe>
    </div>
    <g:render template="/search/results" model="${resultsModel}" />
</div>
<p:dependantJavascript>
<script type="text/javascript">
  var d=document,l=d.location;
  d.write('<sc'+'ript src="'+'http'+(l.protocol=='https:'?'s://maps-api-ssl':'://maps')+'.google.com'+'/maps/api/js?v=3&client=gme-storitz&sensor=false" type="text/javascript"></sc'+'ript>');
  $(d).ready(function() {
    initialize_college_landing_page();
  });
  bindPickerFormHandler('.formpicker','picker','.results_container','.spinner');
</script>
</p:dependantJavascript>
</body>
</html>
