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
 *         &lt;element name="GetTotalDueResult" type="{http://www.centershift.com/STORE40/}GetTotalDue_Response"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "getTotalDueResult"
})
@XmlRootElement(name = "GetTotalDueResponse")
public class GetTotalDueResponse {

    @XmlElement(name = "GetTotalDueResult", required = true)
    protected GetTotalDueResponse2 getTotalDueResult;

    /**
     * Gets the value of the getTotalDueResult property.
     *
     * @return possible object is
     *         {@link GetTotalDueResponse2 }
     */
    public GetTotalDueResponse2 getGetTotalDueResult() {
        return getTotalDueResult;
    }

    /**
     * Sets the value of the getTotalDueResult property.
     *
     * @param value allowed object is
     *              {@link GetTotalDueResponse2 }
     */
    public void setGetTotalDueResult(GetTotalDueResponse2 value) {
        this.getTotalDueResult = value;
    }

}
