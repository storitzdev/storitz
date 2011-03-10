
package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for MakePayment_Response complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MakePayment_Response">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="TranID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="CashCreditApplied" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MakePayment_Response", propOrder = {
    "tranID",
    "cashCreditApplied"
})
public class MakePaymentResponse {

    @XmlElement(name = "TranID")
    protected long tranID;
    @XmlElement(name = "CashCreditApplied")
    protected boolean cashCreditApplied;

    /**
     * Gets the value of the tranID property.
     * 
     */
    public long getTranID() {
        return tranID;
    }

    /**
     * Sets the value of the tranID property.
     * 
     */
    public void setTranID(long value) {
        this.tranID = value;
    }

    /**
     * Gets the value of the cashCreditApplied property.
     * 
     */
    public boolean isCashCreditApplied() {
        return cashCreditApplied;
    }

    /**
     * Sets the value of the cashCreditApplied property.
     * 
     */
    public void setCashCreditApplied(boolean value) {
        this.cashCreditApplied = value;
    }

}
