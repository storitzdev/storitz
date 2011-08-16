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

import java.net.URL
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

class StorageMartStorageFeedService extends BaseProviderStorageFeedService {

  static transactional = true

  def unitSizeService = new UnitSizeService()

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
      StorageSite theSite = createUpdateSite (sites[i], source, stats, writer)
      if (theSite) {
        feed.addToSites (theSite)
        SiteUser.link (theSite, feed.manager)
      }
    }
  }

  @Override
  void updateSite(StorageSite storageSiteInstance, SiteStats stats, PrintWriter writer) {
    //To change body of implemented methods use File | Settings | File Templates.
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
        storageSiteInstance.addToUnits (unit)
        // load promos here
      }
    }
  }

  @Override
  void loadPromos(StorageSite storageSiteInstance, PrintWriter writer) {
    //To change body of implemented methods use File | Settings | File Templates.
  }

  @Override
  void addSitePhone(StorageSite storageSiteInstance, PrintWriter writer) {
    //To change body of implemented methods use File | Settings | File Templates.
  }

  @Override
  boolean isAvailable(RentalTransaction trans) {
    return false  //To change body of implemented methods use File | Settings | File Templates.
  }

  @Override
  loadInsurance(Feed feed, StorageSite site) {
    return null  //To change body of implemented methods use File | Settings | File Templates.
  }

  @Override
  boolean moveIn(RentalTransaction trans) {
    return false  //To change body of implemented methods use File | Settings | File Templates.
  }

  @Override
  boolean reserve(RentalTransaction trans) {
    return false  //To change body of implemented methods use File | Settings | File Templates.
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

  StorageSite createUpdateSite (FacilityOutput theSite, String source, SiteStats stats, PrintWriter writer) {
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
    def site_manager_emails = []
    for (int i = 0; i < theSite.manager_Email_Address.size(); i++) {
      site_manager_emails[i] = theSite.manager_Email_Address[i]
    }

    StorageSite site = StorageSite.findBySourceAndSourceId (source,site_id)
    if (!site) {
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

    site.address               = site_address
    site.city                  = site_city

    // Guard against foreign states (Canada mostly)
    try {
      site.state               = State.fromText (site_state)
    }
    catch (Throwable t) {
      t.printStackTrace()
      return null
    }

    site.zipcode               = site_zip
    site.phone                 = site_phone
    site.freeTruck             = site_free_truck ? TruckType.FREE : site_truck ? TruckType.RENTAL : TruckType.NONE
    site.isGate                = site_fenced
    site.isKeypad              = site_electronic_gate
    site.isCamera              = site_camera
    site.isTwentyFourHour      = site_24_hr
    site.lastChange            = new Date()
    site.lastUpdate            = site.lastChange.time

    geoCodeSite (site)

    updateUnits (site, stats, writer)

    if (site.validate()) {
      return site.save (flush:true)
    }
    else {
      println "Validation failed for site: ${site.title}, ${site.address}, ${site.city}, ${site.state}}"
    }
    return null
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
      println ("Cannot determine unitSize for $unit_width}, ${unit_length},  search type ${searchType}. Skipping\n")
      return
    }

    StorageUnit unit = site.units.find { it.unitName = unit_type_id }

    if (!unit) {
      unit = new StorageUnit()
      unit.unitName     = unit_type_id
      unit.unitNumber   = unit_type_id
      unit.isIrregular  = false
      unit.isSecure     = true
      unit.isAvailable  = true
      stats.createCount++
    }
    else {
      stats.updateCount++
      stats.unitCount++
      stats.removedCount--
    }
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
