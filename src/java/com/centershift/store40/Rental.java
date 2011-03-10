
package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for Rental complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Rental">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="RentalID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="AccountID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="StartDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="EndDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="PTD" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="LTD" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="DelExempt" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="DelSchedule" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="DelStep" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="OverlockStatus" type="{http://www.centershift.com/STORE40/}OverlockStatus"/>
 *         &lt;element name="MoveOutDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="TaxExempt" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="TaxExemptInfo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="InAuction" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Rental", propOrder = {
    "rentalID",
    "accountID",
    "startDate",
    "endDate",
    "ptd",
    "ltd",
    "delExempt",
    "delSchedule",
    "delStep",
    "overlockStatus",
    "moveOutDate",
    "taxExempt",
    "taxExemptInfo",
    "inAuction"
})
public class Rental {

    @XmlElement(name = "RentalID")
    protected long rentalID;
    @XmlElement(name = "AccountID")
    protected long accountID;
    @XmlElement(name = "StartDate", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar startDate;
    @XmlElement(name = "EndDate", required = true, nillable = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar endDate;
    @XmlElement(name = "PTD", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar ptd;
    @XmlElement(name = "LTD", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar ltd;
    @XmlElement(name = "DelExempt")
    protected boolean delExempt;
    @XmlElement(name = "DelSchedule", required = true, type = Long.class, nillable = true)
    protected Long delSchedule;
    @XmlElement(name = "DelStep")
    protected int delStep;
    @XmlElement(name = "OverlockStatus", required = true)
    protected OverlockStatus overlockStatus;
    @XmlElement(name = "MoveOutDate", required = true, nillable = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar moveOutDate;
    @XmlElement(name = "TaxExempt")
    protected boolean taxExempt;
    @XmlElement(name = "TaxExemptInfo")
    protected String taxExemptInfo;
    @XmlElement(name = "InAuction")
    protected boolean inAuction;

    /**
     * Gets the value of the rentalID property.
     * 
     */
    public long getRentalID() {
        return rentalID;
    }

    /**
     * Sets the value of the rentalID property.
     * 
     */
    public void setRentalID(long value) {
        this.rentalID = value;
    }

    /**
     * Gets the value of the accountID property.
     * 
     */
    public long getAccountID() {
        return accountID;
    }

    /**
     * Sets the value of the accountID property.
     * 
     */
    public void setAccountID(long value) {
        this.accountID = value;
    }

    /**
     * Gets the value of the startDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getStartDate() {
        return startDate;
    }

    /**
     * Sets the value of the startDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setStartDate(XMLGregorianCalendar value) {
        this.startDate = value;
    }

    /**
     * Gets the value of the endDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getEndDate() {
        return endDate;
    }

    /**
     * Sets the value of the endDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setEndDate(XMLGregorianCalendar value) {
        this.endDate = value;
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
     * Gets the value of the ltd property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getLTD() {
        return ltd;
    }

    /**
     * Sets the value of the ltd property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setLTD(XMLGregorianCalendar value) {
        this.ltd = value;
    }

    /**
     * Gets the value of the delExempt property.
     * 
     */
    public boolean isDelExempt() {
        return delExempt;
    }

    /**
     * Sets the value of the delExempt property.
     * 
     */
    public void setDelExempt(boolean value) {
        this.delExempt = value;
    }

    /**
     * Gets the value of the delSchedule property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getDelSchedule() {
        return delSchedule;
    }

    /**
     * Sets the value of the delSchedule property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setDelSchedule(Long value) {
        this.delSchedule = value;
    }

    /**
     * Gets the value of the delStep property.
     * 
     */
    public int getDelStep() {
        return delStep;
    }

    /**
     * Sets the value of the delStep property.
     * 
     */
    public void setDelStep(int value) {
        this.delStep = value;
    }

    /**
     * Gets the value of the overlockStatus property.
     * 
     * @return
     *     possible object is
     *     {@link OverlockStatus }
     *     
     */
    public OverlockStatus getOverlockStatus() {
        return overlockStatus;
    }

    /**
     * Sets the value of the overlockStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link OverlockStatus }
     *     
     */
    public void setOverlockStatus(OverlockStatus value) {
        this.overlockStatus = value;
    }

    /**
     * Gets the value of the moveOutDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getMoveOutDate() {
        return moveOutDate;
    }

    /**
     * Sets the value of the moveOutDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setMoveOutDate(XMLGregorianCalendar value) {
        this.moveOutDate = value;
    }

    /**
     * Gets the value of the taxExempt property.
     * 
     */
    public boolean isTaxExempt() {
        return taxExempt;
    }

    /**
     * Sets the value of the taxExempt property.
     * 
     */
    public void setTaxExempt(boolean value) {
        this.taxExempt = value;
    }

    /**
     * Gets the value of the taxExemptInfo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTaxExemptInfo() {
        return taxExemptInfo;
    }

    /**
     * Sets the value of the taxExemptInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTaxExemptInfo(String value) {
        this.taxExemptInfo = value;
    }

    /**
     * Gets the value of the inAuction property.
     * 
     */
    public boolean isInAuction() {
        return inAuction;
    }

    /**
     * Sets the value of the inAuction property.
     * 
     */
    public void setInAuction(boolean value) {
        this.inAuction = value;
    }

}
