
package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PrimaryContactRentals complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PrimaryContactRentals">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ContactID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="Rentals" type="{http://www.centershift.com/STORE40/}ArrayOfAccessableRentals" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PrimaryContactRentals", propOrder = {
    "contactID",
    "rentals"
})
public class PrimaryContactRentals {

    @XmlElement(name = "ContactID")
    protected long contactID;
    @XmlElement(name = "Rentals")
    protected ArrayOfAccessableRentals rentals;

    /**
     * Gets the value of the contactID property.
     * 
     */
    public long getContactID() {
        return contactID;
    }

    /**
     * Sets the value of the contactID property.
     * 
     */
    public void setContactID(long value) {
        this.contactID = value;
    }

    /**
     * Gets the value of the rentals property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfAccessableRentals }
     *     
     */
    public ArrayOfAccessableRentals getRentals() {
        return rentals;
    }

    /**
     * Sets the value of the rentals property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfAccessableRentals }
     *     
     */
    public void setRentals(ArrayOfAccessableRentals value) {
        this.rentals = value;
    }

}
