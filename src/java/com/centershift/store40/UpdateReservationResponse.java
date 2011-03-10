
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
 *         &lt;element name="UpdateReservationResult" type="{http://www.centershift.com/STORE40/}MakeReservation_Response"/>
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
    "updateReservationResult"
})
@XmlRootElement(name = "UpdateReservationResponse")
public class UpdateReservationResponse {

    @XmlElement(name = "UpdateReservationResult", required = true)
    protected MakeReservationResponse updateReservationResult;

    /**
     * Gets the value of the updateReservationResult property.
     * 
     * @return
     *     possible object is
     *     {@link MakeReservationResponse }
     *     
     */
    public MakeReservationResponse getUpdateReservationResult() {
        return updateReservationResult;
    }

    /**
     * Sets the value of the updateReservationResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link MakeReservationResponse }
     *     
     */
    public void setUpdateReservationResult(MakeReservationResponse value) {
        this.updateReservationResult = value;
    }

}
