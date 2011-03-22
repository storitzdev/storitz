package com.centershift.store40;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for siteRuleLtrTypeGrpVals.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;simpleType name="siteRuleLtrTypeGrpVals">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="UNKNOWN_INVALID"/>
 *     &lt;enumeration value="INVOICE"/>
 *     &lt;enumeration value="RATECHANGE"/>
 *     &lt;enumeration value="INSURANCE"/>
 *     &lt;enumeration value="NSFNOTICE"/>
 *     &lt;enumeration value="WELCOME"/>
 *     &lt;enumeration value="PARTIALPAY"/>
 *     &lt;enumeration value="AUTOPAY"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 */
@XmlType(name = "siteRuleLtrTypeGrpVals")
@XmlEnum
public enum SiteRuleLtrTypeGrpVals {

    UNKNOWN_INVALID,
    INVOICE,
    RATECHANGE,
    INSURANCE,
    NSFNOTICE,
    WELCOME,
    PARTIALPAY,
    AUTOPAY;

    public String value() {
        return name();
    }

    public static SiteRuleLtrTypeGrpVals fromValue(String v) {
        return valueOf(v);
    }

}
