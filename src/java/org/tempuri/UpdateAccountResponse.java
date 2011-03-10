
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
 *         &lt;element name="UpdateAccountResult" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "updateAccountResult"
})
@XmlRootElement(name = "UpdateAccountResponse")
public class UpdateAccountResponse {

    @XmlElement(name = "UpdateAccountResult")
    protected String updateAccountResult;

    /**
     * Gets the value of the updateAccountResult property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUpdateAccountResult() {
        return updateAccountResult;
    }

    /**
     * Sets the value of the updateAccountResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUpdateAccountResult(String value) {
        this.updateAccountResult = value;
    }

}
