/**
 * Authorize.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.edomico.www;

public class Authorize  implements java.io.Serializable {
    private int clientID;

    private java.lang.String token;

    private java.lang.String siteID;

    private int customerID;

    private java.lang.String units;

    private double chargeAmount;

    private int CCType;

    private java.lang.String CCNumberEncrypted;

    private java.lang.String CCExpires;

    private java.lang.String CCVEncrypted;

    private java.lang.String nameOnCC;

    private java.lang.String address1OnCC;

    private java.lang.String address2OnCC;

    private java.lang.String cityOnCC;

    private java.lang.String stateOnCC;

    private java.lang.String zipOnCC;

    private boolean saveInfo;

    private boolean recurring;

    private boolean sendConfirmationEmail;

    private java.lang.String emailContent;

    private boolean isReservation;

    public Authorize() {
    }

    public Authorize(
           int clientID,
           java.lang.String token,
           java.lang.String siteID,
           int customerID,
           java.lang.String units,
           double chargeAmount,
           int CCType,
           java.lang.String CCNumberEncrypted,
           java.lang.String CCExpires,
           java.lang.String CCVEncrypted,
           java.lang.String nameOnCC,
           java.lang.String address1OnCC,
           java.lang.String address2OnCC,
           java.lang.String cityOnCC,
           java.lang.String stateOnCC,
           java.lang.String zipOnCC,
           boolean saveInfo,
           boolean recurring,
           boolean sendConfirmationEmail,
           java.lang.String emailContent,
           boolean isReservation) {
           this.clientID = clientID;
           this.token = token;
           this.siteID = siteID;
           this.customerID = customerID;
           this.units = units;
           this.chargeAmount = chargeAmount;
           this.CCType = CCType;
           this.CCNumberEncrypted = CCNumberEncrypted;
           this.CCExpires = CCExpires;
           this.CCVEncrypted = CCVEncrypted;
           this.nameOnCC = nameOnCC;
           this.address1OnCC = address1OnCC;
           this.address2OnCC = address2OnCC;
           this.cityOnCC = cityOnCC;
           this.stateOnCC = stateOnCC;
           this.zipOnCC = zipOnCC;
           this.saveInfo = saveInfo;
           this.recurring = recurring;
           this.sendConfirmationEmail = sendConfirmationEmail;
           this.emailContent = emailContent;
           this.isReservation = isReservation;
    }


    /**
     * Gets the clientID value for this Authorize.
     * 
     * @return clientID
     */
    public int getClientID() {
        return clientID;
    }


    /**
     * Sets the clientID value for this Authorize.
     * 
     * @param clientID
     */
    public void setClientID(int clientID) {
        this.clientID = clientID;
    }


    /**
     * Gets the token value for this Authorize.
     * 
     * @return token
     */
    public java.lang.String getToken() {
        return token;
    }


    /**
     * Sets the token value for this Authorize.
     * 
     * @param token
     */
    public void setToken(java.lang.String token) {
        this.token = token;
    }


    /**
     * Gets the siteID value for this Authorize.
     * 
     * @return siteID
     */
    public java.lang.String getSiteID() {
        return siteID;
    }


    /**
     * Sets the siteID value for this Authorize.
     * 
     * @param siteID
     */
    public void setSiteID(java.lang.String siteID) {
        this.siteID = siteID;
    }


    /**
     * Gets the customerID value for this Authorize.
     * 
     * @return customerID
     */
    public int getCustomerID() {
        return customerID;
    }


    /**
     * Sets the customerID value for this Authorize.
     * 
     * @param customerID
     */
    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }


    /**
     * Gets the units value for this Authorize.
     * 
     * @return units
     */
    public java.lang.String getUnits() {
        return units;
    }


    /**
     * Sets the units value for this Authorize.
     * 
     * @param units
     */
    public void setUnits(java.lang.String units) {
        this.units = units;
    }


    /**
     * Gets the chargeAmount value for this Authorize.
     * 
     * @return chargeAmount
     */
    public double getChargeAmount() {
        return chargeAmount;
    }


    /**
     * Sets the chargeAmount value for this Authorize.
     * 
     * @param chargeAmount
     */
    public void setChargeAmount(double chargeAmount) {
        this.chargeAmount = chargeAmount;
    }


    /**
     * Gets the CCType value for this Authorize.
     * 
     * @return CCType
     */
    public int getCCType() {
        return CCType;
    }


    /**
     * Sets the CCType value for this Authorize.
     * 
     * @param CCType
     */
    public void setCCType(int CCType) {
        this.CCType = CCType;
    }


    /**
     * Gets the CCNumberEncrypted value for this Authorize.
     * 
     * @return CCNumberEncrypted
     */
    public java.lang.String getCCNumberEncrypted() {
        return CCNumberEncrypted;
    }


    /**
     * Sets the CCNumberEncrypted value for this Authorize.
     * 
     * @param CCNumberEncrypted
     */
    public void setCCNumberEncrypted(java.lang.String CCNumberEncrypted) {
        this.CCNumberEncrypted = CCNumberEncrypted;
    }


    /**
     * Gets the CCExpires value for this Authorize.
     * 
     * @return CCExpires
     */
    public java.lang.String getCCExpires() {
        return CCExpires;
    }


    /**
     * Sets the CCExpires value for this Authorize.
     * 
     * @param CCExpires
     */
    public void setCCExpires(java.lang.String CCExpires) {
        this.CCExpires = CCExpires;
    }


    /**
     * Gets the CCVEncrypted value for this Authorize.
     * 
     * @return CCVEncrypted
     */
    public java.lang.String getCCVEncrypted() {
        return CCVEncrypted;
    }


    /**
     * Sets the CCVEncrypted value for this Authorize.
     * 
     * @param CCVEncrypted
     */
    public void setCCVEncrypted(java.lang.String CCVEncrypted) {
        this.CCVEncrypted = CCVEncrypted;
    }


    /**
     * Gets the nameOnCC value for this Authorize.
     * 
     * @return nameOnCC
     */
    public java.lang.String getNameOnCC() {
        return nameOnCC;
    }


    /**
     * Sets the nameOnCC value for this Authorize.
     * 
     * @param nameOnCC
     */
    public void setNameOnCC(java.lang.String nameOnCC) {
        this.nameOnCC = nameOnCC;
    }


    /**
     * Gets the address1OnCC value for this Authorize.
     * 
     * @return address1OnCC
     */
    public java.lang.String getAddress1OnCC() {
        return address1OnCC;
    }


    /**
     * Sets the address1OnCC value for this Authorize.
     * 
     * @param address1OnCC
     */
    public void setAddress1OnCC(java.lang.String address1OnCC) {
        this.address1OnCC = address1OnCC;
    }


    /**
     * Gets the address2OnCC value for this Authorize.
     * 
     * @return address2OnCC
     */
    public java.lang.String getAddress2OnCC() {
        return address2OnCC;
    }


    /**
     * Sets the address2OnCC value for this Authorize.
     * 
     * @param address2OnCC
     */
    public void setAddress2OnCC(java.lang.String address2OnCC) {
        this.address2OnCC = address2OnCC;
    }


    /**
     * Gets the cityOnCC value for this Authorize.
     * 
     * @return cityOnCC
     */
    public java.lang.String getCityOnCC() {
        return cityOnCC;
    }


    /**
     * Sets the cityOnCC value for this Authorize.
     * 
     * @param cityOnCC
     */
    public void setCityOnCC(java.lang.String cityOnCC) {
        this.cityOnCC = cityOnCC;
    }


    /**
     * Gets the stateOnCC value for this Authorize.
     * 
     * @return stateOnCC
     */
    public java.lang.String getStateOnCC() {
        return stateOnCC;
    }


    /**
     * Sets the stateOnCC value for this Authorize.
     * 
     * @param stateOnCC
     */
    public void setStateOnCC(java.lang.String stateOnCC) {
        this.stateOnCC = stateOnCC;
    }


    /**
     * Gets the zipOnCC value for this Authorize.
     * 
     * @return zipOnCC
     */
    public java.lang.String getZipOnCC() {
        return zipOnCC;
    }


    /**
     * Sets the zipOnCC value for this Authorize.
     * 
     * @param zipOnCC
     */
    public void setZipOnCC(java.lang.String zipOnCC) {
        this.zipOnCC = zipOnCC;
    }


    /**
     * Gets the saveInfo value for this Authorize.
     * 
     * @return saveInfo
     */
    public boolean isSaveInfo() {
        return saveInfo;
    }


    /**
     * Sets the saveInfo value for this Authorize.
     * 
     * @param saveInfo
     */
    public void setSaveInfo(boolean saveInfo) {
        this.saveInfo = saveInfo;
    }


    /**
     * Gets the recurring value for this Authorize.
     * 
     * @return recurring
     */
    public boolean isRecurring() {
        return recurring;
    }


    /**
     * Sets the recurring value for this Authorize.
     * 
     * @param recurring
     */
    public void setRecurring(boolean recurring) {
        this.recurring = recurring;
    }


    /**
     * Gets the sendConfirmationEmail value for this Authorize.
     * 
     * @return sendConfirmationEmail
     */
    public boolean isSendConfirmationEmail() {
        return sendConfirmationEmail;
    }


    /**
     * Sets the sendConfirmationEmail value for this Authorize.
     * 
     * @param sendConfirmationEmail
     */
    public void setSendConfirmationEmail(boolean sendConfirmationEmail) {
        this.sendConfirmationEmail = sendConfirmationEmail;
    }


    /**
     * Gets the emailContent value for this Authorize.
     * 
     * @return emailContent
     */
    public java.lang.String getEmailContent() {
        return emailContent;
    }


    /**
     * Sets the emailContent value for this Authorize.
     * 
     * @param emailContent
     */
    public void setEmailContent(java.lang.String emailContent) {
        this.emailContent = emailContent;
    }


    /**
     * Gets the isReservation value for this Authorize.
     * 
     * @return isReservation
     */
    public boolean isIsReservation() {
        return isReservation;
    }


    /**
     * Sets the isReservation value for this Authorize.
     * 
     * @param isReservation
     */
    public void setIsReservation(boolean isReservation) {
        this.isReservation = isReservation;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Authorize)) return false;
        Authorize other = (Authorize) obj;
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
            ((this.siteID==null && other.getSiteID()==null) || 
             (this.siteID!=null &&
              this.siteID.equals(other.getSiteID()))) &&
            this.customerID == other.getCustomerID() &&
            ((this.units==null && other.getUnits()==null) || 
             (this.units!=null &&
              this.units.equals(other.getUnits()))) &&
            this.chargeAmount == other.getChargeAmount() &&
            this.CCType == other.getCCType() &&
            ((this.CCNumberEncrypted==null && other.getCCNumberEncrypted()==null) || 
             (this.CCNumberEncrypted!=null &&
              this.CCNumberEncrypted.equals(other.getCCNumberEncrypted()))) &&
            ((this.CCExpires==null && other.getCCExpires()==null) || 
             (this.CCExpires!=null &&
              this.CCExpires.equals(other.getCCExpires()))) &&
            ((this.CCVEncrypted==null && other.getCCVEncrypted()==null) || 
             (this.CCVEncrypted!=null &&
              this.CCVEncrypted.equals(other.getCCVEncrypted()))) &&
            ((this.nameOnCC==null && other.getNameOnCC()==null) || 
             (this.nameOnCC!=null &&
              this.nameOnCC.equals(other.getNameOnCC()))) &&
            ((this.address1OnCC==null && other.getAddress1OnCC()==null) || 
             (this.address1OnCC!=null &&
              this.address1OnCC.equals(other.getAddress1OnCC()))) &&
            ((this.address2OnCC==null && other.getAddress2OnCC()==null) || 
             (this.address2OnCC!=null &&
              this.address2OnCC.equals(other.getAddress2OnCC()))) &&
            ((this.cityOnCC==null && other.getCityOnCC()==null) || 
             (this.cityOnCC!=null &&
              this.cityOnCC.equals(other.getCityOnCC()))) &&
            ((this.stateOnCC==null && other.getStateOnCC()==null) || 
             (this.stateOnCC!=null &&
              this.stateOnCC.equals(other.getStateOnCC()))) &&
            ((this.zipOnCC==null && other.getZipOnCC()==null) || 
             (this.zipOnCC!=null &&
              this.zipOnCC.equals(other.getZipOnCC()))) &&
            this.saveInfo == other.isSaveInfo() &&
            this.recurring == other.isRecurring() &&
            this.sendConfirmationEmail == other.isSendConfirmationEmail() &&
            ((this.emailContent==null && other.getEmailContent()==null) || 
             (this.emailContent!=null &&
              this.emailContent.equals(other.getEmailContent()))) &&
            this.isReservation == other.isIsReservation();
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
        if (getSiteID() != null) {
            _hashCode += getSiteID().hashCode();
        }
        _hashCode += getCustomerID();
        if (getUnits() != null) {
            _hashCode += getUnits().hashCode();
        }
        _hashCode += new Double(getChargeAmount()).hashCode();
        _hashCode += getCCType();
        if (getCCNumberEncrypted() != null) {
            _hashCode += getCCNumberEncrypted().hashCode();
        }
        if (getCCExpires() != null) {
            _hashCode += getCCExpires().hashCode();
        }
        if (getCCVEncrypted() != null) {
            _hashCode += getCCVEncrypted().hashCode();
        }
        if (getNameOnCC() != null) {
            _hashCode += getNameOnCC().hashCode();
        }
        if (getAddress1OnCC() != null) {
            _hashCode += getAddress1OnCC().hashCode();
        }
        if (getAddress2OnCC() != null) {
            _hashCode += getAddress2OnCC().hashCode();
        }
        if (getCityOnCC() != null) {
            _hashCode += getCityOnCC().hashCode();
        }
        if (getStateOnCC() != null) {
            _hashCode += getStateOnCC().hashCode();
        }
        if (getZipOnCC() != null) {
            _hashCode += getZipOnCC().hashCode();
        }
        _hashCode += (isSaveInfo() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isRecurring() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isSendConfirmationEmail() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getEmailContent() != null) {
            _hashCode += getEmailContent().hashCode();
        }
        _hashCode += (isIsReservation() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Authorize.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("https://www.edomico.com/", ">Authorize"));
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
        elemField.setFieldName("siteID");
        elemField.setXmlName(new javax.xml.namespace.QName("https://www.edomico.com/", "SiteID"));
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
        elemField.setFieldName("units");
        elemField.setXmlName(new javax.xml.namespace.QName("https://www.edomico.com/", "Units"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("chargeAmount");
        elemField.setXmlName(new javax.xml.namespace.QName("https://www.edomico.com/", "ChargeAmount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("CCType");
        elemField.setXmlName(new javax.xml.namespace.QName("https://www.edomico.com/", "CCType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("CCNumberEncrypted");
        elemField.setXmlName(new javax.xml.namespace.QName("https://www.edomico.com/", "CCNumberEncrypted"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("CCExpires");
        elemField.setXmlName(new javax.xml.namespace.QName("https://www.edomico.com/", "CCExpires"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("CCVEncrypted");
        elemField.setXmlName(new javax.xml.namespace.QName("https://www.edomico.com/", "CCVEncrypted"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nameOnCC");
        elemField.setXmlName(new javax.xml.namespace.QName("https://www.edomico.com/", "NameOnCC"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("address1OnCC");
        elemField.setXmlName(new javax.xml.namespace.QName("https://www.edomico.com/", "Address1OnCC"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("address2OnCC");
        elemField.setXmlName(new javax.xml.namespace.QName("https://www.edomico.com/", "Address2OnCC"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cityOnCC");
        elemField.setXmlName(new javax.xml.namespace.QName("https://www.edomico.com/", "CityOnCC"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("stateOnCC");
        elemField.setXmlName(new javax.xml.namespace.QName("https://www.edomico.com/", "StateOnCC"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("zipOnCC");
        elemField.setXmlName(new javax.xml.namespace.QName("https://www.edomico.com/", "ZipOnCC"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("saveInfo");
        elemField.setXmlName(new javax.xml.namespace.QName("https://www.edomico.com/", "SaveInfo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("recurring");
        elemField.setXmlName(new javax.xml.namespace.QName("https://www.edomico.com/", "Recurring"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sendConfirmationEmail");
        elemField.setXmlName(new javax.xml.namespace.QName("https://www.edomico.com/", "SendConfirmationEmail"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("emailContent");
        elemField.setXmlName(new javax.xml.namespace.QName("https://www.edomico.com/", "EmailContent"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isReservation");
        elemField.setXmlName(new javax.xml.namespace.QName("https://www.edomico.com/", "IsReservation"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
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
