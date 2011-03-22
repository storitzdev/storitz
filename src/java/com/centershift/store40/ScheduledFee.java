package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.math.BigDecimal;


/**
 * <p>Java class for ScheduledFee complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="ScheduledFee">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="OrgFeeObjectId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="FeeObjectId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="RefType" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="BaseFeeType" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="FeeAmount" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="FeeDescription" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Taxable" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="Active" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ScheduledFee", propOrder = {
        "orgFeeObjectId",
        "feeObjectId",
        "refType",
        "baseFeeType",
        "feeAmount",
        "feeDescription",
        "taxable",
        "active"
})
public class ScheduledFee {

    @XmlElement(name = "OrgFeeObjectId", required = true, type = Long.class, nillable = true)
    protected Long orgFeeObjectId;
    @XmlElement(name = "FeeObjectId", required = true, type = Long.class, nillable = true)
    protected Long feeObjectId;
    @XmlElement(name = "RefType")
    protected int refType;
    @XmlElement(name = "BaseFeeType")
    protected int baseFeeType;
    @XmlElement(name = "FeeAmount", required = true)
    protected BigDecimal feeAmount;
    @XmlElement(name = "FeeDescription")
    protected String feeDescription;
    @XmlElement(name = "Taxable", required = true, type = Boolean.class, nillable = true)
    protected Boolean taxable;
    @XmlElement(name = "Active", required = true, type = Boolean.class, nillable = true)
    protected Boolean active;

    /**
     * Gets the value of the orgFeeObjectId property.
     *
     * @return possible object is
     *         {@link Long }
     */
    public Long getOrgFeeObjectId() {
        return orgFeeObjectId;
    }

    /**
     * Sets the value of the orgFeeObjectId property.
     *
     * @param value allowed object is
     *              {@link Long }
     */
    public void setOrgFeeObjectId(Long value) {
        this.orgFeeObjectId = value;
    }

    /**
     * Gets the value of the feeObjectId property.
     *
     * @return possible object is
     *         {@link Long }
     */
    public Long getFeeObjectId() {
        return feeObjectId;
    }

    /**
     * Sets the value of the feeObjectId property.
     *
     * @param value allowed object is
     *              {@link Long }
     */
    public void setFeeObjectId(Long value) {
        this.feeObjectId = value;
    }

    /**
     * Gets the value of the refType property.
     */
    public int getRefType() {
        return refType;
    }

    /**
     * Sets the value of the refType property.
     */
    public void setRefType(int value) {
        this.refType = value;
    }

    /**
     * Gets the value of the baseFeeType property.
     */
    public int getBaseFeeType() {
        return baseFeeType;
    }

    /**
     * Sets the value of the baseFeeType property.
     */
    public void setBaseFeeType(int value) {
        this.baseFeeType = value;
    }

    /**
     * Gets the value of the feeAmount property.
     *
     * @return possible object is
     *         {@link BigDecimal }
     */
    public BigDecimal getFeeAmount() {
        return feeAmount;
    }

    /**
     * Sets the value of the feeAmount property.
     *
     * @param value allowed object is
     *              {@link BigDecimal }
     */
    public void setFeeAmount(BigDecimal value) {
        this.feeAmount = value;
    }

    /**
     * Gets the value of the feeDescription property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getFeeDescription() {
        return feeDescription;
    }

    /**
     * Sets the value of the feeDescription property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setFeeDescription(String value) {
        this.feeDescription = value;
    }

    /**
     * Gets the value of the taxable property.
     *
     * @return possible object is
     *         {@link Boolean }
     */
    public Boolean isTaxable() {
        return taxable;
    }

    /**
     * Sets the value of the taxable property.
     *
     * @param value allowed object is
     *              {@link Boolean }
     */
    public void setTaxable(Boolean value) {
        this.taxable = value;
    }

    /**
     * Gets the value of the active property.
     *
     * @return possible object is
     *         {@link Boolean }
     */
    public Boolean isActive() {
        return active;
    }

    /**
     * Sets the value of the active property.
     *
     * @param value allowed object is
     *              {@link Boolean }
     */
    public void setActive(Boolean value) {
        this.active = value;
    }

}
