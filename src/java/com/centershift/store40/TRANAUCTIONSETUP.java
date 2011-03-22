package com.centershift.store40;

import javax.xml.bind.annotation.*;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for TRAN_AUCTION_SETUP complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="TRAN_AUCTION_SETUP">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.centershift.com/STORE40/}BaseEntityOfCollectionTRAN_AUCTION_SETUPColumnIndexes">
 *       &lt;sequence>
 *         &lt;element name="AUCTION_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="SITE_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="AUCTION_DATE" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="FORMAT_DATE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AUCTIONEER_NAME" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="NOTES" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="STATUS" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="AUCTION_TIME" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="STATUS_VALUE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TRAN_AUCTION_SETUP", propOrder = {
        "auctionid",
        "siteid",
        "auctiondate",
        "formatdate",
        "auctioneername",
        "notes",
        "status",
        "auctiontime",
        "statusvalue"
})
public class TRANAUCTIONSETUP
        extends BaseEntityOfCollectionTRANAUCTIONSETUPColumnIndexes {

    @XmlElement(name = "AUCTION_ID")
    protected long auctionid;
    @XmlElement(name = "SITE_ID", required = true, type = Long.class, nillable = true)
    protected Long siteid;
    @XmlElement(name = "AUCTION_DATE", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar auctiondate;
    @XmlElement(name = "FORMAT_DATE")
    protected String formatdate;
    @XmlElement(name = "AUCTIONEER_NAME")
    protected String auctioneername;
    @XmlElement(name = "NOTES")
    protected String notes;
    @XmlElement(name = "STATUS")
    protected int status;
    @XmlElement(name = "AUCTION_TIME")
    protected String auctiontime;
    @XmlElement(name = "STATUS_VALUE")
    protected String statusvalue;

    /**
     * Gets the value of the auctionid property.
     */
    public long getAUCTIONID() {
        return auctionid;
    }

    /**
     * Sets the value of the auctionid property.
     */
    public void setAUCTIONID(long value) {
        this.auctionid = value;
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
     * Gets the value of the auctiondate property.
     *
     * @return possible object is
     *         {@link XMLGregorianCalendar }
     */
    public XMLGregorianCalendar getAUCTIONDATE() {
        return auctiondate;
    }

    /**
     * Sets the value of the auctiondate property.
     *
     * @param value allowed object is
     *              {@link XMLGregorianCalendar }
     */
    public void setAUCTIONDATE(XMLGregorianCalendar value) {
        this.auctiondate = value;
    }

    /**
     * Gets the value of the formatdate property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getFORMATDATE() {
        return formatdate;
    }

    /**
     * Sets the value of the formatdate property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setFORMATDATE(String value) {
        this.formatdate = value;
    }

    /**
     * Gets the value of the auctioneername property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getAUCTIONEERNAME() {
        return auctioneername;
    }

    /**
     * Sets the value of the auctioneername property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setAUCTIONEERNAME(String value) {
        this.auctioneername = value;
    }

    /**
     * Gets the value of the notes property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getNOTES() {
        return notes;
    }

    /**
     * Sets the value of the notes property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setNOTES(String value) {
        this.notes = value;
    }

    /**
     * Gets the value of the status property.
     */
    public int getSTATUS() {
        return status;
    }

    /**
     * Sets the value of the status property.
     */
    public void setSTATUS(int value) {
        this.status = value;
    }

    /**
     * Gets the value of the auctiontime property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getAUCTIONTIME() {
        return auctiontime;
    }

    /**
     * Sets the value of the auctiontime property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setAUCTIONTIME(String value) {
        this.auctiontime = value;
    }

    /**
     * Gets the value of the statusvalue property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getSTATUSVALUE() {
        return statusvalue;
    }

    /**
     * Sets the value of the statusvalue property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setSTATUSVALUE(String value) {
        this.statusvalue = value;
    }

}
