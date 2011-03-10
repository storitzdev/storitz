
package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CreateAuction_Response complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CreateAuction_Response">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AuctionID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="Details" type="{http://www.centershift.com/STORE40/}ORG_AUCTION" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CreateAuction_Response", propOrder = {
    "auctionID",
    "details"
})
public class CreateAuctionResponse {

    @XmlElement(name = "AuctionID")
    protected long auctionID;
    @XmlElement(name = "Details")
    protected ORGAUCTION details;

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
     * Gets the value of the details property.
     * 
     * @return
     *     possible object is
     *     {@link ORGAUCTION }
     *     
     */
    public ORGAUCTION getDetails() {
        return details;
    }

    /**
     * Sets the value of the details property.
     * 
     * @param value
     *     allowed object is
     *     {@link ORGAUCTION }
     *     
     */
    public void setDetails(ORGAUCTION value) {
        this.details = value;
    }

}
