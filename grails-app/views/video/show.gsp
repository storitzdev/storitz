<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN"
    "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head>
  <g:set var="title" value="Show Video" scope="request"/>
  <g:render template="/header_home"/>

  <script type="text/javascript">
    //<![CDATA[
    //]]>
  </script>

</head>
<body>
<div id="body">
  <g:render template="/topnav"/>
  <div class="stcontent">
    <g:render template="/logo_bar"/>

    <div style="clear: both;height: 10px"></div>
    <div class="buttons">
      <span class="button"><a href="${createLink(controller: 'admin', action: 'index')}">Menu</a></span>
      <span class="button"><g:link action="list">List Videos</g:link></span>
      <sec:ifAnyGranted roles="ROLE_MANAGER">
        <span class="button"><g:link action="create">Create New Video</g:link></span>
      </sec:ifAnyGranted>

    </div>
    <div class="body">

      <div class="price_options checkout_header white">
        Video Details
      </div>

      <g:if test="${flash.message}">
        <div class="message">${flash.message}</div>
      </g:if>
      <div class="dialog">
        <table>
          <tbody>

          <tr class="prop">
            <td valign="top" class="name"><g:message code="video.id.label" default="Id"/></td>

            <td valign="top" class="value">${fieldValue(bean: videoInstance, field: "id")}</td>

          </tr>

          <tr class="prop">
            <td valign="top" class="name"><g:message code="video.title.label" default="Title"/></td>

            <td valign="top" class="value">${fieldValue(bean: videoInstance, field: "title")}</td>

          </tr>

          <tr class="prop">
            <td valign="top" class="name"><g:message code="video.urlTitle.label" default="URL Title"/></td>

            <td valign="top" class="value">${fieldValue(bean: videoInstance, field: "urlTitle")}</td>

          </tr>

          <tr class="prop">
            <td valign="top" class="name"><g:message code="video.releaseDate.label" default="Release Date"/></td>

            <td valign="top" class="value">${videoInstance.releaseDate.format('MM-dd-yyyy')}</td>

          </tr>

          <tr class="prop">
            <td valign="top" class="name"><g:message code="video.caption.label" default="Caption"/></td>

            <td valign="top" class="value">${videoInstance.caption}</td>

          </tr>


          <tr class="prop">
            <td valign="top" class="name"><g:message code="video.file.label" default="Video"/></td>

              <td valign="top" class="value">
                  <div id="videoContainer"></div>
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
              </td>

          </tr>

          <tr class="prop">
              <td valign="top" class="name">Use Youtube</td>
              <td valign="top" class="value">${videoInstance.useYouTube ? "Yes" : "No"}</td>
          </tr>

          <tr class="prop">
              <td valign="top" class="name">Youtube Video ID</td>
              <td valign="top" class="value">${videoInstance.youTubeId}</td>
          </tr>

          <tr class="prop">
            <td valign="top" class="name"><g:message code="video.tags.label" default="Tags"/></td>

            <td valign="top" class="value">${videoInstance.tags}</td>

          </tr>

          <tr class="prop">
            <td valign="top" class="name"><g:message code="video.site.label" default="Related Facility"/></td>

            <td valign="top" class="value">
              <g:if test="${videoInstance.site}">
                <g:link mapping="siteLink2" params="[site_title:videoInstance.site.title, id:videoInstance.site.id]">${videoInstance.site?.title}</g:link>
              </g:if>
            </td>

          </tr>

          <tr class="prop">
            <td valign="top" class="name"><g:message code="video.external.link.label" default="External Link"/></td>

            <td valign="top" class="value">
              <g:createLink mapping="video" absolute="true" params="[id:videoInstance.id, date:videoInstance.releaseDate.format('MM-dd-yyyy'), title:videoInstance.urlTitle ? videoInstance.urlTitle : videoInstance.title]"/>
            </td>

          </tr>

        </table>
      </div>
      <div class="buttons">
        <g:form>
          <g:hiddenField name="id" value="${videoInstance?.id}"/>
          <span class="button"><g:actionSubmit action="edit" value="${message(code: 'default.button.edit.label', default: 'Edit')}"/></span>
          <span class="button"><g:actionSubmit action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');"/></span>
          <span class="button"><g:link mapping="video" absolute="true" params="[id:videoInstance.id, date:videoInstance.releaseDate.format('MM-dd-yyyy'), title:videoInstance.title]">View as User</g:link></span>
        </g:form>
      </div>
    </div>
  </div>
</div>
</body>
<p:renderDependantJavascript/>
</html>
