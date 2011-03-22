package com.centershift.store40;

import javax.xml.bind.annotation.*;
import javax.xml.datatype.XMLGregorianCalendar;
import java.math.BigDecimal;


/**
 * <p>Java class for ORG_SITE_PCD_AVAIL complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="ORG_SITE_PCD_AVAIL">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.centershift.com/STORE40/}BaseEntityOfCollectionORG_SITE_PCD_AVAILColumnIndexes">
 *       &lt;sequence>
 *         &lt;element name="PAY_LOGIC" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ORG_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="SITE_ID" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="PCD_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="PCD_REV_CAT" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="PCD_CLASS" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="PCD_NAME" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PCD_DESC" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PCD_AMT_MAX" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="PCD_AMT_MIN" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="PCD_AMT_DEFAULT" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="DISP_AMT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AMT_TYPE" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="ACTIVE" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="STARTS" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="EXPIRES" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="CREDIT_LEVEL" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="LIMIT_ACTION" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="LIMIT_TYPE" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="REASON_PROMPT" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="DELINQUENCY_LIMIT" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="PAYMENT_REQUIRED" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="PCD_PERIODS" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="LOS_REQ" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ORG_SITE_PCD_AVAIL", propOrder = {
        "paylogic",
        "orgid",
        "siteid",
        "pcdid",
        "pcdrevcat",
        "pcdclass",
        "pcdname",
        "pcddesc",
        "pcdamtmax",
        "pcdamtmin",
        "pcdamtdefault",
        "dispamt",
        "amttype",
        "active",
        "starts",
        "expires",
        "creditlevel",
        "limitaction",
        "limittype",
        "reasonprompt",
        "delinquencylimit",
        "paymentrequired",
        "pcdperiods",
        "losreq"
})
public class ORGSITEPCDAVAIL
        extends BaseEntityOfCollectionORGSITEPCDAVAILColumnIndexes {

    @XmlElement(name = "PAY_LOGIC")
    protected String paylogic;
    @XmlElement(name = "ORG_ID", required = true, type = Long.class, nillable = true)
    protected Long orgid;
    @XmlElement(name = "SITE_ID", required = true, nillable = true)
    protected BigDecimal siteid;
    @XmlElement(name = "PCD_ID", required = true, type = Long.class, nillable = true)
    protected Long pcdid;
    @XmlElement(name = "PCD_REV_CAT", required = true, type = Integer.class, nillable = true)
    protected Integer pcdrevcat;
    @XmlElement(name = "PCD_CLASS", required = true, type = Integer.class, nillable = true)
    protected Integer pcdclass;
    @XmlElement(name = "PCD_NAME")
    protected String pcdname;
    @XmlElement(name = "PCD_DESC")
    protected String pcddesc;
    @XmlElement(name = "PCD_AMT_MAX", required = true, nillable = true)
    protected BigDecimal pcdamtmax;
    @XmlElement(name = "PCD_AMT_MIN", required = true, nillable = true)
    protected BigDecimal pcdamtmin;
    @XmlElement(name = "PCD_AMT_DEFAULT", required = true, nillable = true)
    protected BigDecimal pcdamtdefault;
    @XmlElement(name = "DISP_AMT")
    protected String dispamt;
    @XmlElement(name = "AMT_TYPE", required = true, type = Integer.class, nillable = true)
    protected Integer amttype;
    @XmlElement(name = "ACTIVE", required = true, type = Boolean.class, nillable = true)
    protected Boolean active;
    @XmlElement(name = "STARTS", required = true, nillable = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar starts;
    @XmlElement(name = "EXPIRES", required = true, nillable = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar expires;
    @XmlElement(name = "CREDIT_LEVEL", required = true, type = Integer.class, nillable = true)
    protected Integer creditlevel;
    @XmlElement(name = "LIMIT_ACTION", required = true, type = Integer.class, nillable = true)
    protected Integer limitaction;
    @XmlElement(name = "LIMIT_TYPE", required = true, type = Integer.class, nillable = true)
    protected Integer limittype;
    @XmlElement(name = "REASON_PROMPT", required = true, type = Integer.class, nillable = true)
    protected Integer reasonprompt;
    @XmlElement(name = "DELINQUENCY_LIMIT", required = true, type = Integer.class, nillable = true)
    protected Integer delinquencylimit;
    @XmlElement(name = "PAYMENT_REQUIRED", required = true, type = Boolean.class, nillable = true)
    protected Boolean paymentrequired;
    @XmlElement(name = "PCD_PERIODS", required = true, type = Integer.class, nillable = true)
    protected Integer pcdperiods;
    @XmlElement(name = "LOS_REQ", required = true, nillable = true)
    protected BigDecimal losreq;

    /**
     * Gets the value of the paylogic property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getPAYLOGIC() {
        return paylogic;
    }

    /**
     * Sets the value of the paylogic property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setPAYLOGIC(String value) {
        this.paylogic = value;
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
     *         {@link BigDecimal }
     */
    public BigDecimal getSITEID() {
        return siteid;
    }

    /**
     * Sets the value of the siteid property.
     *
     * @param value allowed object is
     *              {@link BigDecimal }
     */
    public void setSITEID(BigDecimal value) {
        this.siteid = value;
    }

    /**
     * Gets the value of the pcdid property.
     *
     * @return possible object is
     *         {@link Long }
     */
    public Long getPCDID() {
        return pcdid;
    }

    /**
     * Sets the value of the pcdid property.
     *
     * @param value allowed object is
     *              {@link Long }
     */
    public void setPCDID(Long value) {
        this.pcdid = value;
    }

    /**
     * Gets the value of the pcdrevcat property.
     *
     * @return possible object is
     *         {@link Integer }
     */
    public Integer getPCDREVCAT() {
        return pcdrevcat;
    }

    /**
     * Sets the value of the pcdrevcat property.
     *
     * @param value allowed object is
     *              {@link Integer }
     */
    public void setPCDREVCAT(Integer value) {
        this.pcdrevcat = value;
    }

    /**
     * Gets the value of the pcdclass property.
     *
     * @return possible object is
     *         {@link Integer }
     */
    public Integer getPCDCLASS() {
        return pcdclass;
    }

    /**
     * Sets the value of the pcdclass property.
     *
     * @param value allowed object is
     *              {@link Integer }
     */
    public void setPCDCLASS(Integer value) {
        this.pcdclass = value;
    }

    /**
     * Gets the value of the pcdname property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getPCDNAME() {
        return pcdname;
    }

    /**
     * Sets the value of the pcdname property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setPCDNAME(String value) {
        this.pcdname = value;
    }

    /**
     * Gets the value of the pcddesc property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getPCDDESC() {
        return pcddesc;
    }

    /**
     * Sets the value of the pcddesc property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setPCDDESC(String value) {
        this.pcddesc = value;
    }

    /**
     * Gets the value of the pcdamtmax property.
     *
     * @return possible object is
     *         {@link BigDecimal }
     */
    public BigDecimal getPCDAMTMAX() {
        return pcdamtmax;
    }

    /**
     * Sets the value of the pcdamtmax property.
     *
     * @param value allowed object is
     *              {@link BigDecimal }
     */
    public void setPCDAMTMAX(BigDecimal value) {
        this.pcdamtmax = value;
    }

    /**
     * Gets the value of the pcdamtmin property.
     *
     * @return possible object is
     *         {@link BigDecimal }
     */
    public BigDecimal getPCDAMTMIN() {
        return pcdamtmin;
    }

    /**
     * Sets the value of the pcdamtmin property.
     *
     * @param value allowed object is
     *              {@link BigDecimal }
     */
    public void setPCDAMTMIN(BigDecimal value) {
        this.pcdamtmin = value;
    }

    /**
     * Gets the value of the pcdamtdefault property.
     *
     * @return possible object is
     *         {@link BigDecimal }
     */
    public BigDecimal getPCDAMTDEFAULT() {
        return pcdamtdefault;
    }

    /**
     * Sets the value of the pcdamtdefault property.
     *
     * @param value allowed object is
     *              {@link BigDecimal }
     */
    public void setPCDAMTDEFAULT(BigDecimal value) {
        this.pcdamtdefault = value;
    }

    /**
     * Gets the value of the dispamt property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getDISPAMT() {
        return dispamt;
    }

    /**
     * Sets the value of the dispamt property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setDISPAMT(String value) {
        this.dispamt = value;
    }

    /**
     * Gets the value of the amttype property.
     *
     * @return possible object is
     *         {@link Integer }
     */
    public Integer getAMTTYPE() {
        return amttype;
    }

    /**
     * Sets the value of the amttype property.
     *
     * @param value allowed object is
     *              {@link Integer }
     */
    public void setAMTTYPE(Integer value) {
        this.amttype = value;
    }

    /**
     * Gets the value of the active property.
     *
     * @return possible object is
     *         {@link Boolean }
     */
    public Boolean isACTIVE() {
        return active;
    }

    /**
     * Sets the value of the active property.
     *
     * @param value allowed object is
     *              {@link Boolean }
     */
    public void setACTIVE(Boolean value) {
        this.active = value;
    }

    /**
     * Gets the value of the starts property.
     *
     * @return possible object is
     *         {@link XMLGregorianCalendar }
     */
    public XMLGregorianCalendar getSTARTS() {
        return starts;
    }

    /**
     * Sets the value of the starts property.
     *
     * @param value allowed object is
     *              {@link XMLGregorianCalendar }
     */
    public void setSTARTS(XMLGregorianCalendar value) {
        this.starts = value;
    }

    /**
     * Gets the value of the expires property.
     *
     * @return possible object is
     *         {@link XMLGregorianCalendar }
     */
    public XMLGregorianCalendar getEXPIRES() {
        return expires;
    }

    /**
     * Sets the value of the expires property.
     *
     * @param value allowed object is
     *              {@link XMLGregorianCalendar }
     */
    public void setEXPIRES(XMLGregorianCalendar value) {
        this.expires = value;
    }

    /**
     * Gets the value of the creditlevel property.
     *
     * @return possible object is
     *         {@link Integer }
     */
    public Integer getCREDITLEVEL() {
        return creditlevel;
    }

    /**
     * Sets the value of the creditlevel property.
     *
     * @param value allowed object is
     *              {@link Integer }
     */
    public void setCREDITLEVEL(Integer value) {
        this.creditlevel = value;
    }

    /**
     * Gets the value of the limitaction property.
     *
     * @return possible object is
     *         {@link Integer }
     */
    public Integer getLIMITACTION() {
        return limitaction;
    }

    /**
     * Sets the value of the limitaction property.
     *
     * @param value allowed object is
     *              {@link Integer }
     */
    public void setLIMITACTION(Integer value) {
        this.limitaction = value;
    }

    /**
     * Gets the value of the limittype property.
     *
     * @return possible object is
     *         {@link Integer }
     */
    public Integer getLIMITTYPE() {
        return limittype;
    }

    /**
     * Sets the value of the limittype property.
     *
     * @param value allowed object is
     *              {@link Integer }
     */
    public void setLIMITTYPE(Integer value) {
        this.limittype = value;
    }

    /**
     * Gets the value of the reasonprompt property.
     *
     * @return possible object is
     *         {@link Integer }
     */
    public Integer getREASONPROMPT() {
        return reasonprompt;
    }

    /**
     * Sets the value of the reasonprompt property.
     *
     * @param value allowed object is
     *              {@link Integer }
     */
    public void setREASONPROMPT(Integer value) {
        this.reasonprompt = value;
    }

    /**
     * Gets the value of the delinquencylimit property.
     *
     * @return possible object is
     *         {@link Integer }
     */
    public Integer getDELINQUENCYLIMIT() {
        return delinquencylimit;
    }

    /**
     * Sets the value of the delinquencylimit property.
     *
     * @param value allowed object is
     *              {@link Integer }
     */
    public void setDELINQUENCYLIMIT(Integer value) {
        this.delinquencylimit = value;
    }

    /**
     * Gets the value of the paymentrequired property.
     *
     * @return possible object is
     *         {@link Boolean }
     */
    public Boolean isPAYMENTREQUIRED() {
        return paymentrequired;
    }

    /**
     * Sets the value of the paymentrequired property.
     *
     * @param value allowed object is
     *              {@link Boolean }
     */
    public void setPAYMENTREQUIRED(Boolean value) {
        this.paymentrequired = value;
    }

    /**
     * Gets the value of the pcdperiods property.
     *
     * @return possible object is
     *         {@link Integer }
     */
    public Integer getPCDPERIODS() {
        return pcdperiods;
    }

    /**
     * Sets the value of the pcdperiods property.
     *
     * @param value allowed object is
     *              {@link Integer }
     */
    public void setPCDPERIODS(Integer value) {
        this.pcdperiods = value;
    }

    /**
     * Gets the value of the losreq property.
     *
     * @return possible object is
     *         {@link BigDecimal }
     */
    public BigDecimal getLOSREQ() {
        return losreq;
    }

    /**
     * Sets the value of the losreq property.
     *
     * @param value allowed object is
     *              {@link BigDecimal }
     */
    public void setLOSREQ(BigDecimal value) {
        this.losreq = value;
    }

}
