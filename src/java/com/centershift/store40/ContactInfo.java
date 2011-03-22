package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ContactInfo complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="ContactInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AccountID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="RentalID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="ContactName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Address1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Address2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="City" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="State" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PostalCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Country" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ContactInfo", propOrder = {
        "accountID",
        "rentalID",
        "contactName",
        "address1",
        "address2",
        "city",
        "state",
        "postalCode",
        "country"
})
public class ContactInfo {

    @XmlElement(name = "AccountID")
    protected long accountID;
    @XmlElement(name = "RentalID")
    protected long rentalID;
    @XmlElement(name = "ContactName")
    protected String contactName;
    @XmlElement(name = "Address1")
    protected String address1;
    @XmlElement(name = "Address2")
    protected String address2;
    @XmlElement(name = "City")
    protected String city;
    @XmlElement(name = "State")
    protected String state;
    @XmlElement(name = "PostalCode")
    protected String postalCode;
    @XmlElement(name = "Country")
    protected String country;

    /**
     * Gets the value of the accountID property.
     */
    public long getAccountID() {
        return accountID;
    }

    /**
     * Sets the value of the accountID property.
     */
    public void setAccountID(long value) {
        this.accountID = value;
    }

    /**
     * Gets the value of the rentalID property.
     */
    public long getRentalID() {
        return rentalID;
    }

    /**
     * Sets the value of the rentalID property.
     */
    public void setRentalID(long value) {
        this.rentalID = value;
    }

    /**
     * Gets the value of the contactName property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getContactName() {
        return contactName;
    }

    /**
     * Sets the value of the contactName property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setContactName(String value) {
        this.contactName = value;
    }

    /**
     * Gets the value of the address1 property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getAddress1() {
        return address1;
    }

    /**
     * Sets the value of the address1 property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setAddress1(String value) {
        this.address1 = value;
    }

    /**
     * Gets the value of the address2 property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getAddress2() {
        return address2;
    }

    /**
     * Sets the value of the address2 property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setAddress2(String value) {
        this.address2 = value;
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

}
