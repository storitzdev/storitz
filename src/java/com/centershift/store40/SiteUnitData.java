
package com.centershift.store40;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SiteUnitData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SiteUnitData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="UNIT_NUMBER" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="UNIT_ID" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="VERSION" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="PROMO_ID" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="PROMO_DESC" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PROMO_DET" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PROMO_NAME" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SOFT_RESERVATION" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="HARD_RESERVATION" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RES_AMOUNT" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="CLASS_DESC" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OBJ_PERIOD_UOM_VAL" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MIN_RENT_RATE" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="MAX_RENT_RATE" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="QUANTITY" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="AVAILABLE" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="SITE_CLASS_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="DEPTH" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="WIDTH" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="SITE_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="FEATURES_VAL" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CURRENT_RATE" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SiteUnitData", propOrder = {
    "unitnumber",
    "unitid",
    "version",
    "promoid",
    "promodesc",
    "promodet",
    "promoname",
    "softreservation",
    "hardreservation",
    "resamount",
    "classdesc",
    "objperioduomval",
    "minrentrate",
    "maxrentrate",
    "quantity",
    "available",
    "siteclassid",
    "depth",
    "width",
    "siteid",
    "featuresval",
    "currentrate"
})
public class SiteUnitData {

    @XmlElement(name = "UNIT_NUMBER")
    protected String unitnumber;
    @XmlElement(name = "UNIT_ID", required = true, nillable = true)
    protected BigDecimal unitid;
    @XmlElement(name = "VERSION", required = true, nillable = true)
    protected BigDecimal version;
    @XmlElement(name = "PROMO_ID", required = true, nillable = true)
    protected BigDecimal promoid;
    @XmlElement(name = "PROMO_DESC")
    protected String promodesc;
    @XmlElement(name = "PROMO_DET")
    protected String promodet;
    @XmlElement(name = "PROMO_NAME")
    protected String promoname;
    @XmlElement(name = "SOFT_RESERVATION")
    protected String softreservation;
    @XmlElement(name = "HARD_RESERVATION")
    protected String hardreservation;
    @XmlElement(name = "RES_AMOUNT", required = true, nillable = true)
    protected BigDecimal resamount;
    @XmlElement(name = "CLASS_DESC")
    protected String classdesc;
    @XmlElement(name = "OBJ_PERIOD_UOM_VAL")
    protected String objperioduomval;
    @XmlElement(name = "MIN_RENT_RATE", required = true, nillable = true)
    protected BigDecimal minrentrate;
    @XmlElement(name = "MAX_RENT_RATE", required = true, nillable = true)
    protected BigDecimal maxrentrate;
    @XmlElement(name = "QUANTITY", required = true, nillable = true)
    protected BigDecimal quantity;
    @XmlElement(name = "AVAILABLE", required = true, nillable = true)
    protected BigDecimal available;
    @XmlElement(name = "SITE_CLASS_ID", required = true, type = Long.class, nillable = true)
    protected Long siteclassid;
    @XmlElement(name = "DEPTH", required = true, nillable = true)
    protected BigDecimal depth;
    @XmlElement(name = "WIDTH", required = true, nillable = true)
    protected BigDecimal width;
    @XmlElement(name = "SITE_ID", required = true, type = Long.class, nillable = true)
    protected Long siteid;
    @XmlElement(name = "FEATURES_VAL")
    protected String featuresval;
    @XmlElement(name = "CURRENT_RATE", required = true, nillable = true)
    protected BigDecimal currentrate;

    /**
     * Gets the value of the unitnumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUNITNUMBER() {
        return unitnumber;
    }

    /**
     * Sets the value of the unitnumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUNITNUMBER(String value) {
        this.unitnumber = value;
    }

    /**
     * Gets the value of the unitid property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getUNITID() {
        return unitid;
    }

    /**
     * Sets the value of the unitid property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setUNITID(BigDecimal value) {
        this.unitid = value;
    }

    /**
     * Gets the value of the version property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getVERSION() {
        return version;
    }

    /**
     * Sets the value of the version property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setVERSION(BigDecimal value) {
        this.version = value;
    }

    /**
     * Gets the value of the promoid property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getPROMOID() {
        return promoid;
    }

    /**
     * Sets the value of the promoid property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setPROMOID(BigDecimal value) {
        this.promoid = value;
    }

    /**
     * Gets the value of the promodesc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPROMODESC() {
        return promodesc;
    }

    /**
     * Sets the value of the promodesc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPROMODESC(String value) {
        this.promodesc = value;
    }

    /**
     * Gets the value of the promodet property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPROMODET() {
        return promodet;
    }

    /**
     * Sets the value of the promodet property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPROMODET(String value) {
        this.promodet = value;
    }

    /**
     * Gets the value of the promoname property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPROMONAME() {
        return promoname;
    }

    /**
     * Sets the value of the promoname property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPROMONAME(String value) {
        this.promoname = value;
    }

    /**
     * Gets the value of the softreservation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSOFTRESERVATION() {
        return softreservation;
    }

    /**
     * Sets the value of the softreservation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSOFTRESERVATION(String value) {
        this.softreservation = value;
    }

    /**
     * Gets the value of the hardreservation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHARDRESERVATION() {
        return hardreservation;
    }

    /**
     * Sets the value of the hardreservation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHARDRESERVATION(String value) {
        this.hardreservation = value;
    }

    /**
     * Gets the value of the resamount property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getRESAMOUNT() {
        return resamount;
    }

    /**
     * Sets the value of the resamount property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setRESAMOUNT(BigDecimal value) {
        this.resamount = value;
    }

    /**
     * Gets the value of the classdesc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCLASSDESC() {
        return classdesc;
    }

    /**
     * Sets the value of the classdesc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCLASSDESC(String value) {
        this.classdesc = value;
    }

    /**
     * Gets the value of the objperioduomval property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOBJPERIODUOMVAL() {
        return objperioduomval;
    }

    /**
     * Sets the value of the objperioduomval property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOBJPERIODUOMVAL(String value) {
        this.objperioduomval = value;
    }

    /**
     * Gets the value of the minrentrate property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getMINRENTRATE() {
        return minrentrate;
    }

    /**
     * Sets the value of the minrentrate property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setMINRENTRATE(BigDecimal value) {
        this.minrentrate = value;
    }

    /**
     * Gets the value of the maxrentrate property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getMAXRENTRATE() {
        return maxrentrate;
    }

    /**
     * Sets the value of the maxrentrate property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setMAXRENTRATE(BigDecimal value) {
        this.maxrentrate = value;
    }

    /**
     * Gets the value of the quantity property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getQUANTITY() {
        return quantity;
    }

    /**
     * Sets the value of the quantity property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setQUANTITY(BigDecimal value) {
        this.quantity = value;
    }

    /**
     * Gets the value of the available property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getAVAILABLE() {
        return available;
    }

    /**
     * Sets the value of the available property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setAVAILABLE(BigDecimal value) {
        this.available = value;
    }

    /**
     * Gets the value of the siteclassid property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getSITECLASSID() {
        return siteclassid;
    }

    /**
     * Sets the value of the siteclassid property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setSITECLASSID(Long value) {
        this.siteclassid = value;
    }

    /**
     * Gets the value of the depth property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getDEPTH() {
        return depth;
    }

    /**
     * Sets the value of the depth property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setDEPTH(BigDecimal value) {
        this.depth = value;
    }

    /**
     * Gets the value of the width property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getWIDTH() {
        return width;
    }

    /**
     * Sets the value of the width property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setWIDTH(BigDecimal value) {
        this.width = value;
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
     * Gets the value of the featuresval property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFEATURESVAL() {
        return featuresval;
    }

    /**
     * Sets the value of the featuresval property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFEATURESVAL(String value) {
        this.featuresval = value;
    }

    /**
     * Gets the value of the currentrate property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getCURRENTRATE() {
        return currentrate;
    }

    /**
     * Sets the value of the currentrate property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setCURRENTRATE(BigDecimal value) {
        this.currentrate = value;
    }

}
