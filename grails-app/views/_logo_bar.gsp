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
        <a href="#" class="navMenu helpContent">Storitz Help</a>
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
    <div id="helpContent" title="Storitz Help">
      <p>
        Storitz lets you search, compare, and book self-storage all from the comfort of your computer.  To get started, follow our simple three-step search process on the homepage:
      </p>
      <ol>
        <li>Enter the zip code or city where you are looking for storage, this will help us show you the facilities closest to you</li>
        <li>Select your unit size, this allows us to show you the best prices for that particular unit type (use the size guide if you’re unsure how much space you need)</li>
        <li>Select your desired move-in date, meaning the day in the future when you want to move your things in to storage</li>
      </ol>
      <p>
        Your search will give you many different storage facilities in your area for you to compare based on price, location, and features.  By clicking on a facility’s Rent Me button, you can see additional details and photos of the facility that will help you determine if it is the right facility for you.  Also on this page you will see a Total Move-in Cost for the unit size you selected at that facility.  This total move-in cost includes the rent owed through your paid through date (found in the lower right hand corner of the transaction box) as well as any property admin fees or insurance that may be required at that property.  Property admin fees are charged by the storage facility, and are not a cost of booking with Storitz.  To book your unit, click the “Rent Me” button on the property page and complete our easy two-step checkout process.
      </p>
      <p>
        You can drag the map to see more storage in the area, or scale the map up or down in size to see more or fewer facilities in your search.
      </p>
      <p>
        If you have any further questions, or need help with searching or booking on Storitz, please call us at  (877) 456-2929 or <g:link controller="contactUs" action="create">contact us</g:link> .
      </p>
    </div>
    <p:dependantJavascript>
    <script type="text/javascript">
//<![CDATA[
      $(document).ready(function() {
        $('#helpContent').dialog({
          autoOpen: false,
          resizable: false,
          width: 500
        }).addTouch();
        $('a.helpContent').click(function(event) {
          event.preventDefault();
          $('#helpContent').dialog('open');
        });
      });
//]]>
    </script>
    </p:dependantJavascript>
  </div>
  <div style="clear:both;"></div>
</div>
