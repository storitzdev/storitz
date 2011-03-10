
package com.centershift.store40;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for eTaskRefType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="eTaskRefType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="None"/>
 *     &lt;enumeration value="Account"/>
 *     &lt;enumeration value="Rental"/>
 *     &lt;enumeration value="Reservation_Quote"/>
 *     &lt;enumeration value="Unit"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "eTaskRefType")
@XmlEnum
public enum ETaskRefType {

    @XmlEnumValue("None")
    NONE("None"),
    @XmlEnumValue("Account")
    ACCOUNT("Account"),
    @XmlEnumValue("Rental")
    RENTAL("Rental"),
    @XmlEnumValue("Reservation_Quote")
    RESERVATION_QUOTE("Reservation_Quote"),
    @XmlEnumValue("Unit")
    UNIT("Unit");
    private final String value;

    ETaskRefType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ETaskRefType fromValue(String v) {
        for (ETaskRefType c: ETaskRefType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
