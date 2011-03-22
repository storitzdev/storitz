package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.math.BigDecimal;


/**
 * <p>Java class for QuoteData complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="QuoteData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="RentRate" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="Fees" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="Discounts" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="Deposits" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="Taxes" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="Total" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "QuoteData", propOrder = {
        "rentRate",
        "fees",
        "discounts",
        "deposits",
        "taxes",
        "total"
})
public class QuoteData {

    @XmlElement(name = "RentRate", required = true)
    protected BigDecimal rentRate;
    @XmlElement(name = "Fees", required = true, nillable = true)
    protected BigDecimal fees;
    @XmlElement(name = "Discounts", required = true, nillable = true)
    protected BigDecimal discounts;
    @XmlElement(name = "Deposits", required = true, nillable = true)
    protected BigDecimal deposits;
    @XmlElement(name = "Taxes", required = true, nillable = true)
    protected BigDecimal taxes;
    @XmlElement(name = "Total", required = true)
    protected BigDecimal total;

    /**
     * Gets the value of the rentRate property.
     *
     * @return possible object is
     *         {@link BigDecimal }
     */
    public BigDecimal getRentRate() {
        return rentRate;
    }

    /**
     * Sets the value of the rentRate property.
     *
     * @param value allowed object is
     *              {@link BigDecimal }
     */
    public void setRentRate(BigDecimal value) {
        this.rentRate = value;
    }

    /**
     * Gets the value of the fees property.
     *
     * @return possible object is
     *         {@link BigDecimal }
     */
    public BigDecimal getFees() {
        return fees;
    }

    /**
     * Sets the value of the fees property.
     *
     * @param value allowed object is
     *              {@link BigDecimal }
     */
    public void setFees(BigDecimal value) {
        this.fees = value;
    }

    /**
     * Gets the value of the discounts property.
     *
     * @return possible object is
     *         {@link BigDecimal }
     */
    public BigDecimal getDiscounts() {
        return discounts;
    }

    /**
     * Sets the value of the discounts property.
     *
     * @param value allowed object is
     *              {@link BigDecimal }
     */
    public void setDiscounts(BigDecimal value) {
        this.discounts = value;
    }

    /**
     * Gets the value of the deposits property.
     *
     * @return possible object is
     *         {@link BigDecimal }
     */
    public BigDecimal getDeposits() {
        return deposits;
    }

    /**
     * Sets the value of the deposits property.
     *
     * @param value allowed object is
     *              {@link BigDecimal }
     */
    public void setDeposits(BigDecimal value) {
        this.deposits = value;
    }

    /**
     * Gets the value of the taxes property.
     *
     * @return possible object is
     *         {@link BigDecimal }
     */
    public BigDecimal getTaxes() {
        return taxes;
    }

    /**
     * Sets the value of the taxes property.
     *
     * @param value allowed object is
     *              {@link BigDecimal }
     */
    public void setTaxes(BigDecimal value) {
        this.taxes = value;
    }

    /**
     * Gets the value of the total property.
     *
     * @return possible object is
     *         {@link BigDecimal }
     */
    public BigDecimal getTotal() {
        return total;
    }

    /**
     * Sets the value of the total property.
     *
     * @param value allowed object is
     *              {@link BigDecimal }
     */
    public void setTotal(BigDecimal value) {
        this.total = value;
    }

}
