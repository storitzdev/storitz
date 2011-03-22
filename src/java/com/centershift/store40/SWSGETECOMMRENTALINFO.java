package com.centershift.store40;

import javax.xml.bind.annotation.*;
import javax.xml.datatype.XMLGregorianCalendar;
import java.math.BigDecimal;


/**
 * <p>Java class for SWS_GET_ECOMM_RENTAL_INFO complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="SWS_GET_ECOMM_RENTAL_INFO">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.centershift.com/STORE40/}BaseEntityOfCollectionSWS_GET_ECOMM_RENTAL_INFOColumnIndexes">
 *       &lt;sequence>
 *         &lt;element name="FIRST_NAME" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LAST_NAME" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ACCT_TYPE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ACCT_NAME" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ATTRIBUTE01_VAL" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DEPTH" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="WIDTH" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="UNIT_NUMBER" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SITE_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="SITE_NAME" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OVERLOCK_STATUS" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RENTAL_STATUS" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CURRENTLY_RENTED" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="START_DATE" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="PTD" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="LTD" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="MO_DATE" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="DEL_EXEMPT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DEL_STEP" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="UNIT_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="ACCT_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="CONTACT_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="RENTAL_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="NEXT_PTD" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="ECOMM_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="TOTAL_DUE" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="EXPIRATION" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="OBJ_PERIOD_UOM" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RENT_RATE" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="CONTACT_TYPE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="EMAIL" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="KNOWN_AS" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OBJ_PERIOD" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SWS_GET_ECOMM_RENTAL_INFO", propOrder = {
        "firstname",
        "lastname",
        "accttype",
        "acctname",
        "attribute01VAL",
        "depth",
        "width",
        "unitnumber",
        "siteid",
        "sitename",
        "overlockstatus",
        "rentalstatus",
        "currentlyrented",
        "startdate",
        "ptd",
        "ltd",
        "modate",
        "delexempt",
        "delstep",
        "unitid",
        "acctid",
        "contactid",
        "rentalid",
        "nextptd",
        "ecommid",
        "totaldue",
        "expiration",
        "objperioduom",
        "rentrate",
        "contacttype",
        "email",
        "knownas",
        "objperiod"
})
public class SWSGETECOMMRENTALINFO
        extends BaseEntityOfCollectionSWSGETECOMMRENTALINFOColumnIndexes {

    @XmlElement(name = "FIRST_NAME")
    protected String firstname;
    @XmlElement(name = "LAST_NAME")
    protected String lastname;
    @XmlElement(name = "ACCT_TYPE")
    protected String accttype;
    @XmlElement(name = "ACCT_NAME")
    protected String acctname;
    @XmlElement(name = "ATTRIBUTE01_VAL")
    protected String attribute01VAL;
    @XmlElement(name = "DEPTH", required = true, nillable = true)
    protected BigDecimal depth;
    @XmlElement(name = "WIDTH", required = true, nillable = true)
    protected BigDecimal width;
    @XmlElement(name = "UNIT_NUMBER")
    protected String unitnumber;
    @XmlElement(name = "SITE_ID")
    protected long siteid;
    @XmlElement(name = "SITE_NAME")
    protected String sitename;
    @XmlElement(name = "OVERLOCK_STATUS")
    protected String overlockstatus;
    @XmlElement(name = "RENTAL_STATUS")
    protected String rentalstatus;
    @XmlElement(name = "CURRENTLY_RENTED")
    protected String currentlyrented;
    @XmlElement(name = "START_DATE", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar startdate;
    @XmlElement(name = "PTD", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar ptd;
    @XmlElement(name = "LTD", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar ltd;
    @XmlElement(name = "MO_DATE", required = true, nillable = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar modate;
    @XmlElement(name = "DEL_EXEMPT")
    protected String delexempt;
    @XmlElement(name = "DEL_STEP")
    protected int delstep;
    @XmlElement(name = "UNIT_ID")
    protected long unitid;
    @XmlElement(name = "ACCT_ID", required = true, type = Long.class, nillable = true)
    protected Long acctid;
    @XmlElement(name = "CONTACT_ID")
    protected long contactid;
    @XmlElement(name = "RENTAL_ID")
    protected long rentalid;
    @XmlElement(name = "NEXT_PTD", required = true, nillable = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar nextptd;
    @XmlElement(name = "ECOMM_ID")
    protected long ecommid;
    @XmlElement(name = "TOTAL_DUE", required = true, nillable = true)
    protected BigDecimal totaldue;
    @XmlElement(name = "EXPIRATION", required = true, nillable = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar expiration;
    @XmlElement(name = "OBJ_PERIOD_UOM")
    protected String objperioduom;
    @XmlElement(name = "RENT_RATE", required = true)
    protected BigDecimal rentrate;
    @XmlElement(name = "CONTACT_TYPE")
    protected String contacttype;
    @XmlElement(name = "EMAIL")
    protected String email;
    @XmlElement(name = "KNOWN_AS")
    protected String knownas;
    @XmlElement(name = "OBJ_PERIOD")
    protected long objperiod;

    /**
     * Gets the value of the firstname property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getFIRSTNAME() {
        return firstname;
    }

    /**
     * Sets the value of the firstname property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setFIRSTNAME(String value) {
        this.firstname = value;
    }

    /**
     * Gets the value of the lastname property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getLASTNAME() {
        return lastname;
    }

    /**
     * Sets the value of the lastname property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setLASTNAME(String value) {
        this.lastname = value;
    }

    /**
     * Gets the value of the accttype property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getACCTTYPE() {
        return accttype;
    }

    /**
     * Sets the value of the accttype property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setACCTTYPE(String value) {
        this.accttype = value;
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
     * Gets the value of the attribute01VAL property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getATTRIBUTE01VAL() {
        return attribute01VAL;
    }

    /**
     * Sets the value of the attribute01VAL property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setATTRIBUTE01VAL(String value) {
        this.attribute01VAL = value;
    }

    /**
     * Gets the value of the depth property.
     *
     * @return possible object is
     *         {@link BigDecimal }
     */
    public BigDecimal getDEPTH() {
        return depth;
    }

    /**
     * Sets the value of the depth property.
     *
     * @param value allowed object is
     *              {@link BigDecimal }
     */
    public void setDEPTH(BigDecimal value) {
        this.depth = value;
    }

    /**
     * Gets the value of the width property.
     *
     * @return possible object is
     *         {@link BigDecimal }
     */
    public BigDecimal getWIDTH() {
        return width;
    }

    /**
     * Sets the value of the width property.
     *
     * @param value allowed object is
     *              {@link BigDecimal }
     */
    public void setWIDTH(BigDecimal value) {
        this.width = value;
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
     * Gets the value of the overlockstatus property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getOVERLOCKSTATUS() {
        return overlockstatus;
    }

    /**
     * Sets the value of the overlockstatus property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setOVERLOCKSTATUS(String value) {
        this.overlockstatus = value;
    }

    /**
     * Gets the value of the rentalstatus property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getRENTALSTATUS() {
        return rentalstatus;
    }

    /**
     * Sets the value of the rentalstatus property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setRENTALSTATUS(String value) {
        this.rentalstatus = value;
    }

    /**
     * Gets the value of the currentlyrented property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getCURRENTLYRENTED() {
        return currentlyrented;
    }

    /**
     * Sets the value of the currentlyrented property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setCURRENTLYRENTED(String value) {
        this.currentlyrented = value;
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
     * Gets the value of the delexempt property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getDELEXEMPT() {
        return delexempt;
    }

    /**
     * Sets the value of the delexempt property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setDELEXEMPT(String value) {
        this.delexempt = value;
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
     * Gets the value of the contactid property.
     */
    public long getCONTACTID() {
        return contactid;
    }

    /**
     * Sets the value of the contactid property.
     */
    public void setCONTACTID(long value) {
        this.contactid = value;
    }

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
     * Gets the value of the nextptd property.
     *
     * @return possible object is
     *         {@link XMLGregorianCalendar }
     */
    public XMLGregorianCalendar getNEXTPTD() {
        return nextptd;
    }

    /**
     * Sets the value of the nextptd property.
     *
     * @param value allowed object is
     *              {@link XMLGregorianCalendar }
     */
    public void setNEXTPTD(XMLGregorianCalendar value) {
        this.nextptd = value;
    }

    /**
     * Gets the value of the ecommid property.
     */
    public long getECOMMID() {
        return ecommid;
    }

    /**
     * Sets the value of the ecommid property.
     */
    public void setECOMMID(long value) {
        this.ecommid = value;
    }

    /**
     * Gets the value of the totaldue property.
     *
     * @return possible object is
     *         {@link BigDecimal }
     */
    public BigDecimal getTOTALDUE() {
        return totaldue;
    }

    /**
     * Sets the value of the totaldue property.
     *
     * @param value allowed object is
     *              {@link BigDecimal }
     */
    public void setTOTALDUE(BigDecimal value) {
        this.totaldue = value;
    }

    /**
     * Gets the value of the expiration property.
     *
     * @return possible object is
     *         {@link XMLGregorianCalendar }
     */
    public XMLGregorianCalendar getEXPIRATION() {
        return expiration;
    }

    /**
     * Sets the value of the expiration property.
     *
     * @param value allowed object is
     *              {@link XMLGregorianCalendar }
     */
    public void setEXPIRATION(XMLGregorianCalendar value) {
        this.expiration = value;
    }

    /**
     * Gets the value of the objperioduom property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getOBJPERIODUOM() {
        return objperioduom;
    }

    /**
     * Sets the value of the objperioduom property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setOBJPERIODUOM(String value) {
        this.objperioduom = value;
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
     * Gets the value of the contacttype property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getCONTACTTYPE() {
        return contacttype;
    }

    /**
     * Sets the value of the contacttype property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setCONTACTTYPE(String value) {
        this.contacttype = value;
    }

    /**
     * Gets the value of the email property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getEMAIL() {
        return email;
    }

    /**
     * Sets the value of the email property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setEMAIL(String value) {
        this.email = value;
    }

    /**
     * Gets the value of the knownas property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getKNOWNAS() {
        return knownas;
    }

    /**
     * Sets the value of the knownas property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setKNOWNAS(String value) {
        this.knownas = value;
    }

    /**
     * Gets the value of the objperiod property.
     */
    public long getOBJPERIOD() {
        return objperiod;
    }

    /**
     * Sets the value of the objperiod property.
     */
    public void setOBJPERIOD(long value) {
        this.objperiod = value;
    }

}
