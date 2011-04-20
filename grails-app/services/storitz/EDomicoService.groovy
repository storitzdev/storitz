package storitz

import com.storitz.Feed
import com.storitz.EDomico
import com.storitz.StorageSite
import com.edomico.www.*
import java.io.PrintWriter
import com.storitz.EDomicoLocation
import storitz.constants.TruckType
import storitz.constants.TransactionType
import com.storitz.StorageUnit
import storitz.constants.UnitType
import storitz.constants.SearchType

class EDomicoService extends BaseProviderService {

    /**
     * Contact Information:
     * Leslie Ainscough 800-688-6181
     *
     * Login Credentials:
     * eDomico Client ID: 443
     * eDomico Web Service Key: uBvQoE0DtVTMQA8xCv57A3Rw
     */


    private AvailableUnitsSizesSoap availableUnitsSizesSoap = new AvailableUnitsSizesSoap12Stub(new URL("https://www.edomico.com/WebServices/AvailableUnits.asmx"),null)
    private CommonMethodsSoap commonMethodsSoap = new CommonMethodsSoap12Stub(new URL("https://www.edomico.com/WebServices/Common.asmx"),null)
    private CustomerInfoSoap customerInfoSoap = new CustomerInfoSoap12Stub(new URL("https://www.edomico.com/WebServices/CustomerInfo.asmx"),null)
    private PaymentSoap paymentSoap = new PaymentSoap12Stub(new URL("https://www.edomico.com/WebServices/Payment.asmx"),null)
    private ReservationSoap reservationSoap = new ReservationSoap12Stub(new URL("https://www.edomico.com/WebServices/Reservation.asmx"),null)
    private int clientID
    private String webServicesKey

    static transactional = true

    public EDomicoService (int id, String key) {
         clientID = id
         webServicesKey = key
    }

    def serviceMethod() {

    }

    @Override
    loadInsurance(Feed feed, StorageSite site) {
        return null  //To change body of implemented methods use File | Settings | File Templates.
    }

    // Called by EDomicoController class when a feed is first created
    def loadSites(EDomico instance, String feedType, SiteStats stats, PrintWriter writer) {
        // Get a list of the EDomicoLocation objects associated with this EDomico feed
        List<EDomicoLocation> locations = instance.locations?.asList()

        // Iterate through these locations, processing each StorageSite in turn
        for (int i = 0; i < locations.size(); i++) {
            EDomicoLocation location = locations.get(i)
            StorageSite storageSite = getStorageSiteFromEDomicoLocation(location, stats)
            // do some magic
            storageSite.address     = location.address1
            storageSite.city        = location.city
            storageSite.state       = instance.state
            storageSite.title       = location.siteName
            storageSite.description = instance.operatorName
            storageSite.zipcode     = location.zipcode
            storageSite.sourceId    = location.siteID
            storageSite.sourceLoc   = location.siteName
            storageSite.feed        = instance

            // now handle the associated units for this site
            updateUnits(storageSite, stats, writer)

            // and save
            storageSite.save(flush: true)

        }
    }

    def updateUnits(StorageSite site, SiteStats stats, PrintWriter writer) {
        EDomico feed = (EDomico)site.feed
        EDomicoService service = new EDomicoService(feed.edomicoClientID,feed.edomicoWebServicesKey)
        def token = service.readToken()
        def siteID  = service.readSiteID(token,site.address,site.city,site.zipcode)
        def sizes = service.readSizes(token,siteID)

        for (sz in sizes) {
            def sizeID = new Integer(sz.get("SizeID")).intValue()
            def units = service.readUnits(token,siteID,sizeID)
            def currentUpdateCount = stats.updateCount
            StorageUnit storageUnit = getStorageUnitByNameAndNumber(site,sz.get("SiteID"),sz.get("SizeID"),stats)
            storageUnit.unitTypeInfo = sz.get("SizeCodeInfo")
            storageUnit.price = new Double(sz.get("SizeRentRate")).doubleValue()
            storageUnit.pushRate = new Double(sz.get("SizeRentRate")).doubleValue()
            storageUnit.displaySize = sz.get("SizeCodeInfo")
            storageUnit.unitSizeInfo = sz.get("SizeCodeInfo")
            def unitSize = getUnitSize(sz.get("SizeCodeInfo"))
            if (!unitSize) {
                writer.append("Cannot determine unitSize for " + sz.get("SizeCodeInfo") + ". Skipping")
                continue
            }
            storageUnit.unitsize = unitSize
            storageUnit.description = getStorageUnitDescription(sz.get("SizeCodeInfo"))
            storageUnit.unitCount = units.size()
            storageUnit.deposit = new Double(sz.get("SizeRentRateReservationDeposit")).doubleValue()

            // Looks good to go. Wrap up and move on to the next.
            stats.unitCount += 1
            storageUnit.save()     // no need to flush since the site flush will handle that momentarily
            site.addToUnits(storageUnit)
            site.save(flush: true) // save here just in case we don't come in via 'loadSites'
        }
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

    def getUnitSize(String size) {
        String [] toks = size.split(" ");
        if (toks.length < 3) {
            return null
        }

        Double width
        Double length
        String rest

        try {
            width    = new Double(toks[0]).doubleValue();
            String x_ignore = toks[1];
            length   = new Double(toks[2]).doubleValue();
            rest     = "";
        }  catch (NumberFormatException e) {
            return null
        }

        for (int i = 3; i < toks.length; i++) {
            rest += " " + toks[i];
        }

        UnitSizeService unitSizeService = new UnitSizeService()

        return unitSizeService.getUnitSize(width,length,SearchType.STORAGE)
    }

    def getStorageUnitByNameAndNumber(StorageSite site, String name, String number, SiteStats stats) {
        def currentUnits = site.units

        // Find if one already exists
        for (unit in currentUnits) {
            if (unit.unitName == name && unit.unitNumber == number) {
                return unit
            }
        }

        // No luck? create a new one
        StorageUnit storageUnit = new StorageUnit()
        storageUnit.unitName = name
        storageUnit.unitNumber = number
        storageUnit.description = "Self Storage"
        storageUnit.isAvailable = true
        storageUnit.isSecure = false
        storageUnit.isTempControlled = false
        storageUnit.isAlarm = false
        storageUnit.isPowered = false
        storageUnit.isIrregular = false
        storageUnit.unitType = UnitType.INTERIOR
        return storageUnit
    }

    // Find a reference to the StorageSite mapped to this EDomicoLocation,
    // or create a new reference, as appropriate
    def getStorageSiteFromEDomicoLocation(EDomicoLocation location, SiteStats stats) {
        if (!location.site) {
            stats.createCount += 1
            location.site = newEDomicoStorageSite()
        }
        else {
            stats.updateCount += 1
        }
        return location.site
    }


    // called by the "Refresh Sites" button on the view page
    def refreshSites(EDomico instance, String feedType, SiteStats stats, PrintWriter writer) {
        loadSites(instance,feedType,stats,writer)
    }

    def newEDomicoStorageSite () {
        StorageSite storageSite = new StorageSite()

        // Basic Defaults
        storageSite.boxesAvailable = false
        storageSite.freeTruck = TruckType.NONE
        storageSite.isGate = false
        storageSite.isKeypad = false
        storageSite.isCamera = false
        storageSite.isUnitAlarmed = false
        storageSite.lastUpdate = 0
        storageSite.lat = 0
        storageSite.lng = 0
        storageSite.requiresInsurance = false
        storageSite.extendedHours = false
        storageSite.isManagerOnsite = false
        storageSite.source = 'DOM'             // data source
        storageSite.hasElevator = true
        storageSite.transactionType = TransactionType.RENTAL
        storageSite.lastChange = new Date()

        return storageSite
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
        reservationSoap.reserveUnit(clientID, token, siteID, unitID, sizeID, lastName, firstName, middleInitial, EMailAddress, address1, address2, city, state, zip, homePhone, cellPhone, sendConfirmationEmail, emailContent, depositAmount)
    }
}
