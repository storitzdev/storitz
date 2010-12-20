<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN"
    "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" >
  <head>
    <g:set var="title" scope="request" value="${pressReleaseInstance.title}"/>
    <g:render template="/header" />
    <meta name="DESCRIPTION" content="${pressReleaseInstance.blurb}"/>

    <script type="text/javascript">
//<![CDATA[

//]]>
  </script>

  </head>
  <body>
    <div id="body">
    <g:render template="/topnav" />
    <div class="stcontent">
      <g:render template="/logo_bar" />
      <div id="staticMenu" class="left" style="margin-top: 26px;">
        <!-- menu section -->
      </div>
      <div style="width: 650px;margin-right: 35px;" class="right">

        <h1>${pressReleaseInstance.title}</h1>
        <h3>${pressReleaseInstance.releaseDate.format('MM-dd-yyyy')}</h3>

        <p>
          ${pressReleaseInstance.body}
        </p>
        <p>
          <a href="${resource(file:pressReleaseInstance.pdfLocation)}" onclick="window.open(this.href,'_blank');return false;"><storitz:image src="icn_pdf.jpg" width="36" height="36" alt="PDF"/></a>
        </p>
        <p>
          <span style="font-weight:bold;">Tags:</span>${pressReleaseInstance.tags}
        </p>
        <div style="height: 20px;"></div>
        <div class="buttons">
          <span class="button"><a href="${createLink(controller:'pressRelease', action:'pressRoom')}">Back</a></span>
        </div>
      </div>
    </div>

    <div style="clear:both; height:30px;"></div>
      <g:render template="/footer" />
    </div>
  </body>
  <p:renderDependantJavascript />
</html>