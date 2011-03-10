
package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RemoveRentalFromAuction_Response complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RemoveRentalFromAuction_Response">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="RentalsSucceeded" type="{http://www.centershift.com/STORE40/}ArrayOfLong4" minOccurs="0"/>
 *         &lt;element name="RentalsFailed" type="{http://www.centershift.com/STORE40/}ArrayOfLong5" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RemoveRentalFromAuction_Response", propOrder = {
    "rentalsSucceeded",
    "rentalsFailed"
})
public class RemoveRentalFromAuctionResponse2 {

    @XmlElement(name = "RentalsSucceeded")
    protected ArrayOfLong4 rentalsSucceeded;
    @XmlElement(name = "RentalsFailed")
    protected ArrayOfLong5 rentalsFailed;

    /**
     * Gets the value of the rentalsSucceeded property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfLong4 }
     *     
     */
    public ArrayOfLong4 getRentalsSucceeded() {
        return rentalsSucceeded;
    }

    /**
     * Sets the value of the rentalsSucceeded property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfLong4 }
     *     
     */
    public void setRentalsSucceeded(ArrayOfLong4 value) {
        this.rentalsSucceeded = value;
    }

    /**
     * Gets the value of the rentalsFailed property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfLong5 }
     *     
     */
    public ArrayOfLong5 getRentalsFailed() {
        return rentalsFailed;
    }

    /**
     * Sets the value of the rentalsFailed property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfLong5 }
     *     
     */
    public void setRentalsFailed(ArrayOfLong5 value) {
        this.rentalsFailed = value;
    }

}
