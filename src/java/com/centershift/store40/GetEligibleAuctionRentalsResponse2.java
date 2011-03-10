
package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GetEligibleAuctionRentals_Response complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetEligibleAuctionRentals_Response">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Details" type="{http://www.centershift.com/STORE40/}ArrayOfTRAN_AUCTION_RENTALS" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetEligibleAuctionRentals_Response", propOrder = {
    "details"
})
public class GetEligibleAuctionRentalsResponse2 {

    @XmlElement(name = "Details")
    protected ArrayOfTRANAUCTIONRENTALS details;

    /**
     * Gets the value of the details property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfTRANAUCTIONRENTALS }
     *     
     */
    public ArrayOfTRANAUCTIONRENTALS getDetails() {
        return details;
    }

    /**
     * Sets the value of the details property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfTRANAUCTIONRENTALS }
     *     
     */
    public void setDetails(ArrayOfTRANAUCTIONRENTALS value) {
        this.details = value;
    }

}
