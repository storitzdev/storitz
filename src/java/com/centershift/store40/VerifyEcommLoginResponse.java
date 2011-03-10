
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
 *         &lt;element name="VerifyEcommLoginResult" type="{http://www.centershift.com/STORE40/}VerifyEcommLogin_Response"/>
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
    "verifyEcommLoginResult"
})
@XmlRootElement(name = "VerifyEcommLoginResponse")
public class VerifyEcommLoginResponse {

    @XmlElement(name = "VerifyEcommLoginResult", required = true)
    protected VerifyEcommLoginResponse2 verifyEcommLoginResult;

    /**
     * Gets the value of the verifyEcommLoginResult property.
     * 
     * @return
     *     possible object is
     *     {@link VerifyEcommLoginResponse2 }
     *     
     */
    public VerifyEcommLoginResponse2 getVerifyEcommLoginResult() {
        return verifyEcommLoginResult;
    }

    /**
     * Sets the value of the verifyEcommLoginResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link VerifyEcommLoginResponse2 }
     *     
     */
    public void setVerifyEcommLoginResult(VerifyEcommLoginResponse2 value) {
        this.verifyEcommLoginResult = value;
    }

}
