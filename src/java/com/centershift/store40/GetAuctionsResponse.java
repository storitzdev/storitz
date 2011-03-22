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
 *         &lt;element name="GetAuctionsResult" type="{http://www.centershift.com/STORE40/}GetAuctions_Response"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "getAuctionsResult"
})
@XmlRootElement(name = "GetAuctionsResponse")
public class GetAuctionsResponse {

    @XmlElement(name = "GetAuctionsResult", required = true)
    protected GetAuctionsResponse2 getAuctionsResult;

    /**
     * Gets the value of the getAuctionsResult property.
     *
     * @return possible object is
     *         {@link GetAuctionsResponse2 }
     */
    public GetAuctionsResponse2 getGetAuctionsResult() {
        return getAuctionsResult;
    }

    /**
     * Sets the value of the getAuctionsResult property.
     *
     * @param value allowed object is
     *              {@link GetAuctionsResponse2 }
     */
    public void setGetAuctionsResult(GetAuctionsResponse2 value) {
        this.getAuctionsResult = value;
    }

}
