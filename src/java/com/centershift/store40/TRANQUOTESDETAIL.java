package com.centershift.store40;

import javax.xml.bind.annotation.*;
import javax.xml.datatype.XMLGregorianCalendar;
import java.math.BigDecimal;


/**
 * <p>Java class for TRAN_QUOTES_DETAIL complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="TRAN_QUOTES_DETAIL">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.centershift.com/STORE40/}BaseEntityOfCollectionTRAN_QUOTES_DETAILColumnIndexes">
 *       &lt;sequence>
 *         &lt;element name="QUOTE_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="UNIT_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="UNIT_NUMBER" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SITE_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="ACCT_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="ACCT_NAME" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RENTAL_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="SITE_CLASS_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="ICON" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CLASS_TYPE" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="EXPIRATION" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="STATUS" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="QUOTE_TYPE" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="ATTRIBUTE01" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="ATTRIBUTE01_VAL" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ATTRIBUTE02" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="ATTRIBUTE02_VAL" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CLIMATE" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="CLIMATE_VAL" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="WIDTH" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="DEPTH" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="SQ_FEET" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="FEATURES" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="FEATURES_VAL" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ACCESS_TYPE" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="ACCESS_TYPE_VAL" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DOOR" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="DOOR_VAL" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PRICE" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="LOST_DEMAND_REASON" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="INQUIRY_SOURCE" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="PRORATE_AMT" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="ADMIN_FEE" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="TAX" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="DEPOSIT" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="DISC_AMT" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="TOT_AMT" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="QUOTE_START_DATE" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="CHANNEL" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="MKT_CODE" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="MKT_SOURCE" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="RES_DEPOSIT" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="CREATED" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="CREATED_BY" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="CREATED_BY_NAME" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="STREET_RATE" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="OBJ_PERIOD" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="OBJ_PERIOD_UOM" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="OBJ_PERIOD_UOM_VAL" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RES_GROUP_ID" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="GATE_KEYPAD" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="RENT_NOW" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="UPDATED_BY" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="TRAN_QUOTE_PCD" type="{http://www.centershift.com/STORE40/}ArrayOfTRAN_QUOTE_PCD" minOccurs="0"/>
 *         &lt;element name="TRAN_QUOTE_PCD_DETAIL" type="{http://www.centershift.com/STORE40/}ArrayOfTRAN_QUOTE_PCD_DETAIL" minOccurs="0"/>
 *         &lt;element name="TRAN_QUOTE_NOTES_DETAIL" type="{http://www.centershift.com/STORE40/}ArrayOfTRAN_QUOTE_NOTES_DETAIL" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TRAN_QUOTES_DETAIL", propOrder = {
        "quoteid",
        "unitid",
        "unitnumber",
        "siteid",
        "acctid",
        "acctname",
        "rentalid",
        "siteclassid",
        "icon",
        "classtype",
        "expiration",
        "status",
        "quotetype",
        "attribute01",
        "attribute01VAL",
        "attribute02",
        "attribute02VAL",
        "climate",
        "climateval",
        "width",
        "depth",
        "sqfeet",
        "features",
        "featuresval",
        "accesstype",
        "accesstypeval",
        "door",
        "doorval",
        "price",
        "lostdemandreason",
        "inquirysource",
        "prorateamt",
        "adminfee",
        "tax",
        "deposit",
        "discamt",
        "totamt",
        "quotestartdate",
        "channel",
        "mktcode",
        "mktsource",
        "resdeposit",
        "created",
        "createdby",
        "createdbyname",
        "streetrate",
        "objperiod",
        "objperioduom",
        "objperioduomval",
        "resgroupid",
        "gatekeypad",
        "rentnow",
        "updatedby",
        "tranquotepcd",
        "tranquotepcddetail",
        "tranquotenotesdetail"
})
public class TRANQUOTESDETAIL
        extends BaseEntityOfCollectionTRANQUOTESDETAILColumnIndexes {

    @XmlElement(name = "QUOTE_ID")
    protected long quoteid;
    @XmlElement(name = "UNIT_ID", required = true, type = Long.class, nillable = true)
    protected Long unitid;
    @XmlElement(name = "UNIT_NUMBER")
    protected String unitnumber;
    @XmlElement(name = "SITE_ID", required = true, type = Long.class, nillable = true)
    protected Long siteid;
    @XmlElement(name = "ACCT_ID", required = true, type = Long.class, nillable = true)
    protected Long acctid;
    @XmlElement(name = "ACCT_NAME")
    protected String acctname;
    @XmlElement(name = "RENTAL_ID", required = true, type = Long.class, nillable = true)
    protected Long rentalid;
    @XmlElement(name = "SITE_CLASS_ID", required = true, type = Long.class, nillable = true)
    protected Long siteclassid;
    @XmlElement(name = "ICON")
    protected String icon;
    @XmlElement(name = "CLASS_TYPE", required = true, nillable = true)
    protected BigDecimal classtype;
    @XmlElement(name = "EXPIRATION", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar expiration;
    @XmlElement(name = "STATUS")
    protected int status;
    @XmlElement(name = "QUOTE_TYPE", required = true, type = Integer.class, nillable = true)
    protected Integer quotetype;
    @XmlElement(name = "ATTRIBUTE01", required = true, type = Integer.class, nillable = true)
    protected Integer attribute01;
    @XmlElement(name = "ATTRIBUTE01_VAL")
    protected String attribute01VAL;
    @XmlElement(name = "ATTRIBUTE02", required = true, type = Integer.class, nillable = true)
    protected Integer attribute02;
    @XmlElement(name = "ATTRIBUTE02_VAL")
    protected String attribute02VAL;
    @XmlElement(name = "CLIMATE", required = true, type = Integer.class, nillable = true)
    protected Integer climate;
    @XmlElement(name = "CLIMATE_VAL")
    protected String climateval;
    @XmlElement(name = "WIDTH", required = true, nillable = true)
    protected BigDecimal width;
    @XmlElement(name = "DEPTH", required = true, nillable = true)
    protected BigDecimal depth;
    @XmlElement(name = "SQ_FEET", required = true, type = Integer.class, nillable = true)
    protected Integer sqfeet;
    @XmlElement(name = "FEATURES", required = true, type = Integer.class, nillable = true)
    protected Integer features;
    @XmlElement(name = "FEATURES_VAL")
    protected String featuresval;
    @XmlElement(name = "ACCESS_TYPE", required = true, type = Integer.class, nillable = true)
    protected Integer accesstype;
    @XmlElement(name = "ACCESS_TYPE_VAL")
    protected String accesstypeval;
    @XmlElement(name = "DOOR", required = true, type = Integer.class, nillable = true)
    protected Integer door;
    @XmlElement(name = "DOOR_VAL")
    protected String doorval;
    @XmlElement(name = "PRICE", required = true, nillable = true)
    protected BigDecimal price;
    @XmlElement(name = "LOST_DEMAND_REASON")
    protected int lostdemandreason;
    @XmlElement(name = "INQUIRY_SOURCE")
    protected int inquirysource;
    @XmlElement(name = "PRORATE_AMT", required = true, nillable = true)
    protected BigDecimal prorateamt;
    @XmlElement(name = "ADMIN_FEE", required = true, nillable = true)
    protected BigDecimal adminfee;
    @XmlElement(name = "TAX", required = true, nillable = true)
    protected BigDecimal tax;
    @XmlElement(name = "DEPOSIT", required = true, nillable = true)
    protected BigDecimal deposit;
    @XmlElement(name = "DISC_AMT", required = true, nillable = true)
    protected BigDecimal discamt;
    @XmlElement(name = "TOT_AMT", required = true, nillable = true)
    protected BigDecimal totamt;
    @XmlElement(name = "QUOTE_START_DATE", required = true, nillable = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar quotestartdate;
    @XmlElement(name = "CHANNEL", required = true, type = Integer.class, nillable = true)
    protected Integer channel;
    @XmlElement(name = "MKT_CODE", required = true, type = Long.class, nillable = true)
    protected Long mktcode;
    @XmlElement(name = "MKT_SOURCE", required = true, type = Long.class, nillable = true)
    protected Long mktsource;
    @XmlElement(name = "RES_DEPOSIT", required = true, nillable = true)
    protected BigDecimal resdeposit;
    @XmlElement(name = "CREATED", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar created;
    @XmlElement(name = "CREATED_BY")
    protected long createdby;
    @XmlElement(name = "CREATED_BY_NAME")
    protected String createdbyname;
    @XmlElement(name = "STREET_RATE", required = true, nillable = true)
    protected BigDecimal streetrate;
    @XmlElement(name = "OBJ_PERIOD", required = true, type = Long.class, nillable = true)
    protected Long objperiod;
    @XmlElement(name = "OBJ_PERIOD_UOM", required = true, type = Integer.class, nillable = true)
    protected Integer objperioduom;
    @XmlElement(name = "OBJ_PERIOD_UOM_VAL")
    protected String objperioduomval;
    @XmlElement(name = "RES_GROUP_ID", required = true, nillable = true)
    protected BigDecimal resgroupid;
    @XmlElement(name = "GATE_KEYPAD", required = true, type = Integer.class, nillable = true)
    protected Integer gatekeypad;
    @XmlElement(name = "RENT_NOW", required = true, type = Boolean.class, nillable = true)
    protected Boolean rentnow;
    @XmlElement(name = "UPDATED_BY")
    protected long updatedby;
    @XmlElement(name = "TRAN_QUOTE_PCD")
    protected ArrayOfTRANQUOTEPCD tranquotepcd;
    @XmlElement(name = "TRAN_QUOTE_PCD_DETAIL")
    protected ArrayOfTRANQUOTEPCDDETAIL tranquotepcddetail;
    @XmlElement(name = "TRAN_QUOTE_NOTES_DETAIL")
    protected ArrayOfTRANQUOTENOTESDETAIL tranquotenotesdetail;

    /**
     * Gets the value of the quoteid property.
     */
    public long getQUOTEID() {
        return quoteid;
    }

    /**
     * Sets the value of the quoteid property.
     */
    public void setQUOTEID(long value) {
        this.quoteid = value;
    }

    /**
     * Gets the value of the unitid property.
     *
     * @return possible object is
     *         {@link Long }
     */
    public Long getUNITID() {
        return unitid;
    }

    /**
     * Sets the value of the unitid property.
     *
     * @param value allowed object is
     *              {@link Long }
     */
    public void setUNITID(Long value) {
        this.unitid = value;
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
     * Gets the value of the siteclassid property.
     *
     * @return possible object is
     *         {@link Long }
     */
    public Long getSITECLASSID() {
        return siteclassid;
    }

    /**
     * Sets the value of the siteclassid property.
     *
     * @param value allowed object is
     *              {@link Long }
     */
    public void setSITECLASSID(Long value) {
        this.siteclassid = value;
    }

    /**
     * Gets the value of the icon property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getICON() {
        return icon;
    }

    /**
     * Sets the value of the icon property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setICON(String value) {
        this.icon = value;
    }

    /**
     * Gets the value of the classtype property.
     *
     * @return possible object is
     *         {@link BigDecimal }
     */
    public BigDecimal getCLASSTYPE() {
        return classtype;
    }

    /**
     * Sets the value of the classtype property.
     *
     * @param value allowed object is
     *              {@link BigDecimal }
     */
    public void setCLASSTYPE(BigDecimal value) {
        this.classtype = value;
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
     * Gets the value of the status property.
     */
    public int getSTATUS() {
        return status;
    }

    /**
     * Sets the value of the status property.
     */
    public void setSTATUS(int value) {
        this.status = value;
    }

    /**
     * Gets the value of the quotetype property.
     *
     * @return possible object is
     *         {@link Integer }
     */
    public Integer getQUOTETYPE() {
        return quotetype;
    }

    /**
     * Sets the value of the quotetype property.
     *
     * @param value allowed object is
     *              {@link Integer }
     */
    public void setQUOTETYPE(Integer value) {
        this.quotetype = value;
    }

    /**
     * Gets the value of the attribute01 property.
     *
     * @return possible object is
     *         {@link Integer }
     */
    public Integer getATTRIBUTE01() {
        return attribute01;
    }

    /**
     * Sets the value of the attribute01 property.
     *
     * @param value allowed object is
     *              {@link Integer }
     */
    public void setATTRIBUTE01(Integer value) {
        this.attribute01 = value;
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
     * Gets the value of the attribute02 property.
     *
     * @return possible object is
     *         {@link Integer }
     */
    public Integer getATTRIBUTE02() {
        return attribute02;
    }

    /**
     * Sets the value of the attribute02 property.
     *
     * @param value allowed object is
     *              {@link Integer }
     */
    public void setATTRIBUTE02(Integer value) {
        this.attribute02 = value;
    }

    /**
     * Gets the value of the attribute02VAL property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getATTRIBUTE02VAL() {
        return attribute02VAL;
    }

    /**
     * Sets the value of the attribute02VAL property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setATTRIBUTE02VAL(String value) {
        this.attribute02VAL = value;
    }

    /**
     * Gets the value of the climate property.
     *
     * @return possible object is
     *         {@link Integer }
     */
    public Integer getCLIMATE() {
        return climate;
    }

    /**
     * Sets the value of the climate property.
     *
     * @param value allowed object is
     *              {@link Integer }
     */
    public void setCLIMATE(Integer value) {
        this.climate = value;
    }

    /**
     * Gets the value of the climateval property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getCLIMATEVAL() {
        return climateval;
    }

    /**
     * Sets the value of the climateval property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setCLIMATEVAL(String value) {
        this.climateval = value;
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
     * Gets the value of the sqfeet property.
     *
     * @return possible object is
     *         {@link Integer }
     */
    public Integer getSQFEET() {
        return sqfeet;
    }

    /**
     * Sets the value of the sqfeet property.
     *
     * @param value allowed object is
     *              {@link Integer }
     */
    public void setSQFEET(Integer value) {
        this.sqfeet = value;
    }

    /**
     * Gets the value of the features property.
     *
     * @return possible object is
     *         {@link Integer }
     */
    public Integer getFEATURES() {
        return features;
    }

    /**
     * Sets the value of the features property.
     *
     * @param value allowed object is
     *              {@link Integer }
     */
    public void setFEATURES(Integer value) {
        this.features = value;
    }

    /**
     * Gets the value of the featuresval property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getFEATURESVAL() {
        return featuresval;
    }

    /**
     * Sets the value of the featuresval property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setFEATURESVAL(String value) {
        this.featuresval = value;
    }

    /**
     * Gets the value of the accesstype property.
     *
     * @return possible object is
     *         {@link Integer }
     */
    public Integer getACCESSTYPE() {
        return accesstype;
    }

    /**
     * Sets the value of the accesstype property.
     *
     * @param value allowed object is
     *              {@link Integer }
     */
    public void setACCESSTYPE(Integer value) {
        this.accesstype = value;
    }

    /**
     * Gets the value of the accesstypeval property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getACCESSTYPEVAL() {
        return accesstypeval;
    }

    /**
     * Sets the value of the accesstypeval property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setACCESSTYPEVAL(String value) {
        this.accesstypeval = value;
    }

    /**
     * Gets the value of the door property.
     *
     * @return possible object is
     *         {@link Integer }
     */
    public Integer getDOOR() {
        return door;
    }

    /**
     * Sets the value of the door property.
     *
     * @param value allowed object is
     *              {@link Integer }
     */
    public void setDOOR(Integer value) {
        this.door = value;
    }

    /**
     * Gets the value of the doorval property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getDOORVAL() {
        return doorval;
    }

    /**
     * Sets the value of the doorval property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setDOORVAL(String value) {
        this.doorval = value;
    }

    /**
     * Gets the value of the price property.
     *
     * @return possible object is
     *         {@link BigDecimal }
     */
    public BigDecimal getPRICE() {
        return price;
    }

    /**
     * Sets the value of the price property.
     *
     * @param value allowed object is
     *              {@link BigDecimal }
     */
    public void setPRICE(BigDecimal value) {
        this.price = value;
    }

    /**
     * Gets the value of the lostdemandreason property.
     */
    public int getLOSTDEMANDREASON() {
        return lostdemandreason;
    }

    /**
     * Sets the value of the lostdemandreason property.
     */
    public void setLOSTDEMANDREASON(int value) {
        this.lostdemandreason = value;
    }

    /**
     * Gets the value of the inquirysource property.
     */
    public int getINQUIRYSOURCE() {
        return inquirysource;
    }

    /**
     * Sets the value of the inquirysource property.
     */
    public void setINQUIRYSOURCE(int value) {
        this.inquirysource = value;
    }

    /**
     * Gets the value of the prorateamt property.
     *
     * @return possible object is
     *         {@link BigDecimal }
     */
    public BigDecimal getPRORATEAMT() {
        return prorateamt;
    }

    /**
     * Sets the value of the prorateamt property.
     *
     * @param value allowed object is
     *              {@link BigDecimal }
     */
    public void setPRORATEAMT(BigDecimal value) {
        this.prorateamt = value;
    }

    /**
     * Gets the value of the adminfee property.
     *
     * @return possible object is
     *         {@link BigDecimal }
     */
    public BigDecimal getADMINFEE() {
        return adminfee;
    }

    /**
     * Sets the value of the adminfee property.
     *
     * @param value allowed object is
     *              {@link BigDecimal }
     */
    public void setADMINFEE(BigDecimal value) {
        this.adminfee = value;
    }

    /**
     * Gets the value of the tax property.
     *
     * @return possible object is
     *         {@link BigDecimal }
     */
    public BigDecimal getTAX() {
        return tax;
    }

    /**
     * Sets the value of the tax property.
     *
     * @param value allowed object is
     *              {@link BigDecimal }
     */
    public void setTAX(BigDecimal value) {
        this.tax = value;
    }

    /**
     * Gets the value of the deposit property.
     *
     * @return possible object is
     *         {@link BigDecimal }
     */
    public BigDecimal getDEPOSIT() {
        return deposit;
    }

    /**
     * Sets the value of the deposit property.
     *
     * @param value allowed object is
     *              {@link BigDecimal }
     */
    public void setDEPOSIT(BigDecimal value) {
        this.deposit = value;
    }

    /**
     * Gets the value of the discamt property.
     *
     * @return possible object is
     *         {@link BigDecimal }
     */
    public BigDecimal getDISCAMT() {
        return discamt;
    }

    /**
     * Sets the value of the discamt property.
     *
     * @param value allowed object is
     *              {@link BigDecimal }
     */
    public void setDISCAMT(BigDecimal value) {
        this.discamt = value;
    }

    /**
     * Gets the value of the totamt property.
     *
     * @return possible object is
     *         {@link BigDecimal }
     */
    public BigDecimal getTOTAMT() {
        return totamt;
    }

    /**
     * Sets the value of the totamt property.
     *
     * @param value allowed object is
     *              {@link BigDecimal }
     */
    public void setTOTAMT(BigDecimal value) {
        this.totamt = value;
    }

    /**
     * Gets the value of the quotestartdate property.
     *
     * @return possible object is
     *         {@link XMLGregorianCalendar }
     */
    public XMLGregorianCalendar getQUOTESTARTDATE() {
        return quotestartdate;
    }

    /**
     * Sets the value of the quotestartdate property.
     *
     * @param value allowed object is
     *              {@link XMLGregorianCalendar }
     */
    public void setQUOTESTARTDATE(XMLGregorianCalendar value) {
        this.quotestartdate = value;
    }

    /**
     * Gets the value of the channel property.
     *
     * @return possible object is
     *         {@link Integer }
     */
    public Integer getCHANNEL() {
        return channel;
    }

    /**
     * Sets the value of the channel property.
     *
     * @param value allowed object is
     *              {@link Integer }
     */
    public void setCHANNEL(Integer value) {
        this.channel = value;
    }

    /**
     * Gets the value of the mktcode property.
     *
     * @return possible object is
     *         {@link Long }
     */
    public Long getMKTCODE() {
        return mktcode;
    }

    /**
     * Sets the value of the mktcode property.
     *
     * @param value allowed object is
     *              {@link Long }
     */
    public void setMKTCODE(Long value) {
        this.mktcode = value;
    }

    /**
     * Gets the value of the mktsource property.
     *
     * @return possible object is
     *         {@link Long }
     */
    public Long getMKTSOURCE() {
        return mktsource;
    }

    /**
     * Sets the value of the mktsource property.
     *
     * @param value allowed object is
     *              {@link Long }
     */
    public void setMKTSOURCE(Long value) {
        this.mktsource = value;
    }

    /**
     * Gets the value of the resdeposit property.
     *
     * @return possible object is
     *         {@link BigDecimal }
     */
    public BigDecimal getRESDEPOSIT() {
        return resdeposit;
    }

    /**
     * Sets the value of the resdeposit property.
     *
     * @param value allowed object is
     *              {@link BigDecimal }
     */
    public void setRESDEPOSIT(BigDecimal value) {
        this.resdeposit = value;
    }

    /**
     * Gets the value of the created property.
     *
     * @return possible object is
     *         {@link XMLGregorianCalendar }
     */
    public XMLGregorianCalendar getCREATED() {
        return created;
    }

    /**
     * Sets the value of the created property.
     *
     * @param value allowed object is
     *              {@link XMLGregorianCalendar }
     */
    public void setCREATED(XMLGregorianCalendar value) {
        this.created = value;
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
     * Gets the value of the createdbyname property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getCREATEDBYNAME() {
        return createdbyname;
    }

    /**
     * Sets the value of the createdbyname property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setCREATEDBYNAME(String value) {
        this.createdbyname = value;
    }

    /**
     * Gets the value of the streetrate property.
     *
     * @return possible object is
     *         {@link BigDecimal }
     */
    public BigDecimal getSTREETRATE() {
        return streetrate;
    }

    /**
     * Sets the value of the streetrate property.
     *
     * @param value allowed object is
     *              {@link BigDecimal }
     */
    public void setSTREETRATE(BigDecimal value) {
        this.streetrate = value;
    }

    /**
     * Gets the value of the objperiod property.
     *
     * @return possible object is
     *         {@link Long }
     */
    public Long getOBJPERIOD() {
        return objperiod;
    }

    /**
     * Sets the value of the objperiod property.
     *
     * @param value allowed object is
     *              {@link Long }
     */
    public void setOBJPERIOD(Long value) {
        this.objperiod = value;
    }

    /**
     * Gets the value of the objperioduom property.
     *
     * @return possible object is
     *         {@link Integer }
     */
    public Integer getOBJPERIODUOM() {
        return objperioduom;
    }

    /**
     * Sets the value of the objperioduom property.
     *
     * @param value allowed object is
     *              {@link Integer }
     */
    public void setOBJPERIODUOM(Integer value) {
        this.objperioduom = value;
    }

    /**
     * Gets the value of the objperioduomval property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getOBJPERIODUOMVAL() {
        return objperioduomval;
    }

    /**
     * Sets the value of the objperioduomval property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setOBJPERIODUOMVAL(String value) {
        this.objperioduomval = value;
    }

    /**
     * Gets the value of the resgroupid property.
     *
     * @return possible object is
     *         {@link BigDecimal }
     */
    public BigDecimal getRESGROUPID() {
        return resgroupid;
    }

    /**
     * Sets the value of the resgroupid property.
     *
     * @param value allowed object is
     *              {@link BigDecimal }
     */
    public void setRESGROUPID(BigDecimal value) {
        this.resgroupid = value;
    }

    /**
     * Gets the value of the gatekeypad property.
     *
     * @return possible object is
     *         {@link Integer }
     */
    public Integer getGATEKEYPAD() {
        return gatekeypad;
    }

    /**
     * Sets the value of the gatekeypad property.
     *
     * @param value allowed object is
     *              {@link Integer }
     */
    public void setGATEKEYPAD(Integer value) {
        this.gatekeypad = value;
    }

    /**
     * Gets the value of the rentnow property.
     *
     * @return possible object is
     *         {@link Boolean }
     */
    public Boolean isRENTNOW() {
        return rentnow;
    }

    /**
     * Sets the value of the rentnow property.
     *
     * @param value allowed object is
     *              {@link Boolean }
     */
    public void setRENTNOW(Boolean value) {
        this.rentnow = value;
    }

    /**
     * Gets the value of the updatedby property.
     */
    public long getUPDATEDBY() {
        return updatedby;
    }

    /**
     * Sets the value of the updatedby property.
     */
    public void setUPDATEDBY(long value) {
        this.updatedby = value;
    }

    /**
     * Gets the value of the tranquotepcd property.
     *
     * @return possible object is
     *         {@link ArrayOfTRANQUOTEPCD }
     */
    public ArrayOfTRANQUOTEPCD getTRANQUOTEPCD() {
        return tranquotepcd;
    }

    /**
     * Sets the value of the tranquotepcd property.
     *
     * @param value allowed object is
     *              {@link ArrayOfTRANQUOTEPCD }
     */
    public void setTRANQUOTEPCD(ArrayOfTRANQUOTEPCD value) {
        this.tranquotepcd = value;
    }

    /**
     * Gets the value of the tranquotepcddetail property.
     *
     * @return possible object is
     *         {@link ArrayOfTRANQUOTEPCDDETAIL }
     */
    public ArrayOfTRANQUOTEPCDDETAIL getTRANQUOTEPCDDETAIL() {
        return tranquotepcddetail;
    }

    /**
     * Sets the value of the tranquotepcddetail property.
     *
     * @param value allowed object is
     *              {@link ArrayOfTRANQUOTEPCDDETAIL }
     */
    public void setTRANQUOTEPCDDETAIL(ArrayOfTRANQUOTEPCDDETAIL value) {
        this.tranquotepcddetail = value;
    }

    /**
     * Gets the value of the tranquotenotesdetail property.
     *
     * @return possible object is
     *         {@link ArrayOfTRANQUOTENOTESDETAIL }
     */
    public ArrayOfTRANQUOTENOTESDETAIL getTRANQUOTENOTESDETAIL() {
        return tranquotenotesdetail;
    }

    /**
     * Sets the value of the tranquotenotesdetail property.
     *
     * @param value allowed object is
     *              {@link ArrayOfTRANQUOTENOTESDETAIL }
     */
    public void setTRANQUOTENOTESDETAIL(ArrayOfTRANQUOTENOTESDETAIL value) {
        this.tranquotenotesdetail = value;
    }

}
