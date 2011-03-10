
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
 *         &lt;element name="ProcessRefundResult" type="{http://www.centershift.com/STORE40/}ProcessRefund_Response"/>
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
    "processRefundResult"
})
@XmlRootElement(name = "ProcessRefundResponse")
public class ProcessRefundResponse {

    @XmlElement(name = "ProcessRefundResult", required = true)
    protected ProcessRefundResponse2 processRefundResult;

    /**
     * Gets the value of the processRefundResult property.
     * 
     * @return
     *     possible object is
     *     {@link ProcessRefundResponse2 }
     *     
     */
    public ProcessRefundResponse2 getProcessRefundResult() {
        return processRefundResult;
    }

    /**
     * Sets the value of the processRefundResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProcessRefundResponse2 }
     *     
     */
    public void setProcessRefundResult(ProcessRefundResponse2 value) {
        this.processRefundResult = value;
    }

}
