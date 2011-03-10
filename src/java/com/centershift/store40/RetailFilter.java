
package com.centershift.store40;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RetailFilter.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="RetailFilter">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="ALL_SITE_ITEMS"/>
 *     &lt;enumeration value="SKU"/>
 *     &lt;enumeration value="PART_NUMBER"/>
 *     &lt;enumeration value="BARCODE"/>
 *     &lt;enumeration value="DESCRIPTION"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "RetailFilter")
@XmlEnum
public enum RetailFilter {

    ALL_SITE_ITEMS,
    SKU,
    PART_NUMBER,
    BARCODE,
    DESCRIPTION;

    public String value() {
        return name();
    }

    public static RetailFilter fromValue(String v) {
        return valueOf(v);
    }

}
