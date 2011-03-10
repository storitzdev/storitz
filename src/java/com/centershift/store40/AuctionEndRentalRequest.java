
package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AuctionEndRental_Request complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AuctionEndRental_Request">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SiteID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="AuctionDetail" type="{http://www.centershift.com/STORE40/}ArrayOfAuctionInfo" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AuctionEndRental_Request", propOrder = {
    "siteID",
    "auctionDetail"
})
public class AuctionEndRentalRequest {

    @XmlElement(name = "SiteID")
    protected long siteID;
    @XmlElement(name = "AuctionDetail")
    protected ArrayOfAuctionInfo auctionDetail;

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
     * Gets the value of the auctionDetail property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfAuctionInfo }
     *     
     */
    public ArrayOfAuctionInfo getAuctionDetail() {
        return auctionDetail;
    }

    /**
     * Sets the value of the auctionDetail property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfAuctionInfo }
     *     
     */
    public void setAuctionDetail(ArrayOfAuctionInfo value) {
        this.auctionDetail = value;
    }

}
