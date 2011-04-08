/**
 * MigrateCustomerSPANResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.edomico.www;

public class MigrateCustomerSPANResponse  implements java.io.Serializable {
    private long migrateCustomerSPANResult;

    public MigrateCustomerSPANResponse() {
    }

    public MigrateCustomerSPANResponse(
           long migrateCustomerSPANResult) {
           this.migrateCustomerSPANResult = migrateCustomerSPANResult;
    }


    /**
     * Gets the migrateCustomerSPANResult value for this MigrateCustomerSPANResponse.
     * 
     * @return migrateCustomerSPANResult
     */
    public long getMigrateCustomerSPANResult() {
        return migrateCustomerSPANResult;
    }


    /**
     * Sets the migrateCustomerSPANResult value for this MigrateCustomerSPANResponse.
     * 
     * @param migrateCustomerSPANResult
     */
    public void setMigrateCustomerSPANResult(long migrateCustomerSPANResult) {
        this.migrateCustomerSPANResult = migrateCustomerSPANResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof MigrateCustomerSPANResponse)) return false;
        MigrateCustomerSPANResponse other = (MigrateCustomerSPANResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.migrateCustomerSPANResult == other.getMigrateCustomerSPANResult();
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
        _hashCode += new Long(getMigrateCustomerSPANResult()).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(MigrateCustomerSPANResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("https://www.edomico.com/", ">MigrateCustomerSPANResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("migrateCustomerSPANResult");
        elemField.setXmlName(new javax.xml.namespace.QName("https://www.edomico.com/", "MigrateCustomerSPANResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
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
