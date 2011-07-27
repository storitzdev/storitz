<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
  <g:set var="title" scope="request" value="Storitz Press Room and Media"/>
  <meta name="DESCRIPTION" content="Press Room. Storitz in the media - press announcements, links and other mentions.."/>
</head>
<body>
<div id="body">

  <div class="stcontent">
    <div id="staticMenu" class="left" style="margin-top: 26px;">
      <!-- menu section -->
    </div>
    <div style="width: 650px;margin-right: 35px;" class="right">

      <h1>Press Room</h1>

      <g:each in="${pressReleaseInstanceList}" var="release">
        <h2>
          <g:link mapping="release" params="[title:release.title, date:release.releaseDate.format('MM-dd-yyyy'), id:release.id]" id="${release.id}">${release.title}</g:link>
        </h2>
        <h3>${release.releaseDate.format('MM-dd-yyyy')}</h3>
        <p>
          ${release.blurb}
        </p>
        <p>
          <g:link mapping="release" params="[title:release.title, date:release.releaseDate.format('MM-dd-yyyy'), id:release.id]" id="${release.id}">Details</g:link>
        </p>
        <div style="height:20px;width:650px; border-bottom: #333 dotted 1px;"></div>
      </g:each>
    </div>
  </div>

  <div style="clear:both; height:30px;"></div>

</div>
</body>
</html>