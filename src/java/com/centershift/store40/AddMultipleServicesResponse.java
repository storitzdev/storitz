
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
 *         &lt;element name="AddMultipleServicesResult" type="{http://www.centershift.com/STORE40/}ArrayOfAddMultipleServices_Response" minOccurs="0"/>
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
    "addMultipleServicesResult"
})
@XmlRootElement(name = "AddMultipleServicesResponse")
public class AddMultipleServicesResponse {

    @XmlElement(name = "AddMultipleServicesResult")
    protected ArrayOfAddMultipleServicesResponse addMultipleServicesResult;

    /**
     * Gets the value of the addMultipleServicesResult property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfAddMultipleServicesResponse }
     *     
     */
    public ArrayOfAddMultipleServicesResponse getAddMultipleServicesResult() {
        return addMultipleServicesResult;
    }

    /**
     * Sets the value of the addMultipleServicesResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfAddMultipleServicesResponse }
     *     
     */
    public void setAddMultipleServicesResult(ArrayOfAddMultipleServicesResponse value) {
        this.addMultipleServicesResult = value;
    }

}
