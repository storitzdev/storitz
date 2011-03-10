
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
 *         &lt;element name="MakePaymentResult" type="{http://www.centershift.com/STORE40/}MakePayment_Response"/>
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
    "makePaymentResult"
})
@XmlRootElement(name = "MakePaymentResponse")
public class MakePaymentResponse2 {

    @XmlElement(name = "MakePaymentResult", required = true)
    protected MakePaymentResponse makePaymentResult;

    /**
     * Gets the value of the makePaymentResult property.
     * 
     * @return
     *     possible object is
     *     {@link MakePaymentResponse }
     *     
     */
    public MakePaymentResponse getMakePaymentResult() {
        return makePaymentResult;
    }

    /**
     * Sets the value of the makePaymentResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link MakePaymentResponse }
     *     
     */
    public void setMakePaymentResult(MakePaymentResponse value) {
        this.makePaymentResult = value;
    }

}
