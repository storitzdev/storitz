
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
 *         &lt;element name="AddRentalsToAuctionResult" type="{http://www.centershift.com/STORE40/}AddRentalToAuction_Response" minOccurs="0"/>
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
    "addRentalsToAuctionResult"
})
@XmlRootElement(name = "AddRentalsToAuctionResponse")
public class AddRentalsToAuctionResponse {

    @XmlElement(name = "AddRentalsToAuctionResult")
    protected AddRentalToAuctionResponse addRentalsToAuctionResult;

    /**
     * Gets the value of the addRentalsToAuctionResult property.
     * 
     * @return
     *     possible object is
     *     {@link AddRentalToAuctionResponse }
     *     
     */
    public AddRentalToAuctionResponse getAddRentalsToAuctionResult() {
        return addRentalsToAuctionResult;
    }

    /**
     * Sets the value of the addRentalsToAuctionResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link AddRentalToAuctionResponse }
     *     
     */
    public void setAddRentalsToAuctionResult(AddRentalToAuctionResponse value) {
        this.addRentalsToAuctionResult = value;
    }

}
