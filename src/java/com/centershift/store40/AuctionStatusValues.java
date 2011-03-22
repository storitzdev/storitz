package com.centershift.store40;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AuctionStatusValues.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;simpleType name="AuctionStatusValues">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="SCHEDULED"/>
 *     &lt;enumeration value="COMPLETED"/>
 *     &lt;enumeration value="CANCELLED"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 */
@XmlType(name = "AuctionStatusValues")
@XmlEnum
public enum AuctionStatusValues {

    SCHEDULED,
    COMPLETED,
    CANCELLED;

    public String value() {
        return name();
    }

    public static AuctionStatusValues fromValue(String v) {
        return valueOf(v);
    }

}
