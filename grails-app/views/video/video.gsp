<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN"
    "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head>
  <g:set var="title" scope="request" value="${videoInstance.title}"/>
  <g:render template="/header_home"/>
  <meta name="DESCRIPTION" content="${videoInstance.caption}"/>

  <script type="text/javascript">
    //<![CDATA[
    $(document).ready(function() {
      $("a.embed").click(function(event) {
        $("div#embed").toggle("fade");
        return false;
      });
    });

    //]]>
  </script>

</head>
<body>
<div id="body">

  <div class="stcontent">
    <g:render template="/logo_bar"/>
    <div id="staticMenu" class="left" style="margin-top: 26px;">
      <!-- menu section -->
    </div>
    <div style="width: 650px;margin-right: 35px;" class="right">

      <h1>${videoInstance.title}</h1>
      <h3>${videoInstance.releaseDate.format('MM-dd-yyyy')}</h3>

      <p>
      <div>
        <div id="videoContainer">
        </div>
      </div>
        <p:dependantJavascript>
            <script type="text/javascript">
                jwplayer("videoContainer").setup({
                flashplayer: "${resource(file:'/jwplayer/player.swf')}",
            <g:if test="${videoInstance.useYouTube}">
                file: "http://www.youtube.com/watch?v=${videoInstance.youTubeId}",
            </g:if>
            <g:else>
                file: "${resource(file:videoInstance.fileLocation)}",
                image: "${resource(file:videoInstance.stillImage)}",
            </g:else>
                height: 480,
                width: 640
              });
            </script>
        </p:dependantJavascript>
    </p>
      <div style="margin-top: 10px;">
        <g:if test="${videoInstance.site}">
          <span style="font-weight:bold;">Related Storage Facility:</span>&nbsp;<g:link mapping="siteLink2" params="[site_title:videoInstance.site.title, id:videoInstance.site.id]">${videoInstance.site?.title}</g:link>
        </g:if>
      </div>
      <div>
        ${videoInstance.caption}
      </div>
        <div class="buttons" style="margin-bottom: 0.5em;">
            <span class="button"><a href="#" class="embed">Embed</a></span>
            <div id="embed" style="display:none;margin:10px 0;">
                To embed this video, cut and paste the code from the box and place it in your page:
                <g:if test="${videoInstance.useYouTube}">
                    <g:if test="${videoInstance.youTubeId}">
                        <textarea style="width:600px; height:75px;">&lt;iframe width="640" height="480" src="http://www.youtube.com/embed/${videoInstance.youTubeId}" frameborder="0" allowfullscreen&gt;&lt;/iframe&gt;</textarea>
                    </g:if>
                    <g:else>
                        <textarea style="width:600px; height:75px;">No Youtube Video ID!</textarea>
                    </g:else>
                </g:if>
                <g:else>
                    <textarea style="width:600px; height:75px;"><video id="storitzvid" width="640" height="480" src="${resource(absolute: true, file: videoInstance.fileLocation)}" poster="${resource(absolute: true, file: videoInstance.stillImage)}" controls="controls"></video><script type="text/javascript" src="${resource(absolute: true, file: '/jwplayer/jwplayer.js')}"></script><script type="text/javascript">jwplayer("storitzvid").setup({flashplayer: "${resource(absolute:true, file:'/jwplayer/player.swf')}"});</script></textarea>
                </g:else>
            </div>
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

</div>
</body>
<p:renderDependantJavascript/>
</html>