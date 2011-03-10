
package com.centershift.store40;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GetAssessmentsByID_Response complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetAssessmentsByID_Response">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Assessments" type="{http://www.centershift.com/STORE40/}ArrayOfSOA_GET_ASSESSMENTS" minOccurs="0"/>
 *         &lt;element name="TotalDue" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetAssessmentsByID_Response", propOrder = {
    "assessments",
    "totalDue"
})
public class GetAssessmentsByIDResponse2 {

    @XmlElement(name = "Assessments")
    protected ArrayOfSOAGETASSESSMENTS assessments;
    @XmlElement(name = "TotalDue", required = true)
    protected BigDecimal totalDue;

    /**
     * Gets the value of the assessments property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfSOAGETASSESSMENTS }
     *     
     */
    public ArrayOfSOAGETASSESSMENTS getAssessments() {
        return assessments;
    }

    /**
     * Sets the value of the assessments property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfSOAGETASSESSMENTS }
     *     
     */
    public void setAssessments(ArrayOfSOAGETASSESSMENTS value) {
        this.assessments = value;
    }

    /**
     * Gets the value of the totalDue property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getTotalDue() {
        return totalDue;
    }

    /**
     * Sets the value of the totalDue property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setTotalDue(BigDecimal value) {
        this.totalDue = value;
    }

}
