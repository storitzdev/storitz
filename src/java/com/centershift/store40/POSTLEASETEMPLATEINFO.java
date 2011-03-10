
package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for POST_LEASE_TEMPLATE_INFO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="POST_LEASE_TEMPLATE_INFO">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.centershift.com/STORE40/}BaseEntityOfCollectionPOST_LEASE_TEMPLATE_INFOColumnIndexes">
 *       &lt;sequence>
 *         &lt;element name="LEASE_DEF_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="LEASE_NAME" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CURR_VERSION" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="ORG_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="SITE_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="STATE_ID" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="STATE_MEANING" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LANGUAGE_ID" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="LANGUAGE_MEANING" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="STATUS" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="STATUS_MEANING" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="WHO_CREATED" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CREATED" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="WHO_UPDATED" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="UPDATED" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "POST_LEASE_TEMPLATE_INFO", propOrder = {
    "leasedefid",
    "leasename",
    "currversion",
    "orgid",
    "siteid",
    "stateid",
    "statemeaning",
    "languageid",
    "languagemeaning",
    "status",
    "statusmeaning",
    "whocreated",
    "created",
    "whoupdated",
    "updated"
})
public class POSTLEASETEMPLATEINFO
    extends BaseEntityOfCollectionPOSTLEASETEMPLATEINFOColumnIndexes
{

    @XmlElement(name = "LEASE_DEF_ID")
    protected long leasedefid;
    @XmlElement(name = "LEASE_NAME")
    protected String leasename;
    @XmlElement(name = "CURR_VERSION")
    protected int currversion;
    @XmlElement(name = "ORG_ID")
    protected long orgid;
    @XmlElement(name = "SITE_ID", required = true, type = Long.class, nillable = true)
    protected Long siteid;
    @XmlElement(name = "STATE_ID")
    protected int stateid;
    @XmlElement(name = "STATE_MEANING")
    protected String statemeaning;
    @XmlElement(name = "LANGUAGE_ID")
    protected int languageid;
    @XmlElement(name = "LANGUAGE_MEANING")
    protected String languagemeaning;
    @XmlElement(name = "STATUS")
    protected int status;
    @XmlElement(name = "STATUS_MEANING")
    protected String statusmeaning;
    @XmlElement(name = "WHO_CREATED")
    protected String whocreated;
    @XmlElement(name = "CREATED", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar created;
    @XmlElement(name = "WHO_UPDATED")
    protected String whoupdated;
    @XmlElement(name = "UPDATED", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar updated;

    /**
     * Gets the value of the leasedefid property.
     * 
     */
    public long getLEASEDEFID() {
        return leasedefid;
    }

    /**
     * Sets the value of the leasedefid property.
     * 
     */
    public void setLEASEDEFID(long value) {
        this.leasedefid = value;
    }

    /**
     * Gets the value of the leasename property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLEASENAME() {
        return leasename;
    }

    /**
     * Sets the value of the leasename property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLEASENAME(String value) {
        this.leasename = value;
    }

    /**
     * Gets the value of the currversion property.
     * 
     */
    public int getCURRVERSION() {
        return currversion;
    }

    /**
     * Sets the value of the currversion property.
     * 
     */
    public void setCURRVERSION(int value) {
        this.currversion = value;
    }

    /**
     * Gets the value of the orgid property.
     * 
     */
    public long getORGID() {
        return orgid;
    }

    /**
     * Sets the value of the orgid property.
     * 
     */
    public void setORGID(long value) {
        this.orgid = value;
    }

    /**
     * Gets the value of the siteid property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getSITEID() {
        return siteid;
    }

    /**
     * Sets the value of the siteid property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setSITEID(Long value) {
        this.siteid = value;
    }

    /**
     * Gets the value of the stateid property.
     * 
     */
    public int getSTATEID() {
        return stateid;
    }

    /**
     * Sets the value of the stateid property.
     * 
     */
    public void setSTATEID(int value) {
        this.stateid = value;
    }

    /**
     * Gets the value of the statemeaning property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSTATEMEANING() {
        return statemeaning;
    }

    /**
     * Sets the value of the statemeaning property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSTATEMEANING(String value) {
        this.statemeaning = value;
    }

    /**
     * Gets the value of the languageid property.
     * 
     */
    public int getLANGUAGEID() {
        return languageid;
    }

    /**
     * Sets the value of the languageid property.
     * 
     */
    public void setLANGUAGEID(int value) {
        this.languageid = value;
    }

    /**
     * Gets the value of the languagemeaning property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLANGUAGEMEANING() {
        return languagemeaning;
    }

    /**
     * Sets the value of the languagemeaning property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLANGUAGEMEANING(String value) {
        this.languagemeaning = value;
    }

    /**
     * Gets the value of the status property.
     * 
     */
    public int getSTATUS() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     */
    public void setSTATUS(int value) {
        this.status = value;
    }

    /**
     * Gets the value of the statusmeaning property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSTATUSMEANING() {
        return statusmeaning;
    }

    /**
     * Sets the value of the statusmeaning property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSTATUSMEANING(String value) {
        this.statusmeaning = value;
    }

    /**
     * Gets the value of the whocreated property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWHOCREATED() {
        return whocreated;
    }

    /**
     * Sets the value of the whocreated property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWHOCREATED(String value) {
        this.whocreated = value;
    }

    /**
     * Gets the value of the created property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getCREATED() {
        return created;
    }

    /**
     * Sets the value of the created property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setCREATED(XMLGregorianCalendar value) {
        this.created = value;
    }

    /**
     * Gets the value of the whoupdated property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWHOUPDATED() {
        return whoupdated;
    }

    /**
     * Sets the value of the whoupdated property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWHOUPDATED(String value) {
        this.whoupdated = value;
    }

    /**
     * Gets the value of the updated property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getUPDATED() {
        return updated;
    }

    /**
     * Sets the value of the updated property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setUPDATED(XMLGregorianCalendar value) {
        this.updated = value;
    }

}
