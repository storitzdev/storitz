
package com.centershift.store40;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for eTaskSource.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="eTaskSource">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="None"/>
 *     &lt;enumeration value="SWS"/>
 *     &lt;enumeration value="Call_Center"/>
 *     &lt;enumeration value="Website"/>
 *     &lt;enumeration value="Kiosk"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "eTaskSource")
@XmlEnum
public enum ETaskSource {

    @XmlEnumValue("None")
    NONE("None"),
    SWS("SWS"),
    @XmlEnumValue("Call_Center")
    CALL_CENTER("Call_Center"),
    @XmlEnumValue("Website")
    WEBSITE("Website"),
    @XmlEnumValue("Kiosk")
    KIOSK("Kiosk");
    private final String value;

    ETaskSource(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ETaskSource fromValue(String v) {
        for (ETaskSource c: ETaskSource.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
