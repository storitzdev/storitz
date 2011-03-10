
package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ViewLease_Request complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ViewLease_Request">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SiteID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="LeaseId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="RentalId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ViewLease_Request", propOrder = {
    "siteID",
    "leaseId",
    "rentalId"
})
public class ViewLeaseRequest {

    @XmlElement(name = "SiteID")
    protected long siteID;
    @XmlElement(name = "LeaseId")
    protected long leaseId;
    @XmlElement(name = "RentalId")
    protected long rentalId;

    /**
     * Gets the value of the siteID property.
     * 
     */
    public long getSiteID() {
        return siteID;
    }

    /**
     * Sets the value of the siteID property.
     * 
     */
    public void setSiteID(long value) {
        this.siteID = value;
    }

    /**
     * Gets the value of the leaseId property.
     * 
     */
    public long getLeaseId() {
        return leaseId;
    }

    /**
     * Sets the value of the leaseId property.
     * 
     */
    public void setLeaseId(long value) {
        this.leaseId = value;
    }

    /**
     * Gets the value of the rentalId property.
     * 
     */
    public long getRentalId() {
        return rentalId;
    }

    /**
     * Sets the value of the rentalId property.
     * 
     */
    public void setRentalId(long value) {
        this.rentalId = value;
    }

}
