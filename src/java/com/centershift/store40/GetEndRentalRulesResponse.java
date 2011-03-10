
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
 *         &lt;element name="GetEndRentalRulesResult" type="{http://www.centershift.com/STORE40/}GetEndRentalRules_Response"/>
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
    "getEndRentalRulesResult"
})
@XmlRootElement(name = "GetEndRentalRulesResponse")
public class GetEndRentalRulesResponse {

    @XmlElement(name = "GetEndRentalRulesResult", required = true)
    protected GetEndRentalRulesResponse2 getEndRentalRulesResult;

    /**
     * Gets the value of the getEndRentalRulesResult property.
     * 
     * @return
     *     possible object is
     *     {@link GetEndRentalRulesResponse2 }
     *     
     */
    public GetEndRentalRulesResponse2 getGetEndRentalRulesResult() {
        return getEndRentalRulesResult;
    }

    /**
     * Sets the value of the getEndRentalRulesResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetEndRentalRulesResponse2 }
     *     
     */
    public void setGetEndRentalRulesResult(GetEndRentalRulesResponse2 value) {
        this.getEndRentalRulesResult = value;
    }

}
