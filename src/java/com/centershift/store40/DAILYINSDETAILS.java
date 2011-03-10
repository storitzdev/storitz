
package com.centershift.store40;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for DAILY_INS_DETAILS complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DAILY_INS_DETAILS">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.centershift.com/STORE40/}BaseEntityOfCollectionDAILY_INS_DETAILSColumnIndexes">
 *       &lt;sequence>
 *         &lt;element name="RENTAL_ID" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="INS_EVENT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="INS_COVERAGE_AMT" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="INS_COVERAGE_PERC" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="INS_RATE" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="INS_START_DATE" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="INS_END_DATE" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="DIMENSIONS" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="UNIT_TYPE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LEASE_START" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="PAID_THRU_DATE" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="ACCOUNT_NAME" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ACCOUNT_CONTACT_NAME" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ADDRESS" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CITY" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="STATE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="POSTAL_CODE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PHONE_NUMBER" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="UNIT_ID" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="RECORD_TYPE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RECORD_DATE" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="SITE_ID" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="SITE_NAME" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SS_DATE" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="UNIT_NUMBER" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DAILY_INS_DETAILS", propOrder = {
    "rentalid",
    "insevent",
    "inscoverageamt",
    "inscoverageperc",
    "insrate",
    "insstartdate",
    "insenddate",
    "dimensions",
    "unittype",
    "leasestart",
    "paidthrudate",
    "accountname",
    "accountcontactname",
    "address",
    "city",
    "state",
    "postalcode",
    "phonenumber",
    "unitid",
    "recordtype",
    "recorddate",
    "siteid",
    "sitename",
    "ssdate",
    "unitnumber"
})
public class DAILYINSDETAILS
    extends BaseEntityOfCollectionDAILYINSDETAILSColumnIndexes
{

    @XmlElement(name = "RENTAL_ID", required = true, nillable = true)
    protected BigDecimal rentalid;
    @XmlElement(name = "INS_EVENT")
    protected String insevent;
    @XmlElement(name = "INS_COVERAGE_AMT", required = true, nillable = true)
    protected BigDecimal inscoverageamt;
    @XmlElement(name = "INS_COVERAGE_PERC", required = true, nillable = true)
    protected BigDecimal inscoverageperc;
    @XmlElement(name = "INS_RATE", required = true, nillable = true)
    protected BigDecimal insrate;
    @XmlElement(name = "INS_START_DATE", required = true, nillable = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar insstartdate;
    @XmlElement(name = "INS_END_DATE", required = true, nillable = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar insenddate;
    @XmlElement(name = "DIMENSIONS")
    protected String dimensions;
    @XmlElement(name = "UNIT_TYPE")
    protected String unittype;
    @XmlElement(name = "LEASE_START", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar leasestart;
    @XmlElement(name = "PAID_THRU_DATE", required = true, nillable = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar paidthrudate;
    @XmlElement(name = "ACCOUNT_NAME")
    protected String accountname;
    @XmlElement(name = "ACCOUNT_CONTACT_NAME")
    protected String accountcontactname;
    @XmlElement(name = "ADDRESS")
    protected String address;
    @XmlElement(name = "CITY")
    protected String city;
    @XmlElement(name = "STATE")
    protected String state;
    @XmlElement(name = "POSTAL_CODE")
    protected String postalcode;
    @XmlElement(name = "PHONE_NUMBER")
    protected String phonenumber;
    @XmlElement(name = "UNIT_ID", required = true)
    protected BigDecimal unitid;
    @XmlElement(name = "RECORD_TYPE")
    protected String recordtype;
    @XmlElement(name = "RECORD_DATE", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar recorddate;
    @XmlElement(name = "SITE_ID", required = true)
    protected BigDecimal siteid;
    @XmlElement(name = "SITE_NAME")
    protected String sitename;
    @XmlElement(name = "SS_DATE", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar ssdate;
    @XmlElement(name = "UNIT_NUMBER")
    protected String unitnumber;

    /**
     * Gets the value of the rentalid property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getRENTALID() {
        return rentalid;
    }

    /**
     * Sets the value of the rentalid property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setRENTALID(BigDecimal value) {
        this.rentalid = value;
    }

    /**
     * Gets the value of the insevent property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getINSEVENT() {
        return insevent;
    }

    /**
     * Sets the value of the insevent property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setINSEVENT(String value) {
        this.insevent = value;
    }

    /**
     * Gets the value of the inscoverageamt property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getINSCOVERAGEAMT() {
        return inscoverageamt;
    }

    /**
     * Sets the value of the inscoverageamt property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setINSCOVERAGEAMT(BigDecimal value) {
        this.inscoverageamt = value;
    }

    /**
     * Gets the value of the inscoverageperc property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getINSCOVERAGEPERC() {
        return inscoverageperc;
    }

    /**
     * Sets the value of the inscoverageperc property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setINSCOVERAGEPERC(BigDecimal value) {
        this.inscoverageperc = value;
    }

    /**
     * Gets the value of the insrate property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getINSRATE() {
        return insrate;
    }

    /**
     * Sets the value of the insrate property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setINSRATE(BigDecimal value) {
        this.insrate = value;
    }

    /**
     * Gets the value of the insstartdate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getINSSTARTDATE() {
        return insstartdate;
    }

    /**
     * Sets the value of the insstartdate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setINSSTARTDATE(XMLGregorianCalendar value) {
        this.insstartdate = value;
    }

    /**
     * Gets the value of the insenddate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getINSENDDATE() {
        return insenddate;
    }

    /**
     * Sets the value of the insenddate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setINSENDDATE(XMLGregorianCalendar value) {
        this.insenddate = value;
    }

    /**
     * Gets the value of the dimensions property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDIMENSIONS() {
        return dimensions;
    }

    /**
     * Sets the value of the dimensions property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDIMENSIONS(String value) {
        this.dimensions = value;
    }

    /**
     * Gets the value of the unittype property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUNITTYPE() {
        return unittype;
    }

    /**
     * Sets the value of the unittype property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUNITTYPE(String value) {
        this.unittype = value;
    }

    /**
     * Gets the value of the leasestart property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getLEASESTART() {
        return leasestart;
    }

    /**
     * Sets the value of the leasestart property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setLEASESTART(XMLGregorianCalendar value) {
        this.leasestart = value;
    }

    /**
     * Gets the value of the paidthrudate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getPAIDTHRUDATE() {
        return paidthrudate;
    }

    /**
     * Sets the value of the paidthrudate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setPAIDTHRUDATE(XMLGregorianCalendar value) {
        this.paidthrudate = value;
    }

    /**
     * Gets the value of the accountname property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getACCOUNTNAME() {
        return accountname;
    }

    /**
     * Sets the value of the accountname property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setACCOUNTNAME(String value) {
        this.accountname = value;
    }

    /**
     * Gets the value of the accountcontactname property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getACCOUNTCONTACTNAME() {
        return accountcontactname;
    }

    /**
     * Sets the value of the accountcontactname property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setACCOUNTCONTACTNAME(String value) {
        this.accountcontactname = value;
    }

    /**
     * Gets the value of the address property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getADDRESS() {
        return address;
    }

    /**
     * Sets the value of the address property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setADDRESS(String value) {
        this.address = value;
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
     * Gets the value of the phonenumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPHONENUMBER() {
        return phonenumber;
    }

    /**
     * Sets the value of the phonenumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPHONENUMBER(String value) {
        this.phonenumber = value;
    }

    /**
     * Gets the value of the unitid property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getUNITID() {
        return unitid;
    }

    /**
     * Sets the value of the unitid property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setUNITID(BigDecimal value) {
        this.unitid = value;
    }

    /**
     * Gets the value of the recordtype property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRECORDTYPE() {
        return recordtype;
    }

    /**
     * Sets the value of the recordtype property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRECORDTYPE(String value) {
        this.recordtype = value;
    }

    /**
     * Gets the value of the recorddate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getRECORDDATE() {
        return recorddate;
    }

    /**
     * Sets the value of the recorddate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setRECORDDATE(XMLGregorianCalendar value) {
        this.recorddate = value;
    }

    /**
     * Gets the value of the siteid property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getSITEID() {
        return siteid;
    }

    /**
     * Sets the value of the siteid property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setSITEID(BigDecimal value) {
        this.siteid = value;
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
     * Gets the value of the ssdate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getSSDATE() {
        return ssdate;
    }

    /**
     * Sets the value of the ssdate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setSSDATE(XMLGregorianCalendar value) {
        this.ssdate = value;
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

}
