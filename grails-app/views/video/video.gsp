<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN"
    "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" >
  <head>
    <g:set var="title" scope="request" value="${videoInstance.title}"/>
    <g:render template="/header_home" />
    <meta name="DESCRIPTION" content="${videoInstance.caption}"/>

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

        <h1>${videoInstance.title}</h1>
        <h3>${videoInstance.releaseDate.format('MM-dd-yyyy')}</h3>

        <p>
          <div>
            <div id="videoContainer"></div>
          </div>
          <p:dependantJavascript>
          <script type="text/javascript">
              jwplayer("videoContainer").setup({
                  flashplayer: "${resource(file:'/jwplayer/player.swf')}",
                  file: "${resource(file:videoInstance.fileLocation)}",
                  image: "${resource(file:videoInstance.stillImage)}",
                  height: 480,
                  width: 640
              });
          </script>
          </p:dependantJavascript>
        </p>
        <div style="margin-top: 10px;">
          <g:if test="${videoInstance.site}">
            <span style="font-weight:bold;">Related Storage Facility:</span>&nbsp;<g:link mapping="siteLink" params="[city:videoInstance.site.city, state:videoInstance.site.state.display, site_title:videoInstance.site.title, id:videoInstance.site.id]">${videoInstance.site?.title}</g:link>
          </g:if>
        </div>
        <div>
          ${videoInstance.caption}
        </div>
        <!-- AddThis Button BEGIN -->
        <div class="addthis_toolbox addthis_default_style ">
        <a href="http://www.addthis.com/bookmark.php?v=250&amp;username=xa-4d11385a59ec26da" class="addthis_button_compact">Share</a>
        <span class="addthis_separator">|</span>
        <a class="addthis_button_preferred_1"></a>
        <a class="addthis_button_preferred_2"></a>
        <a class="addthis_button_preferred_3"></a>
        <a class="addthis_button_preferred_4"></a>
        </div>
        <script type="text/javascript" src="http://s7.addthis.com/js/250/addthis_widget.js#username=xa-4d11385a59ec26da"></script>
        <!-- AddThis Button END -->
        <p>
          <span style="font-weight:bold;">Tags:</span>${videoInstance.tags}
        </p>
      </div>
    </div>

    <div style="clear:both; height:30px;"></div>
      <g:render template="/footer" />
    </div>
  </body>
  <p:renderDependantJavascript />
</html>