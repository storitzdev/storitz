
package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="scheduledLetterResult" type="{http://www.centershift.com/STORE40/}scheduledLetter_Response"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "scheduledLetterResult"
})
@XmlRootElement(name = "scheduledLetterResponse")
public class ScheduledLetterResponse {

    @XmlElement(required = true)
    protected ScheduledLetterResponse2 scheduledLetterResult;

    /**
     * Gets the value of the scheduledLetterResult property.
     * 
     * @return
     *     possible object is
     *     {@link ScheduledLetterResponse2 }
     *     
     */
    public ScheduledLetterResponse2 getScheduledLetterResult() {
        return scheduledLetterResult;
    }

    /**
     * Sets the value of the scheduledLetterResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ScheduledLetterResponse2 }
     *     
     */
    public void setScheduledLetterResult(ScheduledLetterResponse2 value) {
        this.scheduledLetterResult = value;
    }

}
