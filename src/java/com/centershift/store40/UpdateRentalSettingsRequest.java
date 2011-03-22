package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for UpdateRentalSettings_Request complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="UpdateRentalSettings_Request">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="TaxExempt" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="TaxInfo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DelStep" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="DelScheduleID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="DelExempt" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="OverlockStatus" type="{http://www.centershift.com/STORE40/}OverlockStatus"/>
 *         &lt;element name="RentalId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UpdateRentalSettings_Request", propOrder = {
        "taxExempt",
        "taxInfo",
        "delStep",
        "delScheduleID",
        "delExempt",
        "overlockStatus",
        "rentalId"
})
public class UpdateRentalSettingsRequest {

    @XmlElement(name = "TaxExempt", required = true, type = Boolean.class, nillable = true)
    protected Boolean taxExempt;
    @XmlElement(name = "TaxInfo")
    protected String taxInfo;
    @XmlElement(name = "DelStep", required = true, type = Integer.class, nillable = true)
    protected Integer delStep;
    @XmlElement(name = "DelScheduleID", required = true, type = Long.class, nillable = true)
    protected Long delScheduleID;
    @XmlElement(name = "DelExempt", required = true, type = Boolean.class, nillable = true)
    protected Boolean delExempt;
    @XmlElement(name = "OverlockStatus", required = true, nillable = true)
    protected OverlockStatus overlockStatus;
    @XmlElement(name = "RentalId")
    protected long rentalId;

    /**
     * Gets the value of the taxExempt property.
     *
     * @return possible object is
     *         {@link Boolean }
     */
    public Boolean isTaxExempt() {
        return taxExempt;
    }

    /**
     * Sets the value of the taxExempt property.
     *
     * @param value allowed object is
     *              {@link Boolean }
     */
    public void setTaxExempt(Boolean value) {
        this.taxExempt = value;
    }

    /**
     * Gets the value of the taxInfo property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getTaxInfo() {
        return taxInfo;
    }

    /**
     * Sets the value of the taxInfo property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setTaxInfo(String value) {
        this.taxInfo = value;
    }

    /**
     * Gets the value of the delStep property.
     *
     * @return possible object is
     *         {@link Integer }
     */
    public Integer getDelStep() {
        return delStep;
    }

    /**
     * Sets the value of the delStep property.
     *
     * @param value allowed object is
     *              {@link Integer }
     */
    public void setDelStep(Integer value) {
        this.delStep = value;
    }

    /**
     * Gets the value of the delScheduleID property.
     *
     * @return possible object is
     *         {@link Long }
     */
    public Long getDelScheduleID() {
        return delScheduleID;
    }

    /**
     * Sets the value of the delScheduleID property.
     *
     * @param value allowed object is
     *              {@link Long }
     */
    public void setDelScheduleID(Long value) {
        this.delScheduleID = value;
    }

    /**
     * Gets the value of the delExempt property.
     *
     * @return possible object is
     *         {@link Boolean }
     */
    public Boolean isDelExempt() {
        return delExempt;
    }

    /**
     * Sets the value of the delExempt property.
     *
     * @param value allowed object is
     *              {@link Boolean }
     */
    public void setDelExempt(Boolean value) {
        this.delExempt = value;
    }

    /**
     * Gets the value of the overlockStatus property.
     *
     * @return possible object is
     *         {@link OverlockStatus }
     */
    public OverlockStatus getOverlockStatus() {
        return overlockStatus;
    }

    /**
     * Sets the value of the overlockStatus property.
     *
     * @param value allowed object is
     *              {@link OverlockStatus }
     */
    public void setOverlockStatus(OverlockStatus value) {
        this.overlockStatus = value;
    }

    /**
     * Gets the value of the rentalId property.
     */
    public long getRentalId() {
        return rentalId;
    }

    /**
     * Sets the value of the rentalId property.
     */
    public void setRentalId(long value) {
        this.rentalId = value;
    }

}
