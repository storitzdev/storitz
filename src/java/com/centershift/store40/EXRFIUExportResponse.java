
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
 *         &lt;element name="EXRFIUExportResult" type="{http://www.centershift.com/STORE40/}EXRFIU_Response"/>
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
    "exrfiuExportResult"
})
@XmlRootElement(name = "EXRFIUExportResponse")
public class EXRFIUExportResponse {

    @XmlElement(name = "EXRFIUExportResult", required = true)
    protected EXRFIUResponse exrfiuExportResult;

    /**
     * Gets the value of the exrfiuExportResult property.
     * 
     * @return
     *     possible object is
     *     {@link EXRFIUResponse }
     *     
     */
    public EXRFIUResponse getEXRFIUExportResult() {
        return exrfiuExportResult;
    }

    /**
     * Sets the value of the exrfiuExportResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link EXRFIUResponse }
     *     
     */
    public void setEXRFIUExportResult(EXRFIUResponse value) {
        this.exrfiuExportResult = value;
    }

}
