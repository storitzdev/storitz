package com.centershift.store40;

import javax.xml.bind.annotation.*;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for ACT_CONTACTS_DEC complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="ACT_CONTACTS_DEC">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.centershift.com/STORE40/}BaseEntityOfCollectionACT_CONTACTS_DECColumnIndexes">
 *       &lt;sequence>
 *         &lt;element name="CONTACT_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="ACCT_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="FIRST_NAME" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LAST_NAME" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="KNOWN_AS" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CONTACT_TYPE" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="EMPLOYER" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ACTIVE" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="EMAIL" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DL_NUMBER" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DL_STATE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DOB" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SSN" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SSN_DEC" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ECOMM_CODE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CFLEX01" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CFLEX02" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CFLEX03" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CFLEX04" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CFLEX05" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CREATED" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="UPDATED" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="CREATED_BY" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="UPDATED_BY" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="ACCT_CONTACT_ADDRESSES" type="{http://www.centershift.com/STORE40/}ArrayOfACCT_CONTACT_ADDRESSES" minOccurs="0"/>
 *         &lt;element name="ACCT_CONTACT_PHONES" type="{http://www.centershift.com/STORE40/}ArrayOfACCT_CONTACT_PHONES" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ACT_CONTACTS_DEC", propOrder = {
        "contactid",
        "acctid",
        "firstname",
        "lastname",
        "knownas",
        "contacttype",
        "employer",
        "active",
        "email",
        "dlnumber",
        "dlstate",
        "dob",
        "ssn",
        "ssndec",
        "ecommcode",
        "cflex01",
        "cflex02",
        "cflex03",
        "cflex04",
        "cflex05",
        "created",
        "updated",
        "createdby",
        "updatedby",
        "acctcontactaddresses",
        "acctcontactphones"
})
public class ACTCONTACTSDEC
        extends BaseEntityOfCollectionACTCONTACTSDECColumnIndexes {

    @XmlElement(name = "CONTACT_ID")
    protected long contactid;
    @XmlElement(name = "ACCT_ID")
    protected long acctid;
    @XmlElement(name = "FIRST_NAME")
    protected String firstname;
    @XmlElement(name = "LAST_NAME")
    protected String lastname;
    @XmlElement(name = "KNOWN_AS")
    protected String knownas;
    @XmlElement(name = "CONTACT_TYPE")
    protected int contacttype;
    @XmlElement(name = "EMPLOYER")
    protected String employer;
    @XmlElement(name = "ACTIVE")
    protected boolean active;
    @XmlElement(name = "EMAIL")
    protected String email;
    @XmlElement(name = "DL_NUMBER")
    protected String dlnumber;
    @XmlElement(name = "DL_STATE")
    protected String dlstate;
    @XmlElement(name = "DOB")
    protected String dob;
    @XmlElement(name = "SSN")
    protected String ssn;
    @XmlElement(name = "SSN_DEC")
    protected String ssndec;
    @XmlElement(name = "ECOMM_CODE")
    protected String ecommcode;
    @XmlElement(name = "CFLEX01")
    protected String cflex01;
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
    @XmlElement(name = "ACCT_CONTACT_ADDRESSES")
    protected ArrayOfACCTCONTACTADDRESSES acctcontactaddresses;
    @XmlElement(name = "ACCT_CONTACT_PHONES")
    protected ArrayOfACCTCONTACTPHONES acctcontactphones;

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
     * Gets the value of the acctid property.
     */
    public long getACCTID() {
        return acctid;
    }

    /**
     * Sets the value of the acctid property.
     */
    public void setACCTID(long value) {
        this.acctid = value;
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
     * Gets the value of the contacttype property.
     */
    public int getCONTACTTYPE() {
        return contacttype;
    }

    /**
     * Sets the value of the contacttype property.
     */
    public void setCONTACTTYPE(int value) {
        this.contacttype = value;
    }

    /**
     * Gets the value of the employer property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getEMPLOYER() {
        return employer;
    }

    /**
     * Sets the value of the employer property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setEMPLOYER(String value) {
        this.employer = value;
    }

    /**
     * Gets the value of the active property.
     */
    public boolean isACTIVE() {
        return active;
    }

    /**
     * Sets the value of the active property.
     */
    public void setACTIVE(boolean value) {
        this.active = value;
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
     * Gets the value of the dlnumber property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getDLNUMBER() {
        return dlnumber;
    }

    /**
     * Sets the value of the dlnumber property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setDLNUMBER(String value) {
        this.dlnumber = value;
    }

    /**
     * Gets the value of the dlstate property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getDLSTATE() {
        return dlstate;
    }

    /**
     * Sets the value of the dlstate property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setDLSTATE(String value) {
        this.dlstate = value;
    }

    /**
     * Gets the value of the dob property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getDOB() {
        return dob;
    }

    /**
     * Sets the value of the dob property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setDOB(String value) {
        this.dob = value;
    }

    /**
     * Gets the value of the ssn property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getSSN() {
        return ssn;
    }

    /**
     * Sets the value of the ssn property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setSSN(String value) {
        this.ssn = value;
    }

    /**
     * Gets the value of the ssndec property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getSSNDEC() {
        return ssndec;
    }

    /**
     * Sets the value of the ssndec property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setSSNDEC(String value) {
        this.ssndec = value;
    }

    /**
     * Gets the value of the ecommcode property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getECOMMCODE() {
        return ecommcode;
    }

    /**
     * Sets the value of the ecommcode property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setECOMMCODE(String value) {
        this.ecommcode = value;
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
     * Gets the value of the cflex04 property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getCFLEX04() {
        return cflex04;
    }

    /**
     * Sets the value of the cflex04 property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setCFLEX04(String value) {
        this.cflex04 = value;
    }

    /**
     * Gets the value of the cflex05 property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getCFLEX05() {
        return cflex05;
    }

    /**
     * Sets the value of the cflex05 property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setCFLEX05(String value) {
        this.cflex05 = value;
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
     * Gets the value of the updated property.
     *
     * @return possible object is
     *         {@link XMLGregorianCalendar }
     */
    public XMLGregorianCalendar getUPDATED() {
        return updated;
    }

    /**
     * Sets the value of the updated property.
     *
     * @param value allowed object is
     *              {@link XMLGregorianCalendar }
     */
    public void setUPDATED(XMLGregorianCalendar value) {
        this.updated = value;
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
     * Gets the value of the acctcontactaddresses property.
     *
     * @return possible object is
     *         {@link ArrayOfACCTCONTACTADDRESSES }
     */
    public ArrayOfACCTCONTACTADDRESSES getACCTCONTACTADDRESSES() {
        return acctcontactaddresses;
    }

    /**
     * Sets the value of the acctcontactaddresses property.
     *
     * @param value allowed object is
     *              {@link ArrayOfACCTCONTACTADDRESSES }
     */
    public void setACCTCONTACTADDRESSES(ArrayOfACCTCONTACTADDRESSES value) {
        this.acctcontactaddresses = value;
    }

    /**
     * Gets the value of the acctcontactphones property.
     *
     * @return possible object is
     *         {@link ArrayOfACCTCONTACTPHONES }
     */
    public ArrayOfACCTCONTACTPHONES getACCTCONTACTPHONES() {
        return acctcontactphones;
    }

    /**
     * Sets the value of the acctcontactphones property.
     *
     * @param value allowed object is
     *              {@link ArrayOfACCTCONTACTPHONES }
     */
    public void setACCTCONTACTPHONES(ArrayOfACCTCONTACTPHONES value) {
        this.acctcontactphones = value;
    }

}
