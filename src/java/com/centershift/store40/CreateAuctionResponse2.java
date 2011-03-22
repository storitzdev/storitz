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
 *         &lt;element name="CreateAuctionResult" type="{http://www.centershift.com/STORE40/}CreateAuction_Response"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "createAuctionResult"
})
@XmlRootElement(name = "CreateAuctionResponse")
public class CreateAuctionResponse2 {

    @XmlElement(name = "CreateAuctionResult", required = true)
    protected CreateAuctionResponse createAuctionResult;

    /**
     * Gets the value of the createAuctionResult property.
     *
     * @return possible object is
     *         {@link CreateAuctionResponse }
     */
    public CreateAuctionResponse getCreateAuctionResult() {
        return createAuctionResult;
    }

    /**
     * Sets the value of the createAuctionResult property.
     *
     * @param value allowed object is
     *              {@link CreateAuctionResponse }
     */
    public void setCreateAuctionResult(CreateAuctionResponse value) {
        this.createAuctionResult = value;
    }

}
