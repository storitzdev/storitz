package storitz

import com.storitz.Feed
import com.storitz.StorageSite
import com.edomico.www.*

class EDomicoService extends BaseProviderService {

    private AvailableUnitsSizesSoap availableUnitsSizesSoap = new AvailableUnitsSizesSoap12Stub()
    private CommonMethodsSoap commonMethodsSoap = new CommonMethodsSoap12Stub()
    private CustomerInfoSoap customerInfoSoap = new CustomerInfoSoap12Stub()
    private PaymentSoap paymentSoap = new PaymentSoap12Stub()
    private ReservationSoap reservationSoap = new ReservationSoap12Stub()

    static transactional = true

    def serviceMethod() {

    }

    @Override
    loadInsurance(Feed feed, StorageSite site) {
        return null  //To change body of implemented methods use File | Settings | File Templates.
    }

    // encapsulated eDomico web services
    def readSiteID(int clientID, java.lang.String token, java.lang.String address, java.lang.String city, java.lang.String zip) {
        availableUnitsSizesSoap.readSiteID(clientID, token, address, city, zip)
    }
    def readSizes(int clientID, java.lang.String token, java.lang.String siteID) {
        availableUnitsSizesSoap.readSizes(clientID, token, siteID)
    }
    def readUnitInfo(int clientID, java.lang.String token, java.lang.String siteID, int sizeID) {
         availableUnitsSizesSoap.readUnitInfo(clientID, token, siteID, sizeID)
    }
    def readUnits(int clientID, java.lang.String token, java.lang.String siteID, int sizeID) {
         availableUnitsSizesSoap.readUnits(clientID, token, siteID, sizeID)
    }
    def readUnitID(int clientID, java.lang.String token, java.lang.String siteID, int sizeID) {
         availableUnitsSizesSoap.readUnitID(clientID, token, siteID, sizeID)
    }
    def readToken(int clientID, java.lang.String key) {
        commonMethodsSoap.readToken(clientID, key)
    }
    def findCustomer(int clientID, java.lang.String token, java.lang.String userIDEncrypted, java.lang.String passwordEncrypted, boolean occupiedOnly) {
        customerInfoSoap.findCustomer(clientID, token, userIDEncrypted, passwordEncrypted, occupiedOnly)
    }
    def deleteCustomerSPAN(int clientID, java.lang.String token, java.lang.String siteID, long customerAccount, int customerID) {
        customerInfoSoap.deleteCustomerSPAN(clientID, token, siteID, customerAccount, customerID)
    }
    def removeMigratedCustomerBilling(int clientID, java.lang.String token, java.lang.String siteID, java.lang.String keyCode) {
        customerInfoSoap.removeMigratedCustomerBilling(clientID, token, siteID, keyCode)
    }
    def migrateCustomerSPAN(int clientID, java.lang.String token, java.lang.String siteID, java.lang.String keyCode, boolean deleteAlreadyMigratedInVault) {
        customerInfoSoap.migrateCustomerSPAN(clientID, token, siteID, keyCode, deleteAlreadyMigratedInVault)
    }
    def writeCustomerSPAN(int clientID, java.lang.String token, java.lang.String siteID, long customerAccount, int customerID, int billingID, org.apache.axis.types.UnsignedByte accountType, org.apache.axis.types.UnsignedByte bankAccountType, org.apache.axis.types.UnsignedByte bankAccountClass, java.lang.String SPAN, java.lang.String accountNo, java.lang.String routingNo, int checkNo, java.util.Calendar expires, java.lang.String CCV, boolean recurring, java.lang.String cardHolderName, java.lang.String cardHolderAddress1, java.lang.String cardHolderAddress2, java.lang.String cardHolderCity, java.lang.String cardHolderState, java.lang.String cardHolderZip, java.util.Calendar lastUsedDate, java.lang.String lastAuthResult, java.lang.String lastAuthID, java.lang.String lastRefID) {
         customerInfoSoap.writeCustomerSPAN(clientID, token, siteID, customerAccount, customerID, billingID, accountType, bankAccountType, bankAccountClass, SPAN, accountNo, routingNo,checkNo, expires, CCV, recurring, cardHolderName, cardHolderAddress1, cardHolderAddress2, cardHolderCity, cardHolderState, cardHolderZip, lastUsedDate, lastAuthResult, lastAuthID, lastRefID)
    }
    def readCustomerSPAN(int clientID, java.lang.String token, java.lang.String siteID, long customerAccount, int customerID, int billingID) {
        customerInfoSoap.readCustomerSPAN(clientID, token, siteID, customerAccount, customerID, billingID)
    }
    def readCustomerInfo(int clientID, java.lang.String token, int customerID) {
        customerInfoSoap.readCustomerInfo(clientID, token, customerID)
    }
    def changePassword(int clientID, java.lang.String token, int customerID, java.lang.String oldPasswordEncrypted, java.lang.String newPasswordEncrypted, boolean sendEmailConfirmation, java.lang.String sendEmailContent) {
        customerInfoSoap.changePassword(clientID, token, customerID, oldPasswordEncrypted, newPasswordEncrypted, sendEmailConfirmation, sendEmailContent)
    }
    def changeAddress(int clientID, java.lang.String token, int customerID, java.lang.String newAddress1, java.lang.String newAddress2, java.lang.String newCity, java.lang.String newState, java.lang.String newZip, java.lang.String newHomePhone, java.lang.String newCellPhone, boolean sendEmailConfirmation, java.lang.String sendEmailContent) {
        customerInfoSoap.changeAddress(clientID, token, customerID, newAddress1, newAddress2, newCity, newState, newZip, newHomePhone, newCellPhone, sendEmailConfirmation, sendEmailContent)
    }
    def authorizeACH(int clientID, java.lang.String token, java.lang.String siteID, int customerID, java.lang.String units, double transactionAmount, int accountClass, java.lang.String accountNumber, int accountType, java.lang.String address1, java.lang.String address2, java.lang.String city, java.lang.String company, java.lang.String countryCode, java.lang.String customerTitle, java.lang.String birthDate, java.lang.String driversLicenseNumber, java.lang.String driversLicenseState, java.lang.String driversLicenseSwipe, java.lang.String email, java.lang.String fax, java.lang.String firstName, java.lang.String lastName, java.lang.String middleName, java.lang.String phone, java.lang.String postalCode, java.lang.String socSec, java.lang.String state, java.lang.String checkNumber, java.lang.String clerkID, java.lang.String currencyType, java.lang.String customerIPAddress, java.lang.String routingNumber, boolean saveInfo, boolean recurring, boolean sendConfirmationEmail, java.lang.String emailContent, boolean isReservation) {
        paymentSoap.authorizeACH(clientID, token, siteID, customerID,  units, transactionAmount, accountClass, accountNumber, accountType, address1, address2, city, company, countryCode, customerTitle, birthDate, driversLicenseNumber, driversLicenseState, driversLicenseSwipe, email, fax, firstName, lastName, middleName, phone, postalCode, socSec, state, checkNumber, clerkID, currencyType, customerIPAddress, routingNumber, saveInfo, recurring, sendConfirmationEmail, emailContent, isReservation)
    }
    def authorize(int clientID, java.lang.String token, java.lang.String siteID, int customerID, java.lang.String units, double chargeAmount, int CCType, java.lang.String CCNumberEncrypted, java.lang.String CCExpires, java.lang.String CCVEncrypted, java.lang.String nameOnCC, java.lang.String address1OnCC, java.lang.String address2OnCC, java.lang.String cityOnCC, java.lang.String stateOnCC, java.lang.String zipOnCC, boolean saveInfo, boolean recurring, boolean sendConfirmationEmail, java.lang.String emailContent, boolean isReservation) {
        paymentSoap.authorize(clientID, token, siteID, customerID, units, chargeAmount, CCType, CCNumberEncrypted, CCExpires, CCVEncrypted, nameOnCC, address1OnCC, address2OnCC, cityOnCC, stateOnCC, zipOnCC, saveInfo, recurring, sendConfirmationEmail, emailContent, isReservation)
    }
    def encrypt(int clientID, java.lang.String token, java.lang.String numberToEncrypt) {
        paymentSoap.encrypt(clientID, token, numberToEncrypt)
    }
    def updateBillingACH(int clientID, java.lang.String token, java.lang.String siteID, int customerID, java.lang.String rountingNo, java.lang.String encryptedAccountNo, java.lang.String nameOnAccount, java.lang.String address1OnAccount, java.lang.String address2OnAccount, java.lang.String cityOnAccount, java.lang.String stateOnAccount, java.lang.String zipOnAccount, org.apache.axis.types.UnsignedByte accountClass, org.apache.axis.types.UnsignedByte accountTypeACH, java.lang.String driversLicenseNumber, java.lang.String driversLicenseState, java.util.Calendar birthDate, java.lang.String countryCode, int checkNumber, boolean saveInfo, boolean recurring) {
        paymentSoap.updateBillingACH(clientID, token, siteID, customerID, rountingNo, encryptedAccountNo, nameOnAccount, address1OnAccount, address2OnAccount, cityOnAccount, stateOnAccount, zipOnAccount, accountClass, accountTypeACH, driversLicenseNumber, driversLicenseState, birthDate, countryCode, checkNumber, saveInfo, recurring)
    }
    def updateBilling(int clientID, java.lang.String token, java.lang.String siteID, int customerID, int CCType, java.lang.String CCNumberEncrypted, java.lang.String CCExpires, java.lang.String CCVEncrypted, java.lang.String nameOnCC, java.lang.String address1OnCC, java.lang.String address2OnCC, java.lang.String cityOnCC, java.lang.String stateOnCC, java.lang.String zipOnCC, boolean saveInfo, boolean recurring) {
        paymentSoap.updateBilling(clientID, token, siteID, customerID, CCType, CCNumberEncrypted, CCExpires, CCVEncrypted, nameOnCC, address1OnCC, address2OnCC, cityOnCC, stateOnCC, zipOnCC, saveInfo, recurring)
    }
    def postPaymentExt(int clientID, java.lang.String token, java.lang.String siteID, int customerID, java.lang.String units, double chargeAmount, int CCType, java.lang.String CCNumberEncrypted, java.lang.String CCExpires, java.lang.String CCVEncrypted, java.lang.String nameOnCC, java.lang.String address1OnCC, java.lang.String address2OnCC, java.lang.String cityOnCC, java.lang.String stateOnCC, java.lang.String zipOnCC, boolean isReservation, java.lang.String refID, java.lang.String authID) {
        paymentSoap.postPaymentExt(clientID, token, siteID, customerID, units, chargeAmount, CCType, CCNumberEncrypted, CCExpires, CCVEncrypted, nameOnCC, address1OnCC, address2OnCC, cityOnCC, stateOnCC, zipOnCC, isReservation, refID, authID)
    }
    def reserveUnit(int clientID, java.lang.String token, java.lang.String siteID, int unitID, int sizeID, java.lang.String lastName, java.lang.String firstName, java.lang.String middleInitial, java.lang.String EMailAddress, java.lang.String address1, java.lang.String address2, java.lang.String city, java.lang.String state, java.lang.String zip, java.lang.String homePhone, java.lang.String cellPhone, boolean sendConfirmationEmail, java.lang.String emailContent, double depositAmount) {
        reservationSoap.reserveUnit(clientID, token, siteID, unitID, sizeID, lastName, firstName, middleInitial, EMailAddress, address1, address2, city, state, zip, homePhone, cellPhone, sendConfirmationEmail, emailContent, depositAmount)
    }
}
