
package com.centershift.store40;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Quote_Types.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="Quote_Types">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="QuoteOnly"/>
 *     &lt;enumeration value="SoftReservation"/>
 *     &lt;enumeration value="HardReservation"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "Quote_Types")
@XmlEnum
public enum QuoteTypes {

    @XmlEnumValue("QuoteOnly")
    QUOTE_ONLY("QuoteOnly"),
    @XmlEnumValue("SoftReservation")
    SOFT_RESERVATION("SoftReservation"),
    @XmlEnumValue("HardReservation")
    HARD_RESERVATION("HardReservation");
    private final String value;

    QuoteTypes(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static QuoteTypes fromValue(String v) {
        for (QuoteTypes c: QuoteTypes.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
