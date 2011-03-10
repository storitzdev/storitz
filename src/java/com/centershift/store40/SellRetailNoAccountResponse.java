
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
 *         &lt;element name="SellRetailNoAccountResult" type="{http://www.centershift.com/STORE40/}SellRetailNoAccount_Response"/>
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
    "sellRetailNoAccountResult"
})
@XmlRootElement(name = "SellRetailNoAccountResponse")
public class SellRetailNoAccountResponse {

    @XmlElement(name = "SellRetailNoAccountResult", required = true)
    protected SellRetailNoAccountResponse2 sellRetailNoAccountResult;

    /**
     * Gets the value of the sellRetailNoAccountResult property.
     * 
     * @return
     *     possible object is
     *     {@link SellRetailNoAccountResponse2 }
     *     
     */
    public SellRetailNoAccountResponse2 getSellRetailNoAccountResult() {
        return sellRetailNoAccountResult;
    }

    /**
     * Sets the value of the sellRetailNoAccountResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link SellRetailNoAccountResponse2 }
     *     
     */
    public void setSellRetailNoAccountResult(SellRetailNoAccountResponse2 value) {
        this.sellRetailNoAccountResult = value;
    }

}
