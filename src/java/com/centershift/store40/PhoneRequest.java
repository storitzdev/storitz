
package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Phone_Request complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Phone_Request">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="PhoneId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="ContactId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="PhoneType" type="{http://www.centershift.com/STORE40/}PhoneType"/>
 *         &lt;element name="Phone" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Active" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Phone_Request", propOrder = {
    "phoneId",
    "contactId",
    "phoneType",
    "phone",
    "active"
})
public class PhoneRequest {

    @XmlElement(name = "PhoneId", required = true, type = Long.class, nillable = true)
    protected Long phoneId;
    @XmlElement(name = "ContactId", required = true, type = Long.class, nillable = true)
    protected Long contactId;
    @XmlElement(name = "PhoneType", required = true, nillable = true)
    protected PhoneType phoneType;
    @XmlElement(name = "Phone")
    protected String phone;
    @XmlElement(name = "Active", required = true, type = Boolean.class, nillable = true)
    protected Boolean active;

    /**
     * Gets the value of the phoneId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getPhoneId() {
        return phoneId;
    }

    /**
     * Sets the value of the phoneId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setPhoneId(Long value) {
        this.phoneId = value;
    }

    /**
     * Gets the value of the contactId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getContactId() {
        return contactId;
    }

    /**
     * Sets the value of the contactId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setContactId(Long value) {
        this.contactId = value;
    }

    /**
     * Gets the value of the phoneType property.
     * 
     * @return
     *     possible object is
     *     {@link PhoneType }
     *     
     */
    public PhoneType getPhoneType() {
        return phoneType;
    }

    /**
     * Sets the value of the phoneType property.
     * 
     * @param value
     *     allowed object is
     *     {@link PhoneType }
     *     
     */
    public void setPhoneType(PhoneType value) {
        this.phoneType = value;
    }

    /**
     * Gets the value of the phone property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Sets the value of the phone property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPhone(String value) {
        this.phone = value;
    }

    /**
     * Gets the value of the active property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isActive() {
        return active;
    }

    /**
     * Sets the value of the active property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setActive(Boolean value) {
        this.active = value;
    }

}
