
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
 *         &lt;element name="GetRentalLedgerResult" type="{http://www.centershift.com/STORE40/}GetRentalLedger_Response"/>
 *         &lt;element name="Request" type="{http://www.centershift.com/STORE40/}GetRentalLedger_Request"/>
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
    "getRentalLedgerResult",
    "request"
})
@XmlRootElement(name = "GetRentalLedgerResponse")
public class GetRentalLedgerResponse {

    @XmlElement(name = "GetRentalLedgerResult", required = true)
    protected GetRentalLedgerResponse2 getRentalLedgerResult;
    @XmlElement(name = "Request", required = true)
    protected GetRentalLedgerRequest request;

    /**
     * Gets the value of the getRentalLedgerResult property.
     * 
     * @return
     *     possible object is
     *     {@link GetRentalLedgerResponse2 }
     *     
     */
    public GetRentalLedgerResponse2 getGetRentalLedgerResult() {
        return getRentalLedgerResult;
    }

    /**
     * Sets the value of the getRentalLedgerResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetRentalLedgerResponse2 }
     *     
     */
    public void setGetRentalLedgerResult(GetRentalLedgerResponse2 value) {
        this.getRentalLedgerResult = value;
    }

    /**
     * Gets the value of the request property.
     * 
     * @return
     *     possible object is
     *     {@link GetRentalLedgerRequest }
     *     
     */
    public GetRentalLedgerRequest getRequest() {
        return request;
    }

    /**
     * Sets the value of the request property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetRentalLedgerRequest }
     *     
     */
    public void setRequest(GetRentalLedgerRequest value) {
        this.request = value;
    }

}
