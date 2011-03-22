package com.centershift.store40;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PcdLimitType.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;simpleType name="PcdLimitType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="AccountLevelDollarAmount"/>
 *     &lt;enumeration value="AccountLevelCount"/>
 *     &lt;enumeration value="RentalLevelDollarAmount"/>
 *     &lt;enumeration value="RentalLevelCount"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 */
@XmlType(name = "PcdLimitType")
@XmlEnum
public enum PcdLimitType {

    @XmlEnumValue("AccountLevelDollarAmount")
    ACCOUNT_LEVEL_DOLLAR_AMOUNT("AccountLevelDollarAmount"),
    @XmlEnumValue("AccountLevelCount")
    ACCOUNT_LEVEL_COUNT("AccountLevelCount"),
    @XmlEnumValue("RentalLevelDollarAmount")
    RENTAL_LEVEL_DOLLAR_AMOUNT("RentalLevelDollarAmount"),
    @XmlEnumValue("RentalLevelCount")
    RENTAL_LEVEL_COUNT("RentalLevelCount");
    private final String value;

    PcdLimitType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static PcdLimitType fromValue(String v) {
        for (PcdLimitType c : PcdLimitType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
