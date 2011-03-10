
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
 *         &lt;element name="FIUExportResult" type="{http://www.centershift.com/STORE40/}FIU_Response"/>
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
    "fiuExportResult"
})
@XmlRootElement(name = "FIUExportResponse")
public class FIUExportResponse {

    @XmlElement(name = "FIUExportResult", required = true)
    protected FIUResponse fiuExportResult;

    /**
     * Gets the value of the fiuExportResult property.
     * 
     * @return
     *     possible object is
     *     {@link FIUResponse }
     *     
     */
    public FIUResponse getFIUExportResult() {
        return fiuExportResult;
    }

    /**
     * Sets the value of the fiuExportResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link FIUResponse }
     *     
     */
    public void setFIUExportResult(FIUResponse value) {
        this.fiuExportResult = value;
    }

}
