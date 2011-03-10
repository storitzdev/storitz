
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
 *         &lt;element name="GetAvailableCreditsResult" type="{http://www.centershift.com/STORE40/}GetAvailableCredits_Response"/>
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
    "getAvailableCreditsResult"
})
@XmlRootElement(name = "GetAvailableCreditsResponse")
public class GetAvailableCreditsResponse {

    @XmlElement(name = "GetAvailableCreditsResult", required = true)
    protected GetAvailableCreditsResponse2 getAvailableCreditsResult;

    /**
     * Gets the value of the getAvailableCreditsResult property.
     * 
     * @return
     *     possible object is
     *     {@link GetAvailableCreditsResponse2 }
     *     
     */
    public GetAvailableCreditsResponse2 getGetAvailableCreditsResult() {
        return getAvailableCreditsResult;
    }

    /**
     * Sets the value of the getAvailableCreditsResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetAvailableCreditsResponse2 }
     *     
     */
    public void setGetAvailableCreditsResult(GetAvailableCreditsResponse2 value) {
        this.getAvailableCreditsResult = value;
    }

}
