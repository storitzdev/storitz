package storitz

import groovyx.net.http.HTTPBuilder
import groovyx.net.http.Method
import static groovyx.net.http.ContentType.XML
import com.storitz.StorageSite
import com.storitz.SiteUser
import storitz.constants.State
import storitz.constants.TruckType
import com.storitz.StorageUnit
import com.storitz.SpecialOffer
import storitz.constants.PromoType
import com.storitz.cshiftclient.CsKiosk
import com.storitz.cshiftclient.CsKioskLocator
import com.storitz.cshiftclient.CsKioskSoapPort_PortType
import com.storitz.Insurance
import com.storitz.Role
import com.storitz.UserRole
import com.storitz.UserNotificationType
import com.storitz.NotificationType
import com.storitz.User
import storitz.constants.RentalUse
import com.storitz.RentalTransaction
import java.math.RoundingMode

class CShiftService {

  def geocodeService
  def unitSizeService

  boolean transactional = false

  def centerShiftWsUrl3 = "https://host05slc.centershift.com/DoD_CallCenter/csCallCenterService.asmx"

  def getSites(userName, pin) {
    def payload = """<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:csc="http://centershift.com/csCallCenter/csCallCenterService">
   <soapenv:Header/>
   <soapenv:Body>
      <csc:GetSiteList>
         <csc:strUser>""" + userName + """</csc:strUser>
         <csc:strPin>""" + pin + """</csc:strPin>
      </csc:GetSiteList>
   </soapenv:Body>
</soapenv:Envelope>"""

    postAction(payload, 'GetSiteList')
  }

  def getSiteAddress(userName, pin, siteId) {
    def payload = """<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:csc="http://centershift.com/csCallCenter/csCallCenterService">
   <soapenv:Header/>
   <soapenv:Body>
      <csc:GetSiteAddress>
         <csc:strUser>""" + userName + """</csc:strUser>
         <csc:strPin>""" + pin + """</csc:strPin>
         <csc:lngSiteID>""" + siteId + """</csc:lngSiteID>
      </csc:GetSiteAddress>
   </soapenv:Body>
</soapenv:Envelope>"""

    postAction(payload, 'GetSiteAddress')
  }

  def getSiteHours(userName, pin, siteId) {
    def payload = """<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:csc="http://centershift.com/csCallCenter/csCallCenterService">
   <soapenv:Header/>
   <soapenv:Body>
      <csc:GetSiteHours>
         <csc:strUser>""" + userName + """</csc:strUser>
         <csc:strPin>""" + pin + """</csc:strPin>
         <csc:lngSiteID>""" + siteId + """</csc:lngSiteID>
      </csc:GetSiteHours>
   </soapenv:Body>
</soapenv:Envelope>"""

    postAction(payload, 'GetSiteHours')
  }

  def getSiteFeatures(userName, pin, siteId) {
    def payload = """<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:csc="http://centershift.com/csCallCenter/csCallCenterService">
   <soapenv:Header/>
   <soapenv:Body>
      <csc:GetSiteFeatures>
         <csc:strUser>""" + userName + """</csc:strUser>
         <csc:strPin>""" + pin + """</csc:strPin>
         <csc:lngSiteID>""" + siteId + """</csc:lngSiteID>
      </csc:GetSiteFeatures>
   </soapenv:Body>
</soapenv:Envelope>"""

    postAction(payload, 'GetSiteFeatures')
  }

  def getSitePhones(userName, pin, siteId) {
    def payload = """<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:csc="http://centershift.com/csCallCenter/csCallCenterService">
   <soapenv:Header/>
   <soapenv:Body>
      <csc:GetSitePhones>
         <csc:strUser>""" + userName + """</csc:strUser>
         <csc:strPin>""" + pin + """</csc:strPin>
         <csc:lngSiteID>""" + siteId + """</csc:lngSiteID>
      </csc:GetSitePhones>
   </soapenv:Body>
</soapenv:Envelope>"""

    postAction(payload, 'GetSitePhones')
  }

  def getSiteUnits(userName, pin, siteId) {
    def payload = """<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:csc="http://centershift.com/csCallCenter/csCallCenterService">
   <soapenv:Header/>
   <soapenv:Body>
      <csc:GetSiteUnitData>
         <csc:strUser>""" + userName + """</csc:strUser>
         <csc:strPin>""" + pin + """</csc:strPin>
         <csc:lngSiteID>""" + siteId + """</csc:lngSiteID>
      </csc:GetSiteUnitData>
   </soapenv:Body>
</soapenv:Envelope>"""

    postAction(payload, 'GetSiteUnitData')
  }

  def getPromos(userName, pin, siteId) {
    def payload = """<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:csc="http://centershift.com/csCallCenter/csCallCenterService">
   <soapenv:Header/>
   <soapenv:Body>
      <csc:GetCurrentPromotionListXML>
         <csc:strUser>""" + userName + """</csc:strUser>
         <!--Optional:-->
         <csc:strPin>""" + pin + """</csc:strPin>
         <csc:lngSiteID>""" + siteId + """</csc:lngSiteID>
      </csc:GetCurrentPromotionListXML>
   </soapenv:Body>
</soapenv:Envelope>"""

    postAction(payload, 'GetCurrentPromotionListXML')
  }

  def newTenant(rentalTransaction) {

    def rentalType = ((rentalTransaction.rentalUse && rentalTransaction.rentalUse == RentalUse.BUSINESS) ?  294 : 295)
    def payload = """<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:csc="http://centershift.com/csCallCenter/csCallCenterService">
   <soapenv:Header/>
   <soapenv:Body>
      <csc:CreateNewAccount2>
         <csc:strUser>""" + rentalTransaction.site.centerShift.userName + """</csc:strUser>
         <csc:strPin>""" + rentalTransaction.site.centerShift.pin + """</csc:strPin>
         <csc:lngSiteID>""" + rentalTransaction.site.sourceId + """</csc:lngSiteID>
         <csc:strFirstName>""" + rentalTransaction.contactPrimary.firstName + """</csc:strFirstName>
         <csc:strLastName>""" + rentalTransaction.contactPrimary.lastName + """</csc:strLastName>
         <csc:strAccountName>""" + rentalTransaction.contactPrimary.email + """</csc:strAccountName>
         <csc:strAccountClass>298</csc:strAccountClass>
         <csc:strAccountType>""" + rentalType + """</csc:strAccountType>
         <csc:strAddress1>""" + rentalTransaction.contactPrimary.address1 + """</csc:strAddress1>
         <csc:strAddress2>""" + rentalTransaction.contactPrimary.address2 + """</csc:strAddress2>
         <csc:strCity>""" + rentalTransaction.contactPrimary.city + """</csc:strCity>
         <csc:strState>""" + rentalTransaction.contactPrimary.state.display + """</csc:strState>
         <csc:strZip>""" + rentalTransaction.contactPrimary.zipcode + """</csc:strZip>
         <csc:strEmail>""" + rentalTransaction.contactPrimary.email + """</csc:strEmail>
         <csc:strHomePhone>""" + rentalTransaction.contactPrimary.phone + """</csc:strHomePhone>
      </csc:CreateNewAccount2>
   </soapenv:Body>
</soapenv:Envelope>"""

    postAction(payload, 'CreateNewAccount2')
  }

  private def postAction(payload, action) {
    def http = new HTTPBuilder(centerShiftWsUrl3)

    http.handler.failure = {resp, req ->
      println "Unexpected failure: ${resp.statusLine} ${resp.dump()}"
    }

    http.request(Method.POST, XML) {req ->

      delegate.headers['Content-Type'] = "text/xml"

      headers.'SOAPAction' = '"http://centershift.com/csCallCenter/csCallCenterService/' + action + '"'

      body = payload

      response.error = {resp ->
        println "${resp.statusLine}"
      }
    }
  }

  def loadSites(cshift, stats) {
    def ret = getSites(cshift.userName, cshift.pin)
    def records = ret.declareNamespace(
            soap: 'http://schemas.xmlsoap.org/soap/envelope/',
            xsi: 'http://www.w3.org/2001/XMLSchema-instance',
            xsd: 'http://www.w3.org/2001/XMLSchema',
            msdata: 'urn:schemas-microsoft-com:xml-msdata',
            diffgr: 'urn:schemas-microsoft-com:xml-diffgram-v1'
    )


    records.'soap:Body'.'*:GetSiteListResponse'.'*:GetSiteListResult'.'*:SiteList'.'*:Site'.each {tab ->
      def publishable = tab.PUBLISH_WWW.text() == 'Y'

      if (publishable) {
        StorageSite site = StorageSite.findBySourceAndSourceId("CS3", tab.SITE_ID.text())
        def newSite = false
        if (site) {
          stats.updateCount++
          site.units.each {unit ->
            unit.delete()
          }
          site.units.clear()
          site.insurances.each {ins ->
            ins.delete()
          }
          site.insurances.clear()
          site.save(flush:true)
        } else {
          site = new StorageSite()
          stats.createCount++
          site.lastUpdate = 0
          newSite = true
        }
        getSiteDetails(cshift, site, tab, stats, newSite)
      }
    }
  }

  def refreshSites(cshift, stats) {
    def ret = getSites(cshift.userName, cshift.pin)
    def records = ret.declareNamespace(
            soap: 'http://schemas.xmlsoap.org/soap/envelope/',
            xsi: 'http://www.w3.org/2001/XMLSchema-instance',
            xsd: 'http://www.w3.org/2001/XMLSchema',
            msdata: 'urn:schemas-microsoft-com:xml-msdata',
            diffgr: 'urn:schemas-microsoft-com:xml-diffgram-v1'
    )


    for (tab in records.'soap:Body'.'*:GetSiteListResponse'.'*:GetSiteListResult'.'*:SiteList'.'*:Site') {
      StorageSite site = StorageSite.findBySourceAndSourceId("CS3", tab.SITE_ID.text())
      if (!site) {
        println "Found and creating new site: ${tab.SITE_NAME.text()}"
        site = new StorageSite()
        stats.createCount++
        site.lastUpdate = 0
        getSiteDetails(cshift, site, tab, stats, true)
      }
    }
  }

  def updateSite(site, stats) {
    def ret = getSites(cshift.userName, cshift.pin)
    def records = ret.declareNamespace(
            soap: 'http://schemas.xmlsoap.org/soap/envelope/',
            xsi: 'http://www.w3.org/2001/XMLSchema-instance',
            xsd: 'http://www.w3.org/2001/XMLSchema',
            msdata: 'urn:schemas-microsoft-com:xml-msdata',
            diffgr: 'urn:schemas-microsoft-com:xml-diffgram-v1'
    )


    for (tab in records.'soap:Body'.'*:GetSiteListResponse'.'*:GetSiteListResult'.'*:SiteList'.'*:Site') {
      StorageSite foundSite = StorageSite.findBySourceAndSourceId("CS3", tab.SITE_ID.text())
      if (foundSite == site) {
        site.units.each {unit ->
          unit.delete()
        }
        site.insurances.each {ins ->
          ins.delete()
        }
        site.specialOffers.each {offer ->
          offer.delete()
        }
        site.units.clear()
        site.insurances.clear()
        site.specialOffers.clear()
        site.lastUpdate = 0
        site.save(flush: true)

        getSiteDetails(site.centerShift, site, tab, stats, false)
      }
    }
  }

  def getSiteDetails(cshift, site, tab, stats, newSite) {

      site.sourceId = tab.SITE_ID.text()
      site.sourceLoc = tab.SITE_NUMBER.text()
      site.source = "CS3"
      site.title = tab.SITE_NAME.text()

      if (site.title ==~/(?i).*(test|training)\s?+.*/) {
        println "Test or training site - dropping: ${site.title}"
        return
      }

      if (!addSiteAddress(cshift, site)) {
        println "Got a bad address, skipping site creation: ${site.title}"
        return
      }

      addSiteHours(cshift, site)
      addSitePhone(cshift, site)
      addSiteFeatures(cshift, site)

      site.extendedHours = false

      site.siteLink = null
      site.centerShift = cshift

      site.save()

      if (newSite) {
        SiteUser.link(site, cshift.manager)
      }

      def email = tab.EMAIL_ADDRESS.text()
      if (email.size() > 0) {
        createSiteUser(site, email, email, cshift.manager)
      }

      unitsAvailable(cshift, site, stats)

      site.requiresInsurance = loadInsurance(cshift, site)
      loadPromos(cshift, site)
      site.save(flush: true)
  }

  def createSiteUsers(cshift) {
    def ret = getSites(cshift.userName, cshift.pin)
    def records = ret.declareNamespace(
            soap: 'http://schemas.xmlsoap.org/soap/envelope/',
            xsi: 'http://www.w3.org/2001/XMLSchema-instance',
            xsd: 'http://www.w3.org/2001/XMLSchema',
            msdata: 'urn:schemas-microsoft-com:xml-msdata',
            diffgr: 'urn:schemas-microsoft-com:xml-diffgram-v1'
    )


    for (tab in records.'soap:Body'.'*:GetSiteListResponse'.'*:GetSiteListResult'.'*:SiteList'.'*:Site') {
      StorageSite site = StorageSite.findBySourceAndSourceId("CS3", tab.SITE_ID.text())
      println "Create contact for site ${tab.SITE_ID.text()}"
      if (site) {
        def email = tab.EMAIL_ADDRESS.text()
        println "Checking contact for email: ${email}"
        if (email.size() > 0) {
          createSiteUser(site, email, email, cshift.manager)
        }
      }
    }
  }

  def createSitePhones(cshift) {
    def ret = getSites(cshift.userName, cshift.pin)
    def records = ret.declareNamespace(
            soap: 'http://schemas.xmlsoap.org/soap/envelope/',
            xsi: 'http://www.w3.org/2001/XMLSchema-instance',
            xsd: 'http://www.w3.org/2001/XMLSchema',
            msdata: 'urn:schemas-microsoft-com:xml-msdata',
            diffgr: 'urn:schemas-microsoft-com:xml-diffgram-v1'
    )


    for (tab in records.'soap:Body'.'*:GetSiteListResponse'.'*:GetSiteListResult'.'*:SiteList'.'*:Site') {
      StorageSite site = StorageSite.findBySourceAndSourceId("CS3", tab.SITE_ID.text())
      println "Create phone for site ${tab.SITE_ID.text()}"
      if (site) {
        addSitePhone(cshift, site)
      }
    }
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

  def boolean addSiteAddress(cshift, site) {
    def ret = getSiteAddress(cshift.userName, cshift.pin, site.sourceId)
    def records = ret.declareNamespace(
            soap: 'http://schemas.xmlsoap.org/soap/envelope/',
            xsi: 'http://www.w3.org/2001/XMLSchema-instance',
            xsd: 'http://www.w3.org/2001/XMLSchema',
            msdata: 'urn:schemas-microsoft-com:xml-msdata',
            diffgr: 'urn:schemas-microsoft-com:xml-diffgram-v1'
    )


    for (addr in records.'soap:Body'.'*:GetSiteAddressResponse'.'*:GetSiteAddressResult'.'*:SiteAddress'.'*:Address') {
      // TODO - check on ADDRESS_TYPE later
      site.address = addr.STREET.text()
      site.address2 = ''
      site.city = addr.CITY.text()
      site.state = State.fromText(addr.STATE.text())

      if (!site.state) {
        println "Bad state: ${addr.STATE.text()}"
        return false
      }

      site.zipcode = addr.POSTAL_CODE.text()

      def address = addr.STREET.text() + ' ' + ', ' + addr.CITY.text() + ', ' + addr.STATE.text() + ' ' + addr.POSTAL_CODE.text()

      println "Found address: ${address}"
      def geoResult = geocodeService.geocode(address)

      site.lng = geoResult.Placemark[0].Point.coordinates[0]
      site.lat = geoResult.Placemark[0].Point.coordinates[1]

    }
    println "Returning good address: ${site.address}, ${site.city} ${site.state}"
    return true
  }

  def addSitePhone(cshift, site) {
    def ret = getSitePhones(cshift.userName, cshift.pin, site.sourceId)

    if (!ret) return
    
    def records = ret.declareNamespace(
            soap: 'http://schemas.xmlsoap.org/soap/envelope/',
            xsi: 'http://www.w3.org/2001/XMLSchema-instance',
            xsd: 'http://www.w3.org/2001/XMLSchema',
            msdata: 'urn:schemas-microsoft-com:xml-msdata',
            diffgr: 'urn:schemas-microsoft-com:xml-diffgram-v1'
    )
    int count = 0;
    for (phone in records.'soap:Body'.'*:GetSitePhonesResponse'.'*:GetSitePhonesResult'.'*:SitePhones'.'*:Phone') {
      def phoneNumber = phone.PHONE_NUMBER.text()
      def value = phone.VALUE.text().toLowerCase()
      if (count++ == 0 || (value == 'site' || value == 'office')) {
        site.phone = phoneNumber
      }
    }
  }

  def addSiteHours(cshift, site) {
    def ret = getSiteHours(cshift.userName, cshift.pin, site.sourceId)
    def records = ret.declareNamespace(
            soap: 'http://schemas.xmlsoap.org/soap/envelope/',
            xsi: 'http://www.w3.org/2001/XMLSchema-instance',
            xsd: 'http://www.w3.org/2001/XMLSchema',
            msdata: 'urn:schemas-microsoft-com:xml-msdata',
            diffgr: 'urn:schemas-microsoft-com:xml-diffgram-v1'
    )


    for (hours in records.'soap:Body'.'*:GetSiteHoursResponse'.'*:GetSiteHoursResult'.'*:SiteHours'.'*:Hours') {
      def day = hours.WEEKDAY.text()

      switch(day) {
        case "Mon":
          def office = hours.OFFICE.text().toLowerCase()
          if (office == 'closed') {
            site.openWeekday = false
          } else {
            site.openWeekday = true
            def m = office =~   /(?i)(\d{1,2}(:\d{0,2})?+\s*[ap]?\.?m?\.?)\s*(to|-)\s*(\d{1,2}(:\d{0,2})?+\s*[ap]?\.?m?\.?)\s*/
            if (m.matches()) {
              def start = m[0][1].replaceAll(/\./, "").replaceAll(" ", "").toLowerCase()
              def end = m[0][4].replaceAll(/\./, "").replaceAll(" ", "").toLowerCase()
              if (start.contains(':') && start.contains('m')) {
                site.startWeekday = Date.parse("HH:mma", start)
              } else if (start.contains(':')) {
                site.startWeekday = Date.parse("HH:mm", start)
              } else if (start.contains('m')) {
                site.startWeekday = Date.parse("HHa", start)
              } else {
                site.startWeekday = Date.parse("HH", start)
              }
              if (end.contains(':') && end.contains('m')) {
                site.endWeekday = Date.parse("HH:mma", end)
              } else if (end.contains(':')) {
                site.endWeekday = Date.parse("HH:mma", end + 'PM')
              } else if (end.contains('m')) {
                site.endWeekday = Date.parse("HHa", end)
              } else {
                def endPM = ((end as Integer) + 12) as String
                site.endWeekday = Date.parse("HH", endPM)
              }
            } else {
              println "Hours do not match: ${office}"
            }
          }
          def gate = hours.GATE.text()
          def n = gate =~   /(?i)(\d{1,2}(:\d{0,2})?+\s*[ap]?\.?m?\.?)\s*(to|-)\s*(\d{1,2}(:\d{0,2})?+\s*[ap]?\.?m?\.?)\s*/
          if (n.matches()) {
            def start = n[0][1].replaceAll(/\./, "").replaceAll(" ", "").toLowerCase()
            def end = n[0][4].replaceAll(/\./, "").replaceAll(" ", "").toLowerCase()
            if (start.contains(':') && start.contains('m')) {
              site.startGate = Date.parse("HH:mma", start)
            } else if (start.contains(':')) {
              site.startGate = Date.parse("HH:mm", start)
            } else if (start.contains('m')) {
              site.startGate = Date.parse("HHa", start)
            } else {
              site.startGate = Date.parse("HH", start)
            }
            if (end.contains(':') && end.contains('m')) {
              site.endGate = Date.parse("HH:mma", end)
            } else if (end.contains(':')) {
              site.endGate = Date.parse("HH:mma", end + "PM")
            } else if (end.contains('m')) {
              site.endGate = Date.parse("HHa", end)
            } else {
              def endPM = ((end as Integer) + 12) as String
              site.endGate = Date.parse("HH", endPM)
            }
          } else {
            println "Gate does not match: ${gate}"
          }
          break

        case "Sat":
          def office = hours.OFFICE.text().toLowerCase()
          if (office == 'closed') {
            site.openSaturday = false
          } else {
            site.openSaturday = true
            def m = office =~   /(?i)(\d{1,2}(:\d{0,2})?+\s*[ap]?\.?m?\.?)\s*(to|-)\s*(\d{1,2}(:\d{0,2})?+\s*[ap]?\.?m?\.?)\s*/
            if (m.matches()) {
              def start = m[0][1].replaceAll(/\./, "").replaceAll(" ", "").toLowerCase()
              def end = m[0][4].replaceAll(/\./, "").replaceAll(" ", "").toLowerCase()
              if (start.contains(':') && start.contains('m')) {
                site.startSaturday = Date.parse("HH:mma", start)
              } else if (start.contains(':')) {
                site.startSaturday = Date.parse("HH:mm", start)
              } else if (start.contains('m')) {
                site.startSaturday = Date.parse("HHa", start)
              } else {
                site.startSaturday = Date.parse("HH", start)
              }
              if (end.contains(':') && end.contains('m')) {
                site.endSaturday = Date.parse("HH:mma", end)
              } else if (end.contains(':')) {
                site.endSaturday = Date.parse("HH:mma", end + "PM")
              } else if (end.contains('m')) {
                site.endSaturday = Date.parse("HHa", end)
              } else {
                def endPM = ((end as Integer) + 12) as String
                site.endSaturday = Date.parse("HH", endPM)
              }
            } else {
              println "Saturday Office does not match: ${office}"
            }
          }
          break

        case "Sun":
          def office = hours.OFFICE.text().toLowerCase()
          if (office == 'closed') {
            site.openSunday = false
          } else {
            site.openSunday = true
            def m = office =~   /(?i)(\d{1,2}(:\d{0,2})?+\s*[ap]?\.?m?\.?)\s*(to|-)\s*(\d{1,2}(:\d{0,2})?+\s*[ap]?\.?m?\.?)\s*/
            if (m.matches()) {
              def start = m[0][1].replaceAll(/\./, "").replaceAll(" ", "").toLowerCase()
              def end = m[0][4].replaceAll(/\./, "").replaceAll(" ", "").toLowerCase()
              if (start.contains(':') && start.contains('m')) {
                site.startSunday = Date.parse("HH:mma", start)
              } else if (start.contains(':')) {
                site.startSunday = Date.parse("HH:mm", start)
              } else if (start.contains('m')) {
                site.startSunday = Date.parse("HHa", start)
              } else {
                site.startSunday = Date.parse("HH", start)
              }
              if (end.contains(':') && end.contains('m')) {
                site.endSunday = Date.parse("HH:mma", end)
              } else if (end.contains(':')) {
                site.endSunday = Date.parse("HH:mma", end + "PM")
              } else if (end.contains('m')) {
                site.endSunday = Date.parse("HHa", end)
              } else {
                def endPM = ((end as Integer) + 12) as String
                site.endSunday = Date.parse("HH", endPM)
              }
            } else {
              println "Sunday Office does not match: ${office}"
            }
          }
          def gate = hours.GATE.text()
          def n = gate =~   /(?i)(\d{1,2}(:\d{0,2})?+\s*[ap]?\.?m?\.?)\s*(to|-)\s*(\d{1,2}(:\d{0,2})?+\s*[ap]?\.?m?\.?)\s*/
          if (n.matches()) {
            def start = n[0][1].replaceAll(/\./, "").replaceAll(" ", "").toLowerCase()
            def end = n[0][4].replaceAll(/\./, "").replaceAll(" ", "").toLowerCase()
            if (start.contains(':') && start.contains('m')) {
              site.startSundayGate = Date.parse("HH:mma", start)
            } else if (start.contains(':')) {
              site.startSundayGate = Date.parse("HH:mm", start)
            } else if (start.contains('m')) {
              site.startSundayGate = Date.parse("HHa", start)
            } else {
              site.startSundayGate = Date.parse("HH", start)
            }
            if (end.contains(':') && end.contains('m')) {
              site.endSundayGate = Date.parse("HH:mma", end)
            } else if (end.contains(':')) {
              site.endSundayGate = Date.parse("HH:mma", end + "PM")
            } else if (end.contains('m')) {
              site.endSundayGate = Date.parse("HHa", end)
            } else {
              def endPM = ((end as Integer) + 12) as String
              site.endSundayGate = Date.parse("HH", endPM)
            }
          } else {
            println "Sunday Gate does not match: ${gate}"
          }
          break

        default:
          break
      }

    }
  }

  def addSiteFeatures(cshift, site) {
    def ret = getSiteFeatures(cshift.userName, cshift.pin, site.sourceId)
    def records = ret.declareNamespace(
            soap: 'http://schemas.xmlsoap.org/soap/envelope/',
            xsi: 'http://www.w3.org/2001/XMLSchema-instance',
            xsd: 'http://www.w3.org/2001/XMLSchema',
            msdata: 'urn:schemas-microsoft-com:xml-msdata',
            diffgr: 'urn:schemas-microsoft-com:xml-diffgram-v1'
    )

    def featuresSet = false
    for (features in records.'soap:Body'.'*:GetSiteFeaturesResponse'.'*:GetSiteFeaturesResult'.'*:SiteFeatures'.'*:Features') {
      featuresSet = true
      site.isManagerOnsite = features.ON_SITE_MANAGER.text() == 'Y'
      site.isGate = features.ELEC_GATE_ACCESS.text() == 'Y'
      site.isKeypad = features.ELEC_GATE_ACCESS.text() == 'Y'
      site.isCamera = features.VIDEO_SURVEILLANCE.text() == 'Y'
      site.isUnitAlarmed = features.ALARMED_UNITS.text() == 'Y'
      site.adminFee = features.ADMIN_FEE.text() as BigDecimal
      site.hasElevator = false
      site.requiresInsurance = false
      site.boxesAvailable = true
      site.freeTruck = TruckType.NONE
    }
    if (!featuresSet) {
      site.isManagerOnsite = false
      site.isGate = false
      site.isKeypad = false
      site.isCamera = false
      site.isUnitAlarmed = false
      site.adminFee = 0.00 as BigDecimal
      site.hasElevator = false
      site.requiresInsurance = false
      site.boxesAvailable = true
      site.freeTruck = TruckType.NONE
    }
  }

  def updateUnits(site, stats) {
    site.units.each {unit ->
      unit.delete()
    }
    site.units.clear()
    site.save()
    unitsAvailable(site.centerShift, site, stats)
    site.save(flush: true)
  }

  def unitsAvailable(cshift, site, stats) {
    def ret = getSiteUnits(cshift.userName, cshift.pin, site.sourceId)
    def records = ret.declareNamespace(
            soap: 'http://schemas.xmlsoap.org/soap/envelope/',
            xsi: 'http://www.w3.org/2001/XMLSchema-instance',
            xsd: 'http://www.w3.org/2001/XMLSchema',
            msdata: 'urn:schemas-microsoft-com:xml-msdata',
            diffgr: 'urn:schemas-microsoft-com:xml-diffgram-v1'
    )
    for(unit in records.'soap:Body'.'*:GetSiteUnitDataResponse'.'*:GetSiteUnitDataResult'.'*:SiteUnitData'.'*:Unit') {

      def vacant = unit.VACANT.text() as Integer
      def typeName = unit.VALUE.text()
      if (vacant > 0 && !(typeName ==~ /(?i).*(parking|cell|mailbox|slip|apartment|office|container|portable|wine).*/)) {
        def dimensions = unit.DIMENSIONS.text()
        def m = dimensions =~ /(\d+\.*\d*)\s*X\s*(\d+\.*\d*)/
        if (m.matches()) {
          // legal dimensions
          def width = m[0][1] as Double
          def length = m[0][2] as Double
          def unitSize = unitSizeService.getUnitSize(width, length)
          if (unitSize) {
            def siteUnit = new StorageUnit()
            siteUnit.unitsize = unitSize
            siteUnit.unitCount = vacant
            siteUnit.description = typeName
            siteUnit.unitName = siteUnit.unitNumber = unit.ATTRIBUTES.text()
            siteUnit.pushRate = siteUnit.price = unit.STREET_RATE.text() as BigDecimal
            siteUnit.taxRate = unit.TAX_RATE.text() as BigDecimal

            // outside = driveup
            // down = interior
            siteUnit.isUpper = ((typeName ==~ /(?i).*\s+up\s+.*/ && !(typeName ==~ /(?i).*drive.*/)) || typeName ==~ /(?i).*(2nd|3rd|second|third).*/)
            siteUnit.isDriveup = (typeName ==~ /(?i).*(drive|roll-up|roll up).*/)
            siteUnit.isInterior = (!siteUnit.isUpper && !siteUnit.isDriveup && !(typeName ==~ /(?i).*outer.*/)) || (typeName ==~ /(?i).*(interior|ground|1st).*/)
            if (!siteUnit.isUpper && !siteUnit.isInterior && !siteUnit.isDriveup) {
              siteUnit.isUpper = true
            }
            siteUnit.isAlarm = false
            siteUnit.isTempControlled = (typeName ==~ /(?i).*climate\s+.*/ && !(typeName ==~ /(?i).*non-climate\s+.*/))
            siteUnit.isPowered = false
            siteUnit.isAvailable = true
            siteUnit.isSecure = false
            siteUnit.displaySize = dimensions
            stats.unitCount += vacant

            site.addToUnits(siteUnit)
            
          } else {
            println "Skipping due to size: length = ${length}, width = ${width}"
          }
        }
      } else {
        if (vacant == 0) {
          println "Skipped due to full occupancy: ${typeName}"
        } else {
          println "Skipped due to parking or other: ${typeName}"
        }
      }
    }
  }

  def loadPromos(cshift, site) {
    def ret = getPromos(cshift.userName, cshift.pin, site.sourceId)
    def records = ret.declareNamespace(
            soap: 'http://schemas.xmlsoap.org/soap/envelope/',
            xsi: 'http://www.w3.org/2001/XMLSchema-instance',
            xsd: 'http://www.w3.org/2001/XMLSchema',
            msdata: 'urn:schemas-microsoft-com:xml-msdata',
            diffgr: 'urn:schemas-microsoft-com:xml-diffgram-v1'
    )
    for(promo in records.'soap:Body'.'*:GetCurrentPromotionListXMLResponse'.'*:GetCurrentPromotionListXMLResult'.'*:promotions'.'*:promo-info') {

      def description = promo.'promo-desc'.text()

      def validGov = true
      def promoSize = null

      for(gov in promo.'promo-governors'.governor) {
        def limitFactor = gov.'limiting-factor'.text()
        if (limitFactor ==~ /Existing.*/) {
          validGov = false
        }
        if (limitFactor == 'Unit Dimensions/Size') {
          def govValue = gov.'governor-value'.text()
          def m = govValue =~ /(\d+)\s*X\s*(\d+)/
          if (m.matches()) {
            def width = m[0][1] as Double
            def length = m[0][2] as Double
            promoSize = unitSizeService.getUnitSize(width, length)
          }
        }
      }

      if (validGov && !(description ==~ /Comp.*/)) {

        SpecialOffer specialOffer = new SpecialOffer()
        specialOffer.concessionId = promo.'promo-id'.text() as Integer
        specialOffer.promoSize = promoSize
        specialOffer.active = true;
        specialOffer.featured = false;
        specialOffer.waiveAdmin = false;
        specialOffer.prepay = (promo.'discount-periods'.text() as Integer) > 0
        specialOffer.expireMonth = specialOffer.prepay ? promo.'discount-periods'.text() as Integer : 0
        specialOffer.prepayMonths = specialOffer.prepay ? (promo.'prepay-periods'.text() as Integer) : 1
        specialOffer.description = description
        specialOffer.promoName = promo.'promo-name'.text()
        specialOffer.inMonth = 0
        specialOffer.promoQty = promo.'discount-min'.text() as BigDecimal
        if (specialOffer.promoQty == 0) specialOffer.promoQty = promo.'discount-max'.text() as BigDecimal 

        def ptype = promo.'discount-type'.text()
        switch (ptype) {
          case '$':
            specialOffer.promoType = PromoType.AMOUNT_OFF
            break

          case '%':
            specialOffer.promoType = PromoType.PERCENT_OFF
            break

          case 'O':
            specialOffer.promoType = PromoType.FIXED_RATE
            break

          default:
            println "Unknown promoType: ${ptype}"
            return
        }
        specialOffer.save()
        site.addToSpecialOffers(specialOffer)
      }

    }
  }

  def loadInsurance(cshift, site) {
    CsKiosk service = new CsKioskLocator();

    CsKioskSoapPort_PortType port = service.getcsKioskSoapPort()
    //invoke business method
    def insOptions = port.getInsuranceOptions(cshift.userName, cshift.pin, site.sourceId)

    if (insOptions instanceof Integer && insOptions < 0) {
      println "Return for insurance < 0 : ${insOptions}"
      return 0
    }
    
    if (insOptions) {
      def insId = insOptions[0]
      def insProvider = insOptions[1]
      def insAmount = insOptions[2]
      def insRate = insOptions[3]
      def insCoverage = insOptions[4]

      def optionSize = insId.size()
      for(i in 0..optionSize-1) {
        def ins = new Insurance()
        ins.insuranceId = insId[i] as Integer
        ins.percentTheft = (insCoverage[i] as BigDecimal) / 100.0
        ins.provider = insProvider[i]
        ins.premium = insRate[i] as BigDecimal
        ins.totalCoverage = insAmount[i] as BigDecimal
        
        if (!ins.save()) {
          ins.errors.allErrors.each { println it }
        }

        println "Adding new insurance: ${ins.dump()}"
        
        site.addToInsurances(ins)
      }
      return optionSize
    } else {
      println "Could not obtain insurance information"
      return 0
    }
  }

  def checkRented(RentalTransaction rentalTransaction) {
    def unit = StorageUnit.get(rentalTransaction.unitId)
    def cshift = rentalTransaction.site.centerShift

    if (!unit) return false

    CsKiosk service = new CsKioskLocator();

    CsKioskSoapPort_PortType port = service.getcsKioskSoapPort()

    println "checkRented (${cshift.userName}, ${cshift.pin}, ${rentalTransaction.site.sourceId as Long}, ${unit.unitName as Long}, ${unit.displaySize})"
    
    def unitInfo = port.getAvailableUnits(cshift.userName, cshift.pin, rentalTransaction.site.sourceId as Long, unit.unitName as Long, unit.displaySize)

    if ((unitInfo instanceof Integer || unitInfo instanceof String) && (unitInfo as Integer) < 0) {
      println "Return for getAvailableUnits < 0 : ${unitInfo}"
      return false
    }

    println "Dumping unit info: ${unitInfo.dump()}"

    def unitId = unitInfo[0]
    def dimensions = unitInfo[1]
    def sqFt = unitInfo[2]
    def rate = unitInfo[3]
    def unitNumber = unitInfo[4]
    def attrDesc = unitInfo[5]
    def attrId = unitInfo[6]
    def promoAvail = unitInfo[7]
    def promoId = unitInfo[8]
    def promoDesc = unitInfo[9]

    rentalTransaction.feedUnitId = unitId[0] as Long
    rentalTransaction.feedUnitNumber = unitNumber[0]
    if (promoAvail[0] == 'Y' && rentalTransaction?.promoId > 0) {
      def promoCheck = rentalTransaction.site.specialOffers.findBy{ it.concessionId == (promoId[0] as Long)}
      if (promoCheck) {
        rentalTransaction.promoId = promoId[0] as Long
      }
    }
    rentalTransaction.save(flush: true)
    return true
  }

  def createTenant(RentalTransaction rentalTransaction) {
    def ret = newTenant(rentalTransaction)

    println "newTenant returned: ${ret}"

    def records = ret.declareNamespace(
            soap: 'http://schemas.xmlsoap.org/soap/envelope/',
            xsi: 'http://www.w3.org/2001/XMLSchema-instance',
            xsd: 'http://www.w3.org/2001/XMLSchema',
            msdata: 'urn:schemas-microsoft-com:xml-msdata',
            diffgr: 'urn:schemas-microsoft-com:xml-diffgram-v1'
    )
    for(acct in records.'soap:Body'.'*:CreateNewAccount2Response'.'*:CreateNewAccount2Result'.'*:CreateNewAccount'.'*:Account') {

      rentalTransaction.tenantId = acct.ACCOUNT_ID.text()
    }
    rentalTransaction.save(flush:true)
  }

  def moveInDetail(RentalTransaction rentalTransaction) {

    if (!checkRented(rentalTransaction)) {
      return null
    }

    def cshift = rentalTransaction.site.centerShift

    def insId = -1
    if (rentalTransaction.insuranceId > 0) {
      def ins = Insurance.get(rentalTransaction.insuranceId)
      insId = ins.insuranceId
    }

    CsKiosk service = new CsKioskLocator();

    CsKioskSoapPort_PortType port = service.getcsKioskSoapPort()

    println "getMoveInCost params: ${cshift.userName}, ${cshift.pin}, ${rentalTransaction.site.sourceId as Long}, ${rentalTransaction.feedUnitId}, ${insId as String}"

    def ret = port.getMoveInCost(cshift.userName, cshift.pin, rentalTransaction.site.sourceId as Long, rentalTransaction.feedUnitId, insId as String)

    if (ret instanceof Integer && ret < 0) {
      println "Return for getMoveInCost < 0 : ${ret}"
      return null
    }

    println "Dumping getMoveInCost : ${ret.dump()}"

    def desc = ret[0]
    def price = ret[1]
    def tax = ret[2]
    def subtotal = ret[3]
    def start = ret[4]
    def end = ret[5]

    def itemLength = end.size() - 1
    rentalTransaction.paymentString = end[itemLength] as String
    rentalTransaction.save(flush: true)

    def moveInDetails = new MoveInDetails()
    for(i in 0..itemLength - 1) {
      moveInDetails.items.add(new LineItem(description:desc[i], tax:tax[i] as BigDecimal, amount: price[i] as BigDecimal))
    }
    
    return moveInDetails
  }

  def moveIn(RentalTransaction rentalTransaction) {
    def cshift = rentalTransaction.site.centerShift

    def insId = -1
    if (rentalTransaction.insuranceId > 0) {
      def ins = Insurance.get(rentalTransaction.insuranceId)
      insId = ins.insuranceId
    }

    CsKiosk service = new CsKioskLocator();

    CsKioskSoapPort_PortType port = service.getcsKioskSoapPort()

    println "doMoveIn params: ${cshift.userName}, ${cshift.pin}, ${rentalTransaction.site.sourceId as Long}, ${rentalTransaction.tenantId as Long}, ${rentalTransaction.feedUnitId}, ${insId as String},  ${paymentString}, \"Storitz  \", \"0123456789\", \"Storitz Acct.\", \"10\", \"\", \"K\" "
    // Use ACH to allow Centershift to report transactions
    ret = port.doMoveIn(cshift.userName, cshift.pin, rentalTransaction.site.sourceId as Long, rentalTransaction.tenantId as Long, rentalTransaction.feedUnitId, insId as String,
            rentalTransaction.paymentString, "Storitz  ", "0123456789", "Storitz Acct.", "10", "00000", "K")

    if (ret instanceof Integer && ret < 0) {
      println "Return for doMoveIn < 0 : ${ret}"
      return false
    }

    println "Return from doMoveIn: ${ret}"

    rentalTransaction.idNumber = ret
    rentalTransaction.save(flush: true)

    return true

  }

  def calculateMoveInCost(StorageSite site, StorageUnit unit, SpecialOffer promo, Insurance ins, Date moveInDate, boolean extended) {
    def ret = calculateTotals(site, unit, promo, ins, moveInDate, extended)
    return ret["moveInTotal"]
  }

  def calculatePaidThruDate(StorageSite site, SpecialOffer promo, Date moveInDate) {
    // TODO - handle prorated payments
    def durationMonths = promo ? [promo.prepayMonths, promo.expireMonth].max() : 1;

    def cal = new GregorianCalendar()
    cal.setTime(moveInDate)
    // force a bump for people who rent after the 15th
    if (cal.get(Calendar.DAY_OF_MONTH) > 15) durationMonths++;
    if (durationMonths - 1 > 0) {
      cal.add(Calendar.MONTH, durationMonths - 1)
    }
    cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH))
    return cal.time
  }

  def calculateTotals(StorageSite site, StorageUnit unit, SpecialOffer promo, Insurance ins, Date moveInDate) {
    calculateTotals(site, unit, promo, ins, moveInDate, true)
  }

  def calculateTotals(StorageSite site, StorageUnit unit, SpecialOffer promo, Insurance ins, Date moveInDate, boolean allowExtension) {

    // TODO

    def ret = [:]
    def durationMonths = promo ? (promo.prepay ? promo.prepayMonths + promo.expireMonth : (promo.inMonth -1) + promo.expireMonth) : 1;
    def offerDiscount = 0
    def rate = unit ? unit.pushRate : 0
    def premium = ins ? ins.premium : 0
    def additionalFees = site.adminFee ? site.adminFee : site.lockFee ? site.lockFee : 0
    def adminFee = site.adminFee ? site.adminFee : 0
    def waiveAdmin = false

    if (promo) {

      waiveAdmin = promo.waiveAdmin

      switch (promo.promoType) {
        case "AMOUNT_OFF":
          offerDiscount = promo.promoQty * promo.expireMonth;
          break;

        case "PERCENT_OFF":
          offerDiscount = (promo.promoQty/100.0) * promo.expireMonth * unit.price;
          break;

        case "FIXED_RATE":
          offerDiscount = ((rate - promo.promoQty) > 0 ? (rate - promo.promoQty): 0) * promo.expireMonth;
          break;
      }
    }

    def cal = new GregorianCalendar()
    cal.setTime(moveInDate)
    def lastDayInMonth = cal.getActualMaximum(Calendar.DAY_OF_MONTH)
    def moveInDay = cal.get(Calendar.DAY_OF_MONTH)

    if (durationMonths - 1 > 0) {
      cal.add(Calendar.MONTH, durationMonths - 1)
    }
    cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH))

    if (allowExtension) {
      if (moveInDay > 15) {
       durationMonths++;
        ret["extended"] = true;
      } else {
        ret["extended"] = false;
      }
    }
    //durationMonths -= (1 - ((lastDayInMonth - moveInDay) + 1)/30)


    def feesTotal = (waiveAdmin ? additionalFees - adminFee : additionalFees)
    def subTotal = (rate*durationMonths).setScale(2, RoundingMode.HALF_UP) + (premium*durationMonths).setScale(2, RoundingMode.HALF_UP)
    // TODO handle AZ insurance tax
    def tax = ((premium * durationMonths) * (unit.taxRate)).setScale(2, RoundingMode.HALF_UP)

    println "CShift tax rate on unit is ${unit.taxRate} and taxable amount is ${premium*durationMonths}"
    
    def moveInTotal = feesTotal + subTotal + tax - offerDiscount;

    ret["durationMonths"] = durationMonths
    ret["discountTotal"] = offerDiscount
    ret["feesTotal"] = feesTotal
    ret["tax"] = tax
    ret["moveInTotal"] = moveInTotal
    ret["paidThruDate"] = cal.time.format('MM/dd/yy')

    return ret
  }
}

