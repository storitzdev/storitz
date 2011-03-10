
package com.centershift.store40;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TransOldRentalData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TransOldRentalData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="RentalID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="TotalEscrow" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="Assessments" type="{http://www.centershift.com/STORE40/}ArrayOfTransRentalAssessments" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TransOldRentalData", propOrder = {
    "rentalID",
    "totalEscrow",
    "assessments"
})
public class TransOldRentalData {

    @XmlElement(name = "RentalID")
    protected long rentalID;
    @XmlElement(name = "TotalEscrow", required = true)
    protected BigDecimal totalEscrow;
    @XmlElement(name = "Assessments")
    protected ArrayOfTransRentalAssessments assessments;

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
     * Gets the value of the totalEscrow property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getTotalEscrow() {
        return totalEscrow;
    }

    /**
     * Sets the value of the totalEscrow property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setTotalEscrow(BigDecimal value) {
        this.totalEscrow = value;
    }

    /**
     * Gets the value of the assessments property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfTransRentalAssessments }
     *     
     */
    public ArrayOfTransRentalAssessments getAssessments() {
        return assessments;
    }

    /**
     * Sets the value of the assessments property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfTransRentalAssessments }
     *     
     */
    public void setAssessments(ArrayOfTransRentalAssessments value) {
        this.assessments = value;
    }

}
