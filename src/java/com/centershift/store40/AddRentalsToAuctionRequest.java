
package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AddRentalsToAuction_Request complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AddRentalsToAuction_Request">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AuctionID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="CreateLetter" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="AssessFee" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="SiteID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="Rentals" type="{http://www.centershift.com/STORE40/}ArrayOfAuctionRentalItemData" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AddRentalsToAuction_Request", propOrder = {
    "auctionID",
    "createLetter",
    "assessFee",
    "siteID",
    "rentals"
})
public class AddRentalsToAuctionRequest {

    @XmlElement(name = "AuctionID")
    protected long auctionID;
    @XmlElement(name = "CreateLetter")
    protected boolean createLetter;
    @XmlElement(name = "AssessFee")
    protected boolean assessFee;
    @XmlElement(name = "SiteID")
    protected long siteID;
    @XmlElement(name = "Rentals")
    protected ArrayOfAuctionRentalItemData rentals;

    /**
     * Gets the value of the auctionID property.
     * 
     */
    public long getAuctionID() {
        return auctionID;
    }

    /**
     * Sets the value of the auctionID property.
     * 
     */
    public void setAuctionID(long value) {
        this.auctionID = value;
    }

    /**
     * Gets the value of the createLetter property.
     * 
     */
    public boolean isCreateLetter() {
        return createLetter;
    }

    /**
     * Sets the value of the createLetter property.
     * 
     */
    public void setCreateLetter(boolean value) {
        this.createLetter = value;
    }

    /**
     * Gets the value of the assessFee property.
     * 
     */
    public boolean isAssessFee() {
        return assessFee;
    }

    /**
     * Sets the value of the assessFee property.
     * 
     */
    public void setAssessFee(boolean value) {
        this.assessFee = value;
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
     * Gets the value of the rentals property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfAuctionRentalItemData }
     *     
     */
    public ArrayOfAuctionRentalItemData getRentals() {
        return rentals;
    }

    /**
     * Sets the value of the rentals property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfAuctionRentalItemData }
     *     
     */
    public void setRentals(ArrayOfAuctionRentalItemData value) {
        this.rentals = value;
    }

}
