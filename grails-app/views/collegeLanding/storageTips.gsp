<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN"
    "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head>
<g:render template="/header_college"/>
</head>
<body class="college_storage_tips ${params.layout == 'min' ? 'min' : 'full'}">
<div id="header">
    <strong class="logo"><a href="listSites.gsp#">Storitz</a></strong>
    <div class="text-holder">
        <strong class="subheading">The Storitz Advantage</strong>
        <strong class="heading">Find and Rent Self Storage right here, right now.</strong>
    </div>
    <a href="listSites.gsp#" class="btn-need-assistance">Need Assistance? (877) 465-29-29</a>
    <form action="listSites.gsp#" class="search-form" id="gsearch" method="post">
        <fieldset>
            <legend>search</legend>
            <input tabindex="10" class="text" type="text" id="address" value="Enter Address or Zip" title="Enter Address or Zip"/>
            <input tabindex="11" type="submit" class="submit" id="btn-search" value="" title="search submit"/>
        </fieldset>
    </form>
</div>
<g:render template="storage_tips_body" />
<div id="footer">
    <p class="copyright">
    &copy; 2010-2011 Storitz Inc. All rights reserved.
    Use of this website signifies your agreement to the <g:link controller="static" action="terms">Terms of Use</g:link> and
    Online Privacy Policy.</p>
</div>
</body>
</html>
