
package com.centershift.store40;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for LTR_CONTACT_TYPES.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="LTR_CONTACT_TYPES">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="PRIMARY"/>
 *     &lt;enumeration value="SECONDARY"/>
 *     &lt;enumeration value="BOTH"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "LTR_CONTACT_TYPES")
@XmlEnum
public enum LTRCONTACTTYPES {

    PRIMARY,
    SECONDARY,
    BOTH;

    public String value() {
        return name();
    }

    public static LTRCONTACTTYPES fromValue(String v) {
        return valueOf(v);
    }

}
