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
        if (idMatch.getCount()) {
          def idNum = idMatch[0][1]
          def siteHtml = new URL(pageUrl).text
          def usiMatch = siteHtml =~ /(?i)usi(\d+)-/
          if (usiMatch.getCount()) {
            def usiNum = usiMatch[0][1]
            if (usiNum.size() < 4) {
              usiNum = '0' + usiNum
            }
            def site = StorageSite.findByFeedAndTitleLike(ustoreitFeed, usiNum + '%')
            println "Searching for feed id = ${ustoreitFeed.id} and title starting with ${usiNum} found = ${site != null} page url= ${pageUrl}"
            if (site) {
              def imageList = []
              for (siteImage in site.siteImages()) {
                imageList.add(siteImage)
              }
              println "Getting ready to delete ${imageList.size()}"
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
                def ext
                def newName
                if (fileName.size > 0) {
                  ext = '.' + fileName.tokenize('.')[-1]
                  newName = "Storitz-${site.city}-${site.state.display}-${site.title}-self-storage-units-${imgOrder}${ext}"
                }
                def filePath = fileUploadService.getFilePath('/images/site', newName, siteId)
                def filePathMid = fileUploadService.getFilePath('/images/site', 'mid-' + newName, siteId)
                def filePathThumb = fileUploadService.getFilePath('/images/site', 'thumb-' + newName, siteId)
                ++imgOrder
                imageService.scaleImages(new File(tmpPath), site.id, imgOrder, filePath, filePathMid, filePathThumb, site)
                imageService.iptcTagImage(new File(filePath), site, imgOrder, 'FULL')
                imageService.iptcTagImage(new File(filePathMid), site, imgOrder, 'MID')
                imageService.iptcTagImage(new File(filePathThumb), site, imgOrder, 'THUMB')

                println "\tProcessed to ${filePath}"
                site.save(flush:true)
              }
            }
          }
        }
      }
      render(status: 200, text: "Done processing images")
    }

    def titles = {
      def ustoreitManager = User.findByUsername('ustoreit')
      def ustoreitFeed = (CenterShift)Feed.findByManager(ustoreitManager)
      for(site in ustoreitFeed.sites) {
        def title
        if (site.title.contains("/")) {
          title = 'U-Store-It ' + site.title.tokenize("/")[-1]
        } else {
          def titleArr = site.title.tokenize(" ")
          title = "U-Store-It " + titleArr[1..titleArr.size()-1].join(' ')
        }
        site.title = title
        site.save(flush: true)
      }
      render(status: 200, text: "Done processing titles")
    }
}
