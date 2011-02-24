package storitz

import groovyx.net.http.HTTPBuilder
import groovyx.net.http.Method
import java.math.RoundingMode
import com.storitz.*
import static groovyx.net.http.ContentType.XML
import storitz.constants.*

class SiteLinkService extends BaseProviderService {

  def geocodeService
  def unitSizeService
  def emailService

  def siteLinkWsUrl = "https://www.smdservers.net/ccws/callcenterws.asmx"
  def siteLinkWsUrl35 = "https://www.smdservers.net/CCWs_3.5/CallCenterWs.asmx"

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

  def getMoveInWithDiscount(rentalTransaction, unit) {

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

    def siteLink = (SiteLink)rentalTransaction.site.feed
    def payload = """<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:cal="http://tempuri.org/CallCenterWs/CallCenterWs">
   <soapenv:Header/>
   <soapenv:Body>
      <cal:MoveInCostRetrieveWithDiscount>
         <!--Optional:-->
         <cal:sCorpCode>""" + siteLink.corpCode + """</cal:sCorpCode>
         <!--Optional:-->
         <cal:sLocationCode>""" + rentalTransaction.site.sourceLoc + """</cal:sLocationCode>
         <!--Optional:-->
         <cal:sCorpUserName>""" + siteLink.userName + """</cal:sCorpUserName>
         <!--Optional:-->
         <cal:sCorpPassword>""" + siteLink.password + """</cal:sCorpPassword>
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

    def siteLink = (SiteLink)rentalTransaction.site.feed

    def payload = """<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:cal="http://tempuri.org/CallCenterWs/CallCenterWs">
   <soapenv:Header/>
   <soapenv:Body>
      <cal:TenantNewDetailed>
         <!--Optional:-->
         <cal:sCorpCode>""" + siteLink.corpCode + """</cal:sCorpCode>
         <!--Optional:-->
         <cal:sLocationCode>""" + rentalTransaction.site.sourceLoc + """</cal:sLocationCode>
         <!--Optional:-->
         <cal:sCorpUserName>""" + siteLink.userName + """</cal:sCorpUserName>
         <!--Optional:-->
         <cal:sCorpPassword>""" + siteLink.password + """</cal:sCorpPassword>
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
         <cal:sAddr2>""" + (rentalTransaction.contactPrimary?.address2 ? rentalTransaction.contactPrimary.address2 : '') + """</cal:sAddr2>
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
         <cal:sFNameAlt>""" + (rentalTransaction.contactSecondary?.firstName ? rentalTransaction.contactSecondary.firstName : '') + """</cal:sFNameAlt>
         <!--Optional:-->
         <cal:sMIAlt></cal:sMIAlt>
         <!--Optional:-->
         <cal:sLNameAlt>""" + (rentalTransaction.contactSecondary?.lastName ? rentalTransaction.contactSecondary.lastName : '' )+ """</cal:sLNameAlt>
         <!--Optional:-->
         <cal:sAddr1Alt>""" + (rentalTransaction.contactSecondary?.address1 ? rentalTransaction.contactSecondary.address1 : '')+ """</cal:sAddr1Alt>
         <!--Optional:-->
         <cal:sAddr2Alt>""" + (rentalTransaction.contactSecondary?.address2 ? rentalTransaction.contactSecondary.address2 : '' )+ """</cal:sAddr2Alt>
         <!--Optional:-->
         <cal:sCityAlt>""" + (rentalTransaction.contactSecondary?.city ? rentalTransaction.contactSecondary.city : '' ) + """</cal:sCityAlt>
         <!--Optional:-->
         <cal:sRegionAlt>""" + (rentalTransaction.contactSecondary?.state?.display ? rentalTransaction.contactSecondary?.state.display : '' ) +  """</cal:sRegionAlt>
         <!--Optional:-->
         <cal:sPostalCodeAlt>""" + (rentalTransaction.contactSecondary?.zipcode ? rentalTransaction.contactSecondary.zipcode : '' )+ """</cal:sPostalCodeAlt>
         <!--Optional:-->
         <cal:sCountryAlt>""" + (rentalTransaction.contactSecondary?.country?.display ? rentalTransaction.contactSecondary.country.display  : '' ) +  """</cal:sCountryAlt>
         <!--Optional:-->
         <cal:sPhoneAlt>""" + (rentalTransaction.contactSecondary?.phone ? rentalTransaction.contactSecondary.phone : '' ) + """</cal:sPhoneAlt>
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

  def getMoveInPayload(RentalTransaction rentalTransaction) {

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

    def siteLink = (SiteLink)rentalTransaction.site.feed
    def payload = """<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:cal="http://tempuri.org/CallCenterWs/CallCenterWs">
   <soapenv:Header/>
   <soapenv:Body>
      <cal:MoveInWithDiscount>
         <cal:sCorpCode>""" + siteLink.corpCode + """</cal:sCorpCode>
         <cal:sLocationCode>""" + rentalTransaction.site.sourceLoc + """</cal:sLocationCode>
         <cal:sCorpUserName>""" + siteLink.userName + """</cal:sCorpUserName>
         <cal:sCorpPassword>""" + siteLink.password + """</cal:sCorpPassword>
         <cal:TenantID>""" + rentalTransaction.tenantId + """</cal:TenantID>
         <cal:sAccessCode>""" + rentalTransaction.accessCode + """</cal:sAccessCode>
         <cal:UnitID>""" + rentalTransaction.feedUnitId + """</cal:UnitID>
         <cal:dStartDate>""" + rentalTransaction.moveInDate.format("yyyy-MM-dd") + """</cal:dStartDate>
         <cal:dEndDate>""" + rentalTransaction.paidThruDate.format("yyyy-MM-dd") + """</cal:dEndDate>
         <cal:dcPaymentAmount>""" + rentalTransaction.feedMoveInCost + """</cal:dcPaymentAmount>
         <cal:iCreditCardType>""" + rentalTransaction.cardType.siteLinkValue +  """</cal:iCreditCardType>
         <cal:sCreditCardNumber>""" + rentalTransaction.ccNum + """</cal:sCreditCardNumber>
         <cal:sCreditCardCVV>""" + (rentalTransaction.cvv2 ? rentalTransaction.cvv2 : '000') + """</cal:sCreditCardCVV>
         <cal:dExpirationDate>""" + rentalTransaction.ccExpDate.format("yyyy-MM-dd")+ """</cal:dExpirationDate>
         <cal:sBillingName>""" + rentalTransaction.billingAddress.fullName() + """</cal:sBillingName>
         <cal:sBillingAddress>""" + "${rentalTransaction.billingAddress.address1}${rentalTransaction.billingAddress.address2 ? ' ' + rentalTransaction.billingAddress.address2 : ''}" + """</cal:sBillingAddress>
         <cal:sBillingZipCode>""" + rentalTransaction.billingAddress.zipcode + """</cal:sBillingZipCode>
         <cal:InsuranceCoverageID>""" + insuranceId + """</cal:InsuranceCoverageID>
         <cal:ConcessionPlanID>""" + concessionId + """</cal:ConcessionPlanID>
         <cal:bTestMode>true</cal:bTestMode>
      </cal:MoveInWithDiscount>
   </soapenv:Body>
</soapenv:Envelope>"""

    return payload
  }

  def doMoveIn(RentalTransaction rentalTransaction) {

    def payload = getMoveInPayload(rentalTransaction)

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

  def getTaxRate(corpCode, locationCode, userName, password) {
    def payload = """<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:cal="http://tempuri.org/CallCenterWs/CallCenterWs">
   <soapenv:Header/>
   <soapenv:Body>
      <cal:RentTaxRatesRetrieve>
         <cal:sCorpCode>""" + corpCode + """</cal:sCorpCode>
         <cal:sLocationCode>""" + locationCode + """</cal:sLocationCode>
         <cal:sCorpUserName>""" + userName + """</cal:sCorpUserName>
         <cal:sCorpPassword>""" + password + """</cal:sCorpPassword>
      </cal:RentTaxRatesRetrieve>
   </soapenv:Body>
</soapenv:Envelope>"""

    postAction(payload, 'RentTaxRatesRetrieve')
  }

  def getProrationInformation(corpCode, locationCode, userName, password) {

    def payload = """<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:cal="http://tempuri.org/CallCenterWs/CallCenterWs">
   <soapenv:Header/>
   <soapenv:Body>
      <cal:ProrationInformationRetrieve>
         <cal:sCorpCode>""" + corpCode + """</cal:sCorpCode>
         <cal:sLocationCode>""" + locationCode + """</cal:sLocationCode>
         <cal:sCorpUserName>""" + userName + """</cal:sCorpUserName>
         <cal:sCorpPassword>""" + password + """</cal:sCorpPassword>
      </cal:ProrationInformationRetrieve>
   </soapenv:Body>
</soapenv:Envelope>"""

    postAction(payload, 'ProrationInformationRetrieve')
  }

  def getUnitTypePriceList(corpCode, locationCode, userName, password) {

    def payload = """<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:cal="http://tempuri.org/CallCenterWs/CallCenterWs">
   <soapenv:Header/>
   <soapenv:Body>
      <cal:UnitTypePriceList>
         <cal:sCorpCode>""" + corpCode + """</cal:sCorpCode>
         <cal:sLocationCode>""" + locationCode + """</cal:sLocationCode>
         <cal:sCorpUserName>""" + userName + """</cal:sCorpUserName>
         <cal:sCorpPassword>""" + password + """</cal:sCorpPassword>
      </cal:UnitTypePriceList>
   </soapenv:Body>
</soapenv:Envelope>"""

    postAction(payload, 'UnitTypePriceList')
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
    def writer = new PrintWriter(System.out)
    def ret = getSites(siteLink.corpCode, siteLink.userName, siteLink.password)
    def records = ret.declareNamespace(
            soap: 'http://schemas.xmlsoap.org/soap/envelope/',
            xsi: 'http://www.w3.org/2001/XMLSchema-instance',
            xsd: 'http://www.w3.org/2001/XMLSchema',
            msdata: 'urn:schemas-microsoft-com:xml-msdata',
            diffgr: 'urn:schemas-microsoft-com:xml-diffgram-v1'
    )


    records.'soap:Body'.'*:SiteSearchByPostalCodeResponse'.'*:SiteSearchByPostalCodeResult'.'*:diffgram'.NewDataSet.'*:Table'.each {tab ->
      StorageSite site = StorageSite.findByFeedAndSourceId(siteLink as Feed, tab.SiteID.text())
      if (!site) {
        println "Found and creating new site: ${tab.sSiteName.text()}, postal code: ${tab.sSitePostalCode.text()}"
        site = new StorageSite()
        stats.createCount++
        site.lastUpdate = 0
        if (tab.sSitePostalCode.text().size() >= 5 && tab.sSitePostalCode.text().substring(0, 5).isNumber()) {
          getSiteDetails(siteLink, site, tab, stats, true, writer)
        }
      }
    }
    writer.close()
  }

  def corpSites(siteLink, stats) {
    def writer = new PrintWriter(System.out)
    def ret = getSites(siteLink.corpCode, siteLink.userName, siteLink.password)
    def records = ret.declareNamespace(
            soap: 'http://schemas.xmlsoap.org/soap/envelope/',
            xsi: 'http://www.w3.org/2001/XMLSchema-instance',
            xsd: 'http://www.w3.org/2001/XMLSchema',
            msdata: 'urn:schemas-microsoft-com:xml-msdata',
            diffgr: 'urn:schemas-microsoft-com:xml-diffgram-v1'
    )


    records.'soap:Body'.'*:SiteSearchByPostalCodeResponse'.'*:SiteSearchByPostalCodeResult'.'*:diffgram'.NewDataSet.'*:Table'.each {tab ->
      StorageSite site = StorageSite.findByFeedAndSourceId(siteLink as Feed, tab.SiteID.text())
      def newSite = false
      if (site) {
        stats.updateCount++
        site.save(flush:true)
      } else {
        site = new StorageSite()
        stats.createCount++
        site.lastUpdate = 0
        site.lastChange = new Date()
        newSite = true
      }
      if (tab.sSitePostalCode.text().isNumber()) {
        getSiteDetails(siteLink, site, tab, stats, newSite, writer)
      }
    }
    writer.close()
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
      StorageSite site = StorageSite.findByFeedAndSourceId(siteLink as Feed, tab.SiteID.text())
      if (site) {
        def email = tab.sEmailAddress.text().toLowerCase()
        def realName = tab.sContactName.text()
        createSiteUser(site, email, realName, siteLink.manager)
      }
    }
  }

  def createSiteTaxes(siteLink) {
    def ret = getSites(siteLink.corpCode, siteLink.userName, siteLink.password)
    def records = ret.declareNamespace(
            soap: 'http://schemas.xmlsoap.org/soap/envelope/',
            xsi: 'http://www.w3.org/2001/XMLSchema-instance',
            xsd: 'http://www.w3.org/2001/XMLSchema',
            msdata: 'urn:schemas-microsoft-com:xml-msdata',
            diffgr: 'urn:schemas-microsoft-com:xml-diffgram-v1'
    )


    for(tab in records.'soap:Body'.'*:SiteSearchByPostalCodeResponse'.'*:SiteSearchByPostalCodeResult'.'*:diffgram'.NewDataSet.'*:Table') {
      StorageSite site = StorageSite.findByFeedAndSourceId(siteLink as Feed, tab.SiteID.text())
      if (site) {
        getTaxes(siteLink, site)
        site.save()
      }
    }
  }

  def createProration(siteLink) {
    PrintWriter writer = new PrintWriter(System.out)
    for (site in siteLink.sites) {
      addProration(siteLink, site, writer)
    }
  }

  def createSiteUser(site, email, realName, manager) {
    def user = User.findByEmail(email)

    if (!email || email.size() == 0) return
    
    if (!realName || realName.size() == 0) realName = email

    if (!user) {
      user = new User(
        username:email,
        password: (Math.random() * System.currentTimeMillis()) as String,
        description: "Site Manager for ${site.title}",
        email: email,
        userRealName: realName,
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

  def getSiteDetails(siteLink, site, tab, stats, newSite, writer) {
    def address = tab.sSiteAddr1.text() + ' ' + tab.sSiteAddr2.text() + ', ' + tab.sSiteCity.text() + ', ' + tab.sSiteRegion.text() + ' ' + tab.sSitePostalCode.text()

    writer << "Found address: ${address}"
    def geoResult = geocodeService.geocode(address)

    site.lng = geoResult.results[0].geometry.location.lng
    site.lat = geoResult.results[0].geometry.location.lat

    site.sourceId = tab.SiteID.text()
    site.sourceLoc = tab.sLocationCode.text()
    site.source = "SL"
    site.title = tab.sSiteName.text().replace('/', '-')
    site.address = tab.sSiteAddr1.text()
    site.address2 = tab.sSiteAddr2.text()
    site.city = tab.sSiteCity.text()
    site.state = State.fromText(tab.sSiteRegion.text())
    site.zipcode = tab.sSitePostalCode.text()
    site.phone = tab.sSitePhone.text()
    site.requiresInsurance = false
    site.boxesAvailable = true
    site.freeTruck = TruckType.NONE
    site.isGate = false
    site.isKeypad = false
    site.isCamera = false
    site.isUnitAlarmed = false
    site.isManagerOnsite = false
    site.hasElevator = false
    site.disabled = false
    site.netCommission = false
    site.transactionType = TransactionType.RENTAL
    site.minInventory = 0

    site.openMonday =  site.openTuesday = site.openWednesday = site.openThursday = site.openFriday = !(tab.bClosedWeekdays.text().toLowerCase() == 'true')
    site.openSaturday = !(tab.bClosedSaturday.text().toLowerCase() == 'true')
    site.openSunday = !(tab.bClosedSunday.text().toLowerCase() == 'true')

    def sWeekdayStart = tab.dWeekdayStrt.text()
    def sWeekdayEnd = tab.dWeekdayEnd.text()
    def sSaturdayStart = tab.dSaturdayStrt.text()
    def sSaturdayEnd = tab.dSaturdayEnd.text()
    def sSundayStart = tab.dSundayStrt.text()
    def sSundayEnd = tab.dSundayEnd.text()

    def dateString
    def formatString
    if (sWeekdayStart.size() > 3) {
      dateString = sWeekdayStart.substring(0, sWeekdayStart.length() - 3) + '00'
      formatString = "yyyy-MM-dd'T'HH:mm:ssZ"
      if (dateString ==~ /\d{4}-\d{2}-\d{2}T\d{2}:\d{2}:\d{2}\.\d{1,3}-\d{4}/) {
        formatString = "yyyy-MM-dd'T'HH:mm:ss.SSSZ"
      }
      site.startSundayGate = site.startMondayGate = site.startTuesdayGate = site.startWednesdayGate = site.startThursdayGate = site.startFridayGate = site.startSaturdayGate = site.startMonday = site.startTuesday = site.startWednesday = site.startThursday = site.startFriday = sWeekdayStart.length() > 0 ? Date.parse(formatString, sWeekdayStart.substring(0, sWeekdayStart.length() - 3) + '00') : null
      site.endSundayGate = site.endMondayGate = site.endTuesdayGate = site.endWednesdayGate = site.endThursdayGate = site.endFridayGate = site.endSaturdayGate = site.endMonday = site.endTuesday = site.endWednesday = site.endThursday = site.endFriday = sWeekdayEnd.length() > 0 ? Date.parse(formatString, sWeekdayEnd.substring(0, sWeekdayEnd.length() - 3) + '00') : null
    }

    if (sSaturdayStart.size() > 3) {
      dateString = sSaturdayStart.substring(0, sSaturdayStart.length() - 3) + '00'
      formatString = "yyyy-MM-dd'T'HH:mm:ssZ"
      if (dateString ==~ /\d{4}-\d{2}-\d{2}T\d{2}:\d{2}:\d{2}\.\d{1,3}-\d{4}/) {
        formatString = "yyyy-MM-dd'T'HH:mm:ss.SSSZ"
      }
      site.startSaturday = sSaturdayStart.length() > 0 ? Date.parse(formatString, sSaturdayStart.substring(0, sSaturdayStart.length() - 3) + '00') : null
      site.endSaturday = sSaturdayEnd.length() > 0 ? Date.parse(formatString, sSaturdayEnd.substring(0, sSaturdayEnd.length() - 3) + '00') : null
    }

    if (sSundayStart.size() > 3) {
      dateString = sSundayStart.substring(0, sSundayStart.length() - 3) + '00'
      formatString = "yyyy-MM-dd'T'HH:mm:ssZ"
      if (dateString ==~ /\d{4}-\d{2}-\d{2}T\d{2}:\d{2}:\d{2}\.\d{1,3}-\d{4}/) {
        formatString = "yyyy-MM-dd'T'HH:mm:ss.SSSZ"
      }
      site.startSunday = sSundayStart.length() > 0 ? Date.parse(formatString, sSundayStart.substring(0, sSundayStart.length() - 3) + '00') : null
      site.endSunday = sSundayEnd.length() > 0 ? Date.parse(formatString, sSundayEnd.substring(0, sSundayEnd.length() - 3) + '00') : null
    }

    site.extendedHours = false
    site.feed = siteLink

    site.save()

    def email = tab.sEmailAddress.text().toLowerCase()
    def realName = tab.sContactName.text()
    createSiteUser(site, email, realName, siteLink.manager)

    if (newSite) {
      SiteUser.link(site, siteLink.manager)
    }

    unitsAvailable(siteLink, site, stats, newSite, writer)

    site.requiresInsurance = loadInsurance(siteLink, site)
    if (site.units?.size() > 0) {
      def fees = adminFees(siteLink, site.units.asList().get(0).unitNumber, site)
      site.adminFee = fees["admin"] ? fees["admin"] : 0
      site.deposit = fees["deposit"] ? fees["deposit"] : 0 
    }
    getPromos(siteLink, site, writer)
    addProration(siteLink, site, writer)
    getTaxes(siteLink, site)
    site.save(flush: true)
  }

  def updateSite(site, stats, writer) {
    def siteLink = (SiteLink)site.feed
    def ret = getSiteInfo(siteLink.corpCode, site.sourceLoc, siteLink.userName, siteLink.password)
    def records = ret.declareNamespace(
            soap: 'http://schemas.xmlsoap.org/soap/envelope/',
            xsi: 'http://www.w3.org/2001/XMLSchema-instance',
            xsd: 'http://www.w3.org/2001/XMLSchema',
            msdata: 'urn:schemas-microsoft-com:xml-msdata',
            diffgr: 'urn:schemas-microsoft-com:xml-diffgram-v1'
    )
    records.'soap:Body'.'*:SiteInformationResponse'.'*:SiteInformationResult'.'*:diffgram'.NewDataSet.'*:Table'.each {tab ->
      site.specialOffers.each {offer ->
        offer.delete()
      }
      site.specialOffers.clear()
      site.lastUpdate = 0
      site.save(flush: true)
      getSiteDetails(siteLink, site, tab, stats, false, writer)
    }

  }

  def addPhones(siteLink, site, writer) {
    def ret = getSiteInfo(siteLink.corpCode, site.sourceLoc, siteLink.userName, siteLink.password)
    def records = ret.declareNamespace(
            soap: 'http://schemas.xmlsoap.org/soap/envelope/',
            xsi: 'http://www.w3.org/2001/XMLSchema-instance',
            xsd: 'http://www.w3.org/2001/XMLSchema',
            msdata: 'urn:schemas-microsoft-com:xml-msdata',
            diffgr: 'urn:schemas-microsoft-com:xml-diffgram-v1'
    )
    for (tab in records.'soap:Body'.'*:SiteInformationResponse'.'*:SiteInformationResult'.'*:diffgram'.NewDataSet.'*:Table') {
      if (!site.phone) {
        site.phone = tab.sSitePhone.text()
        writer.println "Updated site ${site.title } phone ${site.phone}"
        site.save()
      }
    }
  }

  def addProration(siteLink, site, writer) {
    def ret = getProrationInformation(siteLink.corpCode, site.sourceLoc, siteLink.userName, siteLink.password)
    def records = ret.declareNamespace(
            soap: 'http://schemas.xmlsoap.org/soap/envelope/',
            xsi: 'http://www.w3.org/2001/XMLSchema-instance',
            xsd: 'http://www.w3.org/2001/XMLSchema',
            msdata: 'urn:schemas-microsoft-com:xml-msdata',
            diffgr: 'urn:schemas-microsoft-com:xml-diffgram-v1'
    )
    for (prorate in records.'soap:Body'.'*:ProrationInformationRetrieveResponse'.'*:ProrationInformationRetrieveResult'.'*:diffgram'.NewDataSet.'*:Table') {
      site.prorateSecondMonth = prorate.b2ndMonthProrate.text().toLowerCase() == 'true'
      site.prorateStart = prorate.iDayStrtProrating.text() as Integer
      site.prorateCutoff = prorate.iDayStrtProratePlusNext.text() as Integer
      site.save(flush:true)
      writer.println "Added proration 2nd Month = ${site.prorateSecondMonth}, start = ${site.prorateStart}, cutoff = ${site.prorateCutoff}"
    }
  }

  def updateUnits(site, stats, writer) {
    def siteLink = (SiteLink)site.feed
    unitsAvailable(siteLink, site, stats, false, writer)
    site.save(flush: true)
  }

  def getUnitTypeCounts(siteLink, site, writer) {
    def unitTypeLookup = [:]

    def ret = getUnitTypePriceList(siteLink.corpCode, site.sourceLoc, siteLink.userName, siteLink.password)

    def records = ret.declareNamespace(
            soap: 'http://schemas.xmlsoap.org/soap/envelope/',
            xsi: 'http://www.w3.org/2001/XMLSchema-instance',
            xsd: 'http://www.w3.org/2001/XMLSchema',
            msdata: 'urn:schemas-microsoft-com:xml-msdata',
            diffgr: 'urn:schemas-microsoft-com:xml-diffgram-v1'
    )

    for (unitType in records.'soap:Body'.'*:UnitTypePriceListResponse'.'*:UnitTypePriceListResult'.'*:diffgram'.NewDataSet.'*:Table') {
      String key = "${unitType.UnitTypeID.text()}:${unitType.dcWidth.text()}X${unitType.dcLength.text()}${unitType.bClimate.text()}"
      unitTypeLookup[key] = unitType.iTotalUnits.text() as Integer
      writer.println "Unit Type: ${key} has ${unitType.iTotalUnits.text()} units"
    }
    return unitTypeLookup
  }

  def unitsAvailable(siteLink, site, stats, newSite, writer) {
    writer.println "Getting units available for site: " + site.title + " last update ticks: " + site.lastUpdate

    def unitTypeTotalLookup = getUnitTypeCounts(siteLink, site, writer)

    def ret = getUnitsAvailable(siteLink.corpCode, site.sourceLoc, siteLink.userName, siteLink.password, newSite ? 0 : site.lastUpdate)
    def records = ret.declareNamespace(
            soap: 'http://schemas.xmlsoap.org/soap/envelope/',
            xsi: 'http://www.w3.org/2001/XMLSchema-instance',
            xsd: 'http://www.w3.org/2001/XMLSchema',
            msdata: 'urn:schemas-microsoft-com:xml-msdata',
            diffgr: 'urn:schemas-microsoft-com:xml-diffgram-v1'
    )

    def unitID
    for (unit in records.'soap:Body'.'*:UnitsInformationAvailableUnitsOnly_v2Response'.'*:UnitsInformationAvailableUnitsOnly_v2Result'.'*:diffgram'.NewDataSet.'*:Table') {
      boolean rented = unit.bRented.text().toLowerCase() == 'true'
      def typeName = unit.sTypeName.text()

      if (rented) {
       unitID = unit.UnitID.text()
       writer.println "Rented unit ${unitID} checking for deletion"
       def deletedUnit = site.units.find{ it.unitNumber == unitID }
       if (deletedUnit) {
         site.removeFromUnits(deletedUnit)
         stats.removedCount++
       }

      } else {
        unitID = unit.UnitID.text()
        StorageUnit existingUnit = site.units.find{ it.unitNumber == unitID }

        if (!existingUnit) {

          Double width = unit.dcWidth.text() as Double
          Double length = unit.dcLength.text() as Double

          def searchType
          def siteUnit = new StorageUnit()
          Integer unitTypeID = unit.UnitTypeID.text() as Integer
          String key = "${unitTypeID}:${unit.dcWidth.text()}X${unit.dcLength.text()}${unit.bClimate.text()}"
          siteUnit.unitTypeInfo = "${unitTypeID}:${unit.dcWidth.text()}X${unit.dcLength.text()}"
          siteUnit.totalUnits = unitTypeTotalLookup[key]
          siteUnit.unitSizeInfo = "${unit.dcWidth.text()}X${unit.dcLength.text()}"
          def unitTypeLookup = UnitTypeLookup.findByDescription(typeName)
          if (unitTypeLookup) {
            searchType = unitTypeLookup.searchType
            if (unitTypeLookup.unitType != UnitType.UNDEFINED) {
              siteUnit.unitType = unitTypeLookup.unitType
              siteUnit.isTempControlled = unitTypeLookup.tempControlled
            } else {
              writer.println "Skipping illegal type ${typeName}"
              continue
            }
          } else {

            writer.println "Unknown unit type description ${typeName}"

            if ((typeName ==~ /(?i).*(cell|mail|slip|apartment|office|container|portable|wine|locker).*/)) continue

            def floor = unit.iFloor.text() as Integer
            if ((typeName ==~ /(?i).*(parking|rv).*/)) {
              searchType = SearchType.PARKING
              siteUnit.unitType = UnitType.UNCOVERED
            } else {
              searchType = SearchType.STORAGE
              if (floor > 1 || floor == 1 && typeName ==~ /(2ND|3RD).+/) {
                siteUnit.unitType = UnitType.UPPER
              } else if ((unit.bInside.text().toLowerCase() != 'false') || typeName ==~ /(?i)main floor.*/) {
                siteUnit.unitType = UnitType.INTERIOR
              } else if (typeName ==~ /(?i).*drive.*/) {
                siteUnit.unitType = UnitType.DRIVEUP
              }
              if (!siteUnit.unitType) {
                siteUnit.unitType = UnitType.UPPER
              }
            }
          }
          siteUnit.isTempControlled = (unit.bClimate.text().toLowerCase() == 'true')
          siteUnit.unitCount = 1
          siteUnit.description = typeName
          siteUnit.unitNumber = unitID
          siteUnit.unitName = unit.sUnitName.text()
          siteUnit.price = unit.dcStdRate.text() as BigDecimal
          if (unit.dcPushRate) {
            siteUnit.pushRate = unit.dcPushRate.text() as BigDecimal
          } else {
            siteUnit.pushRate = siteUnit.price
          }
          siteUnit.isPowered = unit.bPower.text().toLowerCase() == 'true'
          siteUnit.isAvailable = true
          siteUnit.isSecure = false
          siteUnit.isAlarm = unit.bAlarm.text().toLowerCase() == 'true'
          siteUnit.isIrregular = false

          if ((width - (int)width == 0) && (length - (int)length == 0)) {
            siteUnit.displaySize = (width as Integer) + " X " + (length as Integer)
          } else {
            siteUnit.displaySize = width + " X " + length
          }

          def unitSize = unitSizeService.getUnitSize(width, length, searchType)

          if (unitSize && unitSize.id != 1 && (width != 0 && length != 0) && siteUnit.price > 0) {
            siteUnit.unitsize = unitSize
            if (!siteUnit.save()) {
              siteUnit.errors.allErrors.each { writer.println it }
            }
            stats.unitCount++;

            site.addToUnits(siteUnit)
          } else {
            if (siteUnit.price <= 0 ) {
              writer.println "Skipping unit due to price=" + siteUnit.price
            } else {
              writer.println "Skipping unit due to size: width=" + width + " length=" + length
            }
          }
        } else {
          // update pricing
          def price =  unit.dcStdRate.text() as BigDecimal
          def pushRate
          if (unit.dcPushRate.text()) {
            pushRate = unit.dcPushRate.text() as BigDecimal
          } else {
            pushRate = price
          }
          if (existingUnit.price != price || existingUnit.pushRate != pushRate) {
            def newPrice = unit.dcStdRate.text() as BigDecimal
            def newPushRate = unit.dcPushRate.text() as BigDecimal
            if (newPrice == 0 || newPushRate == 0) {
              // remove unit from inventory
              site.removeFromUnits(existingUnit)
              writer.println "Removing unit from inventory - price was changed to \$0 - ${existingUnit.unitNumber}"
            } else {
              existingUnit.price = newPrice
              existingUnit.pushRate = newPushRate 
              existingUnit.save()
            }
          }
        }
      }
    }
    for (lastupdate in records.'soap:Body'.'*:UnitsInformationAvailableUnitsOnly_v2Response'.'*:UnitsInformationAvailableUnitsOnly_v2Result'.'*:diffgram'.NewDataSet.'*:Table1') {
      site.lastUpdate = lastupdate.lngLastTimePolled.text() as Long
    }
    // check admin fees
    if (!unitID && site.units.size() > 0) {
      unitID = site.units.asList().get(0).unitNumber
    }
    if (unitID) {
      def fees = adminFees(siteLink, unitID, site)
      site.adminFee = fees["admin"]
      site.deposit = fees["deposit"]
    }
  }

  def loadInsurance(Feed feed, StorageSite site) {
    SiteLink siteLink = (SiteLink)feed
    def ret = getInsurance(siteLink.corpCode, site.sourceLoc, siteLink.userName, siteLink.password)
    def records = ret.declareNamespace(
            soap: 'http://schemas.xmlsoap.org/soap/envelope/',
            xsi: 'http://www.w3.org/2001/XMLSchema-instance',
            xsd: 'http://www.w3.org/2001/XMLSchema',
            msdata: 'urn:schemas-microsoft-com:xml-msdata',
            diffgr: 'urn:schemas-microsoft-com:xml-diffgram-v1'
    )
    def count = 0;
    def siteInsurances = [:]
    site.insurances.each{ siteInsurances[it.insuranceId as Integer] = false }
    for (ins in records.'soap:Body'.'*:InsuranceCoverageRetrieveResponse'.'*:InsuranceCoverageRetrieveResult'.'*:diffgram'.NewDataSet.'*:Table') {
      def insuranceId = ins.InsurCoverageID.text() as Integer
      siteInsurances[insuranceId] = true
      def insurance = site.insurances.find{it.insuranceId == insuranceId}
      def newInsurance = false
      if (!insurance) {
        newInsurance = true
        insurance = new Insurance()
        insurance.insuranceId = insuranceId
        insurance.active = true
        count++;
      }
      insurance.totalCoverage = ins.dcCoverage.text() as BigDecimal
      insurance.premium = ins.dcPremium.text() as BigDecimal
      def pctTheft = ins.dcPCTheft.text()
      insurance.percentTheft = (pctTheft != "" ? pctTheft as BigDecimal : 0)
      insurance.provider = ins.sProvidor.text()
      insurance.save()

      if (newInsurance) {
        site.addToInsurances(insurance)
      }
    }
    for(entry in siteInsurances.entrySet()) {
      if (!entry.value) {
        def ins = site.insurances.find{(it.insuranceId as Integer) == entry.key}
        println "Cleanup found deleted type: ${entry.key} - removing ${ins.id}"
        site.removeFromInsurances(ins)
      }
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
    def adminFee = 0 as BigDecimal
    def deposit = 0 as BigDecimal
    for (fee in records.'soap:Body'.'*:MoveInCostRetrieveResponse'.'*:MoveInCostRetrieveResult'.'*:diffgram'.NewDataSet.'*:Table') {
      def chargeDescription =  fee.ChargeDescription.text().toLowerCase()
      if (chargeDescription.contains('administrative fee')) {
        adminFee = fee.dcTenantRate.text() as BigDecimal
      }
      if (chargeDescription.contains('deposit')) {
        deposit = fee.dcTenantRate.text() as BigDecimal
      }
    }
    def fees = [:]
    fees["admin"] = adminFee
    fees["deposit"] = deposit

    return fees
  }

  def getPromos(siteLink, site, writer) {
    def ret = getPromos(siteLink.corpCode, site.sourceLoc, siteLink.userName, siteLink.password)
    def records = ret.declareNamespace(
            soap: 'http://schemas.xmlsoap.org/soap/envelope/',
            xsi: 'http://www.w3.org/2001/XMLSchema-instance',
            xsd: 'http://www.w3.org/2001/XMLSchema',
            msdata: 'urn:schemas-microsoft-com:xml-msdata',
            diffgr: 'urn:schemas-microsoft-com:xml-diffgram-v1'
    )

    def concessionIds = []
    for (promo in records.'soap:Body'.'*:PromotionsRetrieveResponse'.'*:PromotionsRetrieveResult'.'*:diffgram'.NewDataSet.'*:ConcessionPlans') {
      def showOn = Integer.parseInt(promo.iShowOn.text())
      def promoName = promo.sPlanName
      if ((showOn == 0 || showOn == 1) && promoName != 'Manual') {

        def concessionId = promo.ConcessionID.text() as Integer
        concessionIds.add(concessionId)
        SpecialOffer specialOffer = site.specialOffers.find{ it.concessionId == concessionId }
        boolean newOffer = false
        if (!specialOffer)  {
          specialOffer = new SpecialOffer()
          specialOffer.concessionId = concessionId
          specialOffer.active = false;
          specialOffer.featured = false;
          specialOffer.waiveAdmin = false;
          specialOffer.description = promo.sDescription.text()
          newOffer = true
        } else {
          specialOffer.restrictions.clear()
          specialOffer.save(flush:true)
        }
        specialOffer.prepayMonths = promo.iPrePaidMonths.text() as Integer
        specialOffer.promoName = promoName
        specialOffer.expireMonth = Integer.parseInt(promo.iExpirMonths.text())
        specialOffer.prepay = promo.bPrepay.text().toLowerCase() == 'true'
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
        if (newOffer) {
          site.addToSpecialOffers(specialOffer)
        }
        // check restrictions
        if (promo.dcMaxOccPct && promo.dcMaxOccPct.text().isNumber()) {
          BigDecimal maxRange =  (promo.dcMaxOccPct.text() as BigDecimal)
          if (maxRange > 0) {
            SpecialOfferRestriction restriction = new SpecialOfferRestriction()
            restriction.restrictive = false
            restriction.type = SpecialOfferRestrictionType.OCCUPANCY_RATE
            restriction.minRange = 0
            restriction.maxRange = maxRange
            restriction.save(flush:true)
            specialOffer.addToRestrictions(restriction)
          }
        }
        if (promo.iExcludeIfLessThanUnitsTotal && promo.iExcludeIfLessThanUnitsTotal.text().isNumber()) {
          Integer minRange = promo.iExcludeIfLessThanUnitsTotal.text() as Integer
          if (minRange > 0) {
            SpecialOfferRestriction restriction = new SpecialOfferRestriction()
            restriction.restrictive = false
            restriction.type = SpecialOfferRestrictionType.MINIMUM_AVAILABLE
            restriction.minRange = minRange
            restriction.maxRange = 1000
            restriction.save(flush:true)
            specialOffer.addToRestrictions(restriction)
          }
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
    for (unitRestriction in records.'soap:Body'.'*:PromotionsRetrieveResponse'.'*:PromotionsRetrieveResult'.'*:diffgram'.NewDataSet.'*:ConcessionUnitTypes') {
      SpecialOffer specialOffer = SpecialOffer.findByConcessionId(unitRestriction.ConcessionID.text() as Integer)
      if (specialOffer) {
        // add unit type
        def restriction = new SpecialOfferRestriction()
        restriction.restrictive = false
        restriction.type = SpecialOfferRestrictionType.UNIT_TYPE
        restriction.restrictionInfo = "${unitRestriction.UnitTypeID.text()}:${unitRestriction.dcWidth.text()}X${unitRestriction.dcLength.text()}"
        restriction.save(flush:true)
        specialOffer.addToRestrictions(restriction)
        // add size type
        restriction = new SpecialOfferRestriction()
        restriction.restrictive = false
        restriction.type = SpecialOfferRestrictionType.UNIT_SIZE
        restriction.restrictionInfo = unitRestriction.dcWidth.text() + "X" + unitRestriction.dcLength.text()
        restriction.save(flush:true)
        specialOffer.addToRestrictions(restriction)
      }
    }    
  }

  def getTaxes(siteLink, site) {
    def ret = getTaxRate(siteLink.corpCode, site.sourceLoc, siteLink.userName, siteLink.password)
    def records = ret.declareNamespace(
            soap: 'http://schemas.xmlsoap.org/soap/envelope/',
            xsi: 'http://www.w3.org/2001/XMLSchema-instance',
            xsd: 'http://www.w3.org/2001/XMLSchema',
            msdata: 'urn:schemas-microsoft-com:xml-msdata',
            diffgr: 'urn:schemas-microsoft-com:xml-diffgram-v1'
    )

    for(rateSet in records.'soap:Body'.'*:RentTaxRatesRetrieveResponse'.'*:RentTaxRatesRetrieveResult'.'*:diffgram'.NewDataSet.'*:Table') {
      site.taxRateRental = rateSet.dcTax1Rate.text() as BigDecimal
      site.taxRateInsurance = rateSet.dcTax2Rate.text() as BigDecimal
      site.taxRateMerchandise = 0;
    }
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
    def siteLink = (SiteLink)rentalTransaction.site.feed
    def ret = getUnitInfoByName(siteLink, rentalTransaction.site.sourceLoc, rentalTransaction.unitId)

    println "checkRented ret =${ret}"

    def records = ret.declareNamespace(
            soap: 'http://schemas.xmlsoap.org/soap/envelope/',
            xsi: 'http://www.w3.org/2001/XMLSchema-instance',
            xsd: 'http://www.w3.org/2001/XMLSchema',
            msdata: 'urn:schemas-microsoft-com:xml-msdata',
            diffgr: 'urn:schemas-microsoft-com:xml-diffgram-v1'
    )
    def rented = false
    records.'soap:Body'.'*:UnitsInformationByUnitNameResponse'.'*:UnitsInformationByUnitNameResult'.'*:diffgram'.NewDataSet.'*:Table'.each {tab ->
      rented = (tab.bRented.text().toLowerCase() == 'true')
    }

    return !rented
  }

/*

TODO - evaluate whether we need this going forward

  def moveInDetail(RentalTransaction rentalTransaction) {
    StorageUnit unit = StorageUnit.get(rentalTransaction.unitId as Long)

    if (!unit) return null

    def ret = getMoveInWithDiscount(rentalTransaction, unit)

    println "moveInDetail ret =${ret}"
    
    def records = ret.declareNamespace(
            soap: 'http://schemas.xmlsoap.org/soap/envelope/',
            xsi: 'http://www.w3.org/2001/XMLSchema-instance',
            xsd: 'http://www.w3.org/2001/XMLSchema',
            msdata: 'urn:schemas-microsoft-com:xml-msdata',
            diffgr: 'urn:schemas-microsoft-com:xml-diffgram-v1'
    )
    def details = new MoveInDetails()
    for (item in records.'soap:Body'.'*:MoveInCostRetrieveWithDiscountResponse'.'*:MoveInCostRetrieveWithDiscountResult'.'*:diffgram'.NewDataSet.'*:Table') {
      def tax = item.TaxAmount.text() as BigDecimal
      def total = item.dcTotal.text() as BigDecimal
      details.items.add(new LineItem(tax: tax, amount: (total-tax), description: item.ChargeDescription.text()))
    }
    return details

  }
*/

  def moveIn(RentalTransaction rentalTransaction) {
    StorageUnit unit = StorageUnit.get(rentalTransaction.unitId as Long)
    rentalTransaction.feedUnitId = unit.unitNumber
    rentalTransaction.feedUnitNumber = unit.unitName

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
    if (moveInResult > 3) {
      rentalTransaction.idNumber = moveInResult
      rentalTransaction.save(flush:true)
    } else {
      def body = getMoveInPayload(rentalTransaction)
      moveInResult = new Date().format('yyyyMMdd') + sprintf('%08d', rentalTransaction.id)
      rentalTransaction.idNumber = moveInResult
      rentalTransaction.save(flush:true)

      try {
        emailService.sendTextEmail(
                to: "notifications@storitz.com",
                from: "no-reply@storitz.com",
                subject: "SITELINK - failed move-in",
                body: body)

        } catch (Exception e) {
            log.error("${e}", e)
        }
    }

    // TODO - fix when Sitelink corrects issue
    return true
  }

  def postMoveInCredit(RentalTransaction rentalTransaction) {
    if (rentalTransaction.feedMoveInCost < rentalTransaction.cost) {

      // TODO - create the delta payment for the transaction here
      // post to the account after move-in
    }
  }

}
