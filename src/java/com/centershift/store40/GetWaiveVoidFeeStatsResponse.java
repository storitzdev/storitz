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
 *         &lt;element name="GetWaiveVoidFeeStatsResult" type="{http://www.centershift.com/STORE40/}GetWaiveVoidFeeStats_Response"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "getWaiveVoidFeeStatsResult"
})
@XmlRootElement(name = "GetWaiveVoidFeeStatsResponse")
public class GetWaiveVoidFeeStatsResponse {

    @XmlElement(name = "GetWaiveVoidFeeStatsResult", required = true)
    protected GetWaiveVoidFeeStatsResponse2 getWaiveVoidFeeStatsResult;

    /**
     * Gets the value of the getWaiveVoidFeeStatsResult property.
     *
     * @return possible object is
     *         {@link GetWaiveVoidFeeStatsResponse2 }
     */
    public GetWaiveVoidFeeStatsResponse2 getGetWaiveVoidFeeStatsResult() {
        return getWaiveVoidFeeStatsResult;
    }

    /**
     * Sets the value of the getWaiveVoidFeeStatsResult property.
     *
     * @param value allowed object is
     *              {@link GetWaiveVoidFeeStatsResponse2 }
     */
    public void setGetWaiveVoidFeeStatsResult(GetWaiveVoidFeeStatsResponse2 value) {
        this.getWaiveVoidFeeStatsResult = value;
    }

}
