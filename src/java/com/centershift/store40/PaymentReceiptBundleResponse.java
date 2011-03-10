
package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="PaymentReceiptBundleResult" type="{http://www.centershift.com/STORE40/}PaymentReceiptBundle_Response"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "paymentReceiptBundleResult"
})
@XmlRootElement(name = "PaymentReceiptBundleResponse")
public class PaymentReceiptBundleResponse {

    @XmlElement(name = "PaymentReceiptBundleResult", required = true)
    protected PaymentReceiptBundleResponse2 paymentReceiptBundleResult;

    /**
     * Gets the value of the paymentReceiptBundleResult property.
     * 
     * @return
     *     possible object is
     *     {@link PaymentReceiptBundleResponse2 }
     *     
     */
    public PaymentReceiptBundleResponse2 getPaymentReceiptBundleResult() {
        return paymentReceiptBundleResult;
    }

    /**
     * Sets the value of the paymentReceiptBundleResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link PaymentReceiptBundleResponse2 }
     *     
     */
    public void setPaymentReceiptBundleResult(PaymentReceiptBundleResponse2 value) {
        this.paymentReceiptBundleResult = value;
    }

}
