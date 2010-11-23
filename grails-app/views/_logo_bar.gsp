<div class="stcontent" style="margin-top:15px;">
  <div class="left" style="width:300px;margin-right:15px;">
    <g:link controller="home" action="index">
      <storitz:image src="storitz-logo.png" width="241" height="77" class="noborder"/>
    </g:link> 
  </div>
  <div class="left" style="width:635px;">
    <div>
      <div class="left bannerMasthead">
        <div class="mastheadCenter mastheadTop">Welcome to Storitz</div>
        <div class="mastheadCenter mastheadBottom">Let's find self storage that's right for you.</div>
      </div>
      <div class="left tollFree">
        <div style="font-size:8px;">NEED BOOKING ASSISTANCE?</div>
        <div style="font-size:16px;">(877) 456-2929</div>
      </div>
      <div style="clear:both;"></div>
    </div>
    <div  style="margin-top: 15px;">
      <div class="left" style="margin-top: 5px;">
        <g:if test="${params.controller =='home'}">
          <g:link controller="home" action="index" class="navHighlight">Home</g:link>
        </g:if>
        <g:else>
          <g:link controller="home" action="index" class="navMenu">Home</g:link>
        </g:else>
        <g:if test="${params.controller =='static' && params.action == 'faq'}">
          <g:link controller="static" action="faq" class="navHighlight">Self Storage FAQs</g:link>
        </g:if>
        <g:else>
          <g:link controller="static" action="faq" class="navMenu">Self Storage FAQs</g:link>
        </g:else>
        <a href="http://blog.storitz.com" class="navMenu">Blog</a>
        <g:link controller="static" action="help" class="navMenu">Storitz Help</g:link>
        <g:if test="${params.controller =='static' && params.action == 'operatorsignup'}">
          <g:link controller="static" action="operatorsignup" class="navHighlight">Add Your Facility</g:link>
        </g:if>
        <g:else>
          <g:link controller="static" action="operatorsignup" class="navMenu">Add Your Facility</g:link>
        </g:else>
      </div>
      <div class="right">
        <a href="http://twitter.com/Storitzdotcom" target="_blank"><storitz:image style="border: none;" src="twitter-icon-page.gif" width="20" height="20" alt="Storitz on Twitter"/></a>
        <a href="http://www.facebook.com/storitz" target="_blank"><storitz:image style="border: none;" src="facebook-icon-page.gif" width="20" height="20" alt="Storitz on FaceBook"/></a>
        <a href="http://www.stumbleupon.com/submit?url=http://www.storitz.com/" target="_blank"><storitz:image style="border: none;" src="stumbleupon-icon-page.gif" width="20" height="20" alt="Storitz on StumbleUpon"/></a>
        <a href="http://www.linkedin.com/companies/storitz-inc?trk=fc_badge" target="_blank"><storitz:image style="border: none;" src="linkedin-icon-page.gif" width="20" height="20" alt="Storitz on LinkedIn"/></a>
        <a href="http://www.youtube.com/user/Storitzdotcom" target="_blank"><storitz:image style="border: none;" src="youtube-icon-page.gif" width="20" height="20" alt="Storitz Youtube Channel"/></a>
      </div>
      <div style="clear:both;"></div>
    </div>
  </div>
  <div style="clear:both;"></div>
</div>
