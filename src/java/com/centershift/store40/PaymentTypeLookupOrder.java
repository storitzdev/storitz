package com.centershift.store40;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for paymentTypeLookupOrder.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;simpleType name="paymentTypeLookupOrder">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="OTHER1"/>
 *     &lt;enumeration value="ESCROW_DEPOSIT"/>
 *     &lt;enumeration value="IFT"/>
 *     &lt;enumeration value="UNDETERMINED"/>
 *     &lt;enumeration value="CASH"/>
 *     &lt;enumeration value="CHECK"/>
 *     &lt;enumeration value="MONEY_ORDER"/>
 *     &lt;enumeration value="TRAVELERS_CHECK"/>
 *     &lt;enumeration value="ACH"/>
 *     &lt;enumeration value="VISA"/>
 *     &lt;enumeration value="VISA_DEBIT"/>
 *     &lt;enumeration value="VISA_EXTERNAL"/>
 *     &lt;enumeration value="MASTERCARD"/>
 *     &lt;enumeration value="MASTERCARD_DEBIT"/>
 *     &lt;enumeration value="MASTERCARD_EXTERNAL"/>
 *     &lt;enumeration value="AMEX"/>
 *     &lt;enumeration value="AMEX_DEBIT"/>
 *     &lt;enumeration value="AMEX_EXTERNAL"/>
 *     &lt;enumeration value="DISCOVER"/>
 *     &lt;enumeration value="DISCOVER_DEBIT"/>
 *     &lt;enumeration value="DISCOVER_EXTERNAL"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 */
@XmlType(name = "paymentTypeLookupOrder")
@XmlEnum
public enum PaymentTypeLookupOrder {

    @XmlEnumValue("OTHER1")
    OTHER_1("OTHER1"),
    ESCROW_DEPOSIT("ESCROW_DEPOSIT"),
    IFT("IFT"),
    UNDETERMINED("UNDETERMINED"),
    CASH("CASH"),
    CHECK("CHECK"),
    MONEY_ORDER("MONEY_ORDER"),
    TRAVELERS_CHECK("TRAVELERS_CHECK"),
    ACH("ACH"),
    VISA("VISA"),
    VISA_DEBIT("VISA_DEBIT"),
    VISA_EXTERNAL("VISA_EXTERNAL"),
    MASTERCARD("MASTERCARD"),
    MASTERCARD_DEBIT("MASTERCARD_DEBIT"),
    MASTERCARD_EXTERNAL("MASTERCARD_EXTERNAL"),
    AMEX("AMEX"),
    AMEX_DEBIT("AMEX_DEBIT"),
    AMEX_EXTERNAL("AMEX_EXTERNAL"),
    DISCOVER("DISCOVER"),
    DISCOVER_DEBIT("DISCOVER_DEBIT"),
    DISCOVER_EXTERNAL("DISCOVER_EXTERNAL");
    private final String value;

    PaymentTypeLookupOrder(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static PaymentTypeLookupOrder fromValue(String v) {
        for (PaymentTypeLookupOrder c : PaymentTypeLookupOrder.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
