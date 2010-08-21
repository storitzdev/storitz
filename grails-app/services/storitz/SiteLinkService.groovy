package storitz

import groovyx.net.http.HTTPBuilder
import groovyx.net.http.Method
import static groovyx.net.http.ContentType.XML

import storitz.constants.TruckType
import storitz.constants.PromoType
import com.storitz.Insurance
import com.storitz.StorageUnit
import com.storitz.SiteUser
import com.storitz.StorageSite
import com.storitz.SpecialOffer
import storitz.constants.State
import com.storitz.RentalTransaction
import storitz.constants.RentalUse
import storitz.constants.IdType
import com.storitz.User
import com.storitz.UserNotificationType
import com.storitz.NotificationType
import com.storitz.UserRole
import com.storitz.Role

class SiteLinkService {

  def geocodeService
  def unitSizeService

  def siteLinkWsUrl = "https://www.smdservers.net/ccws/callcenterws.asmx"
  def siteLinkWsUrl35 = "https://www.smdservers.net/CCWs_3.5/CallCenterWs.asmx"

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
         <cal:iCountry>-1</cal:iCountry>
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

  def getMoveInWithDiscount(rentalTransaction) {
    StorageUnit unit = StorageUnit.get(rentalTransaction.unitId as Long)

    def concessionId = rentalTransaction.promoId as Long
    if (concessionId != -999) {
      SpecialOffer specialOffer = SpecialOffer.get(rentalTransaction.promoId as Long)
      concessionId = specialOffer.concessionId
    }

    def insuranceId = rentalTransaction.insuranceId as Long
    if (insuranceId != -999) {
      Insurance ins = Insurance.get(insuranceId)
      insuranceId = ins.insuranceId
    }

    def payload = """<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:cal="http://tempuri.org/CallCenterWs/CallCenterWs">
   <soapenv:Header/>
   <soapenv:Body>
      <cal:MoveInCostRetrieveWithDiscount>
         <!--Optional:-->
         <cal:sCorpCode>""" + rentalTransaction.site.siteLink.corpCode + """</cal:sCorpCode>
         <!--Optional:-->
         <cal:sLocationCode>""" + rentalTransaction.site.sourceLoc + """</cal:sLocationCode>
         <!--Optional:-->
         <cal:sCorpUserName>""" + rentalTransaction.site.siteLink.userName + """</cal:sCorpUserName>
         <!--Optional:-->
         <cal:sCorpPassword>""" + rentalTransaction.site.siteLink.password + """</cal:sCorpPassword>
         <cal:iUnitID>""" + unit.unitNumber + """</cal:iUnitID>
         <cal:dMoveInDate>""" + rentalTransaction.moveInDate.format("yyyy-MM-dd") + """</cal:dMoveInDate>
         <cal:InsuranceCoverageID>""" + insuranceId + """</cal:InsuranceCoverageID>
         <cal:ConcessionPlanID>""" + concessionId + """</cal:ConcessionPlanID>
      </cal:MoveInCostRetrieveWithDiscount>
   </soapenv:Body>
</soapenv:Envelope>"""

    println "MoveInCostRetrieveWithDiscount: ${payload}"

    postAction(payload, 'MoveInCostRetrieveWithDiscount')
  }

  def newTenant(RentalTransaction rentalTransaction) {

    def payload = """<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:cal="http://tempuri.org/CallCenterWs/CallCenterWs">
   <soapenv:Header/>
   <soapenv:Body>
      <cal:TenantNewDetailed>
         <!--Optional:-->
         <cal:sCorpCode>""" + rentalTransaction.site.siteLink.corpCode + """</cal:sCorpCode>
         <!--Optional:-->
         <cal:sLocationCode>""" + rentalTransaction.site.sourceLoc + """</cal:sLocationCode>
         <!--Optional:-->
         <cal:sCorpUserName>""" + rentalTransaction.site.siteLink.userName + """</cal:sCorpUserName>
         <!--Optional:-->
         <cal:sCorpPassword>""" + rentalTransaction.site.siteLink.password + """</cal:sCorpPassword>
         <!--Optional:-->
         <cal:sWebPassword></cal:sWebPassword>
         <!--Optional:-->
         <cal:sMrMrs></cal:sMrMrs>
         <!--Optional:-->
         <cal:sFName>""" + rentalTransaction.contactPrimary.firstName + """</cal:sFName>
         <!--Optional:-->
         <cal:sMI></cal:sMI>
         <!--Optional:-->
         <cal:sLName>""" + rentalTransaction.contactPrimary.lastName + """</cal:sLName>
         <!--Optional:-->
         <cal:sCompany></cal:sCompany>
         <!--Optional:-->
         <cal:sAddr1>""" + rentalTransaction.contactPrimary.address1 + """</cal:sAddr1>
         <!--Optional:-->
         <cal:sAddr2>""" + rentalTransaction.contactPrimary.address2 + """</cal:sAddr2>
         <!--Optional:-->
         <cal:sCity>""" + rentalTransaction.contactPrimary.city + """</cal:sCity>
         <!--Optional:-->
         <cal:sRegion>""" + rentalTransaction.contactPrimary.state.display + """</cal:sRegion>
         <!--Optional:-->
         <cal:sPostalCode>""" + rentalTransaction.contactPrimary.zipcode + """</cal:sPostalCode>
         <!--Optional:-->
         <cal:sCountry>""" + rentalTransaction.contactPrimary.country.display + """</cal:sCountry>
         <!--Optional:-->
         <cal:sPhone>""" + rentalTransaction.contactPrimary.phone + """</cal:sPhone>
         <!--Optional:-->
         <cal:sMrMrsAlt></cal:sMrMrsAlt>
         <!--Optional:-->
         <cal:sFNameAlt>""" + rentalTransaction.contactSecondary?.firstName + """</cal:sFNameAlt>
         <!--Optional:-->
         <cal:sMIAlt></cal:sMIAlt>
         <!--Optional:-->
         <cal:sLNameAlt>""" + rentalTransaction.contactSecondary?.lastName + """</cal:sLNameAlt>
         <!--Optional:-->
         <cal:sAddr1Alt>""" + rentalTransaction.contactSecondary?.address1 + """</cal:sAddr1Alt>
         <!--Optional:-->
         <cal:sAddr2Alt>""" + rentalTransaction.contactSecondary?.address2 + """</cal:sAddr2Alt>
         <!--Optional:-->
         <cal:sCityAlt>""" + rentalTransaction.contactSecondary?.city + """</cal:sCityAlt>
         <!--Optional:-->
         <cal:sRegionAlt>""" + rentalTransaction.contactSecondary?.state?.display +  """</cal:sRegionAlt>
         <!--Optional:-->
         <cal:sPostalCodeAlt>""" + rentalTransaction.contactSecondary?.zipcode + """</cal:sPostalCodeAlt>
         <!--Optional:-->
         <cal:sCountryAlt>""" + rentalTransaction.contactSecondary?.country?.display +  """</cal:sCountryAlt>
         <!--Optional:-->
         <cal:sPhoneAlt>""" + rentalTransaction.contactSecondary?.phone + """</cal:sPhoneAlt>
         <!--Optional:-->
         <cal:sMrMrsBus></cal:sMrMrsBus>
         <!--Optional:-->
         <cal:sFNameBus></cal:sFNameBus>
         <!--Optional:-->
         <cal:sMIBus></cal:sMIBus>
         <!--Optional:-->
         <cal:sLNameBus></cal:sLNameBus>
         <!--Optional:-->
         <cal:sCompanyBus></cal:sCompanyBus>
         <!--Optional:-->
         <cal:sAddr1Bus></cal:sAddr1Bus>
         <!--Optional:-->
         <cal:sAddr2Bus></cal:sAddr2Bus>
         <!--Optional:-->
         <cal:sCityBus></cal:sCityBus>
         <!--Optional:-->
         <cal:sRegionBus></cal:sRegionBus>
         <!--Optional:-->
         <cal:sPostalCodeBus></cal:sPostalCodeBus>
         <!--Optional:-->
         <cal:sCountryBus></cal:sCountryBus>
         <!--Optional:-->
         <cal:sPhoneBus></cal:sPhoneBus>
         <!--Optional:-->
         <cal:sFax></cal:sFax>
         <!--Optional:-->
         <cal:sEmail>""" + rentalTransaction.contactPrimary.email + """</cal:sEmail>
         <!--Optional:-->
         <cal:sPager></cal:sPager>
         <!--Optional:-->
         <cal:sMobile></cal:sMobile>
         <cal:bCommercial>""" + (rentalTransaction.rentalUse == RentalUse.BUSINESS ? 'true' : 'false') + """</cal:bCommercial>
         <cal:bCompanyIsTenant>""" + (rentalTransaction.rentalUse == RentalUse.BUSINESS ? 'true' : 'false') + """</cal:bCompanyIsTenant>
         <cal:dDOB>""" + (rentalTransaction.dateOfBirth ? rentalTransaction.dateOfBirth.format('yyyy-MM-dd') : '1969-01-01') + """</cal:dDOB>
         <!--Optional:-->
         <cal:sTenNote>""" + "Storitz move-in: Transaction ID = ${rentalTransaction.id}" + """</cal:sTenNote>
         <!--Optional:-->
         <cal:sLicense>""" + (rentalTransaction.idType == IdType.DRIVERSLICENSE ? rentalTransaction.idNumber : '') + """</cal:sLicense>
         <!--Optional:-->
         <cal:sLicRegion>""" + (rentalTransaction.idType == IdType.DRIVERSLICENSE ? rentalTransaction.idState.display : '') + """</cal:sLicRegion>
         <!--Optional:-->
         <cal:sSSN></cal:sSSN>
      </cal:TenantNewDetailed>
   </soapenv:Body>
</soapenv:Envelope>"""

    postAction(payload, 'TenantNewDetailed')
  }

  def doMoveIn(RentalTransaction rentalTransaction) {
    StorageUnit unit = StorageUnit.get(rentalTransaction.unitId as Long)

    def concessionId = rentalTransaction.promoId as Long
    if (concessionId != -999) {
      SpecialOffer specialOffer = SpecialOffer.get(rentalTransaction.promoId as Long)
      concessionId = specialOffer.concessionId
    }

    def insuranceId = rentalTransaction.insuranceId as Long
    if (insuranceId != -999) {
      Insurance ins = Insurance.get(insuranceId)
      insuranceId = ins.insuranceId
    }

    def payload = """<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:cal="http://tempuri.org/CallCenterWs/CallCenterWs">
   <soapenv:Header/>
   <soapenv:Body>
      <cal:MoveInWithDiscount>
         <cal:sCorpCode>""" + rentalTransaction.site.siteLink.corpCode + """</cal:sCorpCode>
         <cal:sLocationCode>""" + rentalTransaction.site.sourceLoc + """</cal:sLocationCode>
         <cal:sCorpUserName>""" + rentalTransaction.site.siteLink.userName + """</cal:sCorpUserName>
         <cal:sCorpPassword>""" + rentalTransaction.site.siteLink.password + """</cal:sCorpPassword>
         <cal:TenantID>""" + rentalTransaction.tenantId + """</cal:TenantID>
         <cal:sAccessCode>""" + rentalTransaction.accessCode + """</cal:sAccessCode>
         <cal:UnitID>""" + unit.unitNumber + """</cal:UnitID>
         <cal:dStartDate>""" + rentalTransaction.moveInDate.format("yyyy-MM-dd") + """</cal:dStartDate>
         <cal:dEndDate>""" + rentalTransaction.paidThruDate.format("yyyy-MM-dd") + """</cal:dEndDate>
         <cal:dcPaymentAmount>""" + rentalTransaction.cost + """</cal:dcPaymentAmount>
         <cal:iCreditCardType>""" + rentalTransaction.cardType.siteLinkValue +  """</cal:iCreditCardType>
         <cal:sCreditCardNumber>""" + rentalTransaction.ccNum + """</cal:sCreditCardNumber>
         <cal:sCreditCardCVV>""" + rentalTransaction.cvv2 + """</cal:sCreditCardCVV>
         <cal:dExpirationDate>""" + rentalTransaction.ccExpDate.format("yyyy-MM-dd")+ """</cal:dExpirationDate>
         <cal:sBillingName>""" + "${rentalTransaction.billingAddress.firstName} ${rentalTransaction.billingAddress.lastName}" + """</cal:sBillingName>
         <cal:sBillingAddress>""" + "${rentalTransaction.billingAddress.address1} ${rentalTransaction.billingAddress.address2}" + """</cal:sBillingAddress>
         <cal:sBillingZipCode>""" + rentalTransaction.billingAddress.zipcode + """</cal:sBillingZipCode>
         <cal:InsuranceCoverageID>""" + insuranceId + """</cal:InsuranceCoverageID>
         <cal:ConcessionPlanID>""" + concessionId + """</cal:ConcessionPlanID>
         <cal:bTestMode>true</cal:bTestMode>
      </cal:MoveInWithDiscount>
   </soapenv:Body>
</soapenv:Envelope>"""

    println "MoveInWithDiscount: ${payload}"

    postAction(payload, "MoveInWithDiscount")
  }

  def getUnitInfoByName(siteLink, location, unitId) {
    StorageUnit unit = StorageUnit.get(unitId as Long)

    def payload = """<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:cal="http://tempuri.org/CallCenterWs/CallCenterWs">
   <soapenv:Header/>
   <soapenv:Body>
      <cal:UnitsInformationByUnitName>
         <!--Optional:-->
         <cal:sCorpCode>""" + siteLink.corpCode + """</cal:sCorpCode>
         <!--Optional:-->
         <cal:sLocationCode>""" + location + """</cal:sLocationCode>
         <!--Optional:-->
         <cal:sCorpUserName>""" + siteLink.userName + """</cal:sCorpUserName>
         <!--Optional:-->
         <cal:sCorpPassword>""" + siteLink.password + """</cal:sCorpPassword>
         <!--Optional:-->
         <cal:sUnitName>""" + unit.unitName + """</cal:sUnitName>
      </cal:UnitsInformationByUnitName>
   </soapenv:Body>
</soapenv:Envelope>"""

    postAction(payload, 'UnitsInformationByUnitName')
  }

  private def postAction(payload, action) {
    def http = new HTTPBuilder(siteLinkWsUrl35)

    http.handler.failure = {resp, req ->
      println "Unexpected failure: ${resp.statusLine} ${resp.dump()}"
    }

    http.request(Method.POST, XML) {req ->

      delegate.headers['Content-Type'] = "text/xml"

      headers.'SOAPAction' = '"http://tempuri.org/CallCenterWs/CallCenterWs/' + action + '"'

      body = payload

      response.error = {resp ->
        println "${resp.statusLine}"
      }
    }
  }

  def refreshSites(siteLink, stats) {
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
      if (!site) {
        println "Found and creating new site: ${tab.sSiteName.text()}, postal code: ${tab.sSitePostalCode.text()}"
        site = new StorageSite()
        stats.createCount++
        site.lastUpdate = 0
        if (tab.sSitePostalCode.text().size() >= 5 && tab.sSitePostalCode.text().substring(0, 5).isNumber()) {
          getSiteDetails(siteLink, site, tab, stats, true)
        }
      }
    }
  }

  def corpSites(siteLink, stats) {
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
      def newSite = false
      if (site) {
        stats.updateCount++
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
      if (tab.sSitePostalCode.text().isNumber()) {
        getSiteDetails(siteLink, site, tab, stats, newSite)
      }
    }
  }

  def createSiteUsers(siteLink) {
    def ret = getSites(siteLink.corpCode, siteLink.userName, siteLink.password)
    def records = ret.declareNamespace(
            soap: 'http://schemas.xmlsoap.org/soap/envelope/',
            xsi: 'http://www.w3.org/2001/XMLSchema-instance',
            xsd: 'http://www.w3.org/2001/XMLSchema',
            msdata: 'urn:schemas-microsoft-com:xml-msdata',
            diffgr: 'urn:schemas-microsoft-com:xml-diffgram-v1'
    )


    for(tab in records.'soap:Body'.'*:SiteSearchByPostalCodeResponse'.'*:SiteSearchByPostalCodeResult'.'*:diffgram'.NewDataSet.'*:Table') {
      StorageSite site = StorageSite.findBySourceAndSourceId("SL", tab.SiteID.text())
      if (site) {
        def email = tab.sEmailAddress.text().toLowerCase()
        def realName = tab.sContactName.text()
        createSiteUser(site, email, realName, siteLink.manager)
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

  def getSiteDetails(siteLink, site, tab, stats, newSite) {
    def address = tab.sSiteAddr1.text() + ' ' + tab.sSiteAddr2.text() + ', ' + tab.sSiteCity.text() + ', ' + tab.sSiteRegion.text() + ' ' + tab.sSitePostalCode.text()

    println "Found address: ${address}"
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
    site.state = State.fromText(tab.sSiteRegion.text())
    site.zipcode = tab.sSitePostalCode.text()
    site.requiresInsurance = false
    site.boxesAvailable = true
    site.freeTruck = TruckType.NONE
    site.isGate = false
    site.isKeypad = false
    site.isCamera = false
    site.isUnitAlarmed = false
    site.isManagerOnsite = false
    site.hasElevator = false

    site.openWeekday = !Boolean.parseBoolean(tab.bClosedWeekdays.text())
    site.openSaturday = !Boolean.parseBoolean(tab.bClosedSaturday.text())
    site.openSunday = !Boolean.parseBoolean(tab.bClosedSunday.text())

    def sWeekdayStart = tab.dWeekdayStrt.text()
    def sWeekdayEnd = tab.dWeekdayEnd.text()
    def sSaturdayStart = tab.dSaturdayStrt.text()
    def sSaturdayEnd = tab.dSaturdayEnd.text()
    def sSundayStart = tab.dSundayStrt.text()
    def sSundayEnd = tab.dSundayEnd.text()
    site.startSundayGate = site.startGate = site.startWeekday = sWeekdayStart.length() > 0 ? Date.parse("yyyy-MM-dd'T'HH:mm:ssZ", sWeekdayStart.substring(0, sWeekdayStart.length() - 3) + '00') : null
    site.endSundayGate = site.endGate = site.endWeekday = sWeekdayEnd.length() > 0 ? Date.parse("yyyy-MM-dd'T'HH:mm:ssZ", sWeekdayEnd.substring(0, sWeekdayEnd.length() - 3) + '00') : null
    site.startSaturday = sSaturdayStart.length() > 0 ? Date.parse("yyyy-MM-dd'T'HH:mm:ssZ", sSaturdayStart.substring(0, sSaturdayStart.length() - 3) + '00') : null
    site.endSaturday = sSaturdayEnd.length() > 0 ? Date.parse("yyyy-MM-dd'T'HH:mm:ssZ", sSaturdayEnd.substring(0, sSaturdayEnd.length() - 3) + '00') : null
    site.startSunday = sSundayStart.length() > 0 ? Date.parse("yyyy-MM-dd'T'HH:mm:ssZ", sSundayStart.substring(0, sSundayStart.length() - 3) + '00') : null
    site.endSunday = sSundayEnd.length() > 0 ? Date.parse("yyyy-MM-dd'T'HH:mm:ssZ", sSundayEnd.substring(0, sSundayEnd.length() - 3) + '00') : null
    site.extendedHours = false

    site.siteLink = siteLink
    site.centerShift = null

    site.save()

    def email = tab.sEmailAddress.text().toLowerCase()
    def realName = tab.sContactName.text()
    createSiteUser(site, email, realName, siteLink.manager)

    if (newSite) {
      SiteUser.link(site, siteLink.manager)
    }

    unitsAvailable(siteLink, site, stats, newSite)

    site.requiresInsurance = insurance(siteLink, site)
    if (site.units?.size() > 0) {
      site.adminFee = adminFees(siteLink, site.units.asList().get(0).unitNumber, site)
    }
    getPromos(siteLink, site)
    site.save(flush: true)
  }

  def updateSite(site, stats) {
    def ret = getSiteInfo(site.siteLink.corpCode, site.sourceLoc, site.siteLink.userName, site.siteLink.password)
    def records = ret.declareNamespace(
            soap: 'http://schemas.xmlsoap.org/soap/envelope/',
            xsi: 'http://www.w3.org/2001/XMLSchema-instance',
            xsd: 'http://www.w3.org/2001/XMLSchema',
            msdata: 'urn:schemas-microsoft-com:xml-msdata',
            diffgr: 'urn:schemas-microsoft-com:xml-diffgram-v1'
    )
    records.'soap:Body'.'*:SiteInformationResponse'.'*:SiteInformationResult'.'*:diffgram'.NewDataSet.'*:Table'.each {tab ->
      site.insurances.each {ins ->
        ins.delete()
      }
      site.specialOffers.each {offer ->
        offer.delete()
      }
      site.insurances.clear()
      site.specialOffers.clear()
      site.lastUpdate = 0
      site.save(flush: true)
      getSiteDetails(site.siteLink, site, tab, stats, false)
    }

  }

  def updateUnits(site, stats) {
    unitsAvailable(site.siteLink, site, stats, false)
    site.save(flush: true)
  }

  def unitsAvailable(siteLink, site, stats, newSite) {
    println "Getting units available for site: " + site.title + " last update ticks: " + site.lastUpdate
    def ret = getUnitsAvailable(siteLink.corpCode, site.sourceLoc, siteLink.userName, siteLink.password, newSite ? 0 : site.lastUpdate)
    def records = ret.declareNamespace(
            soap: 'http://schemas.xmlsoap.org/soap/envelope/',
            xsi: 'http://www.w3.org/2001/XMLSchema-instance',
            xsd: 'http://www.w3.org/2001/XMLSchema',
            msdata: 'urn:schemas-microsoft-com:xml-msdata',
            diffgr: 'urn:schemas-microsoft-com:xml-diffgram-v1'
    )

    for (unit in records.'soap:Body'.'*:UnitsInformationAvailableUnitsOnly_v2Response'.'*:UnitsInformationAvailableUnitsOnly_v2Result'.'*:diffgram'.NewDataSet.'*:Table') {
      boolean rented = unit.bRented.text().toLowerCase() == 'true'

      if (rented) {

       def unitID = unit.UnitID.text()
       def deletedUnit = site.units.find{ it.unitNumber == unitID }
       if (deletedUnit) {
         site.removeFromUnits(deletedUnit)
         stats.removedCount++
       }

      } else {
        def unitID = unit.UnitID.text()
        def existingUnit = site.units.find{ it.unitNumber == unitID }

        if (!existingUnit) {

          def siteUnit = new StorageUnit()
          siteUnit.unitCount = 1
          siteUnit.description = unit.sTypeName.text()
          siteUnit.unitNumber = unit.UnitID.text()
          siteUnit.unitName = unit.sUnitName.text()
          siteUnit.price = unit.dcStdRate.text() as BigDecimal
          siteUnit.pushRate = unit.dcBoardRate.text() as BigDecimal
          def floor = unit.iFloor.text() as Integer
          def typeName = unit.sTypeName.text()
          siteUnit.isUpper = (floor > 1 || floor == 1 && typeName ==~ /(2ND|3RD).+/)
          siteUnit.isInterior = (!siteUnit.isUpper && (Boolean.parseBoolean(unit.bInside.text()) || typeName ==~ /MAIN FLOOR*/))
          siteUnit.isAlarm = Boolean.parseBoolean(unit.bAlarm.text())
          siteUnit.isTempControlled = Boolean.parseBoolean(unit.bClimate.text())
          siteUnit.isDriveup = ((!siteUnit.isUpper && !siteUnit.isInterior) || typeName ==~ /DRIVE UP*/)
          siteUnit.isPowered = Boolean.parseBoolean(unit.bPower.text())
          siteUnit.isAvailable = true
          siteUnit.isSecure = false
          if (!siteUnit.isUpper && !siteUnit.isInterior && !siteUnit.isDriveup) {
            siteUnit.isUpper = true
          }
          Integer width = (int) Double.parseDouble(unit.dcWidth.text())
          Integer length = (int) Double.parseDouble(unit.dcLength.text())
          siteUnit.displaySize = width + " X " + length

          def unitSize = unitSizeService.getUnitSize(width, length)
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
      }
    }
    for (lastupdate in records.'soap:Body'.'*:UnitsInformationAvailableUnitsOnly_v2Response'.'*:UnitsInformationAvailableUnitsOnly_v2Result'.'*:diffgram'.NewDataSet.'*:Table1') {
      site.lastUpdate = lastupdate.lngLastTimePolled.text() as Long
    }

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
    for (ins in records.'soap:Body'.'*:InsuranceCoverageRetrieveResponse'.'*:InsuranceCoverageRetrieveResult'.'*:diffgram'.NewDataSet.'*:Table') {
      def insurance = new Insurance()
      insurance.insuranceId = Integer.parseInt(ins.InsurCoverageID.text())
      insurance.totalCoverage = ins.dcCoverage.text() as BigDecimal
      insurance.premium = ins.dcPremium.text() as BigDecimal
      insurance.percentTheft = ins.dcPCTheft.text() as BigDecimal
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
    for (fee in records.'soap:Body'.'*:MoveInCostRetrieveResponse'.'*:MoveInCostRetrieveResult'.'*:diffgram'.NewDataSet.'*:Table') {
      if (fee.ChargeDescription.text() == 'Administrative Fee') {
        adminFee = new BigDecimal(fee.dcTenantRate.text() as String)
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
    records.'soap:Body'.'*:PromotionsRetrieveResponse'.'*:PromotionsRetrieveResult'.'*:diffgram'.NewDataSet.'*:ConcessionPlans'.each {promo ->
      def showOn = Integer.parseInt(promo.iShowOn.text())
      def promoName = promo.sPlanName
      if ((showOn == 0 || showOn == 1) && promoName != 'Manual') {
        SpecialOffer specialOffer = new SpecialOffer()
        specialOffer.concessionId = Integer.parseInt(promo.ConcessionID.text())
        specialOffer.active = true;
        specialOffer.featured = false;
        specialOffer.waiveAdmin = false;
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
            specialOffer.promoQty = promo.dcFixedDiscount.text() as BigDecimal
            break

          case 1:
            specialOffer.promoType = PromoType.PERCENT_OFF
            specialOffer.promoQty = promo.dcPCDiscount.text() as BigDecimal
            break

          case 2:
            specialOffer.promoType = PromoType.FIXED_RATE
            specialOffer.promoQty = promo.dcChgAmt.text() as BigDecimal
        }
        specialOffer.save()
        site.addToSpecialOffers(specialOffer)
      }
    }
  }

  def moveInCostRetrieve(rentalTransaction) {
    def ret = getMoveInWithDiscount(rentalTransaction)

    println "MoveInWithDiscount result: ${ret}"

    def records = ret.declareNamespace(
            soap: 'http://schemas.xmlsoap.org/soap/envelope/',
            xsi: 'http://www.w3.org/2001/XMLSchema-instance',
            xsd: 'http://www.w3.org/2001/XMLSchema',
            msdata: 'urn:schemas-microsoft-com:xml-msdata',
            diffgr: 'urn:schemas-microsoft-com:xml-diffgram-v1'
    )
    def adminFee = new BigDecimal(0)
    for (fee in records.'soap:Body'.'*:MoveInCostRetrieveResponse'.'*:MoveInCostRetrieveResult'.'*:diffgram'.NewDataSet.'*:Table') {
      if (fee.ChargeDescription.text() == 'Administrative Fee') {
        adminFee = new BigDecimal(fee.dcTenantRate.text() as String)
      }
    }
    println('returning fee=' + adminFee)
    return adminFee
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


    records.'soap:Body'.'*:TenantNewDetailedResponse'.'*:TenantNewDetailedResult'.'*:diffgram'.NewDataSet.'*:RT'.each {tab ->
      rentalTransaction.tenantId = tab.TenantID.text()
      rentalTransaction.accessCode = tab.AccessCode.text()
    }
    rentalTransaction.save(flush:true)
  }

  def checkRented(RentalTransaction rentalTransaction) {
    def ret = getUnitInfoByName(rentalTransaction.site.siteLink, rentalTransaction.site.sourceLoc, rentalTransaction.unitId)

    def records = ret.declareNamespace(
            soap: 'http://schemas.xmlsoap.org/soap/envelope/',
            xsi: 'http://www.w3.org/2001/XMLSchema-instance',
            xsd: 'http://www.w3.org/2001/XMLSchema',
            msdata: 'urn:schemas-microsoft-com:xml-msdata',
            diffgr: 'urn:schemas-microsoft-com:xml-diffgram-v1'
    )
    def rented = false
    records.'soap:Body'.'*:UnitsInformationByUnitNameResponse'.'*:UnitsInformationByUnitNameResult'.'*:diffgram'.NewDataSet.'*:Table'.each {tab ->
      rented = tab.bRented.text() as Boolean
    }

    return rented
  }

  def moveIn(RentalTransaction rentalTransaction) {
    def ret = doMoveIn(rentalTransaction)

    println "MoveInWithDiscount: ${ret}"
    def records = ret.declareNamespace(
            soap: 'http://schemas.xmlsoap.org/soap/envelope/',
            xsi: 'http://www.w3.org/2001/XMLSchema-instance',
            xsd: 'http://www.w3.org/2001/XMLSchema',
            msdata: 'urn:schemas-microsoft-com:xml-msdata',
            diffgr: 'urn:schemas-microsoft-com:xml-diffgram-v1'
    )

    def moveInResult = -1
    records.'soap:Body'.'*:MoveInWithDiscountResponse'.'*:MoveInWithDiscountResult'.'*:diffgram'.NewDataSet.'*:RT'.each {tab ->
      moveInResult = tab.Ret_Code.text() as Integer
    }
    return moveInResult > 0 
  }

  def calculateMoveInCost(StorageSite site, StorageUnit unit, SpecialOffer promo, Insurance ins) {
    def durationMonths = 1
    def offerDiscount = 0
    def premium = ins ? ins.premium : 0
    def additionalFees = site.adminFee ? site.adminFee : site.lockFee ? site.lockFee : 0
    def adminFee = site.adminFee ? site.adminFee : 0
    def waiveAdmin = false

    if (promo) {

      durationMonths = (promo.prepay ? promo.prepayMonths + promo.expireMonth : (promo.inMonth -1) + promo.expireMonth)
      waiveAdmin = promo.waiveAdmin

      switch (promo.promoType) {
        case "AMOUNT_OFF":
          offerDiscount = promo.promoQty * promo.expireMonth;
          break;

        case "PERCENT_OFF":
          offerDiscount = (promo.promoQty/100.0) * promo.expireMonth * unit.price;
          break;

        case "FIXED_RATE":
          offerDiscount = (unit.price - promo.promoQty) * promo.expireMonth;
          break;
      }
    }
    return (waiveAdmin ? additionalFees - adminFee : additionalFees) + (unit.price + premium)*durationMonths - offerDiscount;

  }

  def calculatePaidThruDate(StorageSite site, SpecialOffer promo, Date moveInDate) {
    // TODO - handle prorated payments
    def durationMonths = promo ? (promo.prepay ? promo.prepayMonths + promo.expireMonth : (promo.inMonth -1) + promo.expireMonth) : 1;
    def cal = new GregorianCalendar()
    cal.setTime(moveInDate)
    cal.add(Calendar.MONTH, durationMonths)
    return cal.time
  }

  def calculateTotals(StorageSite site, StorageUnit unit, SpecialOffer promo, Insurance ins) {
    def ret = [:]
    def durationMonths = promo ? (promo.prepay ? promo.prepayMonths + promo.expireMonth : (promo.inMonth -1) + promo.expireMonth) : 1;
    def offerDiscount = 0
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
          offerDiscount = (unit.price - promo.promoQty) * promo.expireMonth;
          break;
      }
    }
    def feesTotal = (waiveAdmin ? additionalFees - adminFee : additionalFees)
    def moveInTotal = feesTotal + (unit.price + premium)*durationMonths - offerDiscount;

    ret["durationMonths"] = durationMonths
    ret["discountTotal"] = offerDiscount
    ret["feesTotal"] = feesTotal
    ret["moveInTotal"] = moveInTotal

    return ret
  }
}
