
package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AutoPayData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AutoPayData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="IsNew" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="AutoPayID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="IsActive" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="SiteID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="AccountID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="RentalID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="AccountType" type="{http://www.centershift.com/STORE40/}APAccountType"/>
 *         &lt;element name="StreetAddress" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="City" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="State" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PostalCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CreditCardInfo" type="{http://www.centershift.com/STORE40/}APCreditCardData" minOccurs="0"/>
 *         &lt;element name="ACHInfo" type="{http://www.centershift.com/STORE40/}APACHData" minOccurs="0"/>
 *         &lt;element name="NoActiveAP" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AutoPayData", propOrder = {
    "isNew",
    "autoPayID",
    "isActive",
    "siteID",
    "accountID",
    "rentalID",
    "accountType",
    "streetAddress",
    "city",
    "state",
    "postalCode",
    "creditCardInfo",
    "achInfo",
    "noActiveAP"
})
public class AutoPayData {

    @XmlElement(name = "IsNew")
    protected boolean isNew;
    @XmlElement(name = "AutoPayID", required = true, type = Long.class, nillable = true)
    protected Long autoPayID;
    @XmlElement(name = "IsActive")
    protected boolean isActive;
    @XmlElement(name = "SiteID")
    protected long siteID;
    @XmlElement(name = "AccountID")
    protected long accountID;
    @XmlElement(name = "RentalID")
    protected long rentalID;
    @XmlElement(name = "AccountType", required = true)
    protected APAccountType accountType;
    @XmlElement(name = "StreetAddress")
    protected String streetAddress;
    @XmlElement(name = "City")
    protected String city;
    @XmlElement(name = "State")
    protected String state;
    @XmlElement(name = "PostalCode")
    protected String postalCode;
    @XmlElement(name = "CreditCardInfo")
    protected APCreditCardData creditCardInfo;
    @XmlElement(name = "ACHInfo")
    protected APACHData achInfo;
    @XmlElement(name = "NoActiveAP")
    protected boolean noActiveAP;

    /**
     * Gets the value of the isNew property.
     * 
     */
    public boolean isIsNew() {
        return isNew;
    }

    /**
     * Sets the value of the isNew property.
     * 
     */
    public void setIsNew(boolean value) {
        this.isNew = value;
    }

    /**
     * Gets the value of the autoPayID property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getAutoPayID() {
        return autoPayID;
    }

    /**
     * Sets the value of the autoPayID property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setAutoPayID(Long value) {
        this.autoPayID = value;
    }

    /**
     * Gets the value of the isActive property.
     * 
     */
    public boolean isIsActive() {
        return isActive;
    }

    /**
     * Sets the value of the isActive property.
     * 
     */
    public void setIsActive(boolean value) {
        this.isActive = value;
    }

    /**
     * Gets the value of the siteID property.
     * 
     */
    public long getSiteID() {
        return siteID;
    }

    /**
     * Sets the value of the siteID property.
     * 
     */
    public void setSiteID(long value) {
        this.siteID = value;
    }

    /**
     * Gets the value of the accountID property.
     * 
     */
    public long getAccountID() {
        return accountID;
    }

    /**
     * Sets the value of the accountID property.
     * 
     */
    public void setAccountID(long value) {
        this.accountID = value;
    }

    /**
     * Gets the value of the rentalID property.
     * 
     */
    public long getRentalID() {
        return rentalID;
    }

    /**
     * Sets the value of the rentalID property.
     * 
     */
    public void setRentalID(long value) {
        this.rentalID = value;
    }

    /**
     * Gets the value of the accountType property.
     * 
     * @return
     *     possible object is
     *     {@link APAccountType }
     *     
     */
    public APAccountType getAccountType() {
        return accountType;
    }

    /**
     * Sets the value of the accountType property.
     * 
     * @param value
     *     allowed object is
     *     {@link APAccountType }
     *     
     */
    public void setAccountType(APAccountType value) {
        this.accountType = value;
    }

    /**
     * Gets the value of the streetAddress property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStreetAddress() {
        return streetAddress;
    }

    /**
     * Sets the value of the streetAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStreetAddress(String value) {
        this.streetAddress = value;
    }

    /**
     * Gets the value of the city property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCity() {
        return city;
    }

    /**
     * Sets the value of the city property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCity(String value) {
        this.city = value;
    }

    /**
     * Gets the value of the state property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getState() {
        return state;
    }

    /**
     * Sets the value of the state property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setState(String value) {
        this.state = value;
    }

    /**
     * Gets the value of the postalCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPostalCode() {
        return postalCode;
    }

    /**
     * Sets the value of the postalCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPostalCode(String value) {
        this.postalCode = value;
    }

    /**
     * Gets the value of the creditCardInfo property.
     * 
     * @return
     *     possible object is
     *     {@link APCreditCardData }
     *     
     */
    public APCreditCardData getCreditCardInfo() {
        return creditCardInfo;
    }

    /**
     * Sets the value of the creditCardInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link APCreditCardData }
     *     
     */
    public void setCreditCardInfo(APCreditCardData value) {
        this.creditCardInfo = value;
    }

    /**
     * Gets the value of the achInfo property.
     * 
     * @return
     *     possible object is
     *     {@link APACHData }
     *     
     */
    public APACHData getACHInfo() {
        return achInfo;
    }

    /**
     * Sets the value of the achInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link APACHData }
     *     
     */
    public void setACHInfo(APACHData value) {
        this.achInfo = value;
    }

    /**
     * Gets the value of the noActiveAP property.
     * 
     */
    public boolean isNoActiveAP() {
        return noActiveAP;
    }

    /**
     * Sets the value of the noActiveAP property.
     * 
     */
    public void setNoActiveAP(boolean value) {
        this.noActiveAP = value;
    }

}
