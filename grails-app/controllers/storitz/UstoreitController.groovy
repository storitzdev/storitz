package storitz

import grails.converters.XML
import com.storitz.CenterShift
import com.storitz.StorageSize
import com.storitz.StorageSite
import com.storitz.Feed
import com.storitz.User

class UstoreitController {

    def fileUploadService
    def imageService

    def index = { }

    def images = {
      def ustoreitManager = User.findByUsername('ustoreit')
      def ustoreitFeed = (CenterShift)Feed.findByManager(ustoreitManager)
      def random = new Random()
      def sitemapXml = new URL("http://www.ustoreit.com/sitemap.xml").text
      def matcher = sitemapXml =~ /<loc>(http:\/\/.+?(\d+)\.html)<\/loc>/
      matcher.each {
        def pageUrl = it[1]
        def idMatch = pageUrl  =~ /(\d+)/
        if (idMatch.size() > 0) {
          def idNum = idMatch[0][1]
          def siteHtml = new URL(pageUrl).text
          def usiMatch = siteHtml =~ /usi(\d+)-/
          if (usiMatch.size() > 0) {
            def usiNum = usiMatch[0][1]
            if (usiNum.size() < 4) {
              usiNum = '0' + usiNum
            }
            def site = StorageSite.findByFeedAndTitleLike(ustoreitFeed, usiNum + '%')
            if (site) {
              def imageList = []
              for (siteImage in site.images) {
                imageList.add(siteImage)
              }
              for (siteImage in imageList) {
                imageService.deleteImage(site, siteImage)
              }
              println "Page URL: ${pageUrl} pageId: ${idNum} usiId: ${usiNum} - found site: ${site.title}"
              def xmlUrl = "http://www.ustoreit.com/find-storage-and-rates/xml.ashx?facID=${idNum}|1?cachebuster=${random.nextInt(1000000)}&timestamp=${System.currentTimeMillis()}"
              def gallery = new XmlSlurper().parseText(new URL(xmlUrl).text)
              def basePath = gallery.setup.@path
              def imgOrder = 0
              for(item in gallery.item) {
                println "\tImage: ${item.img}"
                def address = "http://www.ustoreit.com${basePath}${(item.img as String).replaceAll(' ','%20')}"
                def fileName = address.tokenize("/")[-1]
                def tmpPath = fileUploadService.getFilePath('/images/upload', site.id + '_' + fileName, site.id)
                def dirPath = new File(fileUploadService.getFilePath('/images/upload', '', site.id))
                dirPath.mkdirs()
                def file = new FileOutputStream(tmpPath)
                def out = new BufferedOutputStream(file)
                out << new URL(address).openStream()
                out.close()
                def filePath = fileUploadService.getFilePath('/images/site', site.id + '_' + fileName, site.id)
                def filePathMid = fileUploadService.getFilePath('/images/site', 'mid_' + site.id + '_' + fileName, site.id)
                def filePathThumb = fileUploadService.getFilePath('/images/site', 'thumb_' + site.id + '_' + fileName, site.id)
                imageService.scaleImages(new File(tmpPath), site.id, imgOrder, filePath, filePathMid, filePathThumb, site)
                println "\tProcessed to ${filePath}"
                ++imgOrder
              }
            }
          }
        }
      }
      render(status: 200, text: "Done processing images")
    }
}
