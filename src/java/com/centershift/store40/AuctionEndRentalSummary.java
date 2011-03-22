package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AuctionEndRentalSummary complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="AuctionEndRentalSummary">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AuctionID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="CompletionDetail" type="{http://www.centershift.com/STORE40/}ArrayOfAuctionEndRentalComplete1" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AuctionEndRentalSummary", propOrder = {
        "auctionID",
        "completionDetail"
})
public class AuctionEndRentalSummary {

    @XmlElement(name = "AuctionID")
    protected long auctionID;
    @XmlElement(name = "CompletionDetail")
    protected ArrayOfAuctionEndRentalComplete1 completionDetail;

    /**
     * Gets the value of the auctionID property.
     */
    public long getAuctionID() {
        return auctionID;
    }

    /**
     * Sets the value of the auctionID property.
     */
    public void setAuctionID(long value) {
        this.auctionID = value;
    }

    /**
     * Gets the value of the completionDetail property.
     *
     * @return possible object is
     *         {@link ArrayOfAuctionEndRentalComplete1 }
     */
    public ArrayOfAuctionEndRentalComplete1 getCompletionDetail() {
        return completionDetail;
    }

    /**
     * Sets the value of the completionDetail property.
     *
     * @param value allowed object is
     *              {@link ArrayOfAuctionEndRentalComplete1 }
     */
    public void setCompletionDetail(ArrayOfAuctionEndRentalComplete1 value) {
        this.completionDetail = value;
    }

}
