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
 *         &lt;element name="viewLeasePdfResult" type="{http://www.centershift.com/STORE40/}PdfFilePath_Response"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "viewLeasePdfResult"
})
@XmlRootElement(name = "viewLeasePdfResponse")
public class ViewLeasePdfResponse {

    @XmlElement(required = true)
    protected PdfFilePathResponse viewLeasePdfResult;

    /**
     * Gets the value of the viewLeasePdfResult property.
     *
     * @return possible object is
     *         {@link PdfFilePathResponse }
     */
    public PdfFilePathResponse getViewLeasePdfResult() {
        return viewLeasePdfResult;
    }

    /**
     * Sets the value of the viewLeasePdfResult property.
     *
     * @param value allowed object is
     *              {@link PdfFilePathResponse }
     */
    public void setViewLeasePdfResult(PdfFilePathResponse value) {
        this.viewLeasePdfResult = value;
    }

}
