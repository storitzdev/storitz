/**
 * PaymentLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.edomico.www;

public class PaymentLocator extends org.apache.axis.client.Service implements com.edomico.www.Payment {

/**
 * Attempts to authorize a credit card payment and updates billing
 * information.
 */

    public PaymentLocator() {
    }


    public PaymentLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public PaymentLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for PaymentSoap12
    private java.lang.String PaymentSoap12_address = "https://www.edomico.com/WebServices/Payment.asmx";

    public java.lang.String getPaymentSoap12Address() {
        return PaymentSoap12_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String PaymentSoap12WSDDServiceName = "PaymentSoap12";

    public java.lang.String getPaymentSoap12WSDDServiceName() {
        return PaymentSoap12WSDDServiceName;
    }

    public void setPaymentSoap12WSDDServiceName(java.lang.String name) {
        PaymentSoap12WSDDServiceName = name;
    }

    public com.edomico.www.PaymentSoap getPaymentSoap12() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(PaymentSoap12_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getPaymentSoap12(endpoint);
    }

    public com.edomico.www.PaymentSoap getPaymentSoap12(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.edomico.www.PaymentSoap12Stub _stub = new com.edomico.www.PaymentSoap12Stub(portAddress, this);
            _stub.setPortName(getPaymentSoap12WSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setPaymentSoap12EndpointAddress(java.lang.String address) {
        PaymentSoap12_address = address;
    }


    // Use to get a proxy class for PaymentSoap
    private java.lang.String PaymentSoap_address = "https://www.edomico.com/WebServices/Payment.asmx";

    public java.lang.String getPaymentSoapAddress() {
        return PaymentSoap_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String PaymentSoapWSDDServiceName = "PaymentSoap";

    public java.lang.String getPaymentSoapWSDDServiceName() {
        return PaymentSoapWSDDServiceName;
    }

    public void setPaymentSoapWSDDServiceName(java.lang.String name) {
        PaymentSoapWSDDServiceName = name;
    }

    public com.edomico.www.PaymentSoap getPaymentSoap() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(PaymentSoap_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getPaymentSoap(endpoint);
    }

    public com.edomico.www.PaymentSoap getPaymentSoap(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.edomico.www.PaymentSoapStub _stub = new com.edomico.www.PaymentSoapStub(portAddress, this);
            _stub.setPortName(getPaymentSoapWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setPaymentSoapEndpointAddress(java.lang.String address) {
        PaymentSoap_address = address;
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
            if (com.edomico.www.PaymentSoap.class.isAssignableFrom(serviceEndpointInterface)) {
                com.edomico.www.PaymentSoap12Stub _stub = new com.edomico.www.PaymentSoap12Stub(new java.net.URL(PaymentSoap12_address), this);
                _stub.setPortName(getPaymentSoap12WSDDServiceName());
                return _stub;
            }
            if (com.edomico.www.PaymentSoap.class.isAssignableFrom(serviceEndpointInterface)) {
                com.edomico.www.PaymentSoapStub _stub = new com.edomico.www.PaymentSoapStub(new java.net.URL(PaymentSoap_address), this);
                _stub.setPortName(getPaymentSoapWSDDServiceName());
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
        if ("PaymentSoap12".equals(inputPortName)) {
            return getPaymentSoap12();
        }
        else if ("PaymentSoap".equals(inputPortName)) {
            return getPaymentSoap();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("https://www.edomico.com/", "Payment");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("https://www.edomico.com/", "PaymentSoap12"));
            ports.add(new javax.xml.namespace.QName("https://www.edomico.com/", "PaymentSoap"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("PaymentSoap12".equals(portName)) {
            setPaymentSoap12EndpointAddress(address);
        }
        else 
if ("PaymentSoap".equals(portName)) {
            setPaymentSoapEndpointAddress(address);
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
