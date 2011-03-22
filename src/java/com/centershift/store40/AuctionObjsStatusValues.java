package com.centershift.store40;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AuctionObjsStatusValues.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;simpleType name="AuctionObjsStatusValues">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="SCHEDULED_FOR_AUCTION"/>
 *     &lt;enumeration value="REMOVED_FROM_AUCTION"/>
 *     &lt;enumeration value="SOLD_AT_AUCTION"/>
 *     &lt;enumeration value="NOT_SOLD_AT_AUCTION_TERMINATED"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 */
@XmlType(name = "AuctionObjsStatusValues")
@XmlEnum
public enum AuctionObjsStatusValues {

    SCHEDULED_FOR_AUCTION,
    REMOVED_FROM_AUCTION,
    SOLD_AT_AUCTION,
    NOT_SOLD_AT_AUCTION_TERMINATED;

    public String value() {
        return name();
    }

    public static AuctionObjsStatusValues fromValue(String v) {
        return valueOf(v);
    }

}
