package com.centershift.store40;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Lost_Demand_Reasons.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;simpleType name="Lost_Demand_Reasons">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Current"/>
 *     &lt;enumeration value="Price"/>
 *     &lt;enumeration value="Availability"/>
 *     &lt;enumeration value="Unknown"/>
 *     &lt;enumeration value="NewQuoteCreated"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 */
@XmlType(name = "Lost_Demand_Reasons")
@XmlEnum
public enum LostDemandReasons {

    @XmlEnumValue("Current")
    CURRENT("Current"),
    @XmlEnumValue("Price")
    PRICE("Price"),
    @XmlEnumValue("Availability")
    AVAILABILITY("Availability"),
    @XmlEnumValue("Unknown")
    UNKNOWN("Unknown"),
    @XmlEnumValue("NewQuoteCreated")
    NEW_QUOTE_CREATED("NewQuoteCreated");
    private final String value;

    LostDemandReasons(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static LostDemandReasons fromValue(String v) {
        for (LostDemandReasons c : LostDemandReasons.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
