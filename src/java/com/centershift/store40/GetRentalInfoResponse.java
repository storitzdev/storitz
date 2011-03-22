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
 *         &lt;element name="GetRentalInfoResult" type="{http://www.centershift.com/STORE40/}GetRentalInfo_Response"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "getRentalInfoResult"
})
@XmlRootElement(name = "GetRentalInfoResponse")
public class GetRentalInfoResponse {

    @XmlElement(name = "GetRentalInfoResult", required = true)
    protected GetRentalInfoResponse2 getRentalInfoResult;

    /**
     * Gets the value of the getRentalInfoResult property.
     *
     * @return possible object is
     *         {@link GetRentalInfoResponse2 }
     */
    public GetRentalInfoResponse2 getGetRentalInfoResult() {
        return getRentalInfoResult;
    }

    /**
     * Sets the value of the getRentalInfoResult property.
     *
     * @param value allowed object is
     *              {@link GetRentalInfoResponse2 }
     */
    public void setGetRentalInfoResult(GetRentalInfoResponse2 value) {
        this.getRentalInfoResult = value;
    }

}
