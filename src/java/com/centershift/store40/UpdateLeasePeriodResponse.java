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
 *         &lt;element name="UpdateLeasePeriodResult" type="{http://www.centershift.com/STORE40/}UpdateLeasePeriod_Response"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "updateLeasePeriodResult"
})
@XmlRootElement(name = "UpdateLeasePeriodResponse")
public class UpdateLeasePeriodResponse {

    @XmlElement(name = "UpdateLeasePeriodResult", required = true)
    protected UpdateLeasePeriodResponse2 updateLeasePeriodResult;

    /**
     * Gets the value of the updateLeasePeriodResult property.
     *
     * @return possible object is
     *         {@link UpdateLeasePeriodResponse2 }
     */
    public UpdateLeasePeriodResponse2 getUpdateLeasePeriodResult() {
        return updateLeasePeriodResult;
    }

    /**
     * Sets the value of the updateLeasePeriodResult property.
     *
     * @param value allowed object is
     *              {@link UpdateLeasePeriodResponse2 }
     */
    public void setUpdateLeasePeriodResult(UpdateLeasePeriodResponse2 value) {
        this.updateLeasePeriodResult = value;
    }

}
