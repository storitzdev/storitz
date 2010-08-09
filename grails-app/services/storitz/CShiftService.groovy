package storitz

import groovyx.net.http.HTTPBuilder
import groovyx.net.http.Method
import static groovyx.net.http.ContentType.XML
import com.storitz.StorageSite
import com.storitz.SiteUser
import storitz.constants.State
import storitz.constants.TruckType

class CShiftService {

  def geocodeService

  boolean transactional = false

  def centerShiftWsUrl3 = "https://host05slc.centershift.com/DoD_CallCenter/csCallCenterService.asmx"

  def getSites(userName, pin) {
    def payload = """<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:csc="http://centershift.com/csCallCenter/csCallCenterService">
   <soapenv:Header/>
   <soapenv:Body>
      <csc:GetSiteList>
         <!--Optional:-->
         <csc:strUser>""" + userName + """</csc:strUser>
         <!--Optional:-->
         <csc:strPin>""" + pin + """</csc:strPin>
      </csc:GetSiteList>
   </soapenv:Body>
</soapenv:Envelope>"""

    postAction(paylaod, 'GetSiteList')
  }

  def getSiteAddress(userName, pin, siteId) {
    def payload = """<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:csc="http://centershift.com/csCallCenter/csCallCenterService">
   <soapenv:Header/>
   <soapenv:Body>
      <csc:GetSiteAddress>
         <!--Optional:-->
         <csc:strUser>""" + userName + """</csc:strUser>
         <!--Optional:-->
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
         <!--Optional:-->
         <csc:strUser>""" + userName + """</csc:strUser>
         <!--Optional:-->
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
         <!--Optional:-->
         <csc:strUser>""" + userName + """</csc:strUser>
         <!--Optional:-->
         <csc:strPin>""" + pin + """</csc:strPin>
         <csc:lngSiteID>""" + siteId + """</csc:lngSiteID>
      </csc:GetSiteFeatures>
   </soapenv:Body>
</soapenv:Envelope>"""

    postAction(payload, 'GetSiteFeatures')
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
          site.contacts.each {contact ->
            contact.delete()
          }
          site.contacts.clear()
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

  def getSiteDetails(cshift, site, tab, stats, newSite) {

      site.sourceId = tab.SITE_ID.text()
      site.sourceLoc = tab.SITE_NUMBER.text()
      site.source = "CS3"
      site.title = tab.SITE_NAME.text()

      addSiteAddress(cshift, site)
      addSiteHours(cshift, site)
      addSiteFeatures(cshift, site)

      site.extendedHours = false

      site.siteLink = null
      site.centerShift = cshift

//      def contact = new SiteContact(email: tab.sEmailAddress.text(), name: tab.sContactName.text())
//      site.addToContacts(contact)

      site.save()
      if (newSite) {
        SiteUser.link(site, cshift.manager)
      }

//      unitsAvailable(siteLink, site, stats)

      site.requiresInsurance = insurance(siteLink, site)
      if (site.units.size() > 0) {
        site.adminFee = adminFees(siteLink, site.units.asList().get(0).unitNumber, site)
      }
//      getPromos(siteLink, site)
      site.save(flush: true)
  }


  def addSiteAddress(cshift, site) {
    def ret = getSiteAddress(cshift.userName, cshift.pin, site.sourceId)
    def records = ret.declareNamespace(
            soap: 'http://schemas.xmlsoap.org/soap/envelope/',
            xsi: 'http://www.w3.org/2001/XMLSchema-instance',
            xsd: 'http://www.w3.org/2001/XMLSchema',
            msdata: 'urn:schemas-microsoft-com:xml-msdata',
            diffgr: 'urn:schemas-microsoft-com:xml-diffgram-v1'
    )


    records.'soap:Body'.'*:GetSiteAddressResponse'.'*:GetSiteAddressResult'.'*:SiteAddress'.'*:Address'.each {addr ->
      // TODO - check on ADDRESS_TYPE later
      site.address = addr.STREET.text()
      site.address2 = ''
      site.city = addr.CITY.text()
      site.state= State.fromText(addr.STATE.text())
      site.zipcode = addr.POSTAL_CODE.text()

      def address = addr.STREET.text() + ' ' + ', ' + addr.CITY.text() + ', ' + addr.STATE.text() + ' ' + addr.POSTAL_CODE.text()

      print "Found address: ${address}"
      def geoResult = geocodeService.geocode(address)

      site.lng = geoResult.Placemark[0].Point.coordinates[0]
      site.lat = geoResult.Placemark[0].Point.coordinates[1]

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


    records.'soap:Body'.'*:GetSiteHoursResponse'.'*:GetSiteHoursResult'.'*:SiteHours'.'*:Hours'.each {hours ->
      def day = hours.WEEKDAY.text()

      // HH:MM a - HH:MM a

      switch(day) {
        case "Mon":
          def office = hours.OFFICE.text()
          if (office == 'Closed') {
            site.openWeekday = false
          } else {
            site.openWeekday = true
            def m = office =~ /(\d+:\d+ ?m) - (\d+:\d+ ?m)/
            site.startWeekday = Date.parse("HH:mm a", m[0][1])
            site.endWeekday = Date.parse("HH:mm a", m[0][2])
          }
          def gate = hours.GATE.text()
          def n = gate =~ /(\d+:\d+ ?m) to (\d+:\d+ ?m)/
          site.startGate = Date.parse("HH:mm a", n[0][1])
          site.endGate = Date.parse("HH:mm a", n[0][2])
          break

        case "Sat":
          def office = hours.OFFICE.text()
          if (office == 'Closed') {
            site.openSaturday = false
          } else {
            site.openSaturday = true
            def m = office =~ /(\d+:\d+ ?m) - (\d+:\d+ ?m)/
            site.startSaturday = Date.parse("HH:mm a", m[0][1])
            site.endSaturday = Date.parse("HH:mm a", m[0][2])
          }
          break

        case "Sun":
          def office = hours.OFFICE.text()
          if (office == 'Closed') {
            site.openSunday = false
          } else {
            site.openSunday = true
            def m = office =~ /(\d+:\d+ ?m) - (\d+:\d+ ?m)/
            site.startSunday = Date.parse("HH:mm a", m[0][1])
            site.endSunday = Date.parse("HH:mm a", m[0][2])
          }
          def gate = hours.GATE.text()
          def n = gate =~ /(\d+:\d+ ?m) to (\d+:\d+ ?m)/
          site.startSundayGate = Date.parse("HH:mm a", n[0][1])
          site.endSundayGate = Date.parse("HH:mm a", n[0][2])
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


    records.'soap:Body'.'*:GetSiteFeaturesResponse'.'*:GetSiteFeaturesResult'.'*:SiteFeatures'.'*:Features'.each {features ->
      site.isManagerOnsite = features.ON_SITE_MANAGER.text() == 'Y'
      site.isGate = features.ELEC_GATE_ACCESS.text() == 'Y'
      site.isKeypad = features.ELEC_GATE_ACCESS.text() == 'Y'
      site.isCamera = features.VIDEO_SURVEILLANCE.text() == 'Y'
      site.isUnitAlarmed = features.ALARMED_UNITS.text() == 'Y'
      site.hasElevator = false
      site.requiresInsurance = false
      site.boxesAvailable = true
      site.freeTruck = TruckType.NONE
    }
  }
}

