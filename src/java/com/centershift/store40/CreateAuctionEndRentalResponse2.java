
package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CreateAuctionEndRental_Response complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CreateAuctionEndRental_Response">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AuctionedItems" type="{http://www.centershift.com/STORE40/}ArrayOfAuctionEndRentalComplete" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CreateAuctionEndRental_Response", propOrder = {
    "auctionedItems"
})
public class CreateAuctionEndRentalResponse2 {

    @XmlElement(name = "AuctionedItems")
    protected ArrayOfAuctionEndRentalComplete auctionedItems;

    /**
     * Gets the value of the auctionedItems property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfAuctionEndRentalComplete }
     *     
     */
    public ArrayOfAuctionEndRentalComplete getAuctionedItems() {
        return auctionedItems;
    }

    /**
     * Sets the value of the auctionedItems property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfAuctionEndRentalComplete }
     *     
     */
    public void setAuctionedItems(ArrayOfAuctionEndRentalComplete value) {
        this.auctionedItems = value;
    }

}
