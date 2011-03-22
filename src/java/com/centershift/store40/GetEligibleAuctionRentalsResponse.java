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
 *         &lt;element name="GetEligibleAuctionRentalsResult" type="{http://www.centershift.com/STORE40/}GetEligibleAuctionRentals_Response"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "getEligibleAuctionRentalsResult"
})
@XmlRootElement(name = "GetEligibleAuctionRentalsResponse")
public class GetEligibleAuctionRentalsResponse {

    @XmlElement(name = "GetEligibleAuctionRentalsResult", required = true)
    protected GetEligibleAuctionRentalsResponse2 getEligibleAuctionRentalsResult;

    /**
     * Gets the value of the getEligibleAuctionRentalsResult property.
     *
     * @return possible object is
     *         {@link GetEligibleAuctionRentalsResponse2 }
     */
    public GetEligibleAuctionRentalsResponse2 getGetEligibleAuctionRentalsResult() {
        return getEligibleAuctionRentalsResult;
    }

    /**
     * Sets the value of the getEligibleAuctionRentalsResult property.
     *
     * @param value allowed object is
     *              {@link GetEligibleAuctionRentalsResponse2 }
     */
    public void setGetEligibleAuctionRentalsResult(GetEligibleAuctionRentalsResponse2 value) {
        this.getEligibleAuctionRentalsResult = value;
    }

}
