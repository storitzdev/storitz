<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN"
    "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" >
  <head>
    <g:render template="/header" />
    <link href="${createLinkTo(dir:'css', file:'login.css')}" media="screen" rel="stylesheet" type="text/css" />

    <script type="text/javascript">
//<![CDATA[
//]]>
  </script>

  </head>
  <body>
    <div id="body">
    <g:render template="/topnav" />
    <div id="stcontent">
      <g:render template="/logo_bar" />
    	<div id='login'>
          <div class='inner'>
              <g:if test='${flash.message}'>
              <div class='login_message'>${flash.message}</div>
              </g:if>
              <div class='fheader'>Change Password</div>
              <g:form controller="user" action="changePassword" method="POST" id="passwordForm" class='cssform'>
                  <p>
                      <label for='oldPasswd'>Old Password</label>
                      <input type='password' class='inputBox' name='oldPasswd' id='oldPasswd' />
                  </p>
                  <p>
                      <label for='passwd'>New Password</label>
                      <input type='password' class='inputBox' name='passwd' id='passwd' />
                  </p>
                  <p>
                      <label for='repasswd'>Repeat Password</label>
                      <input type='password' class='inputBox' name='repasswd' id='repasswd' />
                  </p>
                  <p>
                      <input type='submit' value='Change Password' />
                  </p>
              </g:form>
          </div>
      </div>
	</div>
<script type='text/javascript'>
<!--
(function(){
	$('oldPasswd').focus();
})();
// -->
</script>
</div>
</body>
</html>