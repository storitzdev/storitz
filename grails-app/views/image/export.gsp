<%@ page contentType="text/html;charset=UTF-8" %>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head>
  <g:set var="title" value="Export Images" scope="request"/>
</head>
<body>
<div id="body">

  <div class="stcontent">
    <div class="body">

        <div class="buttons">
          <span class="button"><a href="${createLink(controller: 'admin', action: 'index')}">Menu</a></span>
        </div>


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
</html>
