<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN"
    "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" >
  <head>
    <g:render template="/header" />

    <script type="text/javascript">
//<![CDATA[

  <g:render template="/directions_js" />

  Event.observe(window, 'load', function() {
    getDirections();
    createDirectionMap();
  });

//]]>
  </script>
  <script type="text/javascript" src="http://maps.google.com/maps/api/js?v=3.1&sensor=false&key=ABQIAAAAEDNru_s_vCsZdWplqCj4hxSjGMYCLTKEQ0TzQvUUxxIh1qVrLhTUMUuVByc3xGunRlZ-4Jv6pHfFHA"></script>

  </head>
  <body>
    <div id="body">
    <g:render template="/topnav" />
    <div id="stcontent">
      <g:render template="/logo_bar" />
        <div id="site_info" class="left" style="margin-top: 26px;">
          <g:render template="/siteInfo" />
        </div>

        <div style="width: 650px;" class="left">

          <div id="detailInfo">
            <div style="height: 25px; clear: both;"></div>


            <div id="detail_tabs">
              <g:render template="/directions"/> 
            </div>
            <div style="clear:both;"></div>
          </div>

        </div>
    </div>
    <div style="clear:both; height:30px;"></div>
    <g:render template="/footer" />
    </div>
  </body>
</html>