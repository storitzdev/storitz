/**
 * Payment.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.edomico.www;

public interface Payment extends javax.xml.rpc.Service {

/**
 * Attempts to authorize a credit card payment and updates billing
 * information.
 */
    public java.lang.String getPaymentSoap12Address();

    public com.edomico.www.PaymentSoap getPaymentSoap12() throws javax.xml.rpc.ServiceException;

    public com.edomico.www.PaymentSoap getPaymentSoap12(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
    public java.lang.String getPaymentSoapAddress();

    public com.edomico.www.PaymentSoap getPaymentSoap() throws javax.xml.rpc.ServiceException;

    public com.edomico.www.PaymentSoap getPaymentSoap(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
