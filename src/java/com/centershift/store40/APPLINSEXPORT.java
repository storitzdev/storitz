
package com.centershift.store40;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for APPL_INS_EXPORT complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="APPL_INS_EXPORT">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.centershift.com/STORE40/}BaseEntityOfCollectionAPPL_INS_EXPORTColumnIndexes">
 *       &lt;sequence>
 *         &lt;element name="PROVIDER_EXT_ID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SITE_REF_ID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ACCT_NAME" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FIRST_NAME" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LAST_NAME" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ADDR1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ADDR2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CITY" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="STATE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="POSTAL_CODE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="UNIT_NUMBER" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="START_DATE" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="COVERAGE_AMOUNT" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="COVERAGE_PERC" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="RATE" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="ACCT_CLASS" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ATTRIBUTE01" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ATTRIBUTE02" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SITE_NAME" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SITE_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="INS_OPTION_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="COVERAGE_GROUP_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="GROUP_NAME" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PROVIDER_NAME" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="INS_PROVIDER_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="ORG_NAME" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ORG_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="SITE_NUMBER" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SHORT_NAME" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "APPL_INS_EXPORT", propOrder = {
    "providerextid",
    "siterefid",
    "acctname",
    "firstname",
    "lastname",
    "addr1",
    "addr2",
    "city",
    "state",
    "postalcode",
    "unitnumber",
    "startdate",
    "coverageamount",
    "coverageperc",
    "rate",
    "acctclass",
    "attribute01",
    "attribute02",
    "sitename",
    "siteid",
    "insoptionid",
    "coveragegroupid",
    "groupname",
    "providername",
    "insproviderid",
    "orgname",
    "orgid",
    "sitenumber",
    "shortname"
})
public class APPLINSEXPORT
    extends BaseEntityOfCollectionAPPLINSEXPORTColumnIndexes
{

    @XmlElement(name = "PROVIDER_EXT_ID")
    protected String providerextid;
    @XmlElement(name = "SITE_REF_ID")
    protected String siterefid;
    @XmlElement(name = "ACCT_NAME")
    protected String acctname;
    @XmlElement(name = "FIRST_NAME")
    protected String firstname;
    @XmlElement(name = "LAST_NAME")
    protected String lastname;
    @XmlElement(name = "ADDR1")
    protected String addr1;
    @XmlElement(name = "ADDR2")
    protected String addr2;
    @XmlElement(name = "CITY")
    protected String city;
    @XmlElement(name = "STATE")
    protected String state;
    @XmlElement(name = "POSTAL_CODE")
    protected String postalcode;
    @XmlElement(name = "UNIT_NUMBER")
    protected String unitnumber;
    @XmlElement(name = "START_DATE", required = true, nillable = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar startdate;
    @XmlElement(name = "COVERAGE_AMOUNT")
    protected int coverageamount;
    @XmlElement(name = "COVERAGE_PERC", required = true, nillable = true)
    protected BigDecimal coverageperc;
    @XmlElement(name = "RATE", required = true)
    protected BigDecimal rate;
    @XmlElement(name = "ACCT_CLASS")
    protected String acctclass;
    @XmlElement(name = "ATTRIBUTE01")
    protected String attribute01;
    @XmlElement(name = "ATTRIBUTE02")
    protected String attribute02;
    @XmlElement(name = "SITE_NAME")
    protected String sitename;
    @XmlElement(name = "SITE_ID")
    protected long siteid;
    @XmlElement(name = "INS_OPTION_ID")
    protected long insoptionid;
    @XmlElement(name = "COVERAGE_GROUP_ID")
    protected long coveragegroupid;
    @XmlElement(name = "GROUP_NAME")
    protected String groupname;
    @XmlElement(name = "PROVIDER_NAME")
    protected String providername;
    @XmlElement(name = "INS_PROVIDER_ID")
    protected long insproviderid;
    @XmlElement(name = "ORG_NAME")
    protected String orgname;
    @XmlElement(name = "ORG_ID")
    protected long orgid;
    @XmlElement(name = "SITE_NUMBER")
    protected String sitenumber;
    @XmlElement(name = "SHORT_NAME")
    protected String shortname;

    /**
     * Gets the value of the providerextid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPROVIDEREXTID() {
        return providerextid;
    }

    /**
     * Sets the value of the providerextid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPROVIDEREXTID(String value) {
        this.providerextid = value;
    }

    /**
     * Gets the value of the siterefid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSITEREFID() {
        return siterefid;
    }

    /**
     * Sets the value of the siterefid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSITEREFID(String value) {
        this.siterefid = value;
    }

    /**
     * Gets the value of the acctname property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getACCTNAME() {
        return acctname;
    }

    /**
     * Sets the value of the acctname property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setACCTNAME(String value) {
        this.acctname = value;
    }

    /**
     * Gets the value of the firstname property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFIRSTNAME() {
        return firstname;
    }

    /**
     * Sets the value of the firstname property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFIRSTNAME(String value) {
        this.firstname = value;
    }

    /**
     * Gets the value of the lastname property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLASTNAME() {
        return lastname;
    }

    /**
     * Sets the value of the lastname property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLASTNAME(String value) {
        this.lastname = value;
    }

    /**
     * Gets the value of the addr1 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getADDR1() {
        return addr1;
    }

    /**
     * Sets the value of the addr1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setADDR1(String value) {
        this.addr1 = value;
    }

    /**
     * Gets the value of the addr2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getADDR2() {
        return addr2;
    }

    /**
     * Sets the value of the addr2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setADDR2(String value) {
        this.addr2 = value;
    }

    /**
     * Gets the value of the city property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCITY() {
        return city;
    }

    /**
     * Sets the value of the city property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCITY(String value) {
        this.city = value;
    }

    /**
     * Gets the value of the state property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSTATE() {
        return state;
    }

    /**
     * Sets the value of the state property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSTATE(String value) {
        this.state = value;
    }

    /**
     * Gets the value of the postalcode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPOSTALCODE() {
        return postalcode;
    }

    /**
     * Sets the value of the postalcode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPOSTALCODE(String value) {
        this.postalcode = value;
    }

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
     * Gets the value of the startdate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getSTARTDATE() {
        return startdate;
    }

    /**
     * Sets the value of the startdate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setSTARTDATE(XMLGregorianCalendar value) {
        this.startdate = value;
    }

    /**
     * Gets the value of the coverageamount property.
     * 
     */
    public int getCOVERAGEAMOUNT() {
        return coverageamount;
    }

    /**
     * Sets the value of the coverageamount property.
     * 
     */
    public void setCOVERAGEAMOUNT(int value) {
        this.coverageamount = value;
    }

    /**
     * Gets the value of the coverageperc property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getCOVERAGEPERC() {
        return coverageperc;
    }

    /**
     * Sets the value of the coverageperc property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setCOVERAGEPERC(BigDecimal value) {
        this.coverageperc = value;
    }

    /**
     * Gets the value of the rate property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getRATE() {
        return rate;
    }

    /**
     * Sets the value of the rate property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setRATE(BigDecimal value) {
        this.rate = value;
    }

    /**
     * Gets the value of the acctclass property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getACCTCLASS() {
        return acctclass;
    }

    /**
     * Sets the value of the acctclass property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setACCTCLASS(String value) {
        this.acctclass = value;
    }

    /**
     * Gets the value of the attribute01 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getATTRIBUTE01() {
        return attribute01;
    }

    /**
     * Sets the value of the attribute01 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setATTRIBUTE01(String value) {
        this.attribute01 = value;
    }

    /**
     * Gets the value of the attribute02 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getATTRIBUTE02() {
        return attribute02;
    }

    /**
     * Sets the value of the attribute02 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setATTRIBUTE02(String value) {
        this.attribute02 = value;
    }

    /**
     * Gets the value of the sitename property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSITENAME() {
        return sitename;
    }

    /**
     * Sets the value of the sitename property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSITENAME(String value) {
        this.sitename = value;
    }

    /**
     * Gets the value of the siteid property.
     * 
     */
    public long getSITEID() {
        return siteid;
    }

    /**
     * Sets the value of the siteid property.
     * 
     */
    public void setSITEID(long value) {
        this.siteid = value;
    }

    /**
     * Gets the value of the insoptionid property.
     * 
     */
    public long getINSOPTIONID() {
        return insoptionid;
    }

    /**
     * Sets the value of the insoptionid property.
     * 
     */
    public void setINSOPTIONID(long value) {
        this.insoptionid = value;
    }

    /**
     * Gets the value of the coveragegroupid property.
     * 
     */
    public long getCOVERAGEGROUPID() {
        return coveragegroupid;
    }

    /**
     * Sets the value of the coveragegroupid property.
     * 
     */
    public void setCOVERAGEGROUPID(long value) {
        this.coveragegroupid = value;
    }

    /**
     * Gets the value of the groupname property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGROUPNAME() {
        return groupname;
    }

    /**
     * Sets the value of the groupname property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGROUPNAME(String value) {
        this.groupname = value;
    }

    /**
     * Gets the value of the providername property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPROVIDERNAME() {
        return providername;
    }

    /**
     * Sets the value of the providername property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPROVIDERNAME(String value) {
        this.providername = value;
    }

    /**
     * Gets the value of the insproviderid property.
     * 
     */
    public long getINSPROVIDERID() {
        return insproviderid;
    }

    /**
     * Sets the value of the insproviderid property.
     * 
     */
    public void setINSPROVIDERID(long value) {
        this.insproviderid = value;
    }

    /**
     * Gets the value of the orgname property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getORGNAME() {
        return orgname;
    }

    /**
     * Sets the value of the orgname property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setORGNAME(String value) {
        this.orgname = value;
    }

    /**
     * Gets the value of the orgid property.
     * 
     */
    public long getORGID() {
        return orgid;
    }

    /**
     * Sets the value of the orgid property.
     * 
     */
    public void setORGID(long value) {
        this.orgid = value;
    }

    /**
     * Gets the value of the sitenumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSITENUMBER() {
        return sitenumber;
    }

    /**
     * Sets the value of the sitenumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSITENUMBER(String value) {
        this.sitenumber = value;
    }

    /**
     * Gets the value of the shortname property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSHORTNAME() {
        return shortname;
    }

    /**
     * Sets the value of the shortname property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSHORTNAME(String value) {
        this.shortname = value;
    }

}
