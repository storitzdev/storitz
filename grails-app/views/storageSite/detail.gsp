<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN"
    "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" >
  <head>
    <g:render template="/header" />

    <script type="text/javascript">
//<![CDATA[
    var storageSize = [];
    <g:each var="size" in="${sizeList}">storageSize[${size.id}] = "${size.description}";</g:each>
    // searchSize = ${params.searchSize}
    <g:if test="${params.searchSize}">
      var sizeDescription = storageSize[ ${params.searchSize} ];
    </g:if>

    function setupSize() {
      if(typeof(sizeDescription) !== 'undefined')  {
        $('sizeDescription').replace(sizeDescription);
      }
    }

    FastInit.addOnLoad(setupSize);
//]]>
  </script>

  </head>
  <body>
    <g:render template="/topnav" />
    <div id="stcontent">
      <g:render template="/logo_bar" />
      <div>
        <div id="site_info">
          <div class="title">
          ${site.title}
          </div>
          <g:if test="${site.logoUrl}">
            <div>
              <img src="${site.logoUrl}" alt="logo"/>
            </div>
          </g:if>
          <div>
            ${site.description}
          </div>
          <div>
            ${site.address}
          </div>
          <div>
            ${site.city}, ${site.state} ${site.zipcode}
          </div>
          <div style="height: 15px;"></div>
          <!--
            get the default image for the site here
          -->
          <g:if test="${params.searchSize}">
            <div>
              Results for size  <span id="sizeDescription"></span>
            </div>
          </g:if>
        </div>
        <div id="map">
          <img src="http://maps.google.com/maps/api/staticmap?center=${site.lat},${site.lng}&zoom=15&size=300x300&maptype=roadmap&markers=color:blue|${site.lat},${site.lng}&sensor=false&key=ABQIAAAAEDNru_s_vCsZdWplqCj4hxSjGMYCLTKEQ0TzQvUUxxIh1qVrLhTUMUuVByc3xGunRlZ-4Jv6pHfFHA" alt="Map of ${site.title}"/>
        </div>
        <div style="clear: both;"/>
      </div>
    </div>
    <div style="height:30px;"></div>
    <g:render template="/footer" />
  </body>
</html>