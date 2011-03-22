package com.centershift.store40;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GetDelinqSchedule_Response complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="GetDelinqSchedule_Response">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Result" type="{http://www.centershift.com/STORE40/}ArrayOfDelinquencySchedule" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetDelinqSchedule_Response", propOrder = {
        "result"
})
public class GetDelinqScheduleResponse2 {

    @XmlElement(name = "Result")
    protected ArrayOfDelinquencySchedule result;

    /**
     * Gets the value of the result property.
     *
     * @return possible object is
     *         {@link ArrayOfDelinquencySchedule }
     */
    public ArrayOfDelinquencySchedule getResult() {
        return result;
    }

    /**
     * Sets the value of the result property.
     *
     * @param value allowed object is
     *              {@link ArrayOfDelinquencySchedule }
     */
    public void setResult(ArrayOfDelinquencySchedule value) {
        this.result = value;
    }

}
