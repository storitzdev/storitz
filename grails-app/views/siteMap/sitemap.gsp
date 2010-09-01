<%@ page contentType="text/xml;charset=UTF-8" %><?xml version="1.0" encoding="UTF-8"?>
<urlset xmlns="http://www.sitemaps.org/schemas/sitemap/0.9"
        xmlns:image="http://www.google.com/schemas/sitemap-image/1.1"
        xmlns:geo="http://www.google.com/geo/schemas/sitemap/1.0">
<g:each in="${siteList}" var="${site}">
  <url>
     <loc><g:createLink absolute="true" controller="storageSite" action="kml" id="${site.id}" /></loc>
     &lt;geo:geo>
         &lt;geo:format>kml&lt/geo:format>
     &lt;/geo:geo>
  </url>
  <url>
      <loc><g:createLink absolute="true" controller="storageSite" action="detail" id="${site.id}" /></loc>
      &lt;image:image>
         &lt;image:loc><g:createLinkTo absolute="true" file="${resource(file: site.coverImage()?.mid())}"/>&lt;/image:loc>
         &lt;image:title>${site.title.encodeAsXML()}&lt;/image:title>
      &lt;/image:image>
      <changefreq>weekly</changefreq>
  </url>
</g:each>
</urlset>