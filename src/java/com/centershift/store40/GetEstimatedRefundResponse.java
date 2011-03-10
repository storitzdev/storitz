
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
 *         &lt;element name="GetEstimatedRefundResult" type="{http://www.centershift.com/STORE40/}GetEstimatedRefund_Response"/>
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
    "getEstimatedRefundResult"
})
@XmlRootElement(name = "GetEstimatedRefundResponse")
public class GetEstimatedRefundResponse {

    @XmlElement(name = "GetEstimatedRefundResult", required = true)
    protected GetEstimatedRefundResponse2 getEstimatedRefundResult;

    /**
     * Gets the value of the getEstimatedRefundResult property.
     * 
     * @return
     *     possible object is
     *     {@link GetEstimatedRefundResponse2 }
     *     
     */
    public GetEstimatedRefundResponse2 getGetEstimatedRefundResult() {
        return getEstimatedRefundResult;
    }

    /**
     * Sets the value of the getEstimatedRefundResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetEstimatedRefundResponse2 }
     *     
     */
    public void setGetEstimatedRefundResult(GetEstimatedRefundResponse2 value) {
        this.getEstimatedRefundResult = value;
    }

}
