/**
 * ChangeAddress.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.edomico.www;

public class ChangeAddress  implements java.io.Serializable {
    private int clientID;

    private java.lang.String token;

    private int customerID;

    private java.lang.String newAddress1;

    private java.lang.String newAddress2;

    private java.lang.String newCity;

    private java.lang.String newState;

    private java.lang.String newZip;

    private java.lang.String newHomePhone;

    private java.lang.String newCellPhone;

    private boolean sendEmailConfirmation;

    private java.lang.String sendEmailContent;

    public ChangeAddress() {
    }

    public ChangeAddress(
           int clientID,
           java.lang.String token,
           int customerID,
           java.lang.String newAddress1,
           java.lang.String newAddress2,
           java.lang.String newCity,
           java.lang.String newState,
           java.lang.String newZip,
           java.lang.String newHomePhone,
           java.lang.String newCellPhone,
           boolean sendEmailConfirmation,
           java.lang.String sendEmailContent) {
           this.clientID = clientID;
           this.token = token;
           this.customerID = customerID;
           this.newAddress1 = newAddress1;
           this.newAddress2 = newAddress2;
           this.newCity = newCity;
           this.newState = newState;
           this.newZip = newZip;
           this.newHomePhone = newHomePhone;
           this.newCellPhone = newCellPhone;
           this.sendEmailConfirmation = sendEmailConfirmation;
           this.sendEmailContent = sendEmailContent;
    }


    /**
     * Gets the clientID value for this ChangeAddress.
     * 
     * @return clientID
     */
    public int getClientID() {
        return clientID;
    }


    /**
     * Sets the clientID value for this ChangeAddress.
     * 
     * @param clientID
     */
    public void setClientID(int clientID) {
        this.clientID = clientID;
    }


    /**
     * Gets the token value for this ChangeAddress.
     * 
     * @return token
     */
    public java.lang.String getToken() {
        return token;
    }


    /**
     * Sets the token value for this ChangeAddress.
     * 
     * @param token
     */
    public void setToken(java.lang.String token) {
        this.token = token;
    }


    /**
     * Gets the customerID value for this ChangeAddress.
     * 
     * @return customerID
     */
    public int getCustomerID() {
        return customerID;
    }


    /**
     * Sets the customerID value for this ChangeAddress.
     * 
     * @param customerID
     */
    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }


    /**
     * Gets the newAddress1 value for this ChangeAddress.
     * 
     * @return newAddress1
     */
    public java.lang.String getNewAddress1() {
        return newAddress1;
    }


    /**
     * Sets the newAddress1 value for this ChangeAddress.
     * 
     * @param newAddress1
     */
    public void setNewAddress1(java.lang.String newAddress1) {
        this.newAddress1 = newAddress1;
    }


    /**
     * Gets the newAddress2 value for this ChangeAddress.
     * 
     * @return newAddress2
     */
    public java.lang.String getNewAddress2() {
        return newAddress2;
    }


    /**
     * Sets the newAddress2 value for this ChangeAddress.
     * 
     * @param newAddress2
     */
    public void setNewAddress2(java.lang.String newAddress2) {
        this.newAddress2 = newAddress2;
    }


    /**
     * Gets the newCity value for this ChangeAddress.
     * 
     * @return newCity
     */
    public java.lang.String getNewCity() {
        return newCity;
    }


    /**
     * Sets the newCity value for this ChangeAddress.
     * 
     * @param newCity
     */
    public void setNewCity(java.lang.String newCity) {
        this.newCity = newCity;
    }


    /**
     * Gets the newState value for this ChangeAddress.
     * 
     * @return newState
     */
    public java.lang.String getNewState() {
        return newState;
    }


    /**
     * Sets the newState value for this ChangeAddress.
     * 
     * @param newState
     */
    public void setNewState(java.lang.String newState) {
        this.newState = newState;
    }


    /**
     * Gets the newZip value for this ChangeAddress.
     * 
     * @return newZip
     */
    public java.lang.String getNewZip() {
        return newZip;
    }


    /**
     * Sets the newZip value for this ChangeAddress.
     * 
     * @param newZip
     */
    public void setNewZip(java.lang.String newZip) {
        this.newZip = newZip;
    }


    /**
     * Gets the newHomePhone value for this ChangeAddress.
     * 
     * @return newHomePhone
     */
    public java.lang.String getNewHomePhone() {
        return newHomePhone;
    }


    /**
     * Sets the newHomePhone value for this ChangeAddress.
     * 
     * @param newHomePhone
     */
    public void setNewHomePhone(java.lang.String newHomePhone) {
        this.newHomePhone = newHomePhone;
    }


    /**
     * Gets the newCellPhone value for this ChangeAddress.
     * 
     * @return newCellPhone
     */
    public java.lang.String getNewCellPhone() {
        return newCellPhone;
    }


    /**
     * Sets the newCellPhone value for this ChangeAddress.
     * 
     * @param newCellPhone
     */
    public void setNewCellPhone(java.lang.String newCellPhone) {
        this.newCellPhone = newCellPhone;
    }


    /**
     * Gets the sendEmailConfirmation value for this ChangeAddress.
     * 
     * @return sendEmailConfirmation
     */
    public boolean isSendEmailConfirmation() {
        return sendEmailConfirmation;
    }


    /**
     * Sets the sendEmailConfirmation value for this ChangeAddress.
     * 
     * @param sendEmailConfirmation
     */
    public void setSendEmailConfirmation(boolean sendEmailConfirmation) {
        this.sendEmailConfirmation = sendEmailConfirmation;
    }


    /**
     * Gets the sendEmailContent value for this ChangeAddress.
     * 
     * @return sendEmailContent
     */
    public java.lang.String getSendEmailContent() {
        return sendEmailContent;
    }


    /**
     * Sets the sendEmailContent value for this ChangeAddress.
     * 
     * @param sendEmailContent
     */
    public void setSendEmailContent(java.lang.String sendEmailContent) {
        this.sendEmailContent = sendEmailContent;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ChangeAddress)) return false;
        ChangeAddress other = (ChangeAddress) obj;
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
            ((this.newAddress1==null && other.getNewAddress1()==null) || 
             (this.newAddress1!=null &&
              this.newAddress1.equals(other.getNewAddress1()))) &&
            ((this.newAddress2==null && other.getNewAddress2()==null) || 
             (this.newAddress2!=null &&
              this.newAddress2.equals(other.getNewAddress2()))) &&
            ((this.newCity==null && other.getNewCity()==null) || 
             (this.newCity!=null &&
              this.newCity.equals(other.getNewCity()))) &&
            ((this.newState==null && other.getNewState()==null) || 
             (this.newState!=null &&
              this.newState.equals(other.getNewState()))) &&
            ((this.newZip==null && other.getNewZip()==null) || 
             (this.newZip!=null &&
              this.newZip.equals(other.getNewZip()))) &&
            ((this.newHomePhone==null && other.getNewHomePhone()==null) || 
             (this.newHomePhone!=null &&
              this.newHomePhone.equals(other.getNewHomePhone()))) &&
            ((this.newCellPhone==null && other.getNewCellPhone()==null) || 
             (this.newCellPhone!=null &&
              this.newCellPhone.equals(other.getNewCellPhone()))) &&
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
        if (getNewAddress1() != null) {
            _hashCode += getNewAddress1().hashCode();
        }
        if (getNewAddress2() != null) {
            _hashCode += getNewAddress2().hashCode();
        }
        if (getNewCity() != null) {
            _hashCode += getNewCity().hashCode();
        }
        if (getNewState() != null) {
            _hashCode += getNewState().hashCode();
        }
        if (getNewZip() != null) {
            _hashCode += getNewZip().hashCode();
        }
        if (getNewHomePhone() != null) {
            _hashCode += getNewHomePhone().hashCode();
        }
        if (getNewCellPhone() != null) {
            _hashCode += getNewCellPhone().hashCode();
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
        new org.apache.axis.description.TypeDesc(ChangeAddress.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("https://www.edomico.com/", ">ChangeAddress"));
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
        elemField.setFieldName("newAddress1");
        elemField.setXmlName(new javax.xml.namespace.QName("https://www.edomico.com/", "NewAddress1"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("newAddress2");
        elemField.setXmlName(new javax.xml.namespace.QName("https://www.edomico.com/", "NewAddress2"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("newCity");
        elemField.setXmlName(new javax.xml.namespace.QName("https://www.edomico.com/", "NewCity"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("newState");
        elemField.setXmlName(new javax.xml.namespace.QName("https://www.edomico.com/", "NewState"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("newZip");
        elemField.setXmlName(new javax.xml.namespace.QName("https://www.edomico.com/", "NewZip"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("newHomePhone");
        elemField.setXmlName(new javax.xml.namespace.QName("https://www.edomico.com/", "NewHomePhone"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("newCellPhone");
        elemField.setXmlName(new javax.xml.namespace.QName("https://www.edomico.com/", "NewCellPhone"));
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
