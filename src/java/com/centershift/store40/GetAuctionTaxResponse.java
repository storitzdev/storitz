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
 *         &lt;element name="GetAuctionTaxResult" type="{http://www.centershift.com/STORE40/}GetAuctionTax_Response"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "getAuctionTaxResult"
})
@XmlRootElement(name = "GetAuctionTaxResponse")
public class GetAuctionTaxResponse {

    @XmlElement(name = "GetAuctionTaxResult", required = true)
    protected GetAuctionTaxResponse2 getAuctionTaxResult;

    /**
     * Gets the value of the getAuctionTaxResult property.
     *
     * @return possible object is
     *         {@link GetAuctionTaxResponse2 }
     */
    public GetAuctionTaxResponse2 getGetAuctionTaxResult() {
        return getAuctionTaxResult;
    }

    /**
     * Sets the value of the getAuctionTaxResult property.
     *
     * @param value allowed object is
     *              {@link GetAuctionTaxResponse2 }
     */
    public void setGetAuctionTaxResult(GetAuctionTaxResponse2 value) {
        this.getAuctionTaxResult = value;
    }

}
