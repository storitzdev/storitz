package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CompleteUnitTransfer_Request complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="CompleteUnitTransfer_Request">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="OrgID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="TransferData" type="{http://www.centershift.com/STORE40/}TransferToCommit"/>
 *         &lt;element name="PaymentData" type="{http://www.centershift.com/STORE40/}MakePayment_Request"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CompleteUnitTransfer_Request", propOrder = {
        "orgID",
        "transferData",
        "paymentData"
})
public class CompleteUnitTransferRequest {

    @XmlElement(name = "OrgID")
    protected long orgID;
    @XmlElement(name = "TransferData", required = true)
    protected TransferToCommit transferData;
    @XmlElement(name = "PaymentData", required = true, nillable = true)
    protected MakePaymentRequest paymentData;

    /**
     * Gets the value of the orgID property.
     */
    public long getOrgID() {
        return orgID;
    }

    /**
     * Sets the value of the orgID property.
     */
    public void setOrgID(long value) {
        this.orgID = value;
    }

    /**
     * Gets the value of the transferData property.
     *
     * @return possible object is
     *         {@link TransferToCommit }
     */
    public TransferToCommit getTransferData() {
        return transferData;
    }

    /**
     * Sets the value of the transferData property.
     *
     * @param value allowed object is
     *              {@link TransferToCommit }
     */
    public void setTransferData(TransferToCommit value) {
        this.transferData = value;
    }

    /**
     * Gets the value of the paymentData property.
     *
     * @return possible object is
     *         {@link MakePaymentRequest }
     */
    public MakePaymentRequest getPaymentData() {
        return paymentData;
    }

    /**
     * Sets the value of the paymentData property.
     *
     * @param value allowed object is
     *              {@link MakePaymentRequest }
     */
    public void setPaymentData(MakePaymentRequest value) {
        this.paymentData = value;
    }

}
