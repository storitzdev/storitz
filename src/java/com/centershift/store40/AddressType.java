package com.centershift.store40;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AddressType.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;simpleType name="AddressType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="HOME"/>
 *     &lt;enumeration value="OFFICE"/>
 *     &lt;enumeration value="MAILING"/>
 *     &lt;enumeration value="SHIPPING"/>
 *     &lt;enumeration value="OTHER"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 */
@XmlType(name = "AddressType")
@XmlEnum
public enum AddressType {

    HOME,
    OFFICE,
    MAILING,
    SHIPPING,
    OTHER;

    public String value() {
        return name();
    }

    public static AddressType fromValue(String v) {
        return valueOf(v);
    }

}
