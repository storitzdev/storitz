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
 *         &lt;element name="GetRefundsResult" type="{http://www.centershift.com/STORE40/}Refund_Response"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "getRefundsResult"
})
@XmlRootElement(name = "GetRefundsResponse")
public class GetRefundsResponse {

    @XmlElement(name = "GetRefundsResult", required = true)
    protected RefundResponse getRefundsResult;

    /**
     * Gets the value of the getRefundsResult property.
     *
     * @return possible object is
     *         {@link RefundResponse }
     */
    public RefundResponse getGetRefundsResult() {
        return getRefundsResult;
    }

    /**
     * Sets the value of the getRefundsResult property.
     *
     * @param value allowed object is
     *              {@link RefundResponse }
     */
    public void setGetRefundsResult(RefundResponse value) {
        this.getRefundsResult = value;
    }

}
