
package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AuctionEndRentalResult" type="{http://www.centershift.com/STORE40/}AuctionEndRental_Response"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "auctionEndRentalResult"
})
@XmlRootElement(name = "AuctionEndRentalResponse")
public class AuctionEndRentalResponse {

    @XmlElement(name = "AuctionEndRentalResult", required = true)
    protected AuctionEndRentalResponse2 auctionEndRentalResult;

    /**
     * Gets the value of the auctionEndRentalResult property.
     * 
     * @return
     *     possible object is
     *     {@link AuctionEndRentalResponse2 }
     *     
     */
    public AuctionEndRentalResponse2 getAuctionEndRentalResult() {
        return auctionEndRentalResult;
    }

    /**
     * Sets the value of the auctionEndRentalResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link AuctionEndRentalResponse2 }
     *     
     */
    public void setAuctionEndRentalResult(AuctionEndRentalResponse2 value) {
        this.auctionEndRentalResult = value;
    }

}
