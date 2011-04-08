/**
 * AvailableUnitsSizesSoap.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.edomico.www;

public interface AvailableUnitsSizesSoap extends java.rmi.Remote {
    public java.lang.String readSiteID(int clientID, java.lang.String token, java.lang.String address, java.lang.String city, java.lang.String zip) throws java.rmi.RemoteException;
    public com.edomico.www.ReadSizesResponseReadSizesResult readSizes(int clientID, java.lang.String token, java.lang.String siteID) throws java.rmi.RemoteException;
    public com.edomico.www.ReadUnitInfoResponseReadUnitInfoResult readUnitInfo(int clientID, java.lang.String token, java.lang.String siteID, int sizeID) throws java.rmi.RemoteException;
    public com.edomico.www.ReadUnitsResponseReadUnitsResult readUnits(int clientID, java.lang.String token, java.lang.String siteID, int sizeID) throws java.rmi.RemoteException;
    public int readUnitID(int clientID, java.lang.String token, java.lang.String siteID, int sizeID) throws java.rmi.RemoteException;
}
