
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
 *         &lt;element name="MakeMiscPaymentResult" type="{http://www.centershift.com/STORE40/}MakePayment_Response"/>
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
    "makeMiscPaymentResult"
})
@XmlRootElement(name = "MakeMiscPaymentResponse")
public class MakeMiscPaymentResponse {

    @XmlElement(name = "MakeMiscPaymentResult", required = true)
    protected MakePaymentResponse makeMiscPaymentResult;

    /**
     * Gets the value of the makeMiscPaymentResult property.
     * 
     * @return
     *     possible object is
     *     {@link MakePaymentResponse }
     *     
     */
    public MakePaymentResponse getMakeMiscPaymentResult() {
        return makeMiscPaymentResult;
    }

    /**
     * Sets the value of the makeMiscPaymentResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link MakePaymentResponse }
     *     
     */
    public void setMakeMiscPaymentResult(MakePaymentResponse value) {
        this.makeMiscPaymentResult = value;
    }

}
