package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for structCreateAccount complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="structCreateAccount">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AccountID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="ContactID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="Addresses" type="{http://www.centershift.com/STORE40/}ArrayOfACCT_CONTACT_ADDRESSES" minOccurs="0"/>
 *         &lt;element name="Phones" type="{http://www.centershift.com/STORE40/}ArrayOfACCT_CONTACT_PHONES" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "structCreateAccount", propOrder = {
        "accountID",
        "contactID",
        "addresses",
        "phones"
})
public class StructCreateAccount {

    @XmlElement(name = "AccountID")
    protected long accountID;
    @XmlElement(name = "ContactID")
    protected long contactID;
    @XmlElement(name = "Addresses")
    protected ArrayOfACCTCONTACTADDRESSES addresses;
    @XmlElement(name = "Phones")
    protected ArrayOfACCTCONTACTPHONES phones;

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
     * Gets the value of the contactID property.
     */
    public long getContactID() {
        return contactID;
    }

    /**
     * Sets the value of the contactID property.
     */
    public void setContactID(long value) {
        this.contactID = value;
    }

    /**
     * Gets the value of the addresses property.
     *
     * @return possible object is
     *         {@link ArrayOfACCTCONTACTADDRESSES }
     */
    public ArrayOfACCTCONTACTADDRESSES getAddresses() {
        return addresses;
    }

    /**
     * Sets the value of the addresses property.
     *
     * @param value allowed object is
     *              {@link ArrayOfACCTCONTACTADDRESSES }
     */
    public void setAddresses(ArrayOfACCTCONTACTADDRESSES value) {
        this.addresses = value;
    }

    /**
     * Gets the value of the phones property.
     *
     * @return possible object is
     *         {@link ArrayOfACCTCONTACTPHONES }
     */
    public ArrayOfACCTCONTACTPHONES getPhones() {
        return phones;
    }

    /**
     * Sets the value of the phones property.
     *
     * @param value allowed object is
     *              {@link ArrayOfACCTCONTACTPHONES }
     */
    public void setPhones(ArrayOfACCTCONTACTPHONES value) {
        this.phones = value;
    }

}
