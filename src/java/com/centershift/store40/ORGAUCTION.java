package com.centershift.store40;

import javax.xml.bind.annotation.*;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for ORG_AUCTION complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="ORG_AUCTION">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.centershift.com/STORE40/}BaseEntityOfCollectionORG_AUCTIONColumnIndexes">
 *       &lt;sequence>
 *         &lt;element name="SITE_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="AUCTION_DATE" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="AUCTIONEER_NAME" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="NOTES" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="STATUS" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="CREATED_BY" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="UPDATED_BY" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="AUCTION_TIME" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ORG_AUCTION_OBJS" type="{http://www.centershift.com/STORE40/}ArrayOfORG_AUCTION_OBJS" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ORG_AUCTION", propOrder = {
        "siteid",
        "auctiondate",
        "auctioneername",
        "notes",
        "status",
        "createdby",
        "updatedby",
        "auctiontime",
        "orgauctionobjs"
})
public class ORGAUCTION
        extends BaseEntityOfCollectionORGAUCTIONColumnIndexes {

    @XmlElement(name = "SITE_ID", required = true, type = Long.class, nillable = true)
    protected Long siteid;
    @XmlElement(name = "AUCTION_DATE", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar auctiondate;
    @XmlElement(name = "AUCTIONEER_NAME")
    protected String auctioneername;
    @XmlElement(name = "NOTES")
    protected String notes;
    @XmlElement(name = "STATUS")
    protected int status;
    @XmlElement(name = "CREATED_BY")
    protected long createdby;
    @XmlElement(name = "UPDATED_BY")
    protected long updatedby;
    @XmlElement(name = "AUCTION_TIME")
    protected String auctiontime;
    @XmlElement(name = "ORG_AUCTION_OBJS")
    protected ArrayOfORGAUCTIONOBJS orgauctionobjs;

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
     * Gets the value of the createdby property.
     */
    public long getCREATEDBY() {
        return createdby;
    }

    /**
     * Sets the value of the createdby property.
     */
    public void setCREATEDBY(long value) {
        this.createdby = value;
    }

    /**
     * Gets the value of the updatedby property.
     */
    public long getUPDATEDBY() {
        return updatedby;
    }

    /**
     * Sets the value of the updatedby property.
     */
    public void setUPDATEDBY(long value) {
        this.updatedby = value;
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
     * Gets the value of the orgauctionobjs property.
     *
     * @return possible object is
     *         {@link ArrayOfORGAUCTIONOBJS }
     */
    public ArrayOfORGAUCTIONOBJS getORGAUCTIONOBJS() {
        return orgauctionobjs;
    }

    /**
     * Sets the value of the orgauctionobjs property.
     *
     * @param value allowed object is
     *              {@link ArrayOfORGAUCTIONOBJS }
     */
    public void setORGAUCTIONOBJS(ArrayOfORGAUCTIONOBJS value) {
        this.orgauctionobjs = value;
    }

}
