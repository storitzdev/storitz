/**
 * UpdateBilling.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.edomico.www;

public class UpdateBilling  implements java.io.Serializable {
    private int clientID;

    private java.lang.String token;

    private java.lang.String siteID;

    private int customerID;

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

    public UpdateBilling() {
    }

    public UpdateBilling(
           int clientID,
           java.lang.String token,
           java.lang.String siteID,
           int customerID,
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
           boolean recurring) {
           this.clientID = clientID;
           this.token = token;
           this.siteID = siteID;
           this.customerID = customerID;
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
    }


    /**
     * Gets the clientID value for this UpdateBilling.
     * 
     * @return clientID
     */
    public int getClientID() {
        return clientID;
    }


    /**
     * Sets the clientID value for this UpdateBilling.
     * 
     * @param clientID
     */
    public void setClientID(int clientID) {
        this.clientID = clientID;
    }


    /**
     * Gets the token value for this UpdateBilling.
     * 
     * @return token
     */
    public java.lang.String getToken() {
        return token;
    }


    /**
     * Sets the token value for this UpdateBilling.
     * 
     * @param token
     */
    public void setToken(java.lang.String token) {
        this.token = token;
    }


    /**
     * Gets the siteID value for this UpdateBilling.
     * 
     * @return siteID
     */
    public java.lang.String getSiteID() {
        return siteID;
    }


    /**
     * Sets the siteID value for this UpdateBilling.
     * 
     * @param siteID
     */
    public void setSiteID(java.lang.String siteID) {
        this.siteID = siteID;
    }


    /**
     * Gets the customerID value for this UpdateBilling.
     * 
     * @return customerID
     */
    public int getCustomerID() {
        return customerID;
    }


    /**
     * Sets the customerID value for this UpdateBilling.
     * 
     * @param customerID
     */
    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }


    /**
     * Gets the CCType value for this UpdateBilling.
     * 
     * @return CCType
     */
    public int getCCType() {
        return CCType;
    }


    /**
     * Sets the CCType value for this UpdateBilling.
     * 
     * @param CCType
     */
    public void setCCType(int CCType) {
        this.CCType = CCType;
    }


    /**
     * Gets the CCNumberEncrypted value for this UpdateBilling.
     * 
     * @return CCNumberEncrypted
     */
    public java.lang.String getCCNumberEncrypted() {
        return CCNumberEncrypted;
    }


    /**
     * Sets the CCNumberEncrypted value for this UpdateBilling.
     * 
     * @param CCNumberEncrypted
     */
    public void setCCNumberEncrypted(java.lang.String CCNumberEncrypted) {
        this.CCNumberEncrypted = CCNumberEncrypted;
    }


    /**
     * Gets the CCExpires value for this UpdateBilling.
     * 
     * @return CCExpires
     */
    public java.lang.String getCCExpires() {
        return CCExpires;
    }


    /**
     * Sets the CCExpires value for this UpdateBilling.
     * 
     * @param CCExpires
     */
    public void setCCExpires(java.lang.String CCExpires) {
        this.CCExpires = CCExpires;
    }


    /**
     * Gets the CCVEncrypted value for this UpdateBilling.
     * 
     * @return CCVEncrypted
     */
    public java.lang.String getCCVEncrypted() {
        return CCVEncrypted;
    }


    /**
     * Sets the CCVEncrypted value for this UpdateBilling.
     * 
     * @param CCVEncrypted
     */
    public void setCCVEncrypted(java.lang.String CCVEncrypted) {
        this.CCVEncrypted = CCVEncrypted;
    }


    /**
     * Gets the nameOnCC value for this UpdateBilling.
     * 
     * @return nameOnCC
     */
    public java.lang.String getNameOnCC() {
        return nameOnCC;
    }


    /**
     * Sets the nameOnCC value for this UpdateBilling.
     * 
     * @param nameOnCC
     */
    public void setNameOnCC(java.lang.String nameOnCC) {
        this.nameOnCC = nameOnCC;
    }


    /**
     * Gets the address1OnCC value for this UpdateBilling.
     * 
     * @return address1OnCC
     */
    public java.lang.String getAddress1OnCC() {
        return address1OnCC;
    }


    /**
     * Sets the address1OnCC value for this UpdateBilling.
     * 
     * @param address1OnCC
     */
    public void setAddress1OnCC(java.lang.String address1OnCC) {
        this.address1OnCC = address1OnCC;
    }


    /**
     * Gets the address2OnCC value for this UpdateBilling.
     * 
     * @return address2OnCC
     */
    public java.lang.String getAddress2OnCC() {
        return address2OnCC;
    }


    /**
     * Sets the address2OnCC value for this UpdateBilling.
     * 
     * @param address2OnCC
     */
    public void setAddress2OnCC(java.lang.String address2OnCC) {
        this.address2OnCC = address2OnCC;
    }


    /**
     * Gets the cityOnCC value for this UpdateBilling.
     * 
     * @return cityOnCC
     */
    public java.lang.String getCityOnCC() {
        return cityOnCC;
    }


    /**
     * Sets the cityOnCC value for this UpdateBilling.
     * 
     * @param cityOnCC
     */
    public void setCityOnCC(java.lang.String cityOnCC) {
        this.cityOnCC = cityOnCC;
    }


    /**
     * Gets the stateOnCC value for this UpdateBilling.
     * 
     * @return stateOnCC
     */
    public java.lang.String getStateOnCC() {
        return stateOnCC;
    }


    /**
     * Sets the stateOnCC value for this UpdateBilling.
     * 
     * @param stateOnCC
     */
    public void setStateOnCC(java.lang.String stateOnCC) {
        this.stateOnCC = stateOnCC;
    }


    /**
     * Gets the zipOnCC value for this UpdateBilling.
     * 
     * @return zipOnCC
     */
    public java.lang.String getZipOnCC() {
        return zipOnCC;
    }


    /**
     * Sets the zipOnCC value for this UpdateBilling.
     * 
     * @param zipOnCC
     */
    public void setZipOnCC(java.lang.String zipOnCC) {
        this.zipOnCC = zipOnCC;
    }


    /**
     * Gets the saveInfo value for this UpdateBilling.
     * 
     * @return saveInfo
     */
    public boolean isSaveInfo() {
        return saveInfo;
    }


    /**
     * Sets the saveInfo value for this UpdateBilling.
     * 
     * @param saveInfo
     */
    public void setSaveInfo(boolean saveInfo) {
        this.saveInfo = saveInfo;
    }


    /**
     * Gets the recurring value for this UpdateBilling.
     * 
     * @return recurring
     */
    public boolean isRecurring() {
        return recurring;
    }


    /**
     * Sets the recurring value for this UpdateBilling.
     * 
     * @param recurring
     */
    public void setRecurring(boolean recurring) {
        this.recurring = recurring;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof UpdateBilling)) return false;
        UpdateBilling other = (UpdateBilling) obj;
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
            this.recurring == other.isRecurring();
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
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(UpdateBilling.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("https://www.edomico.com/", ">UpdateBilling"));
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
