/**
 * ReadCustomerInfoResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.edomico.www;

public class ReadCustomerInfoResponse  implements java.io.Serializable {
    private com.edomico.www.ReadCustomerInfoResponseReadCustomerInfoResult readCustomerInfoResult;

    public ReadCustomerInfoResponse() {
    }

    public ReadCustomerInfoResponse(
           com.edomico.www.ReadCustomerInfoResponseReadCustomerInfoResult readCustomerInfoResult) {
           this.readCustomerInfoResult = readCustomerInfoResult;
    }


    /**
     * Gets the readCustomerInfoResult value for this ReadCustomerInfoResponse.
     * 
     * @return readCustomerInfoResult
     */
    public com.edomico.www.ReadCustomerInfoResponseReadCustomerInfoResult getReadCustomerInfoResult() {
        return readCustomerInfoResult;
    }


    /**
     * Sets the readCustomerInfoResult value for this ReadCustomerInfoResponse.
     * 
     * @param readCustomerInfoResult
     */
    public void setReadCustomerInfoResult(com.edomico.www.ReadCustomerInfoResponseReadCustomerInfoResult readCustomerInfoResult) {
        this.readCustomerInfoResult = readCustomerInfoResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ReadCustomerInfoResponse)) return false;
        ReadCustomerInfoResponse other = (ReadCustomerInfoResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.readCustomerInfoResult==null && other.getReadCustomerInfoResult()==null) || 
             (this.readCustomerInfoResult!=null &&
              this.readCustomerInfoResult.equals(other.getReadCustomerInfoResult())));
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
        if (getReadCustomerInfoResult() != null) {
            _hashCode += getReadCustomerInfoResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ReadCustomerInfoResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("https://www.edomico.com/", ">ReadCustomerInfoResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("readCustomerInfoResult");
        elemField.setXmlName(new javax.xml.namespace.QName("https://www.edomico.com/", "ReadCustomerInfoResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("https://www.edomico.com/", ">>ReadCustomerInfoResponse>ReadCustomerInfoResult"));
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
