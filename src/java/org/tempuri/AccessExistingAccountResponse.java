
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
 *         &lt;element name="AccessExistingAccountResult" type="{http://tempuri.org/}UserAccount_ST"/>
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
    "accessExistingAccountResult"
})
@XmlRootElement(name = "AccessExistingAccountResponse")
public class AccessExistingAccountResponse {

    @XmlElement(name = "AccessExistingAccountResult", required = true)
    protected UserAccountST accessExistingAccountResult;

    /**
     * Gets the value of the accessExistingAccountResult property.
     * 
     * @return
     *     possible object is
     *     {@link UserAccountST }
     *     
     */
    public UserAccountST getAccessExistingAccountResult() {
        return accessExistingAccountResult;
    }

    /**
     * Sets the value of the accessExistingAccountResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link UserAccountST }
     *     
     */
    public void setAccessExistingAccountResult(UserAccountST value) {
        this.accessExistingAccountResult = value;
    }

}
