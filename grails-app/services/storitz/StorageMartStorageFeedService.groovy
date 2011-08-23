package storitz

import com.storitz.Feed
import com.storitz.StorageSite
import com.storitz.RentalTransaction
import org.tempuri.BasicHttpBinding_IAvailabilityDataStub
import org.datacontract.schemas._2004._07.StorageMart_Services.Credentials
import org.datacontract.schemas._2004._07.StorageMart_Services.FacilityOutput
import org.datacontract.schemas._2004._07.StorageMart_Services.UnitTypeOutput
import org.datacontract.schemas._2004._07.StorageMart_Services.ReservationRequest
import org.datacontract.schemas._2004._07.StorageMart_Services.FacilityHoursOutput

import org.springframework.mock.web.MockMultipartFile
import javax.xml.rpc.Service
import com.storitz.StorageMart
import com.storitz.SiteUser
import storitz.constants.State
import storitz.constants.TruckType
import storitz.constants.TransactionType
import com.storitz.StorageUnit
import com.storitz.StorageSize
import storitz.constants.SearchType
import storitz.constants.UnitType
import com.storitz.SpecialOffer
import com.storitz.SpecialOfferRestriction
import storitz.constants.SpecialOfferRestrictionType
import java.text.DateFormat
import java.text.SimpleDateFormat
import com.storitz.User
import org.springframework.web.multipart.MultipartFile
import org.grails.mail.MailService
import com.storitz.StorageMartSpecialOfferLookup

class StorageMartStorageFeedService extends BaseProviderStorageFeedService {

  static transactional = true

  def unitSizeService = new UnitSizeService()
  def fileUploadService = new FileUploadService()
  def imageService = new ImageService()
  def mailService = new MailService()

  private URL endpointURL
  private Service service
  private String userName
  private String passWord

  private def cityCount = [:] // used to help name the sites

  public StorageMartStorageFeedService (String userName, String passWord, String url) {
    this.userName = userName
    this.passWord = passWord
    this.endpointURL = new URL(url)
    this.service = new org.apache.axis.client.Service()
  }

  public StorageMartStorageFeedService () {
  }

  ////////////////////////////
  ///// OVERRIDE METHODS /////
  ////////////////////////////

  @Override
  void refreshSites(Feed feed, String source, SiteStats stats, PrintWriter writer) {
    FacilityOutput [] sites = loadFacilities()
    for (int i = 0; i < sites.size(); i++) {
      def city = sites[i].city
      if (cityCount[city])
        cityCount[city]++
      else
        cityCount[city]=1
    }

    for (int i = 0; i < sites.size(); i++) {
      StorageSite theSite = createUpdateSite (sites[i], feed.manager, source, stats, writer)
      if (theSite) {
        feed.addToSites (theSite)
        SiteUser.link (theSite, feed.manager)
      }
    }
  }

  @Override
  void updateSite(StorageSite storageSiteInstance, SiteStats stats, PrintWriter writer) {
    FacilityOutput [] sites = loadFacilities()
    FacilityOutput theSite
    for (int i = 0; i < sites.size(); i++) {
      theSite = sites[i]
      if (theSite.facility_Id.equalsIgnoreCase(storageSiteInstance.sourceId)) {
        createUpdateSite (theSite, storageSiteInstance.feed.manager, 'STM', stats, writer)
        return
      }
    }
    log.info "Unable to update site! ID=${storageSiteInstance.id} SOURCE_ID=${storageSiteInstance.sourceId}"
  }

  @Override
  void updateUnits(StorageSite storageSiteInstance, SiteStats stats, PrintWriter writer) {
    zeroOutUnitsForSite(storageSiteInstance,stats,writer)
    UnitTypeOutput [] unitTypeOutput = loadUnitTypesByFacility (storageSiteInstance.sourceId)
    for (int i = 0; i < unitTypeOutput.length; i++) {
      UnitTypeOutput theUnit = unitTypeOutput[i]
      def unit_can_store_vehicle        = theUnit.can_Store_Vehicle
      def unit_discount_price           = theUnit.discount_Price
      def unit_door_height              = theUnit.door_Height
      def unit_door_type                = theUnit.door_Type
      def unit_door_width               = theUnit.door_Width
      def unit_powered                  = theUnit.electricity
      def unit_floor                    = theUnit.floor
      def unit_has_alarm                = theUnit.has_Alarm
      def unit_drive_up                 = theUnit.has_Drive_Up_Access
      def unit_has_outdoor_access       = theUnit.has_Outdoor_Access
      def unit_height                   = theUnit.height
      def unit_is_climate_controlled    = theUnit.is_Climate_Controlled
      def unit_is_covered_parking       = theUnit.is_Covered_Parking_Spot
      def unit_is_humidity_controlled   = theUnit.is_Humidity_Controlled
      def unit_length                   = theUnit.length
      def unit_price                    = theUnit.price
      def unit_promotion                = theUnit.promotion
      def unit_promotion_long           = theUnit.promotionLongFormText
      def unit_quantity_available       = theUnit.quantity_Available
      def unit_type                     = theUnit.type
      def unit_type_id                  = theUnit.unit_Type_Id
      def unit_width                    = theUnit.width

      def unit = createUpdateUnit (storageSiteInstance
                                   ,stats
                                   ,writer
                                   ,unit_can_store_vehicle
                                   ,unit_discount_price           
                                   ,unit_door_height              
                                   ,unit_door_type                
                                   ,unit_door_width               
                                   ,unit_powered                  
                                   ,unit_floor                    
                                   ,unit_has_alarm                
                                   ,unit_drive_up                 
                                   ,unit_has_outdoor_access       
                                   ,unit_height                   
                                   ,unit_is_climate_controlled    
                                   ,unit_is_covered_parking       
                                   ,unit_is_humidity_controlled   
                                   ,unit_length                   
                                   ,unit_price                    
                                   ,unit_promotion                
                                   ,unit_promotion_long           
                                   ,unit_quantity_available       
                                   ,unit_type                     
                                   ,unit_type_id                  
                                   ,unit_width)

      if (unit) {
        loadPromoForUnit (storageSiteInstance, unit, unit_promotion_long)
      }
    }
    updateBestUnitPrice (storageSiteInstance)
  }

  @Override
  void loadPromos(StorageSite storageSiteInstance, PrintWriter writer) {
    // no-op. promos loaded during inventory update
  }

  @Override
  void addSitePhone(StorageSite storageSiteInstance, PrintWriter writer) {
    // no-op. phones loaded during site creation/refresh
  }

  @Override
  boolean isAvailable(RentalTransaction trans) {
    StorageUnit unit = StorageUnit.get (trans.unitId)
    if (!unit) {
      log.warn ("Storage Unit ${trans.unitId} not found during transaction ${trans.id}!")
      return false
    }

    // check the feed to see if this unit is available
    UnitTypeOutput [] unitTypeOutput = loadUnitTypesByFacility (trans.site.sourceId)
    for (int i = 0; i < unitTypeOutput.length; i++) {
      UnitTypeOutput theUnit = unitTypeOutput[i]
      int unitTypeId = theUnit.unit_Type_Id.intValue()
      int unitNumber = Integer.parseInt(unit.unitNumber).intValue()
      if (unitTypeId == unitNumber)
        return theUnit.quantity_Available > trans.site.minInventory
    }

    return false
  }

  @Override
  loadInsurance(Feed feed, StorageSite site) {
    return null  // no-op
  }

  @Override
  boolean moveIn(RentalTransaction trans, boolean sandboxMode) {
    // Sites are set up as rental, since we want to process the credit card for
    // payment. However, Storage Mart only exposes reserve via the API, so we
    // use that here.
    return reserve (trans, sandboxMode)
  }

  @Override
  boolean reserve(RentalTransaction trans, boolean sandboxMode) {
    try {
      StorageUnit unit = StorageUnit.get (trans.unitId)
      DateFormat df = new SimpleDateFormat("yyyy/MM/dd")
      Integer unitID = new Integer(unit.unitNumber)
      ReservationRequest request = new ReservationRequest(
          trans.contactPrimary.email     // java.lang.String customer_Email_Address
         ,trans.contactPrimary.firstName // java.lang.String customer_First_Name
         ,trans.contactPrimary.lastName  // java.lang.String customer_Last_Name
         ,trans.contactPrimary.phone     // java.lang.String customer_Phone
         ,trans.site.sourceId            // java.lang.String facility_Id
         ,df.format(trans.moveInDate)    // java.lang.String move_In_Date
         ,trans.cost                     // java.lang.Double quoted_Price
         ,unitID                         // java.lang.Integer unit_Id
      )
      Credentials creds = new Credentials(this.passWord,this.userName) // yes, password/username
      BasicHttpBinding_IAvailabilityDataStub stub = new BasicHttpBinding_IAvailabilityDataStub(this.endpointURL, this.service)

      // Sanboxmode: don't notify the operator of reservation.
      if (sandboxMode)
        trans.idNumber = "12345" // Bogus id
      else
        trans.idNumber = stub.addReservation (creds, request)

      // unitID is actually a unit-type in StorageMart, not specific unit per-se
      /* Leaving as comment pending further review
      trans.feedUnitNumber = "${unitID}"
      */
      return true
    }
    catch (Throwable t) {
      log.error ("StorageMart: Error during reserve", t)
    }
    return false
  }

  @Override
  void init(StorageSite site) {
    StorageMart storageMart = (StorageMart)site.feed
    this.userName = storageMart.stmUser
    this.passWord = storageMart.stmPass
    this.endpointURL = new URL(storageMart.url)
    this.service = new org.apache.axis.client.Service()
  }

  //////////////////////////
  ///// HELPER METHODS /////
  //////////////////////////

  StorageSite createUpdateSite (FacilityOutput theSite, User feedManager, String source, SiteStats stats, PrintWriter writer) {
    def site_id = theSite.facility_Id
    def site_name = theSite.name
    def site_desc = theSite.description
    def site_promo = theSite.promotion // used by units
    def site_promo_long = theSite.promotionLongFormText // used by units
    def site_images = []
    for (int i = 0; i < theSite.image_Urls.size(); i++) {
      site_images[i] = theSite.image_Urls[i]
    }
    def site_address = theSite.address
    def site_city = theSite.city
    def site_state = theSite.state
    def site_zip = theSite.zip
    def site_phone = theSite.phone
    def site_office_hours = []
    for (int i = 0; i < theSite.office_Hours.size(); i++) {
      site_office_hours[i] = theSite.office_Hours[i] // FacilityHoursOutput
    }
    def site_access_hours = []
    for (int i = 0; i < theSite.access_Hours.size(); i++) {
      site_access_hours[i] = theSite.access_Hours[i] // FacilityHoursOutput
    }
    def site_truck = theSite.has_Truck_Rental
    def site_free_truck = theSite.has_Free_Truck_Rental
    def site_dock = theSite.has_Loading_Dock
    def site_dock_size = theSite.loading_Dock_Size
    def site_electronic_gate = theSite.has_Electronic_Gate_Access
    def site_camera = theSite.has_Surveillance_Cameras
    def site_fenced = theSite.is_Fenced_And_Lighted
    def site_24_hr = theSite.has_24_Hour_Access
    def site_handcart = theSite.has_Handcarts
    def site_admin_fee = theSite.admin_Fee
    def site_manager_emails = []
    for (int i = 0; i < theSite.manager_Email_Address.size(); i++) {
      site_manager_emails[i] = theSite.manager_Email_Address[i]
    }

    StorageSite site = StorageSite.findBySourceAndSourceId (source,site_id)
    if (!site) {
      stats.createCount++
      site                     = new StorageSite()
      site.source              = source
      site.sourceId            = site_id
      site.sourceLoc           = site_name
      site.title               = siteTitle (site_city, site_name)
      site.description         = site_desc
      site.transactionType     = TransactionType.RENTAL

      // basic defaults
      site.boxesAvailable      = false
      site.isUnitAlarmed       = false
      site.requiresInsurance   = false
      site.extendedHours       = false
      site.isManagerOnsite     = false
      site.hasElevator         = false
      site.taxRateMerchandise  = 0
      site.taxRateInsurance    = 0
      site.taxRateRental       = 0
      site.maxReserveDays      = 30
    }
    else {
      stats.updateCount++
    }

    site.address               = site_address
    site.city                  = site_city

    // Guard against foreign states (Canada mostly)
    try {
      site.state               = State.fromText (site_state)
    }
    catch (Throwable t) {
      log.info "Cannot handle state: ${site_state}"
      return null
    }

    site.zipcode               = site_zip
    site.phone                 = site_phone
    site.freeTruck             = site_free_truck ? TruckType.FREE : site_truck ? TruckType.RENTAL : TruckType.NONE
    site.isGate                = site_fenced
    site.isKeypad              = site_electronic_gate
    site.isCamera              = site_camera
    site.isTwentyFourHour      = site_24_hr
    site.adminFee              = site_admin_fee

    setOfficeHours (site, site_office_hours)
    setAccessHours (site, site_access_hours)

    site.lastChange            = new Date()
    site.lastUpdate            = site.lastChange.time

    geoCodeSite (site)

    updateUnits (site, stats, writer)

    if (site.validate()) {
      site.save ()                  // force gen site.id
      createSiteUsers (site, site_manager_emails, feedManager)
      setImages (site, site_images)
      site.save (flush:true)        // final save
      return site
    }
    else {
      log.info "Validation failed for site: ${site.title}, ${site.address}, ${site.city}, ${site.state}}"
    }
    return null
  }

  private def setOfficeHours (site, hours) {
    DateFormat df = new SimpleDateFormat("hh:mm a")
    if (hours && hours.size() == 7) {
      if (!hours[0].is_Closed) {
        site.openMonday = true
        site.startMonday = df.parse(hours[0].open)
        site.endMonday = df.parse(hours[0].closed)
      }
      if (!hours[1].is_Closed) {
        site.openTuesday = true
        site.startTuesday = df.parse(hours[1].open)
        site.endTuesday = df.parse(hours[1].closed)
      }
      if (!hours[2].is_Closed) {
        site.openWednesday = true
        site.startWednesday = df.parse(hours[2].open)
        site.endWednesday = df.parse(hours[2].closed)
      }
      if (!hours[3].is_Closed) {
        site.openThursday = true
        site.startThursday = df.parse(hours[3].open)
        site.endThursday = df.parse(hours[3].closed)
      }
      if (!hours[4].is_Closed) {
        site.openFriday = true
        site.startFriday = df.parse(hours[4].open)
        site.endFriday = df.parse(hours[4].closed)
      }
      if (!hours[5].is_Closed) {
        site.openSaturday = true
        site.startSaturday = df.parse(hours[5].open)
        site.endSaturday = df.parse(hours[5].closed)
      }
      if (!hours[6].is_Closed) {
        site.openSunday = true
        site.startSunday = df.parse(hours[6].open)
        site.endSunday = df.parse(hours[6].closed)
      }
    }
  }

  private def setAccessHours (site, hours) {
    DateFormat df = new SimpleDateFormat("hh:mm a")
    if (hours && hours.size() == 7) {
      if (!hours[0].is_Closed) {
        site.openMonday = true
        site.startMondayGate = df.parse(hours[0].open)
        site.endMondayGate = df.parse(hours[0].closed)
      }
      if (!hours[1].is_Closed) {
        site.openTuesday = true
        site.startTuesdayGate = df.parse(hours[1].open)
        site.endTuesdayGate = df.parse(hours[1].closed)
      }
      if (!hours[2].is_Closed) {
        site.openWednesday = true
        site.startWednesdayGate = df.parse(hours[2].open)
        site.endWednesdayGate = df.parse(hours[2].closed)
      }
      if (!hours[3].is_Closed) {
        site.openThursday = true
        site.startThursdayGate = df.parse(hours[3].open)
        site.endThursdayGate = df.parse(hours[3].closed)
      }
      if (!hours[4].is_Closed) {
        site.openFriday = true
        site.startFridayGate = df.parse(hours[4].open)
        site.endFridayGate = df.parse(hours[4].closed)
      }
      if (!hours[5].is_Closed) {
        site.openSaturday = true
        site.startSaturdayGate = df.parse(hours[5].open)
        site.endSaturdayGate = df.parse(hours[5].closed)
      }
      if (!hours[6].is_Closed) {
        site.openSunday = true
        site.startSundayGate = df.parse(hours[6].open)
        site.endSundayGate = df.parse(hours[6].closed)
      }
    }
  }

  private def createSiteUsers (site, site_manager_emails, feed_manager) {
    if (site_manager_emails) {
      for (int i = 0; i < site_manager_emails.size(); i++) {
        def email = site_manager_emails[i]
        createSiteUser(site, email, null, feed_manager)
      }
    }
  }

  private def setImages (site, site_images) {
    if (!site_images)
      return

    // Only pull the images from the feed once.
    // This may be subject to change
    if (site.siteImages())
      return

    def imgOrder = site.images.collect { it.imgOrder }.max()
    if (!imgOrder)
      imgOrder = 0;
    else
      imgOrder++

    for (int i = 0; i < site_images.size(); i++) {
      byte [] imgSrc = site_images[i].toURL().bytes
      MultipartFile imgFile = new MockMultipartFile(site_images[i].substring(site_images[i].lastIndexOf("/")+1), imgSrc)

      def ext
      def web
      def newName
      if (imgFile.size > 0) {
        ext = site_images[i].substring(site_images[i].lastIndexOf("."))
        web = site_images[i].substring(site_images[i].lastIndexOf(".")-3)

        // Web-sized images come in with names ending like "0105web.jpg".
        // These web-sized images get rasterized horribly by our thumbnail routines.
        // If we see an image with "web" just before the extension, then assume
        // it to be one of these and ignore it.
        if (web && web.startsWith("web"))
          continue

        newName = "Storitz-${site.city}-${site.state.display}-${site.title}-self-storage-units-${imgOrder}${ext}"
        if (fileUploadService.moveFile(imgFile, '/images/upload', newName, site.id)) {
          def tmpPath = fileUploadService.getFilePath('/images/upload', newName, site.id)
          def filePath = fileUploadService.getFilePath('/images/site', newName, site.id)
          def filePathMid = fileUploadService.getFilePath('/images/site', 'mid-' + newName, site.id)
          def filePathThumb = fileUploadService.getFilePath('/images/site', 'thumb-' + newName, site.id)
          imageService.scaleImages(new File(tmpPath), site.id, imgOrder, filePath, filePathMid, filePathThumb, site)
          imageService.iptcTagImage(new File(filePath), site, imgOrder, 'FULL')
          imageService.iptcTagImage(new File(filePathMid), site, imgOrder, 'MID')
          imageService.iptcTagImage(new File(filePathThumb), site, imgOrder, 'THUMB')
          ++imgOrder
        }
      }
    }
  }

  private String siteTitle (String city, String name) {
    // Only one site in this city?
    // Return the city name.
    if (cityCount[city] == 1)
      return "Storage Mart " + city

    // More than one site in this city?
    // Clean up the name and append to city
    int ampersand = name.indexOf("&")
    if (ampersand > 0) {
      return "Storage Mart " + city + " " + name.substring (0, ampersand)
    }
    int and = name.indexOf("and")
    if (and > 0) {
      return "Storage Mart " + city + " " + name.substring(0, and);
    }
    return "Storage Mart " + city + " " + name;
  }

  private StorageUnit createUpdateUnit(site
                                       ,stats
                                       ,writer
                                       ,unit_can_store_vehicle
                                       ,unit_discount_price
                                       ,unit_door_height
                                       ,unit_door_type
                                       ,unit_door_width
                                       ,unit_powered
                                       ,unit_floor
                                       ,unit_has_alarm
                                       ,unit_drive_up
                                       ,unit_has_outdoor_access
                                       ,unit_height
                                       ,unit_is_climate_controlled
                                       ,unit_is_covered_parking
                                       ,unit_is_humidity_controlled
                                       ,unit_length
                                       ,unit_price
                                       ,unit_promotion
                                       ,unit_promotion_long
                                       ,unit_quantity_available
                                       ,unit_type
                                       ,unit_type_id
                                       ,unit_width) {
    // Check the unit size (and possibly eliminate this as a potential unit)
    // before we fetch/create the actual unit so our site stats remain accurate.
    SearchType searchType = unit_can_store_vehicle ? SearchType.PARKING : SearchType.STORAGE
    StorageSize unitSize = unitSizeService.getUnitSize(unit_width,unit_length, searchType)
    if (!unitSize) {
      log.info ("Cannot determine unitSize for ${unit_width}, ${unit_length},  search type ${searchType}. Skipping\n")
      return
    }

    StorageUnit unit = site.units.find { it.unitNumber == unit_type_id }

    if (!unit) {
      unit = new StorageUnit()
      unit.site         = site
      unit.unitName     = unit_type_id
      unit.unitNumber   = unit_type_id
      unit.isIrregular  = false
      unit.isSecure     = true
      unit.isAvailable  = true
    }
    else {
      stats.removedCount--
    }
    stats.unitCount++
    unit.unitType     = bestGuessUnitType (unit_drive_up,unit_has_outdoor_access,unit_floor)
    unit.pushRate     = unit_discount_price
    unit.isPowered    = unit_powered
    unit.isAlarm      = unit_has_alarm
    unit.isTempControlled = unit_is_climate_controlled
    unit.unitsize     = unitSize
    unit.price        = unit_price
    unit.unitCount    = unit_quantity_available
    unit.displaySize  = "${unit_width as int} X ${unit_length as int}"
    unit.unitSizeInfo = "${unit_width}X${unit_length}"
    unit.unitTypeInfo = "${unit_type_id}:${unit_width}X${unit_length}"

    return unit.save()
  }

  private def bestGuessUnitType (drive_up, outdoor_access, floor) {
    if (drive_up)
      return UnitType.DRIVEUP

    if (!outdoor_access)
      return UnitType.INTERIOR

    if (floor == "2+Up")
      return UnitType.UPPER

    return UnitType.INTERIOR
  }

  private def loadPromoForUnit (site, unit, unit_promotion_long) {
    def code = "${site.sourceId}:${unit.unitNumber}"

    try {
      ///////////////////
      // SPECIAL OFFER //
      ///////////////////
      SpecialOffer specialOffer = site.specialOffers.find { it.code == code }
      boolean addToSite = false
      if (!specialOffer) {
        specialOffer = new SpecialOffer()
        specialOffer.code = code
        specialOffer.featured = true
        specialOffer.active = true
        addToSite = true
      }

      StorageMartSpecialOfferLookup lookup = lookupPromo (unit_promotion_long)
      if (lookup && !lookup.isNew()) {
        specialOffer.inMonth = lookup.startMonth
        specialOffer.promoType = lookup.type
        specialOffer.prepayMonths = lookup.prepayMonths
        specialOffer.expireMonth = lookup.expireMonth
        specialOffer.promoQty = lookup.amount
        specialOffer.description = unit_promotion_long
        if (!specialOffer.promoName)
          specialOffer.promoName = unit_promotion_long
        specialOffer.save(flush:true)
        if (addToSite)
          site.addToSpecialOffers(specialOffer)
      }

      ///////////////////////////////
      // SPECIAL OFFER RESTRICTION //
      ///////////////////////////////
      def specialOfferRestriction = specialOffer.restrictions.find { it.restrictionInfo == unit.unitTypeInfo }
      if (!specialOfferRestriction) {
        specialOfferRestriction = new SpecialOfferRestriction()
        specialOfferRestriction.restrictionInfo = unit.unitTypeInfo
        specialOfferRestriction.restrictive = false
        specialOfferRestriction.type = SpecialOfferRestrictionType.UNIT_TYPE
        specialOfferRestriction.save()
        specialOffer.addToRestrictions(specialOfferRestriction)
      }
    }
    catch (Throwable t) {
      def err = "Error processing special offer! site: ${site.title} (${site.id}), unit: ${unit.displaySize} (${unit.id}), special offer: ${special_description} (${special_amount}), month: ${special_month}"
      log.error (err, t)
    }
  }

  private StorageMartSpecialOfferLookup lookupPromo (String promoName) {
    StorageMartSpecialOfferLookup lookup = StorageMartSpecialOfferLookup.findByName(promoName)

    if (!lookup) {
      lookup = new StorageMartSpecialOfferLookup()
      lookup.name = promoName
      lookup.save ()
    }

    return lookup
  }

  ///////////////////////////////////////////////////
  ///// WEB SERVICE METHODS (Called from above) /////
  ///////////////////////////////////////////////////
  private FacilityOutput [] loadFacilities() {
    Credentials creds = new Credentials(this.passWord,this.userName); // yes, password/username
    BasicHttpBinding_IAvailabilityDataStub stub =
      new BasicHttpBinding_IAvailabilityDataStub(this.endpointURL, this.service);
    return stub.loadFacilities(creds);
  }

  private UnitTypeOutput [] loadUnitTypesByFacility (String facilityID) {
    Credentials creds = new Credentials(this.passWord,this.userName); // yes, password/username
    BasicHttpBinding_IAvailabilityDataStub stub =
      new BasicHttpBinding_IAvailabilityDataStub(this.endpointURL, this.service);
    return stub.loadUnitTypesByFacility(creds, facilityID)
  }

  /////////////////////////////////////////////////////////////
  ///// TEST METHODS (Called by integration & unit tests) /////
  /////////////////////////////////////////////////////////////
  public boolean testLoadFacilitiesAndUnits () {
    FacilityOutput [] output = loadFacilities()
    for (FacilityOutput o : output) {
      println "FACILITY: ${o.toString()}"
      println "   ID: ${o.facility_Id}"
      println "   NAME: ${o.name}"
      println "   DESC: ${o.description}"
      println "   PROMO: ${o.promotion}"
      println "   PROMO (LONG): ${o.promotionLongFormText}"
      for (int i = 0; i < o.image_Urls.size(); i++) {
        def image = o.image_Urls[i]
        println "   IMG[${i}]: ${image}"
      }
      println "   ADDRESS: ${o.address}"
       println "   CITY: ${o.city}"
       println "   STATE: ${o.state}"
      println "   ZIP: ${o.zip}"
      println "   PHONE: ${o.phone}"
      for (int i = 0; i < o.office_Hours.size(); i++) {
        FacilityHoursOutput hours = o.office_Hours[i]
        def daily_hrs = "${hours.open} - ${hours.closed}"
        println "   OFFICE[${i}] : ${hours.day} (${hours.is_Closed ? 'closed' : 'open'}), \t${hours.is_24_Hours ? '24 hour' : daily_hrs}"
      }
      for (int i = 0; i < o.access_Hours.size(); i++) {
        FacilityHoursOutput hours = o.access_Hours[i]
        def daily_hrs = "${hours.open} - ${hours.closed}"
        println "   ACCESS[${i}] : ${hours.day} (${hours.is_Closed ? 'closed' : 'open'}), \t${hours.is_24_Hours ? '24 hour' : daily_hrs}"
      }
      println "   TRUCK: ${o.has_Truck_Rental}"
      println "   FREE TRUCK: ${o.has_Free_Truck_Rental}"
      println "   DOCK: ${o.has_Loading_Dock}"
      println "   DOCK SZ: ${o.loading_Dock_Size}"
      println "   ELECTRONIC GATE: ${o.has_Electronic_Gate_Access}"
      println "   CAMERA: ${o.has_Surveillance_Cameras}"
      println "   FENCED: ${o.is_Fenced_And_Lighted}"
      println "   24 HR: ${o.has_24_Hour_Access}"
      println "   HARDCART: ${o.has_Handcarts}"
       println "   FEE: ${o.admin_Fee}"
     for (int i = 0; i < o.manager_Email_Address.size(); i++) {
        def email = o.manager_Email_Address[i]
        println "   MANAGER EMAIL[${i}]: ${email}"
      }

      try {
        testLoadUnitTypesByFacility (o.facility_Id)
      }
      catch (Throwable t) {
        println "ERROR!!! FACILITY ID=${o.facility_Id}"
        t.printStackTrace(System.err)
      }

    }
    return true
  }

  public boolean testLoadUnitTypesByFacility (String facilityID) {
    UnitTypeOutput[] output = loadUnitTypesByFacility(facilityID)
    for (UnitTypeOutput o : output) {
      println "   UNIT: ${o.toString()}"
      println "      can_Store_Vehicle:${o.can_Store_Vehicle}"
      println "      discount_Price:${o.discount_Price}"
      println "      door_Height:${o.door_Height}"
      println "      door_Type:${o.door_Type}"
      println "      door_Width:${o.door_Width}"
      println "      electricity:${o.electricity}"
      println "      floor:${o.floor}"
      println "      has_Alarm:${o.has_Alarm}"
      println "      has_Drive_Up_Access:${o.has_Drive_Up_Access}"
      println "      has_Outdoor_Access:${o.has_Outdoor_Access}"
      println "      height:${o.height}"
      println "      is_Climate_Controlled:${o.is_Climate_Controlled}"
      println "      is_Covered_Parking_Spot:${o.is_Covered_Parking_Spot}"
      println "      is_Humidity_Controlled:${o.is_Humidity_Controlled}"
      println "      length:${o.length}"
      println "      price:${o.price}"
      println "      promotion:${o.promotion}"
      println "      promotionLongFormText:${o.promotionLongFormText}"
      println "      quantity_Available:${o.quantity_Available}"
      println "      type:${o.type}"
      println "      unit_Type_Id:${o.unit_Type_Id}"
      println "      width:${o.width}"
    }
    return false
  }

  public boolean testAddReservation () {
    ReservationRequest request = new ReservationRequest(
        "jmeade@storitz.com"  // java.lang.String customer_Email_Address
        ,"Testy"              // java.lang.String customer_First_Name
        ,"McTest"             // java.lang.String customer_Last_Name
        ,"310-444-5550"       // java.lang.String customer_Phone
        ,"FAC1"               // java.lang.String facility_Id
        ,"2011-10-01"         // java.lang.String move_In_Date
        ,19.99                // java.lang.Double quoted_Price
        ,1                    // java.lang.Integer unit_Id
    );
    Credentials creds = new Credentials(this.passWord,this.userName); // yes, password/username
    BasicHttpBinding_IAvailabilityDataStub stub = new BasicHttpBinding_IAvailabilityDataStub(this.endpointURL, this.service);
    Integer confID = stub.addReservation (creds, request);
    println "CONFIRMATION: ${confID}"
    return false
  }

}