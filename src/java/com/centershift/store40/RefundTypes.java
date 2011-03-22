package com.centershift.store40;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RefundTypes.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;simpleType name="RefundTypes">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="CASH_CREDIT"/>
 *     &lt;enumeration value="CASH"/>
 *     &lt;enumeration value="CREDIT_CARD"/>
 *     &lt;enumeration value="CHECK"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 */
@XmlType(name = "RefundTypes")
@XmlEnum
public enum RefundTypes {

    CASH_CREDIT,
    CASH,
    CREDIT_CARD,
    CHECK;

    public String value() {
        return name();
    }

    public static RefundTypes fromValue(String v) {
        return valueOf(v);
    }

}
