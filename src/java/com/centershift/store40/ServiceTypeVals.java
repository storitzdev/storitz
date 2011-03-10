
package com.centershift.store40;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for serviceTypeVals.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="serviceTypeVals">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="MAIL_INVOICE"/>
 *     &lt;enumeration value="GATE_ACCESS"/>
 *     &lt;enumeration value="OTHER"/>
 *     &lt;enumeration value="EMAIL_INVOICE"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "serviceTypeVals")
@XmlEnum
public enum ServiceTypeVals {

    MAIL_INVOICE,
    GATE_ACCESS,
    OTHER,
    EMAIL_INVOICE;

    public String value() {
        return name();
    }

    public static ServiceTypeVals fromValue(String v) {
        return valueOf(v);
    }

}
