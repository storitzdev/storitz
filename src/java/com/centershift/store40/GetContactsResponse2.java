
package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GetContacts_Response complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetContacts_Response">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Details" type="{http://www.centershift.com/STORE40/}ArrayOfACT_CONTACTS" minOccurs="0"/>
 *         &lt;element name="PrimaryContactRentals" type="{http://www.centershift.com/STORE40/}ArrayOfPrimaryContactRentals" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetContacts_Response", propOrder = {
    "details",
    "primaryContactRentals"
})
public class GetContactsResponse2 {

    @XmlElement(name = "Details")
    protected ArrayOfACTCONTACTS details;
    @XmlElement(name = "PrimaryContactRentals")
    protected ArrayOfPrimaryContactRentals primaryContactRentals;

    /**
     * Gets the value of the details property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfACTCONTACTS }
     *     
     */
    public ArrayOfACTCONTACTS getDetails() {
        return details;
    }

    /**
     * Sets the value of the details property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfACTCONTACTS }
     *     
     */
    public void setDetails(ArrayOfACTCONTACTS value) {
        this.details = value;
    }

    /**
     * Gets the value of the primaryContactRentals property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfPrimaryContactRentals }
     *     
     */
    public ArrayOfPrimaryContactRentals getPrimaryContactRentals() {
        return primaryContactRentals;
    }

    /**
     * Sets the value of the primaryContactRentals property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfPrimaryContactRentals }
     *     
     */
    public void setPrimaryContactRentals(ArrayOfPrimaryContactRentals value) {
        this.primaryContactRentals = value;
    }

}
