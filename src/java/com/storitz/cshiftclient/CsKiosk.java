/**
 * CsKiosk.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.storitz.cshiftclient;

public interface CsKiosk extends javax.xml.rpc.Service {
    public java.lang.String getcsKioskSoapPortAddress();

    public com.storitz.cshiftclient.CsKioskSoapPort_PortType getcsKioskSoapPort() throws javax.xml.rpc.ServiceException;

    public com.storitz.cshiftclient.CsKioskSoapPort_PortType getcsKioskSoapPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
