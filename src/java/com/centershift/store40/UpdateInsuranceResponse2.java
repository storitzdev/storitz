package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.math.BigDecimal;


/**
 * <p>Java class for UpdateInsurance_Response complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="UpdateInsurance_Response">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CreditsReturned" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="AmountDueAfterUpdate" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="TransactionID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="InsuranceRentalID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UpdateInsurance_Response", propOrder = {
        "creditsReturned",
        "amountDueAfterUpdate",
        "transactionID",
        "insuranceRentalID"
})
public class UpdateInsuranceResponse2 {

    @XmlElement(name = "CreditsReturned", required = true, nillable = true)
    protected BigDecimal creditsReturned;
    @XmlElement(name = "AmountDueAfterUpdate", required = true, nillable = true)
    protected BigDecimal amountDueAfterUpdate;
    @XmlElement(name = "TransactionID", required = true, type = Long.class, nillable = true)
    protected Long transactionID;
    @XmlElement(name = "InsuranceRentalID", required = true, type = Long.class, nillable = true)
    protected Long insuranceRentalID;

    /**
     * Gets the value of the creditsReturned property.
     *
     * @return possible object is
     *         {@link BigDecimal }
     */
    public BigDecimal getCreditsReturned() {
        return creditsReturned;
    }

    /**
     * Sets the value of the creditsReturned property.
     *
     * @param value allowed object is
     *              {@link BigDecimal }
     */
    public void setCreditsReturned(BigDecimal value) {
        this.creditsReturned = value;
    }

    /**
     * Gets the value of the amountDueAfterUpdate property.
     *
     * @return possible object is
     *         {@link BigDecimal }
     */
    public BigDecimal getAmountDueAfterUpdate() {
        return amountDueAfterUpdate;
    }

    /**
     * Sets the value of the amountDueAfterUpdate property.
     *
     * @param value allowed object is
     *              {@link BigDecimal }
     */
    public void setAmountDueAfterUpdate(BigDecimal value) {
        this.amountDueAfterUpdate = value;
    }

    /**
     * Gets the value of the transactionID property.
     *
     * @return possible object is
     *         {@link Long }
     */
    public Long getTransactionID() {
        return transactionID;
    }

    /**
     * Sets the value of the transactionID property.
     *
     * @param value allowed object is
     *              {@link Long }
     */
    public void setTransactionID(Long value) {
        this.transactionID = value;
    }

    /**
     * Gets the value of the insuranceRentalID property.
     *
     * @return possible object is
     *         {@link Long }
     */
    public Long getInsuranceRentalID() {
        return insuranceRentalID;
    }

    /**
     * Sets the value of the insuranceRentalID property.
     *
     * @param value allowed object is
     *              {@link Long }
     */
    public void setInsuranceRentalID(Long value) {
        this.insuranceRentalID = value;
    }

}
