
package com.centershift.store40;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TransRentalAssessments complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TransRentalAssessments">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AssessID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="Description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Rate" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="RateTax" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="NetPrePaid" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="PrePaidTax" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="Credit" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="IsTransferrable" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TransRentalAssessments", propOrder = {
    "assessID",
    "description",
    "rate",
    "rateTax",
    "netPrePaid",
    "prePaidTax",
    "credit",
    "isTransferrable"
})
public class TransRentalAssessments {

    @XmlElement(name = "AssessID")
    protected long assessID;
    @XmlElement(name = "Description")
    protected String description;
    @XmlElement(name = "Rate", required = true)
    protected BigDecimal rate;
    @XmlElement(name = "RateTax", required = true)
    protected BigDecimal rateTax;
    @XmlElement(name = "NetPrePaid", required = true)
    protected BigDecimal netPrePaid;
    @XmlElement(name = "PrePaidTax", required = true)
    protected BigDecimal prePaidTax;
    @XmlElement(name = "Credit", required = true)
    protected BigDecimal credit;
    @XmlElement(name = "IsTransferrable")
    protected boolean isTransferrable;

    /**
     * Gets the value of the assessID property.
     * 
     */
    public long getAssessID() {
        return assessID;
    }

    /**
     * Sets the value of the assessID property.
     * 
     */
    public void setAssessID(long value) {
        this.assessID = value;
    }

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Gets the value of the rate property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getRate() {
        return rate;
    }

    /**
     * Sets the value of the rate property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setRate(BigDecimal value) {
        this.rate = value;
    }

    /**
     * Gets the value of the rateTax property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getRateTax() {
        return rateTax;
    }

    /**
     * Sets the value of the rateTax property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setRateTax(BigDecimal value) {
        this.rateTax = value;
    }

    /**
     * Gets the value of the netPrePaid property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getNetPrePaid() {
        return netPrePaid;
    }

    /**
     * Sets the value of the netPrePaid property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setNetPrePaid(BigDecimal value) {
        this.netPrePaid = value;
    }

    /**
     * Gets the value of the prePaidTax property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getPrePaidTax() {
        return prePaidTax;
    }

    /**
     * Sets the value of the prePaidTax property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setPrePaidTax(BigDecimal value) {
        this.prePaidTax = value;
    }

    /**
     * Gets the value of the credit property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getCredit() {
        return credit;
    }

    /**
     * Sets the value of the credit property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setCredit(BigDecimal value) {
        this.credit = value;
    }

    /**
     * Gets the value of the isTransferrable property.
     * 
     */
    public boolean isIsTransferrable() {
        return isTransferrable;
    }

    /**
     * Sets the value of the isTransferrable property.
     * 
     */
    public void setIsTransferrable(boolean value) {
        this.isTransferrable = value;
    }

}
