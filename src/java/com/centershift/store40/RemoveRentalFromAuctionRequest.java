package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RemoveRentalFromAuction_Request complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="RemoveRentalFromAuction_Request">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SiteID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="RentalIDs" type="{http://www.centershift.com/STORE40/}ArrayOfLong3" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RemoveRentalFromAuction_Request", propOrder = {
        "siteID",
        "rentalIDs"
})
public class RemoveRentalFromAuctionRequest {

    @XmlElement(name = "SiteID")
    protected long siteID;
    @XmlElement(name = "RentalIDs")
    protected ArrayOfLong3 rentalIDs;

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
     * Gets the value of the rentalIDs property.
     *
     * @return possible object is
     *         {@link ArrayOfLong3 }
     */
    public ArrayOfLong3 getRentalIDs() {
        return rentalIDs;
    }

    /**
     * Sets the value of the rentalIDs property.
     *
     * @param value allowed object is
     *              {@link ArrayOfLong3 }
     */
    public void setRentalIDs(ArrayOfLong3 value) {
        this.rentalIDs = value;
    }

}
