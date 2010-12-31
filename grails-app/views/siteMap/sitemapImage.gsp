<?xml version="1.0" encoding="UTF-8"?>
<?xml-stylesheet type="text/xsl" href="${resource(absolute: true, dir:'css', file:'gss.xsl')}"?>
<urlset xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns="http://www.sitemaps.org/schemas/sitemap/0.9" xsi:schemaLocation="http://www.sitemaps.org/schemas/sitemap/0.9 http://www.sitemaps.org/schemas/sitemap/0.9/sitemap.xsd" xmlns:image="http://www.google.com/schemas/sitemap-image/1.1" xmlns:geo="http://www.google.com/geo/schemas/sitemap/1.0">
<g:each in="${siteList}" var="${site}">
  <g:if test="${site.city && site.state}">
    <url>
      <loc><g:createLink absolute="true" mapping="siteLink2" controller="storageSite" action="detail" params="[site_title:site.title, id:site.id]"/></loc>
      <changefreq>weekly</changefreq>
      <priority>0.75</priority>
      <lastmod>${site.lastChange ? site.lastChange.format('yyyy-MM-dd') : new Date().format('yyyy-MM-dd')}</lastmod>
      <image:image>
          <image:loc><g:createLinkTo absolute="true" file="${resource(file: site.coverImage()?.mid())}"/></image:loc>
          <image:caption>Image of ${site.title.replace("&", "&amp;").replace("\"", "&quot;").replace("<", "&lt;")}</image:caption>
          <image:geo_location>${site.getFullAddress().replace("&", "&amp;").replace("\"", "&quot;").replace("<", "&lt;")}</image:geo_location>
          <image:title>${site.title.replace("&", "&amp;").replace("\"", "&quot;").replace("<", "&lt;")}</image:title>
      </image:image>
      <g:each var="image" in="${site.images}">
        <image:image>
            <image:loc><g:createLinkTo absolute="true" file="${resource(file: image.mid())}"/></image:loc>
            <image:caption>Image of ${site.title.replace("&", "&amp;").replace("\"", "&quot;").replace("<", "&lt;")}</image:caption>
            <image:geo_location>${site.getFullAddress().replace("&", "&amp;").replace("\"", "&quot;").replace("<", "&lt;")}</image:geo_location>
            <image:title>${site.title.replace("&", "&amp;").replace("\"", "&quot;").replace("<", "&lt;")}</image:title>
        </image:image>
      </g:each>
    </url>
  </g:if>
</g:each>
</urlset>