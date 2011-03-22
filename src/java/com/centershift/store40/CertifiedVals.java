package com.centershift.store40;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for certifiedVals.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;simpleType name="certifiedVals">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="NONE"/>
 *     &lt;enumeration value="CERT_NO_RECEIPT"/>
 *     &lt;enumeration value="CERT_WITH_RECEIPT"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 */
@XmlType(name = "certifiedVals")
@XmlEnum
public enum CertifiedVals {

    NONE,
    CERT_NO_RECEIPT,
    CERT_WITH_RECEIPT;

    public String value() {
        return name();
    }

    public static CertifiedVals fromValue(String v) {
        return valueOf(v);
    }

}
