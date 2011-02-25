package storitz

import com.storitz.CenterShift
import com.storitz.Feed
import com.storitz.StorageSite
import com.storitz.User
import storitz.constants.CenterShiftVersion
import storitz.constants.FeedType

class ExrsController extends CshiftController {

    def fileUploadService
    def imageService
    def exrsService

    static String baseUrl = "http://selfstorage.extraspace.com"

    def list = {
      def exrsManager = User.findByUsername('exrs')
      def exrsFeed = (CenterShift)Feed.findByManager(exrsManager)
      def feedList = [exrsFeed]
      [cshiftInstanceList: feedList, cshiftInstanceTotal: feedList.size()]
    }

    def save = {
      def cshiftInstance = new CenterShift(params)
      cshiftInstance.feedType = FeedType.CENTERSHIFT
      if (cshiftInstance.validate() && cshiftInstance.save(flush: true)) {
        // read in sites
        def stats = new storitz.SiteStats()
        def writer = new PrintWriter(System.out)
        exrsService.loadSites(cshiftInstance, "EX", stats, writer)
        flash.message = "Feed " + stats.createCount + " sites created " + stats.updateCount + " sites updated " + stats.unitCount + " units added."
        redirect(action: "show", id: cshiftInstance.id)
      }
      else {
        render(view: "create", model: [cshiftInstance: cshiftInstance])
      }
    }

    def refreshPromos = {
      def writer = new PrintWriter(System.out)
      def cshiftInstance = CenterShift.get(params.id)
      if (cshiftInstance) {
        for(site in cshiftInstance.sites) {
          for(promo in site.specialOffers) {
            promo.delete()
          }
          site.specialOffers.clear()
          exrsService.loadPromos(cshiftInstance, site, writer)
          println "Promos refreshed for ${site.title}"
        }
        flash.message = "Feed promotions refreshed."
        redirect(action: "show", id: cshiftInstance.id)
      }
    }

    def refresh = {
      def cshiftInstance = CenterShift.get(params.id)
      if (cshiftInstance) {
        def stats = new storitz.SiteStats()
        def writer = new PrintWriter(System.out)
        exrsService.refreshSites(cshiftInstance, 'EX', stats, writer)
        flash.message = "Feed " + stats.createCount + " sites created " + stats.updateCount + " sites updated " + stats.unitCount + " units added."
        redirect(action: "show", id: cshiftInstance.id)
      }
    }

    def createContacts = {
      def cshiftInstance = CenterShift.get(params.id)
      if (cshiftInstance) {
        CShiftService.createSiteUsers(cshiftInstance, "EX")
        flash.message = "Site contacts created."
        redirect(action: "list")
      }
    }

    def refreshPhones = {
      def cshiftInstance = CenterShift.get(params.id)
      if (cshiftInstance) {
        def writer = new PrintWriter(System.out)
        CShiftService.createSitePhones(cshiftInstance, "EX", writer)
        writer.close()
        flash.message = "Feed phones refreshed."
        redirect(action: "show", id: cshiftInstance.id)
      }
    }

    def images = {
      def exrsManager = User.findByUsername('exrs')
      def exrsFeed = (CenterShift)Feed.findByManager(exrsManager)
      def random = new Random()
      for (i in 1..6) {
        def sitemapXml = new URL("http://selfstorage.extraspace.com/SiteMap-${i}.aspx").text
        // /Storage/Facilities/US/Arizona/Phoenix/501590/Facility.aspx
        def matcher = sitemapXml =~ /(\/Storage\/Facilities\/US\/.+?(\d+)\/Facility.aspx)/
        matcher.each {
          def pageUrl = it[1]
          println "Opening page: ${baseUrl}${pageUrl}"
          def siteHtml = new URL(baseUrl + pageUrl).text
          def addrMatch = siteHtml =~ /<div class="street-address">(.+?)<\/div>/
          def addr
          if (addrMatch.getCount()) {
            addr = addrMatch[0][1]
          }
          def cityMatch = siteHtml =~ /<span class="locality">(.+?)<\/span>/
          def city
          if (cityMatch.getCount()) {
            city = cityMatch[0][1]
          }
          def stateMatch = siteHtml =~ /<span class="region">(.+?)<\/span>/
          def state
          if (stateMatch.getCount()) {
            state = stateMatch[0][1]
          }
          def zipMatch = siteHtml =~ /<span class="postal-code">(.+?)<\/span>/
          def zip
          if (zipMatch.getCount()) {
            zip = zipMatch[0][1]
          }

          def c = StorageSite.createCriteria()
          StorageSite site = c.get {
            and {
              ilike("address", addr + '%')
              eq("zipcode", zip)
              eq("feed.id", exrsFeed.id)
            }
            maxResults(1)
          }
          if (site) {
            println "Found EXRS facility ${site.title} at addr=${addr} city=${city} state=${state} zip=${zip}"
            // grab image URLS of the form
            def imageList = []
            for (siteImage in site.siteImages()) {
              imageList.add(siteImage)
            }
            println "Getting ready to delete ${imageList.size()}"
            for (siteImage in imageList) {
              imageService.deleteImage(site, siteImage)
            }
            def imageMatch = siteHtml =~ /showPreview\('\/Images\/ImageHandler\.ashx\?image=(\/Images\/FacilityImages\/(.+?)\.jpg)&width=319&height=240','1'\)/
            if (imageMatch.getCount()) {
              def imgOrder = 0
              imageMatch.each {
                def imageUrl = it[1]
                def address = "${baseUrl}${imageUrl}"
                println "Image found at URL ${address}"
                def ext = '.' + imageUrl.tokenize('.')[-1]
                def newName = "Storitz-${site.city}-${site.state.display}-${site.title}-self-storage-units-${imgOrder}${ext}"
                def tmpPath = fileUploadService.getFilePath('/images/upload', newName, site.id)
                def dirPath = new File(fileUploadService.getFilePath('/images/upload', '', site.id))
                dirPath.mkdirs()
                def file = new FileOutputStream(tmpPath)
                def out = new BufferedOutputStream(file)
                try {
                  out << new URL(address).openStream()
                  out.close()
                  def filePath = fileUploadService.getFilePath('/images/site', newName, site.id)
                  def filePathMid = fileUploadService.getFilePath('/images/site', 'mid-' + newName, site.id)
                  def filePathThumb = fileUploadService.getFilePath('/images/site', 'thumb-' + newName, site.id)
                  imageService.scaleImages(new File(tmpPath), site.id, imgOrder, filePath, filePathMid, filePathThumb, site)
                  imageService.iptcTagImage(new File(filePath), site, imgOrder, 'FULL')
                  imageService.iptcTagImage(new File(filePathMid), site, imgOrder, 'MID')
                  imageService.iptcTagImage(new File(filePathThumb), site, imgOrder, 'THUMB')
                  ++imgOrder
  
                  println "\tProcessed to ${filePath}"
                  site.save(flush:true)
                } catch (Exception e) {
                  println "Could not open image ${address}"
                }
              }
            }
          } else {
            println "Could not locate storage facility for address |${addr}| and zip |${zip}| and feed id = ${exrsFeed.id}"
          }
        }
      }
      render(status: 200, text: "Done processing images")
    }

    def urls = {
      def exrsManager = User.findByUsername('exrs')
      def exrsFeed = (CenterShift)Feed.findByManager(exrsManager)
      def random = new Random()
      for (i in 1..6) {
        def sitemapXml = new URL("http://selfstorage.extraspace.com/SiteMap-${i}.aspx").text
        // /Storage/Facilities/US/Arizona/Phoenix/501590/Facility.aspx
        def matcher = sitemapXml =~ /(\/Storage\/Facilities\/US\/.+?(\d+)\/Facility.aspx)/
        matcher.each {
          def pageUrl = it[1]
          println "Opening page: ${baseUrl}${pageUrl}"
          def siteHtml = new URL(baseUrl + pageUrl).text
          def addrMatch = siteHtml =~ /<div class="street-address">(.+?)<\/div>/
          def addr
          if (addrMatch.getCount()) {
            addr = addrMatch[0][1]
          }
          def cityMatch = siteHtml =~ /<span class="locality">(.+?)<\/span>/
          def city
          if (cityMatch.getCount()) {
            city = cityMatch[0][1]
          }
          def stateMatch = siteHtml =~ /<span class="region">(.+?)<\/span>/
          def state
          if (stateMatch.getCount()) {
            state = stateMatch[0][1]
          }
          def zipMatch = siteHtml =~ /<span class="postal-code">(.+?)<\/span>/
          def zip
          if (zipMatch.getCount()) {
            zip = zipMatch[0][1]
          }

          def c = StorageSite.createCriteria()
          StorageSite site = c.get {
            and {
              ilike("address", addr + '%')
              eq("zipcode", zip)
              eq("feed.id", exrsFeed.id)
            }
            maxResults(1)
          }
          if (site) {
            println "Found EXRS facility ${site.title} at addr=${addr} city=${city} state=${state} zip=${zip} saving URL"
            site.url = pageUrl
            site.save(flush:true)
          } else {
            println "Could not locate storage facility for address |${addr}| and zip |${zip}| and feed id = ${exrsFeed.id}"
          }
        }
      }
      render(status: 200, text: "Done processing images")
    }
}
