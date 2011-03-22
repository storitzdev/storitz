package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ReassignRental_Request complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="ReassignRental_Request">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SiteID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="OldAccountID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="OldRentalID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="OldContactID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="NewAccountID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="NewContactID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="NewAddressID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="NewPhoneID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="DeactiveOldEcommContact" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ReassignRental_Request", propOrder = {
        "siteID",
        "oldAccountID",
        "oldRentalID",
        "oldContactID",
        "newAccountID",
        "newContactID",
        "newAddressID",
        "newPhoneID",
        "deactiveOldEcommContact"
})
public class ReassignRentalRequest {

    @XmlElement(name = "SiteID")
    protected long siteID;
    @XmlElement(name = "OldAccountID")
    protected long oldAccountID;
    @XmlElement(name = "OldRentalID")
    protected long oldRentalID;
    @XmlElement(name = "OldContactID")
    protected long oldContactID;
    @XmlElement(name = "NewAccountID")
    protected long newAccountID;
    @XmlElement(name = "NewContactID")
    protected long newContactID;
    @XmlElement(name = "NewAddressID")
    protected long newAddressID;
    @XmlElement(name = "NewPhoneID")
    protected long newPhoneID;
    @XmlElement(name = "DeactiveOldEcommContact", required = true, type = Boolean.class, nillable = true)
    protected Boolean deactiveOldEcommContact;

    /**
     * Gets the value of the siteID property.
     */
    public long getSiteID() {
        return siteID;
    }

    /**
     * Sets the value of the siteID property.
     */
    public void setSiteID(long value) {
        this.siteID = value;
    }

    /**
     * Gets the value of the oldAccountID property.
     */
    public long getOldAccountID() {
        return oldAccountID;
    }

    /**
     * Sets the value of the oldAccountID property.
     */
    public void setOldAccountID(long value) {
        this.oldAccountID = value;
    }

    /**
     * Gets the value of the oldRentalID property.
     */
    public long getOldRentalID() {
        return oldRentalID;
    }

    /**
     * Sets the value of the oldRentalID property.
     */
    public void setOldRentalID(long value) {
        this.oldRentalID = value;
    }

    /**
     * Gets the value of the oldContactID property.
     */
    public long getOldContactID() {
        return oldContactID;
    }

    /**
     * Sets the value of the oldContactID property.
     */
    public void setOldContactID(long value) {
        this.oldContactID = value;
    }

    /**
     * Gets the value of the newAccountID property.
     */
    public long getNewAccountID() {
        return newAccountID;
    }

    /**
     * Sets the value of the newAccountID property.
     */
    public void setNewAccountID(long value) {
        this.newAccountID = value;
    }

    /**
     * Gets the value of the newContactID property.
     */
    public long getNewContactID() {
        return newContactID;
    }

    /**
     * Sets the value of the newContactID property.
     */
    public void setNewContactID(long value) {
        this.newContactID = value;
    }

    /**
     * Gets the value of the newAddressID property.
     */
    public long getNewAddressID() {
        return newAddressID;
    }

    /**
     * Sets the value of the newAddressID property.
     */
    public void setNewAddressID(long value) {
        this.newAddressID = value;
    }

    /**
     * Gets the value of the newPhoneID property.
     */
    public long getNewPhoneID() {
        return newPhoneID;
    }

    /**
     * Sets the value of the newPhoneID property.
     */
    public void setNewPhoneID(long value) {
        this.newPhoneID = value;
    }

    /**
     * Gets the value of the deactiveOldEcommContact property.
     *
     * @return possible object is
     *         {@link Boolean }
     */
    public Boolean isDeactiveOldEcommContact() {
        return deactiveOldEcommContact;
    }

    /**
     * Sets the value of the deactiveOldEcommContact property.
     *
     * @param value allowed object is
     *              {@link Boolean }
     */
    public void setDeactiveOldEcommContact(Boolean value) {
        this.deactiveOldEcommContact = value;
    }

}
