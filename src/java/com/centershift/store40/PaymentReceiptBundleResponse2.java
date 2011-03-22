package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PaymentReceiptBundle_Response complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="PaymentReceiptBundle_Response">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="MakePaymentResponse" type="{http://www.centershift.com/STORE40/}MakePayment_Response"/>
 *         &lt;element name="PdfFilePathResponse" type="{http://www.centershift.com/STORE40/}PdfFilePath_Response"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PaymentReceiptBundle_Response", propOrder = {
        "makePaymentResponse",
        "pdfFilePathResponse"
})
public class PaymentReceiptBundleResponse2 {

    @XmlElement(name = "MakePaymentResponse", required = true)
    protected MakePaymentResponse makePaymentResponse;
    @XmlElement(name = "PdfFilePathResponse", required = true)
    protected PdfFilePathResponse pdfFilePathResponse;

    /**
     * Gets the value of the makePaymentResponse property.
     *
     * @return possible object is
     *         {@link MakePaymentResponse }
     */
    public MakePaymentResponse getMakePaymentResponse() {
        return makePaymentResponse;
    }

    /**
     * Sets the value of the makePaymentResponse property.
     *
     * @param value allowed object is
     *              {@link MakePaymentResponse }
     */
    public void setMakePaymentResponse(MakePaymentResponse value) {
        this.makePaymentResponse = value;
    }

    /**
     * Gets the value of the pdfFilePathResponse property.
     *
     * @return possible object is
     *         {@link PdfFilePathResponse }
     */
    public PdfFilePathResponse getPdfFilePathResponse() {
        return pdfFilePathResponse;
    }

    /**
     * Sets the value of the pdfFilePathResponse property.
     *
     * @param value allowed object is
     *              {@link PdfFilePathResponse }
     */
    public void setPdfFilePathResponse(PdfFilePathResponse value) {
        this.pdfFilePathResponse = value;
    }

}
