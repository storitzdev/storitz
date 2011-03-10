
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
 *         &lt;element name="AddDepositResult" type="{http://www.centershift.com/STORE40/}AddDeposit_Response"/>
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
    "addDepositResult"
})
@XmlRootElement(name = "AddDepositResponse")
public class AddDepositResponse {

    @XmlElement(name = "AddDepositResult", required = true)
    protected AddDepositResponse2 addDepositResult;

    /**
     * Gets the value of the addDepositResult property.
     * 
     * @return
     *     possible object is
     *     {@link AddDepositResponse2 }
     *     
     */
    public AddDepositResponse2 getAddDepositResult() {
        return addDepositResult;
    }

    /**
     * Sets the value of the addDepositResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link AddDepositResponse2 }
     *     
     */
    public void setAddDepositResult(AddDepositResponse2 value) {
        this.addDepositResult = value;
    }

}
