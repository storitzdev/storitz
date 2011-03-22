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
 *         &lt;element name="GetAccountInfoResult" type="{http://www.centershift.com/STORE40/}GetAccountInfo_Response"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "getAccountInfoResult"
})
@XmlRootElement(name = "GetAccountInfoResponse")
public class GetAccountInfoResponse {

    @XmlElement(name = "GetAccountInfoResult", required = true)
    protected GetAccountInfoResponse2 getAccountInfoResult;

    /**
     * Gets the value of the getAccountInfoResult property.
     *
     * @return possible object is
     *         {@link GetAccountInfoResponse2 }
     */
    public GetAccountInfoResponse2 getGetAccountInfoResult() {
        return getAccountInfoResult;
    }

    /**
     * Sets the value of the getAccountInfoResult property.
     *
     * @param value allowed object is
     *              {@link GetAccountInfoResponse2 }
     */
    public void setGetAccountInfoResult(GetAccountInfoResponse2 value) {
        this.getAccountInfoResult = value;
    }

}
