package storitz

import com.storitz.Feed
import com.storitz.StorageSite
import com.edomico.www.*

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
    private final int clientID = 443
    private final String webServicesKey = "uBvQoE0DtVTMQA8xCv57A3Rw"

    static transactional = true

    def serviceMethod() {

    }

    @Override
    loadInsurance(Feed feed, StorageSite site) {
        return null  //To change body of implemented methods use File | Settings | File Templates.
    }

    // encapsulated eDomico web services

    // COMMON METHODS SOAP

    // call this method first!
    // returns a new web services session token
    def readToken() {
        return commonMethodsSoap.readToken(clientID, webServicesKey)
    }

    // AVAILABLE UNITS SOAP
    def readSiteID(java.lang.String token, java.lang.String address, java.lang.String city, java.lang.String zip) {
        return availableUnitsSizesSoap.readSiteID(clientID, token, address, city, zip)
    }
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
    def readUnitID(java.lang.String token, java.lang.String siteID, int sizeID) {
        return availableUnitsSizesSoap.readUnitID(clientID, token, siteID, sizeID)
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
    // Same as readUnitInfo, but returns all possible units, not just one
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

    // CUSTOMER INFO SOAP
    def findCustomer(java.lang.String token, java.lang.String userIDEncrypted, java.lang.String passwordEncrypted, boolean occupiedOnly) {
        customerInfoSoap.findCustomer(clientID, token, userIDEncrypted, passwordEncrypted, occupiedOnly)
    }
    def readCustomerInfo(java.lang.String token, int customerID) {
        customerInfoSoap.readCustomerInfo(clientID, token, customerID)
    }
    def changePassword(java.lang.String token, int customerID, java.lang.String oldPasswordEncrypted, java.lang.String newPasswordEncrypted, boolean sendEmailConfirmation, java.lang.String sendEmailContent) {
        customerInfoSoap.changePassword(clientID, token, customerID, oldPasswordEncrypted, newPasswordEncrypted, sendEmailConfirmation, sendEmailContent)
    }
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

    // PAYMENT SOAP
    def authorize(java.lang.String token, java.lang.String siteID, int customerID, java.lang.String units, double chargeAmount, int CCType, java.lang.String CCNumberEncrypted, java.lang.String CCExpires, java.lang.String CCVEncrypted, java.lang.String nameOnCC, java.lang.String address1OnCC, java.lang.String address2OnCC, java.lang.String cityOnCC, java.lang.String stateOnCC, java.lang.String zipOnCC, boolean saveInfo, boolean recurring, boolean sendConfirmationEmail, java.lang.String emailContent, boolean isReservation) {
        paymentSoap.authorize(clientID, token, siteID, customerID, units, chargeAmount, CCType, CCNumberEncrypted, CCExpires, CCVEncrypted, nameOnCC, address1OnCC, address2OnCC, cityOnCC, stateOnCC, zipOnCC, saveInfo, recurring, sendConfirmationEmail, emailContent, isReservation)
    }
    def authorizeACH(java.lang.String token, java.lang.String siteID, int customerID, java.lang.String units, double transactionAmount, int accountClass, java.lang.String accountNumber, int accountType, java.lang.String address1, java.lang.String address2, java.lang.String city, java.lang.String company, java.lang.String countryCode, java.lang.String customerTitle, java.lang.String birthDate, java.lang.String driversLicenseNumber, java.lang.String driversLicenseState, java.lang.String driversLicenseSwipe, java.lang.String email, java.lang.String fax, java.lang.String firstName, java.lang.String lastName, java.lang.String middleName, java.lang.String phone, java.lang.String postalCode, java.lang.String socSec, java.lang.String state, java.lang.String checkNumber, java.lang.String clerkID, java.lang.String currencyType, java.lang.String customerIPAddress, java.lang.String routingNumber, boolean saveInfo, boolean recurring, boolean sendConfirmationEmail, java.lang.String emailContent, boolean isReservation) {
        paymentSoap.authorizeACH(clientID, token, siteID, customerID,  units, transactionAmount, accountClass, accountNumber, accountType, address1, address2, city, company, countryCode, customerTitle, birthDate, driversLicenseNumber, driversLicenseState, driversLicenseSwipe, email, fax, firstName, lastName, middleName, phone, postalCode, socSec, state, checkNumber, clerkID, currencyType, customerIPAddress, routingNumber, saveInfo, recurring, sendConfirmationEmail, emailContent, isReservation)
    }
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

    // RESERVATION SOAP
    def reserveUnit(java.lang.String token, java.lang.String siteID, int unitID, int sizeID, java.lang.String lastName, java.lang.String firstName, java.lang.String middleInitial, java.lang.String EMailAddress, java.lang.String address1, java.lang.String address2, java.lang.String city, java.lang.String state, java.lang.String zip, java.lang.String homePhone, java.lang.String cellPhone, boolean sendConfirmationEmail, java.lang.String emailContent, double depositAmount) {
        reservationSoap.reserveUnit(clientID, token, siteID, unitID, sizeID, lastName, firstName, middleInitial, EMailAddress, address1, address2, city, state, zip, homePhone, cellPhone, sendConfirmationEmail, emailContent, depositAmount)
    }
}
