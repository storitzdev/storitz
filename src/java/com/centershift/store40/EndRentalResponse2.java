package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for EndRental_Response complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="EndRental_Response">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="TransactionID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="AppliedCashCredit" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="RefundMessage" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ErrorMessage" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EndRental_Response", propOrder = {
        "transactionID",
        "appliedCashCredit",
        "refundMessage",
        "errorMessage"
})
public class EndRentalResponse2 {

    @XmlElement(name = "TransactionID")
    protected long transactionID;
    @XmlElement(name = "AppliedCashCredit")
    protected boolean appliedCashCredit;
    @XmlElement(name = "RefundMessage")
    protected String refundMessage;
    @XmlElement(name = "ErrorMessage")
    protected String errorMessage;

    /**
     * Gets the value of the transactionID property.
     */
    public long getTransactionID() {
        return transactionID;
    }

    /**
     * Sets the value of the transactionID property.
     */
    public void setTransactionID(long value) {
        this.transactionID = value;
    }

    /**
     * Gets the value of the appliedCashCredit property.
     */
    public boolean isAppliedCashCredit() {
        return appliedCashCredit;
    }

    /**
     * Sets the value of the appliedCashCredit property.
     */
    public void setAppliedCashCredit(boolean value) {
        this.appliedCashCredit = value;
    }

    /**
     * Gets the value of the refundMessage property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getRefundMessage() {
        return refundMessage;
    }

    /**
     * Sets the value of the refundMessage property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setRefundMessage(String value) {
        this.refundMessage = value;
    }

    /**
     * Gets the value of the errorMessage property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getErrorMessage() {
        return errorMessage;
    }

    /**
     * Sets the value of the errorMessage property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setErrorMessage(String value) {
        this.errorMessage = value;
    }

}
