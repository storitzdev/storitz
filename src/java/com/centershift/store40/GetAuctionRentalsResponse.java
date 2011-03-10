
package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="GetAuctionRentalsResult" type="{http://www.centershift.com/STORE40/}GetAuctionRentals_Response"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "getAuctionRentalsResult"
})
@XmlRootElement(name = "GetAuctionRentalsResponse")
public class GetAuctionRentalsResponse {

    @XmlElement(name = "GetAuctionRentalsResult", required = true)
    protected GetAuctionRentalsResponse2 getAuctionRentalsResult;

    /**
     * Gets the value of the getAuctionRentalsResult property.
     * 
     * @return
     *     possible object is
     *     {@link GetAuctionRentalsResponse2 }
     *     
     */
    public GetAuctionRentalsResponse2 getGetAuctionRentalsResult() {
        return getAuctionRentalsResult;
    }

    /**
     * Sets the value of the getAuctionRentalsResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetAuctionRentalsResponse2 }
     *     
     */
    public void setGetAuctionRentalsResult(GetAuctionRentalsResponse2 value) {
        this.getAuctionRentalsResult = value;
    }

}
