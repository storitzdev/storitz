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
 *         &lt;element name="viewLetterPdfResult" type="{http://www.centershift.com/STORE40/}PdfFilePath_Response"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "viewLetterPdfResult"
})
@XmlRootElement(name = "viewLetterPdfResponse")
public class ViewLetterPdfResponse {

    @XmlElement(required = true)
    protected PdfFilePathResponse viewLetterPdfResult;

    /**
     * Gets the value of the viewLetterPdfResult property.
     *
     * @return possible object is
     *         {@link PdfFilePathResponse }
     */
    public PdfFilePathResponse getViewLetterPdfResult() {
        return viewLetterPdfResult;
    }

    /**
     * Sets the value of the viewLetterPdfResult property.
     *
     * @param value allowed object is
     *              {@link PdfFilePathResponse }
     */
    public void setViewLetterPdfResult(PdfFilePathResponse value) {
        this.viewLetterPdfResult = value;
    }

}
