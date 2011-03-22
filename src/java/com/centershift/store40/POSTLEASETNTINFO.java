package com.centershift.store40;

import javax.xml.bind.annotation.*;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for POST_LEASE_TNT_INFO complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="POST_LEASE_TNT_INFO">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.centershift.com/STORE40/}BaseEntityOfCollectionPOST_LEASE_TNT_INFOColumnIndexes">
 *       &lt;sequence>
 *         &lt;element name="LEASE_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="SITE_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="ACCT_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="RENTAL_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="LEASE_DEF_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="LEASE_VERSION" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="WHO_CREATED" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CREATED" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "POST_LEASE_TNT_INFO", propOrder = {
        "leaseid",
        "siteid",
        "acctid",
        "rentalid",
        "leasedefid",
        "leaseversion",
        "whocreated",
        "created"
})
public class POSTLEASETNTINFO
        extends BaseEntityOfCollectionPOSTLEASETNTINFOColumnIndexes {

    @XmlElement(name = "LEASE_ID")
    protected long leaseid;
    @XmlElement(name = "SITE_ID", required = true, type = Long.class, nillable = true)
    protected Long siteid;
    @XmlElement(name = "ACCT_ID", required = true, type = Long.class, nillable = true)
    protected Long acctid;
    @XmlElement(name = "RENTAL_ID")
    protected long rentalid;
    @XmlElement(name = "LEASE_DEF_ID")
    protected long leasedefid;
    @XmlElement(name = "LEASE_VERSION")
    protected int leaseversion;
    @XmlElement(name = "WHO_CREATED")
    protected String whocreated;
    @XmlElement(name = "CREATED", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar created;

    /**
     * Gets the value of the leaseid property.
     */
    public long getLEASEID() {
        return leaseid;
    }

    /**
     * Sets the value of the leaseid property.
     */
    public void setLEASEID(long value) {
        this.leaseid = value;
    }

    /**
     * Gets the value of the siteid property.
     *
     * @return possible object is
     *         {@link Long }
     */
    public Long getSITEID() {
        return siteid;
    }

    /**
     * Sets the value of the siteid property.
     *
     * @param value allowed object is
     *              {@link Long }
     */
    public void setSITEID(Long value) {
        this.siteid = value;
    }

    /**
     * Gets the value of the acctid property.
     *
     * @return possible object is
     *         {@link Long }
     */
    public Long getACCTID() {
        return acctid;
    }

    /**
     * Sets the value of the acctid property.
     *
     * @param value allowed object is
     *              {@link Long }
     */
    public void setACCTID(Long value) {
        this.acctid = value;
    }

    /**
     * Gets the value of the rentalid property.
     */
    public long getRENTALID() {
        return rentalid;
    }

    /**
     * Sets the value of the rentalid property.
     */
    public void setRENTALID(long value) {
        this.rentalid = value;
    }

    /**
     * Gets the value of the leasedefid property.
     */
    public long getLEASEDEFID() {
        return leasedefid;
    }

    /**
     * Sets the value of the leasedefid property.
     */
    public void setLEASEDEFID(long value) {
        this.leasedefid = value;
    }

    /**
     * Gets the value of the leaseversion property.
     */
    public int getLEASEVERSION() {
        return leaseversion;
    }

    /**
     * Sets the value of the leaseversion property.
     */
    public void setLEASEVERSION(int value) {
        this.leaseversion = value;
    }

    /**
     * Gets the value of the whocreated property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getWHOCREATED() {
        return whocreated;
    }

    /**
     * Sets the value of the whocreated property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setWHOCREATED(String value) {
        this.whocreated = value;
    }

    /**
     * Gets the value of the created property.
     *
     * @return possible object is
     *         {@link XMLGregorianCalendar }
     */
    public XMLGregorianCalendar getCREATED() {
        return created;
    }

    /**
     * Sets the value of the created property.
     *
     * @param value allowed object is
     *              {@link XMLGregorianCalendar }
     */
    public void setCREATED(XMLGregorianCalendar value) {
        this.created = value;
    }

}
