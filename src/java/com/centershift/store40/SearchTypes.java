
package com.centershift.store40;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SearchTypes.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="SearchTypes">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="QuickSearch"/>
 *     &lt;enumeration value="SearchByPhone"/>
 *     &lt;enumeration value="SearchByUnit"/>
 *     &lt;enumeration value="SearchByName"/>
 *     &lt;enumeration value="SearchByRental"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "SearchTypes")
@XmlEnum
public enum SearchTypes {

    @XmlEnumValue("QuickSearch")
    QUICK_SEARCH("QuickSearch"),
    @XmlEnumValue("SearchByPhone")
    SEARCH_BY_PHONE("SearchByPhone"),
    @XmlEnumValue("SearchByUnit")
    SEARCH_BY_UNIT("SearchByUnit"),
    @XmlEnumValue("SearchByName")
    SEARCH_BY_NAME("SearchByName"),
    @XmlEnumValue("SearchByRental")
    SEARCH_BY_RENTAL("SearchByRental");
    private final String value;

    SearchTypes(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static SearchTypes fromValue(String v) {
        for (SearchTypes c: SearchTypes.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
