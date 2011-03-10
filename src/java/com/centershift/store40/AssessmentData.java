
package com.centershift.store40;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AssessmentData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AssessmentData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AssessmentID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="AmountPayingForAssessment" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AssessmentData", propOrder = {
    "assessmentID",
    "amountPayingForAssessment"
})
public class AssessmentData {

    @XmlElement(name = "AssessmentID")
    protected long assessmentID;
    @XmlElement(name = "AmountPayingForAssessment", required = true)
    protected BigDecimal amountPayingForAssessment;

    /**
     * Gets the value of the assessmentID property.
     * 
     */
    public long getAssessmentID() {
        return assessmentID;
    }

    /**
     * Sets the value of the assessmentID property.
     * 
     */
    public void setAssessmentID(long value) {
        this.assessmentID = value;
    }

    /**
     * Gets the value of the amountPayingForAssessment property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getAmountPayingForAssessment() {
        return amountPayingForAssessment;
    }

    /**
     * Sets the value of the amountPayingForAssessment property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setAmountPayingForAssessment(BigDecimal value) {
        this.amountPayingForAssessment = value;
    }

}
