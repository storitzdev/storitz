
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
 *         &lt;element name="GetAvailableRetailItemsResult" type="{http://www.centershift.com/STORE40/}GetAvailableRetailItems_Response"/>
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
    "getAvailableRetailItemsResult"
})
@XmlRootElement(name = "GetAvailableRetailItemsResponse")
public class GetAvailableRetailItemsResponse {

    @XmlElement(name = "GetAvailableRetailItemsResult", required = true)
    protected GetAvailableRetailItemsResponse2 getAvailableRetailItemsResult;

    /**
     * Gets the value of the getAvailableRetailItemsResult property.
     * 
     * @return
     *     possible object is
     *     {@link GetAvailableRetailItemsResponse2 }
     *     
     */
    public GetAvailableRetailItemsResponse2 getGetAvailableRetailItemsResult() {
        return getAvailableRetailItemsResult;
    }

    /**
     * Sets the value of the getAvailableRetailItemsResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetAvailableRetailItemsResponse2 }
     *     
     */
    public void setGetAvailableRetailItemsResult(GetAvailableRetailItemsResponse2 value) {
        this.getAvailableRetailItemsResult = value;
    }

}
