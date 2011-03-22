package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DelinquencySchedule complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="DelinquencySchedule">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Del_Schedule_ID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="Del_Schedule_Name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Del_Schedule_Desc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DelinquencySchedule", propOrder = {
        "delScheduleID",
        "delScheduleName",
        "delScheduleDesc"
})
public class DelinquencySchedule {

    @XmlElement(name = "Del_Schedule_ID")
    protected long delScheduleID;
    @XmlElement(name = "Del_Schedule_Name")
    protected String delScheduleName;
    @XmlElement(name = "Del_Schedule_Desc")
    protected String delScheduleDesc;

    /**
     * Gets the value of the delScheduleID property.
     */
    public long getDelScheduleID() {
        return delScheduleID;
    }

    /**
     * Sets the value of the delScheduleID property.
     */
    public void setDelScheduleID(long value) {
        this.delScheduleID = value;
    }

    /**
     * Gets the value of the delScheduleName property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getDelScheduleName() {
        return delScheduleName;
    }

    /**
     * Sets the value of the delScheduleName property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setDelScheduleName(String value) {
        this.delScheduleName = value;
    }

    /**
     * Gets the value of the delScheduleDesc property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getDelScheduleDesc() {
        return delScheduleDesc;
    }

    /**
     * Sets the value of the delScheduleDesc property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setDelScheduleDesc(String value) {
        this.delScheduleDesc = value;
    }

}
