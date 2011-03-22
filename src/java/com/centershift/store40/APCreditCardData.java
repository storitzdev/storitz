package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for APCreditCardData complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="APCreditCardData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CardNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CardHolderName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Exp" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CVV2" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "APCreditCardData", propOrder = {
        "cardNumber",
        "cardHolderName",
        "exp",
        "cvv2"
})
public class APCreditCardData {

    @XmlElement(name = "CardNumber")
    protected String cardNumber;
    @XmlElement(name = "CardHolderName")
    protected String cardHolderName;
    @XmlElement(name = "Exp")
    protected String exp;
    @XmlElement(name = "CVV2")
    protected int cvv2;

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
     * Gets the value of the exp property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getExp() {
        return exp;
    }

    /**
     * Sets the value of the exp property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setExp(String value) {
        this.exp = value;
    }

    /**
     * Gets the value of the cvv2 property.
     */
    public int getCVV2() {
        return cvv2;
    }

    /**
     * Sets the value of the cvv2 property.
     */
    public void setCVV2(int value) {
        this.cvv2 = value;
    }

}
