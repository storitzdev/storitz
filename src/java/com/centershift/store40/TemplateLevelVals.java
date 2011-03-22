package com.centershift.store40;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for templateLevelVals.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;simpleType name="templateLevelVals">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="SITE_ONLY"/>
 *     &lt;enumeration value="ORG_ONLY"/>
 *     &lt;enumeration value="GENERICS_ONLY"/>
 *     &lt;enumeration value="SITE_ORG"/>
 *     &lt;enumeration value="SITE_ORG_GENERICS"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 */
@XmlType(name = "templateLevelVals")
@XmlEnum
public enum TemplateLevelVals {

    SITE_ONLY,
    ORG_ONLY,
    GENERICS_ONLY,
    SITE_ORG,
    SITE_ORG_GENERICS;

    public String value() {
        return name();
    }

    public static TemplateLevelVals fromValue(String v) {
        return valueOf(v);
    }

}
