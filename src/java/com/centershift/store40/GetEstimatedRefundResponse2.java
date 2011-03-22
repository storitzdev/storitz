package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.math.BigDecimal;


/**
 * <p>Java class for GetEstimatedRefund_Response complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="GetEstimatedRefund_Response">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="EstimatedRefundAmount" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetEstimatedRefund_Response", propOrder = {
        "estimatedRefundAmount"
})
public class GetEstimatedRefundResponse2 {

    @XmlElement(name = "EstimatedRefundAmount", required = true)
    protected BigDecimal estimatedRefundAmount;

    /**
     * Gets the value of the estimatedRefundAmount property.
     *
     * @return possible object is
     *         {@link BigDecimal }
     */
    public BigDecimal getEstimatedRefundAmount() {
        return estimatedRefundAmount;
    }

    /**
     * Sets the value of the estimatedRefundAmount property.
     *
     * @param value allowed object is
     *              {@link BigDecimal }
     */
    public void setEstimatedRefundAmount(BigDecimal value) {
        this.estimatedRefundAmount = value;
    }

}
