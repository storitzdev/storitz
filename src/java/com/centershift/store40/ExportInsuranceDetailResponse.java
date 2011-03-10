
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
 *         &lt;element name="ExportInsuranceDetailResult" type="{http://www.centershift.com/STORE40/}ExportInsuranceDetail_Response"/>
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
    "exportInsuranceDetailResult"
})
@XmlRootElement(name = "ExportInsuranceDetailResponse")
public class ExportInsuranceDetailResponse {

    @XmlElement(name = "ExportInsuranceDetailResult", required = true)
    protected ExportInsuranceDetailResponse2 exportInsuranceDetailResult;

    /**
     * Gets the value of the exportInsuranceDetailResult property.
     * 
     * @return
     *     possible object is
     *     {@link ExportInsuranceDetailResponse2 }
     *     
     */
    public ExportInsuranceDetailResponse2 getExportInsuranceDetailResult() {
        return exportInsuranceDetailResult;
    }

    /**
     * Sets the value of the exportInsuranceDetailResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExportInsuranceDetailResponse2 }
     *     
     */
    public void setExportInsuranceDetailResult(ExportInsuranceDetailResponse2 value) {
        this.exportInsuranceDetailResult = value;
    }

}
