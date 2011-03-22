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
 *         &lt;element name="GetRetailRefundAmountResult" type="{http://www.centershift.com/STORE40/}GetRetailRefundAmount_Response"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "getRetailRefundAmountResult"
})
@XmlRootElement(name = "GetRetailRefundAmountResponse")
public class GetRetailRefundAmountResponse {

    @XmlElement(name = "GetRetailRefundAmountResult", required = true)
    protected GetRetailRefundAmountResponse2 getRetailRefundAmountResult;

    /**
     * Gets the value of the getRetailRefundAmountResult property.
     *
     * @return possible object is
     *         {@link GetRetailRefundAmountResponse2 }
     */
    public GetRetailRefundAmountResponse2 getGetRetailRefundAmountResult() {
        return getRetailRefundAmountResult;
    }

    /**
     * Sets the value of the getRetailRefundAmountResult property.
     *
     * @param value allowed object is
     *              {@link GetRetailRefundAmountResponse2 }
     */
    public void setGetRetailRefundAmountResult(GetRetailRefundAmountResponse2 value) {
        this.getRetailRefundAmountResult = value;
    }

}
