/**
 * ReadCustomerSPANResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.edomico.www;

public class ReadCustomerSPANResponse  implements java.io.Serializable {
    private com.edomico.www.ReadCustomerSPANResponseReadCustomerSPANResult readCustomerSPANResult;

    public ReadCustomerSPANResponse() {
    }

    public ReadCustomerSPANResponse(
           com.edomico.www.ReadCustomerSPANResponseReadCustomerSPANResult readCustomerSPANResult) {
           this.readCustomerSPANResult = readCustomerSPANResult;
    }


    /**
     * Gets the readCustomerSPANResult value for this ReadCustomerSPANResponse.
     * 
     * @return readCustomerSPANResult
     */
    public com.edomico.www.ReadCustomerSPANResponseReadCustomerSPANResult getReadCustomerSPANResult() {
        return readCustomerSPANResult;
    }


    /**
     * Sets the readCustomerSPANResult value for this ReadCustomerSPANResponse.
     * 
     * @param readCustomerSPANResult
     */
    public void setReadCustomerSPANResult(com.edomico.www.ReadCustomerSPANResponseReadCustomerSPANResult readCustomerSPANResult) {
        this.readCustomerSPANResult = readCustomerSPANResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ReadCustomerSPANResponse)) return false;
        ReadCustomerSPANResponse other = (ReadCustomerSPANResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.readCustomerSPANResult==null && other.getReadCustomerSPANResult()==null) || 
             (this.readCustomerSPANResult!=null &&
              this.readCustomerSPANResult.equals(other.getReadCustomerSPANResult())));
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
        if (getReadCustomerSPANResult() != null) {
            _hashCode += getReadCustomerSPANResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ReadCustomerSPANResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("https://www.edomico.com/", ">ReadCustomerSPANResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("readCustomerSPANResult");
        elemField.setXmlName(new javax.xml.namespace.QName("https://www.edomico.com/", "ReadCustomerSPANResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("https://www.edomico.com/", ">>ReadCustomerSPANResponse>ReadCustomerSPANResult"));
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
