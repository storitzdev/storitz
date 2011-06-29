<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN"
    "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head>
  <p:css name="login"/>
  <p:css name="main"/>

  <script type="text/javascript">
    //<![CDATA[
    //]]>
  </script>

</head>
<body>
<div id="body">

  <div class="stcontent">
    <g:render template="/logo_bar"/>
    <div id='login'>
      <div class='inner'>
        <g:if test='${flash.message}'>
          <div class='login_message'>${flash.message}</div>
        </g:if>
        <div class='fheader'>You have been logged out.</div>
      </div>
      <div style="height:100px;"></div>
    </div>
  </div>
</div>
</body>
</html>