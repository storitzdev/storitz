package com.centershift.store40;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RecurRange.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;simpleType name="RecurRange">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="NoEndDate"/>
 *     &lt;enumeration value="EndAfterNum"/>
 *     &lt;enumeration value="EndBy"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 */
@XmlType(name = "RecurRange")
@XmlEnum
public enum RecurRange {

    @XmlEnumValue("NoEndDate")
    NO_END_DATE("NoEndDate"),
    @XmlEnumValue("EndAfterNum")
    END_AFTER_NUM("EndAfterNum"),
    @XmlEnumValue("EndBy")
    END_BY("EndBy");
    private final String value;

    RecurRange(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static RecurRange fromValue(String v) {
        for (RecurRange c : RecurRange.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
