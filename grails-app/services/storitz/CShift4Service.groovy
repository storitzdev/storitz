package storitz
import groovyx.net.ws.WSClient
import com.storitz.CenterShift
import com.storitz.StorageSite
import storitz.constants.State
import com.storitz.Role
import com.storitz.UserRole
import com.storitz.UserNotificationType
import com.storitz.NotificationType
import com.storitz.SiteUser
import com.storitz.User
import com.storitz.Insurance

class CShift4Service {

    def cshiftUrl = "https://slc.centershift.com:443/Sandbox40/SWS.asmx?WSDL"
    def proxy
  
    boolean transactional = false

    def getProxy() {
      if (!proxy) {
        proxy = new WSClient(cshiftUrl, this.class.classLoader)
        proxy.initialize() // from 0.5.0
      }
      return proxy
    }

    def getLookupUser(CenterShift cshift) {
      getProxy()
      def lookupUser = proxy.create("com.centershift.store40.LookupUserRequest")
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
          password: (Math.random() * System.currentTimeMillis()) as String,
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

    def loadSites(cshift, stats, writer) {
      getProxy()
      def siteListRequest = proxy.create("com.centershift.store40.GetSiteListRequest")
      siteListRequest.orgID = cshift.orgId

      def lookupUser = getLookupUser(cshift)
      def siteList = proxy.GetSiteList(lookupUser, siteListRequest)

      for (site in siteList.details.soagetsitelist) {
        StorageSite foundSite = StorageSite.findBySourceAndSourceId("CS4", site.siteid)
        if (foundSite) {
          // TODO - handle update case
        } else {
          if (site.propertytype == 1 && (site.sitestatus == 1 | site.sitestatus == 2)) {

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

            site.save()
            SiteUser.link(csite, cshift.manager)
            if (site.email?.size() > 0) {
              createSiteUser(site, site.email, site.email, cshift.manager)
            }

            // TODO - promos, insurance, hours, site features
            // hours may be free form
            loadInsurance(site)
            loadUnits(site)

            site.save(flush:true)

          } else {
            println "Skipped site ${site.displayname} due to status ${site.sitestatus} or property type ${site.propertytype}"
          }
        }

      }
    }

    def loadInsurance(site) {
      getProxy()
      def insuranceRequest = proxy.create("com.centershift.store40.GetInsuranceProvidersRequest")
      insuranceRequest.siteID = site.siteid
      insuranceRequest.orgID = site.orgid
      def insuranceProviders = proxy.GetInsuranceProviders(lookupUser, insuranceRequest)
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

}
