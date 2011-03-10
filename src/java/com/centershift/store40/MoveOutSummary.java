
package com.centershift.store40;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for MoveOutSummary complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MoveOutSummary">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="GrossAmount" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="GrossTax" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="GrossTotal" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="WithheldAmount" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="WithheldTax" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="WithheldTotal" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="DueAmount" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="DueTax" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="DueTotal" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MoveOutSummary", propOrder = {
    "grossAmount",
    "grossTax",
    "grossTotal",
    "withheldAmount",
    "withheldTax",
    "withheldTotal",
    "dueAmount",
    "dueTax",
    "dueTotal"
})
public class MoveOutSummary {

    @XmlElement(name = "GrossAmount", required = true)
    protected BigDecimal grossAmount;
    @XmlElement(name = "GrossTax", required = true)
    protected BigDecimal grossTax;
    @XmlElement(name = "GrossTotal", required = true)
    protected BigDecimal grossTotal;
    @XmlElement(name = "WithheldAmount", required = true)
    protected BigDecimal withheldAmount;
    @XmlElement(name = "WithheldTax", required = true)
    protected BigDecimal withheldTax;
    @XmlElement(name = "WithheldTotal", required = true)
    protected BigDecimal withheldTotal;
    @XmlElement(name = "DueAmount", required = true)
    protected BigDecimal dueAmount;
    @XmlElement(name = "DueTax", required = true)
    protected BigDecimal dueTax;
    @XmlElement(name = "DueTotal", required = true)
    protected BigDecimal dueTotal;

    /**
     * Gets the value of the grossAmount property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getGrossAmount() {
        return grossAmount;
    }

    /**
     * Sets the value of the grossAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setGrossAmount(BigDecimal value) {
        this.grossAmount = value;
    }

    /**
     * Gets the value of the grossTax property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getGrossTax() {
        return grossTax;
    }

    /**
     * Sets the value of the grossTax property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setGrossTax(BigDecimal value) {
        this.grossTax = value;
    }

    /**
     * Gets the value of the grossTotal property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getGrossTotal() {
        return grossTotal;
    }

    /**
     * Sets the value of the grossTotal property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setGrossTotal(BigDecimal value) {
        this.grossTotal = value;
    }

    /**
     * Gets the value of the withheldAmount property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getWithheldAmount() {
        return withheldAmount;
    }

    /**
     * Sets the value of the withheldAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setWithheldAmount(BigDecimal value) {
        this.withheldAmount = value;
    }

    /**
     * Gets the value of the withheldTax property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getWithheldTax() {
        return withheldTax;
    }

    /**
     * Sets the value of the withheldTax property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setWithheldTax(BigDecimal value) {
        this.withheldTax = value;
    }

    /**
     * Gets the value of the withheldTotal property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getWithheldTotal() {
        return withheldTotal;
    }

    /**
     * Sets the value of the withheldTotal property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setWithheldTotal(BigDecimal value) {
        this.withheldTotal = value;
    }

    /**
     * Gets the value of the dueAmount property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getDueAmount() {
        return dueAmount;
    }

    /**
     * Sets the value of the dueAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setDueAmount(BigDecimal value) {
        this.dueAmount = value;
    }

    /**
     * Gets the value of the dueTax property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getDueTax() {
        return dueTax;
    }

    /**
     * Sets the value of the dueTax property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setDueTax(BigDecimal value) {
        this.dueTax = value;
    }

    /**
     * Gets the value of the dueTotal property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getDueTotal() {
        return dueTotal;
    }

    /**
     * Sets the value of the dueTotal property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setDueTotal(BigDecimal value) {
        this.dueTotal = value;
    }

}
