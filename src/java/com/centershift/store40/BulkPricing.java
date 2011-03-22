package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.math.BigDecimal;


/**
 * <p>Java class for BulkPricing complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="BulkPricing">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="RetailId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="MinThreshold" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="DiscountAmount" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="DiscountType" type="{http://www.centershift.com/STORE40/}BulkDiscountTypes"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BulkPricing", propOrder = {
        "retailId",
        "minThreshold",
        "discountAmount",
        "discountType"
})
public class BulkPricing {

    @XmlElement(name = "RetailId", required = true, type = Long.class, nillable = true)
    protected Long retailId;
    @XmlElement(name = "MinThreshold", required = true, type = Integer.class, nillable = true)
    protected Integer minThreshold;
    @XmlElement(name = "DiscountAmount", required = true, nillable = true)
    protected BigDecimal discountAmount;
    @XmlElement(name = "DiscountType", required = true, nillable = true)
    protected BulkDiscountTypes discountType;

    /**
     * Gets the value of the retailId property.
     *
     * @return possible object is
     *         {@link Long }
     */
    public Long getRetailId() {
        return retailId;
    }

    /**
     * Sets the value of the retailId property.
     *
     * @param value allowed object is
     *              {@link Long }
     */
    public void setRetailId(Long value) {
        this.retailId = value;
    }

    /**
     * Gets the value of the minThreshold property.
     *
     * @return possible object is
     *         {@link Integer }
     */
    public Integer getMinThreshold() {
        return minThreshold;
    }

    /**
     * Sets the value of the minThreshold property.
     *
     * @param value allowed object is
     *              {@link Integer }
     */
    public void setMinThreshold(Integer value) {
        this.minThreshold = value;
    }

    /**
     * Gets the value of the discountAmount property.
     *
     * @return possible object is
     *         {@link BigDecimal }
     */
    public BigDecimal getDiscountAmount() {
        return discountAmount;
    }

    /**
     * Sets the value of the discountAmount property.
     *
     * @param value allowed object is
     *              {@link BigDecimal }
     */
    public void setDiscountAmount(BigDecimal value) {
        this.discountAmount = value;
    }

    /**
     * Gets the value of the discountType property.
     *
     * @return possible object is
     *         {@link BulkDiscountTypes }
     */
    public BulkDiscountTypes getDiscountType() {
        return discountType;
    }

    /**
     * Sets the value of the discountType property.
     *
     * @param value allowed object is
     *              {@link BulkDiscountTypes }
     */
    public void setDiscountType(BulkDiscountTypes value) {
        this.discountType = value;
    }

}
