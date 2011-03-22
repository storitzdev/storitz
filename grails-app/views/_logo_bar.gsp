<div class="stcontent" style="margin-top:15px;">
  <div class="left" style="width:300px;margin-right:15px;">
    <g:link controller="home" action="index">
      <storitz:image src="storitz-logo.png" width="241" height="77" class="noborder"/>
    </g:link>
  </div>
  <div class="left" style="width:635px;">
    <div>
      <div class="left bannerMasthead">
        <div class="mastheadCenter mastheadTop"><h2 class="mastheadTop">The Storitz Advantage:</h2></div>
        <g:if test="${params.controller =='home'}">
          <div class="mastheadCenter mastheadBottom"><h1 class="mastheadBottom">Find and rent self storage right here, right now.</h1></div>
        </g:if>
        <g:else>
          <div class="mastheadCenter mastheadBottom"><h2 class="mastheadBottom">Find and rent self storage right here, right now.</h2></div>
        </g:else>
      </div>
      <div class="left tollFree">
        <div style="font-family:verdana;font-size:9px;text-transform:capitalize;color:#266e00;line-height:15px;margin: 10px 0 0 34px;">NEED ASSISTANCE?</div>
        <div style="font-family:verdana; font-weight: bold; font-size:13px;color:#fff;margin-left: 34px;">(877) 456-2929</div>
      </div>
      <div style="clear:both;"></div>
    </div>
    <div style="margin-top: 15px;">
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
        <a href="http://blog.storitz.com" class="navMenu" target="_blank">Blog</a>
        <a href="${resource(dir: '/help')}" title="Storitz Help" class="navMenu dialogContent">Storitz Help</a>
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
    <p:dependantJavascript>
      <script type="text/javascript">
        //<![CDATA[
        $(document).ready(function() {
          $('a.dialogContent').each(function() {
            var link = $(this)
            var dialog = $('<div>').load(link.attr('href'))
                    .dialog({
              title: link.attr('title'),
              width: 500,
              autoOpen: false
            });
            link.click(function(event) {
              event.preventDefault();
              dialog.dialog('open');
              _gaq.push(['funnelTracker._trackEvent', 'help', 'open']);
              return false;
            });
          });
        });
        //]]>
      </script>
    </p:dependantJavascript>
  </div>
  <div style="clear:both;"></div>
</div>
