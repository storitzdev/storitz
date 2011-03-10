
package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for UpdateAuction_Request complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="UpdateAuction_Request">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SiteID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="AuctionID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="AuctionDateTime" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="AuctioneerName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AuctionNotes" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AuctionStatus" type="{http://www.centershift.com/STORE40/}AuctionStatusValues"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UpdateAuction_Request", propOrder = {
    "siteID",
    "auctionID",
    "auctionDateTime",
    "auctioneerName",
    "auctionNotes",
    "auctionStatus"
})
public class UpdateAuctionRequest {

    @XmlElement(name = "SiteID")
    protected long siteID;
    @XmlElement(name = "AuctionID")
    protected long auctionID;
    @XmlElement(name = "AuctionDateTime", required = true, nillable = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar auctionDateTime;
    @XmlElement(name = "AuctioneerName")
    protected String auctioneerName;
    @XmlElement(name = "AuctionNotes")
    protected String auctionNotes;
    @XmlElement(name = "AuctionStatus", required = true, nillable = true)
    protected AuctionStatusValues auctionStatus;

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
     * Gets the value of the auctionDateTime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getAuctionDateTime() {
        return auctionDateTime;
    }

    /**
     * Sets the value of the auctionDateTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setAuctionDateTime(XMLGregorianCalendar value) {
        this.auctionDateTime = value;
    }

    /**
     * Gets the value of the auctioneerName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAuctioneerName() {
        return auctioneerName;
    }

    /**
     * Sets the value of the auctioneerName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAuctioneerName(String value) {
        this.auctioneerName = value;
    }

    /**
     * Gets the value of the auctionNotes property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAuctionNotes() {
        return auctionNotes;
    }

    /**
     * Sets the value of the auctionNotes property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAuctionNotes(String value) {
        this.auctionNotes = value;
    }

    /**
     * Gets the value of the auctionStatus property.
     * 
     * @return
     *     possible object is
     *     {@link AuctionStatusValues }
     *     
     */
    public AuctionStatusValues getAuctionStatus() {
        return auctionStatus;
    }

    /**
     * Sets the value of the auctionStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link AuctionStatusValues }
     *     
     */
    public void setAuctionStatus(AuctionStatusValues value) {
        this.auctionStatus = value;
    }

}
