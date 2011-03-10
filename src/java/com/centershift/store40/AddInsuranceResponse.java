
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
 *         &lt;element name="AddInsuranceResult" type="{http://www.centershift.com/STORE40/}AddInsurance_Response"/>
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
    "addInsuranceResult"
})
@XmlRootElement(name = "AddInsuranceResponse")
public class AddInsuranceResponse {

    @XmlElement(name = "AddInsuranceResult", required = true)
    protected AddInsuranceResponse2 addInsuranceResult;

    /**
     * Gets the value of the addInsuranceResult property.
     * 
     * @return
     *     possible object is
     *     {@link AddInsuranceResponse2 }
     *     
     */
    public AddInsuranceResponse2 getAddInsuranceResult() {
        return addInsuranceResult;
    }

    /**
     * Sets the value of the addInsuranceResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link AddInsuranceResponse2 }
     *     
     */
    public void setAddInsuranceResult(AddInsuranceResponse2 value) {
        this.addInsuranceResult = value;
    }

}
