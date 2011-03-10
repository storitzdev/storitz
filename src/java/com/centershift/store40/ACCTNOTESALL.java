
package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for ACCT_NOTES_ALL complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ACCT_NOTES_ALL">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.centershift.com/STORE40/}BaseEntityOfCollectionACCT_NOTES_ALLColumnIndexes">
 *       &lt;sequence>
 *         &lt;element name="NOTE_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="ACCT_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="RENTAL_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="TYPE_VAL" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="NOTE_TYPE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PRIORITY_VAL" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="PRIORITY" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CREATED_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="CREATED_BY" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="NOTE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SUBJECT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CREATED" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="EXPIRES" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="ACCT_NAME" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="UNIT_ID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RENTAL_STATUS" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ACCT_NOTES_ALL", propOrder = {
    "noteid",
    "acctid",
    "rentalid",
    "typeval",
    "notetype",
    "priorityval",
    "priority",
    "createdid",
    "createdby",
    "note",
    "subject",
    "created",
    "expires",
    "acctname",
    "unitid",
    "rentalstatus"
})
public class ACCTNOTESALL
    extends BaseEntityOfCollectionACCTNOTESALLColumnIndexes
{

    @XmlElement(name = "NOTE_ID")
    protected long noteid;
    @XmlElement(name = "ACCT_ID")
    protected long acctid;
    @XmlElement(name = "RENTAL_ID", required = true, type = Long.class, nillable = true)
    protected Long rentalid;
    @XmlElement(name = "TYPE_VAL")
    protected int typeval;
    @XmlElement(name = "NOTE_TYPE")
    protected String notetype;
    @XmlElement(name = "PRIORITY_VAL")
    protected int priorityval;
    @XmlElement(name = "PRIORITY")
    protected String priority;
    @XmlElement(name = "CREATED_ID")
    protected long createdid;
    @XmlElement(name = "CREATED_BY")
    protected String createdby;
    @XmlElement(name = "NOTE")
    protected String note;
    @XmlElement(name = "SUBJECT")
    protected String subject;
    @XmlElement(name = "CREATED", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar created;
    @XmlElement(name = "EXPIRES", required = true, nillable = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar expires;
    @XmlElement(name = "ACCT_NAME")
    protected String acctname;
    @XmlElement(name = "UNIT_ID")
    protected String unitid;
    @XmlElement(name = "RENTAL_STATUS", required = true, type = Integer.class, nillable = true)
    protected Integer rentalstatus;

    /**
     * Gets the value of the noteid property.
     * 
     */
    public long getNOTEID() {
        return noteid;
    }

    /**
     * Sets the value of the noteid property.
     * 
     */
    public void setNOTEID(long value) {
        this.noteid = value;
    }

    /**
     * Gets the value of the acctid property.
     * 
     */
    public long getACCTID() {
        return acctid;
    }

    /**
     * Sets the value of the acctid property.
     * 
     */
    public void setACCTID(long value) {
        this.acctid = value;
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
     * Gets the value of the typeval property.
     * 
     */
    public int getTYPEVAL() {
        return typeval;
    }

    /**
     * Sets the value of the typeval property.
     * 
     */
    public void setTYPEVAL(int value) {
        this.typeval = value;
    }

    /**
     * Gets the value of the notetype property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNOTETYPE() {
        return notetype;
    }

    /**
     * Sets the value of the notetype property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNOTETYPE(String value) {
        this.notetype = value;
    }

    /**
     * Gets the value of the priorityval property.
     * 
     */
    public int getPRIORITYVAL() {
        return priorityval;
    }

    /**
     * Sets the value of the priorityval property.
     * 
     */
    public void setPRIORITYVAL(int value) {
        this.priorityval = value;
    }

    /**
     * Gets the value of the priority property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPRIORITY() {
        return priority;
    }

    /**
     * Sets the value of the priority property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPRIORITY(String value) {
        this.priority = value;
    }

    /**
     * Gets the value of the createdid property.
     * 
     */
    public long getCREATEDID() {
        return createdid;
    }

    /**
     * Sets the value of the createdid property.
     * 
     */
    public void setCREATEDID(long value) {
        this.createdid = value;
    }

    /**
     * Gets the value of the createdby property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCREATEDBY() {
        return createdby;
    }

    /**
     * Sets the value of the createdby property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCREATEDBY(String value) {
        this.createdby = value;
    }

    /**
     * Gets the value of the note property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNOTE() {
        return note;
    }

    /**
     * Sets the value of the note property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNOTE(String value) {
        this.note = value;
    }

    /**
     * Gets the value of the subject property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSUBJECT() {
        return subject;
    }

    /**
     * Sets the value of the subject property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSUBJECT(String value) {
        this.subject = value;
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
     * Gets the value of the expires property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getEXPIRES() {
        return expires;
    }

    /**
     * Sets the value of the expires property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setEXPIRES(XMLGregorianCalendar value) {
        this.expires = value;
    }

    /**
     * Gets the value of the acctname property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getACCTNAME() {
        return acctname;
    }

    /**
     * Sets the value of the acctname property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setACCTNAME(String value) {
        this.acctname = value;
    }

    /**
     * Gets the value of the unitid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUNITID() {
        return unitid;
    }

    /**
     * Sets the value of the unitid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUNITID(String value) {
        this.unitid = value;
    }

    /**
     * Gets the value of the rentalstatus property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getRENTALSTATUS() {
        return rentalstatus;
    }

    /**
     * Sets the value of the rentalstatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setRENTALSTATUS(Integer value) {
        this.rentalstatus = value;
    }

}
