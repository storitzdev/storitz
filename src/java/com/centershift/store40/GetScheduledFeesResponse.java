
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
 *         &lt;element name="GetScheduledFeesResult" type="{http://www.centershift.com/STORE40/}GetScheduledFees_Response"/>
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
    "getScheduledFeesResult"
})
@XmlRootElement(name = "GetScheduledFeesResponse")
public class GetScheduledFeesResponse {

    @XmlElement(name = "GetScheduledFeesResult", required = true)
    protected GetScheduledFeesResponse2 getScheduledFeesResult;

    /**
     * Gets the value of the getScheduledFeesResult property.
     * 
     * @return
     *     possible object is
     *     {@link GetScheduledFeesResponse2 }
     *     
     */
    public GetScheduledFeesResponse2 getGetScheduledFeesResult() {
        return getScheduledFeesResult;
    }

    /**
     * Sets the value of the getScheduledFeesResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetScheduledFeesResponse2 }
     *     
     */
    public void setGetScheduledFeesResult(GetScheduledFeesResponse2 value) {
        this.getScheduledFeesResult = value;
    }

}
