package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for scheduledLetter_Response complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="scheduledLetter_Response">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ScheduledID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "scheduledLetter_Response", propOrder = {
        "scheduledID"
})
public class ScheduledLetterResponse2 {

    @XmlElement(name = "ScheduledID")
    protected long scheduledID;

    /**
     * Gets the value of the scheduledID property.
     */
    public long getScheduledID() {
        return scheduledID;
    }

    /**
     * Sets the value of the scheduledID property.
     */
    public void setScheduledID(long value) {
        this.scheduledID = value;
    }

}
