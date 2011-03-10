
package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for POST_SCHEDULE_LTR_TNT_INFO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="POST_SCHEDULE_LTR_TNT_INFO">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.centershift.com/STORE40/}BaseEntityOfCollectionPOST_SCHEDULE_LTR_TNT_INFOColumnIndexes">
 *       &lt;sequence>
 *         &lt;element name="SCHED_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="RENTAL_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="ACCT_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="SITE_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="LTR_TYPE_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="LTR_NAME" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CERT_FLAG" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="MAIL_LOCAL" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="PROCESSED_FLAG" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="SCHEDULED_DATE" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="ACTIVE" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="WHO_CREATED" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="NOTES" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "POST_SCHEDULE_LTR_TNT_INFO", propOrder = {
    "schedid",
    "rentalid",
    "acctid",
    "siteid",
    "ltrtypeid",
    "ltrname",
    "certflag",
    "maillocal",
    "processedflag",
    "scheduleddate",
    "active",
    "whocreated",
    "notes"
})
public class POSTSCHEDULELTRTNTINFO
    extends BaseEntityOfCollectionPOSTSCHEDULELTRTNTINFOColumnIndexes
{

    @XmlElement(name = "SCHED_ID")
    protected long schedid;
    @XmlElement(name = "RENTAL_ID", required = true, type = Long.class, nillable = true)
    protected Long rentalid;
    @XmlElement(name = "ACCT_ID", required = true, type = Long.class, nillable = true)
    protected Long acctid;
    @XmlElement(name = "SITE_ID")
    protected long siteid;
    @XmlElement(name = "LTR_TYPE_ID")
    protected long ltrtypeid;
    @XmlElement(name = "LTR_NAME")
    protected String ltrname;
    @XmlElement(name = "CERT_FLAG")
    protected boolean certflag;
    @XmlElement(name = "MAIL_LOCAL", required = true, type = Boolean.class, nillable = true)
    protected Boolean maillocal;
    @XmlElement(name = "PROCESSED_FLAG")
    protected boolean processedflag;
    @XmlElement(name = "SCHEDULED_DATE", required = true, nillable = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar scheduleddate;
    @XmlElement(name = "ACTIVE")
    protected boolean active;
    @XmlElement(name = "WHO_CREATED")
    protected String whocreated;
    @XmlElement(name = "NOTES")
    protected String notes;

    /**
     * Gets the value of the schedid property.
     * 
     */
    public long getSCHEDID() {
        return schedid;
    }

    /**
     * Sets the value of the schedid property.
     * 
     */
    public void setSCHEDID(long value) {
        this.schedid = value;
    }

    /**
     * Gets the value of the rentalid property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getRENTALID() {
        return rentalid;
    }

    /**
     * Sets the value of the rentalid property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setRENTALID(Long value) {
        this.rentalid = value;
    }

    /**
     * Gets the value of the acctid property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getACCTID() {
        return acctid;
    }

    /**
     * Sets the value of the acctid property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setACCTID(Long value) {
        this.acctid = value;
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
     * Gets the value of the certflag property.
     * 
     */
    public boolean isCERTFLAG() {
        return certflag;
    }

    /**
     * Sets the value of the certflag property.
     * 
     */
    public void setCERTFLAG(boolean value) {
        this.certflag = value;
    }

    /**
     * Gets the value of the maillocal property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isMAILLOCAL() {
        return maillocal;
    }

    /**
     * Sets the value of the maillocal property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setMAILLOCAL(Boolean value) {
        this.maillocal = value;
    }

    /**
     * Gets the value of the processedflag property.
     * 
     */
    public boolean isPROCESSEDFLAG() {
        return processedflag;
    }

    /**
     * Sets the value of the processedflag property.
     * 
     */
    public void setPROCESSEDFLAG(boolean value) {
        this.processedflag = value;
    }

    /**
     * Gets the value of the scheduleddate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getSCHEDULEDDATE() {
        return scheduleddate;
    }

    /**
     * Sets the value of the scheduleddate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setSCHEDULEDDATE(XMLGregorianCalendar value) {
        this.scheduleddate = value;
    }

    /**
     * Gets the value of the active property.
     * 
     */
    public boolean isACTIVE() {
        return active;
    }

    /**
     * Sets the value of the active property.
     * 
     */
    public void setACTIVE(boolean value) {
        this.active = value;
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
     * Gets the value of the notes property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNOTES() {
        return notes;
    }

    /**
     * Sets the value of the notes property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNOTES(String value) {
        this.notes = value;
    }

}
