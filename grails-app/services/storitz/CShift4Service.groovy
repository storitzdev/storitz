package storitz

import storitz.constants.State
import com.storitz.*
import com.centershift.store40.WSSoap
import com.centershift.store40.WS
import com.centershift.store40.LookupUserRequest
import com.centershift.store40.GetSiteListRequest
import com.centershift.store40.GetInsuranceProvidersRequest
import com.centershift.store40.GetSiteListResponse
import storitz.constants.TransactionType
import com.centershift.store40.GetSiteDetailsRequest
import com.centershift.store40.ArrayOfLong
import com.centershift.store40.GetBaseFeesRequest

class CShift4Service {

    def geocodeService
  
    def cshiftUrl = "https://slc.centershift.com:443/Store40/SWS.asmx?WSDL"
    WSSoap proxy
  
    boolean transactional = false

    def getProxy(CenterShift cshift) {
      if (!proxy) {
        def cshiftWS = new WS()
        proxy = cshiftWS.getWSSoap()
      }
      return proxy
    }

    def getLookupUser(CenterShift cshift) {
      def lookupUser = new LookupUserRequest()
      lookupUser.username = cshift.userName
      lookupUser.password = cshift.pin
      lookupUser.channel = 0
      return lookupUser
    }

    def createSiteUser(site, email, realName, manager) {
      def user = User.findByEmail(email)
      if (!user) {
        user = new User(
          username:email,
          password: ((Math.random() * System.currentTimeMillis()) as String),
          description: "Site Manager for ${site.title}",
          email: email,
          userRealName:realName,
          accountExpired: false,
          accountLocked: false,
          passwordExpired: false,
          enabled: false
        )
        user.manager = manager
        user.save(flush: true)
        SiteUser.link(site, user)
      }
      if (!UserNotificationType.userHasNotificationType(user, 'NOTIFICATION_SITE_MANAGER')) {
        def notificationType = NotificationType.findByNotificationType('NOTIFICATION_SITE_MANAGER')
        UserNotificationType.create(user, notificationType, true)
      }
      if (!UserRole.userHasRole(user,'ROLE_USER')) {
        UserRole.create(user, Role.findByAuthority('ROLE_USER'), true)
      }
    }

    def refreshSites(cshift, stats, writer) {
      loadSites(cshift, stats, writer)
    }

    def loadSites(cshift, stats, writer) {
      WSSoap myProxy = getProxy(cshift)
      def siteListRequest = new GetSiteListRequest()
      siteListRequest.orgID = cshift.orgId

      def lookupUser = getLookupUser(cshift)
      def siteList = myProxy.getSiteList(lookupUser, siteListRequest)

      for (site in siteList.details.soagetsitelist) {
        StorageSite foundSite = StorageSite.findBySourceAndSourceId("CS4", site.siteid)
        if (foundSite) {
          // TODO - handle update case
        } else {
          if (site.propertytype == 1 && (site.sitestauts == 1 | site.sitestauts == 2)) {

            def csite = new StorageSite()
            csite.sourceId = site.siteid
            csite.sourceLoc = site.sitenumber
            csite.title = site.displayname
            csite.disabled = true
            csite.feed = cshift

            csite.phone = site.phone
            csite.address = site.line1
            csite.address2 = site.line2
            csite.city = site.city
            csite.state = State.fromText(site.state)
            csite.zipcode = site.postalcode

            def address = csite.address  + ', ' + csite.city + ', ' + csite.state.display + ' ' + csite.zipcode

            println "Found address: ${address}"
            def geoResult = geocodeService.geocode(address)

            csite.lng = geoResult.results[0].geometry.location.lng
            csite.lat = geoResult.results[0].geometry.location.lat

            csite.transactionType = TransactionType.RENTAL
            csite.lastUpdate = 0

            // grab site details
            GetSiteDetailsRequest detailsReq = new GetSiteDetailsRequest()
            detailsReq.setSiteID(new ArrayOfLong())
            detailsReq.siteID.getLong().add(site.siteid)
            def siteDetails = myProxy.getSiteDetails(lookupUser, detailsReq)

            def siteDetail = siteDetails.details.soasiteattributes[0]

            def sitehours = siteDetail.sitehours
            def gatehours = siteDetail.gatehours

            println "Site hours = ${sitehours}"
            def hm = sitehours =~ /Monday:\s*(.+?)\s*Tuesday:\s(.+?)\s*Wednesday:\s*(.+?)\s*Thursday:\s*(.+?)\s*Friday:\s*(.+?)\s*Saturday:\s*(.+?)\s*Sunday:\s*(.+?)/
            if (hm.getCount()) {
              println "Site hours match"
              def hrsMon = hm[0][1].toLowerCase()
              def hrsTues = hm[0][2].toLowerCase()
              def hrsWed = hm[0][3].toLowerCase()
              def hrsThurs = hm[0][4].toLowerCase()
              def hrsFri = hm[0][5].toLowerCase()
              def hrsSat = hm[0][6].toLowerCase()

              if (hrsMon == "closed") {
                csite.openMonday = false
              } else {
                csite.openMonday = true
                csite.startMonday = getStartTime(hrsMon)
                csite.endMonday = getEndTime(hrsMon)
              }
            }
            println "Gate hours = ${gatehours}"

            GetBaseFeesRequest siteFeesRequest = new GetBaseFeesRequest()
            siteFeesRequest.siteID = site.siteid
            def siteFees = myProxy.getBaseFees(lookupUser, siteFeesRequest)

            for (siteFee in siteFees.details.orgfeesiteall) {
              if (siteFee.feename == "Admin Fee") {
                csite.adminFee = siteFee.feeamt
                println "Found admin fee = ${csite.adminFee}"
              }
            }

            // csite.save(flush:true)
            SiteUser.link(csite, cshift.manager)
            if (site.email?.size() > 0) {
              createSiteUser(csite, site.email, site.email, cshift.manager)
            }

            // TODO - promos, insurance, hours, site features
            // hours may be free form
            loadInsurance(cshift, csite)
            // loadUnits(csite)

            // csite.save(flush:true)

          } else {
            println "Skipped site ${site.displayname} due to status ${site.sitestatus} or property type ${site.propertytype}"
          }
        }

      }
    }

    def loadInsurance(cshift, site) {
      def myProxy = getProxy(cshift)
      def insuranceRequest = new GetInsuranceProvidersRequest()
      insuranceRequest.siteID = site.siteid
      insuranceRequest.orgID = site.orgid
      def lookupUser = getLookupUser(cshift)
      def insuranceProviders = myProxy.getInsuranceProviders(lookupUser, insuranceRequest)
      for (ins in insuranceProviders.details.ORGINSSITEOFFERINGS) {
        def siteIns = site.insurances.find{ it.insuranceId == ins.siteinsid }
        if (!siteIns) {
          siteIns = new Insurance()
          siteIns.insuranceId = ins.siteinsid
        }
        siteIns.percentTheft = ins.coverageperc
        siteIns.provider = ins.providername
        siteIns.premium = ins.rate
        siteIns.totalCoverage = ins.coverageamount

        siteIns.save(flush:true)
      }
    }

    private Date getStartTime(String hrs) {
      def start = hrs.split("-")[0].trim()
    }

    private Date getEndTime(String hrs) {
      def end = hrs.split("-")[-1].trim()
    }

}
