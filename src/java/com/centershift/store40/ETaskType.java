
package com.centershift.store40;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for eTaskType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="eTaskType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Task_To_Do"/>
 *     &lt;enumeration value="Appointment"/>
 *     &lt;enumeration value="Followup"/>
 *     &lt;enumeration value="Maintenance"/>
 *     &lt;enumeration value="Reservation"/>
 *     &lt;enumeration value="Other"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "eTaskType")
@XmlEnum
public enum ETaskType {

    @XmlEnumValue("Task_To_Do")
    TASK_TO_DO("Task_To_Do"),
    @XmlEnumValue("Appointment")
    APPOINTMENT("Appointment"),
    @XmlEnumValue("Followup")
    FOLLOWUP("Followup"),
    @XmlEnumValue("Maintenance")
    MAINTENANCE("Maintenance"),
    @XmlEnumValue("Reservation")
    RESERVATION("Reservation"),
    @XmlEnumValue("Other")
    OTHER("Other");
    private final String value;

    ETaskType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ETaskType fromValue(String v) {
        for (ETaskType c: ETaskType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
