/**
 * AuthorizeResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.edomico.www;

public class AuthorizeResponse  implements java.io.Serializable {
    private com.edomico.www.AuthorizeResponseAuthorizeResult authorizeResult;

    public AuthorizeResponse() {
    }

    public AuthorizeResponse(
           com.edomico.www.AuthorizeResponseAuthorizeResult authorizeResult) {
           this.authorizeResult = authorizeResult;
    }


    /**
     * Gets the authorizeResult value for this AuthorizeResponse.
     * 
     * @return authorizeResult
     */
    public com.edomico.www.AuthorizeResponseAuthorizeResult getAuthorizeResult() {
        return authorizeResult;
    }


    /**
     * Sets the authorizeResult value for this AuthorizeResponse.
     * 
     * @param authorizeResult
     */
    public void setAuthorizeResult(com.edomico.www.AuthorizeResponseAuthorizeResult authorizeResult) {
        this.authorizeResult = authorizeResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AuthorizeResponse)) return false;
        AuthorizeResponse other = (AuthorizeResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.authorizeResult==null && other.getAuthorizeResult()==null) || 
             (this.authorizeResult!=null &&
              this.authorizeResult.equals(other.getAuthorizeResult())));
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
        if (getAuthorizeResult() != null) {
            _hashCode += getAuthorizeResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(AuthorizeResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("https://www.edomico.com/", ">AuthorizeResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("authorizeResult");
        elemField.setXmlName(new javax.xml.namespace.QName("https://www.edomico.com/", "AuthorizeResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("https://www.edomico.com/", ">>AuthorizeResponse>AuthorizeResult"));
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
