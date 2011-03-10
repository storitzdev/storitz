
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
 *         &lt;element name="mailCentralizedReceiptResult" type="{http://www.centershift.com/STORE40/}tntLtrNum_Response"/>
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
    "mailCentralizedReceiptResult"
})
@XmlRootElement(name = "mailCentralizedReceiptResponse")
public class MailCentralizedReceiptResponse {

    @XmlElement(required = true)
    protected TntLtrNumResponse mailCentralizedReceiptResult;

    /**
     * Gets the value of the mailCentralizedReceiptResult property.
     * 
     * @return
     *     possible object is
     *     {@link TntLtrNumResponse }
     *     
     */
    public TntLtrNumResponse getMailCentralizedReceiptResult() {
        return mailCentralizedReceiptResult;
    }

    /**
     * Sets the value of the mailCentralizedReceiptResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link TntLtrNumResponse }
     *     
     */
    public void setMailCentralizedReceiptResult(TntLtrNumResponse value) {
        this.mailCentralizedReceiptResult = value;
    }

}
