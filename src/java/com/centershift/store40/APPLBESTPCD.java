
package com.centershift.store40;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for APPL_BEST_PCD complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="APPL_BEST_PCD">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.centershift.com/STORE40/}BaseEntityOfCollectionAPPL_BEST_PCDColumnIndexes">
 *       &lt;sequence>
 *         &lt;element name="LIMIT_TYPE_VAL" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DELINQUENCY_LIMIT" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="PCD_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="ORG_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="PCD_NAME" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PCD_DESC" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PCD_REV_CAT" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="PCD_REV_CAT_VAL" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PCD_CLASS" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="PCD_CLASS_VAL" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ALL_SITES" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="STARTS" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="EXPIRES" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="PCD_AMT_MAX" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="PCD_AMT_MIN" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="PCD_AMT_DEFAULT" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="PCD_PERIODS" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="AMT_TYPE" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="AMT_TYPE_VAL" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="COUPON_CODE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BARCODE" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="TRANSFERABLE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PAYMENT_REQUIRED" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LOS_REQ" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="LOS_PREPAID" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="LOS_PENALTY" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="LOS_PENALTY_TYPE" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="LOS_PENALTY_TYPE_VAL" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CREDIT_LEVEL" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="CREDIT_LEVEL_VAL" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PCD_PRIORITY" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="LIMIT_ACTION" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="LIMIT_ACTION_VAL" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LIMIT_TYPE" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "APPL_BEST_PCD", propOrder = {
    "limittypeval",
    "delinquencylimit",
    "pcdid",
    "orgid",
    "pcdname",
    "pcddesc",
    "pcdrevcat",
    "pcdrevcatval",
    "pcdclass",
    "pcdclassval",
    "allsites",
    "starts",
    "expires",
    "pcdamtmax",
    "pcdamtmin",
    "pcdamtdefault",
    "pcdperiods",
    "amttype",
    "amttypeval",
    "couponcode",
    "barcode",
    "transferable",
    "paymentrequired",
    "losreq",
    "losprepaid",
    "lospenalty",
    "lospenaltytype",
    "lospenaltytypeval",
    "creditlevel",
    "creditlevelval",
    "pcdpriority",
    "limitaction",
    "limitactionval",
    "limittype"
})
public class APPLBESTPCD
    extends BaseEntityOfCollectionAPPLBESTPCDColumnIndexes
{

    @XmlElement(name = "LIMIT_TYPE_VAL")
    protected String limittypeval;
    @XmlElement(name = "DELINQUENCY_LIMIT")
    protected int delinquencylimit;
    @XmlElement(name = "PCD_ID")
    protected long pcdid;
    @XmlElement(name = "ORG_ID")
    protected long orgid;
    @XmlElement(name = "PCD_NAME")
    protected String pcdname;
    @XmlElement(name = "PCD_DESC")
    protected String pcddesc;
    @XmlElement(name = "PCD_REV_CAT", required = true, type = Integer.class, nillable = true)
    protected Integer pcdrevcat;
    @XmlElement(name = "PCD_REV_CAT_VAL")
    protected String pcdrevcatval;
    @XmlElement(name = "PCD_CLASS", required = true, type = Integer.class, nillable = true)
    protected Integer pcdclass;
    @XmlElement(name = "PCD_CLASS_VAL")
    protected String pcdclassval;
    @XmlElement(name = "ALL_SITES")
    protected String allsites;
    @XmlElement(name = "STARTS", required = true, nillable = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar starts;
    @XmlElement(name = "EXPIRES", required = true, nillable = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar expires;
    @XmlElement(name = "PCD_AMT_MAX", required = true)
    protected BigDecimal pcdamtmax;
    @XmlElement(name = "PCD_AMT_MIN", required = true)
    protected BigDecimal pcdamtmin;
    @XmlElement(name = "PCD_AMT_DEFAULT", required = true)
    protected BigDecimal pcdamtdefault;
    @XmlElement(name = "PCD_PERIODS")
    protected int pcdperiods;
    @XmlElement(name = "AMT_TYPE", required = true, type = Integer.class, nillable = true)
    protected Integer amttype;
    @XmlElement(name = "AMT_TYPE_VAL")
    protected String amttypeval;
    @XmlElement(name = "COUPON_CODE")
    protected String couponcode;
    @XmlElement(name = "BARCODE", required = true, type = Long.class, nillable = true)
    protected Long barcode;
    @XmlElement(name = "TRANSFERABLE")
    protected String transferable;
    @XmlElement(name = "PAYMENT_REQUIRED")
    protected String paymentrequired;
    @XmlElement(name = "LOS_REQ", required = true, nillable = true)
    protected BigDecimal losreq;
    @XmlElement(name = "LOS_PREPAID", required = true, nillable = true)
    protected BigDecimal losprepaid;
    @XmlElement(name = "LOS_PENALTY", required = true, nillable = true)
    protected BigDecimal lospenalty;
    @XmlElement(name = "LOS_PENALTY_TYPE", required = true, type = Integer.class, nillable = true)
    protected Integer lospenaltytype;
    @XmlElement(name = "LOS_PENALTY_TYPE_VAL")
    protected String lospenaltytypeval;
    @XmlElement(name = "CREDIT_LEVEL", required = true, type = Integer.class, nillable = true)
    protected Integer creditlevel;
    @XmlElement(name = "CREDIT_LEVEL_VAL")
    protected String creditlevelval;
    @XmlElement(name = "PCD_PRIORITY", required = true, type = Integer.class, nillable = true)
    protected Integer pcdpriority;
    @XmlElement(name = "LIMIT_ACTION", required = true, type = Integer.class, nillable = true)
    protected Integer limitaction;
    @XmlElement(name = "LIMIT_ACTION_VAL")
    protected String limitactionval;
    @XmlElement(name = "LIMIT_TYPE", required = true, type = Integer.class, nillable = true)
    protected Integer limittype;

    /**
     * Gets the value of the limittypeval property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLIMITTYPEVAL() {
        return limittypeval;
    }

    /**
     * Sets the value of the limittypeval property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLIMITTYPEVAL(String value) {
        this.limittypeval = value;
    }

    /**
     * Gets the value of the delinquencylimit property.
     * 
     */
    public int getDELINQUENCYLIMIT() {
        return delinquencylimit;
    }

    /**
     * Sets the value of the delinquencylimit property.
     * 
     */
    public void setDELINQUENCYLIMIT(int value) {
        this.delinquencylimit = value;
    }

    /**
     * Gets the value of the pcdid property.
     * 
     */
    public long getPCDID() {
        return pcdid;
    }

    /**
     * Sets the value of the pcdid property.
     * 
     */
    public void setPCDID(long value) {
        this.pcdid = value;
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
     * Gets the value of the pcdrevcat property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getPCDREVCAT() {
        return pcdrevcat;
    }

    /**
     * Sets the value of the pcdrevcat property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setPCDREVCAT(Integer value) {
        this.pcdrevcat = value;
    }

    /**
     * Gets the value of the pcdrevcatval property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPCDREVCATVAL() {
        return pcdrevcatval;
    }

    /**
     * Sets the value of the pcdrevcatval property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPCDREVCATVAL(String value) {
        this.pcdrevcatval = value;
    }

    /**
     * Gets the value of the pcdclass property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getPCDCLASS() {
        return pcdclass;
    }

    /**
     * Sets the value of the pcdclass property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setPCDCLASS(Integer value) {
        this.pcdclass = value;
    }

    /**
     * Gets the value of the pcdclassval property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPCDCLASSVAL() {
        return pcdclassval;
    }

    /**
     * Sets the value of the pcdclassval property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPCDCLASSVAL(String value) {
        this.pcdclassval = value;
    }

    /**
     * Gets the value of the allsites property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getALLSITES() {
        return allsites;
    }

    /**
     * Sets the value of the allsites property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setALLSITES(String value) {
        this.allsites = value;
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
     * Gets the value of the pcdperiods property.
     * 
     */
    public int getPCDPERIODS() {
        return pcdperiods;
    }

    /**
     * Sets the value of the pcdperiods property.
     * 
     */
    public void setPCDPERIODS(int value) {
        this.pcdperiods = value;
    }

    /**
     * Gets the value of the amttype property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getAMTTYPE() {
        return amttype;
    }

    /**
     * Sets the value of the amttype property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setAMTTYPE(Integer value) {
        this.amttype = value;
    }

    /**
     * Gets the value of the amttypeval property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAMTTYPEVAL() {
        return amttypeval;
    }

    /**
     * Sets the value of the amttypeval property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAMTTYPEVAL(String value) {
        this.amttypeval = value;
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
     * Gets the value of the transferable property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTRANSFERABLE() {
        return transferable;
    }

    /**
     * Sets the value of the transferable property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTRANSFERABLE(String value) {
        this.transferable = value;
    }

    /**
     * Gets the value of the paymentrequired property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPAYMENTREQUIRED() {
        return paymentrequired;
    }

    /**
     * Sets the value of the paymentrequired property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPAYMENTREQUIRED(String value) {
        this.paymentrequired = value;
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
     * Gets the value of the losprepaid property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getLOSPREPAID() {
        return losprepaid;
    }

    /**
     * Sets the value of the losprepaid property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setLOSPREPAID(BigDecimal value) {
        this.losprepaid = value;
    }

    /**
     * Gets the value of the lospenalty property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getLOSPENALTY() {
        return lospenalty;
    }

    /**
     * Sets the value of the lospenalty property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setLOSPENALTY(BigDecimal value) {
        this.lospenalty = value;
    }

    /**
     * Gets the value of the lospenaltytype property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getLOSPENALTYTYPE() {
        return lospenaltytype;
    }

    /**
     * Sets the value of the lospenaltytype property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setLOSPENALTYTYPE(Integer value) {
        this.lospenaltytype = value;
    }

    /**
     * Gets the value of the lospenaltytypeval property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLOSPENALTYTYPEVAL() {
        return lospenaltytypeval;
    }

    /**
     * Sets the value of the lospenaltytypeval property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLOSPENALTYTYPEVAL(String value) {
        this.lospenaltytypeval = value;
    }

    /**
     * Gets the value of the creditlevel property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getCREDITLEVEL() {
        return creditlevel;
    }

    /**
     * Sets the value of the creditlevel property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setCREDITLEVEL(Integer value) {
        this.creditlevel = value;
    }

    /**
     * Gets the value of the creditlevelval property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCREDITLEVELVAL() {
        return creditlevelval;
    }

    /**
     * Sets the value of the creditlevelval property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCREDITLEVELVAL(String value) {
        this.creditlevelval = value;
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
     * Gets the value of the limitaction property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getLIMITACTION() {
        return limitaction;
    }

    /**
     * Sets the value of the limitaction property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setLIMITACTION(Integer value) {
        this.limitaction = value;
    }

    /**
     * Gets the value of the limitactionval property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLIMITACTIONVAL() {
        return limitactionval;
    }

    /**
     * Sets the value of the limitactionval property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLIMITACTIONVAL(String value) {
        this.limitactionval = value;
    }

    /**
     * Gets the value of the limittype property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getLIMITTYPE() {
        return limittype;
    }

    /**
     * Sets the value of the limittype property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setLIMITTYPE(Integer value) {
        this.limittype = value;
    }

}
