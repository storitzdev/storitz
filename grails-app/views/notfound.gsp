<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN"
    "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head>
  <g:set var="title" value="Storitz 404 Error" scope="request"/>
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
    <div id="staticMenu" class="left" style="margin-top: 26px;">
      <!-- menu section -->
    </div>
    <div style="width: 650px;margin-right: 35px;" class="right">

      <h1>Storitz Not Found</h1>

      <div class="formInstructions">
        We're not sure, what you were looking for, but how about finding some storage:
        <g:link controller="home" action="index">Storitz</g:link>.
      </div>

    </div>
  </div>
  <div style="clear:both; height:30px;"></div>
</div>
</body>
<p:renderDependantJavascript/>
</html>