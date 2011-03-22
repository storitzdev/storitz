package com.centershift.store40;

import javax.xml.bind.annotation.*;
import javax.xml.datatype.XMLGregorianCalendar;
import java.math.BigDecimal;


/**
 * <p>Java class for SDS_WALK_THRU_LIST complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="SDS_WALK_THRU_LIST">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.centershift.com/STORE40/}BaseEntityOfCollectionSDS_WALK_THRU_LISTColumnIndexes">
 *       &lt;sequence>
 *         &lt;element name="SITE_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="SITE_NAME" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="WALK_THRU_ORDER" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="UNIT_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="STATUS" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="UNIT_STATUS_VAL" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RENTAL_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="ACCT_NAME" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="UNIT_NUMBER" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RENTAL_START_DATE" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="PTD" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="OVERLOCK_STATUS_VAL" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DEL_STEP" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="DIM" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ATTRIBUTE01" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RENT_RATE" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="DAYS_LATE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ORG_NUMBER_XREF" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SUM_DAYS_LATE" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="UNIT_NUM_SORT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SDS_WALK_THRU_LIST", propOrder = {
        "siteid",
        "sitename",
        "walkthruorder",
        "unitid",
        "status",
        "unitstatusval",
        "rentalid",
        "acctname",
        "unitnumber",
        "rentalstartdate",
        "ptd",
        "overlockstatusval",
        "delstep",
        "dim",
        "attribute01",
        "rentrate",
        "dayslate",
        "orgnumberxref",
        "sumdayslate",
        "unitnumsort"
})
public class SDSWALKTHRULIST
        extends BaseEntityOfCollectionSDSWALKTHRULISTColumnIndexes {

    @XmlElement(name = "SITE_ID")
    protected long siteid;
    @XmlElement(name = "SITE_NAME")
    protected String sitename;
    @XmlElement(name = "WALK_THRU_ORDER", required = true, type = Integer.class, nillable = true)
    protected Integer walkthruorder;
    @XmlElement(name = "UNIT_ID")
    protected long unitid;
    @XmlElement(name = "STATUS", required = true, type = Integer.class, nillable = true)
    protected Integer status;
    @XmlElement(name = "UNIT_STATUS_VAL")
    protected String unitstatusval;
    @XmlElement(name = "RENTAL_ID", required = true, type = Long.class, nillable = true)
    protected Long rentalid;
    @XmlElement(name = "ACCT_NAME")
    protected String acctname;
    @XmlElement(name = "UNIT_NUMBER")
    protected String unitnumber;
    @XmlElement(name = "RENTAL_START_DATE", required = true, nillable = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar rentalstartdate;
    @XmlElement(name = "PTD", required = true, nillable = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar ptd;
    @XmlElement(name = "OVERLOCK_STATUS_VAL")
    protected String overlockstatusval;
    @XmlElement(name = "DEL_STEP", required = true, nillable = true)
    protected BigDecimal delstep;
    @XmlElement(name = "DIM")
    protected String dim;
    @XmlElement(name = "ATTRIBUTE01")
    protected String attribute01;
    @XmlElement(name = "RENT_RATE", required = true, nillable = true)
    protected BigDecimal rentrate;
    @XmlElement(name = "DAYS_LATE")
    protected String dayslate;
    @XmlElement(name = "ORG_NUMBER_XREF")
    protected String orgnumberxref;
    @XmlElement(name = "SUM_DAYS_LATE", required = true, nillable = true)
    protected BigDecimal sumdayslate;
    @XmlElement(name = "UNIT_NUM_SORT")
    protected String unitnumsort;

    /**
     * Gets the value of the siteid property.
     */
    public long getSITEID() {
        return siteid;
    }

    /**
     * Sets the value of the siteid property.
     */
    public void setSITEID(long value) {
        this.siteid = value;
    }

    /**
     * Gets the value of the sitename property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getSITENAME() {
        return sitename;
    }

    /**
     * Sets the value of the sitename property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setSITENAME(String value) {
        this.sitename = value;
    }

    /**
     * Gets the value of the walkthruorder property.
     *
     * @return possible object is
     *         {@link Integer }
     */
    public Integer getWALKTHRUORDER() {
        return walkthruorder;
    }

    /**
     * Sets the value of the walkthruorder property.
     *
     * @param value allowed object is
     *              {@link Integer }
     */
    public void setWALKTHRUORDER(Integer value) {
        this.walkthruorder = value;
    }

    /**
     * Gets the value of the unitid property.
     */
    public long getUNITID() {
        return unitid;
    }

    /**
     * Sets the value of the unitid property.
     */
    public void setUNITID(long value) {
        this.unitid = value;
    }

    /**
     * Gets the value of the status property.
     *
     * @return possible object is
     *         {@link Integer }
     */
    public Integer getSTATUS() {
        return status;
    }

    /**
     * Sets the value of the status property.
     *
     * @param value allowed object is
     *              {@link Integer }
     */
    public void setSTATUS(Integer value) {
        this.status = value;
    }

    /**
     * Gets the value of the unitstatusval property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getUNITSTATUSVAL() {
        return unitstatusval;
    }

    /**
     * Sets the value of the unitstatusval property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setUNITSTATUSVAL(String value) {
        this.unitstatusval = value;
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
     * Gets the value of the acctname property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getACCTNAME() {
        return acctname;
    }

    /**
     * Sets the value of the acctname property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setACCTNAME(String value) {
        this.acctname = value;
    }

    /**
     * Gets the value of the unitnumber property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getUNITNUMBER() {
        return unitnumber;
    }

    /**
     * Sets the value of the unitnumber property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setUNITNUMBER(String value) {
        this.unitnumber = value;
    }

    /**
     * Gets the value of the rentalstartdate property.
     *
     * @return possible object is
     *         {@link XMLGregorianCalendar }
     */
    public XMLGregorianCalendar getRENTALSTARTDATE() {
        return rentalstartdate;
    }

    /**
     * Sets the value of the rentalstartdate property.
     *
     * @param value allowed object is
     *              {@link XMLGregorianCalendar }
     */
    public void setRENTALSTARTDATE(XMLGregorianCalendar value) {
        this.rentalstartdate = value;
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
     * Gets the value of the overlockstatusval property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getOVERLOCKSTATUSVAL() {
        return overlockstatusval;
    }

    /**
     * Sets the value of the overlockstatusval property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setOVERLOCKSTATUSVAL(String value) {
        this.overlockstatusval = value;
    }

    /**
     * Gets the value of the delstep property.
     *
     * @return possible object is
     *         {@link BigDecimal }
     */
    public BigDecimal getDELSTEP() {
        return delstep;
    }

    /**
     * Sets the value of the delstep property.
     *
     * @param value allowed object is
     *              {@link BigDecimal }
     */
    public void setDELSTEP(BigDecimal value) {
        this.delstep = value;
    }

    /**
     * Gets the value of the dim property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getDIM() {
        return dim;
    }

    /**
     * Sets the value of the dim property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setDIM(String value) {
        this.dim = value;
    }

    /**
     * Gets the value of the attribute01 property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getATTRIBUTE01() {
        return attribute01;
    }

    /**
     * Sets the value of the attribute01 property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setATTRIBUTE01(String value) {
        this.attribute01 = value;
    }

    /**
     * Gets the value of the rentrate property.
     *
     * @return possible object is
     *         {@link BigDecimal }
     */
    public BigDecimal getRENTRATE() {
        return rentrate;
    }

    /**
     * Sets the value of the rentrate property.
     *
     * @param value allowed object is
     *              {@link BigDecimal }
     */
    public void setRENTRATE(BigDecimal value) {
        this.rentrate = value;
    }

    /**
     * Gets the value of the dayslate property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getDAYSLATE() {
        return dayslate;
    }

    /**
     * Sets the value of the dayslate property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setDAYSLATE(String value) {
        this.dayslate = value;
    }

    /**
     * Gets the value of the orgnumberxref property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getORGNUMBERXREF() {
        return orgnumberxref;
    }

    /**
     * Sets the value of the orgnumberxref property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setORGNUMBERXREF(String value) {
        this.orgnumberxref = value;
    }

    /**
     * Gets the value of the sumdayslate property.
     *
     * @return possible object is
     *         {@link BigDecimal }
     */
    public BigDecimal getSUMDAYSLATE() {
        return sumdayslate;
    }

    /**
     * Sets the value of the sumdayslate property.
     *
     * @param value allowed object is
     *              {@link BigDecimal }
     */
    public void setSUMDAYSLATE(BigDecimal value) {
        this.sumdayslate = value;
    }

    /**
     * Gets the value of the unitnumsort property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getUNITNUMSORT() {
        return unitnumsort;
    }

    /**
     * Sets the value of the unitnumsort property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setUNITNUMSORT(String value) {
        this.unitnumsort = value;
    }

}
