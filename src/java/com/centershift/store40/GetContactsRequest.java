package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GetContacts_Request complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="GetContacts_Request">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SiteID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="AcctID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="ContactId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetContacts_Request", propOrder = {
        "siteID",
        "acctID",
        "contactId"
})
public class GetContactsRequest {

    @XmlElement(name = "SiteID")
    protected long siteID;
    @XmlElement(name = "AcctID", required = true, type = Long.class, nillable = true)
    protected Long acctID;
    @XmlElement(name = "ContactId", required = true, type = Long.class, nillable = true)
    protected Long contactId;

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
     * Gets the value of the acctID property.
     *
     * @return possible object is
     *         {@link Long }
     */
    public Long getAcctID() {
        return acctID;
    }

    /**
     * Sets the value of the acctID property.
     *
     * @param value allowed object is
     *              {@link Long }
     */
    public void setAcctID(Long value) {
        this.acctID = value;
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

}
