<?xml version="1.0" encoding="UTF-8"?>
<?xml-stylesheet type="text/xsl" href="${resource(absolute: true, dir:'css', file:'gss.xsl')}"?>
<urlset xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns="http://www.sitemaps.org/schemas/sitemap/0.9" xsi:schemaLocation="http://www.sitemaps.org/schemas/sitemap/0.9 http://www.sitemaps.org/schemas/sitemap/0.9/sitemap.xsd" xmlns:image="http://www.google.com/schemas/sitemap-image/1.1" xmlns:geo="http://www.google.com/geo/schemas/sitemap/1.0">
  <url>
    <loc>http://www.storitz.com/</loc>
    <changefreq>weekly</changefreq>
    <priority>1.0</priority>
    <lastmod>${new Date().format('yyyy-MM-dd')}</lastmod>
  </url>
  <url>
    <loc>http://www.storitz.com/sitemap</loc>
    <changefreq>weekly</changefreq>
    <priority>0.5</priority>
    <lastmod>${new Date().format('yyyy-MM-dd')}</lastmod>
  </url>
<g:each in="${siteList}" var="${site}">
  <g:if test="${site.city && site.state}">
    <url>
      <loc><g:createLink absolute="true" mapping="siteLink" controller="storageSite" action="detail" id="${site.id}" params="[city:site.city, site_title:site.title, state:site.state.display]"/></loc>
      <changefreq>weekly</changefreq>
      <priority>0.75</priority>
      <lastmod>${site.lastChange ? site.lastChange.format('yyyy-MM-dd') : new Date().format('yyyy-MM-dd')}</lastmod>
      <image:image>
          <image:loc><g:createLinkTo absolute="true" file="${resource(file: site.coverImage()?.mid())}"/></image:loc>
          <image:caption>Image of ${site.title.replace("&", "&amp;").replace("\"", "&quot;").replace("<", "&lt;")}</image:caption>
          <image:geo_location>${site.getFullAddress().replace("&", "&amp;").replace("\"", "&quot;").replace("<", "&lt;")}</image:geo_location>
          <image:title>${site.title.replace("&", "&amp;").replace("\"", "&quot;").replace("<", "&lt;")}</image:title>
      </image:image>
    </url>
  </g:if>
</g:each>
<g:each in="${siteList}" var="${site}">
  <url>
     <loc><g:createLink absolute="true" controller="storageSite" action="kml" id="${site.id}" /></loc>
     <geo:geo>
         <geo:format>kml</geo:format>
     </geo:geo>
  </url>
</g:each>
</urlset>