package com.centershift.store40;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for waiveLimit.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;simpleType name="waiveLimit">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="NO_LIMIT"/>
 *     &lt;enumeration value="NUM_WAIVES"/>
 *     &lt;enumeration value="AMT_WAIVES"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 */
@XmlType(name = "waiveLimit")
@XmlEnum
public enum WaiveLimit {

    NO_LIMIT,
    NUM_WAIVES,
    AMT_WAIVES;

    public String value() {
        return name();
    }

    public static WaiveLimit fromValue(String v) {
        return valueOf(v);
    }

}
