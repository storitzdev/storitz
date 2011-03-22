package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.math.BigDecimal;


/**
 * <p>Java class for CreditCardData complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="CreditCardData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Amount" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="CardNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CardHolderName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ExpireMonth" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ExpireYear" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CVV2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Address" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PostalCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TrackData" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CreditCardData", propOrder = {
        "amount",
        "cardNumber",
        "cardHolderName",
        "expireMonth",
        "expireYear",
        "cvv2",
        "address",
        "postalCode",
        "trackData"
})
public class CreditCardData {

    @XmlElement(name = "Amount", required = true)
    protected BigDecimal amount;
    @XmlElement(name = "CardNumber")
    protected String cardNumber;
    @XmlElement(name = "CardHolderName")
    protected String cardHolderName;
    @XmlElement(name = "ExpireMonth")
    protected String expireMonth;
    @XmlElement(name = "ExpireYear")
    protected String expireYear;
    @XmlElement(name = "CVV2")
    protected String cvv2;
    @XmlElement(name = "Address")
    protected String address;
    @XmlElement(name = "PostalCode")
    protected String postalCode;
    @XmlElement(name = "TrackData")
    protected String trackData;

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
     * Gets the value of the cardNumber property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getCardNumber() {
        return cardNumber;
    }

    /**
     * Sets the value of the cardNumber property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setCardNumber(String value) {
        this.cardNumber = value;
    }

    /**
     * Gets the value of the cardHolderName property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getCardHolderName() {
        return cardHolderName;
    }

    /**
     * Sets the value of the cardHolderName property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setCardHolderName(String value) {
        this.cardHolderName = value;
    }

    /**
     * Gets the value of the expireMonth property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getExpireMonth() {
        return expireMonth;
    }

    /**
     * Sets the value of the expireMonth property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setExpireMonth(String value) {
        this.expireMonth = value;
    }

    /**
     * Gets the value of the expireYear property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getExpireYear() {
        return expireYear;
    }

    /**
     * Sets the value of the expireYear property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setExpireYear(String value) {
        this.expireYear = value;
    }

    /**
     * Gets the value of the cvv2 property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getCVV2() {
        return cvv2;
    }

    /**
     * Sets the value of the cvv2 property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setCVV2(String value) {
        this.cvv2 = value;
    }

    /**
     * Gets the value of the address property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets the value of the address property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setAddress(String value) {
        this.address = value;
    }

    /**
     * Gets the value of the postalCode property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getPostalCode() {
        return postalCode;
    }

    /**
     * Sets the value of the postalCode property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setPostalCode(String value) {
        this.postalCode = value;
    }

    /**
     * Gets the value of the trackData property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getTrackData() {
        return trackData;
    }

    /**
     * Sets the value of the trackData property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setTrackData(String value) {
        this.trackData = value;
    }

}
