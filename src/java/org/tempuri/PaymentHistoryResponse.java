
package org.tempuri;

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
 *         &lt;element name="PaymentHistoryResult" type="{http://tempuri.org/}ArrayOfPaymentHistory_ST" minOccurs="0"/>
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
    "paymentHistoryResult"
})
@XmlRootElement(name = "PaymentHistoryResponse")
public class PaymentHistoryResponse {

    @XmlElement(name = "PaymentHistoryResult")
    protected ArrayOfPaymentHistoryST paymentHistoryResult;

    /**
     * Gets the value of the paymentHistoryResult property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfPaymentHistoryST }
     *     
     */
    public ArrayOfPaymentHistoryST getPaymentHistoryResult() {
        return paymentHistoryResult;
    }

    /**
     * Sets the value of the paymentHistoryResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfPaymentHistoryST }
     *     
     */
    public void setPaymentHistoryResult(ArrayOfPaymentHistoryST value) {
        this.paymentHistoryResult = value;
    }

}
