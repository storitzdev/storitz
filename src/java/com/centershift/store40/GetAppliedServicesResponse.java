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
 *         &lt;element name="GetAppliedServicesResult" type="{http://www.centershift.com/STORE40/}GetAppliedServices_Response"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "getAppliedServicesResult"
})
@XmlRootElement(name = "GetAppliedServicesResponse")
public class GetAppliedServicesResponse {

    @XmlElement(name = "GetAppliedServicesResult", required = true)
    protected GetAppliedServicesResponse2 getAppliedServicesResult;

    /**
     * Gets the value of the getAppliedServicesResult property.
     *
     * @return possible object is
     *         {@link GetAppliedServicesResponse2 }
     */
    public GetAppliedServicesResponse2 getGetAppliedServicesResult() {
        return getAppliedServicesResult;
    }

    /**
     * Sets the value of the getAppliedServicesResult property.
     *
     * @param value allowed object is
     *              {@link GetAppliedServicesResponse2 }
     */
    public void setGetAppliedServicesResult(GetAppliedServicesResponse2 value) {
        this.getAppliedServicesResult = value;
    }

}
