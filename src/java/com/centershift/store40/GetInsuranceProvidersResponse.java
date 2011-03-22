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
 *         &lt;element name="GetInsuranceProvidersResult" type="{http://www.centershift.com/STORE40/}GetInsuranceProviders_Response"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "getInsuranceProvidersResult"
})
@XmlRootElement(name = "GetInsuranceProvidersResponse")
public class GetInsuranceProvidersResponse {

    @XmlElement(name = "GetInsuranceProvidersResult", required = true)
    protected GetInsuranceProvidersResponse2 getInsuranceProvidersResult;

    /**
     * Gets the value of the getInsuranceProvidersResult property.
     *
     * @return possible object is
     *         {@link GetInsuranceProvidersResponse2 }
     */
    public GetInsuranceProvidersResponse2 getGetInsuranceProvidersResult() {
        return getInsuranceProvidersResult;
    }

    /**
     * Sets the value of the getInsuranceProvidersResult property.
     *
     * @param value allowed object is
     *              {@link GetInsuranceProvidersResponse2 }
     */
    public void setGetInsuranceProvidersResult(GetInsuranceProvidersResponse2 value) {
        this.getInsuranceProvidersResult = value;
    }

}
