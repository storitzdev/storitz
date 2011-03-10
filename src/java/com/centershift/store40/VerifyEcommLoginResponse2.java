
package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VerifyEcommLogin_Response complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VerifyEcommLogin_Response">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Details" type="{http://www.centershift.com/STORE40/}ArrayOfSWS_LOGIN" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VerifyEcommLogin_Response", propOrder = {
    "details"
})
public class VerifyEcommLoginResponse2 {

    @XmlElement(name = "Details")
    protected ArrayOfSWSLOGIN details;

    /**
     * Gets the value of the details property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfSWSLOGIN }
     *     
     */
    public ArrayOfSWSLOGIN getDetails() {
        return details;
    }

    /**
     * Sets the value of the details property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfSWSLOGIN }
     *     
     */
    public void setDetails(ArrayOfSWSLOGIN value) {
        this.details = value;
    }

}
