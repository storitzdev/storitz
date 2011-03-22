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
 *         &lt;element name="MakePaymentByAssessmentResult" type="{http://www.centershift.com/STORE40/}MakePayment_Response"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "makePaymentByAssessmentResult"
})
@XmlRootElement(name = "MakePaymentByAssessmentResponse")
public class MakePaymentByAssessmentResponse {

    @XmlElement(name = "MakePaymentByAssessmentResult", required = true)
    protected MakePaymentResponse makePaymentByAssessmentResult;

    /**
     * Gets the value of the makePaymentByAssessmentResult property.
     *
     * @return possible object is
     *         {@link MakePaymentResponse }
     */
    public MakePaymentResponse getMakePaymentByAssessmentResult() {
        return makePaymentByAssessmentResult;
    }

    /**
     * Sets the value of the makePaymentByAssessmentResult property.
     *
     * @param value allowed object is
     *              {@link MakePaymentResponse }
     */
    public void setMakePaymentByAssessmentResult(MakePaymentResponse value) {
        this.makePaymentByAssessmentResult = value;
    }

}
