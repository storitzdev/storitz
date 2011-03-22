package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AuctionProceeds complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="AuctionProceeds">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SiteID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="AuctionProceedsAmount" type="{http://www.centershift.com/STORE40/}ArrayOfDecimal" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AuctionProceeds", propOrder = {
        "siteID",
        "auctionProceedsAmount"
})
public class AuctionProceeds {

    @XmlElement(name = "SiteID")
    protected long siteID;
    @XmlElement(name = "AuctionProceedsAmount")
    protected ArrayOfDecimal auctionProceedsAmount;

    /**
     * Gets the value of the siteID property.
     */
    public long getSiteID() {
        return siteID;
    }

    /**
     * Sets the value of the siteID property.
     */
    public void setSiteID(long value) {
        this.siteID = value;
    }

    /**
     * Gets the value of the auctionProceedsAmount property.
     *
     * @return possible object is
     *         {@link ArrayOfDecimal }
     */
    public ArrayOfDecimal getAuctionProceedsAmount() {
        return auctionProceedsAmount;
    }

    /**
     * Sets the value of the auctionProceedsAmount property.
     *
     * @param value allowed object is
     *              {@link ArrayOfDecimal }
     */
    public void setAuctionProceedsAmount(ArrayOfDecimal value) {
        this.auctionProceedsAmount = value;
    }

}
