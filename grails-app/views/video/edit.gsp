<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
  <script src="http://www.google.com/jsapi" type="text/javascript"></script>
  <g:set var="title" value="Create Press Release" scope="request"/>
  <p:dependantJavascript>
    <script type="text/javascript">
      //<![CDATA[

      function setupSiteSelector() {
        jQuery("input#sitename").autocomplete({source:"${createLink(controller:'storageSite', action:'autocompleteSite')}"});
      }

      $(document).ready(function() {
        var dateFormat = '%m/%d/%Y';

        // do stuff when DOM is ready
        $('#releaseDate').datepicker({
          showOn: "button",
          buttonImage: ${storitz.imageLink(src:"calendar.png")},
          buttonImageOnly: true
        });

        setupSiteSelector();
      });
      //]]>

    </script>
    <p:dependantJavascript>
      <p:javascript src="jquery.MetaDeta"/>
      <p:javascript src="jquery.MultiFile"/>
    </p:dependantJavascript>
    <p:javascript src="jquery.MetaDeta"/>
    <p:javascript src="jquery.MultiFile"/>
  </p:dependantJavascript>

</head>
<body>
<div id="body">

  <div class="stcontent">
    <div class="buttons">
      <span class="button"><a href="${createLink(controller: 'admin', action: 'index')}">Menu</a></span>
      <span class="button"><g:link action="list">Video List</g:link></span>
    </div>

    <div class="body">

      <div class="price_options checkout_header white">
        Create Video
      </div>

      <g:if test="${flash.message}">
        <div class="message">${flash.message}</div>
      </g:if>
      <g:hasErrors bean="${videoInstance}">
        <div class="errors">
          <g:renderErrors bean="${videoInstance}" as="list"/>
        </div>
      </g:hasErrors>

      <g:uploadForm action="save" id="${videoInstance.id}">
        <div class="formInstructions">
          To create the video page, make sure to have the video and the still image handy.  Enter a caption and title and choose a release date
        </div>

        <div class="checkout_section_header">
          Title
        </div>

        <div class="checkout_fields">
          <div style="width:400px;" class="checkout_value ${hasErrors(bean: videoInstance, field: 'title', 'errors')}">
            <g:textField id="title" name="title" style="width: 380px;" value="${fieldValue(bean:videoInstance,field:'title')}"/>
          </div>
          <div style="width:150px;" class="checkout_value ${hasErrors(bean: videoInstance, field: 'releaseDate', 'errors')}">
            <g:textField id="releaseDate" name="releaseDate" style="width: 100px;" value="${videoInstance?.releaseDate?.format('MM/dd/yyyy')}"/>
          </div>
          <div style="clear:both;"></div>
        </div>

        <div class="checkout_labels">
          <div class="checkout_name" style="width:400px;">
            <label for="title">Video Title</label>
          </div>
          <div class="checkout_name" style="width:400px;">
            <label for="title">Release Date</label>
          </div>
          <div style="height:10px;clear:both;"></div>
        </div>

        <div class="checkout_fields">
          <div style="width:400px;" class="checkout_value ${hasErrors(bean: videoInstance, field: 'urlTitle', 'errors')}">
            <g:textField id="urlTitle" name="urlTitle" style="width: 380px;" value="${fieldValue(bean:videoInstance,field:'urlTitle')}"/>
          </div>
        </div>

        <div class="checkout_labels">
          <div class="checkout_name" style="width:800px;">
            <label for="urlTitle">Video URL Title</label>
          </div>
          <div style="height:10px;clear:both;"></div>
        </div>

        <div class="checkout_section_header">
          Video Caption
        </div>

        <div class="checkout_fields">
          <div style="width:660px;" class="checkout_value ${hasErrors(bean: videoInstance, field: 'caption', 'errors')}">
            <fckeditor:config CustomConfigurationsPath="${storitz.javascriptLink(src:'fckstoritz')}"/>
            <fckeditor:editor
                    name="caption"
                    width="650"
                    height="400"
                    toolbar="StoritzPress">
              ${videoInstance?.caption}
            </fckeditor:editor>
          </div>
          <div style="height:10px;clear:both;"></div>
        </div>

        <div class="checkout_section_header">
          Video file (Optional if using YouTube)
        </div>

        <div class="checkout_labels">
          <div class="checkout_name" style="width:400px;">
            <input type="file" style="width:250px;" name="videoFile" class="multi" maxlength="1" accept="mp4|mov"/>
          </div>
          <div style="height:10px;clear:both;"></div>
        </div>

        <div class="checkout_section_header">
          Still Image (Optional if using YouTube)
        </div>

        <div class="checkout_labels">
          <div class="checkout_name" style="width:400px;">
            <input type="file" style="width:250px;" name="imageFile" class="multi" maxlength="1" accept="jpg|jpeg"/>
          </div>
          <div style="height:10px;clear:both;"></div>
        </div>

          <div class="checkout_labels">
              <div class="checkout_name" stype="width:400px">
                  <input type='radio' name='useYouTube' value='yes'
                      <g:if test="${videoInstance.useYouTube}">checked='checked'</g:if>/> Yes
                  <input type='radio' name='useYouTube' value='no'
                      <g:if test="${!videoInstance.useYouTube}">checked='checked'</g:if>/> No
              </div>
              <div style="height:10px;clear:both;"></div>
          </div>

          <div class="checkout_section_header">
            Use Youtube Player
          </div>


          <div class="checkout_labels">
              <div style="width:400px;" class="checkout_value ${hasErrors(bean: videoInstance, field: 'youTubeId', 'errors')}">
                  <g:textField id="youTubeId" name="youTubeId" style="width: 380px;" value="${videoInstance.youTubeId}"/>
            </div>
            <div style="height:10px;clear:both;"></div>
          </div>

          <div class="checkout_section_header">
            Youtube Video ID
          </div>

        <div class="checkout_section_header">
          Tags
        </div>

        <div class="checkout_fields">
          <div style="width:400px;" class="checkout_value ${hasErrors(bean: videoInstance, field: 'tags', 'errors')}">
            <g:textField id="tags" name="tags" style="width: 400px;" value="${fieldValue(bean:videoInstance,field:'tags')}"/>
          </div>
          <div style="clear:both;"></div>
        </div>

        <div class="checkout_labels">
          <div class="checkout_name" style="width:400px;">
            <label for="title">Tags</label>
          </div>
          <div style="height:10px;clear:both;"></div>
        </div>

        <div class="checkout_section_header">
          Storage Site
        </div>

        <div class="checkout_fields">
          <div style="width:400px;" class="checkout_value">
            <g:textField id="sitename" name="sitename" style="width: 400px;" value="${videoInstance?.site?.title}"/>
          </div>
          <div style="clear:both;"></div>
        </div>

        <div class="checkout_labels">
          <div class="checkout_name" style="width:400px;">
            <label for="title">Related Storage Facility</label>
          </div>
          <div style="height:10px;clear:both;"></div>
        </div>

        <div class="buttons">
          <span class="button"><g:actionSubmit action="update" value="${message(code: 'default.button.update.label', default: 'Update')}"/></span>
        </div>
      </g:uploadForm>
    </div>
  </div>
</div>
</body>
</html>
