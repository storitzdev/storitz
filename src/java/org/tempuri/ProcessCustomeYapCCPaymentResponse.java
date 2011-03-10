
package org.tempuri;

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
 *         &lt;element name="ProcessCustomeYapCCPaymentResult" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "processCustomeYapCCPaymentResult"
})
@XmlRootElement(name = "ProcessCustomeYapCCPaymentResponse")
public class ProcessCustomeYapCCPaymentResponse {

    @XmlElement(name = "ProcessCustomeYapCCPaymentResult")
    protected String processCustomeYapCCPaymentResult;

    /**
     * Gets the value of the processCustomeYapCCPaymentResult property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProcessCustomeYapCCPaymentResult() {
        return processCustomeYapCCPaymentResult;
    }

    /**
     * Sets the value of the processCustomeYapCCPaymentResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProcessCustomeYapCCPaymentResult(String value) {
        this.processCustomeYapCCPaymentResult = value;
    }

}
