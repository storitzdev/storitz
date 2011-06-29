<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN"
    "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head>
  <g:set var="title" value="Export Images" scope="request"/>
  <g:render template="/header"/>

  <script type="text/javascript">
    //<![CDATA[
    //]]>
  </script>

</head>
<body>
<div id="body">

  <div class="stcontent">
    <g:render template="/logo_bar"/>
    <div class="body">

    <h1>Image Export and Upload Service</h1>
    <h3>${status}</h3>
    <pre>${message}</pre>

    <g:form action="export">
        <table border="0">
            <thead>
                <th colspan="2">Image Service</th>
            </thead>
            <tbody>
                <g:radioGroup name="imageServer"
                    labels="['Picasa','FlickR','Photo Bucket', 'Face Book']"
                    values="['Picasa', 'FlickR', 'PhotoBucket', 'FaceBook']"
                    value="Picasa">
                    <tr><td>${it.label}</td><td>${it.radio}</td></tr>
                </g:radioGroup>
            </tbody>
        </table>

        <div class="buttons">
          <span class="button"><input class="save" type="submit" value="Export & Upload Images"/></span>
        </div>
    </g:form>


    </div>
  </div>
</div>
</body>
<p:renderDependantJavascript/>
</html>
