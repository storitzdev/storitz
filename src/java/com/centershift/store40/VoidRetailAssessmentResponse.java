package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VoidRetailAssessment_Response complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="VoidRetailAssessment_Response">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AssessData" type="{http://www.centershift.com/STORE40/}ArrayOfVoidRetailAssessmentData" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VoidRetailAssessment_Response", propOrder = {
        "assessData"
})
public class VoidRetailAssessmentResponse {

    @XmlElement(name = "AssessData")
    protected ArrayOfVoidRetailAssessmentData assessData;

    /**
     * Gets the value of the assessData property.
     *
     * @return possible object is
     *         {@link ArrayOfVoidRetailAssessmentData }
     */
    public ArrayOfVoidRetailAssessmentData getAssessData() {
        return assessData;
    }

    /**
     * Sets the value of the assessData property.
     *
     * @param value allowed object is
     *              {@link ArrayOfVoidRetailAssessmentData }
     */
    public void setAssessData(ArrayOfVoidRetailAssessmentData value) {
        this.assessData = value;
    }

}
