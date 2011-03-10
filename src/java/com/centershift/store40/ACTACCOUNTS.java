
package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for ACT_ACCOUNTS complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ACT_ACCOUNTS">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.centershift.com/STORE40/}BaseEntityOfCollectionACT_ACCOUNTSColumnIndexes">
 *       &lt;sequence>
 *         &lt;element name="CFLEX02" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CFLEX03" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CFLEX04" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CFLEX05" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CREATED" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="UPDATED" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="CREATED_BY" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="UPDATED_BY" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="ACCT_DEMOG" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="ADDR_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="SITE_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="ACCT_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="ORG_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="ACCT_NAME" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ACCT_TYPE" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="ACCT_CLASS" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="CFLEX01" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ACT_BUSINESS_CONTACT" type="{http://www.centershift.com/STORE40/}ArrayOfACT_CONTACTS_DEC" minOccurs="0"/>
 *         &lt;element name="ACT_NON_BUSINESS_CONTACTS" type="{http://www.centershift.com/STORE40/}ArrayOfACT_CONTACTS_DEC" minOccurs="0"/>
 *         &lt;element name="ACT_CONTACTS_DEC" type="{http://www.centershift.com/STORE40/}ArrayOfACT_CONTACTS_DEC" minOccurs="0"/>
 *         &lt;element name="APPL_ACCT_CFLEX_DATA" type="{http://www.centershift.com/STORE40/}ArrayOfAPPL_ACCT_CFLEX_DATA" minOccurs="0"/>
 *         &lt;element name="APPL_ORG_FLEX_FIELDS" type="{http://www.centershift.com/STORE40/}ArrayOfAPPL_ORG_FLEX_FIELDS" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ACT_ACCOUNTS", propOrder = {
    "cflex02",
    "cflex03",
    "cflex04",
    "cflex05",
    "created",
    "updated",
    "createdby",
    "updatedby",
    "acctdemog",
    "addrid",
    "siteid",
    "acctid",
    "orgid",
    "acctname",
    "accttype",
    "acctclass",
    "cflex01",
    "actbusinesscontact",
    "actnonbusinesscontacts",
    "actcontactsdec",
    "applacctcflexdata",
    "applorgflexfields"
})
public class ACTACCOUNTS
    extends BaseEntityOfCollectionACTACCOUNTSColumnIndexes
{

    @XmlElement(name = "CFLEX02")
    protected String cflex02;
    @XmlElement(name = "CFLEX03")
    protected String cflex03;
    @XmlElement(name = "CFLEX04")
    protected String cflex04;
    @XmlElement(name = "CFLEX05")
    protected String cflex05;
    @XmlElement(name = "CREATED", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar created;
    @XmlElement(name = "UPDATED", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar updated;
    @XmlElement(name = "CREATED_BY")
    protected long createdby;
    @XmlElement(name = "UPDATED_BY")
    protected long updatedby;
    @XmlElement(name = "ACCT_DEMOG")
    protected int acctdemog;
    @XmlElement(name = "ADDR_ID", required = true, type = Long.class, nillable = true)
    protected Long addrid;
    @XmlElement(name = "SITE_ID", required = true, type = Long.class, nillable = true)
    protected Long siteid;
    @XmlElement(name = "ACCT_ID")
    protected long acctid;
    @XmlElement(name = "ORG_ID")
    protected long orgid;
    @XmlElement(name = "ACCT_NAME")
    protected String acctname;
    @XmlElement(name = "ACCT_TYPE")
    protected int accttype;
    @XmlElement(name = "ACCT_CLASS")
    protected int acctclass;
    @XmlElement(name = "CFLEX01")
    protected String cflex01;
    @XmlElement(name = "ACT_BUSINESS_CONTACT")
    protected ArrayOfACTCONTACTSDEC actbusinesscontact;
    @XmlElement(name = "ACT_NON_BUSINESS_CONTACTS")
    protected ArrayOfACTCONTACTSDEC actnonbusinesscontacts;
    @XmlElement(name = "ACT_CONTACTS_DEC")
    protected ArrayOfACTCONTACTSDEC actcontactsdec;
    @XmlElement(name = "APPL_ACCT_CFLEX_DATA")
    protected ArrayOfAPPLACCTCFLEXDATA applacctcflexdata;
    @XmlElement(name = "APPL_ORG_FLEX_FIELDS")
    protected ArrayOfAPPLORGFLEXFIELDS applorgflexfields;

    /**
     * Gets the value of the cflex02 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCFLEX02() {
        return cflex02;
    }

    /**
     * Sets the value of the cflex02 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCFLEX02(String value) {
        this.cflex02 = value;
    }

    /**
     * Gets the value of the cflex03 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCFLEX03() {
        return cflex03;
    }

    /**
     * Sets the value of the cflex03 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCFLEX03(String value) {
        this.cflex03 = value;
    }

    /**
     * Gets the value of the cflex04 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCFLEX04() {
        return cflex04;
    }

    /**
     * Sets the value of the cflex04 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCFLEX04(String value) {
        this.cflex04 = value;
    }

    /**
     * Gets the value of the cflex05 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCFLEX05() {
        return cflex05;
    }

    /**
     * Sets the value of the cflex05 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCFLEX05(String value) {
        this.cflex05 = value;
    }

    /**
     * Gets the value of the created property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getCREATED() {
        return created;
    }

    /**
     * Sets the value of the created property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setCREATED(XMLGregorianCalendar value) {
        this.created = value;
    }

    /**
     * Gets the value of the updated property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getUPDATED() {
        return updated;
    }

    /**
     * Sets the value of the updated property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setUPDATED(XMLGregorianCalendar value) {
        this.updated = value;
    }

    /**
     * Gets the value of the createdby property.
     * 
     */
    public long getCREATEDBY() {
        return createdby;
    }

    /**
     * Sets the value of the createdby property.
     * 
     */
    public void setCREATEDBY(long value) {
        this.createdby = value;
    }

    /**
     * Gets the value of the updatedby property.
     * 
     */
    public long getUPDATEDBY() {
        return updatedby;
    }

    /**
     * Sets the value of the updatedby property.
     * 
     */
    public void setUPDATEDBY(long value) {
        this.updatedby = value;
    }

    /**
     * Gets the value of the acctdemog property.
     * 
     */
    public int getACCTDEMOG() {
        return acctdemog;
    }

    /**
     * Sets the value of the acctdemog property.
     * 
     */
    public void setACCTDEMOG(int value) {
        this.acctdemog = value;
    }

    /**
     * Gets the value of the addrid property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getADDRID() {
        return addrid;
    }

    /**
     * Sets the value of the addrid property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setADDRID(Long value) {
        this.addrid = value;
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
     * Gets the value of the acctid property.
     * 
     */
    public long getACCTID() {
        return acctid;
    }

    /**
     * Sets the value of the acctid property.
     * 
     */
    public void setACCTID(long value) {
        this.acctid = value;
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
     * Gets the value of the accttype property.
     * 
     */
    public int getACCTTYPE() {
        return accttype;
    }

    /**
     * Sets the value of the accttype property.
     * 
     */
    public void setACCTTYPE(int value) {
        this.accttype = value;
    }

    /**
     * Gets the value of the acctclass property.
     * 
     */
    public int getACCTCLASS() {
        return acctclass;
    }

    /**
     * Sets the value of the acctclass property.
     * 
     */
    public void setACCTCLASS(int value) {
        this.acctclass = value;
    }

    /**
     * Gets the value of the cflex01 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCFLEX01() {
        return cflex01;
    }

    /**
     * Sets the value of the cflex01 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCFLEX01(String value) {
        this.cflex01 = value;
    }

    /**
     * Gets the value of the actbusinesscontact property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfACTCONTACTSDEC }
     *     
     */
    public ArrayOfACTCONTACTSDEC getACTBUSINESSCONTACT() {
        return actbusinesscontact;
    }

    /**
     * Sets the value of the actbusinesscontact property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfACTCONTACTSDEC }
     *     
     */
    public void setACTBUSINESSCONTACT(ArrayOfACTCONTACTSDEC value) {
        this.actbusinesscontact = value;
    }

    /**
     * Gets the value of the actnonbusinesscontacts property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfACTCONTACTSDEC }
     *     
     */
    public ArrayOfACTCONTACTSDEC getACTNONBUSINESSCONTACTS() {
        return actnonbusinesscontacts;
    }

    /**
     * Sets the value of the actnonbusinesscontacts property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfACTCONTACTSDEC }
     *     
     */
    public void setACTNONBUSINESSCONTACTS(ArrayOfACTCONTACTSDEC value) {
        this.actnonbusinesscontacts = value;
    }

    /**
     * Gets the value of the actcontactsdec property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfACTCONTACTSDEC }
     *     
     */
    public ArrayOfACTCONTACTSDEC getACTCONTACTSDEC() {
        return actcontactsdec;
    }

    /**
     * Sets the value of the actcontactsdec property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfACTCONTACTSDEC }
     *     
     */
    public void setACTCONTACTSDEC(ArrayOfACTCONTACTSDEC value) {
        this.actcontactsdec = value;
    }

    /**
     * Gets the value of the applacctcflexdata property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfAPPLACCTCFLEXDATA }
     *     
     */
    public ArrayOfAPPLACCTCFLEXDATA getAPPLACCTCFLEXDATA() {
        return applacctcflexdata;
    }

    /**
     * Sets the value of the applacctcflexdata property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfAPPLACCTCFLEXDATA }
     *     
     */
    public void setAPPLACCTCFLEXDATA(ArrayOfAPPLACCTCFLEXDATA value) {
        this.applacctcflexdata = value;
    }

    /**
     * Gets the value of the applorgflexfields property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfAPPLORGFLEXFIELDS }
     *     
     */
    public ArrayOfAPPLORGFLEXFIELDS getAPPLORGFLEXFIELDS() {
        return applorgflexfields;
    }

    /**
     * Sets the value of the applorgflexfields property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfAPPLORGFLEXFIELDS }
     *     
     */
    public void setAPPLORGFLEXFIELDS(ArrayOfAPPLORGFLEXFIELDS value) {
        this.applorgflexfields = value;
    }

}
