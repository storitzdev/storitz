package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for UpdateInsurance_Request complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="UpdateInsurance_Request">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SiteID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="RentalID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="NewInsuranceOptionID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UpdateInsurance_Request", propOrder = {
        "siteID",
        "rentalID",
        "newInsuranceOptionID"
})
public class UpdateInsuranceRequest {

    @XmlElement(name = "SiteID")
    protected long siteID;
    @XmlElement(name = "RentalID")
    protected long rentalID;
    @XmlElement(name = "NewInsuranceOptionID")
    protected long newInsuranceOptionID;

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
     * Gets the value of the newInsuranceOptionID property.
     */
    public long getNewInsuranceOptionID() {
        return newInsuranceOptionID;
    }

    /**
     * Sets the value of the newInsuranceOptionID property.
     */
    public void setNewInsuranceOptionID(long value) {
        this.newInsuranceOptionID = value;
    }

}