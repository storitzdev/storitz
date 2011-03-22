package com.centershift.store40;

import javax.xml.bind.annotation.*;


/**
 * <p>Java class for anonymous complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CancelReservationResult" type="{http://www.centershift.com/STORE40/}CancelReservation_Response"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "cancelReservationResult"
})
@XmlRootElement(name = "CancelReservationResponse")
public class CancelReservationResponse {

    @XmlElement(name = "CancelReservationResult", required = true)
    protected CancelReservationResponse2 cancelReservationResult;

    /**
     * Gets the value of the cancelReservationResult property.
     *
     * @return possible object is
     *         {@link CancelReservationResponse2 }
     */
    public CancelReservationResponse2 getCancelReservationResult() {
        return cancelReservationResult;
    }

    /**
     * Sets the value of the cancelReservationResult property.
     *
     * @param value allowed object is
     *              {@link CancelReservationResponse2 }
     */
    public void setCancelReservationResult(CancelReservationResponse2 value) {
        this.cancelReservationResult = value;
    }

}
