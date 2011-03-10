
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
 *         &lt;element name="AddServiceResult" type="{http://www.centershift.com/STORE40/}AddService_Response"/>
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
    "addServiceResult"
})
@XmlRootElement(name = "AddServiceResponse")
public class AddServiceResponse {

    @XmlElement(name = "AddServiceResult", required = true)
    protected AddServiceResponse2 addServiceResult;

    /**
     * Gets the value of the addServiceResult property.
     * 
     * @return
     *     possible object is
     *     {@link AddServiceResponse2 }
     *     
     */
    public AddServiceResponse2 getAddServiceResult() {
        return addServiceResult;
    }

    /**
     * Sets the value of the addServiceResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link AddServiceResponse2 }
     *     
     */
    public void setAddServiceResult(AddServiceResponse2 value) {
        this.addServiceResult = value;
    }

}
