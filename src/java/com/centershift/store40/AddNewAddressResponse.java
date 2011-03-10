
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
 *         &lt;element name="AddNewAddressResult" type="{http://www.centershift.com/STORE40/}Address_Response"/>
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
    "addNewAddressResult"
})
@XmlRootElement(name = "AddNewAddressResponse")
public class AddNewAddressResponse {

    @XmlElement(name = "AddNewAddressResult", required = true)
    protected AddressResponse addNewAddressResult;

    /**
     * Gets the value of the addNewAddressResult property.
     * 
     * @return
     *     possible object is
     *     {@link AddressResponse }
     *     
     */
    public AddressResponse getAddNewAddressResult() {
        return addNewAddressResult;
    }

    /**
     * Sets the value of the addNewAddressResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link AddressResponse }
     *     
     */
    public void setAddNewAddressResult(AddressResponse value) {
        this.addNewAddressResult = value;
    }

}
