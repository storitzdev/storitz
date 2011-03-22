package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getRules_Response complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="getRules_Response">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ruleCol" type="{http://www.centershift.com/STORE40/}ArrayOfSiteRuleData" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getRules_Response", propOrder = {
        "ruleCol"
})
public class GetRulesResponse {

    protected ArrayOfSiteRuleData ruleCol;

    /**
     * Gets the value of the ruleCol property.
     *
     * @return possible object is
     *         {@link ArrayOfSiteRuleData }
     */
    public ArrayOfSiteRuleData getRuleCol() {
        return ruleCol;
    }

    /**
     * Sets the value of the ruleCol property.
     *
     * @param value allowed object is
     *              {@link ArrayOfSiteRuleData }
     */
    public void setRuleCol(ArrayOfSiteRuleData value) {
        this.ruleCol = value;
    }

}
