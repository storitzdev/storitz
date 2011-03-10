
package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for CreateAuction_Request complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CreateAuction_Request">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SiteID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="AuctionDateTime" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="AuctioneerName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AuctionNotes" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CreateAuction_Request", propOrder = {
    "siteID",
    "auctionDateTime",
    "auctioneerName",
    "auctionNotes"
})
public class CreateAuctionRequest {

    @XmlElement(name = "SiteID")
    protected long siteID;
    @XmlElement(name = "AuctionDateTime", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar auctionDateTime;
    @XmlElement(name = "AuctioneerName")
    protected String auctioneerName;
    @XmlElement(name = "AuctionNotes")
    protected String auctionNotes;

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

}
