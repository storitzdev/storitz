/**
 * CommonMethods.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.edomico.www;

public interface CommonMethods extends javax.xml.rpc.Service {

/**
 * Common Token exhange.
 */
    public java.lang.String getCommonMethodsSoap12Address();

    public com.edomico.www.CommonMethodsSoap getCommonMethodsSoap12() throws javax.xml.rpc.ServiceException;

    public com.edomico.www.CommonMethodsSoap getCommonMethodsSoap12(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
    public java.lang.String getCommonMethodsSoapAddress();

    public com.edomico.www.CommonMethodsSoap getCommonMethodsSoap() throws javax.xml.rpc.ServiceException;

    public com.edomico.www.CommonMethodsSoap getCommonMethodsSoap(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
