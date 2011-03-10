
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
 *         &lt;element name="VerifyLoginResult" type="{http://www.centershift.com/STORE40/}Password_Response"/>
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
    "verifyLoginResult"
})
@XmlRootElement(name = "VerifyLoginResponse")
public class VerifyLoginResponse {

    @XmlElement(name = "VerifyLoginResult", required = true)
    protected PasswordResponse verifyLoginResult;

    /**
     * Gets the value of the verifyLoginResult property.
     * 
     * @return
     *     possible object is
     *     {@link PasswordResponse }
     *     
     */
    public PasswordResponse getVerifyLoginResult() {
        return verifyLoginResult;
    }

    /**
     * Sets the value of the verifyLoginResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link PasswordResponse }
     *     
     */
    public void setVerifyLoginResult(PasswordResponse value) {
        this.verifyLoginResult = value;
    }

}
