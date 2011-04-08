/**
 * CustomerInfoSoap.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.edomico.www;

public interface CustomerInfoSoap extends java.rmi.Remote {
    public com.edomico.www.FindCustomerResponseFindCustomerResult findCustomer(int clientID, java.lang.String token, java.lang.String userIDEncrypted, java.lang.String passwordEncrypted, boolean occupiedOnly) throws java.rmi.RemoteException;
    public int deleteCustomerSPAN(int clientID, java.lang.String token, java.lang.String siteID, long customerAccount, int customerID) throws java.rmi.RemoteException;
    public boolean removeMigratedCustomerBilling(int clientID, java.lang.String token, java.lang.String siteID, java.lang.String keyCode) throws java.rmi.RemoteException;
    public long migrateCustomerSPAN(int clientID, java.lang.String token, java.lang.String siteID, java.lang.String keyCode, boolean deleteAlreadyMigratedInVault) throws java.rmi.RemoteException;
    public boolean writeCustomerSPAN(int clientID, java.lang.String token, java.lang.String siteID, long customerAccount, int customerID, int billingID, org.apache.axis.types.UnsignedByte accountType, org.apache.axis.types.UnsignedByte bankAccountType, org.apache.axis.types.UnsignedByte bankAccountClass, java.lang.String SPAN, java.lang.String accountNo, java.lang.String routingNo, int checkNo, java.util.Calendar expires, java.lang.String CCV, boolean recurring, java.lang.String cardHolderName, java.lang.String cardHolderAddress1, java.lang.String cardHolderAddress2, java.lang.String cardHolderCity, java.lang.String cardHolderState, java.lang.String cardHolderZip, java.util.Calendar lastUsedDate, java.lang.String lastAuthResult, java.lang.String lastAuthID, java.lang.String lastRefID) throws java.rmi.RemoteException;
    public com.edomico.www.ReadCustomerSPANResponseReadCustomerSPANResult readCustomerSPAN(int clientID, java.lang.String token, java.lang.String siteID, long customerAccount, int customerID, int billingID) throws java.rmi.RemoteException;
    public com.edomico.www.ReadCustomerInfoResponseReadCustomerInfoResult readCustomerInfo(int clientID, java.lang.String token, int customerID) throws java.rmi.RemoteException;
    public java.lang.String changePassword(int clientID, java.lang.String token, int customerID, java.lang.String oldPasswordEncrypted, java.lang.String newPasswordEncrypted, boolean sendEmailConfirmation, java.lang.String sendEmailContent) throws java.rmi.RemoteException;
    public java.lang.String changeAddress(int clientID, java.lang.String token, int customerID, java.lang.String newAddress1, java.lang.String newAddress2, java.lang.String newCity, java.lang.String newState, java.lang.String newZip, java.lang.String newHomePhone, java.lang.String newCellPhone, boolean sendEmailConfirmation, java.lang.String sendEmailContent) throws java.rmi.RemoteException;
}
