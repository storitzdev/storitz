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
<g:each in="${storitz.constants.State.listSeo()}" var="state">
  <url>
    <loc><g:createLink absolute="true" mapping="state2" params="[state:state.display]"/></loc>
    <changefreq>weekly</changefreq>
    <priority>0.5</priority>
  </url>
</g:each>
<g:each in="${metroList}" var="metro">
  <url>
    <loc><g:createLink absolute="true" mapping="metro2" params="[city:metro.city, state:metro.state.display]"/></loc>
    <changefreq>weekly</changefreq>
    <priority>0.5</priority>
  </url>
</g:each>
<g:each in="${metroEntryList}" var="metroEntry">
  <url>
    <loc><g:createLink absolute="true" mapping="geo2" params="[zip:metroEntry.zipcode]"/></loc>
    <changefreq>weekly</changefreq>
    <priority>0.5</priority>
  </url>
</g:each>
<g:each in="${siteList}" var="${site}">
  <g:if test="${site.city && site.state}">
    <url>
      <loc><g:createLink absolute="true" mapping="siteLink2" controller="storageSite" action="detail" id="${site.id}" params="[site_title:site.title]"/></loc>
      <changefreq>weekly</changefreq>
      <priority>0.75</priority>
      <lastmod>${site.lastChange ? site.lastChange.format('yyyy-MM-dd') : new Date().format('yyyy-MM-dd')}</lastmod>
    </url>
  </g:if>
</g:each>
</urlset>