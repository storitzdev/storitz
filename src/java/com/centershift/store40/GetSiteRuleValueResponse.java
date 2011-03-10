
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
 *         &lt;element name="GetSiteRuleValueResult" type="{http://www.centershift.com/STORE40/}GetSiteRuleValue_Response"/>
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
    "getSiteRuleValueResult"
})
@XmlRootElement(name = "GetSiteRuleValueResponse")
public class GetSiteRuleValueResponse {

    @XmlElement(name = "GetSiteRuleValueResult", required = true)
    protected GetSiteRuleValueResponse2 getSiteRuleValueResult;

    /**
     * Gets the value of the getSiteRuleValueResult property.
     * 
     * @return
     *     possible object is
     *     {@link GetSiteRuleValueResponse2 }
     *     
     */
    public GetSiteRuleValueResponse2 getGetSiteRuleValueResult() {
        return getSiteRuleValueResult;
    }

    /**
     * Sets the value of the getSiteRuleValueResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetSiteRuleValueResponse2 }
     *     
     */
    public void setGetSiteRuleValueResult(GetSiteRuleValueResponse2 value) {
        this.getSiteRuleValueResult = value;
    }

}
