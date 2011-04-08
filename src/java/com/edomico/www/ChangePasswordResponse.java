/**
 * ChangePasswordResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.edomico.www;

public class ChangePasswordResponse  implements java.io.Serializable {
    private java.lang.String changePasswordResult;

    public ChangePasswordResponse() {
    }

    public ChangePasswordResponse(
           java.lang.String changePasswordResult) {
           this.changePasswordResult = changePasswordResult;
    }


    /**
     * Gets the changePasswordResult value for this ChangePasswordResponse.
     * 
     * @return changePasswordResult
     */
    public java.lang.String getChangePasswordResult() {
        return changePasswordResult;
    }


    /**
     * Sets the changePasswordResult value for this ChangePasswordResponse.
     * 
     * @param changePasswordResult
     */
    public void setChangePasswordResult(java.lang.String changePasswordResult) {
        this.changePasswordResult = changePasswordResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ChangePasswordResponse)) return false;
        ChangePasswordResponse other = (ChangePasswordResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.changePasswordResult==null && other.getChangePasswordResult()==null) || 
             (this.changePasswordResult!=null &&
              this.changePasswordResult.equals(other.getChangePasswordResult())));
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
        if (getChangePasswordResult() != null) {
            _hashCode += getChangePasswordResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ChangePasswordResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("https://www.edomico.com/", ">ChangePasswordResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("changePasswordResult");
        elemField.setXmlName(new javax.xml.namespace.QName("https://www.edomico.com/", "ChangePasswordResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
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
