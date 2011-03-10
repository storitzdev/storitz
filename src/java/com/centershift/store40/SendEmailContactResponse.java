
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
 *         &lt;element name="SendEmailContactResult" type="{http://www.centershift.com/STORE40/}SendEmail_Response"/>
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
    "sendEmailContactResult"
})
@XmlRootElement(name = "SendEmailContactResponse")
public class SendEmailContactResponse {

    @XmlElement(name = "SendEmailContactResult", required = true)
    protected SendEmailResponse sendEmailContactResult;

    /**
     * Gets the value of the sendEmailContactResult property.
     * 
     * @return
     *     possible object is
     *     {@link SendEmailResponse }
     *     
     */
    public SendEmailResponse getSendEmailContactResult() {
        return sendEmailContactResult;
    }

    /**
     * Sets the value of the sendEmailContactResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link SendEmailResponse }
     *     
     */
    public void setSendEmailContactResult(SendEmailResponse value) {
        this.sendEmailContactResult = value;
    }

}
