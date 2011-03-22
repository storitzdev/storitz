package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GetAuctions_Request complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="GetAuctions_Request">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SiteID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="Status" type="{http://www.centershift.com/STORE40/}ArrayOfAuctionStatusValues" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetAuctions_Request", propOrder = {
        "siteID",
        "status"
})
public class GetAuctionsRequest {

    @XmlElement(name = "SiteID")
    protected long siteID;
    @XmlElement(name = "Status")
    protected ArrayOfAuctionStatusValues status;

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
     * Gets the value of the status property.
     *
     * @return possible object is
     *         {@link ArrayOfAuctionStatusValues }
     */
    public ArrayOfAuctionStatusValues getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     *
     * @param value allowed object is
     *              {@link ArrayOfAuctionStatusValues }
     */
    public void setStatus(ArrayOfAuctionStatusValues value) {
        this.status = value;
    }

}
