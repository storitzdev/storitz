
package com.centershift.store40;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PCDType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="PCDType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Promotion"/>
 *     &lt;enumeration value="Credit"/>
 *     &lt;enumeration value="Discount"/>
 *     &lt;enumeration value="Rate_Modification"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "PCDType")
@XmlEnum
public enum PCDType {

    @XmlEnumValue("Promotion")
    PROMOTION("Promotion"),
    @XmlEnumValue("Credit")
    CREDIT("Credit"),
    @XmlEnumValue("Discount")
    DISCOUNT("Discount"),
    @XmlEnumValue("Rate_Modification")
    RATE_MODIFICATION("Rate_Modification");
    private final String value;

    PCDType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static PCDType fromValue(String v) {
        for (PCDType c: PCDType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
