
package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for CreateAuctionEndRental_Request complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CreateAuctionEndRental_Request">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SiteID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="AuctionDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="AuctionRentalsPayInfo" type="{http://www.centershift.com/STORE40/}ArrayOfAuctionEndRentalInfo" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CreateAuctionEndRental_Request", propOrder = {
    "siteID",
    "auctionDate",
    "auctionRentalsPayInfo"
})
public class CreateAuctionEndRentalRequest {

    @XmlElement(name = "SiteID")
    protected long siteID;
    @XmlElement(name = "AuctionDate", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar auctionDate;
    @XmlElement(name = "AuctionRentalsPayInfo")
    protected ArrayOfAuctionEndRentalInfo auctionRentalsPayInfo;

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
     * Gets the value of the auctionDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getAuctionDate() {
        return auctionDate;
    }

    /**
     * Sets the value of the auctionDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setAuctionDate(XMLGregorianCalendar value) {
        this.auctionDate = value;
    }

    /**
     * Gets the value of the auctionRentalsPayInfo property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfAuctionEndRentalInfo }
     *     
     */
    public ArrayOfAuctionEndRentalInfo getAuctionRentalsPayInfo() {
        return auctionRentalsPayInfo;
    }

    /**
     * Sets the value of the auctionRentalsPayInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfAuctionEndRentalInfo }
     *     
     */
    public void setAuctionRentalsPayInfo(ArrayOfAuctionEndRentalInfo value) {
        this.auctionRentalsPayInfo = value;
    }

}
