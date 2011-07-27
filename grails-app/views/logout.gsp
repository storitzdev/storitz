<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
  <p:css name="login"/>
</head>
<body>
<div id="body">

  <div class="stcontent">
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