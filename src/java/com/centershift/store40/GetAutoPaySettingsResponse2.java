
package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GetAutoPaySettings_Response complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetAutoPaySettings_Response">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AutoPayID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="RentalID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="Street" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="State" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="City" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PostalCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AccountType" type="{http://www.centershift.com/STORE40/}APAccountType"/>
 *         &lt;element name="CreditCardInfo" type="{http://www.centershift.com/STORE40/}APCreditCardData" minOccurs="0"/>
 *         &lt;element name="ACHInfo" type="{http://www.centershift.com/STORE40/}APACHData" minOccurs="0"/>
 *         &lt;element name="IsActive" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetAutoPaySettings_Response", propOrder = {
    "autoPayID",
    "rentalID",
    "street",
    "state",
    "city",
    "postalCode",
    "accountType",
    "creditCardInfo",
    "achInfo",
    "isActive"
})
public class GetAutoPaySettingsResponse2 {

    @XmlElement(name = "AutoPayID")
    protected long autoPayID;
    @XmlElement(name = "RentalID")
    protected long rentalID;
    @XmlElement(name = "Street")
    protected String street;
    @XmlElement(name = "State")
    protected String state;
    @XmlElement(name = "City")
    protected String city;
    @XmlElement(name = "PostalCode")
    protected String postalCode;
    @XmlElement(name = "AccountType", required = true)
    protected APAccountType accountType;
    @XmlElement(name = "CreditCardInfo")
    protected APCreditCardData creditCardInfo;
    @XmlElement(name = "ACHInfo")
    protected APACHData achInfo;
    @XmlElement(name = "IsActive")
    protected String isActive;

    /**
     * Gets the value of the autoPayID property.
     * 
     */
    public long getAutoPayID() {
        return autoPayID;
    }

    /**
     * Sets the value of the autoPayID property.
     * 
     */
    public void setAutoPayID(long value) {
        this.autoPayID = value;
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
     * Gets the value of the street property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStreet() {
        return street;
    }

    /**
     * Sets the value of the street property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStreet(String value) {
        this.street = value;
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
     * Gets the value of the isActive property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIsActive() {
        return isActive;
    }

    /**
     * Sets the value of the isActive property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIsActive(String value) {
        this.isActive = value;
    }

}
