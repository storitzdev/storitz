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
    <g:render template="/topnav" />
    <div id="stcontent">
      <g:render template="/logo_bar" />
    	<div id='login'>
          <div class='inner'>
              <g:if test='${flash.message}'>
              <div class='login_message'>${flash.message}</div>
              </g:if>
              <div class='fheader'>Please Login..</div>
              <form action='${postUrl}' method='POST' id='loginForm' class='cssform'>
                  <p>
                      <label for='username'>Login ID</label>
                      <input type='text' class='text_' name='j_username' id='username' />
                  </p>
                  <p>
                      <label for='password'>Password</label>
                      <input type='password' class='text_' name='j_password' id='password' />
                  </p>
                  <p>
                      <label for='remember_me'>Remember me</label>
                      <input type='checkbox' class='chk' name='${rememberMeParameter}' id='remember_me'
                      <g:if test='${hasCookie}'>checked='checked'</g:if> />
                  </p>
                  <p>
                      <input type='submit' value='Login' />
                  </p>
              </form>
          </div>
      </div>
	</div>
<script type='text/javascript'>
<!--
(function(){
	document.forms['loginForm'].elements['j_username'].focus();
})();
// -->
</script>
</body>
