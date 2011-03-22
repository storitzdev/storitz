package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CompleteUnitTransfer_Response complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="CompleteUnitTransfer_Response">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Succeeded" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="TransferReturn" type="{http://www.centershift.com/STORE40/}TransferReturn"/>
 *         &lt;element name="PaymentResponse" type="{http://www.centershift.com/STORE40/}MakePayment_Response"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CompleteUnitTransfer_Response", propOrder = {
        "succeeded",
        "transferReturn",
        "paymentResponse"
})
public class CompleteUnitTransferResponse2 {

    @XmlElement(name = "Succeeded")
    protected boolean succeeded;
    @XmlElement(name = "TransferReturn", required = true)
    protected TransferReturn transferReturn;
    @XmlElement(name = "PaymentResponse", required = true, nillable = true)
    protected MakePaymentResponse paymentResponse;

    /**
     * Gets the value of the succeeded property.
     */
    public boolean isSucceeded() {
        return succeeded;
    }

    /**
     * Sets the value of the succeeded property.
     */
    public void setSucceeded(boolean value) {
        this.succeeded = value;
    }

    /**
     * Gets the value of the transferReturn property.
     *
     * @return possible object is
     *         {@link TransferReturn }
     */
    public TransferReturn getTransferReturn() {
        return transferReturn;
    }

    /**
     * Sets the value of the transferReturn property.
     *
     * @param value allowed object is
     *              {@link TransferReturn }
     */
    public void setTransferReturn(TransferReturn value) {
        this.transferReturn = value;
    }

    /**
     * Gets the value of the paymentResponse property.
     *
     * @return possible object is
     *         {@link MakePaymentResponse }
     */
    public MakePaymentResponse getPaymentResponse() {
        return paymentResponse;
    }

    /**
     * Sets the value of the paymentResponse property.
     *
     * @param value allowed object is
     *              {@link MakePaymentResponse }
     */
    public void setPaymentResponse(MakePaymentResponse value) {
        this.paymentResponse = value;
    }

}
