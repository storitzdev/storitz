/**
 * DeleteCustomerSPANResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.edomico.www;

public class DeleteCustomerSPANResponse  implements java.io.Serializable {
    private int deleteCustomerSPANResult;

    public DeleteCustomerSPANResponse() {
    }

    public DeleteCustomerSPANResponse(
           int deleteCustomerSPANResult) {
           this.deleteCustomerSPANResult = deleteCustomerSPANResult;
    }


    /**
     * Gets the deleteCustomerSPANResult value for this DeleteCustomerSPANResponse.
     * 
     * @return deleteCustomerSPANResult
     */
    public int getDeleteCustomerSPANResult() {
        return deleteCustomerSPANResult;
    }


    /**
     * Sets the deleteCustomerSPANResult value for this DeleteCustomerSPANResponse.
     * 
     * @param deleteCustomerSPANResult
     */
    public void setDeleteCustomerSPANResult(int deleteCustomerSPANResult) {
        this.deleteCustomerSPANResult = deleteCustomerSPANResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DeleteCustomerSPANResponse)) return false;
        DeleteCustomerSPANResponse other = (DeleteCustomerSPANResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.deleteCustomerSPANResult == other.getDeleteCustomerSPANResult();
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
        _hashCode += getDeleteCustomerSPANResult();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DeleteCustomerSPANResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("https://www.edomico.com/", ">DeleteCustomerSPANResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("deleteCustomerSPANResult");
        elemField.setXmlName(new javax.xml.namespace.QName("https://www.edomico.com/", "DeleteCustomerSPANResult"));
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
