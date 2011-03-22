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
 *         &lt;element name="GetAvailableServicesResult" type="{http://www.centershift.com/STORE40/}GetAvailableServices_Response"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "getAvailableServicesResult"
})
@XmlRootElement(name = "GetAvailableServicesResponse")
public class GetAvailableServicesResponse {

    @XmlElement(name = "GetAvailableServicesResult", required = true)
    protected GetAvailableServicesResponse2 getAvailableServicesResult;

    /**
     * Gets the value of the getAvailableServicesResult property.
     *
     * @return possible object is
     *         {@link GetAvailableServicesResponse2 }
     */
    public GetAvailableServicesResponse2 getGetAvailableServicesResult() {
        return getAvailableServicesResult;
    }

    /**
     * Sets the value of the getAvailableServicesResult property.
     *
     * @param value allowed object is
     *              {@link GetAvailableServicesResponse2 }
     */
    public void setGetAvailableServicesResult(GetAvailableServicesResponse2 value) {
        this.getAvailableServicesResult = value;
    }

}
