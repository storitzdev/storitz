
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
 *         &lt;element name="SendEmailWithPasswordResult" type="{http://www.centershift.com/STORE40/}SendEmail_Response"/>
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
    "sendEmailWithPasswordResult"
})
@XmlRootElement(name = "SendEmailWithPasswordResponse")
public class SendEmailWithPasswordResponse {

    @XmlElement(name = "SendEmailWithPasswordResult", required = true)
    protected SendEmailResponse sendEmailWithPasswordResult;

    /**
     * Gets the value of the sendEmailWithPasswordResult property.
     * 
     * @return
     *     possible object is
     *     {@link SendEmailResponse }
     *     
     */
    public SendEmailResponse getSendEmailWithPasswordResult() {
        return sendEmailWithPasswordResult;
    }

    /**
     * Sets the value of the sendEmailWithPasswordResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link SendEmailResponse }
     *     
     */
    public void setSendEmailWithPasswordResult(SendEmailResponse value) {
        this.sendEmailWithPasswordResult = value;
    }

}
