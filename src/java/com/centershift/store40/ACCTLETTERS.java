package com.centershift.store40;

import javax.xml.bind.annotation.*;
import javax.xml.datatype.XMLGregorianCalendar;
import java.math.BigDecimal;


/**
 * <p>Java class for ACCT_LETTERS complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="ACCT_LETTERS">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.centershift.com/STORE40/}BaseEntityOfCollectionACCT_LETTERSColumnIndexes">
 *       &lt;sequence>
 *         &lt;element name="ACCT_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="RENTAL_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="CONTACT_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="CNAME" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="UNIT_NUM" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LETTER_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="LTR_NUM" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="LTR_TYPE_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="SCHEDULED" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="LTR_TYPE_VAL" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="LTR_TYPE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LTR_NAME" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="GEN_TYPE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ADR_TYPE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="EMAIL" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="EMAIL_TO" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="EMAIL_SENT" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="EMAIL_STS" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="STS_MEANING" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CERTIFIED" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="PROCESSED_FLAG" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MAILED" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="ACTIVE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="EXPORT_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="VERSION" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="CREATED_BY" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="CREATED_NAME" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="STATUS" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="STATUS_VAL" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="UNIT_NUM_STS" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MAIL_LOCAL" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SENT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ACCT_LETTERS", propOrder = {
        "acctid",
        "rentalid",
        "contactid",
        "cname",
        "unitnum",
        "letterid",
        "ltrnum",
        "ltrtypeid",
        "scheduled",
        "ltrtypeval",
        "ltrtype",
        "ltrname",
        "gentype",
        "adrtype",
        "email",
        "emailto",
        "emailsent",
        "emailsts",
        "stsmeaning",
        "certified",
        "processedflag",
        "mailed",
        "active",
        "exportid",
        "version",
        "createdby",
        "createdname",
        "status",
        "statusval",
        "unitnumsts",
        "maillocal",
        "sent"
})
public class ACCTLETTERS
        extends BaseEntityOfCollectionACCTLETTERSColumnIndexes {

    @XmlElement(name = "ACCT_ID")
    protected long acctid;
    @XmlElement(name = "RENTAL_ID", required = true, type = Long.class, nillable = true)
    protected Long rentalid;
    @XmlElement(name = "CONTACT_ID", required = true, type = Long.class, nillable = true)
    protected Long contactid;
    @XmlElement(name = "CNAME")
    protected String cname;
    @XmlElement(name = "UNIT_NUM")
    protected String unitnum;
    @XmlElement(name = "LETTER_ID")
    protected long letterid;
    @XmlElement(name = "LTR_NUM")
    protected long ltrnum;
    @XmlElement(name = "LTR_TYPE_ID")
    protected long ltrtypeid;
    @XmlElement(name = "SCHEDULED", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar scheduled;
    @XmlElement(name = "LTR_TYPE_VAL")
    protected int ltrtypeval;
    @XmlElement(name = "LTR_TYPE")
    protected String ltrtype;
    @XmlElement(name = "LTR_NAME")
    protected String ltrname;
    @XmlElement(name = "GEN_TYPE")
    protected String gentype;
    @XmlElement(name = "ADR_TYPE")
    protected String adrtype;
    @XmlElement(name = "EMAIL")
    protected boolean email;
    @XmlElement(name = "EMAIL_TO")
    protected String emailto;
    @XmlElement(name = "EMAIL_SENT", required = true, nillable = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar emailsent;
    @XmlElement(name = "EMAIL_STS", required = true, nillable = true)
    protected BigDecimal emailsts;
    @XmlElement(name = "STS_MEANING")
    protected String stsmeaning;
    @XmlElement(name = "CERTIFIED")
    protected boolean certified;
    @XmlElement(name = "PROCESSED_FLAG")
    protected String processedflag;
    @XmlElement(name = "MAILED", required = true, nillable = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar mailed;
    @XmlElement(name = "ACTIVE")
    protected String active;
    @XmlElement(name = "EXPORT_ID", required = true, type = Long.class, nillable = true)
    protected Long exportid;
    @XmlElement(name = "VERSION")
    protected int version;
    @XmlElement(name = "CREATED_BY")
    protected long createdby;
    @XmlElement(name = "CREATED_NAME")
    protected String createdname;
    @XmlElement(name = "STATUS", required = true, type = Boolean.class, nillable = true)
    protected Boolean status;
    @XmlElement(name = "STATUS_VAL")
    protected String statusval;
    @XmlElement(name = "UNIT_NUM_STS")
    protected String unitnumsts;
    @XmlElement(name = "MAIL_LOCAL")
    protected String maillocal;
    @XmlElement(name = "SENT")
    protected String sent;

    /**
     * Gets the value of the acctid property.
     */
    public long getACCTID() {
        return acctid;
    }

    /**
     * Sets the value of the acctid property.
     */
    public void setACCTID(long value) {
        this.acctid = value;
    }

    /**
     * Gets the value of the rentalid property.
     *
     * @return possible object is
     *         {@link Long }
     */
    public Long getRENTALID() {
        return rentalid;
    }

    /**
     * Sets the value of the rentalid property.
     *
     * @param value allowed object is
     *              {@link Long }
     */
    public void setRENTALID(Long value) {
        this.rentalid = value;
    }

    /**
     * Gets the value of the contactid property.
     *
     * @return possible object is
     *         {@link Long }
     */
    public Long getCONTACTID() {
        return contactid;
    }

    /**
     * Sets the value of the contactid property.
     *
     * @param value allowed object is
     *              {@link Long }
     */
    public void setCONTACTID(Long value) {
        this.contactid = value;
    }

    /**
     * Gets the value of the cname property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getCNAME() {
        return cname;
    }

    /**
     * Sets the value of the cname property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setCNAME(String value) {
        this.cname = value;
    }

    /**
     * Gets the value of the unitnum property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getUNITNUM() {
        return unitnum;
    }

    /**
     * Sets the value of the unitnum property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setUNITNUM(String value) {
        this.unitnum = value;
    }

    /**
     * Gets the value of the letterid property.
     */
    public long getLETTERID() {
        return letterid;
    }

    /**
     * Sets the value of the letterid property.
     */
    public void setLETTERID(long value) {
        this.letterid = value;
    }

    /**
     * Gets the value of the ltrnum property.
     */
    public long getLTRNUM() {
        return ltrnum;
    }

    /**
     * Sets the value of the ltrnum property.
     */
    public void setLTRNUM(long value) {
        this.ltrnum = value;
    }

    /**
     * Gets the value of the ltrtypeid property.
     */
    public long getLTRTYPEID() {
        return ltrtypeid;
    }

    /**
     * Sets the value of the ltrtypeid property.
     */
    public void setLTRTYPEID(long value) {
        this.ltrtypeid = value;
    }

    /**
     * Gets the value of the scheduled property.
     *
     * @return possible object is
     *         {@link XMLGregorianCalendar }
     */
    public XMLGregorianCalendar getSCHEDULED() {
        return scheduled;
    }

    /**
     * Sets the value of the scheduled property.
     *
     * @param value allowed object is
     *              {@link XMLGregorianCalendar }
     */
    public void setSCHEDULED(XMLGregorianCalendar value) {
        this.scheduled = value;
    }

    /**
     * Gets the value of the ltrtypeval property.
     */
    public int getLTRTYPEVAL() {
        return ltrtypeval;
    }

    /**
     * Sets the value of the ltrtypeval property.
     */
    public void setLTRTYPEVAL(int value) {
        this.ltrtypeval = value;
    }

    /**
     * Gets the value of the ltrtype property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getLTRTYPE() {
        return ltrtype;
    }

    /**
     * Sets the value of the ltrtype property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setLTRTYPE(String value) {
        this.ltrtype = value;
    }

    /**
     * Gets the value of the ltrname property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getLTRNAME() {
        return ltrname;
    }

    /**
     * Sets the value of the ltrname property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setLTRNAME(String value) {
        this.ltrname = value;
    }

    /**
     * Gets the value of the gentype property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getGENTYPE() {
        return gentype;
    }

    /**
     * Sets the value of the gentype property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setGENTYPE(String value) {
        this.gentype = value;
    }

    /**
     * Gets the value of the adrtype property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getADRTYPE() {
        return adrtype;
    }

    /**
     * Sets the value of the adrtype property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setADRTYPE(String value) {
        this.adrtype = value;
    }

    /**
     * Gets the value of the email property.
     */
    public boolean isEMAIL() {
        return email;
    }

    /**
     * Sets the value of the email property.
     */
    public void setEMAIL(boolean value) {
        this.email = value;
    }

    /**
     * Gets the value of the emailto property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getEMAILTO() {
        return emailto;
    }

    /**
     * Sets the value of the emailto property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setEMAILTO(String value) {
        this.emailto = value;
    }

    /**
     * Gets the value of the emailsent property.
     *
     * @return possible object is
     *         {@link XMLGregorianCalendar }
     */
    public XMLGregorianCalendar getEMAILSENT() {
        return emailsent;
    }

    /**
     * Sets the value of the emailsent property.
     *
     * @param value allowed object is
     *              {@link XMLGregorianCalendar }
     */
    public void setEMAILSENT(XMLGregorianCalendar value) {
        this.emailsent = value;
    }

    /**
     * Gets the value of the emailsts property.
     *
     * @return possible object is
     *         {@link BigDecimal }
     */
    public BigDecimal getEMAILSTS() {
        return emailsts;
    }

    /**
     * Sets the value of the emailsts property.
     *
     * @param value allowed object is
     *              {@link BigDecimal }
     */
    public void setEMAILSTS(BigDecimal value) {
        this.emailsts = value;
    }

    /**
     * Gets the value of the stsmeaning property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getSTSMEANING() {
        return stsmeaning;
    }

    /**
     * Sets the value of the stsmeaning property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setSTSMEANING(String value) {
        this.stsmeaning = value;
    }

    /**
     * Gets the value of the certified property.
     */
    public boolean isCERTIFIED() {
        return certified;
    }

    /**
     * Sets the value of the certified property.
     */
    public void setCERTIFIED(boolean value) {
        this.certified = value;
    }

    /**
     * Gets the value of the processedflag property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getPROCESSEDFLAG() {
        return processedflag;
    }

    /**
     * Sets the value of the processedflag property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setPROCESSEDFLAG(String value) {
        this.processedflag = value;
    }

    /**
     * Gets the value of the mailed property.
     *
     * @return possible object is
     *         {@link XMLGregorianCalendar }
     */
    public XMLGregorianCalendar getMAILED() {
        return mailed;
    }

    /**
     * Sets the value of the mailed property.
     *
     * @param value allowed object is
     *              {@link XMLGregorianCalendar }
     */
    public void setMAILED(XMLGregorianCalendar value) {
        this.mailed = value;
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
     * Gets the value of the exportid property.
     *
     * @return possible object is
     *         {@link Long }
     */
    public Long getEXPORTID() {
        return exportid;
    }

    /**
     * Sets the value of the exportid property.
     *
     * @param value allowed object is
     *              {@link Long }
     */
    public void setEXPORTID(Long value) {
        this.exportid = value;
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
     * Gets the value of the createdname property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getCREATEDNAME() {
        return createdname;
    }

    /**
     * Sets the value of the createdname property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setCREATEDNAME(String value) {
        this.createdname = value;
    }

    /**
     * Gets the value of the status property.
     *
     * @return possible object is
     *         {@link Boolean }
     */
    public Boolean isSTATUS() {
        return status;
    }

    /**
     * Sets the value of the status property.
     *
     * @param value allowed object is
     *              {@link Boolean }
     */
    public void setSTATUS(Boolean value) {
        this.status = value;
    }

    /**
     * Gets the value of the statusval property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getSTATUSVAL() {
        return statusval;
    }

    /**
     * Sets the value of the statusval property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setSTATUSVAL(String value) {
        this.statusval = value;
    }

    /**
     * Gets the value of the unitnumsts property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getUNITNUMSTS() {
        return unitnumsts;
    }

    /**
     * Sets the value of the unitnumsts property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setUNITNUMSTS(String value) {
        this.unitnumsts = value;
    }

    /**
     * Gets the value of the maillocal property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getMAILLOCAL() {
        return maillocal;
    }

    /**
     * Sets the value of the maillocal property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setMAILLOCAL(String value) {
        this.maillocal = value;
    }

    /**
     * Gets the value of the sent property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getSENT() {
        return sent;
    }

    /**
     * Sets the value of the sent property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setSENT(String value) {
        this.sent = value;
    }

}
