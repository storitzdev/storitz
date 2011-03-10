
package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AuctionInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AuctionInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AuctionID" type="{http://www.w3.org/2001/XMLSchema}long"/>
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
@XmlType(name = "AuctionInfo", propOrder = {
    "auctionID",
    "auctionRentalsPayInfo"
})
public class AuctionInfo {

    @XmlElement(name = "AuctionID")
    protected long auctionID;
    @XmlElement(name = "AuctionRentalsPayInfo")
    protected ArrayOfAuctionEndRentalInfo auctionRentalsPayInfo;

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
