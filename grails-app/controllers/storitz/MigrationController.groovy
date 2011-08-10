package storitz

import grails.converters.JSON
import org.apache.commons.lang.time.DateUtils
import org.codehaus.groovy.grails.web.json.JSONObject
import storitz.constants.CenterShiftVersion
import storitz.constants.FeedType
import com.storitz.*
import storitz.constants.State 

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
      for (site in myFeed.sites) {
        for (img in site.images) {
          fileList.add("**${img.basename}${img.fileLocation.replace(' ', '*')}")
          fileList.add("**${img.basename}mid-${img.fileLocation.replace(' ', '*')}")
          fileList.add("**${img.basename}thumb-${img.fileLocation.replace(' ', '*')}")
        }
        if (site.logo) {
          fileList.add("**${site.logo.basename}logo-${site.logo.fileLocation.replace(' ', '*')}")
        }
      }
      // add PDFs
      for (ra in rentalAgreements) {
        fileList.add("**${ra.src().replace(' ', '*')}")
      }
      // build bundle
      def tmpFile = File.createTempFile("migration", ".zip")
      tmpFile.delete()
      def ant = new AntBuilder();
      println "Files for bundle:${tmpFile.canonicalFile} basedir: ${request.getRealPath("/")} - ${fileList.dump()}"
      ant.zip(destfile: tmpFile.canonicalFile, basedir: request.getRealPath("/"), includes: fileList)
      JSON.use("default")
      if (myFeed.feedType == FeedType.SITELINK) {
        SiteLink f = myFeed as SiteLink
        render(status: 200, contentType: "application/json", text: "{ \"assetFile\": \"${tmpFile.canonicalFile}\", \"feed\": ${f as JSON}, \"users\": ${users as JSON}, \"siteUsers\": ${siteUsers as JSON} }, \"rentalAgrements\":${rentalAgreements as JSON} }")
      } else if (myFeed.feedType == FeedType.CENTERSHIFT) {
        CenterShift f = myFeed as CenterShift
        render(status: 200, contentType: "application/json", text: "{ \"assetFile\": \"${tmpFile.canonicalFile}\", \"feed\": ${f as JSON}, \"users\": ${users as JSON}, \"siteUsers\": ${siteUsers as JSON} }, \"rentalAgrements\":${rentalAgreements as JSON} }")
      } else if (myFeed.feedType == FeedType.QUIKSTOR) {
        QuikStor f = myFeed as QuikStor
        render(status: 200, contentType: "application/json", text: "{ \"assetFile\": \"${tmpFile.canonicalFile}\", \"feed\": ${f as JSON}, \"users\": ${users as JSON}, \"siteUsers\": ${siteUsers as JSON} }, \"rentalAgrements\":${rentalAgreements as JSON} }")
      } else if (myFeed.feedType == FeedType.EDOMICO) {
        EDomico f = myFeed as EDomico
        render(status: 200, contentType: "application/json", text: "{ \"assetFile\": \"${tmpFile.canonicalFile}\", \"feed\": ${f as JSON}, \"users\": ${users as JSON}, \"siteUsers\": ${siteUsers as JSON} }, \"rentalAgrements\":${rentalAgreements as JSON} }")
      } else if (myFeed.feedType == FeedType.UNCLEBOBS) {
        UncleBobs f = myFeed as UncleBobs
        render(status: 200, contentType: "application/json", text: "{ \"assetFile\": \"${tmpFile.canonicalFile}\", \"feed\": ${f as JSON}, \"users\": ${users as JSON}, \"siteUsers\": ${siteUsers as JSON} }, \"rentalAgrements\":${rentalAgreements as JSON} }")
      } else if (myFeed.feedType == FeedType.STORAGEMART) {
        StorageMart f = myFeed as StorageMart
        render(status: 200, contentType: "application/json", text: "{ \"assetFile\": \"${tmpFile.canonicalFile}\", \"feed\": ${f as JSON}, \"users\": ${users as JSON}, \"siteUsers\": ${siteUsers as JSON} }, \"rentalAgrements\":${rentalAgreements as JSON} }")
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
      def respText = conn.content.text
      def resp = JSON.parse(respText)
      clearNulls(resp)
      def feed
      if (feedTypeEquals(resp.feed.feedType,'SITELINK')) {
        feed = new SiteLink()
        feed.feedType = FeedType.SITELINK
        feed.corpCode = resp.feed.corpCode
        feed.userName = resp.feed.userName
        feed.password = resp.feed.password
        feed.operatorName = resp.feed.operatorName
        feed.address1 = resp.feed.address1
        feed.address2 = resp.feed.address2
        feed.city = resp.feed.city
        feed.state = resp.feed.state ? State.getEnumFromId(resp.feed.state) : null
        feed.zipcode = resp.feed.zipcode
        feed.transactionBoxLink = resp.feed.transactionBoxLink
        feed.transactionBoxBody = resp.feed.transactionBoxBody
        feed.reservationMoveInDescription = resp.feed.reservationMoveInDescription
      } else if (feedTypeEquals(resp.feed.feedType,'CENTERSHIFT')) {
        feed = new CenterShift()
        feed.userName = resp.feed.userName
        feed.pin = resp.feed.pin
        feed.orgId = resp.feed?.orgId
        feed.cshiftVersion = CenterShiftVersion.getEnumFromId(resp.feed.cshiftVersion)
        feed.feedType = FeedType.CENTERSHIFT
        feed.operatorName = resp.feed.operatorName
        feed.address1 = resp.feed.address1
        feed.address2 = resp.feed.address2
        feed.city = resp.feed.city
        feed.state = resp.feed.state ? State.getEnumFromId(resp.feed.state) : null
        feed.zipcode = resp.feed.zipcode
        feed.transactionBoxLink = resp.feed.transactionBoxLink
        feed.transactionBoxBody = resp.feed.transactionBoxBody
        feed.reservationMoveInDescription = resp.feed.reservationMoveInDescription
      } else if (feedTypeEquals(resp.feed.feedType,'QUIKSTOR')) {
        feed = new QuikStor()
        feed.feedType = FeedType.QUIKSTOR
        feed.operatorName = resp.feed.operatorName
        feed.url = resp.feed.url
        feed.address1 = resp.feed.address1
        feed.address2 = resp.feed.address2
        feed.city = resp.feed.city
        feed.state = resp.feed.state ? State.getEnumFromId(resp.feed.state) : null
        feed.zipcode = resp.feed.zipcode
        feed.transactionBoxLink = resp.feed.transactionBoxLink
        feed.transactionBoxBody = resp.feed.transactionBoxBody
        feed.reservationMoveInDescription = resp.feed.reservationMoveInDescription
      }
      else if (feedTypeEquals(resp.feed.feedType,'EDOMICO')) {
        feed = new EDomico()
        feed.feedType = FeedType.EDOMICO
        feed.operatorName = resp.feed.operatorName
        feed.edomicoClientID = resp.feed.edomicoClientID
        feed.edomicoWebServicesKey = resp.feed.edomicoWebServicesKey
        feed.address1 = resp.feed.address1
        feed.address2 = resp.feed.address2
        feed.city = resp.feed.city
        feed.state = resp.feed.state ? State.getEnumFromId(resp.feed.state.name) : null
        feed.zipcode = resp.feed.zipcode
        feed.transactionBoxLink = resp.feed.transactionBoxLink
        feed.transactionBoxBody = resp.feed.transactionBoxBody
        feed.reservationMoveInDescription = resp.feed.reservationMoveInDescription
      }
      else if (feedTypeEquals(resp.feed.feedType,'UNCLEBOBS')) {
        feed = new UncleBobs()
        feed.feedType = FeedType.UNCLEBOBS
        feed.operatorName = resp.feed.operatorName
        feed.UBCompanyName = resp.feed.UBCompanyName
        feed.address1 = resp.feed.address1
        feed.address2 = resp.feed.address2
        feed.city = resp.feed.city
        feed.state = resp.feed.state ? State.getEnumFromId(resp.feed.state.name) : null
        feed.zipcode = resp.feed.zipcode
        feed.transactionBoxLink = resp.feed.transactionBoxLink
        feed.transactionBoxBody = resp.feed.transactionBoxBody
        feed.reservationMoveInDescription = resp.feed.reservationMoveInDescription
      }
      else if (feedTypeEquals(resp.feed.feedType,'STORAGEMART')) {
        feed = new StorageMart()
        feed.feedType = FeedType.STORAGEMART
        feed.operatorName = resp.feed.operatorName
        feed.stmUser = resp.feed.stmUser
        feed.stmPass = resp.feed.stmPass
        feed.address1 = resp.feed.address1
        feed.address2 = resp.feed.address2
        feed.city = resp.feed.city
        feed.state = resp.feed.state ? State.getEnumFromId(resp.feed.state.name) : null
        feed.zipcode = resp.feed.zipcode
        feed.transactionBoxLink = resp.feed.transactionBoxLink
        feed.transactionBoxBody = resp.feed.transactionBoxBody
        feed.reservationMoveInDescription = resp.feed.reservationMoveInDescription
      }
      CommissionSchedule commissionSchedule = CommissionSchedule.get(1L)
      // create the manager first
      // handle users
      def users = []

      def manager = User.findByUsername(resp.feed.manager.username)
      if (!manager) {
        manager = new User()
        def notificationTypes = []
        for (n in resp.feed.manager.notificationTypes) {
          def notificationType = NotificationType.get(n.notificationType)
          notificationTypes.add(notificationType)
        }
        resp.feed.manager.notificationTypes.clear()
        bindData(manager, resp.feed.manager)
        manager.manager = User.findByUsername('admin')
        manager.save(flush: true)
        for (n in notificationTypes) {
          UserNotificationType.create(manager, n)
        }
        UserRole.create(manager, Role.findByAuthority('ROLE_MANAGER'))
        UserRole.create(manager, Role.findByAuthority('ROLE_USER'))
      }
      for (u in resp.users) {
        def user = User.findByUsername(u.username)
        if (!user) {
          user = new User()
          def notificationTypes = []
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
          UserRole.create(user, Role.findByAuthority('ROLE_USER'))
          users.add(user)
        }
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
      for (s in resp.feed.sites) {
        def site = new StorageSite()
        def securityItems = []
        for (i in s.securityItems) {
          def si = new Bullet()
          bindData(si, i)
          si.save(flush: true)
          securityItems.add(si)
        }
        def convenienceItems = []
        for (i in s.convenienceItems) {
          def si = new Bullet()
          bindData(si, i)
          si.save(flush: true)
          convenienceItems.add(si)
        }
        def amenities = []
        for (i in s.amenityItems) {
          def si = new Bullet()
          bindData(si, i)
          si.save(flush: true)
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
          si.save(flush: true)
          insurances.add(si)
        }
        def specialOffers = []
        for (i in s.specialOffers) {
          def si = new SpecialOffer()
          def restrictions = []
          for (j in i.restrictions) {
            def sor = new SpecialOfferRestriction()
            bindData(sor, j)
            restrictions.add(sor)
          }
          i.restrictions.clear()
          bindData(si, i)
          si.save(flush: true)
          for (sor in restrictions) {
            si.addToRestrictions(sor)
          }
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
        def bankAccount
        if (s.bankAccount) {
          bankAccount = new BankAccount()
          bindData(bankAccount, s.bankAccount)
          s.bankAccount = null
        }
        def logo
        if (s.logo) {
          logo = new SiteImage()
          bindData(logo, s.logo)
          s.logo = null
        }
        s.rentalAgreement = null
        bindData(site, s)
        site.rentalAgreement = rentalAgreement
        site.bankAccount = bankAccount
        site.save(flush: true)
        // adjust times by our timezone
        if (site.startMonday) {
          site.startMonday = DateUtils.addHours(site.startMonday, (TimeZone.getDefault().getRawOffset() / TimeZone.ONE_HOUR) as int)
        }
        if (site.endMonday) {
          site.endMonday = DateUtils.addHours(site.endMonday, (TimeZone.getDefault().getRawOffset() / TimeZone.ONE_HOUR) as int)
        }
        if (site.startTuesday) {
          site.startTuesday = DateUtils.addHours(site.startTuesday, (TimeZone.getDefault().getRawOffset() / TimeZone.ONE_HOUR) as int)
        }
        if (site.endTuesday) {
          site.endTuesday = DateUtils.addHours(site.endTuesday, (TimeZone.getDefault().getRawOffset() / TimeZone.ONE_HOUR) as int)
        }
        if (site.startWednesday) {
          site.startWednesday = DateUtils.addHours(site.startWednesday, (TimeZone.getDefault().getRawOffset() / TimeZone.ONE_HOUR) as int)
        }
        if (site.endWednesday) {
          site.endWednesday = DateUtils.addHours(site.endWednesday, (TimeZone.getDefault().getRawOffset() / TimeZone.ONE_HOUR) as int)
        }
        if (site.startThursday) {
          site.startThursday = DateUtils.addHours(site.startThursday, (TimeZone.getDefault().getRawOffset() / TimeZone.ONE_HOUR) as int)
        }
        if (site.endThursday) {
          site.endThursday = DateUtils.addHours(site.endThursday, (TimeZone.getDefault().getRawOffset() / TimeZone.ONE_HOUR) as int)
        }
        if (site.startFriday) {
          site.startFriday = DateUtils.addHours(site.startFriday, (TimeZone.getDefault().getRawOffset() / TimeZone.ONE_HOUR) as int)
        }
        if (site.endFriday) {
          site.endFriday = DateUtils.addHours(site.endFriday, (TimeZone.getDefault().getRawOffset() / TimeZone.ONE_HOUR) as int)
        }
        if (site.startSaturday) {
          site.startSaturday = DateUtils.addHours(site.startSaturday, (TimeZone.getDefault().getRawOffset() / TimeZone.ONE_HOUR) as int)
        }
        if (site.endSaturday) {
          site.endSaturday = DateUtils.addHours(site.endSaturday, (TimeZone.getDefault().getRawOffset() / TimeZone.ONE_HOUR) as int)
        }
        if (site.startSunday) {
          site.startSunday = DateUtils.addHours(site.startSunday, (TimeZone.getDefault().getRawOffset() / TimeZone.ONE_HOUR) as int)
        }
        if (site.endSunday) {
          site.endSunday = DateUtils.addHours(site.endSunday, (TimeZone.getDefault().getRawOffset() / TimeZone.ONE_HOUR) as int)
        }
        if (site.startMondayGate) {
          site.startMondayGate = DateUtils.addHours(site.startMondayGate, (TimeZone.getDefault().getRawOffset() / TimeZone.ONE_HOUR) as int)
        }
        if (site.endMondayGate) {
          site.endMondayGate = DateUtils.addHours(site.endMondayGate, (TimeZone.getDefault().getRawOffset() / TimeZone.ONE_HOUR) as int)
        }
        if (site.startTuesdayGate) {
          site.startTuesdayGate = DateUtils.addHours(site.startTuesdayGate, (TimeZone.getDefault().getRawOffset() / TimeZone.ONE_HOUR) as int)
        }
        if (site.endTuesdayGate) {
          site.endTuesdayGate = DateUtils.addHours(site.endTuesdayGate, (TimeZone.getDefault().getRawOffset() / TimeZone.ONE_HOUR) as int)
        }
        if (site.startWednesdayGate) {
          site.startWednesdayGate = DateUtils.addHours(site.startWednesdayGate, (TimeZone.getDefault().getRawOffset() / TimeZone.ONE_HOUR) as int)
        }
        if (site.endWednesdayGate) {
          site.endWednesdayGate = DateUtils.addHours(site.endWednesdayGate, (TimeZone.getDefault().getRawOffset() / TimeZone.ONE_HOUR) as int)
        }
        if (site.startThursdayGate) {
          site.startThursdayGate = DateUtils.addHours(site.startThursdayGate, (TimeZone.getDefault().getRawOffset() / TimeZone.ONE_HOUR) as int)
        }
        if (site.endThursdayGate) {
          site.endThursdayGate = DateUtils.addHours(site.endThursdayGate, (TimeZone.getDefault().getRawOffset() / TimeZone.ONE_HOUR) as int)
        }
        if (site.startFridayGate) {
          site.startFridayGate = DateUtils.addHours(site.startFridayGate, (TimeZone.getDefault().getRawOffset() / TimeZone.ONE_HOUR) as int)
        }
        if (site.endFridayGate) {
          site.endFridayGate = DateUtils.addHours(site.endFridayGate, (TimeZone.getDefault().getRawOffset() / TimeZone.ONE_HOUR) as int)
        }
        if (site.startSaturdayGate) {
          site.startSaturdayGate = DateUtils.addHours(site.startSaturdayGate, (TimeZone.getDefault().getRawOffset() / TimeZone.ONE_HOUR) as int)
        }
        if (site.endSaturdayGate) {
          site.endSaturdayGate = DateUtils.addHours(site.endSaturdayGate, (TimeZone.getDefault().getRawOffset() / TimeZone.ONE_HOUR) as int)
        }
        if (site.startSundayGate) {
          site.startSundayGate = DateUtils.addHours(site.startSundayGate, (TimeZone.getDefault().getRawOffset() / TimeZone.ONE_HOUR) as int)
        }
        if (site.endSundayGate) {
          site.endSundayGate = DateUtils.addHours(site.endSundayGate, (TimeZone.getDefault().getRawOffset() / TimeZone.ONE_HOUR) as int)
        }
        for (image in images) {
          image.site = site
          site.addToImages(image)
          image.save(flush: true)
        }
        if (logo) {
          logo.site = site
          site.logo = logo
          logo.save(flush: true)
          site.save(flush: true)
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
        site.save(flush: true)
        sites.add(site)

      }
      feed.manager = manager
      feed.commissionSchedule = commissionSchedule
      feed.save(flush: true)
      for (site in sites) {
        feed.addToSites(site)
        SiteUser.link(site, manager)
      }
      feed.save(flush: true)

      // QuikStor Locations
      if (feedTypeEquals(resp.feed.feedType,'QUIKSTOR')) {
        for (loc in resp.feed.locations) {
          def qloc = new QuikStorLocation()
          qloc.username = loc.username
          qloc.password = loc.password
          qloc.sitename = loc.sitename
          qloc.quikStor = feed
          qloc.site = StorageSite.findByTitle(loc.site)
          qloc.save(flush: true)
          feed.addToLocations(qloc)
        }
        feed.save(flush: true)
      }

      // EDomico Locations
      if (feedTypeEquals(resp.feed.feedType,'EDOMICO')) {
        for (loc in resp.feed.locations) {
          def eloc = new EDomicoLocation()
          eloc.address1 = loc.address1
          eloc.city = loc.city
          eloc.zipcode = loc.zipcode
          eloc.state = loc.state
          eloc.edomico = feed
          eloc.siteID = loc.siteID
          eloc.siteName = loc.siteName
          eloc.site = StorageSite.findBySourceId(loc.siteID)
          eloc.save(flush:true)
          feed.addToLocations(eloc)
        }
        feed.save(flush: true)
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
      def map = (Map) obj
      for (r in map.entrySet()) {
        if (r.value == JSONObject.NULL) {
          r.value = null
        } else if (r.value instanceof Map || r.value instanceof List) {
          clearNulls(r.value)
        }
      }
    } else if (obj instanceof List) {
      def list = (List) obj
      for (l in list) {
        if (l == JSONObject.NULL) {
          l = null
        } else if (l instanceof Map || l instanceof List) {
          clearNulls(l)
        }
      }
    }
  }

  def feedTypeEquals(feedType,feedName) {
    try {
      if (feedType == feedName)
        return true
      if (feedType.name && feedType.name == feedName)
        return true
    } catch (groovy.lang.MissingPropertyException mpe) {
      // This is expected for cases where `feedType instanceof lava.lang.String` is true.
      // Ignore this one
    } catch (Throwable t) {
      // Something really unexpected happened. Log it and march on.
      t.printStackTrace()
    }
    return false;
  }

}
