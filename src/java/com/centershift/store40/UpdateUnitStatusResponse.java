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
 *         &lt;element name="UpdateUnitStatusResult" type="{http://www.centershift.com/STORE40/}UpdateUnitStatus_Response"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "updateUnitStatusResult"
})
@XmlRootElement(name = "UpdateUnitStatusResponse")
public class UpdateUnitStatusResponse {

    @XmlElement(name = "UpdateUnitStatusResult", required = true)
    protected UpdateUnitStatusResponse2 updateUnitStatusResult;

    /**
     * Gets the value of the updateUnitStatusResult property.
     *
     * @return possible object is
     *         {@link UpdateUnitStatusResponse2 }
     */
    public UpdateUnitStatusResponse2 getUpdateUnitStatusResult() {
        return updateUnitStatusResult;
    }

    /**
     * Sets the value of the updateUnitStatusResult property.
     *
     * @param value allowed object is
     *              {@link UpdateUnitStatusResponse2 }
     */
    public void setUpdateUnitStatusResult(UpdateUnitStatusResponse2 value) {
        this.updateUnitStatusResult = value;
    }

}
