package com.centershift.store40;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PcdCreditLevels.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;simpleType name="PcdCreditLevels">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Level1"/>
 *     &lt;enumeration value="Level2"/>
 *     &lt;enumeration value="Level3"/>
 *     &lt;enumeration value="Level4"/>
 *     &lt;enumeration value="Level5"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 */
@XmlType(name = "PcdCreditLevels")
@XmlEnum
public enum PcdCreditLevels {

    @XmlEnumValue("Level1")
    LEVEL_1("Level1"),
    @XmlEnumValue("Level2")
    LEVEL_2("Level2"),
    @XmlEnumValue("Level3")
    LEVEL_3("Level3"),
    @XmlEnumValue("Level4")
    LEVEL_4("Level4"),
    @XmlEnumValue("Level5")
    LEVEL_5("Level5");
    private final String value;

    PcdCreditLevels(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static PcdCreditLevels fromValue(String v) {
        for (PcdCreditLevels c : PcdCreditLevels.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
