
package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SOA_LOGIN complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SOA_LOGIN">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.centershift.com/STORE40/}BaseEntityOfCollectionSOA_LOGINColumnIndexes">
 *       &lt;sequence>
 *         &lt;element name="ORG_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="CONTACT_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="ACCT_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="FIRST_NAME" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LAST_NAME" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="KNOWN_AS" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CONTACT_TYPE" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="ACTIVE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="EMAIL" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ECOMM_CODE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CFLEX01" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CFLEX02" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CFLEX03" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CFLEX04" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CFLEX05" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SOA_LOGIN", propOrder = {
    "orgid",
    "contactid",
    "acctid",
    "firstname",
    "lastname",
    "knownas",
    "contacttype",
    "active",
    "email",
    "ecommcode",
    "cflex01",
    "cflex02",
    "cflex03",
    "cflex04",
    "cflex05"
})
public class SOALOGIN
    extends BaseEntityOfCollectionSOALOGINColumnIndexes
{

    @XmlElement(name = "ORG_ID")
    protected long orgid;
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
    @XmlElement(name = "ACTIVE")
    protected String active;
    @XmlElement(name = "EMAIL")
    protected String email;
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
     * Gets the value of the contactid property.
     * 
     */
    public long getCONTACTID() {
        return contactid;
    }

    /**
     * Sets the value of the contactid property.
     * 
     */
    public void setCONTACTID(long value) {
        this.contactid = value;
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
     * Gets the value of the knownas property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKNOWNAS() {
        return knownas;
    }

    /**
     * Sets the value of the knownas property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKNOWNAS(String value) {
        this.knownas = value;
    }

    /**
     * Gets the value of the contacttype property.
     * 
     */
    public int getCONTACTTYPE() {
        return contacttype;
    }

    /**
     * Sets the value of the contacttype property.
     * 
     */
    public void setCONTACTTYPE(int value) {
        this.contacttype = value;
    }

    /**
     * Gets the value of the active property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getACTIVE() {
        return active;
    }

    /**
     * Sets the value of the active property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setACTIVE(String value) {
        this.active = value;
    }

    /**
     * Gets the value of the email property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEMAIL() {
        return email;
    }

    /**
     * Sets the value of the email property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEMAIL(String value) {
        this.email = value;
    }

    /**
     * Gets the value of the ecommcode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getECOMMCODE() {
        return ecommcode;
    }

    /**
     * Sets the value of the ecommcode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setECOMMCODE(String value) {
        this.ecommcode = value;
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

}
