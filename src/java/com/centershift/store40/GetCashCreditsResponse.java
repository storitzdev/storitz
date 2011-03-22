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
 *         &lt;element name="GetCashCreditsResult" type="{http://www.centershift.com/STORE40/}GetCashCredits_Response"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "getCashCreditsResult"
})
@XmlRootElement(name = "GetCashCreditsResponse")
public class GetCashCreditsResponse {

    @XmlElement(name = "GetCashCreditsResult", required = true)
    protected GetCashCreditsResponse2 getCashCreditsResult;

    /**
     * Gets the value of the getCashCreditsResult property.
     *
     * @return possible object is
     *         {@link GetCashCreditsResponse2 }
     */
    public GetCashCreditsResponse2 getGetCashCreditsResult() {
        return getCashCreditsResult;
    }

    /**
     * Sets the value of the getCashCreditsResult property.
     *
     * @param value allowed object is
     *              {@link GetCashCreditsResponse2 }
     */
    public void setGetCashCreditsResult(GetCashCreditsResponse2 value) {
        this.getCashCreditsResult = value;
    }

}
