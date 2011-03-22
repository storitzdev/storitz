package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TerminateService_Request complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="TerminateService_Request">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SiteID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="ServiceRentalID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="ServiceType" type="{http://www.centershift.com/STORE40/}serviceTypeVals"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TerminateService_Request", propOrder = {
        "siteID",
        "serviceRentalID",
        "serviceType"
})
public class TerminateServiceRequest {

    @XmlElement(name = "SiteID")
    protected long siteID;
    @XmlElement(name = "ServiceRentalID")
    protected long serviceRentalID;
    @XmlElement(name = "ServiceType", required = true)
    protected ServiceTypeVals serviceType;

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
     * Gets the value of the serviceRentalID property.
     */
    public long getServiceRentalID() {
        return serviceRentalID;
    }

    /**
     * Sets the value of the serviceRentalID property.
     */
    public void setServiceRentalID(long value) {
        this.serviceRentalID = value;
    }

    /**
     * Gets the value of the serviceType property.
     *
     * @return possible object is
     *         {@link ServiceTypeVals }
     */
    public ServiceTypeVals getServiceType() {
        return serviceType;
    }

    /**
     * Sets the value of the serviceType property.
     *
     * @param value allowed object is
     *              {@link ServiceTypeVals }
     */
    public void setServiceType(ServiceTypeVals value) {
        this.serviceType = value;
    }

}
