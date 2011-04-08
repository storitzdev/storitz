/**
 * AvailableUnitsSizesLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.edomico.www;

public class AvailableUnitsSizesLocator extends org.apache.axis.client.Service implements com.edomico.www.AvailableUnitsSizes {

/**
 * Returns available Units and Sizes Information
 */

    public AvailableUnitsSizesLocator() {
    }


    public AvailableUnitsSizesLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public AvailableUnitsSizesLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for AvailableUnitsSizesSoap
    private java.lang.String AvailableUnitsSizesSoap_address = "https://www.edomico.com/WebServices/AvailableUnits.asmx";

    public java.lang.String getAvailableUnitsSizesSoapAddress() {
        return AvailableUnitsSizesSoap_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String AvailableUnitsSizesSoapWSDDServiceName = "AvailableUnitsSizesSoap";

    public java.lang.String getAvailableUnitsSizesSoapWSDDServiceName() {
        return AvailableUnitsSizesSoapWSDDServiceName;
    }

    public void setAvailableUnitsSizesSoapWSDDServiceName(java.lang.String name) {
        AvailableUnitsSizesSoapWSDDServiceName = name;
    }

    public com.edomico.www.AvailableUnitsSizesSoap getAvailableUnitsSizesSoap() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(AvailableUnitsSizesSoap_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getAvailableUnitsSizesSoap(endpoint);
    }

    public com.edomico.www.AvailableUnitsSizesSoap getAvailableUnitsSizesSoap(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.edomico.www.AvailableUnitsSizesSoapStub _stub = new com.edomico.www.AvailableUnitsSizesSoapStub(portAddress, this);
            _stub.setPortName(getAvailableUnitsSizesSoapWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setAvailableUnitsSizesSoapEndpointAddress(java.lang.String address) {
        AvailableUnitsSizesSoap_address = address;
    }


    // Use to get a proxy class for AvailableUnitsSizesSoap12
    private java.lang.String AvailableUnitsSizesSoap12_address = "https://www.edomico.com/WebServices/AvailableUnits.asmx";

    public java.lang.String getAvailableUnitsSizesSoap12Address() {
        return AvailableUnitsSizesSoap12_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String AvailableUnitsSizesSoap12WSDDServiceName = "AvailableUnitsSizesSoap12";

    public java.lang.String getAvailableUnitsSizesSoap12WSDDServiceName() {
        return AvailableUnitsSizesSoap12WSDDServiceName;
    }

    public void setAvailableUnitsSizesSoap12WSDDServiceName(java.lang.String name) {
        AvailableUnitsSizesSoap12WSDDServiceName = name;
    }

    public com.edomico.www.AvailableUnitsSizesSoap getAvailableUnitsSizesSoap12() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(AvailableUnitsSizesSoap12_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getAvailableUnitsSizesSoap12(endpoint);
    }

    public com.edomico.www.AvailableUnitsSizesSoap getAvailableUnitsSizesSoap12(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.edomico.www.AvailableUnitsSizesSoap12Stub _stub = new com.edomico.www.AvailableUnitsSizesSoap12Stub(portAddress, this);
            _stub.setPortName(getAvailableUnitsSizesSoap12WSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setAvailableUnitsSizesSoap12EndpointAddress(java.lang.String address) {
        AvailableUnitsSizesSoap12_address = address;
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
            if (com.edomico.www.AvailableUnitsSizesSoap.class.isAssignableFrom(serviceEndpointInterface)) {
                com.edomico.www.AvailableUnitsSizesSoapStub _stub = new com.edomico.www.AvailableUnitsSizesSoapStub(new java.net.URL(AvailableUnitsSizesSoap_address), this);
                _stub.setPortName(getAvailableUnitsSizesSoapWSDDServiceName());
                return _stub;
            }
            if (com.edomico.www.AvailableUnitsSizesSoap.class.isAssignableFrom(serviceEndpointInterface)) {
                com.edomico.www.AvailableUnitsSizesSoap12Stub _stub = new com.edomico.www.AvailableUnitsSizesSoap12Stub(new java.net.URL(AvailableUnitsSizesSoap12_address), this);
                _stub.setPortName(getAvailableUnitsSizesSoap12WSDDServiceName());
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
        if ("AvailableUnitsSizesSoap".equals(inputPortName)) {
            return getAvailableUnitsSizesSoap();
        }
        else if ("AvailableUnitsSizesSoap12".equals(inputPortName)) {
            return getAvailableUnitsSizesSoap12();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("https://www.edomico.com/", "AvailableUnitsSizes");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("https://www.edomico.com/", "AvailableUnitsSizesSoap"));
            ports.add(new javax.xml.namespace.QName("https://www.edomico.com/", "AvailableUnitsSizesSoap12"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("AvailableUnitsSizesSoap".equals(portName)) {
            setAvailableUnitsSizesSoapEndpointAddress(address);
        }
        else 
if ("AvailableUnitsSizesSoap12".equals(portName)) {
            setAvailableUnitsSizesSoap12EndpointAddress(address);
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
