<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN"
    "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" >
  <head>
    <g:set var="title" scope="request" value="Storitz Press Room and Media"/>
    <g:render template="/header" />
    <meta name="DESCRIPTION" content="Press Room. Storitz in the media - press announcements, links and other mentions.."/>

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

        <h1>Press Room</h1>

        <g:each in="${pressReleaseInstanceList}" var="release">
          <h2>${release.release.format('MM-dd-yyyy')}</h2>
          <h3>
            <g:link mapping="release" params="[title:release.title, date:release.release.format('MM-dd-yyyy'), id:release.id]" id="${release.id}">${release.title}</g:link>
          </h3>
          <p>
            ${release.blurb}
          </p>
          <p>
            <g:link mapping="release" params="[title:release.title, date:release.release.format('MM-dd-yyyy'), id:release.id]" id="${release.id}">Details</g:link>
          </p>
          <div style="height:20px;width:650px; border-bottom: #333 dotted 1px;"></div>
        </g:each>
      </div>
    </div>

    <div style="clear:both; height:30px;"></div>
      <g:render template="/footer" />
    </div>
  </body>
  <p:renderDependantJavascript />
</html>