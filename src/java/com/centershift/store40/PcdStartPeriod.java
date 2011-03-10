
package com.centershift.store40;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PcdStartPeriod.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="PcdStartPeriod">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="StartOfRequiredLOS"/>
 *     &lt;enumeration value="EndOfRequiredLOS"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "PcdStartPeriod")
@XmlEnum
public enum PcdStartPeriod {

    @XmlEnumValue("StartOfRequiredLOS")
    START_OF_REQUIRED_LOS("StartOfRequiredLOS"),
    @XmlEnumValue("EndOfRequiredLOS")
    END_OF_REQUIRED_LOS("EndOfRequiredLOS");
    private final String value;

    PcdStartPeriod(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static PcdStartPeriod fromValue(String v) {
        for (PcdStartPeriod c: PcdStartPeriod.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
