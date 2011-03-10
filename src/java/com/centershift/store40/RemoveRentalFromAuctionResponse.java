
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
 *         &lt;element name="RemoveRentalFromAuctionResult" type="{http://www.centershift.com/STORE40/}RemoveRentalFromAuction_Response"/>
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
    "removeRentalFromAuctionResult"
})
@XmlRootElement(name = "RemoveRentalFromAuctionResponse")
public class RemoveRentalFromAuctionResponse {

    @XmlElement(name = "RemoveRentalFromAuctionResult", required = true)
    protected RemoveRentalFromAuctionResponse2 removeRentalFromAuctionResult;

    /**
     * Gets the value of the removeRentalFromAuctionResult property.
     * 
     * @return
     *     possible object is
     *     {@link RemoveRentalFromAuctionResponse2 }
     *     
     */
    public RemoveRentalFromAuctionResponse2 getRemoveRentalFromAuctionResult() {
        return removeRentalFromAuctionResult;
    }

    /**
     * Sets the value of the removeRentalFromAuctionResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link RemoveRentalFromAuctionResponse2 }
     *     
     */
    public void setRemoveRentalFromAuctionResult(RemoveRentalFromAuctionResponse2 value) {
        this.removeRentalFromAuctionResult = value;
    }

}
