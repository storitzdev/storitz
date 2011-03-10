
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
 *         &lt;element name="GetRefundsResult" type="{http://www.centershift.com/STORE40/}Refund_Response"/>
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
    "getRefundsResult"
})
@XmlRootElement(name = "GetRefundsResponse")
public class GetRefundsResponse {

    @XmlElement(name = "GetRefundsResult", required = true)
    protected RefundResponse getRefundsResult;

    /**
     * Gets the value of the getRefundsResult property.
     * 
     * @return
     *     possible object is
     *     {@link RefundResponse }
     *     
     */
    public RefundResponse getGetRefundsResult() {
        return getRefundsResult;
    }

    /**
     * Sets the value of the getRefundsResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link RefundResponse }
     *     
     */
    public void setGetRefundsResult(RefundResponse value) {
        this.getRefundsResult = value;
    }

}
