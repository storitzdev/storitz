/**
 * ReservationLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.edomico.www;

public class ReservationLocator extends org.apache.axis.client.Service implements com.edomico.www.Reservation {

/**
 * Makes a reservation based on Size/Unit selected.
 */

    public ReservationLocator() {
    }


    public ReservationLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public ReservationLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for ReservationSoap12
    private java.lang.String ReservationSoap12_address = "https://www.edomico.com/WebServices/Reservation.asmx";

    public java.lang.String getReservationSoap12Address() {
        return ReservationSoap12_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String ReservationSoap12WSDDServiceName = "ReservationSoap12";

    public java.lang.String getReservationSoap12WSDDServiceName() {
        return ReservationSoap12WSDDServiceName;
    }

    public void setReservationSoap12WSDDServiceName(java.lang.String name) {
        ReservationSoap12WSDDServiceName = name;
    }

    public com.edomico.www.ReservationSoap getReservationSoap12() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(ReservationSoap12_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getReservationSoap12(endpoint);
    }

    public com.edomico.www.ReservationSoap getReservationSoap12(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.edomico.www.ReservationSoap12Stub _stub = new com.edomico.www.ReservationSoap12Stub(portAddress, this);
            _stub.setPortName(getReservationSoap12WSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setReservationSoap12EndpointAddress(java.lang.String address) {
        ReservationSoap12_address = address;
    }


    // Use to get a proxy class for ReservationSoap
    private java.lang.String ReservationSoap_address = "https://www.edomico.com/WebServices/Reservation.asmx";

    public java.lang.String getReservationSoapAddress() {
        return ReservationSoap_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String ReservationSoapWSDDServiceName = "ReservationSoap";

    public java.lang.String getReservationSoapWSDDServiceName() {
        return ReservationSoapWSDDServiceName;
    }

    public void setReservationSoapWSDDServiceName(java.lang.String name) {
        ReservationSoapWSDDServiceName = name;
    }

    public com.edomico.www.ReservationSoap getReservationSoap() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(ReservationSoap_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getReservationSoap(endpoint);
    }

    public com.edomico.www.ReservationSoap getReservationSoap(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.edomico.www.ReservationSoapStub _stub = new com.edomico.www.ReservationSoapStub(portAddress, this);
            _stub.setPortName(getReservationSoapWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setReservationSoapEndpointAddress(java.lang.String address) {
        ReservationSoap_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     * This service has multiple ports for a given interface;
     * the proxy implementation returned may be indeterminate.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.edomico.www.ReservationSoap.class.isAssignableFrom(serviceEndpointInterface)) {
                com.edomico.www.ReservationSoap12Stub _stub = new com.edomico.www.ReservationSoap12Stub(new java.net.URL(ReservationSoap12_address), this);
                _stub.setPortName(getReservationSoap12WSDDServiceName());
                return _stub;
            }
            if (com.edomico.www.ReservationSoap.class.isAssignableFrom(serviceEndpointInterface)) {
                com.edomico.www.ReservationSoapStub _stub = new com.edomico.www.ReservationSoapStub(new java.net.URL(ReservationSoap_address), this);
                _stub.setPortName(getReservationSoapWSDDServiceName());
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
        if ("ReservationSoap12".equals(inputPortName)) {
            return getReservationSoap12();
        }
        else if ("ReservationSoap".equals(inputPortName)) {
            return getReservationSoap();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("https://www.edomico.com/", "Reservation");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("https://www.edomico.com/", "ReservationSoap12"));
            ports.add(new javax.xml.namespace.QName("https://www.edomico.com/", "ReservationSoap"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("ReservationSoap12".equals(portName)) {
            setReservationSoap12EndpointAddress(address);
        }
        else 
if ("ReservationSoap".equals(portName)) {
            setReservationSoapEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
