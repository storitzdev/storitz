/**
 * CsKioskLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.storitz.cshiftclient;

public class CsKioskLocator extends org.apache.axis.client.Service implements com.storitz.cshiftclient.CsKiosk {

    public CsKioskLocator() {
    }


    public CsKioskLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public CsKioskLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for csKioskSoapPort
    private java.lang.String csKioskSoapPort_address = "https://host01slc.centershift.com/pxi/kiosks/csKiosk.WSDL";

    public java.lang.String getcsKioskSoapPortAddress() {
        return csKioskSoapPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String csKioskSoapPortWSDDServiceName = "csKioskSoapPort";

    public java.lang.String getcsKioskSoapPortWSDDServiceName() {
        return csKioskSoapPortWSDDServiceName;
    }

    public void setcsKioskSoapPortWSDDServiceName(java.lang.String name) {
        csKioskSoapPortWSDDServiceName = name;
    }

    public com.storitz.cshiftclient.CsKioskSoapPort_PortType getcsKioskSoapPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(csKioskSoapPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getcsKioskSoapPort(endpoint);
    }

    public com.storitz.cshiftclient.CsKioskSoapPort_PortType getcsKioskSoapPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.storitz.cshiftclient.CsKioskSoapBindingStub _stub = new com.storitz.cshiftclient.CsKioskSoapBindingStub(portAddress, this);
            _stub.setPortName(getcsKioskSoapPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setcsKioskSoapPortEndpointAddress(java.lang.String address) {
        csKioskSoapPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.storitz.cshiftclient.CsKioskSoapPort_PortType.class.isAssignableFrom(serviceEndpointInterface)) {
                com.storitz.cshiftclient.CsKioskSoapBindingStub _stub = new com.storitz.cshiftclient.CsKioskSoapBindingStub(new java.net.URL(csKioskSoapPort_address), this);
                _stub.setPortName(getcsKioskSoapPortWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("csKioskSoapPort".equals(inputPortName)) {
            return getcsKioskSoapPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://tempuri.org/csKiosk/wsdl/", "csKiosk");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://tempuri.org/csKiosk/wsdl/", "csKioskSoapPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
     * @param portName
     * @param address
     * @throws javax.xml.rpc.ServiceException
     */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("csKioskSoapPort".equals(portName)) {
            setcsKioskSoapPortEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
     * @param portName
     * @param address
     * @throws javax.xml.rpc.ServiceException
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
