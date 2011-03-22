package com.centershift.store40;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PcdClass.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;simpleType name="PcdClass">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Promotion"/>
 *     &lt;enumeration value="Credit"/>
 *     &lt;enumeration value="Discount"/>
 *     &lt;enumeration value="RateModification"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 */
@XmlType(name = "PcdClass")
@XmlEnum
public enum PcdClass {

    @XmlEnumValue("Promotion")
    PROMOTION("Promotion"),
    @XmlEnumValue("Credit")
    CREDIT("Credit"),
    @XmlEnumValue("Discount")
    DISCOUNT("Discount"),
    @XmlEnumValue("RateModification")
    RATE_MODIFICATION("RateModification");
    private final String value;

    PcdClass(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static PcdClass fromValue(String v) {
        for (PcdClass c : PcdClass.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
