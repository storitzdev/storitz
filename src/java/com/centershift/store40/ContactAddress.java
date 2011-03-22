package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ContactAddress complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="ContactAddress">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AddrId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="ContactId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="AddrType" type="{http://www.centershift.com/STORE40/}AddressType"/>
 *         &lt;element name="Addr1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Addr2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Addr3" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="City" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="State" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PostalCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Country" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Active" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ContactAddress", propOrder = {
        "addrId",
        "contactId",
        "addrType",
        "addr1",
        "addr2",
        "addr3",
        "city",
        "state",
        "postalCode",
        "country",
        "active"
})
public class ContactAddress {

    @XmlElement(name = "AddrId", required = true, type = Long.class, nillable = true)
    protected Long addrId;
    @XmlElement(name = "ContactId", required = true, type = Long.class, nillable = true)
    protected Long contactId;
    @XmlElement(name = "AddrType", required = true, nillable = true)
    protected AddressType addrType;
    @XmlElement(name = "Addr1")
    protected String addr1;
    @XmlElement(name = "Addr2")
    protected String addr2;
    @XmlElement(name = "Addr3")
    protected String addr3;
    @XmlElement(name = "City")
    protected String city;
    @XmlElement(name = "State")
    protected String state;
    @XmlElement(name = "PostalCode")
    protected String postalCode;
    @XmlElement(name = "Country")
    protected String country;
    @XmlElement(name = "Active", required = true, type = Boolean.class, nillable = true)
    protected Boolean active;

    /**
     * Gets the value of the addrId property.
     *
     * @return possible object is
     *         {@link Long }
     */
    public Long getAddrId() {
        return addrId;
    }

    /**
     * Sets the value of the addrId property.
     *
     * @param value allowed object is
     *              {@link Long }
     */
    public void setAddrId(Long value) {
        this.addrId = value;
    }

    /**
     * Gets the value of the contactId property.
     *
     * @return possible object is
     *         {@link Long }
     */
    public Long getContactId() {
        return contactId;
    }

    /**
     * Sets the value of the contactId property.
     *
     * @param value allowed object is
     *              {@link Long }
     */
    public void setContactId(Long value) {
        this.contactId = value;
    }

    /**
     * Gets the value of the addrType property.
     *
     * @return possible object is
     *         {@link AddressType }
     */
    public AddressType getAddrType() {
        return addrType;
    }

    /**
     * Sets the value of the addrType property.
     *
     * @param value allowed object is
     *              {@link AddressType }
     */
    public void setAddrType(AddressType value) {
        this.addrType = value;
    }

    /**
     * Gets the value of the addr1 property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getAddr1() {
        return addr1;
    }

    /**
     * Sets the value of the addr1 property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setAddr1(String value) {
        this.addr1 = value;
    }

    /**
     * Gets the value of the addr2 property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getAddr2() {
        return addr2;
    }

    /**
     * Sets the value of the addr2 property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setAddr2(String value) {
        this.addr2 = value;
    }

    /**
     * Gets the value of the addr3 property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getAddr3() {
        return addr3;
    }

    /**
     * Sets the value of the addr3 property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setAddr3(String value) {
        this.addr3 = value;
    }

    /**
     * Gets the value of the city property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getCity() {
        return city;
    }

    /**
     * Sets the value of the city property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setCity(String value) {
        this.city = value;
    }

    /**
     * Gets the value of the state property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getState() {
        return state;
    }

    /**
     * Sets the value of the state property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setState(String value) {
        this.state = value;
    }

    /**
     * Gets the value of the postalCode property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getPostalCode() {
        return postalCode;
    }

    /**
     * Sets the value of the postalCode property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setPostalCode(String value) {
        this.postalCode = value;
    }

    /**
     * Gets the value of the country property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getCountry() {
        return country;
    }

    /**
     * Sets the value of the country property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setCountry(String value) {
        this.country = value;
    }

    /**
     * Gets the value of the active property.
     *
     * @return possible object is
     *         {@link Boolean }
     */
    public Boolean isActive() {
        return active;
    }

    /**
     * Sets the value of the active property.
     *
     * @param value allowed object is
     *              {@link Boolean }
     */
    public void setActive(Boolean value) {
        this.active = value;
    }

}
