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
 *         &lt;element name="SendEmailWithUnitResult" type="{http://www.centershift.com/STORE40/}SendEmail_Response"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "sendEmailWithUnitResult"
})
@XmlRootElement(name = "SendEmailWithUnitResponse")
public class SendEmailWithUnitResponse {

    @XmlElement(name = "SendEmailWithUnitResult", required = true)
    protected SendEmailResponse sendEmailWithUnitResult;

    /**
     * Gets the value of the sendEmailWithUnitResult property.
     *
     * @return possible object is
     *         {@link SendEmailResponse }
     */
    public SendEmailResponse getSendEmailWithUnitResult() {
        return sendEmailWithUnitResult;
    }

    /**
     * Sets the value of the sendEmailWithUnitResult property.
     *
     * @param value allowed object is
     *              {@link SendEmailResponse }
     */
    public void setSendEmailWithUnitResult(SendEmailResponse value) {
        this.sendEmailWithUnitResult = value;
    }

}
