package com.centershift.store40;

import javax.xml.bind.annotation.*;


/**
 * <p>Java class for anonymous complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="GetDelinqScheduleResult" type="{http://www.centershift.com/STORE40/}GetDelinqSchedule_Response"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "getDelinqScheduleResult"
})
@XmlRootElement(name = "GetDelinqScheduleResponse")
public class GetDelinqScheduleResponse {

    @XmlElement(name = "GetDelinqScheduleResult", required = true)
    protected GetDelinqScheduleResponse2 getDelinqScheduleResult;

    /**
     * Gets the value of the getDelinqScheduleResult property.
     *
     * @return possible object is
     *         {@link GetDelinqScheduleResponse2 }
     */
    public GetDelinqScheduleResponse2 getGetDelinqScheduleResult() {
        return getDelinqScheduleResult;
    }

    /**
     * Sets the value of the getDelinqScheduleResult property.
     *
     * @param value allowed object is
     *              {@link GetDelinqScheduleResponse2 }
     */
    public void setGetDelinqScheduleResult(GetDelinqScheduleResponse2 value) {
        this.getDelinqScheduleResult = value;
    }

}
