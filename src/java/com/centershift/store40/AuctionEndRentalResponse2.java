package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AuctionEndRental_Response complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="AuctionEndRental_Response">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AuctionsSummary" type="{http://www.centershift.com/STORE40/}ArrayOfAuctionEndRentalSummary" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AuctionEndRental_Response", propOrder = {
        "auctionsSummary"
})
public class AuctionEndRentalResponse2 {

    @XmlElement(name = "AuctionsSummary")
    protected ArrayOfAuctionEndRentalSummary auctionsSummary;

    /**
     * Gets the value of the auctionsSummary property.
     *
     * @return possible object is
     *         {@link ArrayOfAuctionEndRentalSummary }
     */
    public ArrayOfAuctionEndRentalSummary getAuctionsSummary() {
        return auctionsSummary;
    }

    /**
     * Sets the value of the auctionsSummary property.
     *
     * @param value allowed object is
     *              {@link ArrayOfAuctionEndRentalSummary }
     */
    public void setAuctionsSummary(ArrayOfAuctionEndRentalSummary value) {
        this.auctionsSummary = value;
    }

}
