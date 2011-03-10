
package com.centershift.store40;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PcdReasonPrompt.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="PcdReasonPrompt">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="NotRequired"/>
 *     &lt;enumeration value="StandardReasonCodes"/>
 *     &lt;enumeration value="FreeTextReasonEntry"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "PcdReasonPrompt")
@XmlEnum
public enum PcdReasonPrompt {

    @XmlEnumValue("NotRequired")
    NOT_REQUIRED("NotRequired"),
    @XmlEnumValue("StandardReasonCodes")
    STANDARD_REASON_CODES("StandardReasonCodes"),
    @XmlEnumValue("FreeTextReasonEntry")
    FREE_TEXT_REASON_ENTRY("FreeTextReasonEntry");
    private final String value;

    PcdReasonPrompt(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static PcdReasonPrompt fromValue(String v) {
        for (PcdReasonPrompt c: PcdReasonPrompt.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
