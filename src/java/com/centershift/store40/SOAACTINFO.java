
package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SOA_ACT_INFO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SOA_ACT_INFO">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.centershift.com/STORE40/}BaseEntityOfCollectionSOA_ACT_INFOColumnIndexes">
 *       &lt;sequence>
 *         &lt;element name="ACCT_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="ACCT_NAME" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ACCT_TYPE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ACCT_CLASS" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CONTACT_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="FIRST_NAME" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LAST_NAME" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="KNOWN_AS" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ACTIVE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CONTACT_TYPE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CREATED_BY" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="UPDATED_BY" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SOA_ACT_INFO", propOrder = {
    "acctid",
    "acctname",
    "accttype",
    "acctclass",
    "contactid",
    "firstname",
    "lastname",
    "knownas",
    "active",
    "contacttype",
    "createdby",
    "updatedby"
})
public class SOAACTINFO
    extends BaseEntityOfCollectionSOAACTINFOColumnIndexes
{

    @XmlElement(name = "ACCT_ID")
    protected long acctid;
    @XmlElement(name = "ACCT_NAME")
    protected String acctname;
    @XmlElement(name = "ACCT_TYPE")
    protected String accttype;
    @XmlElement(name = "ACCT_CLASS")
    protected String acctclass;
    @XmlElement(name = "CONTACT_ID")
    protected long contactid;
    @XmlElement(name = "FIRST_NAME")
    protected String firstname;
    @XmlElement(name = "LAST_NAME")
    protected String lastname;
    @XmlElement(name = "KNOWN_AS")
    protected String knownas;
    @XmlElement(name = "ACTIVE")
    protected String active;
    @XmlElement(name = "CONTACT_TYPE")
    protected String contacttype;
    @XmlElement(name = "CREATED_BY")
    protected long createdby;
    @XmlElement(name = "UPDATED_BY")
    protected long updatedby;

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
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getACCTTYPE() {
        return accttype;
    }

    /**
     * Sets the value of the accttype property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setACCTTYPE(String value) {
        this.accttype = value;
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
     * Gets the value of the contacttype property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCONTACTTYPE() {
        return contacttype;
    }

    /**
     * Sets the value of the contacttype property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCONTACTTYPE(String value) {
        this.contacttype = value;
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

}
