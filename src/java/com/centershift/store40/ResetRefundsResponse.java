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
 *         &lt;element name="ResetRefundsResult" type="{http://www.centershift.com/STORE40/}Refund_Response"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "resetRefundsResult"
})
@XmlRootElement(name = "ResetRefundsResponse")
public class ResetRefundsResponse {

    @XmlElement(name = "ResetRefundsResult", required = true)
    protected RefundResponse resetRefundsResult;

    /**
     * Gets the value of the resetRefundsResult property.
     *
     * @return possible object is
     *         {@link RefundResponse }
     */
    public RefundResponse getResetRefundsResult() {
        return resetRefundsResult;
    }

    /**
     * Sets the value of the resetRefundsResult property.
     *
     * @param value allowed object is
     *              {@link RefundResponse }
     */
    public void setResetRefundsResult(RefundResponse value) {
        this.resetRefundsResult = value;
    }

}
