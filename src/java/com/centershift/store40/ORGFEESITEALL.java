
package com.centershift.store40;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ORG_FEE_SITE_ALL complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ORG_FEE_SITE_ALL">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.centershift.com/STORE40/}BaseEntityOfCollectionORG_FEE_SITE_ALLColumnIndexes">
 *       &lt;sequence>
 *         &lt;element name="ORG_FEE_OBJECT_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="FEE_OBJECT_ID" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="FEE_SCHED_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="ICON" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FEE_NAME" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FEE_DESC" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FEE_AMT" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="FEE_AMT_DESC" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TAX_GROUP_ID" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="TAXABLE" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="BASE_FEE_TYPE" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="SCHED_FEE_TYPE" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="FEE_TYPE_VAL" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FEE_BASIS" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="FEE_BASIS_VAL" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PERC_BASIS" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="PERC_BASIS_VAL" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FEE_FIXED" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="FEE_PERC" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="BASIS_MIN" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="BASIS_MAX" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="EVAL_ORDER" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="FEE_LEVEL" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="REF_TYPE" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="SITE_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="ORG_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="FEE_ACTIVE" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="SCHED_ACTIVE" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ORG_FEE_SITE_ALL", propOrder = {
    "orgfeeobjectid",
    "feeobjectid",
    "feeschedid",
    "icon",
    "feename",
    "feedesc",
    "feeamt",
    "feeamtdesc",
    "taxgroupid",
    "taxable",
    "basefeetype",
    "schedfeetype",
    "feetypeval",
    "feebasis",
    "feebasisval",
    "percbasis",
    "percbasisval",
    "feefixed",
    "feeperc",
    "basismin",
    "basismax",
    "evalorder",
    "feelevel",
    "reftype",
    "siteid",
    "orgid",
    "feeactive",
    "schedactive"
})
public class ORGFEESITEALL
    extends BaseEntityOfCollectionORGFEESITEALLColumnIndexes
{

    @XmlElement(name = "ORG_FEE_OBJECT_ID", required = true, type = Long.class, nillable = true)
    protected Long orgfeeobjectid;
    @XmlElement(name = "FEE_OBJECT_ID", required = true, nillable = true)
    protected BigDecimal feeobjectid;
    @XmlElement(name = "FEE_SCHED_ID", required = true, type = Long.class, nillable = true)
    protected Long feeschedid;
    @XmlElement(name = "ICON")
    protected String icon;
    @XmlElement(name = "FEE_NAME")
    protected String feename;
    @XmlElement(name = "FEE_DESC")
    protected String feedesc;
    @XmlElement(name = "FEE_AMT", required = true, nillable = true)
    protected BigDecimal feeamt;
    @XmlElement(name = "FEE_AMT_DESC")
    protected String feeamtdesc;
    @XmlElement(name = "TAX_GROUP_ID", required = true, nillable = true)
    protected BigDecimal taxgroupid;
    @XmlElement(name = "TAXABLE", required = true, type = Boolean.class, nillable = true)
    protected Boolean taxable;
    @XmlElement(name = "BASE_FEE_TYPE", required = true, type = Integer.class, nillable = true)
    protected Integer basefeetype;
    @XmlElement(name = "SCHED_FEE_TYPE", required = true, type = Integer.class, nillable = true)
    protected Integer schedfeetype;
    @XmlElement(name = "FEE_TYPE_VAL")
    protected String feetypeval;
    @XmlElement(name = "FEE_BASIS", required = true, type = Integer.class, nillable = true)
    protected Integer feebasis;
    @XmlElement(name = "FEE_BASIS_VAL")
    protected String feebasisval;
    @XmlElement(name = "PERC_BASIS", required = true, type = Integer.class, nillable = true)
    protected Integer percbasis;
    @XmlElement(name = "PERC_BASIS_VAL")
    protected String percbasisval;
    @XmlElement(name = "FEE_FIXED", required = true, nillable = true)
    protected BigDecimal feefixed;
    @XmlElement(name = "FEE_PERC", required = true, nillable = true)
    protected BigDecimal feeperc;
    @XmlElement(name = "BASIS_MIN", required = true, nillable = true)
    protected BigDecimal basismin;
    @XmlElement(name = "BASIS_MAX", required = true, nillable = true)
    protected BigDecimal basismax;
    @XmlElement(name = "EVAL_ORDER", required = true, type = Integer.class, nillable = true)
    protected Integer evalorder;
    @XmlElement(name = "FEE_LEVEL")
    protected String feelevel;
    @XmlElement(name = "REF_TYPE", required = true, nillable = true)
    protected BigDecimal reftype;
    @XmlElement(name = "SITE_ID", required = true, type = Long.class, nillable = true)
    protected Long siteid;
    @XmlElement(name = "ORG_ID", required = true, type = Long.class, nillable = true)
    protected Long orgid;
    @XmlElement(name = "FEE_ACTIVE", required = true, type = Boolean.class, nillable = true)
    protected Boolean feeactive;
    @XmlElement(name = "SCHED_ACTIVE", required = true, type = Boolean.class, nillable = true)
    protected Boolean schedactive;

    /**
     * Gets the value of the orgfeeobjectid property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getORGFEEOBJECTID() {
        return orgfeeobjectid;
    }

    /**
     * Sets the value of the orgfeeobjectid property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setORGFEEOBJECTID(Long value) {
        this.orgfeeobjectid = value;
    }

    /**
     * Gets the value of the feeobjectid property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getFEEOBJECTID() {
        return feeobjectid;
    }

    /**
     * Sets the value of the feeobjectid property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setFEEOBJECTID(BigDecimal value) {
        this.feeobjectid = value;
    }

    /**
     * Gets the value of the feeschedid property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getFEESCHEDID() {
        return feeschedid;
    }

    /**
     * Sets the value of the feeschedid property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setFEESCHEDID(Long value) {
        this.feeschedid = value;
    }

    /**
     * Gets the value of the icon property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getICON() {
        return icon;
    }

    /**
     * Sets the value of the icon property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setICON(String value) {
        this.icon = value;
    }

    /**
     * Gets the value of the feename property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFEENAME() {
        return feename;
    }

    /**
     * Sets the value of the feename property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFEENAME(String value) {
        this.feename = value;
    }

    /**
     * Gets the value of the feedesc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFEEDESC() {
        return feedesc;
    }

    /**
     * Sets the value of the feedesc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFEEDESC(String value) {
        this.feedesc = value;
    }

    /**
     * Gets the value of the feeamt property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getFEEAMT() {
        return feeamt;
    }

    /**
     * Sets the value of the feeamt property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setFEEAMT(BigDecimal value) {
        this.feeamt = value;
    }

    /**
     * Gets the value of the feeamtdesc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFEEAMTDESC() {
        return feeamtdesc;
    }

    /**
     * Sets the value of the feeamtdesc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFEEAMTDESC(String value) {
        this.feeamtdesc = value;
    }

    /**
     * Gets the value of the taxgroupid property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getTAXGROUPID() {
        return taxgroupid;
    }

    /**
     * Sets the value of the taxgroupid property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setTAXGROUPID(BigDecimal value) {
        this.taxgroupid = value;
    }

    /**
     * Gets the value of the taxable property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isTAXABLE() {
        return taxable;
    }

    /**
     * Sets the value of the taxable property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setTAXABLE(Boolean value) {
        this.taxable = value;
    }

    /**
     * Gets the value of the basefeetype property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getBASEFEETYPE() {
        return basefeetype;
    }

    /**
     * Sets the value of the basefeetype property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setBASEFEETYPE(Integer value) {
        this.basefeetype = value;
    }

    /**
     * Gets the value of the schedfeetype property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getSCHEDFEETYPE() {
        return schedfeetype;
    }

    /**
     * Sets the value of the schedfeetype property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setSCHEDFEETYPE(Integer value) {
        this.schedfeetype = value;
    }

    /**
     * Gets the value of the feetypeval property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFEETYPEVAL() {
        return feetypeval;
    }

    /**
     * Sets the value of the feetypeval property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFEETYPEVAL(String value) {
        this.feetypeval = value;
    }

    /**
     * Gets the value of the feebasis property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getFEEBASIS() {
        return feebasis;
    }

    /**
     * Sets the value of the feebasis property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setFEEBASIS(Integer value) {
        this.feebasis = value;
    }

    /**
     * Gets the value of the feebasisval property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFEEBASISVAL() {
        return feebasisval;
    }

    /**
     * Sets the value of the feebasisval property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFEEBASISVAL(String value) {
        this.feebasisval = value;
    }

    /**
     * Gets the value of the percbasis property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getPERCBASIS() {
        return percbasis;
    }

    /**
     * Sets the value of the percbasis property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setPERCBASIS(Integer value) {
        this.percbasis = value;
    }

    /**
     * Gets the value of the percbasisval property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPERCBASISVAL() {
        return percbasisval;
    }

    /**
     * Sets the value of the percbasisval property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPERCBASISVAL(String value) {
        this.percbasisval = value;
    }

    /**
     * Gets the value of the feefixed property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getFEEFIXED() {
        return feefixed;
    }

    /**
     * Sets the value of the feefixed property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setFEEFIXED(BigDecimal value) {
        this.feefixed = value;
    }

    /**
     * Gets the value of the feeperc property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getFEEPERC() {
        return feeperc;
    }

    /**
     * Sets the value of the feeperc property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setFEEPERC(BigDecimal value) {
        this.feeperc = value;
    }

    /**
     * Gets the value of the basismin property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getBASISMIN() {
        return basismin;
    }

    /**
     * Sets the value of the basismin property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setBASISMIN(BigDecimal value) {
        this.basismin = value;
    }

    /**
     * Gets the value of the basismax property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getBASISMAX() {
        return basismax;
    }

    /**
     * Sets the value of the basismax property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setBASISMAX(BigDecimal value) {
        this.basismax = value;
    }

    /**
     * Gets the value of the evalorder property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getEVALORDER() {
        return evalorder;
    }

    /**
     * Sets the value of the evalorder property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setEVALORDER(Integer value) {
        this.evalorder = value;
    }

    /**
     * Gets the value of the feelevel property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFEELEVEL() {
        return feelevel;
    }

    /**
     * Sets the value of the feelevel property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFEELEVEL(String value) {
        this.feelevel = value;
    }

    /**
     * Gets the value of the reftype property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getREFTYPE() {
        return reftype;
    }

    /**
     * Sets the value of the reftype property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setREFTYPE(BigDecimal value) {
        this.reftype = value;
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
     * Gets the value of the orgid property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getORGID() {
        return orgid;
    }

    /**
     * Sets the value of the orgid property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setORGID(Long value) {
        this.orgid = value;
    }

    /**
     * Gets the value of the feeactive property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isFEEACTIVE() {
        return feeactive;
    }

    /**
     * Sets the value of the feeactive property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setFEEACTIVE(Boolean value) {
        this.feeactive = value;
    }

    /**
     * Gets the value of the schedactive property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isSCHEDACTIVE() {
        return schedactive;
    }

    /**
     * Sets the value of the schedactive property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setSCHEDACTIVE(Boolean value) {
        this.schedactive = value;
    }

}
