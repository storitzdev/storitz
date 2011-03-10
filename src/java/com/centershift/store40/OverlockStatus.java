
package com.centershift.store40;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for OverlockStatus.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="OverlockStatus">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="NOT_OVERLOCKED"/>
 *     &lt;enumeration value="PENDING_OVERLOCK"/>
 *     &lt;enumeration value="OVERLOCKED"/>
 *     &lt;enumeration value="PENDING_LOCK_REMOVAL"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "OverlockStatus")
@XmlEnum
public enum OverlockStatus {

    NOT_OVERLOCKED,
    PENDING_OVERLOCK,
    OVERLOCKED,
    PENDING_LOCK_REMOVAL;

    public String value() {
        return name();
    }

    public static OverlockStatus fromValue(String v) {
        return valueOf(v);
    }

}
