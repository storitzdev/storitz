/**
 * ReadCustomerSPAN.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.edomico.www;

public class ReadCustomerSPAN  implements java.io.Serializable {
    private int clientID;

    private java.lang.String token;

    private java.lang.String siteID;

    private long customerAccount;

    private int customerID;

    private int billingID;

    public ReadCustomerSPAN() {
    }

    public ReadCustomerSPAN(
           int clientID,
           java.lang.String token,
           java.lang.String siteID,
           long customerAccount,
           int customerID,
           int billingID) {
           this.clientID = clientID;
           this.token = token;
           this.siteID = siteID;
           this.customerAccount = customerAccount;
           this.customerID = customerID;
           this.billingID = billingID;
    }


    /**
     * Gets the clientID value for this ReadCustomerSPAN.
     * 
     * @return clientID
     */
    public int getClientID() {
        return clientID;
    }


    /**
     * Sets the clientID value for this ReadCustomerSPAN.
     * 
     * @param clientID
     */
    public void setClientID(int clientID) {
        this.clientID = clientID;
    }


    /**
     * Gets the token value for this ReadCustomerSPAN.
     * 
     * @return token
     */
    public java.lang.String getToken() {
        return token;
    }


    /**
     * Sets the token value for this ReadCustomerSPAN.
     * 
     * @param token
     */
    public void setToken(java.lang.String token) {
        this.token = token;
    }


    /**
     * Gets the siteID value for this ReadCustomerSPAN.
     * 
     * @return siteID
     */
    public java.lang.String getSiteID() {
        return siteID;
    }


    /**
     * Sets the siteID value for this ReadCustomerSPAN.
     * 
     * @param siteID
     */
    public void setSiteID(java.lang.String siteID) {
        this.siteID = siteID;
    }


    /**
     * Gets the customerAccount value for this ReadCustomerSPAN.
     * 
     * @return customerAccount
     */
    public long getCustomerAccount() {
        return customerAccount;
    }


    /**
     * Sets the customerAccount value for this ReadCustomerSPAN.
     * 
     * @param customerAccount
     */
    public void setCustomerAccount(long customerAccount) {
        this.customerAccount = customerAccount;
    }


    /**
     * Gets the customerID value for this ReadCustomerSPAN.
     * 
     * @return customerID
     */
    public int getCustomerID() {
        return customerID;
    }


    /**
     * Sets the customerID value for this ReadCustomerSPAN.
     * 
     * @param customerID
     */
    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }


    /**
     * Gets the billingID value for this ReadCustomerSPAN.
     * 
     * @return billingID
     */
    public int getBillingID() {
        return billingID;
    }


    /**
     * Sets the billingID value for this ReadCustomerSPAN.
     * 
     * @param billingID
     */
    public void setBillingID(int billingID) {
        this.billingID = billingID;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ReadCustomerSPAN)) return false;
        ReadCustomerSPAN other = (ReadCustomerSPAN) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.clientID == other.getClientID() &&
            ((this.token==null && other.getToken()==null) || 
             (this.token!=null &&
              this.token.equals(other.getToken()))) &&
            ((this.siteID==null && other.getSiteID()==null) || 
             (this.siteID!=null &&
              this.siteID.equals(other.getSiteID()))) &&
            this.customerAccount == other.getCustomerAccount() &&
            this.customerID == other.getCustomerID() &&
            this.billingID == other.getBillingID();
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        _hashCode += getClientID();
        if (getToken() != null) {
            _hashCode += getToken().hashCode();
        }
        if (getSiteID() != null) {
            _hashCode += getSiteID().hashCode();
        }
        _hashCode += new Long(getCustomerAccount()).hashCode();
        _hashCode += getCustomerID();
        _hashCode += getBillingID();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ReadCustomerSPAN.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("https://www.edomico.com/", ">ReadCustomerSPAN"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("clientID");
        elemField.setXmlName(new javax.xml.namespace.QName("https://www.edomico.com/", "ClientID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("token");
        elemField.setXmlName(new javax.xml.namespace.QName("https://www.edomico.com/", "Token"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("siteID");
        elemField.setXmlName(new javax.xml.namespace.QName("https://www.edomico.com/", "SiteID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("customerAccount");
        elemField.setXmlName(new javax.xml.namespace.QName("https://www.edomico.com/", "CustomerAccount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("customerID");
        elemField.setXmlName(new javax.xml.namespace.QName("https://www.edomico.com/", "CustomerID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("billingID");
        elemField.setXmlName(new javax.xml.namespace.QName("https://www.edomico.com/", "BillingID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
