package com.centershift.store40;

import javax.xml.bind.annotation.*;
import javax.xml.datatype.XMLGregorianCalendar;
import java.math.BigDecimal;


/**
 * <p>Java class for SOA_GET_ASSESSMENTS complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="SOA_GET_ASSESSMENTS">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.centershift.com/STORE40/}BaseEntityOfCollectionSOA_GET_ASSESSMENTSColumnIndexes">
 *       &lt;sequence>
 *         &lt;element name="ASSESS_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="ACCT_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="SITE_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="RENTAL_ID" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="ASSESS_DATE" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="REF_TYPE" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="VERSION" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="RO_VERSION" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="CLASS_REF" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="TAX_GROUP_ID" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="QTY" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="EXTENDED" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="TAX_DUE" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="REF_TYPE_VAL" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ASSESS_START" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="ASSESS_END" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="DESCRIP" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ITEM_PRICE" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="FULFILL" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="PARENT_ASSESS_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SOA_GET_ASSESSMENTS", propOrder = {
        "assessid",
        "acctid",
        "siteid",
        "rentalid",
        "assessdate",
        "reftype",
        "version",
        "roversion",
        "classref",
        "taxgroupid",
        "qty",
        "extended",
        "taxdue",
        "reftypeval",
        "assessstart",
        "assessend",
        "descrip",
        "itemprice",
        "fulfill",
        "parentassessid"
})
public class SOAGETASSESSMENTS
        extends BaseEntityOfCollectionSOAGETASSESSMENTSColumnIndexes {

    @XmlElement(name = "ASSESS_ID", required = true, type = Long.class, nillable = true)
    protected Long assessid;
    @XmlElement(name = "ACCT_ID", required = true, type = Long.class, nillable = true)
    protected Long acctid;
    @XmlElement(name = "SITE_ID", required = true, type = Long.class, nillable = true)
    protected Long siteid;
    @XmlElement(name = "RENTAL_ID", required = true, nillable = true)
    protected BigDecimal rentalid;
    @XmlElement(name = "ASSESS_DATE", required = true, nillable = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar assessdate;
    @XmlElement(name = "REF_TYPE", required = true, type = Integer.class, nillable = true)
    protected Integer reftype;
    @XmlElement(name = "VERSION", required = true, type = Integer.class, nillable = true)
    protected Integer version;
    @XmlElement(name = "RO_VERSION", required = true, nillable = true)
    protected BigDecimal roversion;
    @XmlElement(name = "CLASS_REF", required = true, type = Integer.class, nillable = true)
    protected Integer classref;
    @XmlElement(name = "TAX_GROUP_ID", required = true, nillable = true)
    protected BigDecimal taxgroupid;
    @XmlElement(name = "QTY", required = true, nillable = true)
    protected BigDecimal qty;
    @XmlElement(name = "EXTENDED", required = true, nillable = true)
    protected BigDecimal extended;
    @XmlElement(name = "TAX_DUE", required = true, nillable = true)
    protected BigDecimal taxdue;
    @XmlElement(name = "REF_TYPE_VAL")
    protected String reftypeval;
    @XmlElement(name = "ASSESS_START", required = true, nillable = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar assessstart;
    @XmlElement(name = "ASSESS_END", required = true, nillable = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar assessend;
    @XmlElement(name = "DESCRIP")
    protected String descrip;
    @XmlElement(name = "ITEM_PRICE", required = true, nillable = true)
    protected BigDecimal itemprice;
    @XmlElement(name = "FULFILL", required = true, nillable = true)
    protected BigDecimal fulfill;
    @XmlElement(name = "PARENT_ASSESS_ID", required = true, type = Long.class, nillable = true)
    protected Long parentassessid;

    /**
     * Gets the value of the assessid property.
     *
     * @return possible object is
     *         {@link Long }
     */
    public Long getASSESSID() {
        return assessid;
    }

    /**
     * Sets the value of the assessid property.
     *
     * @param value allowed object is
     *              {@link Long }
     */
    public void setASSESSID(Long value) {
        this.assessid = value;
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
     * Gets the value of the siteid property.
     *
     * @return possible object is
     *         {@link Long }
     */
    public Long getSITEID() {
        return siteid;
    }

    /**
     * Sets the value of the siteid property.
     *
     * @param value allowed object is
     *              {@link Long }
     */
    public void setSITEID(Long value) {
        this.siteid = value;
    }

    /**
     * Gets the value of the rentalid property.
     *
     * @return possible object is
     *         {@link BigDecimal }
     */
    public BigDecimal getRENTALID() {
        return rentalid;
    }

    /**
     * Sets the value of the rentalid property.
     *
     * @param value allowed object is
     *              {@link BigDecimal }
     */
    public void setRENTALID(BigDecimal value) {
        this.rentalid = value;
    }

    /**
     * Gets the value of the assessdate property.
     *
     * @return possible object is
     *         {@link XMLGregorianCalendar }
     */
    public XMLGregorianCalendar getASSESSDATE() {
        return assessdate;
    }

    /**
     * Sets the value of the assessdate property.
     *
     * @param value allowed object is
     *              {@link XMLGregorianCalendar }
     */
    public void setASSESSDATE(XMLGregorianCalendar value) {
        this.assessdate = value;
    }

    /**
     * Gets the value of the reftype property.
     *
     * @return possible object is
     *         {@link Integer }
     */
    public Integer getREFTYPE() {
        return reftype;
    }

    /**
     * Sets the value of the reftype property.
     *
     * @param value allowed object is
     *              {@link Integer }
     */
    public void setREFTYPE(Integer value) {
        this.reftype = value;
    }

    /**
     * Gets the value of the version property.
     *
     * @return possible object is
     *         {@link Integer }
     */
    public Integer getVERSION() {
        return version;
    }

    /**
     * Sets the value of the version property.
     *
     * @param value allowed object is
     *              {@link Integer }
     */
    public void setVERSION(Integer value) {
        this.version = value;
    }

    /**
     * Gets the value of the roversion property.
     *
     * @return possible object is
     *         {@link BigDecimal }
     */
    public BigDecimal getROVERSION() {
        return roversion;
    }

    /**
     * Sets the value of the roversion property.
     *
     * @param value allowed object is
     *              {@link BigDecimal }
     */
    public void setROVERSION(BigDecimal value) {
        this.roversion = value;
    }

    /**
     * Gets the value of the classref property.
     *
     * @return possible object is
     *         {@link Integer }
     */
    public Integer getCLASSREF() {
        return classref;
    }

    /**
     * Sets the value of the classref property.
     *
     * @param value allowed object is
     *              {@link Integer }
     */
    public void setCLASSREF(Integer value) {
        this.classref = value;
    }

    /**
     * Gets the value of the taxgroupid property.
     *
     * @return possible object is
     *         {@link BigDecimal }
     */
    public BigDecimal getTAXGROUPID() {
        return taxgroupid;
    }

    /**
     * Sets the value of the taxgroupid property.
     *
     * @param value allowed object is
     *              {@link BigDecimal }
     */
    public void setTAXGROUPID(BigDecimal value) {
        this.taxgroupid = value;
    }

    /**
     * Gets the value of the qty property.
     *
     * @return possible object is
     *         {@link BigDecimal }
     */
    public BigDecimal getQTY() {
        return qty;
    }

    /**
     * Sets the value of the qty property.
     *
     * @param value allowed object is
     *              {@link BigDecimal }
     */
    public void setQTY(BigDecimal value) {
        this.qty = value;
    }

    /**
     * Gets the value of the extended property.
     *
     * @return possible object is
     *         {@link BigDecimal }
     */
    public BigDecimal getEXTENDED() {
        return extended;
    }

    /**
     * Sets the value of the extended property.
     *
     * @param value allowed object is
     *              {@link BigDecimal }
     */
    public void setEXTENDED(BigDecimal value) {
        this.extended = value;
    }

    /**
     * Gets the value of the taxdue property.
     *
     * @return possible object is
     *         {@link BigDecimal }
     */
    public BigDecimal getTAXDUE() {
        return taxdue;
    }

    /**
     * Sets the value of the taxdue property.
     *
     * @param value allowed object is
     *              {@link BigDecimal }
     */
    public void setTAXDUE(BigDecimal value) {
        this.taxdue = value;
    }

    /**
     * Gets the value of the reftypeval property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getREFTYPEVAL() {
        return reftypeval;
    }

    /**
     * Sets the value of the reftypeval property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setREFTYPEVAL(String value) {
        this.reftypeval = value;
    }

    /**
     * Gets the value of the assessstart property.
     *
     * @return possible object is
     *         {@link XMLGregorianCalendar }
     */
    public XMLGregorianCalendar getASSESSSTART() {
        return assessstart;
    }

    /**
     * Sets the value of the assessstart property.
     *
     * @param value allowed object is
     *              {@link XMLGregorianCalendar }
     */
    public void setASSESSSTART(XMLGregorianCalendar value) {
        this.assessstart = value;
    }

    /**
     * Gets the value of the assessend property.
     *
     * @return possible object is
     *         {@link XMLGregorianCalendar }
     */
    public XMLGregorianCalendar getASSESSEND() {
        return assessend;
    }

    /**
     * Sets the value of the assessend property.
     *
     * @param value allowed object is
     *              {@link XMLGregorianCalendar }
     */
    public void setASSESSEND(XMLGregorianCalendar value) {
        this.assessend = value;
    }

    /**
     * Gets the value of the descrip property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getDESCRIP() {
        return descrip;
    }

    /**
     * Sets the value of the descrip property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setDESCRIP(String value) {
        this.descrip = value;
    }

    /**
     * Gets the value of the itemprice property.
     *
     * @return possible object is
     *         {@link BigDecimal }
     */
    public BigDecimal getITEMPRICE() {
        return itemprice;
    }

    /**
     * Sets the value of the itemprice property.
     *
     * @param value allowed object is
     *              {@link BigDecimal }
     */
    public void setITEMPRICE(BigDecimal value) {
        this.itemprice = value;
    }

    /**
     * Gets the value of the fulfill property.
     *
     * @return possible object is
     *         {@link BigDecimal }
     */
    public BigDecimal getFULFILL() {
        return fulfill;
    }

    /**
     * Sets the value of the fulfill property.
     *
     * @param value allowed object is
     *              {@link BigDecimal }
     */
    public void setFULFILL(BigDecimal value) {
        this.fulfill = value;
    }

    /**
     * Gets the value of the parentassessid property.
     *
     * @return possible object is
     *         {@link Long }
     */
    public Long getPARENTASSESSID() {
        return parentassessid;
    }

    /**
     * Sets the value of the parentassessid property.
     *
     * @param value allowed object is
     *              {@link Long }
     */
    public void setPARENTASSESSID(Long value) {
        this.parentassessid = value;
    }

}
