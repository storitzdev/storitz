
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
 *         &lt;element name="GetContactAddressesResult" type="{http://www.centershift.com/STORE40/}GetContactAddresses_Response"/>
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
    "getContactAddressesResult"
})
@XmlRootElement(name = "GetContactAddressesResponse")
public class GetContactAddressesResponse {

    @XmlElement(name = "GetContactAddressesResult", required = true)
    protected GetContactAddressesResponse2 getContactAddressesResult;

    /**
     * Gets the value of the getContactAddressesResult property.
     * 
     * @return
     *     possible object is
     *     {@link GetContactAddressesResponse2 }
     *     
     */
    public GetContactAddressesResponse2 getGetContactAddressesResult() {
        return getContactAddressesResult;
    }

    /**
     * Sets the value of the getContactAddressesResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetContactAddressesResponse2 }
     *     
     */
    public void setGetContactAddressesResult(GetContactAddressesResponse2 value) {
        this.getContactAddressesResult = value;
    }

}
