<%@ page contentType="text/xml;charset=UTF-8" %><?xml version="1.0" encoding="UTF-8"?>
<urlset xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xmlns="http://www.sitemaps.org/schemas/sitemap/0.9"
        xsi:schemaLocation="http://www.sitemaps.org/schemas/sitemap/0.9 http://www.sitemaps.org/schemas/sitemap/0.9/sitemap.xsd"
        xmlns:image="http://www.google.com/schemas/sitemap-image/1.1"
        xmlns:geo="http://www.google.com/geo/schemas/sitemap/1.0">

<g:each in="${siteList}" var="${site}">
  <url>
    <loc><g:createLink absolute="true" mapping="siteLink" controller="storageSite" action="detail" id="${site.id}" params="[city:site.city, site_title:site.title]"/></loc>
    <changefreq>weekly</changefreq>
    <priority>0.75</priority>
    <lastmod>${site.lastChange.format('yyyy-MM-dd')}</lastmod>
    <image:image>
       <image:loc><g:createLinkTo absolute="true" file="${resource(file: site.coverImage()?.mid())}"/></image:loc>
       <image:title>${site.title.encodeAsHTML()}</image:title>
    </image:image>
  </url>
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