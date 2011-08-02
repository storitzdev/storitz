package storitz

import com.storitz.Feed
import com.storitz.EDomico
import com.storitz.StorageSite
import com.edomico.www.*

import com.storitz.EDomicoLocation
import storitz.constants.TruckType
import storitz.constants.TransactionType
import com.storitz.StorageUnit
import storitz.constants.UnitType
import storitz.constants.SearchType
import com.storitz.SpecialOffer
import storitz.constants.PromoType

import com.storitz.SiteUser
import com.storitz.SpecialOfferRestriction
import storitz.constants.SpecialOfferRestrictionType
import com.storitz.RentalTransaction
import storitz.constants.State
import com.storitz.EDomicoAmenitiesMap
import storitz.constants.PhoneType
import org.grails.mail.MailService

class EDomicoStorageFeedService extends BaseProviderStorageFeedService {

    /**
     * Contact Information:
     * Leslie Ainscough 800-688-6181
     * =====================
     * = Login Credentials =
     * =====================
     * Storage PRO:
     * eDomico Client ID: 443
     * eDomico Web Service Key: uBvQoE0DtVTMQA8xCv57A3Rw
     *
     * SafeGuard:
     * eDomico Client ID: 400
     * eDomico Web Service Key: Oukm8#Wn36K?7Xx/bKf0IgW!Tm7
     *
     * All Aboard:
     * eDomico Client ID: 981
     * eDomico Web Service Key: Qu/y0JsiCI6+kW8H@rO4mo8f
     */

    // Common across all feeds
    private static AvailableUnitsSizesSoap availableUnitsSizesSoap = new AvailableUnitsSizesSoap12Stub(new URL("https://www.edomico.com/WebServices/AvailableUnits.asmx"),null)
    private static CommonMethodsSoap commonMethodsSoap = new CommonMethodsSoap12Stub(new URL("https://www.edomico.com/WebServices/Common.asmx"),null)
    private static CustomerInfoSoap customerInfoSoap = new CustomerInfoSoap12Stub(new URL("https://www.edomico.com/WebServices/CustomerInfo.asmx"),null)
    private static PaymentSoap paymentSoap = new PaymentSoap12Stub(new URL("https://www.edomico.com/WebServices/Payment.asmx"),null)
    private static ReservationSoap reservationSoap = new ReservationSoap12Stub(new URL("https://www.edomico.com/WebServices/Reservation.asmx"),null)

    // Unique per feed
    private int    clientID
    private String webServicesKey

    static transactional = true

    // Contructor used publicly by service factory
    public EDomicoStorageFeedService() {
    }

    // Constructor used internally by the EDomicoController
    public EDomicoStorageFeedService(int clientID, String webServicesKey) {
        this.clientID = clientID;
        this.webServicesKey = webServicesKey;
    }

    def mailService

    MailService getMailService() {
      if (!mailService) {
        mailService = new MailService()
      }
      return mailService
    }

    @Override
    void init(StorageSite site) {
        EDomico eDomico = (EDomico)site.feed;
        this.clientID = eDomico.edomicoClientID;
        this.webServicesKey = eDomico.edomicoWebServicesKey;
    }

    // TODO
    @Override
    def loadInsurance(Feed feed, StorageSite site) {
        return null
    }

    // Called by EDomicoController class when a feed is first created
    def loadSites(EDomico instance, String feedType, SiteStats stats, PrintWriter writer) {
        // Get a list of the EDomicoLocation objects associated with this EDomico feed
        List<EDomicoLocation> locations = instance.locations?.asList()

        // Iterate through these locations, processing each StorageSite in turn
        for (int i = 0; i < locations?.size(); i++) {
            EDomicoLocation location = locations.get(i)
            StorageSite storageSite = getStorageSiteFromEDomicoLocation(location, stats)
            // If this is initial site creation then the site won't have this
            // feed bound to it yet, so we bind it here.
            if (!storageSite.feed) {
                storageSite.feed = instance
            }
            // It also won't have this sourceId bound. Technically this should
            // not be necessary, since the sourceId gets bound inside the call
            // to updateSite. However, since updateSite is also referenced from
            // outside of this context, I (JM) needed to embed a call to find
            // the EDomicoLocation attached to this site /inside/ the updateSite
            // call, and for that the sourceId is required.
            if (!storageSite.sourceId) {
                storageSite.sourceId = location.siteID
            }
            updateSite(storageSite,stats,writer)
            SiteUser.link(storageSite, instance.manager)
        }
    }

    // TODO
    @Override
    public void loadPromos(StorageSite storageSite, PrintWriter printWriter) {
      // NO OP : promos are loaded along with inventory.
    }

    // This loads promos for a specific unit. There is a more generic method that
    // load promos at the site level.
    // NOTE: Saves but does not flush.
    def loadPromos(StorageSite storageSite, StorageUnit storageUnit, EDomicoNode siteSize, PrintWriter writer) {

        // StorageSite: hasMany StorageUnit, SpecialOffer (hasMany SpecialOfferRestrictions)
        // DiscountName: $29 Move In Special
        // DiscountValue: 29
        String discountName = siteSize.get("DiscountName")
        BigDecimal discountValue = siteSize.get("DiscountValue") as BigDecimal

        if (discountValue < 0.001) {
            deleteSpecialOfferAndSpecialOfferRestrictionByStorageSiteAndUnitIfAny(storageSite,storageUnit)
            return
        }

        // There is only one special per unit. That special, if any is always active and featured
        SpecialOffer specialOffer = getSpecialOfferByStorageSiteAndStorageUnit(storageSite,storageUnit)
        specialOffer.featured    = true
        specialOffer.active      = true
        specialOffer.description = discountName
        if (!specialOffer.promoName) specialOffer.promoName = discountName

        boolean isPercent = new Boolean(siteSize.get("IsPercent")).booleanValue()
        if (isPercent)  {
            specialOffer.promoType = PromoType.PERCENT_OFF
        }
        else {
            specialOffer.promoType = PromoType.FIXED_RATE
        }

        specialOffer.promoQty =  discountValue
        specialOffer.save()            // no flush!

        SpecialOfferRestriction specialOfferRestriction = getSpecialOfferRestrictionByStorageUnitSpecialOffer(storageUnit,specialOffer)
        specialOfferRestriction.restrictive = false
        specialOfferRestriction.type = SpecialOfferRestrictionType.UNIT_TYPE
        specialOfferRestriction.save() // no flush!

        if (!specialOffer.restrictions?.contains(specialOfferRestriction)) {
          specialOffer.addToRestrictions(specialOfferRestriction)
          specialOffer.save()          // no flush!
        }

        if (!storageSite.specialOffers?.contains(specialOffer)) {
          storageSite.addToSpecialOffers(specialOffer)
          storageSite.save()           // no flush!
        }
    }

    def deleteSpecialOfferAndSpecialOfferRestrictionByStorageSiteAndUnitIfAny(StorageSite storageSite, StorageUnit storageUnit) {
        SpecialOffer specialOffer = null
        SpecialOfferRestriction specialOfferRestriction = null

        ////////////////////////////////////////////////////////////////
        try {
           specialOffer = getSpecialOfferByStorageSiteAndStorageUnit(storageSite,storageUnit)
           storageSite.removeFromSpecialOffers(specialOffer)
           specialOffer.delete()
        }
        catch (Throwable t) {
           t.printStackTrace()
        }

        ////////////////////////////////////////////////////////////////
        try {
            specialOfferRestriction = getSpecialOfferRestrictionByStorageUnitSpecialOffer(storageUnit,specialOffer)
            specialOffer.removeFromRestrictions(specialOfferRestriction)
            specialOfferRestriction.delete()
        }
        catch (Throwable t) {
           t.printStackTrace()
        }
    }

    def getSpecialOfferRestrictionByStorageUnitSpecialOffer(StorageUnit storageUnit,SpecialOffer specialOffer) {
        List<SpecialOfferRestriction> restrictions = specialOffer.restrictions?.asList()

        for (SpecialOfferRestriction restriction : restrictions) {
            if (restriction.restrictionInfo == storageUnit.unitTypeInfo) {
                return restriction
            }
        }

        SpecialOfferRestriction specialOfferRestriction = new SpecialOfferRestriction()
        specialOfferRestriction.restrictionInfo = storageUnit.unitTypeInfo
        return specialOfferRestriction
    }

    def getSpecialOfferByStorageSiteAndStorageUnit(StorageSite storageSite,StorageUnit storageUnit) {
       String code = "${storageUnit.unitName}-${storageUnit.unitNumber}"
       SpecialOffer specialOffer = null

        // See if we already have the offer listed
        List<SpecialOffer> specialOffers = storageSite.specialOffers?.asList()
        for (SpecialOffer offer : specialOffers) {
            if (offer.code == code) {
                return offer
            }
        }

        // If not, then create one
        specialOffer = new SpecialOffer()

        // Set some meaningful defaults. Since operations can and will update sites and promotions via the UI,
        // don't set these values upon every load. Rather, set them upon initial creation and let them stay
        // as-is after that.
        specialOffer.expireMonth    = 1
        specialOffer.inMonth        = 1
        specialOffer.prepayMonths   = 0

        specialOffer.code = code
        storageSite.addToSpecialOffers(specialOffer)

        return specialOffer
    }

    def getStorageUnitDescription (String desc) {
        // Matches:
        // "3 X 4.5"                           : ""
        // "3.5 X 4"                           : ""
        // "3 X 4"                             : ""
        // "4 X 4 Minor Obstruction"           : "Minor Obstruction"
        // "4 X 6 Asymmetrical"                : "Asymmetrical"
        // "4.5 X 7 x 8"                       : ""
        // "5 x 10 Upstairs"                   : "Upstairs"
        // "5 X 10 X 6 Minor Obstruction"      : "Minor Obstruction"

        String regexp = "^[0123456789.xX ]*";
        return desc.replaceAll(regexp,"");
    }

    def getUnitSize(sizeInfo, searchType) {
      UnitSizeService unitSizeService = new UnitSizeService()
      return unitSizeService.getUnitSize(sizeInfo["width"],sizeInfo["length"],searchType)
    }

    /**
      *
      * @param size
      * @return list [width: X, length: Y, description: Z]
      */
    def getUnitSizeInfo(String size) {
      // JM: 2011-05-26
      // I've seen data come in as follows:
      // "10 X 16"
      // "10 X 16 Asymmetrical"
      // "10X10X8CC"
      // Since we can't guarantee that spaces will surround the 'X',
      // we force the space here before moving forward

      String [] toks = size.replaceAll("[xX]","/").split("/");
      if (toks.length < 2) {
        return null
      }

      Double width
      Double length

      try {
        width    = new Double(toks[0].replaceAll("[a-zA-Z]*","")).doubleValue();
        length   = new Double(toks[1].replaceAll("[a-zA-Z]*","")).doubleValue();
      }  catch (NumberFormatException e) {
        return null
      }

      // Rest may contain leading numerals if the unit size was W X L X H
      // We ignore the height, so we strip that info away here.
      def description = getStorageUnitDescription(size)

      return [width: width, length: length, description: description]
    }

    def getStorageUnitByNameAndNumber(StorageSite site, String name, String number, SiteStats stats) {
        def currentUnits = site.units

        // Find if one already exists
        for (unit in currentUnits) {
            if (unit.unitName == name && unit.unitNumber == number) {
                stats.removedCount--
                stats.unitCount++
                return unit
            }
        }

        // No luck? create a new one
        stats.createCount++
        StorageUnit storageUnit = new StorageUnit()

        // We know these values...
        storageUnit.unitName            = name
        storageUnit.unitNumber          = number

        // ...But the rest are just basic defaults. It's important to set defaults only when the
        // object is created, and not when it is updated, to prevent overwriting customizations
        // that may have been entered via the UI by operations.
        storageUnit.description         = "Self Storage"
        storageUnit.isAvailable         = true
        storageUnit.isSecure            = false
        storageUnit.isTempControlled    = false
        storageUnit.isAlarm             = false
        storageUnit.isPowered           = false
        storageUnit.isIrregular         = false
        storageUnit.unitType            = UnitType.UNDEFINED
        return storageUnit
    }

    // Find a reference to the StorageSite mapped to this EDomicoLocation,
    // or create a new reference, as appropriate
    def getStorageSiteFromEDomicoLocation(EDomicoLocation location, SiteStats stats) {

        // JM: 2011-06-01
        // When we delete a storage_site the corresponding site_id column is
        // *note* getting nullified. That's a minor issue until we check for
        // the existence of the site, below. I'm wrapping the call and catching
        // the hibernate error as you can see. An invalid linkage is assumed to
        // mean a deleted site, and thus a bad reference.
        def exists = false

        try {
          if (location.site) exists = true
        } catch (org.hibernate.ObjectNotFoundException e) {
          e.printStackTrace()
        }

        if (!exists) {
            stats.createCount++
            location.site = newEDomicoStorageSite()
        }
        else {
            stats.updateCount++
        }
        return location.site
    }

    @Override
    void refreshSites(Feed feed, String source, SiteStats stats, PrintWriter writer) {
      EDomico instance = (EDomico)feed
      loadSites(instance,source,stats,writer)
    }

    def newEDomicoStorageSite () {
        StorageSite storageSite = new StorageSite()

        // I only know the following three values...
        storageSite.transactionType     = TransactionType.RENTAL
        storageSite.source              = 'DOM' // data source
        storageSite.lastChange          = new Date()

        // ...The rest are all basic defaults
        storageSite.boxesAvailable      = false
        storageSite.freeTruck           = TruckType.NONE
        storageSite.isGate              = false
        storageSite.isKeypad            = false
        storageSite.isCamera            = false
        storageSite.isUnitAlarmed       = false
        storageSite.lastUpdate          = 0
        storageSite.lat                 = 0
        storageSite.lng                 = 0
        storageSite.requiresInsurance   = false
        storageSite.extendedHours       = false
        storageSite.isManagerOnsite     = false
        storageSite.hasElevator         = false
        storageSite.taxRateMerchandise  = 0
        storageSite.taxRateInsurance    = 0
        storageSite.taxRateRental       = 0

        return storageSite
    }

    @Override
    public void updateSite(StorageSite storageSite, SiteStats stats, PrintWriter writer) {
        EDomicoLocation eDomicoLocation = EDomicoLocation.findBySiteID(storageSite.sourceId)

        if (!eDomicoLocation) {
            printf "Cannot find EDomico Site by Source ID = ${storageSite.sourceId}"
            return
        }

        // Technically, we only need to set these values once when we create the StorageSite.
        // But, what happens if we ever change the values in the EDomicoLocation, for example
        // to correct an address mistake. We would want that to propagate outward to the site, no?
        // To satisfy that use case, we update these values every time.
        storageSite.address     = eDomicoLocation.address1
        storageSite.city        = eDomicoLocation.city
        storageSite.state       = State.fromText(eDomicoLocation.state)

        // This item is often manually overridden by operations.
        // We respect that override.
        if (!storageSite.title) {
            storageSite.title = eDomicoLocation.siteName
        }

        // This item is often manually overridden by operations.
        // We respect that override.
        if (!storageSite.description) {
            storageSite.description = storageSite.feed.operatorName
        }

        storageSite.zipcode     = eDomicoLocation.zipcode
        storageSite.sourceId    = eDomicoLocation.siteID
        storageSite.sourceLoc   = eDomicoLocation.siteName
        geoCodeSite(storageSite)

        // now handle the associated units for this site
        updateUnits(storageSite, stats, writer)

        // and save
        storageSite.save(flush: true)
    }

    @Override
    public void updateUnits(StorageSite site, SiteStats stats, PrintWriter writer) {
        zeroOutUnitsForSite(site,stats,writer)

        EDomico feed = (EDomico)site.feed
        def token = this.readToken()
        def siteID  = this.readSiteID(token,site.address,site.city,site.zipcode)
        def sizes = this.readSizes(token,siteID)

        for (sz in sizes) {
            def unitSizeInfo = getUnitSizeInfo(sz.get("SizeCodeInfo"))
            if (!unitSizeInfo) {
              println "Cannot determine unitSizeInfo for ${sz.get("SizeCodeInfo")}. Skipping"
              continue
            }

            // will create the map if it does not exist
            EDomicoAmenitiesMap eDomicoAmenitiesMap = getAmenitiesMap(unitSizeInfo["description"])

            def sizeID = new Integer(sz.get("SizeID")).intValue()
            def units = this.readUnits(token,siteID,sizeID)
            def price = new Double(sz.get("SizeRentRate")).doubleValue()
            StorageUnit storageUnit = getStorageUnitByNameAndNumber(site,sz.get("SiteID"),sz.get("SizeID"),stats)
            storageUnit.unitTypeInfo = sz.get("SiteID") + "-" + sz.get("SizeID") + ":" + sz.get("SizeCodeInfo")
            storageUnit.price = storageUnit.pushRate = price
            storageUnit.displaySize = storageUnit.unitSizeInfo = getStorageUnitDisplaySize(sz.get("SizeCodeInfo"))
            def unitSize = getUnitSize(unitSizeInfo,eDomicoAmenitiesMap.searchType)
            if (!unitSize) {
                writer.append("Cannot determine unitSize for " + sz.get("SizeCodeInfo") + ". Skipping\n")
                continue
            }
            storageUnit.unitsize = unitSize
            storageUnit.unitType = eDomicoAmenitiesMap.unitType
            if (eDomicoAmenitiesMap.secure)            storageUnit.isSecure = true
            if (eDomicoAmenitiesMap.tempControlled)    storageUnit.isTempControlled = true
            if (eDomicoAmenitiesMap.alarmed)           storageUnit.isAlarm = true
            if (eDomicoAmenitiesMap.powered)           storageUnit.isPowered = true
            if (eDomicoAmenitiesMap.irregular)         storageUnit.isIrregular = true
            storageUnit.description = getStorageUnitDescription(sz.get("SizeCodeInfo"))
            storageUnit.isAvailable = true
            storageUnit.unitCount = units.size()
            storageUnit.deposit = new Double(sz.get("SizeRentRateReservationDeposit")).doubleValue()

            // Looks good to go. Save and process promos
            site.save()         // don't flush!
            storageUnit.save()  // don't flush!
            site.addToUnits(storageUnit)

            // Process the promotions  (Note: saves but does not flush)
            loadPromos(site,storageUnit,sz,writer)

            // Now we can save, flush and move on...
            site.save(flush: true)
        }
    }

    def getAmenitiesMap (String description) {
      EDomicoAmenitiesMap eDomicoAmenitiesMap = EDomicoAmenitiesMap.findByDescription(description)

      // We don't know what this is.
      // Save into the map so we can figure it out later
      if (!eDomicoAmenitiesMap) {
        println "Creating new EDomico Amenities Map Entry: ${description}"
        eDomicoAmenitiesMap = new EDomicoAmenitiesMap()

        // mandatory fields
        eDomicoAmenitiesMap.description    = description
        eDomicoAmenitiesMap.unitType       = bestGuessUnitType(description)
        eDomicoAmenitiesMap.searchType     = bestGuessSearchType(description)
        eDomicoAmenitiesMap.tempControlled = bestGuessClimateControlled(description)

        // optional fields
        if (bestGuessSecure(description))    eDomicoAmenitiesMap.secure    = true
        if (bestGuessAlarmed(description))   eDomicoAmenitiesMap.alarmed   = true
        if (bestGuessPowered(description))   eDomicoAmenitiesMap.powered   = true
        if (bestGuessIrregular(description)) eDomicoAmenitiesMap.irregular = true
        eDomicoAmenitiesMap.save() // no flush!
      }

      return eDomicoAmenitiesMap
    }

    def bestGuessSearchType (String description) {
      if (description.toLowerCase().contains("parking"))
        return SearchType.PARKING
      if (description.toLowerCase().contains("vehicle"))
        return SearchType.PARKING
      if (description.toLowerCase().contains("garage"))
        return SearchType.PARKING
      if (description.contains("RV"))
        return SearchType.PARKING

      return SearchType.STORAGE
    }

    def bestGuessUnitType (String description) {
      if (description.toLowerCase().contains("drive up"))
        return UnitType.DRIVEUP
      if (description.toLowerCase().contains("hallway"))
        return UnitType.INTERIOR
      if (description.toLowerCase().contains("upstairs"))
        return UnitType.UPPER
      return UnitType.UNDEFINED
    }

  def bestGuessSecure (String description) {
    return false
  }

  def bestGuessClimateControlled (String description) {
    if (description.toLowerCase().contains("climate control"))
      return true
    if (description.toLowerCase().contains("cc"))
      return true
    return false
  }

  def bestGuessAlarmed (String description) {
    return false
  }

  def bestGuessPowered (String description) {
    return false
  }

    def bestGuessIrregular (String description) {
      if (description.toLowerCase().contains("asymmetrical"))
        return true
      if (description.toLowerCase().contains("obstruction"))
        return true
      return false
    }

    /**
     *
     * @param sz where sz can be something like "5X5X4GCC", or "5 x 10 Upper"
     * @return Just the basic size, i.e. "5 X 5", or "5 X 10"
     */
    private String getStorageUnitDisplaySize (String sz) {
        String tmpSize = sz.replaceAll("[xX]","/").replaceAll("[a-zA-Z ]","").replaceAll("/"," X ");
        String size = tmpSize;

        // I.E. 5 X 5 X 8 => 5 X 5
        if (tmpSize.count("X") > 1) {
            int x1 = tmpSize.indexOf('X');
            int x2 = tmpSize.indexOf('X',x1+1);
            size = tmpSize.substring(0,x2);
        }

        return size;
    }

    // TODO
    @Override
    public void addSitePhone(StorageSite storageSite, PrintWriter writer) {
      // NO OP : Api does not give us this info
    }

    // TODO
    @Override
    public boolean isAvailable(RentalTransaction trans) {
      def storageUnit       = StorageUnit.findById(trans.unitId)
      def token             = this.readToken();
      def siteID            = trans.site.sourceId;
      def sizeID            = storageUnit.unitNumber as int;
      def unitID            = this.readUnitID(token, siteID, sizeID);
      return unitID > 0
    }

    // TODO: Test. Lots of test.
    @Override
    public boolean moveIn(RentalTransaction trans) {
      def storageUnit       = StorageUnit.findById(trans.unitId)
      def contact           = trans.contactPrimary

      def token             = this.readToken();
      def siteID            = trans.site.sourceId;
      def sizeID            = storageUnit.unitNumber as int;
      //def unitID            = this.readUnitID(token, siteID, sizeID);
      EDomicoNode unitInfo  = this.readUnitInfo (token, siteID, sizeID)
      def unitID            = unitInfo.get("UnitID")    // internal (pk) unit id
      def unitMask          = unitInfo.get("UnitMask")  // external (public) unit id
      def lastName          = contact.lastName;
      def firstName         = contact.firstName;
      def middleInitial     = null;
      def emailAddress      = contact.email;
      def address1          = contact.address1;
      def address2          = contact.address2;
      def city              = contact.city;
      def state             = contact.state.display.toString();
      def zip               = contact.zipcode;
      def homePhone         = contact.phoneType == PhoneType.HOME ? contact.phone : null;
      // Assume all non-home phones are mobile. It may actually be OFFICE,
      // but Domico has no way to handle that specific type.
      def cellPhone         = contact.phoneType != PhoneType.HOME ? contact.phone : null;
      def sendConfirmationEmail = false;
      def emailContent      = null;
      def depositAmount     = 0.0; // RESERVATION WITHOUT PAYMENT. WE'll ACH the move-in amount

      def res = this.reserveUnit(token, siteID, unitID, sizeID,
          lastName, firstName, middleInitial, emailAddress, address1, address2,
          city, state, zip, homePhone, cellPhone, sendConfirmationEmail,
          emailContent, depositAmount);

      // XML items
      def resSuccess       = res.get("Success")
      def resCustomerID    = res.get("CustomerID")
      def resUnitID        = res.get("UnitID")
      def resError         = res.get("Error")
      def reSeMailMessage  = res.get("EMailMessage")

      println "/// DOMICO RESERVATION RESULTS ///"
      println "<Authorize>"
      println "    <Success>${resSuccess}</Success>"
      println "    <Customer>${resCustomerID}</Customer>"
      println "    <UnitID>${resUnitID}</UnitID>"
      println "    <Error>${resError}</Error>"
      println "    <EMail>${reSeMailMessage}</EMail>"
      println "</Authorize>"

      if (resSuccess) {
        trans.idNumber = "${resCustomerID}"
        trans.feedUnitNumber = "${unitMask}"
//        trans.save(flush:true)
      }
      // Failed move-in!
      else {
        StringBuffer bdy = new StringBuffer()
        bdy.append("\n Failed Domico Move In")
        bdy.append("\n ")
        bdy.append("\n REQUEST")
        bdy.append("\n reserveUnit (")
        bdy.append("\n    token=${token}")
        bdy.append("\n    siteID=${siteID}")
        bdy.append("\n    unitID=${unitID}")
        bdy.append("\n    sizeID=${sizeID}")
        bdy.append("\n    lastName=${lastName}")
        bdy.append("\n    firstName=${firstName}")
        bdy.append("\n    middleInitial=${middleInitial}")
        bdy.append("\n    emailAddress=${emailAddress}")
        bdy.append("\n    address1=${address1}")
        bdy.append("\n    address2=${address2}")
        bdy.append("\n    city=${city}")
        bdy.append("\n    state=${state}")
        bdy.append("\n    zip=${zip}")
        bdy.append("\n    homePhone=${homePhone}")
        bdy.append("\n    cellPhone=${cellPhone}")
        bdy.append("\n    sendConfirmationEmail=${sendConfirmationEmail}")
        bdy.append("\n    emailContent=${emailContent}")
        bdy.append("\n    depositAmount=${depositAmount}")
        bdy.append("\n )")
        bdy.append("\n ")
        bdy.append("\n RESPONSE")
        bdy.append("\n <Authorize>")
        bdy.append("\n     <Success>${resSuccess}</Success>")
        bdy.append("\n     <Customer>${resCustomerID}</Customer>")
        bdy.append("\n     <UnitID>${resUnitID}</UnitID>")
        bdy.append("\n     <Error>${resError}</Error>")
        bdy.append("\n     <EMail>${reSeMailMessage}</EMail>")
        bdy.append("\n </Authorize>")

        getMailService().sendMail {
          to        "notifications@storitz.com"
          from      "no-reply@storitz.com"
          subject   "DOMICO - failed move-in"
          body      bdy.toString()
        }
      }

      return resSuccess
    }

    // TODO
    @Override
    public boolean reserve(RentalTransaction trans) {
      return moveIn (trans);
    }


    /////////////////////////////////////////
    // Encapsulated eDomico Web Services ////
    /////////////////////////////////////////

    ///////////////////////////
    // COMMON METHODS SOAP ////
    ///////////////////////////

    // call this method first!
    // According to Domico:
    // This web service is used to obtain a session token. The session token and ClientID
    // are then used to validate subsequent calls to other eDOMICO web services. All other
    // eDOMICO web services will validate the session token return by this call against the
    // token located in the database for the ClientID provided.
    def readToken() {
        def sessionToken = commonMethodsSoap.readToken(clientID, webServicesKey)
        return sessionToken
    }

    ///////////////////////////
    // AVAILABLE UNITS SOAP ///
    ///////////////////////////


    // According to Domico:
    // This web service is used to determine what site/facility the end user is currently
    // attempting to work with (i.e. reservation). DOMICO databases use a SiteID field as
    // a primary key, and this value is required to process many of the eDOMICO web
    // service calls. The DOMICO Client may or may not know the DOMICO assigned SiteID
    // of each facility, but they will have Address/Location information.
    def readSiteID(java.lang.String token, java.lang.String address, java.lang.String city, java.lang.String zip) {
        def siteID = availableUnitsSizesSoap.readSiteID(clientID, token, address, city, zip)
        return siteID
    }

    // According to Domico:
    // This web service returns the sizes that have units available (vacant) for renting. The
    // sizes returned follow the same client setup options as using the web pages
    // (embedded or stand alone) – i.e. minimum available units.
    def readSizes(java.lang.String token, java.lang.String siteID) {
        ReadSizesResponseReadSizesResult readSizesResponseReadSizesResult = availableUnitsSizesSoap.readSizes(clientID, token, siteID)
        org.w3c.dom.NodeList sizesAndRatesList = Util.getTopLevelNodeList(readSizesResponseReadSizesResult, "SizesAndRates")
        def sizes = []
        for (int i = 0; i < sizesAndRatesList.length; i++) {
            org.w3c.dom.Node n = sizesAndRatesList.item(i)
            org.w3c.dom.NodeList childNodes = n.childNodes
            EDomicoNode siteSize = new EDomicoNode(childNodes)
            siteSize.set("SiteID","${siteID}")
            sizes.add(siteSize)
        }
        return sizes
    }

    // According to Domico:
    // This web service returns a vacant unit based on a provided size.
    def readUnitID(java.lang.String token, java.lang.String siteID, int sizeID) {
        def unitID = availableUnitsSizesSoap.readUnitID(clientID, token, siteID, sizeID)
        return unitID;
    }

    // According to Domico:
    // Returns first available single UnitID/UnitMask based on Size. There is NO
    // criteria. Simply just returns first unit found that is available.
    def readUnitInfo(java.lang.String token, java.lang.String siteID, int sizeID) {
        ReadUnitInfoResponseReadUnitInfoResult readUnitInfoResponseReadUnitInfoResult = availableUnitsSizesSoap.readUnitInfo(clientID, token, siteID, sizeID)
        org.w3c.dom.NodeList readUnitInfo = Util.getTopLevelNodeList(readUnitInfoResponseReadUnitInfoResult,"ReadUnitInfo")
        org.w3c.dom.Node n = readUnitInfo.item(0)
        org.w3c.dom.NodeList childNodes = n.childNodes
        EDomicoNode unitInfo = new EDomicoNode(childNodes)
        unitInfo.set("SiteID","${siteID}")
        unitInfo.set("SizeID","${sizeID}")
        return unitInfo
    }

    // According to Domico:
    // This web service returns all vacant units (UnitID and UnitMask) based on a provided size.
    // (Similar to readUnitInfo, but returns all possible units, not just one)
    def readUnits(java.lang.String token, java.lang.String siteID, int sizeID) {
        ReadUnitsResponseReadUnitsResult readUnitsResponseReadUnitsResult =  availableUnitsSizesSoap.readUnits(clientID, token, siteID, sizeID)
        org.w3c.dom.NodeList documentElementList = Util.getTopLevelNodeList(readUnitsResponseReadUnitsResult,"DocumentElement")
        def units = []
        for (int i = 0; i < documentElementList.length; i++) {
            org.w3c.dom.Node documentElementNode = documentElementList.item(i)
            org.w3c.dom.NodeList readUnitsList = documentElementNode.childNodes
            for (int j = 0; j < readUnitsList.length; j++) {
                org.w3c.dom.Node readUnitsNode = readUnitsList.item(j)
                EDomicoNode unitInfo = new EDomicoNode(readUnitsNode)
                unitInfo.set("SiteID","${siteID}")
                unitInfo.set("SizeID","${sizeID}")
                units.add(unitInfo)
            }
        }
        return units
    }

    ///////////////////////////
    // CUSTOMER INFO SOAP /////
    ///////////////////////////

    // According to Domico:
    // This web service locates a customer’s account based on a userID and password.
    def findCustomer(java.lang.String token, java.lang.String userIDEncrypted, java.lang.String passwordEncrypted, boolean occupiedOnly) {
        customerInfoSoap.findCustomer(clientID, token, userIDEncrypted, passwordEncrypted, occupiedOnly)
    }

    // According to Domico:
    // This web service returns the same information/data as the FindCustomer web
    // service. The only difference between these services is the how they are called. This
    // service requires a CustomerID rather than a UserID/Password.
    def readCustomerInfo(java.lang.String token, int customerID) {
        customerInfoSoap.readCustomerInfo(clientID, token, customerID)
    }

    // According to Domico:
    // This web service handles the changing of a customer's login password.
    // Usage:
    //  Used after customer login as an account management feature.
    def changePassword(java.lang.String token, int customerID, java.lang.String oldPasswordEncrypted, java.lang.String newPasswordEncrypted, boolean sendEmailConfirmation, java.lang.String sendEmailContent) {
        customerInfoSoap.changePassword(clientID, token, customerID, oldPasswordEncrypted, newPasswordEncrypted, sendEmailConfirmation, sendEmailContent)
    }

    // According to Domico:
    // This web service permits the customer to change their address information (Address,
    // City, State, Zip, Home/Cell phone). Optionally supports sending confirmation e-mail
    // to the customer using default e-mail content or provided content.
    // Usage:
    //   Used after customer login as an account management feature.
    def changeAddress(java.lang.String token, int customerID, java.lang.String newAddress1, java.lang.String newAddress2, java.lang.String newCity, java.lang.String newState, java.lang.String newZip, java.lang.String newHomePhone, java.lang.String newCellPhone, boolean sendEmailConfirmation, java.lang.String sendEmailContent) {
        customerInfoSoap.changeAddress(clientID, token, customerID, newAddress1, newAddress2, newCity, newState, newZip, newHomePhone, newCellPhone, sendEmailConfirmation, sendEmailContent)
    }
    def deleteCustomerSPAN(java.lang.String token, java.lang.String siteID, long customerAccount, int customerID) {
        customerInfoSoap.deleteCustomerSPAN(clientID, token, siteID, customerAccount, customerID)
    }
    def removeMigratedCustomerBilling(java.lang.String token, java.lang.String siteID, java.lang.String keyCode) {
        customerInfoSoap.removeMigratedCustomerBilling(clientID, token, siteID, keyCode)
    }
    def migrateCustomerSPAN(java.lang.String token, java.lang.String siteID, java.lang.String keyCode, boolean deleteAlreadyMigratedInVault) {
        customerInfoSoap.migrateCustomerSPAN(clientID, token, siteID, keyCode, deleteAlreadyMigratedInVault)
    }
    def writeCustomerSPAN(java.lang.String token, java.lang.String siteID, long customerAccount, int customerID, int billingID, org.apache.axis.types.UnsignedByte accountType, org.apache.axis.types.UnsignedByte bankAccountType, org.apache.axis.types.UnsignedByte bankAccountClass, java.lang.String SPAN, java.lang.String accountNo, java.lang.String routingNo, int checkNo, java.util.Calendar expires, java.lang.String CCV, boolean recurring, java.lang.String cardHolderName, java.lang.String cardHolderAddress1, java.lang.String cardHolderAddress2, java.lang.String cardHolderCity, java.lang.String cardHolderState, java.lang.String cardHolderZip, java.util.Calendar lastUsedDate, java.lang.String lastAuthResult, java.lang.String lastAuthID, java.lang.String lastRefID) {
         customerInfoSoap.writeCustomerSPAN(clientID, token, siteID, customerAccount, customerID, billingID, accountType, bankAccountType, bankAccountClass, SPAN, accountNo, routingNo,checkNo, expires, CCV, recurring, cardHolderName, cardHolderAddress1, cardHolderAddress2, cardHolderCity, cardHolderState, cardHolderZip, lastUsedDate, lastAuthResult, lastAuthID, lastRefID)
    }
    def readCustomerSPAN(java.lang.String token, java.lang.String siteID, long customerAccount, int customerID, int billingID) {
        customerInfoSoap.readCustomerSPAN(clientID, token, siteID, customerAccount, customerID, billingID)
    }

    ///////////////////////////
    // PAYMENT SOAP ///////////
    ///////////////////////////

    // According to Domico:
    // This web service will authorize or decline online payments and optionally send e-mail
    // notification to the customer and the facility.
    // Usage:
    //     Used for payments made when reserving a unit.
    //     Used for payments made via online customer account management.
    def authorize(java.lang.String token, java.lang.String siteID, int customerID, java.lang.String units, double chargeAmount, int CCType, java.lang.String CCNumberEncrypted, java.lang.String CCExpires, java.lang.String CCVEncrypted, java.lang.String nameOnCC, java.lang.String address1OnCC, java.lang.String address2OnCC, java.lang.String cityOnCC, java.lang.String stateOnCC, java.lang.String zipOnCC, boolean saveInfo, boolean recurring, boolean sendConfirmationEmail, java.lang.String emailContent, boolean isReservation) {
        paymentSoap.authorize(clientID, token, siteID, customerID, units, chargeAmount, CCType, CCNumberEncrypted, CCExpires, CCVEncrypted, nameOnCC, address1OnCC, address2OnCC, cityOnCC, stateOnCC, zipOnCC, saveInfo, recurring, sendConfirmationEmail, emailContent, isReservation)
    }

    // According to Domico:
    // This web service will authorize or decline online payments and optionally send e-mail
    // notification to the customer and the facility.
    // Usage:
    //   Used for payments made when reserving a unit.
    //   Used for payments made via online customer account management.
    def authorizeACH(java.lang.String token, java.lang.String siteID, int customerID, java.lang.String units, double transactionAmount, int accountClass, java.lang.String accountNumber, int accountType, java.lang.String address1, java.lang.String address2, java.lang.String city, java.lang.String company, java.lang.String countryCode, java.lang.String customerTitle, java.lang.String birthDate, java.lang.String driversLicenseNumber, java.lang.String driversLicenseState, java.lang.String driversLicenseSwipe, java.lang.String email, java.lang.String fax, java.lang.String firstName, java.lang.String lastName, java.lang.String middleName, java.lang.String phone, java.lang.String postalCode, java.lang.String socSec, java.lang.String state, java.lang.String checkNumber, java.lang.String clerkID, java.lang.String currencyType, java.lang.String customerIPAddress, java.lang.String routingNumber, boolean saveInfo, boolean recurring, boolean sendConfirmationEmail, java.lang.String emailContent, boolean isReservation) {
        paymentSoap.authorizeACH(clientID, token, siteID, customerID,  units, transactionAmount, accountClass, accountNumber, accountType, address1, address2, city, company, countryCode, customerTitle, birthDate, driversLicenseNumber, driversLicenseState, driversLicenseSwipe, email, fax, firstName, lastName, middleName, phone, postalCode, socSec, state, checkNumber, clerkID, currencyType, customerIPAddress, routingNumber, saveInfo, recurring, sendConfirmationEmail, emailContent, isReservation)
    }

    // According to Domico:
    // This web service is used when a reservation is made that requires a payment/deposit
    // on the size/unit. These reservation types are made with three web services;
    // Authorize, ReserveUnit, PostPaymentExt.
    def postPaymentExt(java.lang.String token, java.lang.String siteID, int customerID, java.lang.String units, double chargeAmount, int CCType, java.lang.String CCNumberEncrypted, java.lang.String CCExpires, java.lang.String CCVEncrypted, java.lang.String nameOnCC, java.lang.String address1OnCC, java.lang.String address2OnCC, java.lang.String cityOnCC, java.lang.String stateOnCC, java.lang.String zipOnCC, boolean isReservation, java.lang.String refID, java.lang.String authID) {
        paymentSoap.postPaymentExt(clientID, token, siteID, customerID, units, chargeAmount, CCType, CCNumberEncrypted, CCExpires, CCVEncrypted, nameOnCC, address1OnCC, address2OnCC, cityOnCC, stateOnCC, zipOnCC, isReservation, refID, authID)
    }
    def encrypt(java.lang.String token, java.lang.String numberToEncrypt) {
        paymentSoap.encrypt(clientID, token, numberToEncrypt)
    }
    def updateBillingACH(java.lang.String token, java.lang.String siteID, int customerID, java.lang.String rountingNo, java.lang.String encryptedAccountNo, java.lang.String nameOnAccount, java.lang.String address1OnAccount, java.lang.String address2OnAccount, java.lang.String cityOnAccount, java.lang.String stateOnAccount, java.lang.String zipOnAccount, org.apache.axis.types.UnsignedByte accountClass, org.apache.axis.types.UnsignedByte accountTypeACH, java.lang.String driversLicenseNumber, java.lang.String driversLicenseState, java.util.Calendar birthDate, java.lang.String countryCode, int checkNumber, boolean saveInfo, boolean recurring) {
        paymentSoap.updateBillingACH(clientID, token, siteID, customerID, rountingNo, encryptedAccountNo, nameOnAccount, address1OnAccount, address2OnAccount, cityOnAccount, stateOnAccount, zipOnAccount, accountClass, accountTypeACH, driversLicenseNumber, driversLicenseState, birthDate, countryCode, checkNumber, saveInfo, recurring)
    }
    def updateBilling(java.lang.String token, java.lang.String siteID, int customerID, int CCType, java.lang.String CCNumberEncrypted, java.lang.String CCExpires, java.lang.String CCVEncrypted, java.lang.String nameOnCC, java.lang.String address1OnCC, java.lang.String address2OnCC, java.lang.String cityOnCC, java.lang.String stateOnCC, java.lang.String zipOnCC, boolean saveInfo, boolean recurring) {
        paymentSoap.updateBilling(clientID, token, siteID, customerID, CCType, CCNumberEncrypted, CCExpires, CCVEncrypted, nameOnCC, address1OnCC, address2OnCC, cityOnCC, stateOnCC, zipOnCC, saveInfo, recurring)
    }

    ///////////////////////////
    // RESERVATION SOAP ///////
    ///////////////////////////

    // According to Domico:
    // This web service will process an online reservation, supporting payment or nopayment
    // options in addition to e-mail content/sending options.
    // Note: Note: online reservations will always create NEW accounts even if an existing
    //       customer (multiple accounts for each unit/size for same customer)
    def reserveUnit(java.lang.String token, java.lang.String siteID, int unitID, int sizeID, java.lang.String lastName, java.lang.String firstName, java.lang.String middleInitial, java.lang.String EMailAddress, java.lang.String address1, java.lang.String address2, java.lang.String city, java.lang.String state, java.lang.String zip, java.lang.String homePhone, java.lang.String cellPhone, boolean sendConfirmationEmail, java.lang.String emailContent, double depositAmount) {
      com.edomico.www.ReserveUnitResponseReserveUnitResult reserveUnitResponseReserveUnitResult = reservationSoap.reserveUnit(clientID, token, siteID, unitID, sizeID, lastName, firstName, middleInitial, EMailAddress, address1, address2, city, state, zip, homePhone, cellPhone, sendConfirmationEmail, emailContent, depositAmount)
      org.w3c.dom.NodeList reservationResults =  Util.getTopLevelNodeList(reserveUnitResponseReserveUnitResult,"Authorize")
      org.w3c.dom.Node n = reservationResults.item(0)
      org.w3c.dom.NodeList childNodes = n.childNodes
      def results =  new EDomicoNode (childNodes)
      return results
    }
}
