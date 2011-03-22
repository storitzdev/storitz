package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.math.BigDecimal;


/**
 * <p>Java class for CancelInsurance_Response complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="CancelInsurance_Response">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="RefundAmount" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CancelInsurance_Response", propOrder = {
        "refundAmount"
})
public class CancelInsuranceResponse {

    @XmlElement(name = "RefundAmount", required = true)
    protected BigDecimal refundAmount;

    /**
     * Gets the value of the refundAmount property.
     *
     * @return possible object is
     *         {@link BigDecimal }
     */
    public BigDecimal getRefundAmount() {
        return refundAmount;
    }

    /**
     * Sets the value of the refundAmount property.
     *
     * @param value allowed object is
     *              {@link BigDecimal }
     */
    public void setRefundAmount(BigDecimal value) {
        this.refundAmount = value;
    }

}
