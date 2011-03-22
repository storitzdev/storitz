package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SendEmail_Response complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="SendEmail_Response">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SentResponse" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SendEmail_Response", propOrder = {
        "sentResponse"
})
public class SendEmailResponse {

    @XmlElement(name = "SentResponse")
    protected String sentResponse;

    /**
     * Gets the value of the sentResponse property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getSentResponse() {
        return sentResponse;
    }

    /**
     * Sets the value of the sentResponse property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setSentResponse(String value) {
        this.sentResponse = value;
    }

}
