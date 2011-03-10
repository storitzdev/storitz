
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
 *         &lt;element name="CancelInsuranceBundleResult" type="{http://www.centershift.com/STORE40/}CancelInsurance_Response"/>
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
    "cancelInsuranceBundleResult"
})
@XmlRootElement(name = "CancelInsuranceBundleResponse")
public class CancelInsuranceBundleResponse {

    @XmlElement(name = "CancelInsuranceBundleResult", required = true)
    protected CancelInsuranceResponse cancelInsuranceBundleResult;

    /**
     * Gets the value of the cancelInsuranceBundleResult property.
     * 
     * @return
     *     possible object is
     *     {@link CancelInsuranceResponse }
     *     
     */
    public CancelInsuranceResponse getCancelInsuranceBundleResult() {
        return cancelInsuranceBundleResult;
    }

    /**
     * Sets the value of the cancelInsuranceBundleResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link CancelInsuranceResponse }
     *     
     */
    public void setCancelInsuranceBundleResult(CancelInsuranceResponse value) {
        this.cancelInsuranceBundleResult = value;
    }

}
