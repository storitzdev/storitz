package com.centershift.store40;

import javax.xml.bind.annotation.*;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for SOA_SITE_ATTRIBUTES complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="SOA_SITE_ATTRIBUTES">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.centershift.com/STORE40/}BaseEntityOfCollectionSOA_SITE_ATTRIBUTESColumnIndexes">
 *       &lt;sequence>
 *         &lt;element name="SITE_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="SITE_NAME" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SITE_NUMBER" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="GATE_TYPE_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="MAP_INDEX" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PHOTO_INDEX" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DIR_NORTH" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DIR_SOUTH" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DIR_EAST" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DIR_WEST" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SITE_HOURS" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="GATE_HOURS" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FACILITY_BUILT" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="GOLIVE" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="PARENT_SITE" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="EMAIL_ADDRESS" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PHONE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FAX" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ALT_PHONE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CFLEX01" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CFLEX02" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CFLEX03" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ADDRESS_LABEL" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LINE1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LINE2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LINE3" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CITY" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="STATE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="POSTAL_CODE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="COUNTRY" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PROPERTY_TYPE" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="TIMEZONE_OFFSET" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="APP_STATUS" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="APP_STATUS_VAL" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DISPLAY_NAME" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SOA_SITE_ATTRIBUTES", propOrder = {
        "siteid",
        "sitename",
        "sitenumber",
        "gatetypeid",
        "mapindex",
        "photoindex",
        "dirnorth",
        "dirsouth",
        "direast",
        "dirwest",
        "sitehours",
        "gatehours",
        "facilitybuilt",
        "golive",
        "parentsite",
        "emailaddress",
        "phone",
        "fax",
        "altphone",
        "cflex01",
        "cflex02",
        "cflex03",
        "addresslabel",
        "line1",
        "line2",
        "line3",
        "city",
        "state",
        "postalcode",
        "country",
        "propertytype",
        "timezoneoffset",
        "appstatus",
        "appstatusval",
        "displayname"
})
public class SOASITEATTRIBUTES
        extends BaseEntityOfCollectionSOASITEATTRIBUTESColumnIndexes {

    @XmlElement(name = "SITE_ID")
    protected long siteid;
    @XmlElement(name = "SITE_NAME")
    protected String sitename;
    @XmlElement(name = "SITE_NUMBER")
    protected String sitenumber;
    @XmlElement(name = "GATE_TYPE_ID", required = true, type = Long.class, nillable = true)
    protected Long gatetypeid;
    @XmlElement(name = "MAP_INDEX")
    protected String mapindex;
    @XmlElement(name = "PHOTO_INDEX")
    protected String photoindex;
    @XmlElement(name = "DIR_NORTH")
    protected String dirnorth;
    @XmlElement(name = "DIR_SOUTH")
    protected String dirsouth;
    @XmlElement(name = "DIR_EAST")
    protected String direast;
    @XmlElement(name = "DIR_WEST")
    protected String dirwest;
    @XmlElement(name = "SITE_HOURS")
    protected String sitehours;
    @XmlElement(name = "GATE_HOURS")
    protected String gatehours;
    @XmlElement(name = "FACILITY_BUILT", required = true, nillable = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar facilitybuilt;
    @XmlElement(name = "GOLIVE", required = true, nillable = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar golive;
    @XmlElement(name = "PARENT_SITE", required = true, type = Long.class, nillable = true)
    protected Long parentsite;
    @XmlElement(name = "EMAIL_ADDRESS")
    protected String emailaddress;
    @XmlElement(name = "PHONE")
    protected String phone;
    @XmlElement(name = "FAX")
    protected String fax;
    @XmlElement(name = "ALT_PHONE")
    protected String altphone;
    @XmlElement(name = "CFLEX01")
    protected String cflex01;
    @XmlElement(name = "CFLEX02")
    protected String cflex02;
    @XmlElement(name = "CFLEX03")
    protected String cflex03;
    @XmlElement(name = "ADDRESS_LABEL")
    protected String addresslabel;
    @XmlElement(name = "LINE1")
    protected String line1;
    @XmlElement(name = "LINE2")
    protected String line2;
    @XmlElement(name = "LINE3")
    protected String line3;
    @XmlElement(name = "CITY")
    protected String city;
    @XmlElement(name = "STATE")
    protected String state;
    @XmlElement(name = "POSTAL_CODE")
    protected String postalcode;
    @XmlElement(name = "COUNTRY")
    protected String country;
    @XmlElement(name = "PROPERTY_TYPE")
    protected int propertytype;
    @XmlElement(name = "TIMEZONE_OFFSET")
    protected int timezoneoffset;
    @XmlElement(name = "APP_STATUS")
    protected int appstatus;
    @XmlElement(name = "APP_STATUS_VAL")
    protected String appstatusval;
    @XmlElement(name = "DISPLAY_NAME")
    protected String displayname;

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
     * Gets the value of the sitenumber property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getSITENUMBER() {
        return sitenumber;
    }

    /**
     * Sets the value of the sitenumber property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setSITENUMBER(String value) {
        this.sitenumber = value;
    }

    /**
     * Gets the value of the gatetypeid property.
     *
     * @return possible object is
     *         {@link Long }
     */
    public Long getGATETYPEID() {
        return gatetypeid;
    }

    /**
     * Sets the value of the gatetypeid property.
     *
     * @param value allowed object is
     *              {@link Long }
     */
    public void setGATETYPEID(Long value) {
        this.gatetypeid = value;
    }

    /**
     * Gets the value of the mapindex property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getMAPINDEX() {
        return mapindex;
    }

    /**
     * Sets the value of the mapindex property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setMAPINDEX(String value) {
        this.mapindex = value;
    }

    /**
     * Gets the value of the photoindex property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getPHOTOINDEX() {
        return photoindex;
    }

    /**
     * Sets the value of the photoindex property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setPHOTOINDEX(String value) {
        this.photoindex = value;
    }

    /**
     * Gets the value of the dirnorth property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getDIRNORTH() {
        return dirnorth;
    }

    /**
     * Sets the value of the dirnorth property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setDIRNORTH(String value) {
        this.dirnorth = value;
    }

    /**
     * Gets the value of the dirsouth property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getDIRSOUTH() {
        return dirsouth;
    }

    /**
     * Sets the value of the dirsouth property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setDIRSOUTH(String value) {
        this.dirsouth = value;
    }

    /**
     * Gets the value of the direast property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getDIREAST() {
        return direast;
    }

    /**
     * Sets the value of the direast property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setDIREAST(String value) {
        this.direast = value;
    }

    /**
     * Gets the value of the dirwest property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getDIRWEST() {
        return dirwest;
    }

    /**
     * Sets the value of the dirwest property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setDIRWEST(String value) {
        this.dirwest = value;
    }

    /**
     * Gets the value of the sitehours property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getSITEHOURS() {
        return sitehours;
    }

    /**
     * Sets the value of the sitehours property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setSITEHOURS(String value) {
        this.sitehours = value;
    }

    /**
     * Gets the value of the gatehours property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getGATEHOURS() {
        return gatehours;
    }

    /**
     * Sets the value of the gatehours property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setGATEHOURS(String value) {
        this.gatehours = value;
    }

    /**
     * Gets the value of the facilitybuilt property.
     *
     * @return possible object is
     *         {@link XMLGregorianCalendar }
     */
    public XMLGregorianCalendar getFACILITYBUILT() {
        return facilitybuilt;
    }

    /**
     * Sets the value of the facilitybuilt property.
     *
     * @param value allowed object is
     *              {@link XMLGregorianCalendar }
     */
    public void setFACILITYBUILT(XMLGregorianCalendar value) {
        this.facilitybuilt = value;
    }

    /**
     * Gets the value of the golive property.
     *
     * @return possible object is
     *         {@link XMLGregorianCalendar }
     */
    public XMLGregorianCalendar getGOLIVE() {
        return golive;
    }

    /**
     * Sets the value of the golive property.
     *
     * @param value allowed object is
     *              {@link XMLGregorianCalendar }
     */
    public void setGOLIVE(XMLGregorianCalendar value) {
        this.golive = value;
    }

    /**
     * Gets the value of the parentsite property.
     *
     * @return possible object is
     *         {@link Long }
     */
    public Long getPARENTSITE() {
        return parentsite;
    }

    /**
     * Sets the value of the parentsite property.
     *
     * @param value allowed object is
     *              {@link Long }
     */
    public void setPARENTSITE(Long value) {
        this.parentsite = value;
    }

    /**
     * Gets the value of the emailaddress property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getEMAILADDRESS() {
        return emailaddress;
    }

    /**
     * Sets the value of the emailaddress property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setEMAILADDRESS(String value) {
        this.emailaddress = value;
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
     * Gets the value of the fax property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getFAX() {
        return fax;
    }

    /**
     * Sets the value of the fax property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setFAX(String value) {
        this.fax = value;
    }

    /**
     * Gets the value of the altphone property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getALTPHONE() {
        return altphone;
    }

    /**
     * Sets the value of the altphone property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setALTPHONE(String value) {
        this.altphone = value;
    }

    /**
     * Gets the value of the cflex01 property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getCFLEX01() {
        return cflex01;
    }

    /**
     * Sets the value of the cflex01 property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setCFLEX01(String value) {
        this.cflex01 = value;
    }

    /**
     * Gets the value of the cflex02 property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getCFLEX02() {
        return cflex02;
    }

    /**
     * Sets the value of the cflex02 property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setCFLEX02(String value) {
        this.cflex02 = value;
    }

    /**
     * Gets the value of the cflex03 property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getCFLEX03() {
        return cflex03;
    }

    /**
     * Sets the value of the cflex03 property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setCFLEX03(String value) {
        this.cflex03 = value;
    }

    /**
     * Gets the value of the addresslabel property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getADDRESSLABEL() {
        return addresslabel;
    }

    /**
     * Sets the value of the addresslabel property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setADDRESSLABEL(String value) {
        this.addresslabel = value;
    }

    /**
     * Gets the value of the line1 property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getLINE1() {
        return line1;
    }

    /**
     * Sets the value of the line1 property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setLINE1(String value) {
        this.line1 = value;
    }

    /**
     * Gets the value of the line2 property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getLINE2() {
        return line2;
    }

    /**
     * Sets the value of the line2 property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setLINE2(String value) {
        this.line2 = value;
    }

    /**
     * Gets the value of the line3 property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getLINE3() {
        return line3;
    }

    /**
     * Sets the value of the line3 property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setLINE3(String value) {
        this.line3 = value;
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
     * Gets the value of the propertytype property.
     */
    public int getPROPERTYTYPE() {
        return propertytype;
    }

    /**
     * Sets the value of the propertytype property.
     */
    public void setPROPERTYTYPE(int value) {
        this.propertytype = value;
    }

    /**
     * Gets the value of the timezoneoffset property.
     */
    public int getTIMEZONEOFFSET() {
        return timezoneoffset;
    }

    /**
     * Sets the value of the timezoneoffset property.
     */
    public void setTIMEZONEOFFSET(int value) {
        this.timezoneoffset = value;
    }

    /**
     * Gets the value of the appstatus property.
     */
    public int getAPPSTATUS() {
        return appstatus;
    }

    /**
     * Sets the value of the appstatus property.
     */
    public void setAPPSTATUS(int value) {
        this.appstatus = value;
    }

    /**
     * Gets the value of the appstatusval property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getAPPSTATUSVAL() {
        return appstatusval;
    }

    /**
     * Sets the value of the appstatusval property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setAPPSTATUSVAL(String value) {
        this.appstatusval = value;
    }

    /**
     * Gets the value of the displayname property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getDISPLAYNAME() {
        return displayname;
    }

    /**
     * Sets the value of the displayname property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setDISPLAYNAME(String value) {
        this.displayname = value;
    }

}
