
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
 *         &lt;element name="SellRetailNoAccountMultipleResult" type="{http://www.centershift.com/STORE40/}SellRetailMultiple_Response"/>
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
    "sellRetailNoAccountMultipleResult"
})
@XmlRootElement(name = "SellRetailNoAccountMultipleResponse")
public class SellRetailNoAccountMultipleResponse {

    @XmlElement(name = "SellRetailNoAccountMultipleResult", required = true)
    protected SellRetailMultipleResponse sellRetailNoAccountMultipleResult;

    /**
     * Gets the value of the sellRetailNoAccountMultipleResult property.
     * 
     * @return
     *     possible object is
     *     {@link SellRetailMultipleResponse }
     *     
     */
    public SellRetailMultipleResponse getSellRetailNoAccountMultipleResult() {
        return sellRetailNoAccountMultipleResult;
    }

    /**
     * Sets the value of the sellRetailNoAccountMultipleResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link SellRetailMultipleResponse }
     *     
     */
    public void setSellRetailNoAccountMultipleResult(SellRetailMultipleResponse value) {
        this.sellRetailNoAccountMultipleResult = value;
    }

}
