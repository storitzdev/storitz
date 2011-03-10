
package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PaymentReceiptBundle_Request complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PaymentReceiptBundle_Request">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="MakePaymentRequest" type="{http://www.centershift.com/STORE40/}MakePayment_Request"/>
 *         &lt;element name="createOrViewReceiptRequest" type="{http://www.centershift.com/STORE40/}createOrViewReceipt_Request"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PaymentReceiptBundle_Request", propOrder = {
    "makePaymentRequest",
    "createOrViewReceiptRequest"
})
public class PaymentReceiptBundleRequest {

    @XmlElement(name = "MakePaymentRequest", required = true)
    protected MakePaymentRequest makePaymentRequest;
    @XmlElement(required = true)
    protected CreateOrViewReceiptRequest createOrViewReceiptRequest;

    /**
     * Gets the value of the makePaymentRequest property.
     * 
     * @return
     *     possible object is
     *     {@link MakePaymentRequest }
     *     
     */
    public MakePaymentRequest getMakePaymentRequest() {
        return makePaymentRequest;
    }

    /**
     * Sets the value of the makePaymentRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link MakePaymentRequest }
     *     
     */
    public void setMakePaymentRequest(MakePaymentRequest value) {
        this.makePaymentRequest = value;
    }

    /**
     * Gets the value of the createOrViewReceiptRequest property.
     * 
     * @return
     *     possible object is
     *     {@link CreateOrViewReceiptRequest }
     *     
     */
    public CreateOrViewReceiptRequest getCreateOrViewReceiptRequest() {
        return createOrViewReceiptRequest;
    }

    /**
     * Sets the value of the createOrViewReceiptRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link CreateOrViewReceiptRequest }
     *     
     */
    public void setCreateOrViewReceiptRequest(CreateOrViewReceiptRequest value) {
        this.createOrViewReceiptRequest = value;
    }

}
