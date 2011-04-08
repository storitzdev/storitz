/**
 * Reservation.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.edomico.www;

public interface Reservation extends javax.xml.rpc.Service {

/**
 * Makes a reservation based on Size/Unit selected.
 */
    public java.lang.String getReservationSoap12Address();

    public com.edomico.www.ReservationSoap getReservationSoap12() throws javax.xml.rpc.ServiceException;

    public com.edomico.www.ReservationSoap getReservationSoap12(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
    public java.lang.String getReservationSoapAddress();

    public com.edomico.www.ReservationSoap getReservationSoap() throws javax.xml.rpc.ServiceException;

    public com.edomico.www.ReservationSoap getReservationSoap(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
