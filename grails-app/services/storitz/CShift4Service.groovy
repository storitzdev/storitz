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
import com.centershift.store40.GetAvailableServices
import com.centershift.store40.GetAvailableServicesRequest
import storitz.constants.TruckType

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

    def loadSites(CenterShift cshift, SiteStats stats, PrintWriter writer) {
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
            def gatehours = siteDetail.gatehours?.toLowerCase()

            def hm = sitehours =~ /Monday:\s*(.+?)\s*Tuesday:\s*(.+?)\s*Wednesday:\s*(.+?)\s*Thursday:\s*(.+?)\s*Friday:\s*(.+?)\s*Saturday:\s*(.+?)\s*Sunday:\s*(.+)/
            if (hm.getCount()) {

              ["Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"].eachWithIndex{
                day, i ->
                def hrs = hm[0][i+1].toUpperCase()
                def open = "open${day}"
                def start = "start${day}"
                def end = "end${day}"
                if (hrs == "CLOSED") {
                  csite."$open" = false
                } else {
                  csite."$open" = true
                  csite."$start" = getStartTime(hrs)
                  csite."$end" = getEndTime(hrs)
                }
              }
            } else {
              hm = sitehours =~ /Monday\s*\w+?\s*Friday\s*(.+?)\s*Saturday:\s*(.+?)\s*Sunday:\s*(.+)/
              if (hm.getCount()) {
                println "Monday - Friday match"
                ["Monday", "Tuesday", "Wednesday", "Thursday", "Friday"].each{ day ->
                  def hrs = hm[0][1].toUpperCase()
                  def open = "open${day}"
                  def start = "start${day}"
                  def end = "end${day}"
                  csite."$open" = true
                  csite."$start" = getStartTime(hrs)
                  csite."$end" = getEndTime(hrs)
                }
                ["Saturday", "Sunday"].eachWithIndex{ day, i ->
                  def hrs = hm[0][i+2].toUpperCase()
                  def open = "open${day}"
                  def start = "start${day}"
                  def end = "end${day}"
                  if (hrs == "CLOSED") {
                    csite."$open" = false
                  } else {
                    csite."$open" = true
                    csite."$start" = getStartTime(hrs)
                    csite."$end" = getEndTime(hrs)
                  }
                }
              }
            }
            if (gatehours == "24 hours") {
              def start = Date.parse("hh:mma","12:00am")
              def end = Date.parse("hh:mma", "11:59pm")
              csite.startMondayGate = csite.startTuesdayGate = csite.startWednesdayGate = csite.startThursdayGate = csite.startFridayGate = csite.startSaturdayGate = csite.startSundayGate = start
              csite.endMondayGate = csite.endTuesdayGate = csite.endWednesdayGate = csite.endThursdayGate = csite.endFridayGate = csite.endSaturdayGate = csite.endSundayGate = end
            } else {
              def gm = gatehours =~ /(.+?)\s+\w+?\s+(.+)/
              if (gm.getCount()) {
                def start = Date.parse("hh:mma",gm[0][1].toUpperCase())
                def end = Date.parse("hh:mma",gm[0][2].toUpperCase())
                csite.startMondayGate = csite.startTuesdayGate = csite.startWednesdayGate = csite.startThursdayGate = csite.startFridayGate = csite.startSaturdayGate = csite.startSundayGate = start
                csite.endMondayGate = csite.endTuesdayGate = csite.endWednesdayGate = csite.endThursdayGate = csite.endFridayGate = csite.endSaturdayGate = csite.endSundayGate = end
              }
            }

            GetBaseFeesRequest siteFeesRequest = new GetBaseFeesRequest()
            siteFeesRequest.siteID = site.siteid
            def siteFees = myProxy.getBaseFees(lookupUser, siteFeesRequest)

            for (siteFee in siteFees.details.orgfeesiteall) {
              if (siteFee.feename == "Admin Fee") {
                csite.adminFee = siteFee.feeamt
                println "Found admin fee = ${csite.adminFee}"
              }
            }

            // set attributes
            csite.extendedHours = false
            csite.isManagerOnsite = false
            csite.isGate = true
            csite.isKeypad = true
            csite.isCamera = false
            csite.hasElevator = false
            csite.requiresInsurance = false
            csite.boxesAvailable = false
            csite.freeTruck = TruckType.NONE
            csite.isUnitAlarmed = false

            GetAvailableServicesRequest availSvcReq = new GetAvailableServicesRequest()
            availSvcReq.siteID = site.siteid
            def availSvcs = myProxy.getAvailableServices(lookupUser, availSvcReq)
            for (svc in availSvcs.details.orgservicesiteofferings) {
              if (svc.servicetypeval == "24 Hour Access") {
                // TODO mark 24 access
                csite.extendedHours = true
                println "Found 24 hr access"
              }
            }

            csite.save(flush:true)
            SiteUser.link(csite, cshift.manager)
            if (site.emailaddress?.size() > 0) {
              createSiteUser(csite, site.emailaddress, site.emailaddress, cshift.manager)
            }

            // TODO - promos, insurance, hours, site features
            // hours may be free form
            loadInsurance(cshift, csite)
            // loadUnits(csite)

            csite.save(flush:true)

            stats.createCount++
            
          } else {
            println "Skipped site ${site.displayname} due to status ${site.sitestatus} or property type ${site.propertytype}"
          }
        }

      }
    }

    def loadInsurance(CenterShift cshift, StorageSite site) {
      def myProxy = getProxy(cshift)
      GetInsuranceProvidersRequest insuranceRequest = new GetInsuranceProvidersRequest()
      insuranceRequest.siteID = site.sourceId as Long
      insuranceRequest.orgID = cshift.orgId
      def lookupUser = getLookupUser(cshift)
      def insuranceProviders = myProxy.getInsuranceProviders(lookupUser, insuranceRequest)
      for (ins in insuranceProviders.details.ORGINSSITEOFFERINGS) {
        Insurance siteIns = site.insurances.find{ it.insuranceId == ins.siteinsid }
        boolean newIns = false
        if (!siteIns) {
          siteIns = new Insurance()
          siteIns.insuranceId = ins.siteinsid
          siteIns.active = true
          newIns = true
        }
        siteIns.percentTheft = ins.coverageperc
        siteIns.provider = ins.providername
        siteIns.premium = ins.rate
        siteIns.totalCoverage = ins.coverageamount
        siteIns.save(flush:true)
        if (newIns) {
          site.addToInsurances(siteIns)
        }
      }
    }

    private Date getStartTime(String hrs) {
      def start = hrs.split("-")[0].trim()
      return Date.parse("hh:mma", start)
    }

    private Date getEndTime(String hrs) {
      def end = hrs.split("-")[-1].trim()
      return Date.parse("hh:mma", end)
    }

}
