package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AddService_Request complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="AddService_Request">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SiteID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="RentalID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="Service" type="{http://www.centershift.com/STORE40/}ORG_SERVICE_SITE_OFFERINGS" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AddService_Request", propOrder = {
        "siteID",
        "rentalID",
        "service"
})
public class AddServiceRequest {

    @XmlElement(name = "SiteID")
    protected long siteID;
    @XmlElement(name = "RentalID")
    protected long rentalID;
    @XmlElement(name = "Service")
    protected ORGSERVICESITEOFFERINGS service;

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
     * Gets the value of the rentalID property.
     */
    public long getRentalID() {
        return rentalID;
    }

    /**
     * Sets the value of the rentalID property.
     */
    public void setRentalID(long value) {
        this.rentalID = value;
    }

    /**
     * Gets the value of the service property.
     *
     * @return possible object is
     *         {@link ORGSERVICESITEOFFERINGS }
     */
    public ORGSERVICESITEOFFERINGS getService() {
        return service;
    }

    /**
     * Sets the value of the service property.
     *
     * @param value allowed object is
     *              {@link ORGSERVICESITEOFFERINGS }
     */
    public void setService(ORGSERVICESITEOFFERINGS value) {
        this.service = value;
    }

}
