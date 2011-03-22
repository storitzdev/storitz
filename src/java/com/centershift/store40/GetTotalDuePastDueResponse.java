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
 *         &lt;element name="GetTotalDuePastDueResult" type="{http://www.centershift.com/STORE40/}GetTotalDuePastDue_Response"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "getTotalDuePastDueResult"
})
@XmlRootElement(name = "GetTotalDuePastDueResponse")
public class GetTotalDuePastDueResponse {

    @XmlElement(name = "GetTotalDuePastDueResult", required = true)
    protected GetTotalDuePastDueResponse2 getTotalDuePastDueResult;

    /**
     * Gets the value of the getTotalDuePastDueResult property.
     *
     * @return possible object is
     *         {@link GetTotalDuePastDueResponse2 }
     */
    public GetTotalDuePastDueResponse2 getGetTotalDuePastDueResult() {
        return getTotalDuePastDueResult;
    }

    /**
     * Sets the value of the getTotalDuePastDueResult property.
     *
     * @param value allowed object is
     *              {@link GetTotalDuePastDueResponse2 }
     */
    public void setGetTotalDuePastDueResult(GetTotalDuePastDueResponse2 value) {
        this.getTotalDuePastDueResult = value;
    }

}
