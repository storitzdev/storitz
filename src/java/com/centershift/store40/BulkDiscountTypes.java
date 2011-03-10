
package com.centershift.store40;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for BulkDiscountTypes.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="BulkDiscountTypes">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="PERCENTAGE"/>
 *     &lt;enumeration value="DOLLAR"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "BulkDiscountTypes")
@XmlEnum
public enum BulkDiscountTypes {

    PERCENTAGE,
    DOLLAR;

    public String value() {
        return name();
    }

    public static BulkDiscountTypes fromValue(String v) {
        return valueOf(v);
    }

}
