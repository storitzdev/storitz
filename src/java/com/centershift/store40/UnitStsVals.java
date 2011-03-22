package com.centershift.store40;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for unitStsVals.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;simpleType name="unitStsVals">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="AVAILABLE"/>
 *     &lt;enumeration value="RESERVED"/>
 *     &lt;enumeration value="RENTED_NORMAL"/>
 *     &lt;enumeration value="COMPANY_USE"/>
 *     &lt;enumeration value="UNAVAILABLE_DAMAGED"/>
 *     &lt;enumeration value="UNAVAILABLE_PERMANENT"/>
 *     &lt;enumeration value="VIRTUAL_LINKED_UNITS"/>
 *     &lt;enumeration value="OTHER"/>
 *     &lt;enumeration value="UNAVAILABLE_PENDING"/>
 *     &lt;enumeration value="AVAILABLE_HOLD"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 */
@XmlType(name = "unitStsVals")
@XmlEnum
public enum UnitStsVals {

    AVAILABLE,
    RESERVED,
    RENTED_NORMAL,
    COMPANY_USE,
    UNAVAILABLE_DAMAGED,
    UNAVAILABLE_PERMANENT,
    VIRTUAL_LINKED_UNITS,
    OTHER,
    UNAVAILABLE_PENDING,
    AVAILABLE_HOLD;

    public String value() {
        return name();
    }

    public static UnitStsVals fromValue(String v) {
        return valueOf(v);
    }

}
