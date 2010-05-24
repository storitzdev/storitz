import org.apache.commons.httpclient.*;
import org.apache.commons.httpclient.methods.*;

import groovyx.net.http.HTTPBuilder
import groovyx.net.http.Method
import static groovyx.net.http.ContentType.XML

import storagetech.constants.TruckType
import storagetech.constants.PromoType

class SiteLinkService {

  def siteLinkWsUrl = "https://www.smdservers.net/ccws/callcenterws.asmx"

  static MSDateEpoch = new Date().parse('yyyy/MM/dd', '1900/01/01') 

  boolean transactional = false

  def getSites(corpCode, userName, password) {

    def payload = """<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:cal="http://tempuri.org/CallCenterWs/CallCenterWs">
   <soapenv:Header/>
   <soapenv:Body>
      <cal:SiteSearchByPostalCode>
         <!--Optional:-->
         <cal:sCorpCode>""" + corpCode + """</cal:sCorpCode>
         <!--Optional:-->
         <cal:sCorpUserName>""" + userName + """</cal:sCorpUserName>
         <!--Optional:-->
         <cal:sCorpPassword>""" + password + """</cal:sCorpPassword>
         <!--Optional:-->
         <cal:sPostalCode></cal:sPostalCode>
         <cal:iCountry>0</cal:iCountry>
         <cal:bMiles>true</cal:bMiles>
      </cal:SiteSearchByPostalCode>
   </soapenv:Body>
</soapenv:Envelope>"""

    postAction(payload, 'SiteSearchByPostalCode')

  }

  def getSiteInfo(corpCode, locationCode, userName, password) {

    def payload = """<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:cal="http://tempuri.org/CallCenterWs/CallCenterWs">
   <soapenv:Header/>
   <soapenv:Body>
      <cal:SiteInformation>
         <!--Optional:-->
         <cal:sCorpCode>""" + corpCode + """</cal:sCorpCode>
         <!--Optional:-->
         <cal:sLocationCode>""" + locationCode + """</cal:sLocationCode>
         <!--Optional:-->
         <cal:sCorpUserName>""" + userName + """</cal:sCorpUserName>
         <!--Optional:-->
         <cal:sCorpPassword>""" + password + """</cal:sCorpPassword>
      </cal:SiteInformation>
   </soapenv:Body>
</soapenv:Envelope>"""

    postAction(payload, 'SiteInformation')
  }

  def getUnitsAvailable(corpCode, locationCode, userName, password, lastTimePolled) {

    def payload = """<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:cal="http://tempuri.org/CallCenterWs/CallCenterWs">
   <soapenv:Header/>
   <soapenv:Body>
      <cal:UnitsInformationAvailableUnitsOnly_v2>
         <!--Optional:-->
         <cal:sCorpCode>""" + corpCode + """</cal:sCorpCode>
         <!--Optional:-->
         <cal:sLocationCode>""" + locationCode + """</cal:sLocationCode>
         <!--Optional:-->
         <cal:sCorpUserName>""" + userName + """</cal:sCorpUserName>
         <!--Optional:-->
         <cal:sCorpPassword>""" + password + """</cal:sCorpPassword>
         <cal:lngLastTimePolled>""" + lastTimePolled + """</cal:lngLastTimePolled>
      </cal:UnitsInformationAvailableUnitsOnly_v2>
   </soapenv:Body>
</soapenv:Envelope>"""

    postAction(payload, 'UnitsInformationAvailableUnitsOnly_v2')

  }

  def getUnits(corpCode, locationCode, userName, password, lastTimePolled) {

    def payload = """<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:cal="http://tempuri.org/CallCenterWs/CallCenterWs">
   <soapenv:Header/>
   <soapenv:Body>
      <cal:UnitsInformation_v2>
         <!--Optional:-->
         <cal:sCorpCode>""" + corpCode + """</cal:sCorpCode>
         <!--Optional:-->
         <cal:sLocationCode>""" + locationCode + """</cal:sLocationCode>
         <!--Optional:-->
         <cal:sCorpUserName>""" + userName + """</cal:sCorpUserName>
         <!--Optional:-->
         <cal:sCorpPassword>""" + password + """</cal:sCorpPassword>
         <cal:lngLastTimePolled>""" + lastTimePolled + """</cal:lngLastTimePolled>
      </cal:UnitsInformation_v2>
   </soapenv:Body>
</soapenv:Envelope>"""

    postAction(payload, 'UnitsInformation_v2')
  }

  def getInsurance(corpCode, locationCode, userName, password) {

    def payload = """<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:cal="http://tempuri.org/CallCenterWs/CallCenterWs">
   <soapenv:Header/>
   <soapenv:Body>
      <cal:InsuranceCoverageRetrieve>
         <!--Optional:-->
         <cal:sCorpCode>""" + corpCode + """</cal:sCorpCode>
         <!--Optional:-->
         <cal:sLocationCode>""" + locationCode + """</cal:sLocationCode>
         <!--Optional:-->
         <cal:sCorpUserName>""" + userName + """</cal:sCorpUserName>
         <!--Optional:-->
         <cal:sCorpPassword>""" + password + """</cal:sCorpPassword>
      </cal:InsuranceCoverageRetrieve>
   </soapenv:Body>
</soapenv:Envelope>"""

    postAction(payload, 'InsuranceCoverageRetrieve')
  }

  def getMoveinCost(corpCode, locationCode, userName, password, unitId) {

    def payload = """<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:cal="http://tempuri.org/CallCenterWs/CallCenterWs">
       <soapenv:Header/>
       <soapenv:Body>
          <cal:MoveInCostRetrieve>
             <!--Optional:-->
             <cal:sCorpCode>""" + corpCode + """</cal:sCorpCode>
             <!--Optional:-->
             <cal:sLocationCode>""" + locationCode + """</cal:sLocationCode>
             <!--Optional:-->
             <cal:sCorpUserName>""" + userName + """</cal:sCorpUserName>
             <!--Optional:-->
             <cal:sCorpPassword>""" + password + """</cal:sCorpPassword>
             <cal:iUnitID>""" + unitId + """</cal:iUnitID>
             <cal:dMoveInDate>""" + new Date().format('yyyy-MM-dd') + """T09:00:00</cal:dMoveInDate>
          </cal:MoveInCostRetrieve>
       </soapenv:Body>
    </soapenv:Envelope>"""

    postAction(payload, 'MoveInCostRetrieve')
  }

  def getPromos(corpCode, locationCode, userName, password) {

    def payload = """<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:cal="http://tempuri.org/CallCenterWs/CallCenterWs">
   <soapenv:Header/>
   <soapenv:Body>
      <cal:PromotionsRetrieve>
         <!--Optional:-->
         <cal:sCorpCode>""" + corpCode + """</cal:sCorpCode>
         <!--Optional:-->
         <cal:sLocationCode>""" + locationCode + """</cal:sLocationCode>
         <!--Optional:-->
         <cal:sCorpUserName>""" + userName + """</cal:sCorpUserName>
         <!--Optional:-->
         <cal:sCorpPassword>""" + password + """</cal:sCorpPassword>
      </cal:PromotionsRetrieve>
   </soapenv:Body>
</soapenv:Envelope>"""

    postAction(payload, 'PromotionsRetrieve')
  }

  private def postAction(payload, action) {
    def http = new HTTPBuilder(siteLinkWsUrl)

    http.handler.failure = {resp, req ->
      "Unexpected failure: ${resp.statusLine} "
    }

    def resp = http.request(Method.POST, XML) {req ->

      delegate.headers['Content-Type'] = "text/xml"

      headers.'SOAPAction' = '"http://tempuri.org/CallCenterWs/CallCenterWs/' + action + '"'

      body = payload

      response.error = {resp ->
        println "${resp.statusLine}"
      }
    }
  }

  def corpSites(siteLink, stats, geocodeService) {
    def ret = getSites(siteLink.corpCode, siteLink.userName, siteLink.password)
    def records = ret.declareNamespace(
            soap: 'http://schemas.xmlsoap.org/soap/envelope/',
            xsi: 'http://www.w3.org/2001/XMLSchema-instance',
            xsd: 'http://www.w3.org/2001/XMLSchema',
            msdata: 'urn:schemas-microsoft-com:xml-msdata',
            diffgr: 'urn:schemas-microsoft-com:xml-diffgram-v1'
    )


    records.'soap:Body'.'*:SiteSearchByPostalCodeResponse'.'*:SiteSearchByPostalCodeResult'.'*:diffgram'.NewDataSet.'*:Table'.each {tab ->
      StorageSite site = StorageSite.findBySourceAndSourceId("SL", tab.SiteID.text())
      if (site) {
        stats.updateCount++
        site.contacts.each {contact ->
          contact.delete()
        }
        site.units.each {unit ->
          unit.delete()
        }
        site.insurances.each {ins ->
          ins.delete()
        }
      } else {
        site = new StorageSite()
        stats.createCount++
        site.lastUpdate = 0
      }
      getSiteDetails(siteLink, site, tab, stats, geocodeService)
    }
  }

  def getSiteDetails(siteLink, site, tab, stats, geocodeService) {
    def address = tab.sSiteAddr1.text() + ' ' + tab.sSiteAddr2.text() + ', ' + tab.sSiteCity.text() + ', ' + tab.sSiteRegion.text() + ' ' + tab.sSitePostalCode.text()
    def geoResult = geocodeService.geocode(address)

    site.lng = geoResult.Placemark[0].Point.coordinates[0]
    site.lat = geoResult.Placemark[0].Point.coordinates[1]

    site.sourceId = tab.SiteID.text()
    site.sourceLoc = tab.sLocationCode.text()
    site.source = "SL"
    site.title = tab.sSiteName.text()
    site.address = tab.sSiteAddr1.text()
    site.address2 = tab.sSiteAddr2.text()
    site.city = tab.sSiteCity.text()
    site.state = tab.sSiteRegion.text()
    site.zipcode = tab.sSitePostalCode.text()
    site.requiresInsurance = false
    site.boxesAvailable = true
    site.freeTruck = TruckType.NONE
    site.isGate = false
    site.isKeypad = false
    site.isCamera = false
    site.isUnitAlarmed = false

    site.openWeekday = !Boolean.parseBoolean(tab.bClosedWeekdays.text())
    site.openSaturday = !Boolean.parseBoolean(tab.bClosedSaturday.text())
    site.openSunday = !Boolean.parseBoolean(tab.bClosedSunday.text())

    def sWeekdayStart = tab.dWeekdayStrt.text()
    def sWeekdayEnd = tab.dWeekdayEnd.text()
    def sSaturdayStart = tab.dSaturdayStrt.text()
    def sSaturdayEnd = tab.dSaturdayEnd.text()
    def sSundayStart = tab.dSundayStrt.text()
    def sSundayEnd = tab.dSundayEnd.text()
    site.startWeekday = sWeekdayStart.length() > 0 ? Date.parse("yyyy-MM-dd'T'HH:mm:ss.SSS", sWeekdayStart) : null
    site.endWeekday = sWeekdayEnd.length() > 0 ? Date.parse("yyyy-MM-dd'T'HH:mm:ss.SSS", sWeekdayEnd) : null
    site.startSaturday = sSaturdayStart.length() > 0 ? Date.parse("yyyy-MM-dd'T'HH:mm:ss.SSS", sSaturdayStart) : null
    site.endSaturday = sSaturdayEnd.length() > 0 ? Date.parse("yyyy-MM-dd'T'HH:mm:ss.SSS", sSaturdayEnd) : null
    site.startSunday = sSundayStart.length() > 0 ? Date.parse("yyyy-MM-dd'T'HH:mm:ss.SSS", sSundayStart) : null
    site.endSunday = sSundayEnd.length() > 0 ? Date.parse("yyyy-MM-dd'T'HH:mm:ss.SSS", sSundayEnd) : null

    site.siteLink = siteLink
    site.centerShift = null

    def contact = new SiteContact(email: tab.sEmailAddress.text(), name: tab.sContactName.text())
    site.addToContacts(contact)

    site.save()

    unitsAvailable(siteLink, site, stats)

    site.requiresInsurance = insurance(siteLink, site)
    if (site.units.size() > 0) {
      site.adminFee = adminFees(siteLink, site.units.asList().get(0).unitNumber, site)
    }
    getPromos(siteLink, site)
    site.save(flush: true)
  }

  def updateSite(site, stats, geocodeService) {
    def ret = getSiteInfo(site.siteLink.corpCode, site.sourceLoc, site.siteLink.userName, site.siteLink.password)
    def records = ret.declareNamespace(
            soap: 'http://schemas.xmlsoap.org/soap/envelope/',
            xsi: 'http://www.w3.org/2001/XMLSchema-instance',
            xsd: 'http://www.w3.org/2001/XMLSchema',
            msdata: 'urn:schemas-microsoft-com:xml-msdata',
            diffgr: 'urn:schemas-microsoft-com:xml-diffgram-v1'
    )
    records.'soap:Body'.'*:SiteInformationResponse'.'*:SiteInformationResult'.'*:diffgram'.NewDataSet.'*:Table'.each {tab ->
      site.contacts.each {contact ->
        contact.delete()
      }
      site.units.each {unit ->
        unit.delete()
      }
      site.insurances.each {ins ->
        ins.delete()
      }
      site.specialOffers.each {offer ->
        offer.delete()
      }
      site.contacts.clear()
      site.units.clear()
      site.insurances.clear()
      site.specialOffers.clear()
      site.lastUpdate = 0
      site.save(flush: true)
      getSiteDetails(site.siteLink, site, tab, stats, geocodeService)
    }

  }

  def updateUnits(site, stats) {
    site.units.each {unit ->
      unit.delete()
    }
    site.units.clear()
    site.save()
    unitsAvailable(site.siteLink, site, stats)
    site.save(flush: true)
  }

  def unitsAvailable(siteLink, site, stats) {
    println "Getting units available for site: " + site.title + " last update ticks: " + site.lastUpdate
    def ret = getUnitsAvailable(siteLink.corpCode, site.sourceLoc, siteLink.userName, siteLink.password, site.lastUpdate)
    def records = ret.declareNamespace(
            soap: 'http://schemas.xmlsoap.org/soap/envelope/',
            xsi: 'http://www.w3.org/2001/XMLSchema-instance',
            xsd: 'http://www.w3.org/2001/XMLSchema',
            msdata: 'urn:schemas-microsoft-com:xml-msdata',
            diffgr: 'urn:schemas-microsoft-com:xml-diffgram-v1'
    )
    def adminFeeSet = false;
    records.'soap:Body'.'*:UnitsInformationAvailableUnitsOnly_v2Response'.'*:UnitsInformationAvailableUnitsOnly_v2Result'.'*:diffgram'.NewDataSet.'*:Table'.each {unit ->

      def siteUnit = new StorageUnit()
      siteUnit.description = unit.sTypeName.text()
      siteUnit.unitNumber = unit.UnitID.text()
      siteUnit.price = new BigDecimal(unit.dcStdRate.text())
      def floor = Integer.parseInt(unit.iFloor.text())
      def typeName = unit.sTypeName.text()
      siteUnit.isUpper = (floor > 1 || floor == 1 && typeName ==~ /(2ND|3RD).+/)
      siteUnit.isInterior = Boolean.parseBoolean(unit.bInside.text()) || typeName ==~ /MAIN FLOOR*/
      siteUnit.isAlarm = Boolean.parseBoolean(unit.bAlarm.text())
      siteUnit.isTempControlled = Boolean.parseBoolean(unit.bClimate.text())
      siteUnit.isDriveup = ((!siteUnit.isUpper && !siteUnit.isInterior) || typeName ==~ /DRIVE UP*/)
      siteUnit.isPowered = Boolean.parseBoolean(unit.bPower.text())
      siteUnit.isAvailable = true
      siteUnit.isSecure = false
      Integer width = (int) Double.parseDouble(unit.dcWidth.text())
      Integer length = (int) Double.parseDouble(unit.dcLength.text())
      siteUnit.displaySize = width + " X " + length

      def unitSize = StorageSize.findByWidthAndLength(width, length)
      if (unitSize == null) {

        def unitArea = width * length
        def foundSize = 0
        StorageSize.findAll().each {u ->
          if (Math.abs(unitArea - foundSize) > Math.abs(unitArea - u.width * u.length)) {
            unitSize = u
            foundSize = u.width * u.length
          }
        }
      }
      if (unitSize) {
        siteUnit.unitsize = unitSize
        if (!siteUnit.save()) {
          siteUnit.errors.allErrors.each { println it }
        }
        stats.unitCount++;

        site.addToUnits(siteUnit)
      } else {
        println "Skipping unit due to size: width=" + width + " length=" + length
      }
    }
    // compute last update
    def now = new Date()
    def daySinceEpoch = now - MSDateEpoch
    def c = Calendar.instance
    c.set(Calendar.HOUR,  0)
    c.set(Calendar.MINUTE, 0)
    c.set(Calendar.SECOND, 0)
    def millisSinceMidnight = now.time - c.timeInMillis
    def ticks = ((millisSinceMidnight * 4)/3).longValue() + (daySinceEpoch.longValue() << 32).longValue()

    site.lastUpdate = ticks
  }

  def insurance(siteLink, site) {
    def ret = getInsurance(siteLink.corpCode, site.sourceLoc, siteLink.userName, siteLink.password)
    def records = ret.declareNamespace(
            soap: 'http://schemas.xmlsoap.org/soap/envelope/',
            xsi: 'http://www.w3.org/2001/XMLSchema-instance',
            xsd: 'http://www.w3.org/2001/XMLSchema',
            msdata: 'urn:schemas-microsoft-com:xml-msdata',
            diffgr: 'urn:schemas-microsoft-com:xml-diffgram-v1'
    )
    def count = 0;
    records.'soap:Body'.'*:InsuranceCoverageRetrieveResponse'.'*:InsuranceCoverageRetrieveResult'.'*:diffgram'.NewDataSet.'*:Table'.each {ins ->
      def insurance = new Insurance()
      insurance.insuranceId = Integer.parseInt(ins.InsurCoverageID.text())
      insurance.totalCoverage = new BigDecimal(ins.dcCoverage.text())
      insurance.premium = new BigDecimal(ins.dcPremium.text())
      insurance.percentTheft = new BigDecimal(ins.dcPCTheft.text())
      insurance.provider = ins.sProvidor.text()
      count++;

      if (!insurance.save()) {
        insurance.errors.allErrors.each { println it }
      }
      site.addToInsurances(insurance)
    }
    return count > 0
  }

  def adminFees(siteLink, unitId, site) {
    def ret = getMoveinCost(siteLink.corpCode, site.sourceLoc, siteLink.userName, siteLink.password, unitId)
    def records = ret.declareNamespace(
            soap: 'http://schemas.xmlsoap.org/soap/envelope/',
            xsi: 'http://www.w3.org/2001/XMLSchema-instance',
            xsd: 'http://www.w3.org/2001/XMLSchema',
            msdata: 'urn:schemas-microsoft-com:xml-msdata',
            diffgr: 'urn:schemas-microsoft-com:xml-diffgram-v1'
    )
    def adminFee = new BigDecimal(0)
    records.'soap:Body'.'*:MoveInCostRetrieveResponse'.'*:MoveInCostRetrieveResult'.'*:diffgram'.NewDataSet.'*:Table'.each {fee ->
      if (fee.ChargeDescription.text() == 'Administrative Fee') {
        adminFee = new BigDecimal(fee.dcTenantRate.text())
      }
    }
    println('returning fee=' + adminFee)
    return adminFee
  }

  def getPromos(siteLink, site) {
    def ret = getPromos(siteLink.corpCode, site.sourceLoc, siteLink.userName, siteLink.password)
    def records = ret.declareNamespace(
            soap: 'http://schemas.xmlsoap.org/soap/envelope/',
            xsi: 'http://www.w3.org/2001/XMLSchema-instance',
            xsd: 'http://www.w3.org/2001/XMLSchema',
            msdata: 'urn:schemas-microsoft-com:xml-msdata',
            diffgr: 'urn:schemas-microsoft-com:xml-diffgram-v1'
    )
    def adminFee = new BigDecimal(0)
    records.'soap:Body'.'*:PromotionsRetrieveResponse'.'*:PromotionsRetrieveResult'.'*:diffgram'.NewDataSet.'*:ConcessionPlans'.each {promo ->
      def showOn = Integer.parseInt(promo.iShowOn.text())
      def promoName = promo.sPlanName
      if ((showOn == 0 || showOn == 1) && promoName != 'Manual') {
        SpecialOffer specialOffer = new SpecialOffer()
        specialOffer.concessionId = Integer.parseInt(promo.ConcessionID.text())
        specialOffer.active = true;
        specialOffer.prepayMonths = Integer.parseInt(promo.iPrePaidMonths.text())
        specialOffer.description = promo.sDescription
        specialOffer.promoName = promoName
        specialOffer.expireMonth = Integer.parseInt(promo.iExpirMonths.text())
        specialOffer.prepay = Boolean.parseBoolean(promo.bPrepay.text())
        specialOffer.inMonth = Integer.parseInt(promo.iInMonth.text())
        def ptype = Integer.parseInt(promo.iAmtType.text())
        switch (ptype) {
          case 0:
            specialOffer.promoType = PromoType.AMOUNT_OFF
            specialOffer.promoQty = new BigDecimal(promo.dcFixedDiscount.text())
            break

          case 1:
            specialOffer.promoType = PromoType.PERCENT_OFF
            specialOffer.promoQty = new BigDecimal(promo.dcPCDiscount.text())
            break

          case 2:
            specialOffer.promoType = PromoType.FIXED_RATE
            specialOffer.promoQty = new BigDecimal(promo.dcChgAmt.text())
        }
        specialOffer.save()
        site.addToSpecialOffers(specialOffer)
      }
    }
  }

}
