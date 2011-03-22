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
 *         &lt;element name="GetAvailableDiscountsResult" type="{http://www.centershift.com/STORE40/}GetAvailableDiscounts_Response"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "getAvailableDiscountsResult"
})
@XmlRootElement(name = "GetAvailableDiscountsResponse")
public class GetAvailableDiscountsResponse {

    @XmlElement(name = "GetAvailableDiscountsResult", required = true)
    protected GetAvailableDiscountsResponse2 getAvailableDiscountsResult;

    /**
     * Gets the value of the getAvailableDiscountsResult property.
     *
     * @return possible object is
     *         {@link GetAvailableDiscountsResponse2 }
     */
    public GetAvailableDiscountsResponse2 getGetAvailableDiscountsResult() {
        return getAvailableDiscountsResult;
    }

    /**
     * Sets the value of the getAvailableDiscountsResult property.
     *
     * @param value allowed object is
     *              {@link GetAvailableDiscountsResponse2 }
     */
    public void setGetAvailableDiscountsResult(GetAvailableDiscountsResponse2 value) {
        this.getAvailableDiscountsResult = value;
    }

}
