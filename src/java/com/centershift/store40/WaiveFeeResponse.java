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
 *         &lt;element name="WaiveFeeResult" type="{http://www.centershift.com/STORE40/}WaiveFee_Response"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "waiveFeeResult"
})
@XmlRootElement(name = "WaiveFeeResponse")
public class WaiveFeeResponse {

    @XmlElement(name = "WaiveFeeResult", required = true)
    protected WaiveFeeResponse2 waiveFeeResult;

    /**
     * Gets the value of the waiveFeeResult property.
     *
     * @return possible object is
     *         {@link WaiveFeeResponse2 }
     */
    public WaiveFeeResponse2 getWaiveFeeResult() {
        return waiveFeeResult;
    }

    /**
     * Sets the value of the waiveFeeResult property.
     *
     * @param value allowed object is
     *              {@link WaiveFeeResponse2 }
     */
    public void setWaiveFeeResult(WaiveFeeResponse2 value) {
        this.waiveFeeResult = value;
    }

}
