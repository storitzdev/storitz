package com.centershift.store40;

import javax.xml.bind.annotation.*;


/**
 * <p>Java class for anonymous complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="getTemplateIdRulesResult" type="{http://www.centershift.com/STORE40/}getRules_Response"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "getTemplateIdRulesResult"
})
@XmlRootElement(name = "getTemplateIdRulesResponse")
public class GetTemplateIdRulesResponse {

    @XmlElement(required = true)
    protected GetRulesResponse getTemplateIdRulesResult;

    /**
     * Gets the value of the getTemplateIdRulesResult property.
     *
     * @return possible object is
     *         {@link GetRulesResponse }
     */
    public GetRulesResponse getGetTemplateIdRulesResult() {
        return getTemplateIdRulesResult;
    }

    /**
     * Sets the value of the getTemplateIdRulesResult property.
     *
     * @param value allowed object is
     *              {@link GetRulesResponse }
     */
    public void setGetTemplateIdRulesResult(GetRulesResponse value) {
        this.getTemplateIdRulesResult = value;
    }

}
