
package com.centershift.store40;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for AddUpdatePCD_Request complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AddUpdatePCD_Request">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ORG_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="PCD_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="ACTIVE" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="ALL_SITES" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="AMT_TYPE" type="{http://www.centershift.com/STORE40/}PcdAmountType"/>
 *         &lt;element name="BARCODE" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="COUPON_CODE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CREDIT_LEVEL" type="{http://www.centershift.com/STORE40/}PcdCreditLevels"/>
 *         &lt;element name="DELINQUENCY_LIMIT" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="EXPIRES" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="LIMIT_ACTION" type="{http://www.centershift.com/STORE40/}PcdLimitApplicability"/>
 *         &lt;element name="LIMIT_TYPE" type="{http://www.centershift.com/STORE40/}PcdLimitType"/>
 *         &lt;element name="LOS_REQ" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="PAYMENT_REQUIRED" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="PCD_AMT_DEFAULT" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="PCD_AMT_MAX" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="PCD_AMT_MIN" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="PCD_CLASS" type="{http://www.centershift.com/STORE40/}PcdClass"/>
 *         &lt;element name="PCD_DESC" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PCD_NAME" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PCD_PERIODS" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="PCD_PRIORITY" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="PCD_REV_CAT" type="{http://www.centershift.com/STORE40/}PcdRevenueCategory"/>
 *         &lt;element name="PCD_START_PERIOD" type="{http://www.centershift.com/STORE40/}PcdStartPeriod"/>
 *         &lt;element name="REASON_PROMPT" type="{http://www.centershift.com/STORE40/}PcdReasonPrompt"/>
 *         &lt;element name="ROLLOVER" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="STARTS" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="TRANSFERABLE" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AddUpdatePCD_Request", propOrder = {
    "orgid",
    "pcdid",
    "active",
    "allsites",
    "amttype",
    "barcode",
    "couponcode",
    "creditlevel",
    "delinquencylimit",
    "expires",
    "limitaction",
    "limittype",
    "losreq",
    "paymentrequired",
    "pcdamtdefault",
    "pcdamtmax",
    "pcdamtmin",
    "pcdclass",
    "pcddesc",
    "pcdname",
    "pcdperiods",
    "pcdpriority",
    "pcdrevcat",
    "pcdstartperiod",
    "reasonprompt",
    "rollover",
    "starts",
    "transferable"
})
public class AddUpdatePCDRequest {

    @XmlElement(name = "ORG_ID")
    protected long orgid;
    @XmlElement(name = "PCD_ID", required = true, type = Long.class, nillable = true)
    protected Long pcdid;
    @XmlElement(name = "ACTIVE", required = true, type = Boolean.class, nillable = true)
    protected Boolean active;
    @XmlElement(name = "ALL_SITES", required = true, type = Boolean.class, nillable = true)
    protected Boolean allsites;
    @XmlElement(name = "AMT_TYPE", required = true, nillable = true)
    protected PcdAmountType amttype;
    @XmlElement(name = "BARCODE", required = true, type = Long.class, nillable = true)
    protected Long barcode;
    @XmlElement(name = "COUPON_CODE")
    protected String couponcode;
    @XmlElement(name = "CREDIT_LEVEL", required = true, nillable = true)
    protected PcdCreditLevels creditlevel;
    @XmlElement(name = "DELINQUENCY_LIMIT", required = true, type = Integer.class, nillable = true)
    protected Integer delinquencylimit;
    @XmlElement(name = "EXPIRES", required = true, nillable = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar expires;
    @XmlElement(name = "LIMIT_ACTION", required = true, nillable = true)
    protected PcdLimitApplicability limitaction;
    @XmlElement(name = "LIMIT_TYPE", required = true, nillable = true)
    protected PcdLimitType limittype;
    @XmlElement(name = "LOS_REQ", required = true, nillable = true)
    protected BigDecimal losreq;
    @XmlElement(name = "PAYMENT_REQUIRED", required = true, type = Boolean.class, nillable = true)
    protected Boolean paymentrequired;
    @XmlElement(name = "PCD_AMT_DEFAULT", required = true, nillable = true)
    protected BigDecimal pcdamtdefault;
    @XmlElement(name = "PCD_AMT_MAX", required = true, nillable = true)
    protected BigDecimal pcdamtmax;
    @XmlElement(name = "PCD_AMT_MIN", required = true, nillable = true)
    protected BigDecimal pcdamtmin;
    @XmlElement(name = "PCD_CLASS", required = true, nillable = true)
    protected PcdClass pcdclass;
    @XmlElement(name = "PCD_DESC")
    protected String pcddesc;
    @XmlElement(name = "PCD_NAME")
    protected String pcdname;
    @XmlElement(name = "PCD_PERIODS", required = true, type = Integer.class, nillable = true)
    protected Integer pcdperiods;
    @XmlElement(name = "PCD_PRIORITY", required = true, type = Integer.class, nillable = true)
    protected Integer pcdpriority;
    @XmlElement(name = "PCD_REV_CAT", required = true, nillable = true)
    protected PcdRevenueCategory pcdrevcat;
    @XmlElement(name = "PCD_START_PERIOD", required = true, nillable = true)
    protected PcdStartPeriod pcdstartperiod;
    @XmlElement(name = "REASON_PROMPT", required = true, nillable = true)
    protected PcdReasonPrompt reasonprompt;
    @XmlElement(name = "ROLLOVER", required = true, type = Boolean.class, nillable = true)
    protected Boolean rollover;
    @XmlElement(name = "STARTS", required = true, nillable = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar starts;
    @XmlElement(name = "TRANSFERABLE", required = true, type = Boolean.class, nillable = true)
    protected Boolean transferable;

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
     * Gets the value of the pcdid property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getPCDID() {
        return pcdid;
    }

    /**
     * Sets the value of the pcdid property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setPCDID(Long value) {
        this.pcdid = value;
    }

    /**
     * Gets the value of the active property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isACTIVE() {
        return active;
    }

    /**
     * Sets the value of the active property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setACTIVE(Boolean value) {
        this.active = value;
    }

    /**
     * Gets the value of the allsites property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isALLSITES() {
        return allsites;
    }

    /**
     * Sets the value of the allsites property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setALLSITES(Boolean value) {
        this.allsites = value;
    }

    /**
     * Gets the value of the amttype property.
     * 
     * @return
     *     possible object is
     *     {@link PcdAmountType }
     *     
     */
    public PcdAmountType getAMTTYPE() {
        return amttype;
    }

    /**
     * Sets the value of the amttype property.
     * 
     * @param value
     *     allowed object is
     *     {@link PcdAmountType }
     *     
     */
    public void setAMTTYPE(PcdAmountType value) {
        this.amttype = value;
    }

    /**
     * Gets the value of the barcode property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getBARCODE() {
        return barcode;
    }

    /**
     * Sets the value of the barcode property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setBARCODE(Long value) {
        this.barcode = value;
    }

    /**
     * Gets the value of the couponcode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCOUPONCODE() {
        return couponcode;
    }

    /**
     * Sets the value of the couponcode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCOUPONCODE(String value) {
        this.couponcode = value;
    }

    /**
     * Gets the value of the creditlevel property.
     * 
     * @return
     *     possible object is
     *     {@link PcdCreditLevels }
     *     
     */
    public PcdCreditLevels getCREDITLEVEL() {
        return creditlevel;
    }

    /**
     * Sets the value of the creditlevel property.
     * 
     * @param value
     *     allowed object is
     *     {@link PcdCreditLevels }
     *     
     */
    public void setCREDITLEVEL(PcdCreditLevels value) {
        this.creditlevel = value;
    }

    /**
     * Gets the value of the delinquencylimit property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getDELINQUENCYLIMIT() {
        return delinquencylimit;
    }

    /**
     * Sets the value of the delinquencylimit property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setDELINQUENCYLIMIT(Integer value) {
        this.delinquencylimit = value;
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
     * Gets the value of the limitaction property.
     * 
     * @return
     *     possible object is
     *     {@link PcdLimitApplicability }
     *     
     */
    public PcdLimitApplicability getLIMITACTION() {
        return limitaction;
    }

    /**
     * Sets the value of the limitaction property.
     * 
     * @param value
     *     allowed object is
     *     {@link PcdLimitApplicability }
     *     
     */
    public void setLIMITACTION(PcdLimitApplicability value) {
        this.limitaction = value;
    }

    /**
     * Gets the value of the limittype property.
     * 
     * @return
     *     possible object is
     *     {@link PcdLimitType }
     *     
     */
    public PcdLimitType getLIMITTYPE() {
        return limittype;
    }

    /**
     * Sets the value of the limittype property.
     * 
     * @param value
     *     allowed object is
     *     {@link PcdLimitType }
     *     
     */
    public void setLIMITTYPE(PcdLimitType value) {
        this.limittype = value;
    }

    /**
     * Gets the value of the losreq property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getLOSREQ() {
        return losreq;
    }

    /**
     * Sets the value of the losreq property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setLOSREQ(BigDecimal value) {
        this.losreq = value;
    }

    /**
     * Gets the value of the paymentrequired property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isPAYMENTREQUIRED() {
        return paymentrequired;
    }

    /**
     * Sets the value of the paymentrequired property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setPAYMENTREQUIRED(Boolean value) {
        this.paymentrequired = value;
    }

    /**
     * Gets the value of the pcdamtdefault property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getPCDAMTDEFAULT() {
        return pcdamtdefault;
    }

    /**
     * Sets the value of the pcdamtdefault property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setPCDAMTDEFAULT(BigDecimal value) {
        this.pcdamtdefault = value;
    }

    /**
     * Gets the value of the pcdamtmax property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getPCDAMTMAX() {
        return pcdamtmax;
    }

    /**
     * Sets the value of the pcdamtmax property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setPCDAMTMAX(BigDecimal value) {
        this.pcdamtmax = value;
    }

    /**
     * Gets the value of the pcdamtmin property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getPCDAMTMIN() {
        return pcdamtmin;
    }

    /**
     * Sets the value of the pcdamtmin property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setPCDAMTMIN(BigDecimal value) {
        this.pcdamtmin = value;
    }

    /**
     * Gets the value of the pcdclass property.
     * 
     * @return
     *     possible object is
     *     {@link PcdClass }
     *     
     */
    public PcdClass getPCDCLASS() {
        return pcdclass;
    }

    /**
     * Sets the value of the pcdclass property.
     * 
     * @param value
     *     allowed object is
     *     {@link PcdClass }
     *     
     */
    public void setPCDCLASS(PcdClass value) {
        this.pcdclass = value;
    }

    /**
     * Gets the value of the pcddesc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPCDDESC() {
        return pcddesc;
    }

    /**
     * Sets the value of the pcddesc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPCDDESC(String value) {
        this.pcddesc = value;
    }

    /**
     * Gets the value of the pcdname property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPCDNAME() {
        return pcdname;
    }

    /**
     * Sets the value of the pcdname property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPCDNAME(String value) {
        this.pcdname = value;
    }

    /**
     * Gets the value of the pcdperiods property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getPCDPERIODS() {
        return pcdperiods;
    }

    /**
     * Sets the value of the pcdperiods property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setPCDPERIODS(Integer value) {
        this.pcdperiods = value;
    }

    /**
     * Gets the value of the pcdpriority property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getPCDPRIORITY() {
        return pcdpriority;
    }

    /**
     * Sets the value of the pcdpriority property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setPCDPRIORITY(Integer value) {
        this.pcdpriority = value;
    }

    /**
     * Gets the value of the pcdrevcat property.
     * 
     * @return
     *     possible object is
     *     {@link PcdRevenueCategory }
     *     
     */
    public PcdRevenueCategory getPCDREVCAT() {
        return pcdrevcat;
    }

    /**
     * Sets the value of the pcdrevcat property.
     * 
     * @param value
     *     allowed object is
     *     {@link PcdRevenueCategory }
     *     
     */
    public void setPCDREVCAT(PcdRevenueCategory value) {
        this.pcdrevcat = value;
    }

    /**
     * Gets the value of the pcdstartperiod property.
     * 
     * @return
     *     possible object is
     *     {@link PcdStartPeriod }
     *     
     */
    public PcdStartPeriod getPCDSTARTPERIOD() {
        return pcdstartperiod;
    }

    /**
     * Sets the value of the pcdstartperiod property.
     * 
     * @param value
     *     allowed object is
     *     {@link PcdStartPeriod }
     *     
     */
    public void setPCDSTARTPERIOD(PcdStartPeriod value) {
        this.pcdstartperiod = value;
    }

    /**
     * Gets the value of the reasonprompt property.
     * 
     * @return
     *     possible object is
     *     {@link PcdReasonPrompt }
     *     
     */
    public PcdReasonPrompt getREASONPROMPT() {
        return reasonprompt;
    }

    /**
     * Sets the value of the reasonprompt property.
     * 
     * @param value
     *     allowed object is
     *     {@link PcdReasonPrompt }
     *     
     */
    public void setREASONPROMPT(PcdReasonPrompt value) {
        this.reasonprompt = value;
    }

    /**
     * Gets the value of the rollover property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isROLLOVER() {
        return rollover;
    }

    /**
     * Sets the value of the rollover property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setROLLOVER(Boolean value) {
        this.rollover = value;
    }

    /**
     * Gets the value of the starts property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getSTARTS() {
        return starts;
    }

    /**
     * Sets the value of the starts property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setSTARTS(XMLGregorianCalendar value) {
        this.starts = value;
    }

    /**
     * Gets the value of the transferable property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isTRANSFERABLE() {
        return transferable;
    }

    /**
     * Sets the value of the transferable property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setTRANSFERABLE(Boolean value) {
        this.transferable = value;
    }

}
