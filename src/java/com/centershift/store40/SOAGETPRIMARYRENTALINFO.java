package com.centershift.store40;

import javax.xml.bind.annotation.*;
import javax.xml.datatype.XMLGregorianCalendar;
import java.math.BigDecimal;


/**
 * <p>Java class for SOA_GET_PRIMARY_RENTAL_INFO complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="SOA_GET_PRIMARY_RENTAL_INFO">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.centershift.com/STORE40/}BaseEntityOfCollectionSOA_GET_PRIMARY_RENTAL_INFOColumnIndexes">
 *       &lt;sequence>
 *         &lt;element name="OBJ_PERIOD_UOM" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OBJ_PERIOD" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="RENT_RATE" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="ADDRESS_TYPE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ADDR1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ADDR2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ADDR3" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CITY" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="STATE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="POSTAL_CODE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="COUNTRY" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PHONE_TYPE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PHONE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CONTACT_TYPE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="EMAIL" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="KNOWN_AS" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FIRST_NAME" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LAST_NAME" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ACCT_CLASS" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ACCT_NAME" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ATTRIBUTE01_VAL" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DEPTH" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="WIDTH" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="UNIT_NUMBER" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SITE_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
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
 *         &lt;element name="VERSION" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SOA_GET_PRIMARY_RENTAL_INFO", propOrder = {
        "objperioduom",
        "objperiod",
        "rentrate",
        "addresstype",
        "addr1",
        "addr2",
        "addr3",
        "city",
        "state",
        "postalcode",
        "country",
        "phonetype",
        "phone",
        "contacttype",
        "email",
        "knownas",
        "firstname",
        "lastname",
        "acctclass",
        "acctname",
        "attribute01VAL",
        "depth",
        "width",
        "unitnumber",
        "siteid",
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
        "version"
})
public class SOAGETPRIMARYRENTALINFO
        extends BaseEntityOfCollectionSOAGETPRIMARYRENTALINFOColumnIndexes {

    @XmlElement(name = "OBJ_PERIOD_UOM")
    protected String objperioduom;
    @XmlElement(name = "OBJ_PERIOD")
    protected long objperiod;
    @XmlElement(name = "RENT_RATE", required = true)
    protected BigDecimal rentrate;
    @XmlElement(name = "ADDRESS_TYPE")
    protected String addresstype;
    @XmlElement(name = "ADDR1")
    protected String addr1;
    @XmlElement(name = "ADDR2")
    protected String addr2;
    @XmlElement(name = "ADDR3")
    protected String addr3;
    @XmlElement(name = "CITY")
    protected String city;
    @XmlElement(name = "STATE")
    protected String state;
    @XmlElement(name = "POSTAL_CODE")
    protected String postalcode;
    @XmlElement(name = "COUNTRY")
    protected String country;
    @XmlElement(name = "PHONE_TYPE")
    protected String phonetype;
    @XmlElement(name = "PHONE")
    protected String phone;
    @XmlElement(name = "CONTACT_TYPE")
    protected String contacttype;
    @XmlElement(name = "EMAIL")
    protected String email;
    @XmlElement(name = "KNOWN_AS")
    protected String knownas;
    @XmlElement(name = "FIRST_NAME")
    protected String firstname;
    @XmlElement(name = "LAST_NAME")
    protected String lastname;
    @XmlElement(name = "ACCT_CLASS")
    protected String acctclass;
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
    @XmlElement(name = "VERSION")
    protected int version;

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
     * Gets the value of the addresstype property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getADDRESSTYPE() {
        return addresstype;
    }

    /**
     * Sets the value of the addresstype property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setADDRESSTYPE(String value) {
        this.addresstype = value;
    }

    /**
     * Gets the value of the addr1 property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getADDR1() {
        return addr1;
    }

    /**
     * Sets the value of the addr1 property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setADDR1(String value) {
        this.addr1 = value;
    }

    /**
     * Gets the value of the addr2 property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getADDR2() {
        return addr2;
    }

    /**
     * Sets the value of the addr2 property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setADDR2(String value) {
        this.addr2 = value;
    }

    /**
     * Gets the value of the addr3 property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getADDR3() {
        return addr3;
    }

    /**
     * Sets the value of the addr3 property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setADDR3(String value) {
        this.addr3 = value;
    }

    /**
     * Gets the value of the city property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getCITY() {
        return city;
    }

    /**
     * Sets the value of the city property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setCITY(String value) {
        this.city = value;
    }

    /**
     * Gets the value of the state property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getSTATE() {
        return state;
    }

    /**
     * Sets the value of the state property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setSTATE(String value) {
        this.state = value;
    }

    /**
     * Gets the value of the postalcode property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getPOSTALCODE() {
        return postalcode;
    }

    /**
     * Sets the value of the postalcode property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setPOSTALCODE(String value) {
        this.postalcode = value;
    }

    /**
     * Gets the value of the country property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getCOUNTRY() {
        return country;
    }

    /**
     * Sets the value of the country property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setCOUNTRY(String value) {
        this.country = value;
    }

    /**
     * Gets the value of the phonetype property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getPHONETYPE() {
        return phonetype;
    }

    /**
     * Sets the value of the phonetype property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setPHONETYPE(String value) {
        this.phonetype = value;
    }

    /**
     * Gets the value of the phone property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getPHONE() {
        return phone;
    }

    /**
     * Sets the value of the phone property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setPHONE(String value) {
        this.phone = value;
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
     * Gets the value of the acctclass property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getACCTCLASS() {
        return acctclass;
    }

    /**
     * Sets the value of the acctclass property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setACCTCLASS(String value) {
        this.acctclass = value;
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

}
