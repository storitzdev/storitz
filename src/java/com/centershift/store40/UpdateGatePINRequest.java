
package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for UpdateGatePIN_Request complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="UpdateGatePIN_Request">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ContactID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="RentalID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="PIN" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UpdateGatePIN_Request", propOrder = {
    "contactID",
    "rentalID",
    "pin"
})
public class UpdateGatePINRequest {

    @XmlElement(name = "ContactID")
    protected long contactID;
    @XmlElement(name = "RentalID")
    protected long rentalID;
    @XmlElement(name = "PIN")
    protected String pin;

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
     * Gets the value of the rentalID property.
     * 
     */
    public long getRentalID() {
        return rentalID;
    }

    /**
     * Sets the value of the rentalID property.
     * 
     */
    public void setRentalID(long value) {
        this.rentalID = value;
    }

    /**
     * Gets the value of the pin property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPIN() {
        return pin;
    }

    /**
     * Sets the value of the pin property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPIN(String value) {
        this.pin = value;
    }

}
