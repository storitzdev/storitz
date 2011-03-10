
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
 *         &lt;element name="GetAvailableInventoryResult" type="{http://tempuri.org/}ArrayOfAvailableInventory" minOccurs="0"/>
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
    "getAvailableInventoryResult"
})
@XmlRootElement(name = "GetAvailableInventoryResponse")
public class GetAvailableInventoryResponse {

    @XmlElement(name = "GetAvailableInventoryResult")
    protected ArrayOfAvailableInventory getAvailableInventoryResult;

    /**
     * Gets the value of the getAvailableInventoryResult property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfAvailableInventory }
     *     
     */
    public ArrayOfAvailableInventory getGetAvailableInventoryResult() {
        return getAvailableInventoryResult;
    }

    /**
     * Sets the value of the getAvailableInventoryResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfAvailableInventory }
     *     
     */
    public void setGetAvailableInventoryResult(ArrayOfAvailableInventory value) {
        this.getAvailableInventoryResult = value;
    }

}
