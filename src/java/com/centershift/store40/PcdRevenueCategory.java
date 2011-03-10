
package com.centershift.store40;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PcdRevenueCategory.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="PcdRevenueCategory">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="RentalItem"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "PcdRevenueCategory")
@XmlEnum
public enum PcdRevenueCategory {

    @XmlEnumValue("RentalItem")
    RENTAL_ITEM("RentalItem");
    private final String value;

    PcdRevenueCategory(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static PcdRevenueCategory fromValue(String v) {
        for (PcdRevenueCategory c: PcdRevenueCategory.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
