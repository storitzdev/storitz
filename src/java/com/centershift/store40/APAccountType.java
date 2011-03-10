
package com.centershift.store40;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for APAccountType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="APAccountType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="CREDIT"/>
 *     &lt;enumeration value="DEBIT"/>
 *     &lt;enumeration value="ACH_CHECKING"/>
 *     &lt;enumeration value="ACH_SAVINGS"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "APAccountType")
@XmlEnum
public enum APAccountType {

    CREDIT,
    DEBIT,
    ACH_CHECKING,
    ACH_SAVINGS;

    public String value() {
        return name();
    }

    public static APAccountType fromValue(String v) {
        return valueOf(v);
    }

}
