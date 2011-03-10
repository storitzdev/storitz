
package com.centershift.store40;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RecurPattern.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="RecurPattern">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="None"/>
 *     &lt;enumeration value="Daily"/>
 *     &lt;enumeration value="Weekly"/>
 *     &lt;enumeration value="Monthly"/>
 *     &lt;enumeration value="Annually"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "RecurPattern")
@XmlEnum
public enum RecurPattern {

    @XmlEnumValue("None")
    NONE("None"),
    @XmlEnumValue("Daily")
    DAILY("Daily"),
    @XmlEnumValue("Weekly")
    WEEKLY("Weekly"),
    @XmlEnumValue("Monthly")
    MONTHLY("Monthly"),
    @XmlEnumValue("Annually")
    ANNUALLY("Annually");
    private final String value;

    RecurPattern(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static RecurPattern fromValue(String v) {
        for (RecurPattern c: RecurPattern.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
