
package com.centershift.store40;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ContactType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ContactType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="ACCOUNT_MANAGER"/>
 *     &lt;enumeration value="ACCOUNT_USER"/>
 *     &lt;enumeration value="ACCOUNT_CONTACT_ONLY"/>
 *     &lt;enumeration value="BUSINESS_CONTACT_RECORD"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ContactType")
@XmlEnum
public enum ContactType {

    ACCOUNT_MANAGER,
    ACCOUNT_USER,
    ACCOUNT_CONTACT_ONLY,
    BUSINESS_CONTACT_RECORD;

    public String value() {
        return name();
    }

    public static ContactType fromValue(String v) {
        return valueOf(v);
    }

}
