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
 *         &lt;element name="GetPrimaryRentalInfoResult" type="{http://www.centershift.com/STORE40/}GetPrimaryRentalInfo_Response"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "getPrimaryRentalInfoResult"
})
@XmlRootElement(name = "GetPrimaryRentalInfoResponse")
public class GetPrimaryRentalInfoResponse {

    @XmlElement(name = "GetPrimaryRentalInfoResult", required = true)
    protected GetPrimaryRentalInfoResponse2 getPrimaryRentalInfoResult;

    /**
     * Gets the value of the getPrimaryRentalInfoResult property.
     *
     * @return possible object is
     *         {@link GetPrimaryRentalInfoResponse2 }
     */
    public GetPrimaryRentalInfoResponse2 getGetPrimaryRentalInfoResult() {
        return getPrimaryRentalInfoResult;
    }

    /**
     * Sets the value of the getPrimaryRentalInfoResult property.
     *
     * @param value allowed object is
     *              {@link GetPrimaryRentalInfoResponse2 }
     */
    public void setGetPrimaryRentalInfoResult(GetPrimaryRentalInfoResponse2 value) {
        this.getPrimaryRentalInfoResult = value;
    }

}
