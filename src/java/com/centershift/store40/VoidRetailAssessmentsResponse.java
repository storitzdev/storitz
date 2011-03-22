package com.centershift.store40;

import javax.xml.bind.annotation.*;


/**
 * <p>Java class for anonymous complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="VoidRetailAssessmentsResult" type="{http://www.centershift.com/STORE40/}VoidRetailAssessment_Response"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "voidRetailAssessmentsResult"
})
@XmlRootElement(name = "VoidRetailAssessmentsResponse")
public class VoidRetailAssessmentsResponse {

    @XmlElement(name = "VoidRetailAssessmentsResult", required = true)
    protected VoidRetailAssessmentResponse voidRetailAssessmentsResult;

    /**
     * Gets the value of the voidRetailAssessmentsResult property.
     *
     * @return possible object is
     *         {@link VoidRetailAssessmentResponse }
     */
    public VoidRetailAssessmentResponse getVoidRetailAssessmentsResult() {
        return voidRetailAssessmentsResult;
    }

    /**
     * Sets the value of the voidRetailAssessmentsResult property.
     *
     * @param value allowed object is
     *              {@link VoidRetailAssessmentResponse }
     */
    public void setVoidRetailAssessmentsResult(VoidRetailAssessmentResponse value) {
        this.voidRetailAssessmentsResult = value;
    }

}
