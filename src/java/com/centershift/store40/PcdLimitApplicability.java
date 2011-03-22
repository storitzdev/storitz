package com.centershift.store40;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PcdLimitApplicability.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;simpleType name="PcdLimitApplicability">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="DoNotLimit"/>
 *     &lt;enumeration value="Audit"/>
 *     &lt;enumeration value="Limit"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 */
@XmlType(name = "PcdLimitApplicability")
@XmlEnum
public enum PcdLimitApplicability {

    @XmlEnumValue("DoNotLimit")
    DO_NOT_LIMIT("DoNotLimit"),
    @XmlEnumValue("Audit")
    AUDIT("Audit"),
    @XmlEnumValue("Limit")
    LIMIT("Limit");
    private final String value;

    PcdLimitApplicability(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static PcdLimitApplicability fromValue(String v) {
        for (PcdLimitApplicability c : PcdLimitApplicability.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
