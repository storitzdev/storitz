
package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AddRentalToAuction_Response complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AddRentalToAuction_Response">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="RentalItems" type="{http://www.centershift.com/STORE40/}ArrayOfAuctionRentalItemResponseData" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AddRentalToAuction_Response", propOrder = {
    "rentalItems"
})
public class AddRentalToAuctionResponse {

    @XmlElement(name = "RentalItems")
    protected ArrayOfAuctionRentalItemResponseData rentalItems;

    /**
     * Gets the value of the rentalItems property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfAuctionRentalItemResponseData }
     *     
     */
    public ArrayOfAuctionRentalItemResponseData getRentalItems() {
        return rentalItems;
    }

    /**
     * Sets the value of the rentalItems property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfAuctionRentalItemResponseData }
     *     
     */
    public void setRentalItems(ArrayOfAuctionRentalItemResponseData value) {
        this.rentalItems = value;
    }

}
