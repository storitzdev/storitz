package com.centershift.store40;

import javax.xml.bind.annotation.*;


/**
 * <p>Java class for anonymous complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
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
     * @return possible object is
     *         {@link VerifyEcommLoginResponse2 }
     */
    public VerifyEcommLoginResponse2 getVerifyEcommLoginResult() {
        return verifyEcommLoginResult;
    }

    /**
     * Sets the value of the verifyEcommLoginResult property.
     *
     * @param value allowed object is
     *              {@link VerifyEcommLoginResponse2 }
     */
    public void setVerifyEcommLoginResult(VerifyEcommLoginResponse2 value) {
        this.verifyEcommLoginResult = value;
    }

}
