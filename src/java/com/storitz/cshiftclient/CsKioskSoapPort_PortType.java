/**
 * CsKioskSoapPort_PortType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.storitz.cshiftclient;

public interface CsKioskSoapPort_PortType extends java.rmi.Remote {
    public java.lang.Object getKioskMerchandise(java.lang.String pUser, java.lang.String pPIN, long pSiteID) throws java.rmi.RemoteException;

    public java.lang.String kioskVer() throws java.rmi.RemoteException;

    public java.lang.Object getSiteHours(java.lang.String pUser, java.lang.String pPIN, long pSiteID) throws java.rmi.RemoteException;

    public java.lang.Object getSiteDirections(java.lang.String pUser, java.lang.String pPIN, long pSiteID) throws java.rmi.RemoteException;

    public java.lang.Object getSitePhones(java.lang.String pUser, java.lang.String pPIN, long pSiteID) throws java.rmi.RemoteException;

    public java.lang.Object getSiteAddress(java.lang.String pUser, java.lang.String pPIN, long pSiteID) throws java.rmi.RemoteException;

    public java.lang.Object getSiteUnitData(java.lang.String pUser, java.lang.String pPIN, long pSiteID) throws java.rmi.RemoteException;

    public int createAccount(java.lang.String pUser, java.lang.String pPIN, long pSiteID, java.lang.String pTenantFirstName, java.lang.String pTenantLastName, java.lang.String pMailALine1, java.lang.String pMailALine2, java.lang.String pMailACity, java.lang.String pMailAState, java.lang.String pMailAZip, java.lang.String pMailACountry, java.lang.String pTenantPhone, long pTenantPhoneType, java.lang.String pTenantPassword, java.lang.String pDriversLicenseNum, java.lang.String pDriversLicenseST, java.lang.String pDriversLicenseEXP, java.lang.String pGatePIN, java.lang.String pGateTimeZone, java.lang.String pGateKeypadZone) throws java.rmi.RemoteException;

    public java.lang.Object getSiteList(java.lang.String pUser, java.lang.String pPIN) throws java.rmi.RemoteException;

    public java.lang.Object getAvailableUnits(java.lang.String pUser, java.lang.String pPIN, long pSiteID, long pAttributeID, java.lang.String pDimensions) throws java.rmi.RemoteException;

    public java.lang.Object getMoveInCost(java.lang.String pUser, java.lang.String pPIN, long pSiteID, java.lang.String pUnitIDs, java.lang.String pInsuranceIDs) throws java.rmi.RemoteException;

    public java.lang.String doMoveIn(java.lang.String pUser, java.lang.String pPIN, long pSiteID, long pAccountID, java.lang.String pUnitIDs, java.lang.String pInsuranceIDs, java.lang.String pPaymentString, java.lang.String pCCNumOrABA, java.lang.String pCCNameOnCardOrCheckingAccountNum, java.lang.String pCCExpirationMonthOrAccountName, java.lang.String pCCExpirationYear, java.lang.String pCCZipCode, java.lang.String pPayMethod) throws java.rmi.RemoteException;

    public int updateTenantInfo(java.lang.String pUser, java.lang.String pPIN, long pTenantID, java.lang.String pTenantFirstName, java.lang.String pTenantLastName, java.lang.String pDriversLicenseNum, java.lang.String pDriversLicenseST, java.lang.String pDriversLicenseEXP) throws java.rmi.RemoteException;

    public int updateTenantAddress(java.lang.String pUser, java.lang.String pPIN, long pTenantID, long pAddressID, java.lang.String pLine1, java.lang.String pLine2, java.lang.String pCity, java.lang.String pState, java.lang.String pZip, java.lang.String pCountry, int pAddressType) throws java.rmi.RemoteException;

    public int updateTenantPhone(java.lang.String pUser, java.lang.String pPIN, long pTenantID, long pPhoneID, java.lang.String pTenantPhone, int pPhoneType) throws java.rmi.RemoteException;

    public java.lang.Object getTenantAddress(java.lang.String pUser, java.lang.String pPIN, long pTenantID, int pAddressType) throws java.rmi.RemoteException;

    public java.lang.Object getTenantPhone(java.lang.String pUser, java.lang.String pPIN, long pTenantID, int pPhoneType) throws java.rmi.RemoteException;

    public int updateTenantPassword(java.lang.String pUser, java.lang.String pPIN, long pTenantID, java.lang.String pOldPasswd, java.lang.String pNewPasswd) throws java.rmi.RemoteException;

    public java.lang.Object getAddressTypes() throws java.rmi.RemoteException;

    public java.lang.Object getPhoneTypes() throws java.rmi.RemoteException;

    public java.lang.Object listAccountUnits(java.lang.String pUser, java.lang.String pPIN, long pAccountID) throws java.rmi.RemoteException;

    public java.lang.Object getCurrentCharges(java.lang.String pUser, java.lang.String pPIN, long pSiteID, long pAccountID, short pMonths, long pItemId, long pItemPrice, long pItemQuantity) throws java.rmi.RemoteException;

    public java.lang.String makePayment(java.lang.String pUser, java.lang.String pPIN, long pSiteID, long pAccountID, java.lang.String pPaymentString, java.lang.String pCCNumOrABA, java.lang.String pCCNameOnCardOrCheckingAccountNum, java.lang.String pCCExpirationMonthOrAccountName, java.lang.String pCCExpirationYear, java.lang.String pCCZipCode, java.lang.String pPayMethod) throws java.rmi.RemoteException;

    public java.lang.String getPicture(java.lang.String pUser, java.lang.String pPIN, short pPictureType, long pTenantID, javax.xml.rpc.holders.ByteArrayHolder pFileObj) throws java.rmi.RemoteException;

    public void pictureReceived(java.lang.String pUser, java.lang.String pPIN, short pPictureType, long pTenantID) throws java.rmi.RemoteException;

    public int updateAccountName(java.lang.String pUser, java.lang.String pPIN, long pAccountID, java.lang.String pAccountName) throws java.rmi.RemoteException;

    public java.lang.String updatePicture(java.lang.String pUser, java.lang.String pPIN, long pSiteID, short pPictureType, long pTenantID, byte[] pFile) throws java.rmi.RemoteException;

    public java.lang.Object tenantLogin2(java.lang.String pUser, java.lang.String pPIN, java.lang.String pSiteID, java.lang.String pAccountID, java.lang.String pFirstName, java.lang.String pLastName, java.lang.String pUnitNumber, java.lang.String pGatePIN, java.lang.String pPhoneNumber, java.lang.String pPostal) throws java.rmi.RemoteException;

    public java.lang.Object tenantLogin(java.lang.String pUser, java.lang.String pPIN, long pSiteID, java.lang.String pAccountIDorUnitNumber, java.lang.String pPassword, java.lang.String pSearchBy) throws java.rmi.RemoteException;

    public java.lang.Object getInsuranceOptions(java.lang.String pUser, java.lang.String pPIN, java.lang.String pSiteID) throws java.rmi.RemoteException;

    public java.lang.String getContract(java.lang.String pUser, java.lang.String pPIN, long pSiteID, long pAccountID, long pTenantID, java.lang.String pUnitIDs, java.lang.String pInsuranceIDs, javax.xml.rpc.holders.ByteArrayHolder pFileObj) throws java.rmi.RemoteException;

    public java.lang.Object getMerchandiseCost(java.lang.String pUser, java.lang.String pPIN, long pSiteID, long pAccountID, java.lang.String pMerchandiseId, short pQuantity) throws java.rmi.RemoteException;

    public java.lang.String sellMerchandise(java.lang.String pUser, java.lang.String pPIN, long pSiteID, long pAccountID, java.lang.String pCCNumOrABA, java.lang.String pCCNameOnCardOrCheckingAccountNum, java.lang.String pCCExpirationMonthOrAccountName, java.lang.String pCCExpirationYear, java.lang.String pCCZipCode, java.lang.String pMerchandiseId, java.lang.String pQuantity, java.lang.String pPaymentString, java.lang.String pPayMethod) throws java.rmi.RemoteException;

    public java.lang.Object getInsuranceCost(java.lang.String pUser, java.lang.String pPIN, long pSiteID, long pAccountID, java.lang.String pUnitIDs, java.lang.String pInsuranceIDs) throws java.rmi.RemoteException;

    public java.lang.String sellInsurance(java.lang.String pUser, java.lang.String pPIN, long pSiteID, long pAccountID, java.lang.String pUnitIDs, java.lang.String pInsuranceIDs, java.lang.String pPaymentString, java.lang.String pCCNumOrABA, java.lang.String pCCNameOnCardOrCheckingAccountNum, java.lang.String pCCExpirationMonthOrAccountName, java.lang.String pCCExpirationYear, java.lang.String pCCZipCode, java.lang.String pPayMethod) throws java.rmi.RemoteException;

    public java.lang.Object getReservation(java.lang.String pUser, java.lang.String pPIN, long pSiteID, java.lang.String pReservationID) throws java.rmi.RemoteException;

    public java.lang.String updateAutoPay(java.lang.String pUser, java.lang.String pPIN, long pSiteID, long pAccountID, java.lang.String pUnitIDs, java.lang.String pCCNumOrABA, java.lang.String pCheckingAccountNum, java.lang.String pCCExpirationMonth, java.lang.String pCCExpirationYear, java.lang.String pAccountHolderName, java.lang.String pStreet, java.lang.String pCity, java.lang.String pState, java.lang.String pZip, java.lang.String pEmail, java.lang.String pDriversLicenseID, java.lang.String pCCorACH, java.lang.String pActive) throws java.rmi.RemoteException;

    public java.lang.Object getAutopayInf(java.lang.String pUser, java.lang.String pPIN, long pSiteID, long pAccountID, java.lang.String pUnitIDs) throws java.rmi.RemoteException;

    public java.lang.Object getAfterMoveInPromotions(java.lang.String pUser, java.lang.String pPIN, long pSiteID, long pAccountID, java.lang.String pUnitID) throws java.rmi.RemoteException;

    public java.lang.Object getPTDChangeCharges(java.lang.String pUser, java.lang.String pPIN, long pSiteID, long pAccountID, java.lang.String pDesiredPTD) throws java.rmi.RemoteException;

    public java.lang.Object getMoveOutCost(java.lang.String pUser, java.lang.String pPIN, long pSiteID, long pAccountID, long pUnitID) throws java.rmi.RemoteException;

    public int doMoveOut(java.lang.String pUser, java.lang.String pPIN, long pSiteID, long pAccountID, long pUnitID, java.lang.String pProcString, java.lang.String pCCNumOrABA, java.lang.String pCCNameOnCardOrCheckingAccountNum, java.lang.String pCCExpirationMonthOrAccountName, java.lang.String pCCExpirationYear, java.lang.String pCCZipCode, java.lang.String pPayMethod) throws java.rmi.RemoteException;

    public java.lang.Object getUnitTransferCharges(java.lang.String pUser, java.lang.String pPIN, long pSiteID, long pAccountID, long pCurrentUnitID, long pNewUnitID) throws java.rmi.RemoteException;

    public int doUnitTransfer(java.lang.String pUser, java.lang.String pPIN, long pSiteID, long pAccountID, long pCurrentUnitID, long pNewUnitID, java.lang.String pProcString, java.lang.String pCCNumOrABA, java.lang.String pCCNameOnCardOrCheckingAccountNum, java.lang.String pCCExpirationMonthOrAccountName, java.lang.String pCCExpirationYear, java.lang.String pCCZipCode, java.lang.String pPayMethod) throws java.rmi.RemoteException;

    public java.lang.String TEST() throws java.rmi.RemoteException;
}
