/**
 * ChangePassword.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.edomico.www;

public class ChangePassword  implements java.io.Serializable {
    private int clientID;

    private java.lang.String token;

    private int customerID;

    private java.lang.String oldPasswordEncrypted;

    private java.lang.String newPasswordEncrypted;

    private boolean sendEmailConfirmation;

    private java.lang.String sendEmailContent;

    public ChangePassword() {
    }

    public ChangePassword(
           int clientID,
           java.lang.String token,
           int customerID,
           java.lang.String oldPasswordEncrypted,
           java.lang.String newPasswordEncrypted,
           boolean sendEmailConfirmation,
           java.lang.String sendEmailContent) {
           this.clientID = clientID;
           this.token = token;
           this.customerID = customerID;
           this.oldPasswordEncrypted = oldPasswordEncrypted;
           this.newPasswordEncrypted = newPasswordEncrypted;
           this.sendEmailConfirmation = sendEmailConfirmation;
           this.sendEmailContent = sendEmailContent;
    }


    /**
     * Gets the clientID value for this ChangePassword.
     * 
     * @return clientID
     */
    public int getClientID() {
        return clientID;
    }


    /**
     * Sets the clientID value for this ChangePassword.
     * 
     * @param clientID
     */
    public void setClientID(int clientID) {
        this.clientID = clientID;
    }


    /**
     * Gets the token value for this ChangePassword.
     * 
     * @return token
     */
    public java.lang.String getToken() {
        return token;
    }


    /**
     * Sets the token value for this ChangePassword.
     * 
     * @param token
     */
    public void setToken(java.lang.String token) {
        this.token = token;
    }


    /**
     * Gets the customerID value for this ChangePassword.
     * 
     * @return customerID
     */
    public int getCustomerID() {
        return customerID;
    }


    /**
     * Sets the customerID value for this ChangePassword.
     * 
     * @param customerID
     */
    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }


    /**
     * Gets the oldPasswordEncrypted value for this ChangePassword.
     * 
     * @return oldPasswordEncrypted
     */
    public java.lang.String getOldPasswordEncrypted() {
        return oldPasswordEncrypted;
    }


    /**
     * Sets the oldPasswordEncrypted value for this ChangePassword.
     * 
     * @param oldPasswordEncrypted
     */
    public void setOldPasswordEncrypted(java.lang.String oldPasswordEncrypted) {
        this.oldPasswordEncrypted = oldPasswordEncrypted;
    }


    /**
     * Gets the newPasswordEncrypted value for this ChangePassword.
     * 
     * @return newPasswordEncrypted
     */
    public java.lang.String getNewPasswordEncrypted() {
        return newPasswordEncrypted;
    }


    /**
     * Sets the newPasswordEncrypted value for this ChangePassword.
     * 
     * @param newPasswordEncrypted
     */
    public void setNewPasswordEncrypted(java.lang.String newPasswordEncrypted) {
        this.newPasswordEncrypted = newPasswordEncrypted;
    }


    /**
     * Gets the sendEmailConfirmation value for this ChangePassword.
     * 
     * @return sendEmailConfirmation
     */
    public boolean isSendEmailConfirmation() {
        return sendEmailConfirmation;
    }


    /**
     * Sets the sendEmailConfirmation value for this ChangePassword.
     * 
     * @param sendEmailConfirmation
     */
    public void setSendEmailConfirmation(boolean sendEmailConfirmation) {
        this.sendEmailConfirmation = sendEmailConfirmation;
    }


    /**
     * Gets the sendEmailContent value for this ChangePassword.
     * 
     * @return sendEmailContent
     */
    public java.lang.String getSendEmailContent() {
        return sendEmailContent;
    }


    /**
     * Sets the sendEmailContent value for this ChangePassword.
     * 
     * @param sendEmailContent
     */
    public void setSendEmailContent(java.lang.String sendEmailContent) {
        this.sendEmailContent = sendEmailContent;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ChangePassword)) return false;
        ChangePassword other = (ChangePassword) obj;
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
            this.customerID == other.getCustomerID() &&
            ((this.oldPasswordEncrypted==null && other.getOldPasswordEncrypted()==null) || 
             (this.oldPasswordEncrypted!=null &&
              this.oldPasswordEncrypted.equals(other.getOldPasswordEncrypted()))) &&
            ((this.newPasswordEncrypted==null && other.getNewPasswordEncrypted()==null) || 
             (this.newPasswordEncrypted!=null &&
              this.newPasswordEncrypted.equals(other.getNewPasswordEncrypted()))) &&
            this.sendEmailConfirmation == other.isSendEmailConfirmation() &&
            ((this.sendEmailContent==null && other.getSendEmailContent()==null) || 
             (this.sendEmailContent!=null &&
              this.sendEmailContent.equals(other.getSendEmailContent())));
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
        _hashCode += getCustomerID();
        if (getOldPasswordEncrypted() != null) {
            _hashCode += getOldPasswordEncrypted().hashCode();
        }
        if (getNewPasswordEncrypted() != null) {
            _hashCode += getNewPasswordEncrypted().hashCode();
        }
        _hashCode += (isSendEmailConfirmation() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getSendEmailContent() != null) {
            _hashCode += getSendEmailContent().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ChangePassword.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("https://www.edomico.com/", ">ChangePassword"));
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
        elemField.setFieldName("customerID");
        elemField.setXmlName(new javax.xml.namespace.QName("https://www.edomico.com/", "CustomerID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("oldPasswordEncrypted");
        elemField.setXmlName(new javax.xml.namespace.QName("https://www.edomico.com/", "OldPasswordEncrypted"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("newPasswordEncrypted");
        elemField.setXmlName(new javax.xml.namespace.QName("https://www.edomico.com/", "NewPasswordEncrypted"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sendEmailConfirmation");
        elemField.setXmlName(new javax.xml.namespace.QName("https://www.edomico.com/", "SendEmailConfirmation"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sendEmailContent");
        elemField.setXmlName(new javax.xml.namespace.QName("https://www.edomico.com/", "SendEmailContent"));
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
