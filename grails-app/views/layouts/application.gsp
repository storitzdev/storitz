<%@ page import="org.codehaus.groovy.grails.commons.ConfigurationHolder" contentType="text/html;charset=UTF-8" %>
<html>
    <head>
        <title><g:layoutTitle default="Rent Best Price Guaranteed Self Storage - Storitz" /></title>
        <meta name="keywords" content="self-storage, household storage, self storage, storage unit, self storage unit, moving and  relocation storage, storage pods, container storage, compare self storage, storage comparison, lowest storage rent, best storage prices, storage units for rent,  storage unit rental, self storage, self-storage search engine, self-storage directory, self storage facility,  find self storage, mini storage, Military storage, College student storage, University storage, Senior citizen storage"/>
        <p:favicon src="images/storitz-favicon"/>
        <meta name="msvalidate.01" content="341E6494DB6B0393BB4866E8E337BDBB" /> <!-- Bing validator -->
        <META name="y_key" content="9a7a338eec8978fd"/>
        <p:css name="bundled" />
        <p:dependantJavascript>
            <script type="text/javascript" src="${request.isSecure() ? "https" : "http"}://oauth.googlecode.com/svn/code/javascript/oauth.js"></script>
            <script type="text/javascript" src="${request.isSecure() ? "https" : "http"}://oauth.googlecode.com/svn/code/javascript/sha1.js"></script>
        </p:dependantJavascript>
        <!--[if IE]> <link href="${resource(dir:'css', file:'application_ie.css')}" rel="stylesheet" type="text/css"> <![endif]-->
        <g:layoutHead />
    </head>
    <body class="${pageProperty(name:'body.class') ? pageProperty(name:'body.class') : 'default'}">
        <div id="header">

            <span id="storitz-logo"${(ConfigurationHolder.config?.storitz?.beta) ? ' class="beta"' : ''}">
                Storitz.com. Click. Store. Done.
                <g:link controller="home" action="index"></g:link>
            </span>
            <g:form class="search" controller="search" action="index" name="search" id="search" method="get">
                <fieldset>
                    <label>Find self storage:</label>
                    <g:if test="${queryTerm}">
                      <input class="text" type="text" name="where" value="${queryTerm}" placeholder="Enter address, zip code, or city &amp; state"/>
                    </g:if>
                    <g:else>
                      <input class="text" type="text" name="where" placeholder="Enter address, zip code, or city &amp; state"/>
                    </g:else>
                    <input class="text" type="hidden" name="collegeName" value="${college?.name}" />
                    <input id="search_button" type="submit" name="btn" value="Search" />
                </fieldset>
            </g:form>
            <div id="phone_support">
                <strong>Need assistance?</strong>
                <span id="call_now">Call now:</span>
                <span id="toll_free">877-456-2929</span>
            </div>
        </div>
        <g:layoutBody />
        <g:render template="/v2footer"></g:render>
        <script type="text/javascript">
          document.write(unescape("%3Cscript src='" + document.location.protocol + "//zopim.com/?OnxU61sHAyKJAixaCrj9vqqwCQ1JzaPN' charset='utf-8' type='text/javascript'%3E%3C/script%3E"));
        </script>
        <g:pageProperty name="page.gwo" />
        <p:renderDependantJavascript />
    </body>
</html>