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
 *         &lt;element name="SendEmailResult" type="{http://www.centershift.com/STORE40/}SendEmail_Response"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "sendEmailResult"
})
@XmlRootElement(name = "SendEmailResponse")
public class SendEmailResponse2 {

    @XmlElement(name = "SendEmailResult", required = true)
    protected SendEmailResponse sendEmailResult;

    /**
     * Gets the value of the sendEmailResult property.
     *
     * @return possible object is
     *         {@link SendEmailResponse }
     */
    public SendEmailResponse getSendEmailResult() {
        return sendEmailResult;
    }

    /**
     * Sets the value of the sendEmailResult property.
     *
     * @param value allowed object is
     *              {@link SendEmailResponse }
     */
    public void setSendEmailResult(SendEmailResponse value) {
        this.sendEmailResult = value;
    }

}
