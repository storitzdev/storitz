package com.centershift.store40;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for contactTypeVals.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;simpleType name="contactTypeVals">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="PRIMARY"/>
 *     &lt;enumeration value="ALL_SECONDARY"/>
 *     &lt;enumeration value="SPECIFIC_ADDR_ID"/>
 *     &lt;enumeration value="SPECIFIC_CONTACT_ID"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 */
@XmlType(name = "contactTypeVals")
@XmlEnum
public enum ContactTypeVals {

    PRIMARY,
    ALL_SECONDARY,
    SPECIFIC_ADDR_ID,
    SPECIFIC_CONTACT_ID;

    public String value() {
        return name();
    }

    public static ContactTypeVals fromValue(String v) {
        return valueOf(v);
    }

}
