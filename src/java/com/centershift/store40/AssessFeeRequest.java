package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AssessFee_Request complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="AssessFee_Request">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SiteID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="RentalID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="BaseFeeObj" type="{http://www.centershift.com/STORE40/}ORG_FEE_SITE_ALL" minOccurs="0"/>
 *         &lt;element name="SchedFeeObj" type="{http://www.centershift.com/STORE40/}ScheduledFee" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AssessFee_Request", propOrder = {
        "siteID",
        "rentalID",
        "baseFeeObj",
        "schedFeeObj"
})
public class AssessFeeRequest {

    @XmlElement(name = "SiteID")
    protected long siteID;
    @XmlElement(name = "RentalID")
    protected long rentalID;
    @XmlElement(name = "BaseFeeObj")
    protected ORGFEESITEALL baseFeeObj;
    @XmlElement(name = "SchedFeeObj")
    protected ScheduledFee schedFeeObj;

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
     * Gets the value of the baseFeeObj property.
     *
     * @return possible object is
     *         {@link ORGFEESITEALL }
     */
    public ORGFEESITEALL getBaseFeeObj() {
        return baseFeeObj;
    }

    /**
     * Sets the value of the baseFeeObj property.
     *
     * @param value allowed object is
     *              {@link ORGFEESITEALL }
     */
    public void setBaseFeeObj(ORGFEESITEALL value) {
        this.baseFeeObj = value;
    }

    /**
     * Gets the value of the schedFeeObj property.
     *
     * @return possible object is
     *         {@link ScheduledFee }
     */
    public ScheduledFee getSchedFeeObj() {
        return schedFeeObj;
    }

    /**
     * Sets the value of the schedFeeObj property.
     *
     * @param value allowed object is
     *              {@link ScheduledFee }
     */
    public void setSchedFeeObj(ScheduledFee value) {
        this.schedFeeObj = value;
    }

}
