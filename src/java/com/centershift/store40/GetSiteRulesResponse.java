
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
 *         &lt;element name="GetSiteRulesResult" type="{http://www.centershift.com/STORE40/}GetSiteRules_Response"/>
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
    "getSiteRulesResult"
})
@XmlRootElement(name = "GetSiteRulesResponse")
public class GetSiteRulesResponse {

    @XmlElement(name = "GetSiteRulesResult", required = true)
    protected GetSiteRulesResponse2 getSiteRulesResult;

    /**
     * Gets the value of the getSiteRulesResult property.
     * 
     * @return
     *     possible object is
     *     {@link GetSiteRulesResponse2 }
     *     
     */
    public GetSiteRulesResponse2 getGetSiteRulesResult() {
        return getSiteRulesResult;
    }

    /**
     * Sets the value of the getSiteRulesResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetSiteRulesResponse2 }
     *     
     */
    public void setGetSiteRulesResult(GetSiteRulesResponse2 value) {
        this.getSiteRulesResult = value;
    }

}
