
package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for siteRuleData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="siteRuleData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ruleId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="ruleName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="desc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="currSiteValue" type="{http://www.w3.org/2001/XMLSchema}anyType" minOccurs="0"/>
 *         &lt;element name="siteValueMeaning" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "siteRuleData", propOrder = {
    "ruleId",
    "ruleName",
    "desc",
    "currSiteValue",
    "siteValueMeaning"
})
public class SiteRuleData {

    protected long ruleId;
    protected String ruleName;
    protected String desc;
    protected Object currSiteValue;
    protected String siteValueMeaning;

    /**
     * Gets the value of the ruleId property.
     * 
     */
    public long getRuleId() {
        return ruleId;
    }

    /**
     * Sets the value of the ruleId property.
     * 
     */
    public void setRuleId(long value) {
        this.ruleId = value;
    }

    /**
     * Gets the value of the ruleName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRuleName() {
        return ruleName;
    }

    /**
     * Sets the value of the ruleName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRuleName(String value) {
        this.ruleName = value;
    }

    /**
     * Gets the value of the desc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDesc() {
        return desc;
    }

    /**
     * Sets the value of the desc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDesc(String value) {
        this.desc = value;
    }

    /**
     * Gets the value of the currSiteValue property.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getCurrSiteValue() {
        return currSiteValue;
    }

    /**
     * Sets the value of the currSiteValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setCurrSiteValue(Object value) {
        this.currSiteValue = value;
    }

    /**
     * Gets the value of the siteValueMeaning property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSiteValueMeaning() {
        return siteValueMeaning;
    }

    /**
     * Sets the value of the siteValueMeaning property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSiteValueMeaning(String value) {
        this.siteValueMeaning = value;
    }

}
