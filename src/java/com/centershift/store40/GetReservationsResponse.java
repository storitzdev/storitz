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
 *         &lt;element name="GetReservationsResult" type="{http://www.centershift.com/STORE40/}GetReservations_Response"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "getReservationsResult"
})
@XmlRootElement(name = "GetReservationsResponse")
public class GetReservationsResponse {

    @XmlElement(name = "GetReservationsResult", required = true)
    protected GetReservationsResponse2 getReservationsResult;

    /**
     * Gets the value of the getReservationsResult property.
     *
     * @return possible object is
     *         {@link GetReservationsResponse2 }
     */
    public GetReservationsResponse2 getGetReservationsResult() {
        return getReservationsResult;
    }

    /**
     * Sets the value of the getReservationsResult property.
     *
     * @param value allowed object is
     *              {@link GetReservationsResponse2 }
     */
    public void setGetReservationsResult(GetReservationsResponse2 value) {
        this.getReservationsResult = value;
    }

}
