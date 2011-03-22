package com.centershift.store40;

import javax.xml.bind.annotation.*;
import javax.xml.datatype.XMLGregorianCalendar;
import java.math.BigDecimal;


/**
 * <p>Java class for SEARCH complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="SEARCH">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.centershift.com/STORE40/}BaseEntityOfCollectionSEARCHColumnIndexes">
 *       &lt;sequence>
 *         &lt;element name="QUICK_SEARCH" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BASIC_NAME_SEARCH" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="NETWORK_NAME_SEARCH" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ACCT_CONTACT_NAME_SEARCH" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PHONE_SEARCH" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PHONE_CONTACT_NAME_SEARCH" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DISPLAY_RENTAL_STR" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="UNIT_SEARCH" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RENTAL_ID" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="ACCT_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="CONTACT_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="OBJECT_ID" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="UNIT_NUMBER" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SITE_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="SITE_NAME" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ORG_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="RENTAL_STATUS" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RSTAT_RAW" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="ACCT_NAME" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FIRST_NAME" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LAST_NAME" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CONTACT_FULL_NAME" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PHONE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PHONE_TYPE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PTD" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="UNIT_STATUS" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AFFILIATE_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SEARCH", propOrder = {
        "quicksearch",
        "basicnamesearch",
        "networknamesearch",
        "acctcontactnamesearch",
        "phonesearch",
        "phonecontactnamesearch",
        "displayrentalstr",
        "unitsearch",
        "rentalid",
        "acctid",
        "contactid",
        "objectid",
        "unitnumber",
        "siteid",
        "sitename",
        "orgid",
        "rentalstatus",
        "rstatraw",
        "acctname",
        "firstname",
        "lastname",
        "contactfullname",
        "phone",
        "phonetype",
        "ptd",
        "unitstatus",
        "affiliateid"
})
public class SEARCH
        extends BaseEntityOfCollectionSEARCHColumnIndexes {

    @XmlElement(name = "QUICK_SEARCH")
    protected String quicksearch;
    @XmlElement(name = "BASIC_NAME_SEARCH")
    protected String basicnamesearch;
    @XmlElement(name = "NETWORK_NAME_SEARCH")
    protected String networknamesearch;
    @XmlElement(name = "ACCT_CONTACT_NAME_SEARCH")
    protected String acctcontactnamesearch;
    @XmlElement(name = "PHONE_SEARCH")
    protected String phonesearch;
    @XmlElement(name = "PHONE_CONTACT_NAME_SEARCH")
    protected String phonecontactnamesearch;
    @XmlElement(name = "DISPLAY_RENTAL_STR")
    protected String displayrentalstr;
    @XmlElement(name = "UNIT_SEARCH")
    protected String unitsearch;
    @XmlElement(name = "RENTAL_ID", required = true, nillable = true)
    protected BigDecimal rentalid;
    @XmlElement(name = "ACCT_ID", required = true, type = Long.class, nillable = true)
    protected Long acctid;
    @XmlElement(name = "CONTACT_ID", required = true, type = Long.class, nillable = true)
    protected Long contactid;
    @XmlElement(name = "OBJECT_ID", required = true, nillable = true)
    protected BigDecimal objectid;
    @XmlElement(name = "UNIT_NUMBER")
    protected String unitnumber;
    @XmlElement(name = "SITE_ID", required = true, type = Long.class, nillable = true)
    protected Long siteid;
    @XmlElement(name = "SITE_NAME")
    protected String sitename;
    @XmlElement(name = "ORG_ID", required = true, type = Long.class, nillable = true)
    protected Long orgid;
    @XmlElement(name = "RENTAL_STATUS")
    protected String rentalstatus;
    @XmlElement(name = "RSTAT_RAW", required = true, nillable = true)
    protected BigDecimal rstatraw;
    @XmlElement(name = "ACCT_NAME")
    protected String acctname;
    @XmlElement(name = "FIRST_NAME")
    protected String firstname;
    @XmlElement(name = "LAST_NAME")
    protected String lastname;
    @XmlElement(name = "CONTACT_FULL_NAME")
    protected String contactfullname;
    @XmlElement(name = "PHONE")
    protected String phone;
    @XmlElement(name = "PHONE_TYPE")
    protected String phonetype;
    @XmlElement(name = "PTD", required = true, nillable = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar ptd;
    @XmlElement(name = "UNIT_STATUS")
    protected String unitstatus;
    @XmlElement(name = "AFFILIATE_ID", required = true, type = Long.class, nillable = true)
    protected Long affiliateid;

    /**
     * Gets the value of the quicksearch property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getQUICKSEARCH() {
        return quicksearch;
    }

    /**
     * Sets the value of the quicksearch property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setQUICKSEARCH(String value) {
        this.quicksearch = value;
    }

    /**
     * Gets the value of the basicnamesearch property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getBASICNAMESEARCH() {
        return basicnamesearch;
    }

    /**
     * Sets the value of the basicnamesearch property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setBASICNAMESEARCH(String value) {
        this.basicnamesearch = value;
    }

    /**
     * Gets the value of the networknamesearch property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getNETWORKNAMESEARCH() {
        return networknamesearch;
    }

    /**
     * Sets the value of the networknamesearch property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setNETWORKNAMESEARCH(String value) {
        this.networknamesearch = value;
    }

    /**
     * Gets the value of the acctcontactnamesearch property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getACCTCONTACTNAMESEARCH() {
        return acctcontactnamesearch;
    }

    /**
     * Sets the value of the acctcontactnamesearch property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setACCTCONTACTNAMESEARCH(String value) {
        this.acctcontactnamesearch = value;
    }

    /**
     * Gets the value of the phonesearch property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getPHONESEARCH() {
        return phonesearch;
    }

    /**
     * Sets the value of the phonesearch property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setPHONESEARCH(String value) {
        this.phonesearch = value;
    }

    /**
     * Gets the value of the phonecontactnamesearch property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getPHONECONTACTNAMESEARCH() {
        return phonecontactnamesearch;
    }

    /**
     * Sets the value of the phonecontactnamesearch property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setPHONECONTACTNAMESEARCH(String value) {
        this.phonecontactnamesearch = value;
    }

    /**
     * Gets the value of the displayrentalstr property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getDISPLAYRENTALSTR() {
        return displayrentalstr;
    }

    /**
     * Sets the value of the displayrentalstr property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setDISPLAYRENTALSTR(String value) {
        this.displayrentalstr = value;
    }

    /**
     * Gets the value of the unitsearch property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getUNITSEARCH() {
        return unitsearch;
    }

    /**
     * Sets the value of the unitsearch property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setUNITSEARCH(String value) {
        this.unitsearch = value;
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
     *
     * @return possible object is
     *         {@link Long }
     */
    public Long getCONTACTID() {
        return contactid;
    }

    /**
     * Sets the value of the contactid property.
     *
     * @param value allowed object is
     *              {@link Long }
     */
    public void setCONTACTID(Long value) {
        this.contactid = value;
    }

    /**
     * Gets the value of the objectid property.
     *
     * @return possible object is
     *         {@link BigDecimal }
     */
    public BigDecimal getOBJECTID() {
        return objectid;
    }

    /**
     * Sets the value of the objectid property.
     *
     * @param value allowed object is
     *              {@link BigDecimal }
     */
    public void setOBJECTID(BigDecimal value) {
        this.objectid = value;
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
     * Gets the value of the orgid property.
     *
     * @return possible object is
     *         {@link Long }
     */
    public Long getORGID() {
        return orgid;
    }

    /**
     * Sets the value of the orgid property.
     *
     * @param value allowed object is
     *              {@link Long }
     */
    public void setORGID(Long value) {
        this.orgid = value;
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
     * Gets the value of the rstatraw property.
     *
     * @return possible object is
     *         {@link BigDecimal }
     */
    public BigDecimal getRSTATRAW() {
        return rstatraw;
    }

    /**
     * Sets the value of the rstatraw property.
     *
     * @param value allowed object is
     *              {@link BigDecimal }
     */
    public void setRSTATRAW(BigDecimal value) {
        this.rstatraw = value;
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
     * Gets the value of the contactfullname property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getCONTACTFULLNAME() {
        return contactfullname;
    }

    /**
     * Sets the value of the contactfullname property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setCONTACTFULLNAME(String value) {
        this.contactfullname = value;
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
     * Gets the value of the unitstatus property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getUNITSTATUS() {
        return unitstatus;
    }

    /**
     * Sets the value of the unitstatus property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setUNITSTATUS(String value) {
        this.unitstatus = value;
    }

    /**
     * Gets the value of the affiliateid property.
     *
     * @return possible object is
     *         {@link Long }
     */
    public Long getAFFILIATEID() {
        return affiliateid;
    }

    /**
     * Sets the value of the affiliateid property.
     *
     * @param value allowed object is
     *              {@link Long }
     */
    public void setAFFILIATEID(Long value) {
        this.affiliateid = value;
    }

}
