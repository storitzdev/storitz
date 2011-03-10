
package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for ACT_ADDR complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ACT_ADDR">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.centershift.com/STORE40/}BaseEntityOfCollectionACT_ADDRColumnIndexes">
 *       &lt;sequence>
 *         &lt;element name="ADDR_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="CONTACT_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="ADDR_TYPE" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="ADDR1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ADDR2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ADDR3" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CITY" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="STATE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="POSTAL_CODE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="COUNTRY" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ACTIVE" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="CREATED" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="UPDATED" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
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
@XmlType(name = "ACT_ADDR", propOrder = {
    "addrid",
    "contactid",
    "addrtype",
    "addr1",
    "addr2",
    "addr3",
    "city",
    "state",
    "postalcode",
    "country",
    "active",
    "created",
    "updated",
    "createdby",
    "updatedby"
})
public class ACTADDR
    extends BaseEntityOfCollectionACTADDRColumnIndexes
{

    @XmlElement(name = "ADDR_ID")
    protected long addrid;
    @XmlElement(name = "CONTACT_ID")
    protected long contactid;
    @XmlElement(name = "ADDR_TYPE")
    protected int addrtype;
    @XmlElement(name = "ADDR1")
    protected String addr1;
    @XmlElement(name = "ADDR2")
    protected String addr2;
    @XmlElement(name = "ADDR3")
    protected String addr3;
    @XmlElement(name = "CITY")
    protected String city;
    @XmlElement(name = "STATE")
    protected String state;
    @XmlElement(name = "POSTAL_CODE")
    protected String postalcode;
    @XmlElement(name = "COUNTRY")
    protected String country;
    @XmlElement(name = "ACTIVE")
    protected boolean active;
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

    /**
     * Gets the value of the addrid property.
     * 
     */
    public long getADDRID() {
        return addrid;
    }

    /**
     * Sets the value of the addrid property.
     * 
     */
    public void setADDRID(long value) {
        this.addrid = value;
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
     * Gets the value of the addrtype property.
     * 
     */
    public int getADDRTYPE() {
        return addrtype;
    }

    /**
     * Sets the value of the addrtype property.
     * 
     */
    public void setADDRTYPE(int value) {
        this.addrtype = value;
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
     * Gets the value of the addr3 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getADDR3() {
        return addr3;
    }

    /**
     * Sets the value of the addr3 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setADDR3(String value) {
        this.addr3 = value;
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
     * Gets the value of the country property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCOUNTRY() {
        return country;
    }

    /**
     * Sets the value of the country property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCOUNTRY(String value) {
        this.country = value;
    }

    /**
     * Gets the value of the active property.
     * 
     */
    public boolean isACTIVE() {
        return active;
    }

    /**
     * Sets the value of the active property.
     * 
     */
    public void setACTIVE(boolean value) {
        this.active = value;
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

}
