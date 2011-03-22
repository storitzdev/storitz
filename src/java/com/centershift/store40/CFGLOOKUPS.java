package com.centershift.store40;

import javax.xml.bind.annotation.*;
import javax.xml.datatype.XMLGregorianCalendar;
import java.math.BigDecimal;


/**
 * <p>Java class for CFG_LOOKUPS complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="CFG_LOOKUPS">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.centershift.com/STORE40/}BaseEntityOfCollectionCFG_LOOKUPSColumnIndexes">
 *       &lt;sequence>
 *         &lt;element name="VALUE_KEY_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="VALUE_ID" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="LOOKUP_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="LOOKUP_VALUE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MEANING" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OTHER_VALUE" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="ACTIVE" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="ORG_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="SITE_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="CREATED" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="UPDATED" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="CREATED_BY" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="UPDATED_BY" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CFG_LOOKUPS", propOrder = {
        "valuekeyid",
        "valueid",
        "lookupid",
        "lookupvalue",
        "meaning",
        "othervalue",
        "active",
        "orgid",
        "siteid",
        "created",
        "updated",
        "createdby",
        "updatedby"
})
public class CFGLOOKUPS
        extends BaseEntityOfCollectionCFGLOOKUPSColumnIndexes {

    @XmlElement(name = "VALUE_KEY_ID")
    protected long valuekeyid;
    @XmlElement(name = "VALUE_ID")
    protected int valueid;
    @XmlElement(name = "LOOKUP_ID")
    protected long lookupid;
    @XmlElement(name = "LOOKUP_VALUE")
    protected String lookupvalue;
    @XmlElement(name = "MEANING")
    protected String meaning;
    @XmlElement(name = "OTHER_VALUE", required = true, nillable = true)
    protected BigDecimal othervalue;
    @XmlElement(name = "ACTIVE")
    protected boolean active;
    @XmlElement(name = "ORG_ID", required = true, type = Long.class, nillable = true)
    protected Long orgid;
    @XmlElement(name = "SITE_ID", required = true, type = Long.class, nillable = true)
    protected Long siteid;
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

    /**
     * Gets the value of the valuekeyid property.
     */
    public long getVALUEKEYID() {
        return valuekeyid;
    }

    /**
     * Sets the value of the valuekeyid property.
     */
    public void setVALUEKEYID(long value) {
        this.valuekeyid = value;
    }

    /**
     * Gets the value of the valueid property.
     */
    public int getVALUEID() {
        return valueid;
    }

    /**
     * Sets the value of the valueid property.
     */
    public void setVALUEID(int value) {
        this.valueid = value;
    }

    /**
     * Gets the value of the lookupid property.
     */
    public long getLOOKUPID() {
        return lookupid;
    }

    /**
     * Sets the value of the lookupid property.
     */
    public void setLOOKUPID(long value) {
        this.lookupid = value;
    }

    /**
     * Gets the value of the lookupvalue property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getLOOKUPVALUE() {
        return lookupvalue;
    }

    /**
     * Sets the value of the lookupvalue property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setLOOKUPVALUE(String value) {
        this.lookupvalue = value;
    }

    /**
     * Gets the value of the meaning property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getMEANING() {
        return meaning;
    }

    /**
     * Sets the value of the meaning property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setMEANING(String value) {
        this.meaning = value;
    }

    /**
     * Gets the value of the othervalue property.
     *
     * @return possible object is
     *         {@link BigDecimal }
     */
    public BigDecimal getOTHERVALUE() {
        return othervalue;
    }

    /**
     * Sets the value of the othervalue property.
     *
     * @param value allowed object is
     *              {@link BigDecimal }
     */
    public void setOTHERVALUE(BigDecimal value) {
        this.othervalue = value;
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
     * Gets the value of the orgid property.
     *
     * @return possible object is
     *         {@link Long }
     */
    public Long getORGID() {
        return orgid;
    }

    /**
     * Sets the value of the orgid property.
     *
     * @param value allowed object is
     *              {@link Long }
     */
    public void setORGID(Long value) {
        this.orgid = value;
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

}
