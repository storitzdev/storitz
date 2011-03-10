
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
 *         &lt;element name="getProcessingMailRulesResult" type="{http://www.centershift.com/STORE40/}getRules_Response"/>
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
    "getProcessingMailRulesResult"
})
@XmlRootElement(name = "getProcessingMailRulesResponse")
public class GetProcessingMailRulesResponse {

    @XmlElement(required = true)
    protected GetRulesResponse getProcessingMailRulesResult;

    /**
     * Gets the value of the getProcessingMailRulesResult property.
     * 
     * @return
     *     possible object is
     *     {@link GetRulesResponse }
     *     
     */
    public GetRulesResponse getGetProcessingMailRulesResult() {
        return getProcessingMailRulesResult;
    }

    /**
     * Sets the value of the getProcessingMailRulesResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetRulesResponse }
     *     
     */
    public void setGetProcessingMailRulesResult(GetRulesResponse value) {
        this.getProcessingMailRulesResult = value;
    }

}
