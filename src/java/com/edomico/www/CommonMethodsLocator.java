/**
 * CommonMethodsLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.edomico.www;

public class CommonMethodsLocator extends org.apache.axis.client.Service implements com.edomico.www.CommonMethods {

/**
 * Common Token exhange.
 */

    public CommonMethodsLocator() {
    }


    public CommonMethodsLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public CommonMethodsLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for CommonMethodsSoap12
    private java.lang.String CommonMethodsSoap12_address = "https://www.edomico.com/WebServices/Common.asmx";

    public java.lang.String getCommonMethodsSoap12Address() {
        return CommonMethodsSoap12_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String CommonMethodsSoap12WSDDServiceName = "CommonMethodsSoap12";

    public java.lang.String getCommonMethodsSoap12WSDDServiceName() {
        return CommonMethodsSoap12WSDDServiceName;
    }

    public void setCommonMethodsSoap12WSDDServiceName(java.lang.String name) {
        CommonMethodsSoap12WSDDServiceName = name;
    }

    public com.edomico.www.CommonMethodsSoap getCommonMethodsSoap12() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(CommonMethodsSoap12_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getCommonMethodsSoap12(endpoint);
    }

    public com.edomico.www.CommonMethodsSoap getCommonMethodsSoap12(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.edomico.www.CommonMethodsSoap12Stub _stub = new com.edomico.www.CommonMethodsSoap12Stub(portAddress, this);
            _stub.setPortName(getCommonMethodsSoap12WSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setCommonMethodsSoap12EndpointAddress(java.lang.String address) {
        CommonMethodsSoap12_address = address;
    }


    // Use to get a proxy class for CommonMethodsSoap
    private java.lang.String CommonMethodsSoap_address = "https://www.edomico.com/WebServices/Common.asmx";

    public java.lang.String getCommonMethodsSoapAddress() {
        return CommonMethodsSoap_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String CommonMethodsSoapWSDDServiceName = "CommonMethodsSoap";

    public java.lang.String getCommonMethodsSoapWSDDServiceName() {
        return CommonMethodsSoapWSDDServiceName;
    }

    public void setCommonMethodsSoapWSDDServiceName(java.lang.String name) {
        CommonMethodsSoapWSDDServiceName = name;
    }

    public com.edomico.www.CommonMethodsSoap getCommonMethodsSoap() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(CommonMethodsSoap_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getCommonMethodsSoap(endpoint);
    }

    public com.edomico.www.CommonMethodsSoap getCommonMethodsSoap(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.edomico.www.CommonMethodsSoapStub _stub = new com.edomico.www.CommonMethodsSoapStub(portAddress, this);
            _stub.setPortName(getCommonMethodsSoapWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setCommonMethodsSoapEndpointAddress(java.lang.String address) {
        CommonMethodsSoap_address = address;
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
            if (com.edomico.www.CommonMethodsSoap.class.isAssignableFrom(serviceEndpointInterface)) {
                com.edomico.www.CommonMethodsSoap12Stub _stub = new com.edomico.www.CommonMethodsSoap12Stub(new java.net.URL(CommonMethodsSoap12_address), this);
                _stub.setPortName(getCommonMethodsSoap12WSDDServiceName());
                return _stub;
            }
            if (com.edomico.www.CommonMethodsSoap.class.isAssignableFrom(serviceEndpointInterface)) {
                com.edomico.www.CommonMethodsSoapStub _stub = new com.edomico.www.CommonMethodsSoapStub(new java.net.URL(CommonMethodsSoap_address), this);
                _stub.setPortName(getCommonMethodsSoapWSDDServiceName());
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
        if ("CommonMethodsSoap12".equals(inputPortName)) {
            return getCommonMethodsSoap12();
        }
        else if ("CommonMethodsSoap".equals(inputPortName)) {
            return getCommonMethodsSoap();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("https://www.edomico.com/", "CommonMethods");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("https://www.edomico.com/", "CommonMethodsSoap12"));
            ports.add(new javax.xml.namespace.QName("https://www.edomico.com/", "CommonMethodsSoap"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("CommonMethodsSoap12".equals(portName)) {
            setCommonMethodsSoap12EndpointAddress(address);
        }
        else 
if ("CommonMethodsSoap".equals(portName)) {
            setCommonMethodsSoapEndpointAddress(address);
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
