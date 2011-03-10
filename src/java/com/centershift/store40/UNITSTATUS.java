
package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for UNIT_STATUS complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="UNIT_STATUS">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="UnitID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="UnitNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AccountID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="AccountName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DelStep" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="PTD" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="DaysLate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Status" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Dimensions" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Attributes" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UNIT_STATUS", propOrder = {
    "unitID",
    "unitNumber",
    "accountID",
    "accountName",
    "delStep",
    "ptd",
    "daysLate",
    "status",
    "dimensions",
    "attributes"
})
public class UNITSTATUS {

    @XmlElement(name = "UnitID", required = true, type = Long.class, nillable = true)
    protected Long unitID;
    @XmlElement(name = "UnitNumber")
    protected String unitNumber;
    @XmlElement(name = "AccountID", required = true, type = Long.class, nillable = true)
    protected Long accountID;
    @XmlElement(name = "AccountName")
    protected String accountName;
    @XmlElement(name = "DelStep", required = true, type = Integer.class, nillable = true)
    protected Integer delStep;
    @XmlElement(name = "PTD", required = true, nillable = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar ptd;
    @XmlElement(name = "DaysLate")
    protected String daysLate;
    @XmlElement(name = "Status")
    protected String status;
    @XmlElement(name = "Dimensions")
    protected String dimensions;
    @XmlElement(name = "Attributes")
    protected String attributes;

    /**
     * Gets the value of the unitID property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getUnitID() {
        return unitID;
    }

    /**
     * Sets the value of the unitID property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setUnitID(Long value) {
        this.unitID = value;
    }

    /**
     * Gets the value of the unitNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUnitNumber() {
        return unitNumber;
    }

    /**
     * Sets the value of the unitNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUnitNumber(String value) {
        this.unitNumber = value;
    }

    /**
     * Gets the value of the accountID property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getAccountID() {
        return accountID;
    }

    /**
     * Sets the value of the accountID property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setAccountID(Long value) {
        this.accountID = value;
    }

    /**
     * Gets the value of the accountName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAccountName() {
        return accountName;
    }

    /**
     * Sets the value of the accountName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccountName(String value) {
        this.accountName = value;
    }

    /**
     * Gets the value of the delStep property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getDelStep() {
        return delStep;
    }

    /**
     * Sets the value of the delStep property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setDelStep(Integer value) {
        this.delStep = value;
    }

    /**
     * Gets the value of the ptd property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getPTD() {
        return ptd;
    }

    /**
     * Sets the value of the ptd property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setPTD(XMLGregorianCalendar value) {
        this.ptd = value;
    }

    /**
     * Gets the value of the daysLate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDaysLate() {
        return daysLate;
    }

    /**
     * Sets the value of the daysLate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDaysLate(String value) {
        this.daysLate = value;
    }

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatus(String value) {
        this.status = value;
    }

    /**
     * Gets the value of the dimensions property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDimensions() {
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
    public void setDimensions(String value) {
        this.dimensions = value;
    }

    /**
     * Gets the value of the attributes property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAttributes() {
        return attributes;
    }

    /**
     * Sets the value of the attributes property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAttributes(String value) {
        this.attributes = value;
    }

}
