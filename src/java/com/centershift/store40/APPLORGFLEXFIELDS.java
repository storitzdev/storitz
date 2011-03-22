package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for APPL_ORG_FLEX_FIELDS complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="APPL_ORG_FLEX_FIELDS">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.centershift.com/STORE40/}BaseEntityOfCollectionAPPL_ORG_FLEX_FIELDSColumnIndexes">
 *       &lt;sequence>
 *         &lt;element name="TABLE_NAME" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="COLUMN_NAME" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ACTIVE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ORG_DEF_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="ORG_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="CUST_LABEL" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CUST_REQUIRED" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="CUST_LOOKUP_SET" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="DISPLAY" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "APPL_ORG_FLEX_FIELDS", propOrder = {
        "tablename",
        "columnname",
        "active",
        "orgdefid",
        "orgid",
        "custlabel",
        "custrequired",
        "custlookupset",
        "display"
})
public class APPLORGFLEXFIELDS
        extends BaseEntityOfCollectionAPPLORGFLEXFIELDSColumnIndexes {

    @XmlElement(name = "TABLE_NAME")
    protected String tablename;
    @XmlElement(name = "COLUMN_NAME")
    protected String columnname;
    @XmlElement(name = "ACTIVE")
    protected String active;
    @XmlElement(name = "ORG_DEF_ID")
    protected long orgdefid;
    @XmlElement(name = "ORG_ID")
    protected long orgid;
    @XmlElement(name = "CUST_LABEL")
    protected String custlabel;
    @XmlElement(name = "CUST_REQUIRED")
    protected boolean custrequired;
    @XmlElement(name = "CUST_LOOKUP_SET", required = true, type = Long.class, nillable = true)
    protected Long custlookupset;
    @XmlElement(name = "DISPLAY")
    protected String display;

    /**
     * Gets the value of the tablename property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getTABLENAME() {
        return tablename;
    }

    /**
     * Sets the value of the tablename property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setTABLENAME(String value) {
        this.tablename = value;
    }

    /**
     * Gets the value of the columnname property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getCOLUMNNAME() {
        return columnname;
    }

    /**
     * Sets the value of the columnname property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setCOLUMNNAME(String value) {
        this.columnname = value;
    }

    /**
     * Gets the value of the active property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getACTIVE() {
        return active;
    }

    /**
     * Sets the value of the active property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setACTIVE(String value) {
        this.active = value;
    }

    /**
     * Gets the value of the orgdefid property.
     */
    public long getORGDEFID() {
        return orgdefid;
    }

    /**
     * Sets the value of the orgdefid property.
     */
    public void setORGDEFID(long value) {
        this.orgdefid = value;
    }

    /**
     * Gets the value of the orgid property.
     */
    public long getORGID() {
        return orgid;
    }

    /**
     * Sets the value of the orgid property.
     */
    public void setORGID(long value) {
        this.orgid = value;
    }

    /**
     * Gets the value of the custlabel property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getCUSTLABEL() {
        return custlabel;
    }

    /**
     * Sets the value of the custlabel property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setCUSTLABEL(String value) {
        this.custlabel = value;
    }

    /**
     * Gets the value of the custrequired property.
     */
    public boolean isCUSTREQUIRED() {
        return custrequired;
    }

    /**
     * Sets the value of the custrequired property.
     */
    public void setCUSTREQUIRED(boolean value) {
        this.custrequired = value;
    }

    /**
     * Gets the value of the custlookupset property.
     *
     * @return possible object is
     *         {@link Long }
     */
    public Long getCUSTLOOKUPSET() {
        return custlookupset;
    }

    /**
     * Sets the value of the custlookupset property.
     *
     * @param value allowed object is
     *              {@link Long }
     */
    public void setCUSTLOOKUPSET(Long value) {
        this.custlookupset = value;
    }

    /**
     * Gets the value of the display property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getDISPLAY() {
        return display;
    }

    /**
     * Sets the value of the display property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setDISPLAY(String value) {
        this.display = value;
    }

}
