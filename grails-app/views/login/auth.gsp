<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
  <meta name="KEYWORDS" content="self-storage, personal storage, moving, storage units, click, store"/>
  <meta name="ROBOTS" content="FOLLOW"/>

  <p:css name="login"/>
  <g:set scope="request" var="title" value="Storitz Login"/>
</head>
<body>
<div id="body">

  <div class="stcontent">
    <div id='login'>
      <div class='inner'>
        <g:if test='${flash.message}'>
          <div class='login_message'>${flash.message}</div>
        </g:if>
        <div class='fheader'>Please Login:</div>
        <form action='${postUrl}' method='post' id='loginForm' class='cssform'>
          <p>
            <label for='username'>Login ID</label>
            <input type='text' class='inputBox' name='j_username' id='username'/>
          </p>
          <p>
            <label for='password'>Password</label>
            <input type='password' class='inputBox' name='j_password' id='password'/>
          </p>
          <p>
            <label for='remember_me'>Remember me</label>
            <input type='checkbox' class='chk' name='${rememberMeParameter}' id='remember_me'
              <g:if test='${hasCookie}'>checked='checked'</g:if>/>
          </p>
          <p>
            <input type='submit' value='Login'/>
          </p>
        </form>
      </div>
      <div style="height:30px;"></div>
    </div>
  </div>
</div>
</body>
<script type='text/javascript'>
  <!--
  (function() {
    document.forms['loginForm'].elements['j_username'].focus();
  })();
  // -->
</script>
</html>