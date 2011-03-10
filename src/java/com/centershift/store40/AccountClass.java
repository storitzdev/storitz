
package com.centershift.store40;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AccountClass.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AccountClass">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="PERSONAL"/>
 *     &lt;enumeration value="BUSINESS"/>
 *     &lt;enumeration value="NATIONAL"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AccountClass")
@XmlEnum
public enum AccountClass {

    PERSONAL,
    BUSINESS,
    NATIONAL;

    public String value() {
        return name();
    }

    public static AccountClass fromValue(String v) {
        return valueOf(v);
    }

}
