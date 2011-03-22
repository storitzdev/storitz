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
 *         &lt;element name="GetAvailableDepositsResult" type="{http://www.centershift.com/STORE40/}GetAvailableDeposits_Response"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "getAvailableDepositsResult"
})
@XmlRootElement(name = "GetAvailableDepositsResponse")
public class GetAvailableDepositsResponse {

    @XmlElement(name = "GetAvailableDepositsResult", required = true)
    protected GetAvailableDepositsResponse2 getAvailableDepositsResult;

    /**
     * Gets the value of the getAvailableDepositsResult property.
     *
     * @return possible object is
     *         {@link GetAvailableDepositsResponse2 }
     */
    public GetAvailableDepositsResponse2 getGetAvailableDepositsResult() {
        return getAvailableDepositsResult;
    }

    /**
     * Sets the value of the getAvailableDepositsResult property.
     *
     * @param value allowed object is
     *              {@link GetAvailableDepositsResponse2 }
     */
    public void setGetAvailableDepositsResult(GetAvailableDepositsResponse2 value) {
        this.getAvailableDepositsResult = value;
    }

}
