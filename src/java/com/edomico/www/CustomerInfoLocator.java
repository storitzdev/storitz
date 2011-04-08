/**
 * CustomerInfoLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.edomico.www;

public class CustomerInfoLocator extends org.apache.axis.client.Service implements com.edomico.www.CustomerInfo {

/**
 * Returns Customer Information including Units and Balances and validates
 * Login information.
 */

    public CustomerInfoLocator() {
    }


    public CustomerInfoLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public CustomerInfoLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for CustomerInfoSoap
    private java.lang.String CustomerInfoSoap_address = "https://www.edomico.com/WebServices/CustomerInfo.asmx";

    public java.lang.String getCustomerInfoSoapAddress() {
        return CustomerInfoSoap_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String CustomerInfoSoapWSDDServiceName = "CustomerInfoSoap";

    public java.lang.String getCustomerInfoSoapWSDDServiceName() {
        return CustomerInfoSoapWSDDServiceName;
    }

    public void setCustomerInfoSoapWSDDServiceName(java.lang.String name) {
        CustomerInfoSoapWSDDServiceName = name;
    }

    public com.edomico.www.CustomerInfoSoap getCustomerInfoSoap() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(CustomerInfoSoap_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getCustomerInfoSoap(endpoint);
    }

    public com.edomico.www.CustomerInfoSoap getCustomerInfoSoap(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.edomico.www.CustomerInfoSoapStub _stub = new com.edomico.www.CustomerInfoSoapStub(portAddress, this);
            _stub.setPortName(getCustomerInfoSoapWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setCustomerInfoSoapEndpointAddress(java.lang.String address) {
        CustomerInfoSoap_address = address;
    }


    // Use to get a proxy class for CustomerInfoSoap12
    private java.lang.String CustomerInfoSoap12_address = "https://www.edomico.com/WebServices/CustomerInfo.asmx";

    public java.lang.String getCustomerInfoSoap12Address() {
        return CustomerInfoSoap12_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String CustomerInfoSoap12WSDDServiceName = "CustomerInfoSoap12";

    public java.lang.String getCustomerInfoSoap12WSDDServiceName() {
        return CustomerInfoSoap12WSDDServiceName;
    }

    public void setCustomerInfoSoap12WSDDServiceName(java.lang.String name) {
        CustomerInfoSoap12WSDDServiceName = name;
    }

    public com.edomico.www.CustomerInfoSoap getCustomerInfoSoap12() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(CustomerInfoSoap12_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getCustomerInfoSoap12(endpoint);
    }

    public com.edomico.www.CustomerInfoSoap getCustomerInfoSoap12(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.edomico.www.CustomerInfoSoap12Stub _stub = new com.edomico.www.CustomerInfoSoap12Stub(portAddress, this);
            _stub.setPortName(getCustomerInfoSoap12WSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setCustomerInfoSoap12EndpointAddress(java.lang.String address) {
        CustomerInfoSoap12_address = address;
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
            if (com.edomico.www.CustomerInfoSoap.class.isAssignableFrom(serviceEndpointInterface)) {
                com.edomico.www.CustomerInfoSoapStub _stub = new com.edomico.www.CustomerInfoSoapStub(new java.net.URL(CustomerInfoSoap_address), this);
                _stub.setPortName(getCustomerInfoSoapWSDDServiceName());
                return _stub;
            }
            if (com.edomico.www.CustomerInfoSoap.class.isAssignableFrom(serviceEndpointInterface)) {
                com.edomico.www.CustomerInfoSoap12Stub _stub = new com.edomico.www.CustomerInfoSoap12Stub(new java.net.URL(CustomerInfoSoap12_address), this);
                _stub.setPortName(getCustomerInfoSoap12WSDDServiceName());
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
        if ("CustomerInfoSoap".equals(inputPortName)) {
            return getCustomerInfoSoap();
        }
        else if ("CustomerInfoSoap12".equals(inputPortName)) {
            return getCustomerInfoSoap12();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("https://www.edomico.com/", "CustomerInfo");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("https://www.edomico.com/", "CustomerInfoSoap"));
            ports.add(new javax.xml.namespace.QName("https://www.edomico.com/", "CustomerInfoSoap12"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("CustomerInfoSoap".equals(portName)) {
            setCustomerInfoSoapEndpointAddress(address);
        }
        else 
if ("CustomerInfoSoap12".equals(portName)) {
            setCustomerInfoSoap12EndpointAddress(address);
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
