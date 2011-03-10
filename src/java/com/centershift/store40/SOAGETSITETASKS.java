
package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for SOA_GET_SITE_TASKS complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SOA_GET_SITE_TASKS">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.centershift.com/STORE40/}BaseEntityOfCollectionSOA_GET_SITE_TASKSColumnIndexes">
 *       &lt;sequence>
 *         &lt;element name="MSG_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="SITE_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="MSG_RECUR_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="MSG_TYPE" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="MSG_TYPE_VAL" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MSG_HEADER" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MSG_BODY" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="STATUS" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="PRIORITY" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="START_DAY" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="REF_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="REF_TYPE" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="REF_TYPE_VAL" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CREATED_BY" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="UPDATED_BY" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SOA_GET_SITE_TASKS", propOrder = {
    "msgid",
    "siteid",
    "msgrecurid",
    "msgtype",
    "msgtypeval",
    "msgheader",
    "msgbody",
    "status",
    "priority",
    "startday",
    "refid",
    "reftype",
    "reftypeval",
    "createdby",
    "updatedby"
})
public class SOAGETSITETASKS
    extends BaseEntityOfCollectionSOAGETSITETASKSColumnIndexes
{

    @XmlElement(name = "MSG_ID")
    protected long msgid;
    @XmlElement(name = "SITE_ID")
    protected long siteid;
    @XmlElement(name = "MSG_RECUR_ID", required = true, type = Long.class, nillable = true)
    protected Long msgrecurid;
    @XmlElement(name = "MSG_TYPE")
    protected int msgtype;
    @XmlElement(name = "MSG_TYPE_VAL")
    protected String msgtypeval;
    @XmlElement(name = "MSG_HEADER")
    protected String msgheader;
    @XmlElement(name = "MSG_BODY")
    protected String msgbody;
    @XmlElement(name = "STATUS")
    protected int status;
    @XmlElement(name = "PRIORITY")
    protected int priority;
    @XmlElement(name = "START_DAY", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar startday;
    @XmlElement(name = "REF_ID", required = true, type = Long.class, nillable = true)
    protected Long refid;
    @XmlElement(name = "REF_TYPE", required = true, type = Integer.class, nillable = true)
    protected Integer reftype;
    @XmlElement(name = "REF_TYPE_VAL")
    protected String reftypeval;
    @XmlElement(name = "CREATED_BY")
    protected long createdby;
    @XmlElement(name = "UPDATED_BY")
    protected long updatedby;

    /**
     * Gets the value of the msgid property.
     * 
     */
    public long getMSGID() {
        return msgid;
    }

    /**
     * Sets the value of the msgid property.
     * 
     */
    public void setMSGID(long value) {
        this.msgid = value;
    }

    /**
     * Gets the value of the siteid property.
     * 
     */
    public long getSITEID() {
        return siteid;
    }

    /**
     * Sets the value of the siteid property.
     * 
     */
    public void setSITEID(long value) {
        this.siteid = value;
    }

    /**
     * Gets the value of the msgrecurid property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getMSGRECURID() {
        return msgrecurid;
    }

    /**
     * Sets the value of the msgrecurid property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setMSGRECURID(Long value) {
        this.msgrecurid = value;
    }

    /**
     * Gets the value of the msgtype property.
     * 
     */
    public int getMSGTYPE() {
        return msgtype;
    }

    /**
     * Sets the value of the msgtype property.
     * 
     */
    public void setMSGTYPE(int value) {
        this.msgtype = value;
    }

    /**
     * Gets the value of the msgtypeval property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMSGTYPEVAL() {
        return msgtypeval;
    }

    /**
     * Sets the value of the msgtypeval property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMSGTYPEVAL(String value) {
        this.msgtypeval = value;
    }

    /**
     * Gets the value of the msgheader property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMSGHEADER() {
        return msgheader;
    }

    /**
     * Sets the value of the msgheader property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMSGHEADER(String value) {
        this.msgheader = value;
    }

    /**
     * Gets the value of the msgbody property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMSGBODY() {
        return msgbody;
    }

    /**
     * Sets the value of the msgbody property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMSGBODY(String value) {
        this.msgbody = value;
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
     * Gets the value of the priority property.
     * 
     */
    public int getPRIORITY() {
        return priority;
    }

    /**
     * Sets the value of the priority property.
     * 
     */
    public void setPRIORITY(int value) {
        this.priority = value;
    }

    /**
     * Gets the value of the startday property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getSTARTDAY() {
        return startday;
    }

    /**
     * Sets the value of the startday property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setSTARTDAY(XMLGregorianCalendar value) {
        this.startday = value;
    }

    /**
     * Gets the value of the refid property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getREFID() {
        return refid;
    }

    /**
     * Sets the value of the refid property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setREFID(Long value) {
        this.refid = value;
    }

    /**
     * Gets the value of the reftype property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getREFTYPE() {
        return reftype;
    }

    /**
     * Sets the value of the reftype property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setREFTYPE(Integer value) {
        this.reftype = value;
    }

    /**
     * Gets the value of the reftypeval property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getREFTYPEVAL() {
        return reftypeval;
    }

    /**
     * Sets the value of the reftypeval property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setREFTYPEVAL(String value) {
        this.reftypeval = value;
    }

    /**
     * Gets the value of the createdby property.
     * 
     */
    public long getCREATEDBY() {
        return createdby;
    }

    /**
     * Sets the value of the createdby property.
     * 
     */
    public void setCREATEDBY(long value) {
        this.createdby = value;
    }

    /**
     * Gets the value of the updatedby property.
     * 
     */
    public long getUPDATEDBY() {
        return updatedby;
    }

    /**
     * Sets the value of the updatedby property.
     * 
     */
    public void setUPDATEDBY(long value) {
        this.updatedby = value;
    }

}
