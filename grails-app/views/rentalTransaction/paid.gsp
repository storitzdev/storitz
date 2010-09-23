<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN"
    "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" >
  <head>
    <g:render template="/header_ssl" />

    <script type="text/javascript">
//<![CDATA[

  Event.observe(window, 'load', function() {
  });

//]]>
  </script>

  </head>
  <body>
    <div id="body">
    <g:render template="/topnav" />
    <div id="stcontent">
      <g:render template="/logo_bar" />
      <div id="site_info" class="left" style="margin-top: 26px;">
        <g:render template="/siteInfo" />

      </div>
      <div style="width: 650px;" class="right">
        <div id="detailInfo">
            <div id="rentalForm">
              <g:form action="pay" controller="rentalTransaction" name="rentalTransaction" method="post" id="${params.id}">

                <div class="vert_text">
                  <span id="step1_bullet" class="bullet" style="display: none;">&#8226</span><span id="step1" class="step_header">Renter Information</span>
                  <span id="step2_bullet" class="bullet" style="display: none;">&#8226</span><span id="step2" class="step_header">Payment</span>
                  <span id="step3_bullet" class="bullet">&#8226</span><span id="step3" class="step_header_hi">Order Complete</span>
                </div>
                <g:if test="${flash.message}">
                  <div class="message">${flash.message}</div>
                </g:if>
                <div class="price_options checkout_header white">
                  Paid
                </div>
                <div class="formInstructions">
                  Your payment for this unit has already been processed.  If you believe you have reached this page by
                  mistake, please <g:link controller="contactUs" action="create">Contact Us</g:link>.
                </div>

              </g:form>
            </div>
        </div>
      </div>
    </div>

    <div style="clear:both; height:30px;"></div>
    <g:render template="/footer" />
    <g:render template="/size_popup" />
    </div>
  </body>
</html>