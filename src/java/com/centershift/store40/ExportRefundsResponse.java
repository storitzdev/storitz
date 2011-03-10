
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
 *         &lt;element name="ExportRefundsResult" type="{http://www.centershift.com/STORE40/}Refund_Response"/>
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
    "exportRefundsResult"
})
@XmlRootElement(name = "ExportRefundsResponse")
public class ExportRefundsResponse {

    @XmlElement(name = "ExportRefundsResult", required = true)
    protected RefundResponse exportRefundsResult;

    /**
     * Gets the value of the exportRefundsResult property.
     * 
     * @return
     *     possible object is
     *     {@link RefundResponse }
     *     
     */
    public RefundResponse getExportRefundsResult() {
        return exportRefundsResult;
    }

    /**
     * Sets the value of the exportRefundsResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link RefundResponse }
     *     
     */
    public void setExportRefundsResult(RefundResponse value) {
        this.exportRefundsResult = value;
    }

}
