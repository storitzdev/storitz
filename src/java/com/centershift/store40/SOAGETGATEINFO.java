
package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SOA_GET_GATE_INFO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SOA_GET_GATE_INFO">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.centershift.com/STORE40/}BaseEntityOfCollectionSOA_GET_GATE_INFOColumnIndexes">
 *       &lt;sequence>
 *         &lt;element name="UNIT_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="FIRST_NAME" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LAST_NAME" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RENTAL_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="CONTACT_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="ACTIVE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ACCESS_LEVEL" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="GATE_CODE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PRIMARY_FLAG" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="GATE_24" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="GATE_TIMEZONE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="GATE_KEYPAD" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="GATE_LOCKOUT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SOA_GET_GATE_INFO", propOrder = {
    "unitid",
    "firstname",
    "lastname",
    "rentalid",
    "contactid",
    "active",
    "accesslevel",
    "gatecode",
    "primaryflag",
    "gate24",
    "gatetimezone",
    "gatekeypad",
    "gatelockout"
})
public class SOAGETGATEINFO
    extends BaseEntityOfCollectionSOAGETGATEINFOColumnIndexes
{

    @XmlElement(name = "UNIT_ID")
    protected long unitid;
    @XmlElement(name = "FIRST_NAME")
    protected String firstname;
    @XmlElement(name = "LAST_NAME")
    protected String lastname;
    @XmlElement(name = "RENTAL_ID")
    protected long rentalid;
    @XmlElement(name = "CONTACT_ID")
    protected long contactid;
    @XmlElement(name = "ACTIVE")
    protected String active;
    @XmlElement(name = "ACCESS_LEVEL")
    protected String accesslevel;
    @XmlElement(name = "GATE_CODE")
    protected String gatecode;
    @XmlElement(name = "PRIMARY_FLAG")
    protected String primaryflag;
    @XmlElement(name = "GATE_24")
    protected String gate24;
    @XmlElement(name = "GATE_TIMEZONE")
    protected String gatetimezone;
    @XmlElement(name = "GATE_KEYPAD")
    protected String gatekeypad;
    @XmlElement(name = "GATE_LOCKOUT")
    protected String gatelockout;

    /**
     * Gets the value of the unitid property.
     * 
     */
    public long getUNITID() {
        return unitid;
    }

    /**
     * Sets the value of the unitid property.
     * 
     */
    public void setUNITID(long value) {
        this.unitid = value;
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
     * Gets the value of the rentalid property.
     * 
     */
    public long getRENTALID() {
        return rentalid;
    }

    /**
     * Sets the value of the rentalid property.
     * 
     */
    public void setRENTALID(long value) {
        this.rentalid = value;
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
     * Gets the value of the accesslevel property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getACCESSLEVEL() {
        return accesslevel;
    }

    /**
     * Sets the value of the accesslevel property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setACCESSLEVEL(String value) {
        this.accesslevel = value;
    }

    /**
     * Gets the value of the gatecode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGATECODE() {
        return gatecode;
    }

    /**
     * Sets the value of the gatecode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGATECODE(String value) {
        this.gatecode = value;
    }

    /**
     * Gets the value of the primaryflag property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPRIMARYFLAG() {
        return primaryflag;
    }

    /**
     * Sets the value of the primaryflag property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPRIMARYFLAG(String value) {
        this.primaryflag = value;
    }

    /**
     * Gets the value of the gate24 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGATE24() {
        return gate24;
    }

    /**
     * Sets the value of the gate24 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGATE24(String value) {
        this.gate24 = value;
    }

    /**
     * Gets the value of the gatetimezone property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGATETIMEZONE() {
        return gatetimezone;
    }

    /**
     * Sets the value of the gatetimezone property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGATETIMEZONE(String value) {
        this.gatetimezone = value;
    }

    /**
     * Gets the value of the gatekeypad property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGATEKEYPAD() {
        return gatekeypad;
    }

    /**
     * Sets the value of the gatekeypad property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGATEKEYPAD(String value) {
        this.gatekeypad = value;
    }

    /**
     * Gets the value of the gatelockout property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGATELOCKOUT() {
        return gatelockout;
    }

    /**
     * Sets the value of the gatelockout property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGATELOCKOUT(String value) {
        this.gatelockout = value;
    }

}
