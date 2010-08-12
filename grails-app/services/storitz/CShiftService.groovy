package storitz

import groovyx.net.http.HTTPBuilder
import groovyx.net.http.Method
import static groovyx.net.http.ContentType.XML
import com.storitz.StorageSite
import com.storitz.SiteUser
import storitz.constants.State
import storitz.constants.TruckType
import com.storitz.SiteContact
import com.storitz.StorageUnit

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

      if (!addSiteAddress(cshift, site)) {
        "Got a bad address, skipping site creation"
        return
      }
    
      addSiteHours(cshift, site)
      addSiteFeatures(cshift, site)

      site.extendedHours = false

      site.siteLink = null
      site.centerShift = cshift

      site.save()
      if (newSite) {
        SiteUser.link(site, cshift.manager)
      }

      unitsAvailable(cshift, site, stats)

//      site.requiresInsurance = insurance(siteLink, site)
      loadPromos(cshift, site)
      site.save(flush: true)
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

      def email = addr.EMAIL.text()
      if (email.size() > 0) {
        def contact = new SiteContact(email: email, name: site.title)
        site.addToContacts(contact)
      }
    }
    println "Returning good address: ${site.address}, ${site.city} ${site.state}"
    return true
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

      // HH:MM a - HH:MM a

      switch(day) {
        case "Mon":
          def office = hours.OFFICE.text()
          if (office == 'Closed' || office.size() < 10) {
            site.openWeekday = false
          } else {
            site.openWeekday = true
            def m = office =~ /(?i)(\d+:\d+\s*[ap]\.*m\.*).+(\d+:\d+\s*[ap]\.*m\.*)/
            if (m.matches()) {
              site.startWeekday = Date.parse("HH:mma", m[0][1].replaceAll(/\./, "").replaceAll(" ", ""))
              site.endWeekday = Date.parse("HH:mma", m[0][2].replaceAll(/\./, "").replaceAll(" ", ""))
            } else {
              println "Hours do not match: ${office}"
            }
          }
          def gate = hours.GATE.text()
          if (gate.size() > 10) {
            def n = gate =~ /(?i)(\d+:\d+\s*[ap]\.*m\.*).+(\d+:\d+\s*[ap]\.*m\.*)/
            if (n.matches()) {
              site.startGate = Date.parse("HH:mma", n[0][1].replaceAll(/\./, "").replaceAll(" ", ""))
              site.endGate = Date.parse("HH:mma", n[0][2].replaceAll(/\./, "").replaceAll(" ", ""))
            } else {
              println "Gate does not match: ${gate}"
            }
          }
          break

        case "Sat":
          def office = hours.OFFICE.text()
          if (office == 'Closed' || office.size() < 10) {
            site.openSaturday = false
          } else {
            site.openSaturday = true
            def m = office =~ /(?i)(\d+:\d+\s*[ap]\.*m\.*).+(\d+:\d+\s*[ap]\.*m\.*)/
            if (m.matches()) {
              site.startSaturday = Date.parse("HH:mma", m[0][1].replaceAll(/\./, "").replaceAll(" ", ""))
              site.endSaturday = Date.parse("HH:mma", m[0][2].replaceAll(/\./, "").replaceAll(" ", ""))
            } else {
              println "Office does not match: ${office}"
            }
          }
          break

        case "Sun":
          def office = hours.OFFICE.text()
          if (office == 'Closed' || office.size() < 10) {
            site.openSunday = false
          } else {
            site.openSunday = true
            def m = office =~ /(?i)(\d+:\d+\s*[ap]\.*m\.*).+(\d+:\d+\s*[ap]\.*m\.*)/
            if (m.matches()) {
              site.startSunday = Date.parse("HH:mma", m[0][1].replaceAll(/\./, "").replaceAll(" ", ""))
              site.endSunday = Date.parse("HH:mma", m[0][2].replaceAll(/\./, "").replaceAll(" ", ""))
            } else {
              println "Office does not match: ${office}"
            }
          }
          def gate = hours.GATE.text()
          if (gate.size() > 10) {
            def n = gate =~ /(?i)(\d+:\d+\s*[ap]\.*m\.*).+(\d+:\d+\s*[ap]\.*m\.*)/
            if (n.matches()) {
              site.startSundayGate = Date.parse("HH:mma", n[0][1].replaceAll(/\./, "").replaceAll(" ", ""))
              site.endSundayGate = Date.parse("HH:mma", n[0][2].replaceAll(/\./, "").replaceAll(" ", ""))
            } else {
              println "Gate does not match: ${gate}"
            }
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
    unitsAvailable(site.centerShift, site, stats, false)
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
      if (vacant > 0 && !(typeName ==~ /(?i).*(parking|cell|mailbox|slip|apartment).*/)) {
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

            // outside = driveup
            // down = interior
            siteUnit.isUpper = (typeName ==~ /(?i).*\s+up\s+.*/ || typeName ==~ /(?i).*2nd.*/)
            siteUnit.isDriveup = (typeName ==~ /(?i).*drive.*/)
            siteUnit.isInterior = (!siteUnit.isUpper && !siteUnit.isDriveup && !(typeName ==~ /(?i).*outer.*/))
            if (!siteUnit.isUpper && !siteUnit.isInterior && !siteUnit.isDriveup) {
              siteUnit.isUpper = true
            }
            siteUnit.isAlarm = false
            siteUnit.isTempControlled = (typeName ==~ /(?i).*climate\s+.*/ && !(typeName ==~ /(?i).*non-climate\s+.*/))
            siteUnit.isPowered = false
            siteUnit.isAvailable = true
            siteUnit.isSecure = false
            siteUnit.displaySize = width + " X " + length
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
    }
  }
}

