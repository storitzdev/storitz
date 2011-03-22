package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.math.BigDecimal;


/**
 * <p>Java class for APPL_RENTAL_OBJECTS_DETAIL complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="APPL_RENTAL_OBJECTS_DETAIL">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.centershift.com/STORE40/}BaseEntityOfCollectionAPPL_RENTAL_OBJECTS_DETAILColumnIndexes">
 *       &lt;sequence>
 *         &lt;element name="SITE_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="UNIT_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="ORG_CLASS_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="SITE_CLASS_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="CLASS_DESC" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CLASS_REF" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="ICON" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CLASS_TYPE" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="ACTIVE" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="STATUS" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="STATUS_VAL" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="UNIT_NUMBER" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ATTRIBUTE01" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="ATTRIBUTE01_VAL" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ATTRIBUTE02" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="ATTRIBUTE02_VAL" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ACCESS_TYPE" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="ACCESS_TYPE_VAL" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CLIMATE" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="CLIMATE_VAL" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DOOR" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="DOOR_VAL" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FEATURES" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="FEATURES_VAL" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="VOL_EXEMPT" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="PORTABLE" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="RENT_RATE" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="OBJ_PERIOD" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="OBJ_PERIOD_UOM" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="OBJ_PERIOD_UOM_VAL" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OBJ_INV_FREQ" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="FOM_IND" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="GP_MULTIPLIER" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="WIDTH" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="DEPTH" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="HEIGHT" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="VOLUME" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="SERIAL01" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="SERIAL02" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="NOTES" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="WALK_THRU_ORDER" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="LINK_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="TAX_GROUP_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="LEASE_GROUP_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="DEL_MODEL_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="RES_GROUP_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="DEP_GROUP_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="MUX" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="ALARM" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="VERSION" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="FEE_OBJECT_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="GATE_KEYPAD" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="CREATED_BY" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="UPDATED_BY" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="RES_AMOUNT" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="SQUARE_FEET" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "APPL_RENTAL_OBJECTS_DETAIL", propOrder = {
        "siteid",
        "unitid",
        "orgclassid",
        "siteclassid",
        "classdesc",
        "classref",
        "icon",
        "classtype",
        "active",
        "status",
        "statusval",
        "unitnumber",
        "attribute01",
        "attribute01VAL",
        "attribute02",
        "attribute02VAL",
        "accesstype",
        "accesstypeval",
        "climate",
        "climateval",
        "door",
        "doorval",
        "features",
        "featuresval",
        "volexempt",
        "portable",
        "rentrate",
        "objperiod",
        "objperioduom",
        "objperioduomval",
        "objinvfreq",
        "fomind",
        "gpmultiplier",
        "width",
        "depth",
        "height",
        "volume",
        "serial01",
        "serial02",
        "notes",
        "walkthruorder",
        "linkid",
        "taxgroupid",
        "leasegroupid",
        "delmodelid",
        "resgroupid",
        "depgroupid",
        "mux",
        "alarm",
        "version",
        "feeobjectid",
        "gatekeypad",
        "createdby",
        "updatedby",
        "resamount",
        "squarefeet"
})
public class APPLRENTALOBJECTSDETAIL
        extends BaseEntityOfCollectionAPPLRENTALOBJECTSDETAILColumnIndexes {

    @XmlElement(name = "SITE_ID")
    protected long siteid;
    @XmlElement(name = "UNIT_ID")
    protected long unitid;
    @XmlElement(name = "ORG_CLASS_ID")
    protected long orgclassid;
    @XmlElement(name = "SITE_CLASS_ID")
    protected long siteclassid;
    @XmlElement(name = "CLASS_DESC")
    protected String classdesc;
    @XmlElement(name = "CLASS_REF")
    protected int classref;
    @XmlElement(name = "ICON")
    protected String icon;
    @XmlElement(name = "CLASS_TYPE")
    protected int classtype;
    @XmlElement(name = "ACTIVE", required = true, type = Boolean.class, nillable = true)
    protected Boolean active;
    @XmlElement(name = "STATUS")
    protected int status;
    @XmlElement(name = "STATUS_VAL")
    protected String statusval;
    @XmlElement(name = "UNIT_NUMBER")
    protected String unitnumber;
    @XmlElement(name = "ATTRIBUTE01")
    protected int attribute01;
    @XmlElement(name = "ATTRIBUTE01_VAL")
    protected String attribute01VAL;
    @XmlElement(name = "ATTRIBUTE02", required = true, type = Integer.class, nillable = true)
    protected Integer attribute02;
    @XmlElement(name = "ATTRIBUTE02_VAL")
    protected String attribute02VAL;
    @XmlElement(name = "ACCESS_TYPE", required = true, type = Integer.class, nillable = true)
    protected Integer accesstype;
    @XmlElement(name = "ACCESS_TYPE_VAL")
    protected String accesstypeval;
    @XmlElement(name = "CLIMATE", required = true, type = Integer.class, nillable = true)
    protected Integer climate;
    @XmlElement(name = "CLIMATE_VAL")
    protected String climateval;
    @XmlElement(name = "DOOR", required = true, type = Integer.class, nillable = true)
    protected Integer door;
    @XmlElement(name = "DOOR_VAL")
    protected String doorval;
    @XmlElement(name = "FEATURES", required = true, type = Integer.class, nillable = true)
    protected Integer features;
    @XmlElement(name = "FEATURES_VAL")
    protected String featuresval;
    @XmlElement(name = "VOL_EXEMPT")
    protected boolean volexempt;
    @XmlElement(name = "PORTABLE")
    protected boolean portable;
    @XmlElement(name = "RENT_RATE", required = true, nillable = true)
    protected BigDecimal rentrate;
    @XmlElement(name = "OBJ_PERIOD")
    protected long objperiod;
    @XmlElement(name = "OBJ_PERIOD_UOM")
    protected int objperioduom;
    @XmlElement(name = "OBJ_PERIOD_UOM_VAL")
    protected String objperioduomval;
    @XmlElement(name = "OBJ_INV_FREQ")
    protected long objinvfreq;
    @XmlElement(name = "FOM_IND")
    protected String fomind;
    @XmlElement(name = "GP_MULTIPLIER", required = true)
    protected BigDecimal gpmultiplier;
    @XmlElement(name = "WIDTH", required = true, nillable = true)
    protected BigDecimal width;
    @XmlElement(name = "DEPTH", required = true, nillable = true)
    protected BigDecimal depth;
    @XmlElement(name = "HEIGHT", required = true, nillable = true)
    protected BigDecimal height;
    @XmlElement(name = "VOLUME", required = true, nillable = true)
    protected BigDecimal volume;
    @XmlElement(name = "SERIAL01", required = true, type = Long.class, nillable = true)
    protected Long serial01;
    @XmlElement(name = "SERIAL02", required = true, type = Long.class, nillable = true)
    protected Long serial02;
    @XmlElement(name = "NOTES")
    protected String notes;
    @XmlElement(name = "WALK_THRU_ORDER", required = true, type = Integer.class, nillable = true)
    protected Integer walkthruorder;
    @XmlElement(name = "LINK_ID", required = true, type = Long.class, nillable = true)
    protected Long linkid;
    @XmlElement(name = "TAX_GROUP_ID", required = true, type = Long.class, nillable = true)
    protected Long taxgroupid;
    @XmlElement(name = "LEASE_GROUP_ID", required = true, type = Long.class, nillable = true)
    protected Long leasegroupid;
    @XmlElement(name = "DEL_MODEL_ID", required = true, type = Long.class, nillable = true)
    protected Long delmodelid;
    @XmlElement(name = "RES_GROUP_ID", required = true, type = Long.class, nillable = true)
    protected Long resgroupid;
    @XmlElement(name = "DEP_GROUP_ID", required = true, type = Long.class, nillable = true)
    protected Long depgroupid;
    @XmlElement(name = "MUX", required = true, type = Integer.class, nillable = true)
    protected Integer mux;
    @XmlElement(name = "ALARM", required = true, type = Integer.class, nillable = true)
    protected Integer alarm;
    @XmlElement(name = "VERSION", required = true)
    protected BigDecimal version;
    @XmlElement(name = "FEE_OBJECT_ID", required = true, type = Long.class, nillable = true)
    protected Long feeobjectid;
    @XmlElement(name = "GATE_KEYPAD", required = true, type = Integer.class, nillable = true)
    protected Integer gatekeypad;
    @XmlElement(name = "CREATED_BY")
    protected long createdby;
    @XmlElement(name = "UPDATED_BY")
    protected long updatedby;
    @XmlElement(name = "RES_AMOUNT", required = true, nillable = true)
    protected BigDecimal resamount;
    @XmlElement(name = "SQUARE_FEET", required = true, nillable = true)
    protected BigDecimal squarefeet;

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
     * Gets the value of the orgclassid property.
     */
    public long getORGCLASSID() {
        return orgclassid;
    }

    /**
     * Sets the value of the orgclassid property.
     */
    public void setORGCLASSID(long value) {
        this.orgclassid = value;
    }

    /**
     * Gets the value of the siteclassid property.
     */
    public long getSITECLASSID() {
        return siteclassid;
    }

    /**
     * Sets the value of the siteclassid property.
     */
    public void setSITECLASSID(long value) {
        this.siteclassid = value;
    }

    /**
     * Gets the value of the classdesc property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getCLASSDESC() {
        return classdesc;
    }

    /**
     * Sets the value of the classdesc property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setCLASSDESC(String value) {
        this.classdesc = value;
    }

    /**
     * Gets the value of the classref property.
     */
    public int getCLASSREF() {
        return classref;
    }

    /**
     * Sets the value of the classref property.
     */
    public void setCLASSREF(int value) {
        this.classref = value;
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
     */
    public int getCLASSTYPE() {
        return classtype;
    }

    /**
     * Sets the value of the classtype property.
     */
    public void setCLASSTYPE(int value) {
        this.classtype = value;
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
     * Gets the value of the statusval property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getSTATUSVAL() {
        return statusval;
    }

    /**
     * Sets the value of the statusval property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setSTATUSVAL(String value) {
        this.statusval = value;
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
     * Gets the value of the attribute01 property.
     */
    public int getATTRIBUTE01() {
        return attribute01;
    }

    /**
     * Sets the value of the attribute01 property.
     */
    public void setATTRIBUTE01(int value) {
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
     * Gets the value of the volexempt property.
     */
    public boolean isVOLEXEMPT() {
        return volexempt;
    }

    /**
     * Sets the value of the volexempt property.
     */
    public void setVOLEXEMPT(boolean value) {
        this.volexempt = value;
    }

    /**
     * Gets the value of the portable property.
     */
    public boolean isPORTABLE() {
        return portable;
    }

    /**
     * Sets the value of the portable property.
     */
    public void setPORTABLE(boolean value) {
        this.portable = value;
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
     * Gets the value of the objperioduom property.
     */
    public int getOBJPERIODUOM() {
        return objperioduom;
    }

    /**
     * Sets the value of the objperioduom property.
     */
    public void setOBJPERIODUOM(int value) {
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
     * Gets the value of the objinvfreq property.
     */
    public long getOBJINVFREQ() {
        return objinvfreq;
    }

    /**
     * Sets the value of the objinvfreq property.
     */
    public void setOBJINVFREQ(long value) {
        this.objinvfreq = value;
    }

    /**
     * Gets the value of the fomind property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getFOMIND() {
        return fomind;
    }

    /**
     * Sets the value of the fomind property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setFOMIND(String value) {
        this.fomind = value;
    }

    /**
     * Gets the value of the gpmultiplier property.
     *
     * @return possible object is
     *         {@link BigDecimal }
     */
    public BigDecimal getGPMULTIPLIER() {
        return gpmultiplier;
    }

    /**
     * Sets the value of the gpmultiplier property.
     *
     * @param value allowed object is
     *              {@link BigDecimal }
     */
    public void setGPMULTIPLIER(BigDecimal value) {
        this.gpmultiplier = value;
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
     * Gets the value of the height property.
     *
     * @return possible object is
     *         {@link BigDecimal }
     */
    public BigDecimal getHEIGHT() {
        return height;
    }

    /**
     * Sets the value of the height property.
     *
     * @param value allowed object is
     *              {@link BigDecimal }
     */
    public void setHEIGHT(BigDecimal value) {
        this.height = value;
    }

    /**
     * Gets the value of the volume property.
     *
     * @return possible object is
     *         {@link BigDecimal }
     */
    public BigDecimal getVOLUME() {
        return volume;
    }

    /**
     * Sets the value of the volume property.
     *
     * @param value allowed object is
     *              {@link BigDecimal }
     */
    public void setVOLUME(BigDecimal value) {
        this.volume = value;
    }

    /**
     * Gets the value of the serial01 property.
     *
     * @return possible object is
     *         {@link Long }
     */
    public Long getSERIAL01() {
        return serial01;
    }

    /**
     * Sets the value of the serial01 property.
     *
     * @param value allowed object is
     *              {@link Long }
     */
    public void setSERIAL01(Long value) {
        this.serial01 = value;
    }

    /**
     * Gets the value of the serial02 property.
     *
     * @return possible object is
     *         {@link Long }
     */
    public Long getSERIAL02() {
        return serial02;
    }

    /**
     * Sets the value of the serial02 property.
     *
     * @param value allowed object is
     *              {@link Long }
     */
    public void setSERIAL02(Long value) {
        this.serial02 = value;
    }

    /**
     * Gets the value of the notes property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getNOTES() {
        return notes;
    }

    /**
     * Sets the value of the notes property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setNOTES(String value) {
        this.notes = value;
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
     * Gets the value of the linkid property.
     *
     * @return possible object is
     *         {@link Long }
     */
    public Long getLINKID() {
        return linkid;
    }

    /**
     * Sets the value of the linkid property.
     *
     * @param value allowed object is
     *              {@link Long }
     */
    public void setLINKID(Long value) {
        this.linkid = value;
    }

    /**
     * Gets the value of the taxgroupid property.
     *
     * @return possible object is
     *         {@link Long }
     */
    public Long getTAXGROUPID() {
        return taxgroupid;
    }

    /**
     * Sets the value of the taxgroupid property.
     *
     * @param value allowed object is
     *              {@link Long }
     */
    public void setTAXGROUPID(Long value) {
        this.taxgroupid = value;
    }

    /**
     * Gets the value of the leasegroupid property.
     *
     * @return possible object is
     *         {@link Long }
     */
    public Long getLEASEGROUPID() {
        return leasegroupid;
    }

    /**
     * Sets the value of the leasegroupid property.
     *
     * @param value allowed object is
     *              {@link Long }
     */
    public void setLEASEGROUPID(Long value) {
        this.leasegroupid = value;
    }

    /**
     * Gets the value of the delmodelid property.
     *
     * @return possible object is
     *         {@link Long }
     */
    public Long getDELMODELID() {
        return delmodelid;
    }

    /**
     * Sets the value of the delmodelid property.
     *
     * @param value allowed object is
     *              {@link Long }
     */
    public void setDELMODELID(Long value) {
        this.delmodelid = value;
    }

    /**
     * Gets the value of the resgroupid property.
     *
     * @return possible object is
     *         {@link Long }
     */
    public Long getRESGROUPID() {
        return resgroupid;
    }

    /**
     * Sets the value of the resgroupid property.
     *
     * @param value allowed object is
     *              {@link Long }
     */
    public void setRESGROUPID(Long value) {
        this.resgroupid = value;
    }

    /**
     * Gets the value of the depgroupid property.
     *
     * @return possible object is
     *         {@link Long }
     */
    public Long getDEPGROUPID() {
        return depgroupid;
    }

    /**
     * Sets the value of the depgroupid property.
     *
     * @param value allowed object is
     *              {@link Long }
     */
    public void setDEPGROUPID(Long value) {
        this.depgroupid = value;
    }

    /**
     * Gets the value of the mux property.
     *
     * @return possible object is
     *         {@link Integer }
     */
    public Integer getMUX() {
        return mux;
    }

    /**
     * Sets the value of the mux property.
     *
     * @param value allowed object is
     *              {@link Integer }
     */
    public void setMUX(Integer value) {
        this.mux = value;
    }

    /**
     * Gets the value of the alarm property.
     *
     * @return possible object is
     *         {@link Integer }
     */
    public Integer getALARM() {
        return alarm;
    }

    /**
     * Sets the value of the alarm property.
     *
     * @param value allowed object is
     *              {@link Integer }
     */
    public void setALARM(Integer value) {
        this.alarm = value;
    }

    /**
     * Gets the value of the version property.
     *
     * @return possible object is
     *         {@link BigDecimal }
     */
    public BigDecimal getVERSION() {
        return version;
    }

    /**
     * Sets the value of the version property.
     *
     * @param value allowed object is
     *              {@link BigDecimal }
     */
    public void setVERSION(BigDecimal value) {
        this.version = value;
    }

    /**
     * Gets the value of the feeobjectid property.
     *
     * @return possible object is
     *         {@link Long }
     */
    public Long getFEEOBJECTID() {
        return feeobjectid;
    }

    /**
     * Sets the value of the feeobjectid property.
     *
     * @param value allowed object is
     *              {@link Long }
     */
    public void setFEEOBJECTID(Long value) {
        this.feeobjectid = value;
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
     * Gets the value of the resamount property.
     *
     * @return possible object is
     *         {@link BigDecimal }
     */
    public BigDecimal getRESAMOUNT() {
        return resamount;
    }

    /**
     * Sets the value of the resamount property.
     *
     * @param value allowed object is
     *              {@link BigDecimal }
     */
    public void setRESAMOUNT(BigDecimal value) {
        this.resamount = value;
    }

    /**
     * Gets the value of the squarefeet property.
     *
     * @return possible object is
     *         {@link BigDecimal }
     */
    public BigDecimal getSQUAREFEET() {
        return squarefeet;
    }

    /**
     * Sets the value of the squarefeet property.
     *
     * @param value allowed object is
     *              {@link BigDecimal }
     */
    public void setSQUAREFEET(BigDecimal value) {
        this.squarefeet = value;
    }

}
