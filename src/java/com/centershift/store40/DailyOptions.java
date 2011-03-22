package com.centershift.store40;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DailyOptions.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;simpleType name="DailyOptions">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="EveryNumDays"/>
 *     &lt;enumeration value="EveryWeekDay"/>
 *     &lt;enumeration value="EveryDay"/>
 *     &lt;enumeration value="Weekends"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 */
@XmlType(name = "DailyOptions")
@XmlEnum
public enum DailyOptions {

    @XmlEnumValue("EveryNumDays")
    EVERY_NUM_DAYS("EveryNumDays"),
    @XmlEnumValue("EveryWeekDay")
    EVERY_WEEK_DAY("EveryWeekDay"),
    @XmlEnumValue("EveryDay")
    EVERY_DAY("EveryDay"),
    @XmlEnumValue("Weekends")
    WEEKENDS("Weekends");
    private final String value;

    DailyOptions(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static DailyOptions fromValue(String v) {
        for (DailyOptions c : DailyOptions.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
