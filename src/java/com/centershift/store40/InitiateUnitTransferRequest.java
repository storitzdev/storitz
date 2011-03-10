
package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for InitiateUnitTransfer_Request complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="InitiateUnitTransfer_Request">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="OrgID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="SiteID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="AccountID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="PrimaryFromRental" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="SetEndDay" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="TransferInvoice" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="TransferServices" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="TransferInsurance" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="FromRentals" type="{http://www.centershift.com/STORE40/}ArrayOfRentalInfo" minOccurs="0"/>
 *         &lt;element name="ToUnits" type="{http://www.centershift.com/STORE40/}ArrayOfUnitInfo" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "InitiateUnitTransfer_Request", propOrder = {
    "orgID",
    "siteID",
    "accountID",
    "primaryFromRental",
    "setEndDay",
    "transferInvoice",
    "transferServices",
    "transferInsurance",
    "fromRentals",
    "toUnits"
})
public class InitiateUnitTransferRequest {

    @XmlElement(name = "OrgID")
    protected long orgID;
    @XmlElement(name = "SiteID")
    protected long siteID;
    @XmlElement(name = "AccountID")
    protected long accountID;
    @XmlElement(name = "PrimaryFromRental", required = true, type = Long.class, nillable = true)
    protected Long primaryFromRental;
    @XmlElement(name = "SetEndDay", required = true, type = Integer.class, nillable = true)
    protected Integer setEndDay;
    @XmlElement(name = "TransferInvoice", required = true, type = Boolean.class, nillable = true)
    protected Boolean transferInvoice;
    @XmlElement(name = "TransferServices", required = true, type = Boolean.class, nillable = true)
    protected Boolean transferServices;
    @XmlElement(name = "TransferInsurance", required = true, type = Boolean.class, nillable = true)
    protected Boolean transferInsurance;
    @XmlElement(name = "FromRentals")
    protected ArrayOfRentalInfo fromRentals;
    @XmlElement(name = "ToUnits")
    protected ArrayOfUnitInfo toUnits;

    /**
     * Gets the value of the orgID property.
     * 
     */
    public long getOrgID() {
        return orgID;
    }

    /**
     * Sets the value of the orgID property.
     * 
     */
    public void setOrgID(long value) {
        this.orgID = value;
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
     * Gets the value of the primaryFromRental property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getPrimaryFromRental() {
        return primaryFromRental;
    }

    /**
     * Sets the value of the primaryFromRental property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setPrimaryFromRental(Long value) {
        this.primaryFromRental = value;
    }

    /**
     * Gets the value of the setEndDay property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getSetEndDay() {
        return setEndDay;
    }

    /**
     * Sets the value of the setEndDay property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setSetEndDay(Integer value) {
        this.setEndDay = value;
    }

    /**
     * Gets the value of the transferInvoice property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isTransferInvoice() {
        return transferInvoice;
    }

    /**
     * Sets the value of the transferInvoice property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setTransferInvoice(Boolean value) {
        this.transferInvoice = value;
    }

    /**
     * Gets the value of the transferServices property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isTransferServices() {
        return transferServices;
    }

    /**
     * Sets the value of the transferServices property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setTransferServices(Boolean value) {
        this.transferServices = value;
    }

    /**
     * Gets the value of the transferInsurance property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isTransferInsurance() {
        return transferInsurance;
    }

    /**
     * Sets the value of the transferInsurance property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setTransferInsurance(Boolean value) {
        this.transferInsurance = value;
    }

    /**
     * Gets the value of the fromRentals property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfRentalInfo }
     *     
     */
    public ArrayOfRentalInfo getFromRentals() {
        return fromRentals;
    }

    /**
     * Sets the value of the fromRentals property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfRentalInfo }
     *     
     */
    public void setFromRentals(ArrayOfRentalInfo value) {
        this.fromRentals = value;
    }

    /**
     * Gets the value of the toUnits property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfUnitInfo }
     *     
     */
    public ArrayOfUnitInfo getToUnits() {
        return toUnits;
    }

    /**
     * Sets the value of the toUnits property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfUnitInfo }
     *     
     */
    public void setToUnits(ArrayOfUnitInfo value) {
        this.toUnits = value;
    }

}
