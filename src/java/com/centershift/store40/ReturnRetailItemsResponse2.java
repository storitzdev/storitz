
package com.centershift.store40;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ReturnRetailItems_Response complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ReturnRetailItems_Response">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="NewReturnTransactionID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="RefundMessage" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TotalRefundAmount" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ReturnRetailItems_Response", propOrder = {
    "newReturnTransactionID",
    "refundMessage",
    "totalRefundAmount"
})
public class ReturnRetailItemsResponse2 {

    @XmlElement(name = "NewReturnTransactionID")
    protected long newReturnTransactionID;
    @XmlElement(name = "RefundMessage")
    protected String refundMessage;
    @XmlElement(name = "TotalRefundAmount", required = true)
    protected BigDecimal totalRefundAmount;

    /**
     * Gets the value of the newReturnTransactionID property.
     * 
     */
    public long getNewReturnTransactionID() {
        return newReturnTransactionID;
    }

    /**
     * Sets the value of the newReturnTransactionID property.
     * 
     */
    public void setNewReturnTransactionID(long value) {
        this.newReturnTransactionID = value;
    }

    /**
     * Gets the value of the refundMessage property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRefundMessage() {
        return refundMessage;
    }

    /**
     * Sets the value of the refundMessage property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRefundMessage(String value) {
        this.refundMessage = value;
    }

    /**
     * Gets the value of the totalRefundAmount property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getTotalRefundAmount() {
        return totalRefundAmount;
    }

    /**
     * Sets the value of the totalRefundAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setTotalRefundAmount(BigDecimal value) {
        this.totalRefundAmount = value;
    }

}
