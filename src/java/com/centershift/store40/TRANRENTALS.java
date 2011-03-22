package com.centershift.store40;

import javax.xml.bind.annotation.*;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for TRAN_RENTALS complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="TRAN_RENTALS">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.centershift.com/STORE40/}BaseEntityOfCollectionTRAN_RENTALSColumnIndexes">
 *       &lt;sequence>
 *         &lt;element name="RENTAL_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="ACCT_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="OBJECT_TYPE" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="OBJECT_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="PARENT_RENTAL_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="STATUS" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="START_DATE" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="END_DATE" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="PTD" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="LTD" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="OVERLOCK_STATUS" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="DEL_SCHEDULE" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="EMAIL_CC" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="MO_NOTICE_DATE" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="MO_DATE" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="TRANSFER_TO_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="DAILY_DEL_DATE" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="DEL_EXEMPT" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="LEGACY_REF_ID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TAX_EXEMPT" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="TAX_EXEMPT_INFO" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CREATED" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="UPDATED" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="CREATED_BY" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="UPDATED_BY" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="DEL_STEP" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="ATD" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="PER_END_DAY" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="VERSION" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="MAIL_SERV_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="EMAIL_SERV_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="TRANSFER_FROM_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TRAN_RENTALS", propOrder = {
        "rentalid",
        "acctid",
        "objecttype",
        "objectid",
        "parentrentalid",
        "status",
        "startdate",
        "enddate",
        "ptd",
        "ltd",
        "overlockstatus",
        "delschedule",
        "emailcc",
        "monoticedate",
        "modate",
        "transfertoid",
        "dailydeldate",
        "delexempt",
        "legacyrefid",
        "taxexempt",
        "taxexemptinfo",
        "created",
        "updated",
        "createdby",
        "updatedby",
        "delstep",
        "atd",
        "perendday",
        "version",
        "mailservid",
        "emailservid",
        "transferfromid"
})
public class TRANRENTALS
        extends BaseEntityOfCollectionTRANRENTALSColumnIndexes {

    @XmlElement(name = "RENTAL_ID")
    protected long rentalid;
    @XmlElement(name = "ACCT_ID", required = true, type = Long.class, nillable = true)
    protected Long acctid;
    @XmlElement(name = "OBJECT_TYPE")
    protected int objecttype;
    @XmlElement(name = "OBJECT_ID")
    protected long objectid;
    @XmlElement(name = "PARENT_RENTAL_ID", required = true, type = Long.class, nillable = true)
    protected Long parentrentalid;
    @XmlElement(name = "STATUS")
    protected int status;
    @XmlElement(name = "START_DATE", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar startdate;
    @XmlElement(name = "END_DATE", required = true, nillable = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar enddate;
    @XmlElement(name = "PTD", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar ptd;
    @XmlElement(name = "LTD", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar ltd;
    @XmlElement(name = "OVERLOCK_STATUS")
    protected int overlockstatus;
    @XmlElement(name = "DEL_SCHEDULE", required = true, type = Long.class, nillable = true)
    protected Long delschedule;
    @XmlElement(name = "EMAIL_CC")
    protected boolean emailcc;
    @XmlElement(name = "MO_NOTICE_DATE", required = true, nillable = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar monoticedate;
    @XmlElement(name = "MO_DATE", required = true, nillable = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar modate;
    @XmlElement(name = "TRANSFER_TO_ID", required = true, type = Long.class, nillable = true)
    protected Long transfertoid;
    @XmlElement(name = "DAILY_DEL_DATE", required = true, nillable = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dailydeldate;
    @XmlElement(name = "DEL_EXEMPT")
    protected boolean delexempt;
    @XmlElement(name = "LEGACY_REF_ID")
    protected String legacyrefid;
    @XmlElement(name = "TAX_EXEMPT")
    protected int taxexempt;
    @XmlElement(name = "TAX_EXEMPT_INFO")
    protected String taxexemptinfo;
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
    @XmlElement(name = "DEL_STEP")
    protected int delstep;
    @XmlElement(name = "ATD", required = true, nillable = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar atd;
    @XmlElement(name = "PER_END_DAY", required = true, type = Integer.class, nillable = true)
    protected Integer perendday;
    @XmlElement(name = "VERSION")
    protected int version;
    @XmlElement(name = "MAIL_SERV_ID", required = true, type = Long.class, nillable = true)
    protected Long mailservid;
    @XmlElement(name = "EMAIL_SERV_ID", required = true, type = Long.class, nillable = true)
    protected Long emailservid;
    @XmlElement(name = "TRANSFER_FROM_ID", required = true, type = Long.class, nillable = true)
    protected Long transferfromid;

    /**
     * Gets the value of the rentalid property.
     */
    public long getRENTALID() {
        return rentalid;
    }

    /**
     * Sets the value of the rentalid property.
     */
    public void setRENTALID(long value) {
        this.rentalid = value;
    }

    /**
     * Gets the value of the acctid property.
     *
     * @return possible object is
     *         {@link Long }
     */
    public Long getACCTID() {
        return acctid;
    }

    /**
     * Sets the value of the acctid property.
     *
     * @param value allowed object is
     *              {@link Long }
     */
    public void setACCTID(Long value) {
        this.acctid = value;
    }

    /**
     * Gets the value of the objecttype property.
     */
    public int getOBJECTTYPE() {
        return objecttype;
    }

    /**
     * Sets the value of the objecttype property.
     */
    public void setOBJECTTYPE(int value) {
        this.objecttype = value;
    }

    /**
     * Gets the value of the objectid property.
     */
    public long getOBJECTID() {
        return objectid;
    }

    /**
     * Sets the value of the objectid property.
     */
    public void setOBJECTID(long value) {
        this.objectid = value;
    }

    /**
     * Gets the value of the parentrentalid property.
     *
     * @return possible object is
     *         {@link Long }
     */
    public Long getPARENTRENTALID() {
        return parentrentalid;
    }

    /**
     * Sets the value of the parentrentalid property.
     *
     * @param value allowed object is
     *              {@link Long }
     */
    public void setPARENTRENTALID(Long value) {
        this.parentrentalid = value;
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
     * Gets the value of the startdate property.
     *
     * @return possible object is
     *         {@link XMLGregorianCalendar }
     */
    public XMLGregorianCalendar getSTARTDATE() {
        return startdate;
    }

    /**
     * Sets the value of the startdate property.
     *
     * @param value allowed object is
     *              {@link XMLGregorianCalendar }
     */
    public void setSTARTDATE(XMLGregorianCalendar value) {
        this.startdate = value;
    }

    /**
     * Gets the value of the enddate property.
     *
     * @return possible object is
     *         {@link XMLGregorianCalendar }
     */
    public XMLGregorianCalendar getENDDATE() {
        return enddate;
    }

    /**
     * Sets the value of the enddate property.
     *
     * @param value allowed object is
     *              {@link XMLGregorianCalendar }
     */
    public void setENDDATE(XMLGregorianCalendar value) {
        this.enddate = value;
    }

    /**
     * Gets the value of the ptd property.
     *
     * @return possible object is
     *         {@link XMLGregorianCalendar }
     */
    public XMLGregorianCalendar getPTD() {
        return ptd;
    }

    /**
     * Sets the value of the ptd property.
     *
     * @param value allowed object is
     *              {@link XMLGregorianCalendar }
     */
    public void setPTD(XMLGregorianCalendar value) {
        this.ptd = value;
    }

    /**
     * Gets the value of the ltd property.
     *
     * @return possible object is
     *         {@link XMLGregorianCalendar }
     */
    public XMLGregorianCalendar getLTD() {
        return ltd;
    }

    /**
     * Sets the value of the ltd property.
     *
     * @param value allowed object is
     *              {@link XMLGregorianCalendar }
     */
    public void setLTD(XMLGregorianCalendar value) {
        this.ltd = value;
    }

    /**
     * Gets the value of the overlockstatus property.
     */
    public int getOVERLOCKSTATUS() {
        return overlockstatus;
    }

    /**
     * Sets the value of the overlockstatus property.
     */
    public void setOVERLOCKSTATUS(int value) {
        this.overlockstatus = value;
    }

    /**
     * Gets the value of the delschedule property.
     *
     * @return possible object is
     *         {@link Long }
     */
    public Long getDELSCHEDULE() {
        return delschedule;
    }

    /**
     * Sets the value of the delschedule property.
     *
     * @param value allowed object is
     *              {@link Long }
     */
    public void setDELSCHEDULE(Long value) {
        this.delschedule = value;
    }

    /**
     * Gets the value of the emailcc property.
     */
    public boolean isEMAILCC() {
        return emailcc;
    }

    /**
     * Sets the value of the emailcc property.
     */
    public void setEMAILCC(boolean value) {
        this.emailcc = value;
    }

    /**
     * Gets the value of the monoticedate property.
     *
     * @return possible object is
     *         {@link XMLGregorianCalendar }
     */
    public XMLGregorianCalendar getMONOTICEDATE() {
        return monoticedate;
    }

    /**
     * Sets the value of the monoticedate property.
     *
     * @param value allowed object is
     *              {@link XMLGregorianCalendar }
     */
    public void setMONOTICEDATE(XMLGregorianCalendar value) {
        this.monoticedate = value;
    }

    /**
     * Gets the value of the modate property.
     *
     * @return possible object is
     *         {@link XMLGregorianCalendar }
     */
    public XMLGregorianCalendar getMODATE() {
        return modate;
    }

    /**
     * Sets the value of the modate property.
     *
     * @param value allowed object is
     *              {@link XMLGregorianCalendar }
     */
    public void setMODATE(XMLGregorianCalendar value) {
        this.modate = value;
    }

    /**
     * Gets the value of the transfertoid property.
     *
     * @return possible object is
     *         {@link Long }
     */
    public Long getTRANSFERTOID() {
        return transfertoid;
    }

    /**
     * Sets the value of the transfertoid property.
     *
     * @param value allowed object is
     *              {@link Long }
     */
    public void setTRANSFERTOID(Long value) {
        this.transfertoid = value;
    }

    /**
     * Gets the value of the dailydeldate property.
     *
     * @return possible object is
     *         {@link XMLGregorianCalendar }
     */
    public XMLGregorianCalendar getDAILYDELDATE() {
        return dailydeldate;
    }

    /**
     * Sets the value of the dailydeldate property.
     *
     * @param value allowed object is
     *              {@link XMLGregorianCalendar }
     */
    public void setDAILYDELDATE(XMLGregorianCalendar value) {
        this.dailydeldate = value;
    }

    /**
     * Gets the value of the delexempt property.
     */
    public boolean isDELEXEMPT() {
        return delexempt;
    }

    /**
     * Sets the value of the delexempt property.
     */
    public void setDELEXEMPT(boolean value) {
        this.delexempt = value;
    }

    /**
     * Gets the value of the legacyrefid property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getLEGACYREFID() {
        return legacyrefid;
    }

    /**
     * Sets the value of the legacyrefid property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setLEGACYREFID(String value) {
        this.legacyrefid = value;
    }

    /**
     * Gets the value of the taxexempt property.
     */
    public int getTAXEXEMPT() {
        return taxexempt;
    }

    /**
     * Sets the value of the taxexempt property.
     */
    public void setTAXEXEMPT(int value) {
        this.taxexempt = value;
    }

    /**
     * Gets the value of the taxexemptinfo property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getTAXEXEMPTINFO() {
        return taxexemptinfo;
    }

    /**
     * Sets the value of the taxexemptinfo property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setTAXEXEMPTINFO(String value) {
        this.taxexemptinfo = value;
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
     * Gets the value of the delstep property.
     */
    public int getDELSTEP() {
        return delstep;
    }

    /**
     * Sets the value of the delstep property.
     */
    public void setDELSTEP(int value) {
        this.delstep = value;
    }

    /**
     * Gets the value of the atd property.
     *
     * @return possible object is
     *         {@link XMLGregorianCalendar }
     */
    public XMLGregorianCalendar getATD() {
        return atd;
    }

    /**
     * Sets the value of the atd property.
     *
     * @param value allowed object is
     *              {@link XMLGregorianCalendar }
     */
    public void setATD(XMLGregorianCalendar value) {
        this.atd = value;
    }

    /**
     * Gets the value of the perendday property.
     *
     * @return possible object is
     *         {@link Integer }
     */
    public Integer getPERENDDAY() {
        return perendday;
    }

    /**
     * Sets the value of the perendday property.
     *
     * @param value allowed object is
     *              {@link Integer }
     */
    public void setPERENDDAY(Integer value) {
        this.perendday = value;
    }

    /**
     * Gets the value of the version property.
     */
    public int getVERSION() {
        return version;
    }

    /**
     * Sets the value of the version property.
     */
    public void setVERSION(int value) {
        this.version = value;
    }

    /**
     * Gets the value of the mailservid property.
     *
     * @return possible object is
     *         {@link Long }
     */
    public Long getMAILSERVID() {
        return mailservid;
    }

    /**
     * Sets the value of the mailservid property.
     *
     * @param value allowed object is
     *              {@link Long }
     */
    public void setMAILSERVID(Long value) {
        this.mailservid = value;
    }

    /**
     * Gets the value of the emailservid property.
     *
     * @return possible object is
     *         {@link Long }
     */
    public Long getEMAILSERVID() {
        return emailservid;
    }

    /**
     * Sets the value of the emailservid property.
     *
     * @param value allowed object is
     *              {@link Long }
     */
    public void setEMAILSERVID(Long value) {
        this.emailservid = value;
    }

    /**
     * Gets the value of the transferfromid property.
     *
     * @return possible object is
     *         {@link Long }
     */
    public Long getTRANSFERFROMID() {
        return transferfromid;
    }

    /**
     * Sets the value of the transferfromid property.
     *
     * @param value allowed object is
     *              {@link Long }
     */
    public void setTRANSFERFROMID(Long value) {
        this.transferfromid = value;
    }

}
