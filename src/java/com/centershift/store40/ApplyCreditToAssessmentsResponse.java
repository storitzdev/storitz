
package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ApplyCreditToAssessmentsResult" type="{http://www.centershift.com/STORE40/}ApplyCreditToAssessments_Response"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "applyCreditToAssessmentsResult"
})
@XmlRootElement(name = "ApplyCreditToAssessmentsResponse")
public class ApplyCreditToAssessmentsResponse {

    @XmlElement(name = "ApplyCreditToAssessmentsResult", required = true)
    protected ApplyCreditToAssessmentsResponse2 applyCreditToAssessmentsResult;

    /**
     * Gets the value of the applyCreditToAssessmentsResult property.
     * 
     * @return
     *     possible object is
     *     {@link ApplyCreditToAssessmentsResponse2 }
     *     
     */
    public ApplyCreditToAssessmentsResponse2 getApplyCreditToAssessmentsResult() {
        return applyCreditToAssessmentsResult;
    }

    /**
     * Sets the value of the applyCreditToAssessmentsResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ApplyCreditToAssessmentsResponse2 }
     *     
     */
    public void setApplyCreditToAssessmentsResult(ApplyCreditToAssessmentsResponse2 value) {
        this.applyCreditToAssessmentsResult = value;
    }

}
