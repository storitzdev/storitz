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
 *         &lt;element name="MakeReservationResult" type="{http://www.centershift.com/STORE40/}MakeReservation_Response"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "makeReservationResult"
})
@XmlRootElement(name = "MakeReservationResponse")
public class MakeReservationResponse2 {

    @XmlElement(name = "MakeReservationResult", required = true)
    protected MakeReservationResponse makeReservationResult;

    /**
     * Gets the value of the makeReservationResult property.
     *
     * @return possible object is
     *         {@link MakeReservationResponse }
     */
    public MakeReservationResponse getMakeReservationResult() {
        return makeReservationResult;
    }

    /**
     * Sets the value of the makeReservationResult property.
     *
     * @param value allowed object is
     *              {@link MakeReservationResponse }
     */
    public void setMakeReservationResult(MakeReservationResponse value) {
        this.makeReservationResult = value;
    }

}
