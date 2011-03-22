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
 *         &lt;element name="AssessFeeResult" type="{http://www.centershift.com/STORE40/}AssessFee_Response"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "assessFeeResult"
})
@XmlRootElement(name = "AssessFeeResponse")
public class AssessFeeResponse {

    @XmlElement(name = "AssessFeeResult", required = true)
    protected AssessFeeResponse2 assessFeeResult;

    /**
     * Gets the value of the assessFeeResult property.
     *
     * @return possible object is
     *         {@link AssessFeeResponse2 }
     */
    public AssessFeeResponse2 getAssessFeeResult() {
        return assessFeeResult;
    }

    /**
     * Sets the value of the assessFeeResult property.
     *
     * @param value allowed object is
     *              {@link AssessFeeResponse2 }
     */
    public void setAssessFeeResult(AssessFeeResponse2 value) {
        this.assessFeeResult = value;
    }

}
