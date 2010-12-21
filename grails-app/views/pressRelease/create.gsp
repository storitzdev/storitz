<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN"
    "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" >
  <head>
    <script src="http://www.google.com/jsapi" type="text/javascript"></script>
    <g:set var="title" value="Create Press Release" scope="request"/>
    <g:render template="/header" />
    <p:dependantJavascript>
      <script type="text/javascript">
//<![CDATA[

        $(document).ready(function() {
          var dateFormat = '%m/%d/%Y';

          // do stuff when DOM is ready
          $('#releaseDate').datepicker({
              showOn: "button",
              buttonImage: ${storitz.imageLink(src:"calendar.png")},
              buttonImageOnly: true
          });


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
    <g:render template="/topnav" />
    <div class="stcontent">
      <g:render template="/logo_bar" />

        <div class="buttons">
            <span class="button"><a href="${createLink(controller:'admin', action:'index')}">Menu</a></span>
            <span class="button"><g:link action="list">Press Release List</g:link></span>
        </div>

        <div class="body">

          <div class="price_options checkout_header white">
            Create Press Release
          </div>

            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${pressReleaseInstance}">
            <div class="errors">
                <g:renderErrors bean="${pressReleaseInstance}" as="list" />
            </div>
            </g:hasErrors>

            <g:uploadForm action="save" >
              <div class="formInstructions">
                To create the press release, edit the format for the long release, then create the blurb - this will be used on the main press release page for the list of releases.  Attach the file (PDF preferred)
              </div>

              <div class="checkout_section_header">
                Title
              </div>

              <div class="checkout_fields">
                <div style="width:400px;" class="checkout_value ${hasErrors(bean: pressReleaseInstance, field: 'title', 'errors')}">
                  <g:textField id="title" name="title" style="width: 380px;" value="${fieldValue(bean:pressReleaseInstance,field:'title')}" />
                </div>
                <div style="width:150px;" class="checkout_value ${hasErrors(bean: pressReleaseInstance, field: 'releaseDate', 'errors')}">
                  <g:textField id="releaseDate" name="releaseDate" style="width: 100px;" value="${fieldValue(bean:pressReleaseInstance,field:'releaseDate')}" />
                </div>
                <div style="clear:both;"></div>
              </div>

              <div class="checkout_labels">
                <div class="checkout_name" style="width:400px;">
                  <label for="title">Press Release Title</label>
                </div>
                <div class="checkout_name" style="width:400px;">
                  <label for="title">Release Date</label>
                </div>
                <div style="height:10px;clear:both;"></div>
              </div>

              <div class="checkout_section_header">
                Blurb (first paragraph or so...)
              </div>

              <div class="checkout_fields">
                <div style="width:660px;" class="checkout_value ${hasErrors(bean: pressReleaseInstance, field: 'blurb', 'errors')}">
                  <fckeditor:config CustomConfigurationsPath="${storitz.javascriptLink(src:'fckstoritz')}" />
                  <fckeditor:editor
                    name="blurb"
                    width="650"
                    height="300"
                    toolbar="StoritzPress">
                    ${pressReleaseInstance?.blurb}
                  </fckeditor:editor>
                </div>
                <div style="height:10px;clear:both;"></div>
              </div>

              <div class="checkout_section_header">
                Press Release Body
              </div>

              <div class="checkout_fields">
                <div style="width:660px;" class="checkout_value ${hasErrors(bean: pressReleaseInstance, field: 'body', 'errors')}">
                  <fckeditor:config CustomConfigurationsPath="${storitz.javascriptLink(src:'fckstoritz')}" />
                  <fckeditor:editor
                    name="body"
                    width="650"
                    height="400"
                    toolbar="StoritzPress">
                    ${pressReleaseInstance?.body}
                  </fckeditor:editor>
                </div>
                <div style="height:10px;clear:both;"></div>
              </div>

              <div class="checkout_section_header">
                PDF file
              </div>

              <div class="checkout_labels">
                <div class="checkout_name" style="width:400px;">
                  <input type="file" style="width:250px;" name="pdfFile" class="multi" maxlength="1" accept="pdf"/>
                </div>
                <div style="height:10px;clear:both;"></div>
              </div>

              <div class="checkout_section_header">
                Tags
              </div>

              <div class="checkout_fields">
                <div style="width:400px;" class="checkout_value ${hasErrors(bean: pressReleaseInstance, field: 'tags', 'errors')}">
                  <g:textField id="tags" name="tags" style="width: 400px;" value="${fieldValue(bean:pressReleaseInstance,field:'tags')}" />
                </div>
                <div style="clear:both;"></div>
              </div>

              <div class="checkout_labels">
                <div class="checkout_name" style="width:400px;">
                  <label for="title">Tags</label>
                </div>
                <div style="height:10px;clear:both;"></div>
              </div>

                </div>
              <div class="buttons">
                  <span class="button"><input class="save" type="submit" value="Update" /></span>
              </div>
            </g:uploadForm>
      </div>
    </div>
  </body>
  <p:renderDependantJavascript />
</html>
