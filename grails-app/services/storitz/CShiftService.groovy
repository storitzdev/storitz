package storitz

import com.storitz.cshiftclient.CsKiosk
import com.storitz.cshiftclient.CsKioskLocator
import com.storitz.cshiftclient.CsKioskSoapPort_PortType
import groovyx.net.http.HTTPBuilder
import groovyx.net.http.Method
import java.math.RoundingMode
import com.storitz.*
import static groovyx.net.http.ContentType.XML
import storitz.constants.*

class CShiftService {

  def geocodeService
  def unitSizeService

  boolean transactional = false

  def getSites(url, userName, pin) {
    def payload = """<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:csc="http://centershift.com/csCallCenter/csCallCenterService">
   <soapenv:Header/>
   <soapenv:Body>
      <csc:GetSiteList>
         <csc:strUser>""" + userName + """</csc:strUser>
         <csc:strPin>""" + pin + """</csc:strPin>
      </csc:GetSiteList>
   </soapenv:Body>
</soapenv:Envelope>"""

    postAction(url, payload, 'GetSiteList')
  }

  def getSiteAddress(url, userName, pin, siteId) {
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

    postAction(url, payload, 'GetSiteAddress')
  }

  def getSiteHours(url, userName, pin, siteId) {
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

    postAction(url, payload, 'GetSiteHours')
  }

  def getSiteFeatures(url, userName, pin, siteId) {
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

    postAction(url, payload, 'GetSiteFeatures')
  }

  def getSitePhones(url, userName, pin, siteId) {
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

    postAction(url, payload, 'GetSitePhones')
  }

  def getSiteUnits(url, userName, pin, siteId) {
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

    postAction(url, payload, 'GetSiteUnitData')
  }

  def getPromos(url, userName, pin, siteId) {
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

    postAction(url, payload, 'GetCurrentPromotionListXML')
  }

  def newTenant(rentalTransaction) {

    def rentalType = ((rentalTransaction.rentalUse && rentalTransaction.rentalUse == RentalUse.BUSINESS) ?  294 : 295)
    def centerShift = (CenterShift)rentalTransaction.site.feed
    def payload = """<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:csc="http://centershift.com/csCallCenter/csCallCenterService">
   <soapenv:Header/>
   <soapenv:Body>
      <csc:CreateNewAccount2>
         <csc:strUser>""" + centerShift.userName + """</csc:strUser>
         <csc:strPin>""" + centerShift.pin + """</csc:strPin>
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

    postAction(centerShift.location.webUrl, payload, 'CreateNewAccount2')
  }

  def getReservationUnitData(url, userName, pin, siteId, dimension, attribute) {

    def payload = """<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:csc="http://centershift.com/csCallCenter/csCallCenterService">
   <soapenv:Header/>
   <soapenv:Body>
      <csc:GetReservationUnitData>
         <csc:strUser>""" + userName + """</csc:strUser>
         <csc:strPin>""" + pin + """</csc:strPin>
         <csc:lngSiteID>""" + siteId + """</csc:lngSiteID>
         <csc:strDimension>""" + dimension + """</csc:strDimension>
         <csc:lngAttributes>""" + attribute + """</csc:lngAttributes>
      </csc:GetReservationUnitData>
   </soapenv:Body>
</soapenv:Envelope>"""

    println "GetReservationUnitDate: ${payload}"
    
    postAction(url, payload, 'GetReservationUnitData')
  }

  def makeReservation(RentalTransaction rentalTransaction) {
     def centerShift = (CenterShift)rentalTransaction.site.feed
     def payload = """<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:csc="http://centershift.com/csCallCenter/csCallCenterService">
   <soapenv:Header/>
   <soapenv:Body>
      <csc:MakeReservationNonCCPayment>
         <csc:strUser>""" + centerShift.userName + """</csc:strUser>
         <csc:strPIN>""" + centerShift.pin + """</csc:strPIN>
         <csc:lngSiteID>""" + rentalTransaction.site.sourceId + """</csc:lngSiteID>
         <csc:lngContactID>""" + rentalTransaction.contactId + """</csc:lngContactID>
         <csc:strReservationStartDate>""" + rentalTransaction.moveInDate.format('MM/dd/yyyy') + """</csc:strReservationStartDate>
         <csc:lngUnitID>""" + rentalTransaction.feedUnitId + """</csc:lngUnitID>
         <csc:sngNewRate>-1</csc:sngNewRate>
         <csc:sngAmount>""" + rentalTransaction.reservationCost + """</csc:sngAmount>
         <csc:strPayMethod>K</csc:strPayMethod>
         <csc:strCheckNumber>0123456789</csc:strCheckNumber>
         <csc:strCheckAcct>Storitz Acct.</csc:strCheckAcct>
      </csc:MakeReservationNonCCPayment>
   </soapenv:Body>
</soapenv:Envelope>"""

    println "makeReservation: ${payload}"
    
    postAction(centerShift.location.webUrl, payload, 'MakeReservationNonCCPayment')
  }

  def insertAccountNote(url, userName, pin, siteId, note) {
    def payload = """<soap:Envelope xmlns:soap="http://www.w3.org/2003/05/soap-envelope" xmlns:csc="http://centershift.com/csCallCenter/csCallCenterService">
   <soap:Header/>
   <soap:Body>
      <csc:InsertAccountNote>
         <csc:strUser>""" + userName + """</csc:strUser>
         <csc:strPIN>""" + pin + """</csc:strPIN>
         <csc:lngAccountID>""" + siteId + """</csc:lngAccountID>
         <csc:strNote>""" + note + """</csc:strNote>
         <csc:blnPriority>false</csc:blnPriority>
         <csc:dteExpireDate>""" + (new Date().format('yyyy-MM-dd')) + """</csc:dteExpireDate>
      </csc:InsertAccountNote>
   </soap:Body>
</soap:Envelope>"""

    println "account note: ${payload}"

    postAction(url, payload, "InsertAccountNote")

  }

  private def postAction(url, payload, action) {
    def http = new HTTPBuilder(url)

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

  def loadSites(cshift, stats, writer) {
    def ret = getSites(cshift.location.webUrl, cshift.userName, cshift.pin)
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
        getSiteDetails(cshift, site, tab, stats, newSite, writer)
      }
    }
  }

  def refreshSites(cshift, stats, writer) {
    def ret = getSites(cshift.location.webUrl, cshift.userName, cshift.pin)
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
        writer.println "Found and creating new site: ${tab.SITE_NAME.text()}"
        site = new StorageSite()
        stats.createCount++
        site.lastUpdate = 0
        getSiteDetails(cshift, site, tab, stats, true, writer)
      }
    }
  }

  def updateSite(site, stats, writer) {
    def centerShift = (CenterShift)site.feed

    def ret = getSites(centerShift.location.webUrl, centerShift.userName, centerShift.pin)
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

        getSiteDetails(centerShift, site, tab, stats, false, writer)
      }
    }
  }

  def getSiteDetails(cshift, site, tab, stats, newSite, writer) {

      site.sourceId = tab.SITE_ID.text()
      site.sourceLoc = tab.SITE_NUMBER.text()
      site.source = "CS3"
      site.title = tab.SITE_NAME.text()

      if (site.title ==~/(?i).*(test|training)\s?+.*/) {
        writer.println "Test or training site - dropping: ${site.title}"
        return
      }

      if (!addSiteAddress(cshift, site, writer)) {
        writer.println "Got a bad address, skipping site creation: ${site.title}"
        return
      }

      addSiteHours(cshift, site)
      addSitePhone(cshift, site, writer)
      addSiteFeatures(cshift, site)

      site.extendedHours = false

      site.feed  = cshift

      site.save()

      if (newSite) {
        SiteUser.link(site, cshift.manager)
        site.disabled = true
        site.lastChange = new Date()
      }

      def email = tab.EMAIL_ADDRESS.text()
      if (email.size() > 0) {
        createSiteUser(site, email, email, cshift.manager)
      }

      unitsAvailable(cshift, site, stats, writer)

      site.requiresInsurance = loadInsurance(cshift, site)
      loadPromos(cshift, site, writer)
      site.save(flush: true)
  }

  def createSiteUsers(cshift) {
    def ret = getSites(cshift.location.webUrl, cshift.userName, cshift.pin)
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

  def createSitePhones(cshift, writer) {
    def ret = getSites(cshift.location.webUrl, cshift.userName, cshift.pin)
    def records = ret.declareNamespace(
            soap: 'http://schemas.xmlsoap.org/soap/envelope/',
            xsi: 'http://www.w3.org/2001/XMLSchema-instance',
            xsd: 'http://www.w3.org/2001/XMLSchema',
            msdata: 'urn:schemas-microsoft-com:xml-msdata',
            diffgr: 'urn:schemas-microsoft-com:xml-diffgram-v1'
    )


    for (tab in records.'soap:Body'.'*:GetSiteListResponse'.'*:GetSiteListResult'.'*:SiteList'.'*:Site') {
      StorageSite site = StorageSite.findBySourceAndSourceId("CS3", tab.SITE_ID.text())
      writer.println "Create phone for site ${tab.SITE_ID.text()}"
      if (site) {
        addSitePhone(cshift, site, writer)
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
      if (user.validate()) {
        user.save(flush: true)
        SiteUser.link(site, user)
      } else {
        println "Bad user from feed - errors below: "
        user.errors.allErrors.each {
          println it
        }
        return;
      }
    }
    if (!UserNotificationType.userHasNotificationType(user, 'NOTIFICATION_SITE_MANAGER')) {
      def notificationType = NotificationType.findByNotificationType('NOTIFICATION_SITE_MANAGER')
      UserNotificationType.create(user, notificationType, true)
    }
    if (!UserRole.userHasRole(user,'ROLE_USER')) {
      UserRole.create(user, Role.findByAuthority('ROLE_USER'), true)
    }
  }

  def boolean addSiteAddress(cshift, site, writer) {
    def ret = getSiteAddress(cshift.location.webUrl, cshift.userName, cshift.pin, site.sourceId)
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
      try {
        site.state = State.fromText(addr.STATE.text().toUpperCase())
      } catch (Exception e) {
      }

      if (!site.state) {
        writer.println "Bad state: ${addr.STATE.text()}"
        return false
      }

      site.zipcode = addr.POSTAL_CODE.text()

      def address = addr.STREET.text() + ' ' + ', ' + addr.CITY.text() + ', ' + addr.STATE.text() + ' ' + addr.POSTAL_CODE.text()

      writer.println "Found address: ${address}"
      def geoResult = geocodeService.geocode(address)

      site.lng = geoResult.Placemark[0].Point.coordinates[0]
      site.lat = geoResult.Placemark[0].Point.coordinates[1]

    }
    writer.println "Returning good address: ${site.address}, ${site.city} ${site.state}"
    return true
  }

  def addSitePhone(cshift, site, writer) {
    def ret = getSitePhones(cshift.location.webUrl, cshift.userName, cshift.pin, site.sourceId)

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
        writer.println "Updated site ${site.title } phone ${site.phone}"
      }
    }
  }

  def addSiteHours(cshift, site) {
    def ret = getSiteHours(cshift.location.webUrl, cshift.userName, cshift.pin, site.sourceId)
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
    def ret = getSiteFeatures(cshift.location.webUrl, cshift.userName, cshift.pin, site.sourceId)
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

  def updateUnits(site, stats, writer) {
    site.units.each {unit ->
      unit.delete()
    }
    site.units.clear()
    site.save()
    def centerShift = (CenterShift)site.feed
    unitsAvailable(centerShift, site, stats, writer)
    if (site.units.size() > 0) {
      def unit = site.units.asList().get(0)

      URL endPoint = new URL(centerShift.location.kioskUrl)
      CsKiosk service = new CsKioskLocator();

      CsKioskSoapPort_PortType port = service.getcsKioskSoapPort(endPoint)

      writer.println "checkRented (${centerShift.userName}, ${centerShift.pin}, ${site.sourceId as Long}, ${unit.unitName as Long}, ${unit.displaySize})"

      def unitInfo = port.getAvailableUnits(centerShift.userName, centerShift.pin, site.sourceId as Long, unit.unitName as Long, unit.displaySize)

      if ((unitInfo instanceof Integer || unitInfo instanceof String) && (unitInfo as Integer) < 0) {
        writer.println "Return for getAvailableUnits < 0 : ${unitInfo}"
        return false
      }

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

      def feedUnitId = unitId[0] as Long
      def feedUnitNumber = unitNumber[0]

      def moveInDetails = getCostDetails(centerShift.userName, centerShift.pin, site.sourceId, centerShift.location.kioskUrl, feedUnitId, "-1", writer)

      def depositLine = moveInDetails.items.find{ it.description =~ /(?i).*deposit.*/ }
      if (depositLine) {
        site.deposit = depositLine.amount
        writer.println "Found deposit ${site.deposit}"
      }
    }
    site.save(flush: true)
  }

  def unitsAvailable(cshift, site, stats, writer) {
    def ret = getSiteUnits(cshift.location.webUrl, cshift.userName, cshift.pin, site.sourceId)
    def records = ret.declareNamespace(
            soap: 'http://schemas.xmlsoap.org/soap/envelope/',
            xsi: 'http://www.w3.org/2001/XMLSchema-instance',
            xsd: 'http://www.w3.org/2001/XMLSchema',
            msdata: 'urn:schemas-microsoft-com:xml-msdata',
            diffgr: 'urn:schemas-microsoft-com:xml-diffgram-v1'
    )
    for (unit in records.'soap:Body'.'*:GetSiteUnitDataResponse'.'*:GetSiteUnitDataResult'.'*:SiteUnitData'.'*:Unit') {

      def vacant = unit.VACANT.text() as Integer
      def typeName = unit.VALUE.text()

      if (vacant > 0) {
        def dimensions = unit.DIMENSIONS.text()
        def m = dimensions =~ /(\d+\.*\d*)\s*X\s*(\d+\.*\d*)/
        if (m.matches()) {
          // legal dimensions
          def width = m[0][1] as Double
          def length = m[0][2] as Double
          def unitSize = unitSizeService.getUnitSize(width, length)
          if (unitSize) {
            def siteUnit = new StorageUnit()

            def unitTypeLookup = UnitTypeLookup.findByDescription(typeName)
            if (unitTypeLookup) {
              if (unitTypeLookup.unitType != UnitType.UNDEFINED) {
                siteUnit.unitType = unitTypeLookup.unitType
                siteUnit.isTempControlled = unitTypeLookup.tempControlled
              } else {
                writer.println "Skipping illegal type ${typeName}"
                continue
              }
            } else {
              writer.println "Unknown unit type description ${typeName}"

              if (typeName ==~ /(?i).*(parking|cell|mail|slip|apartment|office|container|portable|wine|locker|rv).*/) continue

              if ((typeName ==~ /(?i).*\s+up\s+.*/ && !(typeName ==~ /(?i).*drive.*/)) || typeName ==~ /(?i).*(2nd|3rd|second|third).*/) {
                siteUnit.unitType = UnitType.UPPER
              } else if (typeName ==~ /(?i).*(drive|roll-up|roll up).*/) {
                siteUnit.unitType = UnitType.DRIVEUP
              } else if (!(typeName ==~ /(?i).*outer.*/) || (typeName ==~ /(?i).*(interior|ground|1st).*/)) {
                siteUnit.unitType = UnitType.INTERIOR
              }
              if (!siteUnit.unitType) {
                siteUnit.unitType = UnitType.UPPER
              }
              siteUnit.isTempControlled = (typeName ==~ /(?i).*climate\s+.*/ && !(typeName ==~ /(?i).*non-climate\s+.*/))
            }
            siteUnit.unitsize = unitSize
            siteUnit.unitCount = vacant
            siteUnit.description = typeName
            siteUnit.unitName = siteUnit.unitNumber = unit.ATTRIBUTES.text()
            siteUnit.pushRate = siteUnit.price = unit.STREET_RATE.text() as BigDecimal
            siteUnit.taxRate = unit.TAX_RATE.text() as BigDecimal
            siteUnit.isAlarm = false
            siteUnit.isIrregular = false
            siteUnit.isPowered = false
            siteUnit.isAvailable = true
            siteUnit.isSecure = false
            siteUnit.displaySize = dimensions
            stats.unitCount += vacant

            site.addToUnits(siteUnit)

          } else {
            writer.println "Skipping due to size: length = ${length}, width = ${width}"
          }
        }
      } else if (vacant == 0) {
        writer.println "Skipped due to full occupancy: ${typeName}"
      } else {
        writer.println "Skipped due to parking or other: ${typeName}"
      }
    }
  }

  def loadPromos(cshift, site, writer) {
    def ret = getPromos(cshift.location.webUrl, cshift.userName, cshift.pin, site.sourceId)
    def records = ret.declareNamespace(
            soap: 'http://schemas.xmlsoap.org/soap/envelope/',
            xsi: 'http://www.w3.org/2001/XMLSchema-instance',
            xsd: 'http://www.w3.org/2001/XMLSchema',
            msdata: 'urn:schemas-microsoft-com:xml-msdata',
            diffgr: 'urn:schemas-microsoft-com:xml-diffgram-v1'
    )
    def concessionIds = []
    
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

        def concessionId = promo.'promo-id'.text() as Integer
        concessionIds.add(concessionId)
        SpecialOffer specialOffer = site.specialOffers.find{ it.concessionId == concessionId }
        boolean newOffer = false
        if (!specialOffer)  {
          specialOffer = new SpecialOffer()
          specialOffer.concessionId = concessionId
          specialOffer.active = true;
          specialOffer.featured = false;
          specialOffer.waiveAdmin = false;
          specialOffer.description = promo.sDescription.text()
          specialOffer.concessionId = concessionId
          specialOffer.promoName = promo.'promo-name'.text()
          newOffer = true
        }
        specialOffer.promoSize = promoSize
        specialOffer.prepay = (promo.'discount-periods'.text() as Integer) > 0
        specialOffer.expireMonth = specialOffer.prepay ? promo.'discount-periods'.text() as Integer : 0
        specialOffer.prepayMonths = specialOffer.prepay ? (promo.'prepay-periods'.text() as Integer) : 1
        specialOffer.description = description
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
            writer.println "Unknown promoType: ${ptype}"
            return
        }
        specialOffer.save()
        if (newOffer) {
          site.addToSpecialOffers(specialOffer)
        }
      }

    }
    def deleteList = []
    for (promo in site.specialOffers) {
      if (!concessionIds.contains(promo.concessionId)) {
        deleteList.add(promo)
      }
    }
    for (promo in deleteList) {
      writer.println "Removing stale concession: ${site.title} - ${promo.concessionId} ${promo.promoName} - ${promo.description}"
      site.removeFromSpecialOffers(promo)
    }

  }

  def loadInsurance(cshift, site) {

    URL endPoint = new URL(cshift.location.kioskUrl)

    CsKiosk service = new CsKioskLocator();

    CsKioskSoapPort_PortType port = service.getcsKioskSoapPort(endPoint)
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
    def cshift = (CenterShift)rentalTransaction.site.feed

    if (!unit) return false

    // get the number of reservation days
    def ret = getReservationUnitData(cshift.location.webUrl, cshift.userName, cshift.pin, rentalTransaction.site.sourceId, unit.displaySize, unit.unitName)

    println "Reservation data: ${ret as String}"
    
    def records = ret.declareNamespace(
            soap: 'http://schemas.xmlsoap.org/soap/envelope/',
            xsi: 'http://www.w3.org/2001/XMLSchema-instance',
            xsd: 'http://www.w3.org/2001/XMLSchema',
            msdata: 'urn:schemas-microsoft-com:xml-msdata',
            diffgr: 'urn:schemas-microsoft-com:xml-diffgram-v1'
    )
    def found = false
    for(resData in records.'soap:Body'.'*:GetReservationUnitDataResponse'.'*:GetReservationUnitDataResult'.'*:ReservationUnitData'.'*:UnitData') {
      rentalTransaction.reservationPeriod = resData.Reservation_Days.text() as Integer
      rentalTransaction.reservationCost = resData.Reservation_Cost.text() as BigDecimal
      found = true
    }
    if (!found) {
      def errCode
      for(resData in records.'soap:Body'.'*:GetReservationUnitDataResponse'.'*:GetReservationUnitDataResult'.'*:ReservationUnitData'.'*:Error')  {
        errCode = resData.ErrorCode.text() as Integer
      }
      if (errCode == 100) {
        rentalTransaction.site.removeFromUnits(unit)
      }
      return false
    }

    URL endPoint = new URL(cshift.location.kioskUrl)

    CsKiosk service = new CsKioskLocator();

    CsKioskSoapPort_PortType port = service.getcsKioskSoapPort(endPoint)

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


    def records = ret.declareNamespace(
            soap: 'http://schemas.xmlsoap.org/soap/envelope/',
            xsi: 'http://www.w3.org/2001/XMLSchema-instance',
            xsd: 'http://www.w3.org/2001/XMLSchema',
            msdata: 'urn:schemas-microsoft-com:xml-msdata',
            diffgr: 'urn:schemas-microsoft-com:xml-diffgram-v1'
    )
    for(acct in records.'soap:Body'.'*:CreateNewAccount2Response'.'*:CreateNewAccount2Result'.'*:CreateNewAccount'.'*:Account') {

      rentalTransaction.tenantId = acct.ACCOUNT_ID.text()
      rentalTransaction.contactId = acct.CONTACT_ID.text()
    }
    // memo as a new Storitz tenant
    def centerShift = (CenterShift)rentalTransaction.site.feed
    if (rentalTransaction.tenantId) {
      insertAccountNote(centerShift.location.webUrl,
              centerShift.userName,
              centerShift.pin,
              rentalTransaction.site.sourceId,
              "Storitz tenant")
    }
    rentalTransaction.save(flush:true)
  }

  def moveInDetail(RentalTransaction rentalTransaction, writer) {

    if (!checkRented(rentalTransaction)) {
      return null
    }

    def cshift = (CenterShift)rentalTransaction.site.feed

    def insId = -1
    if (rentalTransaction.insuranceId > 0) {
      def ins = Insurance.get(rentalTransaction.insuranceId)
      insId = ins.insuranceId
    }

    def moveInDetails = getCostDetails(cshift.userName, cshift.pin, rentalTransaction.site.sourceId as Long, cshift.location.kioskUrl, rentalTransaction.feedUnitId, insId as String, writer)
    rentalTransaction.paymentString = moveInDetails.paymentString

    return moveInDetails
  }

  def getCostDetails(userName, pin, sourceId, url, unitId, insId, writer) {
    URL endPoint = new URL(url)
    CsKiosk service = new CsKioskLocator();

    CsKioskSoapPort_PortType port = service.getcsKioskSoapPort(endPoint)

    writer.println "getMoveInCost params: ${userName}, ${pin}, ${sourceId as Long}, ${unitId}, ${insId as String}"

    def ret = port.getMoveInCost(userName, pin, sourceId as Long, unitId as String, insId as String)

    if ((ret instanceof Integer || ret instanceof String) && (ret as Integer) < 0) {
      writer.println "Return for getMoveInCost < 0 : ${ret}"
      return null
    }

    def desc = ret[0]
    def price = ret[1]
    def tax = ret[2]
    def subtotal = ret[3]
    def start = ret[4]
    def end = ret[5]

    def itemLength = end.size() - 1

    def moveInDetails = new MoveInDetails()
    moveInDetails.paymentString = (end[itemLength] as String)

    for(i in 0..itemLength - 1) {
      try {
        moveInDetails.items.add(new LineItem(description:desc[i], tax:(tax[i] ? tax[i] : 0) as BigDecimal, amount: (price[i] ? price[i] : 0) as BigDecimal))
      } catch (NumberFormatException nfe) {
        writer.println "Bad format for tax: ${tax[i]} or price: ${price[i]}"
      }
    }

    return moveInDetails
  }

  def reserve(RentalTransaction rentalTransaction) {
    def ret = makeReservation(rentalTransaction)

    println "MakeReservation return ${ret}"
    
    def records = ret.declareNamespace(
            soap: 'http://schemas.xmlsoap.org/soap/envelope/',
            xsi: 'http://www.w3.org/2001/XMLSchema-instance',
            xsd: 'http://www.w3.org/2001/XMLSchema',
            msdata: 'urn:schemas-microsoft-com:xml-msdata',
            diffgr: 'urn:schemas-microsoft-com:xml-diffgram-v1'
    )
    def errorCode = -1
    def message
    for(res in records.'soap:Body'.'*:MakeReservationNonCCPaymentResponse'.'*:MakeReservationNonCCPaymentResult'.'*:MakeReservationNonCCPayment'.'*:Completed') {
      errorCode = res.ErrorCode.text() as Integer
      message = res.Message.text()
    }
    if (!message) {
      for(res in records.'soap:Body'.'*:MakeReservationNonCCPaymentResponse'.'*:MakeReservationNonCCPaymentResult'.'*:MakeReservationNonCCPayment'.'*:Error') {
        errorCode = res.ErrorCode.text() as Integer
        message = res.Message.text()
      }
    }
    rentalTransaction.reserved = true

    println "errorCode = ${errorCode} and message = ${message}"
    // parse the message to get the reservation ID - Reservation Payment Successful. RentalID: 6225002, UnitID: 2528340
    def m = message =~ /.+RentalID:\s+(\d+),.+/
    if (m.matches()) {
      rentalTransaction.reservationId = m[0][1]
      rentalTransaction.idNumber = "R${rentalTransaction.reservationId}"
    }
    println "Reservation ID = ${rentalTransaction.reservationId}"
    rentalTransaction.save()

    return errorCode == 0

  }

  def moveIn(RentalTransaction rentalTransaction, PrintWriter writer) {
    def cshift = (CenterShift)rentalTransaction.site.feed

    def insId = -1
    if (rentalTransaction.insuranceId > 0) {
      def ins = Insurance.get(rentalTransaction.insuranceId)
      insId = ins.insuranceId
    }

    def moveInDetails = getCostDetails(cshift.userName, cshift.pin, rentalTransaction.site.sourceId as Long, cshift.location.kioskUrl, rentalTransaction.feedUnitId, insId as String, writer)
    rentalTransaction.paymentString = moveInDetails.paymentString

    URL endPoint = new URL(cshift.location.kioskUrl)
    CsKiosk service = new CsKioskLocator();

    CsKioskSoapPort_PortType port = service.getcsKioskSoapPort(endPoint)
    writer.println "doMoveIn params: ${cshift.userName}, ${cshift.pin}, ${rentalTransaction.site.sourceId as Long}, ${rentalTransaction.tenantId as Long}, ${rentalTransaction.feedUnitId}, ${insId as String},  ${rentalTransaction.paymentString}, \"Storitz  \", \"0123456789\", \"Storitz Acct.\", \"10\", \"\", \"K\" "
    // Use ACH to allow Centershift to report transactions
    def ret = port.doMoveIn(cshift.userName, cshift.pin, rentalTransaction.site.sourceId as Long, rentalTransaction.tenantId as Long, rentalTransaction.feedUnitId, insId as String,
            rentalTransaction.paymentString, "Storitz  ", "0123456789", "Storitz Acct.", "10", "00000", "K")

    if ((ret instanceof Integer || ret instanceof String) && (ret as Integer) < 0) {
      writer.println "Return for doMoveIn < 0 : ${ret}"
      return false
    }

    writer.println "Return from doMoveIn: ${ret}"

    rentalTransaction.idNumber = ret
    rentalTransaction.save(flush: true)

    return true

  }

  def calculateMoveInCost(StorageSite site, StorageUnit unit, SpecialOffer promo, Insurance ins, Date moveInDate, boolean extended) {
    def ret = calculateTotals(site, unit, promo, ins, moveInDate, extended)
    return ret["moveInTotal"]
  }

  def calculatePaidThruDate(StorageSite site, SpecialOffer promo, Date moveInDate, boolean allowExtension) {
    BigDecimal durationMonths = promo ? [promo.prepayMonths, promo.expireMonth].max() : 1;

    def cal = new GregorianCalendar()
    cal.setTime(moveInDate)
    def lastDayInMonth = cal.getActualMaximum(Calendar.DAY_OF_MONTH)
    def moveInDay = cal.get(Calendar.DAY_OF_MONTH)

    if (site.useProrating) {
      if (allowExtension) {
        if (moveInDay > 15) {
          durationMonths++;
          ret["extended"] = true;
        } else {
          ret["extended"] = false;
        }
      }
      if (durationMonths - 1 > 0) {
        cal.add(Calendar.MONTH, ((durationMonths - 1) as Integer))
      }
    } else {
      cal.add(Calendar.MONTH, (durationMonths as Integer))
    }

    if (site.useProrating) {
      cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH))
    }
    return cal.time
  }

  def calculateTotals(StorageSite site, StorageUnit unit, SpecialOffer promo, Insurance ins, Date moveInDate) {
    calculateTotals(site, unit, promo, ins, moveInDate, true)
  }

  def calculateTotals(StorageSite site, StorageUnit unit, SpecialOffer promo, Insurance ins, Date moveInDate, boolean allowExtension) {

    def ret = [:]
    BigDecimal durationMonths = promo ? (promo.prepay ? promo.expireMonth : promo.prepayMonths) : 1
    BigDecimal promoMonths = promo ? (promo.prepay ? (promo.expireMonth >= durationMonths ? durationMonths : promo.expireMonth) : promo.prepayMonths) : 0
    def offerDiscount = 0
    def rate = unit ? unit.pushRate : 0
    def premium = ins ? ins.premium : 0
    def additionalFees = site.adminFee ? site.adminFee : site.lockFee ? site.lockFee : 0
    def adminFee = site.adminFee ? site.adminFee : 0
    def waiveAdmin = false
    def deposit = site.deposit ? site.deposit : 0


    if (promo) {

      waiveAdmin = promo.waiveAdmin

      switch (promo.promoType) {
        case "AMOUNT_OFF":
          offerDiscount = promo.promoQty;
          break;

        case "PERCENT_OFF":
          offerDiscount = (promo.promoQty/100.0) * promoMonths * unit.price;
          break;

        case "FIXED_RATE":
          offerDiscount = ((rate - promo.promoQty) > 0 ? (rate - promo.promoQty): 0) * promoMonths;
          break;
      }
    }

    def cal = new GregorianCalendar()
    cal.setTime(moveInDate)
    def lastDayInMonth = cal.getActualMaximum(Calendar.DAY_OF_MONTH)
    def moveInDay = cal.get(Calendar.DAY_OF_MONTH)

    if (site.useProrating) {
      if (allowExtension) {
        if (moveInDay > 15) {
          durationMonths++;
          ret["extended"] = true;
        } else {
          ret["extended"] = false;
        }
      }
      if (durationMonths - 1 > 0) {
        cal.add(Calendar.MONTH, ((durationMonths - 1) as Integer))
      }
    } else {
      cal.add(Calendar.MONTH, (durationMonths as Integer))
    }

    if (site.useProrating) {
      cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH))

      durationMonths -= (1 - ((lastDayInMonth - moveInDay) + 1)/lastDayInMonth)
    }


    def feesTotal = (waiveAdmin ? additionalFees - adminFee : additionalFees)
    def subTotal = (rate*durationMonths).setScale(2, RoundingMode.HALF_UP) + (premium*durationMonths).setScale(2, RoundingMode.HALF_UP)
    // TODO handle AZ insurance tax
    def tax = 0 //((premium * durationMonths) * (unit.taxRate)).setScale(2, RoundingMode.HALF_UP)

    def moveInTotal = feesTotal + subTotal + deposit + tax - offerDiscount;

    ret["durationMonths"] = durationMonths
    ret["discountTotal"] = offerDiscount
    ret["feesTotal"] = feesTotal
    ret["tax"] = tax
    ret["moveInTotal"] = moveInTotal
    ret["deposit"] = deposit
    ret["paidThruDate"] = cal.time.format('MM/dd/yy')

    return ret
  }
}

