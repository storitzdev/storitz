package storitz

import com.centershift.store40.*
import com.storitz.*
import storitz.constants.*

class CShift4StorageFeedService extends BaseProviderStorageFeedService {

  def geocodeService
  def unitSizeService

  // required for script services
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
    loadPromos(storageSiteInstance, writer)

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
      if (!csite && site.propertytype == 1 && (site.sitestauts == 1 | site.sitestauts == 2)) {
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
        def address = csite.address + ', ' + csite.city + ', ' + csite.state.display + ' ' + csite.zipcode
        log.info "Found address: ${address}"
        def geoResult = getGeocodeService().geocode(address)
        csite.lng = geoResult.results[0].geometry.location.lng
        csite.lat = geoResult.results[0].geometry.location.lat
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
        SiteUser.link(csite, cshift.manager)
      }
      // Update will also save site
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
      unit.save.flush(true);
    }
    if (deleteList.size() > 0) {
      site.save(flush: true)
    }
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
        } else {
          log.info "offer did not validate ${offer.dump()}"
        }
        def restriction = offer.restrictions.find { (it.restrictionInfo as Long) == discReq.unitID }
        if (!restriction && offer.validate()) {
          restriction = new SpecialOfferRestriction()
          restriction.type = SpecialOfferRestrictionType.UNIT_TYPE
          restriction.restrictionInfo = discReq.unitID
          restriction.restrictive = false
          restriction.specialOffer = offer
          restriction.save(flush: true)
          offer.save(flush: true)
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
        return true
      }
    }
    return false
  }

  // TODO
  @Override
  public void addSitePhone(StorageSite storageSiteInstance, PrintWriter writer) {

  }

  def createTenant(RentalTransaction trans) {

    CenterShift cshift = (CenterShift) trans.site.feed
    def myProxy = getProxy(cshift)

    CreateNewAccountRequest acctReq = new CreateNewAccountRequest()
    acctReq.orgID = cshift.orgId
    acctReq.siteID = trans.site.sourceId as Long
    acctReq.firstName = trans.contactPrimary.firstName
    acctReq.lastName = trans.contactPrimary.lastName
    acctReq.email = trans.contactPrimary.email
    acctReq.accountClass = (trans.rentalUse == RentalUse.BUSINESS ? AccountClass.BUSINESS : AccountClass.PERSONAL)
    acctReq.contactType = ContactType.ACCOUNT_USER

    ContactAddress contactPrimary = new ContactAddress()
    contactPrimary.addr1 = trans.contactPrimary.address1
    contactPrimary.addr2 = trans.contactPrimary.address2
    contactPrimary.active = true
    contactPrimary.addrType = AddressType.HOME
    contactPrimary.city = trans.contactPrimary.city
    contactPrimary.state = trans.contactPrimary.state.display
    contactPrimary.country = trans.contactPrimary.country.display
    contactPrimary.postalCode = trans.contactPrimary.zipcode

    ACCTCONTACTPHONES phoneInfo = new ACCTCONTACTPHONES()
    phoneInfo.phone = trans.contactPrimary.phone
    phoneInfo.phonetype = (trans.contactPrimary.phoneType == PhoneType.HOME ? 1 : 2)
    phoneInfo.phonetypeval = trans.contactPrimary.phoneType.display
    phoneInfo.active = true

    acctReq.getContactAddress().add(contactPrimary)
    acctReq.getContactPhone().add(phoneInfo)

  }

  @Override
  public boolean reserve(RentalTransaction trans, boolean sandboxMode) {
    return moveIn(trans, sandboxMode);
  }

  @Override
  public boolean moveIn(RentalTransaction trans, boolean sandboxMode) {
    createTenant(trans)
    StorageUnit transUnit = StorageUnit.get(trans.unitId as Long)

  }

  private Date getStartTime(String hrs) {
    def start = hrs.split("-")[0].trim()
    return Date.parse("hh:mma", start)
  }

  private Date getEndTime(String hrs) {
    def end = hrs.split("-")[-1].trim()
    return Date.parse("hh:mma", end)
  }

  @Override
  void init(StorageSite site) {
        // nothing to do
  }
}
