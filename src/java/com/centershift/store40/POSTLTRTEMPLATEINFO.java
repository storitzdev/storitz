
package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for POST_LTR_TEMPLATE_INFO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="POST_LTR_TEMPLATE_INFO">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.centershift.com/STORE40/}BaseEntityOfCollectionPOST_LTR_TEMPLATE_INFOColumnIndexes">
 *       &lt;sequence>
 *         &lt;element name="LTR_TYPE_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="LTR_TYPE_GROUP" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="GROUP_MEANING" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LTR_NAME" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CURR_VERSION" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="ORG_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="SITE_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="PRINT_SPECIAL" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="PRINT_MEANING" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
@XmlType(name = "POST_LTR_TEMPLATE_INFO", propOrder = {
    "ltrtypeid",
    "ltrtypegroup",
    "groupmeaning",
    "ltrname",
    "currversion",
    "orgid",
    "siteid",
    "printspecial",
    "printmeaning",
    "status",
    "statusmeaning",
    "whocreated",
    "created",
    "whoupdated",
    "updated"
})
public class POSTLTRTEMPLATEINFO
    extends BaseEntityOfCollectionPOSTLTRTEMPLATEINFOColumnIndexes
{

    @XmlElement(name = "LTR_TYPE_ID")
    protected long ltrtypeid;
    @XmlElement(name = "LTR_TYPE_GROUP")
    protected int ltrtypegroup;
    @XmlElement(name = "GROUP_MEANING")
    protected String groupmeaning;
    @XmlElement(name = "LTR_NAME")
    protected String ltrname;
    @XmlElement(name = "CURR_VERSION")
    protected int currversion;
    @XmlElement(name = "ORG_ID")
    protected long orgid;
    @XmlElement(name = "SITE_ID", required = true, type = Long.class, nillable = true)
    protected Long siteid;
    @XmlElement(name = "PRINT_SPECIAL")
    protected int printspecial;
    @XmlElement(name = "PRINT_MEANING")
    protected String printmeaning;
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
     * Gets the value of the ltrtypeid property.
     * 
     */
    public long getLTRTYPEID() {
        return ltrtypeid;
    }

    /**
     * Sets the value of the ltrtypeid property.
     * 
     */
    public void setLTRTYPEID(long value) {
        this.ltrtypeid = value;
    }

    /**
     * Gets the value of the ltrtypegroup property.
     * 
     */
    public int getLTRTYPEGROUP() {
        return ltrtypegroup;
    }

    /**
     * Sets the value of the ltrtypegroup property.
     * 
     */
    public void setLTRTYPEGROUP(int value) {
        this.ltrtypegroup = value;
    }

    /**
     * Gets the value of the groupmeaning property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGROUPMEANING() {
        return groupmeaning;
    }

    /**
     * Sets the value of the groupmeaning property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGROUPMEANING(String value) {
        this.groupmeaning = value;
    }

    /**
     * Gets the value of the ltrname property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLTRNAME() {
        return ltrname;
    }

    /**
     * Sets the value of the ltrname property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLTRNAME(String value) {
        this.ltrname = value;
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
     * Gets the value of the printspecial property.
     * 
     */
    public int getPRINTSPECIAL() {
        return printspecial;
    }

    /**
     * Sets the value of the printspecial property.
     * 
     */
    public void setPRINTSPECIAL(int value) {
        this.printspecial = value;
    }

    /**
     * Gets the value of the printmeaning property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPRINTMEANING() {
        return printmeaning;
    }

    /**
     * Sets the value of the printmeaning property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPRINTMEANING(String value) {
        this.printmeaning = value;
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
