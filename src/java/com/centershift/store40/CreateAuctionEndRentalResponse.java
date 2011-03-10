
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
 *         &lt;element name="CreateAuctionEndRentalResult" type="{http://www.centershift.com/STORE40/}CreateAuctionEndRental_Response"/>
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
    "createAuctionEndRentalResult"
})
@XmlRootElement(name = "CreateAuctionEndRentalResponse")
public class CreateAuctionEndRentalResponse {

    @XmlElement(name = "CreateAuctionEndRentalResult", required = true)
    protected CreateAuctionEndRentalResponse2 createAuctionEndRentalResult;

    /**
     * Gets the value of the createAuctionEndRentalResult property.
     * 
     * @return
     *     possible object is
     *     {@link CreateAuctionEndRentalResponse2 }
     *     
     */
    public CreateAuctionEndRentalResponse2 getCreateAuctionEndRentalResult() {
        return createAuctionEndRentalResult;
    }

    /**
     * Sets the value of the createAuctionEndRentalResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link CreateAuctionEndRentalResponse2 }
     *     
     */
    public void setCreateAuctionEndRentalResult(CreateAuctionEndRentalResponse2 value) {
        this.createAuctionEndRentalResult = value;
    }

}
