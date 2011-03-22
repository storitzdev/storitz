package com.centershift.store40;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RetailReturnReasons.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;simpleType name="RetailReturnReasons">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="RESTOCK_RESELL"/>
 *     &lt;enumeration value="DEFECTIVE_VENDOR_RETURN"/>
 *     &lt;enumeration value="DEFECTIVE_DESTROY"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 */
@XmlType(name = "RetailReturnReasons")
@XmlEnum
public enum RetailReturnReasons {

    RESTOCK_RESELL,
    DEFECTIVE_VENDOR_RETURN,
    DEFECTIVE_DESTROY;

    public String value() {
        return name();
    }

    public static RetailReturnReasons fromValue(String v) {
        return valueOf(v);
    }

}
