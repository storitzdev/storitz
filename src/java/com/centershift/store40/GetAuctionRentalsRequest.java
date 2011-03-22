package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GetAuctionRentals_Request complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="GetAuctionRentals_Request">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SiteID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="AuctionID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetAuctionRentals_Request", propOrder = {
        "siteID",
        "auctionID"
})
public class GetAuctionRentalsRequest {

    @XmlElement(name = "SiteID")
    protected long siteID;
    @XmlElement(name = "AuctionID", required = true, type = Long.class, nillable = true)
    protected Long auctionID;

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
     * Gets the value of the auctionID property.
     *
     * @return possible object is
     *         {@link Long }
     */
    public Long getAuctionID() {
        return auctionID;
    }

    /**
     * Sets the value of the auctionID property.
     *
     * @param value allowed object is
     *              {@link Long }
     */
    public void setAuctionID(Long value) {
        this.auctionID = value;
    }

}
