package storitz

import com.storitz.CenterShift
import com.storitz.Feed
import com.storitz.StorageSite
import com.storitz.User

class UstoreitController {

  def fileUploadService
  def imageService

  def index = { }

  def images = {
    def ustoreitManager = User.findByUsername('ustoreit')
    def ustoreitFeed = (CenterShift) Feed.findByManager(ustoreitManager)

    def random = new Random()
    def sitemapXml = new URL("http://www.ustoreit.com/sitemap.xml").text
    def matcher = sitemapXml =~ /<loc>(http:\/\/.+?(\d+)\.html)<\/loc>/
    matcher.eachWithIndex { url, i ->
      def pageUrl = url[1]
      def idMatch = pageUrl =~ /(\d+)/
      log.info "Checking URL: ${pageUrl}"
      if (idMatch.getCount()) {
        def idNum = idMatch[0][1]
        def siteHtml = pageUrl.toURL().text

        // TODO match by zip and street
        def zipMatch = siteHtml =~ /<span class=['"]postal-code['"]>(.+?)<\/span/
        def zip
        if (zipMatch.getCount()) {
          zip = zipMatch[0][1]
        } else {
          zipMatch = siteHtml =~ /postal-code/
          if (zipMatch.getCount()) {
            log.info "Did not match, but found postal-code..."
          }
        }

        def addrMatch = siteHtml =~ /<span class=['"]street-address['"]>(.+?)<\/span/
        def addr
        if (addrMatch.getCount()) {
          addr = addrMatch[0][1].trim().toLowerCase()
        }

        if (addr && zip) {
          def site = ustoreitFeed.sites.find{it.title ==~ /\d{4} .+/ && it.address.trim().toLowerCase() == addr && it.zipcode == zip}
          if (site) {
            def imageList = []
            for (siteImage in site.siteImages()) {
              imageList.add(siteImage)
            }
            log.info "Getting ready to delete ${imageList.size()}"
            for (siteImage in imageList) {
              imageService.deleteImage(site, siteImage)
            }
            log.info "Page URL: ${pageUrl} pageId: ${idNum} - found site: ${site.title}"
            def xmlUrl = "http://www.ustoreit.com/find-storage-and-rates/xml.ashx?facID=${idNum}|1?cachebuster=${random.nextInt(1000000)}&timestamp=${System.currentTimeMillis()}"
            def gallery = new XmlSlurper().parseText(new URL(xmlUrl).text)
            def basePath = gallery.setup.@path
            def imgOrder = 0
            for (item in gallery.item) {
              log.info "\tImage: ${item.img}"
              def address = "http://www.ustoreit.com${basePath}${(item.img as String).replaceAll(' ', '%20')}"
              def fileName = address.tokenize("/")[-1]
              def ext = '.' + fileName.tokenize('.')[-1]
              def newName = "Storitz-${site.city}-${site.state.display}-${site.title}-self-storage-units-${imgOrder}${ext}"
              def tmpPath = fileUploadService.getFilePath('/images/upload', newName, site.id)
              def dirPath = new File(fileUploadService.getFilePath('/images/upload', '', site.id))
              dirPath.mkdirs()
              def file = new FileOutputStream(tmpPath)
              def out = new BufferedOutputStream(file)
              out << new URL(address).openStream()
              out.close()
              def filePath = fileUploadService.getFilePath('/images/site', newName, site.id)
              def filePathMid = fileUploadService.getFilePath('/images/site', 'mid-' + newName, site.id)
              def filePathThumb = fileUploadService.getFilePath('/images/site', 'thumb-' + newName, site.id)
              ++imgOrder
              imageService.scaleImages(new File(tmpPath), site.id, imgOrder, filePath, filePathMid, filePathThumb, site)
              imageService.iptcTagImage(new File(filePath), site, imgOrder, 'FULL')
              imageService.iptcTagImage(new File(filePathMid), site, imgOrder, 'MID')
              imageService.iptcTagImage(new File(filePathThumb), site, imgOrder, 'THUMB')

              log.info "\tProcessed to ${filePath}"
              site.save(flush: true)
            }
          }
        }
      }
    }
    render(status: 200, text: "Done processing images")
  }

  def titles = {
    def ustoreitManager = User.findByUsername('ustoreit')
    def ustoreitFeed = (CenterShift) Feed.findByManager(ustoreitManager)
    for (site in ustoreitFeed.sites) {
      def tm = site.title =~ /\d{4} .+/
      if (tm.getCount()) {
        def title
        if (site.title.contains("/")) {
          title = 'U-Store-It ' + site.title.tokenize("/")[-1]
        } else if (site.title.contains("/")) {
          title = "U-Store-It " + site.title.tokenize("-")[-1]
        } else {
          def titleArr = site.title.tokenize(" ")
          title = "U-Store-It " + titleArr[1..titleArr.size()-1].join(" ")
        }
        log.info "Changing site title from ${site.title} to ${title}"
        site.title = title
        site.save(flush: true)
      }
    }
    render(status: 200, text: "Done processing titles")
  }
}
