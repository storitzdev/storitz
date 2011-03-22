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
 *         &lt;element name="GetGateCodeInfoResult" type="{http://www.centershift.com/STORE40/}GetGateCodeInfo_Response"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "getGateCodeInfoResult"
})
@XmlRootElement(name = "GetGateCodeInfoResponse")
public class GetGateCodeInfoResponse {

    @XmlElement(name = "GetGateCodeInfoResult", required = true)
    protected GetGateCodeInfoResponse2 getGateCodeInfoResult;

    /**
     * Gets the value of the getGateCodeInfoResult property.
     *
     * @return possible object is
     *         {@link GetGateCodeInfoResponse2 }
     */
    public GetGateCodeInfoResponse2 getGetGateCodeInfoResult() {
        return getGateCodeInfoResult;
    }

    /**
     * Sets the value of the getGateCodeInfoResult property.
     *
     * @param value allowed object is
     *              {@link GetGateCodeInfoResponse2 }
     */
    public void setGetGateCodeInfoResult(GetGateCodeInfoResponse2 value) {
        this.getGateCodeInfoResult = value;
    }

}
