package com.centershift.store40;

import javax.xml.bind.annotation.*;


/**
 * <p>Java class for anonymous complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="viewReceiptPdfResult" type="{http://www.centershift.com/STORE40/}PdfFilePath_Response"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "viewReceiptPdfResult"
})
@XmlRootElement(name = "viewReceiptPdfResponse")
public class ViewReceiptPdfResponse {

    @XmlElement(required = true)
    protected PdfFilePathResponse viewReceiptPdfResult;

    /**
     * Gets the value of the viewReceiptPdfResult property.
     *
     * @return possible object is
     *         {@link PdfFilePathResponse }
     */
    public PdfFilePathResponse getViewReceiptPdfResult() {
        return viewReceiptPdfResult;
    }

    /**
     * Sets the value of the viewReceiptPdfResult property.
     *
     * @param value allowed object is
     *              {@link PdfFilePathResponse }
     */
    public void setViewReceiptPdfResult(PdfFilePathResponse value) {
        this.viewReceiptPdfResult = value;
    }

}
