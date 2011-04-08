/**
 * CustomerInfo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.edomico.www;

public interface CustomerInfo extends javax.xml.rpc.Service {

/**
 * Returns Customer Information including Units and Balances and validates
 * Login information.
 */
    public java.lang.String getCustomerInfoSoapAddress();

    public com.edomico.www.CustomerInfoSoap getCustomerInfoSoap() throws javax.xml.rpc.ServiceException;

    public com.edomico.www.CustomerInfoSoap getCustomerInfoSoap(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
    public java.lang.String getCustomerInfoSoap12Address();

    public com.edomico.www.CustomerInfoSoap getCustomerInfoSoap12() throws javax.xml.rpc.ServiceException;

    public com.edomico.www.CustomerInfoSoap getCustomerInfoSoap12(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
