<%@ page import="org.codehaus.groovy.grails.commons.ConfigurationHolder" %>
<?xml version="1.0" encoding="UTF-8"?>
<?xml-stylesheet type="text/xsl" href="${resource(absolute: true, dir: 'css', file: 'gss.xsl')}"?>
<urlset xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns="http://www.sitemaps.org/schemas/sitemap/0.9" xsi:schemaLocation="http://www.sitemaps.org/schemas/sitemap/0.9 http://www.sitemaps.org/schemas/sitemap/0.9/sitemap.xsd" xmlns:image="http://www.google.com/schemas/sitemap-image/1.1" xmlns:geo="http://www.google.com/geo/schemas/sitemap/1.0">
    <g:each in="${videoList}" var="video">
        <url>
           <loc><g:createLink mapping="video" absolute="true" params="[id:video.id, date:video.releaseDate.format('MM-dd-yyyy'), title:video.urlTitle ? video.urlTitle : video.title]"/></loc>
           <changefreq>weekly</changefreq>
           <priority>0.5</priority>
           <lastmod>${new Date().format('yyyy-MM-dd')}</lastmod>
        </url>
    </g:each>
</urlset>
