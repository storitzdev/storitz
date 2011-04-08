/**
 * WriteCustomerSPAN.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.edomico.www;

public class WriteCustomerSPAN  implements java.io.Serializable {
    private int clientID;

    private java.lang.String token;

    private java.lang.String siteID;

    private long customerAccount;

    private int customerID;

    private int billingID;

    private org.apache.axis.types.UnsignedByte accountType;

    private org.apache.axis.types.UnsignedByte bankAccountType;

    private org.apache.axis.types.UnsignedByte bankAccountClass;

    private java.lang.String SPAN;

    private java.lang.String accountNo;

    private java.lang.String routingNo;

    private int checkNo;

    private java.util.Calendar expires;

    private java.lang.String CCV;

    private boolean recurring;

    private java.lang.String cardHolderName;

    private java.lang.String cardHolderAddress1;

    private java.lang.String cardHolderAddress2;

    private java.lang.String cardHolderCity;

    private java.lang.String cardHolderState;

    private java.lang.String cardHolderZip;

    private java.util.Calendar lastUsedDate;

    private java.lang.String lastAuthResult;

    private java.lang.String lastAuthID;

    private java.lang.String lastRefID;

    public WriteCustomerSPAN() {
    }

    public WriteCustomerSPAN(
           int clientID,
           java.lang.String token,
           java.lang.String siteID,
           long customerAccount,
           int customerID,
           int billingID,
           org.apache.axis.types.UnsignedByte accountType,
           org.apache.axis.types.UnsignedByte bankAccountType,
           org.apache.axis.types.UnsignedByte bankAccountClass,
           java.lang.String SPAN,
           java.lang.String accountNo,
           java.lang.String routingNo,
           int checkNo,
           java.util.Calendar expires,
           java.lang.String CCV,
           boolean recurring,
           java.lang.String cardHolderName,
           java.lang.String cardHolderAddress1,
           java.lang.String cardHolderAddress2,
           java.lang.String cardHolderCity,
           java.lang.String cardHolderState,
           java.lang.String cardHolderZip,
           java.util.Calendar lastUsedDate,
           java.lang.String lastAuthResult,
           java.lang.String lastAuthID,
           java.lang.String lastRefID) {
           this.clientID = clientID;
           this.token = token;
           this.siteID = siteID;
           this.customerAccount = customerAccount;
           this.customerID = customerID;
           this.billingID = billingID;
           this.accountType = accountType;
           this.bankAccountType = bankAccountType;
           this.bankAccountClass = bankAccountClass;
           this.SPAN = SPAN;
           this.accountNo = accountNo;
           this.routingNo = routingNo;
           this.checkNo = checkNo;
           this.expires = expires;
           this.CCV = CCV;
           this.recurring = recurring;
           this.cardHolderName = cardHolderName;
           this.cardHolderAddress1 = cardHolderAddress1;
           this.cardHolderAddress2 = cardHolderAddress2;
           this.cardHolderCity = cardHolderCity;
           this.cardHolderState = cardHolderState;
           this.cardHolderZip = cardHolderZip;
           this.lastUsedDate = lastUsedDate;
           this.lastAuthResult = lastAuthResult;
           this.lastAuthID = lastAuthID;
           this.lastRefID = lastRefID;
    }


    /**
     * Gets the clientID value for this WriteCustomerSPAN.
     * 
     * @return clientID
     */
    public int getClientID() {
        return clientID;
    }


    /**
     * Sets the clientID value for this WriteCustomerSPAN.
     * 
     * @param clientID
     */
    public void setClientID(int clientID) {
        this.clientID = clientID;
    }


    /**
     * Gets the token value for this WriteCustomerSPAN.
     * 
     * @return token
     */
    public java.lang.String getToken() {
        return token;
    }


    /**
     * Sets the token value for this WriteCustomerSPAN.
     * 
     * @param token
     */
    public void setToken(java.lang.String token) {
        this.token = token;
    }


    /**
     * Gets the siteID value for this WriteCustomerSPAN.
     * 
     * @return siteID
     */
    public java.lang.String getSiteID() {
        return siteID;
    }


    /**
     * Sets the siteID value for this WriteCustomerSPAN.
     * 
     * @param siteID
     */
    public void setSiteID(java.lang.String siteID) {
        this.siteID = siteID;
    }


    /**
     * Gets the customerAccount value for this WriteCustomerSPAN.
     * 
     * @return customerAccount
     */
    public long getCustomerAccount() {
        return customerAccount;
    }


    /**
     * Sets the customerAccount value for this WriteCustomerSPAN.
     * 
     * @param customerAccount
     */
    public void setCustomerAccount(long customerAccount) {
        this.customerAccount = customerAccount;
    }


    /**
     * Gets the customerID value for this WriteCustomerSPAN.
     * 
     * @return customerID
     */
    public int getCustomerID() {
        return customerID;
    }


    /**
     * Sets the customerID value for this WriteCustomerSPAN.
     * 
     * @param customerID
     */
    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }


    /**
     * Gets the billingID value for this WriteCustomerSPAN.
     * 
     * @return billingID
     */
    public int getBillingID() {
        return billingID;
    }


    /**
     * Sets the billingID value for this WriteCustomerSPAN.
     * 
     * @param billingID
     */
    public void setBillingID(int billingID) {
        this.billingID = billingID;
    }


    /**
     * Gets the accountType value for this WriteCustomerSPAN.
     * 
     * @return accountType
     */
    public org.apache.axis.types.UnsignedByte getAccountType() {
        return accountType;
    }


    /**
     * Sets the accountType value for this WriteCustomerSPAN.
     * 
     * @param accountType
     */
    public void setAccountType(org.apache.axis.types.UnsignedByte accountType) {
        this.accountType = accountType;
    }


    /**
     * Gets the bankAccountType value for this WriteCustomerSPAN.
     * 
     * @return bankAccountType
     */
    public org.apache.axis.types.UnsignedByte getBankAccountType() {
        return bankAccountType;
    }


    /**
     * Sets the bankAccountType value for this WriteCustomerSPAN.
     * 
     * @param bankAccountType
     */
    public void setBankAccountType(org.apache.axis.types.UnsignedByte bankAccountType) {
        this.bankAccountType = bankAccountType;
    }


    /**
     * Gets the bankAccountClass value for this WriteCustomerSPAN.
     * 
     * @return bankAccountClass
     */
    public org.apache.axis.types.UnsignedByte getBankAccountClass() {
        return bankAccountClass;
    }


    /**
     * Sets the bankAccountClass value for this WriteCustomerSPAN.
     * 
     * @param bankAccountClass
     */
    public void setBankAccountClass(org.apache.axis.types.UnsignedByte bankAccountClass) {
        this.bankAccountClass = bankAccountClass;
    }


    /**
     * Gets the SPAN value for this WriteCustomerSPAN.
     * 
     * @return SPAN
     */
    public java.lang.String getSPAN() {
        return SPAN;
    }


    /**
     * Sets the SPAN value for this WriteCustomerSPAN.
     * 
     * @param SPAN
     */
    public void setSPAN(java.lang.String SPAN) {
        this.SPAN = SPAN;
    }


    /**
     * Gets the accountNo value for this WriteCustomerSPAN.
     * 
     * @return accountNo
     */
    public java.lang.String getAccountNo() {
        return accountNo;
    }


    /**
     * Sets the accountNo value for this WriteCustomerSPAN.
     * 
     * @param accountNo
     */
    public void setAccountNo(java.lang.String accountNo) {
        this.accountNo = accountNo;
    }


    /**
     * Gets the routingNo value for this WriteCustomerSPAN.
     * 
     * @return routingNo
     */
    public java.lang.String getRoutingNo() {
        return routingNo;
    }


    /**
     * Sets the routingNo value for this WriteCustomerSPAN.
     * 
     * @param routingNo
     */
    public void setRoutingNo(java.lang.String routingNo) {
        this.routingNo = routingNo;
    }


    /**
     * Gets the checkNo value for this WriteCustomerSPAN.
     * 
     * @return checkNo
     */
    public int getCheckNo() {
        return checkNo;
    }


    /**
     * Sets the checkNo value for this WriteCustomerSPAN.
     * 
     * @param checkNo
     */
    public void setCheckNo(int checkNo) {
        this.checkNo = checkNo;
    }


    /**
     * Gets the expires value for this WriteCustomerSPAN.
     * 
     * @return expires
     */
    public java.util.Calendar getExpires() {
        return expires;
    }


    /**
     * Sets the expires value for this WriteCustomerSPAN.
     * 
     * @param expires
     */
    public void setExpires(java.util.Calendar expires) {
        this.expires = expires;
    }


    /**
     * Gets the CCV value for this WriteCustomerSPAN.
     * 
     * @return CCV
     */
    public java.lang.String getCCV() {
        return CCV;
    }


    /**
     * Sets the CCV value for this WriteCustomerSPAN.
     * 
     * @param CCV
     */
    public void setCCV(java.lang.String CCV) {
        this.CCV = CCV;
    }


    /**
     * Gets the recurring value for this WriteCustomerSPAN.
     * 
     * @return recurring
     */
    public boolean isRecurring() {
        return recurring;
    }


    /**
     * Sets the recurring value for this WriteCustomerSPAN.
     * 
     * @param recurring
     */
    public void setRecurring(boolean recurring) {
        this.recurring = recurring;
    }


    /**
     * Gets the cardHolderName value for this WriteCustomerSPAN.
     * 
     * @return cardHolderName
     */
    public java.lang.String getCardHolderName() {
        return cardHolderName;
    }


    /**
     * Sets the cardHolderName value for this WriteCustomerSPAN.
     * 
     * @param cardHolderName
     */
    public void setCardHolderName(java.lang.String cardHolderName) {
        this.cardHolderName = cardHolderName;
    }


    /**
     * Gets the cardHolderAddress1 value for this WriteCustomerSPAN.
     * 
     * @return cardHolderAddress1
     */
    public java.lang.String getCardHolderAddress1() {
        return cardHolderAddress1;
    }


    /**
     * Sets the cardHolderAddress1 value for this WriteCustomerSPAN.
     * 
     * @param cardHolderAddress1
     */
    public void setCardHolderAddress1(java.lang.String cardHolderAddress1) {
        this.cardHolderAddress1 = cardHolderAddress1;
    }


    /**
     * Gets the cardHolderAddress2 value for this WriteCustomerSPAN.
     * 
     * @return cardHolderAddress2
     */
    public java.lang.String getCardHolderAddress2() {
        return cardHolderAddress2;
    }


    /**
     * Sets the cardHolderAddress2 value for this WriteCustomerSPAN.
     * 
     * @param cardHolderAddress2
     */
    public void setCardHolderAddress2(java.lang.String cardHolderAddress2) {
        this.cardHolderAddress2 = cardHolderAddress2;
    }


    /**
     * Gets the cardHolderCity value for this WriteCustomerSPAN.
     * 
     * @return cardHolderCity
     */
    public java.lang.String getCardHolderCity() {
        return cardHolderCity;
    }


    /**
     * Sets the cardHolderCity value for this WriteCustomerSPAN.
     * 
     * @param cardHolderCity
     */
    public void setCardHolderCity(java.lang.String cardHolderCity) {
        this.cardHolderCity = cardHolderCity;
    }


    /**
     * Gets the cardHolderState value for this WriteCustomerSPAN.
     * 
     * @return cardHolderState
     */
    public java.lang.String getCardHolderState() {
        return cardHolderState;
    }


    /**
     * Sets the cardHolderState value for this WriteCustomerSPAN.
     * 
     * @param cardHolderState
     */
    public void setCardHolderState(java.lang.String cardHolderState) {
        this.cardHolderState = cardHolderState;
    }


    /**
     * Gets the cardHolderZip value for this WriteCustomerSPAN.
     * 
     * @return cardHolderZip
     */
    public java.lang.String getCardHolderZip() {
        return cardHolderZip;
    }


    /**
     * Sets the cardHolderZip value for this WriteCustomerSPAN.
     * 
     * @param cardHolderZip
     */
    public void setCardHolderZip(java.lang.String cardHolderZip) {
        this.cardHolderZip = cardHolderZip;
    }


    /**
     * Gets the lastUsedDate value for this WriteCustomerSPAN.
     * 
     * @return lastUsedDate
     */
    public java.util.Calendar getLastUsedDate() {
        return lastUsedDate;
    }


    /**
     * Sets the lastUsedDate value for this WriteCustomerSPAN.
     * 
     * @param lastUsedDate
     */
    public void setLastUsedDate(java.util.Calendar lastUsedDate) {
        this.lastUsedDate = lastUsedDate;
    }


    /**
     * Gets the lastAuthResult value for this WriteCustomerSPAN.
     * 
     * @return lastAuthResult
     */
    public java.lang.String getLastAuthResult() {
        return lastAuthResult;
    }


    /**
     * Sets the lastAuthResult value for this WriteCustomerSPAN.
     * 
     * @param lastAuthResult
     */
    public void setLastAuthResult(java.lang.String lastAuthResult) {
        this.lastAuthResult = lastAuthResult;
    }


    /**
     * Gets the lastAuthID value for this WriteCustomerSPAN.
     * 
     * @return lastAuthID
     */
    public java.lang.String getLastAuthID() {
        return lastAuthID;
    }


    /**
     * Sets the lastAuthID value for this WriteCustomerSPAN.
     * 
     * @param lastAuthID
     */
    public void setLastAuthID(java.lang.String lastAuthID) {
        this.lastAuthID = lastAuthID;
    }


    /**
     * Gets the lastRefID value for this WriteCustomerSPAN.
     * 
     * @return lastRefID
     */
    public java.lang.String getLastRefID() {
        return lastRefID;
    }


    /**
     * Sets the lastRefID value for this WriteCustomerSPAN.
     * 
     * @param lastRefID
     */
    public void setLastRefID(java.lang.String lastRefID) {
        this.lastRefID = lastRefID;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof WriteCustomerSPAN)) return false;
        WriteCustomerSPAN other = (WriteCustomerSPAN) obj;
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
            this.customerAccount == other.getCustomerAccount() &&
            this.customerID == other.getCustomerID() &&
            this.billingID == other.getBillingID() &&
            ((this.accountType==null && other.getAccountType()==null) || 
             (this.accountType!=null &&
              this.accountType.equals(other.getAccountType()))) &&
            ((this.bankAccountType==null && other.getBankAccountType()==null) || 
             (this.bankAccountType!=null &&
              this.bankAccountType.equals(other.getBankAccountType()))) &&
            ((this.bankAccountClass==null && other.getBankAccountClass()==null) || 
             (this.bankAccountClass!=null &&
              this.bankAccountClass.equals(other.getBankAccountClass()))) &&
            ((this.SPAN==null && other.getSPAN()==null) || 
             (this.SPAN!=null &&
              this.SPAN.equals(other.getSPAN()))) &&
            ((this.accountNo==null && other.getAccountNo()==null) || 
             (this.accountNo!=null &&
              this.accountNo.equals(other.getAccountNo()))) &&
            ((this.routingNo==null && other.getRoutingNo()==null) || 
             (this.routingNo!=null &&
              this.routingNo.equals(other.getRoutingNo()))) &&
            this.checkNo == other.getCheckNo() &&
            ((this.expires==null && other.getExpires()==null) || 
             (this.expires!=null &&
              this.expires.equals(other.getExpires()))) &&
            ((this.CCV==null && other.getCCV()==null) || 
             (this.CCV!=null &&
              this.CCV.equals(other.getCCV()))) &&
            this.recurring == other.isRecurring() &&
            ((this.cardHolderName==null && other.getCardHolderName()==null) || 
             (this.cardHolderName!=null &&
              this.cardHolderName.equals(other.getCardHolderName()))) &&
            ((this.cardHolderAddress1==null && other.getCardHolderAddress1()==null) || 
             (this.cardHolderAddress1!=null &&
              this.cardHolderAddress1.equals(other.getCardHolderAddress1()))) &&
            ((this.cardHolderAddress2==null && other.getCardHolderAddress2()==null) || 
             (this.cardHolderAddress2!=null &&
              this.cardHolderAddress2.equals(other.getCardHolderAddress2()))) &&
            ((this.cardHolderCity==null && other.getCardHolderCity()==null) || 
             (this.cardHolderCity!=null &&
              this.cardHolderCity.equals(other.getCardHolderCity()))) &&
            ((this.cardHolderState==null && other.getCardHolderState()==null) || 
             (this.cardHolderState!=null &&
              this.cardHolderState.equals(other.getCardHolderState()))) &&
            ((this.cardHolderZip==null && other.getCardHolderZip()==null) || 
             (this.cardHolderZip!=null &&
              this.cardHolderZip.equals(other.getCardHolderZip()))) &&
            ((this.lastUsedDate==null && other.getLastUsedDate()==null) || 
             (this.lastUsedDate!=null &&
              this.lastUsedDate.equals(other.getLastUsedDate()))) &&
            ((this.lastAuthResult==null && other.getLastAuthResult()==null) || 
             (this.lastAuthResult!=null &&
              this.lastAuthResult.equals(other.getLastAuthResult()))) &&
            ((this.lastAuthID==null && other.getLastAuthID()==null) || 
             (this.lastAuthID!=null &&
              this.lastAuthID.equals(other.getLastAuthID()))) &&
            ((this.lastRefID==null && other.getLastRefID()==null) || 
             (this.lastRefID!=null &&
              this.lastRefID.equals(other.getLastRefID())));
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
        _hashCode += new Long(getCustomerAccount()).hashCode();
        _hashCode += getCustomerID();
        _hashCode += getBillingID();
        if (getAccountType() != null) {
            _hashCode += getAccountType().hashCode();
        }
        if (getBankAccountType() != null) {
            _hashCode += getBankAccountType().hashCode();
        }
        if (getBankAccountClass() != null) {
            _hashCode += getBankAccountClass().hashCode();
        }
        if (getSPAN() != null) {
            _hashCode += getSPAN().hashCode();
        }
        if (getAccountNo() != null) {
            _hashCode += getAccountNo().hashCode();
        }
        if (getRoutingNo() != null) {
            _hashCode += getRoutingNo().hashCode();
        }
        _hashCode += getCheckNo();
        if (getExpires() != null) {
            _hashCode += getExpires().hashCode();
        }
        if (getCCV() != null) {
            _hashCode += getCCV().hashCode();
        }
        _hashCode += (isRecurring() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getCardHolderName() != null) {
            _hashCode += getCardHolderName().hashCode();
        }
        if (getCardHolderAddress1() != null) {
            _hashCode += getCardHolderAddress1().hashCode();
        }
        if (getCardHolderAddress2() != null) {
            _hashCode += getCardHolderAddress2().hashCode();
        }
        if (getCardHolderCity() != null) {
            _hashCode += getCardHolderCity().hashCode();
        }
        if (getCardHolderState() != null) {
            _hashCode += getCardHolderState().hashCode();
        }
        if (getCardHolderZip() != null) {
            _hashCode += getCardHolderZip().hashCode();
        }
        if (getLastUsedDate() != null) {
            _hashCode += getLastUsedDate().hashCode();
        }
        if (getLastAuthResult() != null) {
            _hashCode += getLastAuthResult().hashCode();
        }
        if (getLastAuthID() != null) {
            _hashCode += getLastAuthID().hashCode();
        }
        if (getLastRefID() != null) {
            _hashCode += getLastRefID().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(WriteCustomerSPAN.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("https://www.edomico.com/", ">WriteCustomerSPAN"));
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
        elemField.setFieldName("customerAccount");
        elemField.setXmlName(new javax.xml.namespace.QName("https://www.edomico.com/", "CustomerAccount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("customerID");
        elemField.setXmlName(new javax.xml.namespace.QName("https://www.edomico.com/", "CustomerID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("billingID");
        elemField.setXmlName(new javax.xml.namespace.QName("https://www.edomico.com/", "BillingID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("accountType");
        elemField.setXmlName(new javax.xml.namespace.QName("https://www.edomico.com/", "AccountType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "unsignedByte"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("bankAccountType");
        elemField.setXmlName(new javax.xml.namespace.QName("https://www.edomico.com/", "BankAccountType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "unsignedByte"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("bankAccountClass");
        elemField.setXmlName(new javax.xml.namespace.QName("https://www.edomico.com/", "BankAccountClass"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "unsignedByte"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SPAN");
        elemField.setXmlName(new javax.xml.namespace.QName("https://www.edomico.com/", "SPAN"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("accountNo");
        elemField.setXmlName(new javax.xml.namespace.QName("https://www.edomico.com/", "AccountNo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("routingNo");
        elemField.setXmlName(new javax.xml.namespace.QName("https://www.edomico.com/", "RoutingNo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("checkNo");
        elemField.setXmlName(new javax.xml.namespace.QName("https://www.edomico.com/", "CheckNo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("expires");
        elemField.setXmlName(new javax.xml.namespace.QName("https://www.edomico.com/", "Expires"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("CCV");
        elemField.setXmlName(new javax.xml.namespace.QName("https://www.edomico.com/", "CCV"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("recurring");
        elemField.setXmlName(new javax.xml.namespace.QName("https://www.edomico.com/", "Recurring"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cardHolderName");
        elemField.setXmlName(new javax.xml.namespace.QName("https://www.edomico.com/", "CardHolderName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cardHolderAddress1");
        elemField.setXmlName(new javax.xml.namespace.QName("https://www.edomico.com/", "CardHolderAddress1"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cardHolderAddress2");
        elemField.setXmlName(new javax.xml.namespace.QName("https://www.edomico.com/", "CardHolderAddress2"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cardHolderCity");
        elemField.setXmlName(new javax.xml.namespace.QName("https://www.edomico.com/", "CardHolderCity"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cardHolderState");
        elemField.setXmlName(new javax.xml.namespace.QName("https://www.edomico.com/", "CardHolderState"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cardHolderZip");
        elemField.setXmlName(new javax.xml.namespace.QName("https://www.edomico.com/", "CardHolderZip"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("lastUsedDate");
        elemField.setXmlName(new javax.xml.namespace.QName("https://www.edomico.com/", "LastUsedDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("lastAuthResult");
        elemField.setXmlName(new javax.xml.namespace.QName("https://www.edomico.com/", "LastAuthResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("lastAuthID");
        elemField.setXmlName(new javax.xml.namespace.QName("https://www.edomico.com/", "LastAuthID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("lastRefID");
        elemField.setXmlName(new javax.xml.namespace.QName("https://www.edomico.com/", "LastRefID"));
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
