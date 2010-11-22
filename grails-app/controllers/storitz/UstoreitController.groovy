package storitz

import grails.converters.XML

class UstoreitController {

    def index = { }

    def images = {
      def sitemapXml = new URL("http://www.ustoreit.com/sitemap.xml").text
      def matcher = sitemapXml =~ /<loc>http:\/\/.+?(\d+)\.html<\/loc>/
      matcher.each {
        println it[1]
      }
    }
}
