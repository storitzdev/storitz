
package com.centershift.store40;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for LedgerType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="LedgerType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Rental"/>
 *     &lt;enumeration value="Retail"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "LedgerType")
@XmlEnum
public enum LedgerType {

    @XmlEnumValue("Rental")
    RENTAL("Rental"),
    @XmlEnumValue("Retail")
    RETAIL("Retail");
    private final String value;

    LedgerType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static LedgerType fromValue(String v) {
        for (LedgerType c: LedgerType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
