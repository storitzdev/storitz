
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
 *         &lt;element name="UpdateContactResult" type="{http://www.centershift.com/STORE40/}Contact_Response"/>
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
    "updateContactResult"
})
@XmlRootElement(name = "UpdateContactResponse")
public class UpdateContactResponse {

    @XmlElement(name = "UpdateContactResult", required = true)
    protected ContactResponse updateContactResult;

    /**
     * Gets the value of the updateContactResult property.
     * 
     * @return
     *     possible object is
     *     {@link ContactResponse }
     *     
     */
    public ContactResponse getUpdateContactResult() {
        return updateContactResult;
    }

    /**
     * Sets the value of the updateContactResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ContactResponse }
     *     
     */
    public void setUpdateContactResult(ContactResponse value) {
        this.updateContactResult = value;
    }

}
