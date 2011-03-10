
package com.centershift.store40;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PhoneType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="PhoneType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="HOME"/>
 *     &lt;enumeration value="OFFICE"/>
 *     &lt;enumeration value="MOBILE"/>
 *     &lt;enumeration value="FAX"/>
 *     &lt;enumeration value="OTHER"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "PhoneType")
@XmlEnum
public enum PhoneType {

    HOME,
    OFFICE,
    MOBILE,
    FAX,
    OTHER;

    public String value() {
        return name();
    }

    public static PhoneType fromValue(String v) {
        return valueOf(v);
    }

}
