package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.math.BigDecimal;


/**
 * <p>Java class for TransUnitAssessments complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="TransUnitAssessments">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AssessID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="RentalID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="Description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ItemPrice" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="Quantity" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="ExtendedPrice" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="AmountFulFilled" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="Tax" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="TaxFulFilled" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TransUnitAssessments", propOrder = {
        "assessID",
        "rentalID",
        "description",
        "itemPrice",
        "quantity",
        "extendedPrice",
        "amountFulFilled",
        "tax",
        "taxFulFilled"
})
public class TransUnitAssessments {

    @XmlElement(name = "AssessID")
    protected long assessID;
    @XmlElement(name = "RentalID")
    protected long rentalID;
    @XmlElement(name = "Description")
    protected String description;
    @XmlElement(name = "ItemPrice", required = true)
    protected BigDecimal itemPrice;
    @XmlElement(name = "Quantity")
    protected int quantity;
    @XmlElement(name = "ExtendedPrice", required = true)
    protected BigDecimal extendedPrice;
    @XmlElement(name = "AmountFulFilled", required = true)
    protected BigDecimal amountFulFilled;
    @XmlElement(name = "Tax", required = true)
    protected BigDecimal tax;
    @XmlElement(name = "TaxFulFilled", required = true)
    protected BigDecimal taxFulFilled;

    /**
     * Gets the value of the assessID property.
     */
    public long getAssessID() {
        return assessID;
    }

    /**
     * Sets the value of the assessID property.
     */
    public void setAssessID(long value) {
        this.assessID = value;
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
     * Gets the value of the description property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Gets the value of the itemPrice property.
     *
     * @return possible object is
     *         {@link BigDecimal }
     */
    public BigDecimal getItemPrice() {
        return itemPrice;
    }

    /**
     * Sets the value of the itemPrice property.
     *
     * @param value allowed object is
     *              {@link BigDecimal }
     */
    public void setItemPrice(BigDecimal value) {
        this.itemPrice = value;
    }

    /**
     * Gets the value of the quantity property.
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Sets the value of the quantity property.
     */
    public void setQuantity(int value) {
        this.quantity = value;
    }

    /**
     * Gets the value of the extendedPrice property.
     *
     * @return possible object is
     *         {@link BigDecimal }
     */
    public BigDecimal getExtendedPrice() {
        return extendedPrice;
    }

    /**
     * Sets the value of the extendedPrice property.
     *
     * @param value allowed object is
     *              {@link BigDecimal }
     */
    public void setExtendedPrice(BigDecimal value) {
        this.extendedPrice = value;
    }

    /**
     * Gets the value of the amountFulFilled property.
     *
     * @return possible object is
     *         {@link BigDecimal }
     */
    public BigDecimal getAmountFulFilled() {
        return amountFulFilled;
    }

    /**
     * Sets the value of the amountFulFilled property.
     *
     * @param value allowed object is
     *              {@link BigDecimal }
     */
    public void setAmountFulFilled(BigDecimal value) {
        this.amountFulFilled = value;
    }

    /**
     * Gets the value of the tax property.
     *
     * @return possible object is
     *         {@link BigDecimal }
     */
    public BigDecimal getTax() {
        return tax;
    }

    /**
     * Sets the value of the tax property.
     *
     * @param value allowed object is
     *              {@link BigDecimal }
     */
    public void setTax(BigDecimal value) {
        this.tax = value;
    }

    /**
     * Gets the value of the taxFulFilled property.
     *
     * @return possible object is
     *         {@link BigDecimal }
     */
    public BigDecimal getTaxFulFilled() {
        return taxFulFilled;
    }

    /**
     * Sets the value of the taxFulFilled property.
     *
     * @param value allowed object is
     *              {@link BigDecimal }
     */
    public void setTaxFulFilled(BigDecimal value) {
        this.taxFulFilled = value;
    }

}
