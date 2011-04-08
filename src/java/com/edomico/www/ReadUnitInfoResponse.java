/**
 * ReadUnitInfoResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.edomico.www;

public class ReadUnitInfoResponse  implements java.io.Serializable {
    private com.edomico.www.ReadUnitInfoResponseReadUnitInfoResult readUnitInfoResult;

    public ReadUnitInfoResponse() {
    }

    public ReadUnitInfoResponse(
           com.edomico.www.ReadUnitInfoResponseReadUnitInfoResult readUnitInfoResult) {
           this.readUnitInfoResult = readUnitInfoResult;
    }


    /**
     * Gets the readUnitInfoResult value for this ReadUnitInfoResponse.
     * 
     * @return readUnitInfoResult
     */
    public com.edomico.www.ReadUnitInfoResponseReadUnitInfoResult getReadUnitInfoResult() {
        return readUnitInfoResult;
    }


    /**
     * Sets the readUnitInfoResult value for this ReadUnitInfoResponse.
     * 
     * @param readUnitInfoResult
     */
    public void setReadUnitInfoResult(com.edomico.www.ReadUnitInfoResponseReadUnitInfoResult readUnitInfoResult) {
        this.readUnitInfoResult = readUnitInfoResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ReadUnitInfoResponse)) return false;
        ReadUnitInfoResponse other = (ReadUnitInfoResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.readUnitInfoResult==null && other.getReadUnitInfoResult()==null) || 
             (this.readUnitInfoResult!=null &&
              this.readUnitInfoResult.equals(other.getReadUnitInfoResult())));
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
        if (getReadUnitInfoResult() != null) {
            _hashCode += getReadUnitInfoResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ReadUnitInfoResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("https://www.edomico.com/", ">ReadUnitInfoResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("readUnitInfoResult");
        elemField.setXmlName(new javax.xml.namespace.QName("https://www.edomico.com/", "ReadUnitInfoResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("https://www.edomico.com/", ">>ReadUnitInfoResponse>ReadUnitInfoResult"));
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
