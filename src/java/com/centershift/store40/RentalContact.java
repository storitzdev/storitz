package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RentalContact complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="RentalContact">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ContactId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="AddressId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="PhoneId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="GateCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PrimaryFlag" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RentalContact", propOrder = {
        "contactId",
        "addressId",
        "phoneId",
        "gateCode",
        "primaryFlag"
})
public class RentalContact {

    @XmlElement(name = "ContactId")
    protected long contactId;
    @XmlElement(name = "AddressId")
    protected long addressId;
    @XmlElement(name = "PhoneId")
    protected long phoneId;
    @XmlElement(name = "GateCode")
    protected String gateCode;
    @XmlElement(name = "PrimaryFlag", required = true, type = Boolean.class, nillable = true)
    protected Boolean primaryFlag;

    /**
     * Gets the value of the contactId property.
     */
    public long getContactId() {
        return contactId;
    }

    /**
     * Sets the value of the contactId property.
     */
    public void setContactId(long value) {
        this.contactId = value;
    }

    /**
     * Gets the value of the addressId property.
     */
    public long getAddressId() {
        return addressId;
    }

    /**
     * Sets the value of the addressId property.
     */
    public void setAddressId(long value) {
        this.addressId = value;
    }

    /**
     * Gets the value of the phoneId property.
     */
    public long getPhoneId() {
        return phoneId;
    }

    /**
     * Sets the value of the phoneId property.
     */
    public void setPhoneId(long value) {
        this.phoneId = value;
    }

    /**
     * Gets the value of the gateCode property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getGateCode() {
        return gateCode;
    }

    /**
     * Sets the value of the gateCode property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setGateCode(String value) {
        this.gateCode = value;
    }

    /**
     * Gets the value of the primaryFlag property.
     *
     * @return possible object is
     *         {@link Boolean }
     */
    public Boolean isPrimaryFlag() {
        return primaryFlag;
    }

    /**
     * Sets the value of the primaryFlag property.
     *
     * @param value allowed object is
     *              {@link Boolean }
     */
    public void setPrimaryFlag(Boolean value) {
        this.primaryFlag = value;
    }

}
