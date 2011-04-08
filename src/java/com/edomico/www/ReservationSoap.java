/**
 * ReservationSoap.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.edomico.www;

public interface ReservationSoap extends java.rmi.Remote {
    public com.edomico.www.ReserveUnitResponseReserveUnitResult reserveUnit(int clientID, java.lang.String token, java.lang.String siteID, int unitID, int sizeID, java.lang.String lastName, java.lang.String firstName, java.lang.String middleInitial, java.lang.String EMailAddress, java.lang.String address1, java.lang.String address2, java.lang.String city, java.lang.String state, java.lang.String zip, java.lang.String homePhone, java.lang.String cellPhone, boolean sendConfirmationEmail, java.lang.String emailContent, double depositAmount) throws java.rmi.RemoteException;
}
