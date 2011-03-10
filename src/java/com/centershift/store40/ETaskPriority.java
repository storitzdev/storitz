
package com.centershift.store40;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for eTaskPriority.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="eTaskPriority">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Low"/>
 *     &lt;enumeration value="Medium"/>
 *     &lt;enumeration value="High"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "eTaskPriority")
@XmlEnum
public enum ETaskPriority {

    @XmlEnumValue("Low")
    LOW("Low"),
    @XmlEnumValue("Medium")
    MEDIUM("Medium"),
    @XmlEnumValue("High")
    HIGH("High");
    private final String value;

    ETaskPriority(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ETaskPriority fromValue(String v) {
        for (ETaskPriority c: ETaskPriority.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
