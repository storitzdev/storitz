package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.math.BigDecimal;


/**
 * <p>Java class for CheckData complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="CheckData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Amount" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="CheckNumber" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="CheckType" type="{http://www.centershift.com/STORE40/}paymentTypeLookupOrder"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CheckData", propOrder = {
        "amount",
        "checkNumber",
        "checkType"
})
public class CheckData {

    @XmlElement(name = "Amount", required = true)
    protected BigDecimal amount;
    @XmlElement(name = "CheckNumber")
    protected long checkNumber;
    @XmlElement(name = "CheckType", required = true)
    protected PaymentTypeLookupOrder checkType;

    /**
     * Gets the value of the amount property.
     *
     * @return possible object is
     *         {@link BigDecimal }
     */
    public BigDecimal getAmount() {
        return amount;
    }

    /**
     * Sets the value of the amount property.
     *
     * @param value allowed object is
     *              {@link BigDecimal }
     */
    public void setAmount(BigDecimal value) {
        this.amount = value;
    }

    /**
     * Gets the value of the checkNumber property.
     */
    public long getCheckNumber() {
        return checkNumber;
    }

    /**
     * Sets the value of the checkNumber property.
     */
    public void setCheckNumber(long value) {
        this.checkNumber = value;
    }

    /**
     * Gets the value of the checkType property.
     *
     * @return possible object is
     *         {@link PaymentTypeLookupOrder }
     */
    public PaymentTypeLookupOrder getCheckType() {
        return checkType;
    }

    /**
     * Sets the value of the checkType property.
     *
     * @param value allowed object is
     *              {@link PaymentTypeLookupOrder }
     */
    public void setCheckType(PaymentTypeLookupOrder value) {
        this.checkType = value;
    }

}
