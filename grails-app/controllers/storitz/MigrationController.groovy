package storitz

import grails.converters.JSON
import com.storitz.StorageSite
import com.storitz.Feed
import storitz.constants.FeedType
import com.storitz.SiteLink
import com.storitz.CenterShift
import com.storitz.User
import org.codehaus.groovy.grails.web.json.JSONObject
import com.storitz.Bullet
import com.storitz.SiteImage
import com.storitz.Insurance
import com.storitz.SpecialOffer
import com.storitz.SiteUser
import com.storitz.RentalAgreement
import com.storitz.BankAccount
import com.storitz.UserNotificationType
import com.storitz.NotificationType

class MigrationController {

  def index = { }

  def owner = {
    def myFeed = Feed.get(params.id as Long)

    if (myFeed) {
      def users = User.findAllByManager(myFeed.manager)
      def rentalAgreements = RentalAgreement.findAllByAgreementOwner(myFeed.manager)
      def siteUsers = []
      for (user in users) {
        for (site in user.sites) {
          siteUsers.add(site)
        }
      }
      for (site in myFeed.manager.sites) {
        siteUsers.add(site)
      }
      // compile the assets into a file
      def fileList = []
      for(site in myFeed.sites) {
        for(img in site.images) {
          fileList.add("**${img.basename}/thumb_${img.fileLocation}")
          fileList.add("**${img.basename}/mid_${img.fileLocation}")
          fileList.add("**${img.basename}/${img.fileLocation}")
        }
        if (site.logo) {
          fileList.add("**${site.logo.basename}/${site.logo.fileLocation}")
        }
      }
      // add PDFs
      for(ra in rentalAgreements) {
        fileList.add("**${ra.src()}")
      }
      // build bundle
      def tmpFile = File.createTempFile("migration", ".zip")
      tmpFile.delete()
      def ant = new AntBuilder();
      println "Files for bundle:${tmpFile.canonicalFile} basedir: ${request.getRealPath("/")} - ${fileList.dump()}"
      ant.zip(destfile:tmpFile.canonicalFile, basedir:request.getRealPath("/"), includes:fileList)
      JSON.use("default")
      if (myFeed.feedType == FeedType.SITELINK) {
        SiteLink f = myFeed as SiteLink
        render(status: 200, contentType: "application/json", text: "{ \"assetFile\": \"${tmpFile.canonicalFile}\", \"feed\": ${f as JSON}, \"users\": ${users as JSON}, \"manager\":${myFeed.manager as JSON}, \"siteUsers\": ${siteUsers as JSON} }, \"rentalAgrements\":${rentalAgreements as JSON} }")
      } else if (myFeed.feedType == FeedType.CENTERSHIFT) {
        CenterShift f = myFeed as CenterShift
        render(status: 200, contentType: "application/json", text: "{ \"assetFile\": \"${tmpFile.canonicalFile}\", \"feed\": ${f as JSON}, \"users\": ${users as JSON} }, \"manager\":${myFeed.manager as JSON}, \"siteUsers\": ${siteUsers as JSON}, \"rentalAgreements\":${rentalAgreements as JSON } }")
      }
    }
  }

  def consume = {
    def urlString = 'http://preview.storitz.com/migration/owner/' + params.id
    if (params.url) {
      urlString = params.url
    }

    def url = new URL(urlString)
    def conn = url.openConnection()
    if (conn.responseCode == 200) {
      println "Response was 200"
      def respText = conn.content.text
      def resp = JSON.parse(respText)
      clearNulls(resp)
      def feed
      if (resp.feed.feedType == 'SITELINK') {
        feed = new SiteLink(params['feed'])
        feed.properties = resp.feed
        feed.feedType = FeedType.SITELINK

      } else if (resp.feedType == 'CENTERSHIFT') {
        feed = new CenterShift(params['feed'])
        feed.properties = resp.feed
        feed.feedType = FeedType.CENTERSHIFT

      }
      // create the manager first
      // handle users
      def users = []
      def manager = new User()
      def notificationTypes = []
      for (n in resp.manager.notificationTypes) {
        def notificationType = NotificationType.get(n.notificationType)
        notificationTypes.add(notificationType)
      }
      resp.manager.notificationTypes.clear()
      bindData(manager, resp.manager)
      manager.save(flush: true)
      for (n in notificationTypes) {
        UserNotificationType.create(manager, n)
      }
      for (u in resp.users) {
        def user = new User()
        notificationTypes = []
        for (n in u.notificationTypes) {
          def notificationType = NotificationType.get(n.notificationType)
          notificationTypes.add(notificationType)
        }
        u.notificationTypes.clear()
        bindData(user, u)
        user.save(flush: true)
        for (n in notificationTypes) {
          UserNotificationType.create(user, n)
        }
        users.add(user)
      }
      for (u in users) {
        u.manager = manager
      }
      def sites = []
      for (ra in resp.rentalAgreements) {
        def rentalAgreement = new RentalAgreement()
        ra.agreementOwner = null
        rentalAgreement.agreementOwner = manager
        bindData(rentalAgreement, ra)
        rentalAgreement.save(flush: true)
      }
      for (s in feed.sites) {
        def site = new StorageSite()
        def securityItems = []
        for (i in s.securityItems) {
          def si = new Bullet()
          bindData(si, i)
          si.save(flush:true)
          securityItems.add(si)
        }
        def convenienceItems = []
        for (i in s.convenienceItems) {
          def si = new Bullet()
          bindData(si, i)
          si.save(flush:true)
          convenienceItems.add(si)
        }
        def amenities = []
        for (i in s.amenityItems) {
          def si = new Bullet()
          bindData(si, i)
          si.save(flush:true)
          amenities.add(si)
        }
        def images = []
        for (i in s.images) {
          def si = new SiteImage()
          bindData(si, i)
          si.site = site
          images.add(si)
        }
        def insurances = []
        for (i in s.insurances) {
          def si = new Insurance()
          bindData(si, i)
          si.save(flush:true)
          insurances.add(si)
        }
        def specialOffers = []
        for (i in s.specialOffers) {
          def si = new SpecialOffer()
          bindData(si, i)
          si.save(flush:true)
          specialOffers.add(si)
        }
        s.amenityItems.clear()
        s.securityItems.clear()
        s.convenienceItems.clear()
        s.images.clear()
        s.insurances.clear()
        s.specialOffers.clear()

        def rentalAgreement
        if (s.rentalAgreement) {
          rentalAgreement = RentalAgreement.findByAgreementOwnerAndTitle(manager, s.rentalAgreement.title)
        }
        if (s.bankAccount) {
          def bankAccount = new BankAccount()
          bindData(bankAccount, s.bankAccount)
          s.bankAccount = null
          site.bankAccount = bankAccount
        }
        if (s.logo) {
          def logo = new SiteImage()
          bindData(logo, s.logo)
          s.logo = null
          site.logo = logo
        }
        s.rentalAgreement = null
        bindData(site, s)
        site.rentalAgreement = rentalAgreement
        site.save(flush:true)
        for (image in images) {
          image.site = site
          site.addToImages(image)
          image.save(flush:true)
        }
        for (so in specialOffers) {
          site.addToSpecialOffers(so)
        }
        for (i in insurances) {
          site.addToInsurances(i)
        }
        for (si in securityItems) {
          site.addToSecurityItems(si)
        }
        for (ci in convenienceItems) {
          site.addToConvenienceItems(ci)
        }
        for (a in amenities) {
          site.addToAmenityItems(a)
        }
        site.save(flush:true)
        sites.add(site)

      }
      feed.sites.clear()
      feed.save(flush: true)
      for(site in sites) {
        feed.addToSites(site)
        SiteUser.link(site, manager)
      }

      for (su in resp.siteUsers) {
        def site = StorageSite.findByTitle(su.site)
        def user = User.findByUsername(su.user)
        SiteUser.link(site, user)
      }
      render(status: 200, text: "Done! Grab ${resp.assetFile} and unzip locally")
    } else {
      render(status: 200, text: "Error during migration - check logs")
    }
  }

  private clearNulls(Object obj) {

    if (obj instanceof Map) {
      def map = (Map)obj
      for (r in map.entrySet()) {
        println "Examining map key=${r.key} value=${r.value}"
        if (r.value == JSONObject.NULL) {
          r.value = null
        } else if (r.value instanceof Map || r.value instanceof List) {
          clearNulls(r.value)
        }
      }
    } else if (obj instanceof List) {
      def list = (List)obj
      for (l in list) {
        if (l == JSONObject.NULL) {
          l = null
        } else if (l instanceof Map || l instanceof List) {
          clearNulls(l)
        }
      }
    }

  }
}
