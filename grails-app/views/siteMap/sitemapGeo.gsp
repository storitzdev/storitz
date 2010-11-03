<?xml version="1.0" encoding="UTF-8"?>
<?xml-stylesheet type="text/xsl" href="${resource(absolute: true, dir:'css', file:'gss.xsl')}"?>
<urlset xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns="http://www.sitemaps.org/schemas/sitemap/0.9" xsi:schemaLocation="http://www.sitemaps.org/schemas/sitemap/0.9 http://www.sitemaps.org/schemas/sitemap/0.9/sitemap.xsd" xmlns:image="http://www.google.com/schemas/sitemap-image/1.1" xmlns:geo="http://www.google.com/geo/schemas/sitemap/1.0">
<g:each in="${siteList}" var="${site}">
  <url>
     <loc><g:createLink absolute="true" controller="storageSite" action="kml" id="${site.id}" /></loc>
     <geo:geo>
         <geo:format>kml</geo:format>
     </geo:geo>
  </url>
</g:each>
</urlset>