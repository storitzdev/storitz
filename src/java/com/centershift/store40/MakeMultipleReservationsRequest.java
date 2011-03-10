
package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for MakeMultipleReservations_Request complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MakeMultipleReservations_Request">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Reservations" type="{http://www.centershift.com/STORE40/}ArrayOfMakeReservation_Request" minOccurs="0"/>
 *         &lt;element name="OrgID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MakeMultipleReservations_Request", propOrder = {
    "reservations",
    "orgID"
})
public class MakeMultipleReservationsRequest {

    @XmlElement(name = "Reservations")
    protected ArrayOfMakeReservationRequest reservations;
    @XmlElement(name = "OrgID")
    protected long orgID;

    /**
     * Gets the value of the reservations property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfMakeReservationRequest }
     *     
     */
    public ArrayOfMakeReservationRequest getReservations() {
        return reservations;
    }

    /**
     * Sets the value of the reservations property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfMakeReservationRequest }
     *     
     */
    public void setReservations(ArrayOfMakeReservationRequest value) {
        this.reservations = value;
    }

    /**
     * Gets the value of the orgID property.
     * 
     */
    public long getOrgID() {
        return orgID;
    }

    /**
     * Sets the value of the orgID property.
     * 
     */
    public void setOrgID(long value) {
        this.orgID = value;
    }

}
