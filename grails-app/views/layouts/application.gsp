<%@ page contentType="text/html;charset=UTF-8" %>
<html>
    <head>
        <title><g:layoutTitle default="Rent Best Price Guaranteed Self Storage - Storitz" /></title>
        <meta name="keywords" content="self-storage, household storage, self storage, storage unit, self storage unit, moving and  relocation storage, storage pods, container storage, compare self storage, storage comparison, lowest storage rent, best storage prices, storage units for rent,  storage unit rental, self storage, self-storage search engine, self-storage directory, self storage facility,  find self storage, mini storage, Military storage, College student storage, University storage, Senior citizen storage"/>
        <p:favicon src="images/favicon"/>
        <meta name="msvalidate.01" content="341E6494DB6B0393BB4866E8E337BDBB" /> <!-- Bing validator -->
        <META name="y_key" content="9a7a338eec8978fd"/>
        %{--<p:css name="bundled_css" />--}%
        <g:layoutHead />
    </head>
    <body class="${pageProperty(name:'body.class')}">
        <div id="header">
            <g:link controller="home" action="index" elementId="logo">
                Storitz.com - Find & Rent Self Storage From 1000s of Facilities Nationwide ... Best Price Guaranteed
            </g:link>
            <g:form id="search" controller="search" action="listSites">
                <fieldset>
                    <legend>Enter your address, ZIP code, or city &amp; state:</legend>
                    <input type="text" name="q" />
                    <input type="submit" name="btn" value="Search" />
                </fieldset>
            </g:form>
            <div id="phone_support">
                <strong>Need assistance?</strong>
                <span id="call_now">Call now:</span>
                <span id="toll_free">877-456-2929</span>
            </div>
        </div>
        <div class="body">
            <g:layoutBody />
        </div>
        <div id="footer">
            <g:link controller="static" action="aboutus">About Us</g:link>
            <g:link controller="static" action="terms">Terms</g:link>
            <g:link controller="static" action="privacy">Privacy</g:link>
        </div>
        <script src="http://maps.google.com/maps/api/js?v=3&client=gme-storitz&sensor=false" type="text/javascript"></script>
        <script type="text/javascript">
          document.write(unescape("%3Cscript src='" + document.location.protocol + "//zopim.com/?OnxU61sHAyKJAixaCrj9vqqwCQ1JzaPN' charset='utf-8' type='text/javascript'%3E%3C/script%3E"));
        </script>
        %{--<p:javascript name="bundled_js" />--}%
        <g:pageProperty name="page.gwo" />
    </body>
</html>