
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
 *         &lt;element name="ReassignRentalResult" type="{http://www.centershift.com/STORE40/}ReassignRental_Response"/>
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
    "reassignRentalResult"
})
@XmlRootElement(name = "ReassignRentalResponse")
public class ReassignRentalResponse {

    @XmlElement(name = "ReassignRentalResult", required = true)
    protected ReassignRentalResponse2 reassignRentalResult;

    /**
     * Gets the value of the reassignRentalResult property.
     * 
     * @return
     *     possible object is
     *     {@link ReassignRentalResponse2 }
     *     
     */
    public ReassignRentalResponse2 getReassignRentalResult() {
        return reassignRentalResult;
    }

    /**
     * Sets the value of the reassignRentalResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReassignRentalResponse2 }
     *     
     */
    public void setReassignRentalResult(ReassignRentalResponse2 value) {
        this.reassignRentalResult = value;
    }

}
