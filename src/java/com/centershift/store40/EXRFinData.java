package com.centershift.store40;

import javax.xml.bind.annotation.*;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for EXRFinData complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="EXRFinData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SiteID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="SiteName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SiteNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TransactionDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="Entry" type="{http://www.centershift.com/STORE40/}ArrayOfEntryItem" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EXRFinData", propOrder = {
        "siteID",
        "siteName",
        "siteNumber",
        "transactionDate",
        "entry"
})
public class EXRFinData {

    @XmlElement(name = "SiteID")
    protected long siteID;
    @XmlElement(name = "SiteName")
    protected String siteName;
    @XmlElement(name = "SiteNumber")
    protected String siteNumber;
    @XmlElement(name = "TransactionDate", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar transactionDate;
    @XmlElement(name = "Entry")
    protected ArrayOfEntryItem entry;

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
     * Gets the value of the siteName property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getSiteName() {
        return siteName;
    }

    /**
     * Sets the value of the siteName property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setSiteName(String value) {
        this.siteName = value;
    }

    /**
     * Gets the value of the siteNumber property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getSiteNumber() {
        return siteNumber;
    }

    /**
     * Sets the value of the siteNumber property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setSiteNumber(String value) {
        this.siteNumber = value;
    }

    /**
     * Gets the value of the transactionDate property.
     *
     * @return possible object is
     *         {@link XMLGregorianCalendar }
     */
    public XMLGregorianCalendar getTransactionDate() {
        return transactionDate;
    }

    /**
     * Sets the value of the transactionDate property.
     *
     * @param value allowed object is
     *              {@link XMLGregorianCalendar }
     */
    public void setTransactionDate(XMLGregorianCalendar value) {
        this.transactionDate = value;
    }

    /**
     * Gets the value of the entry property.
     *
     * @return possible object is
     *         {@link ArrayOfEntryItem }
     */
    public ArrayOfEntryItem getEntry() {
        return entry;
    }

    /**
     * Sets the value of the entry property.
     *
     * @param value allowed object is
     *              {@link ArrayOfEntryItem }
     */
    public void setEntry(ArrayOfEntryItem value) {
        this.entry = value;
    }

}
