package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Rules_Request complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="Rules_Request">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SiteID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="RuleID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="Active" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Rules_Request", propOrder = {
        "siteID",
        "ruleID",
        "active"
})
public class RulesRequest {

    @XmlElement(name = "SiteID", required = true, type = Long.class, nillable = true)
    protected Long siteID;
    @XmlElement(name = "RuleID", required = true, type = Long.class, nillable = true)
    protected Long ruleID;
    @XmlElement(name = "Active", required = true, type = Boolean.class, nillable = true)
    protected Boolean active;

    /**
     * Gets the value of the siteID property.
     *
     * @return possible object is
     *         {@link Long }
     */
    public Long getSiteID() {
        return siteID;
    }

    /**
     * Sets the value of the siteID property.
     *
     * @param value allowed object is
     *              {@link Long }
     */
    public void setSiteID(Long value) {
        this.siteID = value;
    }

    /**
     * Gets the value of the ruleID property.
     *
     * @return possible object is
     *         {@link Long }
     */
    public Long getRuleID() {
        return ruleID;
    }

    /**
     * Sets the value of the ruleID property.
     *
     * @param value allowed object is
     *              {@link Long }
     */
    public void setRuleID(Long value) {
        this.ruleID = value;
    }

    /**
     * Gets the value of the active property.
     *
     * @return possible object is
     *         {@link Boolean }
     */
    public Boolean isActive() {
        return active;
    }

    /**
     * Sets the value of the active property.
     *
     * @param value allowed object is
     *              {@link Boolean }
     */
    public void setActive(Boolean value) {
        this.active = value;
    }

}
