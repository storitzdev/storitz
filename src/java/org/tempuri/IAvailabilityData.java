/**
 * IAvailabilityData.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public interface IAvailabilityData extends java.rmi.Remote {
    public org.datacontract.schemas._2004._07.StorageMart_Services.FacilityOutput[] loadFacilities(org.datacontract.schemas._2004._07.StorageMart_Services.Credentials credentials) throws java.rmi.RemoteException;
    public org.datacontract.schemas._2004._07.StorageMart_Services.UnitTypeOutput[] loadUnitTypesByFacility(org.datacontract.schemas._2004._07.StorageMart_Services.Credentials credentials, java.lang.String facilityId) throws java.rmi.RemoteException;
    public java.lang.Integer addReservation(org.datacontract.schemas._2004._07.StorageMart_Services.Credentials credentials, org.datacontract.schemas._2004._07.StorageMart_Services.ReservationRequest request) throws java.rmi.RemoteException;
}
