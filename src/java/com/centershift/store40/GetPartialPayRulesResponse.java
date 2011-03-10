
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
 *         &lt;element name="GetPartialPayRulesResult" type="{http://www.centershift.com/STORE40/}GetPartialPayRules_Response"/>
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
    "getPartialPayRulesResult"
})
@XmlRootElement(name = "GetPartialPayRulesResponse")
public class GetPartialPayRulesResponse {

    @XmlElement(name = "GetPartialPayRulesResult", required = true)
    protected GetPartialPayRulesResponse2 getPartialPayRulesResult;

    /**
     * Gets the value of the getPartialPayRulesResult property.
     * 
     * @return
     *     possible object is
     *     {@link GetPartialPayRulesResponse2 }
     *     
     */
    public GetPartialPayRulesResponse2 getGetPartialPayRulesResult() {
        return getPartialPayRulesResult;
    }

    /**
     * Sets the value of the getPartialPayRulesResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetPartialPayRulesResponse2 }
     *     
     */
    public void setGetPartialPayRulesResult(GetPartialPayRulesResponse2 value) {
        this.getPartialPayRulesResult = value;
    }

}
