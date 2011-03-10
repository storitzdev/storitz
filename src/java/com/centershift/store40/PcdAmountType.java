
package com.centershift.store40;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PcdAmountType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="PcdAmountType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="DiscountAmount"/>
 *     &lt;enumeration value="DiscountPercentage"/>
 *     &lt;enumeration value="PriceOverride"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "PcdAmountType")
@XmlEnum
public enum PcdAmountType {

    @XmlEnumValue("DiscountAmount")
    DISCOUNT_AMOUNT("DiscountAmount"),
    @XmlEnumValue("DiscountPercentage")
    DISCOUNT_PERCENTAGE("DiscountPercentage"),
    @XmlEnumValue("PriceOverride")
    PRICE_OVERRIDE("PriceOverride");
    private final String value;

    PcdAmountType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static PcdAmountType fromValue(String v) {
        for (PcdAmountType c: PcdAmountType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
