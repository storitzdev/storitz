package storitz

import com.centershift.store40.*
import com.storitz.*
import storitz.constants.*
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.text.ParseException
import org.grails.mail.MailService
import javax.xml.datatype.XMLGregorianCalendar
import javax.xml.datatype.DatatypeFactory

class CShift4StorageFeedService extends BaseProviderStorageFeedService {

  def geocodeService
  def unitSizeService
  def mailService

  // required for script services
  MailService getMailService() {
    if (!mailService) {
      log.info ("mailService is null: instantiating")
      mailService = new MailService()
    }
    return mailService;
  }

  UnitSizeService getUnitSizeService() {
      if (!unitSizeService) {
          log.info ("unitSizeService is null: instantiating")
          unitSizeService = new UnitSizeService()
      }
      return unitSizeService
  }

  GeocodeService getGeocodeService() {
      if (!geocodeService) {
          log.info ("geocodeService is null: instantiating")
          geocodeService = new GeocodeService()
      }
      return geocodeService
  }

  def proxy = [:]

  private WSSoap getProxy(CenterShift cshift) {
    if (!proxy[cshift.location?.webUrl]) {
      if (cshift.location) {
        def cshiftWS = new WS(new URL(cshift.location.webUrl))
        proxy[cshift.location.webUrl] = cshiftWS.getWSSoap()
      } else {
        def cshiftWS = new WS()
        return cshiftWS.getWSSoap()
      }
    }
    return proxy[cshift.location?.webUrl]
  }

  def getLookupUser(CenterShift cshift) {
    def lookupUser = new LookupUserRequest()
    lookupUser.username = cshift.userName
    lookupUser.password = cshift.pin
    lookupUser.channel = 0
    return lookupUser
  }

  @Override
  void refreshSites(Feed feed, String source, SiteStats stats, PrintWriter writer) {
    def cshift = (CenterShift)feed
    loadSites(cshift, stats, writer)
  }

  @Override
  public void updateSite(StorageSite storageSiteInstance, SiteStats stats, PrintWriter writer) {
    def cshift = (CenterShift)storageSiteInstance.feed
    WSSoap myProxy = getProxy(cshift)

    // grab site details
    GetSiteDetailsRequest detailsReq = new GetSiteDetailsRequest()
    detailsReq.setSiteID(new ArrayOfLong())
    detailsReq.siteID.getLong().add(new Long(storageSiteInstance.sourceId))
    def lookupUser = getLookupUser(cshift)
    def siteDetails = myProxy.getSiteDetails(lookupUser, detailsReq)

    def siteDetail = siteDetails.details.soasiteattributes[0]

    if (siteDetail.PHONE)
      storageSiteInstance.phone=siteDetail.PHONE

    // Update geo-code
    def address = storageSiteInstance.address + ', ' + storageSiteInstance.city + ', ' + storageSiteInstance.state.display + ' ' + storageSiteInstance.zipcode
    log.info "Found address: ${address}"
    def geoResult = getGeocodeService().geocode(address)
    storageSiteInstance.lng = geoResult.results[0].geometry.location.lng
    storageSiteInstance.lat = geoResult.results[0].geometry.location.lat

    def sitehours = siteDetail.sitehours
    def gatehours = siteDetail.gatehours?.toLowerCase()

    def hm = sitehours =~ /Monday:\s*(.+?)\s*Tuesday:\s*(.+?)\s*Wednesday:\s*(.+?)\s*Thursday:\s*(.+?)\s*Friday:\s*(.+?)\s*Saturday:\s*(.+?)\s*Sunday:\s*(.+)/
    if (hm.getCount()) {

      ["Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"].eachWithIndex {
        day, i ->
        def hrs = hm[0][i + 1].toUpperCase()
        def open = "open${day}"
        def start = "start${day}"
        def end = "end${day}"
        if (hrs == "CLOSED") {
          storageSiteInstance."$open" = false
        } else {
          storageSiteInstance."$open" = true
          storageSiteInstance."$start" = getStartTime(hrs)
          storageSiteInstance."$end" = getEndTime(hrs)
        }
      }
    } else {
      hm = sitehours =~ /Monday\s*\w+?\s*Friday\s*(.+?)\s*Saturday:\s*(.+?)\s*Sunday:\s*(.+)/
      if (hm.getCount()) {
        log.info "Monday - Friday match"
        ["Monday", "Tuesday", "Wednesday", "Thursday", "Friday"].each { day ->
          def hrs = hm[0][1].toUpperCase()
          def open = "open${day}"
          def start = "start${day}"
          def end = "end${day}"
          storageSiteInstance."$open" = true
          storageSiteInstance."$start" = getStartTime(hrs)
          storageSiteInstance."$end" = getEndTime(hrs)
        }
        ["Saturday", "Sunday"].eachWithIndex { day, i ->
          def hrs = hm[0][i + 2].toUpperCase()
          def open = "open${day}"
          def start = "start${day}"
          def end = "end${day}"
          if (hrs == "CLOSED") {
            storageSiteInstance."$open" = false
          } else {
            storageSiteInstance."$open" = true
            storageSiteInstance."$start" = getStartTime(hrs)
            storageSiteInstance."$end" = getEndTime(hrs)
          }
        }
      }
    }
    if (gatehours == "24 hours") {
      def start = Date.parse("hh:mma", "12:00am")
      def end = Date.parse("hh:mma", "11:59pm")
      storageSiteInstance.startMondayGate = storageSiteInstance.startTuesdayGate = storageSiteInstance.startWednesdayGate = storageSiteInstance.startThursdayGate = storageSiteInstance.startFridayGate = storageSiteInstance.startSaturdayGate = storageSiteInstance.startSundayGate = start
      storageSiteInstance.endMondayGate = storageSiteInstance.endTuesdayGate = storageSiteInstance.endWednesdayGate = storageSiteInstance.endThursdayGate = storageSiteInstance.endFridayGate = storageSiteInstance.endSaturdayGate = storageSiteInstance.endSundayGate = end
    } else {
      def gm = gatehours =~ /(.+?)\s+\w+?\s+(.+)/
      if (gm.getCount()) {
        def start = Date.parse("hh:mma", gm[0][1].toUpperCase())
        def end = Date.parse("hh:mma", gm[0][2].toUpperCase())
        storageSiteInstance.startMondayGate = storageSiteInstance.startTuesdayGate = storageSiteInstance.startWednesdayGate = storageSiteInstance.startThursdayGate = storageSiteInstance.startFridayGate = storageSiteInstance.startSaturdayGate = storageSiteInstance.startSundayGate = start
        storageSiteInstance.endMondayGate = storageSiteInstance.endTuesdayGate = storageSiteInstance.endWednesdayGate = storageSiteInstance.endThursdayGate = storageSiteInstance.endFridayGate = storageSiteInstance.endSaturdayGate = storageSiteInstance.endSundayGate = end
      }
    }

    GetBaseFeesRequest siteFeesRequest = new GetBaseFeesRequest()
    siteFeesRequest.siteID = new Long(storageSiteInstance.sourceId)
    def siteFees = myProxy.getBaseFees(lookupUser, siteFeesRequest)

    for (siteFee in siteFees.details.orgfeesiteall) {
      if (siteFee.feename == "Admin Fee") {
        storageSiteInstance.adminFee = siteFee.feeamt
        log.info "Found admin fee = ${storageSiteInstance.adminFee}"
        break
      }
    }

    // check deposits
    GetAvailableDepositsRequest depositRequest = new GetAvailableDepositsRequest()
    depositRequest.orgID = cshift.orgId
    def depositFees = myProxy.getAvailableDeposits(lookupUser, depositRequest)

    storageSiteInstance.deposit = 0
    for (depositFee in depositFees.details.orgsecuritydeposits) {
      if (depositFee.deptypeval == "Security" && depositFee.active && depositFee.depfix && depositFee.deptype == 1 && storageSiteInstance.deposit == 0) {
        storageSiteInstance.deposit = depositFee.depfix
        log.info "Found deposit fee = ${storageSiteInstance.deposit}"
        break
      }
    }

    GetAvailableServicesRequest availSvcReq = new GetAvailableServicesRequest()
    availSvcReq.siteID = new Long(storageSiteInstance.sourceId)
    def availSvcs = myProxy.getAvailableServices(lookupUser, availSvcReq)
    for (svc in availSvcs.details.orgservicesiteofferings) {
      if (svc.servicetypeval == "24 Hour Access") {
        storageSiteInstance.extendedHours = true
        storageSiteInstance.isTwentyFourHour = true
        log.info "Found 24 hr access"
      }
    }


    storageSiteInstance.save(flush: true)
    if (siteDetail.emailaddress) {
      createSiteUser(storageSiteInstance, siteDetail.emailaddress, null, cshift.manager)
    }

    loadInsurance(cshift, storageSiteInstance)
    updateUnits(storageSiteInstance, stats, writer)

    Date now = new Date()
    storageSiteInstance.lastChange = now
    storageSiteInstance.lastUpdate = now.time
    storageSiteInstance.save(flush: true)
  }

  def loadSites(CenterShift cshift, SiteStats stats, PrintWriter writer) {
    WSSoap myProxy = getProxy(cshift)
    def siteListRequest = new GetSiteListRequest()
    siteListRequest.orgID = cshift.orgId

    def lookupUser = getLookupUser(cshift)
    def siteList = myProxy.getSiteList(lookupUser, siteListRequest)

    for (site in siteList.details.soagetsitelist) {
      StorageSite csite = StorageSite.findBySourceAndSourceId("CS4", site.siteid)
      if (!csite) {
        csite = new StorageSite()
        csite.source = "CS4"
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
        csite.lng = 0  // will set in updateSite
        csite.lat = 0  // will set in updateSite
        csite.transactionType = TransactionType.RENTAL

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

        // TODO get taxes
        csite.taxRateInsurance = 0
        csite.taxRateRental = 0
        csite.taxRateMerchandise = 0

        csite.lastUpdate = 0
        stats.createCount++
        csite.save()
        SiteUser.link(csite, cshift.manager)
      }
      // Update will also save site
      if (csite)
        updateSite(csite, stats, writer)

    }
  }

  @Override
  def loadInsurance(Feed feed, StorageSite site) {
    CenterShift cshift = (CenterShift) feed
    def myProxy = getProxy(cshift)
    GetInsuranceProvidersRequest insuranceRequest = new GetInsuranceProvidersRequest()
    insuranceRequest.siteID = site.sourceId as Long
    insuranceRequest.orgID = cshift.orgId
    def lookupUser = getLookupUser(cshift)
    def insuranceProviders = myProxy.getInsuranceProviders(lookupUser, insuranceRequest)
    for (ins in insuranceProviders.details.orginssiteofferings) {
      log.info "Found insurance ${ins.dump()}"
      Insurance siteIns = site.insurances.find { it.insuranceId == ins.insoptionid }
      boolean newIns = false
      if (!siteIns) {
        siteIns = new Insurance()
        siteIns.insuranceId = ins.insoptionid
        siteIns.active = true
        newIns = true
      }
      siteIns.percentTheft = ins.coverageperc / 100
      siteIns.provider = ins.providername
      siteIns.premium = ins.rate
      siteIns.totalCoverage = ins.coverageamount
      siteIns.save(flush: true)
      if (newIns) {
        site.addToInsurances(siteIns)
      }
    }
    def deleteList = []
    for (ins in site.insurances) {
      if (!insuranceProviders.details.orginssiteofferings.find { it.insoptionid == ins.insuranceId }) {
        deleteList.add(ins)
      }
    }
    for (ins in deleteList) {
      log.info("Removing stale insurance from site ${site.title}: ${ins.dump()}")
      site.removeFromInsurances(ins)
    }
  }

  @Override
  public void updateUnits(StorageSite site, SiteStats stats, PrintWriter writer) {
    zeroOutUnitsForSite(site,stats,writer)

    def unitList = []

    CenterShift cshift = (CenterShift) site.feed
    def myProxy = getProxy(cshift)

    GetSiteUnitDataRequest siteUnitDataReq = new GetSiteUnitDataRequest()
    siteUnitDataReq.siteID = site.sourceId as Long
    siteUnitDataReq.getPromoData = false
    def lookupUser = getLookupUser(cshift)
    def siteUnitData = myProxy.getSiteUnitData(lookupUser, siteUnitDataReq)
    for (unit in siteUnitData.details.siteUnitData) {

      // check unit size for valid
      BigDecimal width = unit.width
      BigDecimal length = unit.depth
      SearchType searchType = SearchType.STORAGE
      def isTempControlled = false
      def unitType = UnitType.UPPER

      if (width == 0 && length > 10) {
        searchType = SearchType.PARKING
        width = 10
      }
      if (length == 0 && width > 10) {
        searchType = SearchType.PARKING
        length = width
        width = 10
      }
      if (unit.featuresval) {
        def features = unit.featuresval.split(',')
        for (feature in features) {
          switch (feature.toLowerCase()) {
            case 'parking':
              searchType = SearchType.PARKING
              unitType = UnitType.UNCOVERED
              break

            case 'a/c':
              isTempControlled = true
              break

            case 'indoor':
              unitType = UnitType.INTERIOR
              break

            case 'exterior':
              unitType = UnitType.DRIVEUP
              break
          }
        }
      }
      StorageSize storageSize = getUnitSizeService().getUnitSize(width, length, searchType)
      if (storageSize) {
        unitList.add(unit.unitid)
        StorageUnit myUnit = site.units.find {(it.unitNumber as BigDecimal) == unit.unitid}
        if (!myUnit) {
          myUnit = new StorageUnit()
          myUnit.site = site;
          myUnit.unitName = unit.unitnumber
          myUnit.unitNumber = unit.unitid
          myUnit.price = unit.maxrentrate
          myUnit.pushRate = unit.currentrate
          myUnit.displaySize = myUnit.unitSizeInfo = "${width} X ${length}"
          myUnit.unitInfo = ""    // TODO understand promo governors
          myUnit.unitTypeInfo = unit.unitid
          myUnit.unitsize = storageSize
          myUnit.unitType = unitType
          myUnit.totalUnits = unit.quantity
          myUnit.unitCount = unit.available
          myUnit.cs4Version = unit.version

          // TODO grab attributes
          myUnit.isAlarm = false
          myUnit.isIrregular = false
          myUnit.isPowered = false
          myUnit.isAvailable = true
          myUnit.isSecure = false
          myUnit.isTempControlled = isTempControlled

          stats.unitCount += unit.available
          stats.createCount++

        } else {
          myUnit.totalUnits = unit.quantity
          myUnit.unitCount = unit.available
          myUnit.price = unit.maxrentrate
          myUnit.pushRate = unit.currentrate
          myUnit.cs4Version = unit.version
          stats.unitCount += unit.available
          stats.updateCount++
          stats.removedCount--
        }

        myUnit.save(flush: true)
      } else {
        log.info "Skipping unit due to size width: ${width}, length: ${length} features: ${unit.featuresval}"
      }
    }
    // Loop through and remove old units
    def deleteList = []
    for (unit in site.units) {
      if (!(unitList.contains(unit.unitNumber as BigDecimal))) {
        log.info "Added unit for deletion: ${unit.unitNumber}"
        deleteList.add(unit)
      }
    }

    for (unit in deleteList) {
      stats.removedCount++
      unit.unitCount = 0;
      unit.save(flush:true);
    }
    if (deleteList.size() > 0) {
      site.save(flush: true)
    }

    loadPromos(site, writer)

    updateBestUnitPrice (site)
  }

  @Override
  public void loadPromos(StorageSite site, PrintWriter writer) {
    CenterShift cshift = (CenterShift)site.feed;
    def myProxy = getProxy(cshift)

    Long siteID = site.sourceId as Long
    def concessionIds = []
    def unitIds = []
    for (unit in site.units) {
      GetAvailableDiscountsRequest discReq = new GetAvailableDiscountsRequest()
      discReq.orgID = cshift.orgId
      discReq.siteID = siteID
      discReq.unitID = unit.unitNumber as Long
      //discReq.rentalID = null // This value is only required if this is an existing rental
      def lookupUser = getLookupUser(cshift)
      def discountList = myProxy.getAvailableDiscounts(lookupUser, discReq)
      for (discount in discountList.details?.applbestpcd) {
        log.info "Processing discount: ${discount.dump()}"
        concessionIds << discount.pcdid
        unitIds << discReq.unitID

        def offer = site.specialOffers.find {discount.pcdid == it.concessionId}
        if (!offer) {
          offer = new SpecialOffer()
          offer.site = site
          offer.concessionId = discount.pcdid
          if (!offer.promoName) offer.promoName = discount.pcdname
          offer.description = discount.pcddesc
          offer.featured = false
        }
        else {
          offer.deleteRestrictions();
        }
        offer.active = true
        offer.startDate = discount.starts?.toGregorianCalendar()?.getTime()
        offer.endDate = discount.expires?.toGregorianCalendar()?.getTime()
        log.info "Processing offer: ${discount.dump()}"
        switch (discount.amttype) {
          case 1:
            offer.promoType = PromoType.AMOUNT_OFF
            offer.promoQty = discount.pcdamtdefault
            offer.prepayMonths = 0
            offer.inMonth = 1
            offer.expireMonth = 1
            break

          case 2:
            offer.promoType = PromoType.PERCENT_OFF
            offer.promoQty = discount.pcdamtmax
            offer.prepay = (discount.paymentrequired == 'Y')
            if (offer.prepay) {
              offer.prepayMonths = 0
              offer.expireMonth = discount.pcdperiods
              offer.inMonth = 0
            } else {
              offer.inMonth = discount.losreq ? discount.losreq : 1
              offer.prepayMonths = 0
              offer.expireMonth = 1
            }
            break

          case 3:
            offer.promoType = PromoType.FIXED_RATE
            offer.promoQty = discount.pcdamtmax
            offer.expireMonth = discount.pcdperiods
            offer.prepay = (discount.paymentrequired == 'Y')
            if (offer.prepay) {
              offer.prepayMonths = discount.losprepaid ? discount.losprepaid : 0
            } else {
              offer.prepayMonths = 0
            }
            offer.inMonth = discount.losreq ? ((discount.losreq + 1) - discount.pcdperiods) : 1
            break

          default:
            log.info "Unexpected amttype: ${discount.dump()}"
            break
        }
        if (offer.validate()) {
          offer.save(flush: true)
          log.info "Created offer: ${offer.dump()}"
          def restriction = offer.restrictions.find { (it.restrictionInfo as Long) == discReq.unitID }
          if (!restriction) {
            restriction = new SpecialOfferRestriction()
            restriction.type = SpecialOfferRestrictionType.UNIT_TYPE
            restriction.restrictionInfo = discReq.unitID
            restriction.restrictive = false
            restriction.specialOffer = offer
            restriction.save(flush: true)
          }
        } else {
          log.info "offer did not validate ${offer.dump()}"
        }
      }
    }
    deactivateDeletedOffers(site, concessionIds, CONCESSION_ID_FIELD, writer)
  }

  @Override
  public boolean isAvailable(RentalTransaction trans) {

    StorageUnit transUnit = StorageUnit.get(trans.unitId as Long)
    BigDecimal unitId = transUnit.unitNumber as BigDecimal

    CenterShift cshift = (CenterShift) trans.site.feed
    def myProxy = getProxy(cshift)

    GetSiteUnitDataRequest siteUnitDataReq = new GetSiteUnitDataRequest()
    siteUnitDataReq.siteID = trans.site.sourceId as Long
    siteUnitDataReq.getPromoData = false
    def lookupUser = getLookupUser(cshift)
    def siteUnitData = myProxy.getSiteUnitData(lookupUser, siteUnitDataReq)

    // TODO remove getquote
    GetQuoteDataRequest quoteReq = new GetQuoteDataRequest()
    quoteReq.orgID = cshift.orgId
    quoteReq.siteID = trans.site.sourceId as Long
    quoteReq.unitID = transUnit.unitNumber as BigDecimal
    if (trans.promoId > 0) {
      SpecialOffer promo = SpecialOffer.get(trans.promoId as Long)
      quoteReq.promoID = promo.concessionId
    }
    quoteReq.rentRate = trans.site.allowPushPrice ? transUnit.pushRate : transUnit.price
    def quotes = myProxy.getQuoteData(lookupUser, quoteReq)

    log.info "Quote information = ${quotes.details.dump()}"

    for (unit in siteUnitData.details.siteUnitData) {
      if (unit.unitid == unitId && unit.available > trans.site.minInventory) {
        trans.feedUnitNumber  = unitId
        trans.feedUnitId = unitId
        return true
      }
    }
    return false
  }

  // TODO
  @Override
  public void addSitePhone(StorageSite storageSiteInstance, PrintWriter writer) {

  }

  private GetAccountInfoResponse2 createTenant(RentalTransaction trans) {
    CenterShift cshift = (CenterShift) trans.site.feed
    def myProxy = getProxy(cshift)
    def lookupUser = getLookupUser(cshift)

    CreateNewAccountRequest acctReq = new CreateNewAccountRequest()
    acctReq.orgID = cshift.orgId
    acctReq.siteID = trans.site.sourceId as Long
    acctReq.firstName = trans.contactPrimary.firstName
    acctReq.lastName = trans.contactPrimary.lastName
    acctReq.accountClass = (trans.rentalUse == RentalUse.BUSINESS ? AccountClass.BUSINESS : AccountClass.PERSONAL)
    acctReq.contactType = ContactType.ACCOUNT_USER
    acctReq.email = trans.contactPrimary.email

    ContactAddress contactPrimary = new ContactAddress()
    contactPrimary.addrType = AddressType.HOME
    contactPrimary.addr1 = trans.contactPrimary.address1
    contactPrimary.addr2 = trans.contactPrimary.address2
    contactPrimary.city = trans.contactPrimary.city
    contactPrimary.state = trans.contactPrimary.state.display
    contactPrimary.postalCode = trans.contactPrimary.zipcode
    contactPrimary.country = trans.contactPrimary.country ? trans.contactPrimary.country.display : "US"
    contactPrimary.active = true

    if (!acctReq.getContactAddress()) {
      ArrayOfContactAddress arrayOfContactAddress = new ArrayOfContactAddress()
      arrayOfContactAddress.getContactAddress().add (contactPrimary)
      acctReq.setContactAddress (arrayOfContactAddress)
    }
    else {
      acctReq.getContactAddress().add(contactPrimary) // contactAddress
    }

    ACCTCONTACTPHONES phoneInfo = new ACCTCONTACTPHONES()
    phoneInfo.phonetype = (trans.contactPrimary.phoneType && trans.contactPrimary.phoneType == PhoneType.OFFICE ? 2 : 1)
    phoneInfo.phonetypeval = trans.contactPrimary.phoneType ? trans.contactPrimary.phoneType.display : PhoneType.HOME.toString()
    phoneInfo.phone = trans.contactPrimary.phone
    phoneInfo.active = true

    if (!acctReq.getContactPhone()) {
      ArrayOfACCTCONTACTPHONES arrayOfACCTCONTACTPHONES = new ArrayOfACCTCONTACTPHONES()
      arrayOfACCTCONTACTPHONES.getACCTCONTACTPHONES().add (phoneInfo)
      acctReq.setContactPhone (arrayOfACCTCONTACTPHONES)
    }
    else {
      acctReq.getContactPhone().add(phoneInfo) // contactPhone
    }

    StructCreateAccount structCreateAccount = myProxy.createNewAccount (lookupUser, acctReq)
    long accountID = structCreateAccount.accountID
    long contactID = structCreateAccount.contactID

    trans.tenantId = "${accountID}"
    trans.contactId = "${contactID}"

    if (trans.tenantId) {
      // Note: Subject limited to 30 chars
      // http://centershiftdevx.com/2011/04/29/sws-createnotes-method/
      String noteSubject = "Storitz.com Reservation"

      String noteText = StoritzGroovyUtil.getCSAccountNoteText (trans)

      CreateNotesRequest createNotesRequest = new CreateNotesRequest()
      createNotesRequest.subject = noteSubject
      createNotesRequest.note = noteText
      createNotesRequest.accountID = accountID
      try {
        myProxy.createNotes (lookupUser, createNotesRequest)
      }
      catch (Throwable t) {
        // The question is what to do now? We've already created the new tenant
        // in the system, so the bulk of the work is done. However, without
        // the note the site manager won't know that this is a storitz
        // tenant. Of course that's not totally true since they will receive
        // an email from us too. In light of this, we'll send an email to
        String stackTrace = StoritzUtil.stackTraceToString (t)
        StringBuilder sb = new StringBuilder()
        sb.append ("Note:\n")
        sb.append (noteText)
        sb.append ("\n\n")
        sb.append ("StackTrace:\n")
        sb.append (stackTrace)
        getMailService().sendMail {
          to "notifications@storitz.com"
          from "no-reply@storitz.com"
          subject "Error Attaching Note to New CS4 Tenant Record"
          body sb.toString()
        }
      }
    }

    AccountRequest accountRequest = new AccountRequest()
    accountRequest.contactID = contactID
    accountRequest.acctID = accountID
    GetAccountInfoResponse2 getAccountInfoResponse2 = myProxy.getAccountInfo (lookupUser, accountRequest)
    return getAccountInfoResponse2
  }

  private MakeReservationResponse makeReservation (RentalTransaction trans, GetAccountInfoResponse2 getAccountInfoResponse2) {
    try {
      CenterShift cshift = (CenterShift) trans.site.feed
      def myProxy = getProxy(cshift)
      def lookupUser = getLookupUser(cshift)

      StorageUnit theUnit = StorageUnit.get (trans.unitId)

      //UpdateUnitStatusRequest updateUnitStatusRequest = new UpdateUnitStatusRequest()
      //updateUnitStatusRequest.siteID = trans.site.sourceId as long; // long siteID;
      //updateUnitStatusRequest.unitID = trans.feedUnitId as long; // long unitID;
      //updateUnitStatusRequest.version = theUnit.cs4Version as BigDecimal; // BigDecimal version;
      //updateUnitStatusRequest.putOnHold = true; // boolean putOnHold;
      //UpdateUnitStatusResponse2 updateUnitStatusResponse2 = myProxy.updateUnitStatus (lookupUser, updateUnitStatusRequest)

      MakeReservationRequest makeReservationRequest = new MakeReservationRequest()
      makeReservationRequest.acctID = trans.tenantId as long; // long acctID;
      makeReservationRequest.contacts = getReservationArrayOfContact(trans, getAccountInfoResponse2) ; // ArrayOfRentalContact contacts;
      makeReservationRequest.quoteType = com.centershift.store40.QuoteTypes.HARD_RESERVATION; // QuoteTypes quoteType;
      makeReservationRequest.rentNow = false; // boolean rentNow;
      makeReservationRequest.siteID = trans.site.sourceId as long; // long siteID;
      makeReservationRequest.unitID = trans.feedUnitId as long; // long unitID;
      makeReservationRequest.version = theUnit.cs4Version
      makeReservationRequest.quoteStartDate = getReservationMoveInDate(trans, getAccountInfoResponse2); // XMLGregorianCalendar quoteStartDate;

      //makeReservationRequest.version = updateUnitStatusResponse2.newVersion; // BigDecimal version;
      //makeReservationRequest.quoteID = 0; // Long quoteID;
      //makeReservationRequest.price = trans.cost; // BigDecimal price;
      //makeReservationRequest.inquirySource = ; // Integer inquirySource;
      //makeReservationRequest.pcds = getReservationPCDS (trans, getAccountInfoResponse2); // ArrayOfTRANQUOTEPCDDETAIL pcds;
      //makeReservationRequest.overrideReservationAmount = ; // BigDecimal overrideReservationAmount;

      MakeReservationResponse makeReservationResponse = myProxy.makeReservation (lookupUser, makeReservationRequest)

      trans.reserved = true
      trans.reservationId = "${makeReservationResponse.rentalID}"
      trans.idNumber ="R${makeReservationResponse.rentalID}"

      log.info ("Successful CS4 Reservation: Rental=${makeReservationResponse.rentalID}, Quote=${makeReservationResponse.quoteID}")
      return makeReservationResponse
    }
    catch (Exception e) {
      log.info ("Error creating CS4 reservation", e)
      throw e
    }
  }

  private ArrayOfTRANQUOTEPCDDETAIL getReservationPCDS (RentalTransaction trans, GetAccountInfoResponse2 getAccountInfoResponse2) {
    CenterShift cshift = (CenterShift) trans.site.feed
    def myProxy = getProxy(cshift)
    def lookupUser = getLookupUser(cshift)

    StorageUnit theUnit = StorageUnit.get (trans.unitId)

    GetAvailableDiscountsRequest getAvailableDiscountsRequest = new GetAvailableDiscountsRequest()
    getAvailableDiscountsRequest.orgID = cshift.orgId
    getAvailableDiscountsRequest.siteID = trans.site.sourceId as long
    getAvailableDiscountsRequest.unitID = theUnit.unitNumber as Long

    GetAvailableDiscountsResponse2 getAvailableDiscountsResponse2 = myProxy.getAvailableDiscounts (lookupUser, getAvailableDiscountsRequest)
  }

  private XMLGregorianCalendar getReservationMoveInDate (RentalTransaction trans, GetAccountInfoResponse2 getAccountInfoResponse2) {
    CenterShift cshift = (CenterShift) trans.site.feed
    def myProxy = getProxy(cshift)
    def lookupUser = getLookupUser(cshift)

    GregorianCalendar gcal = new GregorianCalendar();
    gcal.time = trans.moveInDate
    XMLGregorianCalendar xgcal = DatatypeFactory.newInstance().newXMLGregorianCalendar(gcal);

    return xgcal
  }

  private ArrayOfRentalContact getReservationArrayOfContact (RentalTransaction trans, GetAccountInfoResponse2 getAccountInfoResponse2) {
    ArrayOfRentalContact arrayOfRentalContact = new ArrayOfRentalContact()

    // to make the array or rental contact, first create the rental contact
    RentalContact rentalContact = new RentalContact()
    rentalContact.contactId = trans.contactId as long
    rentalContact.addressId = getReservationAddressId (trans, getAccountInfoResponse2)
    rentalContact.phoneId = getReservationPhoneId (trans, getAccountInfoResponse2)
    //rentalContact.gateCode = getReservationGateCode (trans, getAccountInfoResponse2)
    //rentalContact.primaryFlag = true;
    arrayOfRentalContact.getRentalContact().add (rentalContact)

    return arrayOfRentalContact
  }

  private long getReservationPhoneId (RentalTransaction trans, GetAccountInfoResponse2 getAccountInfoResponse2) {
    CenterShift cshift = (CenterShift) trans.site.feed
    def myProxy = getProxy(cshift)
    def lookupUser = getLookupUser(cshift)

    AccountRequest accountRequest = new AccountRequest()
    accountRequest.contactID = trans.contactId as long
    accountRequest.acctID = trans.tenantId as long

    GetContactPhoneNumbersResponse2 getContactPhoneNumbersResponse2 = myProxy.getContactPhoneNumbers (lookupUser, accountRequest)

    return getContactPhoneNumbersResponse2.details.ACCTCONTACTPHONES.get(0).PHONEID
  }

  private String getReservationGateCode (RentalTransaction trans, GetAccountInfoResponse2 getAccountInfoResponse2) {
    CenterShift cshift = (CenterShift) trans.site.feed
    def myProxy = getProxy(cshift)
    def lookupUser = getLookupUser(cshift)

    GetGateCodeInfoRequest getGateCodeInfoRequest = new GetGateCodeInfoRequest()
    getGateCodeInfoRequest.contactID = trans.contactId as long
    getGateCodeInfoRequest.unitID = trans.feedUnitId as long

    GetGateCodeInfoResponse2 getGateCodeInfoResponse2 = myProxy.getGateCodeInfo (lookupUser, getGateCodeInfoRequest)

    return getGateCodeInfoResponse2.details.SOAGETGATEINFO.get(0).GATECODE
  }

  private long getReservationAddressId (RentalTransaction trans, GetAccountInfoResponse2 getAccountInfoResponse2) {
    CenterShift cshift = (CenterShift) trans.site.feed
    def myProxy = getProxy(cshift)
    def lookupUser = getLookupUser(cshift)

    AccountRequest accountRequest = new AccountRequest()
    accountRequest.contactID = trans.contactId as long
    accountRequest.acctID = trans.tenantId as long
    GetContactAddressesResponse2 getContactAddressesResponse2 = myProxy.getContactAddresses (lookupUser, accountRequest)
    return  getContactAddressesResponse2.details.ACCTCONTACTADDRESSES.get(0).ADDRID
  }

  @Override
  public boolean reserve(RentalTransaction trans, boolean sandboxMode) {
    return moveIn(trans, sandboxMode);
  }

  @Override
  public boolean moveIn(RentalTransaction trans, boolean sandboxMode) {
    if (sandboxMode) {
      trans.reservationId = "SANDBOX"
      trans.idNumber = "SANDBOX"
      trans.reserved = true
      return true;
    }

    GetAccountInfoResponse2 getAccountInfoResponse2 = createTenant (trans)
    MakeReservationResponse makeReservationResponse = makeReservation (trans, getAccountInfoResponse2)
  }

  private Date getStartTime(String hrs) {
    def start = (splitHours(hrs))[0].trim()
    return parseTime (start)
  }

  private Date getEndTime(String hrs) {
    def end = (splitHours(hrs))[-1].trim()
    return parseTime (end)
  }

  private String [] splitHours (String hrs) {
    return hrs.split("-")
  }

  private Date parseTime (String t) {
    ArrayList <DateFormat> df = new ArrayList<DateFormat>() // make this static?
    df.push (new SimpleDateFormat("hh:mma"));
    df.push (new SimpleDateFormat("hha"));

    Date d = null;
    for (DateFormat df1 : df) {
      try {
        d = df1.parse (t);
        break; // if the parse works, then bail 'cause we're done.
      }
      catch (ParseException pe) {
        String err = "failed to parse date string " + pe;
        log.info (err, pe);
      }
    }
    return d;
  }

  @Override
  void init(StorageSite site) {
        // nothing to do
  }
}
