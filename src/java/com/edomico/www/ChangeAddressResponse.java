/**
 * ChangeAddressResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.edomico.www;

public class ChangeAddressResponse  implements java.io.Serializable {
    private java.lang.String changeAddressResult;

    public ChangeAddressResponse() {
    }

    public ChangeAddressResponse(
           java.lang.String changeAddressResult) {
           this.changeAddressResult = changeAddressResult;
    }


    /**
     * Gets the changeAddressResult value for this ChangeAddressResponse.
     * 
     * @return changeAddressResult
     */
    public java.lang.String getChangeAddressResult() {
        return changeAddressResult;
    }


    /**
     * Sets the changeAddressResult value for this ChangeAddressResponse.
     * 
     * @param changeAddressResult
     */
    public void setChangeAddressResult(java.lang.String changeAddressResult) {
        this.changeAddressResult = changeAddressResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ChangeAddressResponse)) return false;
        ChangeAddressResponse other = (ChangeAddressResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.changeAddressResult==null && other.getChangeAddressResult()==null) || 
             (this.changeAddressResult!=null &&
              this.changeAddressResult.equals(other.getChangeAddressResult())));
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
        if (getChangeAddressResult() != null) {
            _hashCode += getChangeAddressResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ChangeAddressResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("https://www.edomico.com/", ">ChangeAddressResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("changeAddressResult");
        elemField.setXmlName(new javax.xml.namespace.QName("https://www.edomico.com/", "ChangeAddressResult"));
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
