
package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="createAndViewLetterResult" type="{http://www.centershift.com/STORE40/}PdfFilePath_Response"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "createAndViewLetterResult"
})
@XmlRootElement(name = "createAndViewLetterResponse")
public class CreateAndViewLetterResponse {

    @XmlElement(required = true)
    protected PdfFilePathResponse createAndViewLetterResult;

    /**
     * Gets the value of the createAndViewLetterResult property.
     * 
     * @return
     *     possible object is
     *     {@link PdfFilePathResponse }
     *     
     */
    public PdfFilePathResponse getCreateAndViewLetterResult() {
        return createAndViewLetterResult;
    }

    /**
     * Sets the value of the createAndViewLetterResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link PdfFilePathResponse }
     *     
     */
    public void setCreateAndViewLetterResult(PdfFilePathResponse value) {
        this.createAndViewLetterResult = value;
    }

}
