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
 *         &lt;element name="getReceiptRulesResult" type="{http://www.centershift.com/STORE40/}getRules_Response"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "getReceiptRulesResult"
})
@XmlRootElement(name = "getReceiptRulesResponse")
public class GetReceiptRulesResponse {

    @XmlElement(required = true)
    protected GetRulesResponse getReceiptRulesResult;

    /**
     * Gets the value of the getReceiptRulesResult property.
     *
     * @return possible object is
     *         {@link GetRulesResponse }
     */
    public GetRulesResponse getGetReceiptRulesResult() {
        return getReceiptRulesResult;
    }

    /**
     * Sets the value of the getReceiptRulesResult property.
     *
     * @param value allowed object is
     *              {@link GetRulesResponse }
     */
    public void setGetReceiptRulesResult(GetRulesResponse value) {
        this.getReceiptRulesResult = value;
    }

}
