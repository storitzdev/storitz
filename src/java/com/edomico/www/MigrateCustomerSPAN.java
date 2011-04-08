/**
 * MigrateCustomerSPAN.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.edomico.www;

public class MigrateCustomerSPAN  implements java.io.Serializable {
    private int clientID;

    private java.lang.String token;

    private java.lang.String siteID;

    private java.lang.String keyCode;

    private boolean deleteAlreadyMigratedInVault;

    public MigrateCustomerSPAN() {
    }

    public MigrateCustomerSPAN(
           int clientID,
           java.lang.String token,
           java.lang.String siteID,
           java.lang.String keyCode,
           boolean deleteAlreadyMigratedInVault) {
           this.clientID = clientID;
           this.token = token;
           this.siteID = siteID;
           this.keyCode = keyCode;
           this.deleteAlreadyMigratedInVault = deleteAlreadyMigratedInVault;
    }


    /**
     * Gets the clientID value for this MigrateCustomerSPAN.
     * 
     * @return clientID
     */
    public int getClientID() {
        return clientID;
    }


    /**
     * Sets the clientID value for this MigrateCustomerSPAN.
     * 
     * @param clientID
     */
    public void setClientID(int clientID) {
        this.clientID = clientID;
    }


    /**
     * Gets the token value for this MigrateCustomerSPAN.
     * 
     * @return token
     */
    public java.lang.String getToken() {
        return token;
    }


    /**
     * Sets the token value for this MigrateCustomerSPAN.
     * 
     * @param token
     */
    public void setToken(java.lang.String token) {
        this.token = token;
    }


    /**
     * Gets the siteID value for this MigrateCustomerSPAN.
     * 
     * @return siteID
     */
    public java.lang.String getSiteID() {
        return siteID;
    }


    /**
     * Sets the siteID value for this MigrateCustomerSPAN.
     * 
     * @param siteID
     */
    public void setSiteID(java.lang.String siteID) {
        this.siteID = siteID;
    }


    /**
     * Gets the keyCode value for this MigrateCustomerSPAN.
     * 
     * @return keyCode
     */
    public java.lang.String getKeyCode() {
        return keyCode;
    }


    /**
     * Sets the keyCode value for this MigrateCustomerSPAN.
     * 
     * @param keyCode
     */
    public void setKeyCode(java.lang.String keyCode) {
        this.keyCode = keyCode;
    }


    /**
     * Gets the deleteAlreadyMigratedInVault value for this MigrateCustomerSPAN.
     * 
     * @return deleteAlreadyMigratedInVault
     */
    public boolean isDeleteAlreadyMigratedInVault() {
        return deleteAlreadyMigratedInVault;
    }


    /**
     * Sets the deleteAlreadyMigratedInVault value for this MigrateCustomerSPAN.
     * 
     * @param deleteAlreadyMigratedInVault
     */
    public void setDeleteAlreadyMigratedInVault(boolean deleteAlreadyMigratedInVault) {
        this.deleteAlreadyMigratedInVault = deleteAlreadyMigratedInVault;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof MigrateCustomerSPAN)) return false;
        MigrateCustomerSPAN other = (MigrateCustomerSPAN) obj;
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
            ((this.keyCode==null && other.getKeyCode()==null) || 
             (this.keyCode!=null &&
              this.keyCode.equals(other.getKeyCode()))) &&
            this.deleteAlreadyMigratedInVault == other.isDeleteAlreadyMigratedInVault();
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
        if (getKeyCode() != null) {
            _hashCode += getKeyCode().hashCode();
        }
        _hashCode += (isDeleteAlreadyMigratedInVault() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(MigrateCustomerSPAN.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("https://www.edomico.com/", ">MigrateCustomerSPAN"));
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
        elemField.setFieldName("keyCode");
        elemField.setXmlName(new javax.xml.namespace.QName("https://www.edomico.com/", "KeyCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("deleteAlreadyMigratedInVault");
        elemField.setXmlName(new javax.xml.namespace.QName("https://www.edomico.com/", "DeleteAlreadyMigratedInVault"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
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
