
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
 *         &lt;element name="UpdateAuctionResult" type="{http://www.centershift.com/STORE40/}CreateAuction_Response"/>
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
    "updateAuctionResult"
})
@XmlRootElement(name = "UpdateAuctionResponse")
public class UpdateAuctionResponse {

    @XmlElement(name = "UpdateAuctionResult", required = true)
    protected CreateAuctionResponse updateAuctionResult;

    /**
     * Gets the value of the updateAuctionResult property.
     * 
     * @return
     *     possible object is
     *     {@link CreateAuctionResponse }
     *     
     */
    public CreateAuctionResponse getUpdateAuctionResult() {
        return updateAuctionResult;
    }

    /**
     * Sets the value of the updateAuctionResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link CreateAuctionResponse }
     *     
     */
    public void setUpdateAuctionResult(CreateAuctionResponse value) {
        this.updateAuctionResult = value;
    }

}
