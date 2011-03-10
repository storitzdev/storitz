
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
 *         &lt;element name="MakeMultipleReservationsResult" type="{http://www.centershift.com/STORE40/}MakeMultipleReservations_Response"/>
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
    "makeMultipleReservationsResult"
})
@XmlRootElement(name = "MakeMultipleReservationsResponse")
public class MakeMultipleReservationsResponse {

    @XmlElement(name = "MakeMultipleReservationsResult", required = true)
    protected MakeMultipleReservationsResponse2 makeMultipleReservationsResult;

    /**
     * Gets the value of the makeMultipleReservationsResult property.
     * 
     * @return
     *     possible object is
     *     {@link MakeMultipleReservationsResponse2 }
     *     
     */
    public MakeMultipleReservationsResponse2 getMakeMultipleReservationsResult() {
        return makeMultipleReservationsResult;
    }

    /**
     * Sets the value of the makeMultipleReservationsResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link MakeMultipleReservationsResponse2 }
     *     
     */
    public void setMakeMultipleReservationsResult(MakeMultipleReservationsResponse2 value) {
        this.makeMultipleReservationsResult = value;
    }

}
