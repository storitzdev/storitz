
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
 *         &lt;element name="AddAccountMoveIn2Result" type="{http://tempuri.org/}NewAccountResult"/>
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
    "addAccountMoveIn2Result"
})
@XmlRootElement(name = "AddAccountMoveIn2Response")
public class AddAccountMoveIn2Response {

    @XmlElement(name = "AddAccountMoveIn2Result", required = true)
    protected NewAccountResult addAccountMoveIn2Result;

    /**
     * Gets the value of the addAccountMoveIn2Result property.
     * 
     * @return
     *     possible object is
     *     {@link NewAccountResult }
     *     
     */
    public NewAccountResult getAddAccountMoveIn2Result() {
        return addAccountMoveIn2Result;
    }

    /**
     * Sets the value of the addAccountMoveIn2Result property.
     * 
     * @param value
     *     allowed object is
     *     {@link NewAccountResult }
     *     
     */
    public void setAddAccountMoveIn2Result(NewAccountResult value) {
        this.addAccountMoveIn2Result = value;
    }

}
