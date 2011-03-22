package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for MakeMultipleReservations_Response complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="MakeMultipleReservations_Response">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Succeeded" type="{http://www.centershift.com/STORE40/}ArrayOfMakeReservation_Response" minOccurs="0"/>
 *         &lt;element name="Failed" type="{http://www.centershift.com/STORE40/}ArrayOfFailedReservation" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MakeMultipleReservations_Response", propOrder = {
        "succeeded",
        "failed"
})
public class MakeMultipleReservationsResponse2 {

    @XmlElement(name = "Succeeded")
    protected ArrayOfMakeReservationResponse succeeded;
    @XmlElement(name = "Failed")
    protected ArrayOfFailedReservation failed;

    /**
     * Gets the value of the succeeded property.
     *
     * @return possible object is
     *         {@link ArrayOfMakeReservationResponse }
     */
    public ArrayOfMakeReservationResponse getSucceeded() {
        return succeeded;
    }

    /**
     * Sets the value of the succeeded property.
     *
     * @param value allowed object is
     *              {@link ArrayOfMakeReservationResponse }
     */
    public void setSucceeded(ArrayOfMakeReservationResponse value) {
        this.succeeded = value;
    }

    /**
     * Gets the value of the failed property.
     *
     * @return possible object is
     *         {@link ArrayOfFailedReservation }
     */
    public ArrayOfFailedReservation getFailed() {
        return failed;
    }

    /**
     * Sets the value of the failed property.
     *
     * @param value allowed object is
     *              {@link ArrayOfFailedReservation }
     */
    public void setFailed(ArrayOfFailedReservation value) {
        this.failed = value;
    }

}
