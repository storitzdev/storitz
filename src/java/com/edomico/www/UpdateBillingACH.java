/**
 * UpdateBillingACH.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.edomico.www;

public class UpdateBillingACH  implements java.io.Serializable {
    private int clientID;

    private java.lang.String token;

    private java.lang.String siteID;

    private int customerID;

    private java.lang.String rountingNo;

    private java.lang.String encryptedAccountNo;

    private java.lang.String nameOnAccount;

    private java.lang.String address1OnAccount;

    private java.lang.String address2OnAccount;

    private java.lang.String cityOnAccount;

    private java.lang.String stateOnAccount;

    private java.lang.String zipOnAccount;

    private org.apache.axis.types.UnsignedByte accountClass;

    private org.apache.axis.types.UnsignedByte accountTypeACH;

    private java.lang.String driversLicenseNumber;

    private java.lang.String driversLicenseState;

    private java.util.Calendar birthDate;

    private java.lang.String countryCode;

    private int checkNumber;

    private boolean saveInfo;

    private boolean recurring;

    public UpdateBillingACH() {
    }

    public UpdateBillingACH(
           int clientID,
           java.lang.String token,
           java.lang.String siteID,
           int customerID,
           java.lang.String rountingNo,
           java.lang.String encryptedAccountNo,
           java.lang.String nameOnAccount,
           java.lang.String address1OnAccount,
           java.lang.String address2OnAccount,
           java.lang.String cityOnAccount,
           java.lang.String stateOnAccount,
           java.lang.String zipOnAccount,
           org.apache.axis.types.UnsignedByte accountClass,
           org.apache.axis.types.UnsignedByte accountTypeACH,
           java.lang.String driversLicenseNumber,
           java.lang.String driversLicenseState,
           java.util.Calendar birthDate,
           java.lang.String countryCode,
           int checkNumber,
           boolean saveInfo,
           boolean recurring) {
           this.clientID = clientID;
           this.token = token;
           this.siteID = siteID;
           this.customerID = customerID;
           this.rountingNo = rountingNo;
           this.encryptedAccountNo = encryptedAccountNo;
           this.nameOnAccount = nameOnAccount;
           this.address1OnAccount = address1OnAccount;
           this.address2OnAccount = address2OnAccount;
           this.cityOnAccount = cityOnAccount;
           this.stateOnAccount = stateOnAccount;
           this.zipOnAccount = zipOnAccount;
           this.accountClass = accountClass;
           this.accountTypeACH = accountTypeACH;
           this.driversLicenseNumber = driversLicenseNumber;
           this.driversLicenseState = driversLicenseState;
           this.birthDate = birthDate;
           this.countryCode = countryCode;
           this.checkNumber = checkNumber;
           this.saveInfo = saveInfo;
           this.recurring = recurring;
    }


    /**
     * Gets the clientID value for this UpdateBillingACH.
     * 
     * @return clientID
     */
    public int getClientID() {
        return clientID;
    }


    /**
     * Sets the clientID value for this UpdateBillingACH.
     * 
     * @param clientID
     */
    public void setClientID(int clientID) {
        this.clientID = clientID;
    }


    /**
     * Gets the token value for this UpdateBillingACH.
     * 
     * @return token
     */
    public java.lang.String getToken() {
        return token;
    }


    /**
     * Sets the token value for this UpdateBillingACH.
     * 
     * @param token
     */
    public void setToken(java.lang.String token) {
        this.token = token;
    }


    /**
     * Gets the siteID value for this UpdateBillingACH.
     * 
     * @return siteID
     */
    public java.lang.String getSiteID() {
        return siteID;
    }


    /**
     * Sets the siteID value for this UpdateBillingACH.
     * 
     * @param siteID
     */
    public void setSiteID(java.lang.String siteID) {
        this.siteID = siteID;
    }


    /**
     * Gets the customerID value for this UpdateBillingACH.
     * 
     * @return customerID
     */
    public int getCustomerID() {
        return customerID;
    }


    /**
     * Sets the customerID value for this UpdateBillingACH.
     * 
     * @param customerID
     */
    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }


    /**
     * Gets the rountingNo value for this UpdateBillingACH.
     * 
     * @return rountingNo
     */
    public java.lang.String getRountingNo() {
        return rountingNo;
    }


    /**
     * Sets the rountingNo value for this UpdateBillingACH.
     * 
     * @param rountingNo
     */
    public void setRountingNo(java.lang.String rountingNo) {
        this.rountingNo = rountingNo;
    }


    /**
     * Gets the encryptedAccountNo value for this UpdateBillingACH.
     * 
     * @return encryptedAccountNo
     */
    public java.lang.String getEncryptedAccountNo() {
        return encryptedAccountNo;
    }


    /**
     * Sets the encryptedAccountNo value for this UpdateBillingACH.
     * 
     * @param encryptedAccountNo
     */
    public void setEncryptedAccountNo(java.lang.String encryptedAccountNo) {
        this.encryptedAccountNo = encryptedAccountNo;
    }


    /**
     * Gets the nameOnAccount value for this UpdateBillingACH.
     * 
     * @return nameOnAccount
     */
    public java.lang.String getNameOnAccount() {
        return nameOnAccount;
    }


    /**
     * Sets the nameOnAccount value for this UpdateBillingACH.
     * 
     * @param nameOnAccount
     */
    public void setNameOnAccount(java.lang.String nameOnAccount) {
        this.nameOnAccount = nameOnAccount;
    }


    /**
     * Gets the address1OnAccount value for this UpdateBillingACH.
     * 
     * @return address1OnAccount
     */
    public java.lang.String getAddress1OnAccount() {
        return address1OnAccount;
    }


    /**
     * Sets the address1OnAccount value for this UpdateBillingACH.
     * 
     * @param address1OnAccount
     */
    public void setAddress1OnAccount(java.lang.String address1OnAccount) {
        this.address1OnAccount = address1OnAccount;
    }


    /**
     * Gets the address2OnAccount value for this UpdateBillingACH.
     * 
     * @return address2OnAccount
     */
    public java.lang.String getAddress2OnAccount() {
        return address2OnAccount;
    }


    /**
     * Sets the address2OnAccount value for this UpdateBillingACH.
     * 
     * @param address2OnAccount
     */
    public void setAddress2OnAccount(java.lang.String address2OnAccount) {
        this.address2OnAccount = address2OnAccount;
    }


    /**
     * Gets the cityOnAccount value for this UpdateBillingACH.
     * 
     * @return cityOnAccount
     */
    public java.lang.String getCityOnAccount() {
        return cityOnAccount;
    }


    /**
     * Sets the cityOnAccount value for this UpdateBillingACH.
     * 
     * @param cityOnAccount
     */
    public void setCityOnAccount(java.lang.String cityOnAccount) {
        this.cityOnAccount = cityOnAccount;
    }


    /**
     * Gets the stateOnAccount value for this UpdateBillingACH.
     * 
     * @return stateOnAccount
     */
    public java.lang.String getStateOnAccount() {
        return stateOnAccount;
    }


    /**
     * Sets the stateOnAccount value for this UpdateBillingACH.
     * 
     * @param stateOnAccount
     */
    public void setStateOnAccount(java.lang.String stateOnAccount) {
        this.stateOnAccount = stateOnAccount;
    }


    /**
     * Gets the zipOnAccount value for this UpdateBillingACH.
     * 
     * @return zipOnAccount
     */
    public java.lang.String getZipOnAccount() {
        return zipOnAccount;
    }


    /**
     * Sets the zipOnAccount value for this UpdateBillingACH.
     * 
     * @param zipOnAccount
     */
    public void setZipOnAccount(java.lang.String zipOnAccount) {
        this.zipOnAccount = zipOnAccount;
    }


    /**
     * Gets the accountClass value for this UpdateBillingACH.
     * 
     * @return accountClass
     */
    public org.apache.axis.types.UnsignedByte getAccountClass() {
        return accountClass;
    }


    /**
     * Sets the accountClass value for this UpdateBillingACH.
     * 
     * @param accountClass
     */
    public void setAccountClass(org.apache.axis.types.UnsignedByte accountClass) {
        this.accountClass = accountClass;
    }


    /**
     * Gets the accountTypeACH value for this UpdateBillingACH.
     * 
     * @return accountTypeACH
     */
    public org.apache.axis.types.UnsignedByte getAccountTypeACH() {
        return accountTypeACH;
    }


    /**
     * Sets the accountTypeACH value for this UpdateBillingACH.
     * 
     * @param accountTypeACH
     */
    public void setAccountTypeACH(org.apache.axis.types.UnsignedByte accountTypeACH) {
        this.accountTypeACH = accountTypeACH;
    }


    /**
     * Gets the driversLicenseNumber value for this UpdateBillingACH.
     * 
     * @return driversLicenseNumber
     */
    public java.lang.String getDriversLicenseNumber() {
        return driversLicenseNumber;
    }


    /**
     * Sets the driversLicenseNumber value for this UpdateBillingACH.
     * 
     * @param driversLicenseNumber
     */
    public void setDriversLicenseNumber(java.lang.String driversLicenseNumber) {
        this.driversLicenseNumber = driversLicenseNumber;
    }


    /**
     * Gets the driversLicenseState value for this UpdateBillingACH.
     * 
     * @return driversLicenseState
     */
    public java.lang.String getDriversLicenseState() {
        return driversLicenseState;
    }


    /**
     * Sets the driversLicenseState value for this UpdateBillingACH.
     * 
     * @param driversLicenseState
     */
    public void setDriversLicenseState(java.lang.String driversLicenseState) {
        this.driversLicenseState = driversLicenseState;
    }


    /**
     * Gets the birthDate value for this UpdateBillingACH.
     * 
     * @return birthDate
     */
    public java.util.Calendar getBirthDate() {
        return birthDate;
    }


    /**
     * Sets the birthDate value for this UpdateBillingACH.
     * 
     * @param birthDate
     */
    public void setBirthDate(java.util.Calendar birthDate) {
        this.birthDate = birthDate;
    }


    /**
     * Gets the countryCode value for this UpdateBillingACH.
     * 
     * @return countryCode
     */
    public java.lang.String getCountryCode() {
        return countryCode;
    }


    /**
     * Sets the countryCode value for this UpdateBillingACH.
     * 
     * @param countryCode
     */
    public void setCountryCode(java.lang.String countryCode) {
        this.countryCode = countryCode;
    }


    /**
     * Gets the checkNumber value for this UpdateBillingACH.
     * 
     * @return checkNumber
     */
    public int getCheckNumber() {
        return checkNumber;
    }


    /**
     * Sets the checkNumber value for this UpdateBillingACH.
     * 
     * @param checkNumber
     */
    public void setCheckNumber(int checkNumber) {
        this.checkNumber = checkNumber;
    }


    /**
     * Gets the saveInfo value for this UpdateBillingACH.
     * 
     * @return saveInfo
     */
    public boolean isSaveInfo() {
        return saveInfo;
    }


    /**
     * Sets the saveInfo value for this UpdateBillingACH.
     * 
     * @param saveInfo
     */
    public void setSaveInfo(boolean saveInfo) {
        this.saveInfo = saveInfo;
    }


    /**
     * Gets the recurring value for this UpdateBillingACH.
     * 
     * @return recurring
     */
    public boolean isRecurring() {
        return recurring;
    }


    /**
     * Sets the recurring value for this UpdateBillingACH.
     * 
     * @param recurring
     */
    public void setRecurring(boolean recurring) {
        this.recurring = recurring;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof UpdateBillingACH)) return false;
        UpdateBillingACH other = (UpdateBillingACH) obj;
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
            ((this.rountingNo==null && other.getRountingNo()==null) || 
             (this.rountingNo!=null &&
              this.rountingNo.equals(other.getRountingNo()))) &&
            ((this.encryptedAccountNo==null && other.getEncryptedAccountNo()==null) || 
             (this.encryptedAccountNo!=null &&
              this.encryptedAccountNo.equals(other.getEncryptedAccountNo()))) &&
            ((this.nameOnAccount==null && other.getNameOnAccount()==null) || 
             (this.nameOnAccount!=null &&
              this.nameOnAccount.equals(other.getNameOnAccount()))) &&
            ((this.address1OnAccount==null && other.getAddress1OnAccount()==null) || 
             (this.address1OnAccount!=null &&
              this.address1OnAccount.equals(other.getAddress1OnAccount()))) &&
            ((this.address2OnAccount==null && other.getAddress2OnAccount()==null) || 
             (this.address2OnAccount!=null &&
              this.address2OnAccount.equals(other.getAddress2OnAccount()))) &&
            ((this.cityOnAccount==null && other.getCityOnAccount()==null) || 
             (this.cityOnAccount!=null &&
              this.cityOnAccount.equals(other.getCityOnAccount()))) &&
            ((this.stateOnAccount==null && other.getStateOnAccount()==null) || 
             (this.stateOnAccount!=null &&
              this.stateOnAccount.equals(other.getStateOnAccount()))) &&
            ((this.zipOnAccount==null && other.getZipOnAccount()==null) || 
             (this.zipOnAccount!=null &&
              this.zipOnAccount.equals(other.getZipOnAccount()))) &&
            ((this.accountClass==null && other.getAccountClass()==null) || 
             (this.accountClass!=null &&
              this.accountClass.equals(other.getAccountClass()))) &&
            ((this.accountTypeACH==null && other.getAccountTypeACH()==null) || 
             (this.accountTypeACH!=null &&
              this.accountTypeACH.equals(other.getAccountTypeACH()))) &&
            ((this.driversLicenseNumber==null && other.getDriversLicenseNumber()==null) || 
             (this.driversLicenseNumber!=null &&
              this.driversLicenseNumber.equals(other.getDriversLicenseNumber()))) &&
            ((this.driversLicenseState==null && other.getDriversLicenseState()==null) || 
             (this.driversLicenseState!=null &&
              this.driversLicenseState.equals(other.getDriversLicenseState()))) &&
            ((this.birthDate==null && other.getBirthDate()==null) || 
             (this.birthDate!=null &&
              this.birthDate.equals(other.getBirthDate()))) &&
            ((this.countryCode==null && other.getCountryCode()==null) || 
             (this.countryCode!=null &&
              this.countryCode.equals(other.getCountryCode()))) &&
            this.checkNumber == other.getCheckNumber() &&
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
        if (getRountingNo() != null) {
            _hashCode += getRountingNo().hashCode();
        }
        if (getEncryptedAccountNo() != null) {
            _hashCode += getEncryptedAccountNo().hashCode();
        }
        if (getNameOnAccount() != null) {
            _hashCode += getNameOnAccount().hashCode();
        }
        if (getAddress1OnAccount() != null) {
            _hashCode += getAddress1OnAccount().hashCode();
        }
        if (getAddress2OnAccount() != null) {
            _hashCode += getAddress2OnAccount().hashCode();
        }
        if (getCityOnAccount() != null) {
            _hashCode += getCityOnAccount().hashCode();
        }
        if (getStateOnAccount() != null) {
            _hashCode += getStateOnAccount().hashCode();
        }
        if (getZipOnAccount() != null) {
            _hashCode += getZipOnAccount().hashCode();
        }
        if (getAccountClass() != null) {
            _hashCode += getAccountClass().hashCode();
        }
        if (getAccountTypeACH() != null) {
            _hashCode += getAccountTypeACH().hashCode();
        }
        if (getDriversLicenseNumber() != null) {
            _hashCode += getDriversLicenseNumber().hashCode();
        }
        if (getDriversLicenseState() != null) {
            _hashCode += getDriversLicenseState().hashCode();
        }
        if (getBirthDate() != null) {
            _hashCode += getBirthDate().hashCode();
        }
        if (getCountryCode() != null) {
            _hashCode += getCountryCode().hashCode();
        }
        _hashCode += getCheckNumber();
        _hashCode += (isSaveInfo() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isRecurring() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(UpdateBillingACH.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("https://www.edomico.com/", ">UpdateBillingACH"));
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
        elemField.setFieldName("rountingNo");
        elemField.setXmlName(new javax.xml.namespace.QName("https://www.edomico.com/", "RountingNo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("encryptedAccountNo");
        elemField.setXmlName(new javax.xml.namespace.QName("https://www.edomico.com/", "EncryptedAccountNo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nameOnAccount");
        elemField.setXmlName(new javax.xml.namespace.QName("https://www.edomico.com/", "NameOnAccount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("address1OnAccount");
        elemField.setXmlName(new javax.xml.namespace.QName("https://www.edomico.com/", "Address1OnAccount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("address2OnAccount");
        elemField.setXmlName(new javax.xml.namespace.QName("https://www.edomico.com/", "Address2OnAccount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cityOnAccount");
        elemField.setXmlName(new javax.xml.namespace.QName("https://www.edomico.com/", "CityOnAccount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("stateOnAccount");
        elemField.setXmlName(new javax.xml.namespace.QName("https://www.edomico.com/", "StateOnAccount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("zipOnAccount");
        elemField.setXmlName(new javax.xml.namespace.QName("https://www.edomico.com/", "ZipOnAccount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("accountClass");
        elemField.setXmlName(new javax.xml.namespace.QName("https://www.edomico.com/", "AccountClass"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "unsignedByte"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("accountTypeACH");
        elemField.setXmlName(new javax.xml.namespace.QName("https://www.edomico.com/", "AccountTypeACH"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "unsignedByte"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("driversLicenseNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("https://www.edomico.com/", "DriversLicenseNumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("driversLicenseState");
        elemField.setXmlName(new javax.xml.namespace.QName("https://www.edomico.com/", "DriversLicenseState"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("birthDate");
        elemField.setXmlName(new javax.xml.namespace.QName("https://www.edomico.com/", "BirthDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("countryCode");
        elemField.setXmlName(new javax.xml.namespace.QName("https://www.edomico.com/", "CountryCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("checkNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("https://www.edomico.com/", "CheckNumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
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
