package com.centershift.store40;

import javax.xml.bind.annotation.*;
import javax.xml.datatype.XMLGregorianCalendar;
import java.math.BigDecimal;


/**
 * <p>Java class for TRAN_QUOTE_PCD complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="TRAN_QUOTE_PCD">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.centershift.com/STORE40/}BaseEntityOfCollectionTRAN_QUOTE_PCDColumnIndexes">
 *       &lt;sequence>
 *         &lt;element name="QUOTE_PCD_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="QUOTE_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="PCD_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="ACTIVE" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="CREATED" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="UPDATED" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="CREATED_BY" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="UPDATED_BY" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="DISC_AMT" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TRAN_QUOTE_PCD", propOrder = {
        "quotepcdid",
        "quoteid",
        "pcdid",
        "active",
        "created",
        "updated",
        "createdby",
        "updatedby",
        "discamt"
})
public class TRANQUOTEPCD
        extends BaseEntityOfCollectionTRANQUOTEPCDColumnIndexes {

    @XmlElement(name = "QUOTE_PCD_ID")
    protected long quotepcdid;
    @XmlElement(name = "QUOTE_ID")
    protected long quoteid;
    @XmlElement(name = "PCD_ID")
    protected long pcdid;
    @XmlElement(name = "ACTIVE")
    protected boolean active;
    @XmlElement(name = "CREATED", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar created;
    @XmlElement(name = "UPDATED", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar updated;
    @XmlElement(name = "CREATED_BY")
    protected long createdby;
    @XmlElement(name = "UPDATED_BY")
    protected long updatedby;
    @XmlElement(name = "DISC_AMT", required = true)
    protected BigDecimal discamt;

    /**
     * Gets the value of the quotepcdid property.
     */
    public long getQUOTEPCDID() {
        return quotepcdid;
    }

    /**
     * Sets the value of the quotepcdid property.
     */
    public void setQUOTEPCDID(long value) {
        this.quotepcdid = value;
    }

    /**
     * Gets the value of the quoteid property.
     */
    public long getQUOTEID() {
        return quoteid;
    }

    /**
     * Sets the value of the quoteid property.
     */
    public void setQUOTEID(long value) {
        this.quoteid = value;
    }

    /**
     * Gets the value of the pcdid property.
     */
    public long getPCDID() {
        return pcdid;
    }

    /**
     * Sets the value of the pcdid property.
     */
    public void setPCDID(long value) {
        this.pcdid = value;
    }

    /**
     * Gets the value of the active property.
     */
    public boolean isACTIVE() {
        return active;
    }

    /**
     * Sets the value of the active property.
     */
    public void setACTIVE(boolean value) {
        this.active = value;
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

    /**
     * Gets the value of the updated property.
     *
     * @return possible object is
     *         {@link XMLGregorianCalendar }
     */
    public XMLGregorianCalendar getUPDATED() {
        return updated;
    }

    /**
     * Sets the value of the updated property.
     *
     * @param value allowed object is
     *              {@link XMLGregorianCalendar }
     */
    public void setUPDATED(XMLGregorianCalendar value) {
        this.updated = value;
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
     * Gets the value of the discamt property.
     *
     * @return possible object is
     *         {@link BigDecimal }
     */
    public BigDecimal getDISCAMT() {
        return discamt;
    }

    /**
     * Sets the value of the discamt property.
     *
     * @param value allowed object is
     *              {@link BigDecimal }
     */
    public void setDISCAMT(BigDecimal value) {
        this.discamt = value;
    }

}
