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
 *         &lt;element name="GetAppliedInsuranceResult" type="{http://www.centershift.com/STORE40/}GetAppliedInsurance_Response"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "getAppliedInsuranceResult"
})
@XmlRootElement(name = "GetAppliedInsuranceResponse")
public class GetAppliedInsuranceResponse {

    @XmlElement(name = "GetAppliedInsuranceResult", required = true)
    protected GetAppliedInsuranceResponse2 getAppliedInsuranceResult;

    /**
     * Gets the value of the getAppliedInsuranceResult property.
     *
     * @return possible object is
     *         {@link GetAppliedInsuranceResponse2 }
     */
    public GetAppliedInsuranceResponse2 getGetAppliedInsuranceResult() {
        return getAppliedInsuranceResult;
    }

    /**
     * Sets the value of the getAppliedInsuranceResult property.
     *
     * @param value allowed object is
     *              {@link GetAppliedInsuranceResponse2 }
     */
    public void setGetAppliedInsuranceResult(GetAppliedInsuranceResponse2 value) {
        this.getAppliedInsuranceResult = value;
    }

}
