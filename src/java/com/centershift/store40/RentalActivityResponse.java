
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
 *         &lt;element name="RentalActivityResult" type="{http://www.centershift.com/STORE40/}RentalActivity_Response"/>
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
    "rentalActivityResult"
})
@XmlRootElement(name = "RentalActivityResponse")
public class RentalActivityResponse {

    @XmlElement(name = "RentalActivityResult", required = true)
    protected RentalActivityResponse2 rentalActivityResult;

    /**
     * Gets the value of the rentalActivityResult property.
     * 
     * @return
     *     possible object is
     *     {@link RentalActivityResponse2 }
     *     
     */
    public RentalActivityResponse2 getRentalActivityResult() {
        return rentalActivityResult;
    }

    /**
     * Sets the value of the rentalActivityResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link RentalActivityResponse2 }
     *     
     */
    public void setRentalActivityResult(RentalActivityResponse2 value) {
        this.rentalActivityResult = value;
    }

}
